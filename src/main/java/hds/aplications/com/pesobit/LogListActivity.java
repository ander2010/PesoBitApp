package hds.aplications.com.pesobit;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hds.aplications.com.pesobit.adapters.LogAdapter;

public class LogListActivity extends Activity {

    private ListView listView;
    private TextView emptyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_list);

        this.listView = (ListView) findViewById(R.id.list);
        this.emptyList = (TextView) findViewById(R.id.emptyList);

        List<Log> items = new ArrayList();

        if(items.size() > 0) {
            // Sets the data behind this ListView
            this.listView.setAdapter(new LogAdapter(this, items));
            this.emptyList.setVisibility(View.INVISIBLE);
        }
        else{
            this.emptyList.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_list, menu);
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
}
