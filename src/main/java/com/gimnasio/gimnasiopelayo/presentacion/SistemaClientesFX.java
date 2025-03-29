package com.gimnasio.gimnasiopelayo.presentacion;

import com.gimnasio.gimnasiopelayo.GimnasiopelayoApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class SistemaClientesFX extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        this.applicationContext = new SpringApplicationBuilder(GimnasiopelayoApplication.class).run();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(GimnasiopelayoApplication.class.getResource("/templates/inicio.fxml"));
        loader.setControllerFactory((applicationContext::getBean));
        Scene escena = new Scene(loader.load());
        stage.setTitle("Gimnasio Pelayo");
        stage.setResizable(false);
        stage.setScene(escena);
        stage.show();
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }
}