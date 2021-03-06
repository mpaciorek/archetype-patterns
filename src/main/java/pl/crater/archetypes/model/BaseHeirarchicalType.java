package pl.crater.archetypes.model;

import org.apache.commons.lang3.builder.EqualsBuilder;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Some types might need children, and all children are considered to be the same type as the parent.
 * 
 * @author jimbarrows
 */
@MappedSuperclass
public class BaseHeirarchicalType extends BaseType {

	@ManyToOne
	private BaseHeirarchicalType				parent;

	@OneToMany(mappedBy = "parent")
	private List<BaseHeirarchicalType>	children	= new ArrayList<BaseHeirarchicalType>();

	public BaseHeirarchicalType() {
		super();
	}

	public BaseHeirarchicalType(UUID id, Long version, String description) {
		super(id, version, description);
	}

	public BaseHeirarchicalType(UUID id, Long version, String description, BaseHeirarchicalType parent, List<BaseHeirarchicalType> children) {
		super(id, version, description);
		this.parent = parent;
		this.children = children;
	}

	/**
	 * Two heirarchies should only be the same if they are the same type. Base classes should provide a public version, the ensures the same type.
	 * 
	 * @param right
	 * @return
	 */
	public boolean isA(BaseHeirarchicalType right) {
		if (parent == null && right.getParent() == null) {
			return true;
		} else {
			return new EqualsBuilder().append(parent, right.parent).isEquals() && ((parent == null) ? false : parent.isA(right.getParent()));
		}
	}

	public BaseHeirarchicalType getParent() {
		return parent;
	}

	public List<BaseHeirarchicalType> getChildren() {
		return children;
	}

	public void setParent(BaseHeirarchicalType parent) {
		this.parent = parent;
	}

	public void setChildren(List<BaseHeirarchicalType> children) {
		this.children = children;
	}

	private static final long	serialVersionUID	= 1L;

	public void addChild(BaseHeirarchicalType child) {
		child.setParent(this);
		children.add(child);

	}

}
