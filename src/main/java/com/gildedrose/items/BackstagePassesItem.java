package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * A class to define the type Backstage passes of an item
 * 
 * @author Amine.ABBAOUI
 *
 */
public class BackstagePassesItem extends StandardItem {

	/**
	 * Constructor with attributes
	 * 
	 * @param name    : name of item
	 * @param sellIn  : number of days we have to sell the item
	 * @param quality : value of the item
	 */
	public BackstagePassesItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	/**
	 * Constructor with item attribute
	 * 
	 * @param item : the item to be wrapped
	 */
	public BackstagePassesItem(Item item) {
		super(item);
	}

	/**
	 * Polymorphic function responsible on updating the quality and the sellIn state
	 */
	public void updateQuality() {
		if (this.item.sellIn < 0) {
			this.item.quality = 0;
			this.item.sellIn--;
			return;
		}
		if (this.item.sellIn > 0 && this.item.sellIn <= 5) {
			this.item.quality = this.item.quality + 3;
			this.item.sellIn--;
			return;
		}
		if (this.item.sellIn > 0 && this.item.sellIn <= 10) {
			this.item.quality = this.item.quality + 2;
			this.item.sellIn--;
			return;
		}
	}

	

}
