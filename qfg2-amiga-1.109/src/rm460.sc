;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 460)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use RasPlaza)
(use n095)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm460 0
)

(local
	triedLeave
	isInRoom
)

(instance rm460 of RasPlaza
	(properties
		style 6
		north 703
		south 400
		west 703
		topExit 2
		bottomExit 4
		leftExit 1
	)

	(method (init)
		(LoadMany rsVIEW 0 4 380 450 31 445)
		(if (or (== gPrevRoomNum 610) (and (IsFlag 28) (>= gDay 30)))
			(= gDay 30)
			(FixTime 21 0)
		)
		(if (IsFlag 96)
			(= gSpellChecker gAllChecker)
			(SetFlag 28)
			(= inOut 3)
			(gEgo view: 4 loop: 4 cel: 0 posn: 72 115)
		)
		(super init:)
		(if (IsFlag 96)
			(gEgo init: hide:)
			(gCSound number: 520 loop: -1 priority: 0 playBed:)
		)
		(if (IsFlag 96)
			(self setScript: backWithDjinn)
		)
		(InitFeatures topAlleyDoor leftAlleyDoor)
		(InitAddToPics rightDoorBlock lWindow rWindow mosaic)
	)

	(method (doit)
		(cond
			(
				(and
					(IsFlag 96)
					(not triedLeave)
					isInRoom
					(or (< (gEgo x:) 6) (< (gEgo y:) 93))
				)
				(gEgo
					setMotion: 0
					x:
						(if (< (gEgo x:) 100)
							(+ (gEgo x:) 5)
						else
							(gEgo x:)
						)
					y:
						(if (< (gEgo x:) 100)
							(gEgo y:)
						else
							(+ (gEgo y:) 5)
						)
				)
				(= triedLeave 1)
				(djinniPrint 460 0) ; "Hey, where do you think you are going, Master? Iblis is over in the Palace. We haven't got much time. He's getting more powerful."
			)
			((and triedLeave (< (gEgo y:) 93))
				(gEgo setMotion: 0 posn: (gEgo x:) (+ (gEgo y:) 2))
				(gEgo setScript: toPalace)
			)
			((and triedLeave (< (gEgo x:) 6))
				(gEgo setMotion: 0 posn: (+ (gEgo x:) 2) (gEgo y:))
				(gEgo setScript: fromAlley)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(ClearFlag 28)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look,look<up')
				(if (> gTimeODay 4)
					(HighPrint 460 1) ; "The Raseirian sky is ablaze with stars."
				else
					(HighPrint 460 2) ; "The sky is so bright that it hurts your eyes."
				)
			)
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/courtyard')
				)
				(HighPrint 460 3) ; "You are in the Plaza across from the Palace gates."
			)
			((Said 'look,look<down')
				(HighPrint 460 4) ; "Everywhere you look, dirty Plazas."
			)
		)
	)
)

