;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 601)
(include sci.sh)
(use Main)
(use n096)
(use ActorBody)
(use n411)
(use Avd)
(use Orbit)
(use Motion)
(use System)

(public
	petersWife 0
)

(local
	local0 = 1
	[local1 2] = [0 1]
)

(instance petersWife of ActorBody
	(properties
		view 41
		signal 16384
	)

	(method (doVerb)
		(cond
			((gCurRoom script:) 0)
			((or (> nsRight 258) (> nsBottom 156) (< nsLeft 3)) 0)
			(else
				(gCurRoom setScript: converse)
			)
		)
	)

	(method (init &tmp temp0 temp1)
		(self setAvoider: ((Avd new:) offScreenOK: 1 yourself:) setCycle: Walk)
		(super init:)
		(cond
			((> argc 0)
				(self
					moveSpeed: 6
					posn: (gPlace x:) (gPlace y:)
					setMotion: Orbit gPlace 20 0 60 30
				)
				(= local0 0)
			)
			((>= gCurRoomNum 36)
				(switch gCurRoomNum
					(42
						(self
							moveSpeed: (gEgo moveSpeed:)
							posn: global115 (+ global116 20)
							setMotion: MoveTo global115 global116 watch
						)
						(= local0 0)
					)
					(else
						(self hide:)
						(head hide:)
					)
				)
				((self avoider:) offScreenOK: 1)
			)
			((and (== gCurRoomNum 3) (== gPrevRoomNum 2))
				(self
					posn: (- (gEgo x:) 15) (gEgo y:)
					moveSpeed: (gEgo moveSpeed:)
					setMotion: NewFollow gEgo 20
				)
			)
			((and (== gCurRoomNum 5) (== gPrevRoomNum 6))
				(self
					posn: (+ (gEgo x:) 15) (gEgo y:)
					moveSpeed: (gEgo moveSpeed:)
					setMotion: NewFollow gEgo 20
				)
			)
			(else
				(switch (gCurRoom roomToEdge: gPrevRoomNum)
					(3
						(= temp0 (gEgo x:))
						(= temp1 (+ (gEgo y:) 20))
					)
					(2
						(= temp0 (+ (gEgo x:) 15))
						(= temp1 (gEgo y:))
					)
					(else
						(= temp0 (- (gEgo x:) 15))
						(= temp1 (gEgo y:))
					)
				)
				(switch gPrevRoomNum
					(43
						(= temp0 140)
						(= temp1 93)
					)
					(36
						(= temp0 152)
						(= temp1 (gEgo y:))
					)
					(41
						(= temp0 150)
						(= temp1 117)
					)
				)
				(self
					posn: temp0 temp1
					moveSpeed: (gEgo moveSpeed:)
					setMotion: NewFollow gEgo 30
				)
			)
		)
		(if (and (not global341) (not (& signal $0088)))
			(= global341 converse)
		)
	)

	(method (put)
		((gGoals at: 10) egoHas: 0)
		(= local0 0)
		(if (< gCurRoomNum 36)
			(= [global200 gCurRoomNum] view)
			(self moveSpeed: 6 setMotion: Orbit gPlace 20 0 60 30)
		else
			(proc96_1 view)
			(head dispose:)
			(self dispose:)
		)
	)

	(method (get)
		(= [global200 gCurRoomNum] 0)
		((gGoals at: 10) egoHas: 1 egoSeen: 1)
		(self moveSpeed: (gEgo moveSpeed:) setMotion: NewFollow gEgo 30)
		(= local0 1)
	)

	(method (doit)
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

	(method (delete)
		(if (== global130 view)
			(= global129 0)
		else
			(= global150 0)
		)
		(super delete:)
		(DisposeScript 601)
	)
)

(instance watch of Script
	(properties)

	(method (cue)
		(proc0_7 petersWife gEgo)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (= state newState)
			(self dispose:)
			(DoSound sndMASTER_VOLUME global125)
			(DisposeScript 929)
			(RedrawCast)
			(HandsOn)
		else
			(proc0_7 petersWife gEgo)
			(proc0_7 gEgo petersWife)
			(HandsOff)
			(= temp0 (gGoals at: 18))
			(proc0_20)
			(proc411_0 (gEgo head:) (petersWife head:))
			(if (temp0 egoTold:)
				(self setScript: converse2 self 312)
			else
				(self setScript: converse1 self 308)
				(temp0 egoTold: 1)
			)
		)
	)
)

(instance converse1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(petersWife say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(petersWife say: (++ register) self)
			)
			(5
				(proc411_1)
				(= global131 (+ (petersWife x:) 13))
				(= global132 (- (petersWife y:) 67))
				(= global128 96)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance converse2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(petersWife say: (++ register) self)
			)
			(3
				(proc411_1)
				(= global131 (+ (petersWife x:) 13))
				(= global132 (- (petersWife y:) 67))
				(= global128 96)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(4
				(self dispose:)
			)
		)
	)
)

