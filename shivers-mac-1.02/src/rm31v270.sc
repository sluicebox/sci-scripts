;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31270)
(include sci.sh)
(use Main)
(use n951)
(use n31001)
(use Array)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm31v270 0
)

(local
	[local0 9] = [3 0 6 4 -1 1 7 5 2]
	[local9 9] = [0 1 2 3 -1 4 5 6 7]
	local18
	[local19 9] = [37 61 84 108 132 156 180 204 227]
	[local28 9] = [30 54 78 101 125 149 173 197 220]
	[local37 9] = [1 0 1 4 1 2 3 6 5]
	[local46 9] = [3 4 5 6 7 4 7 8 7]
	local55
	local56
	local57
	[local58 9]
	[local67 9]
	local76
	local77
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 9) ((++ temp0))
		(if (!= (local18 at: temp0) [local9 temp0])
			(return 0)
		)
	)
	(return 1)
)

(instance rm31v270 of ShiversRoom
	(properties
		picture 31271
	)

	(method (init &tmp temp0 temp1)
		(proc31001_1)
		(gSounds fade: 23101 0 5 16 1 0)
		(proc951_9 23108)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(= local18 (IntArray with: 3 0 6 4 -1 1 7 5 2))
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(= [local58 temp0] (aBall new:))
			(= temp1 (local18 indexOf: temp0))
			([local58 temp0] cel: temp0 x: [local19 temp1] y: 65 init:)
		)
		(for ((= temp0 0)) (< temp0 9) ((++ temp0))
			(= [local67 temp0] (spFlipper new:))
			([local67 temp0] x: [local28 temp0] y: 70 pos: temp0 init:)
		)
		(super init: &rest)
	)

	(method (newRoom)
		(proc31001_0)
		(proc951_9 23101)
		(gSounds play: 23101 -1 0 0)
		(gSounds fade: 23101 90 5 16 0 0)
		(super newRoom: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31250
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31260
	)
)

(instance aBall of Actor
	(properties
		view 31271
		signal 18433
	)
)

(class spFlipper of ShiversProp
	(properties
		view 31271
		loop 1
		pos 0
	)

	(method (handleEvent event &tmp temp0)
		(event localize: gThePlane)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(gUser canControl:)
				(!= global184 1)
			)
			(event claimed: 1)
			(gSounds stop: 13109)
			(gSounds play: 13109 0 82 0)
			(= temp0 (event x:))
			(= local55 pos)
			(if (< temp0 (+ x 7))
				(= cel 2)
				(= local56 [local46 pos])
			else
				(= cel 1)
				(= local56 [local37 pos])
			)
			(UpdateScreenItem self)
			(if (>= (local18 at: local55) 0)
				(= local57 (local18 at: local55))
				(if (>= (local18 at: local56) 0)
					(gCurRoom setScript: moveAndBounce)
				else
					(gCurRoom setScript: moveBall)
				)
			else
				(gCurRoom setScript: noBall)
			)
		)
		(super handleEvent: event &rest)
	)
)

(instance moveBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== (Abs (- local55 local56)) 1)
					(= local76 (/ (+ [local19 local55] [local19 local56]) 2))
					([local58 local57]
						moveSpeed: 4
						setMotion: JumpTo local76 22 self
					)
				else
					(= cycles 1)
				)
			)
			(1
				([local58 local57] setMotion: JumpTo [local19 local56] 60 self)
				(local18 at: local55 -1)
				(local18 at: local56 local57)
			)
			(2
				(gSounds play: 13110 0 82 0)
				([local67 local55] cel: 0)
				([local58 local57]
					moveSpeed: 2
					setMotion: MoveTo [local19 local56] 65 self
				)
			)
			(3
				(if (or (localproc_0) (IsFlag 71))
					(SetFlag 11)
					(proc951_9 13114)
					(gSounds play: 13114 0 82 self)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(4
				(gCurRoom newRoom: 31260) ; rm31v260
			)
		)
	)
)

(instance noBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 15)
			)
			(1
				([local67 local55] cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance moveAndBounce of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== (Abs (- local55 local56)) 1)
					(= local76 (/ (+ [local19 local55] [local19 local56]) 2))
					([local58 local57]
						moveSpeed: 4
						setMotion: JumpTo local76 22 self
					)
				else
					(= cycles 1)
				)
			)
			(1
				([local58 local57]
					moveSpeed: 4
					setMotion: JumpTo [local19 local56] 58 self
				)
			)
			(2
				(gSounds play: 13111 0 82 0)
				(if (> local55 local56)
					(= local76 (- [local19 local56] 12))
				else
					(= local76 (+ [local19 local56] 12))
				)
				([local58 local57] setMotion: JumpTo local76 60 self)
			)
			(3
				(if (>= local76 133)
					(= temp0 (/ (* 2 (- local76 133)) 5))
				else
					(= temp0 (/ (* 2 (- 133 local76)) 5))
				)
				(= local77 (- 121 temp0))
				([local58 local57] setMotion: JumpTo local76 local77 self)
			)
			(4
				(gSounds play: 13112 0 82 0)
				(if (>= local76 133)
					([local58 local57]
						setMotion: JumpTo (- local76 10) (+ local77 4) self
					)
				else
					([local58 local57]
						setMotion: JumpTo (+ local76 10) (+ local77 4) self
					)
				)
			)
			(5
				([local58 local57] moveSpeed: 3 setMotion: MoveTo 134 121 self)
			)
			(6
				([local58 local57] setMotion: JumpTo 133 122 self)
			)
			(7
				(gSounds stop: 13112)
				(gSounds play: 13113 0 82 self)
				([local58 local57] hide: posn: (- [local19 local55] 1) 32)
			)
			(8
				([local67 local55] cel: 0)
				([local58 local57]
					show:
					setMotion: JumpTo [local19 local55] 58 self
				)
			)
			(9
				(gSounds play: 13110 0 82 0)
				([local58 local57]
					moveSpeed: 2
					setMotion: MoveTo [local19 local55] 65 self
				)
			)
			(10
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

