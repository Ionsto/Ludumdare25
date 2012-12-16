package src;

import org.lwjgl.opengl.GL11;

import Main.Roket;

public class GuiGame extends Gui{
	GuiControls guislid[] = new GuiControls[3];
	public GuiGame()
	{
		
		Render = true;
		buttons[0] = new GuiButton(0,200,100,100,"/Res/Gui/StartRe.png");
		buttons[0].Render = true;
		guislid[0] = new GuiControls(0,500,50,50,100,"/Res/Gui/Thrust.png");
		guislid[0].Render = true;
		guislid[1] = new GuiControls(50,500,50,50,100,"/Res/Gui/Fuel.png");
		guislid[1].Render = true;
		guislid[2] = new GuiControls(100,500,50,50,100,"/Res/Gui/Cel.png");
		guislid[2].Render = true;
	}	
	public void Update()
	{			
		super.Update();
		for(int i =0;i<3;++i)
		{
			guislid[i].Update();
			GL11.glPushMatrix();
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, guislid[i].TextureId);
			GL11.glTranslatef(guislid[i].PosX,guislid[i].PosY , 0);
			GL11.glColor3f(1, 1,1);
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(0, 0);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2f(guislid[i].SizeX, 0);
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2f(guislid[i].SizeX, guislid[i].SizeY);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(0, guislid[i].SizeY);
			GL11.glEnd();
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
			GL11.glPopMatrix();
			

		}
		Roket.Thrust = guislid[0].value * 10;
		Roket.Fuel = guislid[1].value * 4;
		Roket.Cel = guislid[2].value * 2;
		if(buttons[0].RealClicked)
		{
			Roket.GameState = 1;
			Roket.New = true;
		}
	}
}
