/*======================================================================
   Project:  The Cup-O MUD Client
   File:     mudclient/Applet.java
   Language: Java 1.0
   Author:   Alex Stewart
   Date:     Jun 8, 1997
   Version:  1.3
   Copyright 1996,1997 Alex Stewart, all rights reserved
   This file is licensed under the terms of the GNU Public License.
   See the accompanying COPYING file for details.
 =======================================================================
 This is the remote mudclient.Applet class.  This class does nothing
 except raise an exception when it's loaded.  This informs the  main
 CupOmud class that there's no locally-installed mudclient.Applet class,
 and it should use its own methods instead.

 See CupOmud.java for project revision history.
*/

package mudclient;

public class Applet extends java.applet.Applet {

// =============================== Constructor ===============================

   public Applet(java.applet.Applet a, java.lang.String t, int v) throws Exception {
      throw new Exception();
   }

// ============================ That's All Folks! ============================
}
