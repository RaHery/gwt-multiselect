package com.malagasys.client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.jasper.compiler.Node;

import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.malagasys.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class gwtmultiselect implements EntryPoint {
  
  @Override
  public void onModuleLoad() {
    List<String> values = new ArrayList<>();
    values.add("Value1 fjshfj flsfjhf jqhf lfsdjhf jfhlf jhfqds fslfhsdf jhfq hqsl");
    for (int i = 0; i < 20; i++)
      values.add("Value " + i);
    
    MultiSelect select = new MultiSelect(values);
    select.setWidth("200px");
//    select.setHeight("25px");
    RootLayoutPanel.get().add(select);
  }
}
