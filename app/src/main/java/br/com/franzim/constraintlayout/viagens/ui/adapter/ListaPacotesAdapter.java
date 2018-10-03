package br.com.franzim.constraintlayout.viagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.List;

import br.com.franzim.constraintlayout.viagens.R;
import br.com.franzim.constraintlayout.viagens.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(Context context, List<Pacote> pacotes) {
        this.context = context;
        this.pacotes = pacotes;

    }


    @Override
    public int getCount() {
        return this.pacotes.size();
    }

    @Override
    public Pacote getItem(int posicao) {
        return this.pacotes.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);


        Pacote pacote = pacotes.get(posicao);

        TextView tvLocal = viewCriada.findViewById(R.id.item_pacote_tv_local);
        tvLocal.setText(pacote.getLocal());

        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        Drawable drawable = resources.getDrawable(idDrawable);

        ImageView iv = viewCriada.findViewById(R.id.item_pacote_iv);
        iv.setImageDrawable(drawable);

        TextView tvDias = viewCriada.findViewById(R.id.item_pacote_tv_dias);
        tvDias.setText(pacote.getDias() + "dias");

        TextView tvPreco = viewCriada.findViewById(R.id.item_pacote_tv_preco);
        tvPreco.setText(pacote.getPreco().toString());


        return viewCriada;
    }
}
