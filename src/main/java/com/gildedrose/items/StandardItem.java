package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * A class to define a standard Item with the main behavior
 * 
 * @author Amine.ABBAOUI
 */
public class StandardItem {

	/* wrapped item based on the legacy definition */
	protected Item item;

	/**
	 * Constructor with attributes
	 * 
	 * @param name    : name of item
	 * @param sellIn  : number of days we have to sell the item
	 * @param quality : value of the item
	 */
	public StandardItem(String name, int sellIn, int quality) {
		this.item = new Item(name, sellIn, quality);
	}

	/**
	 * Constructor with item attribute
	 * 
	 * @param item : the item to be wrapped
	 */
	public StandardItem(Item item) {
		this.item = item;
	}

	/**
	 * Name getter
	 * 
	 * @return name of the item
	 */
	public String getName() {
		return this.item.name;
	}

	/**
	 * Quality getter
	 * 
	 * @return the quality of the item
	 */
	public int getQuality() {
		return this.item.quality;
	}

	/**
	 * SellIn getter
	 * 
	 * @return number of days in which the item should be sell
	 */
	public int getSellIn() {
		return this.item.sellIn;
	}

	/**
	 * Polymorphic function responsible on updating the quality and the sellIn state
	 */
	public void updateQuality() {
		int valueOfDecrease = 1;
		if (this.item.sellIn < 0)
			valueOfDecrease = 2;
		this.item.quality = this.item.quality - valueOfDecrease;
		this.item.sellIn--;

		this.checkMaxQuality();
		this.checkQualityNegativity();
	}

	/**
	 * Check the maximum value of an item
	 */
	protected void checkMaxQuality() {
		if (this.item.quality > 50)
			this.item.quality = 50;
	}

	/**
	 * Check the positivity of the quality of an item
	 */
	protected void checkQualityNegativity() {
		if (this.item.quality < 0)
			this.item.quality = 0;
	}
}
