package rad.classloading.properties;

public class Person {

	String personId;
	String personName;
	String personContactNo;
	String personMail;
	public Person(String personId, String personName, String personContactNo, String personMail) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personContactNo = personContactNo;
		this.personMail = personMail;
	}
	public Person() {
		super();
	}
	public String getPersonId() {
		return personId;
	}
	public String getPersonName() {
		return personName;
	}
	public String getPersonContactNo() {
		return personContactNo;
	}
	public String getPersonMail() {
		return personMail;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public void setPersonContactNo(String personContactNo) {
		this.personContactNo = personContactNo;
	}
	public void setPersonMail(String personMail) {
		this.personMail = personMail;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", personContactNo=" + personContactNo
				+ ", personMail=" + personMail + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personContactNo == null) ? 0 : personContactNo.hashCode());
		result = prime * result + ((personId == null) ? 0 : personId.hashCode());
		result = prime * result + ((personMail == null) ? 0 : personMail.hashCode());
		result = prime * result + ((personName == null) ? 0 : personName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (personContactNo == null) {
			if (other.personContactNo != null)
				return false;
		} else if (!personContactNo.equals(other.personContactNo))
			return false;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		if (personMail == null) {
			if (other.personMail != null)
				return false;
		} else if (!personMail.equals(other.personMail))
			return false;
		if (personName == null) {
			if (other.personName != null)
				return false;
		} else if (!personName.equals(other.personName))
			return false;
		return true;
	}
	
}
