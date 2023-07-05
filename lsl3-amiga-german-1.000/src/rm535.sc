;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 535)
(include sci.sh)
(use Main)
(use Interface)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm535 0
)

(local
	[local0 150]
	[local150 66]
)

(instance rm535 of Rm
	(properties
		picture 535
		horizon 1
	)

	(method (init)
		(Load rsSOUND 4)
		(Load rsSOUND 536)
		(gMusic number: 535 loop: -1 play:)
		(HandsOff)
		(if (TestFlag 15)
			(= gNormalEgoView 803)
		)
		(super init:)
		(aBird1 init:)
		(aBird2 init:)
		(aBird3 init:)
		(self setScript: RoomScript)
		(gEgo
			view: 536
			loop: 0
			cel: 0
			ignoreActors:
			setStep: 1 1
			moveSpeed: 1
			cycleSpeed: 1
			posn: 49 26
			init:
		)
	)
)

(instance RoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(if (== gNormalEgoView 803)
					(Print 535 0 #at 10 -1 #width 290) ; "You feel certain your informal safety harness will help you pass safely over this canyon."
					(Print 535 1 #at -1 144) ; "(But are your feelings correct?)"
				else
					(Print 535 2 #at 10 -1 #width 290) ; "Well, well, well. Isn't this another fine mess you've gotten us into! Now you're hanging by your hands and knees from a rope woven from marijuana stems suspended high above a tremendously deep chasm."
				)
				(gEgo setMotion: MoveTo 280 26)
				(= cycles (Random 55 111))
			)
			(2
				(if (!= gNormalEgoView 803)
					(Print 535 3) ; "Your hands rapidly tire from holding your body's full weight on the rope."
				)
				(= cycles (Random 55 111))
			)
			(3
				(if (!= gNormalEgoView 803)
					(if (>= gFilthLevel 3)
						(Print 535 4) ; "You are having trouble keeping your knees together."
						(Print 535 5 #at -1 144) ; "...an experience not wholly unfamiliar to you!"
					else
						(Print 535 6) ; "Your legs are becoming fatigued; you wonder how long you will be able to continue!"
					)
				else
					(Print 535 7) ; "Your improvised safety harness works! You feel you may be able to make it all the way across!"
				)
				(= cycles (Random 55 111))
			)
			(4
				(if (== gNormalEgoView 803)
					(gEgo setMotion: MoveTo 280 26 self)
				else
					(self changeState: 7)
				)
			)
			(5
				(gMusic number: 536 loop: 1 play:)
				(Print 535 8) ; "You did it, Patti! But, now you wonder if there was something you forgot before you left."
				(Print 535 9) ; "Of course, you could always take the rope back again!"
				(= cycles 33)
			)
			(6
				(= gEgoState 0)
				(gCurRoom newRoom: 530)
			)
			(7
				(gMusic number: 4 loop: 1 play:)
				(gEgo
					moveSpeed: 0
					cycleSpeed: 0
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(8
				(Print 535 10 #at 10 5 #dispose) ; "LOOK OUT!!"
				(gEgo setMotion: theJump)
			)
			(9
				(gGame setScript: (ScriptID 40)) ; DyingScript
				((ScriptID 40) ; DyingScript
					caller: 814
					register: (Format @local0 535 11) ; "If only you had some way to secure yourself to the rope. Your hands have certain skills, but rope grasping is not one of them!"
					next: (Format @local150 535 12) ; "Remember Christopher Reeves"
				)
			)
		)
	)
)

(instance aBird1 of Actor
	(properties
		x 13
		y 19
		view 535
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setScript: Bird1Script setCycle: Walk)
	)
)

(instance Bird1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (Random 0 2))
					(= seconds (Random 3 7))
				)
			)
			(1
				(aBird1 setMotion: MoveTo 333 19 self)
			)
		)
	)
)

(instance aBird2 of Actor
	(properties
		x 274
		y 138
		view 535
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setScript: Bird2Script setCycle: Walk)
	)
)

(instance Bird2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (Random 0 3))
					(= seconds (Random 1 3))
				)
			)
			(1
				(aBird2 setMotion: MoveTo -14 138 self)
			)
		)
	)
)

(instance aBird3 of Actor
	(properties
		view 535
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self posn: (Random 70 234) 23 setScript: Bird3Script setCycle: Walk)
	)
)

(instance Bird3Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (> 11 (client distanceTo: gEgo)))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(aBird3 setMotion: MoveTo 335 155 self)
			)
		)
	)
)

(instance theJump of Jump
	(properties)

	(method (init)
		(super init: gEgo RoomScript)
		(self yStep: 5 y: 300)
	)
)

