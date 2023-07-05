;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3200)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Talker)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm3200 0
	ceresTalker 1
)

(local
	local0
	local1
	local2
)

(instance rm3200 of KQRoom
	(properties
		picture 3200
	)

	(method (init)
		(if (IsFlag 206)
			(gKqMusic1 number: 3213 setLoop: -1 play:)
			(eastExitFeature init:)
			(westExitFeature init:)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 0 99 -10 139 320 149 320 91 208 83 148 85 115 95
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 226 122 237 133 165 134 163 123 193 118
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 246 100 258 106 235 114 221 109 231 102
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 138 103 143 112 166 112 172 104
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 220 87 221 97 203 97 196 87
						yourself:
					)
			)
			(treeHealed cel: (treeHealed lastCel:) init:)
			(flower1 cel: (flower1 lastCel:) init:)
			(flower2 cel: (flower2 lastCel:) init:)
			((View new:) view: 3211 loop: 8 x: 93 y: 121 setPri: 1 init:)
			((View new:) view: 3211 loop: 9 x: 93 y: 108 setPri: 1 init:)
			((View new:) view: 3211 loop: 6 x: 264 y: 103 setPri: 1 init:)
			((View new:) view: 3211 loop: 7 x: 215 y: 80 setPri: 1 init:)
			((View new:) view: 3211 loop: 8 x: 180 y: 85 setPri: 1 init:)
			((View new:) view: 3211 loop: 6 x: 155 y: 126 setPri: 1 init:)
			((View new:) view: 3211 loop: 8 x: 93 y: 121 setPri: 1 init:)
			((View new:) view: 3211 loop: 6 x: 150 y: 91 setPri: 1 init:)
			((View new:) view: 3211 loop: 7 x: 112 y: 120 setPri: 1 init:)
			((View new:) view: 3211 loop: 8 x: 192 y: 99 setPri: 1 init:)
			((View new:) view: 3211 loop: 6 x: 74 y: 97 setPri: 1 init:)
			((View new:) view: 3211 loop: 7 x: 232 y: 116 setPri: 1 init:)
			((View new:) view: 3211 loop: 8 x: 242 y: 95 setPri: 1 init:)
		else
			(eastExitFeature init:)
			(westExitFeature init:)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 147 111 118 109 130 94 121 97 113 99 102 102 36 95 36 90 102 87 92 83 -10 85 -10 136 330 136 320 95 305 95 302 98 289 98 271 109 235 108 223 100 170 100
						yourself:
					)
			)
		)
		(super init:)
		(SetFlag 21)
		(Load rsMESSAGE 3200)
		(if (not (IsFlag 206))
			(motherOak init:)
			(branch init:)
			(if (not (IsFlag 105))
				(spike init:)
				(sap init: cycleSpeed: 30 setCycle: Fwd)
			else
				(sap loop: 4 init: cycleSpeed: 5 setCycle: Fwd)
			)
		)
		(if (IsFlag 104)
			(river init:)
		)
		(cond
			((and (IsFlag 206) (not (IsFlag 545)))
				(ceres
					view: 3211
					loop: 2
					approachX: 152
					approachY: 89
					setPri: 75
					approachVerbs: 8 10 ; Do, Exit
				)
				(ceres cel: (ceres lastCel:) posn: 210 93 init:)
				(ceresTalker view: -1 loop: -1 client: ceres clientCel: -1)
				(ceresTalker hide_mouth: 1)
			)
			(
				(and
					(IsFlag 104)
					(IsFlag 203)
					(not (IsFlag 206))
					(gEgo has: 66) ; Pomegranate
				)
				(attis
					view: 3208
					loop: 0
					cel: 0
					posn: 192 101
					cycleSpeed: 15
					init:
					setCycle: RandCycle
				)
				(gKqMusic1 number: 3209 setLoop: -1 play:)
			)
			((and (IsFlag 104) (not (IsFlag 206)) (IsFlag 105))
				(if (!= gChapter 4)
					(attis
						view: 3205
						loop: 0
						cel: 12
						setCycle: 0
						posn: 178 100
						init:
					)
					(glow init: setCycle: RandCycle)
					(glow2 init: setCycle: RandCycle)
					(motherOak setHotspot: 0 73) ; Pomegranate
					(gKqMusic1 number: 3208 setLoop: -1 play:)
				)
			)
			((and (IsFlag 104) (not (IsFlag 206)))
				(if (!= gChapter 4)
					(attis setPri: 99 init:)
				)
				(gKqMusic1 number: 3200 setLoop: -1 play:)
			)
			((not (IsFlag 104))
				(if (!= gChapter 4)
					(stag init:)
				)
				(gKqMusic1 number: 3200 setLoop: -1 play:)
			)
		)
		(gEgo init: setScaler: Scaler 109 70 125 93 normalize:)
		(switch gPrevRoomNum
			(3100
				(self setScript: flyIn)
			)
			(3250
				(cond
					((and (IsFlag 104) (not (IsFlag 105)))
						(self setScript: takeSpikeOut)
					)
					(
						(and
							(not (IsFlag 132))
							(or (== gChapter 3) (== gChapter 5))
						)
						(gCurRoom setScript: firstTimeHere)
					)
					(else
						(self setScript: fromMaiden)
					)
				)
			)
			(else
				(gEgo posn: 0 120)
				(if
					(and
						(not (IsFlag 132))
						(!= gChapter 4)
						(not (IsFlag 104))
					)
					(gCurRoom setScript: firstTimeHere5)
				else
					(self setScript: sFromWest)
				)
			)
		)
	)

	(method (doit)
		(if (and (== gValOrRoz -4) (<= (gEgo y:) 93) (not local2)) ; Val
			(= local2 1)
			(gEgo setScaler: Scaler 70 42 93 79)
		)
		(if (and (== gValOrRoz -4) (> (gEgo y:) 93) local2) ; Val
			(= local2 0)
			(gEgo setScaler: Scaler 109 70 125 93)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(IsFlag 103)
		(ceresTalker view: -1 loop: -1 client: 0 clientCel: -1)
		(ceresTalker hide_mouth: 0)
		(gKqMusic1 fade:)
		(super dispose:)
	)
)

