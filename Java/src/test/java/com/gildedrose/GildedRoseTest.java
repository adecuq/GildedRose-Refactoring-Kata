package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class GildedRoseTest {

    @Test
    public void quality_should_increase_by_two_when_Aged_Brie_and_sellin_less_or_equal_than_0() {
        GildedRose app = updateQuality("Aged Brie", 0, 1);

        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void quality_should_increase_by_one_when_Aged_Brie_and_sellin_greater_than_0() {
        GildedRose app = updateQuality("Aged Brie", 1, 1);

        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void quality_should_stop_to_increase_above_50_when_Aged_Brie() {
        GildedRose app = updateQuality("Aged Brie", 0, 50);

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void quality_should_increase_by_three_when_Backstage_and_sellin_between_0_and_5_inclusive() {
        GildedRose app = updateQuality("Backstage passes to a TAFKAL80ETC concert", 1, 1);

        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void quality_should_increase_by_two_when_Backstage_and_sellin_between_6_and_10_inclusive() {
        GildedRose app = updateQuality("Backstage passes to a TAFKAL80ETC concert", 6, 1);

        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void quality_should_increase_by_one_when_Backstage_and_sellin_greater_than_10() {
        GildedRose app = updateQuality("Backstage passes to a TAFKAL80ETC concert", 11, 1);

        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void quality_should_stop_to_increase_above_50_when_Backstage_and_sellin_between_0_and_5_inclusive() {
        GildedRose app = updateQuality("Backstage passes to a TAFKAL80ETC concert", 1, 48);

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void quality_should_stop_to_increase_above_50_when_Backstage_and_sellin_between_6_and_10_inclusive() {
        GildedRose app = updateQuality("Backstage passes to a TAFKAL80ETC concert", 1, 49);

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void quality_should_stop_to_increase_above_50_when_Backstage_and_sellin_greater_than_10() {
        GildedRose app = updateQuality("Backstage passes to a TAFKAL80ETC concert", 1, 50);

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void quality_should_drop_to_0_when_Backstage_and_sellin_equals_to_0() {
        GildedRose app = updateQuality("Backstage passes to a TAFKAL80ETC concert", 0, 15);

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void quality_should_stay_unchanged_when_Sulfuras() {
        GildedRose app = updateQuality("Sulfuras, Hand of Ragnaros", 0, 1);

        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void sellin_should_stay_unchanged_when_Sulfuras() {
        GildedRose app = updateQuality("Sulfuras, Hand of Ragnaros", 1, 0);

        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    public void quality_should_decrease_by_one_when_Conjured_and_sellin_greater_than_0() {
        GildedRose app = updateQuality("Conjured", 1, 2);

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void quality_should_decrease_by_two_when_Conjured_and_sellin_less_or_equal_to_0() {
        GildedRose app = updateQuality("Conjured", 0, 2);

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void quality_should_never_be_negative() {
        GildedRose app = updateQuality("Conjured", 0, 1);

        assertEquals(0, app.items[0].quality);
    }

    private GildedRose updateQuality(String s, int i, int i2) {
        Item[] items = new Item[]{new Item(s, i, i2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app;
    }
}
