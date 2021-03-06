package pl.crater.archetypes.model;

import jakarta.validation.constraints.NotEmpty;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * There are a lot of user definable type, this is the base class for them all.
 * 
 * @author Jim Barrows
 * 
 */
@MappedSuperclass
public class BaseType extends BasePersistentModel {

	@NotEmpty
	@Column(nullable = false)
	protected String	description;

	public BaseType(UUID id, Long version, String description) {
		super(id, version);
		this.description = description;
	}

	public BaseType(String description) {
		super();
		this.description = description;
	}

	public BaseType() {
		super();
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "BaseType [description=" + description + ", id=" + getId() + ", version=" + getVersion() + "]";
	}

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
}
