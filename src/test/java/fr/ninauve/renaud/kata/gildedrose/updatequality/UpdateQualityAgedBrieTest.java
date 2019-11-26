package fr.ninauve.renaud.kata.gildedrose.updatequality;

import fr.ninauve.renaud.kata.gildedrose.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class UpdateQualityAgedBrieTest {

    @Parameterized.Parameters
    public static List<Object[]> params() {

        return Arrays.asList(
                new Object[]{
                        Item.builder().quality(55).sellIn(10).build(),
                        Item.builder().quality(55).sellIn(9).build()
                },
                new Object[]{
                        Item.builder().quality(42).sellIn(10).build(),
                        Item.builder().quality(43).sellIn(9).build()
                },
                new Object[]{
                        Item.builder().quality(42).sellIn(0).build(),
                        Item.builder().quality(44).sellIn(-1).build()
                },
                new Object[]{
                        Item.builder().quality(55).sellIn(0).build(),
                        Item.builder().quality(55).sellIn(-1).build()
                }
        );
    }

    private final Item item;
    private final Item expected;
    private UpdateQualityAgedBrie updateQuality;

    public UpdateQualityAgedBrieTest(Item item, Item expected) {
        this.item = item;
        this.expected = expected;
    }

    @Before
    public void setUp() {
        this.updateQuality = new UpdateQualityAgedBrie();
    }

    @Test
    public void should_update_quality() {

        updateQuality.ofItem(item);
        assertThat(item, is(expected));
    }
}