package com.school.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class School implements EntryPoint {

    private VerticalPanel mainPanel = new VerticalPanel();
    private FlexTable stocksFlexTable = new FlexTable();
    private HorizontalPanel addPanel = new HorizontalPanel();
    private TextBox newSymbolTextBox = new TextBox();
    private Button addStockButton = new Button("Add");
    private Label lastUpdatedLabel = new Label();

    /**
     * Entry point method.
     */
    public void onModuleLoad() {
        // Create table for stock data.
        stocksFlexTable.setText(0, 0, "Фамилия");
        stocksFlexTable.setText(0, 1, "Имя");
        stocksFlexTable.setText(0, 2, "Отчество");
        stocksFlexTable.setText(0, 3, "Был/Не был");

        // Assemble Add Stock panel.
        //addPanel.add(newSymbolTextBox);
        //addPanel.add(addStockButton);

        // Assemble Main panel.
        mainPanel.add(stocksFlexTable);
        mainPanel.add(addPanel);
        //mainPanel.add(lastUpdatedLabel);

        // Associate the Main panel with the HTML host page.
        RootPanel.get("School").add(mainPanel);

        // Move cursor focus to the input box.
        //newSymbolTextBox.setFocus(true);
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}
