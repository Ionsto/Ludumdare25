package src;

import org.lwjgl.opengl.GL11;

public class Gui {
	public boolean Render = false;
	GuiButton buttons[] = new GuiButton[20];
	public void Update()
	{
		if(Render)
		{
			for(int i = 0;i< 20;++i)
			{
				if(buttons[i] != null)
				{
					buttons[i].Update();
				}	
			}
			Render();
		}
	}
	public void Render()
	{
		for(int i = 0;i< 20;++i)
		{
			if(buttons[i] != null)
			{
				if(buttons[i].Render)
				{
					RenderButton(buttons[i]);
				}
			}
		}
	}
	public void RenderButton(GuiButton but)
	{
		GL11.glPushMatrix();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, but.TextureId);
		GL11.glTranslatef(but.PosX,but.PosY , 0);
		GL11.glColor3f(1, 1,1);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2f(0, 0);
		GL11.glTexCoord2f(1,1);
		GL11.glVertex2f(but.SizeX, 0);
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2f(but.SizeX, but.SizeY);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2f(0, but.SizeY);
		GL11.glEnd();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
		GL11.glPopMatrix();
	}
}
