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

CaracterNoValido = [!¡¿?"$"%_"-""*""/""|"]
SimboloError = [.,=()<>#{}+-;:&]
SimboloError2 = [,=()<>#{}+-;:&]
Espacio2 = [ ]

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


Espacio = [\n\r|\n|\r\t|\n\t|\r|\t|\n\r\t| \t\f| ]

/* -------- COMPONENTES LEXICOS -------*/

/*Identificador*/

IdentificadorVariable = {Letra} ({Letra}|{Digito})*
IdentificadorCadena = {Comilla}({Letra}|{Digito})({Letra}|{Digito}|{Simbolo})*{Comilla}
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

/*ERRORES*/

Error0 = {CaracterNoValido}

Error1 = ({Digito}|{SimboloError}|{CaracterNoValido}){Letra} ({Letra}|{Digito})*

Error2 = ({Letra}(({SimboloError}|{CaracterNoValido})({Letra}|{Digito})*)(({SimboloError}|{CaracterNoValido})({Letra}|{Digito})*)*)|
         ({Letra}(({Letra}|{Digito})*({SimboloError}|{CaracterNoValido}))(({Letra}|{Digito})*({SimboloError}|{CaracterNoValido}))*)|
         ({Letra}(({SimboloError}|{CaracterNoValido})({SimboloError}|{CaracterNoValido})*({Letra}|{Digito})*)(({SimboloError}|{CaracterNoValido})({SimboloError}|{CaracterNoValido})*({Letra}|{Digito})*)*)|
         ({Letra}(({Letra}|{Digito})*({SimboloError}|{CaracterNoValido})({SimboloError}|{CaracterNoValido})*)(({Letra}|{Digito})*({SimboloError}|{CaracterNoValido})({SimboloError}|{CaracterNoValido})*)*)

Error3 = {Comilla}({SimboloError}|{CaracterNoValido})({Letra}|{Digito}|{Simbolo}|{CaracterNoValido})*{Comilla}

Error4 = {Comilla}{Espacio2}{Espacio2}*{Comilla}

Error5 = ({Letra}|{Digito})({Letra}|{Digito}|{Simbolo})*{Comilla}|{Comilla}({Letra}|{Digito})({Letra}|{Digito}|{Simbolo})*

Error6 = ({Gato}(({SimboloError}|{CaracterNoValido})({Letra}|{Digito})*)(({SimboloError}|{CaracterNoValido})({Letra}|{Digito})*)*)|
         ({Gato}(({Letra}|{Digito})*({SimboloError}|{CaracterNoValido}))(({Letra}|{Digito})*({SimboloError}|{CaracterNoValido}))*)|
         ({Gato}(({SimboloError}|{CaracterNoValido})({SimboloError}|{CaracterNoValido})*({Letra}|{Digito})*)(({SimboloError}|{CaracterNoValido})({SimboloError}|{CaracterNoValido})*({Letra}|{Digito})*)*)|
         ({Gato}(({Letra}|{Digito})*({SimboloError}|{CaracterNoValido})({SimboloError}|{CaracterNoValido})*)(({Letra}|{Digito})*({SimboloError}|{CaracterNoValido})({SimboloError}|{CaracterNoValido})*)*)

Error7 = {Gato}

Error8 = ({Ampersand}(({SimboloError}|{CaracterNoValido})({Letra}|{Digito})*)(({SimboloError}|{CaracterNoValido})({Letra}|{Digito})*)*)|
         ({Ampersand}(({Letra}|{Digito})*({SimboloError}|{CaracterNoValido}))(({Letra}|{Digito})*({SimboloError}|{CaracterNoValido}))*)|
         ({Ampersand}(({SimboloError}|{CaracterNoValido})({SimboloError}|{CaracterNoValido})*({Letra}|{Digito})*)(({SimboloError}|{CaracterNoValido})({SimboloError}|{CaracterNoValido})*({Letra}|{Digito})*)*)|
         ({Ampersand}(({Letra}|{Digito})*({SimboloError}|{CaracterNoValido})({SimboloError}|{CaracterNoValido})*)(({Letra}|{Digito})*({SimboloError}|{CaracterNoValido})({SimboloError}|{CaracterNoValido})*)*)

Error9 = {Ampersand}

Error10 = {Digito}({Letra}|{CaracterNoValido}|{SimboloError2})({Letra}|{CaracterNoValido}|{SimboloError2})*|
         {Digito}({Digito})*{Punto}({Letra}|{CaracterNoValido}|{SimboloError2})({Letra}|{CaracterNoValido}|{SimboloError2})*|
         {Digito}({Digito})*({Letra}|{CaracterNoValido}|{SimboloError2})({Letra}|{CaracterNoValido}|{SimboloError2})*|
         {Digito}(({Digito})*({Letra}|{CaracterNoValido}|{SimboloError2})({Letra}|{CaracterNoValido}|{SimboloError2})*)(({Digito})*({Letra}|{CaracterNoValido}|{SimboloError2})({Letra}|{CaracterNoValido}|{SimboloError2})*)*|
         {Digito}({Digito})*{Punto}{Digito}({Digito})*({Letra}|{CaracterNoValido}|{SimboloError2})({Letra}|{CaracterNoValido}|{SimboloError2})*|
         {Digito}({Digito})*{Punto}{Digito}(({Digito})*({Letra}|{CaracterNoValido}|{SimboloError2})({Letra}|{CaracterNoValido}|{SimboloError2})*)(({Digito})*({Letra}|{CaracterNoValido}|{SimboloError2})({Letra}|{CaracterNoValido}|{SimboloError2})*)*|
         {Digito}({Digito})*({Letra}|{CaracterNoValido}|{SimboloError2})({Letra}|{CaracterNoValido}|{SimboloError2})*{Punto}{Digito}({Digito})*
         {Digito}(({Digito})*({Letra}|{CaracterNoValido}|{SimboloError2})({Letra}|{CaracterNoValido}|{SimboloError2})*)(({Digito})*({Letra}|{CaracterNoValido}|{SimboloError2})({Letra}|{CaracterNoValido}|{SimboloError2})*)*{Punto}{Digito}({Digito})*

Error11 = {Digito}({Digito})*{Punto}

Error12 = {Punto}{Digito}({Digito})*

Error13 = {Punto}({Digito}|{Punto})({Digito}|{Punto})*

Error14 = ({Letra}|{SimboloError}|{CaracterNoValido}){Digito}({Digito})*|
          ({Letra}|{SimboloError}|{CaracterNoValido}){Digito}({Digito})*{Punto}{Digito}({Digito})*
 
%%

{Espacio} {/*Ignorar*/}

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

{IdentificadorVariable} { return token(yytext(), "Identificador", yyline, yycolumn); }
{IdentificadorCadena} { return token(yytext(), "Identificador", yyline, yycolumn); }
{IdentificadorResultado} { return token(yytext(), "Identificador", yyline, yycolumn); }
{IdentificadorMetodo} { return token(yytext(), "Identificador", yyline, yycolumn); }

{SignoDeAgrupacion} { return token(yytext(), "Signo De Agrupacion", yyline, yycolumn); }

{NumeroEntero} { return token(yytext(), "Numero", yyline, yycolumn); }
{NumeroDecimal} { return token(yytext(), "Numero", yyline, yycolumn); }

{OperadorDeAsignacion} { return token(yytext(), "Operador De Asignacion", yyline, yycolumn); }

{SignoDelimitadorDeSentencia} { return token(yytext(), "Delimitador De Sentencia", yyline, yycolumn); }

{OperadorAritmetico} { return token(yytext(), "Operador Aritmetico", yyline, yycolumn); }

{Separador} { return token(yytext(), "Separador", yyline, yycolumn); }

{Error0} { return token(yytext(), "ERROR 0", yyline, yycolumn); }
{Error1} { return token(yytext(), "ERROR 1", yyline, yycolumn); }
{Error2} { return token(yytext(), "ERROR 2", yyline, yycolumn); }
{Error3} { return token(yytext(), "ERROR 3", yyline, yycolumn); }
{Error4} { return token(yytext(), "ERROR 4", yyline, yycolumn); }
{Error5} { return token(yytext(), "ERROR 5", yyline, yycolumn); }
{Error6} { return token(yytext(), "ERROR 6", yyline, yycolumn); }
{Error7} { return token(yytext(), "ERROR 7", yyline, yycolumn); }
{Error8} { return token(yytext(), "ERROR 8", yyline, yycolumn); }
{Error9} { return token(yytext(), "ERROR 9", yyline, yycolumn); }
{Error10} { return token(yytext(), "ERROR 10", yyline, yycolumn); }
{Error11} { return token(yytext(), "ERROR 11", yyline, yycolumn); }
{Error12} { return token(yytext(), "ERROR 12", yyline, yycolumn); }
{Error13} { return token(yytext(), "ERROR 14", yyline, yycolumn); }
{Error14} { return token(yytext(), "ERROR 15", yyline, yycolumn); }

. { return token(yytext(), "ERROR #", yyline, yycolumn); }