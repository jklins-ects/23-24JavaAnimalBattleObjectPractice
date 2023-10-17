import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class AnimalBrawl {
    private static ArrayList<Animal> animals; //class level variable - static because there is no instance
    private static Scanner input = new Scanner(System.in);
    public static final int MILLIDELAY = 500;
    public static void main(String[] args) {
        animals = new ArrayList<>();
        String userIn;
        do {
            System.out.print("Enter A to add an animal, M to add a mammal and B when it's time to brawl: ");
            userIn = input.nextLine().trim().toUpperCase();
            if(userIn.equals("A")){
                addAnimal();
            }if(userIn.equals("M")){
                addMammal();
            }
        }while(!userIn.equals("B")); //note: using !string.equals("string"), not !=

        if(animals.size() >= 2){
            System.out.println("Here's the roster: ");
            for (Animal a: animals
            ) {
                System.out.println(a);
            }

            brawl();
            System.out.println("All but one animal has been defeated");
            System.out.println(animals.get(0).getType() + " is the winner!");
        }else{
            System.out.println("Not enough animals to brawl.");
        }
    }

    public static void addAnimal(boolean isMammal){
        if(isMammal){
            System.out.println("Creating Mammal");
        }else{
            System.out.println("Creating Animal");
        }
        System.out.print("Please enter the type: ");
        String type = input.nextLine();
        System.out.print("Please enter the strength (invalid ints will be treated as 1): ");
        int strength = Utilities.parseInt(input.nextLine(), 1);
        System.out.print("Please enter the health (invalid ints will be treated as 1): ");
        int health = Utilities.parseInt(input.nextLine(), 1);
        if(isMammal){
            animals.add(new Mammal(type, strength, health));
        }else{
            animals.add(new Animal(type, strength, health));
        }


    }
    public static void addMammal(){
        addAnimal(true);
    }

    public static void addAnimal(){
        addAnimal(false);
    }

    public static void brawl(){
        do{
            int attacker = ThreadLocalRandom.current().nextInt(animals.size());
            int defender;
            do{
                defender = ThreadLocalRandom.current().nextInt(animals.size());
            }while(attacker == defender);
            animalAttack(animals.get(attacker), animals.get(defender));
            if(animals.get(defender).getHealth() <= 0){
                System.out.println(ConsoleColors.RED + animals.get(defender).getType() + " has been defeated." + ConsoleColors.RESET);
                animals.remove(defender);
                if(animals.size() > 1){
                    System.out.println(ConsoleColors.YELLOW + animals.size() + " animals remain." + ConsoleColors.RESET);
                }
            }
        }while(animals.size() > 1);
    }

    public static void animalAttack(Animal attacker, Animal defender){
        //get a random attack value
        int attack;
        if(attacker instanceof Mammal){
            AnimalAttack a = attacker.detailedAttack();
            attack = a.getDamage();
            System.out.println(ConsoleColors.RED + attacker.getType() + " attacks with " + a.getAttackType()+ ConsoleColors.RESET);
        }else{
            attack = attacker.attack();
        }

        //use getter methods to print stats
        if(defender instanceof Mammal){
            Mammal def = (Mammal) defender;
            System.out.println("Defended!");
            int newAttack = def.defend(attack);
            if(newAttack < attack){
                System.out.println(ConsoleColors.GREEN + "Damage reduced from " + attack + " to " + newAttack + ConsoleColors.RESET);
            }
            attack = newAttack;
        }
        System.out.println(attacker.getType() + " attacks " + defender.getType() +
                " delivering " + attack + " damage");
        //update the animals health with the setter
        defender.setHealth(defender.getHealth() - attack);
        Utilities.pause(MILLIDELAY);
        System.out.println(defender.getType() + " has " + defender.getHealth() + " health remaining.");
        Utilities.pause(MILLIDELAY);
    }

}
