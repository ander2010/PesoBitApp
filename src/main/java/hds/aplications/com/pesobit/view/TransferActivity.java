package hds.aplications.com.pesobit.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import hds.aplications.com.pesobit.R;
import hds.aplications.com.pesobit.common.DateUtils;
import hds.aplications.com.pesobit.common.MessageToast;
import hds.aplications.com.pesobit.common.Validator;
import hds.aplications.com.pesobit.models.Transfer;
import hds.aplications.com.pesobit.services.TransferClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class TransferActivity extends AppCompatActivity {

    LoadMask loadingMask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        loadingMask = new LoadMask(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_transfer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onTransferClick(View view){

        EditText edit_email = (EditText)findViewById(R.id.edit_email);
        String email = edit_email.getText().toString();

        EditText edit_public_key = (EditText)findViewById(R.id.edit_public_key);
        String publicKey = edit_public_key.getText().toString();

        EditText edit_amount = (EditText)findViewById(R.id.edit_amount);
        String amountText = edit_amount.getText().toString();

        EditText edit_message = (EditText)this.findViewById(R.id.edit_message);
        String message = edit_message.getText().toString();

        /*Agregar mensaje*/

        if (Validator.isEmailValid(email) && !publicKey.equals("") && !amountText.equals("") && !message.equals("")){

            loadingMask.show("Haciendo transferencia");

            TransferClient transferClient = new TransferClient(getApplicationContext());

            Callback<Transfer> callback = new Callback<Transfer>() {

                @Override
                public void success(Transfer transfer, Response response) {
                    loadingMask.hide();
                    transfer.save();
                    MessageToast.showSuccess(getApplicationContext(), getString(R.string.transfer_successful));
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    loadingMask.hide();
                    MessageToast.showSuccess(getApplicationContext(), getString(R.string.transfer_successful));
                }
            };
            double amount = Double.parseDouble(amountText);
            Date today = new Date();
            transferClient.add("1", "2", amount, DateUtils.DATE_FORMAT.format(today), message, "1", callback);

        }
        else {
            MessageToast.showError(getApplicationContext(), getString(R.string.transfer_errors));
        }
    }

    public void onCancelClick(View view){
        TransferActivity.this.startActivity(new Intent(TransferActivity.this, OperationsActivity.class));
    }
}
