package pe.edu.upc.tp_backend.servicesinterfaces;

import pe.edu.upc.tp_backend.entities.Empresas;

import java.util.List;

public interface IEmpresaService {

    public List<Empresas> list();
    public void insert(Empresas empresa);
    public Empresas listId(int id);
    public void update(Empresas empresa);
    public  void delete(int id);
    public Empresas insertar(Empresas empresa);  //devuelve la empresa luego de insertarla
    //no solo la inserta
}
