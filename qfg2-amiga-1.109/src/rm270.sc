;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 270)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Flame)
(use Interface)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm270 0
)

(local
	numDodges
	tooLate
	struggling
	freeBird
	theBigCount = 1
	[unused 2]
)

(instance rm270 of Rm
	(properties
		picture 2
		style 7
		horizon 100
	)

	(method (init)
		(LoadMany rsVIEW 0 1 2 10 22 47 270 271 272 273)
		(LoadMany rsSCRIPT 78 969)
		(LoadMany rsSOUND 50 270)
		(= numDodges
			(cond
				((< [gEgoStats 7] 50) 100) ; dodge
				((< [gEgoStats 7] 75) 5) ; dodge
				((< [gEgoStats 7] 100) 4) ; dodge
				((< [gEgoStats 7] 125) 3) ; dodge
				(else 2)
			)
		)
		(super init:)
		(self setScript: welcome)
	)
)

(instance drFront of PicView
	(properties
		x 227
		y 118
		noun '/door'
		description {the doorway}
		lookStr {The doorway is the only way out of the room.}
		view 270
		loop 1
		cel 1
		priority 8
	)
)

(instance drBack of PicView
	(properties
		x 227
		y 108
		noun '/door'
		description {the doorway}
		lookStr {The doorway is the only way out of the room.}
		view 270
		loop 1
		priority 7
	)
)

(instance manacles of PicView
	(properties
		x 41
		y 127
		noun '/chain,manacle'
		description {the shackles that bound you}
		lookStr {The shackles that bound you hang limply from the wall.}
		view 270
		loop 1
		cel 2
		priority 8
	)
)

(instance shield of View
	(properties
		x 207
		y 103
		noun '/shield,blade,equipment'
		description {your fighting equipment}
		lookStr {Your sword and shield are doing you no good on the far side of the room.}
		view 270
		priority 6
	)
)

(instance flame1 of Flame
	(properties
		x 158
		y 58
		view 270
		loop 2
	)
)

(instance flame2 of Flame
	(properties
		x 200
		y 58
		view 270
		loop 2
		cel 1
	)
)

(instance fighter of Actor
	(properties
		x 235
		y 110
		noun '/fighter,fighter,swordsman'
		description {the bloodthirsty swordsman}
		lookStr {The flailing, bloodthirsty swordsman looks like he means business.}
		view 272
		signal 6144
	)
)

(instance welcome of HandsOffScript
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'done,escape') (Said 'run[<away]'))
				(= gWimpyHero 2)
				(gCSound fade:)
				(gCurRoom newRoom: 271)
			)
			(else
				(HighPrint 270 0) ; "Your mind is a jumble of half-completed thoughts."
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState &tmp I)
		(switch (= state newState)
			(0
				(Print 270 1) ; "The room is in total darkness as you enter. You can hear some movement around you."
				(LowPrint 270 2 80 {Voice:}) ; "Stand where you are. You now face the most important decision of your life...."
				(Print 270 3 #title {Same Voice:}) ; "Are you a man, or just a craven coward?"
				(HighPrint 270 4 80 {Still the Same Voice:} 25 5) ; "Stand and obey, or now run away!"
				(DontTalk 0)
				(= seconds 5)
			)
			(1
				(DontTalk 1)
				(Print 270 5) ; "You hear heavy footsteps beside you as something grabs you and starts to take away your equipment"
				(Print 270 6) ; "You find you are being dragged by your arms."
				(Print 270 7) ; "You find yourself turned around, and something heavy and cold is attached to your arms with a solid "clank""
				(gCurRoom drawPic: 270)
				(InitAddToPics drFront drBack)
				(shield init: stopUpd:)
				(gCSound number: 50 loop: -1 vol: 60 init: playBed:)
				(flame1 init: cycleSpeed: 1 setCycle: Fwd)
				(flame2 init: cycleSpeed: 1 setCycle: Rev)
				(gEgo view: 271 loop: 0 cel: 0 posn: 46 160 init:)
				(= cycles 10)
			)
			(2
				(rmnSound number: 270 loop: 2 play:)
				(gEgo cycleSpeed: 1 setCycle: End)
				(= seconds 3)
			)
			(3
				(gEgo cycleSpeed: 0)
				(HighPrint 270 8 80 {Voice:}) ; "You have 10 seconds to retrieve your weapon."
				(self cue:)
			)
			(4
				(gCurRoom setScript: countDown)
				(HandsOff)
				(self dispose:)
			)
		)
	)
)

