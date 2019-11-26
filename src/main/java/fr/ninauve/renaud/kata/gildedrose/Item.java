package fr.ninauve.renaud.kata.gildedrose;

public class Item {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality() {

        switch (name) {
            case AGED_BRIE:
                if (quality < 50) {
                    quality = quality + 1;
                }
                sellIn = sellIn - 1;
                if (sellIn < 0 && quality < 50) {
                    quality = quality + 1;
                }
                break;
            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                if (quality < 50) {
                    quality = quality + 1;
                }
                if (sellIn < 11 && quality < 50) {
                    quality = quality + 1;
                }

                if (sellIn < 6 && quality < 50) {
                    quality = quality + 1;
                }
                sellIn = sellIn - 1;
                if (sellIn < 0) {
                    quality = 0;
                }
                break;
            case SULFURAS_HAND_OF_RAGNAROS:
                if (sellIn < 0 && quality > 0) {
                    return;
                }
                break;
            default:
                if (quality > 0) {
                    quality = quality - 1;
                }
                sellIn = sellIn - 1;
                if (sellIn < 0 && quality > 0) {
                    quality = quality - 1;
                }
                break;
        }
    }
    
    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
