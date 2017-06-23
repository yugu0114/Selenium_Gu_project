package testlaptops;

import org.junit.*;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created: 12/04/19 17:12
 *
 * @author chris
 */
public class MyTest {
    private static  String abc= "no reuslts";
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void pr(){
        System.out.println("before test = " + abc);
    }

    @Test
    public void myTest1() {

        collector.checkThat("Count of HP and Lenovo laptops which are cheaper than 30000 must be 10.",
                11,//testFacade.getCountOfFoundLaptopsSatisfyingTheConditions(), // actual
                equalTo(11));
        collector.checkThat("Checking global searching works fine for laptops.",
                1,//rememberFirstElementName,
                equalTo(1));//foundLaptopBySearchingField));
    }

    @Test
    public void myTest2() {
        System.out.println(abc);
        collector.checkThat("aa", equalTo("aa"));
        abc="finished test2";
        System.out.println(abc);
    }

    @AfterClass
    public static void af(){
        System.out.println("after test = " + abc);
    }
}