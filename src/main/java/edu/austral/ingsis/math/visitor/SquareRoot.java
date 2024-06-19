package edu.austral.ingsis.math.visitor;

record SquareRoot(Function radicand) implements Function {

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
