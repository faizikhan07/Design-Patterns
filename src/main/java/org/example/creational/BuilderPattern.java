package org.example.creational;

class Food {
    private String name;
    private int calories;
    private String sauce;
    private boolean isSpicy;
    private boolean isVeg;

    /*
    public Food(String name, int calories, String sauce, boolean isSpicy) {
        this.name = name;
        this.calories = calories;
        this.sauce = sauce;
        this.isSpicy = isSpicy;
    }

    public Food(String name, int calories, boolean isSpicy) {
        this.name = name;
        this.calories = calories;
        this.isSpicy = isSpicy;
    }

    public Food(String name, int calories, boolean isVeg) {
        this.name = name;
        this.calories = calories;
        this.isVeg = isVeg;
    }

     */



    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", sauce='" + sauce + '\'' +
                ", isSpicy=" + isSpicy +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setSpicy(boolean spicy) {
        isSpicy = spicy;
    }

    public void setVeg(boolean veg) {
        isVeg = veg;
    }

    public Food(Builder builder) {
        this.name = builder.name;
        this.calories = builder.calories;
        this.sauce = builder.sauce;
        this.isSpicy = builder.isSpicy;
        this.isVeg = builder.isVeg;
    }



    public static class Builder {
        private String name;
        private int calories;
        private String sauce;
        private boolean isSpicy;
        private boolean isVeg;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCalories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder setSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public Builder setSpicy(boolean spicy) {
            isSpicy = spicy;
            return this;
        }

        public Builder setVeg(boolean veg) {
            isVeg = veg;
            return this;
        }

        public Food build() {
            return new Food(this);
        }
    }
}

public class BuilderPattern {

    public static void main(String[] args) {
//        Food bread = new Food();
//        bread.setName("bread");
//        bread.setCalories(250);
//
//        Food breadModified = new Food();
//        breadModified.setName("new bread");       Inconsistent state
//        breadModified.setCalories(300);
//        breadModified.setVeg(true);
//
//        System.out.println(bread);
//        System.out.println(breadModified);
        Food breadModified = new Food.Builder().setName("New bread").setCalories(300).setVeg(true).build();
        System.out.println(breadModified);
    }
}

/**
 * PROBLEM WITH ABOVE PROGRAM
 *
 * Let's say i want to create an object with first two & last one parameter of Food constructor, so in that case i have to mention all four parameters when creating object and calling
 * constructor and using only with that thing, i can create an object.
 *
 * Let's say in the above example, we don't want sauce parameter, what we will do? We will just create another constructor in the class with only three parameters.
 *
 * But by this way, there comes another problem and that is let's say we want to define one more boolean variable i.e., isVeg is of type boolean. that will create ambiguity between the
 * constructors. So, instead of creating constructor, we can even make setter methods within the class. which will set all the values one by one after the object creation. But, when we
 * set the values of an object one by one, that is called inconsistent state. so, to remove inconsistent state, we create builder design pattern.
 *
 * Above is the example of
 */
