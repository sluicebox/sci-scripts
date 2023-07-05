;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5250)
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
	rm5250 0
)

(local
	local0
	local1
	local2
)

(instance rm5250 of KQRoom
	(properties
		picture 5250
	)

	(method (init)
		(gKqMusic1 number: 5250 loop: -1 play:)
		(gEgo setScaler: Scaler 106 70 137 113 init: normalize:)
		(switch gPrevRoomNum
			(5200
				(= local0 0)
				(gEgo
					posn: 121 84
					view: 5251
					setLoop: 0 1
					cel: 0
					setPri: 110
					ignoreActors: 1
					setScale: 0
				)
				(gCurRoom setScript: sMirrorSpits)
			)
			(23 ; selectGameRoom
				(gEgo normalize:)
			)
			(else
				(gEgo setLoop: 1 posn: 253 111)
				(if (== gChapter 5)
					(= local0 0)
					(gCurRoom setScript: sEnterFromStairs)
				else
					(= picture 5251)
					(= local0 1)
					(gEgo y: 27 setScaler: Scaler 58 75 43 25)
					(gCurRoom setScript: sEnterUpsideDown)
				)
			)
		)
		(if (and (== gPrevRoomNum 5150) (not (IsFlag 123)) (IsFlag 124))
			(SetFlag 267)
		)
		(if (IsFlag 124)
			(if local0
				(if (and (IsFlag 267) (not (IsFlag 123)) (IsFlag 124))
					(statue view: 5226 loop: 0 setPri: 3 posn: 232 134 init:)
				)
				(if (IsFlag 124)
					(drawer init: posn: 260 26 setPri: 2)
				)
			else
				(if (IsFlag 267)
					(statue posn: 232 20)
				)
				(drawer init:)
				(if (not (IsFlag 123))
					(statue setPri: 110 init:)
				)
			)
		)
		(if (not (IsFlag 124))
			(theDrawer init:)
		)
		(theMirror ignoreActors: 1 setPri: (if local0 2 else 20) init:)
		(if local0
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 21 7 81 34 105 35 116 38 125 37 144 23 173 30 209 20 266 33 282 27 267 6
						yourself:
					)
			)
			(upDoor
				setLoop: 0 1
				setCel: 0
				posn: 289 29
				signal: (| (upDoor signal:) $4000)
				init:
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 301 136 256 105 254 113 207 119 172 108 151 114 126 108 124 99 86 101 11 136
						yourself:
					)
			)
			(aDoor setLoop: 0 1 setCel: 0 init:)
			(if (== gChapter 5)
				(aDoor setPri: 200)
			)
		)
		(officeDoor init:)
		(thePortrait init:)
		(super init:)
		(if (not (gCurRoom script:))
			(gGame handsOn:)
		)
		(if local0
			(gEgo disableHotspot:)
			(SetFlag 338)
		)
	)

	(method (dispose)
		(gEgo enableHotspot:)
		(ClearFlag 338)
		(super dispose:)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load 140 801) ; WAVE
					(gEgo setMotion: PolyPath 253 104 self)
				)
				(1
					(statue setPri: 132)
					(drawer setPri: 131)
					(gEgo
						view: 8121
						loop: 0
						cel: 0
						posn: 251 104
						setPri: 130
						setCycle: CT 14 1 self
					)
				)
				(2
					(spitSound number: 801 loop: 1 play:)
					(gEgo cel: 14 setCycle: End)
					(aDoor cel: 0 loop: 0 setCycle: CT 18 1 self)
				)
				(3
					(aDoor setPri: 200)
					(gEgo
						posn: 256 104
						setPri: 100
						normalize:
						setMotion: MoveTo 288 106 self
					)
					(Load 140 802) ; WAVE
				)
				(4
					(aDoor cel: 18 setCycle: End self)
				)
				(5
					(spitSound number: 802 loop: 1 play: self)
				)
				(6
					(gCurRoom newRoom: 5150)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gCurRoom newRoom: 5150)
				)
			)
		)
	)
)

