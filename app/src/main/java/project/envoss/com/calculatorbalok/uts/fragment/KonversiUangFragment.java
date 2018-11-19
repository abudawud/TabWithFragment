package project.envoss.com.calculatorbalok.uts.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import project.envoss.com.calculatorbalok.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KonversiUangFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {
    //USD, EUR, GBP, INR, AUD (Australia)
    private final Double KURS_VAL [] = {14613.0, 16687.42, 18753.68, 202.961, 10716.21};
    private final String KURS_NAME [] = {"USD (US Dollar", "EUR (Euro)", "GBP (British Pound)", "INR (India Rupee)", "AUD (Australian Dollar"};

    private EditText edForeign;
    private RadioGroup rgKurs;
    private RadioButton rbUsd, rbEur, rbGbp, rbInr, rbAud;
    private TextView tvKVal, tvValres;

    public KonversiUangFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_konversi_uang, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edForeign = view.findViewById(R.id.foreign);
        rgKurs = view.findViewById(R.id.kurs_group);
        rbUsd = view.findViewById(R.id.kusd);
        rbEur = view.findViewById(R.id.keur);
        rbGbp = view.findViewById(R.id.kgbp);
        rbInr = view.findViewById(R.id.kinr);
        rbAud = view.findViewById(R.id.kaud);
        tvKVal = view.findViewById(R.id.kurs_val);
        tvValres = view.findViewById(R.id.val_res);

        rbUsd.setText(KURS_NAME[0]);
        rbEur.setText(KURS_NAME[1]);
        rbGbp.setText(KURS_NAME[2]);
        rbInr.setText(KURS_NAME[3]);
        rbAud.setText(KURS_NAME[4]);

        rgKurs.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int id = radioGroup.getCheckedRadioButtonId();

        Double kurs = 0.0;
        switch (id){
            case R.id.kusd:{
                kurs = KURS_VAL[0];
                break;
            }
            case R.id.keur:{
                kurs = KURS_VAL[1];
                break;
            }
            case R.id.kgbp:{
                kurs = KURS_VAL[2];
                break;
            }
            case R.id.kinr:{
                kurs = KURS_VAL[3];
                break;
            }
            case R.id.kaud:{
                kurs = KURS_VAL[4];
                break;
            }
        }

        Double amount = Double.valueOf(edForeign.getText().toString());
        Double result = amount * kurs;

        tvKVal.setText(NumberFormat.getCurrencyInstance(new Locale("id", "ID"))
                .format(kurs));
        tvValres.setText(NumberFormat.getCurrencyInstance(new Locale("id", "ID"))
                .format(result));

    }
}
