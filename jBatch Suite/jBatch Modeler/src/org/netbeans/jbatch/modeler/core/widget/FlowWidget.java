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
package org.netbeans.jbatch.modeler.core.widget;

import org.netbeans.jbatch.modeler.job.file.JobFileDataObject;
import org.netbeans.jbatch.modeler.job.file.action.JobFileActionListener;
import org.netbeans.jbatch.modeler.spec.Flow;
import org.netbeans.jbatch.modeler.spec.core.Definitions;
import org.netbeans.modeler.core.ModelerFile;
import org.netbeans.modeler.specification.model.document.IModelerScene;
import org.netbeans.modeler.specification.model.document.property.ElementPropertySet;
import org.netbeans.modeler.widget.node.info.NodeWidgetInfo;

public class FlowWidget extends ActivityWidget {

    public FlowWidget(IModelerScene scene, NodeWidgetInfo node) {
        super(scene, node);
    }

    @Override
    public void createPropertySet(ElementPropertySet set) {
        super.createPropertySet(set);
//        set.createPropertySet( this , ((Step) this.getBaseElementSpec()).getBatchlet(), getPropertyChangeListeners());
//        Step stepSpec = (Step) this.getBaseElementSpec();
//        set.put("BASIC_PROP", JobUtil.addProperty(this.getModelerScene().getModelerFile(), stepSpec.getBatchlet().getProperties()));

    }

    public void openDiagram() {
        Flow flow = (Flow) this.getBaseElementSpec();
        String path = this.getModelerScene().getModelerPanelTopComponent().getToolTipText();
        JobFileActionListener fileAction = new JobFileActionListener(this.getModelerScene().getModelerFile().getModelerFileDataObject());
//        fileAction.setDefinitionId(flow.getId());
        if (flow.getName() == null || flow.getName().trim().isEmpty()) {
            fileAction.openModelerFile(flow.getId(),flow.getKey(),flow.getKey() + " > " + path);
        } else {
            fileAction.openModelerFile(flow.getId(),flow.getName(),flow.getName() + " > " + path);
        }
        
    }

    @Override
    public void destroy() {
        ModelerFile modelerFile = this.getModelerScene().getModelerFile();
        Definitions definitions = (Definitions) modelerFile.getDefinitionElement();
        definitions.addGarbageDefinitions(this.getId());

//        closeDiagram();
    }

    public boolean isAddedToSplitter() {
        if (this.getIncomingSequenceFlows().size() == 1 && this.getOutgoingSequenceFlows().size() == 1) {
            if (this.getIncomingSequenceFlows().get(0) instanceof SplitterInputConnectionWidget
                    && this.getOutgoingSequenceFlows().get(0) instanceof SplitterOutputConnectionWidget) {
                return true;
            }
        }
        return false;
    }
}
