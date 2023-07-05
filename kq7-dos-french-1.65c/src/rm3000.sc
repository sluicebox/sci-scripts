;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3000)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm3000 0
)

(local
	local0
	local1 = 3
	local2
	local3
	local4
	[local5 44] = [0 0 0 0 0 0 0 0 0 0 0 0 8583 0 113 116 9 113 108 13 108 104 45 8585 0 108 104 8 123 96 12 155 97 45 8585 0 155 97 8 163 89 12 190 90]
	[local49 44] = [180 8592 0 108 104 5 109 115 9 102 118 225 8584 1 155 97 8 147 103 12 108 104 225 8584 1 189 91 8 192 96 12 155 97 0 0 1 0 0 0 0 0 0 0 0]
	[local93 44] = [180 8222 0 112 106 13 112 118 16 121 120 225 3007 1 158 99 9 142 105 11 112 106 225 3007 1 188 92 9 184 98 11 158 99 0 0 0 0 0 0 0 0 0 0 0]
	local137
	local138
)

(instance rm3000 of KQRoom
	(properties
		modNum 1100
		picture 3000
	)

	(method (init)
		(Load rsSOUND 3002)
		(super init:)
		(SetFlag 21)
		(if (>= gChapter 4)
			(SetFlag 55)
		)
		(= local2
			((Polygon new:)
				type: PContainedAccess
				init: 320 124 238 117 202 122 168 115 168 108 123 113 67 113 86 121 118 124 163 139 320 144
				yourself:
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 320 126 246 120 224 126 160 126 148 115 122 115 79 115 86 121 118 124 163 139 320 144
					yourself:
				)
				(if (not (IsFlag 102))
					((Polygon new:)
						type: PContainedAccess
						init: 228 71 320 71 320 65 228 65 199 66 201 70 219 74 205 82 189 82 178 92 194 94 209 88 221 88 236 89 249 83
						yourself:
					)
				else
					((Polygon new:)
						type: PContainedAccess
						init: 235 74 212 74 195 68 228 65 320 65 320 71 235 71
						yourself:
					)
				)
		)
		(gEgo init:)
		(if (== gValOrRoz -4) ; Val
			(Load rsSOUND 3003)
			(gEgo setScaler: Scaler 100 51 138 91)
		else
			(gEgo setScaler: Scaler 100 51 107 75)
		)
		(switch gChapter
			(3
				(if (not (IsFlag 100))
					(if (not (IsFlag 101))
						(spider init:)
					)
					(bird init: setCycle: Fwd)
					(web init:)
				)
			)
			(4
				(cond
					((not (IsFlag 102))
						(Load rsVIEW 8583)
						(Load rsVIEW 8585)
						(Load rsVIEW 8592)
						(Load rsVIEW 8584)
					)
					((IsFlag 106)
						(Load rsVIEW 3004)
						(Load rsVIEW 3005)
					)
					(else
						(Load rsVIEW 3003)
						(Load rsVIEW 3006)
					)
				)
			)
			(5 0)
		)
		(if (IsFlag 102)
			(Load 140 907) ; WAVE
			(waterFall init:)
			(water1 init:)
			(water2 init:)
		)
		(switch gPrevRoomNum
			(3150
				(gEgo normalize: 3 posn: 175 170)
				(= local1 0)
				(gCurRoom setScript: enterFromWoods)
			)
			(3300
				(SetFlag 106)
				(gEgo normalize: 2 posn: 228 82)
				(if (IsFlag 102)
					(gEgo y: 73)
				else
					(gCurRoom setScript: enterFromSpiderRoom)
				)
			)
			(else
				(gEgo posn: 178 127)
				(ClearFlag 106)
				(= local1 0)
				(gEgo normalize: 2)
			)
		)
		(river init:)
		(stone1 init:)
		(if (not (IsFlag 102))
			(stone2 init:)
			(stone3 init:)
		)
		(nExit init:)
		(farWoodsExit init:)
		(wereWoodsExit init:)
		(if (IsFlag 106)
			(gWalkHandler addToFront: gCurRoom)
		)
		(if (or (!= (gKqMusic1 number:) 3000) (not (gKqMusic1 handle:)))
			(gKqMusic1 number: 3000 loop: -1 play:)
		)
		(if (IsFlag 102)
			(waterSound number: 894 loop: -1 play:)
		)
		(if (not script)
			(gGame handsOn:)
		)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(cond
				((and (== local1 1) (local2 onMe: (event x:) (event y:)))
					(if (== gValOrRoz -3) ; Roz
						(self setScript: rosJumpSouth 0 0)
					else
						(self setScript: valJumpSouth 0 0)
					)
				)
				((local2 onMe: (event x:) (event y:)) 0)
				((and (stone3 onMe: event) (== local1 3))
					(gEgo setMotion: PolyPath (event x:) (event y:))
				)
				(else 0)
			)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
			(return)
		)
	)

	(method (newRoom newRoomNumber)
		(gWalkHandler delete: gCurRoom)
		(waterSound stop:)
		(local2 dispose:)
		(if (and (== newRoomNumber 3300) (not (IsFlag 101)))
			(gKqMusic1 fade:)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (cue)
		(stone2 doVerb: 8)
	)
)

