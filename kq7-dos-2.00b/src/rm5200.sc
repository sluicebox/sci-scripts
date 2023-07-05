;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5200)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Inset)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Rev)
(use Sound)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm5200 0
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

(instance rm5200 of KQRoom
	(properties
		picture 5200
	)

	(method (init)
		(= local8 0)
		(Load rsSOUND 5200)
		(super init:)
		(Load rsVIEW 5203 5205)
		(SetFlag 21)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 241 109 308 138 60 140 56 124 85 119 95 110
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 88 120 149 114 216 120 199 135 101 135
					yourself:
				)
		)
		(gKqMusic1 number: 5200 loop: -1 play:)
		(Load rsMESSAGE 5200)
		(statue init:)
		(statueBase init:)
		(if (or (== gValOrRoz -3) (> gChapter 3)) ; Roz
			(SetFlag 338)
			((gInventory at: 53) setHotspot: 8 10) ; Magic_Wand, Do, Exit
			((gInventory at: 55) setHotspot: 8 10) ; Scarab, Do, Exit
			(boards signal: (| (boards signal:) $1000) init:)
		else
			(exitMirror init:)
		)
		(mirror1 init:)
		(mirror2 init:)
		(mirror3 init:)
		(mirror4 init:)
		(door init:)
		(theDoor init:)
		(if (and (IsFlag 169) (== gValOrRoz -3)) ; Roz
			(grapes init:)
		)
		(fountain setPri: 130 init:)
		(fountain1 setPri: 129 init:)
		(fountainFeat init:)
		(gEgo init: normalize: 2 setScaler: Scaler 94 73 137 107)
		(switch gPrevRoomNum
			(5150
				(gEgo posn: 98 111)
				(gCurRoom setScript: sComeIn)
			)
			(5250
				(gEgo posn: 211 115)
			)
			(23 ; selectGameRoom
				(gEgo normalize:)
			)
			(else
				(gEgo posn: 175 115)
			)
		)
		(if (not (gCurRoom script:))
			(gGame handsOn:)
		)
	)

	(method (notify)
		(gCurRoom setScript: sDoTransfer)
	)

	(method (doVerb)
		(if (== (gCurRoom script:) sitDown)
			(= local4 10)
			(= local2 ((gUser curEvent:) x:))
			(= local3 ((gUser curEvent:) y:))
			(gCurRoom setScript: getUp 0 self)
			(return 1)
		)
	)
)

(instance sComeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(theDoor setPri: 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (== gValOrRoz -3) ; Roz
						(gEgo setMotion: PolyPath 102 110 self)
					else
						(= cycles 1)
					)
				)
				(1
					(if (== gValOrRoz -3) ; Roz
						(Load rsVIEW 8483)
					else
						(Load rsVIEW 8123)
					)
					(gEgo setHeading: 315 self)
					(Load 140 801) ; WAVE
				)
				(2
					(if (== gValOrRoz -3) ; Roz
						(gEgo
							view: 8483
							loop: 0
							cel: 0
							posn: 100 110
							setCycle: CT 3 1 self
						)
					else
						(gEgo
							view: 8123
							loop: 0
							cel: 0
							posn: 113 109
							setCycle: CT 3 1 self
						)
					)
				)
				(3
					(doorSound number: 801 loop: 1 play:)
					(theDoor setCycle: End self)
					(gEgo setCycle: End self)
				)
				(4
					(theDoor setPri: 114)
					(gEgo setCycle: 0 normalize: 3)
					(Load 140 802) ; WAVE
					(= cycles 1)
				)
				(5
					(if (== gValOrRoz -3) ; Roz
						(gEgo posn: 113 109)
					)
					(gEgo setMotion: MoveTo 96 99 self)
				)
				(6
					(theDoor setCycle: Beg self)
				)
				(7
					(doorSound number: 802 loop: 1 play: self)
				)
				(8
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

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (== gValOrRoz -3) ; Roz
						(gEgo setMotion: MoveTo 70 115 self)
					else
						(gEgo setMotion: MoveTo 69 117 self)
					)
				)
				(1
					(if (== gValOrRoz -3) ; Roz
						(SetFlag 338)
						((gInventory at: 53) setHotspot: 8 10) ; Magic_Wand, Do, Exit
						((gInventory at: 55) setHotspot: 8 10) ; Scarab, Do, Exit
						(Load rsVIEW 8552)
					else
						(Load rsVIEW 8192)
					)
					(= local1 1)
					(statueBase sightAngle: 300)
					(statue sightAngle: 300)
					(cherubMirror sightAngle: 300)
					(mirror1 sightAngle: 300)
					(mirror2 sightAngle: 300)
					(mirror3 sightAngle: 300)
					(mirror4 sightAngle: 300)
					(exitMirror sightAngle: 300)
					(door sightAngle: 300)
					(grapes sightAngle: 300)
					(= cycles 2)
				)
				(2
					(if (== gValOrRoz -3) ; Roz
						(gEgo view: 8552 loop: 0 cel: 0 setCycle: End self)
					else
						(gEgo view: 8192 loop: 0 cel: 0 setCycle: End self)
					)
				)
				(3
					(if (not (== gValOrRoz -3)) ; Roz
						((ScriptID 13) view: 8192) ; aEgoTalker
						(gMessager say: 3 8 1 0 self) ; "Aaaaahh."
					else
						(= cycles 1)
					)
				)
				(4
					((ScriptID 13) view: -1 mouth_x: -999 mouth_y: -999) ; aEgoTalker
					(gGame handsOn:)
					(Load rsVIEW 8562)
					(gUser canControl: 0)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(= local1 1)
					(gGame handsOn:)
					(gUser canControl: 0)
				)
			)
		)
	)
)

