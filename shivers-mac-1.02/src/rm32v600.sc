;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32600)
(include sci.sh)
(use Main)

(public
	rm32v600 0
)

(instance rm32v600 of ShiversRoom
	(properties
		picture 32600
	)

	(method (init)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 32040
	)

	(method (init)
		(self
			createPoly: 0 0 0 143 262 142 262 113 250 117 225 121 198 117 130 109 112 109 81 114 44 120 30 120 19 116 16 113 11 87 97 53 263 72 262 1 0 0
		)
		(super init: &rest)
	)
)

