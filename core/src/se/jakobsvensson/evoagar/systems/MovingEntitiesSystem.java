package se.jakobsvensson.evoagar.systems;

import se.jakobsvensson.evoagar.components.Size;
import se.jakobsvensson.evoagar.components.Position;
import se.jakobsvensson.evoagar.components.Velocity;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;

public class MovingEntitiesSystem extends EntityProcessingSystem{
	
	

	private ComponentMapper<Position> transformmapper;
	private ComponentMapper<Velocity> velocitymapper;
	
	public MovingEntitiesSystem() {
		super(Aspect.getAspectForAll(Velocity.class, Position.class));
	}
	
	
	@Override
	protected void initialize(){
		velocitymapper = world.getMapper(Velocity.class);
		transformmapper = world.getMapper(Position.class);
	}
	
	
	@Override
	protected void process(Entity e) {
		//TODO Tilda: Implement moving algorithm
		//1. Skapa variabler för de nya positionerna i X och Y
		//2. Hämta nuvarande värde för X och Y och lägg dom i de nya variablerna (transform.getX())
		//3. Lägg nu till den sträcka som objektet ska röra sig på den här framen (tpf*velocity,velocity.getXSpeed())
		//	Tänk på att det finns en hastighet för X och en för Y
		//4. Uppdatera positionen i transform-objektet med de nya positionerna så att de sparas
		Velocity velocity = velocitymapper.get(e);
		Position transform = transformmapper.get(e);
		float tpf = world.getDelta(); //Time per frame
		
		float x = transform.getX();
		float y = transform.getY();
		
		x = x + velocity.getXSpeed() * tpf;
		y = y + velocity.getYSpeed() * tpf;
		
		transform.setPosition(x, y);
		
		
		
	}

}
