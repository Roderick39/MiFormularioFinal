package aplicacion.android.rbaez.miformulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private View boton;
    private View boton1;
    private View boton2;
    ;
    private String msj;
    private String edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        msj = getIntent().getStringExtra("mensaje");




        boton = (Button) findViewById(R.id.button3);
        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, msj, Toast.LENGTH_LONG).show();
                boton.setVisibility(View.INVISIBLE);

            }


        });


        boton1 = (Button) findViewById(R.id.buttonAtras);
        boton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        boton2 = (Button) findViewById(R.id.button4);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, msj);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                //boton2.setVisibility(View.INVISIBLE);

            }
        });
    }
}
