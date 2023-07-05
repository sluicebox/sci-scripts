;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 166)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Save)
(use Motion)
(use Actor)
(use System)

(public
	threeMercenaryAttack 0
)

(instance guardWindow of SysWindow
	(properties
		back 9
		title {City Guard}
		brTop 5
		brBottom 80
	)
)

(instance mercenary1 of Act
	(properties
		yStep 6
		view 333
		signal 16384
		illegalBits 0
		xStep 8
	)
)

(instance mercenary2 of Act
	(properties
		yStep 6
		view 333
		signal 16384
		illegalBits 0
		xStep 8
	)
)

(instance mercenary3 of Act
	(properties
		yStep 6
		view 333
		signal 16384
		illegalBits 0
		xStep 8
	)
)

(instance threeMercenaryAttack of Script
	(properties)

	(method (init)
		(Load rsVIEW 333)
		(Load rsVIEW 396)
		(Load rsVIEW 81)
		(Load rsSOUND 82)
		(super init: &rest)
		(HandsOff)
		(if (> (gEgo x:) 160)
			(mercenary1 posn: 335 150)
			(mercenary2 posn: (+ (gEgo x:) 100) 210)
			(mercenary3 posn: (- (gEgo x:) 90) 200)
		else
			(mercenary1 posn: -15 150)
			(mercenary2 posn: (+ (gEgo x:) 100) 210)
			(mercenary3 posn: (- (gEgo x:) 100) 200)
		)
		(if (== gCurRoomNum 66)
			(mercenary1 posn: (if (> (gEgo x:) 220) 200 else 280) 215)
			(mercenary2 posn: 220 210)
			(mercenary3
				posn:
					(if (> (gEgo x:) 125)
						(- (gEgo x:) 50)
					else
						125
					)
					200
			)
		)
		(mercenary1 init: setScript: (mercenaryAttack new:))
		(mercenary2 init: setScript: (mercenaryAttack new:))
		(mercenary3 init: setScript: (mercenaryAttack new:))
		(if (IsFlag 20)
			(if (<= (- (gMuleObj x:) 90) (mercenary2 x:) (gMuleObj x:))
				(mercenary2 dispose:)
			)
			(if (<= (gMuleObj x:) (mercenary2 x:) (+ (gMuleObj x:) 90))
				(mercenary2 dispose:)
			)
			(if (<= (- (gMuleObj x:) 90) (mercenary3 x:) (gMuleObj x:))
				(mercenary3 dispose:)
			)
			(if (<= (gMuleObj x:) (mercenary3 x:) (+ (gMuleObj x:) 90))
				(mercenary3 dispose:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(< global168 2)
				(== ((mercenary1 script:) state:) 1)
				(== ((mercenary2 script:) state:) 1)
				(== ((mercenary3 script:) state:) 1)
				(== state 0)
			)
			(self changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gTObj talkCue: 0 endTalk: tWindow: guardWindow)
				(guardWindow brLeft: 10 brRight: 200)
				(gTObj talkCue: self)
				(Talk 166 0) ; "We have orders to find a thief!"
			)
			(2
				(guardWindow brLeft: 80 brRight: 280)
				(gTObj talkCue: self)
				(Talk 166 1) ; "And we have never seen YOU before."
			)
			(3
				(guardWindow brLeft: 120 brRight: 320)
				(gTObj talkCue: self)
				(Talk 166 2) ; "He must be the one! Kill him!"
			)
			(4
				((mercenary1 script:) cue:)
				((mercenary2 script:) cue:)
				((mercenary3 script:) cue:)
			)
		)
	)
)

(instance mercenaryAttack of Script
	(properties)

	(method (init)
		(super init: &rest)
		(client setCycle: Walk)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0
					(switch client
						(mercenary1 0)
						(mercenary2 5)
						(mercenary3 10)
					)
				)
				(if (> (client x:) (gEgo x:))
					(client
						setMotion:
							MoveTo
							(+ (gEgo x:) 50)
							(+ (gEgo y:) temp0)
							self
					)
				else
					(client
						setMotion:
							MoveTo
							(- (gEgo x:) 50)
							(+ (gEgo y:) temp0)
							self
					)
				)
			)
			(1
				(if (>= global168 2)
					(= cycles 1)
				)
			)
			(2
				(client
					view: 396
					setLoop: (if (> (client x:) (gEgo x:)) 1 else 0)
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(3
				(if (!= (gRmMusic number:) 82)
					(gRegMusic stop:)
					(gRmMusic number: 82 loop: 1 play:)
				)
				(if (!= (gEgo view:) 81)
					(gEgo view: 81 loop: 0 cel: 0 setCycle: End self)
				)
				(client setCycle: End)
			)
			(4
				(cond
					((>= global168 2)
						(mercenary1 setMotion: 0 setCycle: 0)
						(mercenary2 setMotion: 0 setCycle: 0)
						(mercenary3 setMotion: 0 setCycle: 0)
						(Print 166 3) ; "Did I not warn you against this? But do you listen? Nay, you are too stubborn. Now you are reduced to shish kebab."
						(DisposeScript 166)
						(EgoDead)
					)
					((IsFlag 167)
						(Print 166 4) ; "You did not even try to defend yourself, nor can I blame you, after the Seeress crushed any hope of finding the Grail."
						(Print 166 5) ; "Perhaps you will be wiser in your next life."
						(DisposeScript 166)
						(EgoDead)
					)
					((not (gEgo has: 3)) ; purse
						(Print 166 6) ; "You die in poverty, mistaken for a common thief. In your next life, listen more carefully to Mohammed's hints. He is not short of a coin."
						(DisposeScript 166)
						(EgoDead)
					)
					(else
						(Print 166 7) ; "The reward for greed is death. In your next life, consider fulfilling the tasks of the Seeress in a more worthwhile manner."
						(DisposeScript 166)
						(EgoDead)
					)
				)
			)
		)
	)
)

