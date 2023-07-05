;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 368)
(include sci.sh)
(use Main)
(use volleyRm)
(use Motion)
(use Actor)
(use System)

(public
	cprEndScript 0
)

(instance Doctor of Act
	(properties
		y 124
		x 330
		view 303
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/doc,man]>')
				(cond
					((Said 'look[<at]')
						(proc3_7 368 0) ; "The doctor looks very professional."
					)
					((Said 'talk')
						(proc3_7 368 1) ; "He's too busy to chat."
					)
					((Said 'thank')
						(proc3_7 368 2) ; "He replies, "You're welcome.""
					)
				)
			)
		)
	)
)

(instance cprEndScript of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 368)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc3_7 368 3) ; "Quickly, you locate the bottom of the sternum. Using your index and middle fingers, you measure up the chest finding the proper point to start the compressions."
				(proc3_7 368 4) ; "Using the heel of your hands (keeping your fingers from touching the chest), you start chest compressions at a ratio of 15 compressions to 2 breaths."
				(proc3_7 368 5) ; "You act fast, compressing the chest one and a half to two inches at a rate of 80 - 100 compressions per minute."
				(proc3_7 368 6) ; "In the excitement, you think to yourself, "I must check her pulse in 1 minute.""
				(gEgo setLoop: 1 cycleSpeed: 3 setCycle: Fwd)
				(= seconds 10)
			)
			(1
				(gEgo setLoop: 0 setCel: 0 setCycle: CT 3 1)
				(= seconds 2)
			)
			(2
				(proc3_7 368 7) ; "You check the carotid artery again. You become excited as you notice she is breathing on her own and you detect a faint pulse at the same time."
				(gEgo setCel: 3 setCycle: Beg self)
			)
			(3
				(gEgo setLoop: 1 cycleSpeed: 3 setCycle: Fwd)
				(= seconds 10)
			)
			(4
				(gEgo cycleSpeed: 0 setCycle: Beg self)
			)
			(5
				(proc3_7 368 8) ; "You continue checking her pulse and detect that it's getting stronger and stronger."
				(= seconds 3)
			)
			(6
				(Doctor
					init:
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 248 124 self
				)
			)
			(7
				(Doctor setLoop: 4 setCel: 0 setCycle: End self)
			)
			(8
				(Doctor setLoop: 6 setCel: 0 setCycle: End self)
			)
			(9
				(proc3_7 368 9) ; "You watch as the doctor checks the girl over."
				(Doctor setLoop: 7 cycleSpeed: 3 setCycle: Fwd)
				(= seconds 5)
			)
			(10
				(Doctor setLoop: 6 setCel: 5 cycleSpeed: 0 setCycle: Beg self)
			)
			(11
				(proc3_7 368 10) ; "The doctor turns to you and says..."
				(proc3_7 368 11) ; "Well sir! Thanks to you, this young lady is going to be just fine."
				(= cycles 2)
			)
			(12
				(proc3_7 368 12) ; "She starts moaning and mumbling and attempting to get up."
				(proc3_7 368 13) ; "She insists on standing, so you help her up."
				(gEgo setLoop: 2 setCycle: End self)
			)
			(13
				(gCurRoom notify: 3 1)
				(Doctor setLoop: 5 setCel: 5 setCycle: Beg self)
			)
			(14
				(Doctor
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 350 (Doctor y:) self
				)
			)
			(15
				(Doctor dispose:)
				(gEgo
					view: 200
					setLoop: -1
					posn: 240 121
					setCycle: Walk
					heading: 180
				)
				(gEgo cel: 2)
				(DirLoop gEgo (gEgo heading:))
				((ScriptID 3 2) ; Girl
					init:
					setCycle: Walk
					view: 203
					setLoop: -1
					posn: 246 122
					heading: 270
				)
				(DirLoop (ScriptID 3 2) ((ScriptID 3 2) heading:)) ; Girl, Girl
				(proc3_7 368 14) ; "Although still a little shook up, the young lady you just rescued thanks you for saving her life and says..."
				(proc3_7 368 15) ; "I was foolish to go into the water after just eating! It was fortunate for me that you were here and that you're a strong swimmer."
				(= seconds 4)
			)
			(16
				((ScriptID 3 2) ; Girl
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 360 ((ScriptID 3 2) y:) ; Girl
				)
				((ScriptID 3 6) ; Girl2
					illegalBits: 0
					ignoreActors:
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 360 ((ScriptID 3 2) y:) self ; Girl
				)
				(gCurRoom notify: 3 0)
			)
			(17
				((ScriptID 3 2) dispose:) ; Girl
				((ScriptID 3 6) dispose:) ; Girl2
				(HandsOn)
				(gCurRoom notify: 0 0)
				(self dispose:)
			)
		)
	)
)

