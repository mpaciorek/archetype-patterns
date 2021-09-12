package pl.crater.archetypes.party.repositories;

import pl.crater.archetypes.core.repository.Repository;
import pl.crater.archetypes.party.model.relationship.CustomerRelationship;
import pl.crater.archetypes.party.model.relationship.PartyRelationship;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RelationshipRepository extends Repository<PartyRelationship, UUID> {

	public List<CustomerRelationship> findAllCustomersRelationships(Optional<Integer> startPosition,
                                                                    Optional<Integer> maxResult);

}
