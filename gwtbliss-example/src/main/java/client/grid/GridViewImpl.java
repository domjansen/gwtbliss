/*
 * Copyright 2013, devbliss GmbH
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package client.grid;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * Default implementation of {@link GridPresenter.View}.
 * 
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 * 
 */
public class GridViewImpl extends ViewImpl implements GridPresenter.View {

    public interface GridViewImplUiBinder extends UiBinder<Widget, GridViewImpl> {
    }

    @UiField
    SimplePanel mainContentPanel;

    private final Widget widget;

    @Inject
    public GridViewImpl(final GridViewImplUiBinder uiBinder) {
        this.widget = uiBinder.createAndBindUi(this);
        this.widget.ensureDebugId(GridViewImpl.class.getName());
    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    @Override
    public void setInSlot(final Object slot, final IsWidget content) {
        if (slot == GridPresenter.MAIN_SLOT) {
            setWidgetContent(mainContentPanel, content);
        } else {
            super.setInSlot(slot, content);
        }
    }

    /**
     * Clear the given panel and set a new widget.
     */
    private void setWidgetContent(final SimplePanel simplePanel, final IsWidget content) {
        simplePanel.clear();
        if (content != null) {
            simplePanel.setWidget(content);
        }
    }

}
