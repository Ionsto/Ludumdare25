package src;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import Main.Roket;

public class GuiSelect extends Gui{
	int Counter = 0;
	int a;
	int b;
	int c;
	int d;
	int e;
	int f;
	int g;
	int h;
	public GuiSelect()
	{
		try {
			a = (TextureLoader.getTexture("", ResourceLoader.getResourceAsStream(System.getProperty("user.dir")+"/Res/Gui/Count/1.png"))).getTextureID();
			b = (TextureLoader.getTexture("", ResourceLoader.getResourceAsStream(System.getProperty("user.dir")+"/Res/Gui/Count/2.png"))).getTextureID();
			c = (TextureLoader.getTexture("", ResourceLoader.getResourceAsStream(System.getProperty("user.dir")+"/Res/Gui/Count/3.png"))).getTextureID();
			d = (TextureLoader.getTexture("", ResourceLoader.getResourceAsStream(System.getProperty("user.dir")+"/Res/Gui/Count/4.png"))).getTextureID();
			e = (TextureLoader.getTexture("", ResourceLoader.getResourceAsStream(System.getProperty("user.dir")+"/Res/Gui/Count/5.png"))).getTextureID();
			f = (TextureLoader.getTexture("", ResourceLoader.getResourceAsStream(System.getProperty("user.dir")+"/Res/Gui/Count/6.png"))).getTextureID();
			g = (TextureLoader.getTexture("", ResourceLoader.getResourceAsStream(System.getProperty("user.dir")+"/Res/Gui/Count/7.png"))).getTextureID();
			h = (TextureLoader.getTexture("", ResourceLoader.getResourceAsStream(System.getProperty("user.dir")+"/Res/Gui/Count/8.png"))).getTextureID();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Render = true;
		buttons[0] = new GuiButton(200,200,100,100,"/Res/Gui/Next.png");
		buttons[0].Render = true;
		buttons[1] = new GuiButton(200,100,100,100,"/Res/Gui/Before.png");
		buttons[1].Render = true;
		
		buttons[2] = new GuiButton(500,100,100,100,"/Res/Gui/Start.png");
		buttons[2].Render = true;
	}	
	public void Update()
	{
		super.Update();
		if(buttons[0].RealClicked)
		{
			if(Counter < 5)
			{
			Counter++;
			}
		}
		if(buttons[1].RealClicked)
		{
			if(Counter > 0)
			{
			Counter--;
			}
		}
		if(buttons[2].RealClicked)
		{
			Roket.Leval = Counter;
			Roket.New = true;
		}
		GL11.glPushMatrix();
		switch(Counter)
		{
		case 0:
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, a);
			break;
		case 1:
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, b);
			break;
		case 2:
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, c);
			break;
		case 3:
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, d);
			break;
		case 4:
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, e);
			break;
		case 5:
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, f);
			break;
		}
		GL11.glTranslatef(100,200 , 0);
		GL11.glColor3f(1, 1,1);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2f(0, 0);
		GL11.glTexCoord2f(1,1);
		GL11.glVertex2f(100, 0);
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2f(100, 100);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2f(0, 100);
		GL11.glEnd();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
		GL11.glPopMatrix();
	}
}
