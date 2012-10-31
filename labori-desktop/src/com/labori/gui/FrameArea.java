/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labori.gui;

import com.labori.dao.impl.CompanyDAOImpl;
import javax.swing.JList;

/**
 *
 * @author Rony_2
 */
public class FrameArea extends javax.swing.JFrame {

	private Company empresaSelecionada;
	private MenuAdmin menuAdmin;
	private CompanyDAOImpl companyDao;

	public MenuAdmin getMenuAdmin() {
		return menuAdmin;
	}

	public void setMenuAdmin(MenuAdmin menuAdmin) {
		this.menuAdmin = menuAdmin;
	}

	public Company getEmpresaSelecionada() {
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(Company empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}
	private FormularioEmpresa formularioEmpresa;

	public void atualizarListaEmpresa() {
		initComponents();
	}

	/**
	 * Creates new form FrameEmpresa
	 */
	public FrameArea() {
		this.formularioEmpresa = new FormularioEmpresa();
		this.formularioEmpresa.setFrameEmpresa(this);
		this.companyDao = new CompanyDAOImpl();
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        laboriPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("laboriPU").createEntityManager();
        companyQuery = java.beans.Beans.isDesignTime() ? null : laboriPUEntityManager.createQuery("SELECT c FROM Company c");
        companyList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : companyQuery.getResultList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listEmpresa = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        btnRemoverEmpresa = new javax.swing.JButton();
        btnAdicionarEmpresa = new javax.swing.JButton();
        btnEditarEmpresa = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Labori - Sistema de Gerenciamento de Currículos");

        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, companyList, listEmpresa);
        bindingGroup.addBinding(jListBinding);

        listEmpresa.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listEmpresaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listEmpresa);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Gerenciamento de Empresas");

        btnRemoverEmpresa.setText("Remover");
        btnRemoverEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverEmpresaActionPerformed(evt);
            }
        });

        btnAdicionarEmpresa.setText("Adicionar");
        btnAdicionarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarEmpresaActionPerformed(evt);
            }
        });

        btnEditarEmpresa.setText("Editar");
        btnEditarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEmpresaActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar Lista");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnVoltar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditarEmpresa)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnAdicionarEmpresa)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnRemoverEmpresa))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addComponent(btnAtualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAtualizar)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoverEmpresa)
                    .addComponent(btnAdicionarEmpresa)
                    .addComponent(btnEditarEmpresa)
                    .addComponent(btnVoltar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void btnAdicionarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarEmpresaActionPerformed
		this.formularioEmpresa.setEmpresa(new Company());
		this.formularioEmpresa.mostrarDados();
		this.formularioEmpresa.setVisible(true);
		this.setVisible(false);
	}//GEN-LAST:event_btnAdicionarEmpresaActionPerformed

	private void listEmpresaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listEmpresaValueChanged
		JList lista = (JList) evt.getSource();
		this.empresaSelecionada = (Company) lista.getSelectedValue();
	}//GEN-LAST:event_listEmpresaValueChanged

	private void btnEditarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEmpresaActionPerformed
		this.formularioEmpresa.setEmpresa(this.empresaSelecionada);
		this.formularioEmpresa.mostrarDados();
		this.formularioEmpresa.setVisible(true);
		this.setVisible(false);
	}//GEN-LAST:event_btnEditarEmpresaActionPerformed

	private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
		this.setVisible(false);
		this.menuAdmin.setVisible(true);
	}//GEN-LAST:event_btnVoltarActionPerformed

	private void btnRemoverEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverEmpresaActionPerformed
		if(this.empresaSelecionada!=null){
			this.listEmpresa.remove(0);
			this.companyDao.delete(this.empresaSelecionada);
			atualizarListaEmpresa();
		}
	}//GEN-LAST:event_btnRemoverEmpresaActionPerformed

	private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
		atualizarListaEmpresa();
	}//GEN-LAST:event_btnAtualizarActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/*
		 * Set the Nimbus look and feel
		 */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FrameArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FrameArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FrameArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FrameArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new FrameArea().setVisible(true);
			}
		});
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarEmpresa;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnEditarEmpresa;
    private javax.swing.JButton btnRemoverEmpresa;
    private javax.swing.JButton btnVoltar;
    private java.util.List<com.labori.gui.Company> companyList;
    private javax.persistence.Query companyQuery;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.persistence.EntityManager laboriPUEntityManager;
    private javax.swing.JList listEmpresa;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
