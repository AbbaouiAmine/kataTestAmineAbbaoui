package com.gildedrose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.gildedrose.items.AgedBrieItem;
import com.gildedrose.items.BackstagePassesItem;
import com.gildedrose.items.ConjuredItem;
import com.gildedrose.items.StandardItem;
import com.gildedrose.items.SulfurasItem;

class GildedRose {
	private List<StandardItem> items;

	/**
	 * Constructor
	 * 
	 * @param items
	 *            list of items for legacy code
	 */
	public GildedRose(Item[] items) {
		List<Item> itemsI = Arrays.asList(items);
		this.items = itemsI.stream().map(i -> {
			if (i.name.contains("Aged"))
				return new AgedBrieItem(i);
			if (i.name.contains("Sulfuras"))
				return new SulfurasItem(i);
			if (i.name.contains("Backstage"))
				return new BackstagePassesItem(i);
			if (i.name.contains("Conjured"))
				return new ConjuredItem(i);
			return new StandardItem(i);
		}).collect(Collectors.toList());
	}

	/**
	 * Constructor
	 * 
	 * @param items
	 *            List of standard Items
	 */
	public GildedRose(List<StandardItem> items) {
		this.items = items;
	}

	/**
	 * Update the quality of items depending of functional rules see the tests
	 * functions
	 */
	public void updateQuality() {

		this.items.stream().forEach(item -> item.updateQuality());
	}

	/**
	 * Get an item by its index
	 * 
	 * @param i
	 *            the index of an item
	 * @return the Item selected
	 */
	public StandardItem getItemByIndex(int i) {
		return this.items.get(i);
	}
}