;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3250)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Talker)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm3250 0
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
)

(instance rm3250 of KQRoom
	(properties
		picture 3250
	)

	(method (init)
		(Load rsSOUND 3000)
		(if (and (not (== gPrevRoomNum 3050)) (not (== gPrevRoomNum 3100)))
			(gKqMusic1 number: 3000 loop: -1 play:)
		)
		(super init:)
		(Load rsMESSAGE 3250)
		(if (IsFlag 146)
			(Load rsVIEW 3261)
			(Load rsSOUND 852)
			(Load rsSOUND 864)
		)
		(if (or (== gValOrRoz -3) (!= gChapter 4)) ; Roz
			(aFlower view: 32535 signal: (| (aFlower signal:) $4000))
		else
			(aFlower view: 33254 loop: 2 cel: 0)
		)
		(if (IsFlag 103)
			(aFlower signal: (| (aFlower signal:) $4000))
		)
		(if
			(and
				(not (IsFlag 130))
				(not (IsFlag 103))
				(not (OneOf gPrevRoomNum 3100 3300 3050))
			)
			(aFlower signal: (| (aFlower signal:) $4000) init:)
			(nectarFlowers init:)
		else
			(aFlower init:)
		)
		(drippy init:)
		(if (not (IsFlag 130))
			(drippy setScript: sDrippy)
		)
		(if (not (IsFlag 103))
			(bird1 init:)
			(bird2 init:)
		)
		(if (IsFlag 225)
			(pom cel: 6 init:)
		)
		(gEgo init: setScaler: Scaler 83 28 128 69 normalize:)
		(switch gPrevRoomNum
			(3200
				(ClearFlag 106)
				(gEgo posn: -10 100)
				(gCurRoom setScript: sEnterOak)
			)
			(3100
				(if (IsFlag 146)
					(ClearFlag 106)
					(gEgo
						view: 3261
						loop: 1
						cel: 0
						posn: 153 133
						hide:
						setScale: 0
					)
					(gCurRoom setScript: sSneezed)
				else
					(SetFlag 106)
					(gEgo posn: 252 71)
					(gCurRoom setScript: sEnterFromRock)
				)
			)
			(3050
				(SetFlag 106)
				(gEgo posn: 49 69)
			)
			(6200
				(ClearFlag 106)
				(gEgo
					view: 3261
					loop: 0
					cel: 0
					posn: 153 133
					hide:
					setScale: 0
				)
				(gCurRoom setScript: sSneezed)
			)
			(1000
				(ClearFlag 106)
				(gEgo posn: 158 190)
				(gCurRoom setScript: sFromTunnel)
			)
			(23 ; selectGameRoom
				(gEgo normalize:)
				(gGame handsOn:)
			)
			(else
				(ClearFlag 106)
				(gEgo posn: -10 100)
				(gCurRoom setScript: sEnterOak)
			)
		)
		(pitcherMaiden init:)
		(if (IsFlag 225)
			(cornMaiden init:)
		else
			(cornucopiaMaiden init:)
		)
		(river init:)
		(if
			(or
				(and (IsFlag 103) (OneOf gPrevRoomNum 3100 3050 6200))
				(not (OneOf gPrevRoomNum 3100 3050 6200))
				(IsFlag 146)
			)
			(myWestExit init:)
			(mySouthExit init:)
		)
		(if (IsFlag 103)
			(Load 140 894) ; WAVE
			(myRiverExit init:)
			(gKqSound1 number: 894 loop: -1 play:)
			(rainbowBridge
				view: 33257
				loop: 2
				cel: 0
				signal: (| (rainbowBridge signal:) $4000)
				init:
			)
			(riverProp
				view: 33257
				loop: 3
				cel: 0
				init:
				setPri: 40
				setCycle: Fwd
			)
			(riverPropSouth
				view: 33257
				loop: 1
				cel: 0
				init:
				setPri: 35
				setCycle: Fwd
			)
			(riverPropNorth
				view: 33257
				loop: 0
				cel: 0
				init:
				setPri: 35
				setCycle: Fwd
			)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 32 91 0 96 0 119 33 119 42 126 42 131 123 150 232 138 223 127 236 108 251 96 284 77 291 83 303 83 293 73 285 71 265 72 252 63 245 66 245 74 221 78 195 85 182 84 75 71 57 70 27 62 19 64 54 73 76 73 196 87 248 76 276 79 252 93 234 107 220 125 211 133 178 120 155 119 123 132 43 116 45 99 53 92
						yourself:
					)
			)
			(myNorthExit init:)
			(myNorthWestExit init:)
		else
			(brokenBridge init:)
			(if (and (OneOf gPrevRoomNum 3100 3050) (not (IsFlag 146)))
				(SetFlag 106)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 29 66 58 74 76 72 194 88 213 83 239 79 257 80 285 82 291 85 303 84 295 74 280 70 258 72 253 63 244 65 248 72 230 75 214 79 205 84 192 86 73 70 56 69
							yourself:
						)
				)
				(myNorthExit init:)
				(myNorthWestExit init:)
			else
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 267 138 179 128 182 123 159 120 123 126 56 126 44 98 58 91 32 86 0 93 0 108 38 113 46 137
							yourself:
						)
				)
			)
		)
		(if (not (gCurRoom script:))
			(gGame handsOn:)
		)
	)

	(method (notify)
		(if (and (gCast contains: bird) (not (IsFlag 130)))
			(cond
				((gEgo has: 16) ; Fresh_Water
					(Load rsVIEW 3250)
					(gCurRoom setScript: sPourOut)
				)
				((gEgo has: 15) ; Salt_Water
					(Load rsVIEW 3250)
					(gCurRoom setScript: sPourOut)
				)
				((and (gEgo has: 2) (not (IsFlag 131))) ; Clay_Pot
					(gCurRoom setScript: sBirdComes)
				)
				(else
					(Load rsVIEW 3253)
					(gCurRoom setScript: getNectar)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 3050) (!= newRoomNumber 3100))
			(gKqMusic1 fade: 0 30 10 1)
		)
		(ClearFlag 146)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(if (< (gEgo y:) 89)
			(SetFlag 106)
		else
			(ClearFlag 106)
		)
		(super dispose:)
	)
)

