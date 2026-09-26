import java.util.*;

abstract class Question {
    protected String text;
    protected int points;

    Question(String text, int points) {
        this.text = text;
        this.points = points;
    }

    // Each question type evaluates its answer differently.
    public abstract boolean evaluate(String answer);

    public String getText() {
        return text;
    }

    public int getPoints() {
        return points;
    }
}

class MultipleChoiceQuestion extends Question {
    private String correctOption;

    MultipleChoiceQuestion(String text, int points, String correctOption) {
        super(text, points);
        this.correctOption = correctOption;
    }

    public boolean evaluate(String answer) {
        return correctOption.equalsIgnoreCase(answer);
    }
}

class TrueFalseQuestion extends Question {
    private boolean correctAnswer;

    TrueFalseQuestion(String text, int points, boolean correctAnswer) {
        super(text, points);
        this.correctAnswer = correctAnswer;
    }

    public boolean evaluate(String answer) {
        return Boolean.toString(correctAnswer).equalsIgnoreCase(answer);
    }
}

class ShortAnswerQuestion extends Question {
    private String correctAnswer;

    ShortAnswerQuestion(String text, int points, String correctAnswer) {
        super(text, points);
        this.correctAnswer = correctAnswer;
    }

    public boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer.trim());
    }
}

class ExamStudent {
    String name;

    ExamStudent(String name) {
        this.name = name;
    }
}

class Examination {
    String title;
    List<Question> questions = new ArrayList<>();

    Examination(String title) {
        this.title = title;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }
}

class Attempt {
    private ExamStudent student;
    private Examination exam;
    private Map<Question, String> answers = new LinkedHashMap<>();
    private boolean submitted = false;

    Attempt(ExamStudent student, Examination exam) {
        this.student = student;
        this.exam = exam;
    }

    public void answer(Question question, String answer) {
        if (submitted) {
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }

        if (!exam.questions.contains(question)) {
            System.out.println("Question does not belong to this examination.");
            return;
        }

        answers.put(question, answer);
        System.out.println("Answer recorded for " + question.getText());
    }

    public void submit() {
        if (submitted) {
            System.out.println("Examination already submitted.");
            return;
        }

        submitted = true;
        int score = 0;
        int total = 0;

        System.out.println(exam.title + " submitted by " + student.name + ".");

        for (Question q : exam.questions) {
            total += q.getPoints();
            boolean correct = q.evaluate(answers.getOrDefault(q, ""));
            int earned = correct ? q.getPoints() : 0;
            score += earned;

            System.out.println(q.getText() + ": " +
                    (correct ? "Correct" : "Incorrect") +
                    " (" + earned + " points)");
        }

        System.out.println("Total score: " + score + "/" + total);
    }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        ExamStudent student = new ExamStudent("ExamStudent 1");
        Examination exam = new Examination("Exam A");

        Question q1 = new MultipleChoiceQuestion("Question 1", 5, "C");
        Question q2 = new TrueFalseQuestion("Question 2", 5, false);

        exam.addQuestion(q1);
        exam.addQuestion(q2);

        Attempt attempt = new Attempt(student, exam);
        System.out.println("Exam A started by ExamStudent 1.");

        attempt.answer(q1, "C");
        attempt.answer(q2, "True");
        attempt.submit();

        // Submitted attempts cannot be changed.
        attempt.answer(q1, "A");
    }
}

