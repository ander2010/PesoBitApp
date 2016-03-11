package hds.aplications.com.pesobit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

import hds.aplications.com.pesobit.common.DateUtils;
import hds.aplications.com.pesobit.common.MessageToast;
import hds.aplications.com.pesobit.common.SAppData;
import hds.aplications.com.pesobit.common.WifiReceiver;
import hds.aplications.com.pesobit.common.alerts.Confirmation;
import hds.aplications.com.pesobit.models.User;
import hds.aplications.com.pesobit.repositories.UserRepository;
import hds.aplications.com.pesobit.services.UserClient;
import hds.aplications.com.pesobit.view.LoadMask;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ActivityLogin extends AppCompatActivity {

    LoadMask loadingMask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loadingMask = new LoadMask(this);
    }

    public void actionLogin(View view){
        EditText editTextUser = (EditText)findViewById(R.id.edit_text_user);
        String user = editTextUser.getText().toString();

        EditText editTextPass = (EditText)findViewById(R.id.edit_text_user_pass);
        String pass = editTextPass.getText().toString();

        if (!user.equals("") && !pass.equals("")){
            login(user, pass);
        }
        else {
            MessageToast.showError(getApplicationContext(), getString(R.string.info_alert_user));
        }
    }

    private void login(final String name, final String pass){
        UserRepository userRepository = new UserRepository();
        final User user = (User)userRepository.getByUser(name);

        if(user != null && WifiReceiver.isOnline(getApplicationContext())){
            FragmentManager fragmentManager = getSupportFragmentManager();
            Confirmation dialogo = new Confirmation();
            dialogo.setMessage(getString(R.string.sync_info_alert_message_to_local)).setTitle(getString(R.string.sync_info_alert_title)).setTitleNotOkBnt("No").setTitleOKBnt("Si");

            dialogo.clickOk = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id){
                    dialog.cancel();
                    ActivityLogin.this.synchronizeUserData(name, pass);
                }
            };
            dialogo.clickNotOk = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id){
                    dialog.cancel();
                    ckeckUserLocal(user, pass);
                }
            };
            dialogo.show(fragmentManager, "tagConfirmacion");
            return;
        }
        else if(WifiReceiver.isOnline(getApplicationContext())){
            ActivityLogin.this.synchronizeUserData(name, pass);
            return;
        }

        ckeckUserLocal(user, pass);
    }

    private void ckeckUserLocal(User user, String pass){
        if(user != null && user.getPassword().equals(pass)){
            startFirstActivity(user);
        }
        else {
            MessageToast.showError(ActivityLogin.this.getApplicationContext(), getString(R.string.icorrect_credential));
        }
    }

    private void startFirstActivity(User user){
        //Creamos la información a pasar entre activities
        SAppData.getInstance().setUser(user);
        ActivityLogin.this.startActivity(new Intent(ActivityLogin.this, OperationsActivity.class));
    }

    public void synchronizeUserData(String userName, final String pass) {
        if(WifiReceiver.isOnline(getApplicationContext())){
            UserClient userClient = new UserClient(getApplicationContext());

            loadingMask.show(getString(R.string.login_user));
            Callback<User> callback = new Callback<User>() {
                @Override
                public void success(User user, Response response) {
                    try {
                        user.setPassword(pass);
                        UserRepository.saveUser(user);
                        ActivityLogin.this.startFirstActivity(user);
                    }
                    catch(Exception ex){
                        MessageToast.showError(ActivityLogin.this.getApplicationContext(), ex.getLocalizedMessage());
                    }
                    finally {
                        loadingMask.hide();
                    }
                }
                @Override
                public void failure(RetrofitError retrofitError) {
                    loadingMask.hide();
                    MessageToast.showError(ActivityLogin.this.getApplicationContext(), getString(R.string.icorrect_credential));
                }
            };

            Date today = DateUtils.beginningDay(new Date());
            Calendar nextYear = Calendar.getInstance();
            nextYear.setTime(today);
            nextYear.add(Calendar.YEAR, 2);

            Date start = today;
            Date end = nextYear.getTime();

            userClient.login(userName, pass, DateUtils.DATE_FORMAT.format(start), DateUtils.DATE_FORMAT.format(end), callback);
        }
        else {
            MessageToast.showError(getApplicationContext(), getString(R.string.no_internet_connection));
        }
    }
}
