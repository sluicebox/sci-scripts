;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2000)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm2000 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0)
	(return
		(cond
			((leftTop onMe: gEgo) leftTop)
			((leftBtm onMe: gEgo) leftBtm)
			((midTop onMe: gEgo) midTop)
			((midBtm onMe: gEgo) midBtm)
			((rightTop onMe: gEgo) rightTop)
			((rightBtm onMe: gEgo) rightBtm)
			(else 0)
		)
	)
)

(instance rm2000 of KQRoom
	(properties
		picture 2000
	)

	(method (init)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 110 69 111 79 102 82 87 86 113 91 138 113 172 135 227 135 284 128 315 119 315 91 303 91 292 94 260 94 237 94 227 84 241 80 259 76 254 74 243 74 223 73 210 67 216 60 216 57 202 57 202 68 223 85 232 94 222 102 186 102 114 64 84 59 80 62
					yourself:
				)
				((Polygon new:) type: PContainedAccess init: 27 87 45 91 41 97 28 97 yourself:)
				((Polygon new:)
					type: PContainedAccess
					init: 21 72 42 72 48 67 43 62 32 62
					yourself:
				)
				((Polygon new:) type: PContainedAccess init: 61 81 61 83 63 83 63 81 yourself:)
		)
		(gEgo
			init:
			normalize: 1
			posn: 340 100
			setScaler: Scaler 100 45 138 57
		)
		(if (not (IsFlag 55))
			(leftTop initialize:)
			(midTop initialize:)
			(midBtm initialize:)
			(leftBtm initialize:)
			(if (not (IsFlag 68))
				(greenWater0 init:)
				(greenWater1 init:)
				(greenWater2 init:)
				(greenWater3 init:)
				(greenWater4 init:)
			)
			(if (not (IsFlag 376))
				(Load rsVIEW 2001)
				(pitOfWinds init:)
			)
			(if
				(and
					(not (gEgo has: 35)) ; Lantern
					(not (gEgo has: 36)) ; Lantern_with_Spark
					(not (IsFlag 60))
				)
				(lantern init:)
			)
			(if (and (not (gEgo has: 34)) (not (IsFlag 67))) ; Wet_Sulfur
				(sulfur init:)
			)
		else
			(= local3 1)
		)
		(forgeDoor init:)
		(Load 140 2001) ; WAVE
		(windSound init: number: 2001 setLoop: -1 play: setVol: 20)
		(self setScript: enterRoom)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(= temp0 (- 320 (gEgo x:)))
		(cond
			(script 0)
			(local3 0)
			(local2
				(if
					(and
						(> (gEgo x:) 90)
						(not (rightTop onMe: gEgo))
						(not (rightBtm onMe: gEgo))
					)
					(= local2 0)
					(leftTop dispose:)
					(midTop dispose:)
					(midBtm dispose:)
					(leftBtm dispose:)
					(rightBtm dispose:)
					(rightTop dispose:)
					(gEgo enableHotspot:)
				)
			)
			((and (not local2) (rightBtm onMe: gEgo))
				(= local2 1)
				(leftTop init:)
				(midTop init:)
				(midBtm init:)
				(leftBtm init:)
				(gEgo disableHotspot:)
			)
			((and (not local2) (rightTop onMe: gEgo))
				(= local2 1)
				(leftTop init:)
				(midTop init:)
				(midBtm init:)
				(leftBtm init:)
				(gEgo disableHotspot:)
			)
			((and local1 (!= temp0 (windSound vol:)))
				(windSound setVol: temp0)
				(= local1 0)
			)
			((> (++ local0) 100)
				(= local1 1)
				(= local0 0)
			)
		)
	)

	(method (dispose)
		(windSound stop: dispose:)
		(gEgo enableHotspot:)
		(super dispose:)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 296 100 self)
			)
			(1
				(if (not (IsFlag 364))
					(SetFlag 364)
					(gMessager say: 0 0 1 1 self) ; "(THINKS TO HERSELF)Eeeow. It smells like rotten eggs in here!"
				else
					(self cue:)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookIntoPit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 376)
				(= register (gEgo cycleSpeed:))
				(gEgo
					setScale: 0
					view: 2001
					setLoop: 0
					setCel: 0
					posn: 120 73
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo
					normalize: 1
					posn: 111 73
					cycleSpeed: register
					setScaler: Scaler 100 45 138 57
					setHeading: 180 self
				)
			)
			(3
				(gMessager say: 1 8 2 1 self) ; ""Wow! What an updraft!"
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance touchWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 104)
				(gEgo view: 8805 setLoop: 0 cel: 0 setCycle: CT 11 1 self)
			)
			(1
				(gKqSound1 number: 104 setLoop: 1 play:)
				(= ticks 100)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 2 8 0 1 self) ; "Yuck! What's this? GREEN water!"
			)
			(4
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goGetLantern of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 8773)
				(gEgo setMotion: MoveTo 206 50 self)
			)
			(1
				(gEgo view: 8773 setLoop: 0 cel: 0 setCycle: CT 9 1 self)
			)
			(2
				(gEgo get: 35 setCycle: End self) ; Lantern
				(lantern dispose:)
			)
			(3
				(gEgo normalize: 3 setMotion: MoveTo 211 73 self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance takeSulfur of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 8773)
				(gEgo view: 8773 setLoop: 0 cel: 0 setCycle: CT 9 1 self)
			)
			(1
				(if (not (IsFlag 394))
					((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
					(gMessager say: 3 8 3 1 self) ; "Hmmm...maybe it's sulfur."
				else
					(= ticks 10)
				)
			)
			(2
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo get: 34 setCycle: End self) ; Wet_Sulfur
				(sulfur dispose:)
			)
			(3
				(gEgo normalize: 3 setHeading: 180 self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dipBowl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 68)
				(Load 140 836) ; WAVE
				(Load rsVIEW 2002)
				(gEgo setPri: 100 setMotion: MoveTo 251 88 self)
			)
			(1
				(gEgo
					view: 2002
					setLoop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: CT 5 1 self
				)
				(gKqSound1 number: 836 setLoop: 1 play:)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(gEgo
					normalize: 6
					setPri: 100
					setMotion: MoveTo 251 100 self
				)
			)
			(4
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leaveToForge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 336 83 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 2050)
			)
		)
	)
)

