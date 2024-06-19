package edu.austral.ingsis.math.visitor;

interface Function {
  <T> T accept(Visitor<T> visitor);
}
