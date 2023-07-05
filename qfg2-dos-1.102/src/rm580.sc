;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 580)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use ProjClient)
(use n065)
(use TargActor)
(use Interface)
(use LoadMany)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm580 0
)

(local
	windy
	lastControl
	castSpell
	msgCnt
	falling
	oldScript
)

(procedure (BlackPrint)
	(highBlackWindow color: 9 back: 0)
	(Print &rest #window highBlackWindow)
)

(procedure (NoLamp)
	(BlackPrint 580 0) ; "Uh-oh, you don't seem to have a lamp."
	(if
		(Print
			{Might as well die now.  Just to save yourself a little frustration.}
			#title
			{Your Choice of Poison}
			#button
			{OK.  Kill me now}
			1
			#button
			{Later (but not much)}
			0
		)
		(EgoDead
			1
			{Perhaps there's a reason why people are scared of the dark.}
			#title
			{Whaddaya think?}
		)
	else
		(return 0)
	)
)

(instance rm580 of Rm
	(properties
		picture 580
		east 570
	)

	(method (dispose)
		(if windy
			(roomSound stop: dispose:)
		)
		(= global61 0)
		(super dispose:)
	)

	(method (init)
		(SetFlag 101)
		(LoadMany rsPIC 580 570 2)
		(LoadMany rsSOUND 600 580)
		(LoadMany rsVIEW 585 586 580 591 591)
		(if (!= gPrevRoomNum 550)
			(LoadMany rsVIEW 6 62)
		)
		(= gSpellChecker gAllChecker)
		(NormalEgo)
		(gCSound number: 600 priority: 0 loop: -1 playBed:)
		(if (= windy (not (IsFlag 107)))
			(roomSound init: play:)
		)
		(kludge init: hide:)
		(redDr init: setScript: (if (== gPrevRoomNum 560) 0 else glowDrS))
		(blueDr init:)
		(stag1 init: stopUpd:)
		(stag2 init: stopUpd:)
		(stag3 init: stopUpd:)
		(stag4 init: stopUpd:)
		(self
			style:
				(switch gPrevRoomNum
					(570 41)
					(560 6)
					(550 15)
					(else 15)
				)
		)
		(= global61 0)
		(super init:)
		(floorShine init: hide:)
		(wallShine init: hide:)
		(self
			setScript:
				(switch gPrevRoomNum
					(570 fromWaterRm)
					(560 fromFireRm)
					(else fromEntrance)
				)
		)
		(gCSound number: 600 loop: -1 playBed:)
		(gMiscSound number: 580 loop: 1 play:)
	)

	(method (doit &tmp thisControl)
		(cond
			((== (= thisControl (gEgo onControl: 1)) lastControl))
			((and (< (gEgo x:) 1) (not script))
				(= gEgoY (gEgo y:))
				(gCurRoom newRoom: 570)
			)
			((and (& thisControl $0004) (== (gEgo illegalBits:) -32768))
				(self setScript: toFireRm)
			)
			((and (& thisControl $0008) (not falling))
				(= falling 1)
				(wallShine hide:)
				(self setScript: fallOffLedge)
			)
			((and (& thisControl $0010) (!= (gEgo priority:) 6))
				(gEgo setPri: 6)
				(if (IsFlag 116)
					(wallShine hide:)
					(floorShine hide:)
				)
			)
			((and (not (& thisControl $0010)) (== (gEgo priority:) 6))
				(gEgo setPri: 8)
				(if (IsFlag 116)
					(wallShine show:)
					(floorShine show:)
				)
			)
			((& thisControl $0020)
				(gEgo y: 181 setMotion: 0)
				(BlackPrint 580 1) ; "On the other side of the stalactites and stalagmites, you see the darkness of a very deep chasm. Good thing you have this lamp to light your way."
			)
			(else
				(gEgo setPri: 8)
			)
		)
		(= lastControl thisControl)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'use,light,rub,rub,(turn<on)/lamp,light')
				(cond
					((not [gInvNum 33]) ; BrassLamp
						(NoLamp)
					)
					((IsFlag 116)
						(BlackPrint 580 2) ; "You're already using the lamp."
					)
					(else
						(SetFlag 116)
						(gEgo show:)
						(EgoGait 4 0) ; holdingLamp
						(HandsOn)
						(floorShine show:)
						(wallShine show:)
						(if (< (gEgo y:) 100)
							(= global61 2)
						else
							(= global61 1)
						)
						(gCurRoom drawPic: 580 7)
						(self setScript: 0)
					)
				)
			)
			((Said 'put,drop,extinguish,douse,(turn<off)/lamp,light')
				(if (IsFlag 116)
					(BlackPrint 580 3) ; "If you did that, you would be lost in the dark."
				else
					(BlackPrint 580 4) ; "You can't see to do that. The lamp isn't lit."
				)
			)
			((and (not (IsFlag 116)) (Said 'look,look'))
				(BlackPrint 580 5) ; "You can't see a thing. It's too dark."
			)
			((Said 'run,sneak,walk')
				(BlackPrint 580 6) ; "It's best if you just walk carefully."
			)
			((Said 'listen')
				(if windy
					(HighPrint 580 7) ; "You can hear the sound of rushing wind."
				else
					(HighPrint 580 8) ; "The sound of the wind has diminished."
				)
			)
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/cave,wall,chamber')
					(Said 'look,look<up,down')
				)
				(BlackPrint 580 9) ; "The rock glistens with moisture."
			)
			((Said 'cast,drop,use,throw,climb,climb/rope[<magic]')
				(cond
					(windy
						(BlackPrint 580 10) ; "The wind in here is far too strong for you even to attempt to use your rope."
					)
					((< (gEgo y:) 100)
						(BlackPrint 580 11) ; "There doesn't appear to be a good place to use it here."
					)
					(else
						(= gRopeHighY 150)
						(event claimed: 0)
					)
				)
			)
			((Said 'cast>')
				(switch (SaidSpell event)
					(28
						(cond
							(windy
								(BlackPrint 580 12) ; "The wind in here is far too strong for you even to attempt the levitation spell."
								(event claimed: 1)
							)
							((< (gEgo y:) 100)
								(BlackPrint 580 13) ; "There doesn't appear to be a good place to levitate here."
								(event claimed: 1)
							)
							(else
								(= gLevHighY 123)
								(event claimed: 0)
							)
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance toFireRm of HandsOffScript
	(properties)

	(method (doit &tmp theY)
		(= theY (gEgo y:))
		(redDr
			setCel:
				(cond
					((<= theY 60) 0)
					((<= theY 62) 1)
					((<= theY 64) 2)
					((<= theY 65) 3)
					(else 4)
				)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(redDr setScript: 0)
				(gEgo illegalBits: 0 setMotion: MoveTo 283 58 self)
			)
			(1
				(= gRoomExitDir 4)
				(gCurRoom newRoom: 560)
				(self dispose:)
			)
		)
	)
)

(instance toEarthRm of HandsOffScript ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(blueDr cycleSpeed: 2 setCycle: Beg)
				(gEgo
					illegalBits: 0
					setMotion: MoveTo (+ (gEgo x:) 4) (- (gEgo y:) 4) self
				)
			)
			(1
				(gCurRoom newRoom: 590)
				(self dispose:)
			)
		)
	)
)

