/* ----------------------------------------------------------------------------
 * Copyright (C) 2015      European Space Agency
 *                         European Space Operations Centre
 *                         Darmstadt
 *                         Germany
 * ----------------------------------------------------------------------------
 * System                : ESA NanoSat MO Framework
 * ----------------------------------------------------------------------------
 * Licensed under the European Space Agency Public License, Version 2.0
 * You may not use this file except in compliance with the License.
 *
 * Except as expressly set forth in this License, the Software is provided to
 * You on an "as is" basis and without warranties of any kind, including without
 * limitation merchantability, fitness for a particular purpose, absence of
 * defects or errors, accuracy or non-infringement of intellectual property rights.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * ----------------------------------------------------------------------------
 */
package esa.mo.nmf.nmfpackage.assembler.gui;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author Cesar Coelho
 */
public final class AddModifyFiles extends javax.swing.JDialog {

    private final FilesSourceObject source;
    private final FilesTablePanel table = new FilesTablePanel();

    /**
     * Creates new form MOWindow
     *
     * @param source
     * @throws java.io.IOException
     */
    public AddModifyFiles(final FilesSourceObject source) throws IOException {
        initComponents();

        if (source == null) {
            throw new IOException("A null object was submitted!");
        }

        this.source = source;
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        componentsPanel.add(table); // Add the table to the middle
        componentsPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        addFiles = new javax.swing.JButton();
        removeSelectedFiles = new javax.swing.JButton();
        objectBodyButton2 = new javax.swing.JButton();
        componentsPanel = new javax.swing.JPanel();
        bottomPanel = new javax.swing.JPanel();
        button = new javax.swing.JToggleButton();

        setTitle("Add or Modify Files");
        setMinimumSize(new java.awt.Dimension(600, 550));
        setPreferredSize(new java.awt.Dimension(800, 340));

        topPanel.setPreferredSize(new java.awt.Dimension(100, 100));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Add or Modify Files");
        jLabel14.setToolTipText("");
        jLabel14.setMaximumSize(new java.awt.Dimension(1000, 22));
        jLabel14.setMinimumSize(new java.awt.Dimension(0, 22));
        jLabel14.setPreferredSize(null);

        addFiles.setText("Add Files");
        addFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFilesActionPerformed(evt);
            }
        });

        removeSelectedFiles.setText("Remove Selected Files");
        removeSelectedFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSelectedFilesActionPerformed(evt);
            }
        });

        objectBodyButton2.setText("-----");
        objectBodyButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objectBodyButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addFiles, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(removeSelectedFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(objectBodyButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addFiles)
                    .addComponent(removeSelectedFiles)
                    .addComponent(objectBodyButton2))
                .addContainerGap())
        );

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        componentsPanel.setMinimumSize(new java.awt.Dimension(150, 100));
        componentsPanel.setName(""); // NOI18N
        componentsPanel.setPreferredSize(new java.awt.Dimension(550, 200));

        javax.swing.GroupLayout componentsPanelLayout = new javax.swing.GroupLayout(componentsPanel);
        componentsPanel.setLayout(componentsPanelLayout);
        componentsPanelLayout.setHorizontalGroup(
            componentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        componentsPanelLayout.setVerticalGroup(
            componentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        getContentPane().add(componentsPanel, java.awt.BorderLayout.CENTER);

        bottomPanel.setMaximumSize(new java.awt.Dimension(3000, 32767));
        bottomPanel.setName(""); // NOI18N
        bottomPanel.setPreferredSize(new java.awt.Dimension(400, 40));

        button.setText("Submit");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button)
                .addContainerGap())
        );

        getContentPane().add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_buttonActionPerformed

    private void addFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFilesActionPerformed
        //Create a file chooser
        final JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(true);

        //In response to a button click:
        int returnVal = fc.showDialog(addFiles, "Add Files");

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] files = fc.getSelectedFiles();
        }

    }//GEN-LAST:event_addFilesActionPerformed

    private void removeSelectedFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSelectedFilesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeSelectedFilesActionPerformed

    private void objectBodyButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objectBodyButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objectBodyButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFiles;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JToggleButton button;
    private javax.swing.JPanel componentsPanel;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JButton objectBodyButton2;
    private javax.swing.JButton removeSelectedFiles;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables

}