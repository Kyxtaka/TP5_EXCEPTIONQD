import java.util.ArrayList;
import java.util.List; 
class Personne{
    private String nom;
    private String prenom;
    public Personne( String n, String p) {this.nom = n; this.prenom = p;}
    public String toString() {return this.prenom + " " + this.nom + " ";  }
    public String getNom() {return this.nom;}
    public String getPrenom() {return this.prenom;}
}
class Depense{
    private Personne pers;
    private double montant; 
    private String produit;
    public Depense(Personne p, double mont, String prod ){
	this.pers = p; this.montant = mont; this.produit = prod;
    }
    public Personne getPersonne() {return this.pers;}
    public double getMontant() {return this.montant;}
    public String getProduit() {return this.produit;}
}

class WeekEnd{
    private List<Personne> listeAmis;
    private List<Depense> listeDepenses;

    public WeekEnd(){
		this.listeAmis = new ArrayList<>();
		this.listeDepenses = new ArrayList<>();
    }
	
    public List<Personne> getAmis() {
		return this.listeAmis;
    }

    public List<Depense> getDepenses() {
		return this.listeDepenses;
    }
    
    public void ajouterPersonne(Personne p){this.listeAmis.add(p);}
    
	public void ajouterDepense(Depense d){this.listeDepenses.add(d); }
    
	// totalDepensesPersonne prend en entrée une personne et renvoie la somme des depenses de cette personne.
    public double totalDepensesPersonne(Personne p){
		double s = 0.0;
		for(Depense d : this.listeDepenses) {
			if((p.getNom()).equals(d.getPersonne().getNom()))
			s += d.getMontant();
		}
		return s;
    }

    // totalDepenses renvoie la somme de toutes les dépenses. 
    public double totalDepenses(){
		double s = 0.0; 
		for(Depense d : this.listeDepenses) 
			s += d.getMontant();
		return s;
    }

    // depensesMoyenne renvoie la moyenne des dépenses pour une personne 
    public double depensesMoyenne(){
		double s = totalDepenses(); 
		int nb = this.listeAmis.size(); 
		if(nb != 0) 
			return s/nb;
		else 
			return s; 
    }

    //depenseProduit prend en entrée un produit, et renvoie la somme des dépenses pour ce produit. (par exemple du pain peut avoir été acheté plusieurs fois..)
    public double depenseProduit(String p){
		double s = 0.0; 
		for(Depense d : this.listeDepenses) 
			if (p.equals(d.getProduit()))
			s+= d.getMontant();
		return s;
    } 

    // avoirPersonne prend en entrée une personne et renvoie l'avoir de cette personne pour le week end.
    public double avoirPersonne(Personne p){
		double m = depensesMoyenne(); 
		double avoir = m - totalDepensesPersonne(p); 
		return avoir; 
    }
}

class Executable {
    public static void main(String [] args) {
	Personne pierre = new Personne("Durand","Pierre"); 
	System.out.println(pierre.getNom()); 
	Personne paul = new Personne("Dupond","Paul"); 
	Personne marie = new Personne("Dumond","Marie");
	Personne anne = new Personne("Dunon","Anne");  
	Depense d1 = new Depense(pierre, 12, "pain"); 	
	Depense d2 = new Depense(paul, 100, "pizza"); 
	Depense d3 = new Depense(pierre, 70, "essence");
	Depense d4 = new Depense(marie, 15, "vin");  
	Depense d5 = new Depense(paul, 10, "vin"); 
	WeekEnd we = new WeekEnd();  
	we.ajouterPersonne(pierre); 
	we.ajouterPersonne(paul);
	we.ajouterPersonne(marie);
	we.ajouterPersonne(anne); 
	we.ajouterDepense(d1);   
	we.ajouterDepense(d2); 
	we.ajouterDepense(d4);   
	we.ajouterDepense(d3);
	we.ajouterDepense(d5);
	System.out.println("total des dépenses "+we.totalDepenses()) ;
	System.out.println("moyenne des dépenses "+we.depensesMoyenne()) ;
	System.out.println("total des dépenses de Pierre "+ we.totalDepensesPersonne(pierre)) ;
	System.out.println("total des dépenses de Paul "+ we.totalDepensesPersonne(paul)) ;
	System.out.println("total des dépenses de Marie "+ we.totalDepensesPersonne(marie)) ;
	System.out.println("total des dépenses de Anne "+ we.totalDepensesPersonne(anne)) ;
	System.out.println("depenses vin "+we.depenseProduit("vin"));
	System.out.println("avoir de pierre "+we.avoirPersonne(pierre));
	System.out.println("avoir de paul "+we.avoirPersonne(paul));	
	System.out.println("avoir de marie "+we.avoirPersonne(marie));
    }
}
