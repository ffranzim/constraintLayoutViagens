package br.com.franzim.constraintlayout.viagens.ui.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.franzim.constraintlayout.viagens.R;
import br.com.franzim.constraintlayout.viagens.dao.PacoteDao;
import br.com.franzim.constraintlayout.viagens.model.Pacote;
import br.com.franzim.constraintlayout.viagens.ui.adapter.ListaPacotesAdapter;
import br.com.franzim.constraintlayout.viagens.util.Constantes;

import static br.com.franzim.constraintlayout.viagens.util.Constantes.NAME_PUT_EXTRA_PACOTE;

public class ListaPacotesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(R.string.activity_title_packages);
        confListaPacotes();

    }

    private void confListaPacotes() {
        final List<Pacote> pacotes = new PacoteDao().listaPacotes();
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_lv_pacotes);
        listaDePacotes.setAdapter(new ListaPacotesAdapter(this, pacotes));
        listaDePacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
                Pacote pacote = pacotes.get(position);
                intent.putExtra(NAME_PUT_EXTRA_PACOTE, pacote);
                startActivity(intent);
            }
        });
    }

}