(instance sQuitBugging of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc11_3 gEgo attis self)
			)
			(1
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 1 8 26 0 self) ; "(THINKS TO HERSELF)Until I can offer him some real help, I suppose I should leave poor Attis alone."
			)
			(2
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo setHeading: 180)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCeresLastMsg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 35 self)
			)
			(1
				(gMessager say: 5 8 35 0 self) ; "(VERY WORRIED)Excuse me, but I--"
			)
			(2
				(gEgo setHeading: 180)
				(ceres setHotspot: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGivePom of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(gEgo setPri: 120 setMotion: PolyPath 136 93 self)
				)
				(1
					(gEgo setMotion: MoveTo 136 93 self)
				)
				(2
					(attis loop: 1 cel: 0 cycleSpeed: 6 setCycle: End self)
					(gKqMusic1 stop:)
				)
				(3
					(gEgo
						view: 3208
						setScaler: 0
						scaleX: 128
						scaleY: 128
						loop: 2
						cel: 0
						setCycle: CT 25 1 self
					)
					(attis view: 3209 cel: 0 setPri: 101 setCycle: End self)
				)
				(4 0)
				(5
					(gEgo put: 66) ; Pomegranate
					(gEgo setCycle: End self)
				)
				(6
					(mySound number: 3210 setLoop: 1 play:)
					(branch setCycle: End)
					(gEgo
						normalize:
						setScaler: Scaler 109 70 125 93
						setPri: 150
						setLoop: 6 1
						setCycle: Rev
						setMotion: MoveTo 108 113 self
					)
				)
				(7
					(gEgo setCycle: 0 normalize: 6)
					(if (branch cycler:)
						(= cycles 1)
						(-- state)
					else
						(= cycles 1)
					)
				)
				(8
					(branch loop: 2 cel: 0 posn: 179 100 setCycle: CT 6 1 self)
				)
				(9
					(sap dispose:)
					(motherOak dispose:)
					(branch setPri: -1 setCycle: End self)
				)
				(10
					(branch dispose:)
					(gKqSound1 stop:)
					(ceres init: posn: 179 98 setCycle: End self)
				)
				(11
					(ceres hide:)
					(attis
						view: 3209
						loop: 4
						cel: 0
						posn: 192 102
						setCycle: End self
					)
					(gKqMusic1 number: 3211 setLoop: -1 play:)
				)
				(12
					(= ticks 60)
				)
				(13
					((ScriptID 7000) hide_mouth: 1) ; attisTalker
					(ceresTalker
						client: attis
						view: 3209
						loop: 24
						clientCel: (attis cel:)
					)
					(gMessager sayRange: 3 73 0 1 2 self) ; "(PASSIONATE, OVERCOME WITH EMOTION)my love...my love..."
				)
				(14
					(attis
						view: 3210
						cel: 0
						loop: 0
						posn: 182 97
						setCycle: End self
					)
				)
				(15
					(ceresTalker view: 3210 loop: 20 clientCel: (attis cel:))
					(gMessager sayRange: 3 73 0 3 4 self) ; "(DEEPLY SORROWFUL)I cannot stay, Ceres. I must go to Etheria and do what I can to help. The volcano--"
				)
				(16
					(= ticks 120)
				)
				(17
					(attis loop: 1 cel: 0 posn: 178 96 setCycle: End self)
				)
				(18
					(ceres
						view: 3211
						loop: 0
						cel: 0
						posn: 149 96
						setCycle: End self
						show:
					)
					(attis loop: 2 cel: 0 posn: 185 95)
					(attis setCycle: CT 15 1 self)
				)
				(19 0)
				(20
					(mySound number: 3212 setLoop: 1 play:)
					(attis setCycle: End self)
				)
				(21
					(attis dispose:)
					(= ticks 120)
				)
				(22
					(SetFlag 206)
					(ceresTalker
						view: 3211
						loop: 20
						client: ceres
						clientCel: (ceres cel:)
					)
					(gMessager say: 3 73 0 5 self) ; "(WARMLY)You have my deepest thanks, dear lady."
				)
				(23
					((gCurRoom obstacles:) dispose:)
					(gCurRoom
						obstacles: 0
						addObstacle:
							((Polygon new:)
								type: PContainedAccess
								init: 0 99 -10 139 320 149 320 91 208 83 148 85 115 95
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 188 91 190 96 175 99 160 98 159 91
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 226 122 237 133 165 134 163 123 193 118
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 246 100 258 106 235 114 221 109 231 102
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 138 103 143 112 166 112 172 104
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 220 87 221 97 203 97 196 87
								yourself:
							)
					)
					(gCurRoom setScript: sTimeCeres)
				)
			)
		else
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(gEgo
						put: 66 ; Pomegranate
						setCycle: 0
						setMotion: 0
						posn: 108 113
						setScaler: Scaler 109 70 125 93
						normalize: 2
					)
					(sap dispose:)
					(motherOak dispose:)
					(branch dispose:)
					(attis dispose:)
					(if (not (gCast contains: ceres))
						(ceres init:)
					)
					(ceres
						view: 3211
						setLoop: 0 1
						setCel: (ceres lastCel:)
						show:
						posn: 149 96
					)
					(gKqMusic1 number: 3211 setLoop: -1 play:)
					(mySound stop:)
					(SetFlag 206)
					(ceresTalker
						view: 3211
						loop: 21
						client: ceres
						clientCel: (ceres cel:)
					)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom
						obstacles: 0
						addObstacle:
							((Polygon new:)
								type: PContainedAccess
								init: 0 99 -10 139 320 149 320 91 208 83 148 85 115 95
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 188 91 190 96 175 99 160 98 159 91
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 226 122 237 133 165 134 163 123 193 118
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 246 100 258 106 235 114 221 109 231 102
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 138 103 143 112 166 112 172 104
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 220 87 221 97 203 97 196 87
								yourself:
							)
					)
					(gGame handsOff:)
					(gCurRoom setScript: sTimeCeres)
				)
			)
		)
	)
)

