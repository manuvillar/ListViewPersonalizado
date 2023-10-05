package es.iesoretania.listviewpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MiAdaptadorModulos extends ArrayAdapter {
    private Context ctx;
    private int layoutTemplate;
    private List<Modulo> modulolist;

    public MiAdaptadorModulos(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.modulolist = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate,parent,false);

        Modulo elementoActual = modulolist.get(position);

        TextView textviewmodulo = (TextView)v.findViewById(R.id.textViewitem);
        ImageView imageviewmodulo = (ImageView)v.findViewById(R.id.imageViewitem);

        textviewmodulo.setText(elementoActual.getModulo());

        if (elementoActual.getModulo()=="ASIR"){
            imageviewmodulo.setImageResource(R.drawable.ic_asir);
        }else if (elementoActual.getModulo()=="DAW"){
            imageviewmodulo.setImageResource(R.drawable.ic_daw);
        }else if (elementoActual.getModulo()=="DAM"){
            imageviewmodulo.setImageResource(R.drawable.ic_dam);
        }

        return v;
    }
}
