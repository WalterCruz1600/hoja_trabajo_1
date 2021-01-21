import java.util.ArrayList;

public class Radio implements IRatio {

    private int newPostion;
    private boolean on_off;
    private boolean frecuencia;
    private ArrayList<String> control_remoto;

    public Radio() {}

    public String onOff(boolean on_off) {
        this.on_off = !this.on_off;
        String mensaje = "";
        if(this.on_off) 
            mensaje = "Encendido";
        else
            mensaje = "Apagado";
        return mensaje;
    }

    

    @Override
    public String moveDial(int newPosition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String checkStatus() {
        // TODO Auto-generated method stub
        return null;
    }



}