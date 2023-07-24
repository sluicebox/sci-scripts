;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21190)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v190 0
)

(instance rm21v190 of ShiversRoom
	(properties
		picture 21190
	)

	(method (init)
		(if (IsFlag 83)
			(= picture 21191)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitForwardRight init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21180
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21200
	)

	(method (init)
		(self
			createPoly: 40 140 40 115 83 88 83 40 100 40 100 100 95 104 95 109 101 110 116 110 121 107 121 102 118 100 117 98 117 40 131 40 153 40 153 86 178 106 178 142 40 142
		)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 21150
	)

	(method (init)
		(self createPoly: 199 109 199 84 242 36 242 82 237 90 237 119 199 110)
		(super init: &rest)
	)
)

