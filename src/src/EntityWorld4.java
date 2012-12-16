package src;


import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
public class EntityWorld4 extends EntityWorld{

	public EntityWorld4()
	{
		super(1000);
		this.RoketCount = 20;
		TargetLine = 30;
		RoketCount = 3;
		AddBuilding(1000+60,25,0,5,5);
		AddBuilding(1000+60,30,0,5,5);
		AddBuilding(1000+60,35,0,5,5);
		AddBuilding(1000+60,40,0,5,5);
		AddBuilding(1000+60,45,0,5,5);
		
		AddBuilding(1020+60,25,0,5,5);
		AddBuilding(1020+60,30,0,5,5);
		AddBuilding(1020+60,35,0,5,5);
		AddBuilding(1020+60,40,0,5,5);
		AddBuilding(1020+60,45,0,5,5);
		
		AddBuilding(1010+60,50,0,7,5);
		
		AddBuilding(1000-60,25,0,5,5);
		AddBuilding(1000-60,30,0,5,5);
		AddBuilding(1000-60,35,0,5,5);
		AddBuilding(1000-60,40,0,5,5);
		AddBuilding(1000-60,45,0,5,5);
		
		AddBuilding(1020-60,25,0,5,5);
		AddBuilding(1020-60,30,0,5,5);
		AddBuilding(1020-60,35,0,5,5);
		AddBuilding(1020-60,40,0,5,5);
		AddBuilding(1020-60,45,0,5,5);
		
		AddBuilding(10100-60,50,0,7,5);
		
		AddBuilding(1000,25,0,5,5);
		AddBuilding(1000,30,0,5,5);
		AddBuilding(1000,35,0,5,5);
		AddBuilding(1000,40,0,5,5);
		AddBuilding(1000,45,0,5,5);
		
		AddBuilding(1020,25,0,5,5);
		AddBuilding(1020,30,0,5,5);
		AddBuilding(1020,35,0,5,5);
		AddBuilding(1020,40,0,5,5);
		AddBuilding(1020,45,0,5,5);
		
		AddBuilding(1010,50,0,7,5);
		

		AddBuilding(1000,25+55,0,5,5);
		AddBuilding(1000,30+55,0,5,5);
		AddBuilding(1000,35+55,0,5,5);
		AddBuilding(1000,40+55,0,5,5);
		AddBuilding(1000,45+55,0,5,5);
		
		AddBuilding(1020,25+55,0,5,5);
		AddBuilding(1020,30+55,0,5,5);
		AddBuilding(1020,35+55,0,5,5);
		AddBuilding(1020,40+55,0,5,5);
		AddBuilding(1020,45+55,0,5,5);
		
		AddBuilding(1010,50+55,0,7,5);
	}
}
