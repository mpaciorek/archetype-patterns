package pl.crater.archetypes.party.model.communication;

import pl.crater.archetypes.model.BasePersistentModel;
import pl.crater.archetypes.party.model.PartyContactMechanism;
import pl.crater.archetypes.party.model.relationship.PartyRelationship;
import jakarta.validation.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a communication between two or more parties.
 * 
 * @author Jim
 * @version 1.0
 * @created 25-Dec-2007 9:54:27 AM
 * @see "Data Model Resource Book Volume 1 Figure 2.7, Page 48"
 * @see "Data Model Resource Book Volume 1 Figure 2.12, page 60"
 * @see "Data Model Resource Book Volume 1 Figure 2.13, page 64"
 */
@SuppressWarnings("serial")
@Entity
public class CommunicationEvent extends BasePersistentModel {

	@ManyToMany
	private List<Case> asPartOf = new ArrayList<Case>();

	@OneToMany
	private List<CommunicationEventPurpose> categorizedBy = new ArrayList<CommunicationEventPurpose>();

	private ZonedDateTime dateTimeEnded;

	@NotNull
	private ZonedDateTime dateTimeStarted;

	@ManyToOne
	private PartyRelationship inTheContextOf;

	@OneToMany(mappedBy = "of", cascade = CascadeType.ALL)
	private List<CommunicationEventRole> involving = new ArrayList<CommunicationEventRole>();

	@ManyToOne
	private CommunicationEventStatusType monitoredBy;

	@NotEmpty
	@Lob
	private String note;

	@ManyToOne
	private PartyContactMechanism occursVia;

	public void addCommunicationEventRole(CommunicationEventRole communicationEventRole) {
		if (!getInvolving().contains(communicationEventRole)) {
			getInvolving().add(communicationEventRole);
			communicationEventRole.setOf(this);
		}

	}

	/**
	 * @return the asPartOf
	 */
	public List<Case> getAsPartOf() {
		return asPartOf;
	}

	/**
	 * @return the categorizedBy
	 */
	public List<CommunicationEventPurpose> getCategorizedBy() {
		return categorizedBy;
	}

	/**
	 * @return the dateTimeEnded
	 */

	public ZonedDateTime getDateTimeEnded() {
		return dateTimeEnded;
	}

	/**
	 * @return the dateTimeStarted
	 */
	public ZonedDateTime getDateTimeStarted() {
		return dateTimeStarted;
	}

	/**
	 * @return the inTheContextOf
	 */
	public PartyRelationship getInTheContextOf() {
		return inTheContextOf;
	}

	/**
	 * @return the involving
	 */
	public List<CommunicationEventRole> getInvolving() {
		return involving;
	}

	/**
	 * @return the monitoredBy
	 */
	public CommunicationEventStatusType getMonitoredBy() {
		return monitoredBy;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @return the occursVia
	 */
	public PartyContactMechanism getOccursVia() {
		return occursVia;
	}

	@Transient
	@AssertTrue
	public boolean isRangeValid() {
		if (dateTimeEnded != null) {
			return true;
		} else {
			return dateTimeEnded.isAfter(dateTimeStarted);
		}
	}

	/**
	 * @param asPartOf
	 *            the asPartOf to set
	 */
	public void setAsPartOf(List<Case> asPartOf) {
		this.asPartOf = asPartOf;
	}

	/**
	 * @param categorizedBy
	 *            the categorizedBy to set
	 */
	public void setCategorizedBy(List<CommunicationEventPurpose> categorizedBy) {
		this.categorizedBy = categorizedBy;
	}

	/**
	 * @param dateTimeEnded
	 *            the dateTimeEnded to set
	 */
	public void setDateTimeEnded(ZonedDateTime dateTimeEnded) {
		this.dateTimeEnded = dateTimeEnded;
	}

	/**
	 * @param dateTimeStarted
	 *            the dateTimeStarted to set
	 */
	public void setDateTimeStarted(ZonedDateTime dateTimeStarted) {
		this.dateTimeStarted = dateTimeStarted;
	}

	/**
	 * @param inTheContextOf
	 *            the inTheContextOf to set
	 */
	public void setInTheContextOf(PartyRelationship inTheContextOf) {
		this.inTheContextOf = inTheContextOf;
	}

	/**
	 * @param involving
	 *            the involving to set
	 */
	public void setInvolving(List<CommunicationEventRole> involving) {
		this.involving = involving;
	}

	/**
	 * @param monitoredBy
	 *            the monitoredBy to set
	 */
	public void setMonitoredBy(CommunicationEventStatusType monitoredBy) {
		this.monitoredBy = monitoredBy;
	}

	// public void addCase(Case newCase) {
	// getAsPartOf().add(newCase);
	// newCase.getEncompassing().add(this);
	// }

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @param occursVia
	 *            the occursVia to set
	 */
	public void setOccursVia(PartyContactMechanism occursVia) {
		this.occursVia = occursVia;
	}
}