grammar Whilelang;

programa: seqComando
;

seqComando: cmd (';' cmd)*
;

cmd: ID ':=' expr                                   # cmdAtribuicao
       | 'skip'                                     # cmdSkip
       | 'enquanto' exprBool 'faca' cmd             # cmdEnquanto
       | 'se' exprBool 'entao' cmd 'senao' cmd      # cmdSeSenao
       | 'exiba' TEXTO                              # exiba
       | 'escreva' expr                             # escreva
       | '{' seqComando '}'                         # cmdBloco
;

expr: INT                                           # inteiro
    | ID                                            # identificador
    | 'leia'                                        # leia
    | expr '*' expr                                 # opBin
    | expr '/' expr                                 # opBin
    | expr '^' expr                                 # opBin
    | expr '+' expr                                 # opBin
    | expr '-' expr                                 # opBin
    | '(' expr ')'                                  # exprPar
;

exprBool: ('verdadeiro' | 'falso')                  # booleano
        | expr '=' expr                             # opRel
        | expr '<=' expr                            # opRel
        | expr '>=' expr                            # opRel
        | expr '<>' expr                            # opRel
        | exprBool 'e' exprBool                     # eLogico
        | exprBool 'ou' exprBool                    # ouLogico
        | exprBool 'xor' exprBool                   # xorLogico
        | 'nao' exprBool                            # naoLogico
        | '(' exprBool ')'                          # booleanoPar
;

TEXTO: '"' .*? '"';

ID: [a-zA-Z]+;
INT: '-'?[0-9]+;

WS: [ \r\t\n] -> skip;
