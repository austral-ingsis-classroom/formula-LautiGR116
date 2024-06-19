package edu.austral.ingsis.math.composite;

import java.util.Map;
import java.util.Set;

class SquareRoot implements Function {

  private final Function radicand;

  public SquareRoot(Function radicand) {
    this.radicand = radicand;
  }

  // Public functions
  @Override
  public double compute(Map<String, Function> variables) {
    return getSquareRoot(variables);
  }

  @Override
  public String print() {
    return getFormattedSquareRoot();
  }

  @Override
  public Set<String> getVariables() {
    return getSquareRootVariables();
  }

  // Private functions
  private double getSquareRoot(Map<String, Function> variables) {
    return Math.sqrt(radicand.compute(variables));
  }

  private String getFormattedSquareRoot() {
    return "√(" + radicand.print() + ")";
  }

  private Set<String> getSquareRootVariables() {
    return radicand.getVariables();
  }
}
