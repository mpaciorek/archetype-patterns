package pl.inpost.archetypes.party.repositories;

import pl.inpost.archetypes.core.repository.Repository;
import pl.inpost.archetypes.party.model.relationship.CustomerRelationship;
import pl.inpost.archetypes.party.model.relationship.PartyRelationship;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RelationshipRepository extends Repository<PartyRelationship, UUID>{

	public List<CustomerRelationship> findAllCustomersRelationships(Optional<Integer> startPosition,
			Optional<Integer> maxResult);

}
