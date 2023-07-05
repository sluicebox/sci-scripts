;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4102)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use scaryInvInit)
(use eastFeat)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm4102 0
	coronerTalker 40
)

(local
	local0
	local1
	local2
	[local3 6] = [8 11 14 17 20 -1]
)

(procedure (localproc_0)
	(cond
		((== gValOrRoz -4) ; Val
			(gEgo setScaler: Scaler 88 67 123 88)
		)
		((IsFlag 151)
			(gEgo setScaler: Scaler 100 77 123 91)
		)
		(else
			(gEgo setScaler: Scaler 100 67 123 88)
		)
	)
)

(instance rm4102 of KQRoom
	(properties
		modNum 4100
		picture 4102
		horizon 70
	)

	(method (init)
		(super init:)
		(gGame handsOff:)
		(SetFlag 55)
		(Load rsMESSAGE 4100)
		(Load 140 862) ; WAVE
		(Load 140 863) ; WAVE
		(= local2 gFtrInitializer)
		(= gFtrInitializer roomFeatureInitCode)
		(coronerTalker client: coroner)
		(= local0
			((Polygon new:)
				type: PContainedAccess
				init: 319 104 253 125 225 127 183 128 183 115 204 89 187 89 175 100 178 118 178 127 95 125 0 125 0 138 261 137 320 117
				yourself:
			)
		)
		(= local1
			((Polygon new:)
				type: PContainedAccess
				init: 320 100 302 112 273 119 242 125 163 125 155 125 0 125 0 137 261 137 320 118
				yourself:
			)
		)
		(if (IsFlag 151)
			(SetFlag 553)
		)
		(gEgo init: normalize:)
		(localproc_0)
		(switch gPrevRoomNum
			(4400
				(gEgo posn: 210 200)
			)
			(4200
				(SetFlag 553)
				(gEgo
					posn: (houseDoor approachX:) (houseDoor approachY:)
					normalize: 2
				)
				(localproc_0)
			)
			(4250
				(gEgo posn: 340 117)
			)
			(4101
				(gEgo posn: -20 125)
			)
			(else
				(gGame handsOff:)
				(gEgo posn: 309 117)
			)
		)
		(myEastExit init:)
		(myWestExit init:)
		(myRightSouthExit init:)
		(if (IsFlag 5)
			(ClearFlag 5)
		)
		(if (!= gPrevRoomNum 4101)
			(gKqMusic1 number: 4100 loop: -1 play:)
		)
		(switch gChapter
			(4
				(cond
					((not (IsFlag 456))
						(kid1 view: 4101 setLoop: 0 1 cel: 0 posn: 145 89 init:)
						(kitty init:)
						(SetFlag 553)
						(gCurRoom setScript: roseFirstEnter)
					)
					((and (not (IsFlag 460)) (!= gPrevRoomNum 4200))
						(kid1
							view: 4103
							loop: 1
							cel: 0
							x: 179
							y: 109
							priority: 109
							fixPriority: 1
							init:
						)
						(Load 140 2509) ; WAVE
						(Load rsSOUND 4118)
						(Load rsSOUND 4119)
						(SetFlag 553)
						(gCurRoom setScript: roseSecondEnter)
					)
					(else
						(if (!= gPrevRoomNum 4200)
							(ClearFlag 553)
						)
						(if (IsFlag 151)
							(SetFlag 553)
						)
						(gCurRoom setScript: sEnter)
					)
				)
				(if
					(or
						(and (gEgo has: 62) (not (IsFlag 151))) ; Device
						(and (IsFlag 183) (not (IsFlag 151)) (IsFlag 478))
					)
					(docSign init:)
				)
			)
			(5
				(if
					(or
						(and (IsFlag 564) (not (IsFlag 511)))
						(IsFlag 566)
						(gEgo has: 69) ; Magic_Bridle
					)
					(docSign init:)
				)
				(gCurRoom setScript: sEnter)
			)
		)
		(gate init:)
		(if (IsFlag 553)
			(gCurRoom addObstacle: local0)
		else
			(gCurRoom addObstacle: local1)
		)
		(houseDoor init:)
		(if
			(or
				(and (== gValOrRoz -3) (not (IsFlag 459))) ; Roz
				(and (== gValOrRoz -4) (not (IsFlag 506))) ; Val
			)
			(mailBox init:)
		)
	)

	(method (newRoom newRoomNumber)
		(= gFtrInitializer local2)
		(if (!= newRoomNumber 4101)
			(gKqMusic1 fade:)
		)
		((gCurRoom obstacles:) release:)
		(local0 dispose:)
		(local1 dispose:)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance exitToWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -30 125 self)
			)
			(1
				(gCurRoom newRoom: 4101)
			)
		)
	)
)