(instance fromWaterRm of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SolvePuzzle 634 7)
				(wallShine doit: show:)
				(floorShine doit: show:)
				(gEgo
					loop: 0
					posn: 1 gEgoY
					illegalBits: 0
					setPri: 8
					init:
				)
				(if (< (gEgo y:) 100)
					(self cue:)
				else
					(gEgo setMotion: MoveTo 14 gEgoY self)
				)
			)
			(1
				(NormalEgo)
				(if (and windy (< (gEgo y:) 90))
					(gEgo posn: 1 gEgoY)
					(gEgo setScript: windyCityS)
				)
				(gEgo setPri: 8)
				(self dispose:)
			)
		)
	)
)

(instance windyCityS of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (> (gEgo x:) 106) (not gCantMove))
			(HandsOff)
			(gEgo setMotion: MoveTo 152 77)
		else
			(gEgo x: (- (gEgo x:) 2))
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'cast,throw')
				(BlackPrint 580 14) ; "The air rushing through the passage is so strong that it threatens to blow you off your feet. You find it impossible to concentrate on anything else."
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 62 setLoop: 0 setMotion: MoveTo 152 77)
			)
		)
	)
)

(instance fromEntrance of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'cast>')
				(if (OneOf (SaidSpell event) 22 25)
					(= castSpell 1)
				)
				(event claimed: 0)
			)
			((== (event type:) $0040) ; direction
				(msgTimer setReal: msgTimer 3)
				(event claimed: 1)
			)
		)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (and castSpell (not (IsFlag 87)))
			(gEgo hide:)
			(RedrawCast)
			(BlackPrint 580 15) ; "Your eyes are blinded by the flash in the dark, and you still can't see."
			(= castSpell 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gDirectionHandler add: self)
				(gEgo
					setPri: 32
					loop: 5
					posn: 199 137
					illegalBits: 0
					init:
					setMotion: MoveTo 174 149 self
				)
				(blueDr cel: 0)
			)
			(1
				(blueDr cycleSpeed: 2 setCycle: End self)
			)
			(2
				(gCurRoom drawPic: 2)
				(gEgo setPri: 8 hide:)
				(blueDr stopUpd:)
				(= cycles 8)
			)
			(3
				(BlackPrint 580 16) ; "For a few moments, your mind is overwhelmed by the squalling, whirling wind."
				(= seconds 3)
			)
			(4
				(BlackPrint 580 17) ; "Then the euphoric feeling starts to fade and you stand alone in the darkness."
				(= cycles 10)
			)
			(5
				(BlackPrint 580 18) ; "The past few hours are hazy in your memory. You remember only one thing clearly: you are here to find the Statue of Iblis."
				(gEgo ignoreActors: illegalBits: -32768)
				(HandsOn)
			)
		)
	)
)

