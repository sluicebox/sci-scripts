;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 233)
(include sci.sh)
(use Main)
(use n010)
(use goGet)

(public
	enterCind 0
	enterJack 1
	enterBremenNo 2
	enterBeautyNo 3
	enterSnowNo 4
	enterBremenFol 5
	enterSnowFol 6
)

(instance enterCind of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 233)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (gCindStory state:)
					(0
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 233 0) ; bookWyrm
					)
					(3
						(proc10_13 1 (ScriptID 230 2) gEgo self 1 233 1) ; bookWyrm
					)
					(else
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 233 2) ; bookWyrm
					)
				)
				(= ticks 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance enterJack of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 233)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (gJackStory state:)
					(0
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 233 3) ; bookWyrm
					)
					(3
						(if (not (gEgo has: 3))
							(proc10_13 3 (ScriptID 230 2) gEgo self 1 233 4) ; bookWyrm
						else
							(= cycles 1)
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance enterBremenNo of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 233)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (gBremenStory state:)
					(0
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 233 5) ; bookWyrm
					)
					(2
						(proc10_13 0 (ScriptID 230 2) gEgo -1 0 233 6) ; bookWyrm
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 233 7) ; bookWyrm
					)
					(4
						(proc10_13 0 (ScriptID 230 2) gEgo -1 0 233 8) ; bookWyrm
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 233 9) ; bookWyrm
					)
					(6
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 233 10) ; bookWyrm
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance enterBeautyNo of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 233)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (gBeautyStory state:)
					(0
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 233 11) ; bookWyrm
					)
					(1
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 233 12) ; bookWyrm
					)
					(3
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 233 13) ; bookWyrm
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 233 14) ; bookWyrm
					)
					(else
						(proc10_13 0 (ScriptID 230 2) gEgo -1 0 233 15) ; bookWyrm
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 233 16) ; bookWyrm
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance enterSnowNo of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 233)
	)

	(method (changeState newState &tmp [temp0 200])
		(switch (= state newState)
			(0
				(switch (gSnowStory state:)
					(0
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 233 17) ; bookWyrm
					)
					(2
						(proc10_13
							0
							(ScriptID 230 2) ; bookWyrm
							gEgo
							-1
							0
							(Format @temp0 233 18 @global110) ; "Oh, %s, the Seven Dwarves need your help."
						)
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 233 19) ; bookWyrm
					)
					(3
						(proc10_13 0 (ScriptID 230 2) gEgo -1 0 233 20) ; bookWyrm
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 233 21) ; bookWyrm
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance enterBremenFol of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 233)
	)

	(method (changeState newState &tmp [temp0 200])
		(switch (= state newState)
			(0
				(switch (global224 talkerID:)
					(6
						(proc10_13 0 (ScriptID 230 2) global224 -1 0 233 22) ; bookWyrm
						(proc10_13
							0
							(ScriptID 230 2) ; bookWyrm
							gEgo
							-1
							1
							(Format @temp0 233 23 @global110) ; "Hello again, %s."
						)
						(proc10_13 0 global224 (ScriptID 230 2) self 1 233 24) ; bookWyrm
					)
					(7
						(proc10_13
							0
							(ScriptID 230 2) ; bookWyrm
							global224
							-1
							1
							(Format @temp0 233 25 @global110) ; "Hello, Cat. I see %s found you."
						)
						(proc10_13 0 global224 (ScriptID 230 2) -1 1 233 26) ; bookWyrm
						(proc10_13 0 (ScriptID 230 2) global224 -1 1 233 27) ; bookWyrm
						(proc10_13
							0
							global224
							gEgo
							-1
							0
							(Format @temp0 233 28 @global110) ; "Good. %s, let's hurry."
						)
						(proc10_13 0 global224 gEgo self 1 233 29)
					)
					(8
						(proc10_13 0 (ScriptID 230 2) global224 -1 1 233 30) ; bookWyrm
						(proc10_13 0 global224 (ScriptID 230 2) -1 1 233 31) ; bookWyrm
						(proc10_13 0 (ScriptID 230 2) global224 -1 1 233 32) ; bookWyrm
						(proc10_13 0 global224 gEgo -1 1 233 33)
						(proc10_13 0 (ScriptID 230 2) global224 -1 1 233 34) ; bookWyrm
						(proc10_13
							0
							global224
							gEgo
							-1
							1
							(Format @temp0 233 35 @global110) ; "Great! Come on, let's go, %s."
						)
						(self setScript: (ScriptID 232 3) self) ; dogGo
					)
					(9
						(proc10_13
							0
							(ScriptID 230 2) ; bookWyrm
							global224
							-1
							1
							(Format @temp0 233 36 @global110) ; "So %s found you, Gray. What happened to you?"
						)
						(proc10_13 0 global224 (ScriptID 230 2) -1 0 233 37) ; bookWyrm
						(proc10_13
							0
							global224
							(ScriptID 230 2) ; bookWyrm
							self
							1
							(Format @temp0 233 38 @global110) ; "%s untied me and led me here."
						)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance enterSnowFol of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 233)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (global224 talkerID:)
					(15
						(proc10_13 0 (ScriptID 230 2) global224 -1 1 233 39) ; bookWyrm
						(proc10_13 0 global224 (ScriptID 230 2) self 1 233 40) ; bookWyrm
					)
					(16
						(proc10_13 0 (ScriptID 230 2) global224 -1 1 233 41) ; bookWyrm
						(proc10_13 0 global224 (ScriptID 230 2) -1 0 233 42) ; bookWyrm
						(proc10_13 0 global224 (ScriptID 230 2) self 1 233 43) ; bookWyrm
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

