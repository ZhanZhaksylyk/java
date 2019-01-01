package Upgrades;

import Tanks.Tank;

public class BombWeapon extends Weapon {
    boolean ready=false;
    Bullet bullet;
    public BombWeapon(Tank tank) {
        super(tank);
    }
    @Override
    public void shot(){
        if(ready){
            double angle=0;
            bullet.remove();
            for (int i = 0; i < 16; i++) {
                Bullet piece = new Bullet(tank,angle);
                piece.setRate(getRange()/2);
                piece.shot();
                angle+=360/16;
            }
            ready=false;
        }
        else{
             bullet = new Bullet(tank,angle);
             bullet.shot();
             ready=true;
        }
    }
}
