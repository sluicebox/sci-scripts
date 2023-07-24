;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10130)
(include sci.sh)
(use Main)

(public
	rm10v130 0
)

(instance rm10v130 of ShiversRoom
	(properties
		picture 10130
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(efExitDown init: 0)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10510
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10510
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10140
	)

	(method (init)
		(self
			createPoly: 88 125 102 104 89 99 81 89 76 82 73 67 75 45 93 27 110 19 159 18 163 21 175 27 188 38 197 54 198 73 193 90 188 102 175 111 183 125
		)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 10132
	)

	(method (init)
		(self createPoly: 138 144 162 131 194 135 190 142)
		(super init: &rest)
	)
)

