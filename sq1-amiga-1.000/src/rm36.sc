;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm36 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
)

(procedure (localproc_0)
	(return (if (< local5 160) rock1 else rock2))
)

(procedure (localproc_1 &tmp [temp0 100])
	(gSounds eachElementDo: #stop)
	(Format @temp0 &rest)
	(gLongSong number: 900 vol: 127 loop: 1 flags: 1 play:)
	(gGame setCursor: gNormalCursor 1)
	(repeat
		(switch
			(Print
				@temp0
				#mode
				1
				#button
				{Try Again}
				0
				#button
				{Restore}
				1
				#button
				{Restart}
				2
				#button
				{__Quit__}
				3
				#icon
				26
				5
				1
			)
			(0
				(= gCurRoomNum 0)
				(break)
			)
			(1
				(gGame restore:)
			)
			(2
				(gGame restart:)
			)
			(3
				(= gQuit 1)
				(break)
			)
		)
	)
)

(procedure (localproc_2)
	(gTheIconBar disable: 1 2 3 4 5 6 7)
)

(procedure (localproc_3)
	(if (= local7 (Print 36 0 #button { Play } 0 #button { Skip } 1)) ; "This section is an Arcade sequence. Would you like to Play or Skip this sequence."
		(= local10 (= local11 (+ 40 (* gHowFast 20))))
		(rock1 inc: (rock1 newCelHorizon:))
		(rock2 newCelHorizon: (rock2 inc:))
		(HandsOff)
	else
		(= local10 (= local11 (+ 150 (* gHowFast 150))))
		(localproc_2)
	)
)

(procedure (localproc_4)
	(if (!= (flyingEgo x:) 160)
		(= local14 (/ (- 160 (flyingEgo x:)) 3))
	else
		(= local14 0)
	)
)

(class Rock of Actor
	(properties
		signal 8192
		firstStaticCel 0
		newCelHorizon 0
		inc 0
		lastStaticCel 0
		minCyclesToGo 0
	)

	(method (doit)
		(super doit:)
		(if (and local3 (not (& signal $4000)))
			(self ignoreActors: 1)
		)
	)
)

(class SMover of Motion
	(properties
		maxCyclesToGo 1
		cyclesToGo 10
	)

	(method (init)
		(super init: &rest)
		(motorSound pause:)
		(skimmerBanks loop: 1 play:)
		(if (client cycler:)
			((client cycler:) whoToCue: (self x:))
		)
	)

	(method (doit)
		(super doit:)
		(if (== (skimmerBanks prevSignal:) -1)
			(skimmerBanks prevSignal: 0)
			(motorSound pause: 0)
		)
		(if (not (client isBlocked:))
			(if (and b-xAxis maxCyclesToGo (< (Abs dx) cyclesToGo))
				(if (> x (client x:))
					(+= dx maxCyclesToGo)
				else
					(-= dx maxCyclesToGo)
				)
			)
		else
			(self moveDone:)
			(return)
		)
	)

	(method (moveDone)
		(if (not (OneOf (gEgo loop:) 3 4))
			(motorSound play:)
		)
		(skimmerBanks stop:)
		(client mover: 0)
		(self dispose:)
	)
)

(class SCycler of Fwd
	(properties
		theString 1
		whoToCue 0
		strToCat 0
	)

	(method (doit &tmp temp0 temp1)
		(cond
			((and (client mover:) ((client mover:) b-xAxis:))
				(cond
					((or (not (client loop:)) (!= whoToCue strToCat))
						(= strToCat whoToCue)
						(client
							setLoop:
								(if (< ((client mover:) x:) (client x:))
									1
								else
									2
								)
							cel: 0
						)
					)
					((!= (client cel:) theString)
						(client cel: (self nextCel:))
					)
				)
			)
			((and (client loop:) (== (client cel:) (= temp1 (client lastCel:))))
				(client setLoop: 0 cel: 0)
			)
			(else
				(super doit:)
			)
		)
	)
)

(class RockCycler of Cycle
	(properties
		maxLen 2
		tone 6
		endCel 0
		flash 2
		internalEvent 55
	)

	(method (init)
		(super init: &rest)
		(client ignoreActors: 1)
		(= endCel (client lastCel:))
	)

	(method (doit)
		(if (>= (client y:) internalEvent)
			(if (!= (client cel:) endCel)
				(client cel: (self nextCel:))
			)
			(if (== flash 16)
				(client ignoreActors: 0)
			)
			(+= internalEvent flash)
			(*= flash 2)
		)
	)
)

(instance rm36 of SQRoom
	(properties
		picture 36
		north 41
	)

	(method (init)
		(Load rsVIEW 136)
		(LoadMany rsSOUND 437 438 439 440 441 442 443 444 445 446)
		(gMouseDownHandler addToFront: self)
		(super init: &rest)
		(= local13 (gGame egoMoveSpeed:))
		(gGame egoMoveSpeed: 0)
		((gTheIconBar at: 0) cursor: 26)
		(HandsOff)
		(gAddToPics add: mtn1 mtn2 mtn3 damageGauge eachElementDo: #init doit:)
		(gEgo
			init:
			view: 26
			setLoop: 0
			cel: 0
			x: 160
			y: 225
			xStep: 3
			yStep: 3
			illegalBits: 16384
			ignoreActors: 0
			setPri: 10
			normal: 0
			setCycle: SCycler
			baseSetter: skimmerBase
			setScript: egoHandleEvent
		)
		(city init: stopUpd:)
		(if (> gHowFast 1)
			(shadow init: setCycle: Rev)
		)
		(self setScript: comeOnScreen)
		(= local4 (GetTime 1)) ; SysTime12
	)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if (and local6 (== (-- local10) 0) (not local3))
			(if (== (city cel:) 3)
				(= local9 1)
			else
				(= local10 local11)
				(city cel: (+ (city cel:) 1) forceUpd:)
			)
		)
		(if (and local9 (not (rock1 script:)) (not (rock2 script:)))
			(cond
				(local7
					(Print 36 1) ; "Maybe you could try playing the arcade sequence next time."
				)
				((not local0)
					(Print 36 2) ; "Congratulations, you made it through without a scratch."
				)
				(else
					(Print 36 3) ; "That was pretty intense."
				)
			)
			(gLongSong fade:)
			(self newRoom: 41)
		)
		(= temp0 (GetTime 1)) ; SysTime12
		(if
			(and
				(not local3)
				(not (gCurRoom script:))
				(not (gEgo mover:))
				(>= (- temp0 local4) 3)
			)
			(= local4 temp0)
			(if (!= (gEgo x:) 160)
				(= temp1 (/ -9000 (- (gEgo x:) 160)))
				(= local5 (+ (/ -13400 temp1) 160))
			else
				(= local5
					(if (> (gEgo x:) 160)
						(rock2 newCelHorizon:)
					else
						(rock1 inc:)
					)
				)
			)
		)
	)

	(method (handleEvent event)
		(if (== (event type:) evMOUSEBUTTON)
			(if (and (User controls:) (not script) (== (event type:) evMOUSEBUTTON))
				(gEgo setMotion: theSMover (event x:) (gEgo y:))
				(event claimed: 1)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (dispose)
		(if (== (gGame egoMoveSpeed:) 0)
			(gGame egoMoveSpeed: local13)
		)
		((gTheIconBar at: 0) cursor: 6)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance egoHandleEvent of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((& (event type:) $0040) ; direction
				(switch (event message:)
					(JOY_RIGHT
						(if
							(or
								(!= (event message:) local2)
								(not (gEgo mover:))
							)
							(gEgo setMotion: theSMover 400 (gEgo y:))
						else
							(gEgo setMotion: 0)
						)
					)
					(JOY_LEFT
						(if
							(or
								(!= (event message:) local2)
								(not (gEgo mover:))
							)
							(gEgo setMotion: theSMover -400 (gEgo y:))
						else
							(gEgo setMotion: 0)
						)
					)
					(JOY_NULL
						(gEgo setMotion: 0)
					)
				)
				(= local2 (event message:))
				(event claimed: 1)
			)
			(
				(and
					(User controls:)
					(== (event type:) evKEYBOARD)
					(== (event message:) KEY_RETURN)
				)
				(gEgo setMotion: theSMover (event x:) (gEgo y:))
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance comeOnScreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(motorSound play: hold: 1)
				(gEgo setMotion: MoveTo 160 145 self)
			)
			(1
				(rock1
					init:
					moveSpeed: (* gHowFast 3)
					setPri: 2
					baseSetter: RockBase
					setScript: (Clone rockAttack)
				)
				(rock2
					init:
					moveSpeed: (* gHowFast 3)
					setPri: 2
					baseSetter: RockBase
					setScript: (Clone rockAttack)
				)
				(HandsOn)
				(= local6 1)
				(localproc_3)
				(= cycles 1)
			)
			(2
				(gLongSong number: 437 loop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance rockAttack of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(not local3)
				(not local9)
				(client isBlocked:)
				(not (gCurRoom script:))
			)
			(gCurRoom setScript: hitRock 0 client)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client hide: setPri: 2 setLoop: (Random 1 4))
				(= cycles (Random 3 30))
			)
			(1
				(if (and (not local9) (not local3))
					(client
						show:
						cel: 0
						posn: (client firstStaticCel:) 55
						lastStaticCel: (if (== (client loop:) 1) 1 else 0)
						ignoreActors: 0
						setCycle: RockCycler
						setMotion:
							MoveTo
							(if
								(and
									(not local7)
									local5
									(== client (localproc_0))
									(not local8)
									(= local8 1)
									(client minCyclesToGo: 1)
								)
								local5
							else
								(Random (client newCelHorizon:) (client inc:))
							)
							189
							self
					)
				else
					(self dispose:)
				)
			)
			(2
				(if (client minCyclesToGo:)
					(client minCyclesToGo: 0)
					(= local8 0)
					(= local5 0)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance tossEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_4)
				(flyingEgo
					setLoop: 5
					cycleSpeed: 5
					setCycle: Fwd
					setStep: 5 13
					setMotion: MoveTo (+ (flyingEgo x:) local14) -25 self
				)
			)
			(1
				(= ticks 50)
			)
			(2
				(flyingEgo
					setLoop: 7
					cycleSpeed: 3
					setStep: 2 5
					setPri: -1
					posn: (+ (flyingEgo x:) (/ local14 2)) -10
					setMotion: MoveTo (+ (flyingEgo x:) local14) 62 self
				)
			)
			(3
				(flyingEgo setLoop: 8 cel: 0 cycleSpeed: 7 setCycle: End self)
			)
			(4
				(= seconds 3)
			)
			(5
				(if ((client register:) lastStaticCel:)
					(localproc_1 36 4)
				else
					(localproc_1 36 5)
				)
			)
		)
	)
)

(instance hitRock of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				local3
				(OneOf (gEgo cel:) 4 6 8 11 14)
				(!= local12 (gEgo cel:))
			)
			(if (== (gEgo cel:) 4)
				(gSoundEffects number: 441 loop: 1 play:)
			else
				(skimmerCrash
					number:
						(if (== (gEgo cel:) 6)
							442
						else
							(+ (skimmerCrash number:) 1)
						)
					loop: 1
					play:
				)
			)
		)
		(= local12 (gEgo cel:))
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(register ignoreActors: 1 setPri: -1)
				(if (register lastStaticCel:)
					(= local0 4)
				)
				(gSoundEffects number: 438 loop: 1 play:)
				(if (<= (++ local0) 4)
					(gEgo
						ignoreActors: 1
						setMotion: 0
						setCycle: 0
						setLoop: 3
						cel: 0
						cycleSpeed: 5
						setCycle: End self
					)
				else
					(= local3 1)
					(gLongSong stop:)
					(motorSound stop:)
					(shadow dispose:)
					(flyingEgo
						init:
						setPri: (+ (mtn1 priority:) 1)
						posn: (gEgo x:) (- (gEgo y:) 24)
					)
					(gEgo
						setMotion: 0
						setCycle: 0
						setLoop: 4
						cel: 0
						cycleSpeed: 8
						setCycle: End self
						setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 20)
					)
					(self setScript: tossEgo)
				)
				(DrawCel 136 0 local0 276 145 14)
			)
			(1
				(if (<= local0 4)
					(if (== local0 4)
						(gSoundEffects number: 446 loop: 4 play:)
					)
					(gEgo
						ignoreActors: 0
						setLoop: 0
						cel: 0
						cycleSpeed: 5
						setCycle: SCycler
					)
					(HandsOn)
					(localproc_2)
					(self dispose:)
				else
					(= local0 0)
					(gEgo setMotion: 0)
					(rock1 setMotion: 0 setScript: 0 setCycle: 0)
					(rock2 setMotion: 0 setScript: 0 setCycle: 0)
				)
			)
		)
	)
)

