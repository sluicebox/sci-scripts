;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 682)
(include sci.sh)
(use Main)
(use Interface)
(use KQ5Room)
(use Sync)
(use RandCycle)
(use LoadMany)
(use Follow)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	cdIceQueen 0
)

(local
	[local0 8] = [90 60 160 20 93 29 141 11]
	local8
	local9
)

(instance cdIceQueen of KQ5Room
	(properties
		picture 92
		east 35
		south 34
	)

	(method (init)
		(super init:)
		(= local9 (gGame egoMoveSpeed:))
		(gGame egoMoveSpeed: 1)
		(Load rsSCRIPT 941)
		(Load rsSCRIPT 929)
		(Load rsPIC 92)
		(Load rsSOUND 118)
		(switch gPrevRoomNum
			(39
				(LoadMany rsSYNC 945 947 948 949)
				(gEgo setPri: -1 posn: 135 157)
				(gGlobalSound number: 118 loop: -1 play:)
				(wolf2 cel: 4 init:)
				(wolf1 setLoop: 5 cel: 4)
				(SetFlag 57)
				(self setScript: cartoon2)
			)
			(else
				(Load rsPIC 95)
				(Load rsSCRIPT 971)
				(Load rsSOUND 93)
				(Load rsSOUND 94)
				(Load rsVIEW 10)
				(LoadMany rsSYNC 935 936 937)
				(gEgo loop: 3 cel: 3 posn: 135 157)
				(HandsOff)
				(self setScript: cartoon1)
			)
		)
		(LoadMany rsVIEW 846 917 138 848 856 0)
		(iceQueen init:)
		(wolf1 init:)
		(wolf2 init:)
		(cage setPri: 14 init: stopUpd:)
		(cedric setScript: (ScriptID 202 3) init:) ; rotate
		(gEgo
			normal: 0
			view: 856
			loop: 13
			cel: 0
			moveSpeed: 0
			xStep: 3
			yStep: 2
			init:
		)
		((gEgo head:) hide:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gCurRoom newRoom: temp0)
			)
		)
		(wolf1
			cycleSpeed: (gGame egoMoveSpeed:)
			moveSpeed: (gGame egoMoveSpeed:)
		)
		(wolf2
			cycleSpeed: (gGame egoMoveSpeed:)
			moveSpeed: (gGame egoMoveSpeed:)
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

	(method (dispose)
		(DisposeScript 941)
		(DisposeScript 971)
		(gGame egoMoveSpeed: local9)
		(super dispose:)
	)
)

