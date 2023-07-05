;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use RandCycle)
(use Follow)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm092 0
)

(local
	[local0 8] = [90 60 160 20 93 29 141 11]
	local8
)

(instance rm092 of KQ5Room
	(properties
		picture 92
		east 35
		south 34
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(39
				(gEgo setPri: -1 posn: 135 157)
				(gGlobalSound number: 118 loop: -1 play:)
				(wolf2 cel: 4 init:)
				(wolf1 setLoop: 5 cel: 4)
				(SetFlag 57)
				(self setScript: cartoon2)
			)
			(else
				(gEgo loop: 3 cel: 3 posn: 135 157)
				(HandsOff)
				(self setScript: cartoon1)
			)
		)
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
		(super dispose:)
	)
)

(instance cartoon1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gGlobalSound2 stop:)
				(gGlobalSound number: 92 loop: -1 play:)
				(= cycles 30)
				(wolf1 cycleSpeed: 2 setCycle: End init:)
				(wolf2 cycleSpeed: 2 setCycle: End init:)
			)
			(2
				(iceQueen cycleSpeed: 3 setCycle: End self)
			)
			(3
				(= local8 1)
				(iceQueen loop: 5 cycleSpeed: 8 setCycle: RandCycle show:)
				(smallHead init: setCycle: Fwd)
				(PrintDC 92 0 #at 170 20 #width 130 #dispose) ; "I am Queen Icebella and you have entered MY domain now. I command you to KNEEL before me!"
				(= seconds 9)
			)
			(4
				(= local8 0)
				(smallHead hide:)
				(iceQueen setCycle: 0)
				(cls)
				(gEgo cycleSpeed: 3 setCycle: End self)
			)
			(5
				(smallHead show:)
				(iceQueen loop: 6 cel: 0 setCycle: End)
				(gEgo loop: 12 cel: 2)
				(PrintDC 92 1 #at 170 20 #width 130 #dispose) ; "Since both you and your friend over there..."
				(= seconds 7)
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
				(smallHead loop: 10 x: (iceQueen x:) y: (- (iceQueen y:) 35))
				(gCurRoom drawPic: 95)
				(qArm cycleSpeed: 8 setCycle: RandCycle init:)
				(PrintDC 92 2 #at 117 100 #dispose) ; "...have so thoughtlessly invaded my territory without my permission or knowledge, I have decided you shall both be put to death! Take him away, my pets!"
				(= seconds 13)
			)
			(7
				(= local8 0)
				(cls)
				(gCurRoom drawPic: 92)
				(gTheIconBar disable: 0 1 2 3)
				(wolf1 show:)
				(wolf2 show:)
				(cedric show:)
				(smallHead hide:)
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
				(PrintDC 92 3 #dispose) ; "It's not a pretty sight."
				(= seconds 3)
			)
			(16
				(cls)
				(EgoDead 543 0 Fwd)
			)
			(17
				(HandsOff)
				(gEgo loop: 2 setCycle: Fwd cycleSpeed: 4)
				(note init: setScript: noteScript)
				(gGlobalSound number: 817 loop: 1 play: self)
				(wolf1 setMotion: 0 setCycle: 0)
				(wolf2 setMotion: 0 setCycle: 0)
				(PrintDC 92 4 #at 20 20 #dispose #time 5) ; "Wait, my pets!"
				(wolf1 cycleSpeed: 2 setLoop: 5 setCycle: End)
				(wolf2
					cycleSpeed: 2
					setPri: 1
					setLoop: 4
					ignoreActors: 1
					setCycle: End
				)
			)
			(18
				(= local8 1)
				(smallHead setCycle: 0)
				(= seconds 4)
				(note setScript: 0 dispose:)
				(gEgo loop: 13 cel: 3 setCycle: 0)
			)
			(19
				((ScriptID 763) doit:) ; cartoonCode
				(= cycles 1)
			)
			(20
				(gGlobalSound number: 118 loop: -1 play:)
				(cls)
				(gCurRoom drawPic: 93)
				(cage hide:)
				(cedric hide:)
				(wolf1 hide:)
				(wolf2 hide:)
				(gEgo hide:)
				(iceQueen hide:)
				(smallHead hide:)
				(theMouth cycleSpeed: 4 setCycle: RandCycle init:)
				(theEyes setScript: moveScript init:)
				(glint setScript: glintScript init:)
				(PrintDC 92 5 #at 20 120 #width 270 #dispose) ; "That was very lovely music. I've never heard anything quite that beautiful before. I think I felt my heart melting just a little bit. Just enough, that is, to allow you a chance for your freedom."
				(= seconds 15)
			)
			(21
				(PrintDC 92 6 #at 20 107 #width 270 #dispose) ; "A vicious yeti has entered the area and taken up residence in my prized crystal cave. So far, I have been unable to extricate him from either the cave OR my territory. If you can rid me of the yeti I will release both you and your owl friend and you two can continue on with your journey unhindered."
				(= seconds 18)
			)
			(22
				(= local8 0)
				(theMouth dispose:)
				(RedrawCast)
				(cls)
				(gCurRoom drawPic: 92)
				(theEyes dispose:)
				(smallHead loop: 4 x: 138 y: 25 cel: 0 show:)
				(glint dispose:)
				(cage show:)
				(cedric show:)
				(wolf1 show:)
				(wolf2 show:)
				(gEgo show:)
				(iceQueen loop: 5 cycleSpeed: 8 setCycle: RandCycle show:)
				(smallHead setCycle: Fwd)
				(PrintDC 92 7 #at 170 20 #width 130 #dispose) ; "You may rise now."
				(= seconds 5)
			)
			(23
				(= local8 1)
				(gEgo setCycle: Beg)
				(PrintDC 92 8 #at 170 20 #width 130 #dispose) ; "I wish you luck in defeating the yeti. If you succeed you will have my undying gratitude."
				(= seconds 12)
			)
			(24
				(PrintDC 92 9 #width 130 #at 170 20 #dispose) ; "Go with him, Sir Greywolf. Show him the way to the crystal cave."
				(= seconds 10)
			)
			(25
				(PrintDC 92 10 #width 130 #at 170 20 #dispose) ; "You may go now. Sir Greywolf will lead the way."
				(= seconds 10)
			)
			(26
				(= local8 0)
				(smallHead setCycle: 0 dispose:)
				(iceQueen cel: 0 setCycle: 0)
				(wolf1 setCycle: Beg self)
			)
			(27
				(cls)
				(wolf1
					setLoop: 1
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5) self
				)
			)
			(28
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
					setPri: -1
					ignoreActors: 1
					setMotion: MoveTo 340 175
				)
				((gEgo head:) show:)
			)
			(29
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

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if local8
			(= temp1 ((= temp0 (Event new:)) type:))
			(if (OneOf temp1 1 4)
				(= seconds 0)
				(= cycles 1)
			)
			(temp0 dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar disable:)
				(User canControl: 0 canInput: 0)
				(= local8 1)
				(= cycles 5)
			)
			(1
				(= local8 0)
				((gEgo head:) hide:)
				(gEgo normal: 0 cycleSpeed: 3 setCycle: End self)
			)
			(2
				(iceQueen cycleSpeed: 3 setCycle: End self)
			)
			(3
				(= local8 1)
				(iceQueen loop: 5 cycleSpeed: 8 setCycle: RandCycle)
				(smallHead setCycle: Fwd init:)
				(PrintDC 92 11 #at 170 20 #width 130 #dispose) ; "Ah, good. You have returned in victory, I presume?"
				(= seconds 6)
			)
			(4
				(iceQueen setCycle: 0)
				(smallHead setCycle: 0 hide:)
				(PrintDC 92 12 #at 10 70 #width 210 #dispose) ; "Yes, Your Majesty. The yeti is dead. He will no longer be a scourge upon your realm. Are my friend and I free to go now?"
				(= seconds 13)
				(gEgo loop: 8 cycleSpeed: 6 setScript: (moveScript new:))
			)
			(5
				(gEgo loop: 13 cel: 3 setCycle: 0 setScript: 0)
				(iceQueen loop: 5 cycleSpeed: 8 setCycle: RandCycle)
				(smallHead setCycle: Fwd show:)
				(PrintDC 92 13 #at 170 20 #width 130 #dispose) ; "Yes. I keep my promises. I want to thank you for ridding my mountain domain of the horrible yeti. Please rise, King Graham."
				(= seconds 14)
			)
			(6
				(= local8 0)
				(cls)
				(gEgo cycleSpeed: 2 setCycle: Beg self)
			)
			(7
				(= local8 1)
				(gEgo
					normal: 1
					view: 10
					cycleSpeed: 0
					setLoop: 3
					setCycle: KQ5SyncWalk
				)
				((gEgo head:) show:)
				(PrintDC 92 14 #at 170 20 #width 130 #dispose) ; "Yes, I know who you are and I have been informed of your quest. I do wish you luck against the wizard Mordack."
				(= seconds 14)
			)
			(8
				(= local8 0)
				(smallHead hide:)
				(iceQueen cycleSpeed: 5 setCycle: End self)
			)
			(9
				(= cycles 10)
			)
			(10
				(iceQueen loop: 8 cel: 0 setCycle: End self)
			)
			(11
				(= cycles 10)
			)
			(12
				(cls)
				(cage loop: 3 cel: 0 cycleSpeed: 8 setCycle: End self)
			)
			(13
				(= cycles 10)
			)
			(14
				(= local8 1)
				(iceQueen loop: 5 cycleSpeed: 8 setCycle: RandCycle)
				(cage dispose:)
				(smallHead show:)
				(PrintDC 92 15 #at 170 20 #width 130 #dispose) ; "You two may go. We wish you well on your difficult journey. Sir Greywolf will show you the way out of the mountains."
				(= seconds 14)
			)
			(15
				(= local8 0)
				(wolf1 cycleSpeed: 3 setCycle: Beg self)
			)
			(16
				(smallHead hide:)
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
							(PrintDC 92 16) ; "Queen Icebella has no interest in that."
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
		x 164
		y 78
		view 852
		loop 1
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

(instance smallHead of Prop
	(properties
		x 138
		y 25
		view 848
		loop 4
		priority 14
		signal 16
		cycleSpeed 4
	)
)

