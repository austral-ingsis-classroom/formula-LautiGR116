package edu.austral.ingsis.math.visitor;

class Variable implements Function {

  private final String identifier;

  public Variable(String identifier) {
    this.identifier = identifier;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }

  public String getIdentifier() {
    return identifier;
  }
}
