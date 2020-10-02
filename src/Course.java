import java.util.ArrayList;

public class Course {
    private String uniqueName;
    private ArrayList<Section> sections;

    Course(String uniqueName) {
        this.uniqueName = uniqueName;
        sections = new ArrayList<>();
    }

    boolean addSection(Section section) {
        if (sections.contains(section))
            return false;
        sections.add(section);
        return true;
    }

    boolean enrollStudent(Student student, String sectionName) {
        int sectionIndex = getSectionIndex(sectionName);
        if (sectionIndex == -1) {
            return false;
        } else {
            return sections.get(sectionIndex).enrollStudent(student);
        }
    }

    boolean unenrollStudent(Student student, String sectionName) {
        int sectionIndex = getSectionIndex(sectionName);
        if (sectionIndex == -1) {
            return false;
        } else {
            return sections.get(sectionIndex).unenrollStudent(student);
        }
    }

    public String getUniqueName() {
        return uniqueName;
    }

    private int getSectionIndex(String sectionName) {
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getSectionName().equals(sectionName)) {
                return i;
            }
        }
        return -1;
    }
}
