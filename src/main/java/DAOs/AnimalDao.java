package DAOs;

import java.sql.SQLException;
import java.util.List;

import DTOs.Animal;
import Exceptions.DaoException;

public interface AnimalDao {
    void createAnimal(Animal animal) throws SQLException;
    Animal getAnimalById(int animalId) throws SQLException;
    List<Animal> getAllAnimals() throws SQLException;
    void updateAnimal(Animal animal) throws SQLException;
    void deleteAnimal(int animalId) throws DaoException;
    List<Animal> getAnimalByType() throws SQLException;
}