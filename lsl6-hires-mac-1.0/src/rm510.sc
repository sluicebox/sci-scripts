;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use fileScr)
(use n082)
(use LarryRoom)
(use PolyFeature)
(use Print)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm510 0
	bartender 1
	burgundy 2
)

(local
	local0
	local1
	local2
	local3 = 1
	local4
	local5 = 6
	local6
	local7 = -1
	local8
	local9
	local10
	local11
)

(instance rm510 of LarryRoom
	(properties
		noun 1
		picture 510
		horizon 0
		east 505
		south 505
		autoLoad 0
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 245 138 319 139 319 105 267 102 226 92 226 83 287 78 224 54 108 56 65 44 38 46 0 50 0 69 38 69 59 84 70 92 97 97 119 94 146 87 184 86 231 100 245 114 245 125
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 139 63 151 62 227 68 229 76 210 84 139 78
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 266 113 319 112 319 131 269 130
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 39 62 108 62 108 77 60 79 40 66
					yourself:
				)
		)
		(super init: &rest)
		(if (!= gPrevRoomNum 520)
			(ClearFlag 37)
			(= global172 1)
			(= global181 0)
		)
		(cond
			((OneOf global181 2 1)
				(ClearFlag 37)
			)
			((and (== global181 3) (!= global172 28))
				(garyTimer setReal: gary 5)
			)
		)
		(gEgo
			normalize: 900 4
			ignoreActors: 0
			setScaler: Scaler 100 84 94 43
			init:
		)
		(bottles init:)
		(palmTrees init:)
		(tank init:)
		(mikeStand init:)
		(phallicFruit init:)
		(matchDish init: approachVerbs: 4 1 2 5 6 -1) ; Do, Look, Talk, Take, Zipper, ???
		(barDoor init:)
		(bartender
			init:
			ignoreActors:
			approachVerbs: 2 ; Talk
			setCycle: Walk
			setScript: bartenderScr
		)
		(switch gPrevRoomNum
			(520
				(gEgo posn: (burgundy approachX:) (burgundy approachY:))
				(gGame handsOn:)
			)
			(else
				(self setScript: from3DoorHallScr)
			)
		)
		(if (gGlobalSound2 handle:)
			(gGlobalSound2 stop:)
		)
		(cord init: approachVerbs: 1 4) ; Look, Do
		(cordFtr init: approachVerbs: 1 4) ; Look, Do
		(if (IsFlag 3)
			(if (not (IsFlag 215))
				(burgundy init: approachVerbs: 2 1 9) ; Talk, Look, beer
				(if (== gPrevRoomNum 520)
					(if (== global181 1)
						(gary
							init:
							posn: 175 115
							loop: 4
							setPri: 130
							setScript: gary2Scr 0 (if (IsFlag 98) 17 else 16)
						)
					)
					(cond
						((== global172 28)
							(burgundy setScript: giveBeerScr)
						)
						((!= global181 2)
							(= global172 14)
						)
						(else
							(burgundy setScript: backToGuitarScr)
						)
					)
				)
				(cond
					((== global172 1)
						(gGlobalSound1 stop:)
						(gGlobalSound2 stop:)
						(if (> (Random 0 100) 50)
							(gGlobalSound1 number: 514 loop: 1 play: songManager)
						else
							(gGlobalSound1 number: 515 loop: -1 play:)
						)
						(burgundy setCycle: Fwd)
					)
					((!= gPrevRoomNum 520)
						(gGlobalSound2 number: 200 loop: -1 play:)
					)
				)
				(guitarStand init:)
			else
				(gGlobalSound1
					number: (if (Random 0 1) 511 else 513)
					setLoop: -1
					play:
				)
				(if (>= (gGame detailLevel:) 2)
					(syncSwimmer2 init:)
					(syncSwimmer1 init: setScript: syncSwimmerScr)
				)
			)
		else
			(gGlobalSound1 number: (if (Random 0 1) 511 else 513) setLoop: -1 play:)
			(if (>= (gGame detailLevel:) 2)
				(waitress init: hide: setScript: waitressScr)
			)
			(SetFlag 3)
		)
		(tray init:)
		(stage init:)
		(if (>= (gGame detailLevel:) 3)
			(fish1 init: hide: setScript: fishScr)
			(fish2 init: hide:)
			(fish3 init: hide:)
		)
		(if (not (gCast contains: burgundy))
			(gWalkHandler add: stage)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:) 0)
			((== (event message:) JOY_RIGHT)
				(if (and (not (stage onMe: event)) (< (event y:) 139))
					(self doVerb: 3)
					(event claimed: 1)
				)
			)
			(else
				(super handleEvent: event)
			)
		)
		(event claimed:)
	)

	(method (cue &tmp temp0)
		(if inset
			(= temp0 inset)
			(inset dispose:)
			(if (== temp0 dressInset)
				(self setScript: fromBSInset)
			)
		else
			(= global213 gTheCursor)
			(gGame setCursor: gNormalCursor)
			(SetCursor 200 70)
			(if
				(==
					(Print
						width: 150
						font: gUserFont
						addTitle: 16 0 25 1 510
						addText: 16 0 0 1 50 0 ; "Do you really want to Fast Forward and risk missing a gratuitous sex scene?"
						addButton: 100 16 0 27 1 160 33 ; "Yes"
						addButton: 200 16 0 26 1 50 33 ; "Oops"
						x: 30
						y: 20
						addIcon: 1911 0 0 0 0
						init:
					)
					100
				)
				(gEgo posn: (burgundy approachX:) (burgundy approachY:))
				(if global205
					(proc79_7)
				)
				(burgundy dispose:)
				(if (burgSFX handle:)
					(burgSFX stop:)
				)
				((gInventory at: 17) owner: 510) ; gown
				(gWalkHandler add: stage)
				(gTheIconBar disableIcon: (ScriptID 0 8) show:) ; icon5
				(gGame handsOn:)
			else
				(Platform 0 2 1)
				(= global170 self)
				(gTheIconBar enableIcon: (ScriptID 0 8) show:) ; icon5
			)
			(gGame setCursor: global213)
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((or (not local0) script) 0)
			((gEgo inRect: 25 75 76 90)
				(self setScript: fromStageScr)
			)
			((< (gEgo y:) 112)
				(if (or (not (== local1 1)) (!= (gEgo priority:) 117))
					(gEgo setPri: 117)
					(= local1 1)
				)
			)
			((or (not (== local1 0)) (!= (gEgo priority:) 130))
				(gEgo setPri: 130)
				(= local1 0)
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 1) local0) ; Look
				(gMessager say: noun theVerb 11)
			)
			((== theVerb 3) ; Walk
				(gEgo setMotion: PolyPath 42 80)
			)
			(else
				(return (super doVerb: theVerb))
			)
		)
		(return 1)
	)

	(method (edgeToRoom param1)
		(cond
			((and (== param1 3) local0)
				(self setScript: toBSInset)
				(return 0)
			)
			((OneOf param1 2 3)
				(self setScript: toHallScr 0 param1)
				(return 0)
			)
			(else
				(super edgeToRoom: param1)
			)
		)
	)

	(method (dispose)
		(ClearFlag 86)
		(gGlobalSound1 flags: 1)
		(gWalkHandler delete: stage self)
		(gGlobalSound1 stop:)
		(if (gGlobalSound2 handle:)
			(gGlobalSound2 stop:)
		)
		(garyTimer dispose: delete:)
		(burgWhineTimer dispose: delete:)
		(if (!= local2 0)
			(local2 eachElementDo: #dispose)
			(local2 eachElementDo: #delete)
			(local2 dispose:)
		)
		(DisposeScript 64964)
		(super dispose:)
	)
)

(instance toBSInset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						MoveTo
						(- (gEgo x:) 18)
						(+ (gEgo y:) 45)
						self
				)
			)
			(1
				(gCurRoom setInset: dressInset)
				(gEgo edgeHit: EDGE_NONE)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromBSInset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						MoveTo
						(+ (gEgo x:) 18)
						(- (gEgo y:) 48)
						self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dressInset of Inset
	(properties
		picture -2
		view 514
		x 110
		y 24
		noun 13
	)

	(method (init)
		(super init: &rest)
		(gGraphMenuBar state: (| (gGraphMenuBar state:) $0004))
		(if (== ((gInventory at: 17) owner:) 510) ; gown
			(insetDress init:)
		)
		(SetFlag 86)
		((ScriptID 0 11) init: gCurRoom) ; iconExit
		(plane setSize:)
		(UpdatePlane plane)
		(FrameOut)
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 1 5) ; Look, Take
				(if (and (== theVerb 5) (gCast contains: insetDress)) ; Take
					(insetDress doVerb: theVerb)
				else
					(gMessager
						say:
							noun
							theVerb
							(and (not (gCast contains: insetDress)) 13)
					)
				)
			)
			((OneOf theVerb 6 2 4) ; Zipper, Talk, Do
				(super doVerb: theVerb)
			)
			(else
				(gMessager say: noun 0 0) ; "There's not that much to do backstage."
			)
		)
	)

	(method (dispose)
		(ClearFlag 86)
		(gGraphMenuBar state: (& (gGraphMenuBar state:) $fffb))
		((ScriptID 0 11) dispose:) ; iconExit
		(super dispose:)
	)
)

