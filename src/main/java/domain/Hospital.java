package domain;

public class Hospital {
    private String id;

    public Hospital(String id, String address) {
        this.id = id;
        this.address = address;
    }


    public String getAddress() {
        return address;
    }

    public String getDistrict() {

      return  district;
    }

    public String getCategory() {
        return category;
    }

    public Integer getEmergencyRoom() {
        return emergencyRoom;
    }

    public String getName() {
        return name;
    }

    public String getSubdivision() {
        return subdivision;
    }

    private String address;
    private String district;
    private String category;
    private Integer emergencyRoom; // snake camel
    private String name; // snake camel
    private String subdivision; // snake camel

    public Hospital(String id, String address, String category, Integer emergencyRoom, String name, String subdivision) {
        this.id = id;
        this.address = address;
        String[] splitted = this.address.split(" ");
        this.district = String.format("%s %s",splitted[0],splitted[1]);
        this.category = category;
        this.emergencyRoom = emergencyRoom;
        this.name = name;
        this.subdivision = subdivision;
    }

    public Hospital(String id) {
        this.id = id.replace("\"","");
    }

    public String getId() {
        return id;
    }
}
