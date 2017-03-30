package com.grupomdc.ejercicio1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Rectangulo_Perimetro extends AppCompatActivity {

    RadioGroup rgOperaciones;
    TextView tvBase;
    TextView tvAltura;
    TextView tvResultado;
    EditText edBase;
    EditText edAltura;
    Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo__perimetro);

        tvBase = (TextView) findViewById(R.id.tvBase);
        tvAltura = (TextView) findViewById(R.id.tvAltura);
        tvResultado = (TextView) findViewById(R.id.tvResultado);
        edBase = (EditText) findViewById(R.id.edBase);
        edAltura = (EditText) findViewById(R.id.edAltura);
        btCalcular = (Button) findViewById(R.id.btCalcular);
        rgOperaciones = (RadioGroup) findViewById(R.id.rgOperaciones);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int operacion = rgOperaciones.getCheckedRadioButtonId();
                double base, altura, perimetro, area;
                switch (operacion)
                {
                    case R.id.rdPerimetro:
                        try {
                            base = Double.parseDouble(edBase.getText().toString());
                            altura = Double.parseDouble(edAltura.getText().toString());
                            perimetro = 2 * base + 2 * altura;
                            tvResultado.setText(getString(R.string.texto_perimetro_resultado) + perimetro);
                        }
                        catch (Exception e) {
                            tvResultado.setText(getString(R.string.texto_error));
                        }
                        break;
                    case R.id.rdArea:
                        try {
                            base = Double.parseDouble(edBase.getText().toString());
                            altura = Double.parseDouble(edAltura.getText().toString());
                            area = base * altura;
                            tvResultado.setText(getString(R.string.texto_area_resultado) + area);
                        }
                        catch (Exception e) {
                            tvResultado.setText(getString(R.string.texto_error));
                        }
                        break;
                    default:
                        tvResultado.setText(getString(R.string.texto_sin_opcion));
                }
            }
        });

    }
}
