package dancers;
/**
 * Test class
 * @author <a href='http://www.facebook.com/InQuirerDj'>Habib Mohammad</a>
 */
public class Test {
	static Dancers dcs = new Dancers();
	public static void main(String[] args) {
		IDancer a = new IDancer() {
			@Override public boolean isMale() {return false;}
			@Override public int getID() {return 1;}
			@Override public int getHeight() {return 1;}
		};
		IDancer b = new IDancer() {
			@Override public boolean isMale() {return false;}
			@Override public int getID() {return 2;}
			@Override public int getHeight() {return 2;}
		};
		IDancer c = new IDancer() {
			@Override public boolean isMale() {return true;}
			@Override public int getID() {return 3;}
			@Override public int getHeight() {return 3;}
		};
		IDancer d = new IDancer() {
			@Override public boolean isMale() {return false;}
			@Override public int getID() {return 4;}
			@Override public int getHeight() {return 4;}
		};
		IDancer e = new IDancer() {
			@Override public boolean isMale() {return true;}
			@Override public int getID() {return 5;}
			@Override public int getHeight() {return 5;}
		};
		IDancer f = new IDancer() {
			@Override public boolean isMale() {return true;}
			@Override public int getID() {return 6;}
			@Override public int getHeight() {return 6;}
		};
		IDancer g = new IDancer() {
			@Override public boolean isMale() {return false;}
			@Override public int getID() {return 7;}
			@Override public int getHeight() {return 7;}
		};
		IDancer h = new IDancer() {
			@Override public boolean isMale() {return true;}
			@Override public int getID() {return 8;}
			@Override public int getHeight() {return 8;}
		};
		IDancer i = new IDancer() {
			@Override public boolean isMale() {return true;}
			@Override public int getID() {return 9;}
			@Override public int getHeight() {return 9;}
		};
		IDancer k = new IDancer() {
			@Override public boolean isMale() {return false;}
			@Override public int getID() {return 10;}
			@Override public int getHeight() {return 10;}
		};
		IDancer l = new IDancer() {
			@Override public boolean isMale() {return true;}
			@Override public int getID() {return 11;}
			@Override public int getHeight() {return 11;}
		};
		IDancer m = new IDancer() {
			@Override public boolean isMale() {return false;}
			@Override public int getID() {return 12;}
			@Override public int getHeight() {return 12;}
		};
		IDancer n = new IDancer() {
			@Override public boolean isMale() {return true;}
			@Override public int getID() {return 13;}
			@Override public int getHeight() {return 13;}
		};
		IDancer o = new IDancer() {
			@Override public boolean isMale() {return true;}
			@Override public int getID() {return 14;}
			@Override public int getHeight() {return 14;}
		};
		IDancer p = new IDancer() {
			@Override public boolean isMale() {return true;}
			@Override public int getID() {return 15;}
			@Override public int getHeight() {return 15;}
		};
		IDancer q = new IDancer() {
			@Override public boolean isMale() {return false;}
			@Override public int getID() {return 16;}
			@Override public int getHeight() {return 16;}
		};
		
		insert(a,b,c,d,e,f,g,h,i,k,l,m,n,o,p,q);
//		insert(d,k,e,n,p,f,g,a,q,m,l,b,i,o,c,h);
		System.out.print("\nLeft in list:\t");
		for (IDancer dancer : dcs.returnWaitingList())
			System.out.print(dancer.getHeight() + " ");
	}
	static void insert(IDancer...dancers) {
		for (IDancer d : dancers)
			System.out.print(d.getHeight() + " ");
		System.out.println();
		for (IDancer d : dancers)
			System.out.print(d.getID() + (d.isMale() ? "M " : "F "));
		System.out.println();
		for (IDancer d : dancers)
			dcs.findPartnerFor(d);
	}
}
