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
Enter = [\n\r|\n|\r]

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

PalabraReservada = ({Sumar}|{Restar}|{Multiplicar}|{Dividir}|{Entero}|{Decimal}|
                    {Resultado}|{Cadena}|{Figura}|{Color}|{Mostrar}|
                    {Cuadrado}|{Triangulo}|{Rectangulo}|
                    {Rombo}|{Metedo})

Color1 = {Rojo}
Color2 = {Azul}
Color3 = {Verde}
Color4 = {Blanco}
Color5 = {Negro}

%%
{Enter} {/*Ignorar*/}
{Espacio} {/*Ignorar*/}
{Color1} { return textColor(yychar, yylength(), new Color(255, 0, 0)); }
{Color2} { return textColor(yychar, yylength(), new Color(0, 0, 255)); }
{Color3} { return textColor(yychar, yylength(), new Color(0, 255, 0)); }
{Color4} { return textColor(yychar, yylength(), new Color(255, 255, 210)); }
{Color5} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }
{Sumar} { return textColor(yychar, yylength(), new Color(182, 50, 159)); }
{IdentificadorCadena} { return textColor(yychar, yylength(), new Color(255, 50, 233)); }
{IdentificadorVariable} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }
{IdentificadorResultado} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }
{IdentificadorMetodo} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }
{SignoDeAgrupacion} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }
{NumeroEntero} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }
{NumeroDecimal} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }
{OperadorDeAsignacion} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }
{SignoDelimitadorDeSentencia} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }
{OperadorAritmetico} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }

. { /*Ignorar*/ }