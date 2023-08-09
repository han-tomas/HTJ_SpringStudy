package com.sist.temp;
import java.util.*;
import java.sql.*;
/*
MNO     int
CNO     int
TITLE      VARCHAR(500)
SINGER      VARCHAR(500)
ALBUM    VARCHAR(500)
POSTER       VARCHAR(260)
IDCREMENT    int
STATE  VARCHAR(20)
KEY  VARCHAR(30)
*/
public class MusicDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public MusicDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	public void musicInsert(Music vo)
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
			String sql = "INSERT INTO genie_music "
					+ "VALUES((SELECT NVL(MAX(mno)+1,1) FROM genie_music),"
					+ "?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vo.getCno());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getSinger());
			ps.setString(4, vo.getAlbum());
			ps.setString(5, vo.getPoster());
			ps.setInt(6, vo.getIdcrement());
			ps.setString(7, vo.getState());
			ps.setString(8, vo.getKey());
			
			ps.executeUpdate();
		}catch(Exception ex)
		{
			
		}
		finally
		{
			try
			{
				if(ps!=null) ps.close();
				if(conn!=null)conn.close();
			}catch(Exception ex) {}
		}
	}
}
