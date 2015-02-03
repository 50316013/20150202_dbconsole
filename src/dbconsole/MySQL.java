package dbconsole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

    // JDBCドライバの登録
    String driver;
    // データベースの指定
    String server, dbname, url, user, password;
    Connection con;
    Statement stmt;
    ResultSet rs;
	public MySQL() {

		 this.driver  = "org.gjt.mm.mysql.Driver";

		        this.server  = "j11000.sangi01.net";      // MySQLサーバ ( IP または ホスト名 );

		        this.dbname  = "javaapplication";         // データベース名;

		        this.url = "jdbc:mysql://" + server + "/" + dbname + "?useUnicode=true&characterEncoding=UTF-8";

		        this.user = "javaapplication";         // データベース作成ユーザ名;

		        this.password  = "javaapplication";     // データベース作成ユーザパスワード;


		try {
			this.stmt =con.createStatement ();
			this.con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

      public void close(){

   
   try {
	stmt.close();
	rs.close();
	 con.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  


      }
      
      public ResultSet selectAll(){

       String sql = "SELECT * FROM scores";
       ResultSet rs = null;
       try {
		rs = stmt.executeQuery (sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       return rs;


      }

}
