package LinkedList;

public class MagazineRack
{
    public static void main ( String[] args )
    {           // create MagazineList object
//        MagazineList rack = new MagazineList();
//
//        rack.add( new Magazine ( "Time" ) );        // add magazines to list
//        rack.add( new Magazine ( "Sports Illustrated" ) );
//        rack.add( new Magazine ( "National Geographic" ) );
//        rack.add( new Magazine ( "Mental Floss" ) );
//        System.out.println ( rack );
//
//        rack.add( new Magazine ("Car and Driver"), 1 );  // insert magazines
//        rack.add( new Magazine ("People"), 3 );
//        System.out.println ( rack );
//
//        rack.removeFirst();     // remove current first magazine
//        System.out.println ( rack );
//
//        rack.add( new Magazine ( "Newsweek"), 2 );
//        System.out.println ( rack );
//
//        rack.removeFirst();
//        System.out.println ( rack );
//        System.out.println( "final length = " + rack.size() );

    	MagazineList theList = new MagazineList();

    	theList.add(new Magazine("WIRED"));
    	theList.addFirst(new Magazine("Popular Mechanics"));
    	theList.addFirst(new Magazine("PC Magazine"));
    	theList.add(new Magazine("Maker"), 2);

    	System.out.println(theList);

    	theList.add(new Magazine("Ahhhhhhh!!"), 1);
    	theList.removeLast();
    	theList.add(new Magazine("Mmmmmmhhh, donuts..."), 2);
    	theList.remove(0);

    	System.out.println(theList);
     }
    }