package pl.inpost.archetypes.party.model.relationship;

import pl.inpost.archetypes.party.model.PartyRole;

import javax.persistence.Entity;

@Entity
public class VisitorIsp extends PartyRelationship {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public PartyRole getRelationshipFrom() {
		return (PartyRole)super.getRelationshipFrom();
	}

	@Override
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
