package ui.components.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ui.components.R;
import ui.components.databinding.ItemCard2Binding;
import ui.components.viewholders.CardViewHolder;

public class CardViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CardViewHolder(ItemCard2Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CardViewHolder) {
            CardViewHolder cardViewHolder = (CardViewHolder) holder;
//            cardViewHolder.getItemCardBinding().imgSlide.setImageResource(R.drawable.ic_launcher_background);
//            cardViewHolder.getItemCardBinding().txtScreen.setText(String.valueOf(position));
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
