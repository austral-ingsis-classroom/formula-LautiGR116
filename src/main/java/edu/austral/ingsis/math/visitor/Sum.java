package edu.austral.ingsis.math.visitor;

record Sum(Function firstAddend, Function secondAddend) implements Function {

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
