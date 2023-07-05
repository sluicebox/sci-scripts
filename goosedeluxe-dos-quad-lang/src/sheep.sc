;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 603)
(include sci.sh)
(use Main)
(use n091)
(use ActorBody)
(use PFollow)
(use PolyPath)
(use Blk)
(use Wander)
(use Motion)
(use Actor)
(use System)

(public
	sheep 0
)

(local
	[local0 4]
	[local4 8] = [166 103 57 107 103 137 173 119]
	local12
	local13
	local14
	local15
	local16 = 4
	local17
	local18
)

(procedure (localproc_0 param1 param2)
	(localproc_2 param1)
	(param1
		loop: (Random 0 3)
		cel: 0
		cycleSpeed: (sheep cycleSpeed:)
		moveSpeed: (sheep moveSpeed:)
		setStep: (sheep xStep:) (sheep yStep:)
		ignoreActors: 1
	)
	(cond
		((> local15 0)
			(param1
				posn:
					(+ (gPlace x:) (* 9 (Random -1 1)))
					(+ (gPlace y:) (* 4 (Random -1 1)))
			)
		)
		((>= gCurRoomNum 36)
			(param1
				posn:
					(+ global115 (* 3 (Random -6 -2)))
					(+ global116 (* 2 (Random 3 8)))
				setMotion: 0
				setLoop: 3
			)
		)
		(else
			(localproc_3 param1 param2)
		)
	)
)

(procedure (localproc_1 param1 param2)
	(if (not (param1 plane:))
		(param1 init:)
	)
	(param1
		setCel: 0
		illegalBits: (sheep illegalBits:)
		setCycle: Walk
		setMotion: PFollow gEgo (+ (* param2 6) 30)
	)
)

(procedure (localproc_2 param1)
	(param1
		loop:
			(if (== gCurRoomNum 42)
				3
			else
				(Random 0 3)
			)
		setCel: 0
		setCycle: 0
		setMotion: 0
	)
)

(procedure (localproc_3 param1 param2 &tmp temp0 temp1)
	(if (and (!= global166 1) (or global172 (!= gPrevRoomNum 45))) ; mapRoom
		(switch gPrevRoomNum
			((gCurRoom north:)
				(= temp0 (- param2 1))
				(= temp1 -2)
			)
			((gCurRoom south:)
				(= temp0 (- param2 1))
				(= temp1 (+ 2 param2))
			)
			((gCurRoom east:)
				(= temp0 (+ 2 param2))
				(= temp1 (- param2 1))
			)
			(42
				(= temp0 (- -2 param2))
				(= temp1 (+ 1 param2))
			)
			(41
				(= temp0 (+ 1 param2))
				(= temp1 1)
			)
			(39
				(= temp0 (- -1 param2))
				(= temp1 (+ 3 param2))
			)
			(45 ; mapRoom
				(= temp0 (- -3 param2))
				(= temp1 (- param2 1))
			)
			(else
				(= temp0 (- -2 param2))
				(= temp1 (- param2 1))
			)
		)
		(*= temp0 (Random 5 9))
		(*= temp1 (Random 5 9))
		(if (== gPrevRoomNum 42)
			(= temp1 (proc0_13 18 temp1 30))
		)
		(param1
			x: (+ (gEgo x:) temp0)
			y: (+ (gEgo y:) temp1)
			setCel: 0
			setCycle: Walk
		)
		(param1 y: (proc0_13 (gCurRoom edgeN:) (param1 y:) 169))
	)
)

(procedure (localproc_4 &tmp temp0)
	(= temp0 (/ global164 2))
	([local0 temp0]
		setStep: 3 2
		ignoreActors: 1
		observeBlocks: sheepCage sheepBlock sheepBlock2
		moveSpeed: 8
		setMotion: Wander 20
	)
)

(procedure (localproc_5 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(= temp1 (* temp0 2))
		([local0 temp0]
			moveSpeed: 4
			setMotion: PolyPath [local4 temp1] [local4 (++ temp1)]
			ignoreBlocks: sheepBlock
			ignoreActors: 1
		)
	)
)

(procedure (localproc_6 &tmp temp0)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		([local0 temp0] setMotion: 0 setCel: 0)
	)
)

