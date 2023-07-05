;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 711)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	sClimbDown 0
	sClimbUp 1
	sLeviDown 2
	sLeviUp 3
	sLeviDownRt 4
	sLeviUpRt 5
)

(local
	local0
)

(instance sClimbDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 388)
				(= local0 (gEgo cycleSpeed:))
				(gEgo setMotion: PolyPath 97 96 self)
			)
			(1
				((ScriptID 710 2) setPri: 185) ; torchEff
				(gEgo setPri: 185 setHeading: 90 self)
			)
			(2
				(gEgo
					view: 4
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(grapnel loop: 6 setCel: 7 setPri: 184 x: 97 y: 140 init:)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 7 loop: 5 cel: 11 x: 99 setCycle: Beg self)
			)
			(5
				(gEgo
					view: 7
					loop: 1
					cel: 5
					x: 106
					y: 139
					setCycle: Beg self
				)
			)
			(6
				(gEgo cel: 5 y: 151 setCycle: Beg self)
			)
			(7
				(gEgo cel: 5 y: 163 setCycle: Beg self)
			)
			(8
				(grapnel hide:)
				(gEgo
					x: 107
					y: 160
					normalize: 3
					setPri: 185
					cycleSpeed: local0
					setMotion: MoveTo 70 170 self
				)
			)
			(9
				(gEgo setMotion: MoveTo 80 178 self)
			)
			(10
				(gEgo
					view: 4
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(11
				(grapnel x: 86 y: 222 show:)
				(gEgo setCycle: Beg self)
			)
			(12
				(gEgo
					view: 7
					loop: 5
					cel: 11
					x: 92
					y: 179
					setCycle: Beg self
				)
			)
			(13
				(gEgo loop: 1 cel: 11 x: 95 y: 223 setCycle: Beg self)
			)
			(14
				(gEgo cel: 11 x: 95 y: 233 setCycle: Beg self)
			)
			(15
				(gEgo hide:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(= seconds 2)
			)
			(16
				(grapnel dispose:)
				(gEgo
					show:
					normalize: 3
					setPri: 152
					cycleSpeed: local0
					x: 145
					y: 240
				)
				((ScriptID 710 2) setPri: 152) ; torchEff
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: -300 489 -300 -300 619 -300 619 489 150 489 150 184 266 185 284 161 258 161 221 161 210 154 210 140 173 140 167 163 146 163 127 489
							yourself:
						)
				)
				(= cycles 2)
			)
			(17
				(gEgo setMotion: MoveTo 177 171 self)
			)
			(18
				(self setScript: (ScriptID 710 3) self) ; sCombatOrNot
			)
			(19
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(ClearFlag 388)
				(gEgo setMotion: MoveTo 145 240 self)
			)
			(1
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(grapnel posn: 86 222 setPri: 184 init:)
				(= seconds 2)
			)
			(2
				((ScriptID 710 2) setPri: 185) ; torchEff
				(= local0 (gEgo cycleSpeed:))
				(gEgo
					view: 7
					loop: 1
					cel: 11
					x: 95
					y: 233
					setPri: 190
					cycleSpeed: 12
					setPri: 185
					setCycle: End self
				)
			)
			(3
				(gEgo cel: 0 x: 95 y: 223 setCycle: End self)
			)
			(4
				(gEgo loop: 5 cel: 0 x: 80 y: 179 setCycle: End self)
			)
			(5
				(gEgo
					view: 4
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(6
				(grapnel hide:)
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo
					x: 80
					y: 178
					normalize: 0
					cycleSpeed: local0
					setPri: 185
					setMotion: MoveTo 107 160 self
				)
			)
			(8
				(grapnel show: loop: 6 setCel: 7 x: 97 y: 140)
				(gEgo
					view: 7
					loop: 1
					cel: 0
					x: 106
					y: 163
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(9
				(gEgo cel: 0 y: 151 setCycle: End self)
			)
			(10
				(gEgo cel: 0 y: 139 setCycle: End self)
			)
			(11
				(gEgo view: 7 loop: 4 cel: 0 x: 106 y: 95 setCycle: End self)
			)
			(12
				(gEgo posn: 97 96 setHeading: 270 self)
			)
			(13
				(gEgo view: 4 loop: 0 cel: 0 setCycle: End self)
			)
			(14
				(grapnel dispose:)
				(gEgo setCycle: Beg self)
			)
			(15
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 8 105 60 94 110 94 106 88 138 88 164 74 131 74 113 65 59 65 28 47 94 -300 619 -300 619 489 -300 489 -300 -300 20 -300 46 24 14 48 32 62 8 69
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 102 68 112 75 109 86 27 88 17 78 29 68
							yourself:
						)
				)
				((ScriptID 710 2) setPri: -1) ; torchEff
				(gEgo
					normalize: 0
					cycleSpeed: local0
					setMotion: PolyPath 129 82 self
				)
			)
			(16
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeviDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 388)
				(gEgo setMotion: PolyPath 109 95 self)
			)
			(1
				((ScriptID 710 2) setPri: 180) ; torchEff
				(gEgo
					view: 7
					loop: 5
					cel: 11
					posn: 107 94
					setPri: 180
					setCycle: Beg self
				)
			)
			(2
				(gLongSong2 number: 941 play:)
				(sparklies init: setCycle: Fwd)
				(gEgo
					view: 17
					setLoop: 3 1
					cel: 5
					posn: 109 127
					setMotion: MoveTo 109 159 self
				)
			)
			(3
				(gLongSong2 fade:)
				(sparklies hide:)
				(gEgo setLoop: -1 setCycle: Beg self)
			)
			(4
				(gEgo normalize: 7 setPri: 180 setMotion: MoveTo 86 178 self)
			)
			(5
				(gEgo
					view: 7
					loop: 5
					cel: 11
					posn: 84 177
					setCycle: Beg self
				)
			)
			(6
				(gLongSong2 number: 941 play:)
				(sparklies show:)
				(gEgo
					view: 17
					setLoop: 3 1
					cel: 5
					posn: 87 212
					setMotion: MoveTo 87 252 self
				)
			)
			(7
				(gLongSong2 fade:)
				(sparklies dispose:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(= cycles 2)
			)
			(8
				(gEgo
					normalize: 3
					setPri: 152
					cycleSpeed: local0
					x: 145
					y: 240
				)
				((ScriptID 710 2) setPri: 152) ; torchEff
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: -300 489 -300 -300 619 -300 619 489 150 489 150 184 266 185 284 161 258 161 221 161 210 154 210 140 173 140 167 163 146 163 127 489
							yourself:
						)
				)
				(= cycles 2)
			)
			(9
				(gEgo setMotion: MoveTo 145 173 self)
			)
			(10
				(self setScript: (ScriptID 710 3) self) ; sCombatOrNot
			)
			(11
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeviUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo 145 240 self)
			)
			(1
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(= cycles 2)
			)
			(2
				(gLongSong2 number: 941 play:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 8 105 60 94 110 94 106 88 138 88 164 74 131 74 113 65 59 65 28 47 94 -300 619 -300 619 489 -300 489 -300 -300 20 -300 46 24 14 48 32 62 8 69
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 102 68 112 75 109 86 27 88 17 78 29 68
							yourself:
						)
				)
				((ScriptID 710 2) setPri: 180) ; torchEff
				(sparklies init: setCycle: Fwd)
				(gEgo
					view: 17
					setLoop: 3 1
					cel: 5
					posn: 87 252
					setPri: 180
					setMotion: MoveTo 87 212 self
				)
			)
			(3
				(gLongSong2 fade:)
				(sparklies hide:)
				(gEgo view: 7 loop: 5 cel: 0 posn: 84 177 setCycle: End self)
			)
			(4
				(gEgo
					normalize: 3
					posn: 86 178
					setPri: 180
					setMotion: MoveTo 109 159 self
				)
			)
			(5
				(gLongSong2 number: 941 play:)
				(gEgo view: 17 setLoop: 3 1 cel: 0 setCycle: End self)
			)
			(6
				(sparklies show:)
				(gEgo setMotion: MoveTo 109 127 self)
			)
			(7
				(gLongSong2 fade:)
				(sparklies dispose:)
				(gEgo view: 7 loop: 5 cel: 0 posn: 107 94 setCycle: End self)
			)
			(8
				((ScriptID 710 2) setPri: -1) ; torchEff
				(gEgo normalize: 3)
				(gGlory handsOn:)
				(ClearFlag 388)
				(self dispose:)
			)
		)
	)
)

