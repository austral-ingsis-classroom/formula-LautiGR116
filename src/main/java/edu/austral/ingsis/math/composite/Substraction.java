package edu.austral.ingsis.math.composite;

import java.util.*;

class Substraction implements Function {
  private final Function minuend;
  private final Function substrahend;

  public Substraction(Function minuend, Function substrahend) {
    this.minuend = minuend;
    this.substrahend = substrahend;
  }

  // Public functions
  @Override
  public double compute(Map<String, Function> variables) {
    return getDifference(variables);
  }

  @Override
  public String print() {
    return getFormattedSubstraction();
  }

  @Override
  public Set<String> getVariables() {
    return getSubtractionVariables();
  }

  // Private functions
  private double getDifference(Map<String, Function> variables) {
    return minuend.compute(variables) - substrahend.compute(variables);
  }

  private String getFormattedSubstraction() {
    return "(" + minuend.print() + " - " + substrahend.print() + ")";
  }

  private HashSet<String> getSubtractionVariables() {
    Set<String> leftVariables = minuend.getVariables();
    Set<String> rightVariables = substrahend.getVariables();
    return new HashSet<>(leftVariables) {
      {
        addAll(rightVariables);
      }
    };
  }
}
