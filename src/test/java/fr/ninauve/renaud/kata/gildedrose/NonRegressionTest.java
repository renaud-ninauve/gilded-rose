package fr.ninauve.renaud.kata.gildedrose;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class NonRegressionTest {

    private static final List<String> NAMES = Arrays.asList(
            "Aged Brie",
            "Backstage passes to a TAFKAL80ETC concert",
            "Sulfuras, Hand of Ragnaros",
            "other"
    );
    private static final List<Integer> QUALITY = Arrays.asList(
            0, 1, 2, 3, 47, 48, 49, 50, 51, 52, 53
    );
    private static final List<Integer> SELL_IN =
            IntStream.rangeClosed(-1, 12).boxed().collect(Collectors.toList());

    private static GildedRose gildedRoseFixture() {

        final List<Item> items = NAMES.stream()
                .flatMap(name -> SELL_IN.stream().map(sellIn -> new Item(name, sellIn, -1)))
                .flatMap(item -> QUALITY.stream().map(quality -> new Item(item.getName(), item.getSellIn(), item.getQuality())))
                .collect(Collectors.toList());

        return new GildedRose(items.toArray(new Item[items.size()]));
    }

    private static void print(PrintStream printStream, GildedRose gildedRose) {

        for (Item item : gildedRose.getItems()) {
            printStream.println(item);
        }
    }

    public static void main(String... args) throws Exception {

        final GildedRose gildedRose = gildedRoseFixture();
        gildedRose.updateQuality();

        try (final PrintStream printStream = new PrintStream(System.out)) {
            print(printStream, gildedRose);
        }
    }

    @Test
    public void nonRegressionTest() throws Exception {

        final String expected;
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(NonRegressionTest.class.getResourceAsStream("/fr/ninauve/renaud/kata/gildedrose/non-regression.txt")));
             final ByteArrayOutputStream expectedOut = new ByteArrayOutputStream();
             final PrintStream printStream = new PrintStream(expectedOut)) {

            String line = null;
            while ((line = reader.readLine()) != null) {
                printStream.println(line);
            }
            expected = expectedOut.toString();
        }

        final GildedRose gildedRose = gildedRoseFixture();
        gildedRose.updateQuality();

        final String actual;
        try (final ByteArrayOutputStream actualOut = new ByteArrayOutputStream();
             final PrintStream actualPrintStream = new PrintStream(actualOut);) {

            print(actualPrintStream, gildedRose);
            actual = actualOut.toString();
        }

        assertEquals(expected, actual);
    }
}