(instance theSMover of SMover
	(properties
		z 0
		heading 0
		noun 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		description 0
		sightAngle 0
		actions 0
		onMeCheck 0
		approachX 0
		approachY 0
		approachDist 1
		_approachVerbs 10
	)
)

(instance mtn1 of PicView
	(properties
		x 38
		y 55
		view 238
		loop 1
		cel 2
		priority 0
		signal 16
	)
)

(instance mtn2 of PicView
	(properties
		x 247
		y 56
		view 238
		priority 0
		signal 16
	)
)

(instance mtn3 of PicView
	(properties
		x 282
		y 56
		view 238
		loop 3
		cel 2
		priority 0
		signal 16
	)
)

(instance city of View
	(properties
		x 160
		y 55
		view 136
		loop 5
		signal 26624
	)
)

(instance damageGauge of PicView
	(properties
		x 293
		y 183
		description {gauge}
		lookStr {This gauge tells the amount of damage done to the skimmer.}
		view 136
		priority 13
	)
)

(instance shadow of Prop
	(properties
		view 26
		loop 6
		priority 1
		signal 24592
		cycleSpeed 2
	)

	(method (init)
		(self posn: (+ (gEgo x:) 3) (+ (gEgo y:) 3))
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(= x (+ (gEgo x:) 3))
		(= y (gEgo y:))
	)
)

