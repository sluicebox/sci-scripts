;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Main)
(use Interface)
(use n762)
(use Chase)
(use RFeature)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	shoeShop 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 9] = [1017 170 70 3 7 25 23 25 32]
	[local15 9] = [1025 70 63 5 7 29 24 29 27]
	[local24 9] = [1025 200 70 5 7 29 24 29 27]
	[local33 9] = [1003 120 79 3 9 24 21 30 29]
	[local42 10] = [0 1017 1 1018 0 1019 1 1020 0 0]
	[local52 12] = [1 1024 1 1025 0 1026 1 1027 0 1028 0 0]
	[local64 12] = [1 1030 1 1031 0 1032 1 1033 0 1034 0 0]
	[local76 8] = [1 1035 1 1036 0 1037 0 0]
	[local84 8] = [0 1038 1 1039 1 1040 0 0]
)

(instance shoeShop of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (IsFlag 24)
			(++ local5)
		)
		(gCurRoom setFeatures: shopRoom)
		(gGlobalSound number: 61 loop: -1 play:)
		(if (!= ((gInventory at: 33) owner:) 205) ; Elf_Shoes
			(woman init:)
			(shoeArm init: setScript: makeShoe)
			(shoeMaker init: stopUpd:)
			(dog init:)
			(tail setCycle: Fwd init:)
			(gCurRoom setScript: greet)
		else
			(gCurRoom setScript: enterIn)
		)
	)

	(method (doit &tmp temp0)
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

	(method (dispose)
		(DisposeScript 985)
		(DisposeScript 972)
		(gGlobalSound fade:)
		(super dispose:)
	)
)

(instance enterIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 5)
			)
			(1
				(gEgo illegalBits: 0 setMotion: MoveTo 138 154 self)
			)
			(2
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance greet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 5)
			)
			(1
				(gEgo illegalBits: 0 setMotion: MoveTo 138 154 self)
			)
			(2
				(gEgo illegalBits: $8000)
				(if (IsFlag 23)
					(proc762_1 @local15 1023)
					(wHands cycleSpeed: 3 setCycle: Fwd init:)
					(HandsOn)
					(client setScript: 0)
				else
					(SetFlag 23)
					(proc762_0 @local33 @local15 @local52)
					(woman setCycle: Beg self)
				)
			)
			(3
				(RedrawCast)
				(wHands cycleSpeed: 3 setCycle: Fwd init:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance giveShoes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(shoeArm dispose:)
				(shoeMaker
					setScript: 0
					loop: 7
					cel: 4
					cycleSpeed: 2
					setCycle: Beg self
				)
			)
			(1
				(proc762_1 @local6 1029)
				(wHands dispose:)
				(woman setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 138 148 self)
			)
			(3
				(woman
					view: 210
					setLoop: -1
					posn: 96 140
					setPri: -1
					setCycle: Walk
					setAvoider: (Avoid new:)
					cycleSpeed: 0
					moveSpeed: 0
					setMotion: MoveTo 127 146 self
				)
			)
			(4
				(woman loop: 2)
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 200 loop: 11 cel: 0 setCycle: End self)
			)
			(5
				(gEgo setCycle: Beg)
				(woman setLoop: 8 setMotion: Chase shoeMaker 10 self)
				(shoeMaker
					view: 198
					observeControl: 2
					cycleSpeed: 0
					setLoop: -1
					loop: 2
					setCycle: Walk
					moveSpeed: 0
					setMotion: MoveTo 208 127
				)
			)
			(6
				(gEgo normal: 1 view: 0 loop: 7 cel: 0 setCycle: SyncWalk)
				((gEgo head:) show:)
				(proc0_7 gEgo shoeMaker 5)
				(shoeMaker view: 200 loop: 10 cel: 0 setCycle: CT 3 1)
				(woman setLoop: -1 setMotion: MoveTo 225 133 self)
			)
			(7
				(woman loop: 1)
				(proc762_0 @local33 @local6 @local64)
				(shoeMaker loop: 10 cycleSpeed: 3 setCycle: End self)
			)
			(8
				(shoeMaker loop: 8 cel: 0 setCycle: End self)
			)
			(9
				(proc762_0 @local33 @local6 @local76)
				(gEgo
					normal: 1
					view: 0
					setAvoider: (Avoid new:)
					setCycle: SyncWalk
					setMotion: MoveTo 195 128 self
				)
				((gEgo head:) show:)
			)
			(10
				(gEgo setAvoider: 0 normal: 1)
				(proc0_7 gEgo shoeMaker 5)
				(= cycles 5)
			)
			(11
				(shoeMaker loop: 9 cel: 0 setCycle: End self)
			)
			(12
				(shoeMaker
					view: 198
					observeControl: 2
					cycleSpeed: 0
					setLoop: -1
					setCycle: Walk
					loop: 2
				)
				(proc762_0 @local24 @local6 @local84)
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 10) (gEgo y:) self
				)
				(tail dispose:)
				(dog loop: 3 cel: 0 setCycle: End self)
			)
			(13)
			(14
				(dog
					setLoop: 4
					setCycle: Walk
					setMotion: MoveTo (dog x:) 237 self
				)
				(gEgo loop: 7 cel: 2)
				(shoeMaker
					view: 198
					observeControl: 2
					cycleSpeed: 0
					setLoop: -1
					setCycle: Walk
					moveSpeed: 0
					setMotion: MoveTo 180 237 self
				)
				(woman
					cycleSpeed: 0
					moveSpeed: 0
					setAvoider: 0
					setMotion: MoveTo 160 240
				)
			)
			(15)
			(16
				(gCurRoom obstacles: global322)
				(dog dispose:)
				(shoeMaker setAvoider: 0 dispose:)
				(woman setAvoider: 0 dispose:)
				(gEgo setAvoider: 0)
				(HandsOn)
				(cls)
				(client setScript: 0)
			)
		)
	)
)

