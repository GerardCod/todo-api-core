package dev.gerardcod.todos.commons.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Todo implements Serializable {
	private static final long serialVersionUID = -9197818589235625712L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private Date dueDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = true)
	private User user;
	
	private Date creationDate;
	
	private Date modificationDate;
	
	public Todo(String title, String description, Date dueDate) {
		super();
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
	}
	
	@PrePersist
	private void prePersist() {
		this.creationDate = new Date();
	}
	
	@PreUpdate
	private void preUpdate() {
		this.modificationDate = new Date();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return Objects.equals(id, other.id) && Objects.equals(title, other.title);
	}

}
