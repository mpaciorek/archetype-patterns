package pl.crater.archetypes.core.repository.specification;

public abstract class Composite<E> extends AbstractSpecification<E>{

	protected Specification<E> left;
	protected Specification<E> right;
	
	public Composite( Specification<E> left, Specification<E> right) {
		this.left = left;
		this.right = right;
	}

}
