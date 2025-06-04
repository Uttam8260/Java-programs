public class FacadeDesignPattern {
    
    static class Projector {
        public void on() {
            System.out.println("Projector is ON");
        }

        public void off() {
            System.out.println("Projector is OFF");
        }
    }

    static class SoundSystem {
        public void on() {
            System.out.println("Sound system is ON");
        }

        public void off() {
            System.out.println("Sound system is OFF");
        }

        public void setVolume(int level) {
            System.out.println("Volume set to " + level);
        }
    }

    static class Lights {
        public void dim() {
            System.out.println("Lights are dimmed");
        }

        public void on() {
            System.out.println("Lights are ON");
        }
    }


    static class DVDPlayer {
        public void play(String movie) {
            System.out.println("Playing movie: " + movie);
        }

        public void stop() {
            System.out.println("Stopped movie");
        }
    }

    // Facade
    static class HomeTheaterFacade {
        private final Projector projector;
        private final SoundSystem soundSystem;
        private final Lights lights;
        private final DVDPlayer dvdPlayer;

        public HomeTheaterFacade(Projector projector, SoundSystem soundSystem, Lights lights, DVDPlayer dvdPlayer) {
            this.projector = projector;
            this.soundSystem = soundSystem;
            this.lights = lights;
            this.dvdPlayer = dvdPlayer;
        }

        public void startMovie(String movie) {
            System.out.println("Starting movie setup...");
            lights.dim();
            projector.on();
            soundSystem.on();
            soundSystem.setVolume(10);
            dvdPlayer.play(movie);
            System.out.println("Enjoy your movie!\n");
        }

        public void endMovie() {
            System.out.println("Shutting down movie setup...");
            dvdPlayer.stop();
            soundSystem.off();
            projector.off();
            lights.on();
        }
    }

    public static void main(String[] args) {
        // Create subsystem instances
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();
        Lights lights = new Lights();
        DVDPlayer dvdPlayer = new DVDPlayer();

        // Create the facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(projector, soundSystem, lights, dvdPlayer);

        // Use the facade to start and stop movie experience
        homeTheater.startMovie("Inception");
        homeTheater.endMovie();
    }

}