(instance bottles of PolyFeature
	(properties
		noun 4
		sightAngle 40
		y 34
		variableX 1
	)

	(method (init)
		(super init: &rest)
		(self
			addPolygon:
				((Polygon new:)
					init: 121 31 121 18 133 18 139 22 139 33
					yourself:
				)
		)
	)
)

(instance insetDress of View
	(properties
		noun 14
		x 51
		y 35
		priority 200
		fixPriority 1
		view 514
		loop 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Take
			((gCurRoom inset:) setScript: takeGownScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance mikeStand of Feature
	(properties
		noun 8
		sightAngle 40
		approachX 175
		approachY 114
		x 175
		y 108
	)

	(method (onMe param1)
		(return
			(if (super onMe: param1)
				(if local0
					(self approachVerbs: 4 1 2 5 6) ; Do, Look, Talk, Take, Zipper
				else
					(self approachVerbs:)
				)
				1
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					init: 179 76 180 98 188 107 178 116 163 109 171 98 171 77
					yourself:
				)
		)
	)

	(method (doVerb)
		(gMessager say: noun 0 (and local0 11))
	)
)

(instance barDoor of Prop
	(properties
		sightAngle 40
		approachX 53
		approachY 45
		x 65
		y 7
		view 510
		cycleSpeed 8
	)

	(method (init)
		(self setPri: 44)
		(super init: &rest)
		(self approachVerbs: 4) ; Do
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(if
				(and
					local0
					(& (gApproachCode doit: (param1 message:)) _approachVerbs)
				)
				(gEgo setMotion: PolyPath 42 80)
				(= local6 ((gEgo looper:) oldMover:))
				(CueObj client: self theVerb: (param1 message:))
				(param1 claimed: 1)
				(return 0)
			else
				(return 1)
			)
		else
			(return 0)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: enterPoolScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance syncSwimmer1 of Prop
	(properties
		noun 17
		view 511
		cycleSpeed 11
	)
)

(instance syncSwimmer2 of Prop
	(properties
		noun 17
		view 511
		cycleSpeed 11
	)
)

(instance burgundy of Actor
	(properties
		noun 5
		sightAngle 40
		approachX 143
		approachY 87
		x 175
		y 117
		priority 130
		fixPriority 1
		view 515
		cycleSpeed 10
	)

	(method (init)
		(if (OneOf global172 28 14)
			(burgundy
				setPri: 117
				view: 516
				setLoop: 0
				setCel: 8
				posn: 157 98 10
			)
		)
		(super init: &rest)
	)

	(method (cue)
		(if (and (not (gCurRoom inset:)) (gPrints isEmpty:) (gTalkers isEmpty:))
			(gMessager say: noun 0 (if local9 16 else 17) 4)
		else
			(burgWhineTimer setReal: self 10)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(9 ; beer
				(if (== global172 14)
					(if (gTimers contains: burgWhineTimer)
						(burgWhineTimer dispose:)
					)
					(= global173 1)
					(self setScript: goToInsetScr 0 1)
				else
					(super doVerb: theVerb)
				)
			)
			(1 ; Look
				(cond
					((== global172 14)
						(self setScript: goToInsetScr)
					)
					((and (IsFlag 46) (== global172 1))
						(gMessager say: noun theVerb 24) ; "Burgundy is still hard at work... singing her little adenoids off!"
					)
					(else
						(gMessager say: noun theVerb global172)
					)
				)
			)
			(2 ; Talk
				(if (== global172 14)
					(self setScript: goToInsetScr)
				else
					(gMessager say: noun theVerb global172)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance matchDish of View
	(properties
		noun 10
		sightAngle 40
		approachX 84
		approachY 53
		x 86
		y 35
		priority 49
		fixPriority 1
		view 510
		loop 2
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(if
				(and
					local0
					(& (gApproachCode doit: (param1 message:)) _approachVerbs)
				)
				(gEgo setMotion: PolyPath 42 80)
				(= local6 ((gEgo looper:) oldMover:))
				(CueObj client: self theVerb: (param1 message:))
				(param1 claimed: 1)
				(return 0)
			else
				(return 1)
			)
		else
			(return 0)
		)
	)

	(method (doVerb)
		(gCurRoom setInset: matchInset)
	)
)

(instance cord of View
	(properties
		sightAngle 40
		approachX 251
		approachY 126
		x 226
		y 117
		view 510
		loop 4
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(if
				(and
					local0
					(& (gApproachCode doit: (param1 message:)) _approachVerbs)
				)
				(gEgo setMotion: PolyPath 42 80)
				(= local6 ((gEgo looper:) oldMover:))
				(CueObj client: self theVerb: (param1 message:))
				(param1 claimed: 1)
				(return 0)
			else
				(return 1)
			)
		else
			(return 0)
		)
	)

	(method (init)
		(super init: &rest)
		(= cel (if (IsFlag 37) 1))
	)

	(method (doVerb theVerb)
		(cordFtr doVerb: theVerb)
	)
)

(instance cordFtr of Feature
	(properties
		noun 11
		sightAngle 40
		approachX 251
		approachY 126
		x 226
		y 117
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(if
				(and
					local0
					(& (gApproachCode doit: (param1 message:)) _approachVerbs)
				)
				(gEgo setMotion: PolyPath 42 80)
				(= local6 ((gEgo looper:) oldMover:))
				(CueObj client: self theVerb: (param1 message:))
				(param1 claimed: 1)
				(return 0)
			else
				(return 1)
			)
		else
			(return 0)
		)
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					init: 203 106 214 113 243 113 244 121 210 121 201 116 186 112 190 105
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(cond
				((or (gCast contains: gary) (burgundy script:))
					(gMessager say: noun theVerb 20) ; "Don't do that now. You'll get caught!"
				)
				((SetFlag 37)
					(gMessager say: noun theVerb 2) ; "You've already knocked it out. Why plug it back in?"
				)
				(else
					(gCurRoom setScript: unplugCordScr)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance doGuitarJokeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager sayRange: 7 5 7 1 3 self) ; "You wouldn't want to steal her guitar."
			)
			(2
				(sfx number: 522 loop: 1 play:)
				(gMessager say: 7 5 7 4 self) ; "(DRUM FILL SOUNDFX) (drum fill)"
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance guitarStand of View
	(properties
		noun 7
		sightAngle 40
		x 175
		y 118
		view 518
		cel 1
	)

	(method (init)
		(super init: &rest)
		(if (!= global172 1)
			(= cel 0)
		)
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 5) (!= global172 1)) ; Take
				(gCurRoom setScript: doGuitarJokeScr)
			)
			((and (!= theVerb 6) (!= (gApproachCode doit: theVerb) 32768)) ; Zipper
				(gMessager say: noun theVerb (and (!= global172 1) 7))
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stage of Feature
	(properties
		noun 6
		approachX 28
		approachY 60
	)

	(method (onMe param1)
		(return
			(if (super onMe: param1)
				(if (gWalkHandler contains: self)
					(self approachVerbs: 3 4) ; Walk, Do
				else
					(= _approachVerbs 0)
				)
				1
			)
		)
	)

	(method (init)
		(super init: &rest)
		(= sightAngle 26505)
		(self
			setPolygon:
				((Polygon new:)
					type: PContainedAccess
					init: 32 86 37 140 213 140 232 128 235 115 222 101 185 86 144 87 103 97 68 91 44 71 33 79
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(cond
					(local0
						(gMessager say: noun theVerb 11) ; "Solid stage! Good thing, since it's supporting your weight."
					)
					((gCast contains: burgundy)
						(gMessager say: noun theVerb 5) ; "The stage is occupied. And this isn't "New Talent Night!""
					)
					(else
						(gCurRoom setScript: toStageScr)
					)
				)
			)
			((OneOf theVerb 4 1 2 5 6) ; Do, Look, Talk, Take, Zipper
				(gMessager
					say:
						noun
						theVerb
						(cond
							(local0 11)
							((gCast contains: burgundy) 5)
							(else 6)
						)
				)
			)
			((== theVerb 3) ; Walk
				(gCurRoom setScript: toStageScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bartender of Actor
	(properties
		noun 9
		sightAngle 40
		x 158
		y 35
		priority 49
		fixPriority 1
		view 513
		signal 18465
	)

	(method (setHeading param1)
		(self view: 513 heading: param1 setLoop: (if (< param1 180) 3 else 4) 1)
	)

	(method (cue)
		(self setLoop: 0 setCel: 0)
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(= approachX x)
			(= approachY (+ y 22))
			(if
				(and
					local0
					(& (gApproachCode doit: (param1 message:)) _approachVerbs)
				)
				(gEgo setMotion: PolyPath 42 80)
				(= local6 ((gEgo looper:) oldMover:))
				(CueObj client: self theVerb: (param1 message:))
				(param1 claimed: 1)
				(return 0)
			else
				(return 1)
			)
		else
			(return 0)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(if (and (IsFlag 45) (not (IsFlag 214)))
				(gMessager say: noun theVerb 15) ; "Hey, gimme a couple of long-necks."
			else
				(gMessager
					say:
						noun
						theVerb
						(switch
							(if (> (++ local7) 2)
								(= local7 0)
							else
								local7
							)
							(0 8)
							(1 9)
							(2 10)
						)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance palmTrees of PolyFeature
	(properties
		noun 2
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self addPolygon: palmPoly1 palmPoly2 palmPoly3 palmPoly4 palmPoly5)
	)
)

(instance tank of Feature
	(properties
		noun 3
		nsLeft 96
		nsRight 233
		nsBottom 19
		sightAngle 40
		x 160
		y 24
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 128 2 183 1 230 5 230 9 200 24 97 24 96 16 99 6
					yourself:
				)
		)
	)
)

(instance waitress of Actor
	(properties
		x 208
		y 19
		view 512
		signal 18465
		cycleSpeed 15
	)

	(method (init)
		(self setPri: 25)
		(super init:)
	)

	(method (cue)
		(waitress posn: 138 19 view: 5125 loop: 0 cel: 0 setCycle: Fwd)
	)
)

(instance gary of Actor
	(properties
		noun 12
		sightAngle 40
		view 5192
		scaleSignal 4
	)

	(method (init)
		(self
			view: 5192
			loop: 1
			cel: 0
			posn: 328 110
			setSpeed: 6
			setStep: 3 2
			scaleX: 115
			scaleY: 115
			setCycle: Walk
			setPri: -1
			ignoreActors: 1
			setScale:
		)
		(super init: &rest)
	)

	(method (cue)
		(if (not (gCurRoom inset:))
			(self init: setScript: garyScr)
			(garyTimer dispose:)
		else
			(garyTimer setReal: gary 10)
		)
	)
)

(instance matchInset of Inset
	(properties
		picture -2
		view 5141
		x 86
		y 25
		noun 10
	)

	(method (init)
		(if (== (gGlobalSound1 number:) 514)
			(gGlobalSound1 pause:)
		)
		(super init: &rest)
		(gGraphMenuBar state: (| (gGraphMenuBar state:) $0004))
		(SetFlag 86)
		((ScriptID 0 11) init: gCurRoom) ; iconExit
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Take
			(if (not (gEgo has: 25)) ; match
				(gCurRoom setScript: getMatchScr)
			else
				(gMessager say: noun theVerb 21) ; "You already have a match. Let's not be greedy."
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(ClearFlag 86)
		((ScriptID 0 11) dispose:) ; iconExit
		(gGraphMenuBar state: (& (gGraphMenuBar state:) $fffb))
		(super dispose:)
		(if (== (gGlobalSound1 number:) 514)
			(gGlobalSound1 pause: 0)
		)
	)
)

(instance tray of View
	(properties
		x 81
		y 21
		priority 40
		fixPriority 1
		view 510
		loop 3
	)
)

(instance phallicFruit of Feature
	(properties
		noun 18
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) init: 156 24 170 24 170 33 156 33 yourself:)
		)
		(super init: &rest)
	)
)

(instance songManager of Script
	(properties)

	(method (cue)
		(if (not register)
			(nextSongTimer setReal: self 5)
			(burgundy setCycle: 0)
			(= register 1)
		else
			(gGlobalSound1 number: 515 loop: -1 play:)
			(burgundy setCycle: Fwd)
		)
	)
)

(instance takeGownScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo get: 17) ; gown
				(insetDress dispose:)
				(= cycles 2)
			)
			(1
				(gGame changeScore: 13 216)
				(gMessager say: 14 5 (and (IsFlag 66) 12) 0 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getMatchScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 60)
			)
			(1
				(gGame changeScore: 4 217)
				(gEgo get: 25) ; match
				(gMessager say: 10 5 0 0 self) ; "Oh, boy! Free matches."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toStageScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo hide:)
				(= ticks 60)
			)
			(1
				(= local0 1)
				(= local2 (gCurRoom obstacles:))
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						(stage onMeCheck:)
						((Polygon new:)
							type: PBarredAccess
							init: 160 103 193 103 193 114 160 114
							yourself:
						)
				)
				(if (gCast contains: guitarStand)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 185 115 215 115 215 123 185 123
								yourself:
							)
					)
				)
				(gEgo
					show:
					setPri: 117
					posn: 39 87
					setMotion: MoveTo 52 104 self
				)
			)
			(2
				(cond
					((or (gTalkers size:) (Print dialog:))
						(-- state)
						(= ticks 60)
					)
					(local3
						(gMessager say: 6 4 6 0 self) ; "You decide to hop up on-stage and let your star quality shine through!"
						(= local3 0)
					)
					(else
						(= cycles 2)
					)
				)
			)
			(3
				(gWalkHandler delete: stage add: gCurRoom)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromStageScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= register (if (== local6 (gEgo mover:)) 1))
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 39 87 self)
			)
			(1
				(gEgo hide:)
				(= ticks 60)
			)
			(2
				(gEgo show: posn: 16 63 setMotion: MoveTo 45 60 self)
			)
			(3
				(gWalkHandler delete: gCurRoom add: stage)
				(= local0 0)
				(gEgo setPri: -1)
				((gCurRoom obstacles:) delete: (stage onMeCheck:))
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: local2)
				(= local2 0)
				(gGame handsOn:)
				(if register
					(= temp0 (CueObj client:))
					(CueObj state: 0 cycles: 0)
					(gEgo
						setMotion:
							PolyPath
							(temp0 approachX:)
							(temp0 approachY:)
							CueObj
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance unplugCordScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(garyTimer dispose:)
				(gEgo
					view: 5194
					loop: 0
					cel: 0
					setPri: 109
					setSpeed: 13
					setCycle: End self
				)
			)
			(1
				(sfx number: 520 loop: 1 play:)
				(if (burgundy cycler:)
					(burgundy setCycle: End)
				)
				(cord cel: 1)
				(= cycles 2)
				(if (gCast contains: burgundy)
					(gGlobalSound1 stop:)
				)
			)
			(2
				(= ticks 60)
			)
			(3
				(if (gCast contains: burgundy)
					(gGame changeScore: 10 212)
				)
				(gMessager say: 11 4 0 0 self) ; "Oops."
			)
			(4
				(= cycles 2)
			)
			(5
				(gEgo setLoop: 1 setCel: 0)
				(= ticks 20)
			)
			(6
				(gEgo normalize: 900 8 1 setCel: 7 setPri: -1)
				(= cycles 2)
			)
			(7
				(if (not (gCast contains: burgundy))
					(gGame handsOn:)
					(self dispose:)
				else
					(= ticks 60)
				)
			)
			(8
				(burgundy setCycle: 0)
				(= global172 29)
				(gMessager
					sayRange:
						5
						0
						(if (not (SetFlag 51))
							(= local9 1)
							16
						else
							(SetFlag 98)
							17
						)
						1
						2
						self
				)
			)
			(9
				(= ticks 120)
			)
			(10
				(gMessager say: 5 0 (if local9 16 else 17) 3 self)
			)
			(11
				(gGlobalSound2 number: 200 loop: -1 play: fade: 80 25 10 0)
				(client setScript: burgundySitScr)
			)
		)
	)
)

