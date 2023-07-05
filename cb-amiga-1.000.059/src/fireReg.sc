;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 213)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	fireReg 0
)

(instance fireReg of Rgn
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '<in/fireplace')
							(switch gCurRoomNum
								(31
									(Print 213 0) ; "You peer into the fireplace but nothing catches your interest."
								)
								(44
									(Print 213 0) ; "You peer into the fireplace but nothing catches your interest."
								)
								(42
									(Print 213 1) ; "You see logs smoldering in the fireplace."
								)
								(else
									(if (< gAct 4)
										(Print 213 2) ; "A cheery fire brightens the room."
									else
										(Print 213 1) ; "You see logs smoldering in the fireplace."
									)
								)
							)
						)
						((Said '/fireplace')
							(Print 213 3) ; "The finely carved fireplaces show the craftsmanship of bygone days."
						)
						((Said '/fire')
							(cond
								((or (== gCurRoomNum 32) (== gCurRoomNum 34))
									(if (< gAct 4)
										(Print 213 2) ; "A cheery fire brightens the room."
									else
										(Print 213 1) ; "You see logs smoldering in the fireplace."
									)
								)
								((== gCurRoomNum 42)
									(Print 213 1) ; "You see logs smoldering in the fireplace."
								)
								(else
									(event claimed: 0)
								)
							)
						)
						((Said '/mantel')
							(if (== gCurRoomNum 34)
								(Print 213 4) ; "Nothing on the fireplace mantel catches your attention."
							else
								(Print 213 5) ; "Various objects and knickknacks are displayed on the fireplace mantel. None of it interests you, though."
							)
						)
					)
				)
				((Said 'get/fire')
					(if (or (== gCurRoomNum 32) (== gCurRoomNum 34))
						(Print 213 6) ; "Don't get too close to it!"
					else
						(Print 213 7) ; "You can't get that."
					)
				)
			)
		)
	)
)