(instance fromFireRm of HandsOffScript
	(properties)

	(method (doit &tmp theY)
		(= theY (gEgo y:))
		(redDr
			setCel:
				(cond
					((<= theY 60) 0)
					((<= theY 62) 1)
					((<= theY 64) 2)
					((<= theY 65) 3)
					(else 4)
				)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setPri: 5
					loop: 5
					posn: 286 58
					illegalBits: 0
					init:
					setMotion: MoveTo 273 66 self
				)
				(redDr setCel: 0)
			)
			(1
				(NormalEgo)
				(gEgo setPri: 8)
				(redDr setScript: glowDrS)
				(self dispose:)
			)
		)
	)
)

(instance glowDrS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 5 30))
			)
			(1
				(client setCel: 3)
				(= cycles (Random 2 8))
			)
			(2
				(client setCel: 4)
				(self changeState: 0)
			)
		)
	)
)

(instance fallOffLedge of HandsOffScript
	(properties)

	(method (handleEvent event &tmp zOffset)
		(cond
			((super handleEvent: event))
			((Said 'cast>')
				(if (== (SaidSpell event) 28)
					(if (TrySpell 28)
						(= zOffset (- 170 (gEgo y:)))
						(gEgo y: (+ (gEgo y:) zOffset) z: zOffset)
						(client setScript: (ScriptID 62 0)) ; levitate
					)
				else
					(Print 580 19) ; "Not now - you're falling!"
				)
				(event claimed: 1)
			)
			(else
				(event claimed: 1)
				(Print 580 20) ; "You're busy falling right now."
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DontTalk 0)
				(gEgo
					setScript: 0
					view: 591
					setLoop: 3
					cel: 0
					setPri: 13
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 3) self
				)
				(if (IsFlag 116)
					(floorShine hide:)
					(wallShine hide:)
					(lamp posn: (+ (gEgo x:) 20) (- (gEgo y:) 15) init:)
				)
			)
			(1
				(gEgo
					setLoop: 1
					cel: 0
					posn: (- (gEgo x:) 8) (gEgo y:)
				)
				(if (IsFlag 116)
					(lamp posn: (+ (gEgo x:) 20) (- (gEgo y:) 15))
				)
				(= cycles 1)
			)
			(2
				(gEgo cel: 1 posn: (- (gEgo x:) 2) (+ (gEgo y:) 3))
				(if (IsFlag 116)
					(lamp posn: (+ (gEgo x:) 20) (- (gEgo y:) 10))
				)
				(= cycles 1)
			)
			(3
				(gEgo cel: 2 posn: (+ (gEgo x:) 1) (+ (gEgo y:) 7))
				(if (IsFlag 116)
					(lamp posn: (+ (gEgo x:) 20) (- (gEgo y:) 5))
				)
				(= cycles 1)
			)
			(4
				(gEgo cel: 3 posn: (+ (gEgo x:) 3) (+ (gEgo y:) 3))
				(if (IsFlag 116)
					(lamp posn: (+ (gEgo x:) 20) (gEgo y:))
				)
				(= cycles 1)
			)
			(5
				(gEgo
					view: 6
					setLoop: 2
					cel: 3
					posn: (+ (gEgo x:) 5) (+ (gEgo y:) 14)
				)
				(if (IsFlag 116)
					(lamp posn: (+ (gEgo x:) 20) (gEgo y:))
				)
				(= cycles 1)
			)
			(6
				(DontTalk 1)
				(gEgo cel: 4 posn: (- (gEgo x:) 1) (+ (gEgo y:) 9))
				(if (IsFlag 116)
					(lamp posn: (+ (gEgo x:) 20) (gEgo y:))
				)
				(= cycles 1)
			)
			(7
				(gEgo cel: 5 posn: (+ (gEgo x:) 3) (+ (gEgo y:) 13))
				(if (IsFlag 116)
					(lamp posn: (+ (gEgo x:) 20) (gEgo y:))
				)
				(= cycles 1)
			)
			(8
				(gEgo cel: 6 posn: (gEgo x:) (+ (gEgo y:) 14))
				(if (IsFlag 116)
					(lamp posn: (+ (gEgo x:) 20) (gEgo y:))
				)
				(= cycles 1)
			)
			(9
				(gEgo cel: 7 posn: (- (gEgo x:) 1) 153)
				(if (IsFlag 116)
					(lamp posn: (+ (gEgo x:) 20) (gEgo y:))
				)
				(= cycles 1)
			)
			(10
				(gEgo cel: 8)
				(if (IsFlag 116)
					(lamp posn: (+ (gEgo x:) 20) (gEgo y:))
					(floorShine
						posn: (lamp x:) (lamp y:)
						setPri: (- (lamp priority:) 1)
						show:
					)
				)
				(= cycles 1)
			)
			(11
				(gEgo cel: 9)
				(= cycles 10)
			)
			(12
				(if (TakeDamage 10)
					(if windy
						(switch (++ gFallCount)
							(1
								(BlackPrint 580 21) ; "The wind is at its worst as it comes from the passage above. There must be something you can do to stop its fury."
							)
							(2
								(BlackPrint 580 22) ; "The wind blew you off like a leaf from a tree. It doesn't seem as if you can get near enough to cut the wind off at its source."
							)
							(3
								(BlackPrint 580 23) ; "The wind again caused you to fall like a rock."
							)
							(4
								(BlackPrint 580 24) ; "You can't take much more of this. You must stop the wind from blowing before it stops you."
							)
							(else
								(BlackPrint 580 25) ; "This is getting you nowhere. Maybe you are looking at the problem from the wrong end."
							)
						)
					else
						(BlackPrint 580 26) ; "Even with the lamp, the darkness can be treacherous."
					)
					(gEgo
						setLoop: 3
						cel: 0
						cycleSpeed: 1
						setCycle: CT 6 1 self
					)
					(= falling 0)
				else
					(EgoDead
						1
						{Dancing in the dark is romantic, but dangerous.}
						#title
						{You Blew That One}
					)
				)
			)
			(13
				(gEgo setCycle: End self)
				(lamp dispose:)
			)
			(14
				(wallShine posn: (gEgo x:) 140 show:)
				(HandsOn)
				(NormalEgo)
				(gEgo setPri: 8)
				(self dispose:)
			)
		)
	)
)

