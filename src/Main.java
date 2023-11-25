import menu.Menu;
import model.Model;
import controller.Controller;
import view.View;

public class Main {
    public static void main(String[] args) {
        Controller presenter = new Controller(new View(), new Model(), new Menu());
        presenter.start();

    }
}