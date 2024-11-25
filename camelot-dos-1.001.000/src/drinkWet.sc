;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 179)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	drinkWet 0
)

(local
	local0
	local1
)

(instance drinkWet of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 179)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 120)
				(cond
					((< (gEgo y:) 126)
						(gEgo setMotion: MoveTo (gEgo x:) 126 self)
					)
					((or (<= (gEgo y:) 133) (>= (gEgo y:) 150))
						(gEgo setMotion: MoveTo 100 (gEgo y:) self)
					)
					((< (gEgo x:) 140)
						(gEgo setMotion: MoveTo 100 (gEgo y:) self)
					)
					(else
						(gEgo setMotion: MoveTo (gEgo x:) 126 self)
					)
				)
			)
			(1
				(if (!= (gEgo y:) 126)
					(gEgo setMotion: MoveTo (gEgo x:) 126 self)
				else
					(self cue:)
				)
			)
			(2
				((= local0 (View new:))
					view: 89
					posn: (gEgo x:) (gEgo y:)
					setLoop: 8
					setCel: 0
					ignoreActors: 1
					init:
				)
				(gEgo
					view: 89
					setLoop: 1
					cel: 0
					illegalBits: 0
					x: (+ (gEgo x:) 1)
					z: 2
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(4
				((= local1 (Prop new:))
					view: 89
					ignoreActors: 1
					posn: (gEgo x:) (gEgo y:)
					setLoop: 4
					cycleSpeed: 1
					init:
					setCycle: Fwd
				)
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(if (== (Random 0 2) 0)
					(self changeState: 9)
				else
					(gEgo setLoop: 2 cel: 0 setCycle: End self)
				)
			)
			(7
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(8
				(gEgo setCycle: Beg self)
			)
			(9
				(gEgo setLoop: 2 cel: 1 setCycle: Beg self)
			)
			(10
				(local1 dispose:)
				(gEgo setLoop: 1 cel: 2 setCycle: Beg self)
			)
			(11
				(local0 dispose:)
				(gEgo setLoop: 2)
				(gEgo
					view: 41
					x: (- (gEgo x:) 1)
					z: 0
					setLoop: -1
					cel: 2
					illegalBits: $8000
					cycleSpeed: 0
					setCycle: Walk
				)
				(self cue:)
			)
			(12
				(if (!= (gEgo x:) 115)
					(gEgo setMotion: MoveTo 115 (gEgo y:) self)
				else
					(self cue:)
				)
			)
			(13
				(gEgo setMotion: MoveTo 115 (- (gEgo y:) 20))
			)
			(14
				(gEgo setMotion: MoveTo 115 90 self)
			)
			(15
				(gEgo setMotion: MoveTo 115 92 self)
			)
			(16
				(SetFlag 121)
				(client setScript: 0)
			)
		)
	)
)

