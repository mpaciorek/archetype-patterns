package pl.crater.archetypes.party.model.communication;

import pl.crater.archetypes.model.BasePersistentModel;
import pl.crater.archetypes.fields.DateTimeRange;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class CommunicationEventPurpose extends BasePersistentModel {

	private static final long				serialVersionUID	= 1L;

	@NotNull
	@ManyToOne
	private CommunicationEventPurposeType	type;

	@Embedded
	private DateTimeRange					dateTimeRange		= new DateTimeRange();

	
	public DateTimeRange getDateTimeRange() {
		return dateTimeRange;
	}

	public void setDateTimeRange(DateTimeRange dateTimeRange) {
		this.dateTimeRange = dateTimeRange;
	}

	
	public CommunicationEventPurposeType getType() {
		return type;
	}

	public void setType(CommunicationEventPurposeType type) {
		this.type = type;
	}
}
