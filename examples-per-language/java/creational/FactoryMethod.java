interface Interviewer{
    void askQuestions();
}

class Developer implements  Interviewer{
    public void askQuestions(){
        System.out.println("Asking about design patterns!");
    }
}

class CommunityExecutive implements  Interviewer{
    public void askQuestions(){
        System.out.println("Asking about community building");
    }
}

abstract class HiringManager{

    protected abstract Interviewer makeInterviewer();

    public void takeInterview(){
        Interviewer interviewer = this.makeInterviewer();
        interviewer.askQuestions();
    }
}

class DevelopmentManager extends HiringManager{
    protected Interviewer makeInterviewer(){
        return new Developer();
    }
}

class MarketingManager extends HiringManager{
    protected Interviewer makeInterviewer(){
        return new CommunityExecutive();
    }
}

class FactoryMethod {
    public static void main(String[] args){
        HiringManager devManager = new DevelopmentManager();
        devManager.takeInterview();

        HiringManager marketingManager = new MarketingManager();
        marketingManager.takeInterview();
    }
}