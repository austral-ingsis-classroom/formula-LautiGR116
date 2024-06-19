package edu.austral.ingsis.math.visitor;

interface Visitor<T> {
  T visit(Modulus modulus);
  T visit(Sum sum);
  T visit(Division division);
  T visit(Multiplication multiplication);
  T visit(Negation negation);
  T visit(Power power);
  T visit(SquareRoot squareRoot);
  T visit(Substraction substraction);
  T visit(Value value);
  T visit(Variable variable);
}
