;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12070)
(include sci.sh)
(use Main)
(use n951)

(public
	rm12v07 0
)

(instance rm12v07 of ShiversRoom
	(properties
		picture 12070
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efPlaque init: 3)
		(super init: &rest)
		(if (proc951_11 6 12000)
			(proc951_7 21212)
			(gSounds play: 21212 -1 50 0)
			(gSounds fade: 21210 0 10 8 1 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12100
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12080
	)

	(method (init)
		(self createPoly: 57 143 95 109 97 62 161 62 165 105 164 137 173 147)
		(super init: &rest)
	)
)

(instance efPlaque of ExitFeature
	(properties
		nextRoom 12580
	)

	(method (init)
		(self createPoly: 171 107 171 105 184 95 191 94 193 100 179 112 175 111)
		(super init: &rest)
	)
)

