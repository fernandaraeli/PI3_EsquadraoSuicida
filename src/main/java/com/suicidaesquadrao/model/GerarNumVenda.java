    
package com.suicidaesquadrao.model;


public class GerarNumVenda {
    
    int numVenda;
    String numero;
    

    public String NumeroVenda(int numVenda){
        
        this.numVenda = numVenda+1;
        if((this.numVenda>=10000000)&&(this.numVenda<=100000000)){
            numero=""+this.numVenda; 
        }
        if((this.numVenda>=1000000)&&(this.numVenda<=10000000)){
            numero="0"+this.numVenda; 
        }
        if((this.numVenda>=100000)&&(this.numVenda<=1000000)){
            numero="00"+this.numVenda; 
        }        
        if((this.numVenda>=10000)&&(this.numVenda<=100000)){
            numero="000"+this.numVenda; 
        }
        if((this.numVenda>=1000)&&(this.numVenda<=10000)){
            numero="0000"+this.numVenda; 
        }
        if((this.numVenda>=100)&&(this.numVenda<=1000)){
            numero="00000"+this.numVenda; 
        }
        if((this.numVenda>=10)&&(this.numVenda<=100)){
            numero="000000"+this.numVenda; 
        }
        if(this.numVenda<10){
            numero="00000000"+this.numVenda; 
        }        
       return this.numero;
    }

}
    
