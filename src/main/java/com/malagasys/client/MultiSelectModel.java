package com.malagasys.client;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.google.gwt.view.client.HasKeyProvider;
import com.google.gwt.view.client.ProvidesKey;

public final class MultiSelectModel<T> {
	private Set<T> allValues;
	private Set<T> selected;
	
	private ProvidesKey<T> keyProvider;
	
	public MultiSelectModel(ProvidesKey<T> keyProvider, Set<? extends T> possibleValues) {
		if (keyProvider == null) {
			throw new NullPointerException("keyProvider is required.");
		}
		if (possibleValues == null || possibleValues.isEmpty()) {
			throw new IllegalArgumentException("At least one value available for selection is required.");
		}
		
		this.keyProvider = keyProvider;
		
		//TODO Use immutable set here
		this.allValues = new HashSet<>(possibleValues);
		this.selected = new TreeSet<>();
	}
	
	public Set<T> getSelected() {
		//TODO use defensive copy
		return selected;
	}
	
	public void select(T...values) {
		//TODO notify the presenter
		selected.addAll(Arrays.asList(values));
	}
	
	void setSelected(T value) {
		selected.add(value);
	}
}