(instance lamp of Actor
	(properties
		view 586
		loop 2
		signal 16384
		illegalBits 0
	)
)

(instance floorShine of Actor
	(properties
		x 159
		y 150
		view 586
		priority 1
		signal 18448
		illegalBits 0
	)

	(method (doit)
		(if (and (IsFlag 116) (== (gEgo view:) 585))
			(cond
				((> (gEgo y:) 100)
					(self setPri: 4)
				)
				((== (gEgo loop:) 2)
					(self setPri: 1)
				)
				(else
					(self setPri: 7)
				)
			)
			(switch (gEgo loop:)
				(0
					(self posn: (+ (gEgo x:) 10) (+ (gEgo y:) 5))
				)
				(1
					(self posn: (- (gEgo x:) 10) (+ (gEgo y:) 5))
				)
				(2
					(self posn: (gEgo x:) (+ (gEgo y:) 5))
				)
				(3
					(self posn: (gEgo x:) (- (gEgo y:) 5))
				)
				(4
					(self posn: (+ (gEgo x:) 12) (gEgo y:))
				)
				(5
					(self posn: (- (gEgo x:) 20) (+ (gEgo y:) 5))
				)
				(6
					(self posn: (+ (gEgo x:) 12) (gEgo y:))
				)
				(else
					(self posn: (- (gEgo x:) 20) (+ (gEgo y:) 5))
				)
			)
		)
		(super doit:)
	)
)

