package edu.austral.ingsis.math.visitor;

class Modulus implements Function {

  private final Function value;

  Modulus(Function value){
    this.value = value;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }

  public Function getValue(){
    return value;
  }
}
