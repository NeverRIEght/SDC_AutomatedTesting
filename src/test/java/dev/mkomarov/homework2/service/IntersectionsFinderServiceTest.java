package dev.mkomarov.homework2.service;

import dev.mkomarov.homework2.model.Circle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntersectionsFinderServiceTest {

    private final IntersectionsFinderService finder = new IntersectionsFinderService();

    @ParameterizedTest
    @CsvFileSource(resources = "/intersectionsFinderTestData.csv", numLinesToSkip = 1)
    void testIntersectionCount(int x1, int r1, int x2, int r2, int expected) {
        Circle c1 = new Circle(x1, 0, r1);
        Circle c2 = new Circle(x2, 0, r2);

        int actual = finder.getIntersectionCount(c1, c2);
        assertEquals(expected, actual);
    }
}
