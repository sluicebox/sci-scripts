;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 147)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	goingUpTopStairs 0
	comingDownTopStairs 1
	goingUpBottomStairs 2
	comingDownBottomStairs 3
)

(instance goingUpTopStairs of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 147)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 104 84 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 113 84 self)
			)
			(2
				(gEgo setMotion: MoveTo 137 70 self)
			)
			(3
				(gEgo setMotion: MoveTo 153 70 self)
			)
			(4
				(HandsOn)
				(gEgo ignoreActors: 0 illegalBits: $8000)
				(self dispose:)
			)
		)
	)
)

(instance comingDownTopStairs of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 147)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 137 70 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 113 84 self)
			)
			(2
				(gEgo setMotion: MoveTo 104 84 self)
			)
			(3
				(gEgo setMotion: MoveTo 70 100 self)
			)
			(4
				(HandsOn)
				(ClearFlag 82)
				(gEgo ignoreActors: 0 illegalBits: $8800)
				(self dispose:)
			)
		)
	)
)

(instance goingUpBottomStairs of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 147)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 198 161 self
				)
			)
			(1
				(HandsOn)
				(gEgo ignoreActors: 0 illegalBits: $8000)
				(self dispose:)
			)
		)
	)
)

(instance comingDownBottomStairs of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 147)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 145 182 self
				)
			)
			(1
				(HandsOn)
				(ClearFlag 82)
				(gEgo ignoreActors: 0 illegalBits: $8800)
				(self dispose:)
			)
		)
	)
)

