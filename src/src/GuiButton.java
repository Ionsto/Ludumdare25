package src;
import java.io.IOException;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.loading.*;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
public class GuiButton{
	public boolean Render = false;
	public float PosX,PosY,SizeX,SizeY;
	public int TextureId = 0;
	public boolean RealClicked = false;
	public boolean PrimerClicked = false;
	public GuiButton(float x,float y,float sx,float sy,String tex)
	{
		PosX = x;
		PosY = y;
		SizeX = sx;
		SizeY = sy;
		try {
			TextureId = (TextureLoader.getTexture("", ResourceLoader.getResourceAsStream(System.getProperty("user.dir")+tex))).getTextureID();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void Update()
	{
		if(Render)
		{
			RealClicked = false;
			if(Mouse.isButtonDown(0))
			{
				if(Mouse.getX() < PosX + SizeX && Mouse.getX() > PosX && Mouse.getY() < PosY + SizeY && Mouse.getY() > PosY )
				{
					PrimerClicked = true;
				}
			}
			else
			{
				if(Mouse.getX() < PosX + SizeX && Mouse.getX() > PosX && Mouse.getY() < PosY + SizeY && Mouse.getY() > PosY )
				{
					if(PrimerClicked)
					{
						RealClicked = true;
						PrimerClicked = false;
					}
				}
				else
				{
					RealClicked = false;
					PrimerClicked = false;
				}
			}
		}
	}
}
