package src;

import java.io.IOException;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class GuiControls {
	public float value = 0;
	public boolean Render = false;
	public float PosX,PosY,SizeX,SizeY,RangeT,RangeB;
	public int TextureId = 0;
	public boolean RealClicked = false;
	public boolean PrimerClicked = false;
	public GuiControls(float x,float y,float sx,float sy,float Range,String tex)
	{
		PosX = x;
		PosY = y;
		SizeX = sx;
		SizeY = sy;
		RangeT = PosY + Range;
		RangeB = PosY - Range;
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
			if(Mouse.isButtonDown(0))
			{
				if(Mouse.getX() < PosX + SizeX && Mouse.getX() > PosX && Mouse.getY() < PosY + SizeY && Mouse.getY() > PosY )
				{
					PosY += Mouse.getDY();
					if(PosY > RangeT)
					{
						PosY = RangeT;
					}
					if(PosY < RangeB)
					{
						PosY = RangeB;
					}
				}
			}
			value = PosY - RangeB;
		}
	}
}
