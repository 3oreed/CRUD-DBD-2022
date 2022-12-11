package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Ranking;
import java.util.List;

public interface RankingRepository {
    public Ranking crear(Ranking ranking);

    public String update(Ranking ranking, int id_ranking);

    public List<Ranking> getAll();

    public List<Ranking> show(int lugar);

    public void delete(int id_ranking);
}
