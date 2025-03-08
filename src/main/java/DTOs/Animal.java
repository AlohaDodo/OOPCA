package DTOs;

import java.time.LocalDate;

public class Animal {
    private int animalId;
    private String type;
    private String breed;
    private String name;
    private int age;
    private boolean neutered;
    private String health;
    private LocalDate admitted;
    private String gender;
    private int donorId;

    public Animal(int animalId, String type, String breed, String name, int age, boolean neutered, String health, LocalDate admitted, String gender, int donorId) {
        this.animalId = animalId;
        this.type = type;
        this.breed = breed;
        this.name = name;
        this.age = age;
        this.neutered = neutered;
        this.health = health;
        this.admitted = admitted;
        this.gender = gender;
        this.donorId = donorId;
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
                ", neutered=" + neutered +
                ", health='" + health + '\'' +
                ", admitted=" + admitted +
                ", gender='" + gender + '\'' +
                ", donorId=" + donorId +
                '}';
    }


}
