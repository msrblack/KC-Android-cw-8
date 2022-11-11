package com.example.shopingmentor;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ItemsAdapter extends ArrayAdapter<Items> {
    List<Items> Itemslist;
    public ItemsAdapter(@NonNull Context context, int resource, @NonNull List<Items> objects) {
        super(context, resource, objects);
        Itemslist = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.list, parent, false);

        Items currentItems = Itemslist.get(position);

        TextView ItemsName = view.findViewById(R.id.honeyName);
        TextView Itemsprice = view.findViewById(R.id.honeyprice);
        ImageView ItemsImg = view.findViewById(R.id.honeyImg);
        ImageView delete = view.findViewById(R.id.delete);


        ItemsName.setText(currentItems.getItemName());
        Itemsprice.setText(currentItems.getItemPrice()+"");
        ItemsImg.setImageResource(currentItems.getItemImg());

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Itemslist.remove(position);
                //notifyDataSetChanged();

                AlertDialog.Builder alertbox = new AlertDialog.Builder(view.getRootView().getContext());
                alertbox.setMessage("Are sureee you want to delete this item??????!!!");
                alertbox.setTitle("confirmation");
                alertbox.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Itemslist.remove(position);
                        notifyDataSetChanged();

                        Snackbar.make(getContext(), view,"your item has been deleted", 2000).setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Itemslist.add(currentItems);
                                notifyDataSetChanged();
                            }
                        }).show();

                    }
                });

                alertbox.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                alertbox.show();
            }

        });


        return view;

    }
}
