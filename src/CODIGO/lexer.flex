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

Letra = [a-zA-Z]
Digito = [0-9]
Comilla = [']
Gato = [#]
Ampersand = [&]
Agrupacion = [()<>{}]
Punto = [.]
Coma = [,]
Simbolo = [ .,=()<>#{}+-;:&]
Asignacion = [=]
Delimitador = [;]
Operador = [+-]

Sumar = [S][u][m][a][r]
Restar = [R][e][s][t][a][r]
Multiplicar = [M][u][l][t][i][p][l][i][c][a][r] 
Dividir = [D][i][v][i][d][i][r]
Mostrar = [M][o][s][t][r][a][r]

Entero = [E][n][t][e][r][o]
Decimal = [D][e][c][i][m][a][l]
Resultado = [R][e][s][u][l][t][a][d][o]
Cadena = [C][a][d][e][n][a]
Figura = [F][i][g][u][r][a]
Color = [C][o][l][o][r]

Rojo = [R][o][j][o]
Azul = [A][z][u][l]
Verde = [V][e][r][d][e]
Blanco = [B][l][a][n][c][o]
Negro = [N][e][g][r][o]

Cuadrado = [C][u][a][d][r][a][d][o]
Triangulo = [T][r][i][a][n][g][u][l][o]
Rectangulo = [R][e][c][t][a][n][g][u][l][o]
Rombo = [R][o][m][b][o]
Circulo = [C][i][r][c][u][l][o]

Metodo = [M][e][t][o][d][o]


Espacio = [ ]
Enter = [\n\r|\n|\r\t]

/* -------- COMPONENTES LEXICOS -------*/

/*Identificador*/

IdentificadorVariable = {Letra} ({Letra}|{Digito})*
IdentificadorCadena = {Comilla}({Letra}|{Digito}|{Simbolo})({Letra}|{Digito}|{Simbolo})*{Comilla}
IdentificadorResultado = {Gato}{Letra}({Letra}|{Digito})*
IdentificadorMetodo = {Ampersand}{Letra}({Letra}|{Digito})*

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

/*Separador*/

Separador = {Coma}

/*Palabras reservadas*/

Funcion1 = {Sumar}
Funcion2 = {Restar}
Funcion3 = {Dividir}
Funcion4 = {Multiplicar}
Funcion5 = {Mostrar}

Dato1 = {Entero}
Dato2 = {Decimal}
Dato3 = {Resultado}
Dato4 = {Cadena}
Dato5 = {Figura}
Dato6 = {Color}

Color1 = {Rojo}
Color2 = {Azul}
Color3 = {Verde}
Color4 = {Blanco}
Color5 = {Negro}

Figura1 = {Cuadrado}
Figura2 = {Triangulo}
Figura3 = {Rectangulo}
Figura4 = {Rombo}
Figura5 = {Circulo}

Metodo1 = {Metodo}


%%

{Espacio} {/*Ignorar*/}
{Enter} {/*Ignorar*/}

{Funcion1} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }
{Funcion2} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }
{Funcion3} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }
{Funcion4} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }
{Funcion5} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }

{Dato1} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }
{Dato2} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }
{Dato3} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }
{Dato4} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }
{Dato5} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }
{Dato6} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }

{Color1} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }
{Color2} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }
{Color3} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }
{Color4} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }
{Color5} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }

{Figura1} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }
{Figura2} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }
{Figura3} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }
{Figura4} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }
{Figura5} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }

{Metodo1} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }

{IdentificadorVariable} { return token(yytext(), "Identificador Variable", yyline, yycolumn); }
{IdentificadorCadena} { return token(yytext(), "Identificador Cadena", yyline, yycolumn); }
{IdentificadorResultado} { return token(yytext(), "Identificador Resultado", yyline, yycolumn); }
{IdentificadorMetodo} { return token(yytext(), "Identificador Metodo", yyline, yycolumn); }

{SignoDeAgrupacion} { return token(yytext(), "Signo De Agrupacion", yyline, yycolumn); }

{NumeroEntero} { return token(yytext(), "Numero Entero", yyline, yycolumn); }
{NumeroDecimal} { return token(yytext(), "Numero Decimal", yyline, yycolumn); }

{OperadorDeAsignacion} { return token(yytext(), "Operador De Asignacion", yyline, yycolumn); }

{SignoDelimitadorDeSentencia} { return token(yytext(), "Signo Delimitador De Sentencia", yyline, yycolumn); }

{OperadorAritmetico} { return token(yytext(), "Operador Aritmetico", yyline, yycolumn); }

{Separador} { return token(yytext(), "Separador", yyline, yycolumn); }



. { return token(yytext(), "ERROR", yyline, yycolumn); }