class MovieBookingProfile {

    private String name;
    private boolean confirmed;
    private String otp;

    // No-argument constructor
    public MovieBookingProfile() {
        this.confirmed = false;
    }

    // Constructor chaining
    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    // Getter for name
    String getName() {
        return name;
    }

    // Setter for name
    void setName(String name) {
        this.name = name;
    }

    // Getter for confirmed
    boolean isConfirmed() {
        return confirmed;
    }

    // Setter for confirmed
    void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    // Write-only OTP property
    void setOtp(String otp) {
        this.otp = otp;
    }
}

public class M4_MovieBookingProfile {

    public static void main(String[] args) {

        MovieBookingProfile profile =
            new MovieBookingProfile("Rahul Dev");

        System.out.println(
            profile.getName()
        );

        profile.setConfirmed(true);

        System.out.println(
            profile.isConfirmed()
        );

        profile.setOtp("4471");
    }
}