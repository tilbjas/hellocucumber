package MyDSL;

import java.util.HashMap;
import java.util.Map;

public class Command<T,V> {
    Map<T,V> commands;

    public Command(){
        commands = new HashMap();
    }
//create copy
    public void setCommands(Map<T,V> commands) {
        commands.forEach((T,V) -> this.commands.put(T,V) );
    }
//get commands back
    public Map<T,V> getCommands(){
        return commands;
    }
}
