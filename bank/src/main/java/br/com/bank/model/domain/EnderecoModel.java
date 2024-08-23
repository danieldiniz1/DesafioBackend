package br.com.bank.model.domain;

import br.com.bank.model.form.EnderecoForm;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "tb_endereco")
@EqualsAndHashCode(of = {"logradouro","numero","complemento","bairro","cidade","uf","pais"})
@Data
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private boolean enderecoPrincipal;

    @Column(nullable = false)
    private String cep;

    private String logradouro,numero,complemento,bairro,cidade,uf,pais;

    public static EnderecoModel valueOf (EnderecoForm enderecoForm) {
        EnderecoModel enderecoModel = new EnderecoModel();
        enderecoModel.setEnderecoPrincipal(enderecoForm.enderecoPrincipal());
        enderecoModel.setCep(enderecoForm.cep());
        enderecoModel.setLogradouro(enderecoForm.logradouro());
        enderecoModel.setNumero(enderecoForm.numero());
        enderecoModel.setComplemento(enderecoForm.complemento());
        enderecoModel.setBairro(enderecoForm.bairro());
        enderecoModel.setCidade(enderecoForm.cidade());
        enderecoModel.setUf(enderecoForm.uf());
        enderecoModel.setPais(enderecoForm.pais());
        return enderecoModel;
    }
}
