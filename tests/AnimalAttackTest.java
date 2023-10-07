import static org.junit.Assert.*;
import org.junit.Test;

public class AnimalAttackTest {

    @Test
    public void testConstructor() {
        AnimalAttack attack = new AnimalAttack("claws", 3);
        assertEquals("claws", attack.getAttackType());
        assertEquals(3, attack.getDamage());
    }
}