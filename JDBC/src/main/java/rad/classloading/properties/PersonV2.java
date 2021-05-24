package rad.classloading.properties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class PersonV2 {
	int personId;
	String personName;
	long personContactNo;
	String personMail;
}

class Impl {
	public static void main (String[] args) {
		PersonV2 person = new PersonV2();
		PersonV2 person2 = new PersonV2(23,"rakesh",9324,"abc.gmail");
		person.setPersonContactNo(25);
		System.out.println(person.getPersonContactNo());
		System.out.println(person2);
		System.out.println(person2.hashCode());
		System.out.println(person.equals(person2));
		
	}
}