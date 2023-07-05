;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 450)
(include sci.sh)
(use Main)
(use n001)
(use HandsOffScript)
(use RasPlaza)
(use LoadMany)
(use Save)
(use Motion)
(use Actor)
(use System)

(public
	rm450 0
)

(local
	once
)

(procedure (khaveenPrint)
	(HighPrint &rest 35 kWin 80 {Khaveen:})
)

(procedure (ugartePrint)
	(HighPrint &rest 35 uWin 80 {Ugarte:})
)

(instance kWin of SysWindow
	(properties
		back 11
	)
)

(instance uWin of SysWindow
	(properties
		back 14
	)
)

(instance rm450 of RasPlaza
	(properties
		style 6
		south 390
		bottomExit 1
	)

	(method (init)
		(LoadMany rsVIEW 0 4 380 450)
		(if (and (== gDay 28) (not (IsFlag 97)))
			(LoadMany rsVIEW 362 465 382 383 397)
		)
		(super init:)
		(InitAddToPics leftDoorBlock rightFullBlock backDoorBlock lWindow rWindow)
		(if (and (== gDay 28) (IsFlag 97))
			(InitAddToPics wawa)
		)
		(cond
			((and (== gDay 28) (not (IsFlag 97)) (<= 0 gTimeODay 4))
				(ugarte init: setPri: 7 setScript: uSquirms)
				(khaveen init: stopUpd:)
				(rGuard1 init: stopUpd:)
				(rGuard2 init: setPri: 6 stopUpd:)
				(rGuard3 init:)
				(rGuard4 init: stopUpd:)
				(rGuard5 init: stopUpd:)
				(= entranceScript ugarteArrest)
			)
			(gNight
				(= gSpellChecker gAllChecker)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'look,look<up') (Said 'look,look/sky'))
				(if (> gTimeODay 4)
					(LowPrint 450 0) ; "The Raseirian sky is ablaze with stars."
				else
					(LowPrint 450 1) ; "The sky is so bright, that it hurts your eyes."
				)
			)
			((Said 'look,look[<down,at]/floor,ground')
				(LowPrint 450 2) ; "Dirty, dirty, dirty."
			)
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/courtyard')
				)
				(if (and (== gDay 28) (not (IsFlag 97)))
					(LowPrint 450 3) ; "The Plaza seems to be busy today."
				else
					(LowPrint 450 4) ; "This looks like a nice, quiet spot."
				)
			)
			((Said 'ask,tell')
				(if (and (== gDay 28) (not (IsFlag 97)))
					(LowPrint 450 5) ; "Don't bother the guards."
				else
					(LowPrint 450 6) ; "There is no one to talk to."
				)
			)
			((Said 'free,use/(elemental[<water]),(water<magic)')
				(if (gEgo has: 43) ; MagicWater
					(HighPrint 450 7) ; "Something in the back of your mind tells you to hold on to the Water Elemental."
				else
					(DontHave)
				)
			)
		)
	)
)

