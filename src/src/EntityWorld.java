package src;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import Main.Roket;

public class EntityWorld {
	int Timer = 0;
	public float TargetLine = 20;
	public float CurentRoket = 0;
	public float RoketCountEr = 0;
	public boolean Win = false;
	public boolean Fail = false;
	public float RoketCount = 1;
	public Entity entity[] = new Entity[100];
	public Body body[] = new Body[100]; 
	float Timestep = 0.01f;
	int velocityIterations = 6;
	int positionIterations = 2;
	World world;
	public EntityWorld(float X)
	{
		world = new World(new Vec2(0,-10),true);
		BodyDef body = new BodyDef();
		body.position.set(1000,0);
		world.createBody(body);
		Body groundBody = world.createBody(body);
		PolygonShape groundBox = new PolygonShape();
		groundBox.setAsBox(1000.0f, 20.0f);
		groundBody.createFixture(groundBox,0);

		BodyDef bodya = new BodyDef();
		bodya.position.set(1000,1000);
		world.createBody(bodya);
		Body groundBodya = world.createBody(bodya);
		PolygonShape groundBoxa = new PolygonShape();
		groundBoxa.setAsBox(1000.0f, 20.0f);
		groundBodya.createFixture(groundBoxa,0);
		
		
		BodyDef bodys = new BodyDef();
		bodys.position.set(2000,0);
		world.createBody(bodys);
		Body groundBodys = world.createBody(bodys);
		PolygonShape groundBoxs = new PolygonShape();
		groundBoxs.setAsBox(20.0f, 1000.0f);
		groundBodys.createFixture(groundBoxs,0);
		
		BodyDef bodyss = new BodyDef();
		bodyss.position.set(-2,0);
		world.createBody(bodyss);
		Body groundBodyss = world.createBody(bodyss);
		PolygonShape groundBoxss = new PolygonShape();
		groundBoxss.setAsBox(20.0f, 1000.0f);
		groundBodyss.createFixture(groundBoxss,0);

		
		AddRamp(10,20,-70,10,80);
		AddRamp(10,20,20,10,40);
	}
	public void AddNewRoket()
	{
		if(RoketCountEr < RoketCount)
		{
			AddBody(50,130,27,20,6);
			RoketCountEr++;
		}
	}
	public EntityWorld()
	{
		world = new World(new Vec2(0,-10),true);
		BodyDef body = new BodyDef();
		body.position.set(1000,0);
		world.createBody(body);
		Body groundBody = world.createBody(body);
		PolygonShape groundBox = new PolygonShape();
		groundBox.setAsBox(1000.0f, 20.0f);
		groundBody.createFixture(groundBox,0);

		BodyDef bodya = new BodyDef();
		bodya.position.set(1000,1000);
		world.createBody(bodya);
		Body groundBodya = world.createBody(bodya);
		PolygonShape groundBoxa = new PolygonShape();
		groundBoxa.setAsBox(1000.0f, 20.0f);
		groundBodya.createFixture(groundBoxa,0);
		
		
		BodyDef bodys = new BodyDef();
		bodys.position.set(2000,0);
		world.createBody(bodys);
		Body groundBodys = world.createBody(bodys);
		PolygonShape groundBoxs = new PolygonShape();
		groundBoxs.setAsBox(20.0f, 1000.0f);
		groundBodys.createFixture(groundBoxs,0);
		
		BodyDef bodyss = new BodyDef();
		bodyss.position.set(-2,0);
		world.createBody(bodyss);
		Body groundBodyss = world.createBody(bodyss);
		PolygonShape groundBoxss = new PolygonShape();
		groundBoxss.setAsBox(20.0f, 1000.0f);
		groundBodyss.createFixture(groundBoxss,0);

		
		AddRamp(10,20,-70,10,80);
		AddRamp(10,20,20,10,40);
	}
	public int AddBody(float x,float y,float rol,float sizex,float sizey)
	{
		for(int i = 0;i < 100;++i)
		{
				if(entity[i] == null)
				{
					BodyDef bodys = new BodyDef();
					bodys.type = BodyType.DYNAMIC;
					bodys.position.set(new Vec2(x,y));
					bodys.angle =(float) Math.toRadians(rol);
					body[i] = world.createBody(bodys);
					PolygonShape groundBox = new PolygonShape();
					groundBox.setAsBox(sizex,sizey);
					FixtureDef fixtureDef = new FixtureDef();
					fixtureDef.shape = groundBox;
					fixtureDef.density = 0.5f;
					fixtureDef.friction = 0.3f;
					body[i].createFixture(fixtureDef);
					entity[i] = new EntityRocket(sizex,sizey,i);
					return i;
				}
			}
		return -1;
	}
	
