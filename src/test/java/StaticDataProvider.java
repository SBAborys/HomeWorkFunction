import org.testng.annotations.DataProvider;

public class StaticDataProvider {
    @DataProvider(name = "functionParam")
    public static Object[][] createDataForCalculateFunction() {
        return new Object[][]{
                {0.000, 1.0},
                {1.000, 0.0},
                {2.000, -0.306183},
                {0.7, 1},
                {1.4, -0.329742},
                {3.0, -0.278564},
        };
    }

    @DataProvider(name = "stepsCountParam")
    public static Object[][] createDataForStepsCount() {
        return new Object[][]{
                {0.0, 3.0, 0.004, 751},
                {-2.0, 3.0, 0.004, 1251},
                {0.0, 3.0, 0.007, 429},
        };
    }

    @DataProvider(name = "arrayForXParam")
    public static Object[][] createDataForArrayForX() {
        return new Object[][]{
                {0.0, 3.0, 0.004, 175, 0.7},
                {0.0, 3.0, 0.004, 350, 1.4},
                {0.0, 3.0, 0.004, 750, 3.0},
        };
    }

    @DataProvider(name = "arrayForYParam")
    public static Object[][] createDataForArrayForY() {
        return new Object[][]{
                {0.0, 3.0, 0.004, 175, 1},
                {0.0, 3.0, 0.004, 350, -0.329742},
                {0.0, 3.0, 0.004, 750, -0.278564},
        };
    }
}
