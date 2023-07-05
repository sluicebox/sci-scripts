;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 158)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	brigBlocked 0
	climb 1
)

(instance brigBlocked of Script
	(properties)

	(method (doit)
		(if (and (== state 3) ((ScriptID 95 0) notify: 12)) ; rm95
			(self cue:)
		)
		(if (and (== state 4) ((ScriptID 95 0) notify: 18)) ; rm95
			(self cue:)
		)
		(if (and (< (gEgo x:) 90) (< state 3))
			(self changeState: 3)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HighPrint 158 0) ; "Oh, a wise guy, eh."
				((ScriptID 95 15) setMotion: MoveTo 91 88 self) ; moe
				((ScriptID 95 17) loop: 2 setScript: curlyFollow) ; curly
				((ScriptID 95 19) loop: 2 setScript: larryFollow) ; larry
			)
			(1
				(if ((ScriptID 95 0) notify: 16) ; rm95
					(EgoDead ; "Die drei Knochelkopfen grab you off the table. You should have waited until they were out of reach."
						158
						1
						82
						516
						0
						9
						80
						{Nyuk Nyuk Nyuk -- Mee Mee Mee Mee Mee...}
					)
				else
					((ScriptID 95 15) setMotion: MoveTo 76 106 self) ; moe
				)
			)
			(2
				((ScriptID 95 15) setPri: 8 setMotion: MoveTo 100 115 self) ; moe
			)
			(3
				(if ((ScriptID 95 0) notify: 16) ; rm95
					((ScriptID 95 0) notify: 15) ; rm95
				else
					(EgoDead ; "You're hopelessly surrounded. You should have taken quicker action against these Knochelkopfs. Elevate your thoughts to a higher plane."
						158
						2
						82
						516
						0
						9
						80
						{Woo Woo Woo -- Ruff Ruff Ruff.}
					)
				)
			)
			(4
				((ScriptID 95 15) setMotion: MoveTo 174 124) ; moe
			)
			(5
				((ScriptID 95 15) ; moe
					view: 187
					setCel: 0
					setLoop: 4
					setMotion: MoveTo 165 124
					setCycle: End
				)
				((ScriptID 95 16) dispose:) ; moeHead
				((ScriptID 95 0) notify: 21) ; rm95
				(= cycles 1)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance curlyFollow of Script
	(properties)

	(method (doit)
		(if (and (== state 4) ((ScriptID 95 0) notify: 20)) ; rm95
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 23)
			)
			(1
				((ScriptID 95 17) setMotion: MoveTo 89 88 self) ; curly
			)
			(2
				((ScriptID 95 17) setMotion: MoveTo 76 106 self) ; curly
			)
			(3
				((ScriptID 95 17) setPri: 8 setMotion: MoveTo 100 115 self) ; curly
			)
			(4
				((ScriptID 95 17) setMotion: MoveTo 162 124) ; curly
			)
			(5
				(= cycles 4)
			)
			(6
				((ScriptID 95 17) ; curly
					view: 188
					setCel: 0
					setLoop: 4
					setMotion: MoveTo 153 124
					setCycle: End
				)
				((ScriptID 95 18) dispose:) ; curlyHead
				((ScriptID 95 0) notify: 23) ; rm95
				(= cycles 1)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance larryFollow of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 158)
	)

	(method (doit)
		(if (and ((ScriptID 95 0) notify: 22) (== state 4)) ; rm95
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 32)
			)
			(1
				((ScriptID 95 19) setMotion: MoveTo 89 88 self) ; larry
			)
			(2
				((ScriptID 95 19) setMotion: MoveTo 76 106 self) ; larry
			)
			(3
				((ScriptID 95 19) setPri: 8 setMotion: MoveTo 100 115 self) ; larry
			)
			(4
				((ScriptID 95 19) setMotion: MoveTo 150 124) ; larry
			)
			(5
				(= cycles 4)
			)
			(6
				((ScriptID 95 19) ; larry
					view: 186
					setCel: 0
					setLoop: 4
					setMotion: MoveTo 144 124
					setCycle: End
				)
				((ScriptID 95 20) dispose:) ; larryHead
				(= cycles 30)
			)
			(7
				((ScriptID 95 15) ; moe
					cycleSpeed: 7
					moveSpeed: 7
					setCycle: Beg
					setMotion: MoveTo 164 124
				)
				((ScriptID 95 17) ; curly
					cycleSpeed: 7
					moveSpeed: 7
					setCycle: Beg
					setMotion: MoveTo 152 124
				)
				((ScriptID 95 19) ; larry
					cycleSpeed: 7
					moveSpeed: 7
					setCycle: Beg
					setMotion: MoveTo 145 124 self
				)
			)
			(8
				((ScriptID 95 19) view: 295 setLoop: 1 setCel: 0) ; larry
				((ScriptID 95 4) setScript: (ScriptID 95 24)) ; chandelier, sChandFall
				((ScriptID 95 17) dispose:) ; curly
				((ScriptID 95 15) dispose:) ; moe
				(self dispose:)
			)
		)
	)
)

