;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 72)
(include sci.sh)
(use Main)
(use Interface)
(use n802)
(use Sight)
(use Extra)
(use Game)

(public
	tunaBeachRm2 0
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
		(self setRegions: 310 306) ; tunisia, guardcReg
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
		(wave init:)
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

	(method (init)
		(super init:)
		(self isExtra: 1)
	)

	(method (handleEvent event param2)
		(cond
			((super handleEvent: event))
			((MousedOn self event 3)
				(Print 72 2) ; "You see the waves coming to the shore."
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
							(Print 72 3) ; "Facing in that direction you are unable to see the waves!"
						)
					)
					((and (Said 'look>') (Said '[<at]'))
						(Print 72 2) ; "You see the waves coming to the shore."
					)
				)
			)
		)
	)
)