(instance exitToEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 330 117 self)
			)
			(1
				(gCurRoom newRoom: 4250)
			)
		)
	)
)

(instance exitToRightSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 195 200 self)
			)
			(1
				(gCurRoom newRoom: 4400)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch gPrevRoomNum
					(4400
						(gEgo setMotion: MoveTo 210 129 self)
					)
					(4200
						(self cue:)
					)
					(4250
						(gEgo setMotion: MoveTo 285 120 self)
					)
					(4101
						(gEgo setMotion: MoveTo 14 130 self)
					)
					(else
						(gEgo setMotion: MoveTo 285 120 self)
						(gGame handsOn:)
					)
				)
			)
			(1
				(switch gChapter
					(5
						(gGame handsOn:)
					)
					(4
						(if
							(or
								(and (IsFlag 456) (IsFlag 460))
								(and (IsFlag 456) (== gPrevRoomNum 4200))
							)
							(gGame handsOn:)
						)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance roseFirstEnter of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load 140 802) ; WAVE
					(Load 140 4115) ; WAVE
					(coronerTalker client: houseDoor)
					(self setScript: sEnter self)
				)
				(1
					(gGame handsOff: 1)
					(SetFlag 456)
					(proc11_3 gEgo kid1)
					(gKqSound1 number: 4115 loop: 1 play:)
					(kid1
						view: 4101
						setLoop: 0 1
						cel: 0
						posn: 145 89
						init:
						setCycle: End self
					)
				)
				(2
					(gKqSound1 number: 925 loop: 1 play:)
					(kitty setCycle: End self)
				)
				(3
					(gKqSound1 number: 801 loop: 1 play:)
					(houseDoor setCycle: CT 3 1 self)
				)
				(4
					(kitty hide:)
					(houseDoor setCycle: End self)
				)
				(5
					(houseDoor setLoop: 3 cel: 0 setCycle: End self)
				)
				(6
					(gMessager say: 0 0 1 1 self 4100) ; "(ANGRY BUT FRIGHTENED)You little fiend! Get out of here!"
				)
				(7
					(kid1 setLoop: 4 1 cel: 0 setCycle: CT 32 1 self)
					((ScriptID 7001 5) ; kid1Talker
						view: 4101
						clientCel: 32
						hide_mouth: 0
						loop: 24
					)
				)
				(8
					(gMessager say: 0 0 1 2 self 4100) ; "BOO!"
				)
				(9
					((ScriptID 7001 5) ; kid1Talker
						view: -1
						clientCel: 27
						loop: -1
						mouth_x: -999
						mouth_y: -999
					)
					(coroner view: 4102 loop: 2 posn: 198 96 cel: 0 init:)
					(kitty
						view: 4102
						posn: 197 94
						setCel: 0
						setLoop: 1 1
						show:
						setCycle: End
					)
					(houseDoor
						view: 4102
						setLoop: 0
						cel: 0
						posn: 193 88
						setCycle: CT 16 1 self
					)
				)
				(10
					(coroner dispose:)
					(kitty hide: dispose:)
					(houseDoor cel: 16 posn: 197 95 setCycle: End self)
				)
				(11
					(gKqSound1 number: 802 loop: 1 play: self)
				)
				(12
					(kidSound play:)
					(kid1 cel: 33 setCycle: CT 40 1 self)
				)
				(13
					(kid1 setPri: 130 setCycle: End self)
				)
				(14
					(kidSound loop: 1 fade:)
					(kid1 dispose:)
					(coroner view: 4105 loop: 2 cel: 0 x: 192 y: 89)
					(coronerTalker client: coroner)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(houseDoor view: 4102 posn: 197 95 setLoop: 0)
					(houseDoor cel: (houseDoor lastCel:))
					(coroner view: 4105 loop: 2 cel: 0 x: 192 y: 89)
					(SetFlag 456)
					(kid1 dispose:)
					(kitty dispose:)
					(kidSound stop:)
					(gKqSound1 stop:)
					(coronerTalker client: coroner)
					(ClearFlag 539)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance roseSecondEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: sEnter self)
			)
			(1
				(SetFlag 460)
				(SetFlag 553)
				(= cycles 50)
			)
			(2
				(kid1 setCycle: CT 9 1 self)
			)
			(3
				(gKqSound1 number: 4118 loop: 1 play:)
				(kid1 setCycle: CT 12 1 self)
			)
			(4
				(gKqSound1 number: 2509 loop: 1 play:)
				(kid1 setCycle: CT 14 1 self)
			)
			(5
				(gKqSound1 number: 4119 loop: 1 play:)
				(egg init: setCycle: End egg)
				(kid1 setCycle: End self)
			)
			(6
				(kidSound play:)
				(kid1
					view: 4103
					loop: 3
					cel: 0
					x: 180
					y: 113
					priority: 128
					fixPriority: 1
					setCycle: End self
				)
			)
			(7
				(kidSound loop: 1 fade:)
				(kid1 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance valOpenGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(1
				(gate dispose:)
				(gEgo
					view: 4128
					loop: 0
					cel: 0
					x: 156
					y: 128
					priority: 123
					fixPriority: 1
					setScale: 0
					setCycle: CT 5 1 self
				)
			)
			(2
				(gKqSound1 number: 862 loop: 1 play:)
				(gEgo setCycle: CT 21 1 self)
			)
			(3
				(SetFlag 553)
				(gate init:)
				(cond
					((and (IsFlag 566) (== gChapter 5)) 0)
					((and (IsFlag 564) (not (IsFlag 511)) (== gChapter 5))
						(houseDoor approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
					)
					(else
						(houseDoor approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
					)
				)
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(4
				(gEgo posn: 187 129 normalize: 3)
				(localproc_0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance valCloseGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 4129
					loop: 0
					cel: 0
					x: 177
					y: 128
					priority: 128
					fixPriority: 1
					setScale: 0
					setCycle: CT 11 1 self
				)
			)
			(1
				(gate dispose:)
				(gKqSound1 number: 863 loop: 1 play:)
				(gEgo cel: 12 cycleSpeed: 5 setCycle: CT 36 1 self)
			)
			(2
				(ClearFlag 553)
				(gate init:)
				(houseDoor setHotspot: 0)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo normalize: 3 posn: 182 126)
				(localproc_0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance valSeesDoc of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 41010 setLoop: 0 1 cel: 0 setCycle: CT 7 1 self)
			)
			(1
				(gKqSound1 number: 808 loop: 1 play:)
				(gEgo setCycle: CT 9 1 self)
			)
			(2
				(gKqSound1 play:)
				(gEgo setCycle: CT 7 -1 self)
			)
			(3
				(gKqSound1 play:)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 6)
				(localproc_0)
				(gEgo
					setLoop: 0 1
					setCycle: Rev
					setMotion: MoveTo 172 92 self
				)
			)
			(5
				(gEgo setCycle: 0)
				(coroner
					view: 4107
					setLoop: 0 1
					cel: 0
					posn: 199 90
					init:
					setCycle: End self
				)
				(houseDoor
					view: 4107
					setLoop: 2 1
					cel: 0
					posn: 205 87
					setCycle: End self
				)
				(gKqSound1 number: 801 loop: 1 play:)
			)
			(6
				(coroner
					setLoop: 1 1
					setPri: 88
					posn: (- (coroner x:) 2) (+ (coroner y:) 1)
					cel: 0
					setCycle: End self
				)
			)
			(7
				(if (and (== register 11) (IsFlag 502))
					(gMessager say: 2 8 register 3 self 4100)
				else
					(gMessager say: 2 8 register 0 self 4100)
				)
			)
			(8
				(SetFlag 502)
				(gEgo normalize: 0)
				(gEgo setPri: 87 setMotion: MoveTo 190 92 self)
			)
			(9
				(gEgo setMotion: MoveTo 199 84 self)
			)
			(10
				(gEgo hide:)
				(coroner setCycle: Beg self)
			)
			(11
				(coroner
					setLoop: 0 1
					setPri: 55
					posn: (+ (coroner x:) 2) (- (coroner y:) 1)
					cel: (coroner lastCel:)
					setPri: (- (houseDoor priority:) 1)
					setCycle: CT 0 -1
				)
				(houseDoor setCycle: CT 3 -1 self)
			)
			(12
				(coroner hide:)
				(houseDoor setCycle: CT 0 -1 self)
			)
			(13
				(kidSound number: 802 loop: 1 play: self)
			)
			(14
				(gCurRoom newRoom: 4200)
			)
		)
	)
)

