;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21205)
(include sci.sh)
(use Main)

(public
	rm21v205 0
)

(instance rm21v205 of ShiversRoom
	(properties
		picture 21500
	)

	(method (init)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 21030
	)

	(method (init)
		(self
			createPoly: 0 0 262 0 262 143 0 143 0 1 69 45 47 86 140 127 195 76 173 19 111 10 70 45
		)
		(super init: &rest)
	)
)

