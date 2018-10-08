package kellyurango.murky;

import android.util.Log;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente extends Thread{
    private static Cliente ins; // Instance
    private boolean conectado;
    DataOutputStream salida;
    private Socket socket;
    private boolean vida;
    private static final String IPADDRESS = "192.168.1.53";
    private static final int PUERTO = 7070;
    //private Observer main;

    private String actual;
    MainActivity main;

    public Cliente ( MainActivity activity) {
        this.main = activity;
        //vida = true;
        //socket = null;
        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket(InetAddress.getByName("192.168.1.53"), 7070);
                    conectado = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/
    }

    /*
    @Override
    public void run() {
        while (true) {
            if (socket != null && socket.isConnected()) {
                recibirMensajes();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

    @Override
    public void run() {

        try{

            socket = new Socket("192.168.1.53", 7070);

            //Receptor rec = new Receptor( s );
            // rec.setObserver(activity);
            //rec.start();

        } catch (Exception e){

            e.printStackTrace();
        }
    }

    /*
    @Override
    public void run() {
        while (vida) {
            try {
                if (socket == null) {
                    socket = new Socket(InetAddress.getByName("192.168.1.53"), 7070);
                    conectado = true;
                } else {
                    recibirMensajes();
                }

                Thread.sleep(100);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("NO SERVER");
                vida = true;


                try {
                    socket.close();
                } catch (IOException a) {
                    a.printStackTrace();
                }

                socket = null;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    */



    /*
    private void recibirMensajes() throws IOException, ClassNotFoundException {
        ObjectInputStream inObj = new ObjectInputStream(socket.getInputStream());
        Object ob = inObj.readObject();
        main.update(null, ob);
    }*/
    /*
    private void recibirMensajes() {
        DataInputStream entrada = null;
        try {
            entrada = new DataInputStream(socket.getInputStream());
            String mensaje = entrada.readUTF();

            setChanged();
            notifyObservers(mensaje);
            clearChanged();

        } catch (IOException e) {
            try {
                if (entrada != null) {
                    entrada.close();
                }
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            socket = null;
            conectado = false;
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/


    /*
    public void enviarMensajes(final String mensaje) throws IOException {
        ObjectOutputStream outObj = new ObjectOutputStream(socket.getOutputStream());
        outObj.writeObject(mensaje);
        outObj.flush();

        new RetrieveFeedTask().doInBackground(mensaje);
    }*/

    /*
    public void enviarMensajes(final String mensaje) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OutputStream os = socket.getOutputStream();
                    PrintWriter mensaje = new PrintWriter( new OutputStreamWriter(os));

                    //salida = new DataOutputStream(socket.getOutputStream());
                    //salida.writeUTF(mensaje);

                    mensaje.println(mensaje);

                    mensaje.flush();

                    System.out.println("Se envia el mensaje: " + mensaje);
                } catch (IOException e) {
                    try {
                        if (salida != null) {
                            salida.close();
                        }
                        socket.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    socket = null;
                    conectado = false;
                    e.printStackTrace();
                }
            }
        }).start();



    }
    */

    /*
    public void enviar (final String msj) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OutputStream os = socket.getOutputStream();
                    //Imprimo si funciona
                    Log.e("Envia", "Ready");

                    PrintWriter mensaje = new PrintWriter( new OutputStreamWriter(os));
                    mensaje.println(msj);

                    mensaje.flush();

                } catch ( Exception e ) {
                    e.printStackTrace();
                }
            }
        }).start();
    }*/

    public void enviarMensajes (final String msj) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    OutputStream os = socket.getOutputStream();
                    Log.e("ENVIAR", "ME PREPARO PARA ENVIAR UN MENSAJE");

                    PrintWriter mensaje = new PrintWriter( new OutputStreamWriter(os));
                    mensaje.println(msj);

                    mensaje.flush();

                } catch ( Exception e ) {

                    e.printStackTrace();
                }
            }
        }).start();
    }

    /*
    public static Cliente getInstance() {
        if (ins == null) {
            ins = new Cliente();
            new Thread(ins).start();
        }

        return ins;
    }*/
    /*

    class RetrieveFeedTask extends AsyncTask<Object, Void, Void> {

        @Override
        protected Void doInBackground(Object... objects) {
            try {
                ObjectOutputStream outObj = new ObjectOutputStream(socket.getOutputStream());
                outObj.writeObject(objects);
                outObj.flush();
            } catch (Exception e) {

            }
            return null;
        }
    }*/

    /*
    public String getActual() {
        return actual;
    }


    public void setObserver(Observer main) {

        this.main = main;
    }

    */

}
