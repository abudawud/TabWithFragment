package project.envoss.com.calculatorbalok.uts.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import project.envoss.com.calculatorbalok.R;
import project.envoss.com.calculatorbalok.models.DataMahasiswa;
import project.envoss.com.calculatorbalok.uts.RegisterActivity;
import project.envoss.com.calculatorbalok.uts.ToolsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends Fragment {

    private DataMahasiswa dataMahasiswa;


    public ProfilFragment() {
        // Required empty public constructor
    }


    public static ProfilFragment newInstance(DataMahasiswa data){
        ProfilFragment fragment = new ProfilFragment();
        Bundle bundle = new Bundle();

        bundle.putParcelable(RegisterActivity.EXTRA_MAHASISWA, data);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            dataMahasiswa = getArguments().getParcelable(RegisterActivity.EXTRA_MAHASISWA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txNama = view.findViewById(R.id.nama);
        TextView txTlahir = view.findViewById(R.id.tanggal_lahir);
        TextView txIPK = view.findViewById(R.id.ipk);
        TextView txUsia = view.findViewById(R.id.usia);

        txNama.setText(dataMahasiswa.getNama());
        txTlahir.setText(dataMahasiswa.gettLahir());
        txIPK.setText(dataMahasiswa.getIpk().toString());
        txUsia.setText(dataMahasiswa.getUsia().toString());
    }
}
