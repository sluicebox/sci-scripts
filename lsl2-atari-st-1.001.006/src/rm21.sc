;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm21 0
)

(local
	aSign
)

(instance rm21 of Rm
	(properties
		picture 21
		horizon 146
		north 17
		east 22
		south 25
		west 20
	)

	(method (init)
		(Load rsVIEW 241)
		(super init:)
		((View new:)
			view: 241
			loop: 1
			cel: 0
			posn: 296 138
			setPri: 10
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 241
			loop: 1
			cel: 1
			posn: 259 134
			setPri: 9
			ignoreActors:
			addToPic:
		)
		((= aSign (Prop new:))
			view: 241
			setLoop: 0
			setPri: 5
			posn: 302 87
			setCycle: Fwd
			cycleSpeed: 3
			init:
		)
		(cond
			((== gPrevRoomNum 25)
				(gEgo posn: 222 187)
			)
			((or (== gPrevRoomNum 0) (== gPrevRoomNum 17))
				(gEgo posn: 264 149)
			)
			((== gPrevRoomNum 115)
				(gEgo loop: 0 posn: 178 177)
			)
		)
		(NormalEgo)
		(gEgo init:)
		(self setRegions: 200 setScript: rm21Script) ; rm200
	)
)

(instance rm21Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/barrel,carpet,freeway')
				(Print 21 0) ; "This part of town is not as well-maintained as it should be."
			)
			(if (Said '/bar')
				(Print 21 1) ; "It looks too rough for a guy like you, Larry. Better stay out!"
			)
			(if (Said '/sign')
				(Print 21 2) ; "BAR"
			)
			(if (Said '/graffiti')
				(Print 21 3) ; "It says lots of dirty stuff, all of which you already know and therefore don't need to read here, in a family-oriented product such as this!"
			)
			(if (Said '[/building,airport]')
				(Print 21 4) ; "You are now in a slightly seedy section of the city."
			)
		)
	)
)

