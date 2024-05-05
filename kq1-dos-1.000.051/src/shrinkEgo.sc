;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 779)
(include sci.sh)
(use Main)
(use Motion)
(use User)
(use Menu)
(use System)

(public
	shrinkEgo 0
)

(instance shrinkEgo of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== state 3) (== gCurRoomNum 78) (== (gEgo onControl: 1) 128))
			(= seconds 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (== gCurRoomNum 78) (== (gEgo onControl: 1) 128))
					(gEgo setMotion: MoveTo 304 145 self)
				else
					(self cue:)
				)
			)
			(1
				(HandsOff)
				(gEgo
					view: 24
					cel: 0
					cycleSpeed: 1
					setCycle: End self
					setMotion: 0
				)
				(proc0_8 19 0)
			)
			(2
				((ScriptID 0 21) number: 20 init: play:) ; gameSound
				(gEgo view: 30 setCycle: End self)
			)
			(3
				(gEgo
					view: 31
					setStep: 2 1
					cycleSpeed: 0
					illegalBits: -32768
					setCycle: Walk
				)
				(if (== gCurRoomNum 78)
					(SetScore 104 2)
					(User canControl: 1)
					(MenuBar state: 1)
					(= seconds 10)
				else
					(gGame changeScore: -1)
					(= seconds 4)
				)
			)
			(4
				(User canControl: 0)
				(if (and (== gCurRoomNum 78) (== (gEgo onControl: 1) 2))
					(EgoDead
						{The mushroom wore off and you enlarged.__But you can't squeeze a five-foot Knight into a 6-inch hole!}
					)
				else
					((ScriptID 0 21) number: 21 play:) ; gameSound
					(gEgo
						view: 30
						cycleSpeed: 1
						cel: 6
						setMotion: 0
						illegalBits: -32766
						setCycle: Beg self
					)
				)
			)
			(5
				(proc0_1)
				(gEgo loop: 2 illegalBits: -32766)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