(instance roseKnocks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 851) ; WAVE
				(= cycles 1)
			)
			(1
				(= scratch 0)
				(gEgo
					view: 4105
					setLoop: 0 1
					cel: 0
					setScale: 0
					setCycle: 0
					posn: 181 89
				)
				(= cycles 1)
			)
			(2
				(gEgo setCycle: CT [local3 scratch] 1 self)
			)
			(3
				(gKqSound1 number: 851 loop: 1 play:)
				(if (!= [local3 (++ scratch)] -1)
					(-= state 2)
				)
				(= cycles 1)
			)
			(4
				(gEgo setCycle: CT 42 1 self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance roseKnocksOnDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(coroner init: hide:)
				(self setScript: roseKnocks self)
			)
			(1
				(houseDoor
					view: 4107
					setLoop: 2 1
					cel: 0
					posn: 205 87
					setCycle: CT 3 1 self
				)
				(coroner show: setPri: 55 setCycle: End self)
				(gKqSound1 number: 801 loop: 1 play:)
			)
			(2 0)
			(3
				(gMessager say: 2 8 register 0 self 4100)
			)
			(4
				(coroner view: 4105 setLoop: 3 1 cel: 0 setCycle: End self)
				(houseDoor cel: 4)
				(UpdateScreenItem houseDoor)
			)
			(5
				(coroner view: 4106 setLoop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(6
				(houseDoor cel: 5)
				(UpdateScreenItem houseDoor)
				(coroner setCycle: CT 11 1 self)
			)
			(7
				(houseDoor setCycle: End self)
				(coroner setCycle: End self)
			)
			(8 0)
			(9
				(coroner
					view: 4106
					setLoop: 1 1
					cel: 0
					setPri: 5
					setCycle: CT 34 1 self
				)
			)
			(10
				(gEgo setPri: 10 setCycle: End self)
			)
			(11
				(gEgo hide:)
				(coroner setLoop: 2 1 cel: 0 posn: 196 93 setCycle: CT 1 1 self)
			)
			(12
				(houseDoor dispose:)
				(coroner setCycle: End self)
			)
			(13
				(gKqSound1 number: 802 loop: 1 play: self)
			)
			(14
				(gCurRoom newRoom: 4200)
			)
		)
	)
)

