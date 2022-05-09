/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package git.ipc1.dharch;

import git.ipc1.dharch.board.botones;
import git.ipc1.dharch.board.tablero;
import git.ipc1.dharch.damas.SetBoard;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author absar
 */
public class Principal extends javax.swing.JFrame {

    SetBoard juego = new SetBoard();

    /**
     * Creates new form Principal
     */
//    public Principal(int player1, int player2) {
    public Principal() {
        super("Damas");
        initComponents();
//        this.add(new tablero());
//        this.add(new tablero(), BorderLayout.CENTER);
//        this.add(new SetBoard(), BorderLayout.CENTER);
//        this.add(new botones());

        alinear();
        setVisible(true);
        setResizable(false);
        setSize(685, 531);
        setSize(480, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Actualizar_botones();
        // 1 IA 2 jugador;
        juego.cambiar(1,1);

    }

    public void alinear() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
//		panel.setBorder(new CompoundBorder(new EmptyBorder(0,0,0,0), new TitledBorder("Informacion")));
        setLayout(new BorderLayout());
        add(juego, BorderLayout.CENTER);
    }
    
    public void Actualizar_botones() {
		juego.ResetearTablero();
		juego.dibujar_en_los_botones();
	}

//    @SuppressWarnings("null")
//	@Override
//	public void actionPerformed(ActionEvent e) {
//	
//				
//	
//		
//		
//	}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(645, 645));
        setResizable(false);
        setSize(new java.awt.Dimension(645, 645));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
