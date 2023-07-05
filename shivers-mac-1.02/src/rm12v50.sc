;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12500)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use System)

(public
	rm12v50 0
)

(instance rm12v50 of ShiversRoom
	(properties
		picture 12500
	)

	(method (init)
		(super init: &rest)
		(efExitBack init: 8)
		(if (proc951_11 6 12000)
			(self setScript: sAttack)
		)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 12080
	)

	(method (init)
		(self
			createPoly: 0 0 264 0 264 142 168 142 168 61 80 61 80 143 0 143 0 1
		)
		(super init: &rest)
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 56120 self)
			)
			(1
				(efExitBack dispose:)
				(proc925_0 self)
			)
			(2
				(efExitBack init: 8)
				(if (proc951_11 6 12000)
					(proc951_9 21212)
					(gSounds play: 21212 -1 50 0)
					(proc951_9 20910)
					(gSounds play: 20910 -1 50 0)
					(proc925_1 56120 self 0 1)
					(= state 0)
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

