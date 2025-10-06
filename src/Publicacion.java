public class Publicacion {
    private String codigo;
    private String titulo;
    private String mensaje;
    
    public Publicacion(String codigo, String titulo, String mensaje) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.mensaje = mensaje;
    }
    
    // Getters
    public String getCodigo() {
        return codigo;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    // Setters
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    @Override
    public String toString() {
        return "Codigo: " + codigo + "\n" +
               "Titulo: " + titulo + "\n" +
               "Mensaje: " + mensaje + "\n" +
               "----------------------------------------\n";
    }
}