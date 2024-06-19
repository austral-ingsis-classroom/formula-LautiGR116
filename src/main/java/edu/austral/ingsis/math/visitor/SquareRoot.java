package edu.austral.ingsis.math.visitor;

class SquareRoot implements Function {

  private final Function radicand;

  SquareRoot(Function radicand) {
    this.radicand = radicand;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }

  public Function getRadicand() {
    return radicand;
  }
}
