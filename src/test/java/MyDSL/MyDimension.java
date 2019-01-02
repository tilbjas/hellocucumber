package MyDSL;

import java.awt.Dimension;
import java.util.UUID;

public class MyDimension {

    public Dimension dimension;

    public UUID Id;

    public MyDimension(Dimension dimension){
        this.dimension=dimension;
        Id = UUID.randomUUID();
    }

    public  Dimension getDimension() {
        return dimension;
    }
}
