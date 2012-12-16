package src;

import org.jbox2d.common.Vec2;

import Main.Roket;

public class EntityRamp extends Entity{
	public float Target = 0;
	public EntityRamp(float sx, float sy,float rot, int id) {
		super(sx, sy, id);
		Target = rot;
		Texture = Roket.Textures[2];
		
	}
	@Override
	public void Update(EntityWorld world)
	{
		world.body[Id].setAngularVelocity((float)Math.toRadians(MotRot));
		MotRot = 0;
		super.Update(world);
		
	}
	
}