(instance enterFromSpiderRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo
					setMotion:
						PolyPath
						(stone2 approachX:)
						(stone2 approachY:)
						self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance crossNorth of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gGame handsOff:)
		(switch (++ local1)
			(1
				(self changeState: 1)
			)
			(2
				(self changeState: 3)
			)
			(else
				(self changeState: 8)
			)
		)
	)

	(method (dispose)
		(if (== gNewRoomNum gCurRoomNum)
			(gGame handsOn:)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(= local1 1)
				(stone1 setApproach: 0 setup:)
				(stone2 setApproach: 0)
				(stone3 setApproach: 0)
				(wereWoodsExit setHotspot: 0)
				((ScriptID 19 0) setHotspot: 0) ; eastFeat
				(gWalkHandler addToFront: gCurRoom)
				(gEgo
					view: 3001
					loop: 0
					cel: 0
					posn: 112 115
					setScale: 0
					setCycle: End self
					disableHotspot:
				)
			)
			(2
				(gEgo
					normalize: 6
					setScaler: Scaler 100 51 138 91
					setPri: 115
					posn: 116 106
				)
				(self dispose:)
			)
			(3
				(stone1 setup:)
				(gEgo
					view: 3001
					loop: 1
					cel: 0
					setPri: 115
					setScale: 0
					posn: 159 100
					setCycle: CT 8 1 self
				)
			)
			(4
				(gKqSound1 number: 3002 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(5
				(gKqSound1 number: 3003 loop: 1 play:)
				(gEgo
					view: 3001
					loop: 2
					cel: 0
					posn: 158 101
					cycleSpeed: 7
					setCycle: End self
				)
			)
			(6
				(gEgo
					view: 3001
					loop: 3
					cel: 0
					posn: 157 98
					setCycle: End self
				)
			)
			(7
				(gEgo
					normalize: 6
					setScaler: Scaler 100 51 138 91
					setPri: 100
					posn: 160 99
				)
				(self dispose:)
			)
			(8
				(stone1 setup:)
				(gEgo
					view: 3001
					setScale: 0
					loop: 4
					cel: 0
					posn: 168 96
					setCycle: CT 8 1 self
				)
			)
			(9
				(gKqSound1 number: 3002 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(10
				(if (not (IsFlag 100))
					(gMessager say: 5 24 0 1 self 1100) ; "Oh...my..."
				else
					(= cycles 1)
				)
			)
			(11
				(gWalkHandler delete: gCurRoom)
				(gEgo
					posn: 206 88
					normalize: 6
					enableHotspot:
					setScaler: Scaler 100 51 138 91
					setMotion: MoveTo 225 74 self
				)
			)
			(12
				(SetFlag 106)
				(gCurRoom newRoom: 3300)
			)
		)
	)
)

(instance valJumpSouth of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= local1 register)
		(*= register 11)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(stone1 setApproach: 0)
				(stone2 setApproach: 0)
				(stone3 setApproach: 0)
				(nExit setHotspot: 0)
				(farWoodsExit setHotspot: 0)
				(wereWoodsExit setHotspot: 0)
				(ClearFlag 106)
				(if (== local1 2)
					(gEgo disableHotspot:)
				)
				(if (== local1 0)
					(gEgo enableHotspot:)
					(gWalkHandler delete: gCurRoom)
				else
					(gWalkHandler addToFront: gCurRoom)
				)
				(gEgo setPri: 130 setHeading: [local93 (+ register 0)] self)
			)
			(2
				(gEgo
					view: [local93 (+ register 1)]
					setLoop: [local93 (+ register 2)] 1
					cel: 0
					x: [local93 (+ register 3)]
					y: [local93 (+ register 4)]
					setCycle: CT [local93 (+ register 5)] 1 self
				)
			)
			(3
				(gEgo
					setCycle: CT [local93 (+ register 8)] 1 self
					setMotion:
						MoveTo
						[local93 (+ register 6)]
						[local93 (+ register 7)]
						self
				)
			)
			(4 0)
			(5
				(if (!= local1 0)
					(gKqSound1 number: 3002 loop: 1 play:)
				)
				(gEgo setCycle: End self)
			)
			(6
				(if (== local1 0)
					(gEgo normalize: 2)
				else
					(gEgo normalize: 5)
				)
				(gEgo
					setPri: 130
					x: [local93 (+ register 9)]
					y: [local93 (+ register 10)]
				)
				(stone1 setup:)
				(if (== local1 0)
					(gEgo setPri: -1)
					(stone1 setApproach:)
					(stone2 setApproach:)
					(stone3 setApproach:)
					(wereWoodsExit setHotspot: 8 10) ; Do, Exit
				)
				(if (not next)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance rosJumpNorth of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= local1 register)
		(*= register 11)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(stone1 setApproach: 0)
				(stone2 setApproach: 0)
				(stone3 setApproach: 0)
				(nExit setHotspot: 0)
				(farWoodsExit setHotspot: 0)
				(wereWoodsExit setHotspot: 0)
				(if (== local1 1)
					(gEgo disableHotspot:)
				)
				(if (== local1 3)
					(SetFlag 106)
					(gEgo enableHotspot:)
					(gWalkHandler delete: gCurRoom)
				else
					(ClearFlag 106)
					(gWalkHandler addToFront: gCurRoom)
				)
				(gEgo setPri: 130 setHeading: [local5 (+ register 0)] self)
			)
			(2
				(gEgo
					view: [local5 (+ register 1)]
					setLoop: [local5 (+ register 2)] 1
					cel: 0
					x: [local5 (+ register 3)]
					y: [local5 (+ register 4)]
					setCycle: CT [local5 (+ register 5)] 1 self
				)
			)
			(3
				(gEgo
					setCycle: CT [local5 (+ register 8)] 1 self
					setMotion:
						MoveTo
						[local5 (+ register 6)]
						[local5 (+ register 7)]
						self
				)
			)
			(4 0)
			(5
				(gKqSound1 number: 3002 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(6
				(gEgo
					normalize: 6
					setPri: 130
					x: [local5 (+ register 9)]
					y: [local5 (+ register 10)]
				)
				(stone1 setup:)
				(if (== local1 3)
					(gEgo setMotion: PolyPath 225 74 self)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(7
				(gEgo setHeading: 0 self)
			)
			(8
				(gCurRoom newRoom: 3300)
			)
		)
	)
)

(instance rosJumpSouth of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= local1 register)
		(*= register 11)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(stone1 setApproach: 0)
				(stone2 setApproach: 0)
				(stone3 setApproach: 0)
				(nExit setHotspot: 0)
				(farWoodsExit setHotspot: 0)
				(wereWoodsExit setHotspot: 0)
				(ClearFlag 106)
				(if (== local1 2)
					(gEgo disableHotspot:)
				)
				(if (== local1 0)
					(gEgo enableHotspot:)
					(gWalkHandler delete: gCurRoom)
				else
					(gWalkHandler addToFront: gCurRoom)
				)
				(gEgo setPri: 130 setHeading: [local49 (+ register 0)] self)
			)
			(2
				(gEgo
					view: [local49 (+ register 1)]
					setLoop: [local49 (+ register 2)] 1
					cel: 0
					x: [local49 (+ register 3)]
					y: [local49 (+ register 4)]
					setCycle: CT [local49 (+ register 5)] 1 self
				)
			)
			(3
				(gEgo
					setCycle: CT [local49 (+ register 8)] 1 self
					setMotion:
						MoveTo
						[local49 (+ register 6)]
						[local49 (+ register 7)]
						self
				)
			)
			(4 0)
			(5
				(if (!= local1 0)
					(gKqSound1 number: 3002 loop: 1 play:)
				)
				(gEgo setCycle: End self)
			)
			(6
				(if (== local1 0)
					(gEgo normalize: 2)
				else
					(gEgo normalize: 5)
				)
				(gEgo
					setPri: 130
					x: [local49 (+ register 9)]
					y: [local49 (+ register 10)]
				)
				(stone1 setup:)
				(if (== local1 0)
					(gEgo setPri: -1)
					(stone1 setApproach:)
					(stone2 setApproach:)
					(stone3 setApproach:)
					(wereWoodsExit setHotspot: 8 10) ; Do, Exit
				)
				(if (not next)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance gotoJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						PolyPath
						(river approachX:)
						(river approachY:)
						self
				)
			)
			(1
				(river doVerb: 8)
				(self dispose:)
			)
		)
	)
)

