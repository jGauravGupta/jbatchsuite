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

import org.netbeans.jbatch.modeler.spec.Step;
import org.netbeans.jbatch.modeler.specification.model.job.util.JobUtil;
import org.netbeans.modeler.config.element.ElementConfigFactory;
import org.netbeans.modeler.properties.nentity.NEntityPropertySupport;
import org.netbeans.modeler.specification.model.document.IModelerScene;
import org.netbeans.modeler.specification.model.document.property.ElementPropertySet;
import org.netbeans.modeler.widget.node.info.NodeWidgetInfo;

public class BatchletWidget extends StepWidget {

    public BatchletWidget(IModelerScene scene, NodeWidgetInfo node) {
        super(scene, node);
    }

    @Override
    public void createPropertySet(ElementPropertySet set) {
        super.createPropertySet(set);
        set.createPropertySet(this, ((Step) this.getBaseElementSpec()).getBatchlet(), getPropertyChangeListeners());
        Step stepSpec = (Step) this.getBaseElementSpec();
        set.put("BASIC_PROP",new NEntityPropertySupport(this.getModelerScene().getModelerFile(),JobUtil.addProperty(stepSpec.getBatchlet().getProperties())));

    }
}
