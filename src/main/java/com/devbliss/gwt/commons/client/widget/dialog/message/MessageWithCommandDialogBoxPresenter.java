package com.devbliss.gwt.commons.client.widget.dialog.message;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;

/**
 * A simple message dialog box which takes a command for the ok button and can show/hide a cancel button.
 * 
 * @author rbauer
 * 
 */
public class MessageWithCommandDialogBoxPresenter extends PresenterWidget<SimpleMessageDialogBoxView> {

    private final SimpleMessageDialogBoxView view;

    protected Command command;

    @Inject
    public MessageWithCommandDialogBoxPresenter(EventBus eventBus, SimpleMessageDialogBoxView view) {

        super(eventBus, view);
        this.view = view;

    }

    @Override
    protected void onBind() {

        registerHandler(view.setOkClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

                if (command != null) {
                    command.execute();
                }

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

    /**
     * Open the dialog.
     * 
     * If user clicks on "ok" the command is executed...
     * 
     * Shows both cancel and ok buttons. So if cancel is clicked the command
     * is not executed.
     * 
     * @param title
     * @param message
     * @param command
     */
    public void open(String title, String message, Command command) {

        view.setTitleOfDialog(title);
        view.setMessage(message);
        view.setCancelOptionVisible(true);
        this.command = command;

        view.showDialog();

    }

    /**
     * Open the dialog.
     * 
     * When user clicks on "ok" the command is executed...
     * Lets you select if the cancel button is shown or not.
     * 
     * @param title
     * @param message
     * @param command
     * @param showCancelOption if the cancel option should be shown.
     */
    public void open(String title, String message, Command command, boolean showCancelOption) {

        view.setTitleOfDialog(title);
        view.setMessage(message);
        view.setCancelOptionVisible(showCancelOption);
        this.command = command;

        view.showDialog();

    }

}
