package MyDSL;

import org.junit.Test;

public class TestCommandBuilder {
    Command command;
    @Test
    public void testCommandBuilder(){

        command = new ComandBuilder.Builder()
                 .addListOfDimensions()
                .addDimension().build();

        command.getCommands();
    }
}
