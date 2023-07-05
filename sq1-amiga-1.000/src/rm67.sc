;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 67)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm67 0
)

(local
	[local0 2]
)

(instance rm67 of SQRoom
	(properties
		picture 67
		style 5
	)

	(method (notify)
		(if (== gPrevRoomNum 66)
			(HandsOff)
		)
	)

	(method (init)
		(LoadMany rsVIEW 2 43 167)
		(self setRegions: 703) ; DeltaurRegion
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 117 123 112 114 132 105 157 100 185 103 197 114 191 125 176 127 165 107 149 109 169 130 135 133
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 253 130 206 101 194 102 176 93 144 97 140 101 126 105 80 104 142 143 151 151 218 189 0 189 0 0 319 0 319 185
					yourself:
				)
		)
		(cond
			((IsFlag 52) 0)
			((IsFlag 51)
				(escapePod init:)
				(hood init: setCycle: End self)
			)
			(else
				(escapePod init:)
				(hood init:)
			)
		)
		(elevator init:)
		(elevatorDoor init: stopUpd:)
		(doDadOnWall init:)
		(gEgo observeControl: 16384)
		(super init:)
		(self setScript: roomControl)
	)

	(method (doit)
		(cond
			((IsFlag 54)
				(Print 67 0) ; "You hear a strange rumbling sound. Uh, oh. It seems that you didn't make it out in time. Be seeing you."
				(gCurRoom newRoom: 71)
			)
			((gEgo script:) 0)
			((and (& (gEgo onControl: 1) $0002) (!= (gEgo priority:) 11))
				(gEgo setPri: 11)
				(gEgo setScript: goingUp)
			)
			((and (& (gEgo onControl: 1) $0400) (== (gEgo priority:) 11))
				(gEgo setPri: -1)
			)
			((and (& (gEgo onControl: 0) $4000) (IsFlag 51))
				(gEgo setScript: getInLaunchTube)
			)
			((and (& (gEgo onControl: 0) $4000) (not (gEgo script:)))
				(gEgo setScript: getInEscapePod)
			)
		)
		(super doit: &rest)
	)
)

(instance roomControl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo init: hide:)
				(= cycles 3)
			)
			(1
				(cond
					((IsFlag 52)
						(self setScript: noEscapeForEgo)
					)
					((IsFlag 51)
						(self setScript: waveGoodBye)
					)
					(else
						(self setScript: madeItInTime)
					)
				)
			)
		)
	)
)

(instance egoDropsIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSoundEffects number: 530 loop: 1 play:)
				(elevator init: yStep: 8 setMotion: MoveTo 155 100 self)
			)
			(1
				(elevator yStep: 4 setMotion: MoveTo 155 110 self)
			)
			(2
				(elevator yStep: 2 setMotion: MoveTo 155 120 self)
			)
			(3
				(elevator yStep: 1 setMotion: MoveTo 155 128 self)
				(gEgo setPri: 11)
			)
			(4
				(gSoundEffects number: 531 loop: 1 play: self)
			)
			(5
				(gSoundEffects number: 311 loop: 1 play:)
				(elevatorDoor setCycle: End self)
			)
			(6
				(gSoundEffects stop:)
				(elevator cel: 1 stopUpd: setPri: 8)
				(gEgo
					show:
					setPri: 11
					loop: 2
					cel: 0
					x: 156
					y: 113
					view: 2
					setCycle: StopWalk 62
					setStep: 4 2
				)
				(HandsOff)
				(= cycles 3)
			)
			(7
				(gEgo observeControl: 16384)
				(gEgo
					ignoreActors: 1
					setPri: 11
					setMotion: MoveTo 172 132 self
				)
			)
			(8
				(SetScore 1 173)
				(NormalEgo 2 2 62)
				(gEgo setPri: -1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goingUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 156 113 self)
			)
			(1
				(gEgo setHeading: 180)
				(= cycles 3)
			)
			(2
				(gSoundEffects number: 311 loop: 1 play:)
				(elevatorDoor setCycle: Beg self)
			)
			(3
				(elevatorDoor stopUpd:)
				(gEgo hide: setPri: -1)
				(gSoundEffects number: 530 loop: 1 play:)
				(elevator cel: 0 yStep: 2 setMotion: MoveTo 155 120 self)
			)
			(4
				(elevator yStep: 4 setMotion: MoveTo 155 110 self)
			)
			(5
				(elevator yStep: 8 setMotion: MoveTo 155 80 self)
			)
			(6
				(elevator yStep: 14 setMotion: MoveTo 155 60 self)
			)
			(7
				(elevator yStep: 20 setMotion: MoveTo 155 30 self)
			)
			(8
				(elevator setMotion: MoveTo 155 20 self)
			)
			(9
				(if (IsFlag 53)
					(SetFlag 51)
				)
				(gCurRoom newRoom: 66)
			)
		)
	)
)