(instance cartoon1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGlobalSound2 stop:)
				(gGlobalSound number: 92 loop: -1 play:)
				(theMouth init: hide:)
				(wolf1 cycleSpeed: 2 setCycle: End init:)
				(wolf2 cycleSpeed: 2 setCycle: End init:)
				(= cycles 30)
			)
			(2
				(iceQueen cycleSpeed: 3 setCycle: End self)
			)
			(3
				(= local8 1)
				(iceQueen loop: 5 cycleSpeed: 8 setCycle: RandCycle show:)
				(theMouth setCycle: MouthSync 935 show:)
				(Say 935 self)
			)
			(4
				(= local8 0)
				(theMouth hide:)
				(iceQueen setCycle: 0)
				(cls)
				(gEgo cycleSpeed: 3 setCycle: End self)
			)
			(5
				(iceQueen loop: 6 cel: 0 setCycle: End)
				(gEgo loop: 12 cel: 2)
				(theMouth setCycle: MouthSync 936 show:)
				(Say 936 self)
			)
			(6
				(= local8 1)
				(cls)
				(iceQueen loop: 7 setCel: 1 posn: 248 80)
				(cage hide:)
				(cedric hide:)
				(wolf1 hide:)
				(wolf2 hide:)
				(gEgo loop: 12 cel: 1 posn: 10 171)
				(theMouth changeMouth: 1)
				(gCurRoom drawPic: 95)
				(qArm cycleSpeed: 8 setCycle: RandCycle init:)
				(theMouth setCycle: MouthSync 937)
				(Say 937 self)
			)
			(7
				(= local8 0)
				(cls)
				(gCurRoom drawPic: 92)
				(gTheIconBar disable: 0 1 2 3)
				(wolf1 show:)
				(wolf2 show:)
				(cedric show:)
				(theMouth changeMouth: 0 hide:)
				(qArm dispose:)
				(iceQueen loop: 6 posn: 129 62 cel: (- (NumCels iceQueen) 1))
				(cage view: 846 loop: 4 x: 264 y: 109 show:)
				(gEgo loop: 13 posn: 135 157)
				(gEgo cel: (- (NumCels gEgo) 1))
				(= cycles 5)
			)
			(8
				(gTheIconBar enable:)
				(gGame setCursor: gTheCrownCursor)
				(User canInput: 1)
				(gGlobalSound number: 93 loop: -1 play:)
				(if (HaveMouse)
					(= cycles 1)
				else
					(= seconds 12)
				)
			)
			(9
				(wolf1 setCycle: Beg self)
				(wolf2 setCycle: Beg self)
			)
			(10)
			(11
				(wolf1
					setLoop: 1
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 95 (wolf1 y:) self
				)
				(wolf2
					setLoop: 0
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 179 (wolf2 y:) self
				)
			)
			(12)
			(13
				(gTheIconBar disable:)
				(HandsOff)
				(gGlobalSound number: 94 loop: 1 play:)
				(gEgo loop: 10 cel: 0 setCycle: End self)
			)
			(14
				(wolf1 view: 917 loop: 1 cel: 0 setCycle: End self)
				(wolf2 view: 917 loop: 0 cel: 0 setCycle: End)
			)
			(15
				(= cycles 1)
			)
			(16
				(cls)
				(= global330 757)
				(EgoDead 543 0 Fwd)
			)
			(17
				(HandsOff)
				((ScriptID 763) doit:) ; cartoonCode
				(UnLoad 129 95)
				(UnLoad 142 935)
				(UnLoad 142 936)
				(UnLoad 142 937)
				(Load rsSOUND 817)
				(LoadMany rsSYNC 938)
				(= cycles 1)
			)
			(18
				(gEgo loop: 2 setCycle: Fwd cycleSpeed: 4)
				(note init: setScript: noteScript)
				(gGlobalSound number: 817 loop: 1 play: self)
				(wolf1 setMotion: 0 setCycle: 0)
				(wolf2 setMotion: 0 setCycle: 0)
				(= seconds 3)
			)
			(19
				(theMouth setCycle: MouthSync 938 show:)
				(Say 938 0 1)
				(wolf1 cycleSpeed: 2 setLoop: 5 setCycle: End)
				(wolf2
					cycleSpeed: 2
					setPri: 1
					setLoop: 4
					ignoreActors: 1
					setCycle: End
				)
			)
			(20
				(= local8 1)
				(= seconds 4)
				(note setScript: 0 dispose:)
				(gEgo loop: 13 cel: 3 setCycle: 0)
			)
			(21
				(UnLoad 142 938)
				(Load rsPIC 93)
				(LoadMany rsVIEW 852 1030)
				(Load rsSOUND 118)
				(LoadMany rsSYNC 939 940 941 942 943 944)
				(theMouth hide:)
				(gGlobalSound number: 118 loop: -1 play:)
				(cls)
				(gCurRoom drawPic: 93)
				(cage hide:)
				(cedric hide:)
				(wolf1 hide:)
				(wolf2 hide:)
				(gEgo hide:)
				(iceQueen hide:)
				(theMouth changeMouth: 2)
				(theEyes setScript: moveScript init:)
				(glint setScript: glintScript init:)
				(= seconds 2)
			)
			(22
				(theMouth setCycle: MouthSync 939 show:)
				(Say 939 self)
			)
			(23
				(theMouth setCycle: MouthSync 940)
				(Say 940 self)
				(gGlobalSound fade:)
			)
			(24
				(theMouth hide:)
				(= cycles 1)
			)
			(25
				(glint dispose:)
				(UnLoad 129 93)
				(UnLoad 142 939)
				(UnLoad 142 940)
				(UnLoad 142 941)
				(UnLoad 142 942)
				(UnLoad 142 943)
				(UnLoad 142 944)
				(UnLoad 128 852)
				(UnLoad 128 1030)
				(Load rsPIC 92)
				(Load rsVIEW 10)
				(LoadMany rsSYNC 941 942 943 944)
				(RedrawCast)
				(cls)
				(theEyes dispose:)
				(gCurRoom drawPic: 92)
				(theMouth changeMouth: 0 show:)
				(cage show:)
				(cedric show:)
				(wolf1 show:)
				(wolf2 show:)
				(gEgo show:)
				(iceQueen loop: 5 cycleSpeed: 8 setCycle: RandCycle show:)
				(gGlobalSound number: 118 loop: -1 play:)
				(= seconds 2)
			)
			(26
				(theMouth setCycle: MouthSync 941)
				(Say 941 self)
			)
			(27
				(= local8 1)
				(gEgo setCycle: Beg)
				(theMouth setCycle: MouthSync 942)
				(Say 942 self)
			)
			(28
				(theMouth setCycle: MouthSync 943)
				(Say 943 self)
			)
			(29
				(theMouth setCycle: MouthSync 944)
				(Say 944 self)
			)
			(30
				(= local8 0)
				(theMouth hide:)
				(iceQueen cel: 0 setCycle: 0)
				(wolf1 setCycle: Beg self)
			)
			(31
				(cls)
				(wolf1
					setLoop: 1
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5) self
				)
			)
			(32
				(wolf2 setPri: 1)
				(wolf1
					moveSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo 340 175 self
				)
				(gEgo
					normal: 1
					view: 10
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
					setLoop: -1
					setPri: (- (wolf1 priority:) 1)
					ignoreActors: 1
					setMotion: MoveTo 340 175
				)
				((gEgo head:) show:)
			)
			(33
				(gGlobalSound fade:)
				(gCurRoom newRoom: 39)
			)
		)
	)
)

