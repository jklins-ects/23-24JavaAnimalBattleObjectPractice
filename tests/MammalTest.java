import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MammalTest {

    private Mammal mammal;

    @Before
    public void setUp() {
        mammal = new Mammal("Monkey", 7, 18);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Monkey", mammal.getType());
        assertTrue(mammal.getStrength() >= 1 && mammal.getStrength() <= 10);
        assertTrue(mammal.getHealth() >= 1 && mammal.getHealth() <= 20);
    }

    @Test
    public void testAttack() {
        int damage = mammal.attack();
        assertTrue(damage >= 0 && damage <= 7); // Ensure damage is within the expected range.
    }

    @Test
    public void testDetailedAttack() {
        AnimalAttack attack = mammal.detailedAttack();
        assertNotNull(attack);
        assertNotNull(attack.getAttackType());
        assertTrue(attack.getDamage() >= 0 && attack.getDamage() <= 7); // Ensure damage is within the expected range.
    }
}

