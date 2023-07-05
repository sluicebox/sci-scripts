;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22260)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use n22001)
(use Actor)
(use System)

(public
	rm22v260 0
)

(instance rm22v260 of ShiversRoom
	(properties
		picture 22260
	)

	(method (init)
		(efExitBack init: 8)
		(if (proc951_11 1 22000)
			(= picture 22261)
			((View new:) view: 22260 loop: 1 setPri: 7 1 init:)
			(waxGuy init:)
		)
		(super init: &rest)
		(if (proc951_11 1 22000)
			(self setScript: sAttack)
		)
	)

	(method (newRoom newRoomNumber)
		(if (proc951_11 1 22000)
			(proc951_9 20803)
			(gSounds play: 20803 -1 50 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 22100
	)

	(method (init)
		(self
			createPoly:
				0
				0
				0
				143
				91
				143
				92
				60
				116
				35
				137
				36
				150
				59
				150
				142
				262
				142
				262
				0
				0
				0
		)
		(super init: &rest)
	)
)

(instance waxGuy of View
	(properties
		priority 10
		fixPriority 1
		view 22260
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 51220 self waxGuy)
			)
			(1
				(efExitBack dispose:)
				(proc925_0 self)
			)
			(2
				(efExitBack init: 8)
				(if (proc951_11 1 22000)
					(proc951_9 22212)
					(gSounds play: 22212 -1 50 0)
					(proc951_9 20803)
					(gSounds play: 20803 -1 50 0)
					(proc925_1 51220 self waxGuy 1)
					(= state 0)
				else
					(proc951_9 22201)
					(gSounds play: 22201 -1 0 0)
					(gSounds fade: 22201 74 5 16 0 0)
					(proc22001_0)
					(self dispose:)
				)
			)
		)
	)
)

