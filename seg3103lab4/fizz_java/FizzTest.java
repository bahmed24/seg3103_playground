import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicTest {

  @Test
  void TestFizzBuzz() {
    Fizz fizz = new Fizz(4);
    String expectedResult = "1 2 Fizz Buzz";
    String actualResult = fizz.fizzBuzz();
    assertEquals(expectedResult, actualResult);
  }
