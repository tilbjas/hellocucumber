package MyDSL;

import java.awt.*;
import java.util.List;

public class ListOfDimension {
    List<Dimension> dimensions;
    public ListOfDimension(Dimension dimension) {
        dimensions.add(dimension);
    }

    public Dimension getDimensionAtPos(int pos){
        return dimensions.get(pos);
    }
}


