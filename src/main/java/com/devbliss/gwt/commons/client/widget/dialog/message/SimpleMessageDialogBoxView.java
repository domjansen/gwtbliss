package com.devbliss.gwt.commons.client.widget.dialog.message;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.gwtplatform.mvp.client.View;

public interface SimpleMessageDialogBoxView extends View {

    void setTitleOfDialog(String title);

    void setMessage(String message);

    void setCancelOptionVisible(boolean visible);

    void hideDialog();

    void showDialog();

    HandlerRegistration setOkClickHandler(ClickHandler clickHandler);

    HandlerRegistration setCancelClickHandler(ClickHandler clickHandler);
}