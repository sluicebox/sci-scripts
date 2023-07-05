;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7009)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)

(public
	octoAtriumMoCU 0
)

(instance octoAtriumMoCU of CloseupLocation
	(properties
		heading 225
	)

	(method (init)
		(super init: 7031)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exitToMo init:)
		(gCurRoom exitN: exitToMo)
	)
)

(instance exitToMo of ExitFeature
	(properties
		nsBottom 253
		nsLeft 180
		nsRight 414
		nsTop 35
		nextRoom 7400
	)
)

