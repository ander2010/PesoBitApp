package hds.aplications.com.pesobit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class OperationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_operations, menu);
        return true;
    }

    public void onTransferClick(View view){
        OperationsActivity.this.startActivity(new Intent(OperationsActivity.this, TransferActivity.class));
    }

    public void onNotificationsClick(View view){
        //ActivityEditProfile.this.startActivity(new Intent(ActivityEditProfile.this, ActivityNewProperty.class));
    }

    public void onRechargeClick(View view){
        //ActivityEditProfile.this.startActivity(new Intent(ActivityEditProfile.this, ActivityNewProperty.class));
    }
}
