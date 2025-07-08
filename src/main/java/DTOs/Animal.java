package DTOs;

import java.time.LocalDate;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Animal {
    private static int animalId;
    private static String type;
    private static String breed;
    private static String name;
    private static int age;
    private static float weight;
    private static boolean neutered;
    private static String health;
    private static LocalDate admitted;
    private static String gender;
    private static int donorId;

    public Animal(int animalId, String type, String breed, String name, int age, float weight, boolean neutered, String health, LocalDate admitted, String gender, int donorId) {
        this.animalId = animalId;
        this.type = type;
        this.breed = breed;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.neutered = neutered;
        this.health = health;
        this.admitted = admitted;
        this.gender = gender;
        this.donorId = donorId;
    }


    //Feature 7 - Convert List of Entities to a JSON String
    //Creating method
    public static String animalListToJson(List<Animal> animals) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for(Animal animal : animals) {
            jsonArray.put(convertToJSONObject(animals));
        }

        //Output
        jsonObject.put("animals", jsonArray);
        return jsonObject.toString();
    }

    public static JSONObject convertToJSONObject (List<Animal> animals) {
        JSONObject json = new JSONObject();
        json.put("id", animalId);
        json.put("type", type);
        json.put("breed", breed);
        json.put("name", name);
        json.put("age", age);
        json.put("weight", weight);
        json.put("neutered", neutered);
        json.put("health", health);
        json.put("admitted", admitted.toString());
        json.put("gender", gender);
        json.put("donorId", donorId);
        return json;
    }

    public Animal() {
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() { return  weight; }

    public void setWeight(float weight) { this.weight = weight; }

    public boolean isNeutered() {
        return neutered;
    }

    public void setNeutered(boolean neutered) {
        this.neutered = neutered;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public LocalDate getAdmitted() {
        return admitted;
    }

    public void setAdmitted(LocalDate admitted) {
        this.admitted = admitted;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public int getDonorId() {
        return donorId;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", type='" + type + '\'' +
                ", breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", neutered=" + neutered +
                ", health='" + health + '\'' +
                ", admitted=" + admitted +
                ", gender='" + gender + '\'' +
                ", donorId=" + donorId +
                '}';
    }


}
