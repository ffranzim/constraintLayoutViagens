package br.com.franzim.constraintlayout.viagens.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.franzim.constraintlayout.viagens.R;
import br.com.franzim.constraintlayout.viagens.model.Pacote;
import br.com.franzim.constraintlayout.viagens.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String LOCAL_PACOTE = "São Paulo";
    public static final String IMAGEM_DRAWABLE = "sao_paulo_sp";
    public static final int DIAS_PACOTE = 2;
    public static final String VALOR_PACOTE = "243.99";

    TextView labelPrecoCompra;
    EditText inputNumeroCartao;
    EditText inputMesValidadeCartao;
    EditText inputAnoValidadeCartao;
    EditText inputCVCCartao;
    EditText inputNomeImpressoCartao;
    Button btnFinalizarCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(R.string.activity_pagamento_title);
        bindAtributosTela();

        Pacote pacote = new Pacote(LOCAL_PACOTE, IMAGEM_DRAWABLE, DIAS_PACOTE, new BigDecimal(VALOR_PACOTE));
        setLayout(pacote);

        Intent intent = new Intent(this, ResumoCompraActivity.class);
        startActivity(intent);
    }


    private void bindAtributosTela() {
        labelPrecoCompra = findViewById(R.id.pagamento_tv_preco_compra);
        inputNumeroCartao = findViewById(R.id.pagamento_et_numero_cartao);
        inputMesValidadeCartao = findViewById(R.id.pagamento_et_mes_validade_cartao);
        inputAnoValidadeCartao = findViewById(R.id.pagamento_et_ano_validade_cartao);
        inputCVCCartao = findViewById(R.id.pagamento_et_cvc_cartao);
        inputNomeImpressoCartao = findViewById(R.id.pagamento_et_nome_cartao);
        btnFinalizarCompra = findViewById(R.id.pagamento_btn_finaliza_compra);
    }

    private void setLayout(Pacote pacote) {
        labelPrecoCompra.setText(MoedaUtil.formataMoedaBR(pacote.getPreco()));
    }

}

