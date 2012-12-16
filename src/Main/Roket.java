package Main;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.*;
import org.lwjgl.util.input.*;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;

import src.*;
public class Roket {
	public static boolean Rocket = false;
	public static boolean Goat = false;
	public static int Textures[] = new int[5];
	public static float Thrust = 100;
	public static float Fuel = 100;
	public static float Cel = 100;
	public static int Leval = 0;
	Audio Rok;
	Audio Goa;
	public static float[] Scores = new float[7];
	float PosCamra = 0;
	public static float AspectRation = 1;
	int Width = 800,Height = 800;
	public static EntityWorld world = new EntityWorld1();
	public static Gui gui[] = new Gui[10];
	public static boolean New = false;
	public static boolean Running = true;
	public static int GameState = 0;
	public void Run()
	{
		try {
			Display.setDisplayMode(new DisplayMode(Width,Height));
			//Display.setFullscreen(true);
			Display.setTitle("Roket");
			Display.create();
		} catch (LWJGLException e) {
		Exit();
		}
		Init();
		MainLoop();
	}
	
	void NewWorld()
	{
		switch(Leval)
		{
		case 0:
			world = new EntityWorld1();
			break;
		case 1:
			world = new EntityWorld2();
			break;
		case 2:
			world = new EntityWorld3();
			break;
		case 3:
			world = new EntityWorld4();
			break;
		case 4:
			world = new EntityWorld5();
			break;
		case 5:
			world = new EntityWorld6();
			break;
		}
		gui[4] = new GuiGame();
	}
	void MainLoop()
	{
		while(Running)
		{
			Rocket = false;
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);  
			GLInit();
			Running = !Display.isCloseRequested();
			if(GameState == 0)
			{
				gui[0].Update();
			}
			if(GameState == 1)
			{
				gui[1].Update();
				if(New)
				{
					NewWorld();
					GameState = 2;
					New = false;
				}
			}
			if(GameState == 3)
			{
				Render();
				gui[3].Update();
			}
			if(GameState == 2)
			{
				PollInput();
				world.Update();
				if(Roket.Rocket)
				{
					Rok.playAsSoundEffect(0.5f, 1f, false);
				}
				Render();
				gui[4].Update();
				if(world.Fail)
				{
					GameState = 3;
				}
				if(world.Win)
				{
					Scores[Leval] = 1;
					GameState = 3;
				}
			}
			Display.update();
		}
		Exit();
	}
	void Render()
	{
		GL11.glPushMatrix();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D,Textures[3]);
		GL11.glColor3f(1, 1,1);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0,-0.1f);
		GL11.glTexCoord2f(1,1);
		GL11.glVertex3f(800, 0,-0.1f);
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(800, 800,-0.1f);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 800,-0.1f);
		GL11.glEnd();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
		GL11.glPopMatrix();
		for(int i = 0;i<100;++i)
		{
			if(world.entity[i] != null)
			{
				GL11.glPushMatrix();
				GL11.glTranslatef(-PosCamra, 0, 0);
				if(world.entity[i].getClass() == EntityRamp.class)
				{
					GL11.glTranslatef(world.entity[i].PosX,world.entity[i].PosY , 0);
					GL11.glRotatef((float)world.entity[i].PosRot, 0, 0, 1);
					GL11.glTranslatef(world.entity[i].SizeX,world.entity[i].SizeY , 0);
				}
				else
				{
				GL11.glTranslatef(world.entity[i].PosX,world.entity[i].PosY , 0);
				GL11.glRotatef((float)world.entity[i].PosRot, 0, 0, 1);
				}
				GL11.glBindTexture(GL11.GL_TEXTURE_2D, world.entity[i].Texture);
				GL11.glColor3f(1, 1, 1);
				GL11.glBegin(GL11.GL_QUADS);
					GL11.glTexCoord2f(0, 1);
					GL11.glVertex2f(-world.entity[i].SizeX, -world.entity[i].SizeY);
					GL11.glTexCoord2f(1,1);
					GL11.glVertex2f(world.entity[i].SizeX, -world.entity[i].SizeY);
					GL11.glTexCoord2f(1, 0);
					GL11.glVertex2f(world.entity[i].SizeX, world.entity[i].SizeY);
					GL11.glTexCoord2f(0, 0);
					GL11.glVertex2f(-world.entity[i].SizeX, world.entity[i].SizeY);
				GL11.glEnd();
				GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
				GL11.glPopMatrix();
			}
		}
	}
	boolean SwitchFire;
	boolean SwitchAdd;
	void PollInput()
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
		{
			GameState = 0;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D))
		{
			if(PosCamra + Width < 2000)
			{
			PosCamra += 2;
			}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A))
		{
			if(PosCamra > 0)
			{
			PosCamra -= 2;
			}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_F))
		{
			if(SwitchFire)
			{
			//int counter = 0;
			for(int i = 0;i<100;++i)
			{
				if(world.entity[i]!= null)
				{
						if(world.entity[i] instanceof EntityRocket)
						{
							if(!((EntityRocket)world.entity[i]).Fired){
							((EntityRocket)world.entity[i]).Thrust = Thrust;
							((EntityRocket)world.entity[i]).Fuel = (int)Fuel;
							((EntityRocket)world.entity[i]).Ceiling = Cel;
							((EntityRocket)world.entity[i]).Fired = true;
							world.CurentRoket++;
							}
						}
				}
			}
			SwitchFire = false;
			}
		}
		else
		{
			SwitchFire = true;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_Q))
		{
			for(int i = 0;i<100;++i)
			{
				if(world.entity[i]!= null)
				{
					if(world.entity[i] instanceof EntityRamp)
					{
						((EntityRamp)world.entity[i]).MotRot = 1f;
					}
				}
			}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_E))
		{
			for(int i = 0;i<100;++i)
			{
				if(world.entity[i]!= null)
				{
					if(world.entity[i] instanceof EntityRamp)
					{
						((EntityRamp)world.entity[i]).MotRot = -1f;
					}
				}
			}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_R))
		{
			if(SwitchAdd)
			{
			world.AddNewRoket();
			SwitchAdd = false;
			}
		}
		else
		{
			SwitchAdd = true;
		}
	}
	void Exit()
	{
		Display.destroy();
	}
	void Init()
	{
		GLInit();
		gui[0] = new GuiMain();
		gui[1] = new GuiSelect();
		gui[3] = new GuiScore();
		gui[4] = new GuiGame();
		try {
			Rok = AudioLoader.getAudio("AIF", ResourceLoader.getResourceAsStream(System.getProperty("user.dir")+"/Res/Au/Rock.AIF"));
			Textures[0] = (TextureLoader.getTexture("", ResourceLoader.getResourceAsStream(System.getProperty("user.dir")+"/Res/Game/Missile.png"))).getTextureID();
			Textures[1] = (TextureLoader.getTexture("", ResourceLoader.getResourceAsStream(System.getProperty("user.dir")+"/Res/Game/Block.png"))).getTextureID();
			Textures[2] = (TextureLoader.getTexture("", ResourceLoader.getResourceAsStream(System.getProperty("user.dir")+"/Res/Game/Imp.png"))).getTextureID();
			Textures[3] =  (TextureLoader.getTexture("", ResourceLoader.getResourceAsStream(System.getProperty("user.dir")+"/Res/Game/BackGround.png"))).getTextureID();
			Textures[4] =  (TextureLoader.getTexture("", ResourceLoader.getResourceAsStream(System.getProperty("user.dir")+"/Res/Game/Goat.png"))).getTextureID();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void GLInit()
	{
		GL11.glClearColor(0, 0, 0, 1);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA,GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glHint(GL11.GL_TEXTURE_2D, GL11.GL_REPEAT);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		//GL11.glOrtho(0, Display.getWidth(), 0, Display.getHeight(), 1f,-1);
		GL11.glOrtho(0, Width, 0, Height, 1f,-1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
}
