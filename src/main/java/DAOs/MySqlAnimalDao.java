package DAOs;

import DTOs.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlAnimalDao extends MySqlDao {

    // Create a new animal record
    public void createAnimal(Animal animal) throws SQLException {
        String sql = "INSERT INTO animal (animal_id, type, breed, name, age, weight, neutered, health, admitted, gender, donorId) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, animal.getAnimalId());
            pstmt.setString(2, animal.getType());
            pstmt.setString(3, animal.getBreed());
            pstmt.setString(4, animal.getName());
            pstmt.setInt(5, animal.getAge());
            pstmt.setFloat(6, animal.getWeight());
            pstmt.setBoolean(7, animal.isNeutered());
            pstmt.setString(8, animal.getHealth());
            pstmt.setDate(9, Date.valueOf(animal.getAdmitted()));
            pstmt.setString(10, animal.getGender());
            pstmt.setInt(11, animal.getDonorId());

            pstmt.executeUpdate();
        }
    }

    // Read an animal by ID
    public Animal getAnimalById(int animalId) throws SQLException {
        String sql = "SELECT * FROM animal WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, animalId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return extractAnimalFromResultSet(rs);
            }
            return null;
        }
    }

    // Read all animals
    public List<Animal> getAllAnimals() throws SQLException {
        String sql = "SELECT * FROM animal";
        List<Animal> animals = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                animals.add(extractAnimalFromResultSet(rs));
            }
            return animals;
        }
    }

    // Update an animal
    public void updateAnimal(Animal animal) throws SQLException {
        String sql = "UPDATE animal SET type = ?, breed = ?, name = ?, age = ?, weight = ?" +
                "neutered = ?, health = ?, admitted = ?, gender = ? WHERE animal_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, animal.getType());
            pstmt.setString(2, animal.getBreed());
            pstmt.setString(3, animal.getName());
            pstmt.setInt(4, animal.getAge());
            pstmt.setFloat(5, animal.getWeight());
            pstmt.setBoolean(6, animal.isNeutered());
            pstmt.setString(7, animal.getHealth());
            pstmt.setDate(8, Date.valueOf(animal.getAdmitted()));
            pstmt.setString(9, animal.getGender());
            pstmt.setInt(10, animal.getAnimalId());

            pstmt.executeUpdate();
        }
    }

    // Delete an animal
    public void deleteAnimal(int animalId) throws SQLException {
        String sql = "DELETE FROM animal WHERE animal_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, animalId);
            pstmt.executeUpdate();
        }
    }

    // Helper method to extract Animal from ResultSet
    private Animal extractAnimalFromResultSet(ResultSet rs) throws SQLException {
        return new Animal(
                rs.getInt("id"),
                rs.getString("type"),
                rs.getString("breed"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getFloat("weight"),
                rs.getBoolean("neutered"),
                rs.getString("health"),
                rs.getDate("admitted").toLocalDate(),
                rs.getString("gender"),
                rs.getInt("donor_id")
        );
    }
}
