;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1101)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	resRegion 0
)

(instance resRegion of Rgn
	(properties
		keep 1
	)

	(method (doVerb))

	(method (init)
		(super init: &rest)
		(self setScript: fadeUpDown)
	)
)

(instance fadeUpDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 6))
			)
			(1
				(gGk2Music fade: 0 18 10 0)
				(= seconds 3)
			)
			(2
				(= seconds (Random 3 6))
			)
			(3
				(gGk2Music fade: 63 18 10 0)
				(= seconds 3)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