(instance gotoWoods of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 325 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 3050)
			)
		)
	)
)

(instance leaveEast of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 330 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 3050)
			)
		)
	)
)

(instance leaveSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) 136 self)
			)
			(1
				(gCurRoom newRoom: 3150)
			)
		)
	)
)

(instance enterFromWoods of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo normalize: 3 setMotion: MoveTo (gEgo x:) 129 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance web of View
	(properties
		x 217
		y 43
		view 3000
		loop 2
	)

	(method (onMe)
		(return 0)
	)
)

(instance spider of Prop
	(properties
		x 209
		y 33
		priority 50
		fixPriority 1
		view 3000
	)
)

(instance bird of Prop
	(properties
		x 222
		y 45
		view 3000
		loop 1
		cel 1
	)
)

(instance river of Feature
	(properties)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			y: 1
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 320 124 236 117 213 114 170 108 168 108 123 112 92 111 68 109 57 100 25 79 21 57 83 84 127 83 183 84 178 92 184 96 253 96 278 100 319 112
					yourself:
				)
		)
	)

	(method (onMe param1 &tmp temp0)
		(if (and (not (IsFlag 102)) (== gValOrRoz -3) (== local1 0)) ; Roz
			(return 0)
		)
		(if
			(and
				(= temp0
					(or
						(super onMe: param1)
						(and
							(IsFlag 102)
							(or
								(waterFall onMe: param1)
								(water1 onMe: param1)
								(water2 onMe: param1)
							)
						)
					)
				)
				(<= 1 local1 2)
			)
			(= sightAngle 360)
		else
			(= sightAngle 40)
		)
		(if (and temp0 (param1 type:))
			(cond
				((== gValOrRoz -3) ; Roz
					(cond
						((and (IsFlag 102) (not (OneOf local1 3 0)))
							(= approachX (gEgo x:))
							(= approachY (gEgo y:))
						)
						((not (IsFlag 102))
							(= approachX (gEgo x:))
							(= approachY (gEgo y:))
						)
						((IsFlag 106)
							(= approachX 229)
							(= approachY 75)
						)
						(else
							(= approachX 248)
							(= approachY 120)
						)
					)
				)
				((and (IsFlag 102) (not (OneOf local1 3 0)))
					(= approachX (gEgo x:))
					(= approachY (gEgo y:))
				)
				((not (IsFlag 102))
					(switch local1
						(0
							(= approachX 153)
							(= approachY 116)
						)
						(3
							(= approachX 190)
							(= approachY 90)
						)
						(else
							(= approachX (gEgo x:))
							(= approachY (gEgo y:))
						)
					)
				)
				((IsFlag 106)
					(= approachX 227)
					(= approachY 75)
				)
				(else
					(= approachX 239)
					(= approachY 122)
				)
			)
		)
		(return temp0)
	)

	(method (doVerb)
		(cond
			((== gValOrRoz -3) ; Roz
				(cond
					((and (IsFlag 102) (not (OneOf local1 3 0)))
						(river approachX: 248)
						(river approachY: 120)
						(rosJumpSouth next: gotoJump)
						(gCurRoom setScript: rosJumpSouth 0 0)
					)
					((and (IsFlag 102) (IsFlag 106))
						(if (not local0)
							(++ local0)
							(gCurRoom setScript: rosWadeNorth)
						else
							(gCurRoom setScript: rosJumpWaterSouth)
						)
					)
					((IsFlag 102)
						(if (not local0)
							(++ local0)
							(gCurRoom setScript: rosWadeSouth)
						else
							(gCurRoom setScript: rosJumpWaterNorth)
						)
					)
					(else
						(gCurRoom setScript: rosStickToe)
					)
				)
			)
			((and (IsFlag 102) (not (OneOf local1 3 0)))
				(river approachX: 239)
				(river approachY: 122)
				(valJumpSouth next: gotoJump)
				(gCurRoom setScript: valJumpSouth 0 0)
			)
			((and (IsFlag 102) (IsFlag 106))
				(gCurRoom setScript: valJumpWaterNorth)
			)
			((IsFlag 102)
				(gCurRoom setScript: valJumpWaterSouth)
			)
			(else
				(gCurRoom setScript: valStickToe)
			)
		)
	)
)

