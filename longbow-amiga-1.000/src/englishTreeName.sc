;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 223)
(include sci.sh)
(use Main)
(use n013)
(use n221)
(use n231)
(use n241)
(use sweepRgn)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	englishTreeName 0
	notSweeping 1
	notBlessed 2
	turnToTree 3
	unTreeEgo 4
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
)

(instance englishTreeName of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 60)
			)
			(1
				(if
					(OneOf
						gForestRoomNum
						2
						3
						4
						5
						6
						7
						17
						24
						25
						26
						27
						32
						43
						48
						60
						64
						76
						81
						91
						97
						107
						113
						123
						129
						139
						146
						147
						148
						149
						156
						168
						169
						170
						171
						182
						183
					)
					(Say 1223 0 self) ; "Zounds, I forgot. The bushes will answer only to their Druid names."
				else
					(Say 1223 1 self) ; "Zounds, I forgot. The trees will answer only to their Druid names."
				)
			)
			(2
				(if (IsFlag 129)
					(proc750_2)
					(gTheIconBar disable: 5)
				)
				(HandsOn)
				(self dispose:)
				(DisposeScript 223)
			)
		)
	)
)

(instance notSweeping of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(Say ; "When you are in danger, fleshling, then I will protect you."
					1223
					8
					self
					80
					(switch global124
						(11 {Birch})
						(12 {Rowan})
						(13 {Ash})
						(14 {Alder})
						(15 {Holly})
						(16 {Hazel})
						(17 {Elder})
						(18 {Oak})
						(20 {Blackberry})
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance notBlessed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 60)
			)
			(1
				(Say 1223 2 self) ; "Hmmm...I know that's the tree's name, but what was it Marian said?"
			)
			(2
				(Say 1223 3 self) ; "Aye, she said I must have the blessing of the Green Man before I can call upon the power of the Druid Trees."
			)
			(3
				(if (IsFlag 129)
					(proc750_2)
					(gTheIconBar disable: 5)
				)
				(HandsOn)
				(self dispose:)
				(DisposeScript 223)
			)
		)
	)
)

(instance turnToTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (or (== gForestRoomNum 88) (== gForestRoomNum 49))
					(gEgo setMotion: PolyPath 175 106 self)
				else
					(self cue:)
				)
			)
			(1
				(if (or (== gForestRoomNum 88) (== gForestRoomNum 49))
					(gEgo
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 3) self
					)
				else
					(self cue:)
				)
			)
			(2
				(if (not (or (== gForestRoomNum 88) (== gForestRoomNum 49)))
					(cond
						((== gCurRoomNum 180)
							(= local1 3)
							(= local0 236)
						)
						((or (== gForestRoomNum 132) (== gForestRoomNum 155))
							(= local1 2)
							(= local0 234)
						)
						((== gForestRoomNum 34)
							(= local1 2)
							(= local0 230)
						)
						((or (== gForestRoomNum 53) (== gForestRoomNum 120))
							(= local1 1)
							(= local0 233)
						)
						((== gForestRoomNum 66)
							(= local1 0)
							(= local0 231)
						)
						((== gForestRoomNum 20)
							(= local1 1)
							(= local0 237)
						)
						((== gForestRoomNum 114)
							(= local1 2)
							(= local0 232)
						)
						((or (== gForestRoomNum 22) (== gForestRoomNum 122))
							(= local1 1)
							(= local0 235)
						)
					)
					(switch local1
						(0
							(= local2 (+ (gEgo x:) -40))
							(= local8 (+ (gEgo x:) 40))
						)
						(1
							(= local2 (+ (gEgo x:) -50))
							(= local8 (+ (gEgo x:) 50))
						)
						(3
							(= local2 (+ (gEgo x:) -110))
							(= local8 (+ (gEgo x:) 110))
						)
						(else
							(= local2 (+ (gEgo x:) -60))
							(= local8 (+ (gEgo x:) 60))
						)
					)
					(= local3 (gEgo y:))
					(= local9 (gEgo y:))
					(= local4 (+ local2 10))
					(= local5 (- local3 10))
					(= local12 (+ local2 10))
					(= local13 (+ local3 7))
					(= local6 (- local8 10))
					(= local7 (- local9 10))
					(= local10 (- local8 10))
					(= local11 (+ local9 7))
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init:
									local2
									local3
									local4
									local5
									local6
									local7
									local8
									local9
									local10
									local11
									local12
									local13
								yourself:
							)
					)
				else
					(= local0 236)
				)
				(razzleDazzle init: play:)
				(sparkle
					x: (gEgo x:)
					y: (gEgo y:)
					init:
					setCycle: End self
				)
			)
			(3
				(if (or (== gForestRoomNum 88) (== gForestRoomNum 49))
					(gEgo hide:)
				else
					(gEgo view: local0 loop: 0 cel: 0)
				)
				(gEgo stopUpd:)
				(= ticks 12)
			)
			(4
				(sparkle dispose:)
				(if (< global154 3)
					(++ global154)
					(gSFX2 number: 916 loop: 1 play:)
					(+= gScore 75)
					((ScriptID 0 1) doit:) ; statLine
				)
				((ScriptID 750 0) setScript: 0) ; sweepRgn
				(= ticks 60)
			)
			(5
				(razzleDazzle dispose:)
				(gSFX number: 401 loop: -1 play:)
				(proc750_1)
				(self dispose:)
				(DisposeScript 223)
			)
		)
	)
)

