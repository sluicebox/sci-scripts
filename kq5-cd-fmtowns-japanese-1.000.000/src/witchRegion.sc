;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use Interface)
(use n762)
(use PolyPath)
(use Blk)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	witchRegion 0
	poofOutScript 1
)

(local
	local0
	local1
	local2
	local3
	[local4 9] = [1010 100 62 4 11 32 30 32 35]
	[local13 16] = [1 980 0 981 1 982 0 983 1 984 0 985 1 986 0 0]
	[local29 9] = [1003 130 62 4 11 25 23 31 31]
)

(instance witchRegion of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (== gCurRoomNum 22)
			(LoadMany rsVIEW 447 446 454 440 442)
			(= local0 0)
		else
			(= local0 1)
		)
		(if (== gPrevRoomNum 208) ; releaseGenie
			(self setScript: witchMsgScript)
		)
		(if
			(or
				(and (== gCurRoomNum 22) (!= ((gInventory at: 6) owner:) 200)) ; Brass_Bottle
				(and
					(!= gCurRoomNum 19)
					(or
						(and (IsFlag 18) (!= ((gInventory at: 6) owner:) 200)) ; Brass_Bottle
						(and (not (IsFlag 18)) (< (Random 1 1000) 500))
					)
				)
			)
			(witch view: (+ 440 local0) init:)
			(SetFlag 90)
		)
		(cond
			((== gCurRoomNum 22)
				(gGlobalSound number: 41 loop: -1 vol: 127 playBed:)
			)
			((IsFlag 90)
				(if (!= (gGlobalSound number:) 20)
					(gGlobalSound number: 20 loop: -1 vol: 127 playBed:)
				)
			)
			(
				(and
					(== gCurRoomNum 24)
					(== ((gInventory at: 6) owner:) 200) ; Brass_Bottle
					(not (IsFlag 56))
				)
				(gGlobalSound number: 28 loop: -1 vol: 127 playBed:)
			)
			((and (== gCurRoomNum 21) (== ((gInventory at: 9) owner:) 21)) ; Heart
				(gGlobalSound number: 34 loop: -1 vol: 127 playBed:)
			)
			((or (!= (gGlobalSound number:) 4) (== gCurRoomNum 19))
				(gGlobalSound number: 4 loop: -1 vol: 127 playBed:)
			)
		)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (newRoom)
		(super newRoom:)
	)

	(method (dispose)
		(ClearFlag 90)
		(super dispose:)
	)
)

(instance witchMsgScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(proc762_1 @local29 990)
				(client setScript: 0)
			)
		)
	)
)

(instance poofOutScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(switch register
					(1
						(-= temp1 0)
					)
					(3
						(+= temp1 60)
					)
					(2
						(+= temp0 20)
					)
					(4
						(-= temp0 20)
					)
				)
				(gEgo ignoreActors: 1 setMotion: MoveTo temp0 temp1 self)
				(if (IsFlag 90)
					(witch
						view: (+ 442 local0)
						loop: 0
						cel: 6
						cycleSpeed: 2
						setCycle: Beg
					)
					(gGlobalSound3 number: 95 priority: 15 loop: 1 vol: 127 play:)
				)
			)
			(1
				(if (IsFlag 90)
					(switch register
						(1
							(= cycles 25)
						)
						(3
							(= cycles 1)
						)
						(else
							(= cycles 15)
						)
					)
				else
					(= cycles 1)
				)
			)
			(2
				(gCurRoom newRoom: (gCurRoom edgeToRoom: register))
				(HandsOn)
			)
		)
	)
)

