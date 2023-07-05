;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 206)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use RFeature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	bakeShop 0
)

(local
	[local0 3]
	local3
	local4
	local5
	local6
	local7
	[local8 36] = [0 0 319 0 319 189 176 189 176 170 226 170 207 141 261 141 244 119 144 119 144 112 107 112 95 126 127 126 102 170 146 170 146 189 0 189]
)

(procedure (localproc_0)
	(baker setScript: 0 loop: 3 cel: 0)
)

(instance bakeShop of KQ5Room
	(properties
		picture 924
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 226 224 1120)
		(HandsOff)
		(gGlobalSound vol: 0 stop:)
		(self
			setFeatures: kitchenDoor counterTop shop
			addObstacle: poly1
			setScript: walkInScript
		)
		(if (IsFlag 25)
			(++ local4)
		)
		(if (gEgo has: 2) ; Pie
			(++ local4)
		)
		(if (and (== ((gInventory at: 2) owner:) 206) (IsFlag 50)) ; Pie
			(pie init:)
		)
		(if (not (IsFlag 50))
			(woman init:)
			(boy init:)
			(arm init:)
			(pie init:)
			(baker cel: 7)
		)
		(smoke init:)
		(cedric init:)
		(baker init:)
		(brother init:)
		(if (> (gGame detailLevel:) 1)
			(cat setScript: catScript init:)
			(tail init: cycleSpeed: 2 setCycle: Fwd)
		else
			(cat signal: 1 init:)
			(tail signal: 1 init:)
		)
		(gEgo view: 0 setStep: 3 2 posn: 168 200 setPri: -1 init:)
		(poly1 points: @local8 size: 18)
	)

	(method (doit &tmp temp0)
		(if (and (!= local4 3) (== ((gInventory at: 2) owner:) 1)) ; Pie
			(= local4 3)
		)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl: 0) $4000)
				(HandsOff)
				(gCurRoom setScript: walkOutScript)
			)
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
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(SetFlag 50)
		(gGlobalSound fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance doWinners of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if
			(and
				(OneOf state 1 2 5 9 10 13 15)
				(not (User canInput:))
				(not (User controls:))
			)
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
				(= cycles 3)
			)
			(1
				(PrintDC 206 0 #at 8 62 #width 160 #dispose) ; "And how is your poor dear mother doing, William?"
				(= seconds 7)
			)
			(2
				(cls)
				(bakerMouth init: setCycle: RandCycle)
				(PrintDC 206 1 #at 8 8 #width 160 #dispose) ; "She hasn't been doing too well lately, but my brother and I keep an eye on her. Thanks for asking, Amanda."
				(= seconds 10)
			)
			(3
				(bakerMouth z: 1000)
				(cls)
				(arm cycleSpeed: 7 setCycle: End self)
			)
			(4
				(woman view: 550 setLoop: 4 cycleSpeed: 2 setCycle: CT 1 1 self)
				(RedrawCast)
			)
			(5
				(PrintDC 206 2 #at 8 62 #width 160 #dispose) ; "Austin, don't touch that pie!"
				(= seconds 5)
			)
			(6
				(cls)
				(arm cel: 0)
				(= cycles 1)
			)
			(7
				(arm dispose:)
				(boy loop: 5 cycleSpeed: 2 setCycle: End self)
				(woman setCycle: Beg)
			)
			(8
				(= seconds 1)
			)
			(9
				(PrintDC 206 3 #at 8 62 #width 160 #dispose) ; "The pies look delicious. I think I'll take one."
				(= seconds 7)
			)
			(10
				(bakerMouth z: 0)
				(PrintDC 206 4 #at 8 8 #width 160 #dispose) ; "Yes, they were just made fresh this morning. Here you go."
				(= seconds 9)
			)
			(11
				(bakerMouth dispose:)
				(cls)
				(pie hide:)
				(baker loop: 3 cel: 6)
				(= cycles 15)
			)
			(12
				(woman view: 1120 loop: 1 cel: 1)
				(= cycles 15)
			)
			(13
				(baker view: 226 loop: 3 cel: 7)
				(PrintDC 206 5 #at 8 62 #width 160 #dispose) ; "Yes, this will be a fine dessert for our dinner tonight."
				(= seconds 7)
			)
			(14
				(cls)
				(woman setCycle: End self)
			)
			(15
				(PrintDC 206 6 #at 8 62 #width 160 #dispose) ; "Let's go home, Austin."
				(= seconds 5)
			)
			(16
				(cls)
				(woman view: 550 loop: 3 cel: 0 setCycle: End self)
			)
			(17
				(gTheIconBar enable:)
				(gTheIconBar disable: 0)
				(User canInput: 1)
				(gGame setCursor: gTheCrownCursor)
				(= cycles 1)
			)
			(18
				(boy
					setLoop: 0
					cycleSpeed: 4
					moveSpeed: 4
					setCycle: Fwd
					setMotion: PolyPath 168 200
				)
				(= seconds 1)
			)
			(19
				(woman
					view: 1120
					setLoop: 0
					cycleSpeed: 4
					moveSpeed: 4
					setCycle: Fwd
					setMotion: PolyPath 224 128 self
				)
			)
			(20
				(woman setMotion: PolyPath 168 200 self)
			)
			(21
				(boy dispose:)
				(woman dispose:)
				(gCurRoom setScript: greet)
			)
		)
	)
)

(instance walkInScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(gGlobalSound number: 61 loop: -1 playBed:)
				(gEgo setMotion: MoveTo 168 148 self)
			)
			(2
				(if (not (IsFlag 50))
					(gCurRoom setScript: doWinners)
				else
					(if (> (gGame detailLevel:) 1)
						(brother setScript: brotherScript)
					else
						(brother stopUpd:)
					)
					(gCurRoom setScript: greetAgain)
				)
			)
		)
	)
)

(instance walkOutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 168 200 self)
			)
			(1
				(gCurRoom newRoom: 6)
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
				(= cycles 10)
			)
			(1
				(brother cycleSpeed: 2 setCycle: Beg self)
			)
			(2
				(brother loop: 12 setCycle: CT 2 1 self)
			)
			(3
				(baker view: 226 loop: 3 cel: 0)
				(theMouth init: setCycle: RandCycle)
				(PrintDC 206 7 #at 150 20 #dispose) ; "Here's the last of the pies."
				(= seconds 4)
			)
			(4
				(cls)
				(brother setCycle: End)
				(baker setCycle: End self)
				(theMouth dispose:)
			)
			(5
				(pie show:)
				(= cycles 20)
			)
			(6
				(proc0_28 191 206 8 67 15 8 70 160 25 10) ; "Welcome to our bakehouse, traveler! Of course ALL of our wares are wonderful, but today we've got a special on custard pies."
				(= cycles 1)
			)
			(7
				(if (> (gGame detailLevel:) 1)
					(brother setScript: brotherScript)
				else
					(brother stopUpd:)
				)
				(proc0_28 191 206 9 67 15 8 70 160 25 9) ; "Just one silver coin each. But take your time...let me know when you're ready."
				(= cycles 1)
			)
			(8
				(gTheIconBar enable: 0)
				(if (== (gGame detailLevel:) 3)
					(baker setScript: bakerScript)
				else
					(baker stopUpd:)
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance greetAgain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baker view: 225 loop: 0 setCycle: End self)
			)
			(1
				(cond
					((== ((gInventory at: 2) owner:) 206) ; Pie
						(proc0_28 191 206 10 67 15 8 70 160 25 11) ; "Welcome back to our bakehouse, traveler! Of course ALL of our wares are wonderful, but don't forget our special on custard pies."
					)
					((== ((gInventory at: 2) owner:) gEgo) ; Pie
						(proc0_28 191 206 11 67 15 8 70 160 25 8) ; "Welcome back to our bakehouse! I hope you enjoy our custard pie."
					)
					(else
						(proc0_28 191 206 12 67 15 8 70 160 25 8) ; "Welcome back to our bakehouse! I hope you enjoyed our custard pie."
					)
				)
				(= cycles 1)
			)
			(2
				(if (== ((gInventory at: 2) owner:) 206) ; Pie
					(greet start: 7)
					(gCurRoom setScript: greet)
				else
					(if (== (gGame detailLevel:) 3)
						(baker setScript: bakerScript)
					else
						(baker stopUpd:)
					)
					(HandsOn)
					(client setScript: 0)
				)
			)
		)
	)
)

