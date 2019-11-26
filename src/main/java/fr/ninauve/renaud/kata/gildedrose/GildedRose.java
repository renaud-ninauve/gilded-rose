package fr.ninauve.renaud.kata.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: items) {
            item.updateQuality();
        }
    }
}

