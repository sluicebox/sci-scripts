;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4300)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm4300 0
	headTalker 50
)

(local
	local0
)

(instance rm4300 of KQRoom
	(properties
		picture 4300
	)

	(method (init)
		(SetFlag 192)
		(super init:)
		(headsDummy init:)
		(Load rsMESSAGE 4300)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 59 134 194 134 310 121 309 109 288 109 254 102 246 91 264 88 228 83 204 91 186 82 126 77 87 87 93 93 181 93 244 100 201 129 129 115 92 117 59 117
					yourself:
				)
		)
		(gEgo
			init:
			posn: 100 100
			normalize:
			setScaler: 0
			scaleX: 128
			scaleY: 128
		)
		(if (== gValOrRoz -3) ; Roz
			(mummy init:)
			(if (not (IsFlag 181))
				(Load rsVIEW 4308)
				(Load rsVIEW 359)
				(Load 140 4314) ; WAVE
				(Load rsSOUND 4316)
				(footInBag init:)
			)
			(if (and (not (IsFlag 173)) (not (gEgo has: 50))) ; Back_Bone
				(Load rsVIEW 4307)
				(Load rsVIEW 8383)
				(Load rsSOUND 4315)
				(backBone init:)
			)
			(jackInTheBox init:)
			(cond
				((and (IsFlag 178) (gEgo has: 51)) ; Weird_Pet
					(= local0 40)
				)
				((not (IsFlag 481))
					(Load rsVIEW 8383)
					(Load rsVIEW 4316)
					(heads init:)
					(headTalker client: headsDummy)
				)
			)
			(self setScript: rosComesUp)
		else
			(Load rsVIEW 8295)
			(Load rsVIEW 8025)
			(Load rsVIEW 4313)
			(Load rsVIEW 4315)
			(if (not (IsFlag 518))
				(mummy init:)
			)
			(mummyWig init:)
			(if
				(and
					(not ((gInventory at: 72) ownedBy: 4000)) ; Femur
					(not (gEgo has: 72)) ; Femur
				)
				(Load rsVIEW 4316)
				(Load 140 4308) ; WAVE
				(Load rsSOUND 4309)
				(Load rsSOUND 4310)
				(Load rsSOUND 4311)
				(Load 140 4312) ; WAVE
				(femur init:)
			)
			(if (not (IsFlag 517))
				(heads init:)
				(Load rsVIEW 4316)
				(headTalker client: headsDummy)
			)
			(jackInTheBox init:)
			(Load rsSOUND 4305)
			(Load 140 4306) ; WAVE
			(Load rsSOUND 854)
			(Load rsSOUND 848)
			(Load rsSOUND 865)
			(self setScript: sValComesUp)
		)
		(theMouth init:)
		(theWindow init:)
		(if (IsFlag 5)
			(ClearFlag 5)
		)
		(if (== local0 40)
			(gKqMusic1 number: 4313 setLoop: -1 play:)
		else
			(gKqMusic1 number: 4300 setLoop: -1 play:)
		)
		((ScriptID 7001 5) client: ghoulKid1) ; kid1Talker
		((ScriptID 7001 6) client: ghoulKid2) ; kid2Talker
		((ScriptID 7001 7) client: ghoulKid1) ; bothKidsTalker
	)

	(method (dispose)
		(ClearFlag 192)
		(super dispose: &rest)
	)
)

