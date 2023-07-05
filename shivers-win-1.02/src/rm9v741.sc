;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9741)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v741 0
)

(instance rm9v741 of ShiversRoom
	(properties
		picture 9741
	)

	(method (init)
		(efExitRight init: 1)
		(efBack init: 8)
		(efRightForward init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (IsFlag 42) (< 9000 newRoomNumber 9200)) ; rm9v20
			(gSounds fade: 10908 0 20 3 1 0)
			(PrintDebug {fade to 0})
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9730
	)
)

(instance efBack of ExitFeature
	(properties
		nextRoom 9740
	)

	(method (init)
		(self createPoly: 96 142 30 107 26 57 0 52 0 145)
		(super init: &rest)
	)
)

(instance efRightForward of ExitFeature
	(properties
		nextRoom 9140
	)

	(method (init)
		(self createPoly: 170 127 198 96 200 61 202 25 242 28 243 143)
		(super init: &rest)
	)
)