(instance breakOut of HandsOffScript
	(properties)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(<= 0 state 3)
				(== (gEgo view:) 271)
				(OneOf (gEgo loop:) 1 3)
				(OneOf (gEgo cel:) 1 4)
				(== ((gEgo cycler:) cycleCnt:) 0)
			)
			(gSpareSound number: 270 loop: 1 priority: 5 vol: 110 play:)
		)
	)

	(method (dispose)
		(gSpareSound vol: 127)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					loop: 1
					cel: 0
					cycleSpeed: (if (< theBigCount 4) 2 else 1)
					setCycle: Fwd
				)
				(= cycles (Random 15 35))
			)
			(1
				(gEgo loop: 2 setCycle: 0)
				(= cycles (if (gCast contains: fighter) 25 else 10))
			)
			(2
				(if (gCast contains: fighter)
					(gEgo loop: 1 cycleSpeed: 0 setCycle: Fwd)
					(= cycles 14)
				else
					(self changeState: 0)
				)
			)
			(3
				(if tooLate
					(gEgo loop: 2 setCycle: 0)
				else
					(gEgo loop: 3 cel: 0 cycleSpeed: 1 setCycle: End self)
				)
			)
			(4
				(InitAddToPics manacles)
				(gEgo loop: 4 cel: 0 setCycle: End self)
			)
			(5
				(= freeBird 1)
				(gEgo
					setLoop: 5
					cel: 0
					setCycle: 0
					cycleSpeed: 0
					setScript: dodgeEm
				)
				(self dispose:)
			)
		)
	)
)

