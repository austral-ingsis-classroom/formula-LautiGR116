package edu.austral.ingsis.math.composite;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Double result = new Sum(new Value(1), new Value(6)).compute(new HashMap<>());

    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Double result = new Division(new Value(12), new Value(2)).compute(new HashMap<>());

    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Double result =
        new Multiplication(new Division(new Value(9), new Value(2)), new Value(3))
            .compute(new HashMap<>());

    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Double result =
        new Power(new Division(new Value(27), new Value(6)), new Value(2)).compute(new HashMap<>());

    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final Double result =
        new Power(new Value(36), new Division(new Value(1), new Value(2))).compute(new HashMap<>());

    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Double result = new Modulus(new Value(136)).compute(new HashMap<>());

    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Double result = new Modulus(new Negation(new Value(136))).compute(new HashMap<>());

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Double result =
        new Multiplication(new Subtraction(new Value(5), new Value(5)), new Value(8))
            .compute(new HashMap<>());

    assertThat(result, equalTo(0d));
  }
}
