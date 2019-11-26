package fr.ninauve.renaud.kata.gildedrose;

import fr.ninauve.renaud.kata.gildedrose.updatequality.UpdateQuality;
import fr.ninauve.renaud.kata.gildedrose.updatequality.UpdateQualityFactory;

class GildedRose {

    private final UpdateQualityFactory updateQualityFactory;
    private final Item[] items;

    public GildedRose(Item[] items) {
        this(new UpdateQualityFactory(), items);
    }

    protected GildedRose(UpdateQualityFactory updateQualityFactory, Item[] items) {
        this.updateQualityFactory = updateQualityFactory;
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: items) {
            UpdateQuality updateQuality = updateQualityFactory.forItem(item);
            updateQuality.ofItem(item);
        }
    }

    public Item[] getItems() {
        return items;
    }
}

