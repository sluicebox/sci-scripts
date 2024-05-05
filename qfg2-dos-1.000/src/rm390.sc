;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TargActor)
(use RasPlaza)
(use Interface)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm390 0
)

(local
	oneTime
	isNear1
	isNear2
	isNear3
	warned
	guardTimer
	bustTimer
	crashJump
	deadGuard
)

(procedure (GreedyEgo)
	(EgoDead 1 390 0 #title {Yours is a high-risk occupation}) ; "As you enter Khaveen's room again, and as your eyes once again become accustomed to the darkness, you perceive a dramatic difference. Khaveen and his bodyguards are waiting for you with swords drawn and smiles on their faces."
)

(instance rm390 of RasPlaza
	(properties
		style 6
		north 703
		south 450
		west 703
	)

	(method (init)
		(LoadMany rsVIEW 6 47 591 382 383 450)
		(Load rsSCRIPT 972)
		(if (or (== gDay 28) (== gDay 29))
			(= gRopeScript ropeMe)
			(= gRopeHighY 30)
			(= gLevScript levMe)
			(= gLevHighY 30)
		)
		(if gNight
			(= gSpellChecker gAllChecker)
		)
		(if (== gPrevRoomNum 410)
			(= inOut 3)
		)
		(super init:)
		(InitFeatures topAlleyDoor leftAlleyDoor)
		(InitAddToPics rightFullBlock lWindow rWindow)
		(cond
			((== gPrevRoomNum 410)
				(gCurRoom setScript: fromRm410)
			)
			(
				(and
					(< (- (GetTime 1) gFollowTime) 45) ; SysTime12
					(!= (- (GetTime 1) gFollowTime) 0) ; SysTime12
					(!= gFollowTime 0)
					(== gPrevRoomNum 450)
				)
				(gEgo setScript: stillDraggin)
			)
			(
				(and
					(< (- (GetTime 1) gFollowTime) 15) ; SysTime12
					(!= (- (GetTime 1) gFollowTime) 0) ; SysTime12
					(!= gFollowTime 0)
					(== gPrevRoomNum 703) ; alleyRas
				)
				(gEgo setScript: multiGuards)
			)
			((and (== gDay 28) (> gTimeODay 4))
				(rGuard6 init:)
			)
			((and (== gDay 28) (not (IsFlag 97))) ; fUgarteBusted
				(rGuard1 init:)
				(rGuard2 init:)
				(rGuard3 init:)
				(rGuard4 view: 383 loop: 7 posn: 20 189 init:)
				(HighPrint 390 1 103) ; "You see several people gathered in the south part of the Plaza."
			)
		)
	)

	(method (dispose)
		(= gLevScript (= gRopeScript 0))
		(super dispose: &rest)
	)

	(method (doit)
		(cond
			((not guardTimer))
			((-- guardTimer))
			(else
				(rGuard6 dispose:)
				(rGuard7 init:)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'cast,drop,use,throw,climb,climb/rope[<magic]')
				(if bustTimer
					(event claimed: 1)
					(HighPrint 390 2) ; "Forget it. It's too late."
				else
					(event claimed: 0)
				)
			)
			((or (Said 'look,look<up') (Said 'look,look<at/sky'))
				(if gNight
					(LowPrint 390 3) ; "The Raseirian sky is ablaze with stars."
				else
					(LowPrint 390 4) ; "The sky is so bright that it hurts your eyes."
				)
			)
			((or (Said 'look,look<down') (Said 'look,look<at/floor,ground'))
				(LowPrint 390 5) ; "Dirty, dirty, dirty."
			)
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/courtyard')
				)
				(if (and (== gDay 28) (not (IsFlag 97))) ; fUgarteBusted
					(LowPrint 390 6) ; "The Plaza seems to be busy today."
				else
					(LowPrint 390 7) ; "The fountain in Raseir's Plaza of the Fountain is cracked and dry."
				)
			)
			((Said 'ask,tell,talk,talk')
				(if (and (== gDay 28) (not (IsFlag 97))) ; fUgarteBusted
					(LowPrint 390 8) ; "Do not bother the guards."
				else
					(LowPrint 390 9) ; "There is no one to talk to."
				)
			)
			(
				(or
					(Said 'search,strip[/guard,body,man]')
					(Said 'get,get/blade,shield,weapon')
				)
				(if deadGuard
					(HighPrint 390 10) ; "It's too dangerous around here right now. More guards could arrive at any moment."
				else
					(event claimed: 0)
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
		lookStr {The window was manufactured by MS Window Co.}
		view 450
		loop 2
		cel 1
		priority 2
		signal 24592
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
		x 249
		y 54
		description {the window}
		lookStr {It's the window of Khaveens' house.}
		view 450
		loop 2
		cel 4
		priority 2
		signal 24592
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance rGuard10 of PicView
	(properties
		x 123
		y 95
		noun '/guard'
		description {the guard}
		lookStr {For all you do, this guard's for you.}
		view 383
		loop 5
	)
)

(instance rGuard11 of PicView
	(properties
		x 196
		y 96
		description {the guard}
		lookStr {He has been waiting for you.}
		view 383
		loop 6
	)
)

(instance rGuard12 of PicView
	(properties
		x 28
		y 142
		description {the guard}
		lookStr {He's in search of curfew breakers.}
		view 383
		loop 5
	)
)

(instance rGuard13 of PicView
	(properties
		x 7
		y 199
		description {the guard}
		lookStr {A Raseirian guard.}
		view 383
		loop 7
	)
)

(instance rGuard14 of PicView
	(properties
		x 251
		y 176
		description {the guard}
		lookStr {A Raseirian guard.}
		view 383
		loop 8
	)
)

(instance rGuard1 of Actor
	(properties
		x 239
		y 180
		description {the guard}
		lookStr {A Raseirian guard.}
		view 382
		loop 3
		cel 4
	)

	(method (doit)
		(cond
			((and (< (self distanceTo: gEgo) 30) (not isNear1))
				(= isNear1 1)
				(gEgo setMotion: 0)
				(self view: 383 loop: 2 cel: 0 setCycle: End self)
			)
			((and (> (self distanceTo: gEgo) 30) isNear1)
				(= isNear1 0)
				(self setCycle: Beg self)
			)
		)
		(super doit:)
	)

	(method (cue)
		(cond
			((< (self distanceTo: gEgo) 30)
				(Print 390 11 #title {Guard:} #dispose #time 3) ; "This is none of your business. Go away."
			)
			((> (self distanceTo: gEgo) 30)
				(NormalEgo)
				(self view: 382 loop: 3 cel: 4)
			)
		)
		(super cue:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look,look/guard,guard,man')
				(Print 390 12) ; "The guards of Raseir look like they are itching for a fight."
			)
			((Said 'attack,kill,hit')
				(Print 390 13) ; "That would only bring more guards."
			)
		)
	)
)

(instance rGuard2 of Actor
	(properties
		x 288
		y 181
		description {the guard}
		lookStr {A Raseirian guard.}
		view 383
		loop 8
	)

	(method (doit)
		(cond
			((and (< (self distanceTo: gEgo) 30) (not isNear2))
				(= isNear2 1)
				(gEgo setMotion: 0)
				(self view: 383 loop: 3 cel: 0 setCycle: End self)
			)
			((and (> (self distanceTo: gEgo) 30) isNear2)
				(= isNear2 0)
				(self setCycle: Beg self)
			)
		)
		(super doit:)
	)

	(method (cue)
		(cond
			((< (self distanceTo: gEgo) 30)
				(Print 390 11 #title {Guard:} #dispose #time 3) ; "This is none of your business. Go away."
			)
			((> (self distanceTo: gEgo) 30)
				(NormalEgo)
				(self view: 382 loop: 3 cel: 4)
			)
		)
		(super cue:)
	)
)

(instance rGuard3 of Actor
	(properties
		x 18
		y 162
		description {the guard}
		lookStr {A Raseirian guard.}
		view 383
		loop 5
	)

	(method (doit)
		(cond
			((< (gEgo x:) 10)
				(EgoDead 1 {________You WERE warned!!!})
			)
			((and (not warned) (< (gEgo x:) 20))
				(gEgo setCycle: 0 setMotion: 0)
				(NormalEgo)
				(= warned 1)
				(Print 390 14 #title {Guard:}) ; "You were told that you may not pass. Turn now or die!"
			)
			((and (< (self distanceTo: gEgo) 25) (not isNear3))
				(= isNear3 1)
				(gEgo setCycle: 0 setMotion: 0)
				(NormalEgo)
				(Print 390 15 #title {Guard:}) ; "No one may pass until Khaveen gives the order."
			)
			((and (> (self distanceTo: gEgo) 25) isNear3)
				(= warned 0)
				(= isNear3 0)
			)
		)
		(super doit:)
	)
)

(instance rGuard4 of Actor
	(properties
		description {the guard}
		lookStr {A Raseirian guard.}
	)
)

(instance rGuard5 of Actor
	(properties
		x 15
		y 177
		description {the guard}
		lookStr {A Raseirian guard.}
		view 382
		loop 1
		illegalBits 0
	)
)

(instance rGuard6 of TargActor
	(properties
		description {the guard}
		lookStr {A Raseirian guard.}
		view 382
	)

	(method (init)
		(if (== (gEgo loop:) 0)
			(self posn: 159 117 loop: 3 setCycle: Walk setMotion: MoveTo 159 36)
		else
			(self posn: 66 170 loop: 1 setCycle: Walk setMotion: MoveTo -10 170)
		)
		(= bustTimer 20)
		(super init:)
	)

	(method (doit)
		(if (and (< (gEgo y:) 90) oneTime)
			(= oneTime 0)
			(self setCycle: 0 setMotion: 0 setScript: 0)
			(rGuard8 setCycle: 0 setMotion: 0)
			(rGuard9 setCycle: 0 setMotion: 0)
			(self setScript: runningMan)
		)
		(cond
			((not bustTimer))
			((-- bustTimer))
			((not (== gEgoGait 2)) ; sneaking
				(self setCycle: 0 setMotion: 0)
				(Face self gEgo)
				(self setScript: theChase)
			)
			(else
				(= guardTimer 350)
			)
		)
		(super doit:)
	)

	(method (hurtMe)
		(= bustTimer 0)
		(= guardTimer 0)
		(self setScript: guardZapped)
		(return 1)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'run,escape')
				(EgoGait 1) ; running
				(self setCycle: 0 setMotion: 0 setScript: 0)
				(rGuard8 setCycle: 0 setMotion: 0)
				(rGuard9 setCycle: 0 setMotion: 0)
				(self setScript: runningMan)
			)
		)
	)
)

(instance rGuard7 of TargActor
	(properties
		x -10
		y 170
		description {the guard}
		lookStr {A Raseirian guard.}
		view 382
		illegalBits 0
	)

	(method (init)
		(self setCycle: Walk setMotion: MoveTo 15 170 self)
		(super init:)
	)

	(method (cue)
		(self setScript: theChase)
		(super cue:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'run,escape')
				(= gEgoGait 1) ; running
				(self setCycle: 0 setMotion: 0 setScript: 0)
				(rGuard8 setCycle: 0 setMotion: 0)
				(rGuard9 setCycle: 0 setMotion: 0)
				(self setScript: runningMan)
			)
		)
	)

	(method (hurtMe)
		(= bustTimer 0)
		(= guardTimer 0)
		(self setScript: guardZapped)
		(return 1)
	)
)

(instance rGuard8 of Actor
	(properties
		x 159
		y 75
		description {the guard}
		lookStr {A Raseirian guard.}
		view 382
		loop 2
		illegalBits 0
	)

	(method (init)
		(self setCycle: Walk setMotion: MoveTo 159 100)
		(super init:)
	)
)

(instance rGuard9 of Actor
	(properties
		x -15
		y 170
		description {the guard}
		lookStr {A Raseirian guard.}
		view 382
	)

	(method (init)
		(self setCycle: Walk setMotion: MoveTo 90 170)
		(super init:)
	)
)

(instance fromRm410 of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 47
					loop: 1
					cel: 3
					setPri: 12
					posn: 249 45
					z: 0
					init:
				)
				(= cycles 1)
			)
			(1
				(gEgo cel: 2 posn: 245 45)
				(= cycles 1)
			)
			(2
				(gEgo cel: 1 posn: 240 46)
				(= cycles 1)
			)
			(3
				(gEgo view: 591 loop: 3 cel: 0 posn: 236 40)
				(= cycles 1)
			)
			(4
				(gEgo posn: 231 46)
				(= cycles 1)
			)
			(5
				(gEgo posn: 226 54)
				(= cycles 1)
			)
			(6
				(gEgo posn: 214 66)
				(= cycles 1)
			)
			(7
				(gEgo posn: 201 85)
				(= cycles 1)
			)
			(8
				(gEgo posn: 186 101)
				(= cycles 1)
			)
			(9
				(gEgo loop: 1 cel: 1 setPri: -1 posn: 174 108)
				(= cycles 1)
			)
			(10
				(if (TakeDamage 15)
					(gEgo cel: 2 posn: 167 114)
					(= cycles 1)
				else
					(= crashJump 1)
					(gEgo loop: 1 cel: 9 x: 175 y: 107)
					(= cycles 1)
				)
			)
			(11
				(if crashJump
					(gEgo
						view: 22
						setLoop: 0
						cel: 0
						x: 180
						y: 111
						yStep: 16
						setMotion: MoveTo 187 117
						setCycle: End self
					)
				else
					(gEgo cel: 3 posn: 164 113)
					(= cycles 1)
				)
			)
			(12
				(if crashJump
					(EgoDead
						1
						{After all the trouble you took to get your hands on that Raven, it's really a shame you couldn't take any more damage.__You should've tended to your healing, but now it's too late. }
						#title
						{You Fell for It}
					)
				else
					(gEgo cel: 4 posn: 160 111)
					(= cycles 1)
				)
			)
			(13
				(gEgo cel: 5 posn: 158 112)
				(= cycles 1)
			)
			(14
				(gEgo cel: 6 posn: 145 113)
				(= cycles 1)
			)
			(15
				(gEgo cel: 7 posn: 145 112)
				(= cycles 1)
			)
			(16
				(gEgo cel: 8 posn: 143 112)
				(= cycles 1)
			)
			(17
				(gEgo cel: 9 posn: 138 112)
				(= cycles 1)
			)
			(18
				(gEgo view: 4 setLoop: 1 cel: 0 posn: 140 110)
				(= cycles 1)
			)
			(19
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance stillDraggin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rGuard5
					init:
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo -35 177
				)
				(rGuard4
					view: 382
					loop: 1
					posn: 40 189
					init:
					setCycle: Walk
					setMotion: MoveTo -30 189
				)
				(= seconds 4)
			)
			(1
				(rGuard4 dispose:)
				(rGuard5 dispose:)
				(= gFollowTime 0)
				(self dispose:)
			)
		)
	)
)

