;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 603)
(include sci.sh)
(use Main)
(use n096)
(use Wander)
(use Avd)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	sheep 0
)

(local
	[local0 4]
	[local4 6] = [57 107 103 132 173 119]
	local10
	local11
	local12
	local13
	local14 = 4
	local15
	local16
)

(procedure (localproc_0 param1)
	(localproc_2 param1)
	(param1
		loop: (Random 0 3)
		cycleSpeed: (sheep cycleSpeed:)
		moveSpeed: (sheep moveSpeed:)
		setStep: (sheep xStep:) (sheep yStep:)
		signal: (| (param1 signal:) (sheep signal:))
		setAvoider: ((Avd new:) offScreenOK: 1)
	)
	(cond
		((> local13 0)
			(param1
				posn:
					(+ (gPlace x:) (* 9 (Random -1 1)))
					(+ (gPlace y:) (* 4 (Random -1 1)))
			)
		)
		((>= gCurRoomNum 36)
			(param1
				posn:
					(+ global115 (* 9 (Random -1 1)))
					(+ global116 (* 2 (Random 4 8)))
			)
		)
		(else
			(localproc_3 param1)
		)
	)
)

(procedure (localproc_1 param1 param2)
	(param1
		setCel: -1
		illegalBits: (sheep illegalBits:)
		setCycle: Walk
		setMotion: NewFollow gEgo (+ (* param2 6) 30)
	)
)

(procedure (localproc_2 param1)
	(param1 loop: (Random 0 3) setCel: 0 setCycle: 0 setMotion: 0)
)

(procedure (localproc_3 param1 &tmp temp0 temp1)
	(if (!= global166 1)
		(switch gPrevRoomNum
			((gCurRoom north:)
				(= temp0 (- (<< (Random 0 1) $0001) 1))
				(= temp1 -1)
			)
			((gCurRoom south:)
				(= temp0 (- (<< (Random 0 1) $0001) 1))
				(= temp1 1)
			)
			((gCurRoom east:)
				(= temp0 1)
				(= temp1 (- (<< (Random 0 1) $0001) 1))
			)
			(42
				(= temp0 10)
				(= temp1 10)
			)
			(else
				(= temp0 -1)
				(= temp1 (- (<< (Random 0 1) $0001) 1))
			)
		)
		(*= temp0 (Random 1 10))
		(*= temp1 (Random 1 10))
		(if (< 23 gCurRoomNum 27)
			(= temp1 0)
			(if (and (== gCurRoomNum 25) (== gPrevRoomNum 24))
				(= temp0 -10)
			)
		)
		(param1
			x: (+ (gEgo x:) temp0)
			y: (+ (gEgo y:) temp1)
			setCel: 0
			ignoreControl: -32764
			ignoreActors: 1
			setCycle: 0
			setMotion: 0
		)
	)
)

(procedure (localproc_4 &tmp temp0)
	(= temp0 (/ global164 2))
	([local0 temp0]
		setStep: 3 2
		observeControl: -32764
		ignoreActors: 0
		observeBlocks: sheepCage
		moveSpeed: 1
		setAvoider: 0
		setMotion: Wander 20
	)
)

(procedure (localproc_5 &tmp temp0 temp1)
	(for ((= temp0 1)) (< temp0 4) ((++ temp0))
		(= temp1 (* (- temp0 1) 2))
		([local0 temp0]
			setAvoider: ((Avd new:) offScreenOK: 0)
			setMotion: MoveTo [local4 temp1] [local4 (++ temp1)]
		)
	)
)

(procedure (localproc_6 &tmp temp0 temp1)
	(= temp1 1)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(if ([local0 temp0] mover:)
			(= temp1 0)
		else
			([local0 temp0] setAvoider: 0 setCel: 0)
		)
	)
	(if temp1
		(sheep setScript: Bleating)
		(++ global164)
	)
)

