package br.com.franzim.constraintlayout.viagens.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.franzim.constraintlayout.viagens.R;
import br.com.franzim.constraintlayout.viagens.dao.PacoteDao;
import br.com.franzim.constraintlayout.viagens.model.Pacote;
import br.com.franzim.constraintlayout.viagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);


        List<Pacote> pacotes = new PacoteDao().listaPacotes();
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_lv_pacotes);
        listaDePacotes.setAdapter(new ListaPacotesAdapter(this, pacotes));
    }
}