(instance rosStickToe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local137 (gEgo x:))
				(= local138 (gEgo y:))
				(if (!= local1 3)
					(gEgo setHeading: 90 self)
				else
					(gEgo setHeading: 270 self)
				)
			)
			(1
				(switch local1
					(1
						(gEgo setMotion: MoveTo 138 105 self)
					)
					(2
						(gEgo setMotion: MoveTo 176 97 self)
					)
					(3
						(gEgo setMotion: MoveTo 172 90 self)
					)
				)
			)
			(2
				(gEgo view: 8381 cel: 0)
				(if (!= local1 3)
					(gEgo setLoop: 0 1 setCycle: End self)
				else
					(gEgo setLoop: 1 1 setCycle: End self)
				)
			)
			(3
				(gEgo normalize: (if (!= local1 3) 0 else 1) setPri: 150)
				(if (!= local1 1)
					(gEgo posn: local137 local138)
					(= cycles 1)
				else
					(gEgo
						posn: 115 105
						setMotion: MoveTo local137 local138 self
					)
				)
			)
			(4
				(gEgo setHeading: 90 self)
			)
			(5
				(gMessager say: 7 8 6 1 self 3250) ; "I don't think so! I'm not silly enough to slog through that. Besides, Mother always told me not to play in the mud."
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance valStickToe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local137 (gEgo x:))
				(= local138 (gEgo y:))
				(if (!= local1 3)
					(gEgo setHeading: 45 self)
				else
					(gEgo setHeading: 225 self)
				)
			)
			(1
				(switch local1
					(0
						(gEgo
							view: 3251
							loop: 0
							cel: 13
							posn: 155 133
							setCycle: End self
						)
					)
					(1
						(gEgo
							view: 3251
							loop: 0
							cel: 13
							posn: 114 119
							setCycle: End self
						)
					)
					(2
						(gEgo
							view: 3251
							loop: 0
							cel: 13
							posn: 160 111
							setCycle: End self
						)
					)
					(3
						(if (>= (++ local0) 3)
							(self setScript: dieInMud self)
						else
							(gEgo setMotion: MoveTo 176 91 self)
						)
					)
				)
			)
			(2
				(cond
					((!= local1 3)
						(if (>= (++ local0) 3)
							(waterSound number: 3253 loop: 1 play:)
							(gEgo loop: 1 cel: 0 setCycle: End self)
						else
							(waterSound number: 3252 loop: 1 play:)
							(gEgo setCycle: CT 13 -1 self)
						)
					)
					((>= local0 3)
						(= ticks 1)
					)
					(else
						(gEgo view: 8021 loop: 1 cel: 0 setCycle: End self)
					)
				)
			)
			(3
				(if (>= local0 3)
					(= local0 0)
					(waterSound stop:)
					(EgoDead 25 self)
				else
					(= cycles 1)
				)
			)
			(4
				(gEgo
					normalize: (if (!= local1 3) 6 else 5)
					posn: local137 local138
					setScaler: Scaler 100 51 138 91
				)
				(if (not (OneOf local1 0 3))
					(gEgo setPri: 150)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dieInMud of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 3055 setLoop: 0 1 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(gEgo posn: 181 90 cel: 3 setCycle: CT 6 1 self)
			)
			(2
				(gEgo setCycle: CT 10 1 self setMotion: MoveTo 168 83 self)
			)
			(3 0)
			(4
				(waterSound number: 902 loop: 1 play:)
				(gEgo setPri: 150 setCycle: CT 27 1 self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance rosWadeSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 3003
					loop: 0
					cel: 0
					setScale: 0
					posn: 226 120
					setCycle: End self
				)
			)
			(1
				(gEgo setLoop: 1 cel: 0 posn: 236 116 setCycle: End self)
			)
			(2
				(gEgo
					normalize: 2
					posn: (river approachX:) (river approachY:)
					setScaler: Scaler 100 51 107 75
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rosWadeNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 3004
					setLoop: 0 1
					cel: 0
					setScaler: Scaler 80 80 1 0
					posn: 229 76
					setPri: 150
					setCycle: CT 17 1 self
				)
			)
			(1
				(gEgo setCycle: End self setMotion: MoveTo 231 78 self)
			)
			(2
				(gEgo setLoop: 1 1 cel: 0 posn: 197 90 setCycle: End self)
			)
			(3
				(gEgo
					normalize: 3
					posn: (river approachX:) (river approachY:)
					setScaler: Scaler 100 51 107 75
					setHeading: 180 self
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rosJumpWaterSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 3005
					setLoop: 0
					cel: 0
					setScale: 0
					setPri: 150
					setCycle: CT 9 1 self
				)
			)
			(1
				(gKqSound1 number: 907 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(2
				(if (IsFlag 102)
					(waterSound stop:)
				)
				(EgoDead 69 self)
			)
			(3
				(if (IsFlag 102)
					(waterSound loop: -1 play:)
				)
				(gEgo
					normalize: 2
					posn: (river approachX:) (river approachY:)
					setScaler: Scaler 100 51 107 75
				)
				(= local0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rosJumpWaterNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 3006
					setLoop: 0
					cel: 0
					setScale: 0
					posn: 244 120
					setCycle: CT 5 1 self
				)
			)
			(1
				(gEgo posn: 236 101 cel: 6 setCycle: CT 9 1 self)
			)
			(2
				(gKqSound1 number: 907 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(if (IsFlag 102)
					(waterSound stop:)
				)
				(EgoDead 69 self)
			)
			(4
				(if (IsFlag 102)
					(waterSound loop: -1 play:)
				)
				(gEgo
					normalize: 3
					posn: (river approachX:) (river approachY:)
					setScaler: Scaler 100 51 107 75
				)
				(= local0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance valJumpWaterSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 3009)
				(= local3 (gEgo scaleX:))
				(= local4 (gEgo scaleY:))
				(gEgo view: 8223 setLoop: 0 1 cel: 0 posn: 241 123 setScale:)
				(gEgo
					signal: (| (gEgo signal:) $0001)
					scaleX: local3
					scaleY: local4
					setCycle: CT 12 1 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 241 110 self setCycle: CT 15 1 self)
			)
			(2 0)
			(3
				(gKqSound1 number: 907 loop: 1 play:)
				(gEgo
					view: 3009
					setLoop: 0 1
					cel: 6
					posn: 257 95
					setCycle: CT 8 1 self
				)
			)
			(4
				(gEgo setMotion: MoveTo 261 90 setCycle: End self)
			)
			(5
				(if (IsFlag 102)
					(waterSound stop:)
				)
				(EgoDead 24 self)
			)
			(6
				(if (IsFlag 102)
					(waterSound loop: -1 play:)
				)
				(gEgo
					normalize: 3
					posn: (river approachX:) (river approachY:)
					setScaler: Scaler 100 51 138 91
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance valJumpWaterNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local3 (gEgo scaleX:))
				(= local4 (gEgo scaleY:))
				(gEgo
					view: 3008
					setLoop: 0 1
					cel: 0
					posn: 227 75
					setPri: 150
					setScale:
				)
				(gEgo
					signal: (| (gEgo signal:) $0001)
					scaleX: local3
					scaleY: local4
					setCycle: CT 5 1 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 207 80 setCycle: CT 10 1 self)
			)
			(2
				(gKqSound1 number: 907 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo hide:)
				(if (IsFlag 102)
					(waterSound stop:)
				)
				(EgoDead 24 self)
			)
			(4
				(if (IsFlag 102)
					(waterSound loop: -1 play:)
				)
				(gEgo
					show:
					normalize: 2
					posn: (river approachX:) (river approachY:)
					setScaler: Scaler 100 51 138 91
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(class Stone of Feature
	(properties
		y 10
		stoneNum 0
	)

	(method (init)
		(super init: &rest)
		(self setApproach: setup:)
	)

	(method (onMe param1 &tmp temp0)
		(if (= temp0 (super onMe: param1))
			(if
				(or
					(and
						(not (OneOf stoneNum (+ local1 1) (- local1 1)))
						(== gTheCursor gNormalCursor)
					)
					(IsFlag 102)
				)
				(gTheCursor setCycle: 0 setCel: 0)
			)
			(if (param1 type:)
				(= _approachVerbs (= approachX (= approachY 0)))
				(if
					(or
						(and (== stoneNum 1) (== local1 0))
						(and (== stoneNum 2) (== local1 3))
					)
					(self setApproach: approachVerbs: 8) ; Do
				)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(8 ; Do
				(= temp0 (- stoneNum local1))
				(cond
					((IsFlag 102) 0)
					((== temp0 -1)
						(if (== gValOrRoz -3) ; Roz
							(gCurRoom setScript: rosJumpSouth 0 stoneNum)
						else
							(gCurRoom setScript: valJumpSouth 0 stoneNum)
						)
					)
					((== temp0 1)
						(if (== gValOrRoz -3) ; Roz
							(gCurRoom setScript: rosJumpNorth 0 stoneNum)
						else
							(gCurRoom setScript: crossNorth)
						)
					)
					((not temp0) 0)
				)
				(self setup:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (setApproach param1)
		(if (or (not argc) param1)
			(if (IsFlag 106)
				(self approachX: 190 approachY: 90)
			else
				(self approachX: 112 approachY: 116)
			)
			(self approachVerbs: 8) ; Do
		else
			(= approachX (= approachY 0))
			(self approachVerbs: 0)
		)
	)

	(method (setup))
)

(instance stone1 of Stone
	(properties
		x 112
		y 106
		stoneNum 1
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 56 98 69 95 80 99 95 98 108 101 123 101 133 104 128 109 110 110 63 110
					yourself:
				)
		)
	)

	(method (setup)
		(if (not (IsFlag 102))
			(stone1 setHotspot: 8 10) ; Do, Exit
			(stone2 setHotspot: 8 10) ; Do, Exit
			(stone3 setHotspot: 8 10) ; Do, Exit
		else
			(self setApproach: setHotspot: 8 10) ; Do, Exit
		)
	)
)

(instance stone2 of Stone
	(properties
		x 156
		y 99
		stoneNum 2
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 140 100 143 96 151 95 163 94 170 96 174 99 171 102
					yourself:
				)
		)
	)
)

(instance stone3 of Stone
	(properties
		x 191
		y 94
		stoneNum 3
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 179 93 180 89 184 88 188 83 205 80 216 76 234 76 249 79 254 87 251 93 239 93 225 96 221 94 198 94 192 95
					yourself:
				)
		)
	)
)

(instance nExit of ExitFeature
	(properties
		nsLeft 151
		nsRight 265
		nsBottom 86
		approachX 225
		approachY 74
		x 225
		y 70
		exitDir 1
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 106)
			(self setHotspot: 8 10) ; Do, Exit
		)
		(self approachVerbs: 8) ; Do
	)

	(method (doVerb)
		(gCurRoom setScript: changeToSpider)
	)
)

(instance changeToSpider of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(1
				(gCurRoom newRoom: 3300)
			)
		)
	)
)

