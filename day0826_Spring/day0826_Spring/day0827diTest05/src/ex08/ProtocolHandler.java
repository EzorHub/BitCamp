
package ex08;

import java.util.List;




public class ProtocolHandler {
	private List<Filters> filters;
	
	
	public void setFilters(List<Filters> filters) {
		this.filters = filters;
	}


	public void service() {
		for(Filters f: filters) {
			f.pro();
		}
	}
	
}
