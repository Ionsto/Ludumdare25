package src;


import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
public class EntityWorld2 extends EntityWorld{

	public EntityWorld2()
	{
		super(1000);
		TargetLine = 35;
		RoketCount = 2;
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
