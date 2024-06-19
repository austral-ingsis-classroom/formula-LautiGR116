package edu.austral.ingsis.math.visitor;

record Multiplication(Function firstFactor, Function secondFactor) implements Function {

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
