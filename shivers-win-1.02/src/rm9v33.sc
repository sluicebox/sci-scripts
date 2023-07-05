;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9330)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v33 0
)

(instance rm9v33 of ShiversRoom
	(properties
		picture 9330
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitUp init: 4)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (IsFlag 42) (== newRoomNumber 9690)) ; rm9v69
			(gSounds fade: 10908 0 20 3 1 0)
			(PrintDebug {fade to 0})
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9320
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9300
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 9331
	)

	(method (init)
		(self createPoly: 20 0 243 0 243 31 178 31 178 0 90 0 90 31 20 31)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9690
	)

	(method (init)
		(self createPoly: 90 0 90 31 97 54 73 82 187 81 167 57 178 31 178 0)
		(super init: &rest)
	)
)

