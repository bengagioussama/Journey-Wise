package Services;

import Entities.Reservation;
import Utils.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ServiceReservation implements IService<Reservation> {
    private Connection connection= DataSource.getInstance().getCon();
    private Statement statement;
    public ServiceReservation(){
        try {
            statement= connection.createStatement();
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
    @Override
    public void add(Reservation reservation) throws SQLException {
        String query = "insert into reservations values(NULL," + "reservation.getDateDebut" +
                "," +
                "reservation.getDateFin" +
                "," +
                "reservation.getNombrePassages" +
                "," +
                "reservation.getId_offre" +
                "," +
                "reservation.getId_membre" +
                ")";
        int res = statement.executeUpdate(query);
        System.out.println("nombre de tuple ajoutés: "+res);
    }

    @Override
    public void update(Reservation t) throws SQLException {
        if (get(t.getId())!=null){
            String query = "update into reservations values(NULL," + "t.getDateDebut" +
                    "," +
                    "t.getDateFin" +
                    "," +
                    "t.getNombrePassages" +
                    "," +
                    "t.getId_offre" +
                    "," +
                    "t.getId_membre" +
                    ")where id="+t.getId();
            int res = statement.executeUpdate(query);
            System.out.println("nombre de tuple Modifier: "+res);
        }
        else {
            throw new SQLException("resvation intruvalbe");
        }
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public ArrayList<Reservation> readAll() throws SQLException {
        ArrayList<Reservation>reservations = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("select * from reservations");
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                Date dateDebut = resultSet.getDate(2);
                Date dateFin= resultSet.getDate(3);
                int nombrePassages = resultSet.getInt(4);
                int id_offre=resultSet.getInt(5);
                int id_membre=resultSet.getInt(6);
                reservations.add(new Reservation(id,dateDebut,dateFin,nombrePassages,id_offre,id_membre));
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
        return null;
    }
    public ArrayList<Reservation> readAllById(int idM) throws SQLException {
        ArrayList<Reservation>reservations = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("select * from reservations where id_membre="+idM);
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                Date dateDebut = resultSet.getDate(2);
                Date dateFin= resultSet.getDate(3);
                int nombrePassages = resultSet.getInt(4);
                int id_offre=resultSet.getInt(5);
                int id_membre=resultSet.getInt(6);
                reservations.add(new Reservation(id,dateDebut,dateFin,nombrePassages,id_offre,id_membre));
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
        return null;
    }

    @Override
    public Reservation get(int idR) throws SQLException {
        try {
            ResultSet resultSet = statement.executeQuery("select * from reservations where id_membre="+idR);
            int id=resultSet.getInt(1);
            Date dateDebut = resultSet.getDate(2);
            Date dateFin= resultSet.getDate(3);
            int nombrePassages = resultSet.getInt(4);
            Offre offre=resultSet.getInt(5); // a refaire
            User user=resultSet.getInt(6); // a refaire
            return new Reservation(id,dateDebut,dateFin,nombrePassages,offre,user);
        }catch (SQLException ex){
            System.out.println(ex);
        }
        return null;
    }
}
