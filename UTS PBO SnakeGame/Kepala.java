import greenfoot.*;

public class Kepala extends Ular
{    
    public void addUlar()
    {
        
    }
    
    public void act() 
    {
        Actor actor=getOneIntersectingObject(Ular.class);
        if(actor!=null){
            getWorld().addObject(new GameOver(),(int)(0.5*getWorld().getWidth()),(int)(0.5*getWorld().getHeight()));
            ((MyWorld)getWorld()).GAMEOVER=true;
            return;
        }
        
        actor=getOneIntersectingObject(Makanan.class);
        if(actor!=null){
            getWorld().removeObject(actor);
            ((MyWorld)getWorld()).setScore(5);
            Ular.ADDEKOR=true;
            ((MyWorld)getWorld()).addMakanan();
        }
        
        if(Greenfoot.isKeyDown("w") && arahy!=1){
            arahx=0;
            arahy=-1;
        }else if(Greenfoot.isKeyDown("s") && arahy!=-1){
            arahx=0;
            arahy=1;
        }else if(Greenfoot.isKeyDown("d") && arahx!=-1){
            arahx=1;
            arahy=0;
        }else if(Greenfoot.isKeyDown("a") && arahx!=1){
            arahx=-1;
            arahy=0;
        }
        super.act();
        if(isAtEdge()){
            getWorld().addObject(new tryagain(),(int)(0.5*getWorld().getWidth()),(int)(0.5*getWorld().getHeight()));
            ((MyWorld)getWorld()).GAMEOVER=true;
            return;
        }
    }    
}
