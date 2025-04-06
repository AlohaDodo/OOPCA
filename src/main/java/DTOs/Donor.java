package DTOs;

import org.json.JSONObject;

public class Donor {
    private int donorId;
    private String firstName;
    private String secondName;
    private String teleNumber;

    public Donor(int donorId, String firstName, String secondName, String teleNumber) {
        this.donorId = donorId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.teleNumber = teleNumber;
    }

    //Json feature 7
    public JSONObject toJSONDonor() {
        JSONObject json = new JSONObject();
        json.put("donorId", donorId);
        json.put("firstName", firstName);
        json.put("secondName", secondName);
        json.put("teleNumber", teleNumber);
        return json;
    }

    public Donor() {
    }

    public int getDonorId() {
        return donorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getTeleNumber() {
        return teleNumber;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setTeleNumber(String teleNumber) {
        this.teleNumber = teleNumber;
    }

    @Override
    public String toString() {
        return "Donor{" +
                "donorId=" + donorId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", teleNumber='" + teleNumber + '\'' +
                '}';
    }
}
