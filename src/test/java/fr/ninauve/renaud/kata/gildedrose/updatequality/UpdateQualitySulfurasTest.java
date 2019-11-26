package fr.ninauve.renaud.kata.gildedrose.updatequality;

import fr.ninauve.renaud.kata.gildedrose.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class UpdateQualitySulfurasTest {

    @Parameterized.Parameters
    public static List<Object[]> params() {

        return Collections.singletonList(
                new Object[]{
                        Item.builder().quality(42).sellIn(31).build(),
                        Item.builder().quality(42).sellIn(31).build()
                }
        );
    }

    private final Item item;
    private final Item expected;
    private UpdateQualitySulfuras updateQuality;

    public UpdateQualitySulfurasTest(Item item, Item expected) {
        this.item = item;
        this.expected = expected;
    }

    @Before
    public void setUp() {
        this.updateQuality = new UpdateQualitySulfuras();
    }

    @Test
    public void should_update_quality() {

        updateQuality.ofItem(item);
        assertThat(item, is(expected));
    }
}