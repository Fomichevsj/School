package com.school.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

public class MyDialogBox extends DialogBox {
    private TextBox textBox = new TextBox();
    private Button okButton = new Button("Ok");

    public MyDialogBox(Label label) {
        super();
        setText("My Dialog Box");
        final Label l = label;
        okButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                hide();
                l.setText(textBox.getText());
            }
        });
        VerticalPanel vPanel = new VerticalPanel();
        vPanel.setStyleName("popUpDialog");
        vPanel.add(textBox);
        vPanel.add(okButton);
        setWidget(vPanel);
    }
}
