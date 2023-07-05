;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 613)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use System)

(public
	fallRight 0
	fallLeft 1
	fallSEast 2
	fallSWest 3
	fallNorth 4
	longFallBack 5
	longFallFront 6
	longFallSWest 7
	longFallLeft 8
	longFallRight 9
)

(procedure (localproc_0 param1)
	(HandsOff)
	(gEgo
		view: 66
		illegalBits: 0
		loop: param1
		cel: 0
		setMotion: 0
		cycleSpeed: 1
	)
)

(procedure (localproc_1)
	((ScriptID 0 21) number: 17 loop: 1 init: play:) ; gameSound
)

(instance fallRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 7)
				(gEgo setCycle: End self)
			)
			(1
				(gEgo loop: 0 cel: 2 setCycle: End self)
			)
			(2
				(localproc_1)
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(3
				(self setScript: fellOffTree)
			)
		)
	)
)

(instance fallLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 8)
				(gEgo setCycle: End self)
			)
			(1
				(gEgo loop: 1 cel: 2 setCycle: End self)
			)
			(2
				(localproc_1)
				(gEgo loop: 4 cel: 0 setCycle: End self)
			)
			(3
				(self setScript: fellOffTree)
			)
		)
	)
)

(instance fallSEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 0)
				(gEgo setCycle: End self)
			)
			(1
				(localproc_1)
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(2
				(self setScript: fellOffTree)
			)
		)
	)
)

(instance fallSWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 1)
				(gEgo setCycle: End self)
			)
			(1
				(localproc_1)
				(if (== gCurRoomNum 67)
					(gEgo loop: 4 cel: 0 setPri: 10 setCycle: End self)
				else
					(gEgo loop: 4 cel: 0 setCycle: End self)
				)
			)
			(2
				(self setScript: fellOffTree)
			)
		)
	)
)

(instance fallNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 2)
				(gEgo setCycle: End self)
			)
			(1
				(localproc_1)
				(gEgo
					setPri: (gEgo priority:)
					posn: (- (gEgo x:) 8) (- (gEgo y:) 22)
					loop: 3
					cel: 0
					setCycle: End self
				)
			)
			(2
				(self setScript: fellOffTree)
			)
		)
	)
)

(instance longFallBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 2)
				(gEgo setCycle: End self)
			)
			(1
				(localproc_1)
				(gEgo setPri: 1 loop: 5 cel: 0 setCycle: End self)
			)
			(2
				(self setScript: fellOffTree)
			)
		)
	)
)

(instance longFallFront of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 1)
				(gEgo setCycle: End self)
			)
			(1
				(localproc_1)
				(gEgo loop: 5 cel: 0 setCycle: End self)
			)
			(2
				(self setScript: fellOffTree)
			)
		)
	)
)

(instance longFallSWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 2)
				(gEgo setCycle: End self)
			)
			(1
				(localproc_1)
				(gEgo setPri: 1 loop: 5 cel: 0 setCycle: End self)
			)
			(2
				(self setScript: fellOffTree)
			)
		)
	)
)

(instance longFallLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 8)
				(gEgo setCycle: End self)
			)
			(1
				(localproc_1)
				(gEgo setPri: 1 loop: 5 cel: 0 setCycle: End self)
			)
			(2
				(self setScript: fellOffTree)
			)
		)
	)
)

(instance longFallRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 7)
				(gEgo setCycle: End self)
			)
			(1
				(localproc_1)
				(gEgo setPri: 1 loop: 6 cel: 0 setCycle: End self)
			)
			(2
				(self setScript: fellOffTree)
			)
		)
	)
)

(instance fellOffTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 1)
					(Print 613 0) ; "As you fall, the magic ring slips from your finger."
					(gGame changeScore: -3)
				)
				(self cue:)
			)
			(1
				((ScriptID 0 21) fade:) ; gameSound
				(EgoDead {WHOOPS!})
				(self dispose:)
			)
		)
	)
)

