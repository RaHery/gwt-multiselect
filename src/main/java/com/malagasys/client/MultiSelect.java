package com.malagasys.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.CompositeCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.HasCell;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;

//TODO: tooltip to display the list of selected elements

public final class MultiSelect extends Composite {
	
	private static final class SelectionCell implements HasCell<String, Boolean> {
		private CheckboxCell innerCell = new CheckboxCell(true, false);
		private SelectionModel<String> selectionModel;
		
		SelectionCell(SelectionModel<String> selectionModel) {
			this.selectionModel = selectionModel;
		}
		
		@Override
		public Cell<Boolean> getCell() {
			return innerCell;
		}
		
		@Override
		public FieldUpdater<String, Boolean> getFieldUpdater() {
			return null;
		}
		
		@Override
		public Boolean getValue(String object) {
			return selectionModel.isSelected(object);
		}
	}
	
	private static final class TextCell implements HasCell<String, String> {
		private com.google.gwt.cell.client.TextCell innerCell = new com.google.gwt.cell.client.TextCell();
		
		@Override
		public Cell<String> getCell() {
			return innerCell;
		}
		
		@Override
		public FieldUpdater<String, String> getFieldUpdater() {
			return null;
		}
		
		@Override
		public String getValue(String object) {
			return object;
		}
	}
	
	private TextBox inputBox;
	
	private PopupPanel menu;
	private CellList<String> cellList;
	
	private List<String> allValues;
	
	public MultiSelect(List<String> allValues) {
		this.allValues = new ArrayList<>(allValues);
		
		HasClickHandlers popupTriggerer = createAndLayoutSubComponents();
		createPopup(popupTriggerer);
	}
	
	private HasClickHandlers createAndLayoutSubComponents() {
		DockLayoutPanel panel = new DockLayoutPanel(Style.Unit.PX);
		initWidget(panel);
		Button dropDownButton = new Button("b");
		panel.addEast(dropDownButton, 25);
		
		inputBox = new TextBox();
		inputBox.setReadOnly(true);
		inputBox.setWidth("100%");
		panel.addNorth(inputBox, 25);
		setHeight("25px");
		
		return dropDownButton;
	}
	
	private void createPopup(HasClickHandlers popupTriggerer) {
		menu = new PopupPanel();
		menu.setAutoHideEnabled(true);
		List<HasCell<String, ?>> cells = new ArrayList<>();
		
		MultiSelectionModel<String> selectionModel = new MultiSelectionModel<>();
		selectionModel.addSelectionChangeHandler(e -> {
			StringBuilder builder = new StringBuilder();
			for (String value: selectionModel.getSelectedSet()) {
				builder.append(value).append(", ");
			}
			inputBox.setText(builder.toString());
		});
		
		cells.add(new SelectionCell(selectionModel));
		
		cells.add(new TextCell());
		
		cellList = new CellList<String>(new CompositeCell<>(cells));
		cellList.setSelectionModel(selectionModel, DefaultSelectionEventManager.createCheckboxManager());
		cellList.setPageSize(Integer.MAX_VALUE);
		ListDataProvider<String> dataProvider = new ListDataProvider<>(allValues);
		dataProvider.addDataDisplay(cellList);
		menu.setWidget(cellList);
		
		popupTriggerer.addClickHandler(e -> {
			menu.showRelativeTo(this);
		});
		
		
	}
	
	public void setEnabled(boolean enabled) {
		//TODO to be implemented.
	}
}
