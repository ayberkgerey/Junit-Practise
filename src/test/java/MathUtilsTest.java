import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//You cant declare methods as private.
@DisplayName("When running MathUtils")
public class MathUtilsTest {

    private MathUtils mathUtils;

    //runs even before instances are created. !!! It has to be static !!!

    @Nested
    @DisplayName("addmethod")
    class Addtest {
        @Test
        @DisplayName("Testing add method positive")
        void testAdditionPositive(){
            int expected= 2;
            int actual = mathUtils.add(1,1);
            assertEquals(expected,actual); //also there are assertArrayEquals() and assertIterableEquals() , assertFalse()
        }

        @Test
        @DisplayName("Testing add method negative")
        void testAdditionNegative(){
            int expected= -2;
            int actual = mathUtils.add(-1,-1);
            assertEquals(expected,actual,() -> "expected: " + expected + "and return : " + actual); //also there are assertArrayEquals() and assertIterableEquals() , assertFalse()
        }
    }

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
    void testDecreasing(){
        assertEquals(5,mathUtils.decrease(7,2),"Decreasing test");
    }

    @RepeatedTest(3)
    @EnabledOnOs(OS.WINDOWS)
    void testComputeCircleRadius(RepetitionInfo repetitionInfo){
        // for ex repetitionInfo.getCurrentRepetition();

        assertEquals(314.1592653589793,mathUtils.computeCircleArea(10),"Should return circle area");
    }

    //AssertThrows
    @Test
    void testDivision(){
        boolean isServerUp = false;

        assumeFalse(isServerUp);
        assertThrows(ArithmeticException.class , () -> mathUtils.divide(1,0),"Divide by zero should throw");
    }

    @Test
    @DisplayName("multiply method")
    void testMultiply(){
        assertAll(
                () -> assertEquals(4,mathUtils.mupltiply(2,2),"Multiply test 1"),
                () -> assertEquals(16,mathUtils.mupltiply(4,4),"Multiply test 2"),
                () -> assertEquals(-2,mathUtils.mupltiply(2,-1),"Multiply test 3")
        );
    }

    @DisplayName("It wont run.")
    @Disabled
    @Test
    void testDisabled(){
        fail("this test should be disabled");
    }
}


