package DAOs;

import DTOs.Animal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MySqlAnimalDao extends MySqlDao {

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

    //Feature 1 - Get all Entities
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

    //Feautre 2 - Find animal by a single entity ( ID )
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

    //Feature 3 - Delete an animal by key ( ID )
    public void deleteAnimal(int animalId) throws SQLException {
        String sql = "DELETE FROM animal WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, animalId);
            pstmt.executeUpdate();
        }
    }

    //Feature 4 - Insert a new entity
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

    //Feature 5 - Update an existing entity by ID
    public Animal updateHealth(String newHealth, int animalId) throws SQLException {
        String sql = "UPDATE animal SET health = ? WHERE id = ?";

        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql); {
                pstmt.setString(1, newHealth);
                pstmt.setInt(2, animalId);
                pstmt.executeUpdate();
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Feature 6 - Filter out animals based on type
    public List<Animal> getAnimalByType(String animalType) throws SQLException {
        String sql = "SELECT * FROM animal WHERE type LIKE ?";
        List<Animal> filteredAnimalTypes = new ArrayList<>();

        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            {
                pstmt.setString(1, animalType);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    filteredAnimalTypes.add(extractAnimalFromResultSet(rs));
                }
                return filteredAnimalTypes;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}


