;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 501)
(include sci.sh)
(use Main)
(use rm500)
(use Print)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	buyFarm 0
	travelFreeway 1
)

(local
	local0
	local1
)

(instance buyFarm of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(= gPrevRoomNum 500)
		(gCurRoom init:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 209)
				(Load rsSOUND 910)
				(Load rsSOUND 905)
				(gLongSong2 stop:)
				(gLongSong stop:)
				(gLongSong2 number: 910 setLoop: 1 play:)
				(car2 init: self register)
			)
			(1
				(explosion init: setCycle: End)
				(crashSound number: 905 setLoop: 1 play:)
				(switch register
					(0
						(explosion posn: 277 72)
						((ScriptID 500 1) ; car
							view: (+ ((ScriptID 500 1) view:) 1) ; car
							cel: 0
							setCycle: End
							setMotion: MoveTo 319 35 self
						)
						(car2 setMotion: MoveTo 269 74 self)
					)
					(1
						(explosion posn: 242 43)
						((ScriptID 500 1) ; car
							view: (+ ((ScriptID 500 1) view:) 3) ; car
							cel: 0
							setCycle: End
							setMotion: MoveTo 186 71 self
						)
						(car2 setMotion: MoveTo 210 40 self)
					)
					(2
						(explosion posn: 233 67)
						((ScriptID 500 1) ; car
							view: (+ ((ScriptID 500 1) view:) 6) ; car
							cel: 0
							setCycle: End
							setMotion: MoveTo 285 107 self
						)
						(car2 setMotion: MoveTo 233 37 self)
					)
					(3
						(explosion posn: 282 44)
						((ScriptID 500 1) ; car
							view: (+ ((ScriptID 500 1) view:) 7) ; car
							cel: 0
							setCycle: End
							setMotion: MoveTo 234 -10 self
						)
						(car2 setMotion: MoveTo 283 80 self)
					)
				)
			)
			(2
				(explosion dispose:)
			)
			(3
				(= seconds 3)
			)
			(4
				(Prints {You die})
				(car2 dispose:)
				((ScriptID 500 1) ; car
					view: ((ScriptID 500 1) view:) ; car
					loop: 0
					cel: register
				)
				(self dispose:)
			)
		)
	)
)

(instance car2 of Actor
	(properties
		yStep 8
		view 224
		priority 5
		signal 16400
		xStep 12
		moveSpeed 2
	)

	(method (init param1 param2)
		(self view: 224 loop: 0)
		(switch param2
			(0
				(self cel: 0 posn: 133 74)
			)
			(1
				(self cel: 1 posn: 379 40)
			)
			(2
				(self cel: 2 posn: 230 -53)
			)
			(3
				(self cel: 3 posn: 283 167)
			)
		)
		(super init: &rest)
		(switch param2
			(0
				(self setMotion: MoveTo 215 74 param1)
			)
			(1
				(self setMotion: MoveTo 300 40 param1)
			)
			(2
				(self setMotion: MoveTo 230 11 param1)
			)
			(3
				(self setMotion: MoveTo 283 99 param1)
			)
		)
	)
)

(instance explosion of Prop
	(properties
		view 209
		priority 15
		signal 16400
		cycleSpeed 12
	)
)

(instance travelFreeway of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				((ScriptID 500 5) dispose:) ; lines
				((ScriptID 500 1) hide:) ; car
				(switch global249
					(773
						(if (== register 1)
							(= local0 129)
							(= local1 107)
						else
							(= local0 179)
							(= local1 82)
						)
					)
					(774
						(if (== register 1)
							(= local0 5)
							(= local1 94)
						else
							(= local0 158)
							(= local1 18)
						)
					)
					(775
						(if (== register 1)
							(= local0 24)
							(= local1 86)
						else
							(= local0 176)
							(= local1 10)
						)
					)
				)
				(= cycles 1)
			)
			(1
				(+= local0 (* register 3))
				(switch global249
					(773
						(= local1 (- 171 (/ local0 2)))
						((ScriptID 500 6) posn: local0 local1) ; carCursor
						(-- state)
						(cond
							((== register 1)
								(if (> local0 179)
									(-- state)
									(self setScript: (ScriptID 500 4) self 774) ; changeOverlay
								else
									(= cycles 1)
								)
							)
							((< local0 129)
								(-- state)
								(self setScript: (ScriptID 500 4) self 775) ; changeOverlay
							)
							(else
								(= cycles 1)
							)
						)
					)
					(774
						(= local1 (- 97 (/ (* local0 76) 153)))
						((ScriptID 500 6) posn: local0 local1) ; carCursor
						(if (== register 1)
							(if (< local0 158)
								(-- state)
							)
							(= cycles 1)
						else
							(-- state)
							(if (< local0 5)
								(-- state)
								(self setScript: (ScriptID 500 4) self 773) ; changeOverlay
							else
								(= cycles 1)
							)
						)
					)
					(775
						(= local1 (- 99 (/ (* local0 76) 153)))
						((ScriptID 500 6) posn: local0 local1) ; carCursor
						(if (== register -1)
							(if (> local0 10)
								(-- state)
							)
							(= cycles 1)
						else
							(-- state)
							(if (> local0 176)
								(-- state)
								(self setScript: (ScriptID 500 4) self 773) ; changeOverlay
							else
								(= cycles 1)
							)
						)
					)
				)
			)
			(2
				((ScriptID 500 1) show:) ; car
				(proc500_3 register)
				(= next (ScriptID 500 2)) ; exitDrive
				(self dispose:)
			)
		)
	)
)

(instance crashSound of Sound
	(properties)
)