(instance sValComesUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(elevator init: z: 1000)
				(gEgo
					posn: 185 148
					view: 4312
					setLoop: 2 1
					setCycle: 0
					setCel: 16
					setStep: 3 3
					ignoreActors:
					setPri: 2
					setMotion: MoveTo 185 122 self
				)
				(soundEffect number: 4264 setLoop: 1 play:)
			)
			(1
				(soundEffect stop:)
				(gEgo setCycle: CT 10 -1 self)
			)
			(2
				(elevator
					view: 4312
					z: 0
					setLoop: 0 1
					setCel: 0
					setPri: 1
					ignoreActors:
				)
				(gEgo setPri: -1 setCycle: Beg self)
			)
			(3
				(gEgo
					normalize: 6
					posn: 172 127
					setScaler: Scaler 100 88 127 82
				)
				(elevator setPri: 112)
				(if (not (IsFlag 178))
					(ghoulKid1 view: 4311 init: hide:)
					(ghoulKid1 setScript: kidsComeHomeVal)
				else
					(ghoulKid1 view: 4310 init: hide:)
					(Load 140 1003) ; WAVE
					(ghoulKid1 setScript: scareEgo)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rosComesUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo z: 1000)
				(elevator
					init:
					view: 4301
					x: 186
					y: 150
					setLoop: 1 1
					setPri: 1
					ignoreActors:
					setMotion: MoveTo 186 122 self
				)
				(soundEffect number: 4264 setLoop: 1 play:)
			)
			(1
				(soundEffect stop:)
				(elevator setLoop: 0 1)
				(gEgo
					view: 4301
					z: 0
					x: 180
					y: 130
					setLoop: 4 1
					setCel: 0
					scaleX: 138
					scaleY: 138
					setCycle: End self
				)
			)
			(2
				(gEgo
					y: (+ (gEgo y:) 2)
					scaleX: 128
					scaleY: 128
					normalize: 3
					setScaler: Scaler 100 88 127 82
				)
				(elevator setPri: 112)
				(if (== local0 40)
					(gCurRoom setScript: killedForPet)
				else
					(if (not (IsFlag 178))
						(ghoulKid1 view: 4303 init: z: 1000)
						(ghoulKid2 view: 4303 init: z: 1000)
						(Load 140 2452) ; WAVE
						(ghoulKid1 setScript: kidsComeHomeRos)
					else
						(ghoulKid1 view: 4310 init: hide:)
						(ghoulKid1 setScript: scareEgo)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sValGoesDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScaler: 0
					scaleX: 128
					scaleY: 128
					view: 4312
					setLoop: 2 1
					setCel: 0
					setStep: 3 3
					ignoreActors:
					posn: 185 122
					setCycle: CT 9 1 self
				)
				(elevator setPri: 1)
			)
			(1
				(elevator z: 1000)
				(gEgo setPri: 2 setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 185 148 self)
				(soundEffect number: 4264 setLoop: 1 play:)
			)
			(3
				(gCurRoom newRoom: 4250)
			)
		)
	)
)

(instance sRosGoesDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScaler: 0
					scaleX: 128
					scaleY: 128
					view: 4301
					setLoop: 4 1
					setCel: 6
					posn: 180 130
					setCycle: Beg self
				)
			)
			(1
				(gEgo hide:)
				(elevator setLoop: 1 1 setPri: 1 setMotion: MoveTo 186 150 self)
				(soundEffect number: 4263 setLoop: 1 play:)
			)
			(2
				(gCurRoom newRoom: 4250)
			)
		)
	)
)

(instance killedForPet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ghoulKid1 view: 4301 init: z: 1000 setPri: 1)
				(ghoulKid2
					init:
					view: 4301
					setLoop: 3 1
					setCel: 0
					posn: 205 124
					setPri: 1
					setCycle: CT 1 1 self
				)
			)
			(1
				(soundEffect number: 43130 setLoop: 1 play:)
				(ghoulKid2 setCycle: CT 6 1 self)
			)
			(2
				(ghoulKid2 setCycle: CT 25 1 self)
				(ghoulKid1
					z: 0
					view: 4301
					setLoop: 2 1
					setCel: 0
					x: 152
					y: 100
					setCycle: End self
				)
			)
			(3
				(ghoulKid1 setPri: 112)
				(ghoulKid2 setPri: (+ (gEgo priority:) 1) setCycle: End)
				((ScriptID 7001 5) hide_mouth: 1) ; kid1Talker
				((ScriptID 7001 6) hide_mouth: 1) ; kid2Talker
				((ScriptID 7001 7) hide_mouth: 1) ; bothKidsTalker
			)
			(4
				(soundEffect stop:)
				(gMessager say: 0 0 2 0 self) ; "(SHRIEK GLEEFULLY)GOTCHA!"
			)
			(5
				(EgoDead 16 self)
			)
			(6
				((ScriptID 7001 5) hide_mouth: 0) ; kid1Talker
				((ScriptID 7001 6) hide_mouth: 0) ; kid2Talker
				((ScriptID 7001 7) hide_mouth: 0) ; bothKidsTalker
				(gCurRoom newRoom: 4250)
			)
		)
	)
)

