package com.example.examenapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Fragment1 extends Fragment implements View.OnClickListener {


    //Definir variables

    TextView tvResultadoCubo, tvResultadoEsfera, tvResultadoPara;
    EditText lCubo, radio, largo, ancho, profundo;
    Button areaCubo, areaEsfera, areaPara, volumenCubo, volumenEsfera, volumenPara, bCubo, bEsfera, bPara;
    ViewFlipper vf;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (container != null) container = null;
        final View view = inflater.inflate(R.layout.fragment_1, container, false);
        inicializarVariables(view);
        return view;
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View view) {

        double lcubo, Radio, Largo, Ancho, Profundo;
        try {
            //Función según el botón
            switch (view.getId()) {
                case R.id.bAreaCubo:
                    //Comprobación dato a introducir esta vacio
                    if (lCubo.getText().toString().isEmpty())
                        //Lanzar excepción personalizada
                        throw new NumericException("Debe introducir un numero");
                    else {
                        lcubo = Double.parseDouble(lCubo.getText().toString());
                        //Comprobación dato es menor o igual a cero
                        if (lcubo <= 0) throw new NumericException("El valor debe ser mayor a 0");
                        else tvResultadoCubo.setText("Resultado: " + 6 * Math.pow(lcubo, 2));
                    }
                    break;

                case R.id.bAreaEsfera:
                    //Comprobación dato a introducir esta vacio
                    if (radio.getText().toString().isEmpty())
                        //Lanzar excepción personalizada
                        throw new NumericException("Debe introducir un numero");
                    else {
                        Radio = Double.parseDouble(radio.getText().toString());
                        //Comprobación dato es menor o igual a cero
                        if (Radio <= 0) throw new NumericException("El valor debe ser mayor a 0");
                        else
                            tvResultadoEsfera.setText("Resultado: " + 4 * Math.PI * Math.pow(Radio, 2));
                    }
                    break;

                case R.id.bAreaPara:
                    //Comprobación datos a introducir están vacios
                    if (largo.getText().toString().isEmpty() || ancho.getText().toString().isEmpty())
                        //Lanzar excepción personalizada
                        throw new NumericException("Debe introducir valores");
                    else {
                        Largo = Double.parseDouble(largo.getText().toString());
                        Ancho = Double.parseDouble(ancho.getText().toString());
                        //Comprobación datos son menores o igual a cero
                        if (Largo <= 0 || Ancho <= 0)
                            throw new NumericException("El valor debe ser mayor a 0");
                        else tvResultadoPara.setText("Resultado: " + Largo * Ancho);
                    }
                    break;

                case R.id.bVolumenCubo:
                    //Comprobación dato a introducir esta vacio
                    if (lCubo.getText().toString().isEmpty())
                        //Lanzar excepción personalizada
                        throw new NumericException("Debe introducir un numero");
                    else {
                        lcubo = Double.parseDouble(lCubo.getText().toString());
                        //Comprobación dato es menor o igual a cero
                        if (lcubo <= 0) throw new NumericException("El valor debe ser mayor a 0");
                        else tvResultadoCubo.setText("Resultado: " + Math.pow(lcubo, 3));
                    }
                    break;

                case R.id.bVolumenEsfera:
                    //Comprobación dato a introducir esta vacio
                    if (radio.getText().toString().isEmpty())
                        //Lanzar excepción personalizada
                        throw new NumericException("Debe introducir un numero");
                    else {
                        Radio = Double.parseDouble(radio.getText().toString());
                        //Comprobación dato es menor o igual a cero
                        if (Radio <= 0) throw new NumericException("El valor debe ser mayor a 0");
                        else
                            tvResultadoEsfera.setText("Resultado: " + (4 * Math.PI * Math.pow(Radio, 3)) / 3);
                    }
                    break;

                case R.id.bVolumenPara:
                    //Comprobación datos a introducir están vacios
                    if (largo.getText().toString().isEmpty() || ancho.getText().toString().isEmpty() || profundo.getText().toString().isEmpty())
                        //Lanzar excepción personalizada
                        throw new NumericException("Debe introducir valores");
                    else {
                        Largo = Double.parseDouble(largo.getText().toString());
                        Ancho = Double.parseDouble(ancho.getText().toString());
                        Profundo = Double.parseDouble(profundo.getText().toString());
                        //Comprobación datos son menores o igual a cero
                        if (Largo <= 0 || Ancho <= 0 || Profundo <= 0)
                            throw new NumericException("El valor debe ser mayor a 0");
                        else tvResultadoPara.setText("Resultado: " + Largo * Ancho * Profundo);
                    }
                    break;

                default:
                    break;
            }
        } catch (NumericException e) {
            //Creación toast a mostrar
            Toast toast = Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG);
            //Colocar toast en el centro
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    //Metodo para inicializar las variables
    private void inicializarVariables(View view) {
        vf = view.findViewById(R.id.vf);
        //Resultados
        tvResultadoCubo = view.findViewById(R.id.tvResultadoCubo);
        tvResultadoEsfera = view.findViewById(R.id.tvResultadoEsfera);
        tvResultadoPara = view.findViewById(R.id.tvResultadoPara);
        //Datos
        lCubo = view.findViewById(R.id.ladoCubo);
        radio = view.findViewById(R.id.radio);
        largo = view.findViewById(R.id.largo);
        ancho = view.findViewById(R.id.ancho);
        profundo = view.findViewById(R.id.profundo);
        //Botones
        areaCubo = view.findViewById(R.id.bAreaCubo);
        areaEsfera = view.findViewById(R.id.bAreaEsfera);
        areaPara = view.findViewById(R.id.bAreaPara);
        volumenCubo = view.findViewById(R.id.bVolumenCubo);
        volumenEsfera = view.findViewById(R.id.bVolumenEsfera);
        volumenPara = view.findViewById(R.id.bVolumenPara);
        bCubo = view.findViewById(R.id.bCubo);
        bPara = view.findViewById(R.id.bPara);
        bEsfera = view.findViewById(R.id.bEsfera);
        //Listeners
        areaCubo.setOnClickListener(this);
        areaEsfera.setOnClickListener(this);
        areaPara.setOnClickListener(this);
        volumenCubo.setOnClickListener(this);
        volumenEsfera.setOnClickListener(this);
        volumenPara.setOnClickListener(this);
        bCubo.setOnClickListener(handler);
        bPara.setOnClickListener(handler);
        bEsfera.setOnClickListener(handler);
    }

    //Listener para cambiar figura
    View.OnClickListener handler = view1 -> {
        if (bCubo.equals(view1)) {
            vf.setDisplayedChild(0);
        } else if (bPara.equals(view1)) {
            vf.setDisplayedChild(1);
        } else if (bEsfera.equals(view1)) {
            vf.setDisplayedChild(2);
        } else {
            throw new IllegalStateException("Unexpected value: " + view1);
        }
    };


}