(instance doPie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 198 120 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 226 loop: 4 cel: 0 setCycle: CT 3 1)
				(= seconds 2)
			)
			(2
				(localproc_0)
				(= cycles 1)
			)
			(3
				(proc0_28 191 206 13 67 15 8 70 160 25 6) ; "Would you like a pie, sir?"
				(= cycles 1)
			)
			(4
				(gEgo setCycle: End)
				(proc0_28 160 206 14 67 15 112 70 160 25 6) ; "Well...yes, actually. I would."
				(= cycles 1)
			)
			(5
				(proc0_28 191 206 15 67 15 8 70 160 25 6) ; "That'll be one silver coin then."
				(= cycles 1)
			)
			(6
				(proc0_28 160 206 16 67 15 105 70 160 25 6) ; "Let me see if I have one."
				(= cycles 1)
			)
			(7
				(gEgo
					view: 0
					setLoop: 0
					setMotion: 0
					setCycle: KQ5SyncWalk
					normal: 1
				)
				((gEgo head:) show:)
				(gEgo setLoop: -1)
				(proc0_28 191 206 17 67 15 8 70 160 25 6) ; "Well, let me know if you do."
				(= cycles 1)
			)
			(8
				(if (== (gGame detailLevel:) 3)
					(baker setScript: bakerScript)
				else
					(baker stopUpd:)
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance talkBakerScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0
					(GetAngle (gEgo x:) (gEgo y:) (baker x:) (baker y:))
				)
				(gEgo
					cel:
						(cond
							((< temp0 45) 3)
							((< temp0 135) 0)
							((< temp0 225) 2)
							((< temp0 315) 1)
							(else 3)
						)
				)
				(proc0_28 160 206 18 67 15 106 70 160 25 7) ; "Everything looks so delicious. It's hard to decide what to buy."
				(localproc_0)
				(= cycles 1)
			)
			(1
				(proc0_28 191 206 19 67 15 8 70 160 25 7) ; "(Laughing) Everybody has that problem! But what a problem to have!"
				(= cycles 1)
			)
			(2
				(proc0_28 160 206 20 67 15 106 70 160 25 5) ; "Those custard pies look awfully good."
				(= cycles 1)
			)
			(3
				(proc0_28 191 206 21 67 15 8 70 160 25 8) ; "Yes. Made from a recipe handed down from our dear Mama...and her Mama before her."
				(= cycles 1)
			)
			(4
				(proc0_28 160 206 22 67 15 106 70 160 25 5) ; "Hmmmmm. It's still hard to decide, though."
				(= cycles 1)
			)
			(5
				(proc0_28 191 206 23 67 15 8 70 160 25 5) ; "Well, take your time. There's no hurry."
				(= cycles 1)
			)
			(6
				(if (== (gGame detailLevel:) 3)
					(baker setScript: bakerScript)
				else
					(baker stopUpd:)
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance getPie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetScore 2)
				(switch local7
					(0
						(gEgo put: 4 206) ; Coin
					)
					(3
						(gEgo put: 11 206) ; Gold_Coin
					)
					(1
						(gEgo put: 3 206) ; Golden_Needle
					)
					(2
						(gEgo put: 9 206) ; Heart
					)
				)
				(HandsOff)
				(gEgo setMotion: PolyPath 198 120 self)
			)
			(1
				(proc0_7 gEgo baker)
				(= cycles 2)
			)
			(2
				(proc0_28 160 206 24 67 15 106 70 160 25 6) ; "Oh, sir! I would like to buy a pie!"
				(localproc_0)
				(= cycles 1)
			)
			(3
				(proc0_28 191 206 25 67 15 8 70 160 25 6) ; "The pies cost one silver coin each."
				(= cycles 1)
			)
			(4
				(switch local7
					(0
						(proc0_28 160 206 26 67 15 106 70 160 25 6) ; "I've got it right here. Here you go."
					)
					(3
						(proc0_28 160 206 27 67 15 106 70 160 25 5) ; "Will a gold coin do?"
					)
					(1
						(proc0_28 160 206 28 67 15 106 70 160 25 5) ; "Will a gold needle do?"
					)
					(2
						(proc0_28 160 206 29 67 15 106 70 160 25 5) ; "Will a golden heart do?"
					)
				)
				(= cycles 1)
			)
			(5
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 226
					loop: 4
					cel: 0
					setCycle: CT 3 1 self
				)
				(gEgo get: 2) ; Pie
				(= local4 2)
				(SetFlag 25)
			)
			(6
				(switch local7
					(0
						(proc0_28 191 206 30 67 15 8 70 160 25 6) ; "I hope you enjoy your custard pie."
					)
					(else
						(proc0_28 191 206 31 67 15 8 70 160 25 4) ; "Sure!"
					)
				)
				(= cycles 1)
			)
			(7
				(gEgo setCycle: End)
				(switch local7
					(0
						(proc0_28 160 206 32 67 15 106 70 160 25 6) ; "Oh, I'm sure I will!"
					)
					(else
						(proc0_28 160 206 33 67 15 8 70 160 25 5) ; "Okay. Here you go."
					)
				)
				(pie dispose:)
				(= cycles 1)
			)
			(8
				(gEgo
					view: 0
					setLoop: 0
					setMotion: 0
					setCycle: KQ5SyncWalk
					normal: 1
				)
				((gEgo head:) show:)
				(gEgo setLoop: -1)
				(if (== (gGame detailLevel:) 3)
					(baker setScript: bakerScript)
				else
					(baker stopUpd:)
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance bakerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baker view: 225 loop: 3 cel: 0 setCycle: End)
				(= cycles (Random 80 140))
			)
			(1
				(baker setCycle: CT 1 -1)
				(= cycles 6)
			)
			(2
				(baker setCycle: End self)
				(= cycles (Random 50 100))
			)
			(3
				(baker setCycle: Beg)
				(= cycles (Random 60 120))
			)
			(4
				(baker loop: 4 cel: 0 setCycle: CT 6 1)
				(= cycles 12)
			)
			(5
				(if (Random 0 1)
					(baker setCycle: CT 3 -1 self)
				else
					(baker setCycle: End self)
				)
			)
			(6
				(baker setCycle: End)
				(= cycles (Random 60 120))
			)
			(7
				(baker loop: 1 setCycle: Fwd)
				(= cycles (Random 40 60))
			)
			(8
				(if (gCurRoom script:)
					(= cycles 1)
				else
					(baker loop: 0 cel: 7 setCycle: Beg self)
				)
			)
			(9
				(baker setCycle: End self)
			)
			(10
				(baker view: 225 loop: 3 cel: 0 setCycle: End)
				(= cycles (Random 80 140))
			)
			(11
				(baker setCycle: CT 1 -1)
				(= cycles (Random 50 100))
			)
			(12
				(baker setCycle: End)
				(= cycles (Random 80 140))
			)
			(13
				(baker setCycle: Beg)
				(= cycles (Random 80 140))
			)
			(14
				(if (gCurRoom script:)
					(self init:)
				else
					(baker loop: 2 setCycle: CT 3 1)
					(= cycles 50)
				)
			)
			(15
				(baker setCycle: End self)
			)
			(16
				(self init:)
			)
		)
	)
)

