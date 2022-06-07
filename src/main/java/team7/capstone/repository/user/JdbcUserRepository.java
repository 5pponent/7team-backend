package team7.capstone.repository.user;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;
import team7.capstone.domain.UserVO;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JdbcUserRepository implements UserRepository {

    private final DataSource dataSource;

    @Override
    public UserVO save(UserVO user) {
        String sql = "insert into user(id, password, name, email) values(?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                user.setUser_seq(rs.getLong(1));
            } else {
                throw new SQLException("유저 조회 실패");
            }
            return user;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Optional<UserVO> findBySeq(Long user_seq) {
        String sql = "select * from user where user_seq = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, user_seq);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                UserVO u = new UserVO();
                u.setUser_seq(user_seq);
                u.setId(rs.getString("user_id"));
                u.setPassword(rs.getString("password"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setJob(rs.getString("job"));
                u.setCategory(rs.getString("category"));
                return Optional.of(u);
            }
            return Optional.empty();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Optional<UserVO> findById(String id) {
        String sql = "select * from user where id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                UserVO u = new UserVO();
                u.setUser_seq(rs.getLong("user_seq"));
                u.setId(id);
                u.setPassword(rs.getString("password"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setJob(rs.getString("job"));
                u.setCategory(rs.getString("category"));
                return Optional.of(u);
            }
            return Optional.empty();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                close(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }

    private void close(Connection conn) throws SQLException {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }
}
