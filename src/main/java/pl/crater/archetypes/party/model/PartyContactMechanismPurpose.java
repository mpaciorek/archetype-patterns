package pl.crater.archetypes.party.model;

import pl.crater.archetypes.fields.DateTimeRange;
import pl.crater.archetypes.model.BasePersistentModel;
import pl.crater.archetypes.party.model.contactmechanism.ContactMechanismPurposeType;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PartyContactMechanismPurpose extends BasePersistentModel {

	/**
	 * 
	 */
	private static final long			serialVersionUID	= 1L;

	@ManyToOne
	private ContactMechanismPurposeType definedVia;

	@ManyToOne
	private PartyContactMechanism		usedWithin;

	@Embedded
	private DateTimeRange dateTimeRange		= new DateTimeRange();

	
	public DateTimeRange getDateTimeRange() {
		return dateTimeRange;
	}

	public void setDateTimeRange(DateTimeRange dateTimeRange) {
		this.dateTimeRange = dateTimeRange;
	}

	
	public ContactMechanismPurposeType getDefinedVia() {
		return definedVia;
	}

	
	public PartyContactMechanism getUsedWithin() {
		return usedWithin;
	}

	public void setDefinedVia(ContactMechanismPurposeType definedVia) {
		this.definedVia = definedVia;
	}

	public void setUsedWithin(PartyContactMechanism usedWithin) {
		this.usedWithin = usedWithin;
	}
}