(instance sLeviDownRt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 388)
				(gEgo setMotion: PolyPath 282 64 self)
			)
			(1
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				((ScriptID 710 2) setPri: 180) ; torchEff
				(gEgo setHeading: 315 self)
			)
			(2
				(gLongSong2 number: 941 play:)
				(gEgo
					view: 17
					setLoop: 3 1
					cel: 0
					posn: 279 64
					setCycle: End self
				)
			)
			(3
				(sparklies init: setCycle: Fwd)
				(gEgo cel: 5 setPri: 180 setMotion: MoveTo 279 164 self)
			)
			(4
				(gLongSong2 fade:)
				(sparklies dispose:)
				(gEgo setPri: 154 setCycle: Beg self)
			)
			(5
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: -300 489 -300 -300 619 -300 619 489 150 489 150 184 266 185 284 161 258 161 221 161 210 154 210 140 173 140 167 163 146 163 127 489
							yourself:
						)
				)
				(gEgo normalize: 7)
				((ScriptID 710 2) setPri: -1) ; torchEff
				(= cycles 2)
			)
			(6
				(gEgo setPri: 152 setHeading: 270 self)
			)
			(7
				(self setScript: (ScriptID 710 3) self) ; sCombatOrNot
			)
			(8
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeviUpRt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 281 164 self)
			)
			(1
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gEgo setHeading: 315 self)
			)
			(2
				(gLongSong2 number: 941 play:)
				((ScriptID 710 2) setPri: 180) ; torchEff
				(gEgo
					view: 17
					setLoop: 3 1
					cel: 0
					posn: 279 164
					setCycle: End self
				)
			)
			(3
				(sparklies init: setCycle: Fwd)
				(gEgo setPri: 180 setMotion: MoveTo 279 64 self)
			)
			(4
				(gLongSong fade:)
				(sparklies dispose:)
				(gEgo setPri: -1 setCycle: Beg self)
			)
			(5
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 271 47 293 58 271 64 286 68 304 63 315 45 293 36 619 11 619 489 -300 489 -300 -300 267 -300 302 19 284 35 241 37 248 43 202 43 202 47
							yourself:
						)
				)
				((ScriptID 710 2) setPri: -1) ; torchEff
				(gEgo posn: 283 64 normalize: 7 setHeading: 90 self)
			)
			(6
				(gGlory handsOn:)
				(ClearFlag 388)
				(self dispose:)
			)
		)
	)
)

(instance sparklies of Prop
	(properties
		priority 182
		fixPriority 1
		view 17
		loop 4
		signal 16385
	)

	(method (init)
		(self setScaler: gEgo)
		(super init: &rest)
	)

	(method (doit)
		(= x (gEgo x:))
		(= y (gEgo y:))
		(super doit: &rest)
	)
)

(instance grapnel of View
	(properties
		sightAngle 180
		view 8
		loop 6
		cel 7
		signal 16384
	)
)

