package project.envoss.com.calculatorbalok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import project.envoss.com.calculatorbalok.models.Mahasiswa;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class LingkaranActivity extends AppCompatActivity {
    private AppCompatEditText etJari;
    private Button btnDo;
    private TextView txHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);

        etJari = findViewById(R.id.jari);
        btnDo = findViewById(R.id.operate);
        txHasil = findViewById(R.id.hasil);

        btnDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doit();
            }
        });
    }

    private void doit(){
        Integer jari = Integer.valueOf(etJari.getText().toString());

        Double luas = PI * pow(jari, 2);
        String text = String.format("%.3f", luas);
        txHasil.setText(text);

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNama("Hello");
        mahasiswa.setNim("0XFF");
        mahasiswa.setUmur(10);

        Intent intentHasil = new Intent(this, HasilActivity.class);
        intentHasil.putExtra(HasilActivity.EXT_DATA, mahasiswa);
        startActivity(intentHasil);
    }
}
