package project.envoss.com.calculatorbalok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import project.envoss.com.calculatorbalok.models.Mahasiswa;

public class HasilActivity extends AppCompatActivity {
    public static final String EXT_DATA = "HELLO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        Mahasiswa hasil = getIntent().getParcelableExtra(EXT_DATA);
        TextView txtHasil = findViewById(R.id.hasil);

        txtHasil.setText(hasil.getNama() + " " + hasil.getNim() + " " + hasil.getUmur());
    }
}