(instance catScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (Random 1 1000) 100)
					(= state 2)
				)
				(= cycles (Random 5 12))
			)
			(1
				(cat loop: 6 setCycle: End self)
			)
			(2
				(cat loop: 6 setCycle: Beg self)
				(= state -1)
			)
			(3
				(tail hide:)
				(cat loop: (+ 2 register) cel: 0 setCycle: CT 4 1 self)
			)
			(4
				(cat
					cycleSpeed: 1
					setCycle: Walk
					xStep: 1
					setMotion:
						MoveTo
						(if register
							(- (cat x:) 20)
						else
							(+ (cat x:) 20)
						)
						(cat y:)
						self
				)
			)
			(5
				(cat
					loop: (+ 4 register)
					cel: 0
					cycleSpeed: 2
					setCycle: CT 5 1 self
				)
			)
			(6
				(if (Random 0 1)
					(cat cel: 1)
				)
				(cat setCycle: End self)
			)
			(7
				(tail show: setCycle: Fwd)
				(= cycles (Random 200 400))
			)
			(8
				(= register (not register))
				(self init:)
			)
		)
	)
)

(instance brotherScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(brother
					setLoop: (brother loop:)
					setCel: (brother cel:)
					setMotion: MoveTo 221 80 self
				)
			)
			(1
				(brother
					setCel: -1
					cel: 0
					setLoop: -1
					loop: 7
					setCycle: End self
				)
			)
			(2
				(brother loop: 9 cel: 0 cycleSpeed: 3 setCycle: End)
				(= seconds (Random 1 3))
				(if (< (Random 1 100) 50)
					(-- state)
				)
			)
			(3
				(brother loop: 7 cel: 6 cycleSpeed: 2 setCycle: Beg self)
			)
			(4
				(brother loop: 8 cel: 2 cycleSpeed: 3 setCycle: Beg self)
			)
			(5
				(brother loop: 11 cycleSpeed: 2 setCycle: Fwd)
				(= cycles (Random 80 200))
			)
			(6
				(brother loop: 8 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(7
				(if (Random 0 1)
					(brother
						setLoop: 14
						setCycle: Fwd
						setMotion:
							MoveTo
							(if (Random 0 1)
								(- (brother x:) 140)
							else
								167
							)
							(brother y:)
							self
					)
				else
					(self init:)
				)
			)
			(8
				(= cycles (Random 10 40))
			)
			(9
				(brother setLoop: 13 setMotion: MoveTo 221 (brother y:) self)
			)
			(10
				(brother setLoop: -1)
				(if (Random 0 1)
					(self start: 4)
				else
					(self start: 0)
				)
				(self init:)
			)
		)
	)
)

