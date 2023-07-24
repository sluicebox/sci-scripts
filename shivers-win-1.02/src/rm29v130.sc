;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29130)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm29v130 0
)

(instance rm29v130 of ShiversRoom
	(properties
		picture 29130
	)

	(method (init)
		(cond
			((IsFlag 61)
				(self picture: 29132)
				(if (IsFlag 68)
					((View new:) view: 29131 setPri: 5 1 init:)
				)
			)
			((IsFlag 68)
				(self picture: 29131)
			)
			(else
				(self picture: 29130)
			)
		)
		(efExitSaucer init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29120
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29180
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29090
	)

	(method (init)
		(self
			createPoly: 100 107 97 102 83 90 83 62 96 50 111 43 165 43 165 96 157 98 149 105 148 111 94 111 100 107
		)
		(super init: &rest)
	)
)

(instance efExitSaucer of ExitFeature
	(properties
		nextRoom 29080
	)

	(method (init)
		(self
			createPoly: 22 127 30 126 33 123 84 111 96 106 86 97 57 82 39 78 34 68 22 59 22 127
		)
		(super init: &rest)
	)
)

