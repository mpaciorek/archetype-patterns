package pl.crater.archetypes.party.model;

import pl.crater.archetypes.fields.DateTimeRange;
import pl.crater.archetypes.model.BasePersistentModel;
import pl.crater.archetypes.party.model.contactmechanism.PostalAddress;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.xml.crypto.Data;

/**
 * Association class between Party and PostalAddress classes, since these could
 * be a many to many relationship, and we might need/want to track address
 * history.
 * 
 * @author Jim
 * @version 1.0
 * @created 25-Dec-2007 9:54:33 AM
 * @see Data Model Resource Book Volume 1 Figure 2.8, page 50
 */
@SuppressWarnings("serial")
@Entity
public class PartyPostalAddress extends BasePersistentModel {

	@Lob
	private String			comment;

	@ManyToOne
	private PostalAddress locatedAt;

	@ManyToOne
	private Party			specifiedFor;

	@Embedded
	private DateTimeRange dateTimeRange	= new DateTimeRange();

	
	public DateTimeRange getDateTimeRange() {
		return dateTimeRange;
	}

	public void setDateTimeRange(DateTimeRange dateTimeRange) {
		this.dateTimeRange = dateTimeRange;
	}
	
	public String getComment() {
		return comment;
	}

	public PostalAddress getLocatedAt() {
		return locatedAt;
	}

	public Party getSpecifiedFor() {
		return specifiedFor;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setLocatedAt(PostalAddress locatedAt) {
		this.locatedAt = locatedAt;
	}

	public void setSpecifiedFor(Party specifiedFor) {
		this.specifiedFor = specifiedFor;
	}

}