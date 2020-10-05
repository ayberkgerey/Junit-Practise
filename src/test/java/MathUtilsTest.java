import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//You cant declare methods as private.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathUtilsTest {

    private MathUtils mathUtils;

    //runs even before instances are created. !!! It has to be static !!!
    @BeforeAll
      static void beforeAllInit(){
        System.out.println("This needs to run before all");
    }

    //runs before all methods
    @BeforeEach
    void init(){
        System.out.println("New instance created");
        mathUtils = new MathUtils();
    }

    //runs after all methods
    @AfterEach
    void cleanup(){
        System.out.println("Cleaning up...");
    }

    @Test
    @DisplayName("Testing add method")
    void testAddition(){
        int expected= 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expected,actual); //also there are assertArrayEquals() and assertIterableEquals() , assertFalse()
    }

    @Test
    void testDecreasing(){
        assertEquals(5,mathUtils.decrease(7,2),"Decreasing test");
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testComputeCircleRadius(){
        assertEquals(314.1592653589793,mathUtils.computeCircleArea(10),"Should return circle area");
    }

    //AssertThrows
    @Test
    void testDivision(){
        boolean isServerUp = false;

        assumeTrue(isServerUp);
        assertThrows(ArithmeticException.class , () -> mathUtils.divide(1,0),"Divide by zero should throw");
    }

    @DisplayName("It wont run.")
    @Disabled
    @Test
    void testDisabled(){
        fail("this test should be disabled");
    }



}
