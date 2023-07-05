;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 71)
(include sci.sh)
(use Main)
(use Interface)
(use n802)
(use Sight)
(use Extra)
(use Game)
(use Actor)

(public
	tunaBeachRm1 0
	stupidAvoider 1
	stupidAvoider2 2
)

(local
	local0 = 1
)

(instance tunaBeachRm1 of Rm
	(properties
		picture 71
		north 74
		east 72
		south 46
		west 70
	)

	(method (init)
		(super init:)
		(Load rsVIEW 576)
		(self setRegions: 310 306) ; tunisia, guardcReg
		(if (== gPrevRoomNum 45) ; netBeachRm
			(gIceGlobalSound stop:)
		)
		(switch gPrevRoomNum
			(west
				(gEgo posn: 10 (gEgo y:) loop: 0)
			)
			(east
				(gEgo posn: 310 (gEgo y:) loop: 1)
			)
			(else
				(gEgo posn: 70 105 view: 71 loop: 0)
			)
		)
		(gEgo init: observeControl: 64 cycleSpeed: 0)
		(gAddToPics add: rockPic doit:)
		(if (== (gEgo view:) 54)
			(gEgo view: 71)
		)
		(wave init:)
		((Clone wave) x: 206 y: 140 loop: 1 priority: 10 isExtra: 1 init:)
		((Clone wave) x: 303 y: 161 loop: 2 priority: 10 isExtra: 1 init:)
	)

	(method (doit)
		(super doit: &rest)
		(if (and local0 (& (proc802_0 gEgo 3) $0040))
			(Print 71 0) ; "You don't have time to swim."
			(= local0 0)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room]')
				(Print 71 1) ; "You see the beautiful Tunisian beach around you."
			)
		)
	)
)

(instance rockPic of PV
	(properties
		y 94
		x 261
		view 576
		loop 2
		cel 2
		signal 16384
	)
)

(instance wave of Extra
	(properties
		y 142
		x 71
		view 271
		priority 10
		cycleSpeed 3
		cycleType 1
		minPause 5
		maxPause 5
		minCycles 2
		maxCycles 3
	)

	(method (init)
		(super init:)
		(self isExtra: 1)
	)

	(method (handleEvent event param2)
		(cond
			((super handleEvent: event))
			((MousedOn self event 3)
				(Print 71 2) ; "You see the waves coming to the shore."
			)
			((Said '[/wave]>')
				(cond
					(
						(and
							(CantBeSeen self)
							(if (>= argc 2)
								(not param2)
							else
								1
							)
						)
						(if (Said '/*')
							(Print 71 3) ; "Facing in that direction you cannot see the waves!"
						)
					)
					((and (Said 'look>') (Said '[<at]'))
						(Print 71 2) ; "You see the waves coming to the shore."
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
		y 105
		x -15
	)
)

