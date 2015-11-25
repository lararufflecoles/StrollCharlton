package es.rufflecol.lara.strollcharlton;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    // This interface allows us to handle clicks outside of the adapter, i.e. the AlertDialog in the ListViewActivity
    // This adapter can now be used again to make another list that does something different when clicked e.g. a Toast
    public interface OnRecyclerItemClickListener {

        void onRecyclerItemClick(String data);
    }

    private ArrayList<String> dataSource;
    private OnRecyclerItemClickListener onRecyclerItemClickListener;

    public RecyclerAdapter(ArrayList<String> dataArgs, OnRecyclerItemClickListener onRecyclerItemClickListener) {
        this.dataSource = dataArgs;
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    // Next three methods are the abstract methods from the parent class - RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view, onRecyclerItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(dataSource.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    // The nested ViewHolder class is inherently tightly coupled to the RecyclerAdapter - part of its nature (the opposite of Separation of Concerns)
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView;
        private String data;
        private OnRecyclerItemClickListener onRecyclerItemClickListener;

        public ViewHolder(View itemView, OnRecyclerItemClickListener onRecyclerItemClickListener) {
            super(itemView);
            textView = (TextView) itemView;
            this.onRecyclerItemClickListener = onRecyclerItemClickListener;
            itemView.setOnClickListener(this);
        }

        public void setData(String data) {
            this.data = data;
            textView.setText(data);
        }

        @Override
        public void onClick(View v) {
            onRecyclerItemClickListener.onRecyclerItemClick(data);
        }
    }
}