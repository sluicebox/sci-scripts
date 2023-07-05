;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7923)
(include sci.sh)
(use Main)
(use Location)
(use n132)

(public
	ocMorphGateNW 0
)

(instance ocMorphGateNW of CloseupLocation
	(properties
		heading 270
	)

	(method (init)
		(proc132_0)
		(super init: 7957)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
	)

	(method (dispose)
		(proc132_1)
		(super dispose: &rest)
	)
)

