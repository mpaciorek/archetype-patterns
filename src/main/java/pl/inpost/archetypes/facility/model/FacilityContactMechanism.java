package pl.inpost.archetypes.facility.model;

import pl.inpost.archetypes.fields.DateTimeRange;
import pl.inpost.archetypes.model.BasePersistentModel;
import pl.inpost.archetypes.party.model.contactmechanism.ContactMechanism;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Jim
 * @version 1.0
 * @created 25-Dec-2007 9:54:29 AM
 * @see "Data Model Resource Book Volume 1 Figure 2.11, page 59"
 */
@SuppressWarnings("serial")
@Entity
public class FacilityContactMechanism extends BasePersistentModel {

	//@NotNull
	@ManyToOne
	private Facility			mechansimToContact;

	//@NotNull
	@ManyToOne
	private ContactMechanism specifiedVia;

	@Embedded
	private DateTimeRange		dateTimeRange	= new DateTimeRange();

	
	public DateTimeRange getDateTimeRange() {
		return dateTimeRange;
	}

	public void setDateTimeRange(DateTimeRange dateTimeRange) {
		this.dateTimeRange = dateTimeRange;
	}

	
	public Facility getMechansimToContact() {
		return mechansimToContact;
	}

	
	public ContactMechanism getSpecifiedVia() {
		return specifiedVia;
	}

	public void setMechansimToContact(Facility mechansimToContact) {
		this.mechansimToContact = mechansimToContact;
	}

	public void setSpecifiedVia(ContactMechanism specifiedVia) {
		this.specifiedVia = specifiedVia;
	}

}