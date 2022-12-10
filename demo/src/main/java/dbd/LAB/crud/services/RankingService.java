package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Ranking;
import dbd.LAB.crud.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController


public class RankingService {


    private final RankingRepository rankingRepository;

    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    @PostMapping("/Ranking")
    @ResponseBody
    public Ranking crear(@RequestBody Ranking ranking){
        Ranking resultado = rankingRepository.crear(ranking);
        return resultado;
    }

    @GetMapping("/Categoria")
    public List<Ranking> getAllRanking(){
        return rankingRepository.getAll();
    }

    @GetMapping("/Categoria/{id_ranking}")
    public List<Ranking> getRanking(@PathVariable int id_rankig){
        return rankingRepository.showLugar(id_rankig);
    }

    @PutMapping("/Categoria/{id}")
    public String updateRanking(@RequestBody Ranking ranking, @PathVariable int id_ranking){
        String retorno = rankingRepository.update(ranking,id_ranking);
        return retorno;
    }

    @DeleteMapping("/Categoria/{id_ranking}")
    public void borrar(int id_ranking){
        rankingRepository.delete(id_ranking);
    }


}
