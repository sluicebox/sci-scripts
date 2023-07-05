;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25050)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm25v5 0
)

(instance rm25v5 of ShiversRoom
	(properties
		picture 25050
		invView 1
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(if (IsFlag 25)
			(self initRoom: 140 170 85 125)
			(psOnShelf init:)
			(aFabric x: -35 init:)
		else
			(aFabric init:)
			(hsFabric init:)
			(if (!= [global118 35] 0)
				(vPotView init:)
			)
		)
		(super init: &rest)
		(if (proc951_11 4 25000)
			(self setScript: sAttack)
		)
	)

	(method (newRoom newRoomNumber)
		(if (proc951_11 4 25000)
			(gSounds fade: 22512 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance psOnShelf of PotSpot
	(properties
		nsLeft 140
		nsTop 85
		nsRight 170
		nsBottom 125
	)
)

(instance vPotView of View
	(properties
		x 155
		y 125
		view 0
	)

	(method (init)
		(self view: [global118 35] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 68 scaleY: 68 setPri: 10)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 25040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 25040
	)
)

(instance aFabric of Actor
	(properties
		x 15
		y 15
		priority 45
		fixPriority 1
		view 25050
		cel 1
	)
)

(instance hsFabric of HotSpot
	(properties)

	(method (init)
		(self
			createPoly:
				93
				105
				82
				110
				76
				126
				86
				133
				125
				134
				173
				129
				162
				112
				151
				109
				142
				101
				134
				99
				128
				94
				109
				95
				99
				100
				94
				104
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (not (proc951_11 4 25000))
			(vPotView dispose:)
			(gCurRoom initRoom: 140 170 85 125)
			(psOnShelf init:)
			(aFabric moveSpeed: 2 setMotion: MoveTo -35 15 0)
			(SetFlag 25)
		)
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 54250 self)
			)
			(1
				(efExitRight dispose:)
				(efExitLeft dispose:)
				(proc925_0 self)
			)
			(2
				(efExitLeft init: 7)
				(efExitRight init: 6)
				(if (proc951_11 4 25000)
					(proc951_9 22506)
					(gSounds play: 22506 -1 50 0)
					(proc951_9 22512)
					(gSounds play: 22512 -1 50 0)
					(proc925_1 54250 self 0 1)
					(= state 0)
				else
					(proc951_9 22501)
					(gSounds play: 22501 -1 0 0)
					(gSounds fade: 22501 74 5 16 0 0)
					(self dispose:)
				)
			)
		)
	)
)

