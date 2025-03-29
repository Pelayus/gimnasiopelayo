package com.gimnasio.gimnasiopelayo.controlador;

import com.gimnasio.gimnasiopelayo.modelo.Cliente;
import com.gimnasio.gimnasiopelayo.servicios.ServicioClienteImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Modality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.time.LocalDate;

@Component
public class AltaClienteController {
    @Autowired
    private ServicioClienteImpl clienteServicio;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField apellidosTextField;

    @FXML
    private TextField dniTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private RadioButton clasicoRadioButton;

    @FXML
    private RadioButton maquinaRadioButton;

    @FXML
    private RadioButton winsorRadioButton;

    @FXML
    private Spinner<Integer> sesionesSpinner;

    @FXML
    private DatePicker altaDatePicker;

    @FXML
    private Slider pesoSlider;

    @FXML
    private Spinner<Integer> alturaSpinner;

    @FXML
    private DatePicker nacimientoDatePicker;

    @FXML
    private final ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        //APLICO VALORES A LOS SPINNER PARA QUE SE PUEDAN USAR, SINO NO SON INTERACTUABLES AL EJECUTAR EL PROGRAMA
        SpinnerValueFactory<Integer> sesionesValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        sesionesSpinner.setValueFactory(sesionesValueFactory);
        sesionesSpinner.setEditable(true);

        SpinnerValueFactory<Integer> alturaValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 300);
        alturaSpinner.setValueFactory(alturaValueFactory);
        alturaSpinner.setEditable(true);

        //SLIDER DE PESO CON INTERVALO DE 50 A 120
        pesoSlider.setMin(50);
        pesoSlider.setMax(120);
        pesoSlider.setValue(5);
        pesoSlider.setMajorTickUnit(1);
        pesoSlider.setMinorTickCount(0);
        pesoSlider.setSnapToTicks(true);

        //MUESTRO LAS ETIQUETAS DEL SLIDER PARA QUE SEAN VISIBLES
        pesoSlider.setShowTickLabels(true);
    }


    @FXML
    protected void btnalta(ActionEvent event) throws IOException {
        listaClientes.clear();
        listaClientes.addAll(clienteServicio.listarClientes());

        // Obtener los datos del formulario
        String nombre = nombreTextField.getText();
        String apellidos = apellidosTextField.getText();
        String dni = dniTextField.getText();
        String email = emailTextField.getText();

        if (nombre.isEmpty() && apellidos.isEmpty() && dni.isEmpty() && email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Tienes campos sin rellenar.");
            alert.showAndWait();
            return;
        } else if (nombre.isEmpty() && apellidos.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Tienes campos sin rellenar. No has introducido el campo del nombre ni de los apellidos.");
            alert.showAndWait();
            return;
        } else if (nombre.isEmpty() && dni.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Tienes campos sin rellenar. No has introducido el campo del nombre ni del DNI.");
            alert.showAndWait();
            return;
        } else if (nombre.isEmpty() && email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Tienes campos sin rellenar. No has introducido el campo del nombre ni del email.");
            alert.showAndWait();
            return;
        } else if (apellidos.isEmpty() && dni.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Tienes campos sin rellenar. No has introducido el campo de los apellidos ni del DNI.");
            alert.showAndWait();
            return;
        } else if (apellidos.isEmpty() && email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Tienes campos sin rellenar. No has introducido el campo de los apellidos ni del email.");
            alert.showAndWait();
            return;
        } else if (dni.isEmpty() && email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Tienes campos sin rellenar. No has introducido el campo del DNI ni del email.");
            alert.showAndWait();
            return;
        } else if (nombre.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No has introducido el campo del nombre.");
            alert.showAndWait();
            return;
        } else if (apellidos.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No has introducido el campo de los apellidos.");
            alert.showAndWait();
            return;
        } else if (dni.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No has introducido el campo del DNI.");
            alert.showAndWait();
            return;
        }else if (email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No has introducido el email.");
            alert.showAndWait();
            return;
        }

        // Validación del formato del DNI
        if (!dni.matches("\\d{8}[a-zA-Z]")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("El DNI debe tener 8 números seguidos de una letra");
            alert.showAndWait();
            return;
        }

        // Validación del formato del email
        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("El email introducido no es válido.");
            alert.showAndWait();
            return;
        }


        //AGRUPO LOS RADIOBUTTONS  PARA QUE SOLO PUEDA ELEGIRSE UNA OPCIÓN
        ToggleGroup tipoToggleGroup = new ToggleGroup();
        clasicoRadioButton.setToggleGroup(tipoToggleGroup);
        maquinaRadioButton.setToggleGroup(tipoToggleGroup);
        winsorRadioButton.setToggleGroup(tipoToggleGroup);
        RadioButton selectedRadioButton = (RadioButton) tipoToggleGroup.getSelectedToggle();
        String tipo = selectedRadioButton != null ? selectedRadioButton.getText() : "";

        if (tipo.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Debes seleccionar un tipo.");
            alert.showAndWait();
            return;
        }

        int sesiones = sesionesSpinner.getValue();

        if (sesiones <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("El número de sesiones debe ser mayor que cero.");
            alert.showAndWait();
            return;
        }

        int altura = alturaSpinner.getValue();

        if (altura <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("La altura debe ser mayor que cero.");
            alert.showAndWait();
            return;
        }

        LocalDate fechaAlta = altaDatePicker.getValue();
        LocalDate fechaNacimiento = nacimientoDatePicker.getValue();
        LocalDate fechaActual = LocalDate.now();

        if (fechaAlta == null || fechaNacimiento == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Debes seleccionar fechas válidas.");
            alert.showAndWait();
            return;
        } else if (fechaAlta.isAfter(fechaActual) || fechaNacimiento.isAfter(fechaActual)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Debes seleccionar fechas válidas y anteriores a la fecha actual.");
            alert.showAndWait();
            return;
        }

        pesoSlider.setMin(50);
        pesoSlider.setMax(120);
        pesoSlider.setValue(5);
        pesoSlider.setMajorTickUnit(1);
        pesoSlider.setMinorTickCount(0);
        pesoSlider.setSnapToTicks(true);
        pesoSlider.setShowTickLabels(true);
        double peso = pesoSlider.getValue();

        if (peso <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("El peso debe ser mayor que cero.");
            alert.showAndWait();
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmación");
        confirmacion.setHeaderText(null);
        confirmacion.setContentText("¿Estás seguro de dar de alta a este cliente?");

        ButtonType resultado = confirmacion.showAndWait().orElse(ButtonType.CANCEL);

        if (resultado == ButtonType.OK) {
            Cliente cliente = new Cliente(dni, nombre, apellidos, tipo, sesiones, fechaAlta, fechaNacimiento, peso, altura,email);
            clienteServicio.guardarCliente(cliente);
            mostrarMensaje("Informacion", "Cliente añadido correctamente");
            btnreset();
        }
    }

    private void mostrarMensaje(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    private void btnreset() {
        nombreTextField.clear();
        apellidosTextField.clear();
        dniTextField.clear();
        emailTextField.clear();
        clasicoRadioButton.setSelected(false);
        maquinaRadioButton.setSelected(false);
        winsorRadioButton.setSelected(false);
        sesionesSpinner.getValueFactory().setValue(0);
        altaDatePicker.setValue(null);
        pesoSlider.setValue(0);
        alturaSpinner.getValueFactory().setValue(0);
        nacimientoDatePicker.setValue(null);
    }
}