(instance makeShoe of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(not (self state:))
				(== (shoeArm cel:) 2)
				(== (gGlobalSound3 prevSignal:) -1)
			)
			(gGlobalSound3 number: 885 loop: 1 vol: 127 play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(shoeArm cycleSpeed: 3 loop: 4 setCycle: Fwd)
				(= seconds (Random 3 8))
			)
			(1
				(shoeArm loop: 5 setCycle: Fwd)
				(= seconds (Random 3 8))
				(= state -1)
			)
			(2
				(shoeArm loop: 6 setCycle: End)
				(= seconds (Random 3 8))
				(= state -1)
			)
		)
	)
)

(instance womanScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc0_7 gEgo woman 5)
				(wHands hide:)
				(woman setCycle: End self)
			)
			(1
				(proc762_0 @local33 @local15 @local42 self)
			)
			(2
				(woman setCycle: Beg self)
			)
			(3
				(wHands show:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance shoeArm of Prop
	(properties
		x 197
		y 102
		view 200
		loop 4
		priority 9
		signal 16
		cycleSpeed 2
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
					(if (gCast contains: woman)
						(Say 808)
					else
						(Say 809)
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local1)
						(++ local1)
						(Say 814)
						(event claimed: 1)
					)
				)
				(5 ; Talk
					(Say 814)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(33
							(event claimed: 1)
							(gEgo put: 33 205) ; Elf_Shoes
							(SetScore 4)
							(HandsOff)
							(gEgo get: 22) ; Hammer
							(gCurRoom setScript: giveShoes)
						)
						(28
							(event claimed: 0)
						)
						(else
							(Say 816)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance shoeMaker of Actor
	(properties
		x 198
		y 123
		view 200
		cycleSpeed 2
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
					(if (gCast contains: woman)
						(Say 808)
					else
						(Say 809)
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local1)
						(++ local1)
						(Say 814)
						(event claimed: 1)
					)
				)
				(5 ; Talk
					(Say 814)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(33
							(event claimed: 1)
							(gEgo put: 33 205) ; Elf_Shoes
							(SetScore 4)
							(HandsOff)
							(gEgo get: 22) ; Hammer
							(gCurRoom setScript: giveShoes)
						)
						(28
							(event claimed: 0)
						)
						(else
							(proc762_1 @local15 1021)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance wHands of Prop
	(properties
		x 95
		y 122
		view 210
		loop 4
		priority 11
		signal 16400
		cycleSpeed 2
	)
)

(instance woman of Actor
	(properties
		x 94
		y 126
		view 210
		loop 5
		cel 3
		priority 10
		signal 16
		cycleSpeed 2
		illegalBits $0800
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
					(Say 810)
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local2)
						(++ local2)
						(Say 9067)
						(event claimed: 1)
					)
				)
				(5 ; Talk
					(switch local5
						(0
							(SetFlag 24)
							(++ local5)
							(gCurRoom setScript: womanScript)
							(event claimed: 1)
						)
						(1
							(Say 820)
							(event claimed: 1)
						)
					)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(33
							(gEgo get: 22) ; Hammer
							(gEgo put: 33 205) ; Elf_Shoes
							(SetScore 4)
							(HandsOff)
							(gCurRoom setScript: giveShoes)
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
						(else
							(Say 817)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance tail of Prop
	(properties
		x 124
		y 124
		view 196
		loop 1
		priority 9
		signal 16
		cycleSpeed 3
	)
)

(instance dog of Actor
	(properties
		x 130
		y 134
		view 196
		signal 16384
	)

	(method (doit)
		(super doit:)
		(cond
			((>= loop 3)
				(self cycleSpeed: 0)
			)
			((and (< (gEgo distanceTo: self) 20) (!= local4 0))
				(= local4 0)
				(self loop: 0 setCycle: End)
				(tail hide:)
			)
			((and (> (gEgo distanceTo: self) 21) (!= local4 1))
				(= local4 1)
				(self setCycle: Beg)
			)
			((and (== (self cel:) 0) (== local4 1))
				(self loop: 2)
				(tail show:)
			)
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
					(Say 811)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 815)
					(event claimed: 1)
				)
				(5 ; Talk
					(Say 821)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(28
							(event claimed: 0)
						)
						(else
							(Say 818)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance shopRoom of RFeature
	(properties
		nsBottom 200
		nsRight 320
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
					(if (gCast contains: woman)
						(Say 812)
					else
						(Say 813)
					)
					(event claimed: 1)
				)
			)
		)
	)
)