(instance lWindow of PicView
	(properties
		x 74
		y 53
		noun '/window'
		description {the window}
		lookStr {Another fine window manufactured by MS Window Co.}
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
		lookStr {The window looks out upon a desolate Plaza.}
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

(instance wawa of PicView
	(properties
		x 106
		y 120
		noun '/water'
		description {the spilled water}
		lookStr {The water spilled by Ugarte.}
		view 397
		loop 1
		priority 1
		signal 16400
	)
)

(instance ugarte of Actor
	(properties
		x 103
		y 123
		description {Ugarte}
		lookStr {It is Ugarte, a water smuggler.}
		view 362
		loop 5
	)
)

(instance rGuard1 of Actor
	(properties
		x 77
		y 124
		noun '/guard'
		description {the guard}
		lookStr {He looks like he means business.}
		view 382
		loop 2
		cel 2
	)
)

(instance rGuard2 of Actor
	(properties
		x 129
		y 124
		description {the guard}
		lookStr {It's a Raseirian Guard.}
		view 382
		loop 2
		cel 2
		signal 16384
		illegalBits 0
	)
)

(instance rGuard3 of Actor
	(properties
		x 175
		y 105
		description {the guard}
		lookStr {It's a Raseirian Guard.}
		view 382
		loop 2
		cel 2
	)
)

(instance rGuard4 of Actor
	(properties
		x 226
		y 179
		description {the guard}
		lookStr {It's a Raseirian Guard.}
		view 382
		loop 3
		cel 2
	)
)

(instance rGuard5 of Actor
	(properties
		x 298
		y 183
		description {the guard}
		lookStr {It's a Raseirian Guard.}
		view 382
		loop 3
		cel 2
	)
)

(instance khaveen of Actor
	(properties
		x 160
		y 125
		noun '/khaveen'
		description {Khaveen}
		lookStr {This man must be the boss.}
		view 465
		loop 1
		cel 1
	)
)

(instance gard_Ugarte of Actor
	(properties
		name {gard&Ugarte}
		x 94
		y 117
		description {Ugarte}
		lookStr {Ugarte is being dragged off to the dungeon.}
		view 397
		loop 3
		signal 16384
	)
)

(instance ugarteArrest of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSound number: 397 loop: 0 priority: 0 playBed:)
				(gEgo setMotion: MoveTo 262 179 self)
			)
			(1
				(gEgo setMotion: MoveTo 250 159)
				(rGuard5
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 278 166
				)
				(rGuard4
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 227 161 self
				)
			)
			(2
				(rGuard4 loop: 0)
				(rGuard5 loop: 1)
				(= seconds 1)
			)
			(3
				(rGuard4
					view: 383
					loop: 2
					cel: 0
					posn: (+ (rGuard4 x:) 3) (- (rGuard4 y:) 1)
					cycleSpeed: 1
					setCycle: End
				)
				(rGuard5
					view: 383
					loop: 3
					cel: 0
					posn: (- (rGuard5 x:) 5) (rGuard5 y:)
					cycleSpeed: 1
					setMotion: 0
					setCycle: End self
				)
			)
			(4
				(HighPrint 450 8 80 {Guard:} 25 3) ; "Do not interfere!"
				(= seconds 1)
			)
			(5
				(ugarte
					setScript: 0
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo (ugarte x:) (- (ugarte y:) 5) self
				)
			)
			(6
				(ugarte cel: 0)
				(rGuard1
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo (- (ugarte x:) 19) (+ (ugarte y:) 2) self
				)
				(rGuard2
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo (+ (ugarte x:) 17) (- (ugarte y:) 5)
				)
			)
			(7
				(rGuard1
					view: 383
					loop: 2
					cel: 0
					posn: (+ (rGuard1 x:) 3) (- (rGuard1 y:) 1)
					cycleSpeed: 1
					setCycle: End self
				)
				(rGuard2
					view: 383
					loop: 3
					cel: 0
					posn: (- (rGuard2 x:) 5) (rGuard1 y:)
					cycleSpeed: 1
					setCycle: End
				)
			)
			(8
				(ugartePrint 450 9) ; "Hero, you must help me! Do something!"
				(LowPrint 450 10) ; "The swords of the guards press deeper into your skin."
				(khaveenPrint 450 11) ; "There are no heroes in this town. You of all men should know that, Ugarte."
				(= seconds 1)
			)
			(9
				(ugartePrint 450 12) ; "I know very little. What is going on? I am innocent of any wrong-doing."
				(ugarte setLoop: 5 cel: 0 cycleSpeed: 6 setCycle: Fwd)
				(rGuard1 setCycle: Beg)
				(rGuard2 setCycle: Beg self)
			)
			(10
				(rGuard1
					view: 382
					loop: 4
					cel: 0
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo (- (ugarte x:) 22) (+ (ugarte y:) 14) self
				)
			)
			(11
				(rGuard1 cel: 0 loop: 3)
				(khaveen setCycle: Walk setMotion: MoveTo 127 123 self)
			)
			(12
				(rGuard1 setCycle: CT 3 0)
				(khaveen loop: 1)
				(= seconds 3)
			)
			(13
				(khaveenPrint 450 13) ; "If you are so innocent, then what is this?"
				(= cycles 4)
			)
			(14
				(ugarte view: 397 setLoop: 0 cycleSpeed: 1 setCycle: CT 7 1)
				(= cycles 20)
			)
			(15
				(khaveen
					view: 397
					loop: 2
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(16
				(ugarte setCycle: End self)
			)
			(17
				(ugartePrint 450 14 80 {Ugarte:} 35 uWin) ; "I don't know how that water bag could have gotten there. Someone must have planted it on me."
				(InitAddToPics wawa)
				(ugarte setLoop: 1 setCel: 1)
				(khaveen setCycle: Beg self)
			)
			(18
				(khaveen view: 465 loop: 1 cel: 3)
				(= cycles 10)
			)
			(19
				(khaveenPrint 450 15) ; "Waterskins under your tunic, Ugarte? You know that smuggling water is a crime against the State. You also know what we do to criminals like you."
				(HighPrint 450 16 80 {Ugarte:} 35 uWin) ; "No, no, please. I am innocent! I do not know how it got there. No!"
				(HighPrint 450 17 80 {Ugarte:} 35 uWin) ; "Hero....    Help!....."
				(= cycles 4)
			)
			(20
				(rGuard2
					view: 382
					loop: 1
					setCycle: Walk
					setMotion: MoveTo 83 112 self
				)
			)
			(21
				(rGuard2 loop: 2 cel: 4)
				(= cycles 4)
			)
			(22
				(rGuard1 loop: 2)
				(rGuard2 view: 383 loop: 4 cel: 0 setCycle: End self)
			)
			(23
				(rGuard2 hide:)
				(ugarte hide:)
				(gard_Ugarte init: setCycle: End self)
				(rGuard1
					setLoop: 2
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 40 255
				)
			)
			(24
				(gard_Ugarte
					setLoop: 4
					cel: 0
					illegalBits: 0
					setCycle: Fwd
					setMotion: MoveTo 40 252
				)
				(= seconds 2)
			)
			(25
				(khaveen loop: 4 cel: 1)
				(= seconds 2)
			)
			(26
				(khaveenPrint 450 18) ; "This is the fate of anyone who breaks the rules of the city. Remember this, and see that you do not suffer the same fate."
				(= seconds 2)
			)
			(27
				(khaveen
					setLoop: 5
					illegalBits: 0
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 40 250
				)
				(rGuard3
					illegalBits: 0
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 37 240 self
				)
			)
			(28
				(HighPrint 450 19 80 {Guard:} 103 25 6) ; "I hope you are smart enough to learn this lesson. You do not want to see the dungeons of Raseir."
				(= cycles 4)
			)
			(29
				(NormalEgo)
				(rGuard4
					view: 382
					loop: 2
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo (rGuard4 x:) 250
				)
				(rGuard5
					view: 382
					loop: 2
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo (rGuard5 x:) 250 self
				)
			)
			(30
				(= gFollowTime (GetTime 1)) ; SysTime12
				(ugarte dispose:)
				(rGuard1 dispose:)
				(rGuard2 dispose:)
				(rGuard3 dispose:)
				(rGuard4 dispose:)
				(rGuard5 dispose:)
				(gard_Ugarte dispose:)
				(khaveen dispose:)
				(gCSound stop:)
				(SetFlag 97)
				(self dispose:)
			)
		)
	)
)

(instance uSquirms of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: CT 1 1 self)
			)
			(1
				(= cycles (Random 10 20))
			)
			(2
				(client setCycle: CT 3 1 self)
			)
			(3
				(= cycles (Random 10 20))
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance leftDoorBlock of PicView
	(properties
		x 4
		y 155
		noun '/door,sign,barricade,board,alley[<alley,bearing,street]'
		description {the barricade}
		lookStr {The alley is securely blocked by a barricade of boards.  You can barely discern a sign reading:\n"This street closed by order of Khaveen!"}
		view 384
		loop 4
		priority 7
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance rightFullBlock of PicView
	(properties
		x 308
		y 164
		shiftClick 0
		view 460
		loop 3
		priority 7
		signal 16400
		palette 1
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance backDoorBlock of PicView
	(properties
		x 160
		y 91
		noun '/door,sign,barricade,board,alley[<alley,bearing,street]'
		description {the barricade}
		lookStr {The alley is securely blocked by a barricade of boards.  You can barely discern a sign reading:\n"The smuggling of water is a capital crime!"}
		view 384
		loop 2
		priority 6
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