(instance sTimeCeres of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(= ticks 360)
			)
			(1
				(gGame handsOff:)
				(proc11_3 gEgo ceres self)
			)
			(2
				(ceres
					loop: 1
					x: (+ (ceres x:) 8)
					y: (- (ceres y:) 3)
					cel: 0
					setCycle: End self
				)
			)
			(3
				(ceresTalker
					view: 3211
					loop: 21
					client: ceres
					clientCel: (ceres cel:)
				)
				(if (not (IsFlag 207))
					(ceres setHotspot: 0)
				else
					(ceres approachX: 95 approachY: 96 approachVerbs: 8 10) ; Do, Exit
				)
				(gMessager say: 5 8 31 2 self) ; "(WARMLY)Farewell, my friend."
			)
			(4
				(ceres loop: 2 cel: 0 setCycle: End self)
				(ceresTalker view: -1 loop: -1 client: ceres clientCel: -1)
				(ceresTalker hide_mouth: 1)
			)
			(5
				(ceres setPri: 80)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom
					obstacles: 0
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 99 -10 139 320 149 320 91 208 83 148 85 115 95
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 226 122 237 133 165 134 163 123 193 118
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 246 100 258 106 235 114 221 109 231 102
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 138 103 143 112 166 112 172 104
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 220 87 221 97 203 97 196 87
							yourself:
						)
				)
				(gKqMusic1 number: 3213 setLoop: -1 play:)
				(ceres setScript: sFlowerGrow)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFlowerGrow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(treeHealed init: cycleSpeed: 20 setCycle: End self)
			)
			(1
				(flower1 init: cycleSpeed: 20 setCycle: End self)
			)
			(2
				(flower2 init: cycleSpeed: 20 setCycle: End self)
			)
			(3
				((View new:) view: 3211 loop: 6 x: 74 y: 97 setPri: 1 init:)
				(= ticks 20)
			)
			(4
				((View new:) view: 3211 loop: 7 x: 232 y: 116 setPri: 1 init:)
				(= ticks 20)
			)
			(5
				((View new:) view: 3211 loop: 8 x: 242 y: 95 setPri: 1 init:)
				(= ticks 20)
			)
			(6
				((View new:) view: 3211 loop: 8 x: 93 y: 121 setPri: 1 init:)
				(= ticks 20)
			)
			(7
				((View new:) view: 3211 loop: 6 x: 150 y: 91 setPri: 1 init:)
				(= ticks 20)
			)
			(8
				((View new:) view: 3211 loop: 7 x: 112 y: 120 setPri: 1 init:)
				(= ticks 20)
			)
			(9
				((View new:) view: 3211 loop: 8 x: 192 y: 99 setPri: 1 init:)
				(= ticks 20)
			)
			(10
				((View new:) view: 3211 loop: 6 x: 264 y: 103 setPri: 1 init:)
				(= ticks 20)
			)
			(11
				((View new:) view: 3211 loop: 7 x: 215 y: 80 setPri: 1 init:)
				(= ticks 20)
			)
			(12
				((View new:) view: 3211 loop: 8 x: 180 y: 85 setPri: 1 init:)
				(= ticks 20)
			)
			(13
				((View new:) view: 3211 loop: 6 x: 155 y: 126 setPri: 1 init:)
				(= ticks 20)
			)
			(14
				((View new:) view: 3211 loop: 8 x: 93 y: 121 setPri: 1 init:)
				(= ticks 20)
			)
			(15
				((View new:) view: 3211 loop: 9 x: 93 y: 108 setPri: 1 init:)
				(= ticks 20)
			)
			(16
				(self dispose:)
			)
		)
	)
)

