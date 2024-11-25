;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 401)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Interface)
(use RaseirGuard)
(use PolyPath)
(use Polygon)
(use Save)
(use Motion)
(use Actor)
(use System)

(public
	rasGuard 0
	secondDown 1
	eunuchDie 2
	theDaz 3
	eunuchBust 4
	centerMe 5
	eunuchPace 6
	doorPicker 7
	doorBuster 8
	backToInn 9
	MakeGuardPoly 10
)

(local
	sayWhaa
	[guard1Pts 8]
	[guard2Pts 8]
)

(procedure (MakeGuardPoly theGuard &tmp rL rT rR rB theObj theList)
	(= theObj theGuard)
	(BaseSetter theGuard)
	(= rL (- (theObj brLeft:) 10))
	(= rT (- (theObj brTop:) 10))
	(= rR (+ (theObj brRight:) 10))
	(= rB (+ (theObj brBottom:) 5))
	(= theList (gCurRoom obstacles:))
	(if (or (== theGuard (ScriptID 400 4)) (== theGuard firstGuy)) ; rGuard1
		(= [guard1Pts 0] (= [guard1Pts 6] rL))
		(= [guard1Pts 1] (= [guard1Pts 3] rT))
		(= [guard1Pts 2] (= [guard1Pts 4] rR))
		(= [guard1Pts 5] (= [guard1Pts 7] rB))
		(guardPoly1 points: @guard1Pts size: 4)
		(if (or (not theList) (not (theList contains: guardPoly1)))
			(gCurRoom addObstacle: guardPoly1)
		)
	else
		(= [guard2Pts 0] (= [guard2Pts 6] rL))
		(= [guard2Pts 1] (= [guard2Pts 3] rT))
		(= [guard2Pts 2] (= [guard2Pts 4] rR))
		(= [guard2Pts 5] (= [guard2Pts 7] rB))
		(guardPoly2 points: @guard2Pts size: 4)
		(if (or (not theList) (not (theList contains: guardPoly2)))
			(gCurRoom addObstacle: guardPoly2)
		)
	)
)

(procedure (eunuchPrint)
	(HighPrint &rest 80 {Eunuch:} 35 eWin)
)

(instance eWin of SysWindow
	(properties
		back 13
	)
)

(instance firstGuy of Actor
	(properties
		x 183
		y 153
		noun '/guard'
		description {the dead guard}
		lookStr {Yep, you killed him!}
		view 381
		loop 9
		signal 16384
		illegalBits 0
	)
)

(instance guyTwo of Actor
	(properties
		noun '/guard<other'
		description {the other dead guard}
		lookStr {It's a dead guard lying on the ground, bleeding all over the place while you just stare.}
		signal 16384
	)
)

(instance rasGuard of RaseirGuard
	(properties)

	(method (initCombat)
		(= deathScript secondDown)
		(super initCombat: &rest)
	)

	(method (die)
		(switch gRasGuardLeft
			(0
				(if (gCast contains: (ScriptID 400 2)) ; eunuch
					((ScriptID 400 2) setScript: (ScriptID 400 3)) ; eunuch, holler
				)
				(if (gCast contains: (ScriptID 400 4)) ; rGuard1
					((ScriptID 400 4) dispose:) ; rGuard1
				)
				(if (gCast contains: (ScriptID 400 5)) ; rGuard2
					((ScriptID 400 5) dispose:) ; rGuard2
				)
				(super die:)
				(return)
			)
			(1
				(firstGuy init: setScript: firstDown)
				(self hide:)
				(gCurRoom setScript: (ScriptID 400 1)) ; fightScript
			)
		)
		(-- gRasGuardLeft)
		(= health (self calcHealth:))
		(= stamina (self calcStamina:))
		(self setHealth: health)
		(self setStamina: stamina)
	)
)

(instance firstDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(firstGuy setCycle: End self)
			)
			(1
				(firstGuy loop: 2 cel: 1 posn: 198 162)
				(= cycles 2)
			)
			(2
				(firstGuy cel: 2 posn: 203 169)
				(= cycles 2)
			)
			(3
				(firstGuy cel: 3 posn: 201 182)
				(= cycles 2)
			)
			(4
				(MakeGuardPoly firstGuy)
				(firstGuy ignoreActors: 0)
				(self dispose:)
			)
		)
	)
)

