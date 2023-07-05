;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 601)
(include sci.sh)
(use Main)
(use n091)
(use MGNarrator)
(use ActorBody)
(use PFollow)
(use ROsc)
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

(instance petersWife of SActor
	(properties
		view 41
	)

	(method (onMe)
		(if (!= gTheCursor gNormalCursor)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (doVerb)
		(cond
			((gCurRoom script:) 0)
			((!= gTheCursor gNormalCursor) 0)
			((== gCurRoomNum 12)
				(gCurRoom setScript: global301)
			)
			(else
				(gCurRoom setScript: pconverse)
			)
		)
	)

	(method (init &tmp temp0 temp1)
		(self setCycle: Walk ignoreActors: 1)
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
						(self setScript: enterHouse)
						(= local0 0)
					)
					(else
						(self hide:)
					)
				)
			)
			((and (== gCurRoomNum 3) (== gPrevRoomNum 2))
				(self
					posn: (- (gEgo x:) 15) (gEgo y:)
					moveSpeed: (gEgo moveSpeed:)
					setMotion: PFollow gEgo 20
				)
			)
			((and (== gCurRoomNum 5) (== gPrevRoomNum 6))
				(self
					posn: (+ (gEgo x:) 15) (gEgo y:)
					moveSpeed: (gEgo moveSpeed:)
					setMotion: PFollow gEgo 20
				)
			)
			((== gPrevRoomNum 39)
				(self
					posn: 120 120
					moveSpeed: (gEgo moveSpeed:)
					setMotion: PFollow gEgo 20
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
					(45 ; mapRoom
						(if global172
							(= temp0 (- (gEgo x:) 15))
							(= temp1 (+ (gEgo y:) 10))
						else
							(= temp0 (self x:))
							(= temp1 (self y:))
						)
					)
					(43
						(= temp0 125)
						(= temp1 100)
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
					setMotion: PFollow gEgo 30
				)
			)
		)
		(if (and (not global301) (not (& signal $0088)))
			(= global301 pconverse)
		)
	)

	(method (put)
		((gGoals at: 10) egoHas: 0)
		(= local0 0)
		(if (< gCurRoomNum 36)
			(= [global200 gCurRoomNum] view)
			(self moveSpeed: 6 setMotion: Orbit gPlace 20 0 60 30)
		else
			(proc91_1 view)
			(self dispose:)
		)
	)

	(method (get)
		(= [global200 gCurRoomNum] 0)
		((gGoals at: 10) egoHas: 1 egoSeen: 1)
		(self moveSpeed: (gEgo moveSpeed:) setMotion: PFollow gEgo 30)
		(= local0 1)
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

(instance pconverse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(gGame handsOff:)
			(= global516 gNarrator)
			(= gNarrator mgNarrator)
			(petersWife scratch: (petersWife mover:))
			(petersWife mover: 0)
			(proc0_7 petersWife gEgo)
			(petersWife loop: (+ (petersWife loop:) 8))
			(proc0_7 gEgo petersWife)
			(= temp0 (gGoals at: 18))
			(proc0_20)
			(if (temp0 egoTold:)
				(self setScript: pconverse2 self 1)
			else
				(self setScript: pconverse1 self 1)
				(temp0 egoTold: 1)
			)
		else
			(proc0_5)
			(= gNarrator global516)
			(petersWife loop: (- (petersWife loop:) 8))
			(petersWife mover: (petersWife scratch:))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance pconverse1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 7 1 18 0 self 12) ; "Hi. You look lost. Are you?"
			)
			(2
				(= global131 (+ (petersWife x:) 13))
				(if (< (= global132 (- (petersWife y:) 67)) 30)
					(if (< (gEgo x:) (petersWife x:))
						(+= global131 30)
					else
						(-= global131 53)
					)
				)
				(= global128 96)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance pconverse2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 7 1 19 0 self 12) ; "Hi, Mrs. Pumpkin Eater."
			)
			(2
				(= global131 (+ (petersWife x:) 13))
				(if (< (= global132 (- (petersWife y:) 67)) 26)
					(if (< (gEgo x:) (petersWife x:))
						(+= global131 30)
					else
						(-= global131 53)
					)
				)
				(= global128 96)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance mgNarrator of MGNarrator
	(properties
		modeless 2
	)

	(method (startAudio param1)
		(switch global515
			(14
				(petersWife setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(14
				(petersWife cel: 0 setCycle: 0)
			)
			(9
				(self doEgoQuiet:)
			)
		)
		(super dispose:)
	)
)

(instance enterHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(petersWife
					moveSpeed: (gEgo moveSpeed:)
					posn: (- global115 10) (+ global116 70)
					setMotion: MoveTo (- global115 10) (+ global116 15) self
				)
			)
			(1
				(proc0_7 petersWife gEgo)
				(self dispose:)
			)
		)
	)
)

