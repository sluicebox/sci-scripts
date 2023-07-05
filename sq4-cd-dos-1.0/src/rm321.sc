;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 321)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use Motion)
(use System)

(public
	rm321 0
)

(local
	[local0 12] = [142 115 144 88 108 114 109 87 80 114 81 86]
	[local12 7]
)

(instance rm321 of SQRoom
	(properties
		picture 321
	)

	(method (init &tmp temp0)
		(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
			((= [local12 temp0] (Clone Propeller1))
				init:
				x: [local0 (* temp0 2)]
				y: [local0 (+ (* temp0 2) 1)]
				setCycle: Fwd
			)
		)
		(super init:)
		(Load rsVIEW 322)
		(spotRight init: setCycle: Fwd)
		(theSub init:)
		(spotLeft init: setCycle: Fwd)
		(eel init: setScript: eelScript)
		(self setScript: displayScript)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(roomNar modNum: 329 say: 2) ; "This is a sea cave."
				(roomNar modNum: 321)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance displayScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(gTheIconBar disable: 0 5 4 3 2 6 7)
				(= seconds 5)
			)
			(1
				(HandsOff)
				(= cycles 1)
			)
			(2
				(roomNar ; "You hope these women soon realize that they MUST have the wrong guy."
					modNum: 321
					init: 0 0 0
					say:
						1
						self
						2
						64
						2
						2
						25
						global136
						26
						(proc0_18 global155 global129)
						27
						1
						67
						315
				)
			)
			(3
				(if (not (== (DoAudio audPOSITION) -1))
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(HandsOn)
				(gTheIconBar disable: 0 5 4 3 2 6 7)
				(= cycles 1)
			)
			(5
				(= seconds 7)
			)
			(6
				(HandsOff)
				(zondraVoice ; "This is Zondra. We are approaching checkpoint six. Prepare to open the tunnel door."
					say:
						1
						self
						2
						64
						2
						2
						25
						(proc0_18 global153 global189)
						26
						(proc0_18 global155 global129)
						27
						1
						67
						315
				)
			)
			(7
				(if (not (== (DoAudio audPOSITION) -1))
					(-- state)
				)
				(= cycles 1)
			)
			(8
				(HandsOn)
				(gTheIconBar disable: 0 5 4 3 2 6 7)
				(= cycles 1)
			)
			(9
				(= cycles 100)
			)
			(10
				(zondraVoice ; "Activate the door."
					say: 2 self 2 64 2 2 25 global153 26 global155 27 1 67 315
				)
			)
			(11
				(HandsOff)
				(cave init: setLoop: 4 setCycle: End self)
			)
			(12
				(if (IsObject zondraVoice)
					(zondraVoice dispose:)
				)
				(if (IsObject roomNar)
					(roomNar dispose:)
				)
				(gCurRoom newRoom: 329)
			)
		)
	)
)

(instance eelScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(eel setLoop: 6 setCycle: Fwd setMotion: MoveTo 50 220 self)
			)
			(1
				(eel z: 1000)
				(= seconds 7)
			)
			(2
				(jellyFish
					init:
					setLoop: 5
					illegalBits: 0
					setCycle: Fwd
					ignoreHorizon:
					setMotion: MoveTo -10 -10 self
				)
			)
			(3
				(jellyFish dispose:)
				(= seconds 5)
			)
		)
	)
)

(instance spotLeft of Sq4Prop
	(properties
		x 99
		y 170
		sightAngle 180
		view 322
		loop 1
		signal 16384
		cycleSpeed 12
		lookStr 2 ; "A spotlight illuminates the floor of the cave as the sub makes its way through the eerie darkness."
	)
)

(instance spotRight of Sq4Prop
	(properties
		x 307
		y 161
		sightAngle 180
		view 322
		signal 16384
		cycleSpeed 12
		lookStr 2 ; "A spotlight illuminates the floor of the cave as the sub makes its way through the eerie darkness."
	)
)

(instance eel of Sq4Actor
	(properties
		x 345
		y 99
		sightAngle 180
		yStep 4
		view 322
		loop 6
		signal 16384
		xStep 6
		lookStr 3 ; "Say! There's an odd looking specimen."
	)
)

(instance jellyFish of Sq4Actor
	(properties
		x 325
		y 137
		sightAngle 180
		view 322
		loop 5
		signal 16384
		cycleSpeed 18
		xStep 6
		lookStr 4 ; "You're not sure what it is, but you bet it would look cool spewing through the propellers."
	)
)

(instance cave of Sq4Prop
	(properties
		x 293
		y 65
		sightAngle 180
		view 322
		loop 4
		cycleSpeed 18
		lookStr 5 ; "An opening appears ahead."
	)
)

(instance Propeller1 of Sq4Prop
	(properties
		x -100
		y -100
		sightAngle 180
		view 322
		loop 2
		lookStr 6 ; "The propellers thrust the small sub deeper and deeper into the dark tunnel."
	)
)

(instance theSub of Sq4Feature
	(properties
		x 156
		y 28
		z -60
		nsTop 48
		nsLeft 60
		nsBottom 128
		nsRight 252
		sightAngle 180
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(roomNar modNum: 329 say: 1) ; "What have I stepped in this time you think to yourself as the Latex Babes' submarine makes its' way through the eerie blackness."
				(roomNar modNum: gCurRoomNum)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance zondraVoice of Sq4GlobalNarrator
	(properties
		modNum 321
		modeless 1
		talkerNum 19
	)
)

(instance roomNar of Sq4GlobalNarrator
	(properties
		noun 99
		modNum 321
		modeless 1
	)
)

