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
Sumar = [S][u][m][a][r]
Restar = [R][e][s][t][a][r]
Multiplicar = [M][u][l][t][i][p][l][i][c][a][r] 
Dividir = [D][i][v][i][d][i][r]
Entero = [E][n][t][e][r][o]
Decimal = [D][e][c][i][m][a][l]
Resultado = [R][e][s][u][l][t][a][d][o]
Cadena = [C][a][d][e][n][a]
Figura = [F][i][g][u][r][a]
Color = [C][o][l][o][r]
Mostrar = [M][o][s][t][r][a][r]
Rojo = [R][o][j][o]
Azul = [A][z][u][l]
Verde = [V][e][r][d][e]
Blanco = [B][l][a][n][c][o]
Negro = [N][e][g][r][o]
Cuadrado = [C][u][a][d][r][a][d][o]
Triangulo = [T][r][i][a][n][g][u][l][o]
Rectangulo = [R][e][c][t][a][n][g][u][l][o]
Rombo = [R][o][m][b][o]
Metedo = [M][e][t][o][d][o]
Enter = [\r|\n|\r\n]

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
{Enter} {/*Ignorar*/}
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
{Sumar} { return token(yytext(), "Palabra Reservada", yyline, yycolumn); }

. { return token(yytext(), "ERROR", yyline, yycolumn); }