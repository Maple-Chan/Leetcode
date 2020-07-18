package javatest;

public class TemplatePatternTest {
    public static void main(String[] args) {
        ConcreteClass concreteClass = new ConcreteClass();
        concreteClass.doTemplate();
        
        TemplateAbstract template = new TemplateAbstract(){

            @Override
            protected void doSomething() {
                // TODO Auto-generated method stub
                System.out.println("doSomething");
            }

            @Override
            protected void customFunction() {
                // TODO Auto-generated method stub
                System.out.println("customFunction");
            }

        };
        template.doTemplate();
        
    }
}

abstract class TemplateAbstract{
    protected abstract void doSomething();
    protected abstract void customFunction();

    protected void doTemplate(){
        doSomething();
        customFunction();
    }

}

class ConcreteClass extends TemplateAbstract{

    @Override
    protected void doSomething() {
        // TODO Auto-generated method stub
        System.out.println("自定义doSomthing");
    }

    @Override
    protected void customFunction() {
        // TODO Auto-generated method stub
        System.out.println("自定义customFunction");
    }

}