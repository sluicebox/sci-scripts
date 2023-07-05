;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10500)
(include sci.sh)
(use Main)
(use n951)

(public
	rm10v500 0
)

(instance rm10v500 of ShiversRoom
	(properties
		picture 10500
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(efExitID init: 0)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 1)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10140
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10510
	)

	(method (init)
		(self
			createPoly:
				68
				142
				76
				130
				60
				117
				47
				90
				43
				72
				48
				50
				55
				35
				83
				16
				91
				10
				157
				9
				174
				21
				197
				40
				209
				61
				205
				76
				202
				97
				194
				107
				181
				118
				173
				121
				162
				121
				151
				111
				132
				117
				145
				129
				161
				122
				174
				122
				184
				142
		)
		(super init: &rest)
	)
)

(instance efExitID of ExitFeature
	(properties
		nextRoom 10122
	)

	(method (init)
		(self createPoly: 145 128 134 117 151 112 161 120)
		(super init: &rest)
	)
)