(instance sDrippy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self cue:)
			)
			(1
				(= register (Random 5 10))
				(= seconds register)
			)
			(2
				(drippy
					setCel: 0
					setPri: 114
					ignoreActors: 1
					setCycle: End self
				)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance sBirds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self cue:)
			)
			(1
				(= register (Random 5 9))
				(if (== gValOrRoz -3) ; Roz
					(bird1 view: 32535)
					(bird2 view: 32535)
				else
					(bird1 view: 33253)
					(bird2 view: 33253)
				)
				(= seconds register)
			)
			(2
				(= register (Random 1 3))
				(switch register
					(1
						(if (== gValOrRoz -3) ; Roz
							(bird1 loop: 1)
						else
							(bird1 loop: 0)
						)
						(bird1
							cel: 0
							ignoreActors: 1
							ignoreHorizon: 1
							posn: 132 120
							setCycle: CT 12 1 self
						)
					)
					(2
						(if (== gValOrRoz -3) ; Roz
							(bird1 loop: 1)
						else
							(bird1 loop: 0)
						)
						(bird2
							cel: 0
							ignoreActors: 1
							ignoreHorizon: 1
							posn: 99 85
							setCycle: CT 23 1 self
						)
					)
					(else
						(if (== gValOrRoz -3) ; Roz
							(bird1 loop: 1)
						else
							(bird1 loop: 0)
						)
						(bird1
							cel: 0
							ignoreActors: 1
							ignoreHorizon: 1
							posn: 132 120
							setCycle: CT 12 1 self
						)
					)
				)
			)
			(3
				(switch register
					(1
						(= cycles 1)
					)
					(2
						(= cycles 1)
					)
					(else
						(if (== gValOrRoz -3) ; Roz
							(bird1 loop: 2 1)
							(bird2 loop: 1)
						else
							(bird1 loop: 1 1)
							(bird2 loop: 0)
						)
						(bird1 cel: 0 posn: 34 21 setCycle: Fwd)
						(bird2
							cel: 0
							ignoreActors: 1
							ignoreHorizon: 1
							posn: 99 85
							setCycle: CT 23 1 self
						)
					)
				)
			)
			(4
				(switch register
					(1
						(if (== gValOrRoz -3) ; Roz
							(bird1 loop: 2 1)
						else
							(bird1 loop: 1 1)
						)
						(bird1 cel: 0 posn: 34 21 setCycle: Fwd)
					)
					(2
						(if (== gValOrRoz -3) ; Roz
							(bird2 loop: 2 1)
						else
							(bird2 loop: 1 1)
						)
						(bird2 cel: 0 posn: 8 4 setCycle: Fwd)
					)
					(else
						(if (== gValOrRoz -3) ; Roz
							(bird2 loop: 2 1)
						else
							(bird2 loop: 1 1)
						)
						(bird2 cel: 0 posn: 8 4 setCycle: Fwd)
					)
				)
				(= seconds 3)
			)
			(5
				(switch (= local2 (Random 1 5))
					(1
						(= local3 32)
						(= local4 21)
						(= local5 22)
						(= local6 10)
					)
					(2
						(= local3 22)
						(= local4 10)
						(= local5 10)
						(= local6 6)
					)
					(3
						(= local3 10)
						(= local4 6)
						(= local5 8)
						(= local6 14)
					)
					(4
						(= local3 8)
						(= local4 14)
						(= local5 5)
						(= local6 10)
					)
					(else
						(= local3 5)
						(= local4 10)
						(= local5 32)
						(= local6 21)
					)
				)
				(switch register
					(1
						(= cycles 1)
					)
					(2
						(if (== gValOrRoz -3) ; Roz
							(bird2 loop: 9)
						else
							(bird2 loop: 3)
						)
						(bird2 cel: 0 posn: 8 4 setCycle: End self)
					)
					(else
						(if (== gValOrRoz -3) ; Roz
							(bird2 loop: 9)
						else
							(bird2 loop: 3)
						)
						(bird2 cel: 0 posn: 8 4 setCycle: End self)
					)
				)
			)
			(6
				(switch register
					(1
						(if (== gValOrRoz -3) ; Roz
							(bird1 loop: 2)
						else
							(bird1 loop: 1)
						)
						(bird1
							posn: 34 21
							setCycle: Fwd
							setMotion: MoveTo local3 local4 self
						)
					)
					(2
						(if (== gValOrRoz -3) ; Roz
							(bird2 loop: 11)
						else
							(bird2 loop: 5)
						)
						(bird2
							cel: 0
							posn: 8 4
							setCycle: Fwd
							setMotion: MoveTo local3 local4 self
						)
					)
					(else
						(if (== gValOrRoz -3) ; Roz
							(bird1 loop: 2)
							(bird2 loop: 11)
						else
							(bird1 loop: 1)
							(bird2 loop: 5)
						)
						(bird1
							cel: 0
							posn: 34 21
							setCycle: Fwd
							setMotion: MoveTo local3 local4 self
						)
						(bird2
							cel: 0
							posn: 8 4
							setCycle: Fwd
							setMotion: MoveTo local5 local6 self
						)
					)
				)
			)
			(7
				(switch register
					(1
						(= cycles 1)
					)
					(2
						(if (== gValOrRoz -3) ; Roz
							(bird2 loop: 9)
						else
							(bird2 loop: 3)
						)
						(bird2 cel: (bird2 lastCel:) setCycle: Beg self)
					)
					(else
						(if (== gValOrRoz -3) ; Roz
							(bird2 loop: 9)
						else
							(bird2 loop: 3)
						)
						(bird2 cel: (bird2 lastCel:) setCycle: Beg self)
					)
				)
			)
			(8
				(= seconds (Random 4 8))
			)
			(9
				(switch register
					(1
						(if (== gValOrRoz -3) ; Roz
							(bird1 loop: 2)
						else
							(bird1 loop: 1)
						)
						(bird1
							setCycle: Fwd
							setMotion: MoveTo (Random 0 local3) -10 self
						)
					)
					(2
						(if (== gValOrRoz -3) ; Roz
							(bird2 loop: 2)
						else
							(bird2 loop: 1)
						)
						(bird2
							cel: 0
							setCycle: Fwd
							setMotion: MoveTo (Random 0 local3) -10 self
						)
					)
					(else
						(if (== gValOrRoz -3) ; Roz
							(bird1 loop: 2)
							(bird2 loop: 11)
						else
							(bird1 loop: 1)
							(bird2 loop: 5)
						)
						(bird1
							cel: 0
							setCycle: Fwd
							setMotion: MoveTo (Random 0 local3) -10 self
						)
						(bird2
							cel: 0
							setCycle: Fwd
							setMotion: MoveTo (Random 0 local5) -10 self
						)
					)
				)
			)
			(10
				(self changeState: 0)
			)
		)
	)
)

(instance sEnterFromRock of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= cycles 2)
				)
				(1
					(gEgo setMotion: MoveTo 252 74 self)
				)
				(2
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo posn: 252 78)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sEnterOak of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= cycles 2)
				)
				(1
					(gEgo setMotion: MoveTo 28 113 self)
				)
				(2
					(gEgo setHeading: 180 self)
				)
				(3
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo posn: 31 113 normalize: 2)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sToOakTree of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= cycles 2)
				)
				(1
					(gEgo setMotion: PolyPath -10 100 self)
				)
				(2
					(gCurRoom newRoom: 3200)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gCurRoom newRoom: 3200)
				)
			)
		)
	)
)

(instance sFromTunnel of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= cycles 3)
				)
				(1
					(gEgo setMotion: MoveTo 158 127 self)
				)
				(2
					(gEgo setHeading: 270 self)
				)
				(3
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gEgo posn: 158 127 normalize: 2)
					(ClearFlag 539)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sToColossus of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setMotion: MoveTo (gEgo x:) 190 self)
				)
				(1
					(if (== (gKqSound1 number:) 894)
						(gKqSound1 setLoop: 1 stop:)
					)
					(gCurRoom newRoom: 1000)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(if (== (gKqSound1 number:) 894)
						(gKqSound1 setLoop: 1 stop:)
					)
					(gCurRoom newRoom: 1000)
				)
			)
		)
	)
)