(instance madeItInTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(escapePod init:)
				(hood init:)
				(gEgo setScript: egoDropsIn self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance noEscapeForEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setScript: egoDropsIn self)
				(launchTube init:)
			)
			(1
				(gEgo ignoreControl: 16384)
				(= cycles 3)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance waveGoodBye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setScript: egoDropsIn)
				(escapePod init:)
				(hood init: setCycle: End self)
			)
			(1
				(gSoundEffects number: 532 loop: 1 play:)
				(flame1 init: setCycle: RandCycle)
				(flame2 init: setCycle: RandCycle)
				(= cycles 15)
			)
			(2
				(gSoundEffects number: 533 loop: 1 play:)
				(escapePod code: accelCode setMotion: MoveTo 525 99 self)
			)
			(3
				(gSoundEffects loop: 0 fade:)
				(= cycles 30)
			)
			(4
				(Print 67 1) ; "There goes your ride, Roger. Too bad you can't call a taxi."
				(launchTube init:)
				(gEgo ignoreControl: 16384)
				(SetFlag 52)
			)
		)
	)
)

(instance getInEscapePod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 3)
				(gEgo ignoreControl: 16384)
			)
			(1
				(gEgo setMotion: PolyPath 192 139 self)
			)
			(2
				(gEgo setPri: 15 setMotion: MoveTo 192 139 self)
			)
			(3
				(gEgo
					posn: 192 129
					cycleSpeed: 3
					view: 43
					cel: 0
					setLoop: 0
					setCycle: End self
				)
			)
			(4
				(gSoundEffects number: 324 loop: 1 play:)
				(hood ignoreControl: 4096 setCycle: End self)
			)
			(5
				(gSoundEffects number: 369 loop: 1 play: self)
			)
			(6
				(= ticks 60)
			)
			(7
				(gSounds eachElementDo: #stop)
				(gSoundEffects number: 532 loop: 1 play:)
				(flame1
					init:
					setPri: 14
					ignoreControl: 4096
					setCycle: RandCycle
				)
				(flame2
					init:
					setPri: 14
					ignoreControl: 4096
					setCycle: RandCycle
				)
				(flyingEgo
					init:
					ignoreControl: 4096
					posn: (gEgo x:) (gEgo y:)
				)
				(gEgo hide:)
				(= cycles 15)
			)
			(8
				(gEgo hide:)
				(SetScore 3 174)
				(gSoundEffects number: 533 loop: 1 play:)
				(escapePod
					ignoreActors: 1
					ignoreControl: 4096
					setMotion: MoveTo 265 144 self
				)
			)
			(9
				(escapePod setStep: 10 10 setMotion: MoveTo 275 142 self)
			)
			(10
				(escapePod setStep: 14 10 setMotion: MoveTo 295 140 self)
			)
			(11
				(escapePod setStep: 18 10 setMotion: MoveTo 315 136 self)
			)
			(12
				(escapePod setStep: 24 10 setMotion: MoveTo 335 132 self)
			)
			(13
				(escapePod setStep: 28 10 setMotion: MoveTo 355 128 self)
			)
			(14
				(escapePod setStep: 34 10 setMotion: MoveTo 375 124 self)
			)
			(15
				(gSoundEffects loop: 0 fade:)
				(escapePod setStep: 40 20 setMotion: MoveTo 410 118 self)
			)
			(16
				(escapePod setStep: 50 30 setMotion: MoveTo 525 99 self)
			)
			(17
				(gCurRoom newRoom: 71)
			)
		)
	)
)

(instance getInLaunchTube of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 180 self)
			)
			(1
				(gEgo view: 43 setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				(Print 67 2) ; "Out of the kindness of our hearts, we're just going to kill you off right now and save you the wait until the ship blows up. Be seeing you."
				(= cycles 3)
			)
			(3
				(gCurRoom newRoom: 71)
			)
		)
	)
)

