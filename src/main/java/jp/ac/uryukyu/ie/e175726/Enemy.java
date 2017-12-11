package jp.ac.uryukyu.ie.e175726;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy extends LivingThing {
    public Enemy (String name, int maximumHP, int attack) {
        super(name,maximumHP,attack);
    }
    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        setHitPoint(getHitPoint()-damage);
        if( getHitPoint() < 0 ) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }
    @Override
    public void attack(LivingThing opponent){
        if(!this.isDead()) {
            int damage = (int) (Math.random() * this.getAttack());
            if(damage==0){
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！！\n", this.getName(), opponent.getName());
            }else {
                if((int)(Math.random()*10)<3){
                    System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", this.getName(), opponent.getName(), damage*2);
                    opponent.wounded(damage*2);
                }else {
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", this.getName(), opponent.getName(), damage);
                    opponent.wounded(damage);
                }
            }

        }
    }

}
