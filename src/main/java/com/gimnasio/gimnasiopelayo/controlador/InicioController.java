package com.gimnasio.gimnasiopelayo.controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class InicioController {
    @Autowired
    private ConfigurableApplicationContext applicationContext;
    @FXML
    private AnchorPane PanelContenido;
    @FXML
    private Button btnInicioSesion;
    @FXML
    private Button btnAltaCliente;

    @FXML
    public void alta(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/templates/altacliente.fxml"));
        loader.setControllerFactory(applicationContext::getBean);
        AnchorPane altaPane = loader.load();
        PanelContenido.getChildren().setAll(altaPane);
    }

    @FXML
    public void iniciarsesion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/templates/iniciosesion.fxml"));
        loader.setControllerFactory(applicationContext::getBean);
        AnchorPane iniciosesionPane = loader.load();
        PanelContenido.getChildren().setAll(iniciosesionPane);
    }
}

