;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
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
					(proc0_28 177 205 0 67 10 10 25 7) ; "It's you again, is it? We still don't have any shoes for sale."
					(wHands cycleSpeed: 3 setCycle: Fwd init:)
					(HandsOn)
					(client setScript: 0)
				else
					(SetFlag 23)
					(proc0_28 177 205 1 67 10 10 70 200 25 9) ; "Take a look around if you want, but we don't have any shoes to sell you right now."
					(RedrawCast)
					(proc0_28 177 205 2 67 10 10 70 200 25 15) ; "We sold our last finished pair yesterday. Our business ain't doin' so good anymore and we're gettin' too old to keep tryin'."
					(RedrawCast)
					(proc0_28 160 205 3 67 60 100 70 140 25 7) ; "Is there anything I can do to help?"
					(RedrawCast)
					(proc0_28 177 205 4 67 10 10 25 11) ; "There ain't nothin' you can do short o' buyin' us out. But, like I said, if you want to look around, feel free."
					(RedrawCast)
					(woman setCycle: Beg self)
				)
			)
			(3
				(proc0_28 160 205 5 67 60 110 25 4) ; "Okay, thanks."
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
				(proc0_28 175 205 6 67 10 10 25 7) ; "What have we here? Mama, take those shoes from the young man. Let me see them."
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
				(gEgo normal: 1 view: 0 loop: 7 cel: 0 setCycle: KQ5SyncWalk)
				((gEgo head:) show:)
				(proc0_7 gEgo shoeMaker 5)
				(shoeMaker view: 200 loop: 10 cel: 0 setCycle: CT 3 1)
				(woman setLoop: -1 setMotion: MoveTo 225 133 self)
			)
			(7
				(woman loop: 1)
				(RedrawCast)
				(proc0_28 175 205 7 67 10 10 25 7) ; "These are the finest pair of shoes I've ever seen. The leather is soft and pliable, yet sturdy."
				(RedrawCast)
				(proc0_28 175 205 8 67 10 10 25 8) ; "The craftmanship of the shoes are superb. And, Mama, look at the solid gold buckle! Why, I could retire with the sale of these shoes!"
				(RedrawCast)
				(proc0_28 160 205 9 67 10 10 25 7) ; "Then the shoes are yours. I don't think I could find any use for them."
				(RedrawCast)
				(proc0_28 175 205 10 67 10 10 25 7) ; "You're a godsend, young man! How can we ever repay you?"
				(RedrawCast)
				(proc0_28 160 205 11 67 10 10 25 7) ; "You don't need to repay me. Just knowing I helped you is enough for me."
				(shoeMaker loop: 10 cycleSpeed: 3 setCycle: End self)
			)
			(8
				(shoeMaker loop: 8 cel: 0 setCycle: End self)
			)
			(9
				(proc0_28 175 205 12 67 10 10 25 9) ; "Well, it ain't much, but it's all I've got to give. Here, take my cobbler's hammer. Perhaps you can find a use for it."
				(RedrawCast)
				(proc0_28 175 205 13 67 10 10 25 7) ; "Since I'll be retirin' I won't need it anymore...thanks to you."
				(gEgo
					normal: 1
					view: 0
					setAvoider: (Avoid new:)
					setCycle: KQ5SyncWalk
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
				(proc0_28 160 205 14 67 10 10 25 7) ; "Why...thank you. A hammer could come in mighty useful on my journey."
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
				(RedrawCast)
				(proc0_28 177 205 15 67 10 10 25 5) ; "Take care, young man. We'll never forget this."
				(RedrawCast)
				(proc0_28 175 205 16 67 10 10 25 8) ; "That's right, son. We'll finally be able to retire in comfort. You'll be in our hearts from now on."
				(RedrawCast)
				(proc0_28 175 205 17 67 10 10 25 8) ; "Come on, Mama. Let's go home. Let's celebrate our good fortune!"
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
				(shoeArm loop: 6 setCycle: Fwd)
				(= seconds (Random 3 6))
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
				(proc0_28 160 205 18 67 60 10 25 4) ; "You don't have any shoes for sale, huh?"
				(RedrawCast)
				(proc0_28 177 205 19 67 10 10 25 8) ; "That's right. No shoes at all. We're makin' a pair right now, but it'll take awhile...we're not as fast as we used to be."
				(RedrawCast)
				(proc0_28 160 205 20 67 60 10 25 6) ; "Well, that's okay. My trusty boots should carry me through the rest of my journey."
				(RedrawCast)
				(proc0_28 177 205 21 67 10 10 25 4) ; "Sorry, son. We're doin' the best we can."
				(= cycles 1)
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
						(PrintDC 205 22) ; "The old shoemaker, eyes squinted and fingers calloused from years of making shoes, drives tiny nails into a shoe sole with a small cobbler's hammer."
					else
						(PrintDC 205 23) ; "The shoeshop looks even more empty now that the shoemaker and his wife have left."
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local1)
						(++ local1)
						(PrintDC 205 24) ; "The old shoemaker wearily hammers tiny nails in a shoe sole. He doesn't even seem to notice Graham."
						(event claimed: 1)
					)
				)
				(5 ; Talk
					(PrintDC 205 24) ; "The old shoemaker wearily hammers tiny nails in a shoe sole. He doesn't even seem to notice Graham."
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
							(PrintDC 205 25) ; "The shoemaker isn't even paying any attention to Graham."
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
						(PrintDC 205 22) ; "The old shoemaker, eyes squinted and fingers calloused from years of making shoes, drives tiny nails into a shoe sole with a small cobbler's hammer."
					else
						(PrintDC 205 23) ; "The shoeshop looks even more empty now that the shoemaker and his wife have left."
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local1)
						(++ local1)
						(PrintDC 205 26) ; "The old shoemaker wearily hammers tiny nails in a shoe sole. He doesn't even seem to notice Graham."
						(event claimed: 1)
					)
				)
				(5 ; Talk
					(PrintDC 205 27) ; "The old shoemaker wearily hammers tiny nails in a shoe sole. He doesn't even seem to notice Graham."
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
							(proc0_28 177 205 28 67 10 10 25 7) ; "I TOL' you we ain't got no shoes for sale right now! Come back another day."
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
					(PrintDC 205 29) ; "The shoemaker's wife, looking haggard and worn, tiredly stitches away at a large piece of shoe leather."
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local2)
						(++ local2)
						(PrintDC 205 30) ; "The poor woman has enough troubles of her own without worrying about Graham's."
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
							(PrintDC 205 31) ; "So as not to upset the poor woman further, Graham politely decides not to question her again."
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
							(PrintDC 205 32) ; "The old woman isn't interested in that."
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
					(PrintDC 205 33) ; "A skinny old dog lies down on the shoeshop's hard floor."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 205 34) ; "This old dog doesn't look very appealing."
					(event claimed: 1)
				)
				(5 ; Talk
					(PrintDC 205 35) ; "The old dog pays no attention to Graham."
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(28
							(event claimed: 0)
						)
						(else
							(PrintDC 205 36) ; "The dog doesn't show any interest in it."
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
						(PrintDC 205 37) ; "Business doesn't seem to be so good for the shoemaker and his wife. There isn't one pair of shoes for sale, and the old couple look worn out."
					else
						(PrintDC 205 38) ; "The old shop is empty now that the shoemaker and his wife have retired."
					)
					(event claimed: 1)
				)
			)
		)
	)
)

