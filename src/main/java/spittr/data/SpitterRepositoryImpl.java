package spittr.data;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import spittr.Spitter;

import javax.inject.Inject;


@Repository
public class SpitterRepositoryImpl implements SpitterRepository {
    private static final String INSERT_SPITTER = "insert into Spitter (username, password, first_name, last_name, email) values (?, ?, ?, ?, ?)";

    private static final String SELECT_SPITTER = "select id, username, password, fullname, email, updateByEmail from Spitter";
    private JdbcOperations jdbcOperations;

    @Inject
    public SpitterRepositoryImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }


    @Override
    public Spitter save(Spitter spitter) {
       jdbcOperations.update(INSERT_SPITTER,
               spitter.getUsername(),
               spitter.getPassword(),
               spitter.getFirstName(),
               spitter.getLastName(),
               spitter.getEmail());

        return spitter;
    }

    @Override
    public Spitter findByUsername(final String username) {
        return null;
    }
}
