;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 781)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	runVoiceCredits 0
)

(local
	local0 = 20
	local1
	local2
	[local3 16]
	[local19 16]
	local35
)

(procedure (localproc_0)
	(= local2 0)
	(for ((= local1 0)) (< local1 (creditTitle lastCel:)) ((++ local1))
		(= [local3 local1]
			(creditName
				x: 15
				view:
					(switch local0
						(20 798)
						(21 799)
						(22 794)
					)
				new:
			)
		)
		([local3 local1] setLoop: 0 setCel: (+ local1 1))
		(++ local2)
	)
)

(procedure (localproc_1)
	(= local2 0)
	(for ((= local1 0)) (< local1 (creditTitle lastCel:)) ((++ local1))
		(= [local19 local1]
			(creditName
				x: 210
				view:
					(switch local0
						(20 798)
						(21 799)
						(22 794)
					)
				new:
			)
		)
		([local19 local1] setLoop: 1 setCel: (+ local1 1))
		(++ local2)
	)
)

(instance runVoiceCredits of Script
	(properties)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(creditTitle
					view:
						(switch local0
							(20 798)
							(21 799)
							(22 794)
						)
					setLoop: 0
					init:
					addToPic:
				)
				(localproc_0)
				(localproc_1)
				(= cycles 1)
			)
			(1
				(= local35 40)
				(= local1 0)
				(= cycles 1)
			)
			(2
				([local3 local1] init:)
				([local19 local1] init:)
				([local3 local1] setMotion: MoveTo 15 local35)
				([local19 local1] setMotion: MoveTo 210 local35 self)
				(= cycles 1)
			)
			(3
				(if (>= (+ local1 1) local2)
					(= state 4)
				else
					0
				)
			)
			(4
				([local3 local1] addToPic:)
				([local19 local1] addToPic:)
				(++ local1)
				(= local35 (+ (/ 164 local2) local35))
				(= state 1)
				(self cue:)
			)
			(5
				(= ticks 300)
			)
			(6
				(gAddToPics eachElementDo: #dispose)
				(gAddToPics eachElementDo: #delete)
				(gCast eachElementDo: #dispose)
				(gCast eachElementDo: #delete)
				(gCurRoom drawPic: 780)
				(= cycles 2)
			)
			(7
				(= cycles 2)
			)
			(8
				(if (< local0 22)
					(++ local0)
					(self changeState: -1)
					(= cycles 2)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance creditTitle of Actor
	(properties
		x 9
		y 20
	)
)

(instance creditName of Actor
	(properties
		x 86
		y 220
		cel 1
		signal 16384
		moveSpeed 1
	)
)

