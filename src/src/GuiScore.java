package src;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import Main.Roket;

public class GuiScore extends Gui{
	int Win = 0;
	int Fail = 0;
	public GuiScore()
	{
		try {
			Win = (TextureLoader.getTexture("", ResourceLoader.getResourceAsStream(System.getProperty("user.dir")+"/Res/Gui/Win.png"))).getTextureID();
			Fail = (TextureLoader.getTexture("", ResourceLoader.getResourceAsStream(System.getProperty("user.dir")+"/Res/Gui/Fail.png"))).getTextureID();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Render = true;
		buttons[0] = new GuiButton(200,300,100,100,"/Res/Gui/ExittoMain.png");
		buttons[1] = new GuiButton(200,200,100,100,"/Res/Gui/NextLeval.png");
		buttons[2] = new GuiButton(200,200,100,100,"/Res/Gui/StartRe.png");
		buttons[0].Render = true;
		buttons[1].Render = true;
		buttons[2].Render = true;
	}
	public void Update()
	{
		super.Update();
		if(buttons[0].RealClicked)
		{
			Roket.GameState =  0;
		}
		if((int)Roket.Scores[Roket.Leval] == 0)
		{
			buttons[1].Render = false;
			buttons[2].Render = true;
		}
		else
		{
			buttons[1].Render = true;
			buttons[2].Render = false;
		}
		if(buttons[1].RealClicked)
		{
			if(Roket.Leval == 6)
			{
				Roket.GameState =  0;
			}
			else{
			Roket.GameState =  1;
			Roket.Leval += 1;
			Roket.New = true;
			}
		}
		if(buttons[2].RealClicked)
		{
			Roket.GameState = 1;
			Roket.New = true;
		}
		GL11.glPushMatrix();
		switch((int)Roket.Scores[Roket.Leval])
		{
		case 0:
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, Fail);
			break;
		case 1:
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, Win);
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
