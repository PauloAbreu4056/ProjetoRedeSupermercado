package br.com.supermercado.telas;

import java.sql.*;
import br.com.supermercado.dal.ModuloDeConexao;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Paulo Abreu
 */
public class TelaLogin extends javax.swing.JFrame {
    
    Connection conexao = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
  
    
    public TelaLogin() {
        initComponents();
        
        conexao = ModuloDeConexao.conector();
    
         if(conexao != null){
        jlTelaLoginIconeStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/supermercado/icones/conectado.png")));
        }else{
           jlTelaLoginIconeStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/supermercado/icones/desconectado.png")));
        }
        
        URL caminhoIconeTelaLogin = getClass().getResource("/br/com/supermercado/icones/OS_LogoMarca.png");
Image iconeTelaLogin = Toolkit.getDefaultToolkit().getImage(caminhoIconeTelaLogin);
this.setIconImage(iconeTelaLogin);

    }
public void Logar() {
    
     String sql = "select * from tbusuariosdosistema where login = ? and senha = ?";
     
          String senha = new String (jpfTelaLoginSenha.getPassword());
       try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for(byte b : messageDigest){
            sb.append(String.format("%02X", 0xFF & b));
            }
            
            String senhaHex = sb.toString();
            
            ps = conexao.prepareStatement(sql);
            ps.setString(1, jtfTelaLoginUsuario.getText());
            ps.setString(2, senhaHex);
            //ps.setString(2, jpfTelaLoginSenha.getText());
            rs = ps.executeQuery();
            
           
            if (rs.next()){
               String perfil = rs.getString(7);
            if(perfil.equals("Administrador")){
               TelaPrincipal tp = new TelaPrincipal();
               tp.setVisible(true);
               TelaPrincipal.jmTelaPrincipalMenuMenuUsuario.setEnabled(true);
               TelaPrincipal.jmTelaPrincipaMenuMenulFornecedores.setEnabled(true);
               TelaPrincipal.jmTelaPrincipalMenuMenuProdutos.setEnabled(true);
               TelaPrincipal.jmTelaPrincipalMenuVendasCaixa.setEnabled(true);
               TelaPrincipal.jmTelaPrincipalMenuPedidosNovo.setEnabled(true);
               TelaPrincipal.jmTelaPrincipalMenuMenuFerramentas.setEnabled(true);
               TelaPrincipal.jlTelaPrincipalUsuario.setText(rs.getString(2));
               TelaPrincipal.jlTelaPrincipalUsuario.setForeground(Color.RED);
               this.dispose();
               
               }else if(perfil.equals("Usuário do Sistema")){
               TelaPrincipal tp1 = new TelaPrincipal();
               tp1.setVisible(true);
               TelaPrincipal.jmTelaPrincipaMenuMenulFornecedores.setEnabled(true);
               TelaPrincipal.jmTelaPrincipalMenuMenuProdutos.setEnabled(true);
               TelaPrincipal.jmTelaPrincipalMenuPedidosNovo.setEnabled(true);
               TelaPrincipal.jlTelaPrincipalUsuario.setText(rs.getString(2));
               TelaVendas.jlTelaVendasCaixa.setText(rs.getString(2));
               TelaVendas.jlTelaVendasCaixa.setForeground(Color.RED);
               this.dispose();
               
               }else if(perfil.equals("Caixa")){
               TelaPrincipal tp2 = new TelaPrincipal();
               tp2.setVisible(true);
               TelaPrincipal.jmTelaPrincipalMenuVendasCaixa.setEnabled(true);
               TelaPrincipal.jlTelaPrincipalUsuario.setText(rs.getString(2));
               TelaVendas.jlTelaVendasCaixa.setText(rs.getString(2));
               TelaVendas.jlTelaVendasCaixa.setForeground(Color.RED);
               this.dispose();
               
               }else{
                   
               TelaPrincipal tp = new TelaPrincipal();
               tp.setVisible(true);
               //TelaPrincipal.jlTelaPrincipalUsuario.setText(rs.getString(2));
               //TelaPrincipal.jlTelaPrincipalUsuario.setForeground(Color.red);
               
               TelaPrincipal tp1 = new TelaPrincipal();
               tp1.setVisible(true);
               
               TelaPrincipal tp2 = new TelaPrincipal();
               tp2.setVisible(true);
               //TelaPrincipal.jmTelaPrincipalMenuVendasCaixa.setEnabled(true);
               //TelaVendas.jlTelaVendasCaixa.setText(rs.getString(2));
               //TelaVendas.jlTelaVendasCaixa.setForeground(Color.red);
              
               this.dispose();
               conexao.close();
               }
            
               
               }else{
           JOptionPane.showMessageDialog(null,"Usuário ou Senha inválido");
          }         
    } catch (Exception e) {}
       
        
      
       
       
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
        jtfTelaLoginUsuario = new javax.swing.JTextField();
        jpfTelaLoginSenha = new javax.swing.JPasswordField();
        jlTelaLoginUsuario = new javax.swing.JLabel();
        jlTelaLoginSenha = new javax.swing.JLabel();
        jbTelaLoginLogin = new javax.swing.JButton();
        jlTelaLoginIconeStatus = new javax.swing.JLabel();
        jlTelaFundoLoginGrafite = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Supermercado");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setPreferredSize(new java.awt.Dimension(380, 440));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Login", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(240, 440));
        jPanel1.setLayout(null);

        jtfTelaLoginUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTelaLoginUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(jtfTelaLoginUsuario);
        jtfTelaLoginUsuario.setBounds(50, 270, 210, 30);

        jpfTelaLoginSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfTelaLoginSenhaActionPerformed(evt);
            }
        });
        jpfTelaLoginSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpfTelaLoginSenhaKeyPressed(evt);
            }
        });
        jPanel1.add(jpfTelaLoginSenha);
        jpfTelaLoginSenha.setBounds(50, 340, 120, 30);

        jlTelaLoginUsuario.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlTelaLoginUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jlTelaLoginUsuario.setText("Usuário");
        jPanel1.add(jlTelaLoginUsuario);
        jlTelaLoginUsuario.setBounds(50, 310, 70, 20);

        jlTelaLoginSenha.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlTelaLoginSenha.setForeground(new java.awt.Color(255, 255, 255));
        jlTelaLoginSenha.setText("Senha");
        jPanel1.add(jlTelaLoginSenha);
        jlTelaLoginSenha.setBounds(50, 380, 60, 20);

        jbTelaLoginLogin.setText("Login");
        jbTelaLoginLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTelaLoginLoginActionPerformed(evt);
            }
        });
        jPanel1.add(jbTelaLoginLogin);
        jbTelaLoginLogin.setBounds(180, 320, 80, 80);

        jlTelaLoginIconeStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/supermercado/icones/desconectado.png"))); // NOI18N
        jPanel1.add(jlTelaLoginIconeStatus);
        jlTelaLoginIconeStatus.setBounds(120, 160, 80, 80);

        jlTelaFundoLoginGrafite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/supermercado/icones/imagemGrafiteTelaFundoJPcadastroUsuarioMenu.jpg"))); // NOI18N
        jlTelaFundoLoginGrafite.setText("jLabel1");
        jPanel1.add(jlTelaFundoLoginGrafite);
        jlTelaFundoLoginGrafite.setBounds(20, 20, 270, 420);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 20, 310, 460);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/supermercado/icones/imagemGrafiteTelaFundoJPcadastroUsuarioMenu.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 510, 550);

        setSize(new java.awt.Dimension(356, 533));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbTelaLoginLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTelaLoginLoginActionPerformed
        Logar();
    }//GEN-LAST:event_jbTelaLoginLoginActionPerformed

    private void jtfTelaLoginUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTelaLoginUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTelaLoginUsuarioActionPerformed

    private void jpfTelaLoginSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfTelaLoginSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpfTelaLoginSenhaActionPerformed

    private void jpfTelaLoginSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpfTelaLoginSenhaKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER) {
        String sql = "select * from tbusuariosdosistema where login = ? and senha = ?";
     
          String senha = new String (jpfTelaLoginSenha.getPassword());
       try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for(byte b : messageDigest){
            sb.append(String.format("%02X", 0xFF & b));
            }
            
            String senhaHex = sb.toString();
            
            ps = conexao.prepareStatement(sql);
            ps.setString(1, jtfTelaLoginUsuario.getText());
            ps.setString(2, senhaHex);
            //ps.setString(2, jpfTelaLoginSenha.getText());
            rs = ps.executeQuery();
            if (rs.next()){
               String perfil = rs.getString(7);
                if(perfil.equals("Administrador")){ 
                   
               TelaPrincipal tp = new TelaPrincipal();
               tp.setVisible(true);
               //TelaPrincipal.jmTelaPrincipalMenuMenuUsuario.setEnabled(true);
               //TelaPrincipal.jmTelaPrincipalMenuMenuFerramentas.setEnabled(true);
               //TelaPrincipal.jlTelaPrincipalUsuario.setText(rs.getString(2));
               //TelaPrincipal.jlTelaPrincipalUsuario.setForeground(Color.red);
               this.dispose();
               
               }else{
                   
               TelaPrincipal tp = new TelaPrincipal();
               tp.setVisible(true);
               //TelaPrincipal.jlTelaPrincipalUsuario.setText(rs.getString(2));
               //TelaPrincipal.jlTelaPrincipalUsuario.setForeground(Color.red);
               this.dispose();
               conexao.close();
               }
              
               this.dispose();
               }else{
                     JOptionPane.showMessageDialog(null,"Usuário ou Senha inválido");
          }         
    } catch (Exception e) {
    }
   
    }//GEN-LAST:event_jpfTelaLoginSenhaKeyPressed
    }
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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbTelaLoginLogin;
    private javax.swing.JLabel jlTelaFundoLoginGrafite;
    private javax.swing.JLabel jlTelaLoginIconeStatus;
    private javax.swing.JLabel jlTelaLoginSenha;
    private javax.swing.JLabel jlTelaLoginUsuario;
    private javax.swing.JPasswordField jpfTelaLoginSenha;
    private javax.swing.JTextField jtfTelaLoginUsuario;
    // End of variables declaration//GEN-END:variables
}
