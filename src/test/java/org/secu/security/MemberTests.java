package org.secu.security;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/applicationContext.xml",
        "file:src/main/webapp/WEB-INF/securityContext.xml"})
public class MemberTests {

    @Setter(onMethod_ = @Autowired)
    private PasswordEncoder passwordEncoder;

    @Setter(onMethod_ = @Autowired)
    private DataSource dataSource;

    @Test
    public void testInsertMember(){
        String sql = "insert into member(username, password, name) values (?,?,?)";
        for (int i = 0;i < 30;i++){
            Connection con = null;
            PreparedStatement pstmt = null;

            try {
                con = dataSource.getConnection();
                pstmt = con.prepareStatement(sql);

                pstmt.setString(2,passwordEncoder.encode("pw"+i));
                if (i <10){
                    pstmt.setString(1,"user"+i);
                    pstmt.setString(3,"user"+i);
                }else if (i <20){
                    pstmt.setString(1,"member"+i);
                    pstmt.setString(3,"member"+i);
                }else{
                    pstmt.setString(1,"user"+i);
                    pstmt.setString(3,"admin"+i);
                }
                pstmt.executeUpdate();

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if (pstmt != null){try { pstmt.close();}catch (Exception e){} }
                if (con != null){try { con.close();}catch (Exception e){} }
            }
        }//end for
    }
    @Test
    public void testInsertAuth(){
        String sql = "insert into member_auth(username, auth) values (?,?)";
        for (int i = 0;i < 30;i++){
            Connection con = null;
            PreparedStatement pstmt = null;

            try {
                con = dataSource.getConnection();
                pstmt = con.prepareStatement(sql);

                if (i <10){
                    pstmt.setString(1,"user"+i);
                    pstmt.setString(2,"ROLE_USER");
                }else if (i <20){
                    pstmt.setString(1,"member"+i);
                    pstmt.setString(2,"ROLE_MEMBER");
                }else{
                    pstmt.setString(1,"user"+i);
                    pstmt.setString(2,"ROLE_ADMIN");
                }
                pstmt.executeUpdate();

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if (pstmt != null){try { pstmt.close();}catch (Exception e){} }
                if (con != null){try { con.close();}catch (Exception e){} }
            }
        }//end for
    }
}
