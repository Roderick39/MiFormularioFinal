package aplicacion.android.rbaez.miformulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private String nombre;
    private RadioGroup grupo;
    private RadioButton selec;
    private View boton;
    private View boton1;
    public String edad;
    TextView vermsje;
    SeekBar barra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        grupo = (RadioGroup) findViewById(R.id.radioGroup);
        nombre = getIntent().getStringExtra("name");



        boton = (Button) findViewById(R.id.button2);
        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int selectedId = grupo.getCheckedRadioButtonId();
                selec = (RadioButton) findViewById(selectedId);

                if(selec.getText().equals("Saludo")){
                    String Saludo = "Hola "+nombre+" ¿Cómo vas con esos "+ edad+"años?";
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("mensaje", Saludo);
                    startActivity(intent);
                }else{
                    int edadentero = Integer.parseInt(edad);
                    edadentero = edadentero +1;
                    String edadnumst = String.valueOf(edadentero);
                    String Despedida = "Espero verte pronto, antes que cumplas "+ edadnumst +"años";
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("mensaje", Despedida);
                    startActivity(intent);
                }

            }
        });

        boton1 = (Button) findViewById(R.id.buttonAtras);
        boton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });




        barra = (SeekBar) findViewById(R.id.Edad);
        vermsje = (TextView) findViewById(R.id.textView2);

        vermsje.setText(" años");



        barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int desplazar, boolean fromUser) {

                vermsje.setText(desplazar + " años");
                edad  = String.valueOf(desplazar);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


}
