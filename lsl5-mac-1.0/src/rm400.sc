;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm400 0
)

(local
	seenMsg
	didPlay
	clapCnt
)

(instance rm400 of LLRoom
	(properties
		picture 400
		east 405
		west 410
	)

	(method (init)
		(LoadMany rsVIEW 400 401)
		(LoadMany rsSOUND 401 402 403 404)
		(gEgo init:)
		(HandsOff)
		(switch gPrevRoomNum
			(east
				(gEgo posn: 285 100 normalize: 570)
				(gEgo setScript: sFromManager)
			)
			(else
				(gTheMusic stop:)
				(gTheMusic2 stop:)
				(self style: 9)
				(gEgo loop: 3 cel: 2 posn: 195 96 normalize: 401)
				(gEgo setScript: sToManager)
			)
		)
		(super init:)
		(SetFFRoom 430)
	)

	(method (doit)
		(super doit:)
		(if (gEgo mover:)
			(switch (gEgo cel:)
				(0
					(if (== (stepSound number:) 404)
						(stepSound number: 402 play:)
					else
						(stepSound number: (+ (stepSound number:) 1) play:)
					)
				)
				(4
					(if (== (stepSound number:) 404)
						(stepSound number: 402 play:)
					else
						(stepSound number: (+ (stepSound number:) 1) play:)
					)
				)
			)
		)
	)

	(method (dispose)
		(gTheMusic fade: 0 15 12 1)
		(super dispose: &rest)
	)
)

(instance patrons of Prop
	(properties
		x 183
		y 81
		view 400
		cycleSpeed 18
	)

	(method (doit)
		(cond
			((< clapCnt 4)
				(if (== (self cel:) 1)
					(if (not didPlay)
						(gTheMusic number: 401 flags: 1 loop: 0 play:)
						(++ clapCnt)
						(= didPlay 1)
					)
				else
					(= didPlay 0)
				)
			)
			((== clapCnt 4)
				(self setCycle: 0 stopUpd:)
			)
		)
		(super doit:)
	)
)

(instance stepSound of Sound
	(properties
		number 404
	)
)

(instance sToManager of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(patrons init: setCycle: Fwd)
				(gEgo setLoop: 0 setCycle: End self cycleSpeed: 12)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo view: 570 setLoop: 8 setCel: 6)
				(= seconds 4)
			)
			(3
				(Say gEgo 400 0 #at -1 15 #width 280) ; "Oh, great," you think, "another lousy crowd. And on a Saturday night, too."
				(= ticks 30)
			)
			(4
				(Say gEgo 400 1 #at -1 15 #width 280) ; "Too many drinkers and talkers; too few listeners," you think. "Are there no good places left to play?"
				(= ticks 30)
			)
			(5
				(Say gEgo 400 2 #at -1 15 #width 280) ; "Another grimy week on a grimy stage before another grimy scene in a grimy office with another grimy little night club manager!"
				(= seconds 3)
			)
			(6
				(TPrint 400 3 #at -1 185) ; "(Just what did you expect from a club called "The Piano Pit," Patti?)"
				(= seconds 3)
			)
			(7
				(Say gEgo 400 4 #at -1 15 #width 280) ; "Finishing your bows, you head for the manager's office. "Now I suppose I'll have to endure another scene with that cheap club manager. The perfect way to top off a perfect week," you think sarcastically."
				(gEgo
					normalize:
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 270 95 self
				)
			)
			(8
				(Say gEgo 400 5) ; "Oh, well," you sigh, "Chin up! Positive attitude!"
				(TPrint 400 6 #at -1 185) ; "(Right. You feel positive he'll be a jerk!)"
				(gCurRoom newRoom: (gCurRoom east:))
			)
		)
	)
)

(instance sFromManager of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 160 100 self
				)
			)
			(1
				(Say gEgo 400 7) ; "That pig!" you think disgustedly. "Gawd, I wish there was some way to get even with the rotten crooks that run this stinking business!"
				(gEgo setMotion: MoveTo 32 100 self)
			)
			(2
				(TPrint 400 8) ; "Poor Patti. Once again, you're "too hip for the room!""
				(gCurRoom newRoom: (gCurRoom west:))
			)
		)
	)
)

