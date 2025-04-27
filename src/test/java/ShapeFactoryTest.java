import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.awt.*;

public class ShapeFactoryTest {
    @Test
    public void shapeColorTest(){
        ShapeFactory factory = new ShapeFactory(78);
        Assertions.assertEquals(Color.red, factory.paint, "Show color must be red");
    }
}