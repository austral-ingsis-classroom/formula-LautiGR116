package edu.austral.ingsis.math.visitor;

import java.util.HashSet;
import java.util.Set;

class VariableGetterVisitor implements Visitor<Set<String>> {

  // Public functions
  public Set<String> getVariables(Function function) {
    return function.accept(this);
  }

  @Override
  public Set<String> visit(Modulus modulus) {
    return modulus.getValue().accept(this);
  }

  @Override
  public Set<String> visit(Sum sum) {
    return joinSets(sum.getFirstAddend(), sum.getSecondAddend());
  }

  @Override
  public Set<String> visit(Division division) {
    return joinSets(division.getDividend(), division.getDivisor());
  }

  @Override
  public Set<String> visit(Multiplication multiplication) {
    return joinSets(multiplication.getFirstFactor(), multiplication.getSecondFactor());
  }

  @Override
  public Set<String> visit(Negation negation) {
    return negation.getValue().accept(this);
  }

  @Override
  public Set<String> visit(Power power) {
    return joinSets(power.getBase(), power.getExponent());
  }

  @Override
  public Set<String> visit(SquareRoot squareRoot) {
    return squareRoot.getRadicand().accept(this);
  }

  @Override
  public Set<String> visit(Substraction substraction) {
    return joinSets(substraction.getMinuend(), substraction.getSubtrahend());
  }

  @Override
  public Set<String> visit(Value value) {
    return new HashSet<>();
  }

  @Override
  public Set<String> visit(Variable variable) {
    return Set.of(variable.getIdentifier());
  }

  // Private functions
  private Set<String> joinSets(Function left, Function right) {
    Set<String> leftVariables = left.accept(this);
    Set<String> rightVariables = right.accept(this);
    Set<String> variables = new HashSet<>();
    variables.addAll(leftVariables);
    variables.addAll(rightVariables);
    return variables;
  }
}
