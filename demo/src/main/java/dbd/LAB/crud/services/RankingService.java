package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Ranking;
import dbd.LAB.crud.repositories.RankingRepository;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController


public class RankingService implements RankingRepository{


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

    @Override
    @PutMapping("/Categoria/{id}")
    public String update(@RequestBody Ranking ranking,@PathVariable int id_ranking) {
        String retorno = rankingRepository.update(ranking,id_ranking);
        return retorno;
    }

    @Override
    @GetMapping("/Ranking")
    public List<Ranking> getAll() {
        return rankingRepository.getAll();
    }

    @Override
    @GetMapping("/Categoria/{id_ranking}")
    public List<Ranking> showLugar(int lugar) {
        return rankingRepository.showLugar(lugar);
    }

    @Override
    @DeleteMapping("/Categoria/{id_ranking}")
    public void delete(int id_ranking) {
        rankingRepository.delete(id_ranking);

    }



}
