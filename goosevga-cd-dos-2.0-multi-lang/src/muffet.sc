;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 602)
(include sci.sh)
(use Main)
(use n096)
(use ActorBody)
(use n411)
(use Avoid)
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
		signal 16384
	)

	(method (init &tmp temp0)
		(= global134 0)
		(self
			moveSpeed: (gEgo moveSpeed:)
			setAvoider: ((Avoid new:) offScreenOK: 1)
			setCycle: Walk
		)
		(cond
			((> argc 0)
				(self
					posn: (gPlace x:) (+ (gPlace y:) 5)
					setMotion: Orbit gPlace 20 0 68 60
				)
				(= local0 0)
			)
			((>= gCurRoomNum 36)
				(self posn: global115 global116 setMotion: 0)
				(proc0_7 self gEgo)
				(= local0 0)
			)
			((== gCurRoomNum 9)
				(= global113 0)
				(= global103 1)
				(if (== gPrevRoomNum 2)
					(self setScript: ClimbIn)
				else
					(self
						posn: (gEgo x:) (+ (gEgo y:) 20)
						setMotion: NewFollow gEgo 30
					)
					(self setScript: EnterIn)
				)
			)
			((== (= temp0 (gCurRoom roomToEdge: gPrevRoomNum)) 3)
				(self
					posn: (gEgo x:) (+ (gEgo y:) 10)
					setMotion: NewFollow gEgo 30
				)
			)
			(else
				(self
					posn: (gEgo x:) (gEgo y:)
					setMotion: NewFollow gEgo 30
				)
				(if (== gCurRoomNum 21)
					(self posn: 186 116)
				)
			)
		)
		(super init:)
		(if (and (< gCurRoomNum 36) (!= gCurRoomNum 9))
			(wave changeState: 0)
		)
	)

	(method (put)
		((gGoals at: 0) egoHas: 0)
		(if (< gCurRoomNum 36)
			(= [global200 gCurRoomNum] view)
			(if (wave register:)
				(= local1 2)
			else
				(self setMotion: Orbit gPlace 20 0 68 60)
			)
		else
			(relocateScript changeState: 0)
		)
		(= local0 0)
	)

	(method (get)
		((gGoals at: 0) egoHas: 1 egoSeen: 1)
		(= [global200 gCurRoomNum] 0)
		(self setMotion: NewFollow gEgo 30)
		(= local0 1)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((gCurRoom script:)
				(return)
			)
			((and (== (event type:) evVERB) (== (muffet view:) 42))
				(event claimed: 1)
				(proc0_2)
				(wave changeState: 3)
				(muffet setMotion: 0)
				(proc0_7 gEgo muffet)
				(proc0_7 muffet gEgo)
				(gCurRoom setScript: mconverse)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (< gCurRoomNum 36)
			(wave doit:)
		)
		(cond
			(script
				(script doit:)
			)
			((and (== gCurRoomNum 9) (!= global134 900))
				(= global134 900)
				(gCurRoom setScript: mconverse)
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
		(DisposeScript 602)
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
						cycleSpeed: 0
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

(instance relocateScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc96_1 (muffet view:))
				(switch gCurRoomNum
					(39
						(muffet
							setMotion:
								MoveTo
								(+ (muffet x:) 10)
								(+ (muffet y:) 40)
								self
						)
					)
					(40
						(muffet
							setMotion:
								MoveTo
								(+ (muffet x:) 10)
								(muffet y:)
								self
						)
					)
					(else
						(muffet setMotion: MoveTo 200 144 self)
					)
				)
			)
			(1
				((muffet head:) dispose:)
				(muffet dispose:)
				(self dispose:)
			)
		)
	)
)

(instance ClimbIn of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(= local3 (gEgo x:))
				(= temp0
					(+
						(= local4 (gEgo y:))
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
					setMotion: MoveTo local3 local4
				)
				(= cycles 1)
			)
			(1
				(if (and (== local3 (muffet x:)) (== local4 (muffet y:)))
					(User canControl: 0)
					(muffet setPri: -1 setLoop: -1 illegalBits: -32768)
					(= global113 1)
					(self dispose:)
				else
					(User canControl: 0)
					(-- state)
					(= cycles 1)
				)
			)
		)
	)
)

(instance EnterIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(if (gCurRoom script:)
					(-- state)
					(= cycles 1)
				else
					(self dispose:)
					(= global113 1)
				)
			)
		)
	)
)

(instance mconverse of Script
	(properties)

	(method (cue)
		(DoSound sndMASTER_VOLUME global125)
		(wave changeState: 0)
		(if local0
			(muffet setMotion: NewFollow gEgo 30)
		)
		(if (!= gScore gPossibleScore)
			(proc0_3)
			(self dispose:)
		)
		(DisposeScript 976)
		(if local5
			(muffet dispose:)
		)
		(if global172
			(gCurRoom newRoom: 45) ; mapRoom
		)
	)

	(method (init &tmp temp0)
		(proc0_20)
		(super init: &rest)
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
				(if (== global113 0)
					(-- state)
				)
				(proc0_2)
				(= cycles 1)
			)
			(1
				(proc0_2)
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo 217 126 self
				)
			)
			(2
				(gEgo setAvoider: 0)
				(proc0_7 gEgo muffet)
				(proc411_0 (gEgo head:) (muffet head:))
				(= cycles 2)
			)
			(3
				(gEgo say: register self)
			)
			(4
				(muffet say: (++ register) self)
			)
			(5
				(proc411_1)
				(muffet
					setLoop: -1
					illegalBits: -32768
					setMotion: MoveTo 150 120 self
				)
			)
			(6
				(muffet loop: 1)
				(self setScript: (ScriptID 309) self) ; rhymeScript
			)
			(7
				(= local5 1)
				(self dispose:)
			)
		)
	)
)

