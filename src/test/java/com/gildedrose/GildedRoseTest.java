package com.gildedrose;

import org.junit.jupiter.api.Test;

import com.gildedrose.items.AgedBrieItem;
import com.gildedrose.items.BackstagePassesItem;
import com.gildedrose.items.ConjuredItem;
import com.gildedrose.items.StandardItem;
import com.gildedrose.items.SulfurasItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

class GildedRoseTest {

	/**
	 * Test case : At the end of each day our system lowers both values for every
	 * item
	 */
	@Test
	public void updateQualityTestEndOfDay() {
		StandardItem myItem = new StandardItem("ItemTest", 15, 20);
		List<StandardItem> items = new ArrayList<>();
		items.add(myItem);
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(19, app.getItemByIndex(0).getQuality());
		assertEquals(14, app.getItemByIndex(0).getSellIn());
	}

	/**
	 * Test case : Once the sell by date has passed, Quality degrades twice as fast
	 */
	@Test
	public void updateQualityTest() {
		try {
			StandardItem myItem = new StandardItem("ItemTest", -1, 19);
			List<StandardItem> items = new ArrayList<>();
			items.add(myItem);
			GildedRose app = new GildedRose(items);
			app.updateQuality();
			assertEquals(17, app.getItemByIndex(0).getQuality());
		} catch (Exception e) {
			fail("Technical error");
		}

	}

	/**
	 * Test Case : The Quality of an item is never negative
	 */
	@Test
	public void updateQualityTestNegativeQuality() {
		StandardItem myItem = new StandardItem("ItemTest", 3, -1);
		List<StandardItem> items = new ArrayList<>();
		items.add(myItem);
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0, app.getItemByIndex(0).getQuality());
	}

	/**
	 * Test case : "Aged Brie" actually increases in Quality the older it gets
	 */
	@Test
	public void updateQualityTestAgedBrieQualityIncrease() {
		StandardItem myItem = new AgedBrieItem("ItemTest", 5, 15);
		List<StandardItem> items = new ArrayList<>();
		items.add(myItem);
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(16, app.getItemByIndex(0).getQuality());
	}

	/**
	 * Test Case : The Quality of an item is never more than 50
	 */
	@Test
	public void updateQualityTestMaxQuality() {
		try {
			StandardItem myItem = new AgedBrieItem("ItemTest", 5, 51);
			List<StandardItem> items = new ArrayList<>();
			items.add(myItem);
			GildedRose app = new GildedRose(items);
			app.updateQuality();
			assertEquals(50, app.getItemByIndex(0).getQuality());
		} catch (Exception e) {
			fail("Technical error");
		}
	}

	/**
	 * Test case : "Sulfuras", being a legendary item, never has to be sold or
	 * decreases in Quality
	 */
	@Test
	public void updateQualityTestSulfurasNotDecrases() {

		StandardItem myItem = new SulfurasItem("ItemTest", 5, 50);
		List<StandardItem> items = new ArrayList<>();
		items.add(myItem);
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(4, app.getItemByIndex(0).getSellIn());
		assertEquals(50, app.getItemByIndex(0).getQuality());
	}

	/**
	 * Test case : Backstage passes Quality increases by 2 when there are 10 days or
	 * less and by 3 when there are 5 days or less but Quality drops to 0 after the
	 * concert
	 */
	@Test
	public void updateQualityTestBackstagePasses() {
		StandardItem myItem1 = new BackstagePassesItem("ItemTest", 7, 30);
		StandardItem myItem2 = new BackstagePassesItem("ItemTest", 2, 30);
		StandardItem myItem3 = new BackstagePassesItem("ItemTest", -1, 30);

		List<StandardItem> items = new ArrayList<>();
		items.add(myItem1);
		items.add(myItem2);
		items.add(myItem3);
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(32, app.getItemByIndex(0).getQuality());
		assertEquals(33, app.getItemByIndex(1).getQuality());
		assertEquals(0, app.getItemByIndex(2).getQuality());
	}

	/**
	 * Test case : "Conjured" items degrade in Quality twice as fast as normal items
	 */
	@Test
	public void updateQualityTestBackstageConjured() {
		StandardItem myItem = new ConjuredItem("ItemTest", 7, 30);
		List<StandardItem> items = new ArrayList<>();
		items.add(myItem);
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(28, app.getItemByIndex(0).getQuality());
	}
}
