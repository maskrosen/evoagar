package se.jakobsvensson.evoagar.systems;



import se.jakobsvensson.evoagar.components.Size;
import se.jakobsvensson.evoagar.components.Species;
import se.jakobsvensson.evoagar.components.Position;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class RenderSystem extends EntitySystem{
	
	private ShapeRenderer shaperenderer;
	private Camera camera;
	private ComponentMapper<Size> sizemapper;
	private ComponentMapper<Position> transformmapper;
	private ComponentMapper<Species> speciesmapper;
	
	public RenderSystem(Camera camera) {
		super(Aspect.getAspectForAll(Size.class, Position.class));
		shaperenderer = new ShapeRenderer();
		this.camera = camera;
		
	}
	
	@Override
	protected void initialize(){
		sizemapper = world.getMapper(Size.class);
		transformmapper = world.getMapper(Position.class);
		speciesmapper = world.getMapper(Species.class);
	}
	
	@Override
	protected boolean checkProcessing() {
		return true;
	}

	@Override
	protected void processEntities(ImmutableBag<Entity> entities) {
		shaperenderer.setProjectionMatrix(camera.combined);
		shaperenderer.begin(ShapeType.Filled);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		for(int i = 0; i<entities.size();i++){
			Size size = sizemapper.get(entities.get(i));
			Position transform = transformmapper.get(entities.get(i));
			Species species = speciesmapper.get(entities.get(i));
			if(species!=null){
				shaperenderer.setColor(species.getColor());
			}
			shaperenderer.circle(transform.getX(), transform.getY(), size.getRadius());
		}	
		shaperenderer.end();

	}

}
