package com.school.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;
import java.util.List;

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

        //updateTable();//Добавить записи в таблицу
        SchoolService.App.getInstance().getInfo(new MyAsyncCallback(schoolFlexTable));


        // Associate the Main panel with the HTML host page.
        schoolFlexTable.setStyleName("School", true);// Добовляет новый стиль для таблицы

        Button button = new Button("Отправить");
        final Label label = new Label("Отправить информацию");



        RootPanel.get("statusLabel").add(label);
        RootPanel.get("sendInfoButton").add(button);
        button.setStyleName("sendButton");
        RootPanel.get("School").add(mainPanel);

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                label.setText("Отправили информацию");
                for (int i = 2; i < schoolFlexTable.getRowCount(); i++) {
                    SimpleCheckBox sch = (SimpleCheckBox) schoolFlexTable.getWidget(i, 3);
                    sch.setValue(true);
                }
            }
        });
    }

    private static class MyAsyncCallback implements AsyncCallback<List<String[]>> {
        private FlexTable table;


        public MyAsyncCallback(FlexTable schoolFlexTable ) {
            this.table = schoolFlexTable;
        }


        public void onFailure(Throwable throwable) {

        }

        public void onSuccess(List<String[]> result) {
            int r = table.getRowCount();
            for (int i = 0; i < result.size(); i++) {
                table.setText(r + i +1, 0, result.get(i)[0]);
                table.setText(r + i +1, 1, result.get(i)[1]);
                table.setText(r + i +1, 2, result.get(i)[2]);
                SimpleCheckBox checkBox = new SimpleCheckBox();
                checkBox.setStyleName("regular-checkbox");
                table.setWidget(r + i + 1, 3, checkBox);
            }

        }

    }
}
