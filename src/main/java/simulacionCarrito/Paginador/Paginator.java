/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionCarrito.Paginador;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author santi
 */
public class Paginator<T> {

    private String url;
    private Page<T> page;
    private int totalPaginas;
    private int numElementosPorPagina;
    private int paginaActual;

    private List<PaginatorItem> lista;

    public Paginator(String url, Page<T> page) {

        this.lista = new ArrayList<PaginatorItem>();
        this.url = url;
        this.page = page;
        this.numElementosPorPagina = page.getSize();
        this.totalPaginas = page.getTotalPages();
        this.paginaActual = page.getNumber() + 1;
        int desde, hasta;
        if (this.totalPaginas <= this.numElementosPorPagina) {
            desde = 1;
            hasta = this.totalPaginas;
        } else {
            if (this.paginaActual <= this.numElementosPorPagina / 2) {
                desde = 1;
                hasta = numElementosPorPagina;
            } else if (this.paginaActual >= this.totalPaginas - this.numElementosPorPagina / 2) {
                desde = this.totalPaginas - this.numElementosPorPagina + 1;
                hasta = this.numElementosPorPagina;
            } else {
                desde = this.paginaActual - this.numElementosPorPagina / 2;
                hasta = this.numElementosPorPagina;
            }
        }
        for (int i = 0; i < hasta; i++) {
            lista.add(new PaginatorItem(desde + i, this.paginaActual == desde + 1));// => El PageItem es la clase que creamos donde pusimos numero y actual.
        }

    }

    public String getUrl() {
        return url;
    }

//    public void setUrl(String url) {
//        this.url = url;
//    }

    public Page<T> getPage() {
        return page;
    }

//    public void setPage(Page<T> page) {
//        this.page = page;
//    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

//    public void setTotalPaginas(int totalPaginas) {
//        this.totalPaginas = totalPaginas;
//    }

    public int getNumElementosPorPagina() {
        return numElementosPorPagina;
    }

//    public void setNumElementosPorPagina(int numElementosPorPagina) {
//        this.numElementosPorPagina = numElementosPorPagina;
//    }

//    public void setPagActual(int paginaActual) {
//        this.paginaActual = paginaActual;
//    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public List<PaginatorItem> getLista() {
        return lista;
    }

//    public void setLista(List<PaginatorItem> lista) {
//        this.lista = lista;
//    }

    //Métodos para las páginas
    public boolean ifFirst() {
        return page.isFirst();
    }

    public boolean ifLast() {
        return page.isLast();
    }

    public boolean ifHasNext() {
        return page.hasNext();
    }

    public boolean ifHasPrevious() {
        return page.hasPrevious();
    }

}