(instance getUp of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= local1 0)
					(statueBase sightAngle: 40)
					(statue sightAngle: 40)
					(cherubMirror sightAngle: 40)
					(mirror1 sightAngle: 40)
					(mirror2 sightAngle: 40)
					(mirror3 sightAngle: 40)
					(mirror4 sightAngle: 40)
					(exitMirror sightAngle: 40)
					(door sightAngle: 40)
					(grapes sightAngle: 40)
					(if (and (== gValOrRoz -3) local7 (not (IsFlag 283))) ; Roz
						((gInventory at: 53) setHotspot: 8 10 74) ; Magic_Wand, Do, Exit, Scarab
						((gInventory at: 55) setHotspot: 8 10 69) ; Scarab, Do, Exit, Magic_Wand
					)
					(gEgo
						loop: (gEgo loop:)
						posn: (gEgo x:) (gEgo y:)
						cel: (gEgo lastCel:)
						setCycle: Beg self
					)
				)
				(1
					(gEgo normalize: 2)
					(gEgo setMotion: MoveTo 96 118 self)
				)
				(2
					(if (not register)
						(= cycles 1)
					else
						(switch register
							(gCurRoom
								(gEgo setMotion: PolyPath local2 local3 self)
							)
							(else
								(gEgo
									setMotion:
										PolyPath
										(register approachX:)
										(register approachY:)
										self
								)
							)
						)
					)
				)
				(3
					(cond
						((not register)
							(= cycles 1)
						)
						((!= register gCurRoom)
							(proc11_3 gEgo register self)
						)
						(else
							(= cycles 1)
						)
					)
				)
				(4
					(cond
						((not register)
							(gGame handsOn:)
						)
						((and (!= register gCurRoom) (!= register gEgo))
							(register doVerb: local4)
						)
						(else
							(gGame handsOn:)
						)
					)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gEgo normalize: 2)
					(if (== register gCurRoom)
						(gEgo setMotion: PolyPath local2 local3)
						(gGame handsOn:)
						(self dispose:)
					else
						(gEgo
							setMotion:
								PolyPath
								(register approachX:)
								(register approachY:)
								self
						)
					)
				)
				(1
					(SetFlag 539)
					(= local1 0)
					(register doVerb: local4)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance enterMirror of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(image
						view: 5205
						setLoop: 0
						setCel: 0
						posn: 207 95
						setPri: 100
						init:
						setCycle: End self
					)
					(gEgo setHeading: 270)
				)
				(1
					(image setLoop: 1 setCel: 0 posn: 210 95 setCycle: End self)
					(mirrorSound number: 2453 loop: 1 play:)
				)
				(2
					(gEgo hide:)
					(image
						setLoop: 2
						setCel: 0
						posn: 211 96
						setPri: 105
						setCycle: CT 2 1 self
					)
				)
				(3
					(mirrorSound number: 2454 loop: 1 play:)
					(image setLoop: 2 setCel: 2 posn: 211 96 setCycle: End self)
				)
				(4
					(gCurRoom newRoom: 5250)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gCurRoom newRoom: 5250)
				)
			)
		)
	)
)

