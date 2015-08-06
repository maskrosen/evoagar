package se.jakobsvensson.evoagar;

import se.jakobsvensson.evoagar.systems.MovingEntitiesSystem;
import se.jakobsvensson.evoagar.systems.RenderSystem;

import com.artemis.World;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen{
	
	private SpriteBatch batch;
	private World world;
	private Camera camera;
	
	public GameScreen(SpriteBatch batch, Camera camera){
		this.batch=batch;
		this.camera=camera;
		initialize();
		
	}
	
	public void initialize(){
		
		this.world = new World();
		world.setSystem(new RenderSystem(camera));
		world.setSystem(new MovingEntitiesSystem());
		world.initialize();
		world.addEntity(EntityFactory.createOrganism(world, 400, 200, 40, Color.PURPLE));
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		world.setDelta(delta);
		world.process();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
