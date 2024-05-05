;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 48)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use LoadMany)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm048 0
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
		(if (> (gGame detailLevel:) 0)
			(wave0 setCycle: Fwd init:)
			(wave1 setCycle: Fwd init:)
			(wave2 setCycle: Fwd init:)
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
				(boat
					init:
					setLoop: 0
					setCycle: Walk
					setMotion:
						MoveTo
						(boat x:)
						(if (IsFlag 54) 170 else 190)
						self
				)
			)
			(2
				(if (not (IsFlag 54))
					(SetScore 3)
					(proc0_28 75 48 0 25 6) ; "Look, Graham! An island! Perhaps we should explore it."
					(proc0_28 160 48 1 25 6) ; "Yes, I think we should, Cedric."
					(= cycles 1)
				else
					(= cycles 1)
				)
			)
			(3
				(if (not (IsFlag 54))
					(boat
						init:
						setLoop: 0
						setCycle: Walk
						setMotion: MoveTo (boat x:) 170 self
					)
				else
					(= cycles 1)
				)
			)
			(4
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
				(= global330 {Oh no!__The water is too cold for swimming!})
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
						(PrintDC 48 2) ; "The boat seems to be seaworthy enough as it sails over the waves."
					else
						(PrintDC 48 3) ; "Graham is growing tired from swimming in the icy water."
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
					(PrintDC 48 4) ; "Within the sheltering waters of a surrounding reef, a craggy island rises abruptly from the sea. Just inside an opening in the reef, Graham can see an inviting little bay."
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
		detailLevel 3
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
		detailLevel 3
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
		detailLevel 3
	)
)

