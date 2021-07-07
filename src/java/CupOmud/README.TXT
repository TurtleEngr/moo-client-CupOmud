This is the official 1.3 release of the Cup-O MUD client source code.
It is being released under the terms of the GNU Public License.  For
more information, see the file named "COPYING", included in this archive.

For more information on the Cup-O MUD Project and related issues, please
see the official web page at http://www.du.org/java/CupOmud/

COMPILATION
-----------

The Cup-O MUD applet consists of two .java files, each of which can be
compiled separately or at the same time. (at some point I'll actually write
up a proper makefile to take care of this, but for now it really isn't that
hard to do things by hand).

Generally, the easiest way to generate the CupOmud.class file (using
Sun's JDK) is:

  javac -O CupOmud.java mudclient/Applet.java

(If you're using the Win95 version of the JDK you'll need to use
"mudclient\Applet.java" (backslash) instead of "mudclient/Applet.java".
Because of the stupid way Sun did their Win95 port, using a forward
slash will actually work, except it complains about filenames being
wrong and won't actually produce the compiled output.)

This will generate all the classes of the actual applet (CupOmud.class
and mudclient/Applet.class).  These files (in the appropriate
directories) should then be put up on the web site, and away you go.

LOCAL INSTALL VERSIONS
----------------------

The reason for the references to an otherwise unused mudclient.Applet class
is to provide support for extended versions of the CupOmud applet.  When
loaded, all official versions of the Cup-O MUD applet will automatically
look for a mudclient.Applet class in the local machine's CLASSPATH.  If
found, the Cup-O MUD bootstrap loader will execute this locally-
installed version of CupOmud (or any other compatible mud client)
instead of the copy located on the remote machine.  This allows for much
fuller-featured versions of the Cup-O MUD applet to be developed for
downloading and installation on a user's local machine, providing added
functionality while avoiding extra download time associated with huge
applets.

The Cup-O MUD Local-Install Interface
-------------------------------------

Following is a brief description of the interface used by Cup-O MUD to load a
locally-installed mudclient.Applet class:

When Cup-O MUD first starts, it attempts to create a new mudclient.Applet
object using the following constructor:

  Applet(java.applet.Applet caller, java.lang.String interfaceType, int interfaceRevision)

"caller" is the CupOmud object which is calling the constructor ("this" in
the CupOmud.class).  "interfaceType" is the type of interface supported (the
current interface type for Cup-O MUD is identified as "Cup-O MUD").
"interfaceRevision" is the revision of the interface in use (currently 1).

"interfaceType" and "interfaceRevision" are used to specify the
features/callbacks supported by the calling loader class.  Any given
interfaceRevision is guanteed to be backward-compatible with previous
revisions for the same interfaceType (i.e. if your client is designed to
work with a loader supporting an interfaceRevision of 2, it will also work
with a loader which provides an interfaceRevision of 3, 4, etc. but will
probably not work with a loader which only supports an interfaceRevision
of 1).

If creation of the mudclient.Applet object succeeds, the created object will
be used instead of the default routines contained in the downloaded
CupOmud.class file.  If, however, the constructor for mudclient.Applet throws
an exception (any exception), the default CupOmud.class routines will be used
and the mudclient.Applet class will not be used.  This allows the constructor
of an installed mudclient.Applet to test the interfaceRevision,
interfaceType, and possibly other criteria before deciding whether it will
take on the task of being the MUVE client or not for the given session.

Providing the mudclient.Applet object is created without an exception, future
applet events received by CupOmud.class are passed on to the mudclient.Applet
object, as if they had been sent to it initially.  The mudclient.Applet
object is responsible for adding itself as a component of the caller (via
caller.add(this), etc) and any other setup it requires when its init method
is called.  Applet parameters can be retrieved by calling caller.getParameter.

Following is a list of the AWT/Applet events which the Cup-O MUD (revision 1)
loader will pass to the mudclient.Applet object, when received by the system:
  getAppletInfo *
  init
  start
  stop
  destroy
  reshape
  layout

(*) CupOmud.getAppletInfo prefixes a Cup-O MUD loader-identification message
    to any text returned by mudclient.Applet's getAppletInfo method.

Note that certain other events (such as keyboard and mouse events) will
automatically be sent to the mudclient.Applet object by the system as long as
it has been add()ed to the calling CupOmud applet's panel.

Anyone interested in developing local-install versions of MUD clients which
will be compatible with this system is also encouraged to get in touch with
me via email and I'll be happy to provide whatever help I can.

-Alex Stewart (riche@crl.com)