(instance boyTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cls)
				(proc0_28 160 206 34 67 15 106 70 160 25 3) ; "What's your name?"
				(= cycles 1)
			)
			(1
				(cls)
				(proc0_28 920 206 35 67 15 8 70 160 25 10) ; "My name's Austin. I'm here with my mama. We're buying a pie."
				(= cycles 1)
			)
			(2
				(cls)
				(proc0_28 160 206 36 67 15 106 70 160 25 3) ; "That's nice."
				(= cycles 1)
			)
			(3
				(User canInput: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance womanTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cls)
				(proc0_28 160 206 37 67 15 106 70 160 25 6) ; "Good day, madam. That pie looks awfully good."
				(= cycles 1)
			)
			(1
				(cls)
				(proc0_28 919 206 38 67 15 8 70 160 25 10) ; "Ah, yes. My family will enjoy it."
				(= cycles 1)
			)
			(2
				(User canInput: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance baker of Actor
	(properties
		x 206
		y 88
		view 226
		loop 3
		priority 7
		signal 16
		cycleSpeed 2
		illegalBits 0
	)

	(method (handleEvent event &tmp temp0)
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
					(PrintDC 206 39) ; "The baker, a large, sturdy fellow, waits for customers behind a pie-covered counter."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 206 40) ; "The baker bides his time behind the counter while Graham looks hungrily at all the delicious wares."
					(event claimed: 1)
				)
				(5 ; Talk
					(if (not (gCurRoom script:))
						(switch local4
							(0
								(++ local4)
								(HandsOff)
								(gCurRoom setScript: talkBakerScript)
								(event claimed: 1)
							)
							(1
								(SetFlag 25)
								(PrintDC 206 41) ; "Graham waits to further bother the baker until a decision for purchase has been made."
								(event claimed: 1)
							)
							(2
								(proc0_28 191 206 42 67 15 8 70 160 25 6) ; "I hope you enjoy your custard pie."
								(proc0_28 160 206 43 67 15 106 70 160 25 6) ; "It looks delicious! I'm sure I will."
								(event claimed: 1)
							)
							(3
								(SetFlag 25)
								(PrintDC 206 44) ; "Graham has already eaten a pie and is not interested in anymore pies."
								(event claimed: 1)
							)
						)
					)
				)
				(4 ; Inventory
					(cond
						((== (gInventory indexOf: (gTheIconBar curInvIcon:)) 28)
							(event claimed: 0)
						)
						((not (gCurRoom script:))
							(cond
								((== ((gInventory at: 2) owner:) 206) ; Pie
									(switch
										(gInventory
											indexOf: (gTheIconBar curInvIcon:)
										)
										(4
											(event claimed: 1)
											(= local7 0)
											(gCurRoom setScript: getPie)
										)
										(11
											(event claimed: 1)
											(= local7 3)
											(gCurRoom setScript: getPie)
										)
										(3
											(event claimed: 1)
											(= local7 1)
											(gCurRoom setScript: getPie)
										)
										(9
											(event claimed: 1)
											(= local7 2)
											(gCurRoom setScript: getPie)
										)
										(else
											(PrintDC 206 45) ; "The baker wouldn't be interested in that."
											(event claimed: 1)
										)
									)
								)
								((== ((gInventory at: 2) owner:) gEgo) ; Pie
									(PrintDC 206 46) ; "Graham already has a pie and is not interested in any other baked goods."
									(event claimed: 1)
								)
								(else
									(PrintDC 206 47) ; "Graham has already eaten a pie and is not interested in anymore pies."
									(event claimed: 1)
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance theMouth of Prop
	(properties
		x 220
		y 61
		view 225
		loop 5
		priority 15
		signal 16400
		cycleSpeed 2
	)
)

(instance bakerMouth of Prop
	(properties
		x 207
		y 70
		view 225
		loop 6
		priority 15
		signal 16400
		cycleSpeed 2
	)
)

(instance brother of Actor
	(properties
		x 221
		y 80
		view 224
		loop 8
		cel 2
		signal 16384
		cycleSpeed 3
		illegalBits 0
		xStep 2
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
				(& (OnControl CONTROL (event x:) (event y:)) $0004)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 206 48) ; "In the kitchen of the bakehouse, Graham can see another big, burly man doing the day's baking."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 206 49) ; "The kitchen is off-limits to customers. Besides, Graham would only be in the way."
					(event claimed: 1)
				)
				(5 ; Talk
					(PrintDC 206 50) ; "The baker's brother is too busy to chat with Graham."
					(event claimed: 1)
				)
				(4 ; Inventory
					(if (== (gInventory indexOf: (gTheIconBar curInvIcon:)) 28)
						(event claimed: 0)
					else
						(PrintDC 206 51) ; "The man in the kitchen is doing the baking and NOT tending to customers."
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance tail of Prop
	(properties
		x 126
		y 107
		view 224
		loop 15
		signal 16384
		cycleSpeed 2
	)

	(method (doit)
		(super doit:)
		(switch (cat loop:)
			(4
				(self x: (- (cat x:) 7))
			)
			(5
				(self x: (+ (cat x:) 6))
			)
			(6
				(self x: (cat x:))
			)
		)
	)
)

(instance cat of Actor
	(properties
		x 126
		y 107
		view 224
		loop 6
		cycleSpeed 2
		detailLevel 3
		xStep 1
		moveSpeed 1
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
					(PrintDC 206 52) ; "The Baker brothers seem to have a pet; a large, mangy cat."
					(event claimed: 1)
				)
				(5 ; Talk
					(PrintDC 206 53) ; "The cat doesn't appear to like Graham, much less answer him."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 206 54) ; "The cat doesn't look too friendly."
					(event claimed: 1)
				)
				(4 ; Inventory
					(if (== (gInventory indexOf: (gTheIconBar curInvIcon:)) 28)
						(event claimed: 0)
					else
						(PrintDC 206 55) ; "The cat is too lazy to care about it."
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance pie of Prop
	(properties
		x 206
		y 93
		view 224
		loop 10
		cel 1
		priority 8
		signal 17
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
					(PrintDC 206 56) ; "Delicious, mouthwatering custard pies lining the countertop attract Graham's eyes...and nose!"
					(event claimed: 1)
				)
				(3 ; Do
					(if (not (gCurRoom script:))
						(cond
							(
								(and
									(not local3)
									(== ((gInventory at: 2) owner:) 206) ; Pie
								)
								(++ local3)
								(HandsOff)
								(gCurRoom setScript: doPie)
								(event claimed: 1)
							)
							((gEgo has: 2) ; Pie
								(PrintDC 206 57) ; "Graham doesn't need another pie."
								(event claimed: 1)
							)
							(else
								(PrintDC 206 58) ; "Graham would love to buy a pie if he could."
								(event claimed: 1)
							)
						)
					)
				)
			)
		)
	)
)

(instance kitchenDoor of RFeature
	(properties
		nsTop 53
		nsLeft 122
		nsBottom 104
		nsRight 155
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
					(PrintDC 206 59) ; "Graham can see the bakehouse kitchen through the partially-open Dutch door."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 206 60) ; "Only employees are allowed in the kitchen."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance shop of RFeature
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
					(PrintDC 206 61) ; "Mmmmmmm. The wonderful smells of the bakehouse set Graham's stomach to rumbling and his mouth to watering."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance counterTop of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 206 62) ; "Delicious, mouthwatering custard pies lining the countertop attract Graham's eyes...and nose!"
					(event claimed: 1)
				)
				(3 ; Do
					(if (not (gCurRoom script:))
						(cond
							(
								(and
									(not local3)
									(== ((gInventory at: 2) owner:) 206) ; Pie
								)
								(++ local3)
								(HandsOff)
								(gCurRoom setScript: doPie)
								(event claimed: 1)
							)
							((gEgo has: 2) ; Pie
								(PrintDC 206 57) ; "Graham doesn't need another pie."
								(event claimed: 1)
							)
							(else
								(PrintDC 206 58) ; "Graham would love to buy a pie if he could."
								(event claimed: 1)
							)
						)
					)
				)
			)
		)
	)
)

