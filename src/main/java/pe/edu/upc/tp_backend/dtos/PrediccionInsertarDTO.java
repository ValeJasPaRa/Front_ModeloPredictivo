package pe.edu.upc.tp_backend.dtos;

public class PrediccionInsertarDTO {


        // FK — solo IDs
        private int idEmpresa;
        private int id_usuario;

        // Input
        private String  fecha_proyectada;   // String porque JSON no conoce LocalDate
        private String  producto;
        private String  categoria;
        private float   precio_unitario;
        private String  canal_venta;
        private String  tipo_cliente;
        private String  region_venta;
        private boolean tiene_dscto;
        private float   porcentaje_dscto;
        private boolean es_campain;
        private String  tipo_campain;
        private int     stock_inicial;

        // Output
        private float   cantidad_predicha;
        private float   stock_recomendado;
        private float   confianza;

        // modelo_version va fijo en el service
        // estado_predic y created_at los pone @PrePersist

        // Getters y Setters
        public int getIdEmpresa() { return idEmpresa; }
        public void setIdEmpresa(int idEmpresa) { this.idEmpresa = idEmpresa; }
        public int getId_usuario() { return id_usuario; }
        public void setId_usuario(int id_usuario) { this.id_usuario = id_usuario; }
        public String getFecha_proyectada() { return fecha_proyectada; }
        public void setFecha_proyectada(String f) { this.fecha_proyectada = f; }
        public String getProducto() { return producto; }
        public void setProducto(String producto) { this.producto = producto; }
        public String getCategoria() { return categoria; }
        public void setCategoria(String categoria) { this.categoria = categoria; }
        public float getPrecio_unitario() { return precio_unitario; }
        public void setPrecio_unitario(float p) { this.precio_unitario = p; }
        public String getCanal_venta() { return canal_venta; }
        public void setCanal_venta(String c) { this.canal_venta = c; }
        public String getTipo_cliente() { return tipo_cliente; }
        public void setTipo_cliente(String t) { this.tipo_cliente = t; }
        public String getRegion_venta() { return region_venta; }
        public void setRegion_venta(String r) { this.region_venta = r; }
        public boolean isTiene_dscto() { return tiene_dscto; }
        public void setTiene_dscto(boolean t) { this.tiene_dscto = t; }
        public float getPorcentaje_dscto() { return porcentaje_dscto; }
        public void setPorcentaje_dscto(float p) { this.porcentaje_dscto = p; }
        public boolean isEs_campain() { return es_campain; }
        public void setEs_campain(boolean e) { this.es_campain = e; }
        public String getTipo_campain() { return tipo_campain; }
        public void setTipo_campain(String t) { this.tipo_campain = t; }
        public int getStock_inicial() { return stock_inicial; }
        public void setStock_inicial(int s) { this.stock_inicial = s; }
        public float getCantidad_predicha() { return cantidad_predicha; }
        public void setCantidad_predicha(float c) { this.cantidad_predicha = c; }
        public float getStock_recomendado() { return stock_recomendado; }
        public void setStock_recomendado(float s) { this.stock_recomendado = s; }
        public float getConfianza() { return confianza; }
        public void setConfianza(float c) { this.confianza = c; }
}