(instance forgeDoor of ExitFeature
	(properties
		nsLeft 289
		nsTop 31
		nsRight 319
		nsBottom 83
		sightAngle 359
		approachX 308
		approachY 91
		x 320
		y 91
		exitDir 6
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb)
		(if (and (== (gEgo x:) approachX) (== (gEgo y:) approachY))
			(gCurRoom setScript: leaveToForge)
		)
		(return 1)
	)
)

(class EmeraldWater of Prop
	(properties
		fixPriority 1
		view 2000
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: setHotspot: 8 10 33 95 setCycle: Fwd) ; Do, Exit, Bowl_a, Bowl_b
	)

	(method (doVerb theVerb)
		(switch theVerb
			(33 ; Bowl_a
				(gCurRoom setScript: dipBowl)
				(self dispose:)
			)
			(95 ; Bowl_b
				(gCurRoom setScript: dipBowl)
				(self dispose:)
			)
			(8 ; Do
				(gCurRoom setScript: touchWater 0 self)
			)
			(else
				(return 0)
			)
		)
		(return 1)
	)
)

(instance greenWater0 of Prop
	(properties
		x 251
		y 62
		view 2000
	)

	(method (init)
		(super init: &rest)
		(self setPri: 71 setCycle: Fwd setHotspot: 0)
	)
)

(instance greenWater1 of EmeraldWater
	(properties
		approachX 242
		approachY 95
		x 268
		y 79
		priority 91
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 33 95) ; Do, Bowl_a, Bowl_b
	)

	(method (doVerb)
		(if (and (== (gEgo x:) approachX) (== (gEgo y:) approachY))
			(super doVerb: &rest)
		)
	)
)

