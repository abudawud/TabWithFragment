package project.envoss.com.calculatorbalok.uts.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import project.envoss.com.calculatorbalok.R;

public class KonversiRomFragment extends Fragment {
    private final String BASE = "IVXLCDM";

    private final int BASE_VAL [] =   {1, 5, 10, 50, 100, 500, 1000};
    private final int BASE_LIMIT [] = {3, 1, 3, 1, 3, 1, 3};

    private Button btConvert;
    private TextView txRomVal;
    private TextView txOutVal;
    public KonversiRomFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_konversi_rom, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btConvert = view.findViewById(R.id.convert);
        txRomVal = view.findViewById(R.id.rom_value);
        txOutVal = view.findViewById(R.id.text_num);

        btConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doConvert();
            }
        });
    }

    private void doConvert(){
        int BASE_ERR [] =   {0, 0, 0, 0, 0, 0, 0};
        Integer result = 0;
        int cerror = 0;
        int lastVal = 0;
        boolean error = false;

        String romStr = txRomVal.getText().toString().toUpperCase();

        txRomVal.setText(romStr);

        char romCh [] = romStr.toCharArray();

        int len = romCh.length - 1;

        for(int i = len; i >= 0; i--){
            int index = BASE.indexOf(romCh[i]);
            int val = BASE_VAL[index];

            BASE_ERR[index]++;

            if(BASE_ERR[index] > BASE_LIMIT[index]){
                result = -1;
                break;
            }

            if((val < lastVal) & lastVal != 0)
                result -= val;
            else
                result += val;

            lastVal = val;
        }

        if(result == -1) {
            txOutVal.setText("ERROR :(");
        }else{
            txOutVal.setText(result.toString());
        }
    }
}