(instance countDown of HandsOffScript
	(properties)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(return 1)
		)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'ask//!*')
						(HighPrint 270 9) ; "There is no one who wants to chit-chat."
					)
					((Said 'look,look>')
						(cond
							((Said '/flame,fire,sconce')
								(HighPrint 270 10) ; "It's the only light in the room."
							)
							((Said '/shield')
								(HighPrint 270 11) ; "It has been left standing in the far corner."
							)
							((Said '/blade')
								(HighPrint 270 12) ; "It's standing in the far corner with the shield."
							)
							((Said '/door')
								(HighPrint 270 13) ; "It looks like the only way in or out."
							)
							((Said '/ceiling,up')
								(HighPrint 270 14) ; "The ceiling is covered in goldleaf."
							)
							((Said '/floor,down')
								(HighPrint 270 15) ; "The floor is paved with large tiles."
							)
							(
								(Said
									'search,look,look[<at,around][/room,area][/!*]'
								)
								(HighPrint 270 16) ; "I guess this is the EOF hall."
							)
							((Said '/fighter,fighter,swordsman')
								(HighPrint 270 17) ; "Fighter, what fighter? I don't see no stinking fighter."
							)
							((Said '/chain,chain,manacle')
								(HighPrint 270 18) ; "These chains don't look very strong."
							)
						)
					)
					(
						(or
							(Said 'break/chain,free,loose')
							(Said 'use/strength')
							(Said 'attack,struggle[<free,loose]')
							(Said 'free/self')
						)
						(if struggling
							(HighPrint 270 19) ; "Of course! You're trying, you're trying!"
						else
							(= struggling 1)
							(gEgo setScript: breakOut)
						)
					)
					((Said 'cast,throw')
						(HighPrint 270 20) ; "You're hardly in a position to do that now."
					)
					(else
						(event claimed: 1)
						(HighPrint 270 21) ; "You'd better think of some way to get out of those shackles... and make it snappy!"
					)
				)
			)
			($0040 ; direction
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DontTalk 0)
				(= seconds 2)
			)
			(1
				(switch theBigCount
					(1
						(HighPrint 270 22 25 2 103) ; "One!"
					)
					(2
						(HighPrint 270 23 25 2 103) ; "Two!"
					)
					(3
						(HighPrint 270 24 25 2 103) ; "Three!"
					)
					(4
						(HighPrint 270 25 25 2 103) ; "Four!"
					)
					(5
						(HighPrint 270 26 25 2 103) ; "Five!"
					)
					(6
						(HighPrint 270 27 25 2 103) ; "Six!"
					)
					(7
						(HighPrint 270 28 25 2 103) ; "Seven!"
					)
					(8
						(HighPrint 270 29 25 2 103) ; "Eight!"
					)
					(9
						(HighPrint 270 30 25 2 103) ; "Nine!"
					)
					(10
						(HighPrint 270 31 25 2 103) ; "TEN!"
					)
				)
				(= seconds 2)
			)
			(2
				(if (<= (++ theBigCount) 10)
					(self changeState: 1)
					(if (and (== theBigCount 8) (not (gCast contains: fighter)))
						(fighter illegalBits: 0 init: setScript: sicEm)
						(if struggling
							(breakOut changeState: 1)
						else
							(= tooLate 1)
						)
					)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance sicEm of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fighter setMotion: MoveTo 229 110 self)
			)
			(1
				(DontTalk 0)
				(fighter setCel: -1 setCycle: End)
				(= cycles 10)
			)
			(2
				(fighter
					setLoop: 1
					cel: 0
					posn: (- (fighter x:) 1) (+ (fighter y:) 2)
					setCycle: Walk
					setMotion: MoveTo 81 153 self
				)
			)
			(3
				(if freeBird
					(fighter
						view: 273
						setLoop: 0
						cel: 0
						setCycle: 0
						setScript: bopEm
					)
				else
					(gEgo setScript: 0)
					(fighter view: 273 setLoop: 0 cel: 0 setCycle: CT 4 1)
					(= gWimpyHero 1)
					(HighPrint 270 32 25 4 103) ; "Some Hero YOU are!"
					(= seconds 3)
				)
			)
			(4
				(if freeBird
					(self dispose:)
				else
					(= gTimeODay 6)
					(gCSound fade:)
					(gCurRoom newRoom: 271)
				)
			)
		)
	)
)

(instance bopEm of Script
	(properties)

	(method (doit)
		(cond
			(
				(and
					(== (client loop:) 3)
					(== (client cel:) (client lastCel:))
					(not (dodgeEm script:))
				)
				(dodgeEm setScript: egoBopped)
			)
			(
				(and
					(<= 4 (client loop:) 5)
					(== (client cel:) (client lastCel:))
					(not (dodgeEm script:))
				)
				(dodgeEm setScript: knockDown)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(client setLoop: 0 cel: 0)
				(= cycles (Random 2 5))
			)
			(2
				(if (== (dodgeEm script:) knockDown)
					(self changeState: 0)
				else
					(client setLoop: (Random 3 5) cel: 0)
					(= cycles (Random 5 15))
				)
			)
			(3
				(if (not (client loop:))
					(client setCycle: CT 0 1 self)
				else
					(client setCycle: End self)
				)
				(= cycles 10)
			)
			(4
				(if (not (client loop:))
					(self changeState: 1)
				else
					(= cycles 4)
				)
			)
			(5
				(self changeState: 1)
			)
		)
	)
)

