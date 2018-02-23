package com.school.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class School implements EntryPoint {

    private VerticalPanel mainPanel = new VerticalPanel();
    private FlexTable schoolFlexTable = new FlexTable();
    private HorizontalPanel addPanel = new HorizontalPanel();


    /**
     * Entry point method.
     */
    public void onModuleLoad() {
        // Create table for stock data.
        schoolFlexTable.setText(0, 0, "Фамилия");
        schoolFlexTable.setText(0, 1, "Имя");
        schoolFlexTable.setText(0, 2, "Отчество");
        schoolFlexTable.setText(0, 3, "Был/Не был");


        // Assemble Main panel.
        mainPanel.add(schoolFlexTable);
        mainPanel.add(addPanel);

        updateTable();

        //schoolFlexTable.setStyleName("students");
        // Associate the Main panel with the HTML host page.
        schoolFlexTable.setStyleName("FlexTable", true);// Добовляет новый стиль для таблицы
        RootPanel.get("School").add(mainPanel);
    }

    private void updateTable() {
        schoolFlexTable.setText(1, 0, "Сергеев");
        schoolFlexTable.setText(1, 1, "Андрей");
        schoolFlexTable.setText(1, 2, "Егорович");
        schoolFlexTable.setText(1, 3, "Y");
        schoolFlexTable.setText(2, 0, "Еврентьева");
        schoolFlexTable.setText(2, 1, "Алина");
        schoolFlexTable.setText(2, 2, "Викторовна");
        schoolFlexTable.setText(2, 3, "N");

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
