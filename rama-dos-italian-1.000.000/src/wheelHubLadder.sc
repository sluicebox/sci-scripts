;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2039)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use Actor)

(public
	wheelHubLadder 0
)

(instance wheelHubLadder of CloseupLocation
	(properties
		picture 2284
	)

	(method (init)
		(super init: picture)
		(mazeControllerCard init:)
	)
)

(instance mazeControllerCard of View
	(properties
		x 84
		y 201
		loop 2
		view 2284
	)

	(method (init)
		(if (!= (proc70_9 47) gCurRoomNum)
			(return)
		)
		(super init: global117)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 47 0)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

