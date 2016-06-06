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
package esa.mo.tools.mowindow;

import esa.mo.helpertools.helpers.HelperAttributes;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ccsds.moims.mo.mal.structures.Union;

/**
 *
 * @author Cesar Coelho
 */
public abstract class MOelement extends javax.swing.JPanel {

    Object object = null;
    boolean editable;

    @SuppressWarnings("unchecked")
    public MOelement(String fieldName, Object obj, boolean editable, boolean objIsNull){
        initComponents();
        
        this.fieldName.setText(fieldName);
        String className = "--";

        if (obj != null){
            className = obj.getClass().getSimpleName();
            mainPanel.remove(this.fieldSelectableAttribute);
        }else{
            mainPanel.remove(this.fieldType);
            this.fieldSelectableAttribute.removeAllItems();
            
            for (int index = 0; index < 18 ; index++ ){
                this.fieldSelectableAttribute.addItem(HelperAttributes.typeShortForm2attributeName(index));
            }
            
//            String asfgsf = (String)  this.fieldSelectableAttribute.getItemAt(1);
//            asfgsf = "dsdcs";

        }

        if (obj instanceof Union){
            try {
                Field field = obj.getClass().getDeclaredField("value");
                Field fieldTypeShortForm = obj.getClass().getDeclaredField("typeShortForm");
                field.setAccessible(true);
                fieldTypeShortForm.setAccessible(true);

                Integer typeShortForm = (Integer) fieldTypeShortForm.get(obj);
                className = HelperAttributes.typeShortForm2attributeName(typeShortForm);

            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException ex) {
                Logger.getLogger(MOelement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (className.endsWith("List")){
            className = "List<" + className.substring(0, className.length()-4) + ">";
        }
        
        if (objIsNull){
            this.makeFieldNull();
        }
        
        if (!editable){
            this.nullCB.setEnabled(false);
        }
        
        this.fieldType.setText(className);
        this.editable = editable;
        this.object = obj;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        fieldName = new javax.swing.JLabel();
        fieldType = new javax.swing.JLabel();
        fieldSelectableAttribute = new javax.swing.JComboBox();
        middlePanel = new javax.swing.JPanel();
        nullCB = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(600, 35));

        mainPanel.setPreferredSize(new java.awt.Dimension(153, 23));
        mainPanel.setLayout(new java.awt.GridLayout(1, 1, 15, 0));

        fieldName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        fieldName.setText("jLabel1");
        mainPanel.add(fieldName);

        fieldType.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fieldType.setText("jLabel1");
        mainPanel.add(fieldType);

        fieldSelectableAttribute.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fieldSelectableAttribute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldSelectableAttributeActionPerformed(evt);
            }
        });
        mainPanel.add(fieldSelectableAttribute);

        middlePanel.setLayout(new java.awt.GridLayout(1, 0));
        mainPanel.add(middlePanel);

        nullCB.setText("null");
        nullCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nullCBActionPerformed(evt);
            }
        });
        mainPanel.add(nullCB);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nullCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nullCBActionPerformed
        for (int i = 0 ; i < this.middlePanel.getComponentCount(); i++){
            this.middlePanel.getComponent(i).setEnabled(!this.middlePanel.getComponent(i).isEnabled());
        }
        
        this.fieldSelectableAttribute.setEnabled(!this.fieldSelectableAttribute.isEnabled());
    }//GEN-LAST:event_nullCBActionPerformed

    private void fieldSelectableAttributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldSelectableAttributeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldSelectableAttributeActionPerformed

    public final void makeFieldNull(){
        for (int i = 0 ; i < this.middlePanel.getComponentCount(); i++){
            this.middlePanel.getComponent(i).setEnabled(false);
            this.nullCB.setSelected(true);
        }

        this.fieldSelectableAttribute.setEnabled(false);
    }
    
    public javax.swing.JLabel getFieldNameLabel(){
        return fieldName;
    }
    
    public String getFieldTypeString(){
        return this.fieldType.getText();
    }
    
    /**
     *
     * @return
     */
    abstract public Object getObject();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel fieldName;
    protected javax.swing.JComboBox fieldSelectableAttribute;
    protected javax.swing.JLabel fieldType;
    protected javax.swing.JPanel mainPanel;
    protected javax.swing.JPanel middlePanel;
    protected javax.swing.JCheckBox nullCB;
    // End of variables declaration//GEN-END:variables
}
