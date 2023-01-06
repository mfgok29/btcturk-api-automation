package btcturk.helpers;

import org.testng.annotations.DataProvider;

public class DataProviderHelper {

    @DataProvider(parallel = true)
    public static Object[][] invalidOrderId() {
        return new Object[][]{
                {0},
                {-1},
                {100}
        };
    }
}