	public int AddImp(float x,float y,float rol,float sizex,float sizey)
	{
		for(int i = 0;i < 100;++i)
		{
				if(entity[i] == null)
				{
					BodyDef bodys = new BodyDef();
					bodys.position.set(new Vec2(x,y));
					bodys.angle =(float) Math.toRadians(rol);
					body[i] = world.createBody(bodys);
					PolygonShape groundBox = new PolygonShape();
					groundBox.setAsBox(sizex,sizey);
					body[i].createFixture(groundBox,0);
					entity[i] = new EntityRocket(sizex,sizey,i);
					entity[i].Texture = Roket.Textures[2];
					return i;
				}
			}
		return -1;
	}
	public int AddBuilding(float x,float y,float rol,float sizex,float sizey)
	{
		for(int i = 0;i < 100;++i)
		{
				if(entity[i] == null)
				{
					BodyDef bodys = new BodyDef();
					bodys.type = BodyType.DYNAMIC;
					bodys.position.set(new Vec2(x,y));
					bodys.angle =(float) Math.toRadians(rol);
					body[i] = world.createBody(bodys);
					PolygonShape groundBox = new PolygonShape();
					groundBox.setAsBox(sizex,sizey);
					FixtureDef fixtureDef = new FixtureDef();
					fixtureDef.shape = groundBox;
					fixtureDef.density = 3.0f;
					fixtureDef.friction = 10f;
					body[i].createFixture(fixtureDef);
					entity[i] = new EntityBuilding(sizex,sizey,i);
					return i;
				}
			}
		return -1;
	}
	public int AddRamp(float x,float y,float rol,float sizex,float sizey)
	{
		for(int i = 0;i < 100;++i)
		{
				if(entity[i] == null)
				{
					BodyDef bodys = new BodyDef();
					bodys.type = BodyType.KINEMATIC;
					bodys.position.set(new Vec2(x,y));
					bodys.angle = (float)Math.toRadians(rol);
					body[i] = world.createBody(bodys);
					PolygonShape groundBox = new PolygonShape();
					groundBox.setAsBox(sizex, sizey,new Vec2(x,y),0);
					FixtureDef fixtureDef = new FixtureDef();
					fixtureDef.shape = groundBox;
					fixtureDef.density = 1.0f;
					fixtureDef.friction = 0.3f;
					body[i].createFixture(fixtureDef);
					entity[i] = new EntityRamp(sizex,sizey,rol,i);
					return i;
				}
			}
		return -1;
	}
	public void Update()
	{
		Win = true;
		boolean Epen = true;
		world.step(Timestep, velocityIterations, positionIterations);
		for(int i = 0;i<100;++i)
		{
			if(entity[i] != null)
			{
				entity[i].Update(this);
				if(!entity[i].Expended)
				{
					Epen = false;
				}
				if(entity[i] instanceof EntityBuilding)
				{
					if(entity[i].PosY > TargetLine+20)
					{
						Win = false;
					}
				}
			}
		}
		if(CurentRoket >= RoketCount && Epen && !Win)
		{
			if(Timer > 100)
			{
			Fail = true;
			Roket.Scores[Roket.Leval] = 0;
			}
			else
			{
				Timer++;
			}
		}
		if(Win)
		{
			Roket.Scores[Roket.Leval] = 1;
		}
	}
}
