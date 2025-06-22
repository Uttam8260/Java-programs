public class BuilderDesignPattern {

    
    static class UserProfile {
        // Required fields
        private final String name;
        private final String email;

        // Optional fields
        private final String phone;
        private final String address;
        private final String profilePic;

        // Private constructor
        private UserProfile(Builder builder) {
            this.name = builder.name;
            this.email = builder.email;
            this.phone = builder.phone;
            this.address = builder.address;
            this.profilePic = builder.profilePic;
        }

        // Show the profile
        public void display() {
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Phone: " + (phone != null ? phone : "Not set"));
            System.out.println("Address: " + (address != null ? address : "Not set"));
            System.out.println("Profile Pic: " + (profilePic != null ? profilePic : "Not set"));
        }

        // Builder Class
        static class Builder {
            private final String name;
            private final String email;

            private String phone;
            private String address;
            private String profilePic;

            public Builder(String name, String email) {
                this.name = name;
                this.email = email;
            }

            public Builder setPhone(String phone) {
                this.phone = phone;
                return this;
            }

            public Builder setAddress(String address) {
                this.address = address;
                return this;
            }

            public Builder setProfilePic(String profilePic) {
                this.profilePic = profilePic;
                return this;
            }

            public UserProfile build() {
                return new UserProfile(this);
            }
        }
    }

    // Main Method (Client Code)
    public static void main(String[] args) {
        UserProfile profile1 = new UserProfile.Builder("Uttam", "uttam@example.com")
                .setPhone("1234567890")
                .setAddress("Bhubaneswar, Odisha")
                .setProfilePic("uttam.jpg")
                .build();

        UserProfile profile2 = new UserProfile.Builder("John Doe", "john@example.com")
                .build();

        UserProfile profile3 =new UserProfile.Builder("Jane smith","jane@gmail.com").build();
        System.out.println("---- Profile 1 ----");
        profile1.display();

        System.out.println("\n---- Profile 2 ----");
        profile2.display();

        System.out.println("\n---- Profile 3 ----");
        profile3.display();
    }
    
}
