package com.gildedrose;

import static java.lang.Math.max;
import static java.lang.Math.min;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if(items[i].name.equals("Aged Brie")) {
                if (items[i].sellIn <= 0) {
                    increaseQualityUpTo50(i,2);
                } else {
                    increaseQualityUpTo50(i,1);
                }
            }
            else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].sellIn == 0) {
                    items[i].quality = 0;
                }
                if (items[i].sellIn > 0 && items[i].sellIn <= 5) {
                    increaseQualityUpTo50(i,3);
                } else if (items[i].sellIn > 5 && items[i].sellIn <= 10) {
                    increaseQualityUpTo50(i, 2);
                } else if (items[i].sellIn > 10) {
                    increaseQualityUpTo50(i,1);
                }
            } 
            else if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                //DO NOTHING
            }
            else {
                if (items[i].sellIn > 0) {
                    decreaseQualityUpTo0(i,1);
                } else if (items[i].sellIn == 0) {
                    decreaseQualityUpTo0(i,2);
                }
            }
        }
    }

    private void decreaseQualityUpTo0(int i, int quality) {
        items[i].quality -= quality;
        items[i].quality = max(items[i].quality, 0);
    }

    private void increaseQualityUpTo50(int i, int quality) {
        items[i].quality += quality;
        items[i].quality = min(items[i].quality, 50);
    }
}