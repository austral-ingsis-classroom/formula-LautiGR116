package edu.austral.ingsis.math.composite;

import java.util.*;

class Multiplication implements Function{

  private final Function firstFactor;
  private final Function secondFactor;

  Multiplication(Function firstFactor, Function secondFactor){
    this.firstFactor = firstFactor;
    this.secondFactor = secondFactor;
  }

  //Public functions
  @Override
  public double compute(Map<String, Function> variables) {
    return getProduct(variables);
  }

  @Override
  public String print() {
    return getFormattedMultiplication();
  }

  @Override
  public Set<String> getVariables() {
    return getMultiplicationVariables();
  }

  //Private functions
  private double getProduct(Map<String, Function> variables) {
    return firstFactor.compute(variables) * secondFactor.compute(variables);
  }

  private String getFormattedMultiplication() {
    return "(" + firstFactor.print() + " * " + secondFactor.print() + ")";
  }

  private HashSet<String> getMultiplicationVariables() {
    Set<String> firstFactorVariables = firstFactor.getVariables();
    Set<String> secondFactorVariables = secondFactor.getVariables();
    return new HashSet<>(firstFactorVariables) {{
      addAll(secondFactorVariables);
    }};
  }
}
