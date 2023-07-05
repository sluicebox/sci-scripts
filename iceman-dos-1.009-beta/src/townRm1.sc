;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 78)
(include sci.sh)
(use Main)
(use Interface)
(use n954)
(use RFeature)
(use Game)

(public
	townRm1 0
)

(instance townRm1 of Rm
	(properties
		picture 78
		horizon 56
		north 79
		west 77
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 241 62 loop: 2)
			)
			(else
				(gEgo posn: 10 (gEgo y:) loop: 0)
			)
		)
		(gEgo init:)
		(self
			setRegions: 310 312 ; tunisia, guardjReg
			setFeatures:
				windo
				door
				building
				((Clone building)
					x: 275
					y: 153
					z: 0
					nsLeft: 231
					nsTop: 117
					nsRight: 319
					nsBottom: 189
					yourself:
				)
				((Clone building)
					x: 290
					y: 30
					z: 0
					nsLeft: 261
					nsTop: 0
					nsRight: 319
					nsBottom: 60
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (Said 'look>') (Said '[<around][/room,town,scene]'))
				(Print 78 0) ; "You see buildings on both sides of the street."
			)
		)
	)
)

(instance building of RFeature
	(properties
		y 45
		x 105
		nsBottom 91
		nsRight 210
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/building]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 78 1) ; "A typical example of Tunisian architecture."
					)
				)
			)
		)
	)
)

(instance windo of RFeature
	(properties
		y 62
		x 60
		nsTop 20
		nsLeft 71
		nsBottom 105
		nsRight 48
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/window]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 78 2) ; "A window."
					)
					((Said 'look<in')
						(proc0_41) ; "That is not a good idea."
					)
				)
			)
		)
	)
)

(instance door of RFeature
	(properties
		y 63
		x 28
		nsTop 34
		nsLeft 4
		nsBottom 92
		nsRight 53
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 78 3) ; "A door leading into a building."
					)
					((Said 'open,close,knock')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

