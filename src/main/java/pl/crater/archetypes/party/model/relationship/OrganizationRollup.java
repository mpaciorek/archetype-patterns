package pl.crater.archetypes.party.model.relationship;

import pl.crater.archetypes.party.model.PartyRole;

import javax.persistence.Entity;


@Entity
public class OrganizationRollup extends PartyRelationship {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	public PartyRole getRelationshipFrom() {
		return (PartyRole)super.getRelationshipFrom();
	}

	public PartyRole getRelationshipTo() {
		return (PartyRole)super.getRelationshipTo();
	}


	public void setRelationshipFrom(PartyRole relationshipFrom) {
		super.setRelationshipFrom(relationshipFrom);
	}

	public void setRelationshipTo(PartyRole relationshipTo) {
		super.setRelationshipTo(relationshipTo);
	}
}