(instance sExitUp of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load 140 801) ; WAVE
					(gEgo setMotion: MoveTo 254 37 self)
				)
				(1
					(gEgo
						view: 5225
						loop: 0
						cel: 0
						posn: 252 37
						setPri: 130
						setCycle: CT 14 1 self
					)
				)
				(2
					(spitSound number: 801 loop: 1 play:)
					(gEgo cel: 14 setCycle: End)
					(upDoor cel: 0 loop: 0 setCycle: CT 18 1 self)
				)
				(3
					(upDoor setPri: 200)
					(gEgo
						posn: 256 36
						setPri: 100
						normalize: 0 5229
						setMotion: MoveTo 288 38 self
					)
					(Load 140 802) ; WAVE
				)
				(4
					(upDoor cel: 18 setCycle: End self)
				)
				(5
					(spitSound number: 802 loop: 1 play: self)
				)
				(6
					(gCurRoom newRoom: 5150)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gCurRoom newRoom: 5150)
				)
			)
		)
	)
)

(instance sMirrorBump of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load rsSOUND 5253)
					(= cycles 2)
				)
				(1
					(gEgo
						view: 5257
						setScale: 0
						loop: 0
						cel: 0
						posn: 117 101
						setCycle: End self
					)
					(spitSound number: 5253 loop: 1 play:)
				)
				(2
					(spitSound stop:)
					((ScriptID 13) hide_mouth: 1) ; aEgoTalker
					(gMessager say: 1 0 1 0 self) ; "Ow! That must not be a two-way mirror."
				)
				(3
					((ScriptID 13) hide_mouth: 0) ; aEgoTalker
					(gEgo
						posn: 126 100
						normalize: 3
						setScaler: Scaler 106 70 137 113
						setHeading: 180 self
					)
				)
				(4
					(gEgo setMotion: MoveTo 118 103 self)
				)
				(5
					(theMirror approachX: 114)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo setScaler: Scaler 106 70 137 113 normalize: 2)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sMirrorFeel of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 5257
						loop: 1
						cel: 0
						posn: 116 102
						setScale: 0
						setCycle: End self
					)
				)
				(1
					(gEgo
						normalize:
						setScaler: Scaler 106 70 137 113
						setHeading: 180 self
					)
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
					(gEgo setScaler: Scaler 106 70 137 113 normalize: 2)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sMirrorSpits of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(IsFlag 267)
				(IsFlag 124)
				(> state 0)
				(< (statue y:) 111)
				(!= (statue moveSpeed:) 0)
			)
			(-- local1)
			(statue moveSpeed: local1)
		)
	)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load rsSOUND 2451)
					(if (and (IsFlag 124) (IsFlag 267))
						(Load 140 830) ; WAVE
					)
					(= cycles 4)
				)
				(1
					(if (and (IsFlag 124) (IsFlag 267))
						(= local1 (statue moveSpeed:))
						(sealSound number: 848 loop: 1 play: self)
						(statue
							moveSpeed: 25
							ignoreActors: 1
							setMotion: MoveTo 233 109
						)
					else
						(= cycles 1)
					)
				)
				(2
					(if (and (IsFlag 124) (IsFlag 267))
						(sealSound number: 817 loop: 1 play: self)
					else
						(= cycles 1)
					)
				)
				(3
					(spitSound number: 2451 loop: 1 play:)
					(gEgo loop: 0 cel: 0 setCycle: End self)
				)
				(4
					(gEgo loop: 1 cel: 0 posn: 108 110 setCycle: End self)
				)
				(5
					(gEgo
						posn: 110 108
						setScaler: Scaler 106 70 137 113
						normalize: 2
					)
					(gGame handsOn:)
					(ClearFlag 267)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo normalize: 2)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sEnterFromStairs of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						normalize: 0
						posn: 253 111
						setMotion: MoveTo 248 124 self
					)
				)
				(1
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo normalize: 2 posn: 175 115)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sEnterUpsideDown of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						normalize: 1 5229
						posn: 253 27
						setMotion: MoveTo 248 28 self
					)
				)
				(1
					(upDoor setPri: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo normalize: 2 posn: 175 115)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sLookAtPortrait of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo normalize: 1)
					(gMessager say: 2 8 0 0 self) ; "(THINKS TO HERSELF) Arch-Duke Fifi, you look every bit as silly on canvas as you od in person."
				)
				(1
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo normalize: 2)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sLookAtPortraitUpside of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo view: 5225 loop: 4 cel: 0 setCycle: End self)
				)
				(1
					(gEgo loop: 2 normalize: 2 5229)
					(= cycles 3)
				)
				(2
					((ScriptID 13) hide_mouth: 1) ; aEgoTalker
					(gMessager say: 2 8 0 0 self) ; "(THINKS TO HERSELF) Arch-Duke Fifi, you look every bit as silly on canvas as you od in person."
				)
				(3
					((ScriptID 13) hide_mouth: 0) ; aEgoTalker
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo normalize: 2)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sLaughMirror of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load 140 5004) ; WAVE
					(= cycles 2)
				)
				(1
					(spitSound number: 5004 loop: 1 play:)
					(gEgo view: 5225 loop: 6 cel: 0 setCycle: End self)
				)
				(2
					(gEgo normalize: 2 5229)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo normalize: 2)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance openTheDrawer of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (IsFlag 124)
						(Load rsSOUND 5255)
						(= cycles 2)
					else
						(Load 140 830) ; WAVE
						(= cycles 2)
					)
				)
				(1
					(Load rsVIEW 5261)
					(Load rsVIEW 5251)
					(= cycles 1)
				)
				(2
					(cond
						((IsFlag 124)
							(drawerSound number: 5255 loop: 1 play:)
							(gEgo
								view: 5261
								loop: 1
								cel: 0
								setScale: 0
								posn: 253 117
								setCycle: End self
							)
						)
						((and (not (gEgo has: 47)) (not (IsFlag 123))) ; Magic_Statue
							(drawerSound number: 5254 loop: 1 play:)
							(theDrawer dispose:)
							(gEgo
								view: 5261
								loop: 0
								cel: 0
								setScale: 0
								posn: 244 109
								setCycle: End self
							)
						)
						(else
							(= cycles 1)
						)
					)
				)
				(3
					(drawerSound stop:)
					(if (IsFlag 124)
						(= cycles 1)
					else
						(if (and (not (gEgo has: 47)) (not (IsFlag 123))) ; Magic_Statue
							(statue setPri: 110 init:)
						)
						(= cycles 3)
					)
				)
				(4
					(if (not (IsFlag 124))
						(gEgo posn: 262 116)
						(SetFlag 124)
						(drawer setPri: 109 init:)
					)
					(gEgo
						normalize: 1
						setScaler: Scaler 106 70 137 113
						setHeading: 180 self
					)
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
					(drawerSound stop:)
					(gEgo setScaler: Scaler 106 70 137 113 normalize: 2)
					(drawerSound stop:)
					(sealSound stop:)
					(if (not (IsFlag 124))
						(SetFlag 124)
						(if (and (not (gEgo has: 47)) (not (IsFlag 123))) ; Magic_Statue
							(statue setPri: 110 init:)
							(drawer init:)
							(theDrawer dispose:)
						)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance openTheDrawerUpside of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and local0 (< (statue y:) 140) (!= (statue moveSpeed:) 0))
			(-- local1)
			(statue moveSpeed: local1)
		)
	)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= local2 0)
					(if (IsFlag 124)
						(Load rsSOUND 5255)
						(= cycles 2)
					else
						(Load rsSOUND 817)
						(Load rsSOUND 848)
						(Load rsSOUND 5254)
						(= cycles 1)
					)
				)
				(1
					(Load rsVIEW 5259)
					(Load rsVIEW 5226)
					(= cycles 1)
				)
				(2
					(cond
						((IsFlag 124)
							(drawerSound number: 5255 loop: 1 play:)
							(gEgo
								view: 5259
								loop: 2
								cel: 0
								setScale: 0
								posn: 260 26
								setCycle: End self
							)
						)
						((and (not (gEgo has: 47)) (not (IsFlag 123))) ; Magic_Statue
							(drawerSound number: 5254 loop: 1 play:)
							(theDrawer dispose:)
							(gEgo
								view: 5259
								loop: 0
								cel: 0
								setScale: 0
								posn: 260 26
								setCycle: End self
							)
						)
						(else
							(= cycles 1)
						)
					)
				)
				(3
					(drawerSound stop:)
					(if (IsFlag 124)
						(= cycles 1)
					else
						(if (and (not (gEgo has: 47)) (not (IsFlag 123))) ; Magic_Statue
							(statue setPri: 1 init:)
						)
						(SetFlag 267)
						(= local1 (statue moveSpeed:))
						(statue
							moveSpeed: 25
							ignoreActors: 1
							ignoreHorizon: 1
							setMotion: MoveTo 232 140
						)
						(sealSound number: 848 loop: 1 play: self)
						(Load rsSOUND 817)
						(= cycles 4)
					)
				)
				(4
					(if (IsFlag 124)
						(= cycles 1)
					else
						(spitSound number: 817 loop: 1 play:)
					)
				)
				(5
					(if (not (IsFlag 124))
						(SetFlag 124)
						(drawer
							view: 5259
							setLoop: 1 1
							cel: 0
							posn: 260 26
							setPri: 2
							init:
						)
					)
					(gEgo
						posn: 260 26
						normalize: 1 5229
						setScaler: Scaler 58 75 43 25
						setHeading: 180 self
					)
				)
				(6
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(drawerSound stop:)
					(gEgo setScaler: Scaler 58 75 43 25 normalize: 2 5229)
					(drawerSound stop:)
					(sealSound stop:)
					(if (not (IsFlag 124))
						(SetFlag 124)
						(if (and (not (gEgo has: 47)) (not (IsFlag 123))) ; Magic_Statue
							(statue setPri: 110 init:)
							(drawer init:)
							(theDrawer dispose:)
						)
						(if local0
							(statue posn: 232 13)
						)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sJumpForIt of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo view: 5227 loop: 0 cel: 0 setCycle: CT 16 1 self)
				)
				(1
					(sealSound number: 817 loop: 1 play:)
					(gEgo loop: 0 cel: 16 setCycle: End self)
				)
				(2
					(gEgo
						posn: (- (gEgo x:) 3) (gEgo y:)
						normalize: 2 5229
					)
					(= cycles 2)
				)
				(3
					((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
					(gMessager say: 3 0 2 0 self) ; "Blast. I can't reach it!"
				)
				(4
					((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo normalize: 2)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sGetIt of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setHeading: 315 self)
				)
				(1
					(Load rsVIEW 8075)
					(= cycles 3)
				)
				(2
					(SetFlag 123)
					(gEgo
						view: 8075
						loop: 1
						cel: 0
						posn: 249 115
						setCycle: End self
					)
					(gEgo get: 47) ; Magic_Statue
					(statue dispose:)
				)
				(3
					(gEgo y: 116 normalize: setHeading: 180 self)
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
					(if (not (gEgo has: 47)) ; Magic_Statue
						(gEgo get: 47) ; Magic_Statue
					)
					(if (gCast contains: statue)
						(statue dispose:)
					)
					(gEgo normalize: 2)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance statue of Actor
	(properties
		approachX 249
		approachY 116
		x 233
		y 109
		z 12
		view 5251
		loop 3
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
		(if local0
			(= view 5226)
			(= loop 0)
			(if (IsFlag 267)
				(= y 134)
			else
				(= y 50)
			)
			(= approachY 48)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if local0
					(gCurRoom setScript: sJumpForIt)
				else
					(gCurRoom setScript: sGetIt)
				)
			)
		)
	)
)