(instance farWoodsExit of ExitFeature
	(properties
		approachX 316
		approachY 78
		x 318
		y 78
		exitDir 2
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 284 49 320 49 320 78 284 78
					yourself:
				)
		)
		(if (IsFlag 106)
			(self setHotspot: 8 10) ; Do, Exit
		)
	)

	(method (doVerb)
		(gCurRoom setScript: gotoWoods)
	)
)

(instance wereWoodsExit of ExitFeature
	(properties
		exitDir 3
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 156 131 320 131 320 139 156 139
					yourself:
				)
		)
		(if (not (IsFlag 106))
			(self setHotspot: 8 10) ; Do, Exit
		)
	)

	(method (onMe param1 &tmp temp0)
		(= temp0 (super onMe: param1))
		(if (param1 type:)
			(= x (= approachX (param1 x:)))
			(= y (+ (= approachY (param1 y:)) 5))
		)
		(return temp0)
	)

	(method (doVerb)
		(gCurRoom setScript: leaveSouth)
	)
)

(instance waterFall of Prop
	(properties
		x 25
		y 105
		priority 10
		fixPriority 1
		view 3002
	)

	(method (init)
		(super init:)
		(|= signal $1000)
		(self setCycle: Fwd)
	)
)

(instance water1 of Prop
	(properties
		x 60
		y 113
		priority 100
		fixPriority 1
		view 3002
		loop 1
	)

	(method (init)
		(super init:)
		(|= signal $1000)
		(self setCycle: Fwd)
	)
)

(instance water2 of Actor
	(properties
		x 180
		y 123
		priority 10
		fixPriority 1
		view 3002
		loop 2
	)

	(method (init)
		(super init:)
		(|= signal $1000)
		(self setCycle: Fwd)
	)
)

(instance waterSound of Sound
	(properties)
)

