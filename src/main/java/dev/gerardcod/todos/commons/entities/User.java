package dev.gerardcod.todos.commons.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "todos")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = -6742839901120805498L;
	
	@Id
	private Long id;
	
	@Column(nullable = false)
	private String email;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(nullable = true)
	private String middleName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Todo> todos;
	
	private Date creationDate;
	
	private Date modificationDate;
	
	@PrePersist
	private void prePersist() {
		this.creationDate= new Date();
	}
	
	@PreUpdate
	private void preUpdate() {
		this.modificationDate = new Date();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", email=");
		builder.append(email);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", middleName=");
		builder.append(middleName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id);
	}

}