(instance lookMirror1 of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (== gValOrRoz -3) ; Roz
						(Load rsVIEW 8385)
						(Load rsVIEW 5220)
					else
						(Load rsVIEW 8025)
						(Load rsVIEW 5203)
					)
					(gKqMusic1 stop:)
					(mirrorSound number: 5221 loop: 1 play:)
					(if (== gValOrRoz -3) ; Roz
						(image
							view: 5220
							posn: 133 77
							setLoop: 0
							setCel: 0
							init:
							setCycle: End self
						)
					else
						(image
							view: 5203
							setLoop: 0
							setCel: 0
							posn: 133 77
							init:
							setCycle: End self
						)
					)
				)
				(1
					(gKqMusic1 play:)
					(if (== gValOrRoz -3) ; Roz
						(gEgo view: 8385)
					else
						(gEgo view: 8025)
					)
					(gEgo
						setLoop: 0
						setCel: 0
						posn: 114 116
						setCycle: End self
					)
				)
				(2
					(= cycles 30)
				)
				(3
					(image setCycle: Beg self)
				)
				(4
					(mirrorSound stop:)
					(if (== gValOrRoz -3) ; Roz
						(gEgo posn: 96 118)
					else
						(gEgo posn: 105 121)
					)
					(image dispose:)
					(gEgo normalize: 6)
					(= cycles 12)
				)
				(5
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(mirrorSound stop:)
					(ClearFlag 539)
					(gEgo normalize: 6 posn: 105 118)
					(image dispose:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance lookMirror2 of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (== gValOrRoz -3) ; Roz
						(Load rsVIEW 8385)
						(Load rsVIEW 5220)
					else
						(Load rsVIEW 8025)
						(Load rsVIEW 5203)
					)
					(= cycles 1)
				)
				(1
					(gKqMusic1 stop:)
					(mirrorSound number: 5222 loop: 1 play:)
					(if (== gValOrRoz -3) ; Roz
						(image
							view: 5220
							setLoop: 1
							setCel: 0
							posn: 167 81
							init:
							setCycle: End self
						)
					else
						(image
							view: 5203
							setLoop: 1
							setCel: 0
							posn: 167 81
							init:
							setCycle: End self
						)
					)
				)
				(2
					(gKqMusic1 play:)
					(if (== gValOrRoz -3) ; Roz
						(gEgo view: 8385)
					else
						(gEgo view: 8025)
					)
					(gEgo
						setLoop: 0
						setCel: 0
						posn: 157 113
						setCycle: End self
					)
				)
				(3
					(= cycles 30)
				)
				(4
					(image setCycle: Beg self)
				)
				(5
					(mirrorSound stop:)
					(if (== gValOrRoz -3) ; Roz
						(gEgo posn: 137 113)
					else
						(gEgo posn: 145 115)
					)
					(image dispose:)
					(gEgo normalize: 6)
					(= cycles 6)
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
					(mirrorSound stop:)
					(image dispose:)
					(gEgo normalize: 6 posn: 157 113)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance lookMirror3 of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (== gValOrRoz -3) ; Roz
						(Load rsVIEW 8385)
						(Load rsVIEW 5220)
					else
						(Load rsVIEW 8025)
						(Load rsVIEW 5203)
					)
					(= cycles 2)
				)
				(1
					(gKqMusic1 stop:)
					(mirrorSound number: 5223 loop: 1 play:)
					(if (== gValOrRoz -3) ; Roz
						(image
							view: 5220
							setLoop: 2
							setCel: 0
							posn: 268 80
							init:
							setCycle: End self
						)
					else
						(image
							view: 5203
							setLoop: 2
							setCel: 0
							posn: 268 80
							init:
							setCycle: End self
						)
					)
				)
				(2
					(gKqMusic1 play:)
					(if (== gValOrRoz -3) ; Roz
						(gEgo view: 8385)
					else
						(gEgo view: 8025)
					)
					(gEgo setLoop: 0 setCel: 0 setCycle: End self)
				)
				(3
					(= cycles 30)
				)
				(4
					(image setCycle: Beg self)
				)
				(5
					(mirrorSound stop:)
					(if (== gValOrRoz -3) ; Roz
						(gEgo posn: 225 122)
					else
						(gEgo posn: 236 121)
					)
					(image dispose:)
					(gEgo normalize: 6)
					(= cycles 6)
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
					(mirrorSound stop:)
					(image dispose:)
					(gEgo normalize: 6 posn: 238 121)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance lookMirror4 of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (== gValOrRoz -3) ; Roz
						(Load rsVIEW 8384)
						(Load rsVIEW 5220)
					else
						(Load rsVIEW 8025)
						(Load rsVIEW 5203)
					)
					(= cycles 2)
				)
				(1
					(gKqMusic1 stop:)
					(mirrorSound number: 5224 loop: 1 play:)
					(if (== gValOrRoz -3) ; Roz
						(image
							view: 5220
							setLoop: 3
							setCel: 0
							posn: 302 85
							setPri: 20
							init:
							setCycle: End self
						)
					else
						(image
							view: 5203
							setLoop: 3
							setCel: 0
							posn: 302 85
							setPri: 20
							init:
							setCycle: End self
						)
					)
				)
				(2
					(gKqMusic1 play:)
					(if (== gValOrRoz -3) ; Roz
						(gEgo view: 8384)
					else
						(gEgo view: 8021)
					)
					(gEgo setLoop: 0 setCel: 0 setCycle: End self)
				)
				(3
					(= cycles 30)
				)
				(4
					(image setCycle: Beg self)
				)
				(5
					(mirrorSound stop:)
					(if (== gValOrRoz -3) ; Roz
						(gEgo posn: 244 129)
					else
						(gEgo posn: 243 129)
					)
					(image dispose:)
					(gEgo normalize: 0)
					(= cycles 6)
				)
				(6
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(mirrorSound stop:)
					(image dispose:)
					(gEgo normalize: 0 posn: 253 129)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sFussWithHair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gValOrRoz -3) ; Roz
					(Load rsVIEW 5218)
				else
					(Load rsVIEW 5201)
				)
				(= cycles 1)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gGame handsOff:)
				(if (== gValOrRoz -3) ; Roz
					(gEgo view: 5218)
				else
					(gEgo view: 5201)
				)
				(gEgo setCel: 0 setLoop: 0 posn: 69 121 setCycle: End self)
			)
			(3
				(gEgo
					posn: 67 119
					setScaler: Scaler 94 73 137 107
					normalize: 7
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPolish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 168)
				(Load rsVIEW 5207)
				(gEgo setMotion: MoveTo 69 115 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gEgo
					view: 5207
					posn: 69 115
					cel: 12
					loop: 0
					setCycle: CT 20 1 self
				)
			)
			(3
				(gEgo cel: 20 loop: 0 setCycle: CT 12 -1 self)
			)
			(4
				(gEgo cel: 12 loop: 0 setCycle: CT 20 1 self)
			)
			(5
				(gEgo cel: 22 loop: 0 setCycle: CT 23 1 self)
			)
			(6
				(gEgo
					view: 836
					setLoop: 3 1
					setScaler: Scaler 94 73 137 107
					setCycle: Rev
					setMotion: MoveTo 71 126 self
				)
			)
			(7
				(gEgo normalize: 3)
				(gMessager say: 2 84 6 0 self) ; "That's doing the trick. I'll bet you could scour pots with this nasty old stocking."
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPullGrapes of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gMessager say: 4 8 0 1 self) ; "Why, those are golden grapes! I wonder..."
				)
				(1
					(gEgo
						view: 5209
						loop: 0
						cel: 0
						posn: 228 116
						setCycle: Osc 1 self
					)
				)
				(2
					(gEgo
						posn: 228 116
						normalize: 0
						setScaler: Scaler 94 73 137 107
						setHeading: 45 self
					)
				)
				(3
					(gMessager say: 4 8 0 2 self) ; "Oh, drat! I can't pull it loose."
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
					(gEgo normalize: 2)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sChiselGrape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 5210)
				(Load 140 874) ; WAVE
				(Load rsSOUND 819)
				(= cycles 2)
			)
			(1
				(gEgo
					view: 5210
					loop: 0
					posn: 229 117
					cel: 0
					setCycle: End self
				)
				(statueSound number: 874 loop: 1 play:)
			)
			(2
				(statueSound number: 819 loop: 1 play:)
				(gEgo
					view: 5210
					loop: 1
					posn: 229 117
					cel: 0
					get: 64 ; Golden_Grape
					setCycle: End self
				)
			)
			(3
				(grapes dispose:)
				(= local8 1)
				(gEgo
					loop: 5
					posn: 231 117
					normalize: 2
					setScaler: Scaler 94 73 137 107
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGrapeStatue of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load 140 5228) ; WAVE
					(= local7 1)
					(fountain approachVerbs: 8 10 75 setHotspot: 8 10 75) ; Do, Exit, Shovel, Do, Exit, Shovel
					(fountain1 approachVerbs: 8 10 75 setHotspot: 8 10 75) ; Do, Exit, Shovel, Do, Exit, Shovel
					(mirror1 dispose:)
					(mirror2 dispose:)
					(gEgo
						view: 8461
						loop: 1
						cel: 0
						put: 64 ; Golden_Grape
						setCycle: End self
					)
				)
				(1
					(gEgo normalize: 1 setHeading: 135 self)
				)
				(2
					(Load rsSOUND 889)
					(Load 140 2616) ; WAVE
					(= cycles 1)
				)
				(3
					(statueSound number: 889 loop: 1 play:)
					(image
						view: 5211
						loop: 1
						cel: 0
						posn: 53 67
						init:
						setCycle: CT 7 1 self
					)
				)
				(4
					(statueSound number: 2616 loop: 1 play:)
					(image loop: 1 cel: 7 setCycle: CT 16 1 self)
				)
				(5
					(statueSound number: 2616 loop: 1 play:)
					(image loop: 1 cel: 16 setCycle: CT 22 1 self)
				)
				(6
					(statueSound number: 2616 loop: 1 play:)
					(image loop: 1 cel: 22 setCycle: End self)
				)
				(7
					(image hide: dispose:)
					(= cycles 2)
				)
				(8
					(statueSound number: 2509 loop: 1 play: self)
					(Load rsSOUND 5229)
					(Load rsVIEW 5211)
				)
				(9
					(gEgo setMotion: MoveTo (+ (gEgo x:) 10) 137 self)
				)
				(10
					(gEgo setMotion: PolyPath 153 137 self)
				)
				(11
					(gEgo setHeading: 360 self)
				)
				(12
					(statueSound number: 5229 loop: 1 play:)
					(mirror1 init:)
					(mirror2 init:)
					(fountain
						view: 5211
						setLoop: 2 1
						setCel: 0
						ignoreActors: 1
						setCycle: CT 1 1 self
					)
					(fountain1
						view: 5200
						setLoop: 3 1
						setCel: 0
						setPri: 129
						ignoreActors: 1
						setCycle: End
					)
				)
				(13
					(gMessager say: 1 88 0 0 self) ; "(EXCITED)That's it! That must be the entrance to the Vulcanix Underground!"
				)
				(14
					(ClearFlag 338)
					(if (not (IsFlag 283))
						((gInventory at: 53) setHotspot: 8 10 74) ; Magic_Wand, Do, Exit, Scarab
						((gInventory at: 55) setHotspot: 8 10 69) ; Scarab, Do, Exit, Magic_Wand
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance tryToOpenFountain of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load rsVIEW 5212)
					(gEgo setMotion: MoveTo 135 137 self)
				)
				(1
					(gEgo setHeading: 90 self)
				)
				(2
					(gEgo
						view: 5212
						posn: 134 143
						loop: 0
						cel: 0
						setCycle: CT 14 1 self
					)
				)
				(3
					(gEgo
						view: 5212
						posn: 134 143
						loop: 0
						cel: 14
						setCycle: Beg self
					)
				)
				(4
					(gEgo posn: 135 137 normalize: 0 setHeading: 45 self)
				)
				(5
					(if (not local6)
						(= local6 1)
						(gMessager say: 5 8 2 0 self) ; "(FRANTIC)I'm just not strong enough to do it!"
					else
						(= cycles 1)
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
					(gEgo normalize: 2)
					(ClearFlag 539)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance useShovel of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load rsVIEW 5212)
					(gEgo setHeading: 90 self)
				)
				(1
					(gEgo
						view: 5212
						posn: 125 137
						loop: 1
						cel: 0
						setCycle: CT 5 1 self
					)
				)
				(2
					(statueSound number: 23010 loop: 1 play: self)
					(gEgo
						view: 5212
						posn: 125 137
						loop: 1
						cel: 5
						setCycle: End self
					)
				)
				(3
					(gEgo view: 5212 loop: 1 cel: 11 setCycle: CT 5 -1 self)
				)
				(4
					(statueSound stop:)
					(gEgo view: 5212 loop: 1 cel: 5 setCycle: Beg self)
				)
				(5
					(gEgo posn: 126 137 normalize: 0 setHeading: 45 self)
				)
				(6
					(if (not local6)
						(= local6 1)
						(gMessager say: 5 8 2 0 self) ; "(FRANTIC)I'm just not strong enough to do it!"
					else
						(= cycles 1)
					)
				)
				(7
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

(instance sDoTransfer of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load rsVIEW 5213)
					(Load rsSOUND 5230)
					(= local0 1)
					(gEgo setMotion: PolyPath 104 124 self)
				)
				(1
					(gEgo
						view: 5213
						loop: 0
						cel: 0
						posn: 98 127
						setScale: 0
						setCycle: End self
					)
				)
				(2
					(Load rsVIEW 5215)
					(statueSound number: 5230 loop: 1 play:)
					(Load rsSOUND 4409)
					(= cycles 4)
				)
				(3
					(zap
						view: 5213
						loop: 1
						cel: 0
						posn: 84 132
						setPri: 200
						init:
						setCycle: End self
					)
					(trollKing
						loop: 0
						cel: 0
						posn: 84 133
						setPri: 256
						init:
						setCycle: End
					)
					(mirrorSound number: 4409 loop: 1 play:)
				)
				(4
					(statueSound stop:)
					(zap dispose:)
					(gEgo
						view: 5213
						loop: 0
						posn: 98 127
						cel: 8
						setCycle: Beg self
					)
					(trollKing loop: 1 cel: 0 setCycle: End)
				)
				(5
					(= local0 1)
					(Load 140 5229) ; WAVE
					(gEgo
						posn: 103 122
						normalize: 1
						setScaler: Scaler 94 73 137 107
					)
					(= cycles 10)
				)
				(6
					(gMessager say: 0 0 4 1 self) ; "Quickly, your majesty! The doorway is stuck partway open! Hurry, before that horrible gargoyle finds us!"
				)
				(7
					(gEgo setMotion: MoveTo 49 137 self)
				)
				(8
					(gEgo setHeading: 90)
					(trollKing loop: 2 cel: 0 setPri: 142 setCycle: End self)
				)
				(9
					(statueSound number: 5229 loop: 1 play:)
					(trollKing loop: 3 cel: 0 setCycle: End self)
					(fountain setCel: 1 setCycle: End)
				)
				(10
					(statueSound stop:)
					(Load 140 855) ; WAVE
					(trollKing loop: 4 cel: 0 setCycle: End self)
				)
				(11
					(gMessager say: 0 0 4 2 self) ; "Come on! There's no time to waste!"
				)
				(12
					(trollKing
						loop: 5
						cel: 0
						setPri: 130
						posn: 92 124
						setMotion: JumpTo 72 125 self
					)
				)
				(13
					(statueSound number: 855 loop: 1 play:)
					(trollKing loop: 5 cel: 0 setPri: 130 setCycle: End self)
				)
				(14
					(fountain dispose:)
					(trollKing dispose:)
					(= local0 1)
					(fountain1 approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
					(fountainFeat approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(if (gCast contains: zap)
						(zap dispose:)
					)
					(if (gCast contains: trollKing)
						(trollKing dispose:)
					)
					(gEgo
						normalize: 1
						setMotion:
							PolyPath
							(- (gEgo x:) 60)
							(gEgo y:)
							self
					)
				)
				(1
					(ClearFlag 539)
					(gEgo setHeading: 90)
					(= local0 1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sGoThroughFountain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 5231) ; WAVE
				(Load rsVIEW 5216)
				(gEgo setMotion: PolyPath 135 148 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gEgo
					view: 5216
					loop: 0
					cel: 0
					posn: 149 142
					setMotion: MoveTo 149 132
					setCycle: CT 9 1 self
				)
			)
			(3
				(statueSound number: 5231 loop: 1 play: self)
				(gEgo cel: 9 posn: 149 132 setCycle: End self)
			)
			(4
				(gEgo hide:)
			)
			(5
				(gCurRoom newRoom: 2400)
			)
		)
	)
)