(instance burgundySitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= global172 14)
				(burgundy
					posn: 196 119
					view: 5151
					loop: 0
					cel: 6
					setSpeed: 8
					setCycle: CT 3 -1 self
				)
			)
			(1
				(sfx number: 523 loop: 1 play:)
				(guitarStand cel: 0)
				(burgundy setCycle: Beg self)
			)
			(2
				(burgundy
					posn: 175 117
					view: 517
					setLoop: 3 1
					setSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 160 112 self
				)
			)
			(3
				(burgundy setPri: 117 loop: 1 setMotion: MoveTo 157 88 self)
			)
			(4
				(burgundy
					view: 516
					loop: 0
					cel: 0
					z: 10
					y: (+ (burgundy y:) 10)
					setSpeed: 8
					setCycle: End self
				)
			)
			(5
				(garyTimer setReal: gary 40)
				(burgWhineTimer setReal: burgundy 20)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveBeerScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (IsFlag 214)
					(gGame handsOff:)
					(gGame changeScore: 8 215)
					(= global170 gCurRoom)
					(gTheIconBar enableIcon: (ScriptID 0 8) show:) ; icon5
					(= register 1)
					(++ state)
					(= local5 5)
				else
					(gGame changeScore: 6 214)
					(= register 0)
					(= local5 6)
				)
				(gEgo put: 3 setHeading: 180 self) ; beer
			)
			(1
				(gGame handsOn:)
				(= cycles 2)
			)
			(2
				(burgundy view: 5161 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(burgundy loop: 1 cel: 0 setCycle: Fwd)
				(burgSFX number: 517 loop: -1 play:)
				(= cycles 2)
			)
			(4
				(= ticks 160)
			)
			(5
				(burgSFX stop:)
				(burgundy loop: 0 cel: 3 setCycle: Beg self)
			)
			(6
				(= temp0 (- (if register 6 else 7) local5))
				(if (not register)
					(if (== temp0 6)
						(= cycles 2)
					else
						(gMessager say: 5 0 4 temp0 self)
					)
				else
					(if (== temp0 3)
						(burgSFX number: 516 loop: 1 play:)
					)
					(if (== temp0 5)
						(gMessager sayRange: 5 0 31 temp0 9 self) ; "Gol dammit, Larry! Ah gotta hava break. Ain' chu got privledges to the sauner?"
					else
						(gMessager say: 5 0 31 temp0 self)
					)
				)
			)
			(7
				(if (-- local5)
					(= state 1)
				)
				(cond
					(register
						(= cycles 1)
					)
					((not local5)
						(= ticks 60)
					)
					((OneOf global181 2 1)
						(= ticks 300)
					)
					((gCast contains: gary) 0)
					((== local5 3)
						(gary init: setScript: garyScr)
					)
					(else
						(= ticks 300)
					)
				)
			)
			(8
				(if register
					(client setScript: secondBeerScr)
				else
					(client setScript: backToGuitarScr)
				)
			)
		)
	)
)

