package android.example.com.practiceandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ComunicarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunicar);

        Bundle extra = getIntent().getExtras();
        TextView nombre = (TextView)findViewById(R.id.nombre);
        TextView apellido = (TextView)findViewById(R.id.apellido);

        nombre.setText(extra.getString("nombre"));
        apellido.setText(extra.getString("apellido"));
    }

    /**
     * This method is called when user press up in close button.
     * @param view
     */
    public void close(View view){
        Intent intent = new Intent();
        intent.putExtra("resultado","valor");
        setResult(RESULT_OK, intent);
        finish();
    }
}
