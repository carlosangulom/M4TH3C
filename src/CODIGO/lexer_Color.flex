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

{Color1} { return textColor(yychar, yylength(), new Color(255, 0, 0)); }
{Color2} { return textColor(yychar, yylength(), new Color(0, 0, 255)); }
{Color3} { return textColor(yychar, yylength(), new Color(0, 255, 0)); }
{Color4} { return textColor(yychar, yylength(), new Color(255, 255, 255)); }
{Color5} { return textColor(yychar, yylength(), new Color(0, 0, 0)); }
{PalabraReservada} { return textColor(yychar, yylength(), new Color(100, 0, 126)); }
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