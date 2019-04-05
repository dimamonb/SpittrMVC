package spittr.data;

import org.springframework.stereotype.Repository;
import spittr.Spittle;

import java.util.List;


public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(long id);
    void save(Spittle spittle);
}
