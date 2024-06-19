package edu.austral.ingsis.math.composite;

import java.util.Map;
import java.util.Set;

class Variable implements Function {

  private final String variable;

  public Variable(String variable){
    this.variable = variable;
  }

  //Public functions
  @Override
  public double compute(Map<String, Function> variables) {
    return getVariable(variables);
  }

  @Override
  public String print() {
    return variable;
  }

  @Override
  public Set<String> getVariables() {
    return getVariableVariables();
  }

  private double getVariable(Map<String, Function> variables) {
    return variables.get(variable).compute(variables);
  }

  private Set<String> getVariableVariables() {
    return Set.of(variable);
  }
}
