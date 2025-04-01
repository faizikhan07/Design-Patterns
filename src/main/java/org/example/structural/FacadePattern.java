package org.example.structural;

/**
 * -----------------------------------------------
 * FACADE PATTERN
 * -----------------------------------------------
 * Facade Pattern creates a high-level interface that simplifies the interactions with a complex subsystem.
 * Instead of client directly interacting with multiple components, the facade acts as a single entry point, encapsulating the complex logic and offering a unified way to interact
 * with the system.
 *
 * -----------------------------------------------
 * Real-World Analogy: A Home Theater System
 * -----------------------------------------------
 * Consider setting up a home theater system.
 * The system includes components like an
 * -> amplifier
 * -> DVD player
 * -> projector
 *
 * To watch a movie, you would:
 * -> Turn on the amplifier and set the volume.
 * -> Turn on the DVD player and start playing the movie.
 * -> Turn on the projector.
 *
 * This process can become tedious and error-prone, especially in complex setups. Now imagine a remote control that performs all these steps for you with a single "Watch Movie" button.
 * The remote control acts as the facade, hiding the complexities of interacting with each component individually.
 */

// Let's see an example of home theater working without facade design pattern:
    /*
class Amplifier {
    public void setVolume(int level) {

    }
}

class DVDPlayer {

    public void on() {
        System.out.println("DVD Player is on.");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is on.");
    }

    public void wideScreenMode() {
        System.out.println("Projector is in Widescreen mode.");
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();

        amp.setVolume(5);
        dvd.on();
        dvd.play("Inception");
        projector.on();
        projector.wideScreenMode();
    }
}
*/

/**
 * Now let's implement this example using facade design pattern to solve issues such as:
 *
 * Complexity: Each class (Amplifier, DVDPlayer, Projector) is manually instantiated and controlled, increasing the overall complexity of usage.
 * Tightly Coupled: The main class directly manages the interactions between different subsystems (e.g., DVDPlayer and Projector), leading to tight coupling and reduced flexibility.
 * Extensible: Adding new functionality or components (e.g., another device) requires changes in the Main class, making it less extensible.
 * Expose of business Logic: The main class explicitly implements the logic for coordinating devices, exposing details of how the system operates.
 *
 */

class Amplifier {
    public void setVolume(int level) {

    }
}

class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is on.");
    }
    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is on.");
    }

    public void wideScreenMode() {
        System.out.println("Projector is in widescren mode.");
    }
}

class HomeTheatreFacade {
    private Amplifier amp;
    private DVDPlayer dvd;
    private Projector projector;
    public HomeTheatreFacade(Amplifier amp, DVDPlayer dvd, Projector projector) {
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
        projector.on();
        projector.wideScreenMode();
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        HomeTheatreFacade homeTheatre = new HomeTheatreFacade(amp, dvd, projector);
        homeTheatre.watchMovie("Inception");
    }
}

/**
 * ADVANTAGES
 * 1. Reduce complexity: The client interacts with a simplified interface rather than multiple subsystem components.
 * 2. Loosely Coupled Code: The facade decouples the client from the subsystem, making it easier to modify or replace components.
 * 3. Improves Code Readability: Centralizing the logic in the facade improves the overall structure and readability of the code.
 * 4. Promotes Code Reusability: The facade encapsulates the logic, making it reusable for different clients.
 */