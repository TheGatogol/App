package com.example.ingrodrigo.abdomen;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Leyenda extends ActionBarActivity {

    ListViewAdapter adapter;

    String[] titulos = new String[]{
            "titulo1",
            "titulo2",
            "titulo3",
            "titulo4",
    };

    String[] subtitulos = new String[]{
            "subtitulo1",
            "subtitulo2",
            "subtitulo3",
            "subtitulo4",
    };

    int[] imagenes = {
            R.drawable.alimentacion,
            R.drawable.cabecera,
            R.drawable.calentar,
            R.drawable.comparte
    };


    public void onCreate(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setContentView(R.layout.leyenda);

        ListView lista = (ListView) findViewById(R.id.listviewLeyenda);
        adapter = new ListViewAdapter(this, titulos, subtitulos, imagenes);
        lista.setAdapter(adapter);
    }

    public class ListViewAdapter extends BaseAdapter {
        // Declare Variables
        Context context;
        String[] titulos;
        String[] subtitulos;
        int[] imagenes;
        LayoutInflater inflater;

        public ListViewAdapter(Context context, String[] titulos, String[] subtitulos, int[] imagenes) {
            this.context = context;
            this.titulos = titulos;
            this.subtitulos = subtitulos;
            this.imagenes = imagenes;
        }

        @Override
        public int getCount() {
            return titulos.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            // Declare Variables
            TextView txtTitle;
            TextView txtSubtitule;
            ImageView imgImg;


            //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View itemView = inflater.inflate(R.layout.list_row, parent, false);

            // Locate the TextViews in listview_item.xml
            imgImg = (ImageView) itemView.findViewById(R.id.iv_ley_imagen);
            txtSubtitule = (TextView) itemView.findViewById(R.id.tv_ley_subtit);
            txtTitle = (TextView) itemView.findViewById(R.id.iv_ley_tit);


            // Capture position and set to the TextViews
            txtTitle.setText(titulos[position]);
            txtSubtitule.setText(subtitulos[position]);
            imgImg.setImageResource(imagenes[position]);



            return itemView;
        }
    }
}
