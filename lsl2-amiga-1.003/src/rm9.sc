;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use User)
(use Menu)
(use System)

(public
	rm9 0
)

(instance rm9 of Rm
	(properties
		picture 178
	)

	(method (init)
		(super init:)
		(TheMenuBar hide:)
		(self setScript: rm9Script)
		(gEgo posn: 99 1098 setMotion: 0)
		(User canControl: 0 canInput: 1)
		(Animate 0)
		(Display 9 0 dsCOORD 0 20 dsFONT 999 dsCOLOR 2) ; "Classified Advertising Dept."
		(Display 9 1 dsCOORD 0 28 dsFONT 999 dsCOLOR 2) ; "Ball Street Journal"
		(Display 9 2 dsCOORD 0 36 dsFONT 999 dsCOLOR 2) ; "10001 Broadway"
		(Display 9 3 dsCOORD 0 44 dsFONT 999 dsCOLOR 2) ; "New York, NY 10001"
		(Display 9 4 dsCOORD 0 60 dsFONT 999 dsCOLOR 2) ; "Gentlemen"
		(Display 9 5 dsCOORD 0 76 dsFONT 999 dsCOLOR 2) ; "Enclosed please find my personal check in the amount of $57.30 to"
		(Display 9 6 dsCOORD 0 84 dsFONT 999 dsCOLOR 2) ; "cover three insertions of the following classified advertisement"
		(Display 9 7 dsCOORD 0 92 dsFONT 999 dsCOLOR 2) ; "in your "Seeking Position" department:"
		(Display 9 8 dsCOORD 50 108 dsFONT 999 dsCOLOR 2) ; "Mature, experienced software analyst available."
		(Display 9 9 dsCOORD 50 116 dsFONT 999 dsCOLOR 2) ; "Bug installation a proven speciality. "No version"
		(Display 9 10 dsCOORD 50 124 dsFONT 999 dsCOLOR 2) ; "too clean." Familiar with DOS 1.0, AGI and SCI."
	)
)

(instance rm9Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (== (event type:) evMOUSERELEASE) (event claimed:))
			(return)
		)
		(Print 9 11) ; "Sorry, but from here, all you can do is Restart or Restore a saved game."
		(Print 9 12 #at -1 130) ; "(Hope you didn't get caught!)"
		(event claimed: 1)
	)
)

