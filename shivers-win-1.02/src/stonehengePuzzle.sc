;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1214)
(include sci.sh)
(use Main)
(use n951)
(use Array)
(use Motion)
(use Actor)
(use System)

(public
	stonehengePuzzle 0
)

(local
	local0
	local1
	[local2 6] = [7 1 9 5 11 3]
)

(procedure (localproc_0 &tmp temp0)
	(= local0 1)
	(for ((= temp0 0)) (< temp0 6) ((++ temp0))
		(if (!= [local2 temp0] ((local1 at: temp0) cel:))
			(= local0 0)
		)
	)
	(if local0
		(SetFlag 1)
		(gCurRoom setScript: doorOpenScript)
		(proc951_15 6750)
	)
)

(instance stonehengePuzzle of ShiversRoom
	(properties
		picture 1214
	)

	(method (init &tmp temp0)
		(super init:)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitUp init: 4)
		(if (IsFlag 1)
			(gCurRoom newRoom: 1220) ; rm1v220
		else
			(= local0 0)
			(= local1 (IntArray new: 6))
			(for ((= temp0 0)) (< temp0 6) ((++ temp0))
				(local1 at: temp0 ((piece new:) init: temp0 yourself:))
				(switch temp0
					(0
						((local1 at: temp0) createPoly: 71 39 130 11 130 66)
					)
					(1
						((local1 at: temp0) createPoly: 137 10 195 38 138 66)
					)
					(2
						((local1 at: temp0) createPoly: 141 71 199 42 199 99)
					)
					(3
						((local1 at: temp0) createPoly: 138 132 138 77 196 105)
					)
					(4
						((local1 at: temp0) createPoly: 72 104 130 76 130 132)
					)
					(5
						((local1 at: temp0) createPoly: 125 72 67 101 67 45)
					)
				)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (not local0)
			(localproc_0)
		)
	)

	(method (newRoom &tmp temp0)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(= [global322 temp0] ((local1 at: temp0) cel:))
		)
		(super newRoom: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1211
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1212
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 1210
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 20 0 243 0 243 20 152 20 137 10 130 11 110 20 20 20)
	)
)

(instance efExitDown of ExitFeature ; UNUSED
	(properties
		nextRoom 1220
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				76
				39
				130
				11
				137
				10
				195
				38
				199
				42
				199
				99
				196
				105
				138
				132
				130
				132
				72
				104
				67
				101
				67
				45
		)
	)
)

(instance backPiece of Prop
	(properties
		priority 10
		fixPriority 1
		view 1211
	)
)

(instance piece of ShiversProp
	(properties
		priority 11
		fixPriority 1
	)

	(method (init param1)
		(= view (+ 1213 (/ param1 3)))
		(= loop (mod param1 3))
		(= cel [global322 param1])
		(super init: &rest)
	)

	(method (doVerb &tmp temp0)
		(if (== cycler 0)
			(gSounds stop: 10109)
			(gSounds play: 10109 0 90 0)
			(if (>= cel 11)
				(self cycleSpeed: 12 setCycle: End self)
			else
				(self cycleSpeed: 15 setCycle: CT (mod (+ cel 2) 12) 1)
			)
		)
	)

	(method (cue)
		(self cel: 0 setCycle: CT 1 1)
	)
)

(instance doorOpenScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 10110 0 90 0)
				(= cycles 1)
			)
			(1
				(backPiece
					view: 1210
					loop: 0
					cel: 0
					cycleSpeed: 12
					priority: 12
					setCycle: End self
					init:
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(gGame handsOn:)
				(gCurRoom newRoom: 1220) ; rm1v220
			)
		)
	)
)

