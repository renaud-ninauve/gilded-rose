package fr.ninauve.renaud.kata.gildedrose;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Item {

    private final String name;
    private int sellIn;
    private int quality;
    
    @Override
    public String toString() {
        return this.getName() + ", " + this.getSellIn() + ", " + this.getQuality();
    }
}