(instance backToGuitarScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(= global172 3)
				(if (not (IsFlag 215))
					(gMessager say: 5 0 4 6 self) ; "Looks like Gary done fixed mah audjo pro'lem. Time tah head back to the salt mines!"
				else
					(= cycles 2)
				)
			)
			(2
				(burgundy
					view: 516
					setLoop: 0
					setCel: 8
					z: 0
					y: (- (burgundy y:) 10)
					setCycle: Beg self
				)
			)
			(3
				(burgundy
					setSpeed: 6
					view: 517
					setLoop: 2 1
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 160 112 self
				)
			)
			(4
				(burgundy setPri: 130 setMotion: MoveTo 175 117 self)
			)
			(5
				(burgundy
					posn: 196 119
					setSpeed: 8
					view: 5151
					setLoop: 0
					setCel: 0
					setCycle: CT 3 1 self
				)
			)
			(6
				(burgundy setCycle: End self)
				(guitarStand cel: 1)
			)
			(7
				(= global172 1)
				(if (!= (gGlobalSound2 prevSignal:) -1)
					(gGlobalSound2 fade:)
				)
				(gGlobalSound1 number: 515 loop: -1 play:)
				(burgundy
					posn: 175 117
					view: 515
					setLoop: 0
					setSpeed: 10
					setCycle: Fwd
				)
				(ClearFlag 37)
				(self dispose:)
			)
		)
	)
)

