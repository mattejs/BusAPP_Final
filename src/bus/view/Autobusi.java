/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.view;

import bus.controller.Obrada;
import bus.model.Autobus;
import bus.model.Linija;
import bus.pomocno.HibernateUtil;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Matej
 */
public class Autobusi extends javax.swing.JFrame {

    /**
     * Creates new form Autobusi
     */
    private Obrada<Autobus> obrada;

    public Autobusi() {
        initComponents();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        ucitajPodatke();
        obrada = new Obrada();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBrojSjedala = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRegistracija = new javax.swing.JTextField();
        btnNovi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Broj sjedala:");

        jLabel2.setText("Registracija:");

        btnNovi.setText("Dodaj novi");
        btnNovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoviActionPerformed(evt);
            }
        });

        lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        btnPromjeni.setText("Promjeni bus");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši bus");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovi, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBrojSjedala, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRegistracija, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnPromjeni, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBrojSjedala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtRegistracija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnNovi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPromjeni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnObrisi)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoviActionPerformed

        if (!kontrola()) {
            return;
        }

        Autobus a = new Autobus();
        a = napuniObjekt(a);
        obrada.save(a);
        ucitajPodatke();
    }//GEN-LAST:event_btnNoviActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        Autobus a = lista.getSelectedValue();

        if (a == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite autobus");
            return;
        }

        if (!kontrola()) {
            return;
        }

        a = napuniObjekt(a);
        obrada.save(a);
        ucitajPodatke();
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        Autobus a = lista.getSelectedValue();
        if (a == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite autobus");
            return;
        }

        boolean mozeObrisati = true;

        for (Linija l : a.getVozniRedovi()) {
            if (!a.isObrisano()) {
                mozeObrisati = false;
                break;
            }
        }

        if (!mozeObrisati) {
            JOptionPane.showMessageDialog(getParent(), "Autobus se ne može obrisati jer se nalazi na jednoj od linija");
            return;
        }

        obrada.delete(a);
        ucitajPodatke();
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void listaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }

        Autobus a = lista.getSelectedValue();

        if (a == null) {
            return;
        }

        txtBrojSjedala.setText(String.valueOf(a.getBrojSjedala()));
        txtRegistracija.setText(a.getRegistracija());
    }//GEN-LAST:event_listaValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovi;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Autobus> lista;
    private javax.swing.JTextField txtBrojSjedala;
    private javax.swing.JTextField txtRegistracija;
    // End of variables declaration//GEN-END:variables

    private Autobus napuniObjekt(Autobus a) {
        a.setBrojSjedala(Integer.parseInt(txtBrojSjedala.getText()));
        a.setRegistracija(txtRegistracija.getText());
        return a;
    }

    private void ucitajPodatke() {
        DefaultListModel<Autobus> model = new DefaultListModel<>();

        List<Autobus> lista = HibernateUtil.getSession().createQuery(
                "from Autobus a where a.obrisano=false").list();

        for (Autobus a : lista) {
            model.addElement(a);
        }

        this.lista.setModel(model);

    }

    private boolean kontrola() {

        if (txtBrojSjedala.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(getRootPane(), "Obavezan broj sjedala");
            return false;
        }

        if (txtRegistracija.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(getRootPane(), "Obavezan unos registracije");
            return false;
        }

        return true;
    }

}