package fr.ninauve.renaud.kata.gildedrose.updatequality;

import fr.ninauve.renaud.kata.gildedrose.Item;

public class UpdateQualityBackstagePasses implements UpdateQuality {

    @Override
    public void ofItem(Item item) {

        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
        if (item.getSellIn() < 11 && item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }

        if (item.getSellIn() < 6 && item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
        item.setSellIn(item.getSellIn() - 1);
        if (item.getSellIn() < 0) {
            item.setQuality(0);
        }
    }
}
