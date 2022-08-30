package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * A class to define the type Sulfuras of an item
 * 
 * @author Amine.ABBAOUI
 *
 */
public class SulfurasItem extends StandardItem {

	/**
	 * Constructor with attributes
	 * 
	 * @param name    : name of item
	 * @param sellIn  : number of days we have to sell the item
	 * @param quality : value of the item
	 */
	public SulfurasItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	/**
	 * Constructor with item attribute
	 * 
	 * @param item : the item to be wrapped
	 */
	public SulfurasItem(Item item) {
		super(item);
	}

	/**
	 * Polymorphic function responsible on updating the quality and the sellIn state
	 */
	public void updateQuality() {
		this.item.quality = this.item.quality;
		this.item.sellIn--;
		this.checkMaxQuality();
		this.checkQualityNegativity();
	}

	/**
	 * Check the maximum value of a Sulfuras item
	 */
	protected void checkMaxQuality() {
		this.item.quality = 80;
	}
}
