package edu.austral.ingsis.math.composite;

import java.util.*;

class Division implements Function {

  private final Function dividend;
  private final Function divisor;

  public Division(Function dividend, Function divisor){
    this.dividend = dividend;
    this.divisor = divisor;
  }

  //Public functions
  @Override
  public double compute(Map<String, Function> variables) {
    return getQuotient(variables);
  }

  @Override
  public String print() {
    return getFormattedDivision();
  }

  @Override
  public Set<String> getVariables() {
    return getDivisionVariables();
  }

  //Private functions
  private double getQuotient(Map<String, Function> variables) {
    return dividend.compute(variables) / divisor.compute(variables);
  }

  private String getFormattedDivision() {
    return "(" + dividend.print() + " / " + divisor.print() + ")";
  }

  private HashSet<String> getDivisionVariables() {
    Set<String> dividendVariables = dividend.getVariables();
    Set<String> divisorVariables = divisor.getVariables();
    return new HashSet<>(dividendVariables) {{
      addAll(divisorVariables);
    }};
  }
}