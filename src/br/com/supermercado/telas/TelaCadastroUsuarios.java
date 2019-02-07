package br.com.supermercado.telas;

import br.com.supermercado.dal.ModuloDeConexao;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo Abreu
 */
public class TelaCadastroUsuarios extends javax.swing.JFrame {
    
    Connection conexao = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    /**
     * Creates new form TelaCadastroUsuarios
     */
    public TelaCadastroUsuarios() {
       
        initComponents();
        
        URL caminhoIconeTelaPrincipal = getClass().getResource("/br/com/supermercado/icones/OS_LogoMarca.png");
Image iconeTelaPrincipal = Toolkit.getDefaultToolkit().getImage(  caminhoIconeTelaPrincipal);
this.setIconImage(iconeTelaPrincipal);

        conexao = ModuloDeConexao.conector();
    }
    
    private void Adicionar(){
            String sql = "insert into tbusuariosdosistema(matricula,nome,admissao,funcao,telefone,tiposanguineo,perfil,login,senha) values (?,?,?,?,?,?,?,?,?)";
            String senha = new String (jpfCadastroUsuarioJPsenha.getPassword());
            //String senha = jpfTelaCadastroUsuarioSenha.getText();
        try {
            
	    MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for(byte b : messageDigest){
            sb.append(String.format("%02X", 0xFF & b));
            }
            
            String senhaHex = sb.toString();
            
            
        ps=conexao.prepareStatement(sql);
        
        ps.setString(1,jtfCadastroUsuarioJPmatricula.getText());
        ps.setString(2,jtfCadastroUsuarioJPnome.getText());
        ps.setString(3,jftfCadastroUsuarioJPadmissao.getText());
        ps.setString(4,jtfCadastroUsuarioJPfuncao.getText());
        ps.setString(5,jftflCadastroUsuarioJPtelefone.getText());
        ps.setString(6,jtfCadastroUsuarioJPtipoSanguineo.getText());
        ps.setString(7,jcbCadastroUsuarioJPperfil.getSelectedItem().toString());
        ps.setString(8,jtfCadastroUsuarioJPlogin.getText());
        ps.setString(9, senhaHex); 
            
            if ((jtfCadastroUsuarioJPmatricula.getText().isEmpty())||
               (jtfCadastroUsuarioJPnome.getText().isEmpty())||
               (jftfCadastroUsuarioJPadmissao.getText().isEmpty())||
               (jtfCadastroUsuarioJPfuncao.getText().isEmpty())||
               (jftflCadastroUsuarioJPtelefone.getText().isEmpty())||
               (jtfCadastroUsuarioJPtipoSanguineo.getText().isEmpty())||
               (jtfCadastroUsuarioJPlogin.getText().isEmpty())||
               (new String(jpfCadastroUsuarioJPsenha.getPassword()).isEmpty())) {
                JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatórios");
            } else {
            
            int adicionado = ps.executeUpdate();
        
            if(adicionado >0){
                JOptionPane.showMessageDialog(null,"Usuário adicionado com sucesso");
                jtfCadastroUsuarioJPmatricula.setText(null);
                jtfCadastroUsuarioJPnome.setText(null);
                jftfCadastroUsuarioJPadmissao.setText(null);
                jtfCadastroUsuarioJPfuncao.setText(null);
                jftflCadastroUsuarioJPtelefone.setText(null);
                jtfCadastroUsuarioJPtipoSanguineo.setText(null);
                jtfCadastroUsuarioJPlogin.setText(null);
                jpfCadastroUsuarioJPsenha.setText(null);
                //jcbTelaCadastroUsuarioPerfil.setSelectedItem(null);
            }
            }
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"Ops!Esse usuário ou login já existe no sistema ");
                
                jtfCadastroUsuarioJPnome.setText(null);
                jftfCadastroUsuarioJPadmissao.setText(null);
                jtfCadastroUsuarioJPfuncao.setText(null);
                jftflCadastroUsuarioJPtelefone.setText(null);
                jtfCadastroUsuarioJPtipoSanguineo.setText(null);
                jtfCadastroUsuarioJPlogin.setText(null);
                jpfCadastroUsuarioJPsenha.setText(null);
                //jcbTelaCadastroUsuarioPerfil.setSelectedItem(null);
        }
        
        
}
      private void Consultar(){
        String sql = "select * from tbusuariosdosistema where matricula=?";
        try {
            ps=conexao.prepareStatement(sql);
            ps.setString(1,jtfCadastroUsuarioJPmatricula.getText());
            rs=ps.executeQuery();
            if (rs.next()) {
            jtfCadastroUsuarioJPnome.setText(rs.getString(2));
            jftfCadastroUsuarioJPadmissao.setText(rs.getString(3));
            jtfCadastroUsuarioJPfuncao.setText(rs.getString(4));
            jftflCadastroUsuarioJPtelefone.setText(rs.getString(5));
            jtfCadastroUsuarioJPtipoSanguineo.setText(rs.getString(6));
            jcbCadastroUsuarioJPperfil.setSelectedItem(rs.getString(7));
            jtfCadastroUsuarioJPlogin.setText(rs.getString(8));
            jpfCadastroUsuarioJPsenha.setText(rs.getString(9));
                   
            } else {
                JOptionPane.showMessageDialog(null,"Ops! Insira o Id do usuário e click no botão pesquisar!");
                
                jtfCadastroUsuarioJPnome.setText(null);
                jftfCadastroUsuarioJPadmissao.setText(null);
                jtfCadastroUsuarioJPfuncao.setText(null);
                jftflCadastroUsuarioJPtelefone.setText(null);
                jtfCadastroUsuarioJPtipoSanguineo.setText(null);
                jtfCadastroUsuarioJPlogin.setText(null);
                jpfCadastroUsuarioJPsenha.setText(null);
                //jcbTelaCadastroUsuarioPerfil.setSelectedItem(null);
                
            }
            
           } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e);
             
              
        }
        
    }
          private void Atualizar(){
              
         String sql = "update tbusuariosdosistema set nome=?,admissao=?,funcao=?,telefone=?,tiposanguineo=?,perfil=?,login=?,senha=? where matricula=?"; 
         
          String senha = new String (jpfCadastroUsuarioJPsenha .getPassword());
          //String senha = jpfTelaCadastroUsuarioSenha.getText();
          try {
          
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for(byte b : messageDigest){
            sb.append(String.format("%02X", 0xFF & b));
            }
              
            String senhaHex = sb.toString();    
              
        ps=conexao.prepareStatement(sql);
        
        ps.setString(1,jtfCadastroUsuarioJPnome.getText());
        ps.setString(2,jftfCadastroUsuarioJPadmissao.getText());
        ps.setString(3,jtfCadastroUsuarioJPfuncao.getText());
        ps.setString(4,jftflCadastroUsuarioJPtelefone.getText());
        ps.setString(5,jtfCadastroUsuarioJPtipoSanguineo.getText());
        ps.setString(6,jcbCadastroUsuarioJPperfil.getSelectedItem().toString());
        ps.setString(7,jtfCadastroUsuarioJPlogin.getText());
        ps.setString(8, senhaHex);
        ps.setString(9,jtfCadastroUsuarioJPmatricula.getText());
        
                if ((jtfCadastroUsuarioJPmatricula.getText().isEmpty())||
               (jtfCadastroUsuarioJPnome.getText().isEmpty())||
               (jftfCadastroUsuarioJPadmissao.getText().isEmpty())||
               (jtfCadastroUsuarioJPfuncao.getText().isEmpty())||
               (jftflCadastroUsuarioJPtelefone.getText().isEmpty())||
               (jtfCadastroUsuarioJPtipoSanguineo.getText().isEmpty())||
               (jtfCadastroUsuarioJPlogin.getText().isEmpty())||
               (new String(jpfCadastroUsuarioJPsenha.getPassword()).isEmpty()))
              {
                JOptionPane.showMessageDialog(null,"Preencha todos os campos para poder atualizar o usuário");
            } else {
            
            int adicionado = ps.executeUpdate();
         
            if(adicionado >0){
                JOptionPane.showMessageDialog(null,"Dados do usuário atualizdos com sucesso");
                jtfCadastroUsuarioJPmatricula.setText(null);
                jtfCadastroUsuarioJPnome.setText(null);
                jftfCadastroUsuarioJPadmissao.setText(null);
                jtfCadastroUsuarioJPfuncao.setText(null);
                jftflCadastroUsuarioJPtelefone.setText(null);
                jtfCadastroUsuarioJPtipoSanguineo.setText(null);
                jcbCadastroUsuarioJPperfil.setSelectedItem(null);
                jtfCadastroUsuarioJPlogin.setText(null);
                jpfCadastroUsuarioJPsenha.setText(null);
              
            }
            }
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null,e);
          }
          
      } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpTelaCadastroUsuarioAcolheImagemAzulMenu = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jbTelaCadastroUsuarioMenuOpcoesAtualizar = new javax.swing.JButton();
        jbTelaCadastroUsuarioMenuOpcoesConsultar = new javax.swing.JButton();
        jbTelaCadastroUsuarioMenuOpcoesAdicionar = new javax.swing.JButton();
        jlTelaCadastroUsuarioJPmenuOpcoes = new javax.swing.JLabel();
        jlTelaFundoJPcadastroUsuarioMenu = new javax.swing.JLabel();
        jlTelaCadastroUsuarioJPmenuDe = new javax.swing.JLabel();
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios = new javax.swing.JPanel();
        jlCadastroUsuarioJPnome = new javax.swing.JLabel();
        jlCadastroUsuarioJPtelefone = new javax.swing.JLabel();
        jlCadastroUsuarioJPadmissao = new javax.swing.JLabel();
        jlCadastroUsuarioJPtipoSanguineo = new javax.swing.JLabel();
        jlCadastroUsuarioJPperfil = new javax.swing.JLabel();
        jlCadastroUsuarioJPsenha = new javax.swing.JLabel();
        jlCadastroUsuarioJPMatricula = new javax.swing.JLabel();
        jlCadastroUsuarioJPlogin = new javax.swing.JLabel();
        jlCadastroUsuarioJPfuncao = new javax.swing.JLabel();
        jtfCadastroUsuarioJPtipoSanguineo = new javax.swing.JTextField();
        jtfCadastroUsuarioJPnome = new javax.swing.JTextField();
        jtfCadastroUsuarioJPfuncao = new javax.swing.JTextField();
        jtfCadastroUsuarioJPmatricula = new javax.swing.JTextField();
        jtfCadastroUsuarioJPlogin = new javax.swing.JTextField();
        jpfCadastroUsuarioJPsenha = new javax.swing.JPasswordField();
        jftfCadastroUsuarioJPadmissao = new javax.swing.JFormattedTextField();
        jftflCadastroUsuarioJPtelefone = new javax.swing.JFormattedTextField();
        jcbCadastroUsuarioJPperfil = new javax.swing.JComboBox<>();
        jlTelaFundoJPcadastroUsuarioUsuario = new javax.swing.JLabel();
        jlTelaCadastroUsuaarioCadastroUsuario = new javax.swing.JLabel();
        jlTelaCadastroUsuarioTelaFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Supermercado - Cadastro de Usuários do Sistema");
        setExtendedState(6);
        getContentPane().setLayout(null);

        jpTelaCadastroUsuarioAcolheImagemAzulMenu.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Menu", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 1, 18))); // NOI18N
        jpTelaCadastroUsuarioAcolheImagemAzulMenu.setLayout(null);

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setText("jButton1");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpTelaCadastroUsuarioAcolheImagemAzulMenu.add(jButton1);
        jButton1.setBounds(40, 540, 90, 90);

        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setText("jButton2");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpTelaCadastroUsuarioAcolheImagemAzulMenu.add(jButton2);
        jButton2.setBounds(40, 430, 90, 90);

        jbTelaCadastroUsuarioMenuOpcoesAtualizar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jbTelaCadastroUsuarioMenuOpcoesAtualizar.setText("Atualizar");
        jbTelaCadastroUsuarioMenuOpcoesAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbTelaCadastroUsuarioMenuOpcoesAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTelaCadastroUsuarioMenuOpcoesAtualizarActionPerformed(evt);
            }
        });
        jpTelaCadastroUsuarioAcolheImagemAzulMenu.add(jbTelaCadastroUsuarioMenuOpcoesAtualizar);
        jbTelaCadastroUsuarioMenuOpcoesAtualizar.setBounds(40, 320, 90, 90);

        jbTelaCadastroUsuarioMenuOpcoesConsultar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jbTelaCadastroUsuarioMenuOpcoesConsultar.setText("Consultar");
        jbTelaCadastroUsuarioMenuOpcoesConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbTelaCadastroUsuarioMenuOpcoesConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTelaCadastroUsuarioMenuOpcoesConsultarActionPerformed(evt);
            }
        });
        jpTelaCadastroUsuarioAcolheImagemAzulMenu.add(jbTelaCadastroUsuarioMenuOpcoesConsultar);
        jbTelaCadastroUsuarioMenuOpcoesConsultar.setBounds(40, 210, 90, 90);

        jbTelaCadastroUsuarioMenuOpcoesAdicionar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jbTelaCadastroUsuarioMenuOpcoesAdicionar.setText("Adicionar");
        jbTelaCadastroUsuarioMenuOpcoesAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbTelaCadastroUsuarioMenuOpcoesAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTelaCadastroUsuarioMenuOpcoesAdicionarActionPerformed(evt);
            }
        });
        jpTelaCadastroUsuarioAcolheImagemAzulMenu.add(jbTelaCadastroUsuarioMenuOpcoesAdicionar);
        jbTelaCadastroUsuarioMenuOpcoesAdicionar.setBounds(40, 100, 90, 90);

        jlTelaCadastroUsuarioJPmenuOpcoes.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jlTelaCadastroUsuarioJPmenuOpcoes.setText("Opções");
        jpTelaCadastroUsuarioAcolheImagemAzulMenu.add(jlTelaCadastroUsuarioJPmenuOpcoes);
        jlTelaCadastroUsuarioJPmenuOpcoes.setBounds(40, 40, 90, 30);

        jlTelaFundoJPcadastroUsuarioMenu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlTelaFundoJPcadastroUsuarioMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/supermercado/icones/imagemGrafiteTelaFundoJPcadastroUsuarioMenu.jpg"))); // NOI18N
        jpTelaCadastroUsuarioAcolheImagemAzulMenu.add(jlTelaFundoJPcadastroUsuarioMenu);
        jlTelaFundoJPcadastroUsuarioMenu.setBounds(20, 80, 130, 570);

        jlTelaCadastroUsuarioJPmenuDe.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jlTelaCadastroUsuarioJPmenuDe.setText("de");
        jpTelaCadastroUsuarioAcolheImagemAzulMenu.add(jlTelaCadastroUsuarioJPmenuDe);
        jlTelaCadastroUsuarioJPmenuDe.setBounds(70, 20, 40, 30);

        getContentPane().add(jpTelaCadastroUsuarioAcolheImagemAzulMenu);
        jpTelaCadastroUsuarioAcolheImagemAzulMenu.setBounds(60, 20, 170, 670);

        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Cadastro de Usuários", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 1, 18))); // NOI18N
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.setLayout(null);

        jlCadastroUsuarioJPnome.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jlCadastroUsuarioJPnome.setForeground(new java.awt.Color(255, 255, 255));
        jlCadastroUsuarioJPnome.setText("Nome");
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jlCadastroUsuarioJPnome);
        jlCadastroUsuarioJPnome.setBounds(230, 180, 60, 30);

        jlCadastroUsuarioJPtelefone.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jlCadastroUsuarioJPtelefone.setForeground(new java.awt.Color(255, 255, 255));
        jlCadastroUsuarioJPtelefone.setText("Telefone");
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jlCadastroUsuarioJPtelefone);
        jlCadastroUsuarioJPtelefone.setBounds(230, 300, 80, 30);

        jlCadastroUsuarioJPadmissao.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jlCadastroUsuarioJPadmissao.setForeground(new java.awt.Color(255, 255, 255));
        jlCadastroUsuarioJPadmissao.setText("Admissão");
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jlCadastroUsuarioJPadmissao);
        jlCadastroUsuarioJPadmissao.setBounds(230, 220, 80, 30);

        jlCadastroUsuarioJPtipoSanguineo.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jlCadastroUsuarioJPtipoSanguineo.setForeground(new java.awt.Color(255, 255, 255));
        jlCadastroUsuarioJPtipoSanguineo.setText("Tipo Sanguineo");
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jlCadastroUsuarioJPtipoSanguineo);
        jlCadastroUsuarioJPtipoSanguineo.setBounds(230, 340, 130, 30);

        jlCadastroUsuarioJPperfil.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jlCadastroUsuarioJPperfil.setForeground(new java.awt.Color(255, 255, 255));
        jlCadastroUsuarioJPperfil.setText("Perfil");
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jlCadastroUsuarioJPperfil);
        jlCadastroUsuarioJPperfil.setBounds(230, 380, 100, 30);

        jlCadastroUsuarioJPsenha.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jlCadastroUsuarioJPsenha.setForeground(new java.awt.Color(255, 255, 255));
        jlCadastroUsuarioJPsenha.setText("Senha");
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jlCadastroUsuarioJPsenha);
        jlCadastroUsuarioJPsenha.setBounds(230, 460, 70, 30);

        jlCadastroUsuarioJPMatricula.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jlCadastroUsuarioJPMatricula.setForeground(new java.awt.Color(255, 255, 255));
        jlCadastroUsuarioJPMatricula.setText("Matricula");
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jlCadastroUsuarioJPMatricula);
        jlCadastroUsuarioJPMatricula.setBounds(230, 140, 80, 30);

        jlCadastroUsuarioJPlogin.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jlCadastroUsuarioJPlogin.setForeground(new java.awt.Color(255, 255, 255));
        jlCadastroUsuarioJPlogin.setText("Login");
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jlCadastroUsuarioJPlogin);
        jlCadastroUsuarioJPlogin.setBounds(230, 420, 50, 30);

        jlCadastroUsuarioJPfuncao.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jlCadastroUsuarioJPfuncao.setForeground(new java.awt.Color(255, 255, 255));
        jlCadastroUsuarioJPfuncao.setText("Função");
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jlCadastroUsuarioJPfuncao);
        jlCadastroUsuarioJPfuncao.setBounds(230, 260, 60, 30);
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jtfCadastroUsuarioJPtipoSanguineo);
        jtfCadastroUsuarioJPtipoSanguineo.setBounds(410, 340, 100, 30);
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jtfCadastroUsuarioJPnome);
        jtfCadastroUsuarioJPnome.setBounds(410, 180, 300, 30);
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jtfCadastroUsuarioJPfuncao);
        jtfCadastroUsuarioJPfuncao.setBounds(410, 260, 130, 30);
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jtfCadastroUsuarioJPmatricula);
        jtfCadastroUsuarioJPmatricula.setBounds(410, 140, 130, 30);
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jtfCadastroUsuarioJPlogin);
        jtfCadastroUsuarioJPlogin.setBounds(410, 420, 130, 30);
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jpfCadastroUsuarioJPsenha);
        jpfCadastroUsuarioJPsenha.setBounds(410, 460, 130, 30);

        jftfCadastroUsuarioJPadmissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftfCadastroUsuarioJPadmissaoActionPerformed(evt);
            }
        });
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jftfCadastroUsuarioJPadmissao);
        jftfCadastroUsuarioJPadmissao.setBounds(410, 220, 130, 30);
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jftflCadastroUsuarioJPtelefone);
        jftflCadastroUsuarioJPtelefone.setBounds(410, 300, 130, 30);

        jcbCadastroUsuarioJPperfil.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jcbCadastroUsuarioJPperfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Administrador", "Caixa", "Usuário do Sistema", " " }));
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jcbCadastroUsuarioJPperfil);
        jcbCadastroUsuarioJPperfil.setBounds(410, 380, 200, 30);

        jlTelaFundoJPcadastroUsuarioUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jlTelaFundoJPcadastroUsuarioUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/supermercado/icones/imagemGrafiteTelaFundoJPcadastroUsuarioMenu.jpg"))); // NOI18N
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jlTelaFundoJPcadastroUsuarioUsuario);
        jlTelaFundoJPcadastroUsuarioUsuario.setBounds(20, 50, 790, 600);

        jlTelaCadastroUsuaarioCadastroUsuario.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jlTelaCadastroUsuaarioCadastroUsuario.setText("do Sistema");
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.add(jlTelaCadastroUsuaarioCadastroUsuario);
        jlTelaCadastroUsuaarioCadastroUsuario.setBounds(350, 20, 140, 20);

        getContentPane().add(jpTelaCadastroUsuarioAcolheImagemAzulUsuarios);
        jpTelaCadastroUsuarioAcolheImagemAzulUsuarios.setBounds(470, 20, 830, 670);

        jlTelaCadastroUsuarioTelaFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/supermercado/icones/imagemGrafiteTelaFundoJPcadastroUsuarioMenu.jpg"))); // NOI18N
        getContentPane().add(jlTelaCadastroUsuarioTelaFundo);
        jlTelaCadastroUsuarioTelaFundo.setBounds(0, -20, 1390, 750);

        setSize(new java.awt.Dimension(1385, 763));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jftfCadastroUsuarioJPadmissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftfCadastroUsuarioJPadmissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jftfCadastroUsuarioJPadmissaoActionPerformed

    private void jbTelaCadastroUsuarioMenuOpcoesAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTelaCadastroUsuarioMenuOpcoesAdicionarActionPerformed
     Adicionar();
    }//GEN-LAST:event_jbTelaCadastroUsuarioMenuOpcoesAdicionarActionPerformed

    private void jbTelaCadastroUsuarioMenuOpcoesConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTelaCadastroUsuarioMenuOpcoesConsultarActionPerformed
     Consultar();
    }//GEN-LAST:event_jbTelaCadastroUsuarioMenuOpcoesConsultarActionPerformed

    private void jbTelaCadastroUsuarioMenuOpcoesAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTelaCadastroUsuarioMenuOpcoesAtualizarActionPerformed
     Atualizar();
    }//GEN-LAST:event_jbTelaCadastroUsuarioMenuOpcoesAtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jbTelaCadastroUsuarioMenuOpcoesAdicionar;
    private javax.swing.JButton jbTelaCadastroUsuarioMenuOpcoesAtualizar;
    private javax.swing.JButton jbTelaCadastroUsuarioMenuOpcoesConsultar;
    private javax.swing.JComboBox<String> jcbCadastroUsuarioJPperfil;
    private javax.swing.JFormattedTextField jftfCadastroUsuarioJPadmissao;
    private javax.swing.JFormattedTextField jftflCadastroUsuarioJPtelefone;
    private javax.swing.JLabel jlCadastroUsuarioJPMatricula;
    private javax.swing.JLabel jlCadastroUsuarioJPadmissao;
    private javax.swing.JLabel jlCadastroUsuarioJPfuncao;
    private javax.swing.JLabel jlCadastroUsuarioJPlogin;
    private javax.swing.JLabel jlCadastroUsuarioJPnome;
    private javax.swing.JLabel jlCadastroUsuarioJPperfil;
    private javax.swing.JLabel jlCadastroUsuarioJPsenha;
    private javax.swing.JLabel jlCadastroUsuarioJPtelefone;
    private javax.swing.JLabel jlCadastroUsuarioJPtipoSanguineo;
    private javax.swing.JLabel jlTelaCadastroUsuaarioCadastroUsuario;
    private javax.swing.JLabel jlTelaCadastroUsuarioJPmenuDe;
    private javax.swing.JLabel jlTelaCadastroUsuarioJPmenuOpcoes;
    private javax.swing.JLabel jlTelaCadastroUsuarioTelaFundo;
    private javax.swing.JLabel jlTelaFundoJPcadastroUsuarioMenu;
    private javax.swing.JLabel jlTelaFundoJPcadastroUsuarioUsuario;
    private javax.swing.JPanel jpTelaCadastroUsuarioAcolheImagemAzulMenu;
    private javax.swing.JPanel jpTelaCadastroUsuarioAcolheImagemAzulUsuarios;
    private javax.swing.JPasswordField jpfCadastroUsuarioJPsenha;
    private javax.swing.JTextField jtfCadastroUsuarioJPfuncao;
    private javax.swing.JTextField jtfCadastroUsuarioJPlogin;
    private javax.swing.JTextField jtfCadastroUsuarioJPmatricula;
    private javax.swing.JTextField jtfCadastroUsuarioJPnome;
    private javax.swing.JTextField jtfCadastroUsuarioJPtipoSanguineo;
    // End of variables declaration//GEN-END:variables
}
