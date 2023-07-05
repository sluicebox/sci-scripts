;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use Door)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm11 0
)

(local
	manOnScreen
)

(instance rm11 of Rm
	(properties
		picture 11
		horizon 2
		east 12
		south 15
		west 15
	)

	(method (init)
		(Load rsVIEW 200)
		(Load rsVIEW 204)
		(Load rsVIEW 205)
		(super init:)
		(aView1 loop: 1 cel: 0 setPri: 1 ignoreActors: addToPic:)
		(aView2 loop: 1 cel: 1 setPri: 10 ignoreActors: addToPic:)
		(aShowBizType
			setLoop: 0
			illegalBits: 0
			setPri: 3
			setCycle: Walk
			ignoreActors:
			init:
		)
		(cond
			((== gPrevRoomNum 101)
				(gEgo posn: 161 60)
			)
			((== gPrevRoomNum 12)
				(gEgo posn: 316 168)
			)
			(else
				(gEgo posn: 21 187)
			)
		)
		(NormalEgo)
		(gEgo init:)
		(aDoor
			setLoop: 0
			setPri: 2
			entranceTo: 101
			msgLook: {Inside, a woman sits behind a desk.}
			init:
		)
		(self setRegions: 200 setScript: rm11Script) ; rm200
	)
)

(instance rm11Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/sign')
				(Print 11 0) ; "A sophisticated sign identifies this as the home of KROD Television."
			)
			(if (Said '/antenna,bowl')
				(Print 11 1) ; "You presume the large dish behind the studio is used to transmit their programming to a satellite in geosynchronous orbit, but you've been wrong before!"
			)
			(if (Said '/man,woman,children')
				(if manOnScreen
					(Print 11 2) ; "Is that someone famous?"
				else
					(Print 11 3) ; "Where?"
				)
			)
			(if (Said '[/krod,building,krod,krod,(krod<krod),airport]')
				(Print 11 4) ; "KROD originates many of your favorite television shows, including the big "Lucky Life Lottery.""
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 13))
			)
			(1
				(= manOnScreen 1)
				(aShowBizType
					view: 204
					setLoop: 0
					setMotion: MoveTo 340 133 self
				)
			)
			(2
				(= manOnScreen 0)
				(= seconds (Random 1 11))
			)
			(3
				(= manOnScreen 1)
				(aShowBizType
					view: 205
					setLoop: 1
					setMotion: MoveTo -20 133 self
				)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance aView1 of View
	(properties
		y 30
		x 160
		view 200
	)
)

(instance aView2 of View
	(properties
		y 146
		x 283
		view 200
	)
)

(instance aShowBizType of Act
	(properties
		y 132
		x -20
		view 204
	)
)

(instance aDoor of AutoDoor
	(properties
		y 62
		x 161
		view 200
		msgLook {Inside, a woman sits behind a desk.}
		msgLookLock 1100
		msgLocked 1120
		msgExcept {aView2}
		msgFunny 1164
		msgCloser 1184
	)
)