(instance sTalkCeres of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc11_3 gEgo ceres self)
			)
			(1
				(ceres
					loop: 1
					cel: 0
					x: (+ (ceres x:) 8)
					y: (- (ceres y:) 3)
					setCycle: End self
				)
			)
			(2
				(ceresTalker
					view: 3211
					loop: 21
					client: ceres
					clientCel: (ceres cel:)
				)
				(if (IsFlag 207)
					(SetFlag 544)
					(gMessager say: 5 8 32 0 self) ; "You are very welcome, lady Ceres. May I ask a question of you?"
					(ceres approachX: 95 approachY: 96 approachVerbs: 8 10) ; Do, Exit
				else
					(ceres setHotspot: 0)
					(gMessager say: 5 8 31 0 self) ; "You are very welcome, lady Ceres."
				)
			)
			(3
				(ceres loop: 2 cel: 0 setCycle: End self)
				(ceresTalker view: -1 loop: -1 client: ceres clientCel: -1)
				(ceresTalker hide_mouth: 1)
			)
			(4
				(ceres setPri: 80)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom
					obstacles: 0
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 99 -10 139 320 149 320 91 208 83 148 85 115 95
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 226 122 237 133 165 134 163 123 193 118
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 246 100 258 106 235 114 221 109 231 102
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 138 103 143 112 166 112 172 104
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 220 87 221 97 203 97 196 87
							yourself:
						)
				)
				(gKqMusic1 number: 3213 setLoop: -1 play:)
				(ceres setScript: sFlowerGrow)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkCeres2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 35 self)
			)
			(1
				(cond
					((not (IsFlag 207))
						(gMessager say: 5 8 35 0 self) ; "(VERY WORRIED)Excuse me, but I--"
					)
					((IsFlag 544)
						(SetFlag 545)
						(gMessager say: 5 8 34 0 self) ; "(WORRIED)Lady Ceres, how am I to travel to the Realm of Dreams while awake? What must I do?"
					)
					(else
						(SetFlag 544)
						(gMessager say: 5 8 33 0 self) ; "Lady Ceres, may I ask a question of you?"
					)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sStopPlayingMab of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc11_3 gEgo attis self)
			)
			(1
				(gMessager say: 4 8 29 1 self) ; "(URGENT)Attis! I have sought help from Etheria,but the lady Mab has been frozen by some horrible curse!"
			)
			(2
				(attis loop: 1 cel: 0 cycleSpeed: 6 setCycle: End self)
				(gKqMusic1 setVol: 0)
			)
			(3
				(gMessager say: 4 8 29 2 self) ; "(VERY SAD)Frozen, you say? It is possible that my lady Ceres could tell you how to thaw Mab...if only she could speak. She is--was--the Lady of Spring."
			)
			(4
				(attis setCycle: Beg self)
			)
			(5
				(attis loop: 0 cycleSpeed: 15 setCycle: RandCycle)
				(gKqMusic1 setVol: 127)
				(gEgo setHeading: 180 self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sStopPlaying of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc11_3 gEgo attis self)
			)
			(1
				(if register
					(= cycles 1)
				else
					(gMessager say: 4 8 27 1 self) ; "(SYMPATHETIC)Hello, Lord Attis."
				)
			)
			(2
				(attis loop: 1 cel: 0 cycleSpeed: 6 setCycle: End self)
				(gKqMusic1 setVol: 0)
			)
			(3
				(if register
					(gMessager say: 4 8 28 1 self) ; "(BROKEN-HEARTED)Leave me with my sorrows, gentle Valanice. Go and make your peace with this world."
				else
					(gMessager say: 4 8 27 2 self) ; "(TOTALLY DISHEARTENED)Hello, Valanice. My lady and I wait for the fire from the heavens. Perhaps our fates will be happier in the next world."
				)
			)
			(4
				(attis setCycle: Beg self)
			)
			(5
				(attis loop: 0 cycleSpeed: 15 setCycle: RandCycle)
				(gKqMusic1 setVol: 127)
				(gEgo setHeading: 180 self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFromWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 30 120 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromMaiden of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 317 111 setMotion: MoveTo 280 111 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance firstTimeHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 340 121
					setMotion: MoveTo (stag approachX:) (stag approachY:) self
				)
			)
			(1
				(SetFlag 132)
				(tears init: setCycle: End self)
			)
			(2
				(tears dispose:)
				(proc11_3 gEgo stag)
				(stag setCel: 0 setLoop: 2 setCycle: End self)
				(gKqSound1 number: 3202 setLoop: 1 play:)
			)
			(3
				(= ticks 60)
			)
			(4
				(gMessager say: 0 0 1 1 self) ; "(MOURNFUL)I advise you to turn back, my lady. These once magical woods have been cursed, and no one is safe here."
			)
			(5
				(stag setLoop: 3 setCel: 0 setCycle: End self)
			)
			(6
				(= ticks 80)
			)
			(7
				(stag setCycle: Beg self)
			)
			(8
				(stag setLoop: 2)
				(stag cel: (stag lastCel:) setCycle: Beg self)
				(gKqSound1 number: 3202 setLoop: 1 play:)
				(proc11_3 gEgo stag self)
			)
			(9 0)
			(10
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance firstTimeHere5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion: MoveTo (stag approachX:) (stag approachY:) self
				)
			)
			(1
				(SetFlag 132)
				(tears init: setCycle: End self)
			)
			(2
				(tears dispose:)
				(stag setCel: 0 setLoop: 2 setCycle: End self)
				(gKqSound1 number: 3202 setLoop: 1 play: self)
			)
			(3 0)
			(4
				(proc11_3 gEgo stag self)
			)
			(5
				(gMessager say: 0 0 1 1 self) ; "(MOURNFUL)I advise you to turn back, my lady. These once magical woods have been cursed, and no one is safe here."
			)
			(6
				(stag setLoop: 3 setCel: 0 setCycle: End self)
			)
			(7
				(= ticks 45)
			)
			(8
				(stag setCycle: Beg self)
			)
			(9
				(stag setLoop: 2)
				(stag cel: (stag lastCel:) setCycle: Beg self)
				(gKqSound1 number: 3202 setLoop: 1 play:)
				(proc11_3 gEgo stag self)
			)
			(10 0)
			(11
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance secondTalk of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(proc11_3 gEgo stag self)
					(stag loop: 2 cel: 0 setCycle: End self)
					(gKqSound1 number: 3202 setLoop: 1 play:)
				)
				(1 0)
				(2
					(gMessager sayRange: 1 8 2 1 4 self) ; "(GENTLY)I am Valanice of Daventry, noble stag, and I appreciate your concern, but I am on a mission from which I cannot be dissuaded. I MUST enter your woods."
				)
				(3
					(stag setLoop: 4 setCel: 0 setCycle: End self)
				)
				(4
					(stag setCycle: Beg self)
				)
				(5
					(stag setLoop: 2)
					(stag setCel: (stag lastCel:))
					(gMessager say: 1 8 2 5 self) ; "(SYMPATHETIC)I am sorry for your loss, Attis, but I must search on. Farewell, my friend."
				)
				(6
					(gEgo setMotion: MoveTo 162 120 self)
				)
				(7
					(gMessager say: 1 8 2 6 self) ; "(ALARMED)Valanice, wait."
				)
				(8
					(gEgo setHeading: 45 self)
				)
				(9
					(gMessager sayRange: 1 8 2 7 8 self) ; "(INTENTLY)Be warned. To the far west is the Wood of the Were Folk. Do not enter them, for the Were Folk are never friendly, and always hungry."
				)
				(10
					(stag setLoop: 5 setCel: 0 setCycle: End self)
				)
				(11
					(stag setCycle: Beg self)
				)
				(12
					(stag setLoop: 2)
					(stag setCel: (stag lastCel:) setCycle: Beg self)
					(gKqSound1 number: 3202 setLoop: 1 play:)
					(gEgo setMotion: MoveTo 155 128 self)
				)
				(13 0)
				(14
					(motherOak setHotspot: 8 10 73) ; Do, Exit, Pomegranate
					(gEgo normalize: 2)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo posn: 138 128 normalize:)
					(proc11_3 gEgo stag)
					(stag setCycle: 0 setLoop: 2 1 setCel: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance touchTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 171 99 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gKqSound1 number: 3204 setLoop: 1 play: self)
			)
			(3
				(gEgo view: 8685 loop: 1 cel: 0 setCycle: End)
				(gKqSound1 number: 3214 setLoop: 1 play: self)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo normalize:)
				(gEgo setMotion: MoveTo 171 106 self)
			)
			(6
				(motherOak setHotspot: 0)
				(motherOak approachVerbs: 0)
				(if (not (IsFlag 105))
					(spike setHotspot: 0)
					(spike approachVerbs: 0)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance restHandOnTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 171 99 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo
					setScale: 0
					scaleX: 128
					scaleY: 128
					view: 3201
					setLoop: 8
					setCel: 0
					setCycle: End self
				)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
			)
			(3
				(gMessager say: 3 8 6 0 self) ; "(THINKS TO HERSELF)Poor thing. It almost looks like it's in pain."
			)
			(4
				((ScriptID 13 0) view: -1 hide_mouth: 0) ; aEgoTalker
				(gEgo
					normalize: 7
					setScaler: Scaler 109 70 125 93
					setHeading: 180 self
				)
			)
			(5
				(gEgo setMotion: MoveTo 171 106 self)
			)
			(6
				(proc11_3 gEgo stag)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tellTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 171 99 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo view: 8155 setLoop: 0 setCel: 0 setCycle: End self)
				((ScriptID 13 0) view: 8155) ; aEgoTalker
			)
			(3
				(gMessager say: 3 8 7 0 self) ; "(WHISPERS)Lady Ceres, I will help you if I can."
			)
			(4
				((ScriptID 13 0) view: -1) ; aEgoTalker
				(gKqSound1 number: 3204 setLoop: 1 play: self)
			)
			(5
				(gEgo normalize: setMotion: MoveTo 171 106 self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTurnValAround of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc11_3 gEgo stag self)
				(if (not (or (IsFlag 135) (IsFlag 241)))
					(stag loop: 2 cel: 0 setCycle: End self)
					(gKqSound1 number: 3202 setLoop: 1 play:)
				else
					(= local1 1)
					(= cycles 1)
				)
			)
			(1 0)
			(2
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(if (and (IsFlag 135) (not (IsFlag 241)))
					(gEgo setHeading: 225 self)
				else
					(proc11_3 gEgo stag self)
				)
				(if (not local1)
					(stag setCycle: Beg self)
					(gKqSound1 number: 3202 setLoop: 1 play:)
				else
					(= local1 0)
					(= cycles 1)
				)
			)
			(3 0)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHelpAttis of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc11_3 gEgo attis self)
			)
			(1
				(gMessager say: 4 8 10 0 self) ; "(THINKS TO HERSELF)I vow I will help you if I can, noble Attis."
			)
			(2
				(gEgo setHeading: 180)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sChap5SecondTalk of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc11_3 gEgo stag self)
				(stag loop: 2 cel: 0 setCycle: End self)
				(gKqSound1 number: 3202 setLoop: 1 play:)
			)
			(1 0)
			(2)
			(3
				(stag setCycle: Beg self)
				(gKqSound1 number: 3202 setLoop: 1 play:)
				(proc11_3 gEgo stag self)
			)
			(4 0)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance touchSpike of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 270 self)
			)
			(1
				(gMessager say: 2 8 7 1 self) ; "(CONCERNED AND ANGRY)What wicked creature drove this stake into the tree--into Lady Ceres?"
			)
			(2
				(stag loop: 2 cel: 0 setCycle: End self)
				(gKqSound1 number: 3202 setLoop: 1 play:)
				(gEgo setHeading: 90 self)
			)
			(3 0)
			(4
				(SetFlag 134)
				(gMessager say: 2 8 7 2 self) ; "(SAD AND ANGRY)The same creature who turned her into a tree. If I only know who that was, Lady Valanice, I would surely make him regret it. I fear my lady may die of that wound, but I can do nothing about it with these clumsy hooves."
			)
			(5
				(gKqSound1 number: 3202 setLoop: 1 play:)
				(stag setCycle: Beg self)
			)
			(6
				(proc11_3 gEgo stag)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sValLookSpike of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 2 8 6 0 self) ; "(THINKS TO HERSELF)Who could have done such a horrible thing?"
			)
			(1
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo setHeading: 180 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance trySpike of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(gEgo setHeading: 90 self)
				)
				(1
					(gMessager say: 2 8 8 1 self) ; "(DETERMINED)With your permission, my lord, I would like to try to remove this stake."
				)
				(2
					(stag loop: 2 cel: 0 setCycle: End self)
					(gKqSound1 number: 3202 setLoop: 1 play:)
				)
				(3
					(stag setLoop: 5 setCel: 0 setCycle: End self)
				)
				(4
					(gEgo setHeading: 315 self)
					(stag setCycle: Beg self)
				)
				(5 0)
				(6
					(stag setLoop: 2)
					(stag setCel: (stag lastCel:))
					(spike hide:)
					(gEgo
						view: 3201
						setLoop: 6
						setScaler: Scaler 110 108 104 98
						scaleX: 128
						scaleY: 128
						setCel: 0
						posn: 167 107
						setCycle: End self
					)
					(mySound number: 3203 setLoop: 1 play: self)
				)
				(7 0)
				(8
					(gEgo setLoop: 7 setCel: 0 setCycle: CT 13 1 self)
				)
				(9
					(spike show:)
					(gEgo setCycle: End self)
				)
				(10
					(gEgo
						normalize: 6
						posn: 168 108
						setScaler: Scaler 109 70 125 93
					)
					(= cycles 1)
				)
				(11
					(gMessager say: 2 8 8 2 self) ; "Do not feel bad, Valanice. That stake was placed there by the darkest of evil magic. I'm not sure anyone can remove it."
				)
				(12
					(gMessager sayRange: 2 8 8 3 4 self) ; "(VERY CONCERNED. THIS JUST OCCURRED TO HER)I hate to ask you this, Lord Attis, but what will happen if Ceres--Mother Nature herself--does indeed perish?"
				)
				(13
					(stag setCycle: Beg self)
					(gKqSound1 number: 3202 setLoop: 1 play:)
				)
				(14
					(proc11_3 gEgo stag)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(stag setCycle: 0 loop: 2 cel: 0)
					(spike show:)
					(gEgo
						setMotion: 0
						setCycle: 0
						normalize: 6
						posn: 168 108
						setScaler: Scaler 109 70 125 93
					)
					(proc11_3 gEgo stag)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance takeSpikeOut of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOn: handsOff: 1)
					(gEgo posn: 340 121 setMotion: MoveTo 250 121 self)
				)
				(1
					(motherOak setHotspot: 0 73) ; Pomegranate
					(Load 140 3206) ; WAVE
					(spike dispose:)
					(gEgo setLoop: 7)
					(attis view: 3203 setLoop: 0 setCel: 0 setCycle: End self)
					(mySound number: 3205 setLoop: 1 play: self)
				)
				(2 0)
				(3
					(attis posn: 178 98 setLoop: 1 setCel: 0 setCycle: End self)
				)
				(4
					(attis
						setLoop: 2
						setCel: 0
						posn: 178 100
						setCycle: End self
					)
					(mySound number: 3206 setLoop: 1 play: self)
				)
				(5 0)
				(6
					(mySound number: 3207 setLoop: 1 play:)
					(sap setCycle: 0)
					(= seconds 4)
				)
				(7
					(sap loop: 4 cycleSpeed: 5 setCycle: Fwd)
					(= seconds 3)
				)
				(8
					(attis view: 3205 setLoop: 0 setCel: 0 setCycle: End self)
				)
				(9
					(SetFlag 105)
					(gMessager sayRange: 0 0 9 1 2 self) ; "(SADLY)It would seem that the curse is stronger than I am. but I will not let her die. I will not."
				)
				(10
					(attis setLoop: 1 setCel: 0 setCycle: End self)
				)
				(11
					(gMessager say: 0 0 9 3 self) ; "(GRATEFULLY)Valanice, if she is in Ooga Booga, you must pass through the swamp--and I have learned of a terrible monster who dwells there. I will help you evade him, but first, I must try to save my lady love."
				)
				(12
					(attis setCycle: Beg self)
				)
				(13
					(attis setLoop: 0)
					(attis cel: (attis lastCel:) setCycle: CT 12 -1 self)
				)
				(14
					(gKqMusic1 fade:)
					(glow init: setCycle: End self)
				)
				(15
					(glow setCycle: RandCycle)
					(glow2 init: setCycle: RandCycle)
					(= cycles 1)
				)
				(16
					(gKqMusic1
						number: 3208
						setLoop: -1
						play:
						setVol: 0
						fade: 127 30 25 0
					)
					(gEgo setHeading: 180 self)
				)
				(17
					((gCurRoom obstacles:) dispose:)
					(gCurRoom
						obstacles: 0
						addObstacle:
							((Polygon new:)
								type: PContainedAccess
								init: 159 111 128 111 129 92 102 102 38 91 102 87 92 83 -10 85 -10 136 330 136 330 83 314 82 302 98 289 98 271 109 235 108 218 98 197 98 184 105 162 105
								yourself:
							)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gGame handsOff:)
					(attis view: 3205 loop: 0 cel: 12 setCycle: 0 posn: 178 100)
					(gKqMusic1 number: 3208 setLoop: -1 play:)
					(glow init: setCycle: RandCycle)
					(glow2 init: setCycle: RandCycle)
					(sap loop: 4 cycleSpeed: 5 setCycle: Fwd)
					(motherOak setHotspot: 0 73) ; Pomegranate
					(spike dispose:)
					(SetFlag 105)
					(gEgo posn: 250 121 setHeading: 180)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom
						obstacles: 0
						addObstacle:
							((Polygon new:)
								type: PContainedAccess
								init: 159 111 128 111 129 92 102 102 38 91 102 87 92 83 -10 85 -10 136 330 136 330 83 314 82 302 98 289 98 271 109 235 108 218 98 197 98 184 105 162 105
								yourself:
							)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance flyIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo hide:)
				(Load 140 865) ; WAVE
				(= cycles 8)
			)
			(1
				(gEgo
					view: 3261
					setScaler: 0
					scaleX: 128
					scaleY: 128
					maxScale: 128
					setLoop: 0
					setCel: 0
					posn: 97 104
					cycleSpeed: (+ (gEgo moveSpeed:) 8)
					show:
					setCycle: CT 3 1 self
				)
			)
			(2
				(mySound number: 865 setLoop: 1 play: self)
				(gEgo setCycle: CT 7 1 self)
			)
			(3 0)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(gEgo
					normalize:
					cycleSpeed: (gEgo moveSpeed:)
					setScaler: Scaler 109 70 125 93
					setHeading: 180
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCombScript of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(proc11_3 gEgo stag self)
					(stag loop: 2 cel: 0 setCycle: End self)
					(mySound number: 3202 setLoop: 1 play:)
				)
				(1 0)
				(2
					(SetFlag 116)
					(if (IsFlag 404)
						(gMessager sayRange: 1 5 2 1 4 self) ; "(HOPEFULLY, WORRIED)Good sir, my daughter was taken from me by powerful magic. She is a lovely girl, with eyes of blue, and golden hair. Her name is Rosella. Have you seen her?"
					else
						(gMessager say: 1 5 2 0 self) ; "(HOPEFULLY, WORRIED)Good sir, my daughter was taken from me by powerful magic. She is a lovely girl, with eyes of blue, and golden hair. Her name is Rosella. Have you seen her?"
					)
				)
				(3
					(if (IsFlag 404)
						(gMessager say: 1 5 2 7 self) ; "(EXCITED)Thank you! I must go!"
					else
						(self cue:)
					)
				)
				(4
					(gEgo setHeading: 180 self)
					(stag setCycle: Beg self)
					(mySound number: 3202 setLoop: 1 play:)
				)
				(5 0)
				(6
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(ClearFlag 539)
			(SetFlag 116)
			(stag setCycle: 0 loop: 2 cel: 0)
			(proc11_3 gEgo stag)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sValFirstChap5 of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(proc11_3 gEgo stag self)
				)
				(1
					((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
					(gMessager say: 1 8 22 1 self) ; "(SYMPATHETIC, SOFT)Poor creature. He looks so sorrowful."
				)
				(2
					((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
					(stag loop: 2 cel: 0 setCycle: End self)
					(gKqSound1 number: 3202 setLoop: 1 play:)
				)
				(3
					(gMessager sayRange: 1 8 22 2 5 self) ; "(SADLY)My life is sorrow, lady."
				)
				(4
					(stag setCycle: Beg self)
					(gKqSound1 number: 3202 setLoop: 1 play:)
				)
				(5
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(stag setCycle: 0 loop: 2 cel: 0)
					(proc11_3 gEgo stag)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sValSecondChap5 of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(proc11_3 gEgo stag self)
					(stag loop: 2 cel: 0 setCycle: End self)
					(gKqSound1 number: 3202 setLoop: 1 play:)
				)
				(1 0)
				(2
					(gMessager say: 1 8 23 0 self) ; "Take heart, Attis. You must never give up."
				)
				(3
					(proc11_3 gEgo stag self)
					(if (not local1)
						(stag setCycle: Beg self)
						(gKqSound1 number: 3202 setLoop: 1 play:)
					)
				)
				(4 0)
				(5
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(stag setCycle: 0 loop: 2 cel: 0)
					(proc11_3 gEgo stag)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sValNoRock2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc11_3 gEgo stag self)
				(stag loop: 2 cel: 0 setCycle: End self)
				(gKqSound1 number: 3202 setLoop: 1 play:)
			)
			(1 0)
			(2
				(gMessager say: 1 8 24 0 self) ; "What can you tell me about this rock spirit? What manner of being is he?"
			)
			(3
				(proc11_3 gEgo stag self)
				(if (not local1)
					(stag setCycle: Beg self)
					(gKqSound1 number: 3202 setLoop: 1 play:)
				)
			)
			(4 0)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sValNoRock3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc11_3 gEgo stag self)
				(stag loop: 2 cel: 0 setCycle: End self)
				(gKqSound1 number: 3202 setLoop: 1 play:)
			)
			(1 0)
			(2
				(gMessager say: 1 8 25 0 self) ; "How will I know this Rock Spirit when I meet him?"
			)
			(3
				(proc11_3 gEgo stag self)
				(if (not local1)
					(stag setCycle: Beg self)
					(gKqSound1 number: 3202 setLoop: 1 play:)
				)
			)
			(4 0)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sValNoRock4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc11_3 gEgo stag self)
			)
			(1
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 1 8 25 0 self) ; "How will I know this Rock Spirit when I meet him?"
			)
			(2
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sValTalkStag3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc11_3 gEgo stag self)
			)
			(1
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 1 8 4 0 self) ; "(THINKS TO HERSELF)Poor fellow. I should leave him in peace."
			)
			(2
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sValSecondStagTalk of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(proc11_3 gEgo stag self)
					(stag loop: 2 cel: 0 setCycle: End self)
					(gKqSound1 number: 3202 setLoop: 1 play:)
				)
				(1 0)
				(2
					(gMessager say: 1 8 3 0 self) ; "Is there nothing that can break the enchantment on you and your wife, Attis?"
				)
				(3
					(proc11_3 gEgo stag self)
					(if (not local1)
						(stag setCycle: Beg self)
						(gKqSound1 number: 3202 setLoop: 1 play:)
					)
				)
				(4 0)
				(5
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(stag setCycle: 0 loop: 2 cel: 0)
					(proc11_3 gEgo stag)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance showPom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc11_3 gEgo attis self)
			)
			(1
				(gMessager say: 4 73 0 1 self) ; "I have replenished the Cornucopia, lord Attis. See, this strange fruit was part of its bounty."
			)
			(2
				(attis loop: 1 cel: 0 cycleSpeed: 6 setCycle: End self)
				(gKqMusic1 setVol: 0)
			)
			(3
				(gMessager say: 4 73 0 2 self) ; "(A TINY BIT HOPEFUL)A pomegranate? the pomegranate is the symbol of birth and death, of regeneration! Perhaps it could help my Ceres...but no. I dream."
			)
			(4
				(attis setCycle: Beg self)
			)
			(5
				(attis loop: 0 cycleSpeed: 15 setCycle: RandCycle)
				(gKqMusic1 setVol: 127)
				(gEgo normalize: setHeading: 180 self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stag of Actor
	(properties
		noun 1
		approachX 165
		approachY 118
		approachDist 10
		x 194
		y 76
		priority 96
		fixPriority 1
		view 3201
		signal 4096
	)

	(method (init)
		(super init:)
		((ScriptID 7000 0) ; attisTalker
			clientCel: 11
			loop: -1
			view: -1
			mouth_x: -999
			mouth_y: -999
			client: self
		)
		(= signal (| (self signal:) $0001))
		(if (IsFlag 116)
			(self approachVerbs: 8 setHotspot: 8 10) ; Do, Do, Exit
		else
			(self approachVerbs: 8 5 setHotspot: 8 10 5) ; Do, Golden_Comb, Do, Exit, Golden_Comb
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((not (IsFlag 133))
						(spike setHotspot: 8 10) ; Do, Exit
						(SetFlag 148)
						(SetFlag 133)
						(gCurRoom setScript: secondTalk)
					)
					((and (IsFlag 133) (not (IsFlag 135)))
						(SetFlag 112)
						(SetFlag 135)
						(gCurRoom setScript: sValSecondStagTalk)
					)
					(
						(and
							(not (IsFlag 148))
							(not (IsFlag 239))
							(== gChapter 5)
						)
						(SetFlag 239)
						(SetFlag 112)
						(gCurRoom setScript: sValFirstChap5)
					)
					((and (IsFlag 148) (not (IsFlag 239)) (== gChapter 5))
						(SetFlag 239)
						(SetFlag 112)
						(gCurRoom setScript: sValSecondChap5)
					)
					((and (IsFlag 239) (not (IsFlag 240)))
						(SetFlag 240)
						(gCurRoom setScript: sValNoRock2)
					)
					((and (IsFlag 240) (not (IsFlag 239)))
						(SetFlag 241)
						(gCurRoom setScript: sValNoRock3)
					)
					((IsFlag 241)
						(gCurRoom setScript: sValNoRock4)
					)
					((IsFlag 135)
						(gCurRoom setScript: sValTalkStag3)
					)
				)
			)
			(5 ; Golden_Comb
				(self setHotspot: 8 10) ; Do, Exit
				(gCurRoom setScript: sCombScript)
			)
		)
	)
)