(instance scareEgo of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== state 1)
				(gGame isHandsOn:)
				(not (gCurRoom script:))
				(not (gEgo script:))
				(> (gEgo y:) 114)
			)
			(gGame handsOff:)
			(gEgo setMotion: 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 24 36))
			)
			(1 0)
			(2
				(gGame handsOff:)
				(soundEffect number: 864 setLoop: 1 play:)
				(gEgo setMotion: 0)
				(if (== gValOrRoz -3) ; Roz
					(if (> (gEgo x:) 160)
						(ghoulKid1
							posn: (- (gEgo x:) 73) (+ (gEgo y:) 15)
							view: 4302
							setLoop: 0 1
							show:
							setCel: 0
						)
					else
						(ghoulKid1
							posn: (+ (gEgo x:) 73) (+ (gEgo y:) 15)
							view: 4302
							setLoop: 1 1
							show:
							setCel: 0
						)
					)
					(+= state 1)
					(ghoulKid1
						show:
						setCel: 0
						setPri: 128
						signal: 16385
						setCycle: CT 22 1 self
					)
				else
					(if (> (gEgo x:) 160)
						(ghoulKid1
							posn: (- (gEgo x:) 92) (- (gEgo y:) 30)
							view: 4310
							setLoop: 0 1
						)
					else
						(ghoulKid1
							posn: (+ (gEgo x:) 92) (- (gEgo y:) 30)
							view: 4310
							setLoop: 1 1
						)
					)
					(ghoulKid1
						show:
						setCel: 0
						setPri: 128
						signal: 16385
						setCycle: End self
					)
				)
			)
			(3
				(if (== gValOrRoz -3) ; Roz
					(ghoulKid1
						setLoop: (+ (ghoulKid1 loop:) 2)
						setCel: 0
						setCycle: CT 15 1 self
					)
				else
					(ghoulKid1
						setLoop: (+ (ghoulKid1 loop:) 2)
						setCel: 0
						setCycle: CT 14 1 self
					)
				)
			)
			(4
				(gEgo hide:)
				(soundEffect number: 4301 setLoop: 1 play:)
				(if (== gValOrRoz -3) ; Roz
					(ghoulKid1 setCycle: End self)
					(soundEffect2 number: 2452 setLoop: 1 play:)
				else
					(ghoulKid1 setCycle: End self)
					(soundEffect2 number: 1003 setLoop: 1 play:)
				)
			)
			(5
				(if (== gValOrRoz -3) ; Roz
					(gMessager say: 0 0 1 0 self) ; "(SHRIEKS GLEEFULLY)GOTCHA, LADY!"
				else
					(gMessager say: 0 0 4 0 self) ; "GOTCHA, LADY!"
				)
			)
			(6
				(if (== gValOrRoz -3) ; Roz
					(EgoDead 17 self)
				else
					(EgoDead 66 self)
				)
			)
			(7
				((ScriptID 7001 5) hide_mouth: 0) ; kid1Talker
				((ScriptID 7001 6) hide_mouth: 0) ; kid2Talker
				((ScriptID 7001 7) hide_mouth: 0) ; bothKidsTalker
				(ghoulKid1 hide:)
				(gEgo show:)
				(gGame handsOn:)
				(ghoulKid1 setScript: scareEgo)
			)
		)
	)
)