(instance theChase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= oneTime 1)
				(= seconds 3)
			)
			(1
				(Print 390 16 #title {Guard:} #time 4) ; "You there, Stop!"
				(if (== (gEgo view:) 6)
					(gEgo setScript: 0)
					(HandsOff)
				)
				(= seconds 1)
			)
			(2
				(client
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 15) self
				)
			)
			(3
				(Face client gEgo)
				(Print 390 17 #title {Guard:}) ; "It is forbidden to be out at night. You are in violation of the laws of Raseir."
				(= cycles 1)
			)
			(4
				(HandsOff)
				(rGuard9 init:)
				(rGuard8 init:)
				(= cycles 10)
			)
			(5
				(if (== client rGuard6)
					(EgoDead
						1
						{All things come to those who wait.__Looks like you waited too long, and look what came to you! }
						#title
						{Don't just stand there....}
					)
				else
					(EgoDead
						1
						{You took too long to do your deed.}
						#title
						{Don't just stand there....}
					)
				)
			)
		)
	)
)

(instance runningMan of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= bustTimer 0)
				(= gFollowTime (GetTime 1)) ; SysTime12
				(if (== client rGuard7)
					(if (> (gEgo x:) 154)
						(gEgo setMotion: MoveTo 159 100 self)
					else
						(gEgo setMotion: MoveTo 20 170 self)
					)
				else
					(self cue:)
				)
			)
			(1
				(Print 390 18 #title {Guard:}) ; "Guards!! There is an intruder in Fountain One. To me!!"
				(= cycles 2)
			)
			(2
				(if (< (gEgo y:) 150)
					(gEgo setMotion: MoveTo 160 82 self)
				else
					(gEgo setMotion: MoveTo -10 162 self)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance multiGuards of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(InitAddToPics rGuard10 rGuard11 rGuard12 rGuard13 rGuard14)
				(= seconds 3)
			)
			(1
				(EgoDead
					1
					{Looks like they were waiting for you.__Maybe you should have made them wait a bit longer before you returned. }
					#title
					{Many unhappy returns}
				)
				(self dispose:)
			)
		)
	)
)