(instance flyingEgo of Actor
	(properties
		view 26
		loop 5
		signal 26624
		cycleSpeed 8
		illegalBits 0
		moveSpeed 2
	)
)

(instance rock1 of Rock
	(properties
		yStep 6
		view 136
	)
)

(instance rock2 of Rock
	(properties
		yStep 6
		view 136
	)
)

(instance skimmerBase of Code
	(properties)

	(method (doit param1)
		(param1
			brTop: (- (param1 y:) 13)
			brLeft: (- (param1 x:) 25)
			brRight: (+ (param1 x:) 25)
			brBottom: (param1 y:)
		)
	)
)

(instance RockBase of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3)
		(= temp0 (= temp1 (= temp2 (= temp3 0))))
		(switch (param1 loop:)
			(1
				(= temp0 7)
				(= temp1 10)
				(= temp2 10)
			)
			(2
				(= temp0 3)
				(= temp2 8)
			)
			(3
				(= temp0 3)
				(= temp1 7)
				(= temp2 9)
			)
			(4
				(= temp0 3)
				(= temp1 8)
				(= temp2 16)
				(= temp3 1)
			)
		)
		(param1
			brTop: (- (param1 y:) temp0)
			brLeft: (- (param1 x:) temp1)
			brRight: (+ (param1 x:) temp2)
			brBottom: (- (param1 y:) temp3)
		)
	)
)

(instance motorSound of Sound
	(properties
		number 439
		loop -1
	)
)

(instance skimmerCrash of Sound
	(properties
		number 442
	)
)

(instance skimmerBanks of Sound
	(properties
		number 440
	)
)