(instance lookAtRiver of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (or (IsFlag 106) (OneOf gPrevRoomNum 3300 3050))
						(gEgo setHeading: 225 self)
					else
						(gEgo setHeading: 45 self)
					)
				)
				(1
					(cond
						((or (IsFlag 106) (OneOf gPrevRoomNum 3300 3050))
							(if (== gValOrRoz -3) ; Roz
								(Load rsVIEW 8494)
								(= cycles 1)
							else
								(Load rsVIEW 8131)
								(= cycles 1)
							)
						)
						((== gValOrRoz -3) ; Roz
							(Load rsVIEW 8495)
							(= cycles 1)
						)
						(else
							(Load rsVIEW 8133)
							(= cycles 1)
						)
					)
				)
				(2
					(cond
						((or (IsFlag 106) (OneOf gPrevRoomNum 3300 3050))
							(if (== gValOrRoz -3) ; Roz
								(gEgo
									view: 8494
									loop: 1
									cel: 0
									x: 197
									y: 86
									setCycle: Osc 1 self
								)
							else
								(gEgo
									view: 8131
									loop: 1
									cel: 0
									x: 203
									y: 86
									setCycle: Osc 1 self
								)
							)
						)
						((== gValOrRoz -3) ; Roz
							(gEgo
								view: 8495
								loop: 0
								cel: 0
								setCycle: Osc 1 self
							)
						)
						(else
							(gEgo
								view: 8133
								loop: 0
								cel: 0
								setCycle: Osc 1 self
							)
						)
					)
				)
				(3
					(if (or (IsFlag 106) (OneOf gPrevRoomNum 3300 3050))
						(if
							(or
								(== (gEgo view:) 8131)
								(== (gEgo view:) 8494)
							)
							(gEgo posn: 198 86)
						)
						(gEgo setScaler: Scaler 83 28 128 69 normalize: 5)
					else
						(gEgo setScaler: Scaler 83 28 128 69 normalize: 6)
					)
					(++ local0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(if (or (IsFlag 106) (OneOf gPrevRoomNum 3300 3050))
						(gEgo
							setCycle: 0
							setScaler: Scaler 83 28 128 69
							normalize: 5
						)
					else
						(gEgo
							setCycle: 0
							posn: 150 130
							setScaler: Scaler 83 28 128 69
							normalize: 6
						)
					)
					(++ local0)
					(ClearFlag 539)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sToe of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= cycles 1)
				)
				(1
					(if (or (IsFlag 106) (OneOf gPrevRoomNum 3300 3050))
						(if (== gValOrRoz -3) ; Roz
							(Load rsVIEW 3262)
						else
							(Load rsVIEW 8021)
						)
						(gEgo setHeading: 225 self)
					else
						(if (== gValOrRoz -3) ; Roz
							(Load rsVIEW 8383)
						else
							(Load rsVIEW 3251)
						)
						(gEgo setHeading: 45 self)
					)
				)
				(2
					(cond
						((or (IsFlag 106) (OneOf gPrevRoomNum 3300 3050))
							(= cycles 1)
						)
						((== gValOrRoz -3) ; Roz
							(gEgo setMotion: MoveTo 159 118 self)
						)
						(else
							(= cycles 1)
						)
					)
				)
				(3
					(cond
						((or (IsFlag 106) (OneOf gPrevRoomNum 3300 3050))
							(if (== gValOrRoz -3) ; Roz
								(gEgo cel: 7 view: 8381)
							else
								(gEgo cel: 5 view: 8021)
							)
							(gEgo loop: 1 posn: 188 86 setCycle: Osc 1 self)
						)
						((== gValOrRoz -3) ; Roz
							(gEgo
								view: 8383
								loop: 0
								cel: 7
								posn: 156 114
								setCycle: Osc 1 self
							)
						)
						(else
							(gEgo
								view: 3251
								loop: 2
								cel: 0
								posn: 169 138
								setScale: 0
								setCycle: Osc 1 self
							)
						)
					)
				)
				(4
					(cond
						((or (IsFlag 106) (OneOf gPrevRoomNum 3300 3050))
							(gEgo
								posn: 198 86
								setScaler: Scaler 83 28 128 69
								normalize: 5
							)
							(= cycles 1)
						)
						((== gValOrRoz -3) ; Roz
							(gEgo
								normalize: 6
								posn: 159 118
								setScaler: Scaler 83 28 128 69
								setMotion: MoveTo 150 130 self
							)
						)
						(else
							(gEgo
								posn: 146 129
								setScaler: Scaler 83 28 128 69
								normalize: 6
							)
							(= cycles 1)
						)
					)
				)
				(5
					(++ local0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(++ local0)
					(if (or (IsFlag 106) (OneOf gPrevRoomNum 3300 3050))
						(gEgo
							setCycle: 0
							posn: 206 88
							setScaler: Scaler 83 28 128 69
							normalize: 5
						)
					else
						(gEgo
							setCycle: 0
							posn: 150 130
							setScaler: Scaler 83 28 128 69
							normalize: 6
						)
					)
					(ClearFlag 539)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance drownDeath of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= cycles 1)
				)
				(1
					(cond
						(
							(or
								(IsFlag 106)
								(OneOf gPrevRoomNum 3100 3300 3050)
							)
							(= cycles 1)
						)
						((== gValOrRoz -3) ; Roz
							(gEgo setMotion: MoveTo 159 118 self)
						)
						(else
							(= cycles 1)
						)
					)
				)
				(2
					(= local1 0)
					(if (IsFlag 102)
						(Load rsSOUND 811)
					else
						(Load rsSOUND 3252)
					)
					(if (or (IsFlag 106) (OneOf gPrevRoomNum 3300 3050))
						(if (== gValOrRoz -3) ; Roz
							(if (IsFlag 102)
								(Load rsVIEW 3262)
							else
								(Load rsVIEW 8381)
							)
						else
							(Load rsVIEW 3263)
						)
						(gEgo setHeading: 225 self)
					else
						(if (== gValOrRoz -3) ; Roz
							(Load rsVIEW 8383)
						else
							(Load rsVIEW 3251)
						)
						(gEgo setHeading: 45 self)
					)
				)
				(3
					(if (not (IsFlag 102))
						(drownSound number: 3252 loop: 1 play:)
					)
					(gKqMusic1 stop:)
					(cond
						((or (IsFlag 106) (OneOf gPrevRoomNum 3300 3050))
							(cond
								((== gValOrRoz -3) ; Roz
									(if (IsFlag 102)
										(gEgo
											view: 3262
											cel: 0
											loop: 0
											setCycle: End self
										)
									else
										(gEgo
											cel: 7
											view: 8381
											loop: 1
											posn: 188 86
											setCycle: Beg self
										)
									)
								)
								((IsFlag 102)
									(gEgo
										view: 3263
										posn: 196 88
										setScale: 0
										loop: 0
										cel: 0
										setCycle: End self
									)
								)
								(else
									(gEgo
										view: 3263
										posn: 196 88
										loop: 0
										setScale: 0
										cel: 0
										setCycle: CT 18 1 self
									)
								)
							)
						)
						((== gValOrRoz -3) ; Roz
							(if (IsFlag 102)
								(gEgo
									view: 3262
									cel: 0
									loop: 2
									setScale: 0
									setCycle: End self
								)
								(gKqSound1 number: 907 loop: 1 play:)
							else
								(gEgo
									view: 8383
									loop: 0
									cel: 7
									posn: 156 114
									setCycle: Osc 1 self
								)
							)
						)
						(else
							(gEgo
								view: 3251
								setScale: 0
								loop: 2
								cel: 0
								posn: 169 139
								setCycle: End self
							)
						)
					)
				)
				(4
					(if
						(and
							(or (IsFlag 106) (OneOf gPrevRoomNum 3300 3050))
							(== gValOrRoz -3) ; Roz
						)
						(gEgo
							cel: 0
							view: 8381
							loop: 1
							posn: 188 86
							setCycle: End self
						)
					else
						(gEgo priority: 40 fixPriority: 1)
						(= cycles 1)
					)
				)
				(5
					(if (IsFlag 102)
						(drownSound number: 811 loop: -1 play:)
						(cond
							(
								(or
									(IsFlag 106)
									(OneOf gPrevRoomNum 3300 3050)
								)
								(self cue:)
							)
							((== gValOrRoz -3) ; Roz
								(= cycles 1)
							)
							(else
								(gEgo
									view: 3251
									setScale: 0
									loop: 3
									cel: 0
									posn: 169 139
									setCycle: End self
								)
							)
						)
					else
						(if (and (not (IsFlag 106)) (not (== gValOrRoz -3))) ; Roz
							(drownSound number: 902 loop: 1 play:)
						else
							(gKqMusic1 play:)
						)
						(cond
							(
								(or
									(IsFlag 106)
									(OneOf gPrevRoomNum 3300 3050)
								)
								(if (== gValOrRoz -3) ; Roz
									(gEgo
										normalize: 5
										posn: 198 86
										setScaler: Scaler 83 28 128 69
									)
									(gMessager say: 7 8 6 1 self) ; "I don't think so! I'm not silly enough to slog through that. Besides, Mother always told me not to play in the mud."
								else
									(gEgo
										view: 3263
										posn: 196 96
										loop: 0
										cel: 18
										setScale: 0
										setCycle: End self
									)
								)
							)
							((== gValOrRoz -3) ; Roz
								(gEgo
									normalize: 6
									posn: 159 118
									setScaler: Scaler 83 28 128 69
								)
								(gMessager say: 7 8 6 1 self) ; "I don't think so! I'm not silly enough to slog through that. Besides, Mother always told me not to play in the mud."
							)
							(else
								(gEgo
									view: 3251
									setScale: 0
									loop: 1
									cel: 0
									x: 168
									y: 139
									setCycle: End self
								)
							)
						)
					)
				)
				(6
					(Load rsSOUND 902)
					(= cycles 2)
				)
				(7
					(cond
						((IsFlag 102)
							(cond
								(
									(or
										(IsFlag 106)
										(OneOf gPrevRoomNum 3300 3050)
									)
									(= cycles 1)
								)
								((== gValOrRoz -3) ; Roz
									(= cycles 1)
								)
								(else
									(gEgo
										view: 3251
										loop: 4
										cel: 0
										x: 171
										y: 139
										priority: 35
										fixPriority: 1
										setScale: 0
										setCycle: End self
									)
								)
							)
						)
						((== gValOrRoz -3) ; Roz
							(if
								(or
									(IsFlag 106)
									(OneOf gPrevRoomNum 3300 3050)
								)
								(self cue:)
							else
								(gEgo
									normalize: 6
									posn: 159 118
									setScaler: Scaler 83 28 128 69
									setMotion: MoveTo 150 130 self
								)
							)
						)
						(else
							(= cycles 1)
						)
					)
				)
				(8
					(= local1 3)
					(drownSound stop:)
					(cond
						((== gValOrRoz -3) ; Roz
							(if (IsFlag 102)
								(EgoDead 69 self)
							else
								0
								(= cycles 1)
							)
						)
						((IsFlag 102)
							(gEgo setPri: -1)
							(EgoDead 24 self)
						)
						(else
							(EgoDead 25 self)
						)
					)
				)
				(9
					(if (IsFlag 103)
						(gKqSound1 number: 894 loop: -1 play:)
					)
					(if (and (not (IsFlag 106)) (not (== gValOrRoz -3))) ; Roz
						(gKqMusic1 play:)
					)
					(= local1 4)
					(cond
						((or (IsFlag 106) (OneOf gPrevRoomNum 3300 3050))
							(if (== gValOrRoz -3) ; Roz
								(gEgo
									normalize: 5
									posn: 198 86
									setScaler: Scaler 83 28 128 69
								)
							else
								(gEgo
									posn: 215 84
									setScaler: Scaler 83 28 128 69
									normalize: 5
								)
							)
						)
						((== gValOrRoz -3) ; Roz
							(gEgo
								posn: 150 130
								setScaler: Scaler 83 28 128 69
								normalize: 6
							)
						)
						(else
							(gEgo
								posn: 150 130
								setScaler: Scaler 83 28 128 69
								normalize: 6
							)
						)
					)
					(ClearFlag 5)
					(if (not (== gValOrRoz -3)) ; Roz
						(= local0 0)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gKqMusic1 play:)
					(if (or (IsFlag 106) (OneOf gPrevRoomNum 3300 3050))
						(gEgo
							setCycle: 0
							posn: 215 84
							setScaler: Scaler 83 28 128 69
							normalize: 5
						)
					else
						(gEgo
							setCycle: 0
							posn: 47 113
							setScaler: Scaler 83 28 128 69
							normalize: 2
						)
					)
					(ClearFlag 539)
					(if (not (== gValOrRoz -3)) ; Roz
						(= local0 0)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sSmell of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 8152
						loop: 0
						cel: 0
						x: 30
						y: 110
						setCycle: Osc 1 self
					)
				)
				(1
					(gEgo setScaler: Scaler 83 28 128 69 normalize: 2)
					(= cycles 1)
				)
				(2
					(SetFlag 129)
					((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
					(gMessager say: 1 8 1 0 self) ; "(THINKS TO HERSELF)Mmm! Those flowers smell heavenly!"
				)
				(3
					((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
					(gEgo setHeading: 180 self)
				)
				(4
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(if (not (IsFlag 129))
						(SetFlag 129)
					)
					(gEgo
						y: 110
						loop: 2
						setScaler: Scaler 83 28 128 69
						normalize: 2
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sBirdComes of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (bird1 script:)
			(if (>= ((bird1 script:) state:) 2)
				0
			else
				((bird1 script:) dispose:)
			)
		)
		(return
			(and
				(drippy script:)
				(if (>= ((drippy script:) state:) 2)
					0
				else
					((drippy script:) dispose:)
				)
			)
		)
	)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(SetFlag 131)
					(Load rsSOUND 3254)
					(Load rsVIEW 8132)
					(Load rsVIEW 3254)
					(gEgo setHeading: 180 self)
				)
				(1
					(= local1 1)
					(gKqMusic1 mute: 1)
					(birdSound number: 3254 loop: -1 play:)
					(gEgo
						view: 8132
						posn: 31 115
						loop: 0
						cel: 0
						setCycle: Osc 3
					)
					(bird
						view: 3254
						loop: 0
						cel: 0
						posn: 117 104
						init:
						setCycle: CT 26 1 self
					)
				)
				(2
					(bird
						view: 3253
						posn: 15 5
						loop: 9
						cel: 0
						setCycle: End self
					)
				)
				(3
					(bird view: 3253 loop: 11 cel: 0 posn: 15 5 setCycle: Fwd)
					(= cycles 5)
				)
				(4
					(= local1 3)
					(gEgo
						view: 8152
						loop: 0
						cel: 0
						posn: 37 112
						setCycle: End self
					)
				)
				(5
					(Load rsVIEW 3253)
					((ScriptID 13 0) view: 8152) ; aEgoTalker
					(gMessager say: 1 8 2 0 self) ; "(PLEASED TO SEE VALANICE)Hello, kindest of humans. Do you desire some sacred nectar?"
				)
				(6
					(gEgo setCycle: Beg self)
				)
				(7
					(gEgo posn: 37 113 normalize: 2 setHeading: 180 self)
				)
				(8
					((ScriptID 13 0) view: -1 mouth_x: -999 mouth_y: -999) ; aEgoTalker
					(if (not (IsFlag 270))
						(gEgo setHotspot: 0 12) ; Clay_Pot
					else
						(gEgo setHotspot: 0 12) ; Clay_Pot
					)
					(aFlower
						approachVerbs: 8 10 12 27 28 ; Do, Exit, Clay_Pot, Salt_Water, Fresh_Water
						setHotspot: 8 10 12 27 28 ; Do, Exit, Clay_Pot, Salt_Water, Fresh_Water
					)
					(nectarFlowers
						approachVerbs: 8 10 12 27 28 ; Do, Exit, Clay_Pot, Salt_Water, Fresh_Water
						setHotspot: 8 10 12 27 28 ; Do, Exit, Clay_Pot, Salt_Water, Fresh_Water
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(SetFlag 131)
					(if (not (IsFlag 270))
						(gEgo setHotspot: 0 12) ; Clay_Pot
					else
						(gEgo setHotspot: 0 12) ; Clay_Pot
					)
					(aFlower
						approachVerbs: 8 10 12 27 28 ; Do, Exit, Clay_Pot, Salt_Water, Fresh_Water
						setHotspot: 8 10 12 27 28 ; Do, Exit, Clay_Pot, Salt_Water, Fresh_Water
					)
					(nectarFlowers
						approachVerbs: 8 10 12 27 28 ; Do, Exit, Clay_Pot, Salt_Water, Fresh_Water
						setHotspot: 8 10 12 27 28 ; Do, Exit, Clay_Pot, Salt_Water, Fresh_Water
					)
					(gEgo posn: 37 113 normalize: 2 setHeading: 180 self)
				)
				(1
					(bird
						view: 3253
						setLoop: 11 1
						cel: 0
						posn: 15 5
						setMotion: 0
						setCycle: Fwd
					)
					(ClearFlag 539)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sQuestion of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setHeading: 180 self)
				)
				(1
					(gEgo
						view: 8152
						loop: 0
						cel: 0
						posn: 37 112
						setCycle: End self
					)
				)
				(2
					((ScriptID 13 0) view: 8152) ; aEgoTalker
					(gMessager say: 1 8 2 0 self) ; "(PLEASED TO SEE VALANICE)Hello, kindest of humans. Do you desire some sacred nectar?"
				)
				(3
					(gEgo setCycle: Beg self)
				)
				(4
					(gEgo posn: 37 113 normalize: 2 setHeading: 180 self)
					((ScriptID 13 0) view: -1 mouth_x: -999 mouth_y: -999) ; aEgoTalker
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gEgo normalize: 2)
					(ClearFlag 539)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sPourOut of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gMessager say: 1 12 5 0 self) ; "Oh, the pot is full of water. Let me dump it out first."
				)
				(1
					(gEgo posn: 37 113 normalize: 2 setHeading: 180 self)
					((ScriptID 13 0) view: -1 mouth_x: -999 mouth_y: -999) ; aEgoTalker
				)
				(2
					(if (gEgo has: 15) ; Salt_Water
						(gEgo put: 15) ; Salt_Water
						(gEgo view: 9193)
					)
					(if (gEgo has: 16) ; Fresh_Water
						(gEgo put: 16) ; Fresh_Water
						(gEgo view: 9192)
					)
					(gEgo loop: 0 cel: 0 posn: 37 117 setCycle: End self)
				)
				(3
					(gEgo posn: 26 118 normalize: 2)
					(= cycles 2)
				)
				(4
					(gCurRoom setScript: getNectar)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo posn: 31 117 normalize: 2)
					(gCurRoom setScript: getNectar)
				)
			)
		)
	)
)

