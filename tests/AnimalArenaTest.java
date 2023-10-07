import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalArenaTest {
    private Animal liz;
    private Animal dog;

    @BeforeEach
    void setUp() {
        // Initialize animals for testing
        liz = new Animal("lizard", 5, 15);
        dog = new Animal("dog", 8, 18);
    }

    @Test
    void testCreateAnimalUsingDefaultConstructorAndMutators() {
        // Test creating an animal using default constructor and mutators
        Animal newAnimal = AnimalArena.CreateAnimalUsingDefaultConstructorAndMutators();

        assertNotNull(newAnimal);
        assertNotNull(newAnimal.getType());
        assertTrue(newAnimal.getStrength() >= 1 &&
                newAnimal.getStrength() <= 10);
        assertTrue(newAnimal.getHealth() >= 0 &&
                newAnimal.getHealth() <= AnimalArena.MAXHEALTH + 1);
    }

    @Test
    void testCreateAnimalWithParameterizedConstructor() {
        // Test creating an animal using parameterized constructor
        Animal newAnimal = AnimalArena.CreateAnimalWithParameterizedConstructor();

        assertNotNull(newAnimal);
        assertEquals("dog", newAnimal.getType());
        assertTrue(newAnimal.getStrength() >= 1 &&
                newAnimal.getStrength() <= 10);
        assertTrue(newAnimal.getHealth() >= 0 &&
                newAnimal.getHealth() <= AnimalArena.MAXHEALTH + 1);
    }

    @Test
    void testAnimalAttack() {
        // Test animal attack method
        int initialHealth = liz.getHealth();
        AnimalArena.animalAttack(dog, liz);
        int newHealth = liz.getHealth();

        assertTrue(newHealth <= initialHealth &&
                newHealth >= initialHealth - dog.getStrength());
    }

    @Test
    void testFight() {
        // Test the fight method
        int initialHealthLiz = liz.getHealth();
        int initialHealthDog = dog.getHealth();
        AnimalArena.Fight(liz, dog);
        int newHealthLiz = liz.getHealth();
        int newHealthDog = dog.getHealth();

        assertTrue((newHealthLiz <= 0 && newHealthDog <= 0) ||
                (newHealthLiz > 0 && newHealthDog <= 0) ||
                (newHealthLiz <= 0 && newHealthDog > 0));
    }
}
