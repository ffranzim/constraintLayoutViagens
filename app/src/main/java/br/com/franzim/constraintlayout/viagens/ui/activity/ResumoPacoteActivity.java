package br.com.franzim.constraintlayout.viagens.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.franzim.constraintlayout.viagens.R;
import br.com.franzim.constraintlayout.viagens.model.Pacote;
import br.com.franzim.constraintlayout.viagens.util.DiasUtil;
import br.com.franzim.constraintlayout.viagens.util.MoedaUtil;
import br.com.franzim.constraintlayout.viagens.util.ResourcesUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));


        ImageView imagemPacote = findViewById(R.id.resumo_pacote_iv);
        TextView labelLocal = findViewById(R.id.resumo_pacote_tv_cidade);
        TextView labelDias = findViewById(R.id.resumo_pacote_tv_dias);
        TextView labelData = findViewById(R.id.resumo_pacote_tv_data);
        TextView labelValor = findViewById(R.id.resumo_pacote_tv_valor);
        Button btnPagar = findViewById(R.id.resumo_pacote_btn_pagar);

        imagemPacote.setImageDrawable(ResourcesUtil.getDrawable(this, pacote.getImagem()));
        labelLocal.setText(pacote.getLocal());
        labelDias.setText(DiasUtil.formataDiasEmTexto(pacote.getDias()));
//        labelData.setText();
        labelValor.setText(MoedaUtil.formataMoedaBR(pacote.getPreco()));


    }
}