(instance getNectar of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(SetFlag 130)
					(ClearFlag 131)
					(aFlower setHotspot: 0)
					(nectarFlowers dispose:)
					(gEgo loop: 3)
					(= cycles 2)
				)
				(1
					(gEgo
						view: 3253
						loop: 4
						cel: 0
						posn: 34 111
						ignoreActors: 1
						setScale: 0
						setCycle: End self
					)
				)
				(2
					(gEgo view: 3253 loop: 5 posn: 32 105 cel: 0 setScale: 0)
					(= cycles 2)
				)
				(3
					(gMessager say: 3 12 3 1 self) ; "Good! Hold it directly below the flowers, my lady."
				)
				(4
					(bird
						setLoop: 11 1
						moveSpeed: 6
						ignoreActors: 1
						setMotion: MoveTo 25 47 self
					)
				)
				(5
					(aFlower
						view: 3253
						setCel: 0
						setLoop: 7 1
						setPri: 102
						ignoreActors: 1
						setCycle: End self
					)
					(gEgo get: 40) ; Nectar_in_Pot
					(gEgo put: 2) ; Clay_Pot
					(gEgo hide:)
				)
				(6
					(aFlower setCycle: 0 loop: 6 setCel: 0)
					(gEgo
						show:
						view: 3253
						loop: 4
						cel: 6
						posn: 36 110
						setScale: 0
						setCycle: CT 2 -1 self
					)
				)
				(7
					(Load rsSOUND 3255)
					(gEgo
						setCycle: 0
						setPri: -1
						setScaler: Scaler 83 28 128 69
						posn: 33 109
						normalize: 3
					)
					(= cycles 1)
				)
				(8
					((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
					(gMessager say: 3 12 3 2 self) ; "Thank you!"
				)
				(9
					((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
					(= local1 8)
					(birdSound number: 3255 loop: 1 play:)
					(bird
						moveSpeed: 6
						posn: 25 38
						ignoreActors: 1
						setMotion: MoveTo 45 0 self
					)
				)
				(10
					(= local1 9)
					(bird dispose:)
					(birdSound stop:)
					(gKqMusic1 mute: 0)
					(gEgo setHeading: 180 self)
				)
				(11
					(bird1 setScript: sBirds)
					(SetFlag 130)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(birdSound stop:)
					(gKqMusic1 mute: 0)
					(if (not (gEgo has: 40)) ; Nectar_in_Pot
						(gEgo get: 40) ; Nectar_in_Pot
					)
					(if (gEgo has: 2) ; Clay_Pot
						(gEgo put: 2) ; Clay_Pot
					)
					(ClearFlag 539)
					(gEgo
						show:
						setCycle: 0
						setScaler: Scaler 83 28 128 69
						normalize: 2
					)
					(aFlower setCycle: 0 loop: 6 setCel: 0)
					(SetFlag 130)
					(if (gCast contains: bird)
						(bird dispose:)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance putNectarInMaiden of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (bird1 script:)
			(if (>= ((bird1 script:) state:) 2)
				0
			else
				((bird1 script:) dispose:)
			)
		)
		(return
			(and
				(drippy script:)
				(if (>= ((drippy script:) state:) 2)
					0
				else
					((drippy script:) dispose:)
				)
			)
		)
	)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(gEgo setHeading: 15 self)
				)
				(1
					(Load rsSOUND 3260)
					(= cycles 6)
				)
				(2
					(gEgo setMotion: MoveTo 93 121 self)
				)
				(3
					(Load rsVIEW 3257)
					(Load rsVIEW 8132)
					(= cycles 6)
				)
				(4
					(gEgo
						view: 3257
						loop: 0
						cel: 0
						posn: 88 107
						setPri: 139
						setScale: 0
						setCycle: End self
					)
				)
				(5
					(Load rsSOUND 893)
					(Load rsSOUND 836)
					(= cycles 6)
				)
				(6
					(gEgo
						loop: 1
						cel: 0
						posn: 109 81
						put: 40 ; Nectar_in_Pot
						get: 2 ; Clay_Pot
						setCycle: CT 10 1 self
					)
				)
				(7
					(gEgo cel: 10 setCycle: End self)
					(nectarSound number: 893 loop: 1 play:)
				)
				(8
					(gEgo
						posn: 130 127
						setScaler: Scaler 83 28 128 69
						normalize: 2
					)
					(= cycles 2)
				)
				(9
					(gEgo setHeading: 45 loop: 6)
					(gKqSound1 number: 836 loop: 1 play:)
					(riverProp
						view: 3257
						loop: 2
						cel: 0
						posn: 151 92
						init:
						setHotspot: 8 10 ; Do, Exit
						approachVerbs: 8 ; Do
						setCycle: End self
					)
				)
				(10
					(Load rsSOUND 894)
					(Load rsVIEW 33257)
					(= cycles 6)
				)
				(11
					(Load rsVIEW 3259)
					(SetFlag 102)
					(SetFlag 103)
					(myNorthExit init:)
					(myNorthWestExit init:)
					(= cycles 1)
				)
				(12
					(Load 140 894) ; WAVE
					(riverProp
						view: 3257
						loop: 3
						cel: 3
						posn: 152 82
						setPri: 36
						setCycle: Beg self
					)
					(gKqSound1 number: 894 loop: -1 play:)
				)
				(13
					(riverProp
						view: 33257
						loop: 3
						cel: 0
						setPri: 36
						setCycle: Fwd
					)
					(riverPropSouth
						view: 3257
						loop: 7
						cel: 0
						setPri: 35
						posn: 226 133
						init:
						setCycle: CT 4 1 self
					)
				)
				(14
					(riverPropSouth cel: 4 setCycle: End)
					(riverPropNorth
						view: 3257
						loop: 4
						cel: 0
						setPri: 35
						posn: 81 94
						init:
						setCycle: End self
					)
				)
				(15
					(riverPropSouth
						view: 33257
						loop: 1
						cel: 0
						posn: 227 133
						setCycle: Fwd
					)
					(riverPropNorth
						loop: 5
						cel: 0
						posn: 56 95
						setCycle: End self
					)
				)
				(16
					(riverPropNorth
						view: 33257
						loop: 0
						cel: 0
						posn: 56 95
						setCycle: Fwd
					)
					(fannySound number: 3256 loop: 1 play:)
					(rainbowBridge
						view: 3257
						loop: 9
						cel: 0
						init:
						setCycle: End self
					)
				)
				(17
					(= seconds 5)
				)
				(18
					(stag init: setPri: 80 posn: 302 80)
					(= local7 (stag cycleSpeed:))
					(= cycles 1)
				)
				(19
					(stag cel: 0 loop: 0 cycleSpeed: 12 setCycle: CT 4 1 self)
				)
				(20
					(Narrator modeless: 1)
					(gMessager say: 4 54 0 1 self) ; "(HAPPY)Come, Lord Attis. Perhaps a drink from the River of Life will give you strength."
				)
				(21
					(stag cel: 4 loop: 0 cycleSpeed: 12 setCycle: End self)
				)
				(22
					(stag
						loop: 1
						cel: 0
						posn: 204 87
						cycleSpeed: local7
						setCycle: End self
					)
				)
				(23
					(stag loop: 2 cel: 0 posn: 208 84 setCycle: End self)
				)
				(24
					(Load rsSOUND 3261)
					(Load rsSOUND 3212)
					(= cycles 6)
				)
				(25
					(SetFlag 104)
					(nectarSound number: 3261 loop: 1 play:)
					(fannySound number: 3212 loop: 1 play:)
					(stag loop: 3 cel: 0 posn: 211 87 setCycle: End self)
				)
				(26
					(nectarSound stop:)
					(gMessager sayRange: 4 54 0 2 3 self) ; "(SURPRISED AND DELIGHTED)The enchantment has been broken!"
				)
				(27
					(Narrator modeless: 0)
					(stag loop: 4 cel: 0 posn: 176 85 setCycle: End self)
				)
				(28
					(stag loop: 5 cel: 0 posn: 176 85 setCycle: End self)
				)
				(29
					(gEgo setMotion: MoveTo 120 127 self)
				)
				(30
					(gEgo setMotion: PolyPath 10 100 self)
				)
				(31
					(gCurRoom newRoom: 3200)
				)
			)
		else
			(switch (= state newState)
				(0
					(= cycles 6)
				)
				(1
					(if (gEgo has: 40) ; Nectar_in_Pot
						(gEgo put: 40 get: 2) ; Nectar_in_Pot, Clay_Pot
					)
					(ClearFlag 539)
					(SetFlag 102)
					(SetFlag 103)
					(SetFlag 104)
					(gCurRoom newRoom: 3200)
				)
			)
		)
	)
)

