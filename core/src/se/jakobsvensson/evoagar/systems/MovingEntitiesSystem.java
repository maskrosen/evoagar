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
		//1. Skapa variabler f�r de nya positionerna i X och Y
		//2. H�mta nuvarande v�rde f�r X och Y och l�gg dom i de nya variablerna (transform.getX())
		//3. L�gg nu till den str�cka som objektet ska r�ra sig p� den h�r framen (tpf*velocity,velocity.getXSpeed())
		//	T�nk p� att det finns en hastighet f�r X och en f�r Y
		//4. Uppdatera positionen i transform-objektet med de nya positionerna s� att de sparas
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
