package edu.austral.ingsis.math.visitor;

class PrinterVisitor implements Visitor<String>{

  //Public functions
  public String print(Function function){
    return function.accept(this);
  }

  @Override
  public String visit(Modulus modulus) {
    return "|" + modulus.getValue().accept(this) + "|";
  }

  @Override
  public String visit(Sum sum) {
    return "(" + sum.getFirstAddend().accept(this) + " + " + sum.getSecondAddend().accept(this) + ")";
  }

  @Override
  public String visit(Division division) {
    return "(" + division.getDividend().accept(this) + " / " + division.getDivisor().accept(this) + ")";
  }

  @Override
  public String visit(Multiplication multiplication) {
    return "(" + multiplication.getFirstFactor().accept(this) + " * " + multiplication.getSecondFactor().accept(this) + ")";
  }

  @Override
  public String visit(Negation negation) {
    return "-" + negation.getValue().accept(this);
  }

  @Override
  public String visit(Power power) {
    return "(" + power.getBase().accept(this) + " ^ " + power.getExponent().accept(this) + ")";
  }

  @Override
  public String visit(SquareRoot squareRoot) {
    return "sqrt(" + squareRoot.getRadicand().accept(this) + ")";
  }

  @Override
  public String visit(Substraction substraction) {
    return "(" + substraction.getMinuend().accept(this) + " - " + substraction.getSubtrahend().accept(this) + ")";
  }

  @Override
  public String visit(Value value) {
    return formattedValue(value.getValue());
  }

  @Override
  public String visit(Variable variable) {
    return variable.getIdentifier();
  }

  //Private functions
  private String formattedValue(double value){
    if(value % 1 == 0){
      return String.valueOf((int) value);
    }
    return String.valueOf(value);
  }
}