(instance kidsComeHomeRos of Script
	(properties)

	(method (doit)
		(if
			(and
				(== state 3)
				(not (gCurRoom script:))
				(not (gEgo script:))
				(< (GetDistance (gEgo x:) (gEgo y:) 150 93 gPerspective) 20)
			)
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= seconds 60)
			)
			(2
				(soundEffect number: 4302 setLoop: 1 play:)
				(= seconds 6)
			)
			(3 0)
			(4
				(gGame handsOff:)
				(gEgo setPri: 111 setMotion: PolyPath 150 93)
				(ghoulKid2
					z: 0
					ignoreActors:
					setLoop: 1 1
					setCel: 0
					x: 141
					y: 122
					setPri: (gEgo priority:)
					setCycle: CT 1 1 self
				)
			)
			(5
				(ghoulKid1
					z: 0
					ignoreActors:
					setLoop: 2 1
					setCel: 0
					x: 157
					y: 118
					setPri: (- (gEgo priority:) 1)
					setCycle: CT 1 1 self
				)
				(ghoulKid2 setCycle: End)
			)
			(6
				(ghoulKid1 setCycle: End)
				(gEgo
					setScaler: 0
					scaleX: 128
					scaleY: 128
					view: 4303
					setLoop: 0 1
					setCel: 0
					x: 154
					y: 119
					setMotion: 0
					setCycle: CT 2 1 self
				)
			)
			(7
				(soundEffect number: 2452 setLoop: 1 play:)
				(gEgo setCycle: End self)
				(ghoulKid1 z: 1000)
				(ghoulKid2 z: 1000)
			)
			(8
				((ScriptID 7001 7) client: gEgo) ; bothKidsTalker
				(gMessager say: 0 0 2 0 self) ; "(SHRIEK GLEEFULLY)GOTCHA!"
			)
			(9
				(EgoDead 17 self)
			)
			(10
				(gEgo normalize: 5 setScaler: Scaler 100 88 127 82)
				(gGame handsOn:)
				(ghoulKid1 setScript: kidsComeHomeRos)
			)
		)
	)
)

(instance kidsComeHomeVal of Script
	(properties)

	(method (doit)
		(if
			(and
				(== state 3)
				(not (gCurRoom script:))
				(not (gEgo script:))
				(< (GetDistance (gEgo x:) (gEgo y:) 135 93 gPerspective) 20)
			)
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= seconds 60)
			)
			(2
				(soundEffect number: 4302 setLoop: 1 play:)
				(= seconds 6)
			)
			(3 0)
			(4
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 135 93 self)
				(ghoulKid1
					show:
					view: 4311
					setLoop: 0
					setCel: 0
					x: 42
					y: 60
					priority: 60
					fixPriority: 1
					signal: 2049
					setCycle: CT 2 1 self
				)
			)
			(5
				(ghoulKid2
					init:
					view: 4311
					setLoop: 1
					setCel: 0
					x: 46
					y: 63
					z: 0
					priority: 63
					fixPriority: 1
					signal: 16385
					setCycle: End
				)
				(ghoulKid1 setCycle: CT 4 1 self)
			)
			(6
				(gEgo hide:)
				(ghoulKid1 setCycle: CT 11 1 self)
			)
			(7
				(ghoulKid2 dispose:)
				(ghoulKid1 setCycle: End self)
			)
			(8
				(gMessager say: 0 0 5 0 self) ; "GOTCHA!"
			)
			(9
				(EgoDead 18 self)
			)
			(10
				(ghoulKid1 hide:)
				(gEgo show:)
				(gGame handsOn:)
				(ghoulKid1 setScript: kidsComeHomeVal)
			)
		)
	)
)

