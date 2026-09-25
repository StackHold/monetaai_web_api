package br.com.MonetaAI.MonetaAI.service;

import br.com.MonetaAI.MonetaAI.model.dao.ReuniaoDAO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReuniaoService {
    private final ReuniaoDAO reuniaoDAO;

    public ReuniaoService(ReuniaoDAO reuniaoDAO) {
        this.reuniaoDAO = reuniaoDAO;
    }




}
