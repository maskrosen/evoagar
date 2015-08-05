package se.jakobsvensson.evoagar;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EvoAgar extends Game {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	
	
	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, w, h);
		setScreen(new GameScreen(batch, camera));
		
	}

	@Override
	public void render () {
		super.render();
	}
}
