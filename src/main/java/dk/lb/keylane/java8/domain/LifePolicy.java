package dk.lb.keylane.java8.domain;

import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LifePolicy {

	public enum LifePolicyStatus {
		valid, invalid, notset
	};

	private String user;
	private String policyId;
	private String personId;
	private LifePolicyStatus status = LifePolicyStatus.invalid;

	public LifePolicy(String user, String policyId, String personId, LifePolicyStatus status) {
		this.user = user;
		this.policyId = policyId;
		this.personId = personId;
		this.status = status;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personId == null) ? 0 : personId.hashCode());
		result = prime * result + ((policyId == null) ? 0 : policyId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		LifePolicy other = (LifePolicy) obj;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		if (policyId == null) {
			if (other.policyId != null)
				return false;
		} else if (!policyId.equals(other.policyId))
			return false;
		if (status != other.status)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}



	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public LifePolicyStatus getStatus() {
		return status;
	}

	public void setStatus(LifePolicyStatus status) {
		this.status = status;
	}

	public interface LifePolicyFactory {
		public abstract LifePolicy getLifePolicy(String user, String policyId, String personId,
				LifePolicyStatus status);
	}

	public static List<LifePolicy> getSomePolicies( int amount ) {	
		return IntStream.rangeClosed(1, amount).mapToObj( LifePolicy::getPolicyFromId )
		.collect( Collectors.toList() );	
	}
	
	public static LifePolicy getPolicyFromId(int i){
		final List<String> names = Arrays.asList("Anna", "Bent", "Cecilie", "Dennis");
		final List<String> lastNames = Arrays.asList("Hansen", "Pedersen", "Olsen");
		
		return new LifePolicy( 
				names.get(i % names.size()) + " "+ lastNames.get( i % lastNames.size()),
				Integer.toString(i),
				"010170-"+i, 
				(i%2==0)?LifePolicyStatus.valid: LifePolicyStatus.invalid 
				);
		
	}

	@Override
	public String toString() {
		String template = "%s[id=%-4s user=%-20s personId=%-10s status=%-8s]"; 
		StringBuilder builder = new StringBuilder();
		Formatter formatter = new Formatter( builder );
		formatter.format( template, this.getClass().getSimpleName(), getPolicyId(), getUser(), getPersonId(), getStatus() );
		formatter.close();
		return builder.toString();	 
	}

	public static void main(String[] args) {

		List<LifePolicy> policies = getSomePolicies(8);
		policies.forEach(System.out::println);

	}

}