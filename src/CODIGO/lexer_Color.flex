import compilerTools.TextColor;
import java.awt.Color;

%%

%class LexerColor
%type TextColor
%char
%{
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int) start, size, color);
    }
%}

/*Variables*/

Letra = [a-zA-Z]
Digito = [0-9]
Comilla = [']
Gato = [#]
Ampersen = [&]
Agrupacion = [()<>{}]
Punto = [.]
Coma = [,]
Simbolo = [ .,=()<>#{}+-;:&]
Asignacion = [=]
Delimitador = [;]
OperadorMas = [+]
OperadorMenos = [-]


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
Enter = [\n\r|\n|\r]

/* -------- COMPONENTES LEXICOS -------*/

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

OperadorAritmeticoPositivo = {OperadorMas}
OperadorAritmeticoNegativo = {OperadorMenos}

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

{Enter} {/*Ignorar*/}
{Espacio} {/*Ignorar*/}

{Color1} { return textColor(yychar, yylength(), new Color(255, 0, 0)); }
{Color2} { return textColor(yychar, yylength(), new Color(0, 0, 255)); }
{Color3} { return textColor(yychar, yylength(), new Color(0, 255, 0)); }
{Color4} { return textColor(yychar, yylength(), new Color(255, 255, 210)); }
{Color5} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

{Funcion1} { return textColor(yychar, yylength(), new Color(182, 50, 159)); }
{Funcion2} { return textColor(yychar, yylength(), new Color(182, 50, 159)); }
{Funcion3} { return textColor(yychar, yylength(), new Color(182, 50, 159)); }
{Funcion4} { return textColor(yychar, yylength(), new Color(182, 50, 159)); }
{Funcion5} { return textColor(yychar, yylength(), new Color(182, 50, 159)); }

{Dato1} { return textColor(yychar, yylength(), new Color(221, 200, 25)); }
{Dato2} { return textColor(yychar, yylength(), new Color(221, 200, 25)); }
{Dato3} { return textColor(yychar, yylength(), new Color(221, 200, 25)); }
{Dato4} { return textColor(yychar, yylength(), new Color(221, 200, 25)); }
{Dato5} { return textColor(yychar, yylength(), new Color(221, 200, 25)); }
{Dato6} { return textColor(yychar, yylength(), new Color(221, 200, 25)); }

{Figura1} { return textColor(yychar, yylength(), new Color(72, 224, 219)); }
{Figura2} { return textColor(yychar, yylength(), new Color(72, 224, 219)); }
{Figura3} { return textColor(yychar, yylength(), new Color(72, 224, 219)); }
{Figura4} { return textColor(yychar, yylength(), new Color(72, 224, 219)); }
{Figura5} { return textColor(yychar, yylength(), new Color(72, 224, 219)); }

{Metodo1} { return textColor(yychar, yylength(), new Color(182, 50, 159)); }

{IdentificadorCadena} { return textColor(yychar, yylength(), new Color(255, 50, 233)); }
{IdentificadorVariable} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }
{IdentificadorResultado} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }
{IdentificadorMetodo} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

{SignoDeAgrupacion} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

{NumeroEntero} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }
{NumeroDecimal} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

{OperadorDeAsignacion} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

{SignoDelimitadorDeSentencia} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

{OperadorAritmeticoPositivo} { return textColor(yychar, yylength(), new Color(255, 0, 0)); }
{OperadorAritmeticoNegativo} { return textColor(yychar, yylength(), new Color(0, 0, 255)); }

{Separador} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

. { /*Ignorar*/ }