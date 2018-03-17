
grammar Calculadora;

expressao : <assoc=right> expressao '^' expressao   # opBin
          | expressao ('*'|'/') expressao           # opBin
          | expressao ('+'|'-') expressao           # opBin
          | INT                                     # inteiro
;

REAL : [0-9]* '.'[0-9]+;
INT: [1-9][0-9]*;
ID : [a-z][1-9]?;
WS: [ \t\r\n] -> skip;
