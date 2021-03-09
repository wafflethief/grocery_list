package com.example.grocerylist;

import java.util.ArrayList;

public class Item {
    private String name;
    private boolean online;

    public Item(String name, boolean online){
        this.name = name;
        this.online = online;
    }

    public String getName(){
        return name;
    }

    public boolean isOnline() {
        return online;
    }

    private static int lastId = 0;

    public static ArrayList<Item> createList(int numItems){
        ArrayList<Item> items = new ArrayList<Item>();

        for(int i = 1; i <= numItems; i++){
            items.add(new Item("com.example.grocerylist.Item " + ++lastId, i <=numItems/2));
        }

        return items;
    }
}
