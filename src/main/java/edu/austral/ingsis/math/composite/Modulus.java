package edu.austral.ingsis.math.composite;

import java.util.Map;
import java.util.Set;

class Modulus implements Function {

  private final Function value;

  public Modulus(Function value) {
    this.value = value;
  }

  // Public functions
  @Override
  public double compute(Map<String, Function> variables) {
    return getModulus(variables);
  }

  @Override
  public String print() {
    return getFormattedModulus();
  }

  @Override
  public Set<String> getVariables() {
    return getModulusVariables();
  }

  // Private functions
  private double getModulus(Map<String, Function> variables) {
    return Math.abs(value.compute(variables));
  }

  private String getFormattedModulus() {
    return "|" + value.print() + "|";
  }

  private Set<String> getModulusVariables() {
    return value.getVariables();
  }
}