(instance attis of Actor
	(properties
		noun 4
		approachX 180
		approachY 110
		x 178
		y 98
		priority 96
		fixPriority 1
		view 3203
	)

	(method (init)
		((ScriptID 7000 0) ; attisTalker
			clientCel: -2
			loop: -1
			view: -1
			mouth_x: -999
			mouth_y: -999
			client: self
		)
		(if (and (IsFlag 105) (not (gEgo has: 66))) ; Pomegranate
			0
		else
			(self setHotspot: 8 10 73 approachVerbs: 8 73) ; Do, Exit, Pomegranate, Do, Pomegranate
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((IsFlag 207)
						(self setHotspot: 0)
						(gCurRoom setScript: sStopPlayingMab)
					)
					((IsFlag 203)
						(cond
							((IsFlag 563)
								(gCurRoom setScript: sQuitBugging)
							)
							((IsFlag 248)
								(SetFlag 563)
								(gCurRoom setScript: sStopPlaying 0 1)
							)
							(else
								(SetFlag 248)
								(gCurRoom setScript: sStopPlaying 0 0)
							)
						)
					)
					((IsFlag 105)
						(attis setHotspot: 0)
						(gCurRoom setScript: sHelpAttis)
					)
				)
			)
			(73 ; Pomegranate
				(self deleteHotVerb: 73 approachVerbs: 8) ; Pomegranate, Do
				(gCurRoom setScript: showPom)
			)
		)
	)
)

