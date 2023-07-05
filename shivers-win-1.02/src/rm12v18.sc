;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12180)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm12v18 0
)

(instance rm12v18 of ShiversRoom
	(properties
		picture 12180
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (IsFlag 9)
			(vColossus init:)
		)
		(if (IsFlag 10)
			(vBimini init:)
			(efExitBimini init: 3)
			(efExitForward2 init: 3)
			(if (!= [global118 15] 0)
				(vPotView init:)
				(vMask init:)
			)
		else
			(efExitForward init: 3)
		)
		(if (proc951_11 8 12000)
			(proc951_7 21212)
			(gSounds play: 21212 -1 50 0)
			(gSounds fade: 21210 0 10 8 1 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 8 12000) (!= newRoomNumber 12140)) ; rm12v14
			(proc951_7 21210)
			(gSounds play: 21210 -1 0 0)
			(gSounds fade: 21210 15 10 8 0 0)
			(gSounds fade: 21212 0 10 8 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance vMask of View
	(properties
		priority 30
		fixPriority 1
		view 12220
		loop 1
	)
)

(instance vPotView of View
	(properties
		x 144
		y 130
		view 0
	)

	(method (init)
		(self view: [global118 15] loop: 2)
		(super init: &rest)
		(self setScale: scaleX: 17 scaleY: 17 setPri: 20)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12240
	)

	(method (init)
		(if (IsFlag 9)
			(self
				createPoly:
					41
					0
					53
					33
					55
					55
					51
					61
					51
					82
					27
					121
					29
					130
					28
					135
					23
					142
					77
					142
					92
					142
					92
					0
					41
					0
			)
		else
			(self createPoly: 0 0 25 0 25 144 0 144 0 0)
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12230
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12140
	)

	(method (init)
		(self
			createPoly:
				135
				31
				101
				47
				78
				104
				41
				142
				222
				142
				182
				104
				178
				50
				135
				30
		)
		(super init: &rest)
	)
)

(instance efExitForward2 of ExitFeature
	(properties
		nextRoom 12140
	)

	(method (init)
		(self createPoly: 137 29 98 49 94 108 195 108 175 48 137 29)
		(super init: &rest)
	)
)

(instance efExitBimini of ExitFeature
	(properties
		nextRoom 12181
	)

	(method (init)
		(self
			createPoly:
				123
				111
				135
				108
				152
				108
				159
				110
				159
				136
				148
				139
				133
				139
				122
				136
				123
				129
				123
				112
		)
		(super init: &rest)
	)
)

(instance vBimini of View
	(properties
		priority 10
		fixPriority 1
		view 12220
	)
)

(instance vColossus of View
	(properties
		priority 10
		fixPriority 1
		view 12220
		cel 1
	)
)

