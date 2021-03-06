package pl.crater.archetypes.party.specifications;

import pl.crater.archetypes.core.repository.specification.AbstractSpecification;
import pl.crater.archetypes.party.model.relationship.CustomerRelationship;
import pl.crater.archetypes.party.model.roles.Customer;
import pl.crater.archetypes.party.model.Party;

/**
 * A party has an active customer relationship with a vendor, if the customer
 * has an active customer role, that has a customer relationship with the
 * vendor, in the vendor's internal organization role. This is the path from
 * possibleCustomer party to the vendor party: possibleCustomer -> has active
 * Customer -> has an active CustomerRelationship -> InternalOrganization ->
 * Vendor.
 * 
 * @author Jim
 *
 */
public class HasActiveCustomerRelationshipWith extends AbstractSpecification<Party> {

	private Party vendor;

	public HasActiveCustomerRelationshipWith(Party vendor) {
		this.vendor = vendor;
	}

	@Override
	public boolean isSatisfiedBy(Party possibleCustomer) {
		return possibleCustomer.getActingAs().stream()
				.anyMatch(partyRole -> (partyRole instanceof Customer) && partyRole.getDateTimeRange().isActive()
						&& partyRole.getRelationshipsInvolvedIn().stream()
								.anyMatch(relationship -> (relationship instanceof CustomerRelationship)
										&& relationship.getDateTimeRange().isActive()
										&& ((CustomerRelationship) relationship).getRelationshipFrom()
												.getDateTimeRange().isActive()
								&& ((CustomerRelationship) relationship).getRelationshipFrom().getRoleFor()
										.equals(vendor)));
	}

	public static final HasActiveCustomerRelationshipWith hasActiveCustomerRelationshipWith(Party vendor) {
		return new HasActiveCustomerRelationshipWith(vendor);
	}
}
