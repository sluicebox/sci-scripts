;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use eRoom)
(use Interface)

(public
	Rm27 0
)

(instance Rm27 of eRoom
	(properties
		picture 27
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
			(26
				(self enterRoom: 169 235 169 182)
			)
			(else
				(self enterRoom: -5 103 25 103)
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
					(self leaveRoom: 28 -5 (gEgo y:))
				)
				((> (gEgo y:) 185)
					(self leaveRoom: 26 (gEgo x:) 235)
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
				(or
					(OnButton event 54 54 108 76)
					(OnButton event 228 123 292 153)
				)
				(Print 27 0) ; "You can observe ice pushed upward into a ridge by the pressure of freezing too quickly."
			)
		)
	)
)

