package se.jakobsvensson.evoagar;

import se.jakobsvensson.evoagar.components.Size;
import se.jakobsvensson.evoagar.components.Species;
import se.jakobsvensson.evoagar.components.Position;
import se.jakobsvensson.evoagar.components.Velocity;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.graphics.Color;

public class EntityFactory {
	private EntityFactory() {
	}
	
	public static Entity createOrganism(World world, float xPos, float yPos, float size, Color color){
		
		Entity organism = world.createEntity();
		organism.addComponent(new Position(xPos, yPos));
		organism.addComponent(new Size(size));
		organism.addComponent(new Velocity(10,10));
		organism.addComponent(new Species(color));
		return organism;
	}
}
