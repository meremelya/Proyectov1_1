package com.example.proyectov1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_peso_kg;
    EditText editText_altura_cm;
    EditText editText_edad;
    Button button;
    Button adelgazar;
    Button engordar;
    TextView resultado;
    TextView resultado2;
    RadioButton radioHombre;
    RadioButton radioMujer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaración variables
        editText_peso_kg = (EditText) findViewById(R.id.editText_peso_kg);
        editText_altura_cm = (EditText) findViewById(R.id.editText_altura_cm);
        editText_edad = (EditText) findViewById(R.id.editText_edad);
        button = (Button) findViewById(R.id.button);
        resultado = (TextView) findViewById(R.id.resultado);
        radioHombre = (RadioButton) findViewById(R.id.radioHombre);
        radioMujer = (RadioButton) findViewById(R.id.radioMujer);
        adelgazar = (Button) findViewById(R.id.adelgazar);
        engordar = (Button) findViewById(R.id.engordar);
        resultado2 = (TextView) findViewById(R.id.resultado2);

        Spinner combo = (Spinner) findViewById(R.id.spinner);
        String[] elementos = {"uno", "dos", "tres"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, elementos);
        combo.setAdapter(adapter);


        // Método listener asociado al botón calcular
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Recoge los datos introducidos en los String de EditText y los transforma
                en Double, variable count realiza la operación matematica
                variable resultado_count transforma el resultado de la operación en String,
                el cual es mostrado dentro del TextView
                 */
                Double count;
                Double count1;
                Double count2;
                Double countHombre;
                Double countMujer;
                String resultado_count;
                String adelgazar_count;

                String datosPeso = editText_peso_kg.getText().toString();
                Double peso = Double.parseDouble(datosPeso);
                String datosAltura = editText_altura_cm.getText().toString();
                Double altura = Double.parseDouble(datosAltura);
                String datosEdad = editText_edad.getText().toString();
                Double edad = Double.parseDouble(datosEdad);
                String selec=combo.getSelectedItem().toString();

                /*
                varios "if" que representan distintas selecciones dentro del spinner, con la posibilidad de 6 opciones difientes
                hombre+uno, hombre+dos, hombre+tres, mujer+uno, mujer+dos, mujer+tres.
                 */
                if(radioHombre.isChecked() && combo.getSelectedItem().equals("uno")) {
                    count = peso * 9.99 + altura * 6.25 + edad * 4.92;
                    countHombre = count + 5;
                    count1 = countHombre * 1.2;
                    resultado_count = String.valueOf(count1);
                    resultado.setText(resultado_count);
                }
                if(radioHombre.isChecked() && combo.getSelectedItem().equals("dos")) {
                    count = peso * 9.99 + altura * 6.25 + edad * 4.92;
                    countHombre = count + 5;
                    count1 = countHombre * 1.5;
                    resultado_count = String.valueOf(count1);
                    resultado.setText(resultado_count);
                }
                if(radioHombre.isChecked() && combo.getSelectedItem().equals("tres")) {
                    count = peso * 9.99 + altura * 6.25 + edad * 4.92;
                    countHombre = count + 5;
                    count1 = countHombre * 1.75;
                    resultado_count = String.valueOf(count1);
                    resultado.setText(resultado_count);
                }

                if(radioMujer.isChecked() && combo.getSelectedItem().equals("uno")){
                    count = peso * 9.99 + altura * 6.25 + edad * 4.92;
                    countMujer = count - 161;
                    count2 = countMujer * 1.2;
                    resultado_count = String.valueOf(count2);
                    resultado.setText(resultado_count);
                }
                if(radioMujer.isChecked() && combo.getSelectedItem().equals("dos")){
                    count = peso * 9.99 + altura * 6.25 + edad * 4.92;
                    countMujer = count - 161;
                    count2 = countMujer * 1.5;
                    resultado_count = String.valueOf(count2);
                    resultado.setText(resultado_count);
                }
                if(radioMujer.isChecked() && combo.getSelectedItem().equals("tres")){
                    count = peso * 9.99 + altura * 6.25 + edad * 4.92;
                    countMujer = count - 161;
                    count2 = countMujer * 1.75;
                    resultado_count = String.valueOf(count2);
                    resultado.setText(resultado_count);
                }
            }
        });

        // Boton adelgazar
        adelgazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoAdelgazar = resultado.getText().toString();
                Double countAd = Double.parseDouble(textoAdelgazar);
                Double resAd = countAd * 0.8;
                String textoresAd = String.valueOf(resAd);
                resultado2.setText(textoresAd);
            }
        });

        // Boton engordar
        engordar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoAdelgazar = resultado.getText().toString();
                Double countAd = Double.parseDouble(textoAdelgazar);
                Double resAd = countAd * 1.2;
                String textoresAd = String.valueOf(resAd);
                resultado2.setText(textoresAd);
            }
        });

        // RadioGroup
        radioHombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioHombre.isChecked()){
                    radioMujer.setChecked(false);
                }
            }
        });

        radioMujer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioMujer.isChecked()){
                    radioHombre.setChecked(false);
                }
            }
        });


    }

}