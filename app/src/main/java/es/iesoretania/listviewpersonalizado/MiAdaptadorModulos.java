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
import java.util.Objects;

public class MiAdaptadorModulos extends ArrayAdapter<Modulo> {
    private final Context ctx;
    private final int layoutTemplate;
    private final List<Modulo> modulolist;

    public MiAdaptadorModulos(@NonNull Context context, int resource, @NonNull List<Modulo> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.modulolist = objects;
    }

    private static class ViewHolder {
        TextView textviewmodulo;
        ImageView imageviewmodulo;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(ctx).inflate(layoutTemplate, parent, false);
            holder = new ViewHolder();
            holder.textviewmodulo = convertView.findViewById(R.id.textViewitem);
            holder.imageviewmodulo = convertView.findViewById(R.id.imageViewitem);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Modulo elementoActual = modulolist.get(position);
        holder.textviewmodulo.setText(elementoActual.getModulo());

        switch (elementoActual.getModulo()) {
            case "ASIR":
                holder.imageviewmodulo.setImageResource(R.drawable.ic_asir);
                break;
            case "DAW":
                holder.imageviewmodulo.setImageResource(R.drawable.ic_daw);
                break;
            case "DAM":
                holder.imageviewmodulo.setImageResource(R.drawable.ic_dam);
                break;
                // En caso de que haya un módulo sin icono específico
            default:
                holder.imageviewmodulo.setImageResource(R.drawable.baseline_disabled_by_default_24);
                break;
        }

        return convertView;
    }
}

