;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29031)
(include sci.sh)
(use Main)
(use n951)

(public
	rm29v031 0
)

(instance rm29v031 of ShiversRoom
	(properties
		picture 29031
	)

	(method (init)
		(if (IsFlag 43)
			(self picture: 29034)
		else
			(self picture: 29031)
		)
		(efExitCamera init: 3)
		(efExitUp init: 4)
		(super init: &rest)
	)
)

(instance efExitCamera of ExitFeature
	(properties
		nextRoom 29520
	)

	(method (init)
		(self createPoly: 203 98 211 85 238 85 251 89 252 97 225 107 203 98)
		(super init: &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 29030
	)

	(method (init)
		(self createPoly: 1 45 262 45 262 1 1 1 1 45)
		(super init: &rest)
	)
)

