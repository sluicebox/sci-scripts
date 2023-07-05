;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7921)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n132)
(use newYorkRegion)
(use Actor)

(public
	ocMorphBBNorth 0
)

(instance ocMorphBBNorth of CloseupLocation
	(properties
		heading 0
	)

	(method (init)
		(super init: 7955)
		(= plane global116)
		(proc132_0)
		(self edgeW: 0 edgeE: 0)
		(laser init:)
	)

	(method (dispose)
		(proc132_1)
		(super dispose: &rest)
	)
)

(instance laser of View
	(properties
		x 117
		y 53
		cel 4
		view 7913
	)

	(method (init)
		(if (== (proc70_9 16) 7921)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc201_1 23)
				(self hide:)
				(proc70_1 16)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