(instance glintScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 (Random 0 3))
				(client
					x: [local0 (* temp0 2)]
					y: [local0 (+ (* temp0 2) 1)]
					cel: 0
					setCycle: End self
				)
			)
			(1
				(= seconds (Random 3 9))
				(= state -1)
			)
		)
	)
)

(instance moveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(= cycles 10)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(= state -1)
				(= seconds (Random 3 10))
			)
		)
	)
)

(instance cartoon2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMouth init: hide: posn: (theMouth x:) (+ (theMouth y:) 1))
				(gTheIconBar disable:)
				(User canControl: 0 canInput: 0)
				(= cycles 5)
			)
			(1
				((gEgo head:) hide:)
				(gEgo normal: 0 cycleSpeed: 3 setCycle: End self)
			)
			(2
				(iceQueen cycleSpeed: 3 setCycle: End self)
			)
			(3
				(iceQueen loop: 5 cycleSpeed: 8 setCycle: RandCycle)
				(theMouth setCycle: MouthSync 945 show:)
				(Say 945 self)
			)
			(4
				(gEgo loop: 8 cycleSpeed: 6 setScript: (moveScript new:))
				(iceQueen setCycle: 0)
				(theMouth hide:)
				(Say 946 self)
			)
			(5
				(gEgo loop: 13 cel: 3 setCycle: 0 setScript: 0)
				(iceQueen loop: 5 cycleSpeed: 8 setCycle: RandCycle)
				(theMouth setCycle: MouthSync 947 show:)
				(Say 947 self)
			)
			(6
				(cls)
				(gEgo cycleSpeed: 2 setCycle: Beg self)
			)
			(7
				(gEgo
					normal: 1
					view: 10
					cycleSpeed: 0
					setLoop: 3
					setCycle: KQ5SyncWalk
				)
				((gEgo head:) show:)
				(theMouth setCycle: MouthSync 948)
				(Say 948 self)
			)
			(8
				(theMouth hide:)
				(iceQueen cycleSpeed: 5 setCycle: End self)
			)
			(9
				(= cycles 10)
			)
			(10
				(iceQueen loop: 8 cel: 0 setCycle: End self)
				(gGlobalAudio number: 8018 loop: 1 play:)
			)
			(11
				(= cycles 10)
			)
			(12
				(cls)
				(cage loop: 3 cel: 0 cycleSpeed: 8 setCycle: End self)
			)
			(13
				(iceQueen setCycle: Beg)
				(= cycles 10)
			)
			(14
				(iceQueen loop: 5 cycleSpeed: 8 setCycle: RandCycle)
				(cage dispose:)
				(theMouth setCycle: MouthSync 949 show:)
				(Say 949 self)
			)
			(15
				(wolf1 cycleSpeed: 3 setCycle: Beg self)
			)
			(16
				(theMouth hide:)
				(iceQueen setCycle: 0)
				(cls)
				(wolf1
					setLoop: 1
					cycleSpeed: 0
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5) self
				)
			)
			(17
				(gEgo setLoop: -1 setMotion: Follow wolf1 40)
				(wolf1
					moveSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo 340 169 self
				)
			)
			(18
				(cedric view: 138 loop: 5 cel: 0 setScript: cedricLeave)
			)
		)
	)
)

