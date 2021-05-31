

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


class SILab2Test {
    private SILab2 object;
    @Test
    void EveryT()
    {

        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> object.function(List.of(new Time(-12,0,0))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));
        ex = assertThrows(RuntimeException.class, () -> object.function(List.of(new Time(28,30,0))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));
        ex = assertThrows(RuntimeException.class, () -> object.function(List.of(new Time(0,-6,0))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));
        ex = assertThrows(RuntimeException.class, () -> object.function(List.of(new Time(22,44,98))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));
        assertEquals(72135, object.function(List.of(new Time(20,2,15))).get(0));
        assertEquals(86400,object.function(List.of(new Time(24,0,0))).get(0));
    }
    @Test
    void Multiple()
    {
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> object.function(List.of(new Time(-1,0,5))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class, () -> object.function(List.of(new Time(26,0,5))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        ex = assertThrows(RuntimeException.class, () -> object.function(List.of(new Time(20,-3,5))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () -> object.function(List.of(new Time(20,76,5))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () -> object.function(List.of(new Time(20,20,-234))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class, () -> object.function(List.of(new Time(20,20,552))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        assertEquals(72135, object.function(List.of(new Time(20,2,15))).get(0));
    }

}