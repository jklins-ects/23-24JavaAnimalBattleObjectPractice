//import static org.junit.Assert.*;

import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    private Animal animal;

    @BeforeEach
    public void setUp() {
        animal = new Animal("dog", 5, 15);
    }

    @Test
    public void testDefaultConstructor() {
        Animal defaultAnimal = new Animal();
        assertEquals("", defaultAnimal.getType());
        assertEquals(1, defaultAnimal.getStrength());
        assertEquals(10, defaultAnimal.getHealth());
    }

    @Test
    public void testParameterizedConstructorAndGetters() {
        assertEquals("dog", animal.getType());
        assertEquals(5, animal.getStrength());
        assertEquals(15, animal.getHealth());
    }

    @Test
    public void testSetType() {
        animal.setType("cat");
        assertEquals("cat", animal.getType());
    }

    @Test
    public void testSetStrength() {
        animal.setStrength(8);
        assertEquals(8, animal.getStrength());
    }

    @Test
    public void testSetHealthWithValidValue() {
        animal.setHealth(20);
        assertEquals(20, animal.getHealth());
    }

    @Test
    public void testSetHealthWithInvalidValue() {
        animal.setHealth(-5);
        assertEquals(0, animal.getHealth());
    }

    @Test
    public void testAttack() {
        int damage = animal.attack();
        assertTrue(damage >= 0 && damage <= 5); // Ensure damage is within the expected range.
    }

    @Test
    public void testToString() {
        assertEquals("Animal{type='dog', strength=5, health=15}", animal.toString());
    }

    @Test
    public void testDetailedAttack() {
        assertNotNull(animal.detailedAttack());
        assertEquals("attacks", animal.detailedAttack().getAttackType());
    }

}
