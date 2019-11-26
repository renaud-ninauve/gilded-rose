package fr.ninauve.renaud.kata.gildedrose.updatequality;

import fr.ninauve.renaud.kata.gildedrose.Item;

import java.util.HashMap;
import java.util.Map;

public class UpdateQualityFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    private static final UpdateQuality UPDATE_QUALITY_OTHER = new UpdateQualityOther();
    private static final Map<String, UpdateQuality> UPDATE_QUALITY_BY_NAME = new HashMap<>();
    static {
        UPDATE_QUALITY_BY_NAME.put(AGED_BRIE, new UpdateQualityAgedBrie());
        UPDATE_QUALITY_BY_NAME.put(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, new UpdateQualityBackstagePasses());
        UPDATE_QUALITY_BY_NAME.put(SULFURAS_HAND_OF_RAGNAROS, new UpdateQualitySulfuras());
    }

    public UpdateQuality forItem(Item item) {

        return UPDATE_QUALITY_BY_NAME.getOrDefault(item.getName(), UPDATE_QUALITY_OTHER);
    }
}
