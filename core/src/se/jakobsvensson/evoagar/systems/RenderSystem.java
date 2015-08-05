package se.jakobsvensson.evoagar.systems;



import se.jakobsvensson.evoagar.components.Size;
import se.jakobsvensson.evoagar.components.Transform;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class RenderSystem extends EntitySystem{
	
	private ShapeRenderer shaperenderer;
	private Camera camera;
	private ComponentMapper<Size> sizemapper;
	private ComponentMapper<Transform> transformmapper;
	
	public RenderSystem(Camera camera) {
		super(Aspect.getAspectForOne(Size.class, Transform.class));
		shaperenderer = new ShapeRenderer();
		this.camera = camera;
		
	}
	
	@Override
	protected void initialize(){
		sizemapper = world.getMapper(Size.class);
		transformmapper = world.getMapper(Transform.class);
	}
	
	@Override
	protected boolean checkProcessing() {
		return true;
	}

	@Override
	protected void processEntities(ImmutableBag<Entity> entities) {
		shaperenderer.setProjectionMatrix(camera.combined);
		shaperenderer.begin(ShapeType.Filled);
		for(int i = 0; i<entities.size();i++){
			Size size = sizemapper.get(entities.get(i));
			Transform transform = transformmapper.get(entities.get(i));
			shaperenderer.circle(transform.getX(), transform.getY(), size.getRadius());
		}	
		shaperenderer.end();

	}

}
