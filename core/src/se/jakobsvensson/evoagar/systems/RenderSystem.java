package se.jakobsvensson.evoagar.systems;



import se.jakobsvensson.evoagar.components.Spatial;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.utils.ImmutableBag;

public class RenderSystem extends EntitySystem{

	public RenderSystem() {
		super(Aspect.getAspectForOne(Spatial.class));
	}

	@Override
	protected boolean checkProcessing() {
		return true;
	}

	@Override
	protected void processEntities(ImmutableBag<Entity> arg0) {
		// TODO Auto-generated method stub
		
	}

}
