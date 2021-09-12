package pl.crater.archetypes.party.repositories.implementation;

import pl.crater.archetypes.core.repository.RepositoryTemplate;
import pl.crater.archetypes.party.model.Party;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.UUID;

public class PartyRepository extends RepositoryTemplate<Party, UUID> implements pl.crater.archetypes.party.repositories.PartyRepository {

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