(instance wallShine of Actor
	(properties
		x 159
		y 140
		view 586
		loop 1
		priority 2
		signal 18448
		illegalBits 0
	)

	(method (doit)
		(if (and (IsFlag 116) (== (gEgo view:) 585))
			(if (== (gEgo loop:) 2)
				(self hide:)
			else
				(self show:)
			)
			(switch (gEgo loop:)
				(0
					(self posn: (+ (gEgo x:) 10) (- (gEgo y:) 15))
				)
				(1
					(self posn: (- (gEgo x:) 10) (- (gEgo y:) 15))
				)
				(2
					(self posn: (gEgo x:) (gEgo y:))
				)
				(3
					(self posn: (- (gEgo x:) 10) (- (gEgo y:) 15))
				)
				(4
					(self posn: (+ (gEgo x:) 20) (- (gEgo y:) 15))
				)
				(5
					(self posn: (- (gEgo x:) 20) (- (gEgo y:) 15))
				)
				(6
					(self posn: (+ (gEgo x:) 20) (- (gEgo y:) 15))
				)
				(7
					(self posn: (- (gEgo x:) 20) (- (gEgo y:) 15))
				)
				(else
					(self posn: (lamp x:) (- (lamp y:) 15))
				)
			)
		else
			(self hide:)
		)
		(super doit:)
	)
)

