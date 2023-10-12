package animal;

import java.util.ArrayList;

public class Catalog {
    private ArrayList<Entity> books;

    public Catalog() {
        books = new ArrayList<>();
    }

    public ArrayList<Entity> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Entity> books) {
        this.books = books;
    }

    public void push(Entity b) {
        books.add(b);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entity b : books) {
            sb.append(b.toString());
        }
        return sb.toString();
    }

}
