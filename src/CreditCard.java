import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCard extends Account{
    private int cardNumber;
    private int EXP;
    private int CVV2;
}
