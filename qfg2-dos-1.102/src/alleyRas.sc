;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 703)
(include sci.sh)
(use Main)
(use n001)
(use HandsOffScript)
(use Talker)
(use Full)
(use AFeat)
(use Blk)
(use MoveFwd)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	alleyRas 0
)

(local
	inAlley200
	aboutToMeetAdAvis
	guardsBlocking
)

(instance alleyRas of AlleyRoom
	(properties)

	(method (init)
		(LoadMany rsVIEW 433 382 426)
		(gCSound number: 710 loop: -1 playBed:)
		(= global61 2)
		(super init: &rest)
	)

	(method (newFeature)
		((super newFeature: &rest)
			palette: (if (<= 0 gTimeODay 4) 3 else 4)
			yourself:
		)
	)

	(method (doit)
		(super doit:)
		(if (gGame script:)
			(return)
		)
		(cond
			(
				(and
					inAlley200
					(not (IsFlag 142))
					(or
						(and (== facingHeading 3) (== (- length scrBotPos) 36))
						(and (== facingHeading 1) (== (- length scrBotPos) 36))
					)
					(== gDay 28)
					(IsFlag 97)
					(not (IsFlag 138))
				)
				(SetFlag 142)
				(gGame setScript: slaveBeckons)
			)
			(
				(and
					(not (gGame script:))
					(IsFlag 142)
					(or
						(and (== facingHeading 1) (== (- length scrBotPos) 20))
						(and (== facingHeading 3) (== (- length scrBotPos) 20))
					)
				)
				(gGame setScript: getCaught)
			)
			((and aboutToMeetAdAvis (== (- length scrBotPos) 9))
				(gGame setScript: meetAdAvis)
			)
		)
	)

	(method (newAlley)
		(super newAlley: &rest)
		(if (and guardsBlocking (gGame script:))
			((gGame script:) dispose:)
		)
		(= inAlley200 (not (StrCmp (alley name:) {alley200})))
		(= aboutToMeetAdAvis
			(and (not (StrCmp (alley name:) {alley250})) (== gPrevRoomNum 440))
		)
		(if
			(and
				(not inAlley200)
				(== gDay 28)
				(not (IsFlag 138))
				(not (gGame script:))
				(or
					(and
						(not (StrCmp (alley name:) {alley201}))
						(== facingHeading 4)
					)
					(not (StrCmp (alley name:) {alley210}))
					(not (StrCmp (alley name:) {alley218}))
				)
			)
			(= guardsBlocking 1)
			(gGame setScript: guardsBlock 0 (== facingHeading 4))
		)
	)

	(method (turnAround)
		(if (and guardsBlocking (gGame script:))
			((gGame script:) dispose:)
		)
		(super turnAround:)
	)

	(method (crossIntersection)
		(if (<= 0 gTimeODay 4)
			(super crossIntersection:)
		)
	)

	(method (makeCrosser guy &tmp [unused 3])
		(guy
			view: 382
			description: {the guard}
			noun: '/man,guard'
			lookStr: {The guard looks like he means business.}
		)
	)

	(method (dispose)
		(= global61 0)
		(if (gGame script:)
			((gGame script:) dispose:)
		)
		(gCSound fade:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (Said 'listen')
			(HighPrint 703 0) ; "You hear the sounds of people standing in fear of their drab and wretched lives."
		else
			(super handleEvent: event)
		)
	)
)

(instance guard1 of Talker
	(properties
		view 383
		illegalBits 0
		tLoop -1
		said '[/guard]'
		title {Guard:}
	)

	(method (init facingBottom)
		(if facingBottom
			(= loop 5)
			(= cel 0)
			(= x 133)
			(= y 137)
		else
			(= loop 7)
			(= cel 0)
			(= x 138)
			(= y 104)
		)
		(super init: show:)
	)

	(method (respond)
		(HighPrint 703 1) ; "These guards appear to be the strong, silent type."
	)

	(method (handleEvent event)
		(if (Said 'attack')
			(HighPrint 703 2) ; "These guards could whip you like cream."
		else
			(super handleEvent: event)
		)
		(event claimed:)
	)
)

(instance guard2 of Actor
	(properties
		view 383
		illegalBits 0
	)

	(method (init facingBottom)
		(if facingBottom
			(= loop 6)
			(= cel 0)
			(= x 182)
			(= y 139)
		else
			(= loop 8)
			(= cel 0)
			(= x 176)
			(= y 104)
		)
		(super init: show:)
	)
)

(instance block of Blk
	(properties
		top 95
		bottom 145
		right 319
	)
)

