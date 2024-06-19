package edu.austral.ingsis.math.visitor;

record Substraction(Function minuend, Function subtrahend) implements Function {

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