(instance ropeMe of Script
	(properties)

	(method (doit)
		(if (== (gEgo z:) 33)
			(gEgo setScript: intoWindow)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 218 128 self)
			)
			(1
				(caller cue:)
			)
		)
	)
)

(instance levMe of Script
	(properties)

	(method (doit)
		(if (== (gEgo z:) 45)
			(gEgo setScript: jumpToWindow)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo inRect: 109 178 130 189)
					(gEgo setMotion: MoveTo 90 180 self)
				else
					(self cue:)
				)
			)
			(1
				(if (gEgo inRect: 0 150 160 189)
					(gEgo setMotion: MoveTo 100 140 self)
				else
					(self cue:)
				)
			)
			(2
				(gEgo setMotion: MoveTo 235 127 self)
			)
			(3
				(gEgo loop: 3)
				(= cycles 2)
			)
			(4
				(caller cue:)
			)
		)
	)
)

(instance intoWindow of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 6
					loop: 6
					cel: 0
					z: 0
					posn: 228 83
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(if (gEgo has: 47) ; Bird
					(gCast eachElementDo: #hide)
					(gCurRoom drawPic: 2 6)
					(= cycles 2)
				else
					(gCurRoom newRoom: 410)
					(self dispose:)
				)
			)
			(2
				(GreedyEgo)
			)
		)
	)
)

