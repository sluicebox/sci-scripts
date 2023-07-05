;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9520)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v52 0
)

(instance rm9v52 of ShiversRoom
	(properties
		picture 9520
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitUp init: 4)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (<= newRoomNumber 9500) (proc951_11 6 9000)) ; rm9v50
			(gSounds fade: 20908 0 10 16 1 0)
			(gSounds fade: 20910 0 10 16 1 0)
			(gSounds stop: 20903)
			(proc951_9 20903)
			(gSounds play: 20903 -1 0 0)
			(gSounds fade: 20903 42 10 16 0 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9550
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9530
	)
)

(instance efExitUp of ExitFeature
	(properties
		nsLeft 21
		nsTop 0
		nsRight 243
		nsBottom 30
		nextRoom 9521
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9480
	)

	(method (init)
		(self
			createPoly: 35 60 64 73 118 79 174 90 174 115 162 127 98 135 54 127
		)
		(super init: &rest)
	)
)

