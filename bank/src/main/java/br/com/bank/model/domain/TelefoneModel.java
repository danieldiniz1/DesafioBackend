package br.com.bank.model.domain;

import br.com.bank.model.form.TelefoneForm;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data()
@EqualsAndHashCode(of = {"ddd","numero"})
@Entity(name = "tb_telefones")
public class TelefoneModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String numero;
    private String ddd;
    private String isoCode;

    public static TelefoneModel valueOf (TelefoneForm telefoneForm) {
        TelefoneModel model = new TelefoneModel();
        model.setNumero(telefoneForm.numero());
        model.setDdd(telefoneForm.ddd());
        model.setIsoCode(telefoneForm.isoCode());
        return model;
    }

}