(instance sSneezed of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load rsSOUND 852)
					(= cycles 3)
				)
				(1
					(nectarSound number: 852 loop: 1 play: self)
					(Load rsSOUND 864)
				)
				(2
					(fannySound number: 865 loop: 1 play:)
					(gEgo show: setCycle: End self)
				)
				(3
					(gEgo
						loop: 3
						posn: 156 133
						setScaler: Scaler 83 28 128 69
						normalize: 3
					)
					(= cycles 2)
				)
				(4
					(gEgo setHeading: 180 self)
				)
				(5
					(ClearFlag 106)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo
						loop: 2
						posn: 156 133
						setScaler: Scaler 83 28 128 69
						normalize: 2
					)
					(ClearFlag 106)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sUp of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not local8)
						(gEgo loop: 0)
					else
						(gEgo loop: 1)
					)
					(gEgo view: 8495 cel: 0 setCycle: End self)
				)
				(1
					(if (not local8)
						(gEgo normalize: 6)
					else
						(gEgo normalize: 5)
					)
					(= cycles 6)
				)
				(2
					(if (not local8)
						(gEgo setHeading: 45 self)
					else
						(gEgo setHeading: 225 self)
					)
				)
				(3
					(gGame handsOn:)
					(= local8 0)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo normalize: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sAmbrosia of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cornucopiaMaiden dispose:)
				(Load rsVIEW 8101)
				(Load rsSOUND 834)
				(gEgo setHeading: 80 self)
			)
			(1
				(gEgo view: 8101 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gKqMusic1 stop:)
				(nectarSound number: 834 loop: 1 play: self)
				(Load rsSOUND 3263)
			)
			(3
				(nectarSound number: 3263 loop: 1 play:)
				(pom setCel: 2 loop: 0 init: setCycle: End self)
				(SetFlag 225)
			)
			(4
				(gKqMusic1 play:)
				(gEgo setCycle: Beg self)
			)
			(5
				(cornMaiden init:)
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLookInside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 8131)
				(gEgo setHeading: 80 self)
			)
			(1
				(gEgo
					view: 8131
					loop: 0
					cel: 0
					posn: 144 80
					setCycle: Osc 1 self
				)
			)
			(2
				(gEgo posn: 148 80 normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveCorn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 3250)
				(Load rsSOUND 834)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gEgo setHeading: 80 self)
			)
			(1
				(gMessager say: 6 30 0 1 self) ; "I wonder if this corn will work with the cornucopia."
			)
			(2
				(gEgo view: 3250 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(gKqMusic1 stop:)
				(nectarSound number: 834 loop: 1 play: self)
				(Load rsVIEW 8111)
			)
			(4
				(gKqMusic1 play:)
				(gEgo put: 19) ; Ear_of_Corn
				(= cycles 1)
			)
			(5
				(gEgo view: 8111 loop: 0 cel: 5 setCycle: Beg self)
			)
			(6
				(gMessager say: 6 30 0 2 self) ; "Ohh...I guess it wasn't sacred enough."
			)
			(7
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPomegranate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 8101)
				(gEgo setHeading: 80 self)
			)
			(1
				(gEgo view: 8101 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gEgo get: 66) ; Pomegranate
				(= cycles 1)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bird1 of Actor
	(properties
		noun 3
		view 33253
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 103))
			(self setScript: sBirds)
		)
	)
)

