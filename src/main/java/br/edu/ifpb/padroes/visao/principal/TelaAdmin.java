package br.edu.ifpb.padroes.visao.principal;

import br.edu.ifpb.padroes.visao.cadastro.TelaAssociarContaCliente;
import br.edu.ifpb.padroes.visao.cadastro.TelaCadastroAdmin;
import br.edu.ifpb.padroes.visao.cadastro.TelaCadastroAgencia;
import br.edu.ifpb.padroes.visao.cadastro.TelaCadastroConta;
import br.edu.ifpb.padroes.visao.cadastro.TelaCadastroGerente;
import br.edu.ifpb.padroes.visao.cadastro.TelaCadastroGerenteGeral;
import br.edu.ifpb.padroes.visao.login.Login;
import br.edu.ifpb.padroes.visao.operacao.TelaDeposito;
import br.edu.ifpb.padroes.visao.pesquisa.TelaPesquisaAdmin;
import br.edu.ifpb.padroes.visao.pesquisa.TelaPesquisaAgencia;
import br.edu.ifpb.padroes.visao.pesquisa.TelaPesquisaCliente;
import br.edu.ifpb.padroes.visao.pesquisa.TelaPesquisaConta;
import br.edu.ifpb.padroes.visao.pesquisa.TelaPesquisaGerente;
import br.edu.ifpb.padroes.visao.pesquisa.TelaPesquisaGerenteGeral;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaAdmin extends javax.swing.JFrame {

    public TelaAdmin() {
        initComponents();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        voltar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cadastroAdmin = new javax.swing.JMenuItem();
        cadastroAgencia = new javax.swing.JMenuItem();
        cadastroConta = new javax.swing.JMenuItem();
        cadastroGerente = new javax.swing.JMenuItem();
        cadastroGerenteG = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        pesquisaAdmin = new javax.swing.JMenuItem();
        pesquisaAgencia = new javax.swing.JMenuItem();
        pesquisaCliente = new javax.swing.JMenuItem();
        pesquisaConta = new javax.swing.JMenuItem();
        pesquisaGerente = new javax.swing.JMenuItem();
        pesquisaGerenteG = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        vincularCliente = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        resgistraSaque = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMINISTRADOR");

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(660, Short.MAX_VALUE)
                .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(347, Short.MAX_VALUE)
                .addComponent(voltar)
                .addContainerGap())
        );

        jMenu1.setText("Cadastrar");

        cadastroAdmin.setText("Administrador");
        cadastroAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroAdminActionPerformed(evt);
            }
        });
        jMenu1.add(cadastroAdmin);

        cadastroAgencia.setText("Agência");
        cadastroAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroAgenciaActionPerformed(evt);
            }
        });
        jMenu1.add(cadastroAgencia);

        cadastroConta.setText("Conta");
        cadastroConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroContaActionPerformed(evt);
            }
        });
        jMenu1.add(cadastroConta);

        cadastroGerente.setText("Gerente");
        cadastroGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroGerenteActionPerformed(evt);
            }
        });
        jMenu1.add(cadastroGerente);

        cadastroGerenteG.setText("Gerente Geral");
        cadastroGerenteG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroGerenteGActionPerformed(evt);
            }
        });
        jMenu1.add(cadastroGerenteG);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Pesquisar");

        pesquisaAdmin.setText("Administrador");
        pesquisaAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaAdminActionPerformed(evt);
            }
        });
        jMenu3.add(pesquisaAdmin);

        pesquisaAgencia.setText("Agência");
        pesquisaAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaAgenciaActionPerformed(evt);
            }
        });
        jMenu3.add(pesquisaAgencia);

        pesquisaCliente.setText("Cliente");
        pesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaClienteActionPerformed(evt);
            }
        });
        jMenu3.add(pesquisaCliente);

        pesquisaConta.setText("Conta");
        pesquisaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaContaActionPerformed(evt);
            }
        });
        jMenu3.add(pesquisaConta);

        pesquisaGerente.setText("Gerente");
        pesquisaGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaGerenteActionPerformed(evt);
            }
        });
        jMenu3.add(pesquisaGerente);

        pesquisaGerenteG.setText("Gerente Geral");
        pesquisaGerenteG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaGerenteGActionPerformed(evt);
            }
        });
        jMenu3.add(pesquisaGerenteG);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Vincular");

        vincularCliente.setText("Cliente");
        vincularCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vincularClienteActionPerformed(evt);
            }
        });
        jMenu2.add(vincularCliente);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Operações");

        resgistraSaque.setText("Regitrar Saque/Deposito");
        resgistraSaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resgistraSaqueActionPerformed(evt);
            }
        });
        jMenu5.add(resgistraSaque);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastroContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroContaActionPerformed
        this.dispose();
        try {
            new TelaCadastroConta().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(TelaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(TelaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cadastroContaActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        this.dispose();
        try {
            new Login().setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(TelaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_voltarActionPerformed

    private void cadastroAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroAdminActionPerformed
        this.dispose();
        try {
            new TelaCadastroAdmin().setVisible(true);

        } catch (ParseException ex) {
            Logger.getLogger(TelaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cadastroAdminActionPerformed

    private void cadastroGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroGerenteActionPerformed
        this.dispose();
        try {
            new TelaCadastroGerente().setVisible(true);

        } catch (ParseException ex) {
            Logger.getLogger(TelaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cadastroGerenteActionPerformed

    private void cadastroGerenteGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroGerenteGActionPerformed
        this.dispose();
        try {
            new TelaCadastroGerenteGeral().setVisible(true);

        } catch (ParseException ex) {
            Logger.getLogger(TelaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cadastroGerenteGActionPerformed

    private void pesquisaAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaAdminActionPerformed
        this.dispose();
        try {
            new TelaPesquisaAdmin().setVisible(true);

        } catch (ParseException ex) {
            Logger.getLogger(TelaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pesquisaAdminActionPerformed

    private void pesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaClienteActionPerformed
        this.dispose();
        try {
            new TelaPesquisaCliente().setVisible(true);

        } catch (ParseException ex) {
            Logger.getLogger(TelaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pesquisaClienteActionPerformed

    private void pesquisaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaContaActionPerformed
        this.dispose();
        new TelaPesquisaConta().setVisible(true);
    }//GEN-LAST:event_pesquisaContaActionPerformed

    private void pesquisaGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaGerenteActionPerformed
        this.dispose();
        try {
            new TelaPesquisaGerente().setVisible(true);

        } catch (ParseException ex) {
            Logger.getLogger(TelaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pesquisaGerenteActionPerformed

    private void pesquisaGerenteGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaGerenteGActionPerformed
        this.dispose();
        try {
            new TelaPesquisaGerenteGeral().setVisible(true);

        } catch (ParseException ex) {
            Logger.getLogger(TelaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pesquisaGerenteGActionPerformed

    private void cadastroAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroAgenciaActionPerformed
        this.dispose();
        new TelaCadastroAgencia().setVisible(true);
    }//GEN-LAST:event_cadastroAgenciaActionPerformed

    private void pesquisaAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaAgenciaActionPerformed
        this.dispose();
        try {
            new TelaPesquisaAgencia().setVisible(true);

        } catch (ParseException ex) {
            Logger.getLogger(TelaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pesquisaAgenciaActionPerformed

    private void vincularClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vincularClienteActionPerformed
        this.dispose();
        try {
            new TelaAssociarContaCliente().setVisible(true);

        } catch (ParseException ex) {
            Logger.getLogger(TelaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_vincularClienteActionPerformed

    private void resgistraSaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resgistraSaqueActionPerformed

        try {
            this.dispose();
            new TelaDeposito().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TelaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_resgistraSaqueActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cadastroAdmin;
    private javax.swing.JMenuItem cadastroAgencia;
    private javax.swing.JMenuItem cadastroConta;
    private javax.swing.JMenuItem cadastroGerente;
    private javax.swing.JMenuItem cadastroGerenteG;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem pesquisaAdmin;
    private javax.swing.JMenuItem pesquisaAgencia;
    private javax.swing.JMenuItem pesquisaCliente;
    private javax.swing.JMenuItem pesquisaConta;
    private javax.swing.JMenuItem pesquisaGerente;
    private javax.swing.JMenuItem pesquisaGerenteG;
    private javax.swing.JMenuItem resgistraSaque;
    private javax.swing.JMenuItem vincularCliente;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
