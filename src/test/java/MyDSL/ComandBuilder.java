package MyDSL;



import java.awt.*;
import java.util.*;
import java.util.List;

public class ComandBuilder {
    public static class Builder {
        private static Command command;
        private static String dimId = UUID.randomUUID().toString();

        private static Map<String, List<MyDimension>> listOfDimensions;

        public Builder() {
            command = new Command();
        }

        public Builder addDimension() {

            Dimension dimension = new Dimension();
            MyDimension myDimension = new MyDimension(dimension);

            Map<String, List<MyDimension>> myMap = command.getCommands();
            myMap.computeIfPresent(dimId, (k, v) ->
                    {
                        List<MyDimension> newDimList = new ArrayList<>();
                        newDimList.addAll(v);
                        newDimList.add(myDimension);
                        return newDimList;
                    }
            );
            command.setCommands(myMap);
            return this;
        }

        public Builder addListOfDimensions() {
            List<MyDimension> myDimensions = new ArrayList<>();
            listOfDimensions = new HashMap<>();

            listOfDimensions.put(dimId, myDimensions);
            command.setCommands(listOfDimensions);

            return this;
        }

        public Builder addItem(double height, double width){
            List<MyDimension> myDimensionList = listOfDimensions.get(dimId);
            Dimension dimension = new Dimension();
            dimension.setSize(height, width);
            MyDimension myDimension = new MyDimension(dimension);

            myDimensionList.add(myDimension);

            return this;
        }

        public List<MyDimension> getList(){
            return listOfDimensions.get(dimId);
        }

        public Builder removeAll(){
            listOfDimensions.clear();
            return this;
        }

        public Command build() {
            //do create stuff here
            return command;
        }
    }
    private ComandBuilder(){

    }
}
