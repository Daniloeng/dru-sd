package io.spring.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;


@Document(collection = "solicitacao")
public class Solicitacao implements GrantedAuthority  {

    @Id
    private String id;
  
    @Field("solicitante_cpf")
    private String solicitanteCpf;

    @Field("solicitante_nome")
    private String solicitanteNome;
    
    @Field("solicitante_email")
    private String solicitanteEmail;    
 
    
    @Field("solicitado_cpf")
    private String solicitadoCpf;
    
    @Field("solicitado_nome")
    private String solicitadoNome;

    @Field("solicitado_email")
    private String solicitadoEmail;
    
    
    @Field("solicitado_em") 
    private Date solicitadoEm;
    
    @Field("expira_em") 
    private Date expiraEm;

    @Field("modificado_em") 
    private Date modificacaoEm;
  
    private String situacao = "NOVA"; 
    private String visualizado = "N"; 
    
  

    public Solicitacao(String solicitanteCpf, String solicitanteNome, String solicitanteEmail, String solicitadoCpf,
			String solicitadoNome, String solicitadoEmail, Date solicitadoEm, Date expiraEm, Date modificacaoEm,
			String situacao, String visualizado) {
		super();
		
		this.solicitanteCpf = solicitanteCpf;
		this.solicitanteNome = solicitanteNome;
		this.solicitanteEmail = solicitanteEmail;
		
		this.solicitadoCpf = solicitadoCpf;
		this.solicitadoNome = solicitadoNome;
		this.solicitadoEmail = solicitadoEmail;
		this.solicitadoEm = solicitadoEm;
		
		this.expiraEm = expiraEm;
		this.modificacaoEm = modificacaoEm;
		this.situacao = situacao;
		this.visualizado = visualizado;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	
	public String getSolicitanteCpf() {
		return solicitanteCpf;
	}

	public void setSolicitanteCpf(String solicitanteCpf) {
		this.solicitanteCpf = solicitanteCpf;
	}



	public String getSolicitanteNome() {
		return solicitanteNome;
	}

	public void setSolicitanteNome(String solicitanteNome) {
		this.solicitanteNome = solicitanteNome;
	}



	public String getSolicitanteEmail() {
		return solicitanteEmail;
	}

	public void setSolicitanteEmail(String solicitanteEmail) {
		this.solicitanteEmail = solicitanteEmail;
	}

	
	
	

	public String getSolicitadoCpf() {
		return solicitadoCpf;
	}

	public void setSolicitadoCpf(String solicitadoCpf) {
		this.solicitadoCpf = solicitadoCpf;
	}



	public String getSolicitadoNome() {
		return solicitadoNome;
	}

	public void setSolicitadoNome(String solicitadoNome) {
		this.solicitadoNome = solicitadoNome;
	}



	public String getSolicitadoEmail() {
		return solicitadoEmail;
	}

	public void setSolicitadoEmail(String solicitadoEmail) {
		this.solicitadoEmail = solicitadoEmail;
	}


	

	public Date getSolicitadoEm() {
		return solicitadoEm;
	}

	public void setSolicitadoEm(Date solicitadoEm) {
		this.solicitadoEm = solicitadoEm;
	}



	
	public Date getExpiraEm() {
		return expiraEm;
	}

	public void setExpiraEm(Date expiraEm) {
		this.expiraEm = expiraEm;
	}



	public Date getModificacaoEm() {
		return modificacaoEm;
	}

	public void setModificacaoEm(Date modificacaoEm) {
		this.modificacaoEm = modificacaoEm;
	}



	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}



	public String getVisualizado() {
		return visualizado;
	}

	public void setVisualizado(String visualizado) {
		this.visualizado = visualizado;
	}



	@Override
    public String getAuthority() {
        return id;
    }	 

}