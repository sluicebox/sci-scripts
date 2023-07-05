;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	Room_27 0
)

(instance Room_27 of Rm
	(properties
		name {Room 27}
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
			(= picture 127)
		)
		(gEgo view: 2 xStep: 2 yStep: 1 init:)
		(super init:)
		(self setRegions: 507 518) ; Woods_Region, regUnicorn
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
					@global300
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

