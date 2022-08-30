package com.gildedrose;

import java.util.List;

import com.gildedrose.items.StandardItem;

class GildedRose {
	 private List<StandardItem> items;

    public GildedRose(Item[] items) {
        //TODO : this.items = items;
    }
    
    /**
     * Constructor 
     * @param items List of standard Items
     */
    public GildedRose(List<StandardItem> items) {
        this.items = items;
    }

    /**
     * Update the quality of items depending of functional rules
     * see the tests functions
     */
    public void updateQuality() {
        
    }
    
    /**
     * Get an item by its index
     * @param i the index of an item
     * @return the Item selected
     */
    public StandardItem getItemByIndex(int i) {
    	return this.items.get(i);
    }
}