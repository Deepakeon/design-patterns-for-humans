interface Theme{
    String getColor();
}

class DarkTheme implements Theme{
    public String getColor(){
        return "Dark Black";
    }
}

class LightTheme implements Theme{
    public String getColor(){
        return "Off White";
    }
}

class AquaTheme implements Theme{
    public String getColor(){
        return "Light Blue";
    }
}

abstract class WebPage {
    protected Theme theme;
    
    WebPage(Theme theme){
        this.theme = theme;
    }

    abstract String getContent();
}

class About extends WebPage{

    About(Theme theme){
        super(theme);
    }

    String getContent(){
        return "About Page in " + theme.getColor();
    }
}

class Careers extends WebPage{

    Careers(Theme theme){
        super(theme);
    }

    String getContent(){
        return "Careers Page in " + theme.getColor();
    }
}

class Bridge{
    public static void main(String[] args) {
        Theme darkTheme = new DarkTheme();
        WebPage about = new About(darkTheme);
        WebPage careers = new Careers(darkTheme);

        System.out.println(about.getContent());
        System.out.println(careers.getContent());
    }
}