(instance bird2 of Actor
	(properties
		noun 3
		view 33253
	)
)

(instance bird of Actor
	(properties
		noun 3
		approachX 31
		approachY 115
		x 117
		y 104
		view 3254
	)

	(method (init)
		(super init:)
		(self approachVerbs: 8 10 12 27 28 setHotspot: 8 10 12 27 28) ; Do, Exit, Clay_Pot, Salt_Water, Fresh_Water, Do, Exit, Clay_Pot, Salt_Water, Fresh_Water
		(SetFlag 131)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: sQuestion)
			)
			(12 ; Clay_Pot
				(cond
					((gEgo has: 16) ; Fresh_Water
						(Load rsVIEW 3250)
						(gCurRoom setScript: sPourOut)
					)
					((gEgo has: 15) ; Salt_Water
						(Load rsVIEW 3250)
						(gCurRoom setScript: sPourOut)
					)
					(else
						(Load rsVIEW 3253)
						(gCurRoom setScript: getNectar)
					)
				)
			)
			(27 ; Salt_Water
				(Load rsVIEW 3250)
				(gCurRoom setScript: sPourOut)
			)
			(28 ; Fresh_Water
				(Load rsVIEW 3250)
				(gCurRoom setScript: sPourOut)
			)
		)
	)

	(method (dispose)
		(ClearFlag 131)
		(super dispose:)
	)
)

