package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Ranking;
import dbd.LAB.crud.repositories.RankingRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController


public class RankingService {


    private final RankingRepository rankingRepository;

    public RankingService(@Lazy RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }


    @PostMapping("/Ranking")
    @ResponseBody
    public Ranking crear(@RequestBody Ranking ranking){
        Ranking resultado = rankingRepository.crear(ranking);
        return resultado;
    }


    @PutMapping("/Ranking/{id_ranking}")
    @ResponseBody
    public String update(@RequestBody Ranking ranking,@PathVariable int id_ranking) {
        String retorno = rankingRepository.update(ranking,id_ranking);
        return retorno;
    }


    @GetMapping("/Ranking")
    public List<Ranking> getAll() {
        return rankingRepository.getAll();
    }


    @GetMapping("/Ranking/{id_ranking}")
    public List<Ranking> show(@PathVariable int id_ranking) {
        return rankingRepository.show(id_ranking);
    }


    @DeleteMapping("/Ranking/{id_ranking}")
    public void delete(@PathVariable int id_ranking) {
        rankingRepository.delete(id_ranking);

    }



}
