package br.edu.ifpb.padroes.visao.pesquisa;

import br.edu.ifpb.padroes.modelo.Gerente;
import br.edu.ifpb.padroes.servico.ContaUsuarioService;
import br.edu.ifpb.padroes.servico.GerenteService;
import br.edu.ifpb.padroes.visao.principal.TelaAdmin;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class TelaPesquisaGerente extends javax.swing.JFrame {
    
    public TelaPesquisaGerente() throws ParseException, SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.editar.setEnabled(false);
        this.excluir.setEnabled(false);
        this.salvar.setEnabled(false);
        
        this.cpf.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
        this.nome.setEditable(false);
        this.rg.setEditable(false);
        this.telefone.setEditable(false);
        this.dataNasc.setEditable(false);
        this.email.setEditable(false);
        this.cidade.setEditable(false);
        this.bairro.setEditable(false);
        this.rua.setEditable(false);
        this.numero.setEditable(false);
        this.agencia.setEditable(false);
        
    }
    
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        telefone = new javax.swing.JTextField();
        bairro = new javax.swing.JTextField();
        rua = new javax.swing.JTextField();
        rg = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        numero = new javax.swing.JTextField();
        cidade = new javax.swing.JTextField();
        salvar = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        dataNasc = new javax.swing.JFormattedTextField();
        cpf = new javax.swing.JFormattedTextField();
        pesquisar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        agencia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PESQUISA - ADMINISTRADOR");

        jLabel1.setText("Nome:");

        jLabel2.setText("CPF:");

        jLabel3.setText("RG:");

        jLabel4.setText("Nascimento:");

        jLabel6.setText("Cidade:");

        jLabel7.setText("Bairro:");

        jLabel8.setText("Rua:");

        jLabel9.setText("Numero:");

        jLabel10.setText("Telefone:");

        jLabel11.setText("Email:");

        telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneActionPerformed(evt);
            }
        });

        bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bairroActionPerformed(evt);
            }
        });

        rua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruaActionPerformed(evt);
            }
        });

        rg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rgActionPerformed(evt);
            }
        });

        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfActionPerformed(evt);
            }
        });

        pesquisar.setText("Pesquisar");
        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel5.setText("PESQUISAR - GERENTE");

        jLabel12.setText("Agência:");

        agencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(editar)
                        .addGap(18, 18, 18)
                        .addComponent(excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(voltar)
                        .addGap(18, 18, 18)
                        .addComponent(salvar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(dataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(rg)
                                            .addComponent(cpf, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addComponent(pesquisar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(199, 199, 199)
                                .addComponent(jLabel5)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(rua, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(agencia, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(agencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvar)
                    .addComponent(voltar)
                    .addComponent(editar)
                    .addComponent(excluir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        this.dispose();
        new TelaAdmin().setVisible(true);
    }//GEN-LAST:event_voltarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        this.nome.setEditable(true);
        this.rg.setEditable(true);
        this.telefone.setEditable(true);
        this.dataNasc.setEditable(true);
        this.email.setEditable(true);
        this.cidade.setEditable(true);
        this.bairro.setEditable(true);
        this.rua.setEditable(true);
        this.numero.setEditable(true);
        this.agencia.setEditable(true);
        
        this.pesquisar.setEnabled(false);
        this.excluir.setEnabled(false);
        this.salvar.setEnabled(true);

    }//GEN-LAST:event_editarActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
        
        try {
            
            Gerente gerente;
            GerenteService gerenteService = new GerenteService();
            gerente = gerenteService.pesquisarGerente(this.cpf.getText());
            
            if (gerente == null) {
                JOptionPane.showMessageDialog(null, "Nenhum gerente encontrado !");
            } else {
                this.cpf.setText(gerente.getCpf());
                this.nome.setText(gerente.getNome());
                this.rg.setText(gerente.getRg());
                this.cidade.setText(gerente.getCidade());
                this.telefone.setText(gerente.getTelefone());
                this.dataNasc.setText(gerente.getDataNasc());
                this.email.setText(gerente.getEmail());
                this.bairro.setText(gerente.getBairro());
                this.rua.setText(gerente.getRua());
                this.numero.setText(gerente.getNumCasa());
                this.agencia.setText(gerente.getAgencia().getNumero());
                
                this.nome.setEditable(false);
                this.rg.setEditable(false);
                this.telefone.setEditable(false);
                this.dataNasc.setEditable(false);
                this.email.setEditable(false);
                this.cidade.setEditable(false);
                this.bairro.setEditable(false);
                this.rua.setEditable(false);
                this.numero.setEditable(false);
                this.agencia.setEditable(false);
                
                this.editar.setEnabled(true);
                this.excluir.setEnabled(true);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaPesquisaGerente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_pesquisarActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        this.nome.setEditable(false);
        this.rg.setEditable(false);
        this.dataNasc.setEditable(false);
        this.telefone.setEditable(false);
        this.email.setEditable(false);
        this.cidade.setEditable(false);
        this.bairro.setEditable(false);
        this.rua.setEditable(false);
        this.numero.setEditable(false);
        this.agencia.setEditable(false);
        
        Gerente gerente = new Gerente();
        
        gerente.setCpf(this.cpf.getText());
        gerente.setNome(this.nome.getText());
        gerente.setRg(this.rg.getText());
        gerente.setDataNasc(this.dataNasc.getText());
        gerente.setTelefone(this.telefone.getText());
        gerente.setEmail(this.email.getText());
        gerente.setCidade(this.cidade.getText());
        gerente.setBairro(this.bairro.getText());
        gerente.setRua(this.rua.getText());
        gerente.setNumCasa(this.numero.getText());
        
        JOptionPane.showMessageDialog(null, "Gerente alterado com sucesso!");
        this.dispose();
        new TelaAdmin().setVisible(true);
        
        try {
            GerenteService gerenteService = new GerenteService();
            gerenteService.alterarGerente(gerente);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPesquisaGerente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(TelaPesquisaGerente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_salvarActionPerformed

    private void ruaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ruaActionPerformed

    private void telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefoneActionPerformed

    private void cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfActionPerformed

    private void rgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rgActionPerformed

    private void bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bairroActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        
        String cpfGerente = this.cpf.getText();
        
        JOptionPane.showMessageDialog(null, "Gerente Excluido com suceso!");
        this.dispose();
        new TelaAdmin().setVisible(true);
        
        try {
            GerenteService gerenteService = new GerenteService();
            gerenteService.deletarGerente(cpfGerente);
            
            ContaUsuarioService contaUsuarioService = new ContaUsuarioService();
            contaUsuarioService.deletarContaUsuario(cpfGerente);
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaPesquisaGerente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException ex) {
            Logger.getLogger(TelaPesquisaGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void agenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agenciaActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaPesquisaGerente().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(TelaPesquisaGerente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPesquisaGerente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agencia;
    private javax.swing.JTextField bairro;
    private javax.swing.JTextField cidade;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JFormattedTextField dataNasc;
    private javax.swing.JButton editar;
    private javax.swing.JTextField email;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField numero;
    private javax.swing.JButton pesquisar;
    private javax.swing.JTextField rg;
    private javax.swing.JTextField rua;
    private javax.swing.JButton salvar;
    private javax.swing.JTextField telefone;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
