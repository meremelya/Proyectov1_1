package com.example.proyectov1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
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
    Button buttonInfo;
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
        buttonInfo = (Button) findViewById(R.id.buttonInfo);

        Spinner combo = (Spinner) findViewById(R.id.spinner);
        String[] elementos = {"Bajo", "Medio", "Alto"};
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
                Double count = 0.0;
                Double countNivelActividad = 0.0;
                Double countHombre = 0.0;
                Double countMujer = 0.0;
                String countResultado = null;
                int countResultadoNumEntero = 0;

                Double peso = 0.0;
                Double altura = 0.0;
                Double edad = 0.0;
                String datosPeso = null;
                String datosAltura = null;
                String datosEdad = null;

                 datosPeso = editText_peso_kg.getText().toString();
                 peso = Double.parseDouble(datosPeso);
                 datosAltura = editText_altura_cm.getText().toString();
                 altura = Double.parseDouble(datosAltura);
                 datosEdad = editText_edad.getText().toString();
                 edad = Double.parseDouble(datosEdad);
                String selec=combo.getSelectedItem().toString();

                /*
                varios "if" que representan distintas selecciones dentro del spinner, con la posibilidad de 6 opciones difientes
                hombre+uno, hombre+dos, hombre+tres, mujer+uno, mujer+dos, mujer+tres.
                 */

                //if(datosPeso.matches("")){
                //    Context context = getApplicationContext();
                //    CharSequence text = "errorrr";
               //     int duration = Toast.LENGTH_LONG;
                //    Toast.makeText(context, text, duration).show();
                //}

               // if (TextUtils.isEmpty(editText_peso_kg.getText().toString())){
                //    Toast.makeText(MainActivity.this, "Empty field not allowed!",
               //             Toast.LENGTH_SHORT).show();
              //  }

                if(radioHombre.isChecked() && combo.getSelectedItem().equals("Bajo")) {
                    count = peso * 9.99 + altura * 6.25 + edad * 4.92;
                    countHombre = count + 5;
                    countNivelActividad = countHombre * 1.2;
                    countResultadoNumEntero = (int)Math.round(countNivelActividad);
                    countResultado = String.valueOf(countResultadoNumEntero);
                    resultado.setText(countResultado);
                }
                if(radioHombre.isChecked() && combo.getSelectedItem().equals("Medio")) {
                    count = peso * 9.99 + altura * 6.25 + edad * 4.92;
                    countHombre = count + 5;
                    countNivelActividad = countHombre * 1.5;
                    countResultadoNumEntero = (int)Math.round(countNivelActividad);
                    countResultado = String.valueOf(countResultadoNumEntero);
                    resultado.setText(countResultado);
                }
                if(radioHombre.isChecked() && combo.getSelectedItem().equals("Alto")) {
                    count = peso * 9.99 + altura * 6.25 + edad * 4.92;
                    countHombre = count + 5;
                    countNivelActividad = countHombre * 1.75;
                    countResultadoNumEntero = (int)Math.round(countNivelActividad);
                    countResultado = String.valueOf(countResultadoNumEntero);
                    resultado.setText(countResultado);
                }

                if(radioMujer.isChecked() && combo.getSelectedItem().equals("Bajo")){
                    count = peso * 9.99 + altura * 6.25 + edad * 4.92;
                    countMujer = count - 161;
                    countNivelActividad = countMujer * 1.2;
                    countResultadoNumEntero = (int)Math.round(countNivelActividad);
                    countResultado = String.valueOf(countResultadoNumEntero);
                    resultado.setText(countResultado);
                }
                if(radioMujer.isChecked() && combo.getSelectedItem().equals("Medio")){
                    count = peso * 9.99 + altura * 6.25 + edad * 4.92;
                    countMujer = count - 161;
                    countNivelActividad = countMujer * 1.5;
                    countResultadoNumEntero = (int)Math.round(countNivelActividad);
                    countResultado = String.valueOf(countResultadoNumEntero);
                    resultado.setText(countResultado);
                }
                if(radioMujer.isChecked() && combo.getSelectedItem().equals("Alto")){
                    count = peso * 9.99 + altura * 6.25 + edad * 4.92;
                    countMujer = count - 161;
                    countNivelActividad = countMujer * 1.75;
                    countResultadoNumEntero = (int)Math.round(countNivelActividad);
                    countResultado = String.valueOf(countResultadoNumEntero);
                    resultado.setText(countResultado);
                }
            }
        });

        // Boton adelgazar
        adelgazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String textoAdEn = resultado.getText().toString();
                    Double countAdEn = Double.parseDouble(textoAdEn);
                    Double countResultadoAdEN = countAdEn * 0.8;
                    int countResultadoAdEnNumEntero = (int) Math.round(countResultadoAdEN);
                    String textoResultadoAdEn = String.valueOf(countResultadoAdEnNumEntero);
                    resultado2.setText(textoResultadoAdEn + " Kcl");
            }
        });

        // Boton engordar
        engordar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String textoAdEn = resultado.getText().toString();
                    Double countAdEn = Double.parseDouble(textoAdEn);
                    Double countResultadoAdEN = countAdEn * 1.2;
                    int countResultadoAdEnNumEntero = (int) Math.round(countResultadoAdEN);
                    String textoResultadoAdEn = String.valueOf(countResultadoAdEnNumEntero);
                    resultado2.setText(textoResultadoAdEn + " Kcl");
                }
        });

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = getApplicationContext();
                CharSequence text = "Nivel de actividad: \nBAJO - estilo de vida sedentario \nMEDIO - hasta 5 entrenamientos semanales \nALTO - alto esfuerzo fisico diario";
                int duration = Toast.LENGTH_LONG;
                Toast.makeText(context, text, duration).show();
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