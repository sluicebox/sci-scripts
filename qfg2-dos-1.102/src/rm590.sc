;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 590)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use n065)
(use TargActor)
(use Interface)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm590 0
)

(local
	wrongGuesses
	msg
	tempI
	[sound 15]
	[soundPri 12] = [8 10 11 9 12 10 9 8 7 10 11 9]
)

(procedure (TurnOnMusic &tmp I)
	(for ((= I 0)) (< I 12) ((++ I))
		(= [sound I] (Sound new:))
		([sound I] priority: [soundPri I] loop: 1 init:)
	)
)

(procedure (playRockMusic &tmp I songNumber)
	(= songNumber 12)
	(for ((= I 0)) (< I tempI) ((++ I))
		(= songNumber
			(switch (Random 0 1)
				(0 12)
				(1 751)
			)
		)
		([sound I] number: songNumber loop: 1 vol: 90 play:)
	)
)

(procedure (turnOffNoise &tmp I)
	(for ((= I 0)) (< I 12) ((++ I))
		([sound I] dispose:)
	)
)

(procedure (BluePrint)
	(hiWindow color: 9 back: 0)
	(Print &rest #mode 1 #window hiWindow)
)

(instance rm590 of Rm
	(properties
		picture 590
		style 6
	)

	(method (init)
		(LoadMany rsPIC 2 590)
		(LoadMany rsVIEW 591 6 31 586)
		(if [gInvNum 16] ; Rope
			(LoadMany rsVIEW 8 47)
		)
		(LoadMany rsSOUND 600 551 590 591)
		(SetFlag 116) ; fLightOn
		(= gEgoGait 4) ; holdingLamp
		(= gSpellChecker gAllChecker)
		(SolvePuzzle 636 7)
		(= global61 1)
		(gKeyDownHandler add: self)
		(super init:)
		(NormalEgo)
		(dr1 init:)
		(dr2 init:)
		(floorShine init:)
		(self setScript: enterS)
		(gCSound number: 600 loop: -1 playBed:)
	)

	(method (doit)
		(cond
			((gEgo script:))
			(
				(and
					(& (gEgo onControl: 1) $0002)
					(== (gEgo illegalBits:) -32768)
				)
				(gEgo setScript: fallDnCliff)
			)
			(
				(and
					(& (gEgo onControl: 1) $0004)
					(== (gEgo illegalBits:) -32768)
				)
				(gEgo setScript: toTreasRoom)
			)
			((> (gEgo x:) 320)
				(= gRoomExitDir 2)
				(gCurRoom newRoom: 560)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'hop')
				(cond
					((> (gEgo x:) 208)
						(Print 590 0) ; "You're not in a good position to make a jump."
					)
					((> (gEgo y:) 100)
						(HighPrint 590 1) ; "Jumping here won't help."
					)
					((!= gOrigHeroType 0)
						(= msg 2)
						(HandsOff)
						(gEgo setMotion: MoveTo 120 120)
					)
					(else
						(SolvePuzzle 635 7 0)
						(gEgo setScript: jumpDownS)
					)
				)
			)
			((Said 'climb,climb')
				(cond
					((> (gEgo y:) 100)
						(HighPrint 590 2) ; "Looking up at the sheerness of the sides and the slickness of the rock, you know that you wouldn't get very far climbing."
					)
					([gEgoStats 11] ; climb
						(Print 590 3) ; "Looking down at the sheerness of the sides and the slickness of the rock, you know you would merely wind up falling."
					)
					((> (gEgo x:) 208)
						(Print 590 4) ; "You're not in a good position to climb."
					)
					(else
						(HandsOff)
						(= msg 1)
						(gEgo setMotion: MoveTo 120 120)
					)
				)
			)
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/cave')
				)
				(if (> (gEgo y:) 100)
					(HighPrint 590 5) ; "All you can see is the pocket of cavern in which you stand, solid rock on all sides, and a massive doorway."
				else
					(HighPrint 590 6) ; "You can see that you are on a ledge overlooking darkness. You can see something that appears deliberately fashioned across the brink, but you cannot tell what it is from where you are standing."
				)
			)
			((Said 'cast,drop,use,throw,climb,climb/rope[<magic]')
				(cond
					((> (gEgo y:) 100)
						(event claimed: 0)
					)
					((not [gInvNum 16]) ; Rope
						(DontHave)
					)
					((> (gEgo x:) 208)
						(Print 590 7) ; "You're not in a good position to use the rope."
					)
					(else
						(gEgo setScript: climbDownRopeS)
					)
				)
			)
			((Said 'put,drop,extinguish/lamp,light')
				(LowPrint 590 8) ; "If you did that, you would be lost in the dark."
			)
			((Said 'cast>')
				(if (== (SaidSpell event) 28)
					(cond
						((> (gEgo y:) 100)
							(event claimed: 0)
						)
						((> (gEgo x:) 208)
							(Print 590 9) ; "You're not in a good position to levitate off of the cliff."
						)
						((TrySpell 28)
							(gEgo setScript: levitateDownS)
						)
					)
				else
					(event claimed: 0)
				)
			)
		)
	)
)

