package qna.domain;

import qna.CannotDeleteException;

import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Embeddable
public class Answers {
    private final List<Answer> answers = new ArrayList<>();

    public Answers() {}

    public void add(Answer answer) {
        answers.add(answer);
    }

    public void deletableValidate(User loginUser) throws CannotDeleteException {
        for (Answer answer : answers) {
            answer.deletableValidate(loginUser);
        }
    }

    public List<DeleteHistory> delete() {
        return answers.stream().map(Answer::delete).collect(Collectors.toList());
    }
}