(instance motherOak of View
	(properties
		approachX 160
		approachY 100
		x 4
		y 72
		z -4
		priority 94
		fixPriority 1
		view 3212
	)

	(method (init)
		(cond
			((IsFlag 105)
				(self setHotspot: 0 73) ; Pomegranate
			)
			((== gChapter 4)
				0
				(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
			)
			((IsFlag 104)
				(self setHotspot: 8 10 73 approachVerbs: 8) ; Do, Exit, Pomegranate, Do
			)
			(else
				(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
			)
		)
		(super init: &rest)
		(= signal (| (self signal:) $1000))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((== gChapter 4)
						(gCurRoom setScript: touchTree)
					)
					((not (IsFlag 105))
						(self setHotspot: 0 73) ; Pomegranate
						(if (IsFlag 133)
							(gCurRoom setScript: tellTree)
						else
							(gCurRoom setScript: restHandOnTree)
						)
					)
				)
				(return 1)
			)
			(73 ; Pomegranate
				(gCurRoom setScript: sGivePom)
				(return 1)
			)
		)
	)
)

(instance river of View
	(properties
		x 203
		y 75
		view 3213
	)
)

(instance spike of View
	(properties
		noun 2
		sightAngle 20
		approachX 171
		approachY 99
		x 153
		y 72
		priority 96
		fixPriority 1
		view 3212
		loop 1
	)

	(method (init)
		(super init:)
		(if (or (not (IsFlag 401)) (and (IsFlag 104) (== gChapter 4)))
			(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((== gChapter 4)
						(gCurRoom setScript: touchTree)
					)
					((and (IsFlag 133) (IsFlag 134))
						(SetFlag 401)
						(self setHotspot: 0)
						(gCurRoom setScript: trySpike)
					)
					((IsFlag 133)
						(SetFlag 134)
						(gCurRoom setScript: touchSpike)
					)
					(else
						(self setHotspot: 0)
						(gCurRoom setScript: sValLookSpike)
					)
				)
			)
		)
	)
)