(instance guardsBlock of Script
	(properties)

	(method (init)
		(super init: &rest)
		(guard1 init: register)
		(guard2 init: register)
		(= gSpellChecker gNoChecker)
		(if register
			(gEgo posn: (gEgo x:) 164)
		else
			(gEgo posn: (gEgo x:) 82)
		)
		(gEgo loop: 3 observeBlocks: block)
		(gCurRoom isMoving: 0 isScrolling: 0)
	)

	(method (dispose)
		(if (IsObject (gEgo blocks:))
			(gEgo ignoreBlocks: block)
		)
		(guard1 dispose:)
		(guard2 dispose:)
		(= gSpellChecker gAllChecker)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			(
				(and
					(not state)
					(or
						(and register (< (gEgo y:) 164))
						(and (not register) (> (gEgo y:) 82))
					)
				)
				(self changeState: 1)
			)
			(
				(and
					(== state 2)
					(or
						(and register (> (gEgo y:) 164))
						(and (not register) (< (gEgo y:) 82))
					)
				)
				(self changeState: 3)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(guard1 loop: 2 setCycle: End)
				(guard2 loop: 3 setCycle: End self)
			)
			(2
				(Say guard1 703 3) ; "This street is closed by order of Khaveen.  No one is permitted to pass."
				(HandsOn)
			)
			(3
				(HandsOff)
				(guard1 setCycle: Beg)
				(guard2 setCycle: Beg self)
			)
			(4
				(guard1 loop: 5)
				(guard2 loop: 6)
				(HandsOn)
				(self changeState: 0)
			)
		)
	)
)

(instance slaveBeckons of HandsOffScript
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= register (== (gCurRoom facingHeading:) 1))
				(gEgo setMotion: 0)
				(gCurRoom isMoving: 0)
				(slaveWoman loop: register x: (if register 202 else 115) init:)
				(= cycles 5)
			)
			(1
				(slaveWoman setCycle: End self)
			)
			(2
				(TimePrint
					5
					{If you are truly a hero, follow me!}
					80
					{Woman}
					103
					self
				)
				(slaveWoman
					loop: (+ 2 register)
					cel: 0
					y: 116
					setCycle: Full 2 self
				)
			)
			(3)
			(4
				(slaveWoman
					loop: register
					setCel: 255
					y: 105
					setCycle: Beg self
				)
			)
			(5
				(slaveWoman dispose:)
				(self dispose:)
			)
		)
	)
)

(instance slaveWoman of Prop
	(properties
		y 105
		view 433
		priority 8
		signal 16400
		cycleSpeed 1
	)
)

(instance catchingGuard of Actor
	(properties
		view 382
		priority 8
		signal 16400
		illegalBits 0
	)

	(method (init aCaller xStart xEnd &tmp aObj)
		(super init:)
		(if (== (gCurRoom facingHeading:) 3)
			(= xStart (- 320 xStart))
			(= xEnd (- 320 xEnd))
		)
		(self setScript: (guardMove new:) aCaller xStart xEnd)
	)
)

(instance guardMove of Script
	(properties)

	(method (init aClient aCaller xStart xEnd)
		(aClient
			posn: xStart 115
			setCycle: Walk
			setMotion: MoveTo xEnd 115 self
		)
		(super init: aClient aCaller)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(= cycles 5)
			)
			(2
				(client setHeading: 180 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance getCaught of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(gCurRoom isMoving: 0)
				((catchingGuard new:) init: self 75 140)
				(= cycles 1)
			)
			(1
				(catchingGuard init: self 95 170)
			)
			(2)
			(3
				(HighPrint 703 4 80 {Guard}) ; "Halt. You are under arrest for speaking with a known subversive. You will come with us."
				(EgoDead ; "Two more guards walk up behind you and "escort" you to the dungeon. After some brutal questioning, you are just locked away for a long time."
					0
					703
					5
					#icon
					(catchingGuard view:)
					(catchingGuard loop:)
					(catchingGuard cel:)
					#title
					{Caught by guards}
				)
			)
		)
	)
)

(instance shimmer of Prop
	(properties
		view 426
		loop 2
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self posn: (gEgo x:) (+ (gEgo y:) 3) setCycle: Fwd)
	)
)

(instance adAvis of Actor
	(properties
		view 426
		signal 16384
		illegalBits 0
	)
)

(instance meetAdAvis of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(gCurRoom isMoving: 0)
				(= cycles 3)
			)
			(1
				(shimmer init:)
				(= seconds 3)
			)
			(2
				(adAvis
					posn: 130 84
					cel: 0
					setHeading: 90
					setCycle: Walk
					xStep: 5
					setMotion: MoveFwd 12 self
					init:
				)
			)
			(3
				(= seconds 2)
			)
			(4
				(shimmer setCycle: 0 cel: 1)
				(gCurRoom newRoom: 420)
			)
		)
	)
)

