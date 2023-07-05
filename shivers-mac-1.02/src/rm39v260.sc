;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39260)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use RandCycle)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	rm39v260 0
)

(instance rm39v260 of ShiversRoom
	(properties
		picture 39261
	)

	(method (init)
		(if (proc951_11 7 39000)
			(gSounds fade: 23905 82 5 16 0 0)
		else
			(gSounds play: 23903 -1 82 0)
		)
		((Prop new:)
			view: 39260
			cycleSpeed: 4
			setCycle: RandCycle
			setPri: 1 1
			init:
		)
		((Prop new:)
			view: 39260
			loop: 1
			cycleSpeed: 4
			setCycle: Fwd
			setPri: 1 1
			init:
		)
		((Prop new:)
			view: 39260
			loop: 2
			cycleSpeed: 4
			setCycle: Fwd
			setPri: 1 1
			init:
		)
		((Prop new:)
			view: 39260
			loop: 3
			cycleSpeed: 9
			setCycle: Rev
			setPri: 2 1
			init:
		)
		(if (== global547 9)
			(= picture 39260)
			((Prop new:)
				view: 39262
				cycleSpeed: 1
				setCycle: RandCycle
				setPri: 2 1
				init:
			)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
		(if (IsFlag 43)
			(gSounds play: 13909 0 82 0)
			(ClearFlag 43)
		)
		(if (proc951_11 7 39000)
			(self setScript: sAttack)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39250
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 57390 self)
			)
			(1
				(efExitRight dispose:)
				(efExitLeft dispose:)
				(proc925_0 self)
			)
			(2
				(efExitLeft init: 2)
				(efExitRight init: 1)
				(cond
					((proc951_11 7 39000)
						(proc951_9 23905)
						(proc951_9 23904)
						(gSounds play: 23905 -1 82 0)
						(gSounds play: 23904 -1 66 0)
						(= state 0)
						(proc925_1 57390 self 0 1)
					)
					((== global547 10)
						(gCurRoom newRoom: 935) ; closingMovie
					)
					(else
						(proc951_9 23903)
						(gSounds play: 23903 -1 82 0)
						(self dispose:)
					)
				)
			)
		)
	)
)

