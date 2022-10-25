package Celebration;
import combat.*;


public abstract class Celebration implements Combat{
    public String celebrate(){ return "";};
}
class Shout extends Celebration{
    @Override
    public String celebrate(){
        return("Shout");
    }

	@Override
	public String fight() {
		// TODO Auto-generated method stub
		return null;
	}
  

}
class Dance extends Celebration{
    @Override
    public String celebrate(){
        return("Dance");
    }

    @Override
    public String fight() {
        // TODO Auto-generated method stub
        return null;
    }

    
}
class Jump extends Celebration{
    @Override
    public String celebrate(){
        return("Jump");
    }

    @Override
    public String fight() {
        // TODO Auto-generated method stub
        return null;
    }

    
}
class Spin extends Celebration{
    @Override
    public String celebrate(){
        return("Spin");
    }

    @Override
    public String fight() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
