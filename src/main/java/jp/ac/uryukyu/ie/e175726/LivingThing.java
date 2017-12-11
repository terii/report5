package jp.ac.uryukyu.ie.e175726;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 名前
     * @param maximumHP HP
     * @param attack 攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     * @return boolean
     */
    public boolean isDead(){
        return  dead;
    }

    public void setDead(boolean dead){this.dead=dead;}

    public String getName(){
        return name;
    }

    public int getHitPoint(){return hitPoint;}

    public void setHitPoint(int hitPoint){this.hitPoint=hitPoint;}

    /**
     * 攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、LivingThing.wounded()によりダメージ処理を実行。
     * @param e 攻撃対象
     */
    public void attack(LivingThing e){
        if(!this.dead) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, e.getName(), damage);
            e.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}