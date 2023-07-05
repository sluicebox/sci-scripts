;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm330 0
)

(instance rm330 of SQRoom
	(properties
		picture 330
		style 12
	)

	(method (init)
		(LoadMany rsVIEW 330 324 331)
		(gLongSong number: 60 vol: 127 loop: -1 flags: 1)
		(LoadMany rsSOUND 126 133)
		(super init:)
		(theArea init:)
		(pillar init:)
		(guard init:)
		(proc0_14 10)
		(self setScript: subScript)
	)
)

(instance subScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(sub setCycle: Fwd init: setMotion: MoveTo 106 101)
				(subTop init: setMotion: MoveTo 103 103 self)
			)
			(1
				(sub setLoop: 3)
				(gLongSong2 stop:)
				(soundFX play:)
				(= seconds 3)
			)
			(2
				(soundFX number: 133 play:)
				(hatch
					init:
					posn: (+ (subTop x:) 23) (+ (subTop y:) 1)
					cycleSpeed: 15
					setCycle: End self
				)
			)
			(3
				(hatch stopUpd:)
				(= cycles 10)
			)
			(4
				(HandsOn)
				(User canControl: 0)
				(gTheIconBar disable: 0)
				(anEgo
					init:
					view: 324
					x: (- (hatch x:) 8)
					y: (+ (hatch y:) 4)
					loop: 8
					cel: 0
					cycleSpeed: 12
					setPri: 6
					illegalBits: 0
					setCycle: End self
				)
			)
			(5
				(= ticks 10)
			)
			(6
				(anEgo
					view: 0
					posn: 134 104
					setPri: 6
					setSpeed: gGameSpeed
					setCycle: Walk
				)
				(= ticks 10)
			)
			(7
				(anEgo setMotion: MoveTo 202 91 self)
			)
			(8
				(gLongSong playBed: hold: 1)
				(zondra
					posn: (+ (subTop x:) 10) (- (subTop y:) 18)
					init:
					setSpeed: gGameSpeed
					setCycle: End self
				)
				(anEgo setMotion: MoveTo 338 96)
			)
			(9
				(zondra
					view: 331
					setLoop: 2
					setCycle: Walk
					setPri: 6
					posn: 137 99
					setMotion: MoveTo 205 87
				)
				(anEgo setMotion: MoveTo 338 96)
				(= seconds 3)
			)
			(10
				(zondra setMotion: MoveTo 340 88)
				(guard
					view: 331
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 345 96
				)
				(= seconds 5)
			)
			(11
				(gCurRoom newRoom: 335)
			)
		)
	)
)

(instance sub of Sq4Actor
	(properties
		x -22
		y 101
		sightAngle 180
		yStep 1
		view 330
		priority 2
		signal 18448
		illegalBits 0
		xStep 2
		lookStr 1 ; "This is the submarine in which the Latex Babes brought you here."
	)
)

(instance subTop of Sq4Actor
	(properties
		x -25
		y 103
		sightAngle 180
		yStep 1
		view 330
		loop 1
		cel 4
		priority 3
		signal 18448
		illegalBits 0
		xStep 2
		lookStr 1 ; "This is the submarine in which the Latex Babes brought you here."
	)
)

(instance hatch of Sq4Prop
	(properties
		x 125
		y 104
		sightAngle 180
		view 330
		loop 2
		priority 5
		signal 18448
		cycleSpeed 12
		lookStr 2 ; "It's a nifty entry/exit device."
	)
)

(instance guard of Sq4Actor
	(properties
		x 235
		y 103
		yStep 3
		view 331
		priority 6
		xStep 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 3) ; "Hmm. You wonder if she has a boyfriend."
			)
			(4 ; Do
				(gNarrator say: 4) ; "You'd better not. She looks like she knows how to use that gun."
			)
			(2 ; Talk
				(gNarrator say: 5) ; "Talking isn't getting you anywhere with her."
			)
			(6 ; Smell
				(gNarrator say: 6) ; "Use it and lose it, buddy!"
			)
			(7 ; Taste
				(gNarrator say: 6) ; "Use it and lose it, buddy!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance zondra of Sq4Actor
	(properties
		x 114
		y 85
		sightAngle 180
		yStep 3
		view 324
		loop 9
		priority 7
		signal 16
		illegalBits 0
		xStep 4
		lookStr 7 ; "What a babe!"
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator say: 8) ; "That isn't a good idea, she seems to hate you for some unknown reason."
			)
			(2 ; Talk
				(gNarrator say: 9) ; "Your efforts at conversation are rewarded with a hateful glare."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance soundFX of Sound
	(properties
		number 126
	)
)

(instance theArea of Sq4Feature
	(properties
		x 156
		y 10
		nsBottom 200
		nsRight 320
		sightAngle 180
		lookStr 10 ; "It looks like they have quite a fortress here."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator say: 11) ; "There is a faint odor of perfume mixed with the salty sea air."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pillar of Sq4Feature
	(properties
		x 292
		y 110
		nsTop 28
		nsLeft 275
		nsBottom 125
		nsRight 319
		sightAngle 180
		lookStr 12 ; "One of the many massive support pillars in the fortress."
	)
)

(instance anEgo of Actor
	(properties
		view 324
	)
)