(instance roseKnocksOnDoorBackbone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: roseKnocks self)
			)
			(1
				(gKqSound1 number: 801 loop: 1 play:)
				(coroner
					view: 4107
					setLoop: 0 1
					cel: 0
					posn: 199 86
					init:
					setCycle: End self
				)
				(houseDoor
					view: 4107
					setLoop: 2 1
					cel: 0
					posn: 205 87
					setCycle: End self
				)
			)
			(2 0)
			(3
				(coroner setLoop: 1 1 setPri: 88 cel: 0 setCycle: End self)
			)
			(4
				(gMessager say: 2 8 register 0 self 4100)
			)
			(5
				(gEgo setPri: 10 setCycle: End self)
			)
			(6
				(gEgo hide:)
				(coroner setCycle: Beg self)
			)
			(7
				(coroner setLoop: 0 1)
				(coroner setPri: 55 cel: (coroner lastCel:) setCycle: CT 0 -1)
				(houseDoor setCycle: CT 3 -1 self)
			)
			(8
				(coroner hide:)
				(houseDoor setCycle: CT 0 -1 self)
			)
			(9
				(kidSound number: 802 loop: 1 play: self)
			)
			(10
				(gCurRoom newRoom: 4200)
			)
		)
	)
)

(instance roseKnocksAsWomanInBlack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 851) ; WAVE
				(= cycles 1)
			)
			(1
				(= scratch 0)
				(gEgo
					view: 4108
					setLoop: 4 1
					cel: 0
					setScale: 0
					setCycle: 0
					posn: 188 92
					setCycle: CT 9 1 self
				)
			)
			(2
				(gKqSound1 number: 851 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo
					normalize: 6
					posn: (houseDoor approachX:) (houseDoor approachY:)
				)
				(localproc_0)
				(gEgo
					setLoop: 0 1
					setCycle: Rev
					setMotion: MoveTo 168 95 self
				)
			)
			(4
				(gEgo setCycle: 0)
				(coroner
					view: 4107
					loop: 0 1
					cel: 0
					x: 199
					y: 90
					init:
					setPri: 50
					setCycle: End self
				)
				(houseDoor
					view: 4107
					setLoop: 2 1
					cel: 0
					posn: 205 87
					setCycle: End self
				)
				(gKqSound1 number: 801 loop: 1 play:)
			)
			(5
				(coroner
					setLoop: 1 1
					setPri: 88
					posn: (- (coroner x:) 2) (+ (coroner y:) 1)
					cel: 0
					setCycle: End self
				)
			)
			(6
				(if register
					(gMessager say: 2 8 register 0 self 4100)
				else
					(= cycles 1)
				)
			)
			(7
				(gEgo normalize: 0)
				(gEgo setPri: 87 setMotion: MoveTo 190 92 self)
			)
			(8
				(gEgo setMotion: MoveTo 199 84 self)
			)
			(9
				(gEgo hide:)
				(coroner setCycle: Beg self)
			)
			(10
				(coroner
					setLoop: 0 1
					setPri: 55
					posn: (+ (coroner x:) 2) (- (coroner y:) 1)
					cel: (coroner lastCel:)
					setPri: (- (houseDoor priority:) 1)
					setCycle: CT 0 -1
				)
				(houseDoor setCycle: CT 3 -1 self)
			)
			(11
				(coroner hide:)
				(houseDoor setCycle: CT 0 -1 self)
			)
			(12
				(kidSound number: 802 loop: 1 play: self)
			)
			(13
				(gCurRoom newRoom: 4200)
			)
		)
	)
)

