package Celebration;



public abstract class Celebration{
    public String celebrate(){ return "";};
}
class Shout extends Celebration{
    @Override
    public String celebrate(){
        return("Shout");
    }
  

}
class Dance extends Celebration{
    @Override
    public String celebrate(){
        return("Dance");
    }

    
}
class Jump extends Celebration{
    @Override
    public String celebrate(){
        return("Jump");
    }

    
}
class Spin extends Celebration{
    @Override
    public String celebrate(){
        return("Spin");
    }
    
}