(instance sRosInspectMummy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(soundEffect number: 4314 setLoop: 1 play: self)
			)
			(1
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 1 8 3 3) ; "(SURPRISED)EEEK!"
				(gEgo view: 8385 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(2
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo normalize: 6 posn: 250 115)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getFoot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 181)
				(gEgo
					view: 4308
					setLoop: 1 1
					setCel: 0
					setPri: 105
					setCycle: CT 4 1 self
				)
			)
			(1
				(footInBag dispose:)
				(gEgo get: 59) ; Foot-In-A-Bag
				(gEgo setPri: -1 setCycle: End self)
			)
			(2
				(gEgo setLoop: 2 1 setCel: 0 setCycle: End self)
				(soundEffect number: 4316 setLoop: 1 play:)
			)
			(3
				(gEgo setLoop: 3 1 setCel: 0 setCycle: End self)
			)
			(4
				(gEgo normalize: 5)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 2 8 0 0 self) ; "(THINKS TO HERSELF, AMUSED AND GROSSED OUT)I suppose a girl never knows when she'll need a foot in a bag. Especially in Ooga Booga land!"
			)
			(5
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sValExitWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 4313
					setLoop: 0
					setCel: 0
					x: 239
					y: 85
					cycleSpeed: 8
					scaleSignal: 0
					scaleX: 128
					scaleY: 128
					setScaler: 0
					setCycle: End self
				)
			)
			(1
				(if (IsFlag 177)
					(gEgo
						posn: 245 75
						setLoop: 1
						setCel: 0
						setCycle: End self
					)
				else
					(= ticks 150)
				)
			)
			(2
				(if (IsFlag 177)
					(gEgo
						posn: 233 51
						setLoop: 2
						setCel: 0
						setCycle: End self
					)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(3
				(if (IsFlag 177)
					(gEgo x: -100)
					(= cycles 3)
				else
					(gEgo normalize: 2 setScaler: Scaler 100 88 127 82)
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(4
				(gCurRoom newRoom: 4250)
			)
		)
	)
)

(instance sRosExitWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 8455
					setLoop: 1 1
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(1
				(if (IsFlag 177)
					(gEgo setCycle: CT 5 1 self)
				else
					(= ticks 150)
				)
			)
			(2
				(if (IsFlag 177)
					(gCurRoom newRoom: 4250)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(3
				(gEgo normalize: 7)
				(gGame handsOn:)
				(self dispose:)
			)
			(4
				(gCurRoom newRoom: 4250)
			)
		)
	)
)

(instance sValJackInTheBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 4314
					setLoop: 0
					setCel: 0
					x: 112
					y: 136
					z: 0
					xStep: 3
					yStep: 2
					priority: (- (jackInTheBox priority:) 1)
					fixPriority: 1
					signal: 2049
					setCycle: End self
				)
			)
			(1
				(jackInTheBox setCel: 15)
				(gEgo
					priority: 150
					fixPriority: 1
					setLoop: 1 1
					setCycle: Fwd
				)
				(gKqMusic1 stop:)
				(soundEffect number: 4305 setLoop: 1 play: self)
			)
			(2
				(jackInTheBox setCel: 0 setCycle: CT 13 1 jackInTheBox)
				(soundEffect number: 4306 setLoop: 1 play:)
				(soundEffect2 number: 854 setLoop: 1 play:)
				(gEgo
					view: 4314
					setLoop: 3 1
					setCel: 0
					x: 126
					y: 129
					z: 0
					setScaler: 0
					scaleX: 128
					scaleY: 128
					setPri: (- (jackInTheBox priority:) 1)
					setCycle: CT 5 1 self
				)
				(soundEffect2 number: 1003 setLoop: 1 play:)
			)
			(3
				(gEgo setCycle: CT 7 1 self)
			)
			(4
				(soundEffect number: 865 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(5 0)
			(6
				(gKqMusic1 play:)
				(EgoDead 67 self)
			)
			(7
				(jackInTheBox setLoop: 2 setCel: 14)
				(gEgo
					posn: 129 121
					normalize: 5
					setScaler: Scaler 100 88 127 82
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRosJackInTheBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 4305
					setLoop: 0 1
					setCel: 0
					x: 190
					y: 133
					setCycle: End self
				)
			)
			(1
				(gEgo
					setLoop: 1 1
					setCel: 0
					setPri: (+ (jackInTheBox priority:) 1)
					setCycle: ForwardCounter 3 self
				)
				(jackInTheBox setCel: 18)
				(gKqMusic1 pause: 1)
				(soundEffect number: 4305 setLoop: -1 play:)
			)
			(2
				(jackInTheBox setCel: 0 setCycle: CT 2 1 self)
			)
			(3
				(jackInTheBox setCycle: CT 16 1 jackInTheBox)
				(soundEffect number: 4306 setLoop: 1 1 play:)
				(soundEffect2 number: 854 setLoop: 1 play:)
				(gEgo
					view: 4305
					setLoop: 3
					setCel: 0
					x: 197
					y: 136
					setCycle: CT 5 1 self
				)
			)
			(4
				(soundEffect2 number: 848 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(5
				(soundEffect2 number: 865 setLoop: 1 play: self)
			)
			(6 0)
			(7
				(gKqMusic1 pause: 0)
				(EgoDead 68 self)
			)
			(8
				(gEgo normalize: 5 posn: 197 132)
				(jackInTheBox setCel: 17)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTouchWig of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 4315 setLoop: 0 setCel: 0 setCycle: CT 7 1 self)
			)
			(1
				(gMessager say: 4 8 6 0) ; "Hey, you! Don't touch my 'do'!"
				(gEgo setCycle: End self)
				(soundEffect number: 4308 setLoop: 1 play:)
			)
			(2
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sValInspectMummy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8295 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 3 8 6 1 self) ; "(WONDERING ABOUT THE MUMMY)Hmmmmmm."
				(++ state)
			)
			(2
				(gEgo view: 8025 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(3
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getBone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 4307 setLoop: 0 setCel: 0 setCycle: CT 7 1 self)
			)
			(1
				(gEgo setCycle: End self)
				(soundEffect number: 4315 setLoop: 1 play:)
			)
			(2
				(gEgo get: 50 normalize: 5) ; Back_Bone
				((gCurRoom obstacles:) delete: ((gCurRoom obstacles:) at: 1))
				(boneRings init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rosLookHeads of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 481)
				(gMessager sayRange: 1 8 3 1 2 self) ; "(SOFTLY, NOT EXPECTING AN ANSWER)Hi, guys."
			)
			(1
				(gMessager say: 1 8 3 3) ; "(SURPRISED)EEEK!"
				(gEgo view: 8383 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo
					normalize: 3
					y: (+ (gEgo y:) 7)
					x: (+ (gEgo x:) 4)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance valLookHeads of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 8 6 1 self) ; "(SOFTLY)How horrible."
			)
			(1
				(gMessager say: 1 8 6 2 self) ; "(CHEERFUL)Same to you, lady!"
				(gEgo
					view: 8023
					setLoop: 0
					setCel: 0
					setScaler: 0
					scaleX: 128
					scaleY: 128
					setCycle: End self
				)
			)
			(2
				(gEgo
					normalize: 3
					posn: (gEgo x:) 93
					setScaler: Scaler 100 88 127 82
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetFemur of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 4316
					setLoop: 0
					setCel: 0
					setScaler: 0
					scaleX: 128
					scaleY: 128
					setCycle: CT 5 1 self
				)
				(soundEffect3 number: 4309 setLoop: 1 play:)
			)
			(1
				(gEgo setCycle: End self)
				(femur dispose:)
			)
			(2
				(= ticks 90)
			)
			(3
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
				(soundEffect3 number: 4310 setLoop: 1 play:)
			)
			(4
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
				(soundEffect3 number: 4311 setLoop: 1 play:)
			)
			(5
				(soundEffect2 number: 4312 setLoop: 1 play:)
				(= ticks 30)
			)
			(6
				(gEgo get: 72 1 normalize: 6 setScaler: Scaler 100 88 127 82) ; Femur
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ghoulKid1 of Actor
	(properties)
)

(instance ghoulKid2 of Actor
	(properties
		view 4310
	)
)

(instance elevator of Actor
	(properties
		sightAngle 40
		approachX 181
		approachY 127
		x 185
		y 122
	)

	(method (init)
		(if (== gValOrRoz -3) ; Roz
			(= view 4301)
			(= loop 1)
		else
			(= view 4312)
			(= approachX 172)
			(= approachY 127)
		)
		(super init:)
		(|= signal $1000)
		(self setHotspot: 8 10 approachVerbs: 8 10 ignoreActors:) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (== gValOrRoz -3) ; Roz
					(gCurRoom setScript: sRosGoesDown)
				else
					(gCurRoom setScript: sValGoesDown)
				)
			)
		)
	)
)