(instance climb of Script
	(properties)

	(method (doit)
		(if (and ((ScriptID 95 0) notify: 14) (== state 6)) ; rm95
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 178 108 self)
			)
			(1
				((ScriptID 95 0) notify: 17) ; rm95
				(gEgo
					view: 195
					setLoop: 0
					setCel: 0
					setPri: 7
					illegalBits: 0
					posn: 173 108
				)
				(= cycles 2)
			)
			(2
				(gEgo setCel: 1 posn: 182 97)
				(= cycles 2)
			)
			(3
				(gEgo setCel: 2 posn: 188 99)
				(= cycles 2)
			)
			(4
				(gEgo setCel: 3 posn: 191 92)
				(= cycles 2)
			)
			(5
				(gEgo setCel: 4 posn: 212 100)
				(= cycles 3)
			)
			(6
				((ScriptID 95 0) notify: 13) ; rm95
				(gEgo
					view: 4
					loop: 1
					setCel: 0
					posn: (- (gEgo x:) 9) (- (gEgo y:) 18)
				)
			)
			(7
				(gEgo
					view: 195
					setLoop: 0
					setCel: 5
					posn: 212 100
					cycleSpeed: 3
					setCycle: CT 7 1 self
				)
				((ScriptID 95 6) setLoop: 4 setCel: 0 posn: 211 63) ; rope
			)
			(8
				(gEgo setCel: 8)
				((ScriptID 95 6) setLoop: 4 setCel: 1 setPri: 11 posn: 206 50) ; rope
				(= cycles 3)
			)
			(9
				(gEgo
					setLoop: 1
					setCel: 0
					setPri: 12
					cycleSpeed: 0
					posn: 230 82
				)
				((ScriptID 95 6) setLoop: 3 setCel: 0 posn: 228 47) ; rope
				(= cycles 3)
			)
			(10
				((ScriptID 95 2) setCel: 1 stopUpd:) ; lDoor
				(gEgo setCel: 1 posn: 244 92)
				((ScriptID 95 6) setCel: 1 posn: 238 57) ; rope
				(= cycles 3)
			)
			(11
				(gEgo setCel: 2 posn: 260 114)
				((ScriptID 95 6) setCel: 2 posn: 246 68) ; rope
				(= cycles 3)
			)
			(12
				(gEgo setCel: 3 posn: 243 128)
				((ScriptID 95 6) setCel: 3 posn: 224 80) ; rope
				(= cycles 4)
			)
			(13
				(gEgo setCel: 4 posn: 183 130)
				((ScriptID 95 6) setCel: 4 posn: 183 88) ; rope
				(= cycles 2)
			)
			(14
				((ScriptID 95 0) notify: 19) ; rm95
				(gEgo setCel: 5 posn: 119 132)
				((ScriptID 95 6) setCel: 5 posn: 117 88) ; rope
				(= cycles 3)
			)
			(15
				(gEgo setCel: 6 posn: 96 122)
				((ScriptID 95 6) setCel: 6 posn: 93 83) ; rope
				(= cycles 3)
			)
			(16
				(gEgo setCel: 7 posn: 62 106)
				((ScriptID 95 6) setCel: 7 posn: 75 74) ; rope
				(= cycles 3)
			)
			(17
				(gEgo setCel: 8 posn: 47 92)
				((ScriptID 95 6) setCel: 8 posn: 80 60) ; rope
				(= cycles 3)
			)
			(18
				((ScriptID 95 2) setCel: 0 stopUpd:) ; lDoor
				(gEgo setCel: 9 posn: 46 86)
				((ScriptID 95 6) hide:) ; rope
				(= cycles 3)
			)
			(19
				(gEgo setLoop: 2 setCel: 0 posn: 40 88)
				(= cycles 3)
			)
			(20
				(gEgo setCel: 1 posn: 59 93)
				(= cycles 3)
			)
			(21
				(NormalEgo)
				(if ((ScriptID 95 0) notify: 3) ; rm95
					(gEgo illegalBits: -28672)
				)
				(gEgo loop: 2 posn: 63 93)
				(self dispose:)
			)
		)
	)
)

