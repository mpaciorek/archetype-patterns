package pl.inpost.archetypes.party.model.contactmechanism;

import jakarta.validation.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EmailAddress extends ElectronicAddress {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Override
	@Column(insertable=false, updatable=false)
	public String getAddress() {
		return super.getAddress();
	}	

}