(instance aFlower of Prop
	(properties
		noun 1
		sightAngle 40
		approachX 31
		approachY 115
		x 32
		y 127
		z 20
		priority 90
		fixPriority 1
		view 3253
		loop 6
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 33 8 37 15 46 22 34 28 26 36 19 24 6 11 1 0 5
					yourself:
				)
		)
		(if
			(and
				(not (IsFlag 130))
				(not (OneOf gPrevRoomNum 3100 3300 3050))
				(== gValOrRoz -4) ; Val
				(!= gValOrRoz -3) ; Roz
			)
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
		(if
			(and
				(not (IsFlag 130))
				(== gPrevRoomNum 3100)
				(== gValOrRoz -4) ; Val
				(IsFlag 146)
				(!= gValOrRoz -3) ; Roz
				(!= gChapter 4)
			)
			(nectarFlowers init:)
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					(
						(and
							(not (IsFlag 131))
							(IsFlag 100)
							(not (IsFlag 130))
						)
						(Load rsVIEW 3054)
						(gCurRoom setScript: sBirdComes)
					)
					((and (IsFlag 131) (IsFlag 100) (not (IsFlag 130)))
						(gCurRoom setScript: sQuestion)
					)
					(else
						(Load rsVIEW 3253)
						(gCurRoom setScript: sSmell)
					)
				)
			)
			(12 ; Clay_Pot
				(cond
					(
						(and
							(not (IsFlag 131))
							(IsFlag 100)
							(not (IsFlag 130))
						)
						(Load rsVIEW 3054)
						(gCurRoom setScript: sBirdComes)
					)
					((gEgo has: 16) ; Fresh_Water
						(Load rsVIEW 3250)
						(gCurRoom setScript: sPourOut)
					)
					((gEgo has: 15) ; Salt_Water
						(Load rsVIEW 3250)
						(gCurRoom setScript: sPourOut)
					)
					(else
						(Load rsVIEW 3253)
						(gCurRoom setScript: getNectar)
					)
				)
			)
			(27 ; Salt_Water
				(if
					(and
						(not (IsFlag 131))
						(IsFlag 100)
						(not (IsFlag 130))
					)
					(Load rsVIEW 3054)
					(gCurRoom setScript: sBirdComes)
				else
					(Load rsVIEW 3250)
					(gCurRoom setScript: sPourOut)
				)
			)
			(28 ; Fresh_Water
				(if
					(and
						(not (IsFlag 131))
						(IsFlag 100)
						(not (IsFlag 130))
					)
					(Load rsVIEW 3054)
					(gCurRoom setScript: sBirdComes)
				else
					(Load rsVIEW 3250)
					(gCurRoom setScript: sPourOut)
				)
			)
		)
	)
)

(instance stag of Prop
	(properties
		x 316
		y 78
		view 3259
	)

	(method (init)
		(super init: &rest)
		((ScriptID 7000 0) ; attisTalker
			clientCel: 27
			loop: -1
			view: -1
			mouth_x: -999
			mouth_y: -999
			client: self
		)
	)
)

(instance riverProp of Prop
	(properties
		approachX 150
		approachY 130
		x 152
		y 82
		view 3257
		loop 3
	)
)

(instance riverPropSouth of Prop
	(properties
		approachX 150
		approachY 130
		x 227
		y 133
		view 3257
		loop 8
	)
)

(instance riverPropNorth of Prop
	(properties
		approachX 150
		approachY 130
		x 56
		y 94
		view 3257
		loop 6
	)
)

(instance rainbowBridge of Prop
	(properties
		sightAngle 40
		approachX 150
		approachY 130
		x 214
		y 86
		view 3257
		loop 9
	)

	(method (doit)
		(cond
			(
				(and
					(IsFlag 106)
					(> (gEgo y:) 90)
					(== (myRiverExit exitDir:) 8)
				)
				(ClearFlag 106)
				(myRiverExit x: 209 y: 130 approachX: 277 approachY: 79)
				(myRiverExit exitDir: 6)
			)
			(
				(and
					(not (IsFlag 106))
					(< (gEgo y:) 90)
					(== (myRiverExit exitDir:) 6)
				)
				(myRiverExit x: 277 y: 78 approachX: 218 approachY: 127)
				(SetFlag 106)
				(myRiverExit exitDir: 8)
			)
		)
		(super doit:)
	)
)

(instance pom of Prop
	(properties
		sightAngle 40
		approachX 148
		approachY 80
		x 156
		y 57
		view 3264
		cel 2
	)
)

(instance drippy of Prop
	(properties
		x 25
		y 25
		view 3252
	)
)

(instance river of Feature
	(properties
		approachX 150
		approachY 130
		x 160
		y 120
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 10 ; Do, Exit
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 25 67 25 77 38 83 68 87 85 93 89 76 75 73 58 74 47 71 40 69
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 152 83 151 95 149 99 143 97 138 102 144 111 171 114 191 116 193 100 205 91 185 89 168 86 156 85
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 280 93 257 112 245 125 276 130 300 118 319 111 319 87
					yourself:
				)
		)
		(if (and (IsFlag 106) (not (IsFlag 103)))
			(self approachX: 198 approachY: 86)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (and (== gValOrRoz -3) (not (IsFlag 103))) ; Roz
					(= local0 2)
				)
				(Load rsVIEW 3251)
				(cond
					((== local0 2)
						(gCurRoom setScript: drownDeath)
					)
					((== local0 1)
						(if (IsFlag 102)
							(gCurRoom setScript: drownDeath)
						else
							(gCurRoom setScript: sToe)
						)
					)
					((IsFlag 102)
						(gCurRoom setScript: sToe)
					)
					(else
						(gCurRoom setScript: lookAtRiver)
					)
				)
			)
		)
	)
)

(instance brokenBridge of Feature
	(properties
		approachX 215
		approachY 128
		x 215
		y 120
	)

	(method (init)
		(super init:)
		(if (== gValOrRoz -4) ; Val
			(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 193 126 247 135 254 115 247 99 231 103 232 123 211 95 192 103
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (not (IsFlag 103))
					((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
					(gMessager say: 5 8 4 0) ; "(THINKS TO HERSELF)What could have happened to this little bridge?"
					(brokenBridge setHotspot: 0)
					((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				)
			)
		)
	)
)

(instance nectarFlowers of Feature
	(properties
		noun 1
		approachX 31
		approachY 115
		x 31
		y 130
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 29 2 47 21 34 47 15 48 9 37 0 34 0 0
					yourself:
				)
		)
		(if
			(and
				(not (IsFlag 130))
				(not (OneOf gPrevRoomNum 3100 3300 3050))
				(== gValOrRoz -4) ; Val
				(!= gValOrRoz -3) ; Roz
				(!= gChapter 4)
			)
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
		(if
			(and
				(not (IsFlag 130))
				(== gPrevRoomNum 3100)
				(== gValOrRoz -4) ; Val
				(IsFlag 146)
				(!= gValOrRoz -3) ; Roz
			)
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					(
						(and
							(not (IsFlag 131))
							(IsFlag 100)
							(not (IsFlag 130))
						)
						(Load rsVIEW 3054)
						(gCurRoom setScript: sBirdComes)
					)
					((and (IsFlag 131) (IsFlag 100) (not (IsFlag 130)))
						(gCurRoom setScript: sQuestion)
					)
					(else
						(Load rsVIEW 3253)
						(gCurRoom setScript: sSmell)
					)
				)
			)
			(12 ; Clay_Pot
				(cond
					(
						(and
							(not (IsFlag 131))
							(IsFlag 100)
							(not (IsFlag 130))
						)
						(Load rsVIEW 3054)
						(gCurRoom setScript: sBirdComes)
					)
					((gEgo has: 16) ; Fresh_Water
						(Load rsVIEW 3250)
						(gCurRoom setScript: sPourOut)
					)
					((gEgo has: 15) ; Salt_Water
						(Load rsVIEW 3250)
						(gCurRoom setScript: sPourOut)
					)
					(else
						(Load rsVIEW 3253)
						(gCurRoom setScript: getNectar)
					)
				)
			)
			(27 ; Salt_Water
				(if
					(and
						(not (IsFlag 131))
						(IsFlag 100)
						(not (IsFlag 130))
					)
					(Load rsVIEW 3054)
					(gCurRoom setScript: sBirdComes)
				else
					(Load rsVIEW 3250)
					(gCurRoom setScript: sPourOut)
				)
			)
			(28 ; Fresh_Water
				(if
					(and
						(not (IsFlag 131))
						(IsFlag 100)
						(not (IsFlag 130))
					)
					(Load rsVIEW 3054)
					(gCurRoom setScript: sBirdComes)
				else
					(Load rsVIEW 3250)
					(gCurRoom setScript: sPourOut)
				)
			)
		)
	)
)