(instance enterS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					illegalBits: -32768
					posn: 319 101
					init:
					setMotion: MoveTo 299 96 self
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance jumpDownS of HandsOffScript
	(properties)

	(method (doit)
		(super doit:)
		(if (and (& (gEgo onControl: 1) $0002) (== state 0))
			(gEgo setMotion: 0)
			(self cue:)
		)
	)

	(method (handleEvent event &tmp zOffset)
		(cond
			((super handleEvent: event))
			((Said 'cast>')
				(if (== (SaidSpell event) 28)
					(if (TrySpell 28)
						(= zOffset (- 160 (gEgo y:)))
						(gEgo y: (+ (gEgo y:) zOffset) z: zOffset)
						(SolvePuzzle 635 7 1)
						(client setScript: (ScriptID 62 0)) ; levitate
					)
				else
					(Print 590 10) ; "Not now - you're falling!"
				)
				(event claimed: 1)
			)
			((== (event type:) evSAID)
				(event claimed: 1)
				(Print 590 11) ; "You're busy falling right now."
			)
			(else
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 120 120 self)
			)
			(1
				(DontTalk 0)
				(gMiscSound number: 590 loop: 1 priority: 10 play:)
				(gEgo
					view: 591
					loop: 3
					cel: 0
					illegalBits: 0
					posn: (- (gEgo x:) 3) (- (gEgo y:) 3)
				)
				(= cycles 1)
			)
			(2
				(gEgo
					loop: 5
					cel: 0
					posn: (- (gEgo x:) 4) (+ (gEgo y:) 10)
				)
				(= cycles 1)
			)
			(3
				(gEgo cel: 1 posn: (- (gEgo x:) 4) (+ (gEgo y:) 15))
				(= cycles 1)
			)
			(4
				(gEgo cel: 2 posn: (- (gEgo x:) 3) (+ (gEgo y:) 16))
				(= cycles 1)
			)
			(5
				(gEgo cel: 2 posn: (- (gEgo x:) 1) (+ (gEgo y:) 16))
				(= cycles 1)
			)
			(6
				(gEgo cel: 1 posn: (- (gEgo x:) 1) (+ (gEgo y:) 12))
				(= cycles 1)
			)
			(7
				(DontTalk 1)
				(gEgo cel: 1 posn: (- (gEgo x:) 1) (+ (gEgo y:) 11))
				(= cycles 1)
			)
			(8
				(gEgo
					loop: 1
					cel: 1
					posn: (- (gEgo x:) 1) (+ (gEgo y:) 7)
				)
				(= cycles 1)
			)
			(9
				(gEgo cel: 2 posn: (- (gEgo x:) 1) (+ (gEgo y:) 5))
				(= cycles 1)
			)
			(10
				(gEgo cel: 3 posn: (- (gEgo x:) 2) (gEgo y:))
				(= cycles 1)
			)
			(11
				(gEgo cel: 4 posn: (- (gEgo x:) 10) (- (gEgo y:) 2))
				(= cycles 1)
			)
			(12
				(gEgo cel: 5 posn: (- (gEgo x:) 9) (- (gEgo y:) 3))
				(= cycles 1)
			)
			(13
				(gEgo cel: 6 posn: (- (gEgo x:) 7) (+ (gEgo y:) 7))
				(= cycles 1)
			)
			(14
				(gEgo cel: 7 posn: (+ (gEgo x:) 1) (gEgo y:))
				(= cycles 1)
			)
			(15
				(gEgo cel: 8 posn: (- (gEgo x:) 1) (gEgo y:))
				(= cycles 1)
			)
			(16
				(gEgo cel: 9 posn: (- (gEgo x:) 2) (gEgo y:))
				(= cycles 1)
			)
			(17
				(NormalEgo)
				(gEgo loop: 3 heading: 0)
				(= cycles 1)
			)
			(18
				(if (TakeDamage 10)
					(Print 590 12) ; "That hurt, but it's a good thing you're tough, agile, and know how to take a fall."
				else
					(EgoDead
						1
						{With all the damage you took to get here, it's really a shame you couldn't take any more.  You should've tended to your healing, but now it's too late.}
						#title
						{You Fell for It}
					)
				)
				(= global61 0)
				(gCurRoom drawPic: 590)
				(RedrawCast)
				(self dispose:)
			)
		)
	)
)

