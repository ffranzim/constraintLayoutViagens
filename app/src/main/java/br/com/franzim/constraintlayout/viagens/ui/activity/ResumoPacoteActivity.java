package br.com.franzim.constraintlayout.viagens.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.franzim.constraintlayout.viagens.R;
import br.com.franzim.constraintlayout.viagens.model.Pacote;
import br.com.franzim.constraintlayout.viagens.util.DataUtil;
import br.com.franzim.constraintlayout.viagens.util.DiasUtil;
import br.com.franzim.constraintlayout.viagens.util.MoedaUtil;
import br.com.franzim.constraintlayout.viagens.util.ResourcesUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String LOCAL_PACOTE = "São Paulo";
    public static final String IMAGEM_DRAWABLE = "sao_paulo_sp";
    public static final int DIAS_PACOTE = 2;
    public static final String VALOR_PACOTE = "243.99";

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

        Pacote pacote = new Pacote(LOCAL_PACOTE, IMAGEM_DRAWABLE, DIAS_PACOTE, new BigDecimal(VALOR_PACOTE));

        setLayout(pacote);

        Intent intent = new Intent(this, PagamentoActivity.class);
        startActivity(intent);

    }

    private void bindAtibutosTela() {
        imagemPacote = findViewById(R.id.resumo_pacote_iv);
        labelLocal = findViewById(R.id.resumo_pacote_tv_cidade);
        labelDias = findViewById(R.id.resumo_pacote_tv_dias);
        labelData = findViewById(R.id.resumo_pacote_tv_data);
        labelValor = findViewById(R.id.resumo_pacote_tv_valor);
        btnPagar = findViewById(R.id.resumo_pacote_btn_pagar);
    }

    private void setLayout(Pacote pacote) {
        imagemPacote.setImageDrawable(ResourcesUtil.getDrawable(this, pacote.getImagem()));
        labelLocal.setText(pacote.getLocal());
        labelDias.setText(DiasUtil.formataDiasEmTexto(pacote.getDias()));
        labelValor.setText(MoedaUtil.formataMoedaBR(pacote.getPreco()));

        String data = DataUtil.getPeriodoEmTexto(Calendar.getInstance(), pacote.getDias());
        labelData.setText(data);
    }


}
