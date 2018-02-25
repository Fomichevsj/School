package com.school.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
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
    private static List<SimpleCheckBox> checkBoxes;
    public static boolean someBody = false;




    /**
     * Entry point method.
     */
    public void onModuleLoad() {

        // Assemble Main panel.
        mainPanel.add(schoolFlexTable);

        //Создать таблицу
        SchoolService.App.getInstance().getInfo(new MyAsyncCallback(schoolFlexTable));


        // Associate the Main panel with the HTML host page.
        schoolFlexTable.setStyleName("School", true);// Добовляет новый стиль для таблицы

        Button button = new Button("Отправить");
        Button searchButton = new Button("Поиск");
        final Label label = new Label("Отправить информацию");
        Label dateLabel = new Label("Дата");




        RootPanel.get("statusLabel").add(label);
        RootPanel.get("sendInfoButton").add(button);
        RootPanel.get("searchButton").add(searchButton);
        RootPanel.get("Datelabel").add(dateLabel);
        searchButton.setStyleName("searchButton");
        button.setStyleName("sendButton");
        RootPanel.get("School").add(mainPanel);


        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                label.setText("Отправили информацию");
                List<Boolean> l = new ArrayList<Boolean>(30);
                for (int i = 2; i < schoolFlexTable.getRowCount(); i++) {
                    SimpleCheckBox sch = (SimpleCheckBox) schoolFlexTable.getWidget(i, 3);
                    if(sch.isChecked()) {
                        sch.setValue(false);
                        l.add(true);
                    } else {
                        sch.setValue(true);
                        l.add(false);
                    }
                }
                SendStatusService.App.getInstance().sendInfo(l, new SendAsyncCallback());
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
            // Create table for stock data.
            table.setText(0, 0, " Фамилия");
            table.setText(0, 1, " Имя");
            table.setText(0, 2, " Отчество");
            table.setText(0, 3, " Был/Не был");
            table.getRowFormatter().addStyleName(0,"FlexTable-Header");
            int r = table.getRowCount();
            checkBoxes = new ArrayList<SimpleCheckBox>(30);
            for (int i = 0; i < result.size(); i++) {
                table.setText(r + i +1, 0, result.get(i)[0]);
                table.setText(r + i +1, 1, result.get(i)[1]);
                table.setText(r + i +1, 2, result.get(i)[2]);
                final SimpleCheckBox checkBox = new SimpleCheckBox();
                checkBoxes.add(checkBox);
                checkBox.setStyleName("regular-checkbox");
                checkBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                    public void onValueChange(ValueChangeEvent<Boolean> event) {
                        int ind = checkBoxes.indexOf(checkBox) + 2;
                        if(event.getValue()) {
                            if(!someBody) {
                                for (int j = 2; j < table.getRowCount(); j++) {
                                    table.setText(j, 4, "");
                                }
                            }
                            someBody = true;
                            table.setText(0, 4, "Причина");
                            table.setWidget(ind, 3, checkBox);
                            /*TextBox textBox = new TextBox();
                            textBox.setStyleName("ReasonSetBox");
                            table.setWidget(ind, 4, textBox);*/
                            TextArea textArea = new TextArea();
                            textArea.setStyleName("ReasonSetBox");
                            table.setWidget(ind, 4, textArea);

                        } else {
                            table.setWidget(ind, 3, checkBox);
                            table.setText(ind, 4, "");
                        }
                    }
                });
                table.setWidget(r + i + 1, 3, checkBox);
            }

        }


    }

    private static class SendAsyncCallback implements AsyncCallback {
        public void onFailure(Throwable caught) {

        }

        public void onSuccess(Object result) {

        }
    }
}