(instance blueDr of TargActor
	(properties
		x 199
		y 130
		noun '/door,entrance[<out,city]'
		description {the door to the outside}
		lookStr {The door through which you entered the Forbidden City has closed behind you.}
		view 580
		cel 4
		priority 4
		signal 16400
	)

	(method (hurtMe amount whatHurt &tmp moveScript)
		(if (OneOf (whatHurt type:) 25 27)
			((= moveScript (Projectile new:))
				type: (whatHurt type:)
				damage: amount
				xStart: hitX
				yStart: hitY
				x: (+ (gEgo x:) (Random -15 15))
				y: (+ (gEgo y:) (Random -10 10))
			)
			(self setScript: moveScript self 0)
			(if (== (whatHurt type:) 25)
				(= msgCnt 4)
			else
				(= msgCnt 5)
			)
			(msgTimer setReal: msgTimer 2)
			(return 0)
		)
	)

	(method (openMe)
		(HighPrint 580 27) ; "The door resists all attempts to open it."
		(return 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2)
			(self openMe:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance redDr of TargActor
	(properties
		x 283
		y 56
		noun '/done,glow'
		description {the red glow}
		lookStr {There is a red glow in another chamber beyond this one.}
		view 580
		loop 1
		cel 4
		priority 4
		signal 16400
	)

	(method (hurtMe amount whatHurt &tmp moveScript)
		(if (OneOf (whatHurt type:) 25 27)
			((= moveScript (Projectile new:))
				type: (whatHurt type:)
				damage: amount
				xStart: hitX
				yStart: hitY
				x: (+ (gEgo x:) (Random -15 15))
				y: (+ (gEgo y:) (Random -10 10))
			)
			(self setScript: moveScript self 0)
			(if (== (whatHurt type:) 25)
				(= msgCnt 4)
			else
				(= msgCnt 5)
			)
			(msgTimer setReal: msgTimer 2)
			(return 0)
		)
	)
)

(instance stag1 of Prop
	(properties
		x 17
		y 75
		view 580
		loop 2
		cel 4
		priority 12
		signal 16
	)

	(method (doit)
		(cond
			((and (IsFlag 116) (< (gEgo y:) 100))
				(cond
					((> (- (gEgo x:) (stag1 x:)) 70)
						(self setCel: 4)
					)
					((> (- (gEgo x:) (stag1 x:)) 25)
						(self setCel: 3)
					)
					((> (- (gEgo x:) (stag1 x:)) 10)
						(self setCel: 2)
					)
					((> (- (stag1 x:) (gEgo x:)) 25)
						(self setCel: 0)
					)
					(else
						(self setCel: 1)
					)
				)
			)
			((!= (self cel:) 4)
				(self setCel: 4)
			)
		)
		(super doit:)
	)
)

(instance stag2 of Prop
	(properties
		x 53
		y 75
		view 580
		loop 3
		cel 4
		priority 12
		signal 16
	)

	(method (doit)
		(cond
			((and (IsFlag 116) (< (gEgo y:) 100))
				(cond
					((> (- (gEgo x:) (self x:)) 70)
						(self setCel: 4)
					)
					((> (- (gEgo x:) (self x:)) 25)
						(self setCel: 3)
					)
					((> (- (gEgo x:) (self x:)) 10)
						(self setCel: 2)
					)
					((> (- (self x:) (gEgo x:)) 25)
						(self setCel: 0)
					)
					(else
						(self setCel: 1)
					)
				)
			)
			((!= (self cel:) 4)
				(self setCel: 4)
			)
		)
		(super doit:)
	)
)

(instance stag3 of Prop
	(properties
		x 91
		y 78
		view 580
		loop 2
		cel 4
		priority 12
		signal 16
	)

	(method (doit)
		(cond
			((and (IsFlag 116) (< (gEgo y:) 100))
				(cond
					((> (- (gEgo x:) (self x:)) 70)
						(self setCel: 4)
					)
					((> (- (gEgo x:) (self x:)) 25)
						(self setCel: 3)
					)
					((> (- (gEgo x:) (self x:)) 10)
						(self setCel: 2)
					)
					((> (- (self x:) (gEgo x:)) 25)
						(self setCel: 0)
					)
					(else
						(self setCel: 1)
					)
				)
			)
			((!= (self cel:) 4)
				(self setCel: 4)
			)
		)
		(super doit:)
	)
)

(instance stag4 of Prop
	(properties
		x 142
		y 82
		view 580
		loop 4
		cel 4
		priority 12
		signal 16
	)

	(method (doit)
		(cond
			((and (IsFlag 116) (< (gEgo y:) 100))
				(cond
					((> (- (gEgo x:) (self x:)) 70)
						(self setCel: 4)
					)
					((> (- (gEgo x:) (self x:)) 25)
						(self setCel: 3)
					)
					((> (- (gEgo x:) (self x:)) 10)
						(self setCel: 2)
					)
					((> (- (self x:) (gEgo x:)) 25)
						(self setCel: 0)
					)
					(else
						(self setCel: 1)
					)
				)
			)
			((!= (self cel:) 4)
				(self setCel: 4)
			)
		)
		(super doit:)
	)
)

(instance kludge of TargActor
	(properties
		x 100
		y 100
		signal 128
	)

	(method (dazzleMe)
		(gEgo show:)
		(return 1)
	)

	(method (detectMe)
		(BlackPrint 580 28) ; "There is a mild feeling of residual magic in the room."
		(if oldScript
			(gEgo setScript: oldScript)
			(= oldScript 0)
		)
		(return 1)
	)

	(method (calmMe)
		(BlackPrint 580 29) ; "Such a weak spell has no effect upon the fury of the wind."
		(if oldScript
			(gEgo setScript: oldScript)
			(= oldScript 0)
		)
		(return 1)
	)
)

(instance msgTimer of Timer
	(properties)

	(method (cue)
		(super cue:)
		(switch msgCnt
			(0
				(BlackPrint 580 30) ; "It is difficult to judge where you are going in this darkness. It is also very dangerous."
				(gEgo loop: 1 setHeading: 270 posn: 168 143)
			)
			(1
				(BlackPrint 580 31) ; "You feel what might be a wall of this cave. It feels cold and damp, despite the desert outside. The sound of the wind is mostly above you."
				(gEgo loop: 0 setHeading: 90 posn: 127 153)
				(if (not [gInvNum 33]) ; BrassLamp
					(NoLamp)
				)
			)
			(2
				(BlackPrint 580 32) ; "You bump your head rather hard into a stalagmite. Or is it a stalactite?"
				(gEgo posn: 94 186 loop: 2 setHeading: 180)
			)
			(3
				(BlackPrint 580 33) ; "As you step forward, you find nothing to step onto. Your hands grab for a stalagmite (or is it a stalactite?), but slip off the slick surface. You find yourself falling ..."
				(EgoDead
					1
					{Afraid of the dark?  You should have been.  Perhaps you would have lasted longer if you hadn't taken the darkness so lightly.}
					#title
					{Can't you see?}
				)
			)
			(4
				(BlackPrint 580 34) ; "The rocks around the passageway resist your flame dart."
			)
			(5
				(BlackPrint 580 35) ; "The rock around the passageway is too strong to be affected by your force bolt."
			)
		)
		(++ msgCnt)
	)
)

(instance highBlackWindow of TopWindow
	(properties)
)

(instance roomSound of Sound
	(properties
		number 580
		priority 5
		loop -1
	)
)

