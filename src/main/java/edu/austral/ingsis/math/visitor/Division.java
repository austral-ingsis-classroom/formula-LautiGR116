package edu.austral.ingsis.math.visitor;

record Division(Function dividend, Function divisor) implements Function {

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