(instance secondBeerScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(burgundy
					view: 516
					setLoop: 0
					setCel: 8
					y: (- (burgundy y:) 10)
					z: 0
					setCycle: Beg self
				)
			)
			(1
				(burgundy
					setStep: 3 3
					view: 517
					setLoop: 2 1
					setCycle: Walk
					setSpeed: 10
					setMotion: MoveTo 98 199 self
				)
				(= cycles 2)
			)
			(2
				(gMessager say: 5 0 31 10) ; "(How colloquial!)"
			)
			(3
				(gMessager say: 5 0 31 11 self) ; "(Guess she's going to take that sixth beer with her! Oh, well. Off to the sauna!)"
			)
			(4
				(gWalkHandler add: stage)
				(if global205
					(proc79_7)
				)
				(burgundy dispose:)
				((gInventory at: 17) owner: 510) ; gown
				(= global170 0)
				(gTheIconBar disableIcon: (ScriptID 0 8) show:) ; icon5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance from3DoorHallScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 325 133 setMotion: MoveTo 311 133 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance waitressScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 300)
			)
			(1
				(waitress show: setCycle: End waitress)
				(= cycles 2)
			)
			(2
				(if (or (bartender mover:) ((waitress cycler:) isKindOf: Fwd))
					(-- state)
				else
					(bartender setScript: 0)
				)
				(= ticks 20)
			)
			(3
				(bartender setLoop: 4)
				(= ticks 15)
			)
			(4
				(bartender setLoop: 0 setCel: 2)
				(= ticks 60)
			)
			(5
				(= ticks 180)
			)
			(6
				(waitress
					posn: 138 19
					view: 5121
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(7
				(waitress setCycle: Beg self)
			)
			(8
				(waitress cue:)
				(bartender setLoop: 1 setCycle: End self)
			)
			(9
				(bartender setLoop: 0 setCel: 2)
				(waitress view: 5121 setLoop: 1 setCycle: End self)
			)
			(10
				(waitress setCycle: End self)
			)
			(11
				(waitress cue:)
				(= ticks 30)
			)
			(12
				(waitress view: 5122 setLoop: 0 setCycle: End self)
			)
			(13
				(waitress setCycle: End self)
			)
			(14
				(waitress cue:)
				(= ticks 30)
			)
			(15
				(waitress
					posn: 125 19
					view: 5123
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(16
				(waitress hide:)
				(= ticks 120)
			)
			(17
				(= register (waitress y:))
				(waitress
					show:
					view: 5123
					setLoop: 0
					y: 44
					setCycle: Fwd
					ignoreActors: 1
					setMotion: MoveTo (waitress x:) register self
				)
			)
			(18
				(= ticks 30)
			)
			(19
				(waitress view: 5122 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(20
				(waitress setCycle: Beg self)
			)
			(21
				(waitress view: 5123 loop: 0 setCycle: Fwd)
				(= ticks 30)
			)
			(22
				(bartender
					view: 513
					loop: 4
					setCycle: Walk
					setMotion: MoveTo 101 35 self
				)
			)
			(23
				(bartender
					posn: 94 35
					view: 5131
					setCel: 0
					setLoop: 1
					setCycle: CT 11 1 self
				)
			)
			(24
				(bartender setCycle: End self)
			)
			(25
				(= ticks 10)
			)
			(26
				(bartender
					posn: 101 35
					view: 513
					setMotion: MoveTo 120 36 bartender
				)
				(= ticks 20)
			)
			(27
				(waitress view: 5123 setLoop: 1 setCel: 1 setCycle: End self)
			)
			(28
				(waitress hide:)
				(= ticks 60)
			)
			(29
				(waitress
					show:
					posn: 150 19
					view: 5124
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(30
				(bartender setScript: bartenderScr)
				(client dispose:)
			)
		)
	)
)

(instance bartenderScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== register -16)
					(self dispose:)
					(gCurRoom setScript: waitressScr)
					(return)
				)
				(= ticks (Random 900 1200))
				(repeat
					(= state (Random 1 3))
					(breakif (!= register state))
				)
				(-- state)
			)
			(1
				(= register 1)
				(client setMotion: MoveTo 181 34 self)
				(= state 3)
			)
			(2
				(= register 2)
				(client setMotion: MoveTo 158 35 self)
				(= state 3)
			)
			(3
				(= register 3)
				(client setMotion: MoveTo 120 36 self)
				(= state 3)
			)
			(4
				(client setLoop: 2 1 cel: 0 setCycle: Fwd)
				(= ticks (Random 120 300))
			)
			(5
				(client view: 510 setCycle: 0 setLoop: 1 1 cel: 0)
				(= cycles 2)
				(= state -1)
			)
		)
	)
)

