package edu.austral.ingsis.math.visitor;

record Value(double value) implements Function {

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
