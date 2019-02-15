package br.com.franzim.constraintlayout.viagens.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.franzim.constraintlayout.viagens.R;
import br.com.franzim.constraintlayout.viagens.model.Pacote;
import br.com.franzim.constraintlayout.viagens.util.DataUtil;
import br.com.franzim.constraintlayout.viagens.util.MoedaUtil;
import br.com.franzim.constraintlayout.viagens.util.ResourcesUtil;

public class ResumoCompraActivity extends AppCompatActivity {


    public static final String LOCAL_PACOTE = "São Paulo";
    public static final String IMAGEM_DRAWABLE = "sao_paulo_sp";
    public static final int DIAS_PACOTE = 2;
    public static final String VALOR_PACOTE = "243.99";

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

        Pacote pacote = new Pacote(LOCAL_PACOTE, IMAGEM_DRAWABLE, DIAS_PACOTE, new BigDecimal(VALOR_PACOTE));
        setLayout(pacote);

        
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