(instance rosCloseGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 553)
				(gEgo
					view: 4104
					loop: 1
					cel: 0
					x: 185
					y: 129
					priority: 128
					fixPriority: 1
					setScale: 0
					setCycle: CT 5 1 self
				)
			)
			(1
				(gate dispose:)
				(gKqSound1 number: 863 loop: 1 play:)
				(gEgo cel: 12 cycleSpeed: 5 setCycle: CT 27 1 self)
			)
			(2
				(ClearFlag 553)
				(gate init:)
				(houseDoor setHotspot: 0)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo normalize: 3 posn: 180 125)
				(localproc_0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rosOpenGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 553)
				(gate dispose:)
				(gEgo
					view: 4104
					setLoop: 0 1
					cel: 3
					posn: 179 128
					setCycle: CT 20 1 self
				)
				(gKqSound1 number: 862 loop: 1 play:)
			)
			(1
				(gate init:)
				(gEgo cel: 21 setCycle: CT 22 1 self)
			)
			(2
				(gEgo normalize: 3 posn: 179 129)
				(if (and (== gChapter 4) (IsFlag 151) (gEgo has: 52)) ; Defoliant
					0
				else
					(houseDoor approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance houseDoor of Prop
	(properties
		noun 2
		approachX 188
		approachY 89
		x 189
		y 85
		view 4101
		loop 2
	)

	(method (init)
		(super init:)
		(self setPri: 70)
		(cond
			((and (== gChapter 4) (IsFlag 151) (gEgo has: 52)) 0) ; Defoliant
			((not (IsFlag 553)) 0)
			((and (IsFlag 564) (not (IsFlag 511)) (== gChapter 5))
				(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
			)
			((and (IsFlag 566) (== gChapter 5)) 0)
			(else
				(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((== gValOrRoz -3) ; Roz
						(cond
							((and (IsFlag 478) (not (IsFlag 151)))
								(gMessager say: noun theVerb 7 1 0 4100) ; "(THINKS TO HERSELF)'The Doctor is Out'. Well, I hope he doesn't give away any other vital organs while he's at it."
							)
							((gEgo has: 52) ; Defoliant
								(gMessager say: noun theVerb 6 1 0 4100) ; "Oh, there's a sign. 'The Doctor is Out."
							)
							((IsFlag 151)
								(if (not (SetFlag 457))
									(gCurRoom
										setScript: roseKnocksAsWomanInBlack 0 5
									)
								else
									(gCurRoom
										setScript: roseKnocksAsWomanInBlack
									)
								)
							)
							((not (IsFlag 488))
								(SetFlag 488)
								(gCurRoom setScript: roseKnocksOnDoor 0 2)
							)
							((and (not (IsFlag 173)) (IsFlag 488))
								(gCurRoom setScript: roseKnocksOnDoor 0 3)
							)
							(else
								(gCurRoom
									setScript: roseKnocksOnDoorBackbone 0 4
								)
							)
						)
					)
					((IsFlag 502)
						(cond
							((and (not (IsFlag 564)) (not (IsFlag 511)))
								(gCurRoom setScript: valSeesDoc 0 11)
							)
							((not (IsFlag 511))
								(gMessager say: noun theVerb 13 0 0 4100) ; "(READING TO HERSELF)Making a house call. Back soon."
							)
							((IsFlag 207)
								(gMessager say: noun theVerb 14 0 0 4100) ; "(READING TO HERSELF)The patient died. Trying to catch him. Back later."
							)
							((IsFlag 503)
								(gCurRoom setScript: valSeesDoc 0 17)
							)
							(else
								(SetFlag 503)
								(gCurRoom setScript: valSeesDoc 0 16)
							)
						)
					)
					((IsFlag 511)
						(SetFlag 502)
						(gCurRoom setScript: valSeesDoc 0 15)
					)
					(else
						(gCurRoom setScript: valSeesDoc 0 11)
					)
				)
			)
		)
	)
)

(instance gate of Prop
	(properties
		approachX 172
		approachY 127
		x 185
		y 127
		priority 122
		fixPriority 1
		view 4131
	)

	(method (init)
		(= loop (IsFlag 553))
		(super init: &rest)
		(if (not (IsFlag 151))
			(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
		)
		(if (== loop 0)
			(if (gCurRoom obstacles:)
				((gCurRoom obstacles:) delete: local0 add: local1)
			)
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 164 118 197 118 206 85 190 73 178 71 157 84
						yourself:
					)
			)
		else
			(if (gCurRoom obstacles:)
				((gCurRoom obstacles:) delete: local1 add: local0)
			)
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 138 75 138 82 157 124 167 118 158 85 145 74
						yourself:
					)
					((Polygon new:)
						type: PTotalAccess
						init: 197 117 208 123 222 85 220 76 216 77 204 89
						yourself:
					)
			)
		)
		(cond
			((== gValOrRoz -4) ; Val
				(= approachX 185)
				(= approachY 128)
			)
			((not (IsFlag 553))
				(= approachX 184)
			)
		)
	)

	(method (doVerb)
		(cond
			((== loop 0)
				(if (== gValOrRoz -3) ; Roz
					(gCurRoom setScript: rosOpenGate)
				else
					(gCurRoom setScript: valOpenGate)
				)
			)
			((== gValOrRoz -3) ; Roz
				(gCurRoom setScript: rosCloseGate)
			)
			(else
				(gCurRoom setScript: valCloseGate)
			)
		)
	)
)