(instance launchTube of Feature
	(properties
		description {escape pod launch tube}
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 67 3) ; "It's an escape pod launch tube minus the escape pod. This presents a serious survival problem."
			)
			(3 ; Do
				(Print 67 4) ; "There's not much you can do without an escape pod."
			)
			(5 ; Talk
				(Print 67 5) ; "There's nobody here to talk to."
			)
			(12 ; Smell
				(Print 67 6) ; "Exhaust fumes from the escaped pod nauseate you, not to mention the tought that you're doomed."
			)
			(11 ; Taste
				(Print 67 7) ; "I don't think licking the floor is the answer to your current dilemma."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doDadOnWall of Feature
	(properties
		description {doDadOnWall}
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 67 8) ; "It's definitely some sort of ...thing."
			)
			(3 ; Do
				(Print 67 9) ; "If you knew what it was, you might have a clue what to do with it, but since you don't, you don't."
			)
			(5 ; Talk
				(Print 67 10) ; "Nope. Not voice-activated."
			)
			(12 ; Smell
				(Print 67 11) ; "You're really 'way too busy for this, Roger."
			)
			(11 ; Taste
				(Print 67 12) ; "No time for funny messages, get off the ship!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance elevatorDoor of Prop
	(properties
		x 177
		y 115
		view 167
		priority 9
		signal 16400
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 67 13) ; "It's an elevator door."
			)
			(3 ; Do
				(Print 67 14) ; "This door is controlled by the elevator, there is nothing you can do to it from here."
			)
			(5 ; Talk
				(Print 67 15) ; "It doesn't want to talk to you."
			)
			(12 ; Smell
				(Print 67 16) ; "It smells like the many elevator doors you've smelled in the past."
			)
			(11 ; Taste
				(Print 67 17) ; "It tastes like the many elevator doors you've smelled in the past."
			)
		)
	)
)

(instance elevator of Actor
	(properties
		x 155
		y 42
		onMeCheck 2048
		view 167
		loop 4
		priority 8
		signal 18448
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 67 18) ; "It's the elevator that brought you down here."
			)
			(3 ; Do
				(self setScript: goingUp)
			)
			(5 ; Talk
				(Print 67 19) ; "It is not voice activated."
			)
			(12 ; Smell
				(Print 67 20) ; "It smells like the many elevators you've smelled in the past."
			)
			(11 ; Taste
				(Print 67 21) ; "It tastes like the many elevators you've smelled in the past."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (onMe param1)
		(return (& onMeCheck (OnControl CONTROL (param1 x:) (param1 y:))))
	)
)

(instance accelCode of Code
	(properties)

	(method (doit param1)
		(param1 setStep: (+ (param1 xStep:) 2) (+ (param1 yStep:) 1))
	)
)

(instance escapePod of Actor
	(properties
		x 225
		y 146
		yStep 8
		view 167
		loop 3
		priority 13
		signal 18448
		xStep 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 67 22) ; "This must be the captain's personal escape pod!"
			)
			(3 ; Do
				(if (IsFlag 51)
					(Print 67 23) ; "It's too late to do that now."
				else
					(gEgo setScript: getInEscapePod)
				)
			)
			(5 ; Talk
				(Print 67 24) ; "The escape pod is not equipped with voice-recognition capability."
			)
			(11 ; Taste
				(Print 67 25) ; "The ship could blow up in a million fiery pieces while you waste time licking the only thing that can get you off it in one piece!"
			)
			(12 ; Smell
				(Print 67 26) ; "You're wasting valuable time here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hood of Actor
	(properties
		view 167
		loop 1
		priority 15
		signal 18448
		cycleSpeed 8
		moveSpeed 2
	)

	(method (doit)
		(self x: (escapePod x:))
		(self y: (escapePod y:))
		(super doit: &rest)
	)
)

(instance flame1 of Actor
	(properties
		view 167
		loop 2
		priority 11
		signal 18448
		cycleSpeed 2
		moveSpeed 2
	)

	(method (doit)
		(self x: (- (escapePod x:) 115))
		(self y: (+ (escapePod y:) 18))
		(super doit: &rest)
	)
)

(instance flame2 of Actor
	(properties
		view 167
		loop 2
		priority 11
		signal 18448
		cycleSpeed 2
		moveSpeed 2
	)

	(method (doit)
		(self x: (- (escapePod x:) 108))
		(self y: (+ (escapePod y:) 25))
		(super doit: &rest)
	)
)

(instance flyingEgo of Actor
	(properties
		view 43
		cel 7
		priority 15
		signal 18448
		cycleSpeed 2
		moveSpeed 2
	)

	(method (doit)
		(self x: (- (escapePod x:) 33))
		(self y: (- (escapePod y:) 17))
		(super doit: &rest)
	)
)

