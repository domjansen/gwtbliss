package com.devbliss.gwt.commons.client.widget.dialog.message;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;

/**
 * Unit tests for {@link SimpleMessageDialogBoxPresenter}
 * 
 * @author bmary
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class SimpleMessageDialogBoxPresenterTest {

    private static final String MESSAGE = "message";
    private static final String TITLE = "title";

    @Mock
    private EventBus eventBus;
    @Mock
    private SimpleMessageDialogBoxView view;

    @Captor
    private ArgumentCaptor<ClickHandler> clickCaptor;

    private SimpleMessageDialogBoxPresenter presenter;

    @Before
    public void setUp() {
        presenter = new SimpleMessageDialogBoxPresenter(eventBus, view);
    }

    @Test
    public void clickOnOk() {
        presenter.onBind();

        verify(view).setOkClickHandler(clickCaptor.capture());

        clickCaptor.getValue().onClick(null);
        verify(view).hideDialog();
    }

    @Test
    public void clickOnCancel() {
        presenter.onBind();

        verify(view).setCancelClickHandler(clickCaptor.capture());

        clickCaptor.getValue().onClick(null);
        verify(view).hideDialog();
    }

    @Test
    public void open() {
        presenter.open(TITLE, MESSAGE);
        verify(view).setTitleOfDialog(TITLE);
        verify(view).setMessage(MESSAGE);
        verify(view).showDialog();
    }
}
