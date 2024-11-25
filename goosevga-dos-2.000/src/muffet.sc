;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 602)
(include sci.sh)
(use Main)
(use n096)
(use ActorBody)
(use n411)
(use PolyPath)
(use Avd)
(use Orbit)
(use Motion)
(use User)
(use System)

(public
	muffet 0
)

(local
	local0 = 1
	local1
	local2
	local3
	local4
	local5
)

(instance muffet of ActorBody
	(properties
		view 42
		signal 20480
	)

	(method (doVerb)
		(cond
			((gCurRoom script:))
			((or (> nsRight 258) (> nsBottom 156) (< nsLeft 3)) 0)
			(else
				(gCurRoom setScript: mconverse)
			)
		)
	)

	(method (init &tmp temp0)
		(= gShell2 0)
		(self setAvoider: ((Avd new:) offScreenOK: 1) setCycle: Walk)
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
						(self posn: global115 global116 setMotion: 0)
						(= local0 0)
					)
					(else
						(self hide:)
					)
				)
			)
			((== gCurRoomNum 9)
				(= moveSpeed (gEgo moveSpeed:))
				(= global103 1)
				(switch gPrevRoomNum
					(2
						(gCurRoom setScript: ClimbIn)
					)
					(36
						(self
							posn: 152 (+ (gEgo y:) 20)
							setMotion: NewFollow gEgo 30
						)
					)
					(else
						(self
							posn: (gEgo x:) (+ (gEgo y:) 20)
							setMotion: NewFollow gEgo 30
						)
					)
				)
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
				(= temp0 (gCurRoom roomToEdge: gPrevRoomNum))
				(= moveSpeed (gEgo moveSpeed:))
				(cond
					((& signal $0008))
					((== temp0 3)
						(self
							posn: (gEgo x:) (+ (gEgo y:) 10)
							setMotion: NewFollow gEgo 30
						)
					)
					((or (== temp0 1) (== temp0 2) (== temp0 4))
						(self
							posn: (gEgo x:) (gEgo y:)
							setMotion: NewFollow gEgo 30
						)
						(if (== gCurRoomNum 21)
							(self posn: 186 116)
						)
					)
					(else
						(self
							posn: (- (gEgo x:) 8) (+ (gEgo y:) 5)
							setMotion: NewFollow gEgo 30
						)
					)
				)
			)
		)
		(super init:)
		(if (and (< gCurRoomNum 36) (not global341))
			(= global341 mconverse)
		)
	)

	(method (put)
		((gGoals at: 0) egoHas: 0)
		(= local0 0)
		(if (< gCurRoomNum 36)
			(= [global200 gCurRoomNum] view)
			(if (wave register:)
				(= local1 2)
			else
				(self moveSpeed: 6 setMotion: Orbit gPlace 20 0 68 60)
			)
		else
			(proc96_1 view)
			(head dispose:)
			(self dispose:)
		)
	)

	(method (get)
		((gGoals at: 0) egoHas: 1 egoSeen: 1)
		(= [global200 gCurRoomNum] 0)
		(self moveSpeed: (gEgo moveSpeed:) setMotion: NewFollow gEgo 30)
		(= local0 1)
	)

	(method (doit)
		(if (< gCurRoomNum 36)
			(wave doit:)
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
					(1
						(muffet get:)
					)
					(2
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

(instance ClimbIn of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local3 (gEgo x:))
				(= local4 (gEgo y:))
				(HandsOff)
				(= temp0
					(+
						local4
						4
						(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
					)
				)
				(gEgo
					setPri: 0
					setLoop: 1
					y: temp0
					init:
					ignoreActors: 1
					setMotion: MoveTo local3 local4 self
				)
			)
			(1
				(= temp0
					(+
						local4
						(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
					)
				)
				(gEgo setPri: -1 setLoop: -1 setMotion: MoveTo local3 temp0)
				(= temp0
					(+
						local4
						4
						(CelHigh
							(global129 view:)
							(global129 loop:)
							(global129 cel:)
						)
					)
				)
				(muffet
					setPri: 0
					setLoop: 2
					illegalBits: 0
					posn: local3 temp0
					setMotion: MoveTo local3 local4 self
				)
			)
			(2
				(User canControl: 1)
				(muffet setPri: -1 setLoop: -1 illegalBits: $8000)
				(= global113 1)
				(if (== gCurRoomNum 9)
					(gCurRoom setScript: mconverse)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance mconverse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (= state newState)
			(DoSound sndMASTER_VOLUME global125)
			(wave changeState: 0)
			(if local0
				(muffet setMotion: NewFollow gEgo 30)
			)
			(if (!= gScore gPossibleScore)
				(RedrawCast)
				(HandsOn)
				(self dispose:)
			)
			(DisposeScript 929)
			(if local5
				(muffet dispose:)
			)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
		else
			(HandsOff)
			(wave changeState: 3)
			(muffet setMotion: 0)
			(proc0_7 gEgo muffet)
			(proc0_7 muffet gEgo)
			(proc0_20)
			(= temp0 (gGoals at: 0))
			(cond
				((== gCurRoomNum 9)
					(self setScript: mconverse3 self 389)
					(if (== global123 17)
						(= global123 0)
					)
					(temp0 egoReturned: 1)
				)
				((temp0 egoTold:)
					(= global123 17)
					(self setScript: mconverse2 self 385)
				)
				(else
					(self setScript: mconverse1 self 377)
					(= global123 17)
					(temp0 egoTold: 1)
				)
			)
		)
	)
)

(instance mconverse1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc411_0 (gEgo head:) (muffet head:))
				(= cycles 1)
			)
			(1
				(muffet say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(muffet say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(muffet say: (++ register) self)
			)
			(6
				(gEgo say: (++ register) self)
			)
			(7
				(muffet say: (++ register) self)
			)
			(8
				(gEgo say: (++ register) self)
			)
			(9
				(proc411_1)
				(= global131 (+ (muffet x:) 13))
				(= global132 (- (muffet y:) 54))
				(= global128 95)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(10
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
				(proc411_0 (gEgo head:) (muffet head:))
				(= cycles 1)
			)
			(1
				(muffet say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(muffet say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(proc411_1)
				(= global131 (+ (muffet x:) 13))
				(= global132 (- (muffet y:) 54))
				(= global128 95)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(6
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
				(HandsOff)
				(= global341 0)
				(muffet
					moveSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo (gEgo x:) (gEgo y:)
				)
				(gEgo setMotion: PolyPath 217 126 self)
			)
			(1
				(proc0_7 gEgo muffet)
				(proc411_0 (gEgo head:) (muffet head:))
				(= cycles 2)
			)
			(2
				(gEgo say: register self)
			)
			(3
				(muffet say: (++ register) self)
			)
			(4
				(proc411_1)
				(muffet
					setLoop: -1
					illegalBits: $8000
					setMotion: MoveTo 150 120 self
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

