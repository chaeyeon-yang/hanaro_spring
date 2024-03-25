import com.hana.app.data.CustDto;
import com.hana.app.exception.DuplicatedIdException;
import com.hana.app.frame.Service;
import com.hana.app.service.CustService;

public class Main {
    public static void main(String[] args) {
        Service<String, CustDto> service = new CustService();
        CustDto cust = CustDto.builder().id("id02").pwd("pwd02").name("james").build();
        try {
            service.add(cust);
            System.out.println("OK");
        } catch (DuplicatedIdException e) {
            throw new RuntimeException(e);
        }
    }
}
