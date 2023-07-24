;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12181)
(include sci.sh)
(use Main)
(use Actor)

(public
	rm12v181 0
)

(instance rm12v181 of ShiversRoom
	(properties
		picture 12181
		invView 2
	)

	(method (init)
		(self initRoom: 119 149 70 98)
		(psInBimini init:)
		(vMask init:)
		(efExitBack init: 8)
		(efBlueprints init: 0)
		(super init: &rest)
	)
)

(instance psInBimini of PotSpot
	(properties
		nsLeft 119
		nsTop 70
		nsRight 149
		nsBottom 98
	)
)

(instance vMask of View
	(properties
		priority 30
		fixPriority 1
		view 12181
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 12180
	)

	(method (init)
		(self
			createPoly: 263 0 262 67 172 67 176 60 176 47 163 41 144 38 123 38 99 41 84 45 83 49 84 62 91 68 94 85 88 91 84 100 87 108 100 117 117 121 138 121 156 118 171 109 173 103 173 92 169 90 171 71 263 71 265 143 0 143 0 0 263 0
		)
		(super init: &rest)
	)
)

(instance efBlueprints of ExitFeature
	(properties
		nextRoom 12182
	)

	(method (init)
		(self createPoly: 113 94 128 106 137 105 137 97 112 83 112 94)
		(super init: &rest)
	)
)

