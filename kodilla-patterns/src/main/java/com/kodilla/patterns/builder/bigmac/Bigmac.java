package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.Arrays;
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
        final private List<String> LIST_OF_AVAILABLE_ROLL = new ArrayList<>(Arrays.asList("With sesame seeds", "Without sesame seeds"));
        final private List<String> LIST_OF_AVAILABLE_SAUCE = new ArrayList<>(Arrays.asList("Standard", "Barbecue", "1000 islands"));
        final private List<String> LIST_OF_AVAILABLE_INGREDIENTS = new ArrayList<>(Arrays.asList("lettuce", "onion", "bacon", "cucumber", "chilli pepper", "mushrooms", "shrimp", "cheese"));


        public BigmacBuilder roll(String roll) {
            if (LIST_OF_AVAILABLE_ROLL.contains(roll)) {
                this.roll = roll;
            } else {
                LIST_OF_AVAILABLE_ROLL.forEach(System.out::println);
                throw new IllegalStateException("You can choose only one of the above types, try again.");
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
            if (LIST_OF_AVAILABLE_SAUCE.contains(sauce)) {
                this.sauce = sauce;
            } else {
                LIST_OF_AVAILABLE_SAUCE.forEach(System.out::println);
                throw new IllegalStateException("You can choose only one of the above types, try again.");
                }
            return this;

        }

        public BigmacBuilder ingredient(String ingredient) {
            if (LIST_OF_AVAILABLE_INGREDIENTS.contains(ingredient)) {
                ingredients.add(ingredient);
            } else {
                LIST_OF_AVAILABLE_INGREDIENTS.forEach(System.out::println);
                throw new IllegalStateException("You can choose only one of the above types, try again.");
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
