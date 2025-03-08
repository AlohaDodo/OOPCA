package DAOs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DTOs.Donor;

public class MySqlDonorDao extends MySqlDao implements DonorDao {

    @Override
    public void createDonor(Donor donor) throws SQLException {
        String sql = "INSERT INTO donors (donor_id, first_name, second_name, tele_number) " +
                    "VALUES (?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, donor.getDonorId());
            pstmt.setString(2, donor.getFirstName());
            pstmt.setString(3, donor.getSecondName());
            pstmt.setString(4, donor.getTeleNumber());
            pstmt.executeUpdate();
        }
    }

    @Override
    public Donor getDonorById(int donorId) throws SQLException {
        String sql = "SELECT * FROM donors WHERE donor_id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, donorId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return extractDonorFromResultSet(rs);
            }
            return null;
        }
    }

    @Override
    public List<Donor> getAllDonors() throws SQLException {
        String sql = "SELECT * FROM donors";
        List<Donor> donors = new ArrayList<>();
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                donors.add(extractDonorFromResultSet(rs));
            }
            return donors;
        }
    }

    @Override
    public void updateDonor(Donor donor) throws SQLException {
        String sql = "UPDATE donors SET first_name = ?, second_name = ?, tele_number = ? " +
                    "WHERE donor_id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, donor.getFirstName());
            pstmt.setString(2, donor.getSecondName());
            pstmt.setString(3, donor.getTeleNumber());
            pstmt.setInt(4, donor.getDonorId());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void deleteDonor(int donorId) throws SQLException {
        String sql = "DELETE FROM donors WHERE donor_id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, donorId);
            pstmt.executeUpdate();
        }
    }

    private Donor extractDonorFromResultSet(ResultSet rs) throws SQLException {
        return new Donor(
            rs.getInt("donor_id"),
            rs.getString("first_name"),
            rs.getString("second_name"),
            rs.getString("tele_number")
        );
    }
}