import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private int destinationDepositNumber;
    private int originalDepositNumber;
    private int transactionAmount;
    private int transactionDate;
    private boolean transactionStatus;
    private String transactionDescription;




}
