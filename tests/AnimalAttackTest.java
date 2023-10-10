import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalAttackTest {

    @Test
    public void testConstructor() {
        AnimalAttack attack = new AnimalAttack("claws", 3);
        assertEquals("claws", attack.getAttackType());
        assertEquals(3, attack.getDamage());
    }
}