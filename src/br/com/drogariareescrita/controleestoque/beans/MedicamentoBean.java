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
import br.com.drogariareescrita.controleestoque.domains.Fabricante;
import br.com.drogariareescrita.controleestoque.domains.Medicamento;

@ManagedBean(name = "MedicamentoMB")
@ViewScoped

public class MedicamentoBean {
	private Medicamento medicamento;
	private ListDataModel<Medicamento> medicamentoItens;
	private List<Fabricante> fabricanteLista;

	@PostConstruct
	public void carregarTabela() {
		fabricanteLista = new ArrayList<>();
		MedicamentoDAO dao = new MedicamentoDAO();
		FabricanteDAO daoFa = new FabricanteDAO();
		try {
			medicamento = new Medicamento();
			ArrayList<Medicamento> lista = dao.selectMedicamentoALl();

			fabricanteLista.addAll(daoFa.selectFabricanteAll());
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
	
	public void prepararEditar() {
		medicamento = medicamentoItens.getRowData();
	}
	
	public void editar() {
		MedicamentoDAO dao = new MedicamentoDAO();
		try {
			dao.updateMedicamento(medicamento);
			medicamentoItens = new ListDataModel<>(dao.selectMedicamentoALl());
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public List<Fabricante> getFabricanteLista() {
		return fabricanteLista;
	}

	public void setFabricanteLista(List<Fabricante> fabricanteLista) {
		this.fabricanteLista = fabricanteLista;
	}


}