(instance secondDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(guyTwo
					view: 381
					loop: 2
					cel: 0
					illegalBits: 0
					posn: 183 153
					init:
				)
				(rasGuard hide:)
				((ScriptID 32 0) hide:) ; warrior
				(gEgo
					view:
						(if (or (gEgo has: 4) (gEgo has: 24)) 83 else 84) ; Sword, FineSword
					loop: 0
					cel: 6
					posn: 145 159
					show:
					illegalBits: $8000
					cycleSpeed: 2
					setCycle: Beg
				)
				(= cycles 4)
			)
			(1
				(guyTwo cel: 1 posn: 173 162)
				(= cycles 1)
			)
			(2
				(guyTwo setCycle: End)
				(= seconds 2)
			)
			(3
				(HandsOn)
				(guyTwo setPri: 12 ignoreActors: 0)
				(rasGuard dispose:)
				((ScriptID 32 0) dispose:) ; warrior
				(MakeGuardPoly guyTwo)
				(NormalEgo)
				(gEgo loop: 6)
				(= cycles 3)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance eunuchDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 400 2) setMotion: 0) ; eunuch
				(if (== ((ScriptID 400 2) loop:) 0) ; eunuch
					((ScriptID 400 2) setLoop: 1) ; eunuch
					(= seconds 1)
				else
					(self cue:)
				)
			)
			(1
				((ScriptID 400 2) ; eunuch
					view: 533
					setLoop: 1
					cel: 0
					posn:
						(- ((ScriptID 400 2) x:) 11) ; eunuch
						(- ((ScriptID 400 2) y:) 15) ; eunuch
				)
				(= cycles 2)
			)
			(2
				((ScriptID 400 2) ; eunuch
					posn:
						(- ((ScriptID 400 2) x:) 7) ; eunuch
						(+ ((ScriptID 400 2) y:) 5) ; eunuch
				)
				(= cycles 2)
			)
			(3
				((ScriptID 400 2) ; eunuch
					posn:
						(- ((ScriptID 400 2) x:) 9) ; eunuch
						(+ ((ScriptID 400 2) y:) 7) ; eunuch
				)
				(= cycles 3)
			)
			(4
				((ScriptID 400 2) dispose:) ; eunuch
				(self dispose:)
			)
		)
	)
)

(instance theDaz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 400 4) illegalBits: 0 setLoop: 8) ; rGuard1
				(if (gCast contains: (ScriptID 400 5)) ; rGuard2
					((ScriptID 400 5) illegalBits: 0 setLoop: 7) ; rGuard2
				)
				(= cycles 3)
			)
			(1
				(HighPrint 401 0 80 {Guard:} 25 4 103) ; "My eyes! My eyes! I can't see!"
				(= cycles 2)
			)
			(2
				(= seconds 4)
			)
			(3
				(switch sayWhaa
					(0
						(= sayWhaa 0)
						(HighPrint 401 1 80 {Other Guard:} 25 6 103) ; "No, MY eyes! MY eyes are blinded!"
					)
					(1
						(HighPrint 401 2 80 {Other Guard:} 25 6 103) ; "I should think I would know if I were blind!"
					)
					(2
						(HighPrint 401 3 80 {Other Guard:} 25 6 103) ; "If I put your eyes out, you'll think blind!"
					)
					(3
						(HighPrint 401 4 80 {Other Guard:} 25 6 103) ; "Why, I oughta....!"
					)
				)
				(= seconds 4)
			)
			(4
				(switch sayWhaa
					(0
						(HighPrint 401 5 80 {First Guard:} 25 6 103) ; "Oh, no you don't. MY eyes!"
					)
					(1
						(HighPrint 401 6 80 {First Guard:} 25 6 103) ; "I'm tellin' ya, I can't see!"
					)
					(2
						(HighPrint 401 7 80 {First Guard:} 25 6 103) ; "I'm not gonna say it again. I'm blinded!"
					)
					(3
						(HighPrint 401 8 80 {First Guard:} 25 6 103) ; "I would if I could see ya!!"
					)
				)
				(if (== sayWhaa 3)
					(= sayWhaa 0)
				else
					(++ sayWhaa)
				)
				(self changeState: 2)
			)
		)
	)
)

(instance eunuchBust of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0 setCycle: 0)
				(cond
					((> ((ScriptID 400 2) x:) 313) ; eunuch
						((ScriptID 400 2) ; eunuch
							view: 533
							loop: 0
							cel: 0
							posn: 292 35
							mover: 0
							setCycle: End self
						)
					)
					((< ((ScriptID 400 2) x:) 19) ; eunuch
						((ScriptID 400 2) ; eunuch
							setMotion: MoveTo 30 ((ScriptID 400 2) y:) self ; eunuch
						)
					)
					(else
						(Face (ScriptID 400 2) gEgo) ; eunuch
						(= seconds 1)
					)
				)
			)
			(1
				(if (== ((ScriptID 400 2) view:) 533) ; eunuch
					((ScriptID 400 2) loop: 1 setCycle: Fwd) ; eunuch
				)
				(eunuchPrint 401 9 25 3 103 self) ; "Guards, To me!"
			)
			(2
				(Print 401 10 #title {The End}) ; "Timing is everything, and you chose the wrong time to get caught. You are being hauled back to the dungeon as time runs out."
				(= cycles 2)
			)
			(3
				(gCurRoom newRoom: 790)
				(self dispose:)
			)
		)
	)
)