(instance tears of Prop
	(properties
		x 165
		y 133
		view 3201
		loop 1
	)
)

(instance sap of Prop
	(properties
		x 138
		y 66
		priority 95
		fixPriority 1
		view 3203
		loop 3
	)

	(method (doVerb theVerb)
		(motherOak doVerb: theVerb)
	)
)

(instance glow of Prop
	(properties
		x 170
		y 104
		priority 96
		fixPriority 1
		view 3205
		loop 3
	)

	(method (onMe)
		(return 0)
	)
)

(instance glow2 of Prop
	(properties
		x 170
		y 104
		priority 95
		fixPriority 1
		view 3205
		loop 4
	)

	(method (onMe)
		(return 0)
	)
)

(instance branch of Prop
	(properties
		x 150
		y 47
		priority 100
		fixPriority 1
		view 3209
	)
)

(instance ceres of Prop
	(properties
		view 3209
		loop 3
	)

	(method (init)
		(super init:)
		(= signal (| (self signal:) $1000))
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((== (gCurRoom script:) sTimeCeres)
						(sTimeCeres dispose:)
						(gCurRoom setScript: sTalkCeres)
					)
					((IsFlag 545)
						(gCurRoom setScript: sCeresLastMsg)
					)
					(else
						(gCurRoom setScript: sTalkCeres2)
					)
				)
			)
		)
	)
)

(instance treeHealed of Prop
	(properties
		x 1
		y 2
		view 3211
		loop 3
	)
)

(instance flower1 of Prop
	(properties
		x 125
		y 80
		view 3211
		loop 4
	)
)

(instance flower2 of Prop
	(properties
		x 197
		y 125
		view 3211
		loop 5
	)
)

(instance eastExitFeature of ExitFeature
	(properties
		nsLeft 291
		nsTop 80
		nsRight 320
		nsBottom 140
		approachX 330
		approachY 113
		x 330
		y 113
		exitDir 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(gCurRoom newRoom: 3250)
				(return 1)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 10 10 setHotspot: 10 10) ; Exit, Exit, Exit, Exit
	)
)

(instance westExitFeature of ExitFeature
	(properties
		nsTop 88
		nsRight 45
		nsBottom 140
		approachX -20
		approachY 113
		x -20
		y 113
		exitDir 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(gKqMusic1 fade:)
				(gCurRoom newRoom: 3150)
				(return 1)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 10 10 setHotspot: 10 10) ; Exit, Exit, Exit, Exit
	)
)

(instance ceresTalker of KQTalker
	(properties)
)

(instance mySound of Sound
	(properties)
)

