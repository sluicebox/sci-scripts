;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12345)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)

(public
	roGeneric 0
)

(instance roGeneric of TPRoom
	(properties
		picture 0
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn:)
	)

	(method (gimme))
)

