package edu.austral.ingsis.math.composite;

import java.util.*;

class Power implements Function{

  private final Function base;
  private final Function exponent;

  public Power(Function base, Function exponent){
    this.base = base;
    this.exponent = exponent;
  }

  //Public functions
  @Override
  public double compute(Map<String, Function> variables) {
    return getPower(variables);
  }

  @Override
  public String print() {
    return getFormattedPower();
  }

  @Override
  public Set<String> getVariables() {
    return getPowerVariables();
  }

  //Private functions
  private double getPower(Map<String, Function> variables) {
    return Math.pow(base.compute(variables), exponent.compute(variables));
  }

  private String getFormattedPower() {
    return "(" + base.print() + " ^ " + exponent.print() + ")";
  }

  private HashSet<String> getPowerVariables() {
    Set<String> baseVariables = base.getVariables();
    Set<String> exponentVariables = exponent.getVariables();
    return new HashSet<>(baseVariables) {{
      addAll(exponentVariables);
    }};
  }
}