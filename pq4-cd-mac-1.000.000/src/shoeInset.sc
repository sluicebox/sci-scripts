;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use Inset)
(use Actor)

(public
	shoeInset 0
)

(instance shoeInset of Inset
	(properties
		picture 870
		style 9
		disposeNotOnMe 1
		modNum 20
		noun 1
	)

	(method (init)
		(gGame fade: 100 0 10)
		(gTheIconBar disable: 3 7 6 show: 0)
		(Platform 0 2 1)
		(super init: &rest)
		(if (not (gEgo has: 20)) ; shoe
			(redShoe init:)
		)
		(FrameOut)
		(gGame fade: 0 100 10)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (onMe param1)
		(return (and (<= 44 (param1 x:) 274) (<= 10 (param1 y:) 150)))
	)

	(method (dispose)
		(gGame fade: 100 0 10)
		(gTheIconBar enable: 0 3 7 6)
		(super dispose:)
		(FrameOut)
		(gGame fade: 0 100 10)
		(Platform 0 2 0)
		(DisposeScript 20)
	)
)

(instance redShoe of View
	(properties
		noun 2
		modNum 20
		x 97
		y 71
		view 871
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gEgo get: 20) ; shoe
			(gGame points: 4)
			(self dispose:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

