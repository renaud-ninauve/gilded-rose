package fr.ninauve.renaud.kata.gildedrose;

import fr.ninauve.renaud.kata.gildedrose.updatequality.UpdateQuality;
import fr.ninauve.renaud.kata.gildedrose.updatequality.UpdateQualityFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GildedRoseTest {

    @Mock
    private UpdateQualityFactory updateQualityFactory;

    @Test
    public void should_update_quality() {

        final List<Item> items = IntStream.range(0, 10)
                .mapToObj(i -> mock(Item.class))
                .collect(Collectors.toList());

        final List<UpdateQuality> updateQualities = IntStream.range(0, 10)
                .mapToObj(i -> mock(UpdateQuality.class))
                .collect(Collectors.toList());

        for(int i=0; i<items.size(); i++) {
            when(updateQualityFactory.forItem(same(items.get(i))))
                    .thenReturn(updateQualities.get(i));
        }

        final GildedRose gildedRose =
                new GildedRose(updateQualityFactory, items.toArray(new Item[0]));

        gildedRose.updateQuality();

        for(Item item: items) {
            verify(updateQualityFactory).forItem(same(item));
        }
        for(int i=0; i<items.size(); i++) {
            verify(updateQualities.get(i)).ofItem(same(items.get(i)));
        }
    }
}