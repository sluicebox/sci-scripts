;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1140)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use System)

(public
	rm1140 0
)

(instance rm1140 of PQRoom
	(properties
		picture 1140
	)

	(method (init)
		(Load rsAUDIO 10314)
		(super init: &rest)
		(self setScript: killElement)
	)
)

(instance killElement of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 11400 1 0 0 0 -1 1)
			)
			(1
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(2
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(3
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

