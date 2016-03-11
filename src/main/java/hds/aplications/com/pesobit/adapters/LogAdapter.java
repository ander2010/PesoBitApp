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
        TextView lblLogMessage = (TextView) rowView.findViewById(R.id.lbl_log_message);

        Transfer item = this.items.get(position);

        Resources resources = this.context.getResources();
        String logMessage = String.format(resources.getString(R.string.log_message), item.getSender().getUser().getFullName(), item.getInitialAmount(), item.getReceiver().getUser().getFullName(), item.getAmount(), item.getInitialAmount() - item.getAmount());
        lblLogMessage.setText(logMessage);

        return rowView;
    }
}