(instance walkInScr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(barDoor setCycle: End)
				(= ticks 30)
			)
			(2
				(gEgo setMotion: MoveTo 56 53 self)
			)
			(3
				(gEgo setPri: -1)
				(barDoor setCycle: Beg self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterPoolScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gGlobalSound1 handle:)
					(gGlobalSound1 pause:)
				)
				(LoadMany rsVIEW 5101 901)
				(gEgo
					setSpeed: 8
					view: 901
					setLoop: 6
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(sfx number: 518 loop: 1 play:)
				(barDoor view: 5101 setCycle: End self)
				(= ticks 10)
			)
			(2
				(gEgo view: 5101 setLoop: 2 setCel: 0)
			)
			(3
				(= ticks 180)
			)
			(4
				(EgoDead 13 self)
			)
			(5
				(if (gGlobalSound1 handle:)
					(gGlobalSound1 pause: 0)
				)
				(gEgo normalize: 900 8 1 setCel: 2)
				(barDoor view: 510 setLoop: 0 setCel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goToInsetScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= global181
					(if (gCast contains: gary)
						(if (< (garyScr state:) 5) 1 else 2)
					else
						3
					)
				)
				(self cue:)
			)
			(1
				(cond
					((or (gTalkers size:) (Print dialog:))
						(-- state)
						(= ticks 30)
					)
					((and (not (SetFlag 46)) (not register))
						(gMessager say: 5 1 global172 0 self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(= ticks 30)
			)
			(3
				(if (not (or (gTalkers size:) (Print dialog:)))
					(gCurRoom newRoom: 520)
				else
					(-- state)
					(= ticks 30)
				)
			)
		)
	)
)

