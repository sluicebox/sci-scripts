;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8100)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)

(public
	rm8v100 0
)

(local
	local0
)

(instance rm8v100 of ShiversRoom
	(properties
		picture 8100
		invView 2
	)

	(method (init)
		(vBackOfCupboard init:)
		(if (!= [global118 5] 0)
			(vPotView init:)
		)
		(efExitUp init: 4)
		(cupboard init:)
		(= local0 0)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if local0
			(gSounds play: 10802 0 32 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance psInCupboard of PotSpot
	(properties
		nsLeft 104
		nsTop 57
		nsRight 160
		nsBottom 117
	)
)

(instance vBackOfCupboard of View
	(properties
		priority 10
		fixPriority 1
		view 8100
		loop 1
	)
)

(instance vPotView of View
	(properties
		x 132
		y 117
		view 0
	)

	(method (init)
		(self view: [global118 5] loop: 2)
		(super init: &rest)
		(self setScale: scaleX: 102 scaleY: 102 setPri: 15)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nsLeft 21
		nsTop 0
		nsRight 243
		nsBottom 30
		nextRoom 8080
	)
)

(instance cupboard of ShiversProp
	(properties
		priority 255
		fixPriority 1
		view 8100
	)

	(method (doVerb)
		(if local0
			(if (!= [global118 5] 0)
				(vPotView init:)
			)
			(psInCupboard dispose:)
			(if (!= global106 0)
				(gShiversRoomItem dispose:)
			)
			(gSounds play: 10802 0 32 0)
			(= local0 0)
			(self setCycle: Beg createPoly: 67 24 202 24 194 123 73 123)
		else
			(gCurRoom initRoom: 104 160 57 117)
			(psInCupboard init:)
			(vPotView dispose:)
			(gSounds play: 10801 0 32 0)
			(= local0 1)
			(self
				setCycle: End
				createPoly: 189 125 197 24 254 33 242 141 201 142
			)
		)
	)
)

