package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private final String roll;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;

    public static class BigmacBuilder {
        private String roll;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder roll(String roll) {
            if (roll == "With sesame seeds" || roll == "Without sesame seeds") {
                this.roll = roll;
            } else {
                throw new IllegalStateException("You can choose only this types of roll: \n1. With sesame seeds \n2. Without sesame seeds");
            }
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            if (burgers <= 3) {
                this.burgers = burgers;
            } else {
                throw new IllegalStateException("You can choose max 3 burgers");
            }
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            if (sauce == "Standard" || sauce == "Barbecue" || sauce == "1000 islands") {
                this.sauce = sauce;
            } else {
                throw new IllegalStateException("You can choose only one of this types of sauce: \n1. Standard\n2.Barbecue\n3.1000 islands");
            }
            return this;

        }

        public BigmacBuilder ingredient(String ingredient) {
            if (ingredient == "lettuce" || ingredient == "onion" || ingredient == "bacon" || ingredient == "cucumber" || ingredient == "chilli pepper" || ingredient == "mushrooms" || ingredient == "shrimp" || ingredient == "cheese") {
                ingredients.add(ingredient);
            } else {
                throw new IllegalStateException("You can't add this ingredient to your Bigmac");
            }
            return this;
        }

        public Bigmac build() {
            return new Bigmac(roll, burgers, sauce, ingredients);
        }
    }

    public Bigmac(String roll, int burgers, String sauce, List<String> ingredients) {
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public String getRoll() {
        return roll;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "roll='" + roll + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
