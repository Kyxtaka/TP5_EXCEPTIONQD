class UIWeekEnd {    
    public static void main(String[] args) {
	WeekEnd leWeekEnd = new WeekEnd();
	AppWeekEnd app = new AppWeekEnd(leWeekEnd);
	app.run();
    }
}
    
class AppWeekEnd {
	WeekEnd we;
	boolean quitter;

	AppWeekEnd(WeekEnd we) {
		this.we = we;
		this.quitter = false;
	}

	public void run() {
		bienvenue();
		boolean continuer = true;
		while(!quitter) {
			menu();
		}	
		au_revoir();
	}

    public void menu() {
		boolean commande_faite = false;
		while(!commande_faite) {
			System.out.println("Que voulez vous faire?");
			System.out.println("Q: quitter");
			String commande_brute = System.console().readLine();
			String commande = commande_brute.strip().toLowerCase();
			if(commande.equals("q")) {
				quitter = true;
				commande_faite = true;
			}else if(commande.equals("p")) {
				System.out.println(we.getAmis());
				commande_faite = true;
			}else if(commande.equals("d")){
				System.out.println(we.getDepenses());
				commande_faite = true;
			}else if(commande.equals("t")) {
				System.out.println(we.totalDepenses());
				commande_faite = true;
			}else if(commande.equals("m")) {
				System.out.println(we.depensesMoyenne());
				commande_faite = true;
			}
			else {
				System.out.println("Commande '" + commande_brute + "' invalide.");
			}
		}
    }

    /// Affiche un message de bienvenue
    public void bienvenue() {
		System.out.println("╭────────────────────────────────────────────────────────────────────────────────────╮");
		System.out.println("│ Bienvenue! En week-end comme dans la semaine, les bons comptes font les bons amis. │");
		System.out.println("╰────────────────────────────────────────────────────────────────────────────────────╯");
    }

    /// Affiche un message d'au revoir
    public void au_revoir() {
        System.out.println("╭───────────╮");
        System.out.println("│ Au revoir!│");
        System.out.println("╰───────────╯");
    }

}
