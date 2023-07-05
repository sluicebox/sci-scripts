;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7924)
(include sci.sh)
(use Main)
(use Location)
(use n132)

(public
	ocMorphGateSW 0
)

(instance ocMorphGateSW of CloseupLocation
	(properties
		heading 270
	)

	(method (init)
		(proc132_0)
		(super init: 7958)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
	)

	(method (dispose)
		(proc132_1)
		(super dispose: &rest)
	)
)

