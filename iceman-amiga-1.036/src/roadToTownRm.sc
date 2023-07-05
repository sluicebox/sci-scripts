;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 77)
(include sci.sh)
(use Main)
(use Interface)
(use n954)
(use RFeature)
(use Game)

(public
	roadToTownRm 0
)

(instance roadToTownRm of Rm
	(properties
		picture 77
		east 78
		south 74
		west 76
	)

	(method (init)
		(super init:)
		(self setRegions: 310 312 setFeatures: windo building) ; tunisia, guardjReg
		(switch gPrevRoomNum
			(east
				(gEgo posn: 310 (gEgo y:) loop: 1)
			)
			(west
				(gIceGlobalSound number: 74 owner: gGame priority: 1 loop: -1 play:)
				(gEgo posn: 10 (gEgo y:) loop: 0)
			)
			(else
				(gIceGlobalSound number: 74 owner: gGame priority: 1 loop: -1 play:)
				(gEgo posn: 180 179 loop: 3)
			)
		)
		(gEgo init:)
		(HandsOn)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/town,room,scene]')
				(switch (Random 0 1)
					(0
						(Print 77 0) ; "The dry barren countryside reveals nothing of interest.  A dirt roadway leads east and west."
					)
					(1
						(Print 77 1) ; "The outskirts of town can be seen in the distance."
					)
				)
			)
			((Said 'look/road')
				(Print 77 2) ; "You see nothing of interest."
			)
		)
	)
)

(instance building of RFeature
	(properties
		y 52
		x 286
		nsTop 13
		nsLeft 254
		nsBottom 92
		nsRight 319
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/building]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 77 3) ; "A typical example of Tunisian architecture."
					)
				)
			)
		)
	)
)

(instance windo of RFeature
	(properties
		y 51
		x 300
		nsTop 36
		nsLeft 285
		nsBottom 67
		nsRight 316
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/shutter]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 77 4) ; "A window."
					)
					((Said 'open,(look,climb<(in,through))')
						(proc0_41) ; "That is not a good idea."
					)
				)
			)
		)
	)
)

