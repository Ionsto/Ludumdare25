package src;


import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
public class EntityWorld6 extends EntityWorld{

	public EntityWorld6()
	{
		super(1000);
		TargetLine = 20;
		this.RoketCount = 5;
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
		
		AddImp(800,100,0,25,100);
		AddImp(1250,100,0,25,100);
		AddImp(900,200,0,90,20);
		AddImp(1200,200,0,90,20);
	}
}
