;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	rm500 0
)

(instance rm500 of Room
	(properties
		picture 500
	)

	(method (init)
		(if (== gPrevRoomNum 100)
			(gGlobalSound1 number: 922 setLoop: 1 play:)
		)
		(if (and (gPqFlags test: 27) (!= gPrevRoomNum 170))
			(= picture 502)
		else
			(if (gPqFlags test: 29)
				(PalVary 8 500) ; PalVaryNewSource
			)
			(= picture 500)
		)
		(gGame handsOff:)
		(gTheIconBar disable:)
		(super init: &rest)
		(self setScript: sEnter)
	)

	(method (dispose)
		(gTheIconBar enable:)
		(super dispose:)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(if (== gPrevRoomNum 100)
					(gMessager say: 0 0 1 1 self) ; "Monday 5:30 AM Parker Center, Los Angeles, CA"
					(gGlobalSound0 number: 500 setLoop: 1 play: self)
				else
					(if (== gPrevRoomNum 170)
						(gMessager say: 0 0 2 1 self) ; "Tuesday, 9:00 AM Parker Center, Los Angeles, CA"
					else
						(self cue:)
					)
					(gGlobalSound0 number: 501 setLoop: 1 play: self)
				)
			)
			(2)
			(3
				(cond
					((== gPrevRoomNum 100)
						(gPqFlags clear: 27)
						(gCurRoom newRoom: 545)
					)
					((== gPrevRoomNum 170)
						(gPqFlags clear: 27)
						(gCurRoom newRoom: 545)
					)
					(else
						(gCurRoom newRoom: 505)
					)
				)
				(self dispose:)
			)
		)
	)
)

