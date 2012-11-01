package com.devbliss.gwt.commons.client.widget.dialog.message;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;

/**
 * A simple message dialog box. By clicking on ok, the dialog box get closed.
 * 
 * @author rbauer
 * 
 */
public class SimpleMessageDialogBoxPresenter extends PresenterWidget<SimpleMessageDialogBoxView> {

    private final SimpleMessageDialogBoxView view;

    @Inject
    public SimpleMessageDialogBoxPresenter(EventBus eventBus, SimpleMessageDialogBoxView view) {

        super(eventBus, view);
        this.view = view;
    }

    @Override
    protected void onBind() {

        registerHandler(view.setOkClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                view.hideDialog();
            }
        }));

        registerHandler(view.setCancelClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                view.hideDialog();
            }
        }));

    }

    public void open(String title, String message) {
        view.setTitleOfDialog(title);
        view.setMessage(message);
        view.showDialog();
    }

}
