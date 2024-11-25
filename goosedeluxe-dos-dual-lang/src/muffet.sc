;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 602)
(include sci.sh)
(use Main)
(use n091)
(use MGNarrator)
(use ActorBody)
(use PFollow)
(use ROsc)
(use PolyPath)
(use Orbit)
(use Motion)
(use System)

(public
	muffet 0
)

(local
	local0 = 1
	local1
	local2
	[local3 2]
	local5
)

(instance muffet of ActorBody
	(properties
		view 42
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
			(else
				(gCurRoom setScript: mconverse)
			)
		)
	)

	(method (init &tmp temp0)
		(super init:)
		(= gShell2 0)
		(self cycleSpeed: 6 setCycle: Walk)
		(cond
			((> argc 0)
				(self
					moveSpeed: 6
					posn: (gPlace x:) (+ (gPlace y:) 5)
					setMotion: Orbit gPlace 20 0 68 60
				)
				(= local0 0)
			)
			((>= gCurRoomNum 36)
				(switch gCurRoomNum
					(42
						(self setScript: enterHouse)
						(= local0 1)
					)
					(else
						(self hide:)
					)
				)
			)
			((and global172 (== gCurRoomNum 9))
				(self posn: (- (gEgo x:) 15) (- (gEgo y:) 10))
				(gCurRoom setScript: mconverse)
			)
			((and (== gCurRoomNum 3) (== gPrevRoomNum 2))
				(self
					posn: (- (gEgo x:) 15) (gEgo y:)
					moveSpeed: (gEgo moveSpeed:)
					cycleSpeed: (gEgo cycleSpeed:)
					setMotion: PFollow gEgo 20
				)
			)
			((and (== gCurRoomNum 5) (== gPrevRoomNum 6))
				(self
					posn: (+ (gEgo x:) 15) (gEgo y:)
					moveSpeed: (gEgo moveSpeed:)
					cycleSpeed: (gEgo cycleSpeed:)
					setMotion: PFollow gEgo 20
				)
			)
			((and (== gCurRoomNum 32) (== gPrevRoomNum 33))
				(self
					posn: (+ (gEgo x:) 15) (+ (gEgo y:) 5)
					moveSpeed: (gEgo moveSpeed:)
					cycleSpeed: (gEgo cycleSpeed:)
					setMotion: PFollow gEgo 20
				)
			)
			((and (== gCurRoomNum 33) (== gPrevRoomNum 32))
				(self
					posn: (- (gEgo x:) 15) (+ (gEgo y:) 5)
					moveSpeed: (gEgo moveSpeed:)
					cycleSpeed: (gEgo cycleSpeed:)
					setMotion: PFollow gEgo 20
				)
			)
			((== gPrevRoomNum 45) ; mapRoom
				(self
					moveSpeed: (gEgo moveSpeed:)
					cycleSpeed: (gEgo cycleSpeed:)
					setMotion: PFollow gEgo 30
				)
			)
			(else
				(= temp0 (gCurRoom roomToEdge: gPrevRoomNum))
				(= moveSpeed (gEgo moveSpeed:))
				(= cycleSpeed (gEgo cycleSpeed:))
				(cond
					((== temp0 3)
						(self
							posn: (gEgo x:) (+ (gEgo y:) 10)
							setMotion: PFollow gEgo 30
						)
					)
					((or (== temp0 1) (== temp0 2) (== temp0 4))
						(self
							posn: (gEgo x:) (gEgo y:)
							setMotion: PFollow gEgo 30
						)
						(if (== gCurRoomNum 21)
							(self posn: 186 116)
						)
					)
					(else
						(self
							posn: (- (gEgo x:) 11) (+ (gEgo y:) 8)
							setMotion: PFollow gEgo 30
						)
					)
				)
			)
		)
		(if (and (< gCurRoomNum 36) (not global301))
			(= global301 mconverse)
		)
	)

	(method (put)
		((gGoals at: 0) egoHas: 0)
		(= local0 0)
		(if (< gCurRoomNum 36)
			(= [global200 gCurRoomNum] view)
			(if (wave register:)
				(= local1 1)
			else
				(self moveSpeed: 6 setMotion: Orbit gPlace 20 0 68 60)
			)
		else
			(proc91_1 view)
			(self dispose:)
		)
	)

	(method (get)
		((gGoals at: 0) egoHas: 1 egoSeen: 1)
		(= [global200 gCurRoomNum] 0)
		(self moveSpeed: (gEgo moveSpeed:) setMotion: PFollow gEgo 30)
		(= local0 1)
	)

	(method (doit)
		(if (< gCurRoomNum 36)
			(wave doit:)
		)
		(super doit: &rest)
	)

	(method (delete)
		(if (== global130 view)
			(= global129 0)
		else
			(= global150 0)
		)
		(super delete:)
		(DisposeScript 602)
	)
)

