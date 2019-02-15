package br.com.franzim.constraintlayout.viagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.franzim.constraintlayout.viagens.R;
import br.com.franzim.constraintlayout.viagens.model.Pacote;
import br.com.franzim.constraintlayout.viagens.util.MoedaUtil;

import static br.com.franzim.constraintlayout.viagens.util.Constantes.NAME_PUT_EXTRA_PACOTE;

public class PagamentoActivity extends AppCompatActivity {

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
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(NAME_PUT_EXTRA_PACOTE)) {
            Pacote pacote = (Pacote) intent.getSerializableExtra(NAME_PUT_EXTRA_PACOTE);
            setLayout(pacote);
        }
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

    private void setLayout(final Pacote pacote) {
        labelPrecoCompra.setText(MoedaUtil.formataMoedaBR(pacote.getPreco()));
        btnFinalizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
                intent.putExtra(NAME_PUT_EXTRA_PACOTE, pacote);
                startActivity(intent);
            }
        });
    }

}

