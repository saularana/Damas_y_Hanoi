/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package git.ipc1.Models.damas;

/**
 *
 * @author HP
 */
public interface PotitionsMove {
    public static enum Direction{
    UP,DOWN,LEFT,RIGHT
    }
    public abstract boolean move(Direction Direction);
    
}
