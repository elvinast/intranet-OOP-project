package main;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
* @generated
*/
public class Mark implements Comparable {
    
	
    private double points;
    private Date deadline;
    private Integer attestation1;
	private Integer attestation2;
	private Integer finalEx;
    private Course courseName;
    private List<Mark> marks;
    private double totalGrade;
    private double courseGPA;
    private String GPAletter;
    
    public Mark() {
    	this.totalGrade = 0;
    	this.attestation1 = 0;
    	this.attestation2 = 0;
    	this.finalEx = 0;
    }

    public Mark(double points, Course courseName, double totalGrade, List<Mark> marks) {
    	this.points = points;
    	this.courseName = courseName;
    	this.totalGrade = totalGrade;
    	this.marks = marks;
    }
    
    public double getPoints() {
        return this.points;
    }
    
    public void setPoints(double points) {
        this.points = points;
    }
    
    public Date getDeadline() {
        return this.deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    
    public Course getCourseName() {
        return this.courseName;
    }
    
    private void setCourseName(Course courseName) {
        this.courseName = courseName;
    }
    
    public List<Mark> getMarks() {
        return this.marks;
    }
    
    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }
    
    public double getTotalGrade() {
        return this.totalGrade;
    }
    
    public void setTotalGrade(double totalGrade) {
        this.totalGrade = totalGrade;
    }
    
    public double getCourseGPA() {
        return this.courseGPA;
    }
    
    public void setCourseGPA(double courseGPA) {
        this.courseGPA = courseGPA;
    }
    public Integer getAttestation1() {
		return attestation1;
	}

	public void setAttestation1(Integer attestation1) {
		this.attestation1 = attestation1;
		totalGrade += attestation1;
	}

	public Integer getAttestation2() {
		return attestation2;
	}

	public void setAttestation2(Integer attestation2) {
		this.attestation2 = attestation2;
		totalGrade += attestation2;
	}

	public Integer getFinalEx() {
		return finalEx;
	}

	public final void setFinalEx(Integer finalEx) {
		this.finalEx = finalEx;
		totalGrade += finalEx;
	}
    
    

    //                          Operations                                  
    
    public void updatePoints(double addingPoints) throws DeadlineExpired{
    	Date now = Calendar.getInstance().getTime();
        if (now.compareTo(deadline) <= 0) {
            this.points += addingPoints;
        }
        else {
            throw new DeadlineExpired(deadline);
        }
    }

    public String gradeToLetter() {
    	if(totalGrade < 50) {
			courseGPA = 0; GPAletter = "F";
		}
		else if(totalGrade < 55) {
			courseGPA = 1.0; GPAletter = "D";
		}
		else if(totalGrade < 60) {
			courseGPA = 1.33; GPAletter = "D+";
		}
		else if(totalGrade < 65) {
			GPAletter = "C-"; courseGPA = 1.67;
		}
		else if(totalGrade < 70) {
			GPAletter = "C"; courseGPA = 2;
		}
		else if(totalGrade < 75) {
			GPAletter = "C+"; courseGPA = 2.33;
		}
		else if(totalGrade < 80) {
			GPAletter = "B-"; courseGPA = 2.67;
		}
		
		else if(totalGrade < 85) {
			GPAletter = "B"; courseGPA = 3.0;
		}
		else if(totalGrade < 90) {
			GPAletter = "B+"; courseGPA = 3.33;
		}
		else if(totalGrade < 95) {
			GPAletter = "A-"; courseGPA = 3.67;
		}
		else if(totalGrade < 100) {
			GPAletter = "A"; courseGPA = 4;
		}
    	return GPAletter;
    }

	@Override
	public String toString() {
		return "Mark [points=" + points + ", deadline=" + deadline + ", attestation1=" + attestation1
				+ ", attestation2=" + attestation2 + ", finalEx=" + finalEx + ", courseName=" + courseName + ", marks="
				+ marks + ", totalGrade=" + totalGrade + ", courseGPA=" + courseGPA + ", GPAletter=" + GPAletter + "]";
	}
    
	public int compareTo(Object o) {
		Mark m = (Mark)o;
		if(GPAletter.compareTo(m.GPAletter) == 0) {
			return finalEx.compareTo(m.getFinalEx());
		}
		return GPAletter.compareTo(m.GPAletter);
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mark)) return false;
        Mark mark = (Mark) o;
        return Double.compare(mark.points, points) == 0 &&
                deadline.equals(mark.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, deadline);
    }
	
    
}
