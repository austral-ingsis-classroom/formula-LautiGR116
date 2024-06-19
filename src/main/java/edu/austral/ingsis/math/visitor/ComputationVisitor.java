package edu.austral.ingsis.math.visitor;

import java.util.Map;

public class ComputationVisitor implements Visitor<Double> {
  private final Map<String, Function> variables;

  //Public functions
  public ComputationVisitor(Map<String, Function> variables){
    this.variables = variables;
  }

  public ComputationVisitor() {
    this.variables = Map.of();
  }

  public ComputationVisitor setVariables(Map<String, Function> variables){
    return new ComputationVisitor(variables);
  }

  public Double compute(Function function){
    return function.accept(this);
  }

  @Override
  public Double visit(Modulus modulus) {
    return Math.abs(modulus.getValue().accept(this));
  }

  @Override
  public Double visit(Sum sum) {
    return sum.getFirstAddend().accept(this) + sum.getSecondAddend().accept(this);
  }

  @Override
  public Double visit(Division division) {
    return division.getDividend().accept(this) / division.getDivisor().accept(this);
  }

  @Override
  public Double visit(Multiplication multiplication) {
    return multiplication.getFirstFactor().accept(this) * multiplication.getSecondFactor().accept(this);
  }

  @Override
  public Double visit(Negation negation) {
    return -negation.getValue().accept(this);
  }

  @Override
  public Double visit(Power power) {
    return Math.pow(power.getBase().accept(this), power.getExponent().accept(this));
  }

  @Override
  public Double visit(SquareRoot squareRoot) {
    return Math.sqrt(squareRoot.getRadicand().accept(this));
  }

  @Override
  public Double visit(Substraction substraction) {
    return substraction.getMinuend().accept(this) - substraction.getSubtrahend().accept(this);
  }

  @Override
  public Double visit(Value value) {
    return value.getValue();
  }

  @Override
  public Double visit(Variable variable) {
    return variables.get(variable.getIdentifier()).accept(this);
  }
}