(instance cedricLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cedric cycleSpeed: 2 setCycle: CT 4 1 self)
			)
			(1
				(cedric setLoop: 6 setCycle: End self)
			)
			(2
				(gGlobalSound fade:)
				(gTheIconBar enable:)
				(gCurRoom newRoom: 39)
			)
		)
	)
)

(instance noteScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(note
					x: (- (gEgo x:) 30)
					y: (- (gEgo y:) 30)
					setCel: (Random 0 3)
					setMotion:
						MoveTo
						(- (gEgo x:) 50)
						(- (gEgo y:) 50)
						self
				)
				(= state -1)
			)
		)
	)
)

(instance cedric of Prop
	(properties
		x 264
		y 108
		view 138
		loop 5
	)
)

(instance cage of Prop
	(properties
		x 264
		y 109
		view 846
		loop 3
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn gEgo event))
			)
			(return)
		else
			(switch (event message:)
				(4 ; Inventory
					(if (MousedOn gEgo event)
						(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
							(10
								(SetScore 4)
								(cartoon1 changeState: 17)
								(event claimed: 1)
							)
						)
					)
				)
			)
		)
	)
)

(instance iceQueen of Prop
	(properties
		x 129
		y 62
		view 848
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
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(10
							(SetScore 4)
							(cartoon1 changeState: 17)
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
						(else
							(Say 756)
						)
					)
				)
			)
		)
	)
)

(instance wolf1 of Actor
	(properties
		x 24
		y 159
		view 856
		loop 5
	)
)

(instance wolf2 of Actor
	(properties
		x 304
		y 159
		view 856
		loop 4
	)
)

(instance theEyes of Prop
	(properties
		x 164
		y 58
		view 852
	)
)

(instance theMouth of Prop
	(properties
		x 138
		y 25
		view 848
		loop 4
		priority 14
		signal 16
	)

	(method (changeMouth param1)
		(switch param1
			(0
				(theMouth
					view: 848
					loop: 4
					x: 138
					y: 25
					cel: 0
					priority: 14
					signal: 16
				)
			)
			(1
				(theMouth
					loop: 10
					x: (iceQueen x:)
					y: (- (iceQueen y:) 35)
					cel: 0
				)
			)
			(2
				(theMouth view: 1030 loop: 2 x: 139 y: 96 cel: 0)
			)
		)
	)
)

(instance glint of Prop
	(properties
		x 90
		y 60
		view 852
		loop 2
	)
)

(instance qArm of Prop
	(properties
		x 247
		y 44
		view 848
		loop 1
		priority 14
		signal 16
	)
)

(instance note of Actor
	(properties
		view 856
		loop 3
		signal 2048
	)
)

(instance theScriptSync of ScriptSync ; UNUSED
	(properties)
)