(instance poofIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(witch
					view: (+ 442 local0)
					loop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: CT 1 1 self
				)
			)
			(1
				(witch setCycle: End self)
				(gGlobalSound3 number: 95 priority: 15 loop: 1 vol: 127 play:)
			)
			(2
				(witch view: (+ 440 local0))
				(proc0_7 witch gEgo 5)
				(self cue:)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance zapHim of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (!= (gGlobalSound3 number:) 96) (== state 2) (== (witch cel:) 2))
			(fireball
				init:
				x:
					(+
						(witch x:)
						(switch (witch loop:)
							(0 10)
							(1 -10)
							(else 0)
						)
					)
				y: (- (witch y:) 25)
				setLoop: (witch loop:)
				cel: 0
				setCycle: Walk
				setStep: 5 5
				setMotion: MoveTo (gEgo x:) (- (gEgo y:) 25) self
			)
			(gGlobalSound3 number: 96 priority: 15 loop: 1 vol: 127 play:)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0
					(GetAngle (witch x:) (witch y:) (gEgo x:) (gEgo y:))
				)
				(witch
					view: (+ 442 local0)
					loop:
						(cond
							((< temp0 135) 0)
							((< temp0 225) 2)
							(else 1)
						)
					cel: 0
					cycleSpeed: 2
					setCycle: CT 1 1 self
				)
			)
			(1
				(witch setCycle: End self)
				(gGlobalSound3 number: 95 priority: 15 loop: 1 vol: 127 play:)
			)
			(2
				(SetFlag 18)
				(= temp0
					(GetAngle (witch x:) (witch y:) (gEgo x:) (gEgo y:))
				)
				(witch
					view: (+ 446 local0)
					loop:
						(cond
							((< temp0 45) 3)
							((< temp0 135) 0)
							((< temp0 225) 2)
							((< temp0 315) 1)
							(else 3)
						)
					cel: 0
					setCycle: End self
				)
			)
			(3
				(witch setCycle: End)
			)
			(4
				(if (and (gEgo has: 27) (IsFlag 84)) ; Amulet
					(fireball loop: 9 cel: 0 setCycle: End self)
					(+= state 2)
					(gGlobalSound3 number: 82 priority: 15 loop: 1 vol: 127 play:)
				else
					(fireball dispose:)
					((gEgo head:) hide:)
					(gEgo
						normal: 0
						view: (+ 454 local0)
						cel: 0
						setCycle: End self
					)
					(gGlobalSound3 number: 79 priority: 15 loop: 1 vol: 127 play:)
					(gGlobalSound stop:)
					(gGlobalSound2 stop:)
					(gGlobalSound4 stop:)
				)
			)
			(5
				(= seconds 5)
			)
			(6
				(= global330 852)
				(EgoDead 249)
			)
			(7
				(fireball dispose:)
				(= cycles 1)
			)
			(8
				(Say 853)
				(= cycles 1)
			)
			(9
				(= register (witch loop:))
				(witch
					view: (+ 448 local0)
					loop: (if (not register) 1 else 0)
					cel:
						(switch register
							(2 3)
							(3 0)
							(else 1)
						)
					setCycle: CT 6 1 self
				)
			)
			(10
				(witch setCycle: End self)
				(gGlobalSound3 number: 83 priority: 15 loop: 1 vol: 127 play:)
			)
			(11
				(switch register
					(2
						(= register 3)
					)
					(3
						(= register 0)
					)
					(else
						(= register 1)
					)
				)
				(witch setCycle: CT register -1 self)
			)
			(12
				(= local1 1)
				(= temp0
					(GetAngle (witch x:) (witch y:) (gEgo x:) (gEgo y:))
				)
				(witch
					view: (+ 440 local0)
					loop:
						(cond
							((< temp0 45) 3)
							((< temp0 135) 0)
							((< temp0 225) 2)
							((< temp0 315) 1)
							(else 3)
						)
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance talkToWitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cls)
				(proc762_0 @local29 @local4 @local13 self)
			)
			(1
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance killTheBitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 6 200) ; Brass_Bottle
				(SetScore 4)
				(HandsOff)
				(gEgo
					setMotion: PolyPath (- (witch x:) 25) (+ (witch y:) 5) self
				)
			)
			(1
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 1) (- (gEgo y:) 1) self
				)
			)
			(2
				(if (== gCurRoomNum 22)
					(gEgo view: 434 loop: 5)
				else
					(gEgo view: 408 loop: 1)
				)
				((gEgo head:) hide:)
				(gEgo normal: 0 cel: 0 cycleSpeed: 2 setCycle: CT 3 1 self)
			)
			(3
				(if (== gCurRoomNum 22)
					(bottle
						view: 434
						loop: 6
						posn: (+ (gEgo x:) 8) (- (gEgo y:) 1)
						init:
					)
				else
					(bottle
						view: 414
						loop: 0
						posn: (+ (gEgo x:) 9) (- (gEgo y:) 3)
						init:
					)
				)
				(gEgo setCycle: End self)
			)
			(4
				(= global322 200)
				(= global110 (gEgo x:))
				(= global111 (gEgo y:))
				(proc762_1 @local4 987)
				(gCurRoom newRoom: 208) ; releaseGenie
			)
		)
	)
)

(instance fireball of Actor
	(properties
		view 452
		signal 24576
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(if
			(or
				(== gCurRoomNum 22)
				(and (== gCurRoomNum 25) (or (== gPrevRoomNum 19) (== gPrevRoomNum 26)))
			)
			(self setPri: 14)
		)
	)
)

(instance witchCage of Cage
	(properties)
)

(instance witch of Actor
	(properties
		view 440
		signal 16384
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(if
			(and
				local1
				(!= (gCurRoom script:) (ScriptID 200 1)) ; poofOutScript
				(!= (gCurRoom script:) poofIn)
			)
			(self
				setLoop: 0
				cel:
					(Min
						7
						(/
							(*
								(GetAngle
									(self x:)
									(self y:)
									(gEgo x:)
									(gEgo y:)
								)
								4
							)
							180
						)
					)
			)
			(if
				(and
					(== gCurRoomNum 22)
					(!= (self script:) killTheBitch)
					(not local2)
					(< (gEgo distanceTo: witch) 5)
				)
				(++ local2)
				(proc762_1 @local4 988)
			)
		)
	)

	(method (init)
		(super init:)
		(switch gCurRoomNum
			(20
				(self posn: 250 128)
			)
			(21
				(self posn: 159 160)
			)
			(22
				(self
					posn: 143 146
					loop: 2
					observeBlocks: witchCage
					setStep: 1 1
					cel: 0
				)
			)
			(24
				(self posn: 188 111)
			)
			(25
				(self posn: 156 126)
			)
			(26
				(self posn: 243 121)
			)
		)
		(HandsOff)
		(if (IsFlag 18)
			(= local1 1)
			(HandsOff)
			(gCurRoom setScript: poofIn)
		else
			(HandsOff)
			(gCurRoom setScript: zapHim)
		)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (== gCurRoomNum 22)
						(Say 854)
					else
						(Say 855)
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (and (gEgo has: 27) (IsFlag 18)) ; Amulet
						(Say 856)
					)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(6
							(event claimed: 1)
							(self setScript: killTheBitch)
						)
						(28
							(event claimed: 0)
						)
						(27
							(event claimed: 1)
							(Say 857)
						)
						(else
							(proc762_1 @local4 989)
							(event claimed: 1)
						)
					)
				)
				(5 ; Talk
					(if (IsFlag 19)
						(if (not (self script:))
							(self setScript: talkToTheBitch)
						)
						(event claimed: 1)
					else
						(SetFlag 19)
						(HandsOff)
						(self setScript: talkToWitch)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance talkToTheBitch of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Say 858 self)
			)
			(1
				(= temp0 (Random 4001 4005))
				(Say temp0 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance bottle of View
	(properties
		signal 4
	)
)

