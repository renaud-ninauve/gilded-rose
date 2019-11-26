package fr.ninauve.renaud.kata.gildedrose;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GildedRoseTest {

    @Test
    public void should_update_quality() {

        final List<Item> items = IntStream.range(0, 10)
                .mapToObj(i -> mock(Item.class))
                .collect(Collectors.toList());

        final GildedRose gildedRose = new GildedRose(items.toArray(new Item[items.size()]));

        gildedRose.updateQuality();

        for(Item item: items) {
            verify(item).updateQuality();
        }
    }
}