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
public class UpdateQualityOtherTest {

    @Parameterized.Parameters
    public static List<Object[]> params() {

        return Arrays.asList(
                new Object[]{
                        Item.builder().quality(0).sellIn(10).build(),
                        Item.builder().quality(0).sellIn(9).build()
                },
                new Object[]{
                        Item.builder().quality(12).sellIn(10).build(),
                        Item.builder().quality(11).sellIn(9).build()
                },
                new Object[]{
                        Item.builder().quality(12).sellIn(1).build(),
                        Item.builder().quality(11).sellIn(0).build()
                },
                new Object[]{
                        Item.builder().quality(1).sellIn(1).build(),
                        Item.builder().quality(0).sellIn(0).build()
                }
        );
    }

    private final Item item;
    private final Item expected;
    private UpdateQualityOther updateQuality;

    public UpdateQualityOtherTest(Item item, Item expected) {
        this.item = item;
        this.expected = expected;
    }

    @Before
    public void setUp() {
        this.updateQuality = new UpdateQualityOther();
    }

    @Test
    public void should_update_quality() {

        updateQuality.ofItem(item);
        assertThat(item, is(expected));
    }
}