import Adventurer.Adventurer;
import Room.Turn;

public interface InterfaceCommand {
    public abstract void userTurn();
}

class moveCommand implements InterfaceCommand{

    private Turn t;
    public moveCommand( Turn newT){
        t = newT;
    }
    public void userTurn() {
        // TODO Auto-generated method stub
        t.moveAdventurers();
        
    }
    
}
class searchCommand implements InterfaceCommand{

    private Turn t;
    public searchCommand( Turn newT){
        t = newT;
    }
    public void userTurn() {
        // TODO Auto-generated method stub
        t.search();
        
    }
    
}
class celebrateCommand implements InterfaceCommand{

    private Turn t;
    public celebrateCommand( Turn newT){
        t = newT;
    }
    public void userTurn() {
        // TODO Auto-generated method stub
//        t.celebrate();
    }
    
}