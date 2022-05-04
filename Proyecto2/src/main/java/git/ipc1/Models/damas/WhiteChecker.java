/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package git.ipc1.Models.damas;

/**
 *
 * @author HP
 */
public class WhiteChecker extends Ficha {

    public WhiteChecker(int row, int colum) {
        super(row, colum);
    }

    public WhiteChecker(int row, int colum, boolean show) {
        super(row, colum, show);
    }

    @Override
    public String toString() {
        return "WhiteChecker";
    }

    @Override
    protected int potitionRow() {
        return this.getRow() - 1;
    }

    @Override
    public boolean move(Direction Direction) {
        return setPotition(potitionRow(), potitionColum(Direction));
    }

}
