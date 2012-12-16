package src;

import Main.Roket;

public class GuiMain extends Gui{
	public GuiMain()
	{
		Render = true;
		buttons[0] = new GuiButton(200,200,100,100,"/Res/Gui/Start.png");
		buttons[1] = new GuiButton(100,600,400,200,"/Res/Gui/Main.png");
		buttons[2] = new GuiButton(200,90,100,100,"/Res/Gui/Exit.png");
		buttons[0].Render = true;
		buttons[1].Render = true;
		buttons[2].Render = true;
	}	
	public void Update()
	{
		super.Update();
		if(buttons[0].RealClicked)
		{
			Roket.gui[1] = new GuiSelect();
			Roket.GameState =  1;
		}
		if(buttons[2].RealClicked)
		{
			Roket.Running = false;
		}
	}
}
