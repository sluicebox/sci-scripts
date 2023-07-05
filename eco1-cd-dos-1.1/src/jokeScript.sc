;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use System)

(public
	jokeScript 0
)

(local
	[local0 35] = [0 6 9 12 14 16 18 20 22 24 26 28 30 32 34 37 39 41 43 45 48 51 53 56 58 61 63 65 67 69 71 73 75 77 79]
)

(instance jokeScript of Script
	(properties)

	(method (init)
		(= register [local0 global246])
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 1)
	)

	(method (changeState newState &tmp temp0)
		(if (== global246 17)
			(= register [local0 (++ global246)])
		)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 1 0 0 register 1 self 1) ; Delphineus
			)
			(1
				(= temp0
					(cond
						((== register 37) 53)
						((== register 38) 13)
						((> register 38)
							(- register 6)
						)
						(else
							(- register 4)
						)
					)
				)
				((ScriptID 2 1) init: 2 0 0 temp0 1 self 1) ; Adam
			)
			(2
				(if (< (++ register) [local0 (+ global246 1)])
					(= state -1)
					(self cue:)
				else
					(= global246
						(if (== global246 33)
							1
						else
							(+ global246 1)
						)
					)
					(self dispose:)
				)
			)
		)
	)
)