(instance wave of Script
	(properties
		client 1
	)

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
					(muffet setMotion: 0)
					(= seconds (Random 2 5))
				)
			)
			(2
				(if (== local2 1)
					(= local2 -1)
				else
					(= local2 1)
				)
				(if (not local0)
					(muffet
						setMotion: Orbit gPlace 20 0 68 60 local2
						cycleSpeed: 9
						setCycle: Walk
					)
				)
				(switch local1
					(2
						(muffet get:)
					)
					(1
						(muffet put:)
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

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_7 gEgo muffet)
				(proc0_7 muffet gEgo)
				(muffet setLoop: (+ (muffet loop:) 8) 1 cycleSpeed: 6)
				(= cycles 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance atEaseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(muffet setLoop: -1)
				(muffet
					setLoop: (- (muffet loop:) 8)
					setCycle: Walk
					cycleSpeed:
						(if local0
							(gEgo cycleSpeed:)
						else
							9
						)
				)
				(= cycles 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance mconverse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(gGame handsOff:)
			(= global516 gNarrator)
			(= gNarrator mgNarrator)
			(wave changeState: 3)
			(muffet setMotion: 0)
			(muffet setScript: attentionScript)
			(proc0_20)
			(= temp0 (gGoals at: 0))
			(cond
				((== gCurRoomNum 9)
					(self setScript: mconverse3 self 8)
					(if (== global123 17)
						(= global123 0)
					)
					(temp0 egoReturned: 1)
					(= local5 1)
					(= local0 0)
				)
				((temp0 egoTold:)
					(= global123 17)
					(self setScript: mconverse2 self 7)
				)
				(else
					(self setScript: mconverse1 self 6)
					(= global123 17)
					(temp0 egoTold: 1)
				)
			)
		else
			(= gNarrator global516)
			(wave changeState: 0)
			(muffet setScript: atEaseScript)
			(if local0
				(muffet setMotion: PFollow gEgo 30)
			)
			(if (!= gScore gPossibleScore)
				(proc0_5)
				(gGame handsOn:)
				(self dispose:)
			)
			(DisposeScript 64929)
			(if local5
				(muffet dispose:)
			)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
		)
	)
)

(instance mconverse1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 6 1 6 0 self 9) ; "This is a fine how do you do, as my old grandmother would say."
			)
			(2
				(= global131 (+ (muffet x:) 13))
				(= global132 (- (muffet y:) 54))
				(= global128 95)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance mconverse2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 6 1 7 0 self 9) ; "My old grandmother always told me I'd lose my head if it weren't screwed on. Now look at me, I've lost my tuffet."
			)
			(2
				(= global131 (+ (muffet x:) 13))
				(= global132 (- (muffet y:) 54))
				(= global128 95)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance mconverse3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= global301 0)
				(muffet
					setLoop: -1
					setCycle: Walk
					moveSpeed: (gEgo moveSpeed:)
					setMotion: PFollow gEgo 30
				)
				(gEgo setMotion: PolyPath 217 126 self)
			)
			(1
				(self setScript: attentionScript self)
			)
			(2
				(gLongSong fade:)
				(gMessager say: 6 1 8 0 self 9) ; "There's your tuffet, Miss Muffet!"
			)
			(3
				(self setScript: atEaseScript self)
			)
			(4
				(muffet
					setLoop: -1
					illegalBits: $8000
					setCycle: Walk
					setMotion: PolyPath 150 120 self
				)
			)
			(5
				(muffet loop: 1)
				(self setScript: (ScriptID 309) self) ; rhymeScript
			)
			(6
				(= local5 1)
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
			(12
				(muffet setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(12
				(muffet cel: 0 setCycle: 0)
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
				(muffet
					posn: (- global115 12) (+ global116 70)
					setMotion: MoveTo (- global115 12) (+ global116 15) self
				)
			)
			(1
				(proc0_7 muffet gEgo)
				(self dispose:)
			)
		)
	)
)

