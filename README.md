Project for discovering Cucumber

Can use cucumber options to print out Junit file

    format = { “junit:Folder_Name/cucumber.xml“}

Basic ones:

    @RunWith(Cucumber.class)
    @CucumberOptions(
	    features = "Feature"
	    ,glue={"stepDefinition"}
    )

Another useful option:

    tags = {"~@Ignore"},
