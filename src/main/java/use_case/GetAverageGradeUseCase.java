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
        Team team = gradeDB.getMyTeam();
        int sumGrade = 0;
        for(String member : team.getMembers()){
            sumGrade += gradeDB.getGrade(member, course).getGrade();
        }
        return (float) sumGrade / team.getMembers().length;
    }
}
