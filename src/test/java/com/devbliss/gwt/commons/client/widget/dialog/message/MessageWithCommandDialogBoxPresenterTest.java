package com.devbliss.gwt.commons.client.widget.dialog.message;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Unit tests for {@link MessageWithCommandDialogBoxPresenter}
 * 
 * @author bmary
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class MessageWithCommandDialogBoxPresenterTest {

    private static final String MESSAGE = "message";
    private static final String TITLE = "title";

    @Mock
    private SimpleMessageDialogBoxView view;
    @Mock
    private EventBus eventBus;
    @Mock
    private Command command;

    @Captor
    private ArgumentCaptor<ClickHandler> clickCaptor;

    private MessageWithCommandDialogBoxPresenter presenter;

    @Before
    public void setUp() {
        presenter = new MessageWithCommandDialogBoxPresenter(eventBus, view);
    }

    @Test
    public void openDialog() {
        presenter.open(TITLE, MESSAGE, command);

        verify(view).setTitleOfDialog(TITLE);
        verify(view).setMessage(MESSAGE);
        verify(view).setCancelOptionVisible(true);
        verify(view).showDialog();
    }

    @Test
    public void openDialogHideCancel() {
        presenter.open(TITLE, MESSAGE, command, false);

        verify(view).setTitleOfDialog(TITLE);
        verify(view).setMessage(MESSAGE);
        verify(view).setCancelOptionVisible(false);
        verify(view).showDialog();
    }

    @Test
    public void clickOnOkCommandIsNotSet() {
        presenter.onBind();

        verify(view).setOkClickHandler(clickCaptor.capture());

        clickCaptor.getValue().onClick(null);
        verifyZeroInteractions(command);
        verify(view).hideDialog();
    }

    @Test
    public void clickOnOkCommandIsSet() {
        presenter.open(TITLE, MESSAGE, command);
        presenter.onBind();

        verify(view).setOkClickHandler(clickCaptor.capture());

        clickCaptor.getValue().onClick(null);
        verify(command).execute();
        verify(view).hideDialog();
    }

    @Test
    public void clickOnCancel() {
        presenter.onBind();

        verify(view).setCancelClickHandler(clickCaptor.capture());

        clickCaptor.getValue().onClick(null);
        verify(view).hideDialog();
    }
}
