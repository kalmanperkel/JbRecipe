package co.jbtraining.mobile.jbrecipe;

/**
 * Created by kalmanperkel on 22/05/2016.
 */
public class Recipe {

    String name;
    String body;
    String postition;


    public Recipe(String body, String name) {
        this.body = body;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
