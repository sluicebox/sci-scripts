;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24501)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v501 0
)

(instance rm24v501 of ShiversRoom
	(properties
		picture 24501
	)

	(method (init)
		(proc951_16 107)
		(efExitBack init: 8)
		(efExitBook init: 0)
		(efExitBethPointing init: 0)
		(efExitMerrPointing init: 0)
		(efExitBethLaughing init: 0)
		(efExitMerrBadFlash init: 0)
		(if (== gPrevRoomNum 24390) ; rm24v390
			(gSounds play: 12401 0 82 0)
		)
		(if
			(or
				(== gPrevRoomNum 24505) ; rm24v505
				(== gPrevRoomNum 24507) ; rm24v507
				(== gPrevRoomNum 24509) ; rm24v509
				(== gPrevRoomNum 24506) ; rm24v506
			)
			(gSounds play: 12419 0 82 0)
		)
		(if (or (== gPrevRoomNum 24502) (== gPrevRoomNum 24504)) ; rm24v502, rm24v504
			(gSounds play: 12421 0 82 0)
		)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 24390
	)

	(method (init)
		(self
			createPoly:
				0
				1
				261
				1
				261
				143
				1
				143
				0
				2
				32
				11
				32
				94
				229
				94
				229
				11
				32
				11
		)
		(super init: &rest)
	)
)

(instance efExitBook of ExitFeature
	(properties
		nextRoom 24502
	)

	(method (init)
		(self
			createPoly:
				161
				15
				127
				18
				130
				44
				156
				47
				151
				73
				174
				68
				201
				66
				219
				52
				225
				43
				163
				15
				160
				15
		)
		(super init: &rest)
	)
)

(instance efExitBethPointing of ExitFeature
	(properties
		nextRoom 24505
	)

	(method (init)
		(self createPoly: 36 60 41 28 96 47 88 69 73 64 60 64 49 61 36 61 36 60)
		(super init: &rest)
	)
)

(instance efExitMerrPointing of ExitFeature
	(properties
		nextRoom 24506
	)

	(method (init)
		(self
			createPoly:
				93
				41
				152
				48
				147
				74
				142
				77
				128
				77
				124
				47
				98
				50
				92
				44
				92
				41
		)
		(super init: &rest)
	)
)

(instance efExitBethLaughing of ExitFeature
	(properties
		nextRoom 24507
	)

	(method (init)
		(self createPoly: 97 52 121 49 126 76 118 77 113 75 97 74 89 70 97 52)
		(super init: &rest)
	)
)

(instance efExitMerrBadFlash of ExitFeature
	(properties
		nextRoom 24509
	)

	(method (init)
		(self createPoly: 67 23 68 37 90 44 90 38 127 43 125 19 68 23)
		(super init: &rest)
	)
)