(instance razzleDazzle of Sound
	(properties
		number 216
	)
)

(instance unTreeEgo of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (not global143)
					(HandsOff)
				)
				(= seconds 4)
			)
			(1
				(Say ; "The danger is past, fleshling. Return to your native form and go in peace."
					1223
					4
					self
					80
					(switch global124
						(11 {Birch})
						(12 {Rowan})
						(13 {Ash})
						(14 {Alder})
						(15 {Holly})
						(16 {Hazel})
						(17 {Elder})
						(18 {Oak})
					)
				)
			)
			(2
				(if (or (== gForestRoomNum 88) (== gForestRoomNum 49))
					(self cue:)
				else
					(if (gCurRoom obstacles:)
						((gCurRoom obstacles:) dispose:)
					)
					(gCurRoom obstacles: 0)
					(= ticks 120)
				)
			)
			(3
				(razzleDazzle init: play:)
				(sparkle
					x: (gEgo x:)
					y: (gEgo y:)
					cel: 0
					init:
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(4
				(sparkle dispose:)
				(if (or (== gForestRoomNum 88) (== gForestRoomNum 49))
					(gEgo
						show:
						setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 6) self
					)
				else
					(self cue:)
				)
			)
			(5
				(razzleDazzle dispose:)
				(NormalEgo)
				(cond
					((or (== gForestRoomNum 88) (== gForestRoomNum 49))
						(self cue:)
					)
					((== gCurRoomNum 180)
						(gCurRoom
							addObstacle:
								((Polygon new:)
									type: PBarredAccess
									init: 189 156 178 160 181 170 176 173 169 171 160 166 136 166 140 161 177 153 170 145 179 136 158 131 153 126 136 126 122 136 60 157 50 165 30 165 30 160 50 155 68 144 43 152 31 152 39 142 80 141 125 121 199 125 222 121 243 136 247 156 248 165 225 151
									yourself:
								)
								((Polygon new:)
									type: PBarredAccess
									init: 300 167 277 166 266 154 251 145 255 137 277 138 319 139 319 159 300 158
									yourself:
								)
						)
						(= ticks 30)
					)
					(else
						(switch (gCurRoom picture:)
							(220
								(proc221_0)
							)
							(230
								(proc231_0)
							)
							(240
								(proc241_0)
							)
						)
						(= ticks 30)
					)
				)
				(cond
					((and (== gDay 9) (not (IsFlag 36)))
						(SetFlag 36)
						(ClearFlag 129)
						(= gForestSweepRoomCount 0)
						(gSFX fade: 0 30 8 1)
						((ScriptID 750 0) keep: 0) ; sweepRgn
					)
					((and (== gDay 12) (not (IsFlag 38)))
						(SetFlag 38)
						(ClearFlag 129)
						(= gForestSweepRoomCount 0)
						(gSFX fade: 0 30 8 1)
						((ScriptID 750 0) keep: 0) ; sweepRgn
					)
				)
				(= seconds 2)
			)
			(6
				(if (== gDay 9)
					(Say 1223 5 self) ; "'Twas most peaceful being a tree. But I'm glad to have my legs back again."
				else
					(Say 1223 6 self) ; "Tell the Green Man I thank him most heartily for this blessing."
				)
			)
			(7
				(= ticks 100)
			)
			(8
				(if (== gDay 12)
					(Say ; "It will be done."
						1223
						7
						self
						80
						(switch global124
							(11 {Birch})
							(12 {Rowan})
							(13 {Ash})
							(14 {Alder})
							(15 {Holly})
							(16 {Hazel})
							(17 {Elder})
							(18 {Oak})
						)
					)
				else
					(self cue:)
				)
			)
			(9
				(HandsOn)
				(NormalEgo)
				(self dispose:)
				(DisposeScript 223)
			)
		)
	)
)

(instance sparkle of Prop
	(properties
		view 245
		loop 1
		signal 16384
	)
)

