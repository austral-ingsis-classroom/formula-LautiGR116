package edu.austral.ingsis.math.visitor;

record Modulus(Function value) implements Function {

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