(instance aDoor of Prop
	(properties
		x 267
		y 108
		view 5253
	)
)

(instance upDoor of Prop
	(properties
		x 289
		y 31
		view 5228
	)
)

(instance theMirror of View
	(properties
		approachX 122
		approachY 101
		x 121
		y 84
		view 5251
		loop 5
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
		(if local0
			(= view 5226)
			(= loop 2)
			(= y 53)
			(= approachY 33)
		)
		(if (IsFlag 147)
			(= approachX 114)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(cond
				(local0
					(Load rsSOUND 5004)
					(gCurRoom setScript: sLaughMirror)
				)
				((not (IsFlag 147))
					(= approachX 114)
					(Load rsSOUND 5253)
					(SetFlag 147)
					(gCurRoom setScript: sMirrorBump)
				)
				(else
					(gCurRoom setScript: sMirrorFeel)
				)
			)
		)
	)
)

(instance drawer of View
	(properties
		approachX 262
		approachY 116
		x 244
		y 109
		view 5261
		loop 2
	)

	(method (init)
		(super init:)
		(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		(if local0
			(= view 5259)
			(= loop 1)
			(= approachY 48)
			(= y 26)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					(local0
						(gEgo setScript: openTheDrawerUpside)
					)
					(
						(and
							(IsFlag 124)
							(not (IsFlag 267))
							(not (IsFlag 123))
						)
						(gCurRoom setScript: sGetIt)
					)
					(else
						(gEgo setScript: openTheDrawer)
					)
				)
			)
		)
	)
)

