package one.digitalinnovation.gof.service;

import jakarta.validation.constraints.Pattern;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import one.digitalinnovation.gof.model.Endereco;

/**
 * Client HTTP, criado via <b>OpenFeign</b>, para o consumo da API do
 * <b>ViaCEP</b>.
 *
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeign</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 *
 * Consulta endereço pelo CEP utilizando a API ViaCEP.
 */
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    /**
     * Consulta informações de endereço a partir de um CEP usando a API ViaCEP.
     *
     * @param cep CEP no formato apenas números (ex: "01001000").
     * @return Objeto {@link Endereco} com os dados retornados pela API.
     */
    @GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") @Pattern(regexp = "\\d{8}", message = "CEP deve conter 8 dígitos numéricos") String cep);
}
