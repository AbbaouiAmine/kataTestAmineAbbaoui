package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * A class to define the type Conjured of an item
 * 
 * @author Amine.ABBAOUI
 *
 */
public class ConjuredItem extends StandardItem {

	/**
	 * Constructor with attributes
	 * 
	 * @param name    : name of item
	 * @param sellIn  : number of days we have to sell the item
	 * @param quality : value of the item
	 */
	public ConjuredItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	/**
	 * Constructor with item attribute
	 * 
	 * @param item : the item to be wrapped
	 */
	public ConjuredItem(Item item) {
		super(item);
	}



}
