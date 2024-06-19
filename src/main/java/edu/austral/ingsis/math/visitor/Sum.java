package edu.austral.ingsis.math.visitor;

class Sum implements Function {
  private final Function firstAddend;
  private final Function secondAddend;

  Sum(Function firstAddend, Function secondAddend){
    this.firstAddend = firstAddend;
    this.secondAddend = secondAddend;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }

  public Function getFirstAddend(){
    return firstAddend;
  }

  public Function getSecondAddend(){
    return secondAddend;
  }
}
