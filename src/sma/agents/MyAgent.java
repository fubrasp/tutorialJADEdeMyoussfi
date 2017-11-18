package sma.agents;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.ControllerException;

public class MyAgent extends Agent{

    static int compteur = 0;

    @Override
    protected void setup(){
        System.out.println("Creation et initialisation de l'agent : "+this.getAID().getName());
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage aclMessage = receive();
                if(aclMessage!=null){
                    System.out.println("Reception d'un nouveau message : ");
                    System.out.println("Contenu du message : "+aclMessage.getContent());
                    System.out.println("Acte de communication : "+ACLMessage.getPerformative(aclMessage.getPerformative()));
                    System.out.println("Langage : "+aclMessage.getLanguage());
                }else{
                    block();
                }
            }
        });
    }

    @Override
    protected void beforeMove(){
        System.out.println("Avant migration de l'agent : "+this.getAID().getName());
        try {
            System.out.println("de : "+this.getContainerController().getContainerName());
        } catch (ControllerException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void afterMove(){
        System.out.println("Apres migration de l'agent : "+this.getAID().getName());
        try {
            System.out.println("de : "+this.getContainerController().getContainerName());
        } catch (ControllerException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void takeDown(){
        System.out.println("L'agent : "+this.getAID().getName()+" va mourrir");
    }
}
