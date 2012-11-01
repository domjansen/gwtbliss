package com.devbliss.gwt.commons.client.widget.dialog.message;

import com.devbliss.gwt.commons.client.widget.panel.CustomHTMLPanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.SubmitButton;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.gwtplatform.mvp.client.ViewImpl;

public class SimpleMessageDialogBoxViewImpl extends ViewImpl implements SimpleMessageDialogBoxView {

    public interface Binder extends UiBinder<Widget, SimpleMessageDialogBoxViewImpl> {
    }

    public final Widget widget;

    @UiField
    DialogBox mainDialogBox;

    @UiField
    CustomHTMLPanel customText;

    @UiField
    SubmitButton okButton;

    @UiField
    Anchor cancelAnchor;

    @Inject
    public SimpleMessageDialogBoxViewImpl(Binder binder) {
        widget = binder.createAndBindUi(this);

        mainDialogBox.setAnimationEnabled(true);
        mainDialogBox.setGlassEnabled(true);
        mainDialogBox.setAutoHideEnabled(true);
        mainDialogBox.setAutoHideOnHistoryEventsEnabled(true);
    }

    @Override
    public void hideDialog() {
        mainDialogBox.hide();
    }

    @Override
    public void showDialog() {
        mainDialogBox.center();
    }

    @Override
    public void setMessage(String message) {
        customText.setInnerText(message);
    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    @Override
    public void setTitleOfDialog(String title) {
        mainDialogBox.setText(title);
    }

    @Override
    public void setCancelOptionVisible(boolean visible) {
        cancelAnchor.setVisible(visible);
    }

    @Override
    public HandlerRegistration setOkClickHandler(ClickHandler clickHandler) {
        return okButton.addClickHandler(clickHandler);
    }

    @Override
    public HandlerRegistration setCancelClickHandler(ClickHandler clickHandler) {
        return cancelAnchor.addClickHandler(clickHandler);
    }
}
