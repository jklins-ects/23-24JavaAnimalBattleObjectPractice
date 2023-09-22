import java.util.Random;

public class AnimalArena {
    public static Random rand = new Random();
    public static final int MAXHEALTH = 20;
    public static final int MAXSTRENGTH = 10;
    public static void main(String[] args) {
        Animal liz = CreateAnimalUsingDefaultConstructorAndMutators();
        Animal dog = CreateAnimalWithParameterizedConstructor();
        System.out.println(liz);
        System.out.println(dog);
        pause(2000);
        Fight(liz, dog);
    }

    public static Animal CreateAnimalUsingDefaultConstructorAndMutators(){
        //default constructor. We create an OBJECT from the Animal CLASS
        Animal a = new Animal();
        a.setType("lizard"); //mutator methods. Notice "set[Property]"
        a.setStrength(rand.nextInt(MAXSTRENGTH) + 1);//+1 to make sure it's between 1 and 10
        a.setHealth(rand.nextInt(11,MAXHEALTH + 1));// +1 to set the EXCLUSIVE upper bound to max+1
        return a;
    }

    public static Animal CreateAnimalWithParameterizedConstructor(){
        int strength = rand.nextInt(MAXSTRENGTH) + 1; //+1 to make sure it's between 1 and 10
        int health = rand.nextInt(11,MAXHEALTH + 1); // +1 to set the EXCLUSIVE upper bound to max+1
        //parameterized constructor. We create an OBJECT from the Animal CLASS
        Animal a = new Animal("dog",strength,health);
        return a;
    }

    public static void Fight(Animal a1, Animal a2){
        int millidelay = 500; //use this variable to control timing.

        //loop as long as both animals are alive
        while(a1.getHealth() > 0 && a2.getHealth() > 0){
            //get a random attack value
            int attack = rand.nextInt(a1.getStrength());
            //use getter methods to print stats
            System.out.println(a1.getType() + " attacks " + a2.getType() +
                    " delivering " + attack + " damage");
            //update the animals health with the setter
            a2.setHealth(a2.getHealth() - attack);
            pause(millidelay);
            System.out.println(a2.getType() + " has " + a2.getHealth() + " health remaining.");
            pause(millidelay);
            if(a2.getHealth() <= 0){
                System.out.println(a2.getType() + " is dead. " + a1.getType() + " won");
            }else{
                attack = rand.nextInt(a2.getStrength());
                System.out.println(a2.getType() + " attacks " + a1.getType() +
                        " delivering " + attack + " damage");
                a1.setHealth(a1.getHealth() - attack);
                pause(millidelay);
                System.out.println(a1.getType() + " has " + a1.getHealth() + " health remaining.");
                pause(millidelay);
                if(a1.getHealth() <= 0){
                    System.out.println(a1.getType() + " is dead. " + a2.getType() + " won");
                }
            }
        }
    }

    /**
     * helper method to clean up code a bit and pull the try/catch sleep out
     */
    public static void pause(int millis){
        //need a try catch because the sleep method can throw an exception.
        //java will not compile if you do not handle a method that declares it may throw and exception.
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
