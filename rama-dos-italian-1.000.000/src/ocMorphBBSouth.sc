;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7922)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n132)
(use newYorkRegion)
(use Actor)

(public
	ocMorphBBSouth 0
)

(instance ocMorphBBSouth of CloseupLocation
	(properties
		heading 180
	)

	(method (init)
		(proc132_0)
		(super init: 7955)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(idCard init:)
	)

	(method (dispose)
		(proc132_1)
		(super dispose: &rest)
	)
)

(instance idCard of View
	(properties
		x 140
		y 17
		cel 2
		view 7913
	)

	(method (init)
		(if (== (proc70_9 109) 7922)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc201_1 24)
				(self hide:)
				(proc70_1 109)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

