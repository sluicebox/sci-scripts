;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9380)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v38 0
)

(instance rm9v38 of ShiversRoom
	(properties
		picture 9380
	)

	(method (init)
		(if (IsFlag 43)
			(gSounds play: 10920 0 42 0)
			(ClearFlag 43)
		)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efLeftForward init: 3)
		(efRightForward init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (IsFlag 42)
			(cond
				((< 9700 newRoomNumber 9740) ; rm9v70, rm9v740
					(PrintDebug {fade to 8})
					(gSounds fade: 10908 8 15 8 0 0)
				)
				((== newRoomNumber 9340) ; rm9v34
					(PrintDebug {fade to 26})
					(gSounds fade: 10908 26 15 8 0 0)
				)
			)
		)
		(if
			(and
				(!= newRoomNumber 9390) ; rm9v39
				(!= newRoomNumber 9850) ; rm9v850
				(IsFlag 42)
				(proc951_11 0 9000)
			)
			(gSounds fade: 20908 0 10 16 1 0)
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
		nextRoom 9390
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9850
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9740
	)

	(method (init)
		(self createPoly: 158 120 141 120 136 112 138 80 158 81 166 114)
		(super init: &rest)
	)
)

(instance efLeftForward of ExitFeature
	(properties
		nextRoom 9340
	)

	(method (init)
		(self createPoly: 50 75 52 135 21 135 21 58 29 58)
		(super init: &rest)
	)
)

(instance efRightForward of ExitFeature
	(properties
		nextRoom 9730
	)

	(method (init)
		(self createPoly: 159 80 211 58 243 57 243 120 170 118)
		(super init: &rest)
	)
)

