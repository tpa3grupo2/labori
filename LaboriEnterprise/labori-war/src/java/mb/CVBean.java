package mb;

import entity.Education;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CVBean implements Serializable {

    private List<Education> listaFormacao;
    private Education formacao;

    public void iniciarFormulario(){
        formacao = new Education();
    }
    
    public void salvar(){
        this.listaFormacao.add(formacao);
        this.formacao = new Education();
    }
    
    public CVBean(){
        this.listaFormacao = new ArrayList<Education>();
    }

    public Education getFormacao() {
        return formacao;
    }

    public void setFormacao(Education formacao) {
        this.formacao = formacao;
    }

    public List<Education> getListaFormacao() {
        return listaFormacao;
    }

    public void setListaFormacao(List<Education> listaFormacao) {
        this.listaFormacao = listaFormacao;
    }
    
}
