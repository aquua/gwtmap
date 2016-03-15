package com.sonaclo.client;

//import org.gwtopenmaps.openlayers.client.LonLat;
//import org.gwtopenmaps.openlayers.client.MapOptions;
////import org.gwtopenmaps.openlayers.client.MapWidget;
//import org.gwtopenmaps.openlayers.client.layer.OSM;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class Maptest implements EntryPoint {

	private SimplePanel panel;

	public void onModuleLoad(){
		panel = new SimplePanel() ;
		panel.setSize("300px", "300px");
		
		
		GMap gmap = new GMap();
		panel.add(gmap);
		gmap.makeGMap(37.468588, 126.868485);
		
		
		RootPanel.get().add(panel);
	}
}