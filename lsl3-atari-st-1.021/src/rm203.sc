;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 203)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use User)
(use System)

(public
	rm203 0
)

(local
	[string 30]
	letteringColor
)

(procedure (ShadowPrint x y c f ptr)
	(Display ptr dsCOORD x y dsFONT f dsCOLOR c)
	(Display ptr dsCOORD (+ x 1) (+ y 1) dsFONT f dsCOLOR (- c 8))
)

(procedure (PrintPlaque)
	(ShadowPrint 54 105 letteringColor 1 (Format @string 203 4)) ; "On this site, the great hero of our people"
	(ShadowPrint 90 120 letteringColor 9 (Format @string 203 5)) ; "LARRY LAFFER"
	(ShadowPrint 56 140 letteringColor 1 (Format @string 203 6)) ; "singlehandedly saved our island from"
	(ShadowPrint 49 155 letteringColor 1 (Format @string 203 7)) ; "our mortal enemy, the evil Dr. Nonookee."
)

(instance rm203 of Rm
	(properties
		picture 203
	)

	(method (init)
		(super init:)
		(SetFlag 5)
		(= gOldEgoState gEgoState)
		(= gEgoState gCurRoomNum)
		(if (> (Graph grGET_COLOURS) 4)
			(= letteringColor 14)
		else
			(= letteringColor 7)
		)
		(User canControl: 0)
		(User canInput: 1)
		(self setScript: RoomScript)
		(PrintPlaque)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (GameIsRestarting) 2)
			(PrintPlaque)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(or
					(Said 'look/away,area')
					(Said 'look<done,stop')
					(Said 'done,stop/look')
					(Said 'look<done,stop/awning')
					(Said 'exit,go,exit,done,stop')
				)
				(Ok) ; "O.K."
				(= gEgoState gOldEgoState)
				(gCurRoom newRoom: 200)
			)
			((Said 'look/awning')
				(Print 203 0 #at 10 5 #width 290 #mode 1) ; "On this site, the great hero of our people LARRY LAFFER singlehandedly saved our island from our mortal enemy, the evil Dr. Nonookee."
			)
			((Said 'look/eye,head')
				(Print 203 1) ; "Yep, it's Larry; Larry Laffer."
			)
			((Said 'look')
				(Print 203 2) ; "You are reading a beautiful bronze plaque commemorating the previous adventures of Larry; Larry Laffer."
				(if (not gEgoIsPatti)
					(Print 203 3) ; "Your heart fills with pride, but also with longing for those simple days of yesteryear."
				)
			)
		)
	)
)

