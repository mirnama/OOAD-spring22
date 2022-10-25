import Adventurer.Adventurer;

public interface InterfaceCommand {
    public abstract void userTurn();
}

class moveCommand implements InterfaceCommand{

    private Adventurer a;
    public void userTurn() {
        // TODO Auto-generated method stub
        a.move();
        
    }
    
}
class searchCommand implements InterfaceCommand{

    private Adventurer a;
    public void userTurn() {
        // TODO Auto-generated method stub
        a.search();
        
    }
    
}
class celebrateCommand implements InterfaceCommand{

    private Adventurer a;
    public void userTurn() {
        // TODO Auto-generated method stub
        a.celebrate();
    }
    
}