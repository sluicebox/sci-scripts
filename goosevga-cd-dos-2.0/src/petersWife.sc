;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 601)
(include sci.sh)
(use Main)
(use n096)
(use ActorBody)
(use n411)
(use Avoid)
(use Orbit)
(use Motion)
(use System)

(public
	petersWife 0
)

(local
	local0 = 1
	local1
	local2 = 1
)

(instance petersWife of ActorBody
	(properties
		view 41
		signal 16384
	)

	(method (init &tmp temp0 temp1)
		(self
			moveSpeed: (gEgo moveSpeed:)
			setAvoider: ((Avoid new:) offScreenOK: 1)
			setCycle: Walk
		)
		(cond
			((> argc 0)
				(self
					posn: (gPlace x:) (gPlace y:)
					setMotion: Orbit gPlace 20 0 60 30
				)
				(= local0 0)
			)
			((>= gCurRoomNum 36)
				(switch (gCurRoom roomToEdge: gPrevRoomNum)
					(3
						(= temp0 global115)
						(= temp1 (+ global116 20))
					)
					(2
						(= temp1 global116)
						(= temp0 (+ global115 20))
					)
					(else
						(= temp1 global116)
						(= temp0 global115)
					)
				)
				((self avoider:) offScreenOK: 1)
				(self
					posn: temp0 temp1
					setMotion: MoveTo global115 global116 watch
				)
				(= local0 0)
			)
			(else
				(switch (gCurRoom roomToEdge: gPrevRoomNum)
					(3
						(= temp0 (gEgo x:))
						(= temp1 (+ (gEgo y:) 20))
					)
					(else
						(= temp0 (gEgo x:))
						(= temp1 (gEgo y:))
					)
				)
				(switch gPrevRoomNum
					(43
						(= temp0 140)
						(= temp1 93)
					)
				)
				(self posn: temp0 temp1 setMotion: NewFollow gEgo 30)
			)
		)
		(super init:)
		(if (< gCurRoomNum 36)
			(wave changeState: 0)
		)
	)

	(method (put)
		((gGoals at: 10) egoHas: 0)
		(if (< gCurRoomNum 36)
			(= [global200 gCurRoomNum] view)
			(if (wave register:)
				(= local1 2)
			else
				(self setMotion: Orbit gPlace 20 0 60 30)
			)
		else
			(relocateScript changeState: 0)
		)
		(= local0 0)
	)

	(method (get)
		(= [global200 gCurRoomNum] 0)
		((gGoals at: 10) egoHas: 1 egoSeen: 1)
		(self setMotion: NewFollow gEgo 30)
		(= local0 1)
	)

	(method (doit)
		(if (< gCurRoomNum 36)
			(wave doit:)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((gCurRoom script:)
				(return)
			)
			((== (event type:) evVERB)
				(event claimed: 1)
				(wave changeState: 3)
				(petersWife setMotion: 0)
				(proc0_7 petersWife gEgo)
				(proc0_7 gEgo petersWife)
				(gCurRoom setScript: converse)
			)
		)
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

(instance wave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 5))
			)
			(1
				(if local0
					(= state -1)
					(= cycles 1)
				else
					(petersWife setMotion: 0)
					(= seconds (Random 2 5))
				)
			)
			(2
				(*= local2 -1)
				(if (not local0)
					(petersWife
						setMotion: Orbit gPlace 20 0 60 30 local2
						cycleSpeed: 0
						setCycle: Walk
					)
				)
				(switch local1
					(1
						(petersWife get:)
					)
					(2
						(petersWife put:)
					)
				)
				(= local1 0)
				(= state -1)
				(= cycles 1)
			)
			(3
				(= state 2)
			)
		)
	)
)

(instance relocateScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc96_1 (petersWife view:))
				(switch gCurRoomNum
					(39
						(petersWife
							setMotion:
								MoveTo
								(+ (petersWife x:) 10)
								(+ (petersWife y:) 40)
								self
						)
					)
					(40
						(petersWife
							setMotion:
								MoveTo
								(+ (petersWife x:) 10)
								(petersWife y:)
								self
						)
					)
					(else
						(petersWife setMotion: MoveTo 200 144 self)
					)
				)
			)
			(1
				(petersWife dispose:)
				((petersWife head:) dispose:)
				(self dispose:)
			)
		)
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

	(method (cue)
		(wave changeState: 0)
		(if local0
			(petersWife setMotion: NewFollow gEgo 30)
		)
		(self dispose:)
		(DoSound sndMASTER_VOLUME global125)
		(DisposeScript 976)
		(proc0_3)
	)

	(method (init &tmp temp0)
		(proc0_2)
		(super init: &rest)
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

