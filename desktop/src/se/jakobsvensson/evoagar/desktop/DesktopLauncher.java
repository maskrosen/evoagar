package se.jakobsvensson.evoagar.desktop;

import se.jakobsvensson.evoagar.EvoAgar;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Evo Agar";
		config.width = 1280;
		config.height = 720;
		
		new LwjglApplication(new EvoAgar(), config);
	}
}
