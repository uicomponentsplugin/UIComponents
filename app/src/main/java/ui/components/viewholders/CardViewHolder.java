package ui.components.viewholders;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import ui.components.databinding.ItemCard2Binding;
import ui.components.databinding.ItemCardBinding;

public class CardViewHolder extends RecyclerView.ViewHolder {
    private ItemCardBinding itemCardBinding;
    private ItemCard2Binding itemCard2Binding;

    public CardViewHolder(@NonNull ViewBinding binding) {
        super(binding.getRoot());
        if (binding instanceof ItemCardBinding) {
            itemCardBinding = (ItemCardBinding) binding;
        } else if (binding instanceof ItemCard2Binding) {
            itemCard2Binding = (ItemCard2Binding) binding;
        }
    }

    public ItemCardBinding getItemCardBinding() {
        return itemCardBinding;
    }
    public ItemCard2Binding getItemCard2Binding() {
        return itemCard2Binding;
    }
}