(instance kid1 of Prop
	(properties
		x 179
		y 109
		priority 109
		fixPriority 1
		view 4103
		loop 1
		cel 14
	)

	(method (init)
		(super init: &rest)
		((ScriptID 7001 5) ; kid1Talker
			clientCel: 27
			loop: -1
			view: -1
			mouth_x: -999
			mouth_y: -999
			client: self
		)
	)
)

(instance egg of Prop
	(properties
		x 209
		y 75
		priority 85
		fixPriority 1
		view 4103
		loop 2
	)

	(method (cue)
		(self dispose:)
	)
)

(instance coroner of Prop
	(properties
		x 192
		y 89
		view 4105
		loop 2
	)
)

(instance docSign of View
	(properties
		x 188
		y 67
		priority 88
		fixPriority 1
		view 4107
		loop 4
	)
)

(instance kitty of Prop
	(properties
		x 199
		y 94
		view 4101
		loop 1
	)
)

(instance mailBox of Feature
	(properties
		noun 1
		nsLeft 118
		nsTop 85
		nsRight 138
		nsBottom 120
		approachX 144
		approachY 126
		x 140
		y 122
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb theVerb)
		(cond
			((and (== gChapter 4) (not (IsFlag 459)))
				(SetFlag 459)
				(gMessager say: noun theVerb 2 1 0 4100)
				(self dispose:)
			)
			((and (not (IsFlag 511)) (not (IsFlag 506)))
				(SetFlag 506)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: noun theVerb 11 1 0 4100)
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(self dispose:)
			)
			((not (IsFlag 506))
				(SetFlag 506)
				(gMessager say: noun theVerb 12 1 0 4100)
				(self dispose:)
			)
		)
		(return 1)
	)
)

