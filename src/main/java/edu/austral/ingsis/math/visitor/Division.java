package edu.austral.ingsis.math.visitor;


class Division implements Function {

  private final Function dividend;
  private final Function divisor;

  public Division(Function dividend, Function divisor){
    this.dividend = dividend;
    this.divisor = divisor;
  }


  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }

  public Function getDividend(){
    return dividend;
  }

  public Function getDivisor(){
    return divisor;
  }
}
