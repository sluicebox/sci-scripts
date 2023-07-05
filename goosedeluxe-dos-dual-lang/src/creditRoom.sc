;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 118)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	creditRoom 0
)

(local
	local0
)

(instance creditRoom of Room
	(properties
		picture 504
	)

	(method (init)
		(if (>= (GetTime 3) 7905) ; SysDate
			(= picture 506)
		)
		(= local0 global511)
		(= global511 0)
		(gGame setCursor: 10)
		(super init:)
		(gMouseDownHandler add: self)
		(self setScript: sCredits)
		(gGame handsOn:)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(= global511 local0)
		(super dispose:)
	)

	(method (doVerb)
		(script cue:)
	)
)

(instance sCredits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(gCurRoom drawPic: 505)
				(= seconds 10)
			)
			(2
				(= seconds 10)
			)
			(3
				(gCurRoom newRoom: 90) ; intro
			)
		)
	)
)

