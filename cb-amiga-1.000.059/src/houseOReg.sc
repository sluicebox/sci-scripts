;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 206)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	houseOReg 0
)

(instance houseOReg of Rgn
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== gAct 0)
				(not (IsFlag 39))
				(< gCurRoomNum 18)
				(& (gEgo onControl: 1) $0001)
			)
			(Print 206 0) ; "It's real creepy and dark out here! You shiver at the thought of venturing outside alone. Perhaps you ought to go back inside."
			(SetFlag 39)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((and (== gCurRoomNum 10) (Said 'look[<in]/read,colonel[/read]'))
					(if (& (gEgo onControl: 0) $0040)
						(Print 206 1) ; "You attempt to peer in, but can make out no details."
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((and (== gCurRoomNum 12) (Said 'look[<in]/kitchen'))
					(if (& (gEgo onControl: 0) $0040)
						(Print 206 1) ; "You attempt to peer in, but can make out no details."
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((and (== gCurRoomNum 15) (Said 'look[<in]/room<billiard'))
					(if (& (gEgo onControl: 0) $0040)
						(Print 206 1) ; "You attempt to peer in, but can make out no details."
					else
						(NotClose) ; "You're not close enough."
					)
				)
				(
					(and
						(== gCurRoomNum 16)
						(or
							(Said 'look[<in]/(hall,hall)[<entry]')
							(Said 'look[<in]/room<billiard')
							(Said 'look[<in]/parlor')
						)
					)
					(if (& (gEgo onControl: 0) $0040)
						(Print 206 1) ; "You attempt to peer in, but can make out no details."
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((and (== gCurRoomNum 17) (Said 'look[<in]/parlor'))
					(if (& (gEgo onControl: 0) $0040)
						(Print 206 1) ; "You attempt to peer in, but can make out no details."
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((Said 'look>')
					(cond
						((Said '<(in,through)/window,cabin')
							(if (< gCurRoomNum 20)
								(if (& (gEgo onControl: 0) $0040)
									(Print 206 1) ; "You attempt to peer in, but can make out no details."
								else
									(NotClose) ; "You're not close enough."
								)
							else
								(NotClose) ; "You're not close enough."
							)
						)
						((Said '/cabin,mansion')
							(Print 206 2) ; "A once-grand plantation house sits in the center of this lonely bayou island. You can imagine the family that once lived here: the parties, the farming, the hustle and the bustle of a thriving plantation, but now, no more. Now the estate has been reduced to a mere fragment of itself while the big house and outbuildings have been allowed to deteriorate."
						)
						((Said '/window')
							(Print 206 3) ; "Many elegant French windows grace the old mansion."
						)
						((Said '/door')
							(if (< gCurRoomNum 20)
								(Print 206 4) ; "You may enter the house through several French doors."
							else
								(Print 206 5) ; "The front door of the house is well lit by porch lights."
							)
						)
						((Said '/column')
							(Print 206 6) ; "Beautiful grecian columns add splendor to the old mansion. You imagine how wonderful it must have looked in its hey-day."
						)
						((Said '/gallery')
							(Print 206 7) ; "A wide, two-level veranda fronts the house."
						)
					)
				)
				((Said 'open/window')
					(if (< gCurRoomNum 20)
						(Print 206 8) ; "The windows don't open. Why not try a door?"
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((Said 'open/door')
					(if (< gCurRoomNum 20)
						(Print 206 9) ; "Just do that yourself."
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((Said 'break/window')
					(if (< gCurRoomNum 20)
						(Print 206 10) ; "There's no reason to do that. If you wish to enter the house, use a door."
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((Said 'climb/column')
					(if (< gCurRoomNum 20)
						(Print 206 11) ; "You're NOT that agile!"
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((Said 'bang[/door]')
					(if (< gCurRoomNum 20)
						(Print 206 12) ; "There's no need to knock. Just go in the house."
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((Said 'rotate<on/ignite')
					(if (< gCurRoomNum 20)
						(Print 206 13) ; "The lights are already on."
					else
						(NotClose) ; "You're not close enough."
					)
				)
			)
		)
	)
)