(instance sBroken of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 5221)
				(= cycles 3)
			)
			(1
				(gEgo
					view: 5221
					loop: 0
					cel: 0
					posn: 217 112
					setCycle: Osc 1 self
				)
			)
			(2
				(gEgo posn: 216 109 normalize: 6)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(= cycles 1)
			)
			(3
				(gMessager say: 6 8 2 0 self) ; "(THINKS TO HERSELF)It must be broken or something."
			)
			(4
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCantOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 102 110 self)
			)
			(1
				(Load rsVIEW 8483)
				(gEgo setHeading: 315 self)
			)
			(2
				(doorSound number: 2106 setLoop: 1 play:)
				(gEgo
					view: 8483
					loop: 0
					cel: 0
					posn: 100 110
					setCycle: End self
				)
			)
			(3
				((ScriptID 13) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 1 88 0 2 self 5200) ; "(FRANTIC)Oh no! It's STUCK!"
			)
			(4
				((ScriptID 13) hide_mouth: 0) ; aEgoTalker
				(gEgo normalize: setHeading: 180 self)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance trollKing of Actor
	(properties
		view 5215
	)

	(method (init)
		(super init:)
		((ScriptID 7001 0) ; kingTalker
			clientCel: -1
			loop: -1
			view: -1
			mouth_x: -999
			mouth_y: -999
			client: self
		)
	)
)

