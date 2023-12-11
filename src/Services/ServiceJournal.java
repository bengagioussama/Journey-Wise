package Services;

import Entities.Journal;
import Utils.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServiceJournal implements IService<Journal> {
    private Connection connection = DataSource.getInstance().getCon();
    private Statement statement;

    public ServiceJournal() {
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void add(Journal journal) throws SQLException {
        String query = "INSERT INTO journal VALUES (NULL, '"
                + journal.getOffreVoyage() + "', '"
                + journal.getPaysVoyager() + "', '"
                + journal.getTitre() + "', '"
                + journal.getDescrption() + "', '"
                + journal.getUrl_image() + "', "
                + journal.getId_user() + ")";
        int res = statement.executeUpdate(query);
        System.out.println("Nombre de tuples de journal ajoutés : " + res);
    }


    @Override
    public void update(Journal journal) throws SQLException {
        String query = "UPDATE journal SET " +
                "offreVoyage = '" + journal.getOffreVoyage() + "', " +
                "paysVoyager = '" + journal.getPaysVoyager() + "', " +
                "titre = '" + journal.getTitre() + "', " +
                "descrption = '" + journal.getDescrption() + "', " +
                "url_image = '" + journal.getUrl_image() + "', " +
                "id_user = " + journal.getId_user() +
                " WHERE id = " + journal.getId();

        int res = statement.executeUpdate(query);
        System.out.println("Nombre de tuples de journal modifiés : " + res);
    }



    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM journal WHERE id = " + id;
        int res = statement.executeUpdate(query);
        System.out.println("Nombre de tuples de journal supprimés : " + res);
    }

    @Override
    public ArrayList<Journal> readAll() throws SQLException {
        ArrayList<Journal> journals = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM journal");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String offreVoyage = resultSet.getString(2);
                String paysVoyager = resultSet.getString(3);
                String titre = resultSet.getString(4);
                String descrption = resultSet.getString(5);
                String url_image = resultSet.getString(6);
                int id_user = resultSet.getInt(7);

                journals.add(new Journal(id, offreVoyage, paysVoyager, titre, descrption, url_image, id_user));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return journals;
    }

    @Override
    public Journal get(int id) throws SQLException {
        String query = "SELECT * FROM journal WHERE id = " + id;
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            int journalId = resultSet.getInt(1);
            String offreVoyage = resultSet.getString(2);
            String paysVoyager = resultSet.getString(3);
            String titre = resultSet.getString(4);
            String descrption = resultSet.getString(5);
            String url_image = resultSet.getString(6);
            int id_user = resultSet.getInt(7);

            return new Journal(journalId, offreVoyage, paysVoyager, titre, descrption, url_image, id_user);
        }

        return null;
    }

}
