;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use eRoom)
(use Interface)

(public
	Rm23 0
)

(instance Rm23 of eRoom
	(properties
		picture 23
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 917)
	)

	(method (init)
		(super init:)
		(self setRegions: 106) ; otMoor
		(switch gPrevRoomNum
			(28
				(self enterRoom: 320 75 290 75)
			)
			(else
				(self enterRoom: 100 -5 100 60)
			)
		)
		(proc0_13 33)
		(gAddToPics doit:)
	)

	(method (doit)
		(super doit:)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(cond
				((> (gEgo x:) 310)
					(self leaveRoom: 28 320 (gEgo y:))
				)
				((< (gEgo y:) 40)
					(self leaveRoom: 29 (gEgo x:) -5)
				)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(and
					(or (== (event type:) evMOUSEBUTTON) (Said 'look,ask,(are<where)>'))
					(or
						(Said 'look[<at,around][/!*][/!*]')
						(Said 'look/room[/!*]')
						(Said '<around')
						(Said '/lake,ice')
						(Said '//lake,ice')
					)
				)
				(Print 23 0) ; "The ice here is smooth and unbroken."
			)
		)
	)
)

