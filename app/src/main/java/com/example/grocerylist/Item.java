package com.example.grocerylist;

import java.util.ArrayList;

public class Item {
    private String name;
    private boolean purchased;

    public Item(String name, boolean purchased){
        this.name = name;
        this.purchased = purchased;
    }

    public String getName(){
        return name;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void purchaseItem(){this.purchased=true;}

    private static int lastId = 0;

    public static ArrayList<Item> createList(int numItems, String itemName){
        ArrayList<Item> items = new ArrayList<Item>();

        for(int i = 1; i <= numItems; i++){
            //items.add(new Item("" + ++lastId, false));
           items.add(new Item(itemName, false));
        }

        return items;
    }
}