(instance mosaic of PicView
	(properties
		x 159
		y 191
		noun '/mosaic,pattern'
		description {the cracked and dirty}
		lookStr {The mosaic is cracked and dirty.}
		view 450
		loop 1
		priority 1
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance lWindow of PicView
	(properties
		x 74
		y 52
		noun '/window'
		description {the window}
		lookStr {Once, this window overlooked a clean and busy Plaza.}
		view 450
		loop 2
		cel 1
		priority 14
		signal 16
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance rWindow of PicView
	(properties
		x 251
		y 52
		description {the window}
		lookStr {No one has looked out of this window onto the Plaza for a long, long time.}
		view 450
		loop 3
		cel 1
		priority 14
		signal 16
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance sparkle of Prop
	(properties
		x 72
		y 118
		description {the magical light}
		view 31
		loop 4
		signal 24576
	)
)

(instance sharaf of Actor
	(properties
		view 445
		loop 4
	)
)

(instance backWithDjinn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(sparkle init: cycleSpeed: 2 setCycle: End self)
			)
			(1
				(sparkle dispose:)
				(gEgo posn: 72 115 loop: 4 show:)
				(= seconds 2)
			)
			(2
				(djinniPrint 460 5) ; "Wow, What do you know? It worked! My magic really worked!"
				(= seconds 2)
			)
			(3
				(djinniPrint 460 6) ; "We are now in what you call Raseir. This is as close to Iblis as I could get."
				(djinniPrint 460 7) ; "There are some very powerful spells coming from that Palace over there. We don't have much time!"
				(djinniPrint 460 8) ; "Well, what are you waiting for? Let's go!"
				(= isInRoom 1)
				(= seconds 1)
			)
			(4
				(if (IsFlag 94)
					(self cue:)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(5
				(HighPrint 460 9) ; "There is a soft whisper from the alleyway."
				(= seconds 1)
			)
			(6
				(HighPrint 460 10 80 {Sharaf:}) ; "Hero-friend! What magic you have at your command!"
				(= seconds 1)
			)
			(7
				(sharaf
					posn: -9 187
					init:
					setLoop: 4
					setCycle: Walk
					setMotion: MoveTo 111 120 self
				)
			)
			(8
				(sharaf setLoop: 1 setMotion: MoveTo 105 112 self)
			)
			(9
				(HighPrint 460 11 80 {Sharaf:}) ; "The UnderGround is prepared to attack the Palace. If you need to enter there, we will provide some distraction for you. However, we are almost ready, so you must hurry before you are caught in our battle."
				(= seconds 3)
			)
			(10
				(sharaf
					setCycle: Walk
					setLoop: 4
					illegalBits: 0
					setMotion: MoveTo 205 74
				)
				(= seconds 3)
			)
			(11
				(sharaf dispose:)
				(HighPrint 460 12 103 25 4) ; "Sharaf silently sneaks off."
				(= seconds 1)
			)
			(12
				(HandsOn)
				(= seconds 5)
			)
			(13
				(self dispose:)
			)
		)
	)
)

(instance toPalace of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 20) self
				)
			)
			(1
				(if (and (== gDay 30) (> gTimeODay 4))
					(djinniPrint 460 13) ; "You can't stop now! Iblis is starting to awaken!"
				else
					(djinniPrint 460 14) ; "No, no! This way. This way!"
				)
				(= seconds 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance fromAlley of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setCycle: Walk
					setMotion: MoveTo (+ (gEgo x:) 15) (gEgo y:) self
				)
			)
			(1
				(if (and (== gDay 30) (> gTimeODay 4))
					(djinniPrint 460 13) ; "You can't stop now! Iblis is starting to awaken!"
				else
					(djinniPrint 460 14) ; "No, no! This way. This way!"
				)
				(= seconds 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance rightDoorBlock of PicView
	(properties
		x 314
		y 156
		noun '/door,sign,barricade,board,alley[<alley,bearing,street]'
		description {the barricade}
		lookStr {The alley is securely blocked by a barricade of boards.  You can barely discern a sign reading:\n"All Fed-Ex packages must be out by 2:30!"}
		view 384
		loop 3
		priority 11
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance leftAlleyDoor of Feature
	(properties
		x 5
		y 124
		noun '/door,sign,barricade,board,alley[<alley,bearing,street]'
		nsTop 92
		nsBottom 156
		nsRight 13
		description {the alley leading North}
		lookStr {You see a dark foreboding passage leading North.  The street sign reads:\n"Any order from a guard is a rule!"}
	)
)

(instance topAlleyDoor of Feature
	(properties
		x 158
		y 67
		noun '/door,sign,barricade,board,alley[<alley,bearing,street]'
		nsTop 38
		nsLeft 132
		nsBottom 91
		nsRight 185
		description {the alley leading East}
		lookStr {You see a dark foreboding passage leading East.  The street sign reads:\n"Everything not mandatory is forbidden!"}
	)
)

