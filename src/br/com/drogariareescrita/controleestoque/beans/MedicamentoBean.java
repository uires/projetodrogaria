package br.com.drogariareescrita.controleestoque.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;

import br.com.drogariareescrita.controleestoque.dao.FabricanteDAO;
import br.com.drogariareescrita.controleestoque.dao.MedicamentoDAO;
import br.com.drogariareescrita.controleestoque.domains.Medicamento;

@ManagedBean(name = "MedicamentoMB")
@ViewScoped

public class MedicamentoBean {
	private Medicamento medicamento;
	private ListDataModel<Medicamento> medicamentoItens;
	private List<Medicamento> listaMedicamentos;
	
	@PostConstruct
	public void carregarTabela() {
		listaMedicamentos = new ArrayList<>();
		MedicamentoDAO dao = new MedicamentoDAO();
		try {
			medicamento = new Medicamento();
			ArrayList<Medicamento> lista = dao.selectMedicamentoALl();
			
			listaMedicamentos.addAll(dao.selectMedicamentoALl());
			
			medicamentoItens = new ListDataModel<>(lista);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void cadastroMedicamento() {

		MedicamentoDAO dao = new MedicamentoDAO();
		try {
			dao.inserirMedicamento(medicamento);
			ArrayList<Medicamento> lista = dao.selectMedicamentoALl();
			medicamentoItens = new ListDataModel<>(lista);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void carregaSelects() {
		FabricanteDAO dao =  new FabricanteDAO();
	}

	public List<Medicamento> getListaMedicamentos() {
		return listaMedicamentos;
	}

	public void setListaMedicamentos(List<Medicamento> listaMedicamentos) {
		this.listaMedicamentos = listaMedicamentos;
	}

	public ListDataModel<Medicamento> getMedicamentoItens() {
		return medicamentoItens;
	}

	public void setMedicamentoItens(ListDataModel<Medicamento> medicamentoItens) {
		this.medicamentoItens = medicamentoItens;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

}