(instance jackInTheBox of Prop
	(properties
		sightAngle 40
		approachX 129
		approachY 121
		x 91
		y 140
		priority 140
		fixPriority 1
		loop 2
		signal 16385
	)

	(method (cue)
		(if (== gValOrRoz -3) ; Roz
			(self setCycle: Beg sRosJackInTheBox)
		else
			(self setCycle: Beg sValJackInTheBox)
		)
	)

	(method (init)
		(if (== gValOrRoz -3) ; Roz
			(= view 4305)
			(= loop 2)
			(= x 173)
			(= y 143)
			(= cel 17)
			(= approachX 197)
			(= approachY 136)
		else
			(= view 4314)
			(= loop 2)
			(= cel 14)
		)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (== gValOrRoz -3) ; Roz
					(gCurRoom setScript: sRosJackInTheBox)
				else
					(gCurRoom setScript: sValJackInTheBox)
				)
			)
		)
	)
)

(instance backBone of View
	(properties
		sightAngle 360
		approachX 123
		approachY 127
		x 123
		y 127
		view 4307
		loop 1
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8 10 setPri: 122) ; Do, Exit, Do, Exit
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 95 120 122 120 122 126 95 126
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: getBone)
				(self dispose:)
			)
		)
	)
)

(instance boneRings of View
	(properties
		x 123
		y 127
		view 4307
		loop 2
	)
)

