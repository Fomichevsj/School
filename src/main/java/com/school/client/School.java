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




    /**
     * Entry point method.
     */
    public void onModuleLoad() {
        // Create table for stock data.
        schoolFlexTable.setText(0, 0, " Фамилия");
        schoolFlexTable.setText(0, 1, " Имя");
        schoolFlexTable.setText(0, 2, " Отчество");
        schoolFlexTable.setText(0, 3, " Был/Не был");
        schoolFlexTable.getRowFormatter().addStyleName(0,"FlexTable-Header");

        // Assemble Main panel.
        mainPanel.add(schoolFlexTable);

        updateTable();//Добавить записи в таблицу


        // Associate the Main panel with the HTML host page.
        schoolFlexTable.setStyleName("School", true);// Добовляет новый стиль для таблицы


        RootPanel.get("School").add(mainPanel);
    }

    private void updateTable() {
        schoolFlexTable.setText(1, 0, "Сергеев");
        schoolFlexTable.getFlexCellFormatter().setStyleName(1, 0, "LastName");
        schoolFlexTable.setText(1, 1, "Андрей");
        schoolFlexTable.getFlexCellFormatter().setStyleName(1, 1, "FirstName");
        schoolFlexTable.setText(1, 2, "Егорович");
        schoolFlexTable.getFlexCellFormatter().setStyleName(1, 2, "MiddleName");
        schoolFlexTable.setText(1, 3, "Y");
        schoolFlexTable.getFlexCellFormatter().setStyleName(1, 3, "Visit");

        schoolFlexTable.setText(2, 0, "Еврентьева");
        schoolFlexTable.getFlexCellFormatter().setStyleName(2, 0, "FirstName");
        schoolFlexTable.setText(2, 1, "Алина");
        schoolFlexTable.getFlexCellFormatter().setStyleName(2, 1, "LastName");
        schoolFlexTable.setText(2, 2, "Викторовна");
        schoolFlexTable.getFlexCellFormatter().setStyleName(2, 2, "MiddleName");
        schoolFlexTable.setText(2, 3, "N");
        schoolFlexTable.getFlexCellFormatter().setStyleName(2, 2, "Visit");

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
