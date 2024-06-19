package edu.austral.ingsis.math.composite;

import java.util.*;

class Sum implements Function{
  private final Function firstAddend;
  private final Function secondAddend;

  public Sum(Function firstAddend, Function secondAddend){
    this.firstAddend = firstAddend;
    this.secondAddend = secondAddend;
  }

  //Public functions
  @Override
  public double compute(Map<String, Function> variables) {
    return getSum(variables);
  }

  @Override
  public String print() {
    return getFormattedSum();
  }

  @Override
  public Set<String> getVariables() {
    return getSumVariables();
  }

  //Private functions
  private double getSum(Map<String, Function> variables) {
    return firstAddend.compute(variables) + secondAddend.compute(variables);
  }

  private String getFormattedSum() {
    return "(" + firstAddend.print() + " + " + secondAddend.print() + ")";
  }

  private HashSet<String> getSumVariables() {
    Set<String> firstAddendVariables = firstAddend.getVariables();
    Set<String> secondAddendVariables = secondAddend.getVariables();
    return new HashSet<>(firstAddendVariables) {{
      addAll(secondAddendVariables);
    }};
  }
}
