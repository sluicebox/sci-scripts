;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8160)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use Actor)
(use System)

(public
	rm8v160 0
)

(instance rm8v160 of ShiversRoom
	(properties
		picture 8160
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (proc951_11 1 8000)
			(if (and (!= gPrevRoomNum 8140) (!= gPrevRoomNum 8170)) ; rm8v140, rm8v170
				(gSounds stop: 20803)
				(proc951_7 20803)
				(proc951_9 20803)
				(gSounds play: 20803 -1 50 0)
			)
			(= picture 8161)
			(waxGuy init:)
		)
		(super init: &rest)
		(if (proc951_11 1 8000)
			(self setScript: sAttack)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8170
	)
)

(instance waxGuy of View
	(properties
		x 131
		y 96
		priority 1
		fixPriority 1
		view 51084
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 51080 self waxGuy)
			)
			(1
				(efExitRight dispose:)
				(efExitLeft dispose:)
				(proc925_0 self)
			)
			(2
				(efExitLeft init: 2)
				(efExitRight init: 1)
				(if (proc951_11 1 8000)
					(proc951_7 20802)
					(proc951_9 20802)
					(gSounds play: 20802 -1 50 0)
					(proc951_9 20803)
					(gSounds play: 20803 -1 50 0)
					(= state 0)
					(proc925_1 51080 self waxGuy 1)
				else
					(proc951_7 20801)
					(proc951_9 20801)
					(gSounds play: 20801 -1 0 0)
					(gSounds fade: 20801 66 5 8 0 0)
					(self dispose:)
				)
			)
		)
	)
)

