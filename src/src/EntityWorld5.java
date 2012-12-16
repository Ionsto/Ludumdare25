package src;


import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
public class EntityWorld5 extends EntityWorld{

	public EntityWorld5()
	{
		super(1000);
		TargetLine = 25;
		RoketCount = 2;
		AddBuilding(1030,25,0,5,5);
		AddBuilding(1030,30,0,5,5);
		AddBuilding(1030,35,0,5,5);
		AddBuilding(1030,40,0,5,5);
		AddBuilding(1030,45,0,5,5);
		
		AddBuilding(1050,25,0,5,5);
		AddBuilding(1050,30,0,5,5);
		AddBuilding(1050,35,0,5,5);
		AddBuilding(1050,40,0,5,5);
		AddBuilding(1050,45,0,5,5);
		
		AddBuilding(1040,50,0,7,5);
		

		AddBuilding(1030-240,25,0,5,5);
		AddBuilding(1030-240,30,0,5,5);
		AddBuilding(1030-240,35,0,5,5);
		AddBuilding(1030-240,40,0,5,5);
		AddBuilding(1030-240,45,0,5,5);
		
		AddBuilding(1050-240,25,0,5,5);
		AddBuilding(1050-240,30,0,5,5);
		AddBuilding(1050-240,35,0,5,5);
		AddBuilding(1050-240,40,0,5,5);
		AddBuilding(1050-240,45,0,5,5);
		
		AddBuilding(1040-240,50,0,7,5);
		
		AddImp(900,50,0,25,70);
	}
}
