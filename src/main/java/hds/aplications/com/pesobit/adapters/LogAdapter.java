package hds.aplications.com.pesobit.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hds.aplications.com.pesobit.R;
import hds.aplications.com.pesobit.models.Transfer;

/**
 * Created by YANET on 11/03/2016.
 */
public class LogAdapter extends BaseAdapter {
    private Context context;
    private List<Transfer> items;

    public LogAdapter(Context context, List<Transfer> items){
        this.context= context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return  (((Transfer)this.getItem(position)).getId() != null) ?((Transfer)this.getItem(position)).getId(): ((Transfer)this.getItem(position)).getIdRef();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.log_item, parent, false);
        }

        // Set data into the view.
        /*TextView textTitle = (TextView) rowView.findViewById(R.id.textTitle);
        TextView textCheckout = (TextView) rowView.findViewById(R.id.textCheckout);
        TextView textCheckin = (TextView) rowView.findViewById(R.id.textCheckin);
        TextView roomsTotal = (TextView) rowView.findViewById(R.id.roomsTotal);*/

        /*Resources res = this.context.getResources();
        String roomString = this.context.getResources().getQuantityString(R.plurals.rooms, 2, 2);*/

        Transfer item = this.items.get(position);
        /*textTitle.setText(item.getAccommodation().getName());
        textCheckout.setText("Apr 16, 2016");
        textCheckin.setText("Apr 20, 2016");
        roomsTotal.setText(roomString);*/

        return rowView;
    }
}