(instance levitateDownS of HandsOffScript
	(properties)

	(method (doit)
		(super doit:)
		(if (and (& (gEgo onControl: 1) $0002) (== state 0))
			(gEgo setMotion: 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 120 120 self)
			)
			(1
				(DontTalk 0)
				(gEgo
					view: 591
					loop: 3
					cel: 0
					illegalBits: 0
					posn: (- (gEgo x:) 3) (- (gEgo y:) 3)
				)
				(= cycles 1)
			)
			(2
				(gEgo
					loop: 5
					cel: 0
					posn: (- (gEgo x:) 4) (+ (gEgo y:) 10)
				)
				(= cycles 1)
			)
			(3
				(gEgo cel: 1 posn: (- (gEgo x:) 4) (+ (gEgo y:) 15))
				(= global61 0)
				(gCurRoom drawPic: 590)
				(RedrawCast)
				(gEgo y: 160 z: (- 160 (gEgo y:)))
				(SolvePuzzle 635 7 1)
				(client setScript: (ScriptID 62 0)) ; levitate
			)
		)
	)
)

(instance fallDnCliff of HandsOffScript
	(properties)

	(method (handleEvent event &tmp zOffset)
		(cond
			((super handleEvent: event))
			((Said 'cast>')
				(if (== (SaidSpell event) 28)
					(if (TrySpell 28)
						(= zOffset (- 160 (gEgo y:)))
						(gEgo y: (+ (gEgo y:) zOffset) z: zOffset)
						(SolvePuzzle 635 7 1)
						(client setScript: (ScriptID 62 0)) ; levitate
					)
				else
					(Print 590 10) ; "Not now - you're falling!"
				)
				(event claimed: 1)
			)
			((== (event type:) evSAID)
				(event claimed: 1)
				(Print 590 11) ; "You're busy falling right now."
			)
			(else
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DontTalk 0)
				(gEgo
					view: 591
					loop: 3
					cel: 0
					posn: (gEgo x:) (+ (gEgo y:) 3)
				)
				(gMiscSound number: 590 loop: 1 priority: 10 play:)
				(= cycles 1)
			)
			(1
				(gEgo loop: 1 posn: (- (gEgo x:) 8) (+ (gEgo y:) 4))
				(= cycles 1)
			)
			(2
				(gEgo cel: 2 posn: (- (gEgo x:) 2) (+ (gEgo y:) 6))
				(= cycles 1)
			)
			(3
				(gEgo posn: (+ (gEgo x:) 1) (+ (gEgo y:) 8))
				(= cycles 1)
			)
			(4
				(gEgo cel: 3 posn: (+ (gEgo x:) 3) (+ (gEgo y:) 10))
				(= cycles 1)
			)
			(5
				(DontTalk 1)
				(gEgo
					view: 6
					loop: 2
					cel: 3
					posn: (+ (gEgo x:) 5) (+ (gEgo y:) 14)
				)
				(= cycles 1)
			)
			(6
				(gEgo
					loop: 2
					cel: 4
					posn: (- (gEgo x:) 1) (+ (gEgo y:) 13)
				)
				(= cycles 1)
			)
			(7
				(gEgo
					loop: 2
					cel: 5
					posn: (+ (gEgo x:) 3) (+ (gEgo y:) 14)
				)
				(= cycles 1)
			)
			(8
				(gEgo cel: 6 posn: (gEgo x:) (+ (gEgo y:) 15))
				(= cycles 1)
			)
			(9
				(gEgo cel: 7 posn: (- (gEgo x:) 1) (+ (gEgo y:) 13))
				(= cycles 1)
				(gMiscSound number: 591 loop: 1 play:)
			)
			(10
				(gEgo cel: 8 posn: (gEgo x:) (gEgo y:))
				(= cycles 1)
			)
			(11
				(gEgo cel: 9 posn: (gEgo x:) (gEgo y:))
				(= cycles 1)
			)
			(12
				(cond
					((not (TakeDamage 20))
						(EgoDead
							0
							{The conclusion to this little cliff-hanger was in abbreviated form.}
							#title
							{Cliff Notes}
							#icon
							6
							2
							7
						)
					)
					((== msg 1)
						(HandsOn)
						(Print 590 13) ; "Considering your IMPRESSIVE skill at climbing, that wasn't exactly a brilliant maneuver. You are beaten, battered, and bruised... but you ARE down."
						(= msg 0)
					)
					((== msg 2)
						(HandsOn)
						(Print 590 14) ; "You really aren't up to this kind of physical abuse."
					)
					(else
						(Print 590 15) ; "Well, that was ONE way down. But it hurt...a lot!"
					)
				)
				(= global61 0)
				(gCurRoom drawPic: 590)
				(RedrawCast)
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(13
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance climbDownRopeS of HandsOffScript
	(properties)

	(method (doit)
		(super doit:)
		(if (and (& (gEgo onControl: 1) $0002) (== state 0))
			(gEgo setMotion: 0 y: (- (gEgo y:) 2))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 120 120 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo view: 8 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gEgo loop: 6 cel: 0)
				(coil
					init:
					posn: (- (gEgo x:) 13) (+ (gEgo y:) 4)
					setMotion:
						MoveTo
						(- (gEgo x:) 18)
						(if (< (gEgo x:) 234) 144 else 164)
						self
				)
			)
			(4
				(gEgo loop: 6 cel: 0 cycleSpeed: 2 setCycle: End)
				(coil setCycle: End)
				(rope posn: (coil x:) (- (coil y:) 2) init: setCycle: End self)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo
					view: 591
					loop: 0
					cel: 0
					setPri: 9
					posn: (+ (rope x:) 1) (gEgo y:)
					cycleSpeed: 2
					setCycle: CT 4 1 self
				)
			)
			(7
				(gEgo
					view: 6
					setLoop: 9
					setCycle: Fwd
					cycleSpeed: 1
					moveSpeed: 1
					yStep: 4
					setMotion: MoveTo (coil x:) (+ (coil y:) 4) self
				)
			)
			(8
				(gEgo
					setLoop: 8
					cel: 2
					yStep: 2
					setCycle: Beg self
					moveSpeed: 0
					setMotion: MoveTo (coil x:) (+ (coil y:) 12)
				)
				(= global61 0)
				(gCurRoom drawPic: 590)
				(RedrawCast)
			)
			(9
				(rope setCycle: Beg self)
				(coil setCycle: Beg)
			)
			(10
				(NormalEgo)
				(gEgo
					heading: 0
					loop: 3
					setMotion: MoveTo (coil x:) (+ (coil y:) 8) self
				)
			)
			(11
				(gEgo
					view: 47
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(12
				(rope dispose:)
				(coil dispose:)
				(gEgo setCycle: Beg self)
			)
			(13
				(SolvePuzzle 635 7 2)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance toTreasRoom of HandsOffScript
	(properties)

	(method (handleEvent event &tmp zOffset)
		(cond
			((super handleEvent: event))
			((Said '/bendaoud')
				(self cue:)
			)
			((Said 'cast')
				(HighPrint 590 16) ; "You find yourself unable to cast any spells. The voice's demand still rings within your ears."
			)
			(
				(or
					(Said 'cast,drop,use,throw,climb,climb/rope[<magic]')
					(Said 'use,get,get')
				)
				(HighPrint 590 17) ; "You find yourself unable to move. The voice's demand still rings within your ears."
			)
			((Said 'look,look,get,get,use')
				(HighPrint 590 18) ; "Nothing but the voice's demand seems important right now."
			)
			((Said 'answer')
				(HighPrint 590 19) ; "Yes, by all means. Give an answer."
			)
			((Said 'ask')
				(HighPrint 590 20) ; "Stony silence is your answer."
			)
			((Said 'talk,talk,tell')
				(HighPrint 590 21) ; "There is no response."
			)
			((== (event type:) evSAID)
				(event claimed: 1)
				(wrongS changeState: (wrongS register:))
			)
			(else
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: wrongS 0 1)
				(gEgo setMotion: 0)
				(HighPrint 590 22) ; "You hear a deep, echoing voice:"
				(BluePrint 590 23) ; "None shall enter None shall pass but he who speaks the name of Power."
				(BluePrint 590 24) ; "SPEAK NOW THE NAME OF POWER!"
				(DontTalk 0)
			)
			(1
				(DontTalk 1)
				(gEgo setPri: -1)
				(Print 590 25) ; "You hear a sound of thunder."
				(gMiscSound number: 551 loop: 1 priority: 15 init: play:)
				(dr1 setCycle: End)
				(dr2 setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 8 124 self)
			)
			(3
				(gCurRoom newRoom: 600)
			)
		)
	)
)

(instance wrongS of Script
	(properties)

	(method (init)
		(TurnOnMusic)
		(super init: &rest)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				(if (gModelessDialog)
					(gModelessDialog dispose:)
				)
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState &tmp I)
		(switch (= state newState)
			(1
				(= tempI 6)
				(playRockMusic)
				(ShakeScreen 15 ssLEFTRIGHT)
				(= cycles 3)
			)
			(2
				(HighPrint 590 26 103) ; "You hear a roar of rocks collapsing in the distance."
				(= register 3)
			)
			(3
				(+= tempI 3)
				(playRockMusic)
				(ShakeScreen 25 ssUPDOWN)
				(= cycles 3)
			)
			(4
				(HighPrint 590 27 103) ; "The crash of boulder upon boulder echoes through the cavern."
				(= register 5)
			)
			(5
				(+= tempI 3)
				(playRockMusic)
				(ShakeScreen 35 ssFULL_SHAKE)
				(= cycles 3)
			)
			(6
				(HighPrint 590 28 103) ; "Your ears are deafened by rocks crashing and shattering against one another."
				(= register 7)
			)
			(7
				(turnOffNoise)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 2)
				(EgoDead
					1
					{Your last thoughts as the cavern collapses around you are, "Who thought up this crummy puzzle, anyway?"}
					#title
					{Wrong!}
				)
			)
		)
	)
)

(instance dr1 of TargActor
	(properties
		x 47
		y 127
		noun '/door'
		description {the ancient doors}
		lookStr {The great, ancient doors stand guard, as they have for one thousand and one years.}
		view 591
		loop 7
		signal 16
		cycleSpeed 2
	)

	(method (onMe)
		(return (or (super onMe: &rest) (dr2 onMe: &rest)))
	)

	(method (openMe)
		(HighPrint 590 29) ; "The great, ancient door easily resists your tiny spell."
		(return 1)
	)

	(method (fetchMe)
		(HighPrint 590 30) ; "You haven't the power to move such a large object."
		(return 0)
	)

	(method (detectMe)
		(HighPrint 590 31) ; "There is a subtle residue of magic in this room. Once great and powerful, it is now dormant."
	)

	(method (hurtMe)
		(HighPrint 590 32) ; "The great, ancient door is not damaged by your puny effort."
	)
)

(instance dr2 of Prop
	(properties
		x 15
		y 131
		view 591
		loop 8
		signal 16
		cycleSpeed 2
	)
)

(instance rope of Prop
	(properties
		view 8
		loop 4
		priority 8
		signal 16
		cycleSpeed 1
	)
)

(instance coil of Actor
	(properties
		yStep 8
		view 8
		loop 2
		priority 8
		signal 22544
		illegalBits 0
		xStep 4
	)
)

(instance hiWindow of TopWindow
	(properties)
)

(instance floorShine of View
	(properties
		noun '/reflection,glow,light'
		description {the reflection of your lamp.}
		lookStr {It is the reflection of your lamp light.}
		view 586
		signal 18448
	)

	(method (doit)
		(cond
			((and (IsFlag 116) (== (gEgo view:) 585)) ; fLightOn
				(if (& signal $0008)
					(self show:)
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
					(7
						(self posn: (- (gEgo x:) 20) (+ (gEgo y:) 5))
					)
				)
			)
			((not (& signal $0008))
				(self hide:)
			)
		)
		(super doit:)
	)
)

