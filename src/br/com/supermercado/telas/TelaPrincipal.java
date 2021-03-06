package br.com.supermercado.telas;

import br.com.supermercado.dal.ModuloDeConexao;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
/**
 *
 * @author Paulo Abreu
 */
public class TelaPrincipal extends javax.swing.JFrame {
 Connection conexao = null;
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        
        initComponents();
        
        URL caminhoIconeTelaPrincipal = getClass().getResource("/br/com/supermercado/icones/OS_LogoMarca.png");
Image iconeTelaPrincipal = Toolkit.getDefaultToolkit().getImage(  caminhoIconeTelaPrincipal);
this.setIconImage(iconeTelaPrincipal);

        conexao = ModuloDeConexao.conector();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpTelaPrincipalLogoSupermercadoSergipe = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jpTelaPrincipalStatusNomeDataHora = new javax.swing.JPanel();
        jlTelaPrincipalData = new javax.swing.JLabel();
        jlTelaPrincipalHora = new javax.swing.JLabel();
        jlTelaPrincipalUsuario = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlTelaPrincipalMensagem = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jmbTelaPrincipalMenu = new javax.swing.JMenuBar();
        jmTelaPrincipalMenuMenuCadastros = new javax.swing.JMenu();
        jmTelaPrincipalMenuMenuUsuario = new javax.swing.JMenuItem();
        jmTelaPrincipaMenuMenulFornecedores = new javax.swing.JMenuItem();
        jmTelaPrincipalMenuMenuProdutos = new javax.swing.JMenuItem();
        jmTelaPrincipalMenuMenuVendas = new javax.swing.JMenu();
        jmTelaPrincipalMenuVendasCaixa = new javax.swing.JMenuItem();
        jmTelaPrincipalMenuMenuPedidos = new javax.swing.JMenu();
        jmTelaPrincipalMenuPedidosNovo = new javax.swing.JMenuItem();
        jmTelaPrincipalMenuMenuFerramentas = new javax.swing.JMenu();
        jmTelaPrincipalMenuMenuRelatorios = new javax.swing.JMenu();
        jmTelaPrincipalMenuMenuSair = new javax.swing.JMenu();
        jmTelaPrincipalMenuSairSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Supermercado - Tela Principal");
        setExtendedState(6);
        setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jpTelaPrincipalLogoSupermercadoSergipe.setBackground(new java.awt.Color(255, 255, 255));
        jpTelaPrincipalLogoSupermercadoSergipe.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Tela Principal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 24))); // NOI18N
        jpTelaPrincipalLogoSupermercadoSergipe.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/supermercado/icones/imagemLogoCarroSupermercado01.png"))); // NOI18N
        jpTelaPrincipalLogoSupermercadoSergipe.add(jLabel1);
        jLabel1.setBounds(20, 130, 390, 410);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Supermercado Sergipe");
        jpTelaPrincipalLogoSupermercadoSergipe.add(jLabel2);
        jLabel2.setBounds(230, 70, 570, 90);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Preços mais baixos ");
        jpTelaPrincipalLogoSupermercadoSergipe.add(jLabel3);
        jLabel3.setBounds(410, 300, 360, 43);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("não existe!");
        jpTelaPrincipalLogoSupermercadoSergipe.add(jLabel5);
        jLabel5.setBounds(560, 360, 190, 50);

        getContentPane().add(jpTelaPrincipalLogoSupermercadoSergipe);
        jpTelaPrincipalLogoSupermercadoSergipe.setBounds(40, 110, 820, 550);

        jpTelaPrincipalStatusNomeDataHora.setBackground(new java.awt.Color(255, 255, 255));
        jpTelaPrincipalStatusNomeDataHora.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Status", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 24))); // NOI18N

        jlTelaPrincipalData.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlTelaPrincipalData.setText("Data");

        jlTelaPrincipalHora.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlTelaPrincipalHora.setText("Hora");

        jlTelaPrincipalUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlTelaPrincipalUsuario.setText("Usuário");

        javax.swing.GroupLayout jpTelaPrincipalStatusNomeDataHoraLayout = new javax.swing.GroupLayout(jpTelaPrincipalStatusNomeDataHora);
        jpTelaPrincipalStatusNomeDataHora.setLayout(jpTelaPrincipalStatusNomeDataHoraLayout);
        jpTelaPrincipalStatusNomeDataHoraLayout.setHorizontalGroup(
            jpTelaPrincipalStatusNomeDataHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTelaPrincipalStatusNomeDataHoraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTelaPrincipalUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addComponent(jlTelaPrincipalData, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168)
                .addComponent(jlTelaPrincipalHora, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jpTelaPrincipalStatusNomeDataHoraLayout.setVerticalGroup(
            jpTelaPrincipalStatusNomeDataHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTelaPrincipalStatusNomeDataHoraLayout.createSequentialGroup()
                .addGroup(jpTelaPrincipalStatusNomeDataHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTelaPrincipalUsuario)
                    .addComponent(jlTelaPrincipalData)
                    .addComponent(jlTelaPrincipalHora))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        getContentPane().add(jpTelaPrincipalStatusNomeDataHora);
        jpTelaPrincipalStatusNomeDataHora.setBounds(40, 30, 820, 60);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Mensagem", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 24))); // NOI18N

        jlTelaPrincipalMensagem.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jlTelaPrincipalMensagem.setForeground(new java.awt.Color(255, 0, 0));
        jlTelaPrincipalMensagem.setText("Seja Bem-Vindo ao Sistema!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jlTelaPrincipalMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTelaPrincipalMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(880, 30, 450, 150);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/supermercado/icones/imagemGrafiteTelaFundoJPcadastroUsuarioMenu.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1637, 1160);

        jmTelaPrincipalMenuMenuCadastros.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jmTelaPrincipalMenuMenuCadastros.setText("Cadastros");
        jmTelaPrincipalMenuMenuCadastros.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N

        jmTelaPrincipalMenuMenuUsuario.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jmTelaPrincipalMenuMenuUsuario.setText("Usuários");
        jmTelaPrincipalMenuMenuUsuario.setEnabled(false);
        jmTelaPrincipalMenuMenuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmTelaPrincipalMenuMenuUsuarioActionPerformed(evt);
            }
        });
        jmTelaPrincipalMenuMenuCadastros.add(jmTelaPrincipalMenuMenuUsuario);

        jmTelaPrincipaMenuMenulFornecedores.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jmTelaPrincipaMenuMenulFornecedores.setText("Fornecedores");
        jmTelaPrincipaMenuMenulFornecedores.setEnabled(false);
        jmTelaPrincipalMenuMenuCadastros.add(jmTelaPrincipaMenuMenulFornecedores);

        jmTelaPrincipalMenuMenuProdutos.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jmTelaPrincipalMenuMenuProdutos.setText("Produtos");
        jmTelaPrincipalMenuMenuProdutos.setEnabled(false);
        jmTelaPrincipalMenuMenuCadastros.add(jmTelaPrincipalMenuMenuProdutos);

        jmbTelaPrincipalMenu.add(jmTelaPrincipalMenuMenuCadastros);

        jmTelaPrincipalMenuMenuVendas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jmTelaPrincipalMenuMenuVendas.setText("Vendas");
        jmTelaPrincipalMenuMenuVendas.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N

        jmTelaPrincipalMenuVendasCaixa.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jmTelaPrincipalMenuVendasCaixa.setText("Caixa");
        jmTelaPrincipalMenuVendasCaixa.setEnabled(false);
        jmTelaPrincipalMenuVendasCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmTelaPrincipalMenuVendasCaixaActionPerformed(evt);
            }
        });
        jmTelaPrincipalMenuMenuVendas.add(jmTelaPrincipalMenuVendasCaixa);

        jmbTelaPrincipalMenu.add(jmTelaPrincipalMenuMenuVendas);

        jmTelaPrincipalMenuMenuPedidos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jmTelaPrincipalMenuMenuPedidos.setText("Pedidos");
        jmTelaPrincipalMenuMenuPedidos.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N

        jmTelaPrincipalMenuPedidosNovo.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jmTelaPrincipalMenuPedidosNovo.setText("Novo");
        jmTelaPrincipalMenuPedidosNovo.setEnabled(false);
        jmTelaPrincipalMenuMenuPedidos.add(jmTelaPrincipalMenuPedidosNovo);

        jmbTelaPrincipalMenu.add(jmTelaPrincipalMenuMenuPedidos);

        jmTelaPrincipalMenuMenuFerramentas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jmTelaPrincipalMenuMenuFerramentas.setText("Ferramentas");
        jmTelaPrincipalMenuMenuFerramentas.setEnabled(false);
        jmTelaPrincipalMenuMenuFerramentas.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N

        jmTelaPrincipalMenuMenuRelatorios.setBorder(null);
        jmTelaPrincipalMenuMenuRelatorios.setText("Relatórios");
        jmTelaPrincipalMenuMenuRelatorios.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jmTelaPrincipalMenuMenuFerramentas.add(jmTelaPrincipalMenuMenuRelatorios);

        jmbTelaPrincipalMenu.add(jmTelaPrincipalMenuMenuFerramentas);

        jmTelaPrincipalMenuMenuSair.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jmTelaPrincipalMenuMenuSair.setText("Sair");
        jmTelaPrincipalMenuMenuSair.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jmTelaPrincipalMenuMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmTelaPrincipalMenuMenuSairActionPerformed(evt);
            }
        });

        jmTelaPrincipalMenuSairSair.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jmTelaPrincipalMenuSairSair.setText("Sair");
        jmTelaPrincipalMenuSairSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmTelaPrincipalMenuSairSairActionPerformed(evt);
            }
        });
        jmTelaPrincipalMenuMenuSair.add(jmTelaPrincipalMenuSairSair);

        jmbTelaPrincipalMenu.add(jmTelaPrincipalMenuMenuSair);

        setJMenuBar(jmbTelaPrincipalMenu);

        setSize(new java.awt.Dimension(1385, 757));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmTelaPrincipalMenuMenuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmTelaPrincipalMenuMenuUsuarioActionPerformed
        
        TelaCadastroUsuarios tcu = new TelaCadastroUsuarios();
        tcu.setVisible(true);
        //dispose();
    }//GEN-LAST:event_jmTelaPrincipalMenuMenuUsuarioActionPerformed

    private void jmTelaPrincipalMenuMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmTelaPrincipalMenuMenuSairActionPerformed

    }//GEN-LAST:event_jmTelaPrincipalMenuMenuSairActionPerformed

    private void jmTelaPrincipalMenuSairSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmTelaPrincipalMenuSairSairActionPerformed
                     int sair  = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair?","Atenção",JOptionPane.YES_NO_OPTION );
        if (sair == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_jmTelaPrincipalMenuSairSairActionPerformed

    private void jmTelaPrincipalMenuVendasCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmTelaPrincipalMenuVendasCaixaActionPerformed
       TelaVendas tv = new TelaVendas();
       tv.setVisible(true);
       
    }//GEN-LAST:event_jmTelaPrincipalMenuVendasCaixaActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
         Date data = new Date ();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        jlTelaPrincipalData.setText(formatador.format(data));
        
        Timer timer = new Timer (1000, new hora());
        timer.start();
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlTelaPrincipalData;
    private javax.swing.JLabel jlTelaPrincipalHora;
    private javax.swing.JLabel jlTelaPrincipalMensagem;
    public static javax.swing.JLabel jlTelaPrincipalUsuario;
    public static javax.swing.JMenuItem jmTelaPrincipaMenuMenulFornecedores;
    private javax.swing.JMenu jmTelaPrincipalMenuMenuCadastros;
    public static javax.swing.JMenu jmTelaPrincipalMenuMenuFerramentas;
    private javax.swing.JMenu jmTelaPrincipalMenuMenuPedidos;
    public static javax.swing.JMenuItem jmTelaPrincipalMenuMenuProdutos;
    private javax.swing.JMenu jmTelaPrincipalMenuMenuRelatorios;
    private javax.swing.JMenu jmTelaPrincipalMenuMenuSair;
    public static javax.swing.JMenuItem jmTelaPrincipalMenuMenuUsuario;
    private javax.swing.JMenu jmTelaPrincipalMenuMenuVendas;
    public static javax.swing.JMenuItem jmTelaPrincipalMenuPedidosNovo;
    private javax.swing.JMenuItem jmTelaPrincipalMenuSairSair;
    public static javax.swing.JMenuItem jmTelaPrincipalMenuVendasCaixa;
    private javax.swing.JMenuBar jmbTelaPrincipalMenu;
    private javax.swing.JPanel jpTelaPrincipalLogoSupermercadoSergipe;
    private javax.swing.JPanel jpTelaPrincipalStatusNomeDataHora;
    // End of variables declaration//GEN-END:variables
class hora implements ActionListener{
    public void actionPerformed(ActionEvent e){
        Calendar now = Calendar.getInstance();
                jlTelaPrincipalHora.setText(String.format("%1$tH:%1$tM:%1$tS",now));
    }
}

}
