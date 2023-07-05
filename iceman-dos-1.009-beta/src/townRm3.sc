;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 82)
(include sci.sh)
(use Main)
(use Interface)
(use n954)
(use RFeature)
(use Game)

(public
	townRm3 0
)

(instance townRm3 of Rm
	(properties
		picture 82
		east 83
		west 81
	)

	(method (init)
		(super init:)
		(self setRegions: 310 312 setFeatures: windo building arch roof) ; tunisia, guardjReg
		(switch gPrevRoomNum
			(east
				(gEgo posn: 314 (gEgo y:) loop: 1)
			)
			(west
				(gEgo posn: 5 (gEgo y:) loop: 0)
			)
			(else
				(gEgo posn: 5 100 loop: 0)
			)
		)
		(gEgo init:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room,town,scene]')
				(Print 82 0) ; "This whole town looks the same."
			)
		)
	)
)

(instance building of RFeature
	(properties
		y 34
		x 35
		nsBottom 69
		nsRight 70
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/building]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 82 1) ; "A typical example of Tunisian architecture."
					)
				)
			)
		)
	)
)

(instance windo of RFeature
	(properties
		y 23
		x 39
		nsTop 12
		nsLeft 21
		nsBottom 35
		nsRight 57
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/window]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 82 2) ; "A window."
					)
					((Said 'look<in')
						(proc0_41) ; "That is not a good idea."
					)
				)
			)
		)
	)
)

(instance arch of RFeature
	(properties
		y 33
		x 195
		nsLeft 72
		nsBottom 67
		nsRight 319
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/arch]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 82 3) ; "A Tunisian archway."
					)
				)
			)
		)
	)
)

(instance roof of RFeature
	(properties
		y 178
		x 294
		nsTop 167
		nsLeft 269
		nsBottom 189
		nsRight 319
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/roof]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 82 4) ; "The roof of a building."
					)
				)
			)
		)
	)
)

