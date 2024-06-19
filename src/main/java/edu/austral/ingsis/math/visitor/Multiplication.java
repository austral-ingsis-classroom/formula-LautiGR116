package edu.austral.ingsis.math.visitor;

class Multiplication implements Function {

  private final Function firstFactor;
  private final Function secondFactor;

  Multiplication(Function firstFactor, Function secondFactor) {
    this.firstFactor = firstFactor;
    this.secondFactor = secondFactor;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }

  public Function getFirstFactor() {
    return firstFactor;
  }

  public Function getSecondFactor() {
    return secondFactor;
  }
}
