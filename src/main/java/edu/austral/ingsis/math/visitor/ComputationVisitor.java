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
    return Math.abs(modulus.value().accept(this));
  }

  @Override
  public Double visit(Sum sum) {
    return sum.firstAddend().accept(this) + sum.secondAddend().accept(this);
  }

  @Override
  public Double visit(Division division) {
    return division.dividend().accept(this) / division.divisor().accept(this);
  }

  @Override
  public Double visit(Multiplication multiplication) {
    return multiplication.firstFactor().accept(this) * multiplication.secondFactor().accept(this);
  }

  @Override
  public Double visit(Negation negation) {
    return -negation.value().accept(this);
  }

  @Override
  public Double visit(Power power) {
    return Math.pow(power.base().accept(this), power.exponent().accept(this));
  }

  @Override
  public Double visit(SquareRoot squareRoot) {
    return Math.sqrt(squareRoot.radicand().accept(this));
  }

  @Override
  public Double visit(Substraction substraction) {
    return substraction.minuend().accept(this) - substraction.subtrahend().accept(this);
  }

  @Override
  public Double visit(Value value) {
    return value.value();
  }

  @Override
  public Double visit(Variable variable) {
    return variables.get(variable.identifier()).accept(this);
  }
}
