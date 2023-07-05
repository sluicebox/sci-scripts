;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	Room27 0
)

(instance Room27 of Rm
	(properties
		picture 27
	)

	(method (init)
		(= north 21)
		(= south 3)
		(= east 28)
		(= west 26)
		(= horizon 75)
		(= gIndoors 0)
		(if gNight
			(gGSound play: 608)
		else
			(gGSound play: 607)
		)
		(super init:)
		(gEgo view: 2 xStep: 3 yStep: 2 init:)
		(if gNight
			(gCurRoom overlay: 127)
		)
		(self setRegions: 507 518) ; Woods_Region, regUnicorn
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if
			(and
				(== (event type:) evSAID)
				(or
					(Said 'look/around')
					(Said 'look/room')
					(Said 'look[<around][/!*]')
				)
			)
			(Print
				(Format ; "You are wandering through a thick wood. %s"
					@global228
					27
					0
					(if (not gNight)
						{You hear birds chirping from the many trees.}
					else
						{ }
					)
				)
			)
		)
	)
)

