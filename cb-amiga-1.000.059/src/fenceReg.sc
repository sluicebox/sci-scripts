;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 207)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	fenceReg 0
)

(instance fenceReg of Rgn
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '/fence')
							(Print 207 0) ; "A partially-rusted, wrought iron fence fronts the property."
						)
						((Said '/archway')
							(cond
								((or (== gCurRoomNum 28) (== gCurRoomNum 1))
									(Print 207 1) ; "The wrought iron gate is broken and hangs by one hinge."
								)
								((== gCurRoomNum 26)
									(Print 207 2) ; "The iron gate is closed and locked."
								)
								(else
									(event claimed: 0)
								)
							)
						)
						((Said '/road')
							(Print 207 3) ; "An old, rutted, dirt road runs alongside the estate's wrought iron fence. At one time carriages and wagons used it, but in the intervening years, the level of the bayou rose, flooded the road out, and turned the old plantation into an isolated island estate."
						)
					)
				)
				((Said 'open/archway')
					(cond
						((or (== gCurRoomNum 28) (== gCurRoomNum 1))
							(Print 207 4) ; "The gate is already open."
						)
						((== gCurRoomNum 26)
							(Print 207 2) ; "The iron gate is closed and locked."
						)
						(else
							(event claimed: 0)
						)
					)
				)
				((Said 'close/archway')
					(cond
						((or (== gCurRoomNum 28) (== gCurRoomNum 1))
							(Print 207 5) ; "The gate is broken; you can't."
						)
						((== gCurRoomNum 26)
							(Print 207 2) ; "The iron gate is closed and locked."
						)
						(else
							(event claimed: 0)
						)
					)
				)
				((Said 'climb/fence')
					(Print 207 6) ; "Why would you want to? Just go through the front gate!"
				)
				((Said 'archway')
					(Print 207 7) ; "There isn't a gate before you."
				)
			)
		)
	)
)

