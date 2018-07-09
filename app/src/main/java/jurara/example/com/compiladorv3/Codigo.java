package jurara.example.com.compiladorv3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Codigo extends Fragment {
    EditText txtcodigo;
    EditText numeros;
    int lineas=1;
    String cad="";
    int temp=0;
    Button btn;
    public Codigo() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_codigo, container, false);

        txtcodigo=v.findViewById(R.id.codigo);
        numeros=v.findViewById(R.id.numeros);

        txtcodigo.requestFocus();
        txtcodigo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                lineas=txtcodigo.getLineCount();
                cad="";
                for(int i=1;i<=lineas;i++){
                    if (i==lineas){
                        cad+=i;
                    }else{
                        cad+=i+"\n";
                    }
                }
                if(lineas!=temp){
                    numeros.setText("");
                    numeros.setText(cad);
                }
                temp=lineas;

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return v;
    }

}
