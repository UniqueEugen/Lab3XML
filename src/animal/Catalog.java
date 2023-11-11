package animal;

import java.util.ArrayList;

public class Catalog {
    private ArrayList<Entity> animals;

    public Catalog() {
        animals = new ArrayList<>();
    }

    public ArrayList<Entity> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Entity> animals) {
        this.animals = animals;
    }

    public void push(Entity b) {
        animals.add(b);
    }

    @Override
    public String toString() {
        animals.forEach(animal->animal.toString());
        return null;
    }

}
