package com.gimnasio.gimnasiopelayo;

import com.gimnasio.gimnasiopelayo.presentacion.SistemaClientesFX;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GimnasiopelayoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(GimnasiopelayoApplication.class, args);
		Application.launch(SistemaClientesFX.class,args);
	}

}
