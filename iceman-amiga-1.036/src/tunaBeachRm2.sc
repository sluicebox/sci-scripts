;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 72)
(include sci.sh)
(use Main)
(use Interface)
(use n802)
(use n954)
(use RFeature)
(use Extra)
(use Game)
(use Actor)

(public
	tunaBeachRm2 0
	stupidAvoider 1
	stupidAvoider2 2
)

(local
	local0 = 1
)

(instance tunaBeachRm2 of Rm
	(properties
		picture 72
		south 47
		west 71
	)

	(method (init)
		(super init:)
		(self
			setRegions: 310 306 ; tunisia, guardcReg
			setFeatures:
				building
				((Clone building)
					x: 158
					y: 10
					z: 0
					nsLeft: 140
					nsTop: 1
					nsRight: 177
					nsBottom: 18
					yourself:
				)
				((Clone building)
					x: 240
					y: 25
					z: 0
					nsLeft: 220
					nsTop: 17
					nsRight: 261
					nsBottom: 33
					yourself:
				)
		)
		(if (== gPrevRoomNum 45) ; netBeachRm
			(gIceGlobalSound stop:)
		)
		(switch gPrevRoomNum
			(west
				(gEgo posn: 10 (gEgo y:) loop: 0)
			)
			(else
				(gEgo posn: 70 105 view: 71 loop: 0)
			)
		)
		(gEgo init: observeControl: 64 cycleSpeed: 0)
		(if (== (gEgo view:) 54)
			(gEgo view: 71)
		)
		(wave init: isExtra: 1)
		((Clone wave) x: 288 y: 157 loop: 0 priority: 11 isExtra: 1 init:)
		((Clone wave) x: 46 y: 155 loop: 1 priority: 11 isExtra: 1 init:)
		((Clone wave) x: 94 y: 133 loop: 1 priority: 9 isExtra: 1 init:)
		((Clone wave) x: 150 y: 165 loop: 1 priority: 12 isExtra: 1 init:)
	)

	(method (doit)
		(super doit: &rest)
		(if (and local0 (& (proc802_0 gEgo 3) $0040))
			(Print 72 0) ; "You don't have time to swim."
			(= local0 0)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room]')
				(Print 72 1) ; "You see the beautiful Tunisian beach around you."
			)
		)
	)
)

(instance wave of Extra
	(properties
		y 150
		x 233
		view 72
		priority 10
		cycleSpeed 3
		cycleType 1
		minPause 5
		maxPause 5
		minCycles 2
		maxCycles 3
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/wave]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 72 2) ; "You see the waves coming to the shore."
					)
				)
			)
		)
	)
)

(instance building of RFeature
	(properties
		y 20
		x 115
		nsTop 13
		nsLeft 92
		nsBottom 27
		nsRight 139
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/building]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 72 3) ; "You can see the town in the distance."
					)
				)
			)
		)
	)
)

(instance stupidAvoider of Feature
	(properties
		y 75
		x -15
	)
)

(instance stupidAvoider2 of Feature
	(properties
		y 106
		x -15
	)
)

