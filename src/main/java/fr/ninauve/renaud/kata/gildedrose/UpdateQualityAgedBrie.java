package fr.ninauve.renaud.kata.gildedrose;

public class UpdateQualityAgedBrie implements UpdateQuality {
    
    @Override
    public void ofItem(Item item) {

        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
        item.setSellIn(item.getSellIn() - 1);
        if (item.getSellIn() < 0 && item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }        
    }
}
