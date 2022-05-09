package git.ipc1.models.hanoi;

import git.ipc1.models.damas.Damas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author absar
 */
public class HanoiModel extends JPanel implements ActionListener {
    
    private int[][] tablero = new int[8][8];
    private JButton boton[][];
    private Damas damas;
    private int tamanio = 60;
    private final String reinaroja = "./git/ipc1/imagenes/fichaRRn.jpg";
    private final String reinanegra = "./git/ipc1/imagenes/fichaRNn.jpg";
    private final String roja = "./git/ipc1/imagenes/fichaRn.jpg";
    private final String negra = "./git/ipc1/imagenes/fichaNn.jpg";
    private final String vacio = "./imagenes/EspacionNegro.png";

    /*
    private int posX, posY;
    
    public HanoiModel(int posX, int posY, JPanel panel, String picture ){
        
        
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
     */
    public HanoiModel() {
        this.setBackground(Color.blue);
        inicar();
        setLayout(new BorderLayout());
        //setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("juego")));
        setVisible(true);
        alinear();
        dibujar_tablero();
        crear_tabero();
        this.setVisible(true);
        
    }
    
    public void inicar() {
        boton = new JButton[8][8];
        damas = new Damas();
        damas.poner_fichas();
        removeAll();
        
        removeAll();
        for (JButton[] boton1 : boton) {
            for (int j = 0; j < boton[0].length; j++) {
                boton1[j] = new JButton();
                boton1[j].setBackground(Color.BLACK);
                boton1[j].setBorderPainted(false);
                boton1[j].setContentAreaFilled(false);
                boton1[j].setOpaque(false);
                boton1[j].addActionListener(this);
            }
        }
    }
    
    public void ResetearTablero() {
        damas.poner_fichas();
    }
    
    public void dibujar_tablero() {
        for (int[] tablero1 : tablero) {
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
                    boton[i][j].setIcon(new ImageIcon(negra));
                } else if (tablero[i][j] == damas.getRojas()) {
                    boton[i][j].setIcon(new ImageIcon(roja));
                } else if (tablero[i][j] == damas.getReinaR()) {
                    boton[i][j].setIcon(new ImageIcon(reinaroja));
                } else if (tablero[i][j] == damas.getReinaN()) {
                    boton[i][j].setIcon(new ImageIcon(reinanegra));
                } else if (tablero[i][j] == damas.getRelleno()) {
                    boton[i][j].setIcon(new ImageIcon(vacio));
                }
            }
        }
    }
    
    public void dibujar_en_los_botones() {
        damas.verificar(damas.getColor());
        for (int i = 0; i < boton.length; i++) {
            for (int j = 0; j < boton.length; j++) {
                if (damas.verdamas(i, j) == damas.getNegras()) {
                    boton[i][j].setIcon(new ImageIcon(negra));
                } else if (damas.verdamas(i, j) == damas.getRojas()) {
                    boton[i][j].setIcon(new ImageIcon(roja));
                } else if (damas.verdamas(i, j) == damas.getReinaR()) {
                    boton[i][j].setIcon(new ImageIcon(reinaroja));
                } else if (damas.verdamas(i, j) == damas.getReinaN()) {
                    boton[i][j].setIcon(new ImageIcon(reinanegra));
                } else if (damas.verdamas(i, j) == damas.getRelleno()) {
                    boton[i][j].setIcon(new ImageIcon(vacio));
                }
            }
        }
    }
    
    public void alo() {
        damas.poner_fichas();
        dibujar_en_los_botones();
    }
    
    public boolean IA(boolean pasa) {
        int x = (int) (Math.random() * 8) + 0;
        int y = (int) (Math.random() * 8) + 0;
        int x1 = (int) (Math.random() * 8) + 0;
        int y1 = (int) (Math.random() * 8) + 0;
        if (damas.jugar(damas.getColor(), x, y, x1, y1) == true) {
            dibujar_en_los_botones();
            boton[x][y].setText("Negro");
            return true;
        }
        return pasa;
    }
    
    public void alinear() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 8));
        
        for (JButton[] boton1 : boton) {
            for (int j = 0; j < boton[0].length; j++) {
                panel.add(boton1[j]);
            }
        }
        add(panel);
    }
    
    public void cambiar(int rojas, int negras) {
        this.rojas = rojas;
        this.negras = negras;
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
