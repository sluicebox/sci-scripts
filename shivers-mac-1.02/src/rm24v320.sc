;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24320)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm24v320 0
)

(instance rm24v320 of ShiversRoom
	(properties
		picture 24320
		invView 2
	)

	(method (init)
		(if (IsFlag 67)
			(self initRoom: 115 133 105 126)
			(psInChest init:)
		)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitPlaque init: 3)
		(spSkeleton init:)
		(vSkeletonBack init:)
		(super init: &rest)
	)
)

(instance psInChest of PotSpot
	(properties
		nsLeft 115
		nsTop 105
		nsRight 133
		nsBottom 126
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24330
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24350
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 24830
	)

	(method (init)
		(self
			createPoly: 167 87 164 98 164 99 167 99 171 128 156 135 165 140 195 140 195 137 187 129 177 128 185 87 167 87
		)
		(super init: &rest)
	)
)

(instance spSkeleton of ShiversProp
	(properties
		priority 40
		fixPriority 1
		view 24320
		cycleSpeed 12
	)

	(method (init)
		(self
			createPoly: 116 32 105 37 101 52 90 82 96 87 96 125 74 132 80 137 123 141 157 134 135 124 135 90 142 79 132 53 130 42 122 33 116 32
		)
		(if (IsFlag 67)
			(self setCel: 5)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 153)
		(if (not (IsFlag 67))
			(self setScript: sSkeletonFalls)
		)
	)
)

(instance vSkeletonBack of View
	(properties
		priority 20
		fixPriority 1
		view 24320
		loop 1
	)
)

(instance sSkeletonFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom initRoom: 115 133 105 126)
				(psInChest init:)
				(gSounds play: 12409 0 82 0)
				(gSounds play: 12410 0 82 0)
				(spSkeleton setCycle: End self)
			)
			(1
				(SetFlag 67)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