(instance sheep of SActor
	(properties
		view 45
		yStep 3
		signal 16384
		xStep 4
	)

	(method (onMe)
		(return 0)
	)

	(method (init &tmp temp0)
		(if (or (< gCurRoomNum 36) (== gCurRoomNum 42))
			(= global133 sheepFlock)
			(= local18 1)
			(= local14 (= local12 (= local13 0)))
			(= local15 argc)
			(= [local0 0] sheepFlock)
			(= [local0 1] sheepFlock2)
			(= [local0 2] sheepFlock3)
			(= [local0 3] sheepFlock4)
			(super init: gCast)
			(self moveSpeed: (gEgo moveSpeed:))
			(self hide:)
			(if (== global166 1)
				(self setScript: ComingOver)
			else
				(cond
					((> local15 0)
						(self
							posn:
								(+ (gPlace x:) (* 9 (Random -1 1)))
								(+ (gPlace y:) (* 4 (Random -1 1)))
						)
					)
					((>= gCurRoomNum 36)
						(self
							posn:
								(+ global115 (* 3 (Random -6 -2)))
								(+ global116 (* 2 (Random 3 8)))
							setLoop: 3
						)
						(localproc_2 self)
					)
					(else
						(= local14 1)
					)
				)
				(for ((= temp0 0)) (< temp0 4) ((++ temp0))
					(cond
						(local14
							([local0 temp0] setPri: -1 init:)
							(localproc_1 [local0 temp0] temp0)
						)
						((== temp0 0)
							(self show:)
						)
						(else
							([local0 temp0] init:)
							(localproc_2 [local0 temp0] temp0)
						)
					)
				)
				(if (not local14)
					(self setScript: Bleating)
				)
			)
		else
			(= local16 1)
			(= local14 (= local12 (= local13 0)))
			(= local18 0)
			(super init: gCast)
			(self hide:)
		)
	)

	(method (dispose &tmp temp0)
		(if local18
			(for ((= temp0 0)) (< temp0 4) ((++ temp0))
				([local0 temp0] dispose:)
			)
		)
		(if (= temp0 (relocateScript timer:))
			(temp0 dispose:)
			(temp0 delete:)
		)
		(self show:)
		(super dispose:)
	)

	(method (delete)
		(super delete:)
		(if (not (-- local16))
			(DisposeScript 603)
		)
	)

	(method (doit &tmp temp0 temp1 [temp2 2])
		(cond
			((not local18))
			((== global164 0)
				(if (!= (self moveSpeed:) (gEgo moveSpeed:))
					(= temp0 (gEgo moveSpeed:))
					(for ((= temp1 0)) (< temp1 4) ((++ temp1))
						([local0 temp1] moveSpeed: temp0)
					)
				)
				(for ((= temp1 0)) (< temp1 4) ((++ temp1))
					(cond
						(
							(and
								(not global166)
								([local0 temp1] inRect: 5 5 251 150)
							)
							([local0 temp1] ignoreActors: 1)
							(if
								(and
									([local0 temp1] isStopped:)
									(not (sheep script:))
								)
								([local0 temp1] cel: 0)
							)
						)
						((== global166 2)
							([local0 temp1]
								setLoop: 3
								setMotion: MoveTo (gEgo x:) (gEgo y:)
							)
						)
					)
				)
				(if (== global166 2)
					(= global166 0)
				)
			)
			((== global164 1)
				(sheepCage init:)
				(localproc_5)
				(localproc_4)
				(++ global164)
			)
			((== global164 2)
				(if (== (gEgo loop:) 13)
					(gEgo cel: (if (< (gEgo y:) 117) 1 else 3))
					((gEgo head:) loop: (if (< (gEgo y:) 117) 7 else 11))
				)
			)
			((or (== global164 3) (== global164 5) (== global164 7))
				(localproc_4)
				(++ global164)
			)
			((== global164 9)
				(localproc_5)
				(++ global164)
			)
			((== global164 10)
				(for ((= temp1 0)) (< temp1 4) ((++ temp1))
					(if ([local0 temp1] isStopped:)
						([local0 temp1] cel: 0)
					)
				)
			)
			((== global164 11)
				(localproc_6)
				(++ global164)
			)
			((== global164 13)
				(sheep setScript: Bleating)
				(++ global164)
			)
		)
		(super doit:)
	)

	(method (get &tmp temp0)
		(= [global200 gCurRoomNum] 0)
		((gGoals at: (- view 43)) egoHas: 1 egoSeen: 1)
		(sheep dispose:)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			([local0 temp0] init:)
			(localproc_1 [local0 temp0] temp0)
		)
	)

	(method (put &tmp temp0)
		((gGoals at: (- view 43)) egoHas: 0)
		(if (>= gCurRoomNum 36)
			(self setScript: relocateScript)
		else
			(= [global200 gCurRoomNum] view)
			(for ((= temp0 0)) (< temp0 4) ((++ temp0))
				(localproc_2 [local0 temp0])
			)
			(= local12 (= local13 0))
			(self setScript: Bleating)
		)
	)
)

(instance sheepFlock of Actor
	(properties
		view 45
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(if (!= global166 1)
			(localproc_0 self 0)
		)
		(super init:)
	)

	(method (delete)
		(super delete:)
		(if (not (-- local16))
			(DisposeScript 603)
		)
	)
)

