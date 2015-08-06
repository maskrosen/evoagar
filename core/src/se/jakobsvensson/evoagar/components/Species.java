package se.jakobsvensson.evoagar.components;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Color;

public class Species extends Component{
	
	Color color;	
	
	public Species(Color color){
		this.color = color;//
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public Color getColor(){
		return color;
	}

}