(instance image of Prop
	(properties
		view 5203
	)
)

(instance zap of Prop
	(properties
		view 5213
	)
)

(instance theDoor of Prop
	(properties
		approachX 115
		approachY 110
		x 79
		y 99
		view 5200
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(cond
				((== (gCurRoom script:) sitDown)
					(= local4 theVerb)
					(gCurRoom setScript: getUp 0 self)
				)
				((== gValOrRoz -3) ; Roz
					(gCurRoom setScript: sCantOpenDoor)
				)
				(else
					(gCurRoom setScript: sOpenDoor)
				)
			)
		)
	)
)

(instance fountain of Prop
	(properties
		noun 5
		sightAngle 40
		approachX 126
		approachY 137
		x 149
		y 119
		view 5200
		loop 2
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(gUser canInput:)
					(not (gUser canControl:))
					(event type:)
					(== (gCurRoom script:) sitDown)
					(self onMe: event)
				)
				(= local4 8)
				(gCurRoom setScript: getUp 0 self)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(gUser canControl:)
					(& (gEgo state:) $0002)
					gApproachCode
					(!= (gCurRoom script:) sitDown)
					(& _approachVerbs (gApproachCode doit: (event message:)))
				)
				(super handleEvent: event &rest)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)

	(method (init)
		(super init:)
		(cond
			((and (== gValOrRoz -3) local7) ; Roz
				(self approachVerbs: 8 10 75 setHotspot: 8 10 75) ; Do, Exit, Shovel, Do, Exit, Shovel
			)
			((== gValOrRoz -4) ; Val
				(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
			)
		)
	)

	(method (doVerb theVerb)
		(if (== (gCurRoom script:) sitDown)
			(= local4 theVerb)
			(gCurRoom setScript: getUp 0 self)
		else
			(switch theVerb
				(8 ; Do
					(cond
						((== gValOrRoz -4) ; Val
							((ScriptID 13) hide_mouth: 1) ; aEgoTalker
							(gMessager say: 5 8 0) ; "What a perfectly awful basin."
							(self setHotspot: 0)
							(fountain1 setHotspot: 0)
							(fountainFeat setHotspot: 0)
							((ScriptID 13) hide_mouth: 0) ; aEgoTalker
							(gGame handsOn:)
						)
						(local0
							(gCurRoom setScript: sGoThroughFountain)
						)
						(else
							(Load rsVIEW 8423)
							(gCurRoom setScript: tryToOpenFountain)
						)
					)
				)
				(75 ; Shovel
					(gCurRoom setScript: useShovel)
				)
			)
		)
	)
)