(instance pitcherMaiden of Feature
	(properties
		noun 4
		approachX 86
		approachY 125
		x 86
		y 120
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 127 125 69 113 89 101 89 73 103 67 100 50 109 42 121 49 124 59 118 69 150 84 149 100 131 105 140 118
					yourself:
				)
		)
		(cond
			((and (IsFlag 106) (not (IsFlag 103)))
				(self approachVerbs: 8 10) ; Do, Exit
			)
			((IsFlag 136)
				(self setHotspot: 8 10 54 approachVerbs: 8 10 54) ; Do, Exit, Nectar_in_Pot, Do, Exit, Nectar_in_Pot
			)
			(else
				(self approachVerbs: 8 10) ; Do, Exit
			)
		)
		(if (or (== gPrevRoomNum 3100) (== gPrevRoomNum 3050) (IsFlag 106))
			(self approachX: 197 approachY: 86)
		else
			(self approachX: 86 approachY: 125)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (== gValOrRoz -3) ; Roz
					(self setHotspot: 0)
					(if (or (IsFlag 106) (IsFlag 103))
						(= local8 1)
					else
						(= local8 0)
					)
					(gCurRoom setScript: sUp)
				else
					((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
					(gMessager say: 4 8 4 0) ; "(THINKS TO HERSELF)These statues are so beautiful...incredible!"
					((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				)
			)
			(54 ; Nectar_in_Pot
				(Load rsVIEW 3257)
				(gCurRoom setScript: putNectarInMaiden)
			)
		)
	)
)

(instance cornucopiaMaiden of Feature
	(properties
		x 169
		y 80
	)

	(method (init)
		(super init:)
		(if
			(and
				(== gValOrRoz -4) ; Val
				(not (IsFlag 392))
				(IsFlag 136)
				(or
					(IsFlag 103)
					(== gPrevRoomNum 3100)
					(== gPrevRoomNum 3050)
					(IsFlag 106)
				)
			)
			(self
				setHotspot: 8 10 76 30 ; Do, Exit, Ambrosia, Ear_of_Corn
				approachVerbs: 8 10 76 30 ; Do, Exit, Ambrosia, Ear_of_Corn
				approachX: 148
				approachY: 80
			)
		else
			(self
				setHotspot: 8 10 ; Do, Exit
				approachVerbs: 8 10 ; Do, Exit
				approachX: 164
				approachY: 120
			)
		)
		(if (IsFlag 225)
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 148 50 148 66 160 66 160 50
						yourself:
					)
			)
		else
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 206 76 191 87 164 80 166 65 154 71 150 51 170 45 170 30 182 25
						yourself:
					)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((== gValOrRoz -3) ; Roz
						(self setHotspot: 0)
						(= local8 0)
						(gCurRoom setScript: sUp)
					)
					(
						(and
							(IsFlag 225)
							(or (not (gEgo has: 66)) (not (IsFlag 206))) ; Pomegranate
						)
						(self setHotspot: 0)
						(pom setHotspot: 0)
						(gCurRoom setScript: sPomegranate)
					)
					((gEgo has: 67) ; Ambrosia
						(gCurRoom setScript: sLookInside)
					)
					(else
						((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
						(gMessager say: 4 8 4 0) ; "(THINKS TO HERSELF)These statues are so beautiful...incredible!"
						((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
					)
				)
			)
			(76 ; Ambrosia
				(if (and (IsFlag 136) (not (IsFlag 392)))
					(self setHotspot: 0)
					(SetFlag 392)
					(gCurRoom setScript: sAmbrosia)
				else
					(gCurRoom setScript: sLookInside)
				)
			)
			(30 ; Ear_of_Corn
				(gCurRoom setScript: sGiveCorn)
			)
		)
	)
)

(instance cornMaiden of Feature
	(properties
		nsLeft 150
		nsTop 50
		nsRight 175
		nsBottom 66
		x 169
		y 80
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 30 ; Do, Exit, Ear_of_Corn
			approachVerbs: 8 10 30 ; Do, Exit, Ear_of_Corn
			approachX: 148
			approachY: 80
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((== gValOrRoz -3) ; Roz
						(self setHotspot: 0)
						(gCurRoom setScript: sUp)
					)
					(
						(and
							(IsFlag 225)
							(or (not (gEgo has: 66)) (not (IsFlag 206))) ; Pomegranate
						)
						(self setHotspot: 0)
						(pom setHotspot: 0)
						(gCurRoom setScript: sPomegranate)
					)
					((gEgo has: 67) ; Ambrosia
						(gCurRoom setScript: sLookInside)
					)
					(else
						((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
						(gMessager say: 4 8 4 0) ; "(THINKS TO HERSELF)These statues are so beautiful...incredible!"
						((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
					)
				)
			)
			(76 ; Ambrosia
				(if (and (IsFlag 136) (not (IsFlag 225)))
					(gCurRoom setScript: sAmbrosia)
				else
					(gCurRoom setScript: sLookInside)
				)
			)
			(30 ; Ear_of_Corn
				(gCurRoom setScript: sGiveCorn)
			)
		)
	)
)

(instance myWestExit of ExitFeature
	(properties
		nsTop 53
		nsRight 10
		nsBottom 124
		approachX 3
		approachY 100
		exitDir 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: sToOakTree)
		)
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)
)

(instance myNorthExit of ExitFeature
	(properties
		nsLeft 209
		nsRight 278
		nsBottom 65
		approachX 252
		approachY 71
		x 252
		y 60
		exitDir 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(if (== (gKqSound1 number:) 894)
				(gKqSound1 setLoop: 1 stop:)
			)
			(gCurRoom newRoom: 3100)
			(return 1)
		)
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)
)

(instance myNorthWestExit of ExitFeature
	(properties
		nsRight 58
		nsBottom 76
		approachX 29
		approachY 66
		exitDir 5
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom newRoom: 3050)
			(return 1)
		)
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)
)

(instance mySouthExit of ExitFeature
	(properties
		nsLeft 103
		nsTop 130
		nsRight 244
		nsBottom 135
		approachX 152
		approachY 142
		x 152
		y 160
		exitDir 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: sToColossus)
		)
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)
)

(instance myRiverExit of ExitFeature
	(properties
		approachX 271
		approachY 83
		exitDir 8
	)

	(method (doVerb))

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 8 10 ; Do, Exit
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 197 120 214 99 238 88 261 83 286 87 260 99 250 110 241 130
					yourself:
				)
		)
		(if (OneOf gPrevRoomNum 3100 3300 3050)
			(= approachX 218)
			(= approachY 127)
			(= exitDir 8)
		else
			(= approachX 271)
			(= approachY 83)
			(= exitDir 6)
		)
	)
)

(instance drownSound of Sound
	(properties)
)

(instance birdSound of Sound
	(properties)
)

(instance nectarSound of Sound
	(properties)
)

(instance fannySound of Sound
	(properties)
)

(instance waterSound of Sound ; UNUSED
	(properties)
)

