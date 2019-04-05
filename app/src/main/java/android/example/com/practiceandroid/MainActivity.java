package android.example.com.practiceandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
    }

    /**
     * This method is called when user hold on in Acerca de button.
     * @param view
     */
    public void getMessage(View view){
        Intent intent = new Intent(this, AcercaDeActivity.class);
        startActivity(intent);
    }

    /**
     * This method is called when user hold on in close button.
     */
    public void close(View view){
        finish();
    }

    /**
     * This method is called when user press up in Comunicar.
     * @param view
     */
    public void callActivity(View view){
        Intent intent = new Intent(this, ComunicarActivity.class);
        intent.putExtra("nombre","Daniel");
        intent.putExtra("apellido","Villamarin");
        startActivityForResult(intent, 1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
       if(requestCode==1234 && resultCode==RESULT_OK){
           TextView resp = (TextView) findViewById(R.id.resp);
           resp.setText("Okay!");
       }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true; //TRUE -> el menu ya esta visible//
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.action_setting){
            return true;
        }
        if(id == R.id.action_acerca){
            getMessage(null);
            return true;
        }
        if(id == R.id.menu_buscar){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
