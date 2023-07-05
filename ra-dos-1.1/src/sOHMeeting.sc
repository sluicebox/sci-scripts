;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 442)
(include sci.sh)
(use Main)
(use PolyPath)
(use Motion)
(use System)

(public
	sOHMeeting 0
	sOHNoMeet 1
	sOHLeave 2
)

(local
	local0
)

(instance sOHMeeting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				((ScriptID 32 0) ; aHeimlich
					init:
					view: 814
					loop: 1
					setPri: 9
					x: 225
					y: 138
					room: 440
				)
				(= cycles 1)
			)
			(2
				((ScriptID 32 0) setPri: 9 setMotion: MoveTo 189 145 self) ; aHeimlich
			)
			(3
				((ScriptID 32 0) setPri: -1 setMotion: MoveTo 127 154 self) ; aHeimlich
			)
			(4
				((ScriptID 90 2) setMotion: PolyPath 124 156 self) ; aOlympia
				((ScriptID 32 0) setMotion: MoveTo 86 159 self) ; aHeimlich
			)
			(5 0)
			(6
				(Face (ScriptID 32 0) (ScriptID 90 2)) ; aHeimlich, aOlympia
				(= cycles 5)
			)
			(7
				(gMessager say: 2 0 3 0 self 1440) ; "Wolfie, your facial scars are so wonderful! How did you get them?"
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance sOHNoMeet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 98 161 self)
			)
			(2
				((ScriptID 32 0) ; aHeimlich
					init:
					view: 814
					setPri: 9
					x: 225
					y: 138
					room: 440
				)
				(Face gEgo (ScriptID 32 0)) ; aHeimlich
				(= cycles 1)
			)
			(3
				((ScriptID 32 0) setPri: 9 setMotion: MoveTo 189 145 self) ; aHeimlich
			)
			(4
				((ScriptID 32 0) setPri: -1 setMotion: MoveTo 127 154 self) ; aHeimlich
			)
			(5
				((ScriptID 90 2) setMotion: PolyPath 176 150 self) ; aOlympia
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance sOHLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				((ScriptID 90 2) setMotion: PolyPath 228 133 sOHLeave) ; aOlympia
				((ScriptID 32 0) setPri: -1 setMotion: MoveTo 189 145 self) ; aHeimlich
			)
			(2
				((ScriptID 32 0) setPri: 9 setMotion: MoveTo 230 138 self) ; aHeimlich
			)
			(3 0)
			(4
				(= seconds 1)
			)
			(5
				((ScriptID 32 0) dispose:) ; aHeimlich
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if
			(and
				(== (self state:) 3)
				(not ((ScriptID 90 2) mover:)) ; aOlympia
				(not ((ScriptID 32 0) mover:)) ; aHeimlich
				(not local0)
			)
			(= local0 1)
			(self cue:)
		)
		(super doit:)
	)
)