(instance fountain1 of Actor
	(properties
		noun 5
		sightAngle 40
		approachX 126
		approachY 137
		x 147
		y 30
		view 5200
		loop 3
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(gUser canInput:)
					(not (gUser canControl:))
					(event type:)
					(== (gCurRoom script:) sitDown)
					(self onMe: event)
				)
				(= local4 8)
				(gCurRoom setScript: getUp 0 self)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(gUser canControl:)
					(& (gEgo state:) $0002)
					gApproachCode
					(!= (gCurRoom script:) sitDown)
					(& _approachVerbs (gApproachCode doit: (event message:)))
				)
				(super handleEvent: event &rest)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)

	(method (init)
		(super init:)
		(cond
			((and (== gValOrRoz -3) local7) ; Roz
				(self approachVerbs: 8 10 75 setHotspot: 8 10 75) ; Do, Exit, Shovel, Do, Exit, Shovel
			)
			((== gValOrRoz -4) ; Val
				(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
			)
		)
	)

	(method (doVerb theVerb)
		(if (== (gCurRoom script:) sitDown)
			(= local4 theVerb)
			(gCurRoom setScript: getUp 0 self)
		else
			(switch theVerb
				(8 ; Do
					(cond
						((== gValOrRoz -4) ; Val
							((ScriptID 13) hide_mouth: 1) ; aEgoTalker
							(gMessager say: 5 8 0) ; "What a perfectly awful basin."
							(self setHotspot: 0)
							(fountain setHotspot: 0)
							(fountainFeat setHotspot: 0)
							((ScriptID 13) hide_mouth: 0) ; aEgoTalker
							(gGame handsOn:)
						)
						(local0
							(gCurRoom setScript: sGoThroughFountain)
						)
						(else
							(Load rsVIEW 8423)
							(gCurRoom setScript: tryToOpenFountain)
						)
					)
				)
				(75 ; Shovel
					(gCurRoom setScript: useShovel)
				)
			)
		)
	)
)

(instance boards of View
	(properties
		noun 5
		sightAngle 40
		approachX 217
		approachY 98
		x 215
		y 100
		view 5219
	)

	(method (init)
		(super init:)
		(if (== gValOrRoz -3) ; Roz
			(self approachVerbs: 8 10 75 setHotspot: 8 10 75) ; Do, Exit, Shovel, Do, Exit, Shovel
		)
	)

	(method (doVerb theVerb)
		(if (== (gCurRoom script:) sitDown)
			(= local4 theVerb)
			(gCurRoom setScript: getUp 0 self)
		else
			(self setHotspot: 0)
			(gCurRoom setScript: sBroken)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(gUser canInput:)
					(not (gUser canControl:))
					(event type:)
					(== (gCurRoom script:) sitDown)
					(self onMe: event)
				)
				(= local4 8)
				(gCurRoom setScript: getUp 0 self)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(gUser canControl:)
					(& (gEgo state:) $0002)
					gApproachCode
					(!= (gCurRoom script:) sitDown)
					(& _approachVerbs (gApproachCode doit: (event message:)))
				)
				(super handleEvent: event &rest)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance fountainFeat of Feature
	(properties
		noun 5
		approachX 126
		approachY 137
		x 140
		y 129
	)

	(method (init)
		(super init:)
		(cond
			((and (== gValOrRoz -3) local7) ; Roz
				(self approachVerbs: 8 10 75 setHotspot: 8 10 75) ; Do, Exit, Shovel, Do, Exit, Shovel
			)
			((== gValOrRoz -4) ; Val
				(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
			)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 115 105 102 108 99 114 105 120 119 129 150 133 181 131 192 122 195 111 187 107 188 103 198 104 198 99 185 95 180 99 182 105 148 101 122 103 119 99 116 88 99 96 104 101 113 102
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== (gCurRoom script:) sitDown)
			(= local4 theVerb)
			(gCurRoom setScript: getUp 0 self)
		else
			(switch theVerb
				(8 ; Do
					(cond
						((== gValOrRoz -4) ; Val
							((ScriptID 13) hide_mouth: 1) ; aEgoTalker
							(gMessager say: 5 8 0) ; "What a perfectly awful basin."
							(self setHotspot: 0)
							(fountain1 setHotspot: 0)
							(fountain setHotspot: 0)
							((ScriptID 13) hide_mouth: 0) ; aEgoTalker
							(gGame handsOn:)
						)
						(local0
							(gCurRoom setScript: sGoThroughFountain)
						)
						(else
							(Load rsVIEW 8423)
							(gCurRoom setScript: tryToOpenFountain)
						)
					)
				)
				(75 ; Shovel
					(gCurRoom setScript: useShovel)
				)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(gUser canInput:)
					(not (gUser canControl:))
					(event type:)
					(== (gCurRoom script:) sitDown)
					(self onMe: event)
				)
				(= local4 8)
				(gCurRoom setScript: getUp 0 self)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(gUser canControl:)
					(& (gEgo state:) $0002)
					gApproachCode
					(!= (gCurRoom script:) sitDown)
					(& _approachVerbs (gApproachCode doit: (event message:)))
				)
				(super handleEvent: event &rest)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance statueBase of Feature
	(properties
		noun 2
		approachX 67
		approachY 119
		x 66
		y 118
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 10 84 86 ; Do, Exit, Woolen_Stocking, Sling
			setHotspot: 8 10 84 86 ; Do, Exit, Woolen_Stocking, Sling
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 36 86 51 88 60 85 57 80 40 80
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== (gCurRoom script:) sitDown)
			(= local4 theVerb)
			(gCurRoom setScript: getUp 0 self)
		else
			(switch theVerb
				(8 ; Do
					(Load rsSOUND 5210)
					(if (IsFlag 168)
						(if (and (== gValOrRoz -3) (not local8)) ; Roz
							(grapes init:)
						)
						(gEgo normalize:)
						(gCurRoom setInset: iCleanInset)
					else
						(gEgo normalize: x: (+ (gEgo x:) 1000))
						(UpdateScreenItem gEgo)
						(gCurRoom setInset: iDirtyInset)
					)
				)
				(84 ; Woolen_Stocking
					(self setHotspot: 8 10) ; Do, Exit
					(gCurRoom setScript: sPolish)
				)
				(86 ; Sling
					(self setHotspot: 8 10) ; Do, Exit
					(gCurRoom setScript: sPolish)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance statue of Feature
	(properties
		noun 1
		approachX 67
		approachY 119
		x 66
		y 118
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 88 ; Do, Exit, Golden_Grape
			approachVerbs: 8 10 88 ; Do, Exit, Golden_Grape
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 41 78 55 78 58 57 44 57 38 64
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== (gCurRoom script:) sitDown)
			(= local4 theVerb)
			(gCurRoom setScript: getUp 0 self)
		else
			(switch theVerb
				(8 ; Do
					((ScriptID 13) hide_mouth: 1) ; aEgoTalker
					(if (== gValOrRoz -3) ; Roz
						(gMessager say: 1 8 2 0) ; "Tacky, tacky."
					else
						(gMessager say: 1 8 1 0) ; "(THINKS TO HERSELF)Well. I think the world just got a new definition for tacky."
						(self setHotspot: 0)
					)
					((ScriptID 13) hide_mouth: 0) ; aEgoTalker
					(gGame handsOn:)
				)
				(88 ; Golden_Grape
					(gCurRoom setScript: sGrapeStatue)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance cherubMirror of Feature
	(properties
		nsLeft 28
		nsTop 25
		nsRight 52
		nsBottom 77
		approachX 67
		approachY 119
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 33 29 51 29 51 53 35 60 yourself:)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(if (== (gCurRoom script:) sitDown)
				(= local4 theVerb)
				(gCurRoom setScript: getUp 0 self)
			else
				(gCurRoom setScript: sFussWithHair)
			)
		)
	)
)

(instance mirror1 of Feature
	(properties
		approachX 114
		approachY 119
		x 133
		y 77
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		(if (not local7)
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 126 37 118 71 120 100 138 102 141 96 128 91 128 76 144 76 143 71 137 65 136 52 148 47 147 37
						yourself:
					)
			)
		else
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 127 37 127 37 119 68 127 68 138 60 128 50 132 38
						yourself:
					)
					((Polygon new:)
						type: PTotalAccess
						init: 121 92 142 96 140 100 124 101
						yourself:
					)
			)
		)
	)

	(method (doVerb theVerb)
		(if (== (gCurRoom script:) sitDown)
			(= local4 theVerb)
			(gCurRoom setScript: getUp 0 self)
		else
			(switch theVerb
				(8 ; Do
					(Load rsSOUND 5221)
					(gCurRoom setScript: lookMirror1)
				)
			)
		)
	)
)

