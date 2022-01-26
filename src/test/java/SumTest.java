import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class SumTest {

    String[] data1 = new String[]{" ", " "};
    String[] data2 = new String[]{"2", ""};
    String[] data3= new String[]{"2", "2", "2"};
    String[] data4= new String[]{"2", "1"};
    String[] data5= new String[]{"-2147483648", "-1"};
    String[] data6= new String[]{"2147483647", "1"};
    String[] data7= new String[]{"100", "-100"};
    String[] data8= new String[]{"0", "0"};
    String[] data9= new String[]{"-27", "-13"};
    String[] data10= new String[]{"-2", "-2"};
    String[] data11= new String[]{"2", "2"};
    String[] data12= new String[]{"1081", "256"};
    String[] data13= new String[]{"-2147483648", "0"};
    String[] data14= new String[]{"0.5","0.5"};

    @DataProvider(name = "sumDataProvider")
    Object[][] sumDataProvider() {

        return new Object[][]{
                {data1, 0},
                {data2, 0},
                {data3, 0},
                {data4, 3},
                {data5, 0},
                {data6, 0},
                {data7, 0},
                {data8, 0},
                {data9, -40},
                {data10, -4},
                {data11, 4},
                {data12, 1337},
                {data13, -2147483648},
                {data14, 0},
        };
    }

    @Test(dataProvider = "sumDataProvider", alwaysRun = true)
    public void TestSum(String[] args, Integer expected) {
        SumTwoNumbers sum = new SumTwoNumbers(args);
        int result = 0;
        try {
            sum.verifyNumberOfArguments();
            sum.parseArgumentsToInt();
            result = sum.addTwoNumbers();
        } catch (Exception e) {
        } finally {
            assertEquals(result, expected, Arrays.toString(args));
        }
    }

}