(instance footInBag of View
	(properties
		noun 2
		sightAngle 46
		approachX 138
		approachY 102
		x 115
		y 101
		view 4308
	)

	(method (init)
		(super init:)
		(self approachVerbs: 8 10 setHotspot: 8 10 setPri: 105) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: getFoot)
			)
		)
	)
)

(instance femur of View
	(properties
		approachX 261
		approachY 108
		x 272
		y 65
		view 4300
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: sGetFemur)
			)
		)
	)
)

(instance mummyWig of View
	(properties
		noun 4
		approachX 267
		approachY 111
		x 286
		y 36
		view 4300
		loop 1
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 309 50 312 42 296 36 292 43
					yourself:
				)
		)
		(if (not (IsFlag 519))
			(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(SetFlag 519)
				(gCurRoom setScript: sTouchWig)
				(self setHotspot: 0)
			)
		)
	)
)

(instance theWindow of Feature
	(properties
		approachX 239
		approachY 85
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 10 ; Do, Exit
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 225 49 213 25 231 0 260 16 256 45
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if
					(and
						(gCast contains: ghoulKid1)
						(or
							(and
								(== (ghoulKid1 script:) kidsComeHomeVal)
								(<= 1 (kidsComeHomeVal state:) 3)
							)
							(and
								(== (ghoulKid1 script:) kidsComeHomeRos)
								(<= 1 (kidsComeHomeRos state:) 3)
							)
						)
					)
					(SetFlag 177)
				)
				(if (== gValOrRoz -3) ; Roz
					(gCurRoom setScript: sRosExitWindow)
				else
					(gCurRoom setScript: sValExitWindow)
				)
			)
		)
	)
)

(instance theMouth of Feature
	(properties
		approachX 97
		approachY 85
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 11 71 35 87 31 70 49 75 54 70 73 77 83 67 93 69 112 62 141 67 100 40 91 51 73 45 65 62 50 43 40 65 27 50 22 68 9 62
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (not (gCurRoom script:))
					(SetFlag 158)
					(SetFlag 175)
					(ClearFlag 177)
					(gCurRoom newRoom: 4250)
				)
			)
		)
	)
)

(instance mummy of Feature
	(properties
		noun 3
		approachX 267
		approachY 111
		x 310
		y 66
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 268 89 252 87 256 96 272 95 285 102 294 98 281 92 301 69 307 50 291 43 286 50 275 54 274 61 268 76
					yourself:
				)
			approachVerbs: 8 10 ; Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (== gValOrRoz -3) ; Roz
					(gCurRoom setScript: sRosInspectMummy)
					(self dispose:)
				else
					(SetFlag 518)
					(gCurRoom setScript: sValInspectMummy)
					(self dispose:)
				)
			)
		)
	)
)

(instance heads of Feature
	(properties
		noun 1
		approachX 175
		approachY 63
		x 183
		y 30
	)

	(method (init)
		(if (!= gValOrRoz -3) ; Roz
			(= approachY 88)
		)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 149 55 152 65 164 68 196 70 209 64 208 55 194 53 186 50 176 49 165 54 155 51
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (== gValOrRoz -3) ; Roz
					(gCurRoom setScript: rosLookHeads)
				else
					(SetFlag 517)
					(gCurRoom setScript: valLookHeads)
				)
				(self dispose:)
			)
		)
	)
)

(instance soundEffect of Sound
	(properties)
)

(instance soundEffect2 of Sound
	(properties)
)

(instance soundEffect3 of Sound
	(properties)
)

(instance headTalker of KQTalker
	(properties
		view 4316
		loop 6
	)
)

(instance headsDummy of Prop
	(properties
		x 179
		y 63
		z 1000
		view 4316
	)
)