(instance sheep of SActor
	(properties
		yStep 3
		view 45
		signal 16384
		cycleSpeed 9
		xStep 4
	)

	(method (onMe)
		(return 0)
	)

	(method (init &tmp temp0)
		(if (or (< gCurRoomNum 36) (== gCurRoomNum 42))
			(= local16 1)
			(= local12 (= local10 (= local11 0)))
			(= local13 argc)
			(= [local0 0] self)
			(= [local0 1] sheepFlock)
			(= [local0 2] sheepFlock2)
			(= [local0 3] sheepFlock3)
			(self moveSpeed: (gEgo moveSpeed:) ignoreActors: 1)
			(super init:)
			(if (== global166 1)
				(self setScript: ComingOver)
			else
				(self
					loop: (Random 0 3)
					setCel: 0
					setAvoider: ((Avd new:) offScreenOK: 1)
				)
				(cond
					((> local13 0)
						(self
							posn:
								(+ (gPlace x:) (* 9 (Random -1 1)))
								(+ (gPlace y:) (* 4 (Random -1 1)))
							ignoreActors: 0
						)
					)
					((>= gCurRoomNum 36)
						(self
							posn:
								(+ global115 (* 9 (Random -1 1)))
								(+ global116 (* 2 (Random 2 4)))
						)
						(localproc_2 self)
					)
					(else
						(= local12 1)
						(localproc_3 self)
						(localproc_1 self 0)
					)
				)
				(for ((= temp0 1)) (< temp0 4) ((++ temp0))
					([local0 temp0] init:)
					(if local12
						(localproc_1 [local0 temp0] temp0)
					)
				)
				(if (not local12)
					(self setScript: Bleating)
				)
			)
		else
			(= local14 1)
			(= local12 (= local10 (= local11 0)))
			(= local16 0)
			(super init:)
			(self hide:)
		)
	)

	(method (dispose &tmp temp0)
		(if local16
			(for ((= temp0 1)) (< temp0 4) ((++ temp0))
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
		(if (not (-- local14))
			(DisposeScript 603)
		)
	)

	(method (doit &tmp temp0 temp1 [temp2 2])
		(cond
			((not local16))
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
								(== (([local0 temp1] avoider:) offScreenOK:) 1)
								([local0 temp1] inRect: 0 0 258 156)
							)
							(([local0 temp1] avoider:) offScreenOK: 0)
							([local0 temp1]
								observeControl: -32764
								ignoreActors: 1
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
				(for ((= temp1 0)) (< temp1 4) ((++ temp1))
					([local0 temp1] setMotion: 0)
				)
				(sheepCage init:)
				(localproc_4)
				(++ global164)
			)
			((== global164 2)
				(if (== (gEgo loop:) 13)
					(gEgo cel: (if (< (gEgo y:) 117) 1 else 3))
					((gEgo head:) loop: (if (< (gEgo y:) 117) 7 else 11))
				)
			)
			((or (== global164 3) (== global164 5))
				(localproc_4)
				(++ global164)
			)
			((== global164 7)
				(localproc_4)
				(++ global164)
			)
			((== global164 9)
				(localproc_5)
				(++ global164)
			)
			((== global164 10)
				(localproc_6)
			)
		)
		(if
			(and
				(IsObject avoider)
				(avoider offScreenOK:)
				(< 0 x 257)
				(< 0 y 155)
				(not global166)
			)
			(avoider offScreenOK: 0)
		)
		(super doit:)
	)

	(method (get &tmp temp0)
		(= [global200 gCurRoomNum] 0)
		((gGoals at: (- view 43)) egoHas: 1 egoSeen: 1)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
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
			(= local10 (= local11 0))
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
			(localproc_0 self)
		)
		(super init:)
	)

	(method (delete)
		(super delete:)
		(if (not (-- local14))
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
			(localproc_0 self)
		)
		(super init:)
	)

	(method (delete)
		(super delete:)
		(if (not (-- local14))
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
			(localproc_0 self)
		)
		(super init:)
	)

	(method (delete)
		(super delete:)
		(if (not (-- local14))
			(DisposeScript 603)
		)
	)
)

(instance sheepCage of Cage
	(properties
		bottom 155
		right 257
	)
)

(instance Bleating of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if local11
					(= cycles 1)
				else
					(if (IsObject local10)
						(local10 loop: (- (local10 loop:) 4) setCycle: Walk)
					)
					(for ((= temp0 0)) (< temp0 4) ((++ temp0))
						(if (< ([local0 temp0] loop:) 3)
							(break)
						)
					)
					(if (< temp0 4)
						(repeat
							(= local10 [local0 (- (Random 1 4) 1)])
							(if (< (local10 loop:) 3)
								(break)
							)
						)
						(local10 loop: (+ (local10 loop:) 4))
						(= local11 (Random 1 3))
						(= cycles 1)
					else
						(client setScript: 0)
					)
				)
			)
			(1
				(local10 setCycle: End self)
				(cond
					(
						(or
							(gCurRoom script:)
							(not (User controls:))
							(!= (DoAudio audPOSITION) -1)
						)
						(= ticks 60)
					)
					(global157
						(= ticks (DoAudio audPLAY (Random 31 33)))
					)
					(else
						(gSfx number: 31 play:)
						(= ticks 60)
					)
				)
			)
			(2)
			(3
				(local10 setCycle: Beg self)
			)
			(4
				(if (-- local11)
					(= cycles (Random 1 3))
				else
					(= seconds (Random 2 4))
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
					(= temp0 (+ (gEgo x:) (Random 1 20)))
					(= temp2 (gEgo y:))
					(= temp1
						(+
							(gEgo y:)
							4
							(CelHigh (sheep view:) (sheep loop:) (sheep cel:))
						)
					)
					([local0 temp3]
						setLoop: 1
						setCel: -1
						setPri: 0
						cycleSpeed: (sheep cycleSpeed:)
						moveSpeed: (sheep moveSpeed:)
						setStep: (sheep xStep:) (sheep yStep:)
						ignoreActors: 1
						ignoreControl: -32764
						posn: temp0 temp1
						setCycle: Walk
						setMotion: MoveTo temp0 temp2
						setAvoider: ((Avd new:) offScreenOK: 0)
					)
					(if (> temp3 0)
						([local0 temp3] init:)
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
						setMotion: MoveTo ([local0 temp3] x:) (- (gEgo y:) 1)
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
					(localproc_3 [local0 temp3])
					([local0 temp3] loop: 1 observeControl: -32764)
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
				(proc96_1 (sheep view:))
				(sheep dispose:)
			)
		)
	)
)

