;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	Room8 0
)

(instance Room8 of Rm
	(properties
		picture 8
	)

	(method (init)
		(= north 2)
		(= south 14)
		(= east 9)
		(= west 7)
		(= horizon 68)
		(= gIndoors 0)
		(if gNight
			(= picture 108)
		)
		(super init:)
		(gEgo view: 2 init:)
		(self setRegions: 506 514) ; meadReg, regPan
	)

	(method (newRoom newRoomNumber)
		(if (gCast contains: global172)
			(= global211 global160)
			(= global212 global159)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said '/door')
					(Print 8 0) ; "You can't see the door from here."
				)
				((Said '/window>')
					(cond
						((Said 'open')
							(Print 8 1) ; "The windows do not open."
						)
						((Said 'break')
							(Print 8 2) ; "That's vandalism!"
						)
						((Said 'look')
							(if (gEgo inRect: 10 134 57 140)
								(Print 8 3) ; "You peek through the window, but can make out no details."
							else
								(Print 800 1) ; "You're not close enough."
							)
						)
					)
				)
			)
			(if (Said 'look>')
				(cond
					((Said '/cottage')
						(Print 8 4) ; "You see the back of an old shack."
					)
					((Said '[<around][/room]')
						(Print 8 5) ; "A beautiful green meadow, dotted with wildflowers, serves as the fisherman's spacious back yard. The flowers' sweet scent fills the air."
					)
				)
			)
		)
	)
)

