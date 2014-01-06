package TESCAdventure;

import java.util.LinkedList;
import java.util.HashMap;


public class Map {
  public static HashMap<Location, LinkedList<Location>> map;
  
  /* Locations */
  public static Location rs = new Location("Red Square", "rs.jpg");
  public static Location dms = new Location("Dorms", "dms.jpg" );
  public static Location lh = new Location("Long House", "lh.jpg");
  public static Location en = new Location("Entrance", "en.jpg");
  public static Location cab = new Location("College Activities Building", "cab.jpg");
  public static Location sem = new Location("Seminar II", "sem.jpg");
  public static Location fd = new Location("Field", "fd.jpg");
  public static Location crc = new Location("Costantino Recreation Center", "crc.jpg");
  public static Location lb = new Location("Library Building", "lb.jpg");
  public static Location ac = new Location("Academic Computing", "ac.jpg");
  public static Location li = new Location("Library", "li.jpg");
  public static Location hcc = new Location("Housing Community Center", "hcc.jpg");
  public static Location bf = new Location("Boss Fight", "bf.jpg");
  
  static {
    map = new HashMap<Location, LinkedList<Location>>();
       
    //Entrance
    LinkedList<Location> enList = new LinkedList<Location>();
    enList.add(rs);
    map.put(en, enList);
    
    // Red Square
    LinkedList<Location> rsList = new LinkedList<Location>();
    rsList.add(en);
    rsList.add(lh);
    rsList.add(lb);
    rsList.add(cab);
    rsList.add(sem);    
    map.put(rs, rsList);
  
    // Long House
    LinkedList<Location> lhList = new LinkedList<Location>();
    lhList.add(rs);
    map.put(lh, lhList);
    
    //Library Building
    LinkedList<Location> lbList = new LinkedList<Location>();
    lbList.add(rs);
    lbList.add(lb);
    lbList.add(ac);
    map.put(lb, lbList);
    
    //Library
    LinkedList<Location> liList = new LinkedList<Location>();
    liList.add(lb);
    map.put(li, liList);
    
    //Academic Computing
    LinkedList<Location> acList = new LinkedList<Location>();
    acList.add(lb);
    acList.add(bf);
    map.put(ac, acList);
    
    //Boss Fight
    LinkedList<Location> bfList = new LinkedList<Location>();
    bfList.add(ac);
    map.put(bf, bfList);
    
    //College Activities Building
    LinkedList<Location> cabList = new LinkedList<Location>();
    cabList.add(rs);
    cabList.add(fd);
    map.put(cab, cabList);
    
    //Seminar II
    LinkedList<Location> semList = new LinkedList<Location>();
    semList.add(rs);
    semList.add(crc);
    map.put(sem, semList);
    
    //Field
    LinkedList<Location> fdList = new LinkedList<Location>();
    fdList.add(cab);
    fdList.add(dms);
    fdList.add(hcc);
    fdList.add(crc);
    map.put(fd, fdList);
    
    //Dorms
    LinkedList<Location> dmsList = new LinkedList<Location>();
    dmsList.add(fd);
    
    map.put(dms, dmsList);
    
    //Housing Community Center
    LinkedList<Location> hccList = new LinkedList<Location>();
    hccList.add(fd);
    
    map.put(hcc, hccList);
    
    //Costantino Recreation Center
    LinkedList<Location> crcList = new LinkedList<Location>();
    crcList.add(fd);
    crcList.add(sem);
    
    map.put(crc, crcList);
  }
  
}