import Entities.Journal;
import Services.ServiceJournal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    static String url = "jdbc:mysql://localhost:3306/journey_wise";
    static String user = "root";
    static String pwd = "";
    static Connection con;
    private static Statement ste;

    public static void main(String[] args) {
        try {
            con = DriverManager.getConnection(url, user, pwd);
            System.out.println(con);
            System.out.println("Connexion établie");

        /*try {
            ste = con.createStatement();
            String requete = "insert into Journal values (NULL, 'Offre2', 'Pays2', 'Titre2', 'Description2', '../../assets/images/R2.jpg\', 2)";
            int res = ste.executeUpdate(requete);
            System.out.println("Journal ajouté avec succès et " + res + " nombre de ligne ajouté avec succès");

        } catch (SQLException e) {
            System.out.println(e);
        }

        try {
            ResultSet resultSet = ste.executeQuery("select * from journal");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String offreVoyage = resultSet.getString(("offreVoyage"));
                String paysVoyager = resultSet.getString("paysVoyager");
                String titre = resultSet.getString("titre");
                String descrption = resultSet.getString("descrption");
                String url_image = resultSet.getString("url_image");
                int id_user = resultSet.getInt("id_user");

                System.out.println("id : " + id);
                System.out.println("offre de Voyage : " + offreVoyage);
                System.out.println("pays Voyager : " + paysVoyager);
                System.out.println("titre : " + titre);
                System.out.println("descrption : " + descrption);
                System.out.println("url image : " + url_image);
                System.out.println("id_user : " + id_user);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }*/
            ServiceJournal serviceJournal = new ServiceJournal();

            try {
                // Ajouter un journal
                Journal journalToAdd = new Journal("OffreTest", "PaysTest", "TitreTest", "DescriptionTest", "../../assets/images/R2.jpg", 1);
                serviceJournal.add(journalToAdd);
                System.out.println("Journal ajouté avec succès");

                // Lire tous les journaux
                ArrayList<Journal> allJournals = serviceJournal.readAll();
                System.out.println("Liste de tous les journaux :");
                for (Journal journal : allJournals) {
                    System.out.println(journal);
                }

                // Mettre à jour un journal
                int journalIdToUpdate = 1;
                Journal journalToUpdate = serviceJournal.get(journalIdToUpdate);
                if (journalToUpdate != null) {
                    journalToUpdate.setOffreVoyage("NouvelleOffreTest");
                    serviceJournal.update(journalToUpdate);
                    System.out.println("Journal mis à jour avec succès");
                } else {
                    System.out.println("Journal non trouvé pour la mise à jour");
                }

                // Supprimer un journal
                int journalIdToDelete = 2;
                serviceJournal.delete(journalIdToDelete);
                System.out.println("Journal supprimé avec succès");
            } catch (SQLException e) {
                System.out.println(e);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Connexion fermée");
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