(instance mirror2 of Feature
	(properties
		approachX 157
		approachY 113
		x 167
		y 81
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 setHotspot: 8 10) ; Do, Do, Exit
		(if (not local7)
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 162 37 155 67 155 74 167 76 164 86 159 99 176 101 183 79 184 50 182 40
						yourself:
					)
			)
		else
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 169 36 163 58 179 71 178 84 176 92 159 98 161 101 177 100 184 80 185 59 182 39
						yourself:
					)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (== (gCurRoom script:) sitDown)
					(= local4 theVerb)
					(gCurRoom setScript: getUp 0 self)
				else
					(Load rsSOUND 5222)
					(gCurRoom setScript: lookMirror2)
				)
			)
		)
	)
)

(instance mirror3 of Feature
	(properties
		approachX 247
		approachY 120
		x 275
		y 100
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 8 ; Do
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 266 38 275 33 286 33 281 77 268 109 251 101 259 77
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (== (gCurRoom script:) sitDown)
					(= local4 theVerb)
					(gCurRoom setScript: getUp 0 self)
				else
					(Load rsSOUND 5223)
					(gCurRoom setScript: lookMirror3)
				)
			)
		)
	)
)

(instance mirror4 of Feature
	(properties
		approachX 264
		approachY 128
		x 300
		y 110
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 8 ; Do
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 298 30 311 21 320 21 320 73 301 117 282 110 292 77
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (== (gCurRoom script:) sitDown)
					(= local4 theVerb)
					(gCurRoom setScript: getUp 0 self)
				else
					(Load rsSOUND 5221)
					(gCurRoom setScript: lookMirror4)
				)
			)
		)
	)
)

