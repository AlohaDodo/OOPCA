package DAOs;

import java.sql.SQLException;
import java.util.List;

import DTOs.Donor;

public interface DonorDao {
    void createDonor(Donor donor) throws SQLException;
    Donor getDonorById(int donorId) throws SQLException;
    List<Donor> getAllDonors() throws SQLException;
    void updateDonor(Donor donor) throws SQLException;
    void deleteDonor(int donorId) throws SQLException;
}
