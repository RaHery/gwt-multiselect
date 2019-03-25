package com.malagasys.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class gwtmultiselect implements EntryPoint {
  
  @Override
  public void onModuleLoad() {
    List<String> values = new ArrayList<>();
    values.add("Value1 Value1 Value1");
    for (int i = 0; i < 10; i++)
      values.add("Value " + i);
    
    MultiSelect select = new MultiSelect(values);
    select.setWidth("150px");
//    select.setHeight("25px");
    RootLayoutPanel.get().add(select);
  }
}
