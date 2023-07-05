;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 470)
(include sci.sh)
(use System)

(class GinRummyStrategy of Code
	(properties)

	(method (think param1 &tmp [temp0 2])
		(param1 at: (Random 0 (- (param1 size:) 1)))
	)
)

