class Account {
    protected Account successor;
    protected float balance;

    public void setNext(Account account){
        this.successor = account;
    }

    public void pay(float amountToPay){
        if(canPay(amountToPay)){
            System.out.println("Paid " + amountToPay + " using " + this.getClass().getSimpleName());
        }else if(successor != null){
            successor.pay(amountToPay);
        }else{
            throw new RuntimeException("None of the accounts have enough balance");
        }
    }

    public boolean canPay(float amountToPay){
        return amountToPay <= balance;
    }
}

class Bank extends Account {
    Bank(float balance){
        this.balance = balance;
    }
}

class Paypal extends Account {
    Paypal(float balance){
        this.balance = balance;
    }
}

class Bitcoin extends Account {
    Bitcoin(float balance){
        this.balance = balance;
    }
}

class ChainOfResponsibility {
    public static void main(String[] args) {
        Account bank = new Bank(100);
        Account paypal = new Paypal(200);
        Account bitcoin = new Bitcoin(300);

        bank.setNext(paypal);
        paypal.setNext(bitcoin);

        bank.pay(259);
    }
}