(instance greenWater2 of Prop
	(properties
		x 307
		y 111
		view 2000
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 170 setCycle: Fwd setHotspot: 0)
	)
)

(instance greenWater3 of Prop
	(properties
		x 148
		y 139
		view 2000
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self setPri: 170 setCycle: Fwd setHotspot: 0)
	)
)

(instance greenWater4 of Prop
	(properties
		x 286
		y 130
		view 2000
		loop 4
	)

	(method (init)
		(super init: &rest)
		(self setPri: 170 setCycle: Fwd setHotspot: 0)
	)
)

(instance lantern of View
	(properties
		approachX 206
		approachY 62
		x 206
		y 20
		view 2000
		loop 5
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb)
		(if (and (== (gEgo x:) approachX) (== (gEgo y:) approachY))
			(gCurRoom setScript: goGetLantern)
			(return 1)
		)
	)
)

(instance sulfur of Feature
	(properties
		noun 3
		nsLeft 20
		nsTop 22
		nsRight 40
		nsBottom 62
		approachX 30
		approachY 74
		x 30
		y 30
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb theVerb)
		(cond
			((== (localproc_0) leftTop)
				(gCurRoom setScript: takeSulfur)
			)
			((IsFlag 383)
				(SetFlag 394)
				(gMessager say: noun theVerb 3 1)
			)
			(else
				(SetFlag 383)
				(gMessager say: noun theVerb 2 1)
			)
		)
		(return 1)
	)
)

(instance pitOfWinds of Feature
	(properties
		noun 1
		nsLeft 38
		nsTop 58
		nsRight 110
		nsBottom 128
		approachX 111
		approachY 73
		x 80
		y 66
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb)
		(if (and (== (gEgo x:) approachX) (== (gEgo y:) approachY))
			(gCurRoom setScript: lookIntoPit)
			(self dispose:)
			(return 1)
		)
	)
)

(instance windSound of Sound
	(properties)

	(method (init)
		(super init: &rest)
		(self flags: 5 owner: gCurRoom)
	)
)

(class Ledge of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10) ; Do, Exit
	)
)

(instance leftTop of Ledge
	(properties
		x 48
		y 69
	)

	(method (initialize)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 24 71 53 73 59 68 49 61 54 59 49 57 31 60
					yourself:
				)
		)
	)

	(method (doVerb)
		(gCurRoom
			setScript:
				(switch (localproc_0)
					(leftBtm lB_lT)
					(midBtm mB_lT)
					(rightTop rT_lT)
					(rightBtm rB_lT)
					(else 0)
				)
		)
	)
)

(instance leftBtm of Ledge
	(properties
		x 43
		y 93
	)

	(method (initialize)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 32 85 49 88 55 91 47 98 33 97
					yourself:
				)
		)
	)

	(method (doVerb)
		(gCurRoom
			setScript:
				(switch (localproc_0)
					(leftTop lT_lB)
					(midBtm mB_lB)
					(rightTop rT_lB)
					(rightBtm rB_lB)
					(else 0)
				)
		)
	)
)

(instance midTop of Ledge
	(properties
		x 64
		y 65
	)

	(method (initialize)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 55 61 62 60 72 61 68 66 59 66
					yourself:
				)
		)
	)

	(method (doVerb)
		(gCurRoom
			setScript:
				(switch (localproc_0)
					(leftTop lT_mT)
					(leftBtm lB_mT)
					(midBtm mB_mT)
					(rightTop rT_mT)
					(rightBtm rB_mT)
					(else 0)
				)
		)
	)
)

(instance midBtm of Ledge
	(properties
		x 62
		y 82
	)

	(method (initialize)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 54 77 71 77 74 81 63 87 57 85 51 81
					yourself:
				)
		)
	)

	(method (doVerb)
		(gCurRoom
			setScript:
				(switch (localproc_0)
					(leftTop lT_mB)
					(leftBtm lB_mB)
					(rightTop rT_mB)
					(rightBtm rB_mB)
					(else 0)
				)
		)
	)
)

