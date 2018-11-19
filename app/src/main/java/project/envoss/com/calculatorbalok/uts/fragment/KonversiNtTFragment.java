package project.envoss.com.calculatorbalok.uts.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import project.envoss.com.calculatorbalok.R;

public class KonversiNtTFragment extends Fragment {
    private TextView txOut;
    private EditText edVal;
    private Button btDoit;

    //Tingkat yang selalu tetap tiap 3 digit
    private final String NUM_POWER_1[] = {
            "Nol", "Puluh", "Ratus"
    };

    //Tingkat yang selalu berubah tiap kelipatan 3
    private final String NUM_POWER_2[] = {
            "Nol", "Ribu", "Juta", "Milyar", "Triliun", "Tera"
    };

    //Nilai terbilang setiap angka berdasarkan index
    private final String NUM_TEXT [] = {
            "Nol", "Se", "Dua", "Tiga", "Empat", "Lima",
            "Enam", "Tujuh", "Delapan", "Sembilan"
    };

    public KonversiNtTFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_konversi_nt_t, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txOut = view.findViewById(R.id.text_num);
        edVal = view.findViewById(R.id.num_value);
        btDoit = view.findViewById(R.id.convert);

        btDoit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convert();
            }
        });
    }

    private boolean isNum(char cs []){
        for(char item : cs){
            if((item < '0') || (item > '9'))
                return false;
        }

        return true;
    }

    private void convert(){
        char numText [] = edVal.getText().toString().toCharArray();
        int len = numText.length;
        int power1 = 1;
        int power2 = 0;
        int i;
        StringBuilder textRes = new StringBuilder();

        if( (len == 0) || (!isNum(numText)) ) {
            txOut.setText("Error :(");
            return;
        }

        for(i = (len - 1); i > 0; i--){

            //Jangan Tampilkan Nol
            if(numText[i] != '0')
                textRes.insert(0, NUM_TEXT[(numText[i] - 48)] + " ");

            //Tampilkan nilai angka jika angka depannya tidak 0
            if ((power1 != 0) && (numText[i-1] != '0')) {
                textRes.insert(0, NUM_POWER_1[power1] + " ");
            }

            //Tampilkan power ke dua hanya ketika awal power1 dan power2 tidak di permulaan
            if (power2 != 0 && power1 == 0) {
                textRes.insert(0, NUM_POWER_2[power2] + " ");
            }

            if(++power1 > 2){
                power1 = 0;
                power2++;
            }
        }

        textRes.append(" Rupiah");
        textRes.insert(0, NUM_TEXT[(numText[i] - 48)] + " ");
        txOut.setText(textRes.toString());
    }
}
