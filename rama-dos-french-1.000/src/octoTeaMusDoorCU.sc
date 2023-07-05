;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7802)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)

(public
	octoTeaMusDoorCU 0
)

(instance octoTeaMusDoorCU of CloseupLocation
	(properties
		heading 45
	)

	(method (init)
		(super init: 7814)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exitToMuseum init:)
		(self exitN: exitToMuseum)
	)
)

(instance exitToMuseum of ExitFeature
	(properties
		nsBottom 253
		nsLeft 180
		nsRight 414
		nsTop 35
		nextRoom 7601
	)
)

