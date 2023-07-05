;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use Door)
(use Interface)
(use Game)
(use Actor)
(use System)

(public
	rm16 0
)

(local
	work
	aDoor
)

(instance rm16 of Rm
	(properties
		picture 16
		horizon 111
		east 17
		south 20
		west 15
	)

	(method (init)
		(Load rsVIEW 224)
		(super init:)
		((View new:)
			view: 224
			loop: 1
			cel: 1
			posn: 150 141
			setPri: 10
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 224
			loop: 1
			cel: 0
			posn: 150 84
			setPri: 15
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 224
			loop: 1
			cel: 2
			posn: 113 118
			setPri: 8
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 224
			loop: 1
			cel: 3
			posn: 299 93
			setPri: 13
			ignoreActors:
			addToPic:
		)
		(cond
			((== gPrevRoomNum 0)
				(gEgo posn: 248 134)
			)
			((== gPrevRoomNum 12)
				(gEgo posn: 252 136)
			)
			((== gPrevRoomNum 20)
				(gEgo posn: 73 188)
			)
			((== gPrevRoomNum 116)
				(gEgo posn: 150 131)
			)
		)
		(NormalEgo)
		(gEgo init:)
		((= aDoor (AutoDoor new:))
			view: 224
			setLoop: 0
			posn: 136 135
			setPri: 9
			entranceTo: 116
			msgLook:
				{Through the door you see an exclusive mens clothing store. (And, a beautiful female clerk!) A sign says they accept any form of U. S. currency.}
			msgFunny: {Everytime you try to knock, it opens itself!}
			init:
		)
		(self setRegions: 200 setScript: rm16Script) ; rm200
	)
)

(instance rm16Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0008)
			(gCurRoom newRoom: 12)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/pole,(sign<freeway)')
				(Print 16 0) ; "Rodeo Drive"
			)
			(if (Said '/cup,sign')
				(Print 16 1) ; "OPEN"
			)
			(if (Said '/flower')
				(Print 16 2) ; "Yep. They're flowers all right!"
			)
			(if (Said '/carpet,(carpet<door)')
				(Print 16 3) ; "Embedded in the marble sidewalk is a gold-plated medallion reading "Rejectus Fiscus Universum.""
				(Print 16 4 #at -1 152) ; "(That's Latin for "Give us all your money!")"
			)
			(if (Said '[/building,building,airport]')
				(Print 16 5) ; "You are in front of the world renowned Rodeo Drive Italian clothing purveyor, "Molto Lira.""
				(if (gEgo has: 4) ; Million_Dollar_Bill
					(Print 16 6) ; "Perhaps they could cash a million-dollar bill."
				)
				(if (not (gEgo has: 6)) ; Wad_O__Dough
					(Print 16 7) ; "You've never been able to afford anything in there."
				)
			)
		)
	)
)

