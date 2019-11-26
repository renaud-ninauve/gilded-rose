package fr.ninauve.renaud.kata.gildedrose;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class UpdateQualityFactoryTest {

    @Parameterized.Parameters
    public static List<Object[]> params() {

        return Arrays.asList(
                new Object[]{"Aged Brie", UpdateQualityAgedBrie.class},
                new Object[]{"Backstage passes to a TAFKAL80ETC concert", UpdateQualityBackstagePasses.class},
                new Object[]{"Sulfuras, Hand of Ragnaros", UpdateQualitySulfuras.class},
                new Object[]{"Random", UpdateQualityOther.class}
        );
    }

    private UpdateQualityFactory factory;
    private final String name;
    private final Class<? extends UpdateQuality> expected;

    public UpdateQualityFactoryTest(String name, Class<? extends UpdateQuality> expected) {
        this.name = name;
        this.expected = expected;
    }

    @Before
    public void setUp() {
        this.factory = new UpdateQualityFactory();
    }

    @Test
    public void should_return_update_quality_for_item() {

        final Item item = new Item(name, 0, 0);
        final UpdateQuality actual = factory.forItem(item);
        assertThat(actual, is(instanceOf(expected)));
    }
}