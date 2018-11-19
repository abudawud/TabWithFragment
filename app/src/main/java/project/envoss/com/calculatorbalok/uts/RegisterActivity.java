package project.envoss.com.calculatorbalok.uts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import project.envoss.com.calculatorbalok.R;
import project.envoss.com.calculatorbalok.models.DataMahasiswa;

public class RegisterActivity extends AppCompatActivity {
    public static final String EXTRA_MAHASISWA = "EX_MHS";
    private TextView txIPK;
    private TextView txNama;
    private TextView txUmur;
    private TextView txTlahir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txIPK = findViewById(R.id.ipk);
        txNama = findViewById(R.id.nama);
        txUmur = findViewById(R.id.usia);
        txTlahir = findViewById(R.id.tanggal_lahir);

        findViewById(R.id.submit_r).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataMahasiswa dataMahasiswa = new DataMahasiswa();
                String nama = txNama.getText().toString();
                String tlahir = txTlahir.getText().toString();
                String ipk = txIPK.getText().toString();
                String umur = txUmur.getText().toString();

                dataMahasiswa.setNama(nama);
                dataMahasiswa.settLahir(tlahir);
                dataMahasiswa.setIpk(Double.valueOf(ipk));
                dataMahasiswa.setUsia(Integer.valueOf(umur));

                Intent intent = new Intent(RegisterActivity.this, ToolsActivity.class);
                intent.putExtra(EXTRA_MAHASISWA, dataMahasiswa);
                startActivity(intent);
            }
        });
    }
}
