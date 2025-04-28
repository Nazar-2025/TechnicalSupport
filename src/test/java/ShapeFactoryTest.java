import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.awt.*;

class ShapeFactoryTest {
    @Test
    void shapeColorTest(){
        ShapeFactory factory = new ShapeFactory(7,8);
        Assertions.assertEquals(Color.red, factory.getPaint(), "Show color must be red");
    }
}