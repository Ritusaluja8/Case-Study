package usecase;
import java.sql.*;
public class TrainDao {
	private static Connection con;
	private static String Driver_Name="com.mysql.cj.jdbc.Driver";
	private static String DB_URL="jdbc:mysql://localhost:3306/train";
	private static String USERNAME="root";
	private static String PASSWORD="Twinkle7@";
	static {
        try {
            Class.forName(Driver_Name);
            con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void TrainDAO() throws SQLException {
    }

    public static Statement createStatement() throws SQLException {
        return con.createStatement();
    }
    public static Train findTrain(int trainNum) throws SQLException {

        ResultSet rs = createStatement().executeQuery("select * from trains where train_no =" + trainNum);
        rs.next();
        return new Train(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
    }
}
	
	
	