(instance centerMe of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 400 2) ; eunuch
					setMotion: MoveTo 160 ((ScriptID 400 2) y:) self ; eunuch
				)
			)
			(1
				(Face (ScriptID 400 2) gEgo) ; eunuch
				(= cycles 1)
			)
			(2
				(eunuchPrint 401 11 103 25 3) ; "What is going on down there?"
				(self dispose:)
			)
		)
	)
)

(instance eunuchPace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 400 2) setCycle: Walk setMotion: MoveTo 360 58 self) ; eunuch
			)
			(1
				((ScriptID 400 2) loop: 1) ; eunuch
				(= seconds 2)
			)
			(2
				((ScriptID 400 2) setMotion: MoveTo 15 58 self) ; eunuch
			)
			(3
				((ScriptID 400 2) loop: 0) ; eunuch
				(= seconds 5)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance doorPicker of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((< (gEgo y:) 100)
						(LowPrint 401 12) ; "You have no need to pick locks up here, but you better get moving."
					)
					((<= (gEgo y:) 136)
						(gEgo setMotion: MoveTo (gEgo x:) 117 self)
					)
					((< (gEgo x:) 110)
						(gEgo setMotion: MoveTo 121 141 self)
					)
					((< (gEgo x:) 120)
						(gEgo setMotion: MoveTo 159 116 self)
					)
					(else
						(gEgo setMotion: MoveTo 198 141 self)
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo 169 116 self)
			)
			(2
				(gEgo view: 47 loop: 1 cel: 0 posn: 167 113)
				(= cycles 3)
			)
			(3
				(if (PickLock 100 1 1)
					(HighPrint 401 13) ; "The door is barred from the inside. You'll have to find another way into the Palace."
				)
				(gEgo view: 0 loop: 3)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance doorBuster of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo y:) 100)
					(LowPrint 401 14) ; "You have no need to bust down doors up here, but you better get moving."
				else
					(self cue:)
				)
			)
			(1
				(EgoGait 1 0) ; running
				(gEgo illegalBits: 0 setMotion: PolyPath 175 117 self)
			)
			(2
				(gEgo view: 576 setLoop: 0 cel: 0 setCycle: CT 5 1 self)
			)
			(3
				(if (TrySkill 0 100) ; strength
					((ScriptID 400 6) ignoreActors: 1 setCycle: End) ; leftDr
					((ScriptID 400 7) ignoreActors: 1 setCycle: End self) ; rightDr
				else
					(HighPrint 401 15) ; "You don't have the strength to break down the door."
					(self changeState: 7)
				)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(gEgo
					view: 0
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 160 92 self
				)
			)
			(6
				(gCurRoom newRoom: 470)
				(self dispose:)
			)
			(7
				(gEgo illegalBits: $8000 view: 0 loop: 3)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance backToInn of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0 view: 4)
				(= cycles 2)
			)
			(1
				(HighPrint 401 16 80 {Guard:}) ; "Do you not know it is forbidden to be out after dark in Raseir? Show me your visa."
				(= cycles 2)
			)
			(2
				(cond
					((< (gEgo x:) 86)
						(gEgo setMotion: MoveTo 126 135 self)
					)
					((> (gEgo x:) 232)
						(gEgo setMotion: MoveTo 201 135 self)
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(if (< (gEgo x:) 160)
					(gEgo setMotion: MoveTo 195 121 self)
				else
					(gEgo setMotion: MoveTo 131 121 self)
				)
			)
			(4
				(= cycles 2)
			)
			(5
				(if (< (gEgo x:) 160)
					(Face gEgo (ScriptID 400 4)) ; rGuard1
				else
					(Face gEgo (ScriptID 400 5)) ; rGuard2
				)
				(= cycles 2)
			)
			(6
				(if (gEgo has: 41) ; Visa
					(HighPrint 401 17) ; "You show the guard your visa."
					(= cycles 2)
				else
					(EgoDead 401 18 80 {Get a life - Get a visa}) ; MISSING MESSAGE
					(self dispose:)
				)
			)
			(7
				(HighPrint 401 19 80 {Guard:}) ; "You must go immediately to the Blue Parrot Inn. If you are found again outside at night, you will be taken to prison."
				(= cycles 2)
			)
			(8
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 2)
				(= cycles 10)
			)
			(9
				(Print 401 20) ; "The guard sullenly escorts you back to the Blue Parrot Inn."
				(= cycles 2)
			)
			(10
				(gCurRoom newRoom: 360)
				(self dispose:)
			)
		)
	)
)

(instance guardPoly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance guardPoly2 of Polygon
	(properties
		type PBarredAccess
	)
)

