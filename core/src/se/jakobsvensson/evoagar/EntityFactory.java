package se.jakobsvensson.evoagar;

import se.jakobsvensson.evoagar.components.Size;
import se.jakobsvensson.evoagar.components.Transform;

import com.artemis.Entity;
import com.artemis.World;

public class EntityFactory {
	private EntityFactory() {
	}
	
	public static Entity createOrganism(World world, float xPos, float yPos, float size){
		
		Entity organism = world.createEntity();
		organism.addComponent(new Transform(xPos, yPos));
		organism.addComponent(new Size(size));
		return organism;
	}
}
