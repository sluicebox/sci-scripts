;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 203)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use Game)
(use System)

(public
	rm203 0
)

(local
	[local0 90]
	local90
)

(procedure (ShadowPrint x y c f)
	(Display &rest dsCOORD x y dsFONT f dsCOLOR c)
	(Display &rest dsCOORD (+ x 1) (+ y 1) dsFONT f dsCOLOR (- c 8))
)

(procedure (PrintPlaque)
	(SaveSubLang)
	(ShadowPrint (LangSwitch 54 4) 105 local90 1 (Format @local0 203 4)) ; "On this site, the great hero of our people"
	(ShadowPrint 90 120 local90 9 (Format @local0 203 5)) ; "LARRY LAFFER"
	(ShadowPrint (LangSwitch 56 25) 140 local90 1 (Format @local0 203 6)) ; "singlehandedly saved our island from"
	(ShadowPrint (LangSwitch 49 60) 155 local90 1 (Format @local0 203 7)) ; "our mortal enemy, the evil Dr. Nonookee."
	(RestoreSubLang)
)

(instance rm203 of Rm
	(properties
		picture 203
	)

	(method (init)
		(super init:)
		(SetFlag 5) ; noCursor
		(= gOldEgoState gEgoState)
		(= gEgoState gCurRoomNum)
		(if (> (Graph grGET_COLOURS) 4)
			(= local90 14)
		else
			(= local90 7)
		)
		(gUser canControl: 0)
		(gUser canInput: 1)
		(PrintPlaque)
		(self setScript: RoomScript)
	)
)

(instance RoomScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(or
					(Said 'look,look/away,area')
					(Said 'look,look<done,stop')
					(Said 'done,stop/look,look')
					(Said 'look,look<done,stop/awning')
					(Said 'exit,go,exit,done,stop')
				)
				(Ok) ; "O.K."
				(= gEgoState gOldEgoState)
				(gCurRoom newRoom: 200)
			)
			((Said 'look,look/awning')
				(Print 203 0 #at 10 5 #width 290 #mode 1) ; "On this site, the great hero of our people LARRY LAFFER singlehandedly saved our island from our mortal enemy, the evil Dr. Nonookee."
			)
			((Said 'look,look/face,eye,head')
				(Print 203 1) ; "Yep, it's Larry; Larry Laffer."
			)
			((Said 'look,look')
				(Print 203 2) ; "You are reading a beautiful bronze plaque commemorating the previous adventures of Larry; Larry Laffer."
				(if (not gEgoIsPatti)
					(Print 203 3) ; "Your heart fills with pride, but also with longing for those simple days of yesteryear."
				)
			)
		)
	)
)

