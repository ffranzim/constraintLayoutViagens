package br.com.franzim.constraintlayout.viagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

import br.com.franzim.constraintlayout.viagens.R;
import br.com.franzim.constraintlayout.viagens.model.Pacote;
import br.com.franzim.constraintlayout.viagens.util.DataUtil;
import br.com.franzim.constraintlayout.viagens.util.MoedaUtil;
import br.com.franzim.constraintlayout.viagens.util.ResourcesUtil;

import static br.com.franzim.constraintlayout.viagens.util.Constantes.NAME_PUT_EXTRA_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {


    private ImageView ivPacote;
    private TextView labelDestinoPacote;
    private TextView labelDataPacote;
    private TextView labelValorPacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(R.string.activity_resumo_da_compra_title);

        bindAtributosTela();
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(NAME_PUT_EXTRA_PACOTE)) {
            Pacote pacote = (Pacote) intent.getSerializableExtra(NAME_PUT_EXTRA_PACOTE);
            setLayout(pacote);
        }
    }

    private void setLayout(Pacote pacote) {
        ivPacote.setImageDrawable(ResourcesUtil.getDrawable(this, pacote.getImagem()));
        labelDestinoPacote.setText(pacote.getLocal());
        labelDataPacote.setText(DataUtil.getPeriodoEmTexto(Calendar.getInstance(), pacote.getDias()));
        labelValorPacote.setText(MoedaUtil.formataMoedaBR(pacote.getPreco()));
    }

    private void bindAtributosTela() {
        ivPacote = findViewById(R.id.resumo_compra_iv_pacote);
        labelDestinoPacote = findViewById(R.id.resumo_compra_tv_destino_pacote);
        labelDataPacote = findViewById(R.id.resumo_compra_tv_data_pacote);
        labelValorPacote = findViewById(R.id.resumo_compra_tv_valor_pacote);
    }
}