(instance rightTop of Ledge
	(properties
		nsLeft 73
		nsTop 57
		nsRight 97
		nsBottom 70
		x 87
		y 64
	)

	(method (doVerb)
		(gCurRoom
			setScript:
				(switch (localproc_0)
					(leftTop lT_rT)
					(leftBtm lB_rT)
					(midBtm mB_rT)
					(else 0)
				)
		)
	)
)

(instance rightBtm of Ledge
	(properties
		nsLeft 80
		nsTop 77
		nsRight 107
		nsBottom 93
		sightAngle 359
		x 97
		y 85
	)

	(method (doVerb)
		(gCurRoom
			setScript:
				(switch (localproc_0)
					(leftTop lT_rB)
					(leftBtm lB_rB)
					(midBtm mB_rB)
					(else 0)
				)
		)
	)
)

(instance rB_mB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsSOUND 8640)
				(Load rsVIEW 8905)
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 97 85 self)
			)
			(1
				(gEgo
					view: 8905
					setLoop: 0 1
					cel: 0
					cycleSpeed: 12
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setCycle: CT 10 1 self)
				(gEgo setMotion: MoveTo 62 82 self)
			)
			(3 0)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(midBtm dispose:)
				(rightBtm init:)
				(rightTop init:)
				(gEgo normalize: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mB_lB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsVIEW 8904)
				(gEgo
					view: 8904
					setLoop: 1 1
					cel: 0
					cycleSpeed: 12
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(1
				(gEgo setCycle: CT 10 1 self)
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setMotion: MoveTo 43 93 self)
			)
			(2 0)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(leftBtm dispose:)
				(midBtm init:)
				(gEgo normalize: 4)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lB_mB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsVIEW 8905)
				(gEgo setMotion: MoveTo 43 93 self)
			)
			(1
				(gEgo
					view: 8905
					setLoop: 1 1
					cel: 0
					cycleSpeed: 12
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gEgo setCycle: CT 10 1 self)
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setMotion: MoveTo 62 82 self)
			)
			(3 0)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(midBtm dispose:)
				(leftBtm init:)
				(gEgo normalize: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mB_rB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsVIEW 8904)
				(gEgo
					view: 8904
					setLoop: 0 1
					cel: 0
					cycleSpeed: 12
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(1
				(gEgo setCycle: CT 10 1 self)
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setMotion: MoveTo 97 85 self)
			)
			(2 0)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(rightBtm dispose:)
				(rightTop dispose:)
				(midBtm init:)
				(gEgo normalize: 4)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mB_lT of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsVIEW 8905)
				(gEgo setMotion: MoveTo 62 82 self)
			)
			(1
				(gEgo
					view: 8905
					setLoop: 0 1
					cel: 0
					cycleSpeed: 12
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gEgo setCycle: CT 10 1 self)
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setMotion: MoveTo 48 69 self)
			)
			(3 0)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(midBtm init:)
				(leftTop dispose:)
				(gEgo normalize: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lT_mB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsVIEW 8904)
				(gEgo setMotion: MoveTo 48 69 self)
			)
			(1
				(gEgo
					view: 8904
					setLoop: 0 1
					cel: 0
					cycleSpeed: 12
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setCycle: CT 10 1 self)
				(gEgo setMotion: MoveTo 62 82 self)
			)
			(3 0)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(midBtm dispose:)
				(leftTop init:)
				(gEgo normalize: 4)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rT_mT of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsSOUND 4082)
				(Load rsVIEW 8901)
				(Load rsVIEW 20015)
				(gEgo setMotion: MoveTo 87 64 self)
			)
			(1
				(gEgo
					view: 8901
					setLoop: 1 1
					cel: 0
					cycleSpeed: 12
					moveSpeed: 6
					setStep: 8 6
					setPri: 50
					setCycle: CT 7 1 self
				)
			)
			(2
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setCycle: CT 10 1 self)
				(gEgo setMotion: MoveTo 64 65 self)
			)
			(3 0)
			(4
				(gEgo
					view: 20015
					setLoop: 0 1
					cel: 0
					setPri: 50
					setCycle: CT 1 1 self
				)
			)
			(5
				(gKqSound1 number: 4082 setLoop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(6 0)
			(7
				(EgoDead 60 self 1)
			)
			(8
				(windSound init: number: 2001 setLoop: -1 play: setVol: 126)
				(gEgo posn: 87 64 normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lT_mT of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsSOUND 4082)
				(Load rsVIEW 8901)
				(Load rsVIEW 20015)
				(gEgo setMotion: MoveTo 48 69 self)
			)
			(1
				(gEgo
					view: 8901
					setLoop: 0 1
					cel: 0
					cycleSpeed: 12
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gEgo setCycle: CT 10 1 self)
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setMotion: MoveTo 64 65 self)
			)
			(3 0)
			(4
				(gEgo view: 20015 setLoop: 1 1 cel: 0 setCycle: CT 1 1 self)
			)
			(5
				(gKqSound1 number: 4082 setLoop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(6 0)
			(7
				(EgoDead 60 self 1)
			)
			(8
				(windSound init: number: 2001 setLoop: -1 play: setVol: 126)
				(gEgo posn: 48 69 normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rT_mB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsSOUND 4082)
				(Load rsVIEW 8904)
				(Load rsVIEW 20045)
				(gEgo setMotion: MoveTo 87 64 self)
			)
			(1
				(gEgo
					view: 8904
					setLoop: 1 1
					cel: 0
					cycleSpeed: 12
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setMotion: MoveTo 80 75 self setCycle: CT 10 1 self)
			)
			(3 0)
			(4
				(gEgo view: 20045 setLoop: 1 1 cel: 0 setCycle: CT 1 1 self)
			)
			(5
				(gKqSound1 number: 4082 setLoop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(6 0)
			(7
				(EgoDead 60 self 1)
			)
			(8
				(windSound init: number: 2001 setLoop: -1 play: setVol: 126)
				(gEgo posn: 88 65 normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rT_lT of Script
	(properties)

	(method (init)
		(gCurRoom setScript: rT_mT)
	)
)

(instance lT_rT of Script
	(properties)

	(method (init)
		(gCurRoom setScript: lT_mT)
	)
)

(instance rB_lB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsSOUND 4082)
				(Load rsVIEW 8901)
				(Load rsVIEW 20015)
				(gEgo setMotion: MoveTo 97 85 self)
			)
			(1
				(gEgo
					view: 8901
					setLoop: 1 1
					cel: 0
					cycleSpeed: 10
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setCycle: CT 10 1 self setMotion: MoveTo 70 92 self)
			)
			(3 0)
			(4
				(gEgo view: 20015 setLoop: 1 1 cel: 0 setCycle: CT 1 1 self)
			)
			(5
				(gKqSound1 number: 4082 setLoop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(6 0)
			(7
				(EgoDead 60 self 1)
			)
			(8
				(windSound init: number: 2001 setLoop: -1 play: setVol: 126)
				(gEgo posn: 97 85 normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lB_rB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsSOUND 4082)
				(Load rsVIEW 8901)
				(Load rsVIEW 20015)
				(gEgo setMotion: MoveTo 43 93 self)
			)
			(1
				(gEgo
					view: 8901
					setLoop: 0 1
					cel: 0
					cycleSpeed: 10
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setCycle: CT 10 1 self setMotion: MoveTo 80 92 self)
			)
			(3 0)
			(4
				(gEgo view: 20015 setLoop: 0 1 cel: 0 setCycle: CT 1 1 self)
			)
			(5
				(gKqSound1 number: 4082 setLoop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(6 0)
			(7
				(EgoDead 60 self 1)
			)
			(8
				(windSound init: number: 2001 setLoop: -1 play: setVol: 126)
				(gEgo posn: 40 92 normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lB_lT of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsSOUND 4082)
				(Load rsVIEW 8903)
				(Load rsVIEW 20035)
				(gEgo setMotion: MoveTo 43 93 self)
			)
			(1
				(gEgo
					view: 8903
					setLoop: 0 1
					cel: 0
					cycleSpeed: 10
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setCycle: CT 10 1 self setMotion: MoveTo 43 83 self)
			)
			(3 0)
			(4
				(gEgo
					view: 20035
					setLoop: 0 1
					cel: 0
					posn: 43 86
					setCycle: CT 1 1 self
				)
			)
			(5
				(gKqSound1 number: 4082 setLoop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(6 0)
			(7
				(EgoDead 60 self 1)
			)
			(8
				(windSound init: number: 2001 setLoop: -1 play: setVol: 126)
				(gEgo posn: 43 93 normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lT_lB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsSOUND 4082)
				(Load rsVIEW 8902)
				(Load rsVIEW 20025)
				(gEgo setMotion: MoveTo 48 69 self)
			)
			(1
				(gEgo
					view: 8902
					setLoop: 0 1
					cel: 0
					cycleSpeed: 10
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setCycle: CT 10 1 self setMotion: MoveTo 70 92 self)
			)
			(3 0)
			(4
				(gEgo view: 20025 setLoop: 0 1 cel: 0 setCycle: CT 1 1 self)
			)
			(5
				(gKqSound1 number: 4082 setLoop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(6 0)
			(7
				(EgoDead 60 self 1)
			)
			(8
				(windSound init: number: 2001 setLoop: -1 play: setVol: 126)
				(gEgo posn: 48 69 normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mB_mT of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsSOUND 4082)
				(Load rsVIEW 8903)
				(Load rsVIEW 20035)
				(gEgo setMotion: MoveTo 62 82 self)
			)
			(1
				(gEgo
					view: 8903
					setLoop: 0 1
					cel: 0
					cycleSpeed: 10
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setCycle: CT 10 1 self setMotion: MoveTo 63 73 self)
			)
			(3 0)
			(4
				(gEgo view: 20035 setLoop: 0 1 cel: 0 setCycle: CT 1 1 self)
			)
			(5
				(gKqSound1 number: 4082 setLoop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(6 0)
			(7
				(EgoDead 60 self 1)
			)
			(8
				(windSound init: number: 2001 setLoop: -1 play: setVol: 126)
				(gEgo posn: 62 80 normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rB_lT of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsSOUND 4082)
				(Load rsVIEW 8905)
				(Load rsVIEW 20055)
				(gEgo setMotion: MoveTo 97 85 self)
			)
			(1
				(gEgo
					view: 8905
					setLoop: 0 1
					cel: 0
					cycleSpeed: 10
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setCycle: CT 10 1 self setMotion: MoveTo 60 76 self)
			)
			(3 0)
			(4
				(gEgo view: 20055 setLoop: 0 1 cel: 0 setCycle: CT 1 1 self)
			)
			(5
				(gKqSound1 number: 4082 setLoop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(6 0)
			(7
				(EgoDead 60 self 1)
			)
			(8
				(windSound init: number: 2001 setLoop: -1 play: setVol: 126)
				(gEgo posn: 97 85 normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lT_rB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsSOUND 4082)
				(Load rsVIEW 8904)
				(Load rsVIEW 20015)
				(gEgo setMotion: MoveTo 48 69 self)
			)
			(1
				(gEgo
					view: 8904
					setLoop: 0 1
					cel: 0
					cycleSpeed: 10
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setCycle: CT 10 1 self setMotion: MoveTo 82 81 self)
			)
			(3 0)
			(4
				(gEgo view: 20015 setLoop: 0 1 cel: 0 setCycle: CT 1 1 self)
			)
			(5
				(gKqSound1 number: 4082 setLoop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(6 0)
			(7
				(EgoDead 60 self 1)
			)
			(8
				(windSound init: number: 2001 setLoop: -1 play: setVol: 126)
				(gEgo posn: 48 69 normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lB_mT of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsSOUND 4082)
				(Load rsVIEW 8905)
				(Load rsVIEW 20055)
				(gEgo setMotion: MoveTo 43 93 self)
			)
			(1
				(gEgo
					view: 8905
					setLoop: 1 1
					cel: 0
					cycleSpeed: 10
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setCycle: CT 10 1 self setMotion: MoveTo 58 74 self)
			)
			(3 0)
			(4
				(gEgo
					view: 20055
					setLoop: 1 1
					cel: 0
					posn: 61 75
					setCycle: CT 1 1 self
				)
			)
			(5
				(gKqSound1 number: 4082 setLoop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(6 0)
			(7
				(EgoDead 60 self 1)
			)
			(8
				(windSound init: number: 2001 setLoop: -1 play: setVol: 126)
				(gEgo posn: 41 92 normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lB_rT of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsSOUND 4082)
				(Load rsVIEW 8905)
				(Load rsVIEW 20055)
				(gEgo setMotion: MoveTo 43 93 self)
			)
			(1
				(gEgo
					view: 8905
					setLoop: 1 1
					cel: 0
					cycleSpeed: 10
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setCycle: CT 10 1 self setMotion: MoveTo 77 76 self)
			)
			(3 0)
			(4
				(gEgo
					view: 20055
					setLoop: 1 1
					cel: 0
					posn: 81 77
					setCycle: CT 1 1 self
				)
			)
			(5
				(gKqSound1 number: 4082 setLoop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(6 0)
			(7
				(EgoDead 60 self 1)
			)
			(8
				(windSound init: number: 2001 setLoop: -1 play: setVol: 126)
				(gEgo posn: 41 92 normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mB_rT of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsSOUND 4082)
				(Load rsVIEW 8905)
				(Load rsVIEW 20055)
				(gEgo setMotion: MoveTo 62 82 self)
			)
			(1
				(gEgo
					view: 8905
					setLoop: 1 1
					cel: 0
					cycleSpeed: 10
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setCycle: CT 10 1 self setMotion: MoveTo 78 74 self)
			)
			(3 0)
			(4
				(gEgo view: 20055 setLoop: 1 1 cel: 0 setCycle: CT 1 1 self)
			)
			(5
				(gKqSound1 number: 4082 setLoop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(6 0)
			(7
				(EgoDead 60 self 1)
			)
			(8
				(windSound init: number: 2001 setLoop: -1 play: setVol: 126)
				(gEgo posn: 62 82 normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rT_lB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsSOUND 4082)
				(Load rsVIEW 8904)
				(Load rsVIEW 20045)
				(gEgo setMotion: MoveTo 87 64 self)
			)
			(1
				(gEgo
					view: 8904
					setLoop: 1 1
					cel: 0
					cycleSpeed: 10
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setCycle: CT 10 1 self setMotion: MoveTo 70 83 self)
			)
			(3 0)
			(4
				(gEgo
					view: 20045
					setLoop: 1 1
					cel: 0
					posn: 72 85
					setCycle: CT 1 1 self
				)
			)
			(5
				(gKqSound1 number: 4082 setLoop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(6 0)
			(7
				(EgoDead 60 self 1)
			)
			(8
				(windSound init: number: 2001 setLoop: -1 play: setVol: 126)
				(gEgo posn: 87 65 normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rB_mT of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 8640)
				(Load rsSOUND 4082)
				(Load rsVIEW 8905)
				(Load rsVIEW 20055)
				(gEgo setMotion: MoveTo 97 85 self)
			)
			(1
				(gEgo
					view: 8905
					setLoop: 0 1
					cel: 0
					cycleSpeed: 10
					moveSpeed: 6
					setStep: 8 6
					setCycle: CT 7 1 self
				)
			)
			(2
				(gKqSound1 number: 8640 setLoop: 1 play:)
				(gEgo setCycle: CT 10 1 self setMotion: MoveTo 68 73 self)
			)
			(3 0)
			(4
				(gEgo view: 20055 setLoop: 0 1 cel: 0 setCycle: CT 1 1 self)
			)
			(5
				(gKqSound1 number: 4082 setLoop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(6 0)
			(7
				(EgoDead 60 self 1)
			)
			(8
				(windSound init: number: 2001 setLoop: -1 play: setVol: 126)
				(gEgo posn: 97 85 normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

