/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package git.ipc1.Models.damas;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author HP
 */
public class Board {

    public static final int size = 8;
    public static final String barra = "--------------------------";
    private Ficha[][] checkers;
    private ArrayList<Ficha> dead;

    public Board() {
        checkers = new Ficha[size][size];
        dead = new ArrayList<>();
        startBoard();
    }

    public Board(Ficha[] fich) {
        checkers = new Ficha[size][size];
        dead = new ArrayList<>();
        int r, c;
        for (Ficha ficha : fich) {
            r = ficha.getRow();
            c = ficha.getColum();

            if (!ficha.isShow()) {
                dead.add(ficha);
            }

            if (c < size && r < size && c >= 0 && r >= 0) {
                checkers[r][c] = ficha;
            } else {
                dead.add(ficha);
                ficha.setShow(false);
            }
        }

    }

    public final void startBoard() {
        /*    
    //white
        for (int i = size - 3; i < size; i++) {
            for (int j = 1 - i + size - 2; j < size; j += 2) {
                checkers[i][j] = new WhiteChecker(i, j,true);
            }

        }
        //black
        for (int i = 0; i < 3; i++) {
            for (int j = 1 - i; j < size; j++) {
                checkers[i][j] = new DarkChecker(i, j,true);
            }

        }
         */

        checkers = new Ficha[][]{
            {null, new DarkChecker(0, 1), null, new DarkChecker(0, 3), null, new DarkChecker(0, 5), null, new DarkChecker(0, 7)},
            {new DarkChecker(1, 0), null, new DarkChecker(1, 2), null, new DarkChecker(1, 4), null, new DarkChecker(1, 6), null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, new WhiteChecker(6, 1), null, new WhiteChecker(6, 3), null, new WhiteChecker(6, 5), null, new WhiteChecker(6, 7), null},
            {null, new WhiteChecker(6, 1), null, new WhiteChecker(6, 3), null, new WhiteChecker(6, 5), null, new WhiteChecker(6, 7), null}
        };

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (checkers != null && checkers[0] != null) {
            sb.append(barra + "\n");
            for (int i = 0, tam = checkers[0].length; i < checkers.length; i++) {
                for (int j = 0; j < tam; j++) {
                    sb.append("|").
                            append((checkers[i][j] != null) ? checkers[i][j] : "");
                }
                sb.append("\n" + barra + "\n");
            }
        }
        sb.append("Fichas comidas:");
        Iterator it;
        it = dead.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append("");
        }
        return sb.toString();
    }

}