(instance syncSwimmerScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(syncSwimmer1 hide:)
				(syncSwimmer2 hide:)
				(= state
					(-
						(switch (Random 1 5)
							(1 1)
							(2 2)
							(3 4)
							(4 6)
							(5 8)
						)
						1
					)
				)
				(= ticks (Random 120 900))
			)
			(1
				(syncSwimmer1
					view: 511
					loop: 0
					cel: 0
					posn: 163 14
					show:
					setPri: 24
					setCycle: End self
				)
				(= state -1)
			)
			(2
				(syncSwimmer1
					view: 5111
					loop: 0
					cel: 0
					posn: 140 3
					show:
					setPri: 24
					setCycle: End self
				)
				(syncSwimmer2
					view: 5111
					loop: 0
					cel: 0
					posn: 185 3
					show:
					setPri: 24
					setCycle: End self
				)
			)
			(3
				(= state -1)
			)
			(4
				(syncSwimmer1
					view: 5112
					loop: 0
					cel: 0
					posn: 141 -5
					show:
					setPri: 24
					setCycle: End self
				)
				(syncSwimmer2
					view: 5112
					loop: 0
					cel: 0
					posn: 184 -5
					show:
					setPri: 24
					setCycle: End self
				)
			)
			(5
				(= state -1)
			)
			(6
				(syncSwimmer1
					view: 5113
					loop: 0
					cel: 0
					posn: 141 -5
					show:
					setPri: 24
					setCycle: End self
				)
				(syncSwimmer2
					view: 5113
					loop: 1
					cel: 0
					posn: 184 -5
					show:
					setPri: 24
					setCycle: End self
				)
			)
			(7
				(= state -1)
			)
			(8
				(syncSwimmer1
					view: 5114
					loop: 0
					cel: 0
					posn: 165 8
					show:
					setPri: 24
					setCycle: End self
				)
				(syncSwimmer2
					view: 5114
					loop: 1
					cel: 0
					posn: 147 20
					show:
					setPri: 24
					setCycle: End self
				)
			)
			(9
				(= state -1)
			)
		)
	)
)

(instance fish1 of Prop
	(properties
		x 276
		y 57
		view 5104
		loop 2
		signal 16417
	)

	(method (cue)
		(self hide:)
	)
)

(instance fish2 of Prop
	(properties
		x 276
		y 50
		view 5104
		loop 1
		signal 16417
	)

	(method (cue)
		(self hide:)
	)
)

(instance fish3 of Prop
	(properties
		x 279
		y 64
		view 5104
		signal 16417
	)

	(method (cue)
		(self hide:)
	)
)

(instance fishScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 60 200))
			)
			(1
				(switch (Random 0 2)
					(0
						0
						(if (not (fish1 cycler:))
							(fish1
								setCel: 0
								show:
								setPri: 95
								cycleSpeed: (Random 6 15)
								setCycle: End fish1
							)
						)
					)
					(1
						1
						(if (not (fish2 cycler:))
							(fish2
								setCel: 0
								show:
								setPri: 95
								cycleSpeed: (Random 6 15)
								setCycle: End fish2
							)
						)
					)
					(2
						2
						(if (not (fish3 cycler:))
							(fish3
								setCel: 0
								show:
								setPri: 95
								cycleSpeed: (Random 6 15)
								setCycle: End fish3
							)
						)
					)
				)
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance garyTimer of Timer
	(properties)
)

(instance burgWhineTimer of Timer
	(properties)
)

(instance palmPoly1 of Polygon
	(properties)

	(method (init)
		(super
			init: 0 0 56 0 77 5 48 18 53 29 54 48 42 55 30 64 20 65 5 64 0 62
		)
	)
)

(instance palmPoly2 of Polygon
	(properties)

	(method (init)
		(super
			init: 319 0 319 21 305 30 294 44 284 41 271 40 250 41 236 22 224 11 241 0
		)
	)
)

(instance palmPoly3 of Polygon
	(properties)

	(method (init)
		(super init: 319 90 307 101 294 90 293 77 299 65 314 60 308 55 319 57)
	)
)

(instance palmPoly4 of Polygon
	(properties)

	(method (init)
		(super init: 308 139 289 125 303 105 319 110 319 132)
	)
)

