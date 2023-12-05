package Services;

import Entities.User;
import Utils.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServiceUser implements IService<User>{
    private Connection con = DataSource.getInstance().getCon();
    private Statement ste;

    public ServiceUser() {
        try {
            ste = con.createStatement();
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void add(User u) throws SQLException {
        String sql = "INSERT INTO User (id, firstName , lastName, email , pwd) VALUES (NULL, '"+u.getFirstName()+"', '"+u.getLastName()+"', '"+u.getEmail()+"', '"+u.getPwd()+"');  ";
        ste.executeUpdate(sql);
        System.out.println("User Ajouté !");
    }

    @Override
    public void update(User u) throws SQLException {
        String sql = "UPDATE User SET `firstName` = '"+u.getFirstName()+ "', `lastName` = '" +u.getLastName()+"', `Email` = '"+u.getEmail()+"', `pwd` = '"+ u.getPwd()+"' WHERE `id` = "+u.getId();
        ste.executeUpdate(sql);
        System.out.println("User mise à jour !");
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM `User` WHERE `id` = " + id;
        ste.executeUpdate(sql);
        System.out.println("User supprimé !");
    }

    @Override
    public ArrayList<User> readAll() throws SQLException {
        ArrayList<User> list = new ArrayList<>();
        try {
            String sql2 = "SELECT * FROM `User`;";
            ResultSet res = ste.executeQuery(sql2);

            while (res.next()) {
                long id = (res.getLong(1));
                String firstName = (res.getString(2));
                String lastName = (res.getString(3));
                String email = (res.getString(4));
                String pwd  = (res.getString(5));

                User u = new User((int) id,firstName,lastName,email,pwd);
                list.add(u);
            }
        }
        catch(SQLException ex) {
            System.out.println(ex);
        }

        return list;    }

    @Override
    public User get(int id) throws SQLException {
        String sql = "SELECT * FROM `User` WHERE `id` = " + id;
        ResultSet res = ste.executeQuery(sql);
        if (res.next()) {
            String firstName = res.getString("firstName");
            String lastName = res.getString("lastName");
            String email = res.getString("email");
            String pwd = res.getString("pwd");
            return new User(id, firstName, lastName, email, pwd);
        }
        return null;    }
}
