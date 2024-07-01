package com.codingdojo.cynthia.modelos;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuarios") //Nombre de tabla en plural
public class Usuario { //Nombre de clase en singular
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Auto-increment
	private Long id;
	
	@NotNull //@NotEmpty
	@Size(min=2, max=100, message="El nombre debe tener al menos 2 letras")
	private String nombre; //firstName
	
	@NotNull
	@Size(min=2, max=100, message="OYE NO! Pon tu apellido") //mensaje de error es automático
	private String apellido; //lastName
	
	@NotNull
	@Size(min=2, max=200)
	private String email;
	
	@NotNull
	@Size(min=2, max=200)
	private String password; //En un futuro este va a ser hasheando
	
	@Column(updatable=false) //Este atributo solo se agrega 1 vez, y NUNCA se actualiza
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@JsonBackReference(value="salones-json") //Objeto usuario NO va a mostrar salon
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="salon_id")//Llave foránea
	private Salon salon;
	
	@JsonManagedReference(value="hobbies-json") //Objeto usuario SI muestre la lista
	@JsonIgnore //No mandar esa información a través de json en la creación/guardado
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="usuarios_has_hobbies",
			joinColumns = @JoinColumn(name="usuario_id"),
			inverseJoinColumns = @JoinColumn(name="hobby_id")
			)
	private List<Hobby> hobbies;

	public Usuario() {
	}
	
	//Constructor SIN id -> Crear un nuevo usuario
	public Usuario(String nombre, String apellido, String email, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}
	
	//Contructor con id -> Actualizar usuario
	public Usuario(Long id, String nombre, String apellido, String email, String password) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}
	
	public List<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	@PrePersist //Antes de hacer la creación
	protected void onCreate() {
		this.createdAt = new Date(); //DEFAULT CURRENT_TIMESTAMP
	}
	
	@PreUpdate //Antes de la actualización
	protected void onUpdate() {
		this.updatedAt = new Date(); //DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
	}
	
	
}
