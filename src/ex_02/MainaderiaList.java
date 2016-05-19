package ex_02;

import p0_material.*;
import java.util.*;

public class MainaderiaList implements Mainaderia {

    // Referencia a objecte de la classe List on "guardarem" les criatures...
    private List contingut;
    
    public MainaderiaList() {
        // crear la llista. Inicialment serà buida, clar...
        this.contingut = new ArrayList();
    }
 
   // afegeix una criatura. Excepció si ja hi ha una criatura igual
    public void matricular (Criatura c) throws IllegalArgumentException {
        if (this.contingut.contains(c))
            throw new IllegalArgumentException("matricular: criatura repetida");
        contingut.add(c);
    }
    
    // desmatricula la criatura de nom donat. Retorna la criatura que 
    // es desmatricula. Si no n'hi ha cap amb aquell nom retorna null
    public Criatura desMatricular(String nom) {
        Criatura target = new Criatura(nom, Criatura.MIN_EDAT, Criatura.NEN);
        int index = contingut.indexOf(target);
        if (index==-1) {
            return null;
        }
        else {
            return (Criatura)contingut.remove(index);
        }
    }
    
    // Retorna la criatura que té el nom especificat. Retorna null si no
    // n'hi ha cap
    public Criatura buscar(String nom) {
        Criatura target = new Criatura(nom, Criatura.MIN_EDAT, Criatura.NEN);
        int index = contingut.indexOf(target);
        if (index==-1) {
            return null;
        }
        else {
            return (Criatura)contingut.get(index);
        }
    }
    
    // retorna el número de criatures matriculades
    public int numCriatures() {
        return contingut.size();
    }
    
    // retorna el número de criatures del sexe especificat com a paràmetre
    public int quantsSexe (int sexe) {
    
    	int cnt = 0;
    	for (Object o: contingut) {
			Criatura c = (Criatura)o;
			if(c.getSexe() == sexe)
				cnt++;
		}
    	
    	return cnt;
    }
    
    // retorna la i-èssima criatura. Excepció si el paràmetre està fora
    // dels límits actuals
    public Criatura get(int i) throws IndexOutOfBoundsException {
        return (Criatura)contingut.get(i);
        // NOTA: get ja llença IndexOutOfBoundsException si el paràmetre està
        // fora de limits
    }

}
