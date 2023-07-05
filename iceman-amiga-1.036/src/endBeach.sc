;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use Interface)
(use n954)
(use RFeature)
(use Game)

(public
	endBeach 0
)

(instance endBeach of Rm
	(properties
		picture 7
		north 15
		south 5
		west 8
	)

	(method (init)
		(super init:)
		(Load rsVIEW 200)
		(gEgo init: observeControl: 1024)
		(switch gPrevRoomNum
			(south
				(gEgo y: 187)
			)
			(west
				(gEgo view: 200 loop: 0 posn: 5 180)
			)
		)
		(self setFeatures: water jungle setRegions: 301 300) ; Water, tahiti
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room,scene,beach]')
				(Print 7 0) ; "Nice beach!"
			)
			((Said 'look<up')
				(Print 7 1) ; "The sky is very blue."
			)
			((Said 'look[<at]/building,hotel,building,building')
				(Print 7 2) ; "You can't see them from here."
			)
			((Said 'look/cloud')
				(Print 7 3) ; "The clouds are pretty."
			)
		)
	)

	(method (dispose)
		(gEgo ignoreControl: 1024)
		(super dispose:)
	)
)

(instance jungle of RFeature
	(properties
		y 150
		x 294
		nsTop 112
		nsLeft 270
		nsBottom 189
		nsRight 319
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/bush,bush]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 7 4) ; "The dense jungle obscures the interior of the island."
					)
					((Said 'enter')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance water of RFeature
	(properties
		y 82
		x 137
		nsTop 66
		nsBottom 99
		nsRight 274
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[bay,water]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 7 5) ; "Warm tropical ocean water"
					)
					((Said 'enter')
						(Print 7 6) ; "Just walk there."
					)
				)
			)
		)
	)
)

