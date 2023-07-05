;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 83)
(include sci.sh)
(use Main)
(use Interface)
(use n954)
(use RFeature)
(use Game)
(use Actor)

(public
	townRm4 0
)

(instance townRm4 of Rm
	(properties
		picture 83
		south 79
		west 82
	)

	(method (init)
		(Load rsVIEW 82)
		(super init:)
		(switch gPrevRoomNum
			(south
				(gEgo posn: (gEgo x:) 187 loop: 3)
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
				arch
				roof
				((Clone windo)
					x: 334
					y: 61
					z: 0
					nsLeft: 375
					nsTop: 38
					nsRight: 292
					nsBottom: 85
					yourself:
				)
				((Clone building)
					x: 292
					y: 105
					z: 0
					nsLeft: 266
					nsTop: 70
					nsRight: 319
					nsBottom: 141
					yourself:
				)
		)
		(gAddToPics add: wall1 wall2 wall3 wall4 doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[<around][/room,town,scene]')
				(Print 83 0) ; "You see buildings on both sides of the street."
			)
		)
	)
)

(instance wall1 of PV
	(properties
		y 69
		x 21
		view 82
		priority 3
		signal 24576
	)
)

(instance wall2 of PV
	(properties
		y 69
		x 87
		view 82
		cel 1
		priority 3
		signal 24576
	)
)

(instance wall3 of PV
	(properties
		y 68
		x 85
		view 82
		loop 1
		cel 1
		priority 0
		signal 24576
	)
)

(instance wall4 of PV
	(properties
		y 67
		x 7
		view 82
		loop 1
		priority 0
		signal 24576
	)
)

(instance building of RFeature
	(properties
		y 34
		x 229
		nsLeft 139
		nsBottom 69
		nsRight 319
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/building]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 83 1) ; "A typical example of Tunisian architecture."
					)
				)
			)
		)
	)
)

(instance windo of RFeature
	(properties
		y 29
		x 163
		nsTop 15
		nsLeft 151
		nsBottom 43
		nsRight 176
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/shutter]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 83 2) ; "A window."
					)
					((Said 'open,(look,climb<(in,through))')
						(proc0_41) ; "That is not a good idea."
					)
				)
			)
		)
	)
)

(instance arch of RFeature
	(properties
		y 34
		x 69
		nsBottom 69
		nsRight 138
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/arch]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 83 3) ; "A Tunisian archway."
					)
				)
			)
		)
	)
)

(instance roof of RFeature
	(properties
		y 172
		x 69
		nsTop 155
		nsBottom 189
		nsRight 138
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/roof]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 83 4) ; "The roof of a building."
					)
				)
			)
		)
	)
)

(instance door of RFeature
	(properties
		y 128
		x 303
		nsTop 90
		nsLeft 292
		nsBottom 166
		nsRight 315
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 83 5) ; "A door leading into a building."
					)
					((Said 'open,close,knock')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

