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
Comilla = [']
Gato = [#]
Ampersen = [&]
Agrupacion = [()<>{}]
Punto = [.]
Simbolo = [ .,=()<>#{}+-;:&]
Asignacion = [=]
Delimitador = [;]
Operador = [+-]
Sumar = [Sumar]
Restar = [Restar]
Multiplicar = [Multiplicar] 
Dividir = [Dividir]
Entero = [Entero]
Decimal = [Decimal]
Resultado = [Resultado]
Cadena = [Cadena]
Figura = [Figura]
Color = [Color]
Mostrar = [Mostrar]
Rojo = [Rojo]
Azul = [Azul]
Verde = [Verde]
Blanco = [Blanco]
Negro = [Negro]
Cuadrado = [Cuadrado]
Triangulo = [Triangulo]
Rectangulo = [Rectangulo]
Rombo = [Rombo]
Metedo = [Metodo]

/*Identificador*/

IdentificadorVariable = {Letra} ({Letra}|{Digito})*
IdentificadorCadena = {Comilla}({Letra}|{Digito}|{Simbolo})({Letra}|{Digito}|{Simbolo})*{Comilla}
IdentificadorResultado = {Gato}{Letra}({Letra}|{Digito})*
IdentificadorMetodo = {Ampersen}{Letra}({Letra}|{Digito})*

/*Signo de agrupacion*/

SignoDeAgrupacion = {Agrupacion}

/*Numero*/

NumeroEntero = {Digito}({Digito})*
NumeroDecimal = {Digito}({Digito})*{Punto}{Digito}({Digito})* 

/*Operador de asignacion*/

OperadorDeAsignacion = {Asignacion}

/*Signo delimitador de sentencia*/

SignoDelimitadorDeSentencia = {Delimitador}

/*Operador aritmetico*/

OperadorAritmetico = {Operador}

/*Palabra reservada*/

/*Espacio en blanco*/

PalabraReservada = ({Sumar}|{Restar}|{Multiplicar}|{Dividir}|{Entero}|{Decimal}|
                    {Resultado}|{Cadena}|{Figura}|{Color}|{Mostrar}|{Rojo}|{Azul}|
                    {Verde}|{Blanco}|{Negro}|{Cuadrado}|{Triangulo}|{Rectangulo}|
                    {Rombo}|{Metedo})

%%

{Espacio} {/*Ignorar*/}

{IdentificadorVariable} { return token(yytext(), "Identificador", yyline, yycolumn); }
{IdentificadorCadena} { return token(yytext(), "Identificador", yyline, yycolumn); }
{IdentificadorResultado} { return token(yytext(), "Identificador", yyline, yycolumn); }
{IdentificadorMetodo} { return token(yytext(), "Identificador", yyline, yycolumn); }
{SignoDeAgrupacion} { return token(yytext(), "Signo De Agrupacion", yyline, yycolumn); }
{NumeroEntero} { return token(yytext(), "Numero", yyline, yycolumn); }
{NumeroDecimal} { return token(yytext(), "Numero", yyline, yycolumn); }
{OperadorDeAsignacion} { return token(yytext(), "Operador De Asignacion", yyline, yycolumn); }
{SignoDelimitadorDeSentencia} { return token(yytext(), "Signo Delimitador De Sentencia", yyline, yycolumn); }
{OperadorAritmetico} { return token(yytext(), "Operador Aritmetico", yyline, yycolumn); }
{PalabraReservada} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }

. { return token(yytext(), "ERROR", yyline, yycolumn); }