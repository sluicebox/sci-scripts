;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23160)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use Actor)
(use System)

(public
	rm23v160 0
)

(instance rm23v160 of ShiversRoom
	(properties
		picture 23160
	)

	(method (init)
		(efExitBack init: 8)
		(if (proc951_11 5 23000)
			(= picture 23161)
			(woodGuy init:)
		)
		(super init: &rest)
		(if (proc951_11 5 23000)
			(self setScript: sAttack)
		)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 23060
	)

	(method (init)
		(self
			createPoly:
				1
				0
				1
				89
				48
				89
				48
				117
				40
				142
				90
				142
				96
				137
				96
				27
				86
				21
				86
				9
				184
				9
				184
				22
				171
				27
				171
				142
				262
				142
				262
				4
				262
				0
				2
				0
		)
		(super init: &rest)
	)
)

(instance woodGuy of View
	(properties
		x 133
		y 143
		priority 1
		fixPriority 1
		view 55234
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 55230 self woodGuy)
			)
			(1
				(efExitBack dispose:)
				(proc925_0 self)
			)
			(2
				(efExitBack init: 8)
				(if (proc951_11 5 23000)
					(proc951_9 22313)
					(gSounds play: 22313 -1 114 0)
					(proc951_9 20702)
					(gSounds play: 20702 -1 32 0)
					(proc925_1 55230 self woodGuy 1)
					(= state 0)
				else
					(proc951_9 22301)
					(gSounds play: 22301 -1 0 0)
					(gSounds fade: 22301 82 5 16 0 0)
					(self dispose:)
				)
			)
		)
	)
)

