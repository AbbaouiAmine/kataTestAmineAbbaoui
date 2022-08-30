package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * A class to define the type Aged Brie of an item
 * 
 * @author Amine.ABBAOUI
 *
 */
public class AgedBrieItem extends StandardItem {

	/**
	 * Constructor with attributes
	 * 
	 * @param name    : name of item
	 * @param sellIn  : number of days we have to sell the item
	 * @param quality : value of the item
	 */
	public AgedBrieItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	/**
	 * Constructor with item attribute
	 * 
	 * @param item : the item to be wrapped
	 */
	public AgedBrieItem(Item item) {
		super(item);
	}

	/**
	 * Polymorphic function responsible on updating the quality and the sellIn state
	 */
	public void updateQuality() {
		this.item.quality++;
		this.item.sellIn--;
		this.checkMaxQuality();
		this.checkQualityNegativity();
	}

}