(instance sheepFlock2 of Actor
	(properties
		view 45
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(if (!= global166 1)
			(localproc_0 self 1)
		)
		(super init:)
	)

	(method (delete)
		(super delete:)
		(if (not (-- local16))
			(DisposeScript 603)
		)
	)
)

(instance sheepFlock3 of Actor
	(properties
		view 45
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(if (!= global166 1)
			(localproc_0 self 2)
		)
		(super init:)
	)

	(method (delete)
		(super delete:)
		(if (not (-- local16))
			(DisposeScript 603)
		)
	)
)

(instance sheepFlock4 of Actor
	(properties
		view 45
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(if (!= global166 1)
			(localproc_0 self 3)
		)
		(super init:)
	)

	(method (delete)
		(super delete:)
		(if (not (-- local16))
			(DisposeScript 603)
		)
	)
)

(instance sheepCage of Cage
	(properties
		left -10
		top 65
		right 265
		bottom 170
	)
)

(instance sheepBlock of Blk
	(properties
		left 66
		top 101
		right 169
		bottom 134
	)
)

(instance sheepBlock2 of Blk
	(properties
		left 201
		right 265
		bottom 139
	)
)

(instance Bleating of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if local13
					(= cycles 1)
				else
					(if local12
						(local12 loop: (- (local12 loop:) 4) setCycle: Walk)
					)
					(for ((= temp0 0)) (< temp0 4) ((++ temp0))
						(if (< ([local0 temp0] loop:) 3)
							(break)
						)
					)
					(if (< temp0 4)
						(repeat
							(= local12 [local0 (- (Random 1 4) 1)])
							(if (< (local12 loop:) 3)
								(break)
							)
						)
						(local12 loop: (+ (local12 loop:) 4))
						(= local13 (Random 1 3))
						(= cycles 1)
					else
						(client setScript: 0)
					)
				)
			)
			(1
				(local12 setCycle: End self)
				(if
					(or
						(gCurRoom script:)
						(not (gUser controls:))
						(!= (DoAudio audPOSITION) -1)
					)
					(= ticks 60)
				else
					(gSfx number: 31 play:)
					(= ticks 60)
				)
			)
			(2
				(local12 setCycle: Beg self)
			)
			(3
				(if (-- local13)
					(= cycles (Random 1 3))
				else
					(= seconds (Random 5 8))
				)
				(= state -1)
			)
		)
	)
)

(instance ComingOver of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(for ((= temp3 0)) (< temp3 4) ((++ temp3))
					(= temp0 (- (gEgo x:) 5))
					(= temp2 (+ (gEgo y:) 3))
					(= temp1
						(+
							(gEgo y:)
							(* temp3 3)
							2
							(CelHigh (sheep view:) (sheep loop:) (sheep cel:))
						)
					)
					([local0 temp3] init:)
					([local0 temp3]
						setLoop: 2 1
						setCel: -1
						setPri: 0 1
						cycleSpeed: (sheep cycleSpeed:)
						moveSpeed: (sheep moveSpeed:)
						setStep: (sheep xStep:) (sheep yStep:)
						ignoreActors: 1
						posn: temp0 temp1
						setCycle: Walk
						setMotion: MoveTo (+ temp0 (* temp3 3)) temp2
					)
				)
				(= cycles 3)
			)
			(1
				(for ((= temp3 0)) (< temp3 4) ((++ temp3))
					(if ([local0 temp3] mover:)
						(-- state)
						(break)
					)
				)
				(= cycles 1)
			)
			(2
				(for ((= temp3 0)) (< temp3 4) ((++ temp3))
					([local0 temp3]
						setLoop: -1
						setPri: -1
						setMotion:
							MoveTo
							(+ ([local0 temp3] x:) (Random 0 10) -5)
							(- (gEgo y:) (+ 1 (* temp3 2)))
					)
				)
				(= cycles 1)
			)
			(3
				(for ((= temp3 0)) (< temp3 4) ((++ temp3))
					(if ([local0 temp3] mover:)
						(-- state)
						(break)
					)
				)
				(= cycles 1)
			)
			(4
				(for ((= temp3 0)) (< temp3 4) ((++ temp3))
					(localproc_3 [local0 temp3] temp3)
					([local0 temp3] loop: 2 ignoreActors: 1)
				)
				(= cycles 1)
			)
			(5
				(if (gEgo mover:)
					(for ((= temp3 0)) (< temp3 4) ((++ temp3))
						(localproc_1 [local0 temp3] temp3)
					)
					(= global166 0)
					(client setScript: 0)
				else
					(-- state)
					(= cycles 1)
				)
			)
		)
	)

	(method (dispose)
		(= global166 0)
		(super dispose: &rest)
	)
)

(instance relocateScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc91_1 (sheep view:))
				(sheep dispose:)
			)
		)
	)
)

