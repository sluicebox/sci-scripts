;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 609)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	climbRg 0
	climbing 1
	fallRight 2
	fallLeft 3
)

(instance climbRg of Rgn
	(properties)

	(method (init)
		(LoadMany rsVIEW 34 8 270)
		(LoadMany rsSOUND 95 17)
		(self keep: 0)
		(super init: &rest)
		(gCurRoom setScript: climbing)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/leaf')
				(Print 609 0) ; "The beanstalk's leaves are bigger than you are!"
			)
			((Said 'climb,climb>')
				(if (Said '<up,down')
					(Print 609 1) ; "Go ahead and climb."
				else
					(Print 609 2) ; "You are already climbing the beanstalk. Be careful!"
					(event claimed: 1)
				)
			)
			((Said 'get,get/leaf')
				(Print 609 3) ; "They are much too large to carry around."
			)
		)
	)
)

(instance climbing of Script
	(properties)

	(method (doit)
		(super doit:)
		(switch (gEgo onControl: 1)
			(128
				(gCurRoom setScript: fallRight)
			)
			(64
				(gCurRoom setScript: fallLeft)
			)
		)
	)
)

(instance fallRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 0 21) number: 17 loop: -1 init: play:) ; gameSound
				(gEgo
					view: 8
					setLoop: 5
					setCycle: Fwd
					cycleSpeed: 1
					cel: 0
					ignoreActors:
					illegalBits: 0
					setStep: 4 6
					setPri: 15
					setMotion: MoveTo (+ (gEgo x:) 20) 214 self
				)
			)
			(1
				(switch gCurRoomNum
					(72
						(self cue:)
					)
					(71
						(self changeState: 3)
					)
					(70
						(self changeState: 4)
					)
				)
			)
			(2
				(gCurRoom style: 42 drawPic: 71)
				(gEgo
					posn: 168 -10
					setStep: 4 8
					setMotion: MoveTo 180 214 self
				)
			)
			(3
				(gCurRoom style: 42 drawPic: 70)
				(gEgo
					posn: 182 -10
					setStep: 4 12
					setMotion: MoveTo 210 214 self
				)
			)
			(4
				(gCurRoom drawPic: global131 overlay: 270 100)
				(gEgo
					view: 34
					setCycle: 0
					setLoop: 5
					posn: 270 -10
					setStep: 2 15
					setMotion: MoveTo 276 170 self
				)
			)
			(5
				(crater loop: 1 init:)
				((ScriptID 0 21) number: 95 loop: 1 play:) ; gameSound
				(self cue:)
			)
			(6
				(gEgo loop: 3 cel: 0 cycleSpeed: 1 posn: 276 182)
				(proc0_7)
				(ShakeScreen 6)
				(gEgo setCycle: End)
				(= seconds 4)
			)
			(7
				(EgoDead {Looks like you had a bad fall this spring.})
			)
		)
	)
)

(instance fallLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 0 21) number: 17 loop: -1 init: play:) ; gameSound
				(gEgo
					view: 8
					setLoop: 4
					cel: 0
					setCycle: Fwd
					cycleSpeed: 1
					ignoreActors:
					illegalBits: 0
					setStep: 4 6
					setPri: 15
					setMotion: MoveTo (- (gEgo x:) 20) 214 self
				)
			)
			(1
				(switch gCurRoomNum
					(72
						(self cue:)
					)
					(71
						(self changeState: 3)
					)
					(70
						(self changeState: 4)
					)
				)
			)
			(2
				(gCurRoom style: 42 drawPic: 71)
				(gEgo
					posn: 148 -10
					setStep: 4 8
					setMotion: MoveTo 120 214 self
				)
			)
			(3
				(gCurRoom style: 42 drawPic: 70)
				(gEgo
					posn: 118 -10
					setStep: 4 12
					setMotion: MoveTo 106 214 self
				)
			)
			(4
				(gCurRoom drawPic: global131 overlay: 270 100)
				(gEgo
					setCycle: 0
					setLoop: 4
					view: 34
					posn: 54 -10
					setStep: 2 15
					setMotion: MoveTo 50 170 self
				)
			)
			(5
				(crater loop: 0 posn: 50 180 init:)
				((ScriptID 0 21) number: 95 loop: 1 play:) ; gameSound
				(self cue:)
			)
			(6
				(gEgo loop: 2 cel: 0 cycleSpeed: 1 posn: 50 180)
				(proc0_7)
				(ShakeScreen 6)
				(gEgo setCycle: End)
				(= seconds 4)
			)
			(7
				(EgoDead {Looks like you had a bad fall this spring.})
			)
		)
	)
)

(instance leaf1 of RPicView ; UNUSED
	(properties
		description {leaf}
		view 270
	)
)

(instance crater of View
	(properties
		x 276
		y 182
		description {hole}
		view 34
	)
)

