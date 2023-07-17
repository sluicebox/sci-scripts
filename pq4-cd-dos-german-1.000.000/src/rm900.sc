;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 900)
(include sci.sh)
(use Main)
(use Game)
(use Actor)
(use System)

(public
	rm900 0
)

(instance rm900 of Room
	(properties
		picture 900
	)

	(method (init)
		(if (IsHiRes)
			(= picture 10900)
		)
		(gGame handsOff:)
		(if (and (== gDay 3) (== gPrevRoomNum 780))
			(if (IsHiRes)
				(= picture 10901)
			else
				(PalVary 8 900) ; PalVaryNewSource
				(barSign init:)
			)
		)
		(super init: &rest)
		(self setScript: waitScr)
		(gTheIconBar show: 0)
	)

	(method (dispose)
		(if (and (== gDay 3) (== gPrevRoomNum 780))
			(PalVary 3) ; PalVaryKill
		)
		(super dispose:)
	)
)

(instance barSign of View
	(properties
		x 153
		y 84
		view 1900
	)
)

(instance waitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(if (and (== gDay 3) (not (gPqFlags test: 43)))
					(gCurRoom newRoom: 905)
				else
					(gCurRoom newRoom: 910)
				)
			)
		)
	)
)

