import org.assertj.core.data.Percentage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class MainTest {

    Main main;

    @BeforeClass
    public void beforeClass() {
        main = new Main();
    }

    @AfterClass
    public void afterClass() {
        main = null;
    }

    @Test(dataProvider = "functionParam", dataProviderClass = StaticDataProvider.class)
    public void testCalculateFunction(double x, double expected) {
        double actual = main.calculateFunction(x);
        assertThat(actual).as("Calculation method is incorrect").isCloseTo(expected, Percentage.withPercentage(0.1));
    }

    @Test(dataProvider = "stepsCountParam", dataProviderClass = StaticDataProvider.class)
    public void testStepsCount(double xMin, double xMax, double step, int expected) {
        int actual = main.stepsCount(xMin, xMax, step);
        assertThat(actual)
                .as("The amount of steps incorrect")
                .isEqualTo(expected);
    }

    @Test(dataProvider = "arrayForXParam", dataProviderClass = StaticDataProvider.class)
    public void testCreateArrayForX(double start, double end, double step, int index, double expected) {
        double[] actual = main.createArrayForX(start, end, step);
        assertThat(actual[index]).isCloseTo(expected, Percentage.withPercentage(0.1));
    }

    @Test(dataProvider = "arrayForYParam", dataProviderClass = StaticDataProvider.class)
    public void testArrayForY(double start, double end, double step, int index, double expected) {
        double[] actual = main.createArrayForY(start, end, step);
        assertThat(actual[index]).isCloseTo(expected, Percentage.withPercentage(0.1));
    }

    @Test
    public void testIndexOfMaxElement() {
        double[] array = {0.0, 1.56, 2.7, -0.3};
        int expected = 3;
        int actual= main.indexOfMaxElement(array);
        assertEquals(actual, expected, "Index of max element is not correct");
    }

    @Test
    public void testIndexOfMinElement() {
        double[] array = {0.0, 1.56, 2.7, -0.3};
        int expected = 4;
        int actual= main.indexOfMinElement(array);
        assertEquals(actual, expected, "Index of min element is not correct");
    }

    @Test
    public void testSumOfElementsOfArray() {
        double[] array = {0.0000, 1.5600, 2.7000, -0.3000};
        double expected = 3.96;
        double actual= main.sumOfElementsOfArray(array);
        assertThat(actual).isCloseTo(expected, Percentage.withPercentage(0.1));
    }

    @Test
    public void testAvgOfElementsOfArray() {
        double[] array = {0.0000, 1.5600, 2.7000, -0.3000};
        double expected = 0.99;
        double actual= main.avgOfElementsOfArray(array);
        assertThat(actual).isCloseTo(expected, Percentage.withPercentage(0.1));
    }
}