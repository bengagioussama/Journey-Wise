import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        try {
            ste = con.createStatement();
            String requete = "insert into Journal values (NULL, 'Offre2', 'Pays2', 'Titre2', 'Description2', 2)";
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
                int id_user = resultSet.getInt("id_user");

                System.out.println("id : " + id);
                System.out.println("offre de Voyage : " + offreVoyage);
                System.out.println("pays Voyager : " + paysVoyager);
                System.out.println("titre : " + titre);
                System.out.println("descrption : " + descrption);
                System.out.println("id_user : " + id_user);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
