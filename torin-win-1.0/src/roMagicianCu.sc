;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 53000)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use foEExit)

(public
	roMagicianCu 0
)

(instance foExit of CUExitFeature
	(properties
		rExitTo 50900
	)
)

(instance roMagicianCu of TPRoom
	(properties
		picture 53000
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 50900)
		(foExit init:)
		(gGame handsOn:)
	)

	(method (gimme))
)

