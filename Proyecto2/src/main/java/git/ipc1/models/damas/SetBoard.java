/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package git.ipc1.dharch.damas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

/**
 *
 * @author absar
 */
public class SetBoard extends JPanel implements ActionListener {

    private JButton boton[][] = new JButton[8][8];
    ;

	private Damas damas = new Damas();

    private final URL fichanegra = getClass().getResource("/pictures/fichaNn.jpg");
    private final URL ficharroja = getClass().getResource("/pictures/fichaRn.jpg");
    private final URL reinaroja = getClass().getResource("/pictures/fichaRRn.jpg");
    private final URL reinanegra = getClass().getResource("/pictures/fichaRNn.jpg");
    private final URL vacionegro = getClass().getResource("/pictures/EspacionNegro.png");
    private final URL vacioblanco = getClass().getResource("/pictures/EspacionBlanco.png");

    //private PanelImagen imagen= new PanelImagen();
    private int ancho = 60, alto = 60;
    private int tablero[][] = new int[8][8];

    public SetBoard() {
//		new NuevaPartida();
        iniciar();
        setLayout(new BorderLayout());
        //setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("juego")));
        setVisible(true);
        alinear();
        dibujar_tablero();
        crear_tabero();
    }
    
    

    public void iniciar() {

        damas.poner_fichas();
        removeAll();
        for (int i = 0; i < boton.length; i++) {
            for (int j = 0; j < boton[0].length; j++) {

                boton[i][j] = new JButton();
                boton[i][j].setBackground(Color.WHITE);
                boton[i][j].setBorderPainted(false);
                boton[i][j].setContentAreaFilled(false);
                boton[i][j].setOpaque(false);
                boton[i][j].addActionListener(this);
                boton[i][j].setIcon(new ImageIcon(vacioblanco));

            }
        }

    }

    public void alinear() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 8));

        for (int i = 0; i < boton.length; i++) {
            for (int j = 0; j < boton[0].length; j++) {
                panel.add(boton[i][j]);
            }
        }
        add(panel);
    }

    public void dibujar_tablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (j % 2 == 0) {
                    tablero[1][j] = 5;
                    tablero[7][j] = 5;
                    tablero[5][j] = 5;
                    tablero[3][j] = 5;
                } else {
                    tablero[0][j] = 5;
                    tablero[6][j] = 5;
                    tablero[2][j] = 5;
                    tablero[4][j] = 5;
                }
            }
        }
    }

    public void crear_tabero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < boton.length; j++) {
                if (tablero[i][j] == damas.getNegras()) {
                    boton[i][j].setIcon(new ImageIcon(fichanegra));
                } else if (tablero[i][j] == damas.getRojas()) {
                    boton[i][j].setIcon(new ImageIcon(ficharroja));
                } else if (tablero[i][j] == damas.getReinaR()) {
                    boton[i][j].setIcon(new ImageIcon(reinaroja));
                } else if (tablero[i][j] == damas.getReinaN()) {
                    boton[i][j].setIcon(new ImageIcon(reinanegra));
                } else if (tablero[i][j] == damas.getRelleno()) {
                    boton[i][j].setIcon(new ImageIcon(vacionegro));
                }
            }
        }
    }

    public void dibujar_en_los_botones() {
        damas.verificar(damas.getColor());
        for (int i = 0; i < boton.length; i++) {
            for (int j = 0; j < boton.length; j++) {
                if (damas.verdamas(i, j) == damas.getNegras()) {
                    boton[i][j].setIcon(new ImageIcon(fichanegra));
                } else if (damas.verdamas(i, j) == damas.getRojas()) {
                    boton[i][j].setIcon(new ImageIcon(ficharroja));
                } else if (damas.verdamas(i, j) == damas.getReinaR()) {
                    boton[i][j].setIcon(new ImageIcon(reinaroja));
                } else if (damas.verdamas(i, j) == damas.getReinaN()) {
                    boton[i][j].setIcon(new ImageIcon(reinanegra));
                } else if (damas.verdamas(i, j) == damas.getRelleno()) {
                    boton[i][j].setIcon(new ImageIcon(vacionegro));
                }
            }
        }
    }

    public void ResetearTablero() {
        damas.poner_fichas();
    }

    public boolean IA(boolean pasa) {
        int x = (int) (Math.random() * 8) + 0;
        int y = (int) (Math.random() * 8) + 0;
        int x1 = (int) (Math.random() * 8) + 0;
        int y1 = (int) (Math.random() * 8) + 0;
        if (damas.jugar(damas.getColor(), x, y, x1, y1) == true) {
            dibujar_en_los_botones();
            boton[x][y].setIcon(new ImageIcon(vacionegro));
            return true;
        }
        return pasa;
    }

    public void cambiar(int rojas, int negras) {
        this.rojas = rojas;
        this.negras = negras;
    }

    public void alo() {
        damas.poner_fichas();
        dibujar_en_los_botones();
    }

    int contar = 0;
    int x = 0, y = 0, x1 = 0, y1 = 0, rojas, negras;

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean pasa = false;
        for (int i = 0; i < boton.length; i++) {
            for (int j = 0; j < boton[0].length; j++) {
                if (e.getSource() == boton[i][j]) {

                    if (rojas == 1 && negras == 1) {
                        //Rojas:Automatico Vs Negras:Automatico

                        while (IA(pasa) == false) {

                        }
                        damas.CambioDeTurno();
                    } else if (rojas == 2 && negras == 2) {
                        //Rojas:Manual Vs Negras:Manual
                        if (damas.verificar_exitencia_de_ficha(damas.getColor(), i, j)) {
                            x = i;
                            y = j;
                            contar++;
                        } else if (contar == 1) {
                            if (damas.jugar(damas.getColor(), x, y, i, j)) {
                                dibujar_en_los_botones();
                                damas.CambioDeTurno();
                            } else {
                                JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                            }
                            contar--;
                        }
                    } else if (rojas == 1 && negras == 2) {
                        //Rojas:Automatico Vs Negras:Manual

                        if (damas.getColor() == 'N') {
                            if (damas.verificar_exitencia_de_ficha(damas.getColor(), i, j)) {
                                x = i;
                                y = j;
                                contar++;
                            } else if (contar == 1) {
                                if (damas.jugar(damas.getColor(), x, y, i, j)) {
                                    dibujar_en_los_botones();
                                    damas.CambioDeTurno();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                                }
                                contar--;
                            }
                        } else {
                            while (IA(pasa) == false) {

                            }
                            damas.CambioDeTurno();
                        }

                    } else if (rojas == 2 && negras == 1) {
                        //Rojas:Manual Vs Negras:Automatico

                        if (damas.getColor() == 'R') {
                            if (damas.verificar_exitencia_de_ficha(damas.getColor(), i, j)) {
                                x = i;
                                y = j;
                                contar++;
                            } else if (contar == 1) {
                                if (damas.jugar(damas.getColor(), x, y, i, j)) {
                                    dibujar_en_los_botones();
                                    damas.CambioDeTurno();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Movimiento Invalido");
                                }
                                contar--;
                            }
                        } else {
                            while (IA(pasa) == false) {

                            }
                            damas.CambioDeTurno();
                        }

                    }
                }
            }
        }
    }

}
