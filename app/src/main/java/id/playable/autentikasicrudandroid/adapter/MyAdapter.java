package id.playable.autentikasicrudandroid.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.playable.autentikasicrudandroid.R;
import id.playable.autentikasicrudandroid.database.Mahasiswa;


/**
 * Created by nandoseptianhusni on 4/10/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Mahasiswa> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textName,textAlamat,textNohp;

        public ViewHolder(View v) {
            super(v);

            textName = v.findViewById(R.id.text);
            textAlamat = v.findViewById(R.id.textAlamat);
            textNohp = v.findViewById(R.id.textNohp);

        }

        public void bind(final Mahasiswa datanyaItem) {
            textName.setText(datanyaItem.getName());
            textAlamat.setText(datanyaItem.getAlamat());
            textNohp.setText(datanyaItem.getNohp());



        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Mahasiswa> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recylerview, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.bind(mDataset.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}