package com.example.grocerylist;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemsAdapter extends
        RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private List<Item> items;

    public ItemsAdapter(List<Item> i){
        this.items = i;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public Button button;
        public EditText myText;
        public CustomEditTextListener myTextListener;

        public ViewHolder(View itemView){
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_name);
            button = (Button) itemView.findViewById(R.id.button1);
            myText = (EditText) itemView.findViewById(R.id.edit_text);
            /*myTextListener = textListener;
            this.myText.addTextChangedListener(myTextListener);*/
        }
    }

    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemsView = inflater.inflate(R.layout.item_row, parent, false);
        ViewHolder vH = new ViewHolder(itemsView);
        return vH;
    }

    @Override
    public void onBindViewHolder(ItemsAdapter.ViewHolder holder, int position) {
        Item item = items.get(position);

        TextView tv = holder.textView;
        tv.setText(item.getName());
        Button b = holder.button;
        b.setText(item.isPurchased() ? "Purchased" : "Buy");
        //b.setEnabled(item.isPurchased());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.purchaseItem();
                b.setText(item.isPurchased() ? "Purchased" : "Buy");
            }
        });
    }

    public void addRow(String itemName){
        items.add(new Item(itemName, false));
    }

    private class CustomEditTextListener implements TextWatcher {
        private int position;

        public void updatePosition(int position) {
            this.position = position;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            // no op
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            // no op
        }
    }

}

