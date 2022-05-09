/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package git.ipc1.view.hanoi;

import git.ipc1.models.hanoi.HanoiModel;
import javax.swing.JFrame;

/**
 *
 * @author absar
 */
public class HanoiForm extends JFrame{

    public HanoiForm(){
    implemnet();
        HanoiModel ta = new HanoiModel();
    this.add(ta);
    }
   
    
    
    
    private void implemnet(){
    this.setSize(400,400);
    this.setVisible(true);
    this.setTitle("Hanoi frame by me");
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    }
    
}
