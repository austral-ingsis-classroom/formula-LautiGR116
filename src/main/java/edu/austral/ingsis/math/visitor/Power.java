package edu.austral.ingsis.math.visitor;

record Power(Function base, Function exponent) implements Function {

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
