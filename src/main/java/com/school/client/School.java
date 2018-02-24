package com.school.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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

        //updateTable();//Добавить записи в таблицу
        SchoolService.App.getInstance().getInfo(new MyAsyncCallback(schoolFlexTable));


        // Associate the Main panel with the HTML host page.
        schoolFlexTable.setStyleName("School", true);// Добовляет новый стиль для таблицы

        Button button = new Button("Отправить");
        final Label label = new Label("Отправить информацию");

/*        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (label.getText().equals("Отправить информацию")) {
                    SchoolService.App.getInstance().getInfo(new MyAsyncCallback(schoolFlexTable));
                } else {
                    label.setText("Отправить информацию");
                }
            }
        });*/

        RootPanel.get("statusLabel").add(label);
        RootPanel.get("sendInfoButton").add(button);
        button.setStyleName("sendButton");
        RootPanel.get("School").add(mainPanel);
    }


    private static class MyAsyncCallback implements AsyncCallback<String[]> {
        private FlexTable table;


        public MyAsyncCallback(FlexTable schoolFlexTable ) {
            this.table = schoolFlexTable;
        }


        public void onFailure(Throwable throwable) {

        }

        public void onSuccess(String[] result) {
            int r = table.getRowCount();
            table.setText(r +1, 0, result[0]);
            table.setText(r +1, 1, result[1]);
            table.setText(r +1, 2, result[2]);
            table.setText(r +1, 3, result[3]);

        }

    }
}
