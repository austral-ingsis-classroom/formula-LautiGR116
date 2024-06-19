package edu.austral.ingsis.math.visitor;

record Variable(String identifier) implements Function {

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}