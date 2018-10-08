package kellyurango.murky;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Cliente cliente;
    Button botonIzquierda;
    Button botonDerecha;

    private String mensaje;
    private int id, conectados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cliente = new Cliente(this);
        cliente.start();


        //  Cliente.getInstance().setObserver(this);


        //new Thread(com).start();
        //view.setEnabled(false);


        //cliente = new Cliente();
        //cliente.addObserver(this);
        //new Thread(cliente).start();
        //cliente.start();

        botonIzquierda = findViewById(R.id.izquierda);
        botonDerecha = findViewById(R.id.derecha);


        botonIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cliente.enviarMensajes("izquierda:" + id);

                Log.e("ESTO","FUNCIONA");

            }
        });
        botonDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cliente.enviarMensajes("derecha:" + id);
                Log.e("ESTO","FUNCIONA X 2");
            }
        });
    }

    /*
    public void toconectar(View view) {
        cliente = new Cliente();
        cliente.addObserver(this);
        new Thread(cliente).start();
        view.setEnabled(false);
    }

    public void derecha(View view) {
        cliente.enviarMensajes("derecha:"+id);
    }

    public void izquierda(View view) {
        cliente.enviarMensajes("izquierda:"+id);
    }*/

/*
    public void update(Observable observable, Object msn) {
        if (msn instanceof String) {
            String mensaje = (String) msn;
            System.out.println("Se recibio: " + mensaje);

            if (mensaje.contains("Hola jugador")) {

                try{
                    Cliente.getInstance().enviarMensajes("quien soy");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //cliente.enviarMensajes("quien soy");
            }

            if (mensaje.contains("id")) {
                String[] partes = mensaje.split(":");
                id = Integer.parseInt(partes[1]);
                conectados = id;
            }
        }*/

}


