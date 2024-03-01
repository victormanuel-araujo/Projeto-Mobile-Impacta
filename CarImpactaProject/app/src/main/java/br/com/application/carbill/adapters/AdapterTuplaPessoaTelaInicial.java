package br.com.application.carbill.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;

import br.com.application.carbill.models.PessoaResumoTelaInical;
import br.com.application.carbill.R;

public class AdapterTuplaPessoaTelaInicial extends ArrayAdapter<PessoaResumoTelaInical> {

    private final Context context;
    private final ArrayList<PessoaResumoTelaInical> elementos;

    public AdapterTuplaPessoaTelaInicial(Context context, ArrayList<PessoaResumoTelaInical> elementos){
        super(context, R.layout.tupla_pessoa_e_divida_total, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.tupla_pessoa_e_divida_total, parent, false);
        TextView txt_apelido = (TextView) rowView.findViewById(R.id.txt_apelido);
        TextView txt_divida_total = (TextView) rowView.findViewById(R.id.txt_divida_total);
        ImageView img_arrow_icon = (ImageView) rowView.findViewById(R.id.img_divida_click);

        txt_apelido.setText(elementos.get(position).getNome());
        String valorFormatado = NumberFormat.getCurrencyInstance().format(elementos.get(position).getTotal());
        txt_divida_total.setText(String.valueOf(valorFormatado));

        return rowView;
    }
}
