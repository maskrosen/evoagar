package se.jakobsvensson.evoagar.components;

import com.artemis.Component;

public class Size extends Component{
	
	private float radius;
	
	public Size(float radius){
		this.radius = radius;
	}
	
	public float getRadius(){
		return this.radius;
	}
	
	public void setRadius(float radius){
		this.radius = radius;
	}
	
}
