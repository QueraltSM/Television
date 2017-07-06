import org.junit.*;
import static org.junit.Assert.*;

public class TestJUnit {
    private static Television t = new Television();
    private static Channel c1;
    private static Channel c2;
    private static Channel c3;


    @Before
    public void inicialitazion() {
        t = new Television();
        c1 = new Channel("Television 1");
        c2 = new Channel("Channel 2");
        c3 = new Channel("Jason 3");
    }


    @After
    public void finalization() {
        System.out.println("Test was successful");
    }

    @Test
    public void test1() {
        assertEquals(t.toString(), "");
        t.addChannel(c1);
        t.addChannel(c1);
        t.addChannel(c2);
        assertEquals(t.toString(), c1.toString() + "\n\n" + c2.toString() + "\n\n");
    }


    @Test
    public void test2() {
        t.addChannel(c1);
        t.addChannel(c2);
        t.addChannel(c3);
        t.setOrder(0);
        assertEquals(t.toString(), c1.toString() + "\n\n" + c2.toString() + "\n\n" + c3.toString() + "\n\n" );

        t.setOrder(1);
        assertEquals(t.toString(), c2.toString() + "\n\n" + c3.toString() + "\n\n" + c1.toString() + "\n\n" );
    }

    @Test
    public void test3() {
        t.addChannel(c1);
        t.addChannel(c2);
        t.addChannel(c3);
        assertTrue(t.search(c2.getName()).equals(c2));
        assertEquals(t.search(new Channel("Channel Four").getName()), null);
    }


    @Test
    public void test4() {
        t.addChannel(c1);
        t.addChannel(c2);
        t.addChannel(c3);
        t.removeChannel(c2.getName());
        assertEquals(t.toString(), c1.toString() + "\n\n" + c3.toString() + "\n\n");
    }

    @Test
    public void test5() {
        t.addChannel(c1);
        t.addChannel(c2);
        t.addChannel(c3);
        t.swapChannels(c3, c2);
        assertEquals(t.toString(), c1.toString() + "\n\n" + c3.toString() + "\n\n" + c2.toString() + "\n\n");

        t.swapChannels(c1, c2);
        assertEquals(t.toString(), c2.toString() + "\n\n" + c3.toString() + "\n\n" + c1.toString() + "\n\n");

        t.setOrder(0);
        assertEquals(t.toString(), c2.toString() + "\n\n" + c3.toString() + "\n\n" + c1.toString() + "\n\n");

        t.setOrder(1);
        assertEquals(t.toString(), c2.toString() + "\n\n" + c3.toString() + "\n\n" + c1.toString() + "\n\n");
    }

    public static void main(String[] args) {

    }
}
