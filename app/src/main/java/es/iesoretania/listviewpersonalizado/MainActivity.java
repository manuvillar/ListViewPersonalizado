package es.iesoretania.listviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import es.iesoretania.listviewpersonalizado.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ActivityMainBinding binding;
    List<Modulo> milistamodulos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        milistamodulos = new ArrayList<>();
        milistamodulos.add(new Modulo("ASIR"));
        milistamodulos.add(new Modulo("DAW"));
        milistamodulos.add(new Modulo("DAM"));

        MiAdaptadorModulos miadaptador = new MiAdaptadorModulos (this, R.layout.modulos_item,milistamodulos);

        binding.milistview.setAdapter(miadaptador);

        binding.milistview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (milistamodulos.get(i).getModulo()=="ASIR"){
            Intent intent = new Intent(this, ASIRActivity.class);
            startActivity(intent);
        }else if (milistamodulos.get(i).getModulo()=="DAW"){
            Intent intent = new Intent(this, DAWActivity.class);
            startActivity(intent);
        }else if (milistamodulos.get(i).getModulo()=="DAM"){
            Intent intent = new Intent(this, DAMActivity.class);
            startActivity(intent);
        }
    }
}