(instance exitMirror of Feature
	(properties
		noun 6
		approachX 217
		approachY 98
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 ; Do
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 202 34 195 80 197 98 215 98 222 75 216 35
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((== (gCurRoom script:) sitDown)
						(= local4 theVerb)
						(gCurRoom setScript: getUp 0 self)
					)
					((== gChapter 5)
						(gMessager say: 2 8 1 0) ; "(THINKS TO HERSELF)Hmm."
					)
					(else
						(Load rsSOUND 2453)
						(Load rsSOUND 2451)
						(gCurRoom setScript: enterMirror)
					)
				)
			)
		)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 77
		nsTop 31
		nsRight 106
		nsBottom 101
		approachX 115
		approachY 110
		x 98
		y 100
		exitDir 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(gUser canInput:)
					(not (gUser canControl:))
					(event type:)
					(== (gCurRoom script:) sitDown)
					(self onMe: event)
				)
				(= local4 8)
				(gCurRoom setScript: getUp 0 self)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(gUser canControl:)
					(& (gEgo state:) $0002)
					gApproachCode
					(!= (gCurRoom script:) sitDown)
					(& _approachVerbs (gApproachCode doit: (event message:)))
				)
				(super handleEvent: event &rest)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(event type:)
					(!= (event type:) evMOUSERELEASE)
					(not global308)
					(self onMe: event)
				)
				(if code
					(code doit:)
					(event claimed: 1)
					(return)
				)
				(CueObj
					state: 2
					cycles: 0
					client: self
					theVerb: (event message:)
				)
				(switch exitDir
					(1
						(gEgo setMotion: PolyPath (event x:) 0 CueObj)
					)
					(3
						(gEgo setMotion: PolyPath (event x:) 150 CueObj)
					)
					(2
						(if
							(OneOf
								gCurRoomNum
								1100
								111
								2600
								1250
								3150
								5300
								4550
							)
							(if (IsFlag 97)
								(gEgo
									setMotion:
										PolyPath
										(+ (gCurRoom eastSide:) 35)
										(event y:)
										CueObj
								)
							else
								(gEgo
									setMotion:
										PolyPath
										(+ (event x:) 35)
										(event y:)
										CueObj
								)
							)
						else
							(gEgo
								setMotion:
									PolyPath
									(gCurRoom eastSide:)
									(event y:)
									CueObj
							)
						)
					)
					(4
						(if
							(OneOf
								gCurRoomNum
								1100
								111
								2600
								1250
								3150
								5300
								4550
							)
							(if (IsFlag 97)
								(gEgo
									setMotion: PolyPath 50 (event y:) CueObj
								)
							else
								(gEgo
									setMotion:
										PolyPath
										(- (event x:) 35)
										(event y:)
										CueObj
								)
							)
						else
							(gEgo setMotion: PolyPath -10 (event y:) CueObj)
						)
					)
					(6
						(gEgo setMotion: PolyPath gMouseX gMouseY CueObj)
					)
					(5
						(gEgo setMotion: PolyPath gMouseX gMouseY CueObj)
					)
					(7
						(gEgo setMotion: PolyPath gMouseX gMouseY CueObj)
					)
					(8
						(gEgo setMotion: PolyPath gMouseX gMouseY CueObj)
					)
				)
				(event claimed: 1)
				(return)
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== (gCurRoom script:) sitDown)
				(= local4 theVerb)
				(gCurRoom setScript: getUp 0 self)
			)
			((== gValOrRoz -3) ; Roz
				(gCurRoom setScript: sCantOpenDoor)
			)
			(else
				(gCurRoom setScript: sOpenDoor)
			)
		)
	)
)

(instance grapes of Feature
	(properties
		noun 4
		approachX 228
		approachY 114
		x 230
		y 110
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 46 75 approachVerbs: 8 10 46 75) ; Do, Exit, Hammer_and_Chisel, Shovel, Do, Exit, Hammer_and_Chisel, Shovel
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 230 84 245 84 250 73 246 68 232 68 226 74
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== (gCurRoom script:) sitDown)
			(= local4 theVerb)
			(gCurRoom setScript: getUp 0 self)
		else
			(switch theVerb
				(46 ; Hammer_and_Chisel
					(self setHotspot: 0)
					(gCurRoom setScript: sChiselGrape)
				)
				(8 ; Do
					(gCurRoom setScript: sPullGrapes)
				)
				(75 ; Shovel
					(gMessager say: noun theVerb 2 0) ; "(THINKS TO HERSELF)I'd better not. That shovel is just too clumsy."
				)
			)
		)
	)
)

(instance chair of Feature ; UNUSED
	(properties
		noun 3
		approachX 69
		approachY 117
		x 69
		y 120
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 61 110 63 97 71 93 81 97 81 108 73 113
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (== gValOrRoz -3) ; Roz
					(Load rsVIEW 8552)
				else
					(Load rsVIEW 8192)
				)
				(if local1
					(gCurRoom setScript: getUp)
				else
					(gCurRoom setScript: sitDown)
				)
			)
		)
	)
)

(instance iCleanInset of Inset
	(properties
		picture 5210
	)

	(method (init)
		(super init: &rest)
		(proc11_6)
		(SetFlag 169)
		(statueSound number: 5210 loop: 1 play:)
		(if (not (== gValOrRoz -3)) ; Roz
			(gMessager say: 2 8 1 0) ; "(THINKS TO HERSELF)Hmm."
		else
			(gMessager say: 2 8 3 0) ; "I'm a hungry little tot, but I don't want porridge, cold or hot. I don't want bread, I don't want meat, My taste runs more to fruit so sweet! If you give me what I need, you'll see me perform such a deed! The ground will shake, the waters part, And you can plunge into the heart of darkness deep and pulsing fire. Feed me! Get what you desire!"
		)
		(= local5 1)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(super doVerb: theVerb)
	)

	(method (dispose)
		(statueSound stop:)
		(super dispose:)
	)
)

(instance iDirtyInset of Inset
	(properties
		picture 5211
	)

	(method (init)
		(super init: &rest)
		(if (== gValOrRoz -3) ; Roz
			(theRoomInset setHotspot: 0 84 86 init:) ; Woolen_Stocking, Sling
		)
		(proc11_6)
		(statueSound number: 5210 loop: 1 play:)
		(if (== gValOrRoz -4) ; Val
			(gMessager say: 2 8 0 0) ; "Oh, plaque is all tarnished. I can't read it. What dreadful housekeeping...oh well. I've got better things to do."
		else
			(gMessager say: 2 8 5 0) ; "It's all tarnished. I can't quite make it out."
		)
		(gGame handsOn:)
		(gUser canControl: 0)
	)

	(method (dispose)
		(if (not (gCurRoom script:))
			(gUser canControl: 1)
			(gGame handsOn:)
		)
		(statueSound stop:)
		(super dispose:)
		(gEgo x: (- (gEgo x:) 1000))
	)
)

(instance theRoomInset of Feature
	(properties
		nsLeft 84
		nsTop 30
		nsRight 223
		nsBottom 117
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(gUser canInput:)
					(not (gUser canControl:))
					(event type:)
					(or (== (event message:) KEY_V) (== (event message:) KEY_T))
				)
				(statueSound stop:)
				(event claimed: 1)
				(gCurRoom setScript: sPolish)
				(iDirtyInset dispose:)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance statueSound of Sound
	(properties)
)

(instance mirrorSound of Sound
	(properties)
)

(instance doorSound of Sound
	(properties)
)