(instance dodgeEm of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gDirectionHandler add: self)
		(gMouseDownHandler add: self)
		(DontTalk 0)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(gMouseDownHandler delete: self)
		(DontTalk 1)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp whichDodge whatAngle)
		(if (super handleEvent: event)
			(return 1)
		)
		(if (self script:)
			(return)
		)
		(if (== (fighter script:) sicEm)
			(return 1)
		)
		(switch (event type:)
			($0040 ; direction
				(event claimed: 1)
				(switch (event message:)
					(JOY_UP
						(self setScript: egoBlocked)
					)
					(JOY_LEFT
						(self setScript: dodgeLeft)
					)
					(JOY_RIGHT
						(if numDodges
							(if
								(>
									(= whichDodge (/ (Random 5 255) numDodges))
									(Random 15 25)
								)
								(self setScript: dodgeRightBad)
							else
								(self setScript: blockedRight)
							)
						else
							(self setScript: dodgeRightGood)
						)
						(-- numDodges)
					)
					(JOY_DOWN
						(self setScript: jumpBack)
					)
				)
			)
			(evMOUSEBUTTON
				(event claimed: 1)
				(cond
					(
						(<
							(= whatAngle
								(GetAngle
									(gEgo x:)
									(gEgo y:)
									(event x:)
									(event y:)
								)
							)
							75
						)
						(self setScript: egoBlocked)
					)
					((< whatAngle 100)
						(if numDodges
							(if
								(>
									(= whichDodge (/ (Random 5 255) numDodges))
									(Random 15 25)
								)
								(self setScript: dodgeRightBad)
							else
								(self setScript: blockedRight)
							)
						else
							(self setScript: dodgeRightGood)
						)
						(-- numDodges)
					)
					((< whatAngle 240)
						(self setScript: jumpBack)
					)
					(else
						(self setScript: dodgeLeft)
					)
				)
			)
			(evSAID
				(cond
					((or (Said 'done,escape') (Said 'run[<away]'))
						(= gWimpyHero 2)
						(gCSound fade:)
						(gCurRoom newRoom: 271)
					)
					((Said 'cast,throw')
						(= gWimpyHero 6)
						(HighPrint 270 33 80 {A chorus of voices}) ; "CHEAT! CHEAT!!!"
						(gCSound fade:)
						(gCurRoom newRoom: 271)
					)
					(else
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance knockDown of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(UseStamina 20)
				(gEgo
					view: 22
					setLoop: 0
					cel: 0
					posn: (+ (gEgo x:) 10) (+ (gEgo y:) 3)
					setCycle: End self
				)
			)
			(1
				(= cycles 15)
			)
			(2
				(gEgo setLoop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(3
				(= cycles 10)
			)
			(4
				(gEgo setCycle: CT 8 1 self)
			)
			(5
				(gEgo
					view: 271
					setLoop: 5
					posn: (- (gEgo x:) 10) (- (gEgo y:) 3)
				)
				(self dispose:)
			)
		)
	)
)

(instance blockedRight of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fighter setLoop: 5 cel: 1 setCycle: End)
				(gEgo
					setPri: (+ (fighter priority:) 1)
					setLoop: 8
					cel: 0
					posn: (+ (gEgo x:) 13) (- (gEgo y:) 10)
					setCycle: End self
				)
			)
			(1
				(fighter setCycle: Beg)
				(UseStamina 20)
				(gEgo
					view: 22
					posn: (- (gEgo x:) 3) (+ (gEgo y:) 13)
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(2
				(= cycles 15)
			)
			(3
				(gEgo setLoop: 1 cel: 0 cycleSpeed: 1 setCycle: CT 4 1 self)
			)
			(4
				(= cycles 10)
			)
			(5
				(gEgo setCycle: CT 8 1 self)
			)
			(6
				(gEgo
					view: 271
					setLoop: 5
					cycleSpeed: 0
					posn: (- (gEgo x:) 10) (- (gEgo y:) 3)
					setPri: -1
				)
				(self dispose:)
			)
		)
	)
)

(instance dodgeLeft of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: 7 cel: 0 x: (- (gEgo x:) 8))
				(= cycles 2)
			)
			(1
				(gEgo cel: 1)
				(= cycles 2)
			)
			(2
				(gEgo cel: 0)
				(= cycles 2)
			)
			(3
				(gEgo x: (+ (gEgo x:) 8) setLoop: 5)
				(self dispose:)
			)
		)
	)
)

