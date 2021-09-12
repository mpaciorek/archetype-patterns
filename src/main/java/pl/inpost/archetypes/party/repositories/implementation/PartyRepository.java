package pl.inpost.archetypes.party.repositories.implementation;

import pl.inpost.archetypes.core.repository.RepositoryTemplate;
import pl.inpost.archetypes.party.model.Party;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.UUID;

public class PartyRepository extends RepositoryTemplate<Party, UUID> implements pl.inpost.archetypes.party.repositories.PartyRepository {

	@PersistenceContext(name = "PeopleAndOrganizations", type=PersistenceContextType.EXTENDED)
	protected EntityManager em;
	
	public PartyRepository() {
		super(Party.class); 
	}

	@Override
	protected EntityManager entityManager() {
		return em;
	}
	
}
