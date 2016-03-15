package com.sonaclo.client;



import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.maps.gwt.client.GoogleMap;
import com.google.maps.gwt.client.LatLng;
import com.google.maps.gwt.client.MapOptions;
import com.google.maps.gwt.client.MapTypeId;
import com.google.maps.gwt.client.Marker;


public class GMap extends Composite{

	private SimplePanel googleMapContainer;
	
	private static int mapWidth = 300;
	private static int mapHeight = mapWidth;
	
	private MapOptions options = null;
	public GMap(){
		googleMapContainer = new SimplePanel() ;
		googleMapContainer.setSize(mapWidth+"px", mapHeight+"px");
		super.initWidget(googleMapContainer);
		
		initMapOption();
	}
	private void initMapOption() {
		
		
		options  = MapOptions.create(); 
		
        options.setZoom(17);
        options.setMapTypeId(MapTypeId.ROADMAP);
        options.setDraggable(true);
        options.setMapTypeControl(true);
        options.setScaleControl(true);
        options.setScrollwheel(true);
        options.setPanControl(true);
        options.setOverviewMapControl(true);
	}

	public void makeGMap(String latPos, String lonPos) {
		double lat  = 0;
		double lon = 0;
		try{
			lat = Double.parseDouble(latPos);
			lon = Double.parseDouble(lonPos);
		}catch ( NumberFormatException  e){
		}
		makeGMap(lat, lon);
	}
	
	public void makeGMap(double latPos, double lonPos) {
		if ( latPos ==0 || lonPos == 0 ){
			googleMapContainer.setVisible(false);
			
		}else{
			if ( googleMapContainer.isVisible()==false ) googleMapContainer.setVisible(true);
			
			LatLng position = LatLng.create(latPos, lonPos);
			options.setCenter(position); 
	        
	        GoogleMap map = GoogleMap.create(googleMapContainer.getElement(), options) ;
	        
	        Marker marker = Marker.create();
			marker.setMap(map);
			marker.setPosition(position);	
		}
	}
}