(instance jumpToWindow of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 6 loop: 6 cel: 3 z: 0 posn: 238 82)
				(= cycles 2)
			)
			(1
				(if (gEgo has: 47) ; Bird
					(gCast eachElementDo: #hide)
					(gCurRoom drawPic: 2 6)
					(= cycles 2)
				else
					(gCurRoom newRoom: 410)
					(self dispose:)
				)
			)
			(2
				(GreedyEgo)
			)
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
		(if gNight
			(= palette 2)
		)
	)
)

(instance leftAlleyDoor of Feature
	(properties
		x 5
		y 124
		noun '/door,sign[<alley,bearing,street]'
		nsTop 92
		nsBottom 156
		nsRight 13
		description {the alley leading west}
		lookStr {You see a dark foreboding passage leading West.__The street sign reads "Everything not mandatory is forbidden!"}
	)
)

(instance topAlleyDoor of Feature
	(properties
		x 158
		y 67
		noun '/door,sign[<alley,bearing,street]'
		nsTop 38
		nsLeft 132
		nsBottom 91
		nsRight 185
		description {the alley leading North}
		lookStr {You see a dark foreboding passage leading North.__The street sign reads "You must carry your Visa at all times!"}
	)
)

(instance guardZapped of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					illegalBits: 0
					setPri: 8
					signal: 16384
					view: 381
					loop: 2
					cel: 1
					posn: (- (client x:) 10) (+ (client y:) 10)
				)
				(= cycles 1)
			)
			(1
				(client cel: 2 posn: (- (client x:) 8) (- (client y:) 13))
				(= cycles 1)
			)
			(2
				(client cel: 3 posn: (- (client x:) 16) (+ (client y:) 14))
				(= cycles 1)
			)
			(3
				(client signal: -32735)
				(= deadGuard 1)
				(self dispose:)
			)
		)
	)
)

