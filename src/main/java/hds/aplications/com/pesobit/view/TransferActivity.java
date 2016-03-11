package hds.aplications.com.pesobit.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import hds.aplications.com.pesobit.R;
import hds.aplications.com.pesobit.common.MessageToast;
import hds.aplications.com.pesobit.common.Validator;

public class TransferActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
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
        String amount = edit_amount.getText().toString();

        /*Agregar mensaje*/

        if (Validator.isEmailValid(email) && !publicKey.equals("") && !amount.equals("")){

        }
        else {
            MessageToast.showError(getApplicationContext(), getString(R.string.transfer_errors));
        }
    }

    public void onCancelClick(View view){
        TransferActivity.this.startActivity(new Intent(TransferActivity.this, OperationsActivity.class));
    }
}
