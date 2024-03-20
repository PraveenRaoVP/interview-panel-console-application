package com.interviewpanel.repository;

import com.interviewpanel.models.Candidate;

import java.util.*;

public class CandidatesRepository {
    private final List<Candidate> candidateList = new ArrayList<>();
    private final Map<Integer, Candidate> candidateMap = new HashMap<>();
    private String fileNamePath = "./src/main/resources/candidates.json"; // "candidates.json
    private static CandidatesRepository candidatesRepository;

    private CandidatesRepository() {}

    public static CandidatesRepository getInstance() {
        if (candidatesRepository == null) {
            candidatesRepository = new CandidatesRepository();
        }
        return candidatesRepository;
    }

    public void pushCandidates(Candidate candidate) {
        candidateList.add(candidate);
    }

    public Candidate getCandidateById(int candidateId) {
        return candidateMap.get(candidateId);
    }

    public List<Candidate> getCandidates() {
        return new ArrayList<>(candidateMap.values());
    }
}
