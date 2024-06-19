package edu.austral.ingsis.math.composite;

import java.util.Map;
import java.util.Set;

class Negation implements Function {
  private final Function value;

  public Negation(Function value) {
    this.value = value;
  }

  // Public functions
  @Override
  public double compute(Map<String, Function> variables) {
    return getNegation(variables);
  }

  @Override
  public String print() {
    return getFormattedNegation();
  }

  @Override
  public Set<String> getVariables() {
    return getNegationVariables();
  }

  // Private functions
  private double getNegation(Map<String, Function> variables) {
    return -value.compute(variables);
  }

  private String getFormattedNegation() {
    return "-" + value.print();
  }

  private Set<String> getNegationVariables() {
    return value.getVariables();
  }
}
