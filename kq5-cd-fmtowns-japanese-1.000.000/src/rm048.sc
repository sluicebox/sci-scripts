;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 48)
(include sci.sh)
(use Main)
(use Interface)
(use n762)
(use KQ5Room)
(use LoadMany)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm048 0
)

(local
	[local0 6] = [0 3073 1 7027 0 0]
	[local6 9] = [1000 75 123 4 11 24 19 23 30]
	[local15 9] = [1003 154 123 4 11 25 23 31 31]
)

(instance rm048 of KQ5Room
	(properties
		picture 48
		north 49
		south 47
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 620 651)
		(if (== (gGame detailLevel:) 3)
			(wave0 init: setCycle: Fwd)
			(wave1 init: setCycle: Fwd)
			(wave2 init: setCycle: Fwd)
		)
		(self setFeatures: island)
		(HandsOff)
		(= global103 0)
		(switch gPrevRoomNum
			(49
				(if (== (gEgo view:) 21)
					(LoadMany rsVIEW 128 130)
					(self setScript: swimOutScript)
				else
					(self setScript: sailOutScript)
				)
			)
			(else
				(gGlobalSound number: 814 loop: -1 vol: 127 playBed:)
				(self setScript: sailInScript)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 100])
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)
)

(instance sailInScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (not (IsFlag 54))
					(SetScore 3)
					(proc762_0 @local6 @local15 @local0 self)
				else
					(= cycles 1)
				)
			)
			(2
				(boat
					init:
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo (boat x:) 170 self
				)
			)
			(3
				(gCurRoom newRoom: 49)
			)
		)
	)
)

(instance sailOutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(boat
					init:
					view: 620
					posn: (boat x:) 170
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo (boat x:) 219 self
				)
			)
			(1
				(gCurRoom newRoom: 47)
			)
		)
	)
)

(instance swimOutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(boat
					init:
					view: 128
					posn: (boat x:) 155
					setLoop: 4
					setCycle: Walk
					setStep: 1 1
					setMotion: MoveTo (boat x:) 175 self
				)
			)
			(1
				(boat view: 130 setLoop: 1 cycleSpeed: 2 setCycle: Fwd)
				(= seconds 4)
			)
			(2
				(= global330 524)
				(EgoDead)
			)
		)
	)
)

(instance boat of Actor
	(properties
		x 140
		y 219
		yStep 1
		view 620
		xStep 1
		moveSpeed 1
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (== view 620)
						(Say 533)
					else
						(Say 534)
					)
					(event claimed: 1)
				)
				(3 ; Do
					(event claimed: 1)
				)
			)
		)
	)
)

(instance island of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 535)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance wave0 of Prop
	(properties
		x 47
		y 150
		view 651
		priority 1
		signal 16400
		cycleSpeed 3
	)
)

(instance wave1 of Prop
	(properties
		x 147
		y 170
		view 651
		loop 1
		priority 1
		signal 16400
		cycleSpeed 3
	)
)

(instance wave2 of Prop
	(properties
		x 259
		y 151
		view 651
		loop 2
		priority 1
		signal 16400
		cycleSpeed 3
	)
)

