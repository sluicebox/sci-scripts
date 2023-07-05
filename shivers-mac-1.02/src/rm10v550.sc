;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10550)
(include sci.sh)
(use Main)
(use n951)

(public
	rm10v550 0
)

(instance rm10v550 of ShiversRoom
	(properties
		picture 10550
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(efLipstick init: 3)
		(efExitBox init: 3)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 1)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10100
	)

	(method (init)
		(self
			createPoly:
				74
				137
				63
				136
				42
				108
				35
				70
				40
				50
				53
				31
				72
				15
				72
				0
				0
				0
				0
				57
				11
				57
				27
				57
				27
				72
				11
				72
				11
				57
				0
				57
				0
				143
				74
				143
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10110
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10040
	)

	(method (init)
		(self
			createPoly:
				74
				137
				63
				136
				42
				108
				35
				70
				40
				50
				53
				31
				72
				15
				96
				5
				165
				5
				184
				9
				200
				20
				214
				35
				225
				47
				230
				62
				233
				84
				229
				105
				216
				127
				200
				136
				185
				136
				183
				128
				157
				128
				157
				138
		)
		(super init: &rest)
	)
)

(instance efExitBox of ExitFeature
	(properties
		nextRoom 10101
	)

	(method (init)
		(self createPoly: 11 57 27 57 27 72 11 72)
		(super init: &rest)
	)
)

(instance efLipstick of ExitFeature
	(properties
		nextRoom 10060
	)

	(method (init)
		(self createPoly: 159 143 156 128 182 128 188 143)
		(super init: &rest)
	)
)

