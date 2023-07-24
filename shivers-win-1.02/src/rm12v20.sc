;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12200)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use System)

(public
	rm12v20 0
)

(instance rm12v20 of ShiversRoom
	(properties
		picture 12200
	)

	(method (init)
		(super init: &rest)
		(efExitBack init: 8)
		(if (proc951_11 8 12000)
			(self setScript: sAttack)
		)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 12190
	)

	(method (init)
		(self
			createPoly: 36 143 60 116 60 98 53 98 66 68 186 68 199 93 199 122 218 145 264 145 264 0 0 0 0 143
		)
		(super init: &rest)
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 58120 self)
			)
			(1
				(efExitBack dispose:)
				(proc925_0 self)
			)
			(2
				(efExitBack init: 8)
				(if (proc951_11 8 12000)
					(proc951_9 21212)
					(gSounds play: 21212 -1 50 0)
					(proc951_9 21910)
					(gSounds play: 21910 -1 50 0)
					(= state 0)
					(proc925_1 58120 self 0 1)
				else
					(proc951_9 21210)
					(gSounds play: 21210 -1 0 0)
					(gSounds fade: 21210 15 10 8 0 0)
					(self dispose:)
				)
			)
		)
	)
)

