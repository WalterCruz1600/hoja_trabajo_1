public class Radio implements IRatio {

    private double newPosition;
    //Encendido = true; Apagado = false
    private boolean on_off;
    //FM = true, AM = false
    private boolean frecuencia;
    private double[] control_remoto_fm = new double[12];
    private double[] control_remoto_am = new double[12];

    //Constructor
    public Radio() {
        this.newPosition = 530;
        this.on_off = false;
        this.frecuencia = false;
        for(int i = 0; i < 12; i++) {
            this.control_remoto_fm[i] = 0.0;
            this.control_remoto_am[i] = 0.0;
        }
    }

    @Override
    public String onOff() {
        this.on_off = !this.on_off;
        String mensaje = "";
        if(this.on_off) 
            mensaje = "Encendido";
        else
            mensaje = "Apagado";
        return mensaje;
    }

    @Override
    public String changeFrecuency() {
        this.frecuencia = !this.frecuencia;
        String mensaje = "";
        //If/else para detectar opción del usuario.
        if(this.frecuencia) {
            //Comienza en la estación más baja de FM o AM.
            mensaje = "Frecuencia actual: FM, Emisora: 87.9";
            this.newPosition = 87.9;
        } else {
            mensaje = "Frecuencia actual: AM, Emisora: 530";
            this.newPosition = 530;
        }
        return mensaje;
    }

    @Override
    public String checkFavs() {
        double[] estaciones;
        String respuesta = "";
        if(this.frecuencia)
            estaciones = control_remoto_fm;
        else
            estaciones = control_remoto_am;
        for(int i = 0; i < estaciones.length; i++) {
            String s = "";
            if(estaciones[i] == 0)
                s = "Sin asignación";
            else
                s = String.valueOf(estaciones[i]);
            respuesta = respuesta + s;
            if((i + 1) < estaciones.length)
                respuesta = respuesta  + " - ";
        }
        return respuesta;
    }

    @Override
    public String saveStation(int numero_estacion) {
        if(this.frecuencia)
            this.control_remoto_fm[numero_estacion] = this.newPosition;    
        else 
            this.control_remoto_am[numero_estacion] = this.newPosition;
        return "Emisora guardada exitosamente";
    }

    @Override
    public String selectStation(int numero_estacion) {
        if(this.frecuencia)
            if(this.control_remoto_fm[numero_estacion] == 0)
                return "No hay emisora guardada en este botón.";
            else
                this.newPosition = this.control_remoto_fm[numero_estacion];    
        //En caso de no haber una emisora, se despliega un mensaje de "error."
        else 
            if(this.control_remoto_am[numero_estacion] == 0)
                return "No hay emisora guardada en este botón.";
        //En caso de detectar un valor, se cambia a la emisora guardada en el atajo.
            else
                this.newPosition = this.control_remoto_am[numero_estacion];
        return "Seleccionó la emisora: " + this.newPosition;
    }

    @Override
    //Se crea un int para adelantar o retroceder en el navegador de radio.
    public String moveDial(int tipo_movimiento) {
        if(this.frecuencia) {
            if(tipo_movimiento == 1) {
                /*Se hace un if para asegurarse que no se vaya más allá
                del límite de estación, sino que regrese a la inicial.*/
                if(this.newPosition == 107.9)
                    this.newPosition = 87.9;
                //Esta función permite avanzar de estación en estación.
                else 
                    this.newPosition += 0.2;
                /*Es lo mismo que dicta la línea 76 pero en caso contrario. */
            } else {
                if(this.newPosition == 87.9)
                    this.newPosition = 107.9;
                else 
                    this.newPosition -= 0.2;
            }
        /*Este else es en caso de que se haya detectado frecuencia AM.Todos los 
        procesos de la radio FM se repitieron con los valores respectivos.*/
        } else {
            if(tipo_movimiento == 1) {
                if(this.newPosition == 1610)
                    this.newPosition = 530;
                else 
                    this.newPosition += 10;
            } else {
                if(this.newPosition == 530)
                    this.newPosition = 1610;
                else 
                    this.newPosition -= 10;
            }
        }
        /*Permite que la frecuencia que se despliegue en la 
        terminal no tenga decimales de más.*/
        this.newPosition = Math.round(this.newPosition * 100.0)/100.0;
        return "Estación actual: " + this.newPosition;
    }

}