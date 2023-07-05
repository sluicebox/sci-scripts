;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use Interface)
(use Count)
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
)

(instance witchRegion of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (== gCurRoomNum 22)
			(proc0_24 128 447 446 454 440 442)
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
						(and (IsFlag 19) (!= ((gInventory at: 6) owner:) 200)) ; Brass_Bottle
						(and (not (IsFlag 19)) (< (Random 1 1000) 500))
					)
				)
			)
			(witch view: (+ 440 local0) init:)
			(SetFlag 91)
		)
		(cond
			((== gCurRoomNum 22)
				(gGlobalSound number: 41 loop: -1 vol: 127 playBed:)
			)
			((IsFlag 91)
				(if (!= (gGlobalSound number:) 20)
					(gGlobalSound number: 20 loop: -1 vol: 127 playBed:)
				)
			)
			(
				(and
					(== gCurRoomNum 24)
					(== ((gInventory at: 6) owner:) 200) ; Brass_Bottle
					(not (IsFlag 57))
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
		(ClearFlag 91)
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
				(PrintDC 200 0 #at 62 15 #time 15) ; "Good! That old witch won't be seen here for a LONG time! But now, how to get out of this dreadful forest?"
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
				(if (IsFlag 91)
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
				(if (IsFlag 91)
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
				(SetFlag 19)
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
				(if (and (gEgo has: 27) (IsFlag 85)) ; Amulet
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
				(= global330
					{That old witch caught Graham "toadily" off guard. Ribbitt!}
				)
				(EgoDead 249)
			)
			(7
				(fireball dispose:)
				(= cycles 1)
			)
			(8
				(PrintDC 200 1) ; "To Graham's great relief, it appears that the witch's magic has been stopped by the amulet he is wearing, just as Madame Mushka claimed it would."
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
				(Say 77 200 2 67 142 8 70 160 25 7) ; "What are you doing in my forest, young man! Don't you know you're trespassing?"
				(= cycles 1)
			)
			(1
				(Say 160 200 3 67 8 8 70 160 25 6) ; "Oh, I didn't know this was a PRIVATE forest. Do you own it?"
				(= cycles 1)
			)
			(2
				(Say 77 200 4 67 142 8 70 160 25 8) ; "Of COURSE I own it! It's mine! And what did you do to my magic?!"
				(= cycles 1)
			)
			(3
				(Say 160 200 5 67 8 8 25 8 70 160) ; "I don't think you need to know. Now tell me something...how does one leave this terrible forest?"
				(= cycles 1)
			)
			(4
				(Say 77 200 6 67 142 8 25 7 70 160) ; "I'LL never tell. I'm afraid you're stuck, dearie. Now you're my prisoner."
				(= cycles 1)
			)
			(5
				(Say 160 200 7 67 8 8 25 5 70 160) ; "We'll see about that!"
				(= cycles 1)
			)
			(6
				(Say 77 200 8 67 142 8 25 4 70 160) ; "Yes, won't we."
				(= cycles 1)
			)
			(7
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
				(gEgo put: 6 200) ; Brass_Bottle
				(SetScore 4)
				(Say 77 200 9 25 4 67 142 8 70 160) ; "What's this?"
				(gCurRoom newRoom: 208) ; releaseGenie
			)
		)
	)
)

(instance fireball of Act
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

(instance witch of Act
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
					(Max
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
				(Say 77 200 10 25 6 67 142 8 70 160) ; "You're not crossing my bridge, little man!"
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
		(if (IsFlag 19)
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
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (== gCurRoomNum 22)
						(PrintDC 200 11) ; "Though she may look like an ancient old woman, this witch is really very powerful... and much too strong to be shoved aside by a mere man as she staunchly defends her bridge."
					else
						(PrintDC 200 12) ; "Of all the ugly hags Graham has seen in his life, THIS is by far the ugliest!"
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (and (gEgo has: 27) (IsFlag 19)) ; Amulet
						(PrintDC 200 13) ; "Even though the old witch is now powerless to inflict her evil magic on Graham, Graham also finds himself powerless to do anything about her!"
					)
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(6 ; Brass_Bottle
							(event claimed: 1)
							(HandsOff)
							(self setScript: killTheBitch)
						)
						(28 ; Wand
							(event claimed: 0)
						)
						(27 ; Amulet
							(event claimed: 1)
							(PrintDC 200 14) ; "The amulet is already working its magic on the witch."
						)
						(else
							(Say 77 200 15 25 9 67 142 8 70 160) ; "Don't try to bribe me with THAT, dearie!  I'm not DUMB, ya know!"
							(event claimed: 1)
						)
					)
				)
				(4 ; Talk
					(if (IsFlag 20)
						(PrintDC 200 16) ; "The ugly old hag mumbles and mutters to herself but refuses to indulge in any further conversation with Graham."
						(event claimed: 1)
					else
						(SetFlag 20)
						(HandsOff)
						(self setScript: talkToWitch)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance bottle of View
	(properties
		signal 4
	)
)

