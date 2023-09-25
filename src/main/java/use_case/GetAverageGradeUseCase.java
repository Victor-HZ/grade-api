package use_case;
import api.GradeDB;
import api.MongoGradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        // TODO: Get average grade for all students in your team.
        Team team = gradeDB.getMyTeam();
        Integer sumGrade = 0;
        for(String member : team.getMembers()){
            sumGrade = sumGrade + gradeDB.getGrade(member, course).getGrade();
        }
        return sumGrade / team.getMembers().length;
    }
}
