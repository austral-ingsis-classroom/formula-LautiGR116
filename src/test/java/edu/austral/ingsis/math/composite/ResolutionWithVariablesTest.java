package edu.austral.ingsis.math.composite;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

  /**
   * Case 1 + x where x = 3
   */
  @Test
  public void shouldResolveFunction1() {
    final Double result = new Sum(new Value(1), new Variable("x")).compute(Map.of("x", new Value(3)));

    assertThat(result, equalTo(4d));
  }

  /**
   * Case 12 / div where div = 4
   */
  @Test
  public void shouldResolveFunction2() {
    final Double result = new Division(new Value(12), new Variable("div")).compute(Map.of("div", new Value(4)));

    assertThat(result, equalTo(3d));
  }

  /**
   * Case (9 / x) * y where x = 3 and y = 4
   */
  @Test
  public void shouldResolveFunction3() {
    final Double result = new Multiplication(new Division(new Value(9), new Variable("x")), new Variable("y")).compute(Map.of("x", new Value(3), "y", new Value(4)));

    assertThat(result, equalTo(12d));
  }

  /**
   * Case (27 / a) ^ b where a = 9 and b = 3
   */
  @Test
  public void shouldResolveFunction4() {
    final Double result = new Power(new Division(new Value(27), new Variable("a")), new Variable("b")).compute(Map.of("a", new Value(9), "b", new Value(3)));

    assertThat(result, equalTo(27d));
  }

  /**
   * Case z ^ (1/2) where z = 36
   */
  @Test
  public void shouldResolveFunction5() {
    final Double result = new Power(new Variable("z"), new Division(new Value(1), new Value(2))).compute(Map.of("z", new Value(36)));

    assertThat(result, equalTo(6d));
  }

  /**
   * Case |value| - 8 where value = 8
   */
  @Test
  public void shouldResolveFunction6() {
    final Double result = new Substraction(new Modulus(new Variable("value")), new Value(8)).compute(Map.of("value", new Value(8)));

    assertThat(result, equalTo(0d));
  }

  /**
   * Case |value| - 8 where value = 8
   */
  @Test
  public void shouldResolveFunction7() {
    final Double result = new Substraction(new Modulus(new Variable("value")), new Value(8)).compute(Map.of("value", new Value(8)));

    assertThat(result, equalTo(0d));
  }

  /**
   * Case (5 - i) * 8 where i = 2
   */
  @Test
  public void shouldResolveFunction8() {
    final Double result = new Multiplication(new Substraction(new Value(5), new Variable("i")), new Value(8)).compute(Map.of("i", new Value(2)));

    assertThat(result, equalTo(24d));
  }
}