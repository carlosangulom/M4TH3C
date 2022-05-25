import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}

/*Variables*/

Espacio = [ ]
Letra = [a-zA-Z]
Digito = [0-9]
Comilla = ["]
Gato = [#]
Ampersen = [&]
Agrupacion = [()<>{}]
Punto = [.]
Simbolo = [ .,=()<>#{}+-;:&]
Reservada1

/*Identificador*/

Identificador = {Letra} ({Letra}|{Digito})*
Identificador = {Comilla}({Letra}|{Digito}|{Simbolo})({Letra}|{Digito}|{Simbolo})*{Comilla}
Identificador = {Gato}{Letra}({Letra}|{Digito})*
Identificador = {Ampersen}{Letra}({Letra}|{Digito})*

/*Signo de agrupacion*/

Signo De Agrupacion = {Agrupacion}

/*Numero*/

Numero = {Digito}({Digito})*
Numero = {Digito}({Digito})*{Punto}{Digito}({Digito})* 

/*Operador de asignacion*/

Operador De Asinacion = {=}

/*Signo delimitador de sentencia*/

Signo Delimitador De Sentencia = {;}

/*Operador aritmetico*/

Operador Aritmetico = {+-}

/*Palabra reservada*/

/*Espacio en blanco*/

Palabra Reservada = ({Sumar}|{Restar}|{Multiplicar}|{Dividir}|{Entero}|{Decimal}|
                    {Resultado}|{Cadena}|{Figura}|{Color}|{Mostrar}|{Rojo}|{Azul}|
                    {Verde}|{Blanco}|{Negro}|{Cuadrado}|{Triangulo}|{Rectangulo}|
                    {Rombo}|{Metedo})

%%

{Espacio}{/*Ignorar*/}

. { return token(yytext(), "ERROR", yyline, yycolumn); }