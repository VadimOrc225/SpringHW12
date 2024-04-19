package org.gb.springbootlesson3.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gb.springbootlesson3.entity.Issue;
import org.gb.springbootlesson3.entity.Reader;
import org.gb.springbootlesson3.repository.IssueRepository;
import org.gb.springbootlesson3.repository.JpaReaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReaderService {
//    private final ReaderRepository readerRepository;
private final JpaReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    public Reader createReader(String name) {
        Reader reader = new Reader(name);
        readerRepository.save(reader);
        return reader;
    }

    public Reader getReaderById(long id) {
        return readerRepository.getReferenceById(id);
    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public void deleteReader(long id) {
        Reader reader = readerRepository.getReferenceById(id);
        readerRepository.delete(reader);
    }

    /**
     * Список всех выдач книг для одного читателя
     * @param id - id читателя
     * @return список выдач
     */
    public List<Issue> getIssuesForReader(long id){
        return issueRepository.getAllIssues()
                .stream()
                .filter(issue -> issue.getIdReader() == id)
                .collect(Collectors.toList());
    }
}