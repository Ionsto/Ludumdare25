package src;

import org.jbox2d.common.Vec2;

public class Entity {
	public float PosX = 0;
	public float PosY = 0;
	public float PosRot = 0;
	public float SizeX = 0, SizeY = 0;
	public float MotX = 0;
	public float MotY = 0;
	public float MotRot = 0;
	public int Id;
	public boolean Expended = true;
	public int Texture = 0;
	public Entity(float sx,float sy,int id)
	{
		SizeX = sx;
		SizeY = sy;
		Id = id;
	}
	public void Update(EntityWorld world)
	{
		Move(world);
	}
	public void Move(EntityWorld world)
	{
		PosX = world.body[Id].getPosition().x;
		PosY = world.body[Id].getPosition().y;
		PosRot = (float)Math.toDegrees(world.body[Id].getAngle());
		//PosRot = world.body[Id].getAngle();
		world.body[Id].applyLinearImpulse(new Vec2(MotX,MotY), new Vec2(PosX,PosY));
		//world.body[Id].applyAngularImpulse((float)MotRot);
		world.body[Id].applyAngularImpulse((float)Math.toRadians(MotRot));
		MotX = 0;
		MotY = 0;
		MotRot = 0;
		if(Math.abs(world.body[Id].getLinearVelocity().x) < 0.5f && Math.abs(world.body[Id].getLinearVelocity().y) < 0.5f )
		{
			Expended = true;
		}
		else
		{
			Expended = false;
		}
	}
}