(instance theDrawer of Feature
	(properties
		approachX 240
		approachY 116
		x 220
		y 90
	)

	(method (init)
		(super init:)
		(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		(if local0
			(= approachY 48)
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 209 26 211 53 242 56 242 35
						yourself:
					)
			)
		else
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 219 89 217 100 237 97 236 86
						yourself:
					)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if local0
					(gEgo setScript: openTheDrawerUpside)
				else
					(Load rsVIEW 8071)
					(gEgo setScript: openTheDrawer)
				)
			)
		)
	)
)

(instance thePortrait of Feature
	(properties
		nsLeft 36
		nsTop 33
		nsRight 53
		nsBottom 65
		approachX 69
		approachY 110
		x 50
		y 110
	)

	(method (init)
		(super init:)
		(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		(if local0
			(= nsTop 72)
			(= nsLeft 35)
			(= nsBottom 115)
			(= nsRight 66)
			(= approachX 53)
			(= approachY 16)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(self setHotspot: 0)
				(if local0
					(gEgo setScript: sLookAtPortraitUpside)
				else
					(gEgo setScript: sLookAtPortrait)
				)
			)
		)
	)
)

(instance officeDoor of ExitFeature
	(properties
		approachX 252
		approachY 99
		x 270
		y 116
		exitDir 2
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
		(if local0
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 273 36 266 70 264 91 273 99 291 102 299 70 299 56 291 30
						yourself:
					)
			)
			(= approachX 252)
			(= approachY 36)
		else
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 267 104 261 45 287 34 297 50 296 94 287 111
						yourself:
					)
			)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(Load rsVIEW 5253)
			(if local0
				(gCurRoom setScript: sExitUp)
			else
				(gCurRoom setScript: sExit)
			)
		)
	)
)

(instance officeSound of Sound ; UNUSED
	(properties)
)

(instance sealSound of Sound
	(properties)
)

(instance spitSound of Sound
	(properties)
)

(instance drawerSound of Sound
	(properties)
)

