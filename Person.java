import org.json.simple.JSONObject;

public class Person {
	   String id;
	   String first_name;
	   String last_name;
	   String email;
	   String btc_address;
	   String ip_address;
	   Person(JSONObject p) {
		   this.id = String.valueOf(p.get("id"));
		   this.first_name = String.valueOf(p.get("first_name"));
		   this.last_name = String.valueOf(p.get("last_name"));
		   this.email = String.valueOf(p.get("email"));
		   this.btc_address = String.valueOf(p.get("btc_address"));
		   this.ip_address = String.valueOf(p.get("ip_address"));
	   }
}
