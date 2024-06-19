package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;
import java.util.Set;

class Value implements Function {

  private final double value;

  public Value(double value){
    this.value = value;
  }

  @Override
  public double compute(Map<String, Function> variables) {
    return getValue();
  }

  @Override
  public String print() {
    return getFormattedValue();
  }

  @Override
  public Set<String> getVariables() {
    return getValueVariables();
  }

  //Private functions
  private double getValue() {
    return this.value;
  }
  private String getFormattedValue() {
    return this.formatValue();
  }

  private static Set<String> getValueVariables() {
    return Set.of();
  }

  private String formatValue(){
    if(value % 1 == 0){
      return String.valueOf((int) value);
    }
    return String.valueOf(value);
  }
}
