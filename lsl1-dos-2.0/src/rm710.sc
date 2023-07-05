;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 710)
(include sci.sh)
(use Main)
(use eRS)
(use System)

(public
	rm710 0
)

(instance rm710 of LLRoom
	(properties
		picture 700
	)

	(method (init)
		(gGame setCursor: 900 1 350 185)
		(Load rsPIC 710)
		(gTheIconBar disable:)
		(super init:)
		(gTheMusic number: 700 loop: -1 vol: 127 flags: 1 play:)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gCurRoom style: 42 setScript: sRoom 0 710)
	)

	(method (newRoom newRoomNumber)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event type:)
			(event claimed: 1)
			(gCurRoom newRoom: 720)
		)
	)
)

(instance sRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(gCurRoom drawPic: register)
				(if (== register 710)
					(= register 700)
					(gCurRoom style: 43)
				else
					(= register 710)
					(gCurRoom style: 42)
				)
				(-- state)
				(= seconds 10)
			)
		)
	)
)

