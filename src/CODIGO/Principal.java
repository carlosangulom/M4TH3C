/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CODIGO;

import INTERFAZ.*;
import java.io.File;
/**
 *
 * @author Carlos
 */
public class Principal {
    public static void main(String[] args) {
        //jflex.Main.generate(new File("src\\CODIGO\\lexer.flex"));
        Interfaz main = new Interfaz();
        main.setVisible(true);
    }
}
