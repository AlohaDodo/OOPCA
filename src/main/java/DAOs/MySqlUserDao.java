package DAOs;

import DTOs.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlUserDao extends MySqlDao {

    // Create a new animal record
    public void createAnimal(Animal animal) throws SQLException {
        String sql = "INSERT INTO animals (animal_id, type, breed, name, age, neutered, health, admitted, gender) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, animal.getAnimalId());
            pstmt.setString(2, animal.getType());
            pstmt.setString(3, animal.getBreed());
            pstmt.setString(4, animal.getName());
            pstmt.setInt(5, animal.getAge());
            pstmt.setBoolean(6, animal.isNeutered());
            pstmt.setString(7, animal.getHealth());
            pstmt.setDate(8, Date.valueOf(animal.getAdmitted()));
            pstmt.setString(9, animal.getGender());

            pstmt.executeUpdate();
        }
    }

    // Read an animal by ID
    public Animal getAnimalById(int animalId) throws SQLException {
        String sql = "SELECT * FROM animals WHERE animal_id = ?";

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
        String sql = "SELECT * FROM animals";
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
        String sql = "UPDATE animals SET type = ?, breed = ?, name = ?, age = ?, " +
                "neutered = ?, health = ?, admitted = ?, gender = ? WHERE animal_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, animal.getType());
            pstmt.setString(2, animal.getBreed());
            pstmt.setString(3, animal.getName());
            pstmt.setInt(4, animal.getAge());
            pstmt.setBoolean(5, animal.isNeutered());
            pstmt.setString(6, animal.getHealth());
            pstmt.setDate(7, Date.valueOf(animal.getAdmitted()));
            pstmt.setString(8, animal.getGender());
            pstmt.setInt(9, animal.getAnimalId());

            pstmt.executeUpdate();
        }
    }

    // Delete an animal
    public void deleteAnimal(int animalId) throws SQLException {
        String sql = "DELETE FROM animals WHERE animal_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, animalId);
            pstmt.executeUpdate();
        }
    }

    // Helper method to extract Animal from ResultSet
    private Animal extractAnimalFromResultSet(ResultSet rs) throws SQLException {
        return new Animal(
                rs.getInt("animal_id"),
                rs.getString("type"),
                rs.getString("breed"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getBoolean("neutered"),
                rs.getString("health"),
                rs.getDate("admitted").toLocalDate(),
                rs.getString("gender")
        );
    }
}
