package universidad.ui.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class DashboardController {

    @FXML private Pane contentArea;

    @FXML private void showStudents()   { load("students"); }
    @FXML private void showTeachers()   { load("teachers"); }
    @FXML private void showCourses()    { load("courses"); }
    @FXML private void showEnrollment() { load("enrollment"); }
    @FXML private void showGrades()     { load("grades"); }

    private void load(String name) {
        try {
            Node view = FXMLLoader.load(getClass().getResource("/ui/" + name + ".fxml"));
            contentArea.getChildren().setAll(view);
        } catch (IOException | NullPointerException e) {
            System.out.println("No se pudo cargar la pantalla: " + name);
            e.printStackTrace();
        }
    }
}