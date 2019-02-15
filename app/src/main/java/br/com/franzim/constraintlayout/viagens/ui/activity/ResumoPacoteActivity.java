package br.com.franzim.constraintlayout.viagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

import br.com.franzim.constraintlayout.viagens.R;
import br.com.franzim.constraintlayout.viagens.model.Pacote;
import br.com.franzim.constraintlayout.viagens.util.Constantes;
import br.com.franzim.constraintlayout.viagens.util.DataUtil;
import br.com.franzim.constraintlayout.viagens.util.DiasUtil;
import br.com.franzim.constraintlayout.viagens.util.MoedaUtil;
import br.com.franzim.constraintlayout.viagens.util.ResourcesUtil;

import static br.com.franzim.constraintlayout.viagens.util.Constantes.NAME_PUT_EXTRA_PACOTE;

public class ResumoPacoteActivity extends AppCompatActivity {


    private ImageView imagemPacote;
    private TextView labelLocal;
    private TextView labelDias;
    private TextView labelData;
    private TextView labelValor;
    private Button btnPagar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(R.string.activity_resumo_pacote_title);

        bindAtibutosTela();
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(NAME_PUT_EXTRA_PACOTE)) {
            Pacote pacote = (Pacote) intent.getSerializableExtra(NAME_PUT_EXTRA_PACOTE);
            setLayout(pacote);
        }
    }

    private void bindAtibutosTela() {
        imagemPacote = findViewById(R.id.resumo_pacote_iv);
        labelLocal = findViewById(R.id.resumo_pacote_tv_cidade);
        labelDias = findViewById(R.id.resumo_pacote_tv_dias);
        labelData = findViewById(R.id.resumo_pacote_tv_data);
        labelValor = findViewById(R.id.resumo_pacote_tv_valor);
        btnPagar = findViewById(R.id.resumo_pacote_btn_pagar);
    }

    private void setLayout(final Pacote pacote) {
        imagemPacote.setImageDrawable(ResourcesUtil.getDrawable(this, pacote.getImagem()));
        labelLocal.setText(pacote.getLocal());
        labelDias.setText(DiasUtil.formataDiasEmTexto(pacote.getDias()));
        labelValor.setText(MoedaUtil.formataMoedaBR(pacote.getPreco()));

        String data = DataUtil.getPeriodoEmTexto(Calendar.getInstance(), pacote.getDias());
        labelData.setText(data);

        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
                intent.putExtra(NAME_PUT_EXTRA_PACOTE, pacote);
                startActivity(intent);
            }
        });
    }


}
