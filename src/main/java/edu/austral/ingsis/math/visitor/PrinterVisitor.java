package edu.austral.ingsis.math.visitor;

class PrinterVisitor implements Visitor<String>{

  //Public functions
  public String print(Function function){
    return function.accept(this);
  }

  @Override
  public String visit(Modulus modulus) {
    return "|" + modulus.value().accept(this) + "|";
  }

  @Override
  public String visit(Sum sum) {
    return "(" + sum.firstAddend().accept(this) + " + " + sum.secondAddend().accept(this) + ")";
  }

  @Override
  public String visit(Division division) {
    return "(" + division.dividend().accept(this) + " / " + division.divisor().accept(this) + ")";
  }

  @Override
  public String visit(Multiplication multiplication) {
    return "(" + multiplication.firstFactor().accept(this) + " * " + multiplication.secondFactor().accept(this) + ")";
  }

  @Override
  public String visit(Negation negation) {
    return "-" + negation.value().accept(this);
  }

  @Override
  public String visit(Power power) {
    return "(" + power.base().accept(this) + " ^ " + power.exponent().accept(this) + ")";
  }

  @Override
  public String visit(SquareRoot squareRoot) {
    return "sqrt(" + squareRoot.radicand().accept(this) + ")";
  }

  @Override
  public String visit(Substraction substraction) {
    return "(" + substraction.minuend().accept(this) + " - " + substraction.subtrahend().accept(this) + ")";
  }

  @Override
  public String visit(Value value) {
    return formattedValue(value.value());
  }

  @Override
  public String visit(Variable variable) {
    return variable.identifier();
  }

  //Private functions
  private String formattedValue(double value){
    if(value % 1 == 0){
      return String.valueOf((int) value);
    }
    return String.valueOf(value);
  }
}
