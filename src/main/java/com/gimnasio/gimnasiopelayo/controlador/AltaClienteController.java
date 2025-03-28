package com.gimnasio.gimnasiopelayo.controlador;

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
    private void btnalta(ActionEvent event) throws IOException {
        String nombre = nombreTextField.getText();
        String apellidos = apellidosTextField.getText();
        String dni = dniTextField.getText();
        String email = emailTextField.getText();
        boolean clasico = clasicoRadioButton.isSelected();
        boolean maquina = maquinaRadioButton.isSelected();
        boolean winsor = winsorRadioButton.isSelected();
        int sesiones = sesionesSpinner.getValue();
        LocalDate alta = altaDatePicker.getValue();
        double peso = pesoSlider.getValue();
        int altura = alturaSpinner.getValue();
        LocalDate nacimiento = nacimientoDatePicker.getValue();
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
