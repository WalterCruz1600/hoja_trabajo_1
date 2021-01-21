public class Radio implements IRatio {

    private double newPostion = 530;
    //Encendido = true; Apagado = false
    private boolean on_off = false;
    //FM = true, AM = false
    private boolean frecuencia = false;
    private double[] control_remoto_fm = new double[12];
    private double[] control_remoto_am = new double[12];

    public Radio() {
        for(int i = 0; i < 12; i++) {
            this.control_remoto_fm[i] = 0.0;
            this.control_remoto_am[i] = 0.0;
        }
    }

    public String onOff() {
        this.on_off = !this.on_off;
        String mensaje = "";
        if(this.on_off) 
            mensaje = "Encendido";
        else
            mensaje = "Apagado";
        return mensaje;
    }

    public String changeFrecuency() {
        this.frecuencia = !this.frecuencia;
        String mensaje = "";
        if(this.frecuencia) {
            mensaje = "Frecuencia actual: FM, Emisora: 87.9";
            this.newPostion = 87.9;
        } else {
            mensaje = "Frecuencia actual: AM, Emisora: 530";
            this.newPostion = 530;
        }
        return mensaje;
    }

    public String saveStation(int numero_estacion) {
        if(this.frecuencia)
            this.control_remoto_fm[numero_estacion] = this.newPostion;    
        else 
            this.control_remoto_am[numero_estacion] = this.newPostion;
        return "Emisora guardada exitosamente";
    }

    public String selectStation(int numero_estacion) {
        if(this.frecuencia)
            if(this.control_remoto_fm[numero_estacion] == 0)
                return "No hay emisora guardada en este botón.";
            else
                this.newPostion = this.control_remoto_fm[numero_estacion];    
        else 
            if(this.control_remoto_am[numero_estacion] == 0)
                return "No hay emisora guardada en este botón.";
            else
                this.newPostion = this.control_remoto_am[numero_estacion];
        return "Seleccionó la emisora: " + this.newPostion;
    }

    @Override
    public String moveDial(int tipo_movimiento) {
        if(this.frecuencia) {
            if(tipo_movimiento == 1) {
                if(this.newPostion == 107.9)
                    this.newPostion = 87.9;
                else 
                    this.newPostion += 0.2;
            } else {
                if(this.newPostion == 87.9)
                    this.newPostion = 107.9;
                else 
                    this.newPostion -= 0.2;
            }
        } else {
            if(tipo_movimiento == 1) {
                if(this.newPostion == 1610)
                    this.newPostion = 530;
                else 
                    this.newPostion += 10;
            } else {
                if(this.newPostion == 530)
                    this.newPostion = 1610;
                else 
                    this.newPostion -= 10;
            }
        }
        this.newPostion = Math.round(this.newPostion * 100.0)/100.0;
        return "Estación actual: " + this.newPostion;
    }

    @Override
    public String checkStatus() {
        // TODO Auto-generated method stub
        return null;
    }



}