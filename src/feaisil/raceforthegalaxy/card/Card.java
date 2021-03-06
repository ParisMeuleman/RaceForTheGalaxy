package feaisil.raceforthegalaxy.card;

import java.util.ArrayList;
import java.util.List;

import feaisil.raceforthegalaxy.card.power.Power;
import feaisil.raceforthegalaxy.card.victorypointbonus.EndGameBonus;

public class Card {
  private int id;
  private String name;
  private String graphicId;
  private int cost; // Cost or defense
  private int victoryPoints;
  private boolean prestige;
  private List<Power> powers;
  private List<EndGameBonus> endGameBonus;
  private List<Keyword> keywords;
  private Object owner;

  public Card( 
      int id,
      String iName,
      String iGraphicId,
      int iCost, 
      int iVictoryPoints,
      boolean iPrestige,
      List<Keyword> iKeywords,
      List<Power> iPowers,
      List<EndGameBonus> iEgb) {
    super();

    powers = new ArrayList<Power>();
    endGameBonus = new ArrayList<EndGameBonus>();
    keywords = new ArrayList<Keyword>();

    if(iPowers != null)
      powers.addAll(iPowers);
    if(iEgb != null)
      endGameBonus.addAll(iEgb);
    if(iKeywords != null)
      keywords.addAll(iKeywords);

    this.id = id;
    graphicId = iGraphicId;
    prestige = iPrestige;
    name = iName;
    cost = iCost;
    victoryPoints = iVictoryPoints;
  }

  public final String getName()
  {
    return name;
  }
  public final int getCost()
  {
    return cost;
  }
  public final List<Power> getPowers() {
    return powers;
  }
  public final Object getOwner() {
    return owner;
  }
  public final void setOwner(Object _owner) {
    this.owner = _owner;
  }
  public final int getVictoryPoints() {
    return victoryPoints;
  }

  public boolean isPrestige() {
    return prestige;
  }
  public int getId() {
    return id;
  }
  public String getGraphicId() {
    return graphicId;
  }

  public boolean hasPower(Class<? extends Power> iPower) {
    for(Power aP: powers)
    {
      if(aP.getClass() == iPower)
        return true;
    }
    return false;
  }

  public <PowerType extends Power> List<PowerType> getPowers(Class<PowerType> iPower)
  {
    List<PowerType> result = new ArrayList<PowerType>();
    for(Power aP: powers)
    {
      if(aP.getClass() == iPower)
        result.add((PowerType)(aP));
    }
    return result;
  }

  @Override
  public String toString()
  {
    return //name;
    "[name=" + name + ", cost=" + cost + ", victoryPoints="
        + victoryPoints + ", prestige=" + prestige + ", powers=" + powers
        + ", endGameBonus=" + endGameBonus + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Card other = (Card) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

}
