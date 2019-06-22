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

    private String solicitante;
    private String solicitado;
    
    @CreatedDate
    @Field("solicitado_em")
    private Date solicitadoEm;
    
    
    @Field("expira_em")
    private Date expiraEm;

    @LastModifiedDate
    @Field("modificado_em")
    private Date modificacaoEm;

    
    private String situacao = "NOVA";
    private String visualizado = "N";
    
    
    
	public Solicitacao(String solicitante, String solicitado, String situacao, String visualizado, Date solicitadoEm, Date expiraEm, Date modificacaoEm) {
		super();
		this.solicitante = solicitante;
		this.solicitado = solicitado;
		this.situacao = situacao;
		this.visualizado = visualizado;
		this.solicitadoEm = solicitadoEm;
		this.expiraEm = expiraEm;
		this.modificacaoEm = modificacaoEm;
	}

	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getSolicitado() {
		return solicitado;
	}

	public void setSolicitado(String solicitado) {
		this.solicitado = solicitado;
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