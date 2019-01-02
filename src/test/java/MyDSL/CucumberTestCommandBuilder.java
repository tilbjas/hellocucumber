package MyDSL;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CucumberTestCommandBuilder {
    MyDSL.ComandBuilder.Builder commandBuilder;
    @Given("I have a valid command builder")
    public void i_have_a_valid_command_builder() {
        // Write code here that turns the phrase above into concrete actions
        commandBuilder = new ComandBuilder.Builder();

    }

    @When("I add a list of dimension")
    public void i_add_a_list_of_dimension() {
        // Write code here that turns the phrase above into concrete actions
        commandBuilder.addListOfDimensions();

    }

    @Then("I can add a single dimension and build the command")
    public void i_can_add_a_single_dimension() {
        // Write code here that turns the phrase above into concrete actions
        Command command = commandBuilder.addDimension().build();
        System.out.println(command.getCommands().toString());

        assertThat(command.getCommands().size()).isEqualTo(1);
    }

    @After
    public void cleanUp(){
        commandBuilder.removeAll();
    }
    @Given("I have a list of dimensions")
    public void i_have_a_list_of_dimensions() {
        // Write code here that turns the phrase above into concrete actions
        commandBuilder = new ComandBuilder.Builder().addListOfDimensions();

    }

    @Given("a new dimension")
    public void a_new_dimension() {
        // Write code here that turns the phrase above into concrete actions
        commandBuilder.addDimension();

    }

    @When("I add an item to the dimension")
    public void i_add_an_item_to_the_dimension() {
        // Write code here that turns the phrase above into concrete actions
        commandBuilder.addItem(10D,20D);

    }

    @Then("I can get its value")
    public void i_can_get_its_value() {
        // Write code here that turns the phrase above into concrete actions
        List<MyDimension> myDimensionList = commandBuilder.getList();

        assertThat(myDimensionList.get(0).getDimension()).isEqualTo(new Dimension(10,20));

    }

    @Then("there is only one dimension")
    public void there_is_only_one_dimension(){
        assertThat(commandBuilder.getList().size()).isEqualTo(1);
    }

    @When("I add two items to the dimension")
    public void i_add_two_items_to_the_dimension() {
        // Write code here that turns the phrase above into concrete actions
        commandBuilder.addItem(10D,20D);
        commandBuilder.addItem(10D,30D);
    }

    @Then("I can get its values")
    public void i_can_get_its_values() {
        // Write code here that turns the phrase above into concrete actions
        List<MyDimension> myDimensionList = commandBuilder.getList();

        assertThat(myDimensionList.get(0).getDimension()).isEqualTo(new Dimension(10,20));
        assertThat(myDimensionList.get(1).getDimension()).isEqualTo(new Dimension(10,30));

    }
}
