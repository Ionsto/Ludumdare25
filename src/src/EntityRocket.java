package src;

import Main.Roket;

public class EntityRocket extends Entity{
	public int Fuel = 200;
	public int FuelCounter = 0;
	public float Thrust = 100;
	public boolean Fired = false;
	public float Ceiling = 100;
	public boolean CeilingR = false;
	public EntityRocket(float sx,float sy,int id) {
		super(sx,sy,id);
		Texture = Roket.Textures[0];
	}
	@Override
	public void Update(EntityWorld world)
	{
		super.Update(world);
		if(Fired)
		{
			if(FuelCounter<Fuel)
			{
				Roket.Rocket = true;
				MotX = Thrust * (float)Math.cos(Math.toRadians(PosRot));
				MotY = Thrust * (float)Math.sin(Math.toRadians(PosRot));
				MotRot = - 190;
				++FuelCounter;
				if(PosY > Ceiling)
				{
					CeilingR = true;
				}
				if(CeilingR)
				{
					MotRot -= 10000;
				}
			}
			else
			{
				
			}
		}
		//MotRot = 100;
		//MotY = 100;
	}
}
