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
Comilla = ["]
Gato = [#]
Ampersen = [&]
Agrupacion = [()<>{}]
Punto = [.]
Simbolo = [ .,=()<>#{}+-;:&]
Reservada1

/*Identificador*/

Identificador Variable = {Letra} ({Letra}|{Digito})*
Identificador Cadena = {Comilla}({Letra}|{Digito}|{Simbolo})({Letra}|{Digito}|{Simbolo})*{Comilla}
Identificador Resultado = {Gato}{Letra}({Letra}|{Digito})*
Identificador Metodo = {Ampersen}{Letra}({Letra}|{Digito})*

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

Palabra Reservada = ({Sumar}|{Restar}|{Multiplicar}|{Dividir}|{Entero}|{Decimal}|
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
{Palabra Reservada} { return textColor(yychar, yylength(), new Color(100, 0, 126)); }
{Identificador Cadena} { return textColor(yychar, yylength(), new Color(255, 50, 233)); }

. { /*Ignorar*/ }