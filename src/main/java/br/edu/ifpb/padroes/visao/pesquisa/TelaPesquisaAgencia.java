package br.edu.ifpb.padroes.visao.pesquisa;

import br.edu.ifpb.padroes.modelo.Agencia;
import br.edu.ifpb.padroes.servico.AgenciaService;
import br.edu.ifpb.padroes.visao.principal.TelaAdmin;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaPesquisaAgencia extends javax.swing.JFrame {

    public TelaPesquisaAgencia() throws ParseException {
        initComponents();
        this.setLocationRelativeTo(null);

        this.editar.setEnabled(false);
        this.excluir.setEnabled(false);
        this.salvar.setEnabled(false);

        this.nome.setEditable(false);
        this.telefone.setEditable(false);
        this.cidade.setEditable(false);
        this.bairro.setEditable(false);
        this.rua.setEditable(false);
        this.numSede.setEditable(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        telefone = new javax.swing.JTextField();
        bairro = new javax.swing.JTextField();
        rua = new javax.swing.JTextField();
        numSede = new javax.swing.JTextField();
        cidade = new javax.swing.JTextField();
        salvar = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        numero = new javax.swing.JFormattedTextField();
        pesquisar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PESQUISA - ADMINISTRADOR");

        jLabel1.setText("Nome:");

        jLabel2.setText("Numero:");

        jLabel6.setText("Cidade:");

        jLabel7.setText("Bairro:");

        jLabel8.setText("Rua:");

        jLabel9.setText("Numero:");

        jLabel10.setText("Telefone:");

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

        numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroActionPerformed(evt);
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
        jLabel5.setText("PESQUISAR - AGÊNCIA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
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
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54)
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(59, 59, 59)
                                                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(pesquisar))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(177, 177, 177)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel10))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(numSede, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(0, 182, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(rua, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel5)
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(numSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
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
        this.telefone.setEditable(true);
        this.cidade.setEditable(true);
        this.bairro.setEditable(true);
        this.rua.setEditable(true);
        this.numSede.setEditable(true);

        this.pesquisar.setEnabled(false);
        this.excluir.setEnabled(false);
        this.salvar.setEnabled(true);

    }//GEN-LAST:event_editarActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed

        try {

            Agencia agencia;
            AgenciaService agenciaService = new AgenciaService();
            agencia = agenciaService.pesquisarAgencia(this.numero.getText());

            if (agencia == null) {
                JOptionPane.showMessageDialog(null, "Nenhuma agencia encontrado !");
            } else {
                this.numero.setText(agencia.getNumero());
                this.nome.setText(agencia.getNome());
                this.cidade.setText(agencia.getCidade());
                this.telefone.setText(agencia.getTelefone());
                this.bairro.setText(agencia.getBairro());
                this.rua.setText(agencia.getRua());
                this.numSede.setText(agencia.getNumSede());

                this.nome.setEditable(false);
                this.telefone.setEditable(false);
                this.cidade.setEditable(false);
                this.bairro.setEditable(false);
                this.rua.setEditable(false);
                this.numSede.setEditable(false);

                this.editar.setEnabled(true);
                this.excluir.setEnabled(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TelaPesquisaAgencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_pesquisarActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        this.nome.setEditable(false);
        this.telefone.setEditable(false);
        this.cidade.setEditable(false);
        this.bairro.setEditable(false);
        this.rua.setEditable(false);
        this.numSede.setEditable(false);

        Agencia agencia = new Agencia();

        agencia.setNumero(this.numero.getText());
        agencia.setNome(this.nome.getText());
        agencia.setTelefone(this.telefone.getText());
        agencia.setCidade(this.cidade.getText());
        agencia.setBairro(this.bairro.getText());
        agencia.setRua(this.rua.getText());
        agencia.setNumSede(this.numSede.getText());

        JOptionPane.showMessageDialog(null, "Agencia alterada com sucesso!");
        this.dispose();
        new TelaAdmin().setVisible(true);

        try {
            AgenciaService agenciaService = new AgenciaService();
            agenciaService.alterarAgencia(agencia);

        } catch (SQLException ex) {
            Logger.getLogger(TelaPesquisaAgencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TelaPesquisaAgencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_salvarActionPerformed

    private void ruaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ruaActionPerformed

    private void telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefoneActionPerformed

    private void numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroActionPerformed

    private void bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bairroActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed

        String numAgencia = this.numero.getText();

        JOptionPane.showMessageDialog(null, "Agencia Excluida com suceso!");
        this.dispose();
        new TelaAdmin().setVisible(true);

        try {
            AgenciaService agenciaService = new AgenciaService();
            agenciaService.deletarAgencia(numAgencia);

        } catch (SQLException ex) {
            Logger.getLogger(TelaPesquisaAgencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException ex) {
            Logger.getLogger(TelaPesquisaAgencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_excluirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaPesquisaAgencia().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(TelaPesquisaAgencia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bairro;
    private javax.swing.JTextField cidade;
    private javax.swing.JButton editar;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField numSede;
    private javax.swing.JFormattedTextField numero;
    private javax.swing.JButton pesquisar;
    private javax.swing.JTextField rua;
    private javax.swing.JButton salvar;
    private javax.swing.JTextField telefone;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