(instance dodgeRightBad of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setLoop: 6
					cel: 0
					posn: (+ (gEgo x:) 10) (- (gEgo y:) 5)
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(gEgo
					setLoop: 5
					cycleSpeed: 0
					posn: (- (gEgo x:) 10) (+ (gEgo y:) 5)
				)
				(self dispose:)
			)
		)
	)
)

(instance dodgeRightGood of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setLoop: 8
					cel: 0
					setPri: (+ (fighter priority:) 1)
					posn: (+ (gEgo x:) 13) (- (gEgo y:) 9)
					setCycle: End self
				)
			)
			(1
				(gEgo
					setLoop: 7
					cel: 2
					posn: (+ (gEgo x:) 34) (+ (gEgo y:) 9)
					setCycle: Beg self
				)
			)
			(2
				(gEgo view: 271 setLoop: 5 cel: 0 setPri: -1)
				(client setScript: straightUp)
			)
		)
	)
)

(instance egoBopped of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(UseStamina 20)
				(gEgo
					view: 271
					posn: 46 160
					setLoop: 4
					cel: 4
					illegalBits: 0
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: CT 1 -1 self
				)
			)
			(1
				(= cycles 5)
			)
			(2
				(gEgo illegalBits: -32768 cycleSpeed: 1 setCycle: End self)
			)
			(3
				(gEgo view: 271 setLoop: 5 cel: 0 cycleSpeed: 0)
				(self dispose:)
			)
		)
	)
)

(instance egoBlocked of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fighter setScript: 0 setLoop: 4 cel: 0 setCycle: CT 4 1 self)
				(gEgo
					view: 1
					setLoop: 6
					cel: 0
					xStep: 6
					yStep: 3
					cycleSpeed: 1
					moveSpeed: 1
					setCycle: 0
					posn: (+ (gEgo x:) 16) (+ (gEgo y:) 2)
				)
			)
			(1
				(fighter setCycle: Beg)
				(UseStamina 20)
				(gEgo
					setMotion: 0
					view: 271
					posn: 46 160
					setLoop: 4
					cel: 4
					illegalBits: 0
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: CT 1 -1 self
				)
			)
			(2
				(= cycles 5)
			)
			(3
				(gEgo illegalBits: -32768 cycleSpeed: 1 setCycle: End self)
			)
			(4
				(fighter setScript: bopEm)
				(gEgo view: 271 setLoop: 5 cel: 0 cycleSpeed: 0)
				(self dispose:)
			)
		)
	)
)

(instance straightUp of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 1
					setLoop: -1
					loop: (if (< (gEgo x:) 200) 6 else 3)
					cel: 0
					xStep: 6
					yStep: 3
					cycleSpeed: 0
					setCycle: Walk
					posn: (+ (gEgo x:) 16) (+ (gEgo y:) 2)
					setMotion: MoveTo 199 105 self
				)
				(fighter
					view: 272
					setLoop: 2
					cel: 0
					cycleSpeed: 1
					setCycle: End
					setScript: 0
				)
			)
			(1
				(gEgo view: 47 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(HighPrint 270 34) ; "You retrieve your equipment and turn to face your adversary."
				(gCSound fade:)
				(gCurRoom newRoom: 275)
			)
		)
	)
)

(instance jumpBack of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setLoop: 6
					cel: 0
					posn: (+ (gEgo x:) 12) (- (gEgo y:) 4)
				)
				(= cycles 2)
			)
			(1
				(gEgo cycleSpeed: 1 setCycle: End self)
			)
			(2
				(gEgo
					cycleSpeed: 0
					posn: (- (gEgo x:) 12) (+ (gEgo y:) 4)
					setLoop: 5
					cel: 0
				)
				(self dispose:)
			)
		)
	)
)

(instance rmnSound of Sound
	(properties)

	(method (check)
		(DoSound 11 self) ; sndUPDATE_CUES
		(if (self signal:)
			(self prevSignal: (self signal:) signal: 0)
			(cond
				((> (self loop:) 1)
					(self loop: (- (self loop:) 1))
					(DoSound 7 self 0) ; sndPLAY
				)
				((IsObject client)
					(client cue: self)
				)
			)
		)
	)
)

