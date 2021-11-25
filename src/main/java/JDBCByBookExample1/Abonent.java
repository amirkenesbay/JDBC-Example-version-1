package JDBCByBookExample1;

public class Abonent extends Entity{
    private long phone;
    private String lastname;

    public Abonent() {
    }

    public Abonent(int id, long phone, String lastname) {
        super(id);
        this.phone = phone;
        this.lastname = lastname;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Abonent {" +
                "id = " + getId() +
                ", phone=" + phone +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