(instance smoke of Prop
	(properties
		x 146
		y 5
		view 221
		loop 7
		cycleSpeed 5
	)
)

(instance boy of Actor
	(properties
		x 215
		y 120
		view 550
		loop 6
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
					(PrintDC 206 63) ; "The little boy looks all dressed up for a special occasion."
					(event claimed: 1)
				)
				(5 ; Talk
					(event claimed: 1)
					(if (or local6 (> (boy y:) (+ (gEgo y:) 25)))
						(PrintDC 206 64) ; "He appears in too much of a hurry to talk to Graham."
					else
						(++ local6)
						(User canInput: 0)
						(boy setScript: boyTalk)
					)
				)
			)
		)
	)
)

(instance woman of Actor
	(properties
		x 214
		y 118
		view 550
		loop 4
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
					(PrintDC 206 65) ; "This lady looks like she's in a real hurry."
					(event claimed: 1)
				)
				(5 ; Talk
					(event claimed: 1)
					(if (or local5 (> (woman y:) (+ (gEgo y:) 25)))
						(PrintDC 206 66) ; "She appears in too much of a hurry to talk to Graham."
					else
						(++ local5)
						(User canInput: 0)
						(woman setScript: womanTalk)
					)
				)
			)
		)
	)
)

(instance arm of Actor
	(properties
		x 226
		y 99
		view 550
		loop 7
		priority 8
		signal 16
	)
)

(instance cedric of View
	(properties
		x 46
		y 121
		view 225
		loop 7
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