(instance myEastExit of ExitFeature
	(properties
		nsLeft 307
		nsTop 73
		nsRight 320
		nsBottom 124
		approachX 318
		approachY 117
		x 330
		y 117
		exitDir 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gEgo setScript: exitToEast)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
	)
)

(instance myWestExit of ExitFeature
	(properties
		nsTop 73
		nsRight 20
		nsBottom 130
		approachY 125
		x -30
		y 117
		exitDir 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gEgo setScript: exitToWest)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
	)
)

(instance myRightSouthExit of ExitFeature
	(properties
		nsLeft -1
		nsTop 133
		nsRight 319
		nsBottom 139
		approachX 195
		approachY 139
		x 195
		y 160
		exitDir 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gEgo setScript: exitToRightSouth)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
	)
)

(instance roomFeatureInitCode of Code
	(properties)

	(method (doit param1)
		(if (not (param1 isKindOf: KQInventory))
			(if (param1 respondsTo: #signal)
				(param1 signal: (| (param1 signal:) $7001))
			)
			(param1 sightAngle: 10 modNum: 4100)
		)
	)
)

(instance kidSound of Sound
	(properties
		flags 5
		number 4120
		loop -1
	)
)

(instance coronerTalker of KQTalker
	(properties)

	(method (init)
		(super init: &rest)
	)
)

