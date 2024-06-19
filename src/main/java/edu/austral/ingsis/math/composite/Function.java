package edu.austral.ingsis.math.composite;

import java.util.Map;
import java.util.Set;

interface Function {
  double compute(Map<String, Function> variables);

  String print();

  Set<String> getVariables();
}
