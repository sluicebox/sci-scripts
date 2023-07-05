;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use eRoom)
(use Interface)

(public
	Rm28 0
)

(instance Rm28 of eRoom
	(properties
		picture 28
		style 8
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 917)
	)

	(method (init)
		(super init:)
		(self setRegions: 106) ; otMoor
		(switch gPrevRoomNum
			(23
				(self enterRoom: -5 73 25 73)
			)
			(else
				(self enterRoom: 320 84 290 84)
			)
		)
		(proc0_13 33)
		(gAddToPics doit:)
	)

	(method (doit)
		(super doit:)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(cond
				((< (gEgo x:) 10)
					(self leaveRoom: 23 -5 (gEgo y:))
				)
				((> (gEgo x:) 310)
					(self leaveRoom: 27 320 (gEgo y:))
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
			((or (OnButton event 46 31 98 47) (OnButton event 195 48 300 68))
				(Print 28 0) ; "You can observe ice pushed upward into a ridge by the pressure of freezing too quickly."
			)
		)
	)
)

