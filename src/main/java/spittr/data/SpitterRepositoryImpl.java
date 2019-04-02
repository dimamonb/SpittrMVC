package spittr.data;

import org.springframework.stereotype.Component;
import spittr.Spitter;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpitterRepositoryImpl implements SpitterRepository {
    private Spitter spitter;

    @Override
    public Spitter save(Spitter spitter) {
        this.spitter = new Spitter(spitter.getUsername(),spitter.getPassword(),spitter.getFirstName(),spitter.getLastName(),spitter.getEmail());

        return this.spitter;
    }

    @Override
    public Spitter findByUsername(final String username) {
        return spitter;
    }
}
