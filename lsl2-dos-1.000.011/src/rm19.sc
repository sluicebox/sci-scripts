;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm19 0
)

(local
	work
	aChairlift
	aMonorail
	aMatterhorn
	aRollerCoaster
	aFlags
)

(instance rm19 of Rm
	(properties
		picture 19
		horizon 106
		north 15
		south 23
		west 23
	)

	(method (init)
		(Load rsVIEW 254)
		(super init:)
		((View new:) view: 254 loop: 2 cel: 0 posn: 144 32 addToPic:)
		((= aChairlift (Prop new:))
			view: 254
			setLoop: 0
			posn: 60 16
			setCycle: Fwd
			cycleSpeed: 2
			isExtra: 1
			init:
		)
		((= aRollerCoaster (Prop new:))
			view: 254
			setLoop: 3
			setCel: 255
			posn: 149 14
			init:
			hide:
			setScript: coasterScript
		)
		((= aFlags (Prop new:))
			view: 254
			setLoop: 4
			posn: 239 15
			setCycle: Fwd
			cycleSpeed: 4
			isExtra: 1
			init:
		)
		((= aMonorail (Act new:))
			view: 254
			setLoop: 1
			setPri: 2
			setStep: 4 1
			ignoreHorizon:
			ignoreActors:
			illegalBits: 0
			posn: -940 53
			init:
			setScript: monoScript
		)
		(cond
			((== gPrevRoomNum 0)
				(gEgo posn: 318 161)
			)
			((== gPrevRoomNum 15)
				(gEgo posn: 306 109)
			)
			((== gPrevRoomNum 20)
				(gEgo posn: 318 161)
			)
			((== gPrevRoomNum 23)
				(gEgo posn: 5 188)
			)
		)
		(NormalEgo)
		(gEgo init:)
		(self setRegions: 200 setScript: rm19Script) ; rm200
	)
)

(instance rm19Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== 2 (gEgo edgeHit:))
			(if (< (gEgo y:) 159)
				(gCurRoom newRoom: 15)
			else
				(gCurRoom newRoom: 20)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look<over,below/brick,fence')
			(Print 19 0) ; "You don't have time for that."
		)
		(if (Said '/brick,fence')
			(Print 19 1) ; "That wall is designed to keep undesirables like you out!"
		)
		(if (Said 'look[/airport]')
			(Print 19 2) ; "Hey! Is that Disneyland?!"
			(Print 19 3) ; "Nah! Not in an Al Lowe game!!"
		)
	)
)

(instance monoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 21))
			)
			(1
				(aMonorail posn: -59 53 setMotion: MoveTo 380 53 self)
			)
			(2
				(aMonorail posn: -945 53)
				(self changeState: 0)
			)
		)
	)
)

(instance coasterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 10))
			)
			(1
				(aRollerCoaster cel: 0 show: setCycle: End self)
			)
			(2
				(aRollerCoaster hide:)
				(self changeState: 0)
			)
		)
	)
)

