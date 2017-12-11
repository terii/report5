package jp.ac.uryukyu.ie.e175726;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero extends LivingThing {
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */
    public Hero (String name, int maximumHP, int attack) {
        super(name,maximumHP,attack);//LivingThingのコンストラクタ
    }

    public void wounded(int damage){
        setHitPoint(getHitPoint()-damage);
        if( getHitPoint() < 0 ) {
            setDead(true);
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", getName());
        }
    }
    @Override
    public void attack(LivingThing opponent){
        if(!this.isDead()) {
            int damage = (int) (Math.random() * this.getAttack());
            if(damage==0){
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！！\n", this.getName(), opponent.getName());
            }else {
                if((int)(Math.random()*10)<4){
                    System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", this.getName(), opponent.getName(), damage*2);
                    opponent.wounded(damage*2);
                }else {
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", this.getName(), opponent.getName(), damage);
                    opponent.wounded(damage);
                }
                }

        }
    }
}