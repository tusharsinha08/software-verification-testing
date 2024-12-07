import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class Q1Test {
    private Q1 q1;

    @BeforeAll
    static void setUpAll() {
        System.out.println("Hello");
    }

    @BeforeEach
    void setUpEach(){
        System.out.println("Get Set Go");
        q1 = new Q1();
    }


    @AfterEach
    void tearDown() {
        System.out.println("Finish");
        q1 = null;
    }

    @AfterAll
    static void tearDownAll(){
        System.out.println("Good Bye");
    }


    @Test
    void add() {
        int result = q1.add(5,3);
        assertEquals(8,result);
    }


    @Test
    void reverse() {
        String reversed = q1.reverse("hello");
        assertEquals("olleh",reversed);
    }
}