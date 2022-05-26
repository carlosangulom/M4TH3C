/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package INTERFAZ;

import CODIGO.*;
import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author chuy4
 */
public class Interfaz extends javax.swing.JFrame {
    

    private String title;
    private ArrayList<Token> tokens;
    private String[] Errores;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;
    private Directory directorio;
    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("M4TH3C");
        this.setResizable(false);
        init();
    }
    
    private void init() {
        Functions.setLineNumberOnJTextComponent(PanelFuente);
        directorio = new Directory(this, PanelFuente, title, ".MTC");
        addWindowListener(new WindowAdapter() {// Cuando presiona la "X" de la esquina superior derecha
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, PanelFuente, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{"\n","Sumar('VARIABLES')<\n\n\t      'Variable Resultado'\n\n>;",
            "Restar('VARIABLES')<\n\n\t      'Variable Resultado'\n\n>;","Multiplicar('VARIABLES')<\n\n\t      'Variable Resultado'\n\n>;",
            "Dividir('VARIABLES')<\n\n\t      'Variable Resultado'\n\n>;","Entero 'Nombre Variable' = 'Valor';","Entero 'Nombre Variable';",
            "Decimal 'Nombre Variable' = 'Valor';","Decimal 'Nombre Variable';","Resultado 'Nombre Variable';",
            "Cadena 'Nombre Variable' = 'Valor';","Cadena 'Nombre Variable';","Figura 'Nombre Variable' = 'Valor';",
            "Figura 'Nombre Variable';","Color 'Nombre Variable' = 'Valor';","Color 'Nombre Variable';",
            "Mostrar(‘Variable Cadena’ , ‘Variable Resultado’ , ‘Variable Figura’ , ‘Variable Color’);","Mostrar(‘Variable Cadena’ , ‘Variable Resultado’ , "
                    + "‘Variable Figura 1’ , ‘Variable Color 1’, ‘Variable Figura 2’ , ‘Variable Color 2’, ‘Variable Figura 3’ , ‘Variable Color 3, ‘Variable Figura 4’ , "
                    + "‘Variable Color 4’, ‘Variable Figura 5’ , ‘Variable Color 5);","Metodo 'Nombre Metodo' {\n\n\t      'Funciones o Variables'\n\n}"}, PanelFuente, () -> {
            timerKeyReleased.restart();
        timerKeyReleased.start();
        });
    }
    
    private void clearFields(){
        Functions.clearDataInTable(Tokens);
        PanelSalida.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }
    
    private void colorAnalysis(){
         /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = PanelFuente.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        Functions.colorTextPane(textsColor, PanelFuente, new Color(40, 40, 40));
    }
    
    private void compilar(){
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        printConsole();
        mostrarerrores();
        codeHasBeenCompiled = true;
    }

    private void lexicalAnalysis(){
       
        try {
            // Extraer tokens
            Lexer lexer;
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = PanelFuente.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                    
                }
                tokens.add(token);   
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }
    
    private void syntacticAnalysis() {
        Grammar gramatica = new Grammar(tokens, errors);
        
        
        /* Mostrar gramáticas */
        gramatica.show();
    }
    
    private void fillTableTokens(){
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[Linea " + token.getLine() + ", Columna " + token.getColumn() + "]"};
            Functions.addRowDataInTable(Tokens, data);
        });
    }
    
    private void mostrarerrores(){
        String e = "COMPILACION TERMINADA...\n\n";
        PanelSalida.setText(e);
        tokens.forEach(token ->{
            if(token.getLexicalComp().equals("ERROR 0")){
                PanelSalida.append("----------> "+token.getLexicalComp()+": El caracter no pertenece al alfabeto, Linea ["+token.getLine()+"] Columna ["+token.getColumn()+"]\n");
            }else if(token.getLexicalComp().equals("ERROR 1")){
                PanelSalida.append("----------> "+token.getLexicalComp()+": La variable no inicia con una letra, Linea ["+token.getLine()+"] Columna ["+token.getColumn()+"]\n");
            }else if(token.getLexicalComp().equals("ERROR 2")){
                PanelSalida.append("----------> "+token.getLexicalComp()+": Un carácter del nombre de la variable no pertenece a un símbolo válido, Linea ["+token.getLine()+"] Columna ["+token.getColumn()+"]\n");
            }else if(token.getLexicalComp().equals("ERROR 3")){
                PanelSalida.append("----------> "+token.getLexicalComp()+": Un carácter de la cadena no pertenece a un símbolo válido, Linea ["+token.getLine()+"] Columna ["+token.getColumn()+"]\n");
            }else if(token.getLexicalComp().equals("ERROR 4")){
                PanelSalida.append("----------> "+token.getLexicalComp()+": No hay ningún elemento entre ‘ ’, Linea ["+token.getLine()+"] Columna ["+token.getColumn()+"]\n");
            }else if(token.getLexicalComp().equals("ERROR 5")){
                PanelSalida.append("----------> "+token.getLexicalComp()+": Falto una ‘ en la cadena, Linea ["+token.getLine()+"] Columna ["+token.getColumn()+"]\n");
            }else if(token.getLexicalComp().equals("ERROR 6")){
                PanelSalida.append("----------> "+token.getLexicalComp()+": Un carácter del nombre del resultado no pertenece a un símbolo válido, Linea ["+token.getLine()+"] Columna ["+token.getColumn()+"]\n");
            }else if(token.getLexicalComp().equals("ERROR 7")){
                PanelSalida.append("----------> "+token.getLexicalComp()+": No hay por lo menos una letra después de #, Linea ["+token.getLine()+"] Columna ["+token.getColumn()+"]\n");
            }else if(token.getLexicalComp().equals("ERROR 8")){
                PanelSalida.append("----------> "+token.getLexicalComp()+": Un carácter del nombre del método no pertenece a un símbolo válido, Linea ["+token.getLine()+"] Columna ["+token.getColumn()+"]\n");
            }else if(token.getLexicalComp().equals("ERROR 9")){
                PanelSalida.append("----------> "+token.getLexicalComp()+": No Hay por lo menos una letra después de &, Linea ["+token.getLine()+"] Columna ["+token.getColumn()+"]\n");
            }else if(token.getLexicalComp().equals("ERROR 10")){
                PanelSalida.append("----------> "+token.getLexicalComp()+": El número contiene un caracter no valido o cuenta con más de un punto, Linea ["+token.getLine()+"] Columna ["+token.getColumn()+"]\n");
            }else if(token.getLexicalComp().equals("ERROR 11")){
                PanelSalida.append("----------> "+token.getLexicalComp()+": No contiene un dígito como mínimo después del punto en el número , Linea ["+token.getLine()+"] Columna ["+token.getColumn()+"]\n");
            }else if(token.getLexicalComp().equals("ERROR 12")){
                PanelSalida.append("----------> "+token.getLexicalComp()+": El número inicia con punto decimal, Linea ["+token.getLine()+"] Columna ["+token.getColumn()+"]\n");
            }else if(token.getLexicalComp().equals("ERROR 13")){
                PanelSalida.append("----------> "+token.getLexicalComp()+": El número inicia con punto decimal y tiene más de uno, Linea ["+token.getLine()+"] Columna ["+token.getColumn()+"]\n");
            }else if(token.getLexicalComp().equals("ERROR 14")){
                PanelSalida.append("----------> "+token.getLexicalComp()+": El número no inicia con un dígito, Linea ["+token.getLine()+"] Columna ["+token.getColumn()+"]\n");
            }           
        });
    }
    
    private void printConsole(){
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            PanelSalida.setText("Compilación terminada...\n" + strErrors + "\nLa compilación terminó con errores...");
        } else {
            PanelSalida.setText("Compilación terminada...\n");
        }
        PanelSalida.setCaretPosition(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelFuente = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        PanelSalida = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tokens = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnmenuNuevo = new javax.swing.JMenuItem();
        btnmenuAbrir = new javax.swing.JMenuItem();
        btnmenuGuardar = new javax.swing.JMenuItem();
        btnmenuGuardarComo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        btnMenuLEATE = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        jToolBar1.setBackground(new java.awt.Color(0, 0, 0));
        jToolBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar1.setRollover(true);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Nuevo1-select.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Abrir select.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/guardar select.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/guardar como select.png"))); // NOI18N
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/analisis lexico select.png"))); // NOI18N
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/compilar-select.png"))); // NOI18N
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jScrollPane1.setViewportView(PanelFuente);

        PanelSalida.setColumns(20);
        PanelSalida.setRows(5);
        jScrollPane2.setViewportView(PanelSalida);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        Tokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Lexema", "[Fila,Columna]"
            }
        ));
        jScrollPane3.setViewportView(Tokens);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(259, 259, 259))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Archivo");

        btnmenuNuevo.setText("Nuevo");
        btnmenuNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(btnmenuNuevo);

        btnmenuAbrir.setText("Abrir");
        btnmenuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(btnmenuAbrir);

        btnmenuGuardar.setText("Guardar");
        btnmenuGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(btnmenuGuardar);

        btnmenuGuardarComo.setText("Guardar como");
        btnmenuGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuGuardarComoActionPerformed(evt);
            }
        });
        jMenu1.add(btnmenuGuardarComo);
        jMenu1.add(jSeparator1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Compilar");

        jMenuItem8.setText("Analisis Lexico");
        jMenu2.add(jMenuItem8);
        jMenu2.add(jSeparator4);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Acerca de");

        btnMenuLEATE.setText("Sobre M4TH3C");
        btnMenuLEATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuLEATEActionPerformed(evt);
            }
        });
        jMenu4.add(btnMenuLEATE);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnmenuNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuNuevoActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_btnmenuNuevoActionPerformed

    private void btnmenuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuAbrirActionPerformed
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_btnmenuAbrirActionPerformed

    private void btnmenuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuGuardarActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_btnmenuGuardarActionPerformed

    private void btnmenuGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuGuardarComoActionPerformed
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_btnmenuGuardarComoActionPerformed

    private void btnMenuLEATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuLEATEActionPerformed
        AcercaDe ac = new AcercaDe();
        ac.setVisible(true);
    }//GEN-LAST:event_btnMenuLEATEActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if(directorio.Save()){
                compilar();
            }
        } else {
            compilar();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane PanelFuente;
    private javax.swing.JTextArea PanelSalida;
    private javax.swing.JTable Tokens;
    private javax.swing.JMenuItem btnMenuLEATE;
    private javax.swing.JMenuItem btnmenuAbrir;
    private javax.swing.JMenuItem btnmenuGuardar;
    private javax.swing.JMenuItem btnmenuGuardarComo;
    private javax.swing.JMenuItem btnmenuNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
