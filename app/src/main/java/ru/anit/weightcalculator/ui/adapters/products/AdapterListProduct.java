package ru.anit.weightcalculator.ui.adapters.products;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmChangeListener;
import ru.anit.weightcalculator.R;

public class AdapterListProduct extends RecyclerView.Adapter<AdapterListProduct.ViewHolder> implements RealmChangeListener {

    private final List mList;

    private CallBackClickItem mCallBackClickItem;


    public AdapterListProduct(List list,CallBackClickItem CallBackClickItem) {
        mList = list;
        mCallBackClickItem = CallBackClickItem;
        //mProducts.addChangeListener(this);
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int i) {
        holder.setItem((ItemProdactsI) mList.get(i));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    @Override
    public void onChange(Object element) {
        notifyDataSetChanged();
    }


    /**
     * Holde
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_name)
        TextView tvName;

        @BindView(R.id.tv_weight)
        TextView tvWeight;

        @BindView(R.id.tv_sites)
        TextView tvSites;

        ItemProdactsI mItem;


        public void setItem(ItemProdactsI item) {
            mItem = item;

            tvName.setText(mItem.getName());
            tvWeight.setText(mItem.getWeight());
            tvSites.setText(mItem.getSites());
        }

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mCallBackClickItem.click(mItem.getId());
        }
    }

    public interface CallBackClickItem {
        void click(String id);
    }

}
