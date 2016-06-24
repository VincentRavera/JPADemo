package fr.treeptik.jpasample.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name="requete1", query="SELECT p FROM Personne p WHERE p.nom=:name")
public class Personne implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id // dis que c'est not null et primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // dis que c'est auto increment
	private Integer id;
	
	private String nom;
	
	private String prenom;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	private String sexe;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Adresse adresse;
	
//	@OneToMany(mappedBy="personne")
	@ManyToMany
	private List<Numero> numero;
	
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", sexe=" + sexe + "]";
	}

	public Personne() {
	}
	
	public Personne(Integer id, String nom, String prenom, Date dateNaissance) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Numero> getNumero() {
		return numero;
	}

	public void setNumero(List<Numero> numero) {
		this.numero = numero;
	}
	
	

}