(instance palmPoly5 of Polygon
	(properties)

	(method (init)
		(super
			init: 2 124 11 114 23 115 29 113 27 103 10 86 17 75 25 74 43 82 40 89 49 97 56 100 58 118 48 124 40 122 31 127 23 139 12 140
		)
	)
)

(instance nextSongTimer of Timer
	(properties)
)

(instance sfx of Sound
	(properties
		flags 1
	)
)

(instance burgSFX of Sound
	(properties
		flags 1
	)
)

(instance toHallScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== register 3)
					(gEgo
						setMotion:
							MoveTo
							(+ (gEgo x:) 20)
							(+ (gEgo y:) 60)
							self
					)
				else
					(gEgo
						setMotion:
							MoveTo
							(+ (gEgo x:) 15)
							(+ (gEgo y:) 15)
							self
					)
				)
			)
			(1
				(if (gGlobalSound1 client:)
					(gGlobalSound1 client: 0 number: 0 stop:)
				)
				(if (not (or (gTalkers size:) (Print dialog:)))
					(gCurRoom newRoom: 505)
				else
					(gGame handsOff:)
					(-- state)
					(= ticks 30)
				)
			)
		)
	)
)

(instance garyScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gary setMotion: DPath 319 110 250 104 209 82 self)
				(= register (if local9 16 else 17))
				(= ticks 100)
			)
			(1
				(if
					(and
						(not (or (gTalkers size:) (Print dialog:)))
						(!= (burgundy script:) goToInsetScr)
					)
					(gMessager say: 5 0 register 5 self)
				else
					(-- state)
					(= ticks 30)
				)
			)
			(2
				(= ticks 30)
			)
			(3
				(if
					(and
						(not (or (gTalkers size:) (Print dialog:)))
						(!= (burgundy script:) goToInsetScr)
					)
					(gMessager say: 5 0 register 6)
				else
					(-- state)
					(= ticks 30)
				)
			)
			(4
				(gary setMotion: DPath 157 78 112 84 self)
			)
			(5
				(gary view: 519 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(6
				(gary view: 5192 loop: 2 cel: 0)
				(= cycles 4)
			)
			(7
				(gary
					loop: 1
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 87 87 self
				)
			)
			(8
				(if (and (== (burgundy script:) giveBeerScr) (== global181 3))
					(giveBeerScr cue:)
				)
				(gary setMotion: DPath 58 76 28 68 self)
			)
			(9
				(gary hide:)
				(= ticks 120)
			)
			(10
				(guitarStand setPri: 200)
				(gary
					setSpeed: 6
					setStep: 4 3
					setScale: 0
					show:
					setPri: 130
					posn: 28 111
					loop: 0
					setMotion: MoveTo 101 113 self
				)
			)
			(11
				(gary view: 519 loop: 0 cel: 0 setCycle: End self)
			)
			(12
				(gary
					view: 5192
					setLoop: 0
					setCel: 0
					setCycle: Walk
					setSpeed: 6
					setMotion: MoveTo 175 115 self
				)
			)
			(13
				(gary setSpeed: 8 setLoop: 2 setCel: 2 setCycle: CT 4 1 self)
			)
			(14
				(= local11 4)
				(= ticks 20)
			)
			(15
				(burgSFX number: 524 loop: 1 play:)
				(if (-- local11)
					(-- state)
				)
				(= ticks 25)
			)
			(16
				(if
					(and
						(not (or (gTalkers size:) (Print dialog:)))
						(!= (burgundy script:) goToInsetScr)
					)
					(gMessager sayRange: 5 0 register 7 8 self)
				else
					(-- state)
					(= ticks 30)
				)
			)
			(17
				(gary setCycle: CT 2 -1 self)
			)
			(18
				(gary
					setLoop: 0
					setCycle: Walk
					setSpeed: 6
					setMotion: MoveTo 226 118 self
				)
			)
			(19
				(if (and (== (burgundy script:) giveBeerScr) (== global181 3))
					(giveBeerScr cue:)
				)
				(gary
					view: 5193
					setLoop: 0
					setCel: 0
					setSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(20
				(burgSFX number: 3 loop: 1 play:)
				(ClearFlag 37)
				(cord cel: 0)
				(gary setCycle: End self)
			)
			(21
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(= ticks 30)
			)
			(22
				(if
					(and
						(not (or (gTalkers size:) (Print dialog:)))
						(!= (burgundy script:) goToInsetScr)
					)
					(gMessager say: 5 0 register 9 self)
				else
					(-- state)
					(= ticks 30)
				)
			)
			(23
				(gary
					view: 5192
					setLoop: 1
					setSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 175 115 self
				)
			)
			(24
				(guitarStand setPri: 118)
				(client setScript: gary2Scr 0 register)
			)
		)
	)
)

(instance gary2Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gary setSpeed: 8 setLoop: 2 setCel: 5 setCycle: CT 4 -1 self)
				(= local11 4)
			)
			(1
				(burgSFX number: 524 loop: 1 play:)
				(if (-- local11)
					(-- state)
				)
				(= ticks 25)
			)
			(2
				(gMessager say: 5 0 register 10 self)
			)
			(3
				(gMessager say: 5 0 register 11 self oneOnly: 0)
			)
			(4
				(gGame handsOn:)
				(= seconds 6)
			)
			(5
				(gary setCycle: CT 5 1 self)
			)
			(6
				(if (and (== (burgundy script:) giveBeerScr) (== global181 3))
					(giveBeerScr cue:)
				)
				(gary
					setSpeed: 6
					loop: 1
					setCycle: Walk
					setMotion: MoveTo 28 111 self
				)
			)
			(7
				(if
					(not
						(OneOf
							(burgundy script:)
							goToInsetScr
							giveBeerScr
						)
					)
					(burgundy setScript: backToGuitarScr)
				)
				(= local9 0)
				(gary dispose:)
			)
		)
	)
)

