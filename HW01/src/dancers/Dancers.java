package dancers;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
/**
 * @author <a href='http://www.facebook.com/InQuirerDj'>Habib Mohammad</a>
 */
public class Dancers implements IDancers {
	public Tree tree = new Tree();
    @Override
    public SimpleEntry<IDancer, IDancer> findPartnerFor(IDancer d) throws IllegalArgumentException {
    	if (!(d instanceof IDancer) ||
			(d.getHeight() <= 0) ||
			(d.getID() <= 0)) throw new IllegalArgumentException();
    	IDancer partner = null;
    	tree.insert(d);
		try {partner = (d.isMale()) ? tree.female(d) : tree.male(d);
		} catch (NullPointerException n) {return null;}
    	if (partner != null) {
    		tree.remove(d);
    		tree.remove(partner);
    		System.err.println("Partner: "
		    		+ d.getID() 
		    		+ (d.isMale() ? "M " : "F ") 
		    		+ "	For: " 
		    		+ partner.getID() 
		    		+ (partner.isMale() ? "M " : "F "));
    		return new SimpleEntry<IDancer, IDancer>(d, partner);
    	} return null;
    }

    @Override
    public List<IDancer> returnWaitingList() {
    	try {return tree.inorder(tree.root, new ArrayList<IDancer>());
    	} catch(NullPointerException n) {return new ArrayList<IDancer>();}
    }
}