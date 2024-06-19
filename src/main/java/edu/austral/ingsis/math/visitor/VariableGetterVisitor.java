package edu.austral.ingsis.math.visitor;

import java.util.HashSet;
import java.util.Set;

class VariableGetterVisitor implements Visitor<Set<String>>{

  //Public functions
  public Set<String> getVariables(Function function){
    return function.accept(this);
  }

  @Override
  public Set<String> visit(Modulus modulus) {
    return modulus.value().accept(this);
  }

  @Override
  public Set<String> visit(Sum sum) {
    return joinSets(sum.firstAddend(), sum.secondAddend());
  }

  @Override
  public Set<String> visit(Division division) {
    return joinSets(division.dividend(), division.divisor());
  }

  @Override
  public Set<String> visit(Multiplication multiplication) {
    return joinSets(multiplication.firstFactor(), multiplication.secondFactor());
  }

  @Override
  public Set<String> visit(Negation negation) {
    return negation.value().accept(this);
  }

  @Override
  public Set<String> visit(Power power) {
    return joinSets(power.base(), power.exponent());
  }

  @Override
  public Set<String> visit(SquareRoot squareRoot) {
    return squareRoot.radicand().accept(this);
  }

  @Override
  public Set<String> visit(Substraction substraction) {
    return joinSets(substraction.minuend(), substraction.subtrahend());
  }

  @Override
  public Set<String> visit(Value value) {
    return new HashSet<>();
  }

  @Override
  public Set<String> visit(Variable variable) {
    return Set.of(variable.identifier());
  }

  //Private functions
  private Set<String> joinSets(Function left, Function right) {
    Set<String> leftVariables = left.accept(this);
    Set<String> rightVariables = right.accept(this);
    Set<String> variables = new HashSet<>();
    variables.addAll(leftVariables);
    variables.addAll(rightVariables);
    return variables;
  }
}
