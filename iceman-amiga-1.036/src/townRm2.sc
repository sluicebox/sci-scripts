;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 79)
(include sci.sh)
(use Main)
(use Interface)
(use n954)
(use RFeature)
(use Game)

(public
	townRm2 0
)

(instance townRm2 of Rm
	(properties
		picture 79
		horizon 65
		north 83
		south 78
		west 80
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (gEgo x:) 70 loop: 2)
			)
			(west
				(gEgo posn: 10 (gEgo y:) loop: 0)
			)
			(else
				(gEgo posn: (gEgo x:) 185 loop: 3)
			)
		)
		(gEgo init:)
		(self
			setRegions: 310 312 ; tunisia, guardjReg
			setFeatures:
				building
				((Clone building)
					x: 0
					y: 0
					z: 0
					nsLeft: 0
					nsTop: 141
					nsRight: 129
					nsBottom: 189
					yourself:
				)
				((Clone building)
					x: 209
					y: 159
					z: 0
					nsLeft: 130
					nsTop: 130
					nsRight: 289
					nsBottom: 189
					yourself:
				)
				((Clone building)
					x: 223
					y: 3
					z: 0
					nsLeft: 128
					nsTop: 0
					nsRight: 319
					nsBottom: 7
					yourself:
				)
				((Clone building)
					x: 303
					y: 36
					z: 0
					nsLeft: 288
					nsTop: 8
					nsRight: 319
					nsBottom: 64
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (Said 'look>') (Said '[<around][/room,town,scene]'))
				(Print 79 0) ; "You look at what seems to be a business section of town."
			)
		)
	)
)

(instance building of RFeature
	(properties
		y 42
		x 63
		nsBottom 84
		nsRight 127
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/building]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 79 1) ; "A typical example of Tunisian architecture."
					)
				)
			)
		)
	)
)

