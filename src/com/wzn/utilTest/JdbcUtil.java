package com.wzn.utilTest;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PWD = "123456";

    static{
        try {
            new com.mysql.jdbc.Driver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //建立连接
    public static Connection getConnection(){
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL,USER,PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭连接
    public static void close(ResultSet rs, PreparedStatement pstm, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static int executeUpdate(String sql, Object... objects) {
        int a = 0;
        Connection conn = null;
        PreparedStatement pstm = null;
        conn = getConnection();
        try {
            pstm = conn.prepareStatement(sql);
            if (objects != null) {
                for (int i = 0; i < objects.length; i++) {
                    pstm.setObject(i + 1, objects[i]);
                }
            }
            a = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, pstm, conn);
        }
        return a;
    }

    public static<T> List<T> executQuery(String sql,RowMap<T> rm ,Object... objects) {
        List<T> lists=new ArrayList();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs=null;
        try {
            conn=getConnection();
            pstm= conn.prepareStatement(sql);
            if(objects!=null){
                for(int i=0;i<objects.length;i++){
                    pstm.setObject(i+1,objects[i]);
                }
            }
            rs= pstm.executeQuery();

            while(rs.next()){
                T t= rm.rowMapping(rs);
                lists.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rs,pstm,conn);
        }
        return lists;
    }
    public static <T> T queryOne(String sql,RowMap<T> rm, Object... obj){ //范型
        T t = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        conn = getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            if(obj != null){
                for(int i=0; i<obj.length; i++){
                    pstmt.setObject(i+1,obj[i]);
                }
            }
            rs = pstmt.executeQuery();
            while(rs.next()){
                t = rm.rowMapping(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rs, pstmt, conn);//关闭通道
        }
        return t;
    }
}