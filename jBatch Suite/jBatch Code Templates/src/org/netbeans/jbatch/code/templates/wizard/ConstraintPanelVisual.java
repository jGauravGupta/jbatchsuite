/**
 * Copyright [2014] Gaurav Gupta
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.netbeans.jbatch.code.templates.wizard;

import java.util.HashSet;
import java.util.Set;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.openide.loaders.TemplateWizard;

public class ConstraintPanelVisual extends WizardPanel implements DocumentListener {

    /**
     * Creates new form ConstraintPanelVisual
     */
    public ConstraintPanelVisual(TemplateWizard wizard) {
        super(wizard);
        initComponents();
        injectedName_TextField.getDocument().addDocumentListener(this);
    }
    private final Set<ChangeListener> listeners = new HashSet<ChangeListener>(1);

    public final void addChangeListener(ChangeListener l) {
        synchronized (listeners) {
            listeners.add(l);
        }
    }

    public final void removeChangeListener(ChangeListener l) {
        synchronized (listeners) {
            listeners.remove(l);
        }
    }

    private void fireChangeEvent() {
        ChangeEvent e = new ChangeEvent(this);
        for (ChangeListener l : listeners) {
            l.stateChanged(e);
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

        injectedName_Label = new javax.swing.JLabel();
        injectedName_TextField = new javax.swing.JTextField();

        injectedName_Label.setText(org.openide.util.NbBundle.getMessage(ConstraintPanelVisual.class, "ConstraintPanelVisual.injectedName_Label.text")); // NOI18N

        injectedName_TextField.setColumns(20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(injectedName_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(injectedName_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(injectedName_Label)
                    .addComponent(injectedName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public boolean validateTemplate(TemplateWizard wizard) {
        this.setWizard(wizard);
        wizard.putProperty(TemplateWizard.PROP_ERROR_MESSAGE, null);
//        if ("".equals(injectedName_TextField.getText().trim())) {
//            wizard.putProperty(TemplateWizard.PROP_ERROR_MESSAGE, NbBundle.getMessage(ConstraintPanelVisual.class, "ERR_Empty_validator_class"));
//            return false;
//        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel injectedName_Label;
    private javax.swing.JTextField injectedName_TextField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
        fireChangeEvent();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        fireChangeEvent();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        fireChangeEvent();
    }

    public void store(TemplateWizard settings) {
        settings.putProperty(ConstraintIterator.WizardProperties.NAMED, injectedName_TextField.getText().trim());
    }
}
