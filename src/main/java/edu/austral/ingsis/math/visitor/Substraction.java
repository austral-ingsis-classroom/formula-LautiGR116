package edu.austral.ingsis.math.visitor;

class Substraction implements Function {
  private final Function minuend;
  private final Function subtrahend;

  Substraction(Function minuend, Function subtrahend) {
    this.minuend = minuend;
    this.subtrahend = subtrahend;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }

  public Function getMinuend() {
    return minuend;
  }

  public Function getSubtrahend() {
    return subtrahend;
  }
}
