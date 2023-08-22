;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use n079)
(use n082)
(use LarryRoom)
(use PolyFeature)
(use Print)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use DPath)
(use Timer)
(use Sound)
(use Motion)
(use Game)
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

(procedure (localproc_0 param1)
	(if (not gSet)
		(= gSet (Set new:))
	)
	(gSet add: ((Cue new:) cuee: param1 cuer: param1 register: 0 yourself:))
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
			setScale: Scaler 100 84 94 43
			init:
		)
		(bottles init:)
		(palmTrees init:)
		(tank init:)
		(mikeStand init:)
		(phallicFruit init:)
		(matchDish init: approachVerbs: 4 1 2 5 6 -1 addToPic:) ; Do, Look, Talk, Take, Zipper, ???
		(barDoor init:)
		(bartender
			init:
			ignoreActors:
			approachVerbs: 2 ; Talk
			setCycle: Walk
			setScript: bartenderScr
		)
		(gNarrator x: -1 y: -1 modeless: 0)
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
							setPri: 9
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
						(if (> (Random 0 100) 50)
							(gGlobalSound1
								number: 514
								loop: 1
								flags: 0
								play: songManager
								hold: 1
							)
						else
							(gGlobalSound1 number: 515 loop: -1 play:)
							(burgundy setCycle: Fwd)
						)
					)
					((!= gPrevRoomNum 520)
						(gGlobalSound2 number: 200 loop: -1 play: 80)
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
					(syncSwimmer1 init: setScript: syncSwimmerScr)
					(syncSwimmer2 init:)
				)
			)
		else
			(gGlobalSound1 number: (if (Random 0 1) 511 else 513) setLoop: -1 play:)
			(if (>= (gGame detailLevel:) 2)
				(waitress init: hide: setScript: waitressScr)
			)
			(SetFlag 3)
		)
		(tray init: stopUpd:)
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
			(SetCursor 218 88)
			(Platform 0 4 3 6)
			(if
				(==
					(Print
						addTitle: 16 0 25 1 510
						addText: 16 0 0 1 0 0 ; "Do you really want to Fast Forward and risk missing a gratuitous sex scene?"
						addButton: 200 16 0 26 1 4 40 ; "Oops"
						addButton: 100 16 0 27 1 126 40 ; "Yes"
						init:
					)
					100
				)
				(gEgo posn: (burgundy approachX:) (burgundy approachY:))
				(burgundy dispose:)
				(if (burgSFX handle:)
					(burgSFX stop:)
				)
				((gInventory at: 17) owner: 510) ; gown
				(gWalkHandler add: stage)
				((ScriptID 0 8) disable:) ; icon5
				(gGame handsOn:)
				(Platform 0 4 2 6)
			else
				(Platform 0 4 2 6)
				(= global170 self)
				((ScriptID 0 8) enable:) ; icon5
			)
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
				(if (or (not (== local1 1)) (!= (gEgo priority:) 8))
					(gEgo setPri: 8)
					(= local1 1)
				)
			)
			((or (not (== local1 0)) (!= (gEgo priority:) 9))
				(gEgo setPri: 9)
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
		(gGlobalSound1 fade:)
		(if (gGlobalSound2 handle:)
			(gGlobalSound2 fade:)
		)
		(garyTimer dispose: delete:)
		(burgWhineTimer dispose: delete:)
		(if (!= local2 0)
			(local2 eachElementDo: #dispose)
			(local2 eachElementDo: #delete)
			(local2 dispose:)
		)
		(DisposeScript 964)
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
		view 514
		x 101
		y 81
		noun 13
	)

	(method (init)
		(super init: &rest)
		(if (== ((gInventory at: 17) owner:) 510) ; gown
			(insetDress init:)
		)
		(Animate (oldCast elements:) 0)
		(SetFlag 86)
		((ScriptID 0 11) init: gCurRoom) ; iconExit
	)

	(method (doit)
		(if script
			(script doit:)
		)
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
		((ScriptID 0 11) dispose:) ; iconExit
		(gEgo startUpd:)
		(super dispose:)
	)
)

(instance bottles of PolyFeature
	(properties
		y 34
		noun 4
		sightAngle 40
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
		x 109
		y 89
		noun 14
		view 514
		loop 1
		priority 15
		signal 17
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
		x 175
		y 108
		noun 8
		sightAngle 40
		approachX 175
		approachY 114
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
			setOnMeCheck:
				2
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
		x 65
		y 7
		sightAngle 40
		approachX 53
		approachY 45
		view 510
		priority 1
		signal 16401
		cycleSpeed 8
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4) ; Do
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(if
				(and
					local0
					(& (gLarryApproachCode doit: (param1 message:)) _approachVerbs)
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
		x 175
		y 117
		noun 5
		sightAngle 40
		approachX 143
		approachY 87
		view 515
		priority 10
		signal 16400
		cycleSpeed 10
	)

	(method (init)
		(if (OneOf global172 28 14)
			(burgundy setPri: 8 view: 516 loop: 0 cel: 8 posn: 157 98 10)
		)
		(super init: &rest)
	)

	(method (cue)
		(if (not (gCurRoom inset:))
			(gMessager say: noun 0 (if local9 16 else 17) 4)
		else
			(burgWhineTimer setReal: self 10)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(9 ; beer
				(if (== global172 14)
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
		x 86
		y 35
		noun 10
		sightAngle 40
		approachX 86
		approachY 50
		view 510
		loop 2
		priority 2
		signal 16400
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(if
				(and
					local0
					(& (gLarryApproachCode doit: (param1 message:)) _approachVerbs)
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
		(gCurRoom setScript: unknown_510_22)
	)
)

(instance cord of View
	(properties
		x 226
		y 117
		sightAngle 40
		approachX 251
		approachY 126
		view 510
		loop 4
		signal 16384
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(if
				(and
					local0
					(& (gLarryApproachCode doit: (param1 message:)) _approachVerbs)
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
		x 226
		y 117
		noun 11
		sightAngle 40
		approachX 251
		approachY 126
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(if
				(and
					local0
					(& (gLarryApproachCode doit: (param1 message:)) _approachVerbs)
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
			setOnMeCheck:
				2
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
				(gMessager say: 7 5 7 1 3 self) ; "You wouldn't want to steal her guitar."
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
		x 175
		y 118
		noun 7
		sightAngle 40
		view 518
		cel 1
		priority 9
		signal 16400
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
			((and (!= theVerb 6) (!= (gLarryApproachCode doit: theVerb) -32768)) ; Zipper
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
			setOnMeCheck:
				2
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
		x 158
		y 35
		noun 9
		sightAngle 40
		view 513
		priority 2
		signal 16
	)

	(method (setHeading param1)
		(self view: 513 heading: param1 setLoop: (if (< param1 180) 3 else 4))
	)

	(method (cue)
		(self setPri: 2 setLoop: 0)
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(= approachX x)
			(= approachY (+ y 22))
			(if
				(and
					local0
					(& (gLarryApproachCode doit: (param1 message:)) _approachVerbs)
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

(instance palmTrees of Feature
	(properties
		noun 2
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(palmPoly1 init:)
		(palmPoly2 init:)
		(palmPoly3 init:)
		(palmPoly4 init:)
		(palmPoly5 init:)
	)

	(method (onMe param1)
		(return
			(or
				(AvoidPath (param1 x:) (param1 y:) palmPoly1)
				(AvoidPath (param1 x:) (param1 y:) palmPoly2)
				(AvoidPath (param1 x:) (param1 y:) palmPoly3)
				(AvoidPath (param1 x:) (param1 y:) palmPoly4)
				(AvoidPath (param1 x:) (param1 y:) palmPoly5)
			)
		)
	)

	(method (dispose)
		(palmPoly1 dispose:)
		(palmPoly2 dispose:)
		(palmPoly3 dispose:)
		(palmPoly4 dispose:)
		(palmPoly5 dispose:)
		(super dispose:)
	)
)

(instance tank of Feature
	(properties
		x 160
		y 24
		noun 3
		nsLeft 96
		nsBottom 19
		nsRight 233
		sightAngle 40
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
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
		x 138
		y 19
		view 512
		cycleSpeed 15
	)

	(method (cue)
		(waitress view: 5125 loop: 0 cel: 0 setCycle: Fwd)
	)
)

(instance gary of Actor
	(properties
		noun 12
		sightAngle 40
		view 5192
		signal 2048
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
			setScale:
		)
		(super init: &rest)
	)

	(method (cue)
		(if (not (gCurRoom inset:))
			(self init: setScript: garyScr)
		else
			(garyTimer setReal: gary 10)
		)
	)
)

(instance unknown_510_22 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gGlobalSound1 number:) 514)
					(gSounds delete: (gGlobalSound1 pause:))
				)
				(= cycles 1)
			)
			(1
				(tray stopUpd:)
				(gEgo stopUpd:)
				(if (gCast contains: gary)
					(gary stopUpd:)
				)
				(if (gCast contains: bartender)
					(bartender stopUpd:)
				)
				(if (gCast contains: burgundy)
					(burgundy stopUpd:)
				)
				(= cycles 1)
			)
			(2
				(gCurRoom setInset: matchInset)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance unknown_510_23 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (gCast contains: burgundy) (== (burgundy view:) 515))
					(burgundy setCycle: Fwd)
				)
				(if
					(and
						(gCast contains: burgundy)
						(or (== (burgundy view:) 517) (== (burgundy view:) 516))
					)
					(burgundy startUpd:)
				)
				(if (== (gGlobalSound1 number:) 514)
					(gGlobalSound1 pause: 0)
				)
				(if (gCast contains: gary)
					(gary startUpd:)
				)
				(= cycles 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance matchInset of Inset
	(properties
		view 5141
		x 220
		y 68
		noun 10
	)

	(method (init)
		(super init: &rest)
		(Platform 0 4 3 6)
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
		(Platform 0 4 2 6)
		(if (== (gGlobalSound1 number:) 514)
			(gSounds add: gGlobalSound1)
		)
		(ClearFlag 86)
		((ScriptID 0 11) dispose:) ; iconExit
		(super dispose:)
		(gCurRoom setScript: unknown_510_23)
	)
)

(instance tray of View
	(properties
		x 81
		y 21
		view 510
		loop 3
		priority 2
		signal 16
	)
)

(instance phallicFruit of Feature
	(properties
		noun 18
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:) init: 156 24 170 24 170 33 156 33 yourself:)
		)
		(super init: &rest)
	)
)

(instance songManager of Script
	(properties)

	(method (cue param1 &tmp [temp0 100])
		(if (IsObject param1)
			(= param1 (param1 prevSignal:))
		)
		(cond
			((not argc)
				(if (!= (gGlobalSound1 prevSignal:) -1)
					(nextSongTimer setReal: self 5)
				else
					(gGlobalSound1 number: 515 loop: -1 play:)
					(burgundy setCycle: Fwd)
				)
			)
			((== param1 127) 0)
			((== param1 100)
				(burgundy cel: 0 setCycle: End)
			)
			((== param1 -1)
				(if register
					(Display {} dsRESTOREPIXELS register)
					(= register 0)
				)
			)
			(local10
				(if register
					(Display {} dsRESTOREPIXELS register)
					(= register 0)
				)
				(cond
					((== param1 2)
						(gGlobalSound1 release:)
					)
					((== param1 14)
						(nextSongTimer setReal: self 20)
					)
				)
				(Message msgGET 510 0 0 23 (+ param1 12) @temp0)
				(= register (Display @temp0 dsCOORD 11 100 dsWIDTH 155 dsCOLOR 47 dsSAVEPIXELS))
			)
			(else
				(if register
					(Display {} dsRESTOREPIXELS register)
					(= register 0)
				)
				(Message msgGET 510 0 0 23 param1 @temp0)
				(= register (Display @temp0 dsCOORD 11 100 dsWIDTH 155 dsCOLOR 47 dsSAVEPIXELS))
				(if (== param1 12)
					(= local10 1)
				)
			)
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
					(gGlobalSound1 client: 0)
				)
				(gCurRoom newRoom: 505)
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
				(localproc_0 self)
			)
			(2
				(gMessager say: 5 0 register 5 self)
			)
			(3
				(= ticks 30)
			)
			(4
				(localproc_0 self)
			)
			(5
				(gMessager say: 5 0 register 6)
			)
			(6
				(gary setMotion: DPath 157 78 112 84 self)
			)
			(7
				(gary loop: 2 cel: 6)
				(= cycles 4)
			)
			(8
				(gary cel: 0)
				(= cycles 4)
			)
			(9
				(gary view: 519 loop: 2 cel: 0 setCycle: End self)
			)
			(10
				(gary view: 5192 loop: 2 cel: 0)
				(= cycles 4)
			)
			(11
				(gary cel: 6)
				(= cycles 4)
			)
			(12
				(gary
					loop: 1
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 87 87 self
				)
			)
			(13
				(if (and (== (burgundy script:) giveBeerScr) (== global181 3))
					(giveBeerScr cue:)
				)
				(gary setMotion: DPath 58 76 28 68 self)
			)
			(14
				(gary hide:)
				(= ticks 120)
			)
			(15
				(gary
					setSpeed: 6
					setStep: 4 3
					setScale: 0
					show:
					setPri: 9
					posn: 28 111
					loop: 0
					setMotion: MoveTo 101 113 self
				)
			)
			(16
				(gary view: 5192 loop: 2 cel: 2 setSpeed: 8 setCycle: Beg self)
			)
			(17
				(= cycles 2)
			)
			(18
				(gary view: 519 loop: 2 cel: 0 setCycle: End self)
			)
			(19
				(= cycles 2)
			)
			(20
				(gary view: 5192 loop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(21
				(= cycles 2)
			)
			(22
				(gary
					loop: 0
					cel: 0
					setCycle: Walk
					setSpeed: 6
					setMotion: MoveTo 175 115 self
				)
			)
			(23
				(gary setSpeed: 8 loop: 2 cel: 2 setCycle: CT 4 1 self)
			)
			(24
				(= ticks 60)
			)
			(25
				(= local11 4)
				(= ticks 20)
			)
			(26
				(burgSFX number: 524 loop: 1 play: 80)
				(if (-- local11)
					(-- state)
				)
				(= ticks 25)
			)
			(27
				(localproc_0 self)
			)
			(28
				(gMessager say: 5 0 register 7 8 self)
			)
			(29
				(gary setCycle: CT 2 -1 self)
			)
			(30
				(gary
					loop: 0
					setCycle: Walk
					setSpeed: 6
					setMotion: MoveTo 226 118 self
				)
			)
			(31
				(if (and (== (burgundy script:) giveBeerScr) (== global181 3))
					(giveBeerScr cue:)
				)
				(gary
					view: 5193
					loop: 0
					cel: 0
					setSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(32
				(burgSFX number: 3 loop: 1 play:)
				(ClearFlag 37)
				(cord cel: 0)
				(gary setCycle: End self)
			)
			(33
				(= ticks 30)
			)
			(34
				(localproc_0 self)
			)
			(35
				(gMessager say: 5 0 register 9 self)
			)
			(36
				(gary
					view: 5192
					loop: 1
					setSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 175 115 self
				)
			)
			(37
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
				(gary setSpeed: 8 loop: 2 cel: 5 setCycle: CT 4 -1 self)
			)
			(1
				(= ticks 30)
			)
			(2
				(= local11 4)
				(= ticks 20)
			)
			(3
				(burgSFX number: 524 loop: 1 play: 127)
				(if (-- local11)
					(-- state)
				)
				(= ticks 25)
			)
			(4
				(localproc_0 self)
			)
			(5
				(sfx number: 521 loop: 1 play: self)
				(gMessager say: 5 0 register 10 self)
			)
			(6
				(sfx number: 521 loop: 1 play:)
			)
			(7
				(localproc_0 self)
			)
			(8
				(gMessager say: 5 0 register 11 self oneOnly: 0)
			)
			(9
				(gary setCycle: CT 5 1 self)
			)
			(10
				(if (and (== (burgundy script:) giveBeerScr) (== global181 3))
					(giveBeerScr cue:)
				)
				(gary
					setSpeed: 6
					loop: 1
					setCycle: Walk
					setMotion: MoveTo 28 111 self
				)
				(= ticks 60)
			)
			(11
				(if (!= (burgundy script:) giveBeerScr)
					(burgundy setScript: backToGuitarScr)
				)
			)
			(12
				(= local9 0)
				(gary dispose:)
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
					setPri: 8
					posn: 39 87
					setMotion: MoveTo 52 104 self
				)
			)
			(2
				(if local3
					(gMessager say: 6 4 6 0 self) ; "You decide to hop up on-stage and let your star quality shine through!"
					(= local3 0)
				else
					(= cycles 2)
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
					setPri: 6
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
				(gEgo loop: 1 cel: 0)
				(= ticks 20)
			)
			(6
				(gEgo normalize: 900 8 1 cel: 7 setPri: -1)
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
					say:
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
				(gGlobalSound2 number: 200 loop: -1 play: 0 fade: 80 25 10 0)
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
					view: 517
					setLoop: 3
					setSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 160 112 self
				)
			)
			(3
				(burgundy setPri: 8 loop: 1 setMotion: MoveTo 157 88 self)
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
					((ScriptID 0 8) enable:) ; icon5
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
				(burgSFX number: 517 loop: -1 play:)
				(burgundy loop: 1 cel: 0 setCycle: Fwd)
				(= ticks 160)
			)
			(4
				(burgSFX stop:)
				(burgundy loop: 0 cel: 3 setCycle: Beg self)
			)
			(5
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
						(gMessager say: 5 0 31 temp0 9 self) ; "Gol dammit, Larry! Ah gotta hava break. Ain' chu got privledges to the sauner?"
					else
						(gMessager say: 5 0 31 temp0 self)
					)
				)
			)
			(6
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
			(7
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
				(gEgo stopUpd:)
				(bartender stopUpd:)
				(= cycles 1)
			)
			(2
				(= global172 3)
				(if (not (IsFlag 215))
					(gMessager say: 5 0 4 6 self) ; "Looks like Gary done fixed mah audjo pro'lem. Time tah head back to the salt mines!"
				else
					(= cycles 2)
				)
			)
			(3
				(gEgo startUpd:)
				(= cycles 1)
			)
			(4
				(burgundy
					view: 516
					loop: 0
					cel: 8
					z: 0
					y: (- (burgundy y:) 10)
					setCycle: Beg self
				)
			)
			(5
				(burgundy
					setSpeed: 6
					view: 517
					setLoop: 2
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 160 112 self
				)
			)
			(6
				(burgundy setPri: 9 setMotion: MoveTo 175 117 self)
			)
			(7
				(burgundy
					setSpeed: 8
					view: 5151
					loop: 0
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(8
				(burgundy setCycle: End self)
				(guitarStand cel: 1)
			)
			(9
				(= global172 1)
				(if (!= (gGlobalSound2 prevSignal:) -1)
					(gGlobalSound2 fade:)
				)
				(gGlobalSound1 number: 515 loop: -1 play:)
				(burgundy view: 515 loop: 0 setSpeed: 10 setCycle: Fwd)
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
					loop: 0
					cel: 8
					y: (- (burgundy y:) 10)
					z: 0
					setCycle: Beg self
				)
			)
			(1
				(burgundy
					setStep: 3 3
					view: 517
					setLoop: 2
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
				(burgundy dispose:)
				((gInventory at: 17) owner: 510) ; gown
				(= global170 0)
				((ScriptID 0 8) disable:) ; icon5
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
				(if
					(or
						(not (OneOf (bartenderScr state:) 1 2 3))
						((waitress cycler:) isKindOf: Fwd)
					)
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
				(bartender setLoop: 0 cel: 2)
				(= ticks 60)
			)
			(5
				(= ticks 180)
			)
			(6
				(waitress view: 5121 loop: 0 cel: 0 setCycle: End self)
			)
			(7
				(waitress setCycle: Beg self)
			)
			(8
				(waitress cue:)
				(bartender loop: 1 setCycle: End self)
			)
			(9
				(bartender loop: 0 cel: 2)
				(waitress view: 5121 loop: 1 setCycle: End self)
			)
			(10
				(waitress setCycle: End self)
			)
			(11
				(waitress cue:)
				(= ticks 30)
			)
			(12
				(waitress view: 5122 loop: 0 setCycle: End self)
			)
			(13
				(waitress setCycle: End self)
			)
			(14
				(waitress cue:)
				(= ticks 30)
			)
			(15
				(waitress view: 5123 loop: 1 cel: 0 setCycle: End self)
			)
			(16
				(waitress hide:)
				(= ticks 120)
			)
			(17
				(= register (waitress y:))
				(waitress
					view: 5123
					loop: 0
					show:
					setLoop: 6
					setPri: 0
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
				(waitress view: 5122 loop: 1 cel: 0 setCycle: End self)
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
					view: 5123
					loop: 0
					setPri: 1
					setCycle: Walk
					setMotion: MoveTo 101 35 self
				)
			)
			(23
				(tray hide:)
				(bartender view: 5131 cel: 0 loop: 1 setCycle: CT 11 1 self)
			)
			(24
				(bartender setCycle: End self)
				(tray show: stopUpd:)
			)
			(25
				(= ticks 10)
			)
			(26
				(bartender view: 513 setMotion: MoveTo 120 36 bartender)
				(= ticks 20)
			)
			(27
				(waitress view: 5123 loop: 1 cel: 1 setCycle: End self)
			)
			(28
				(waitress hide:)
				(= ticks 60)
			)
			(29
				(waitress show: view: 5124 loop: 0 cel: 0 setCycle: End self)
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
				(client setLoop: 2 cel: 0 setCycle: Fwd)
				(= ticks (Random 120 300))
			)
			(5
				(client view: 510 setCycle: 0 setLoop: 1 cel: 0)
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
				(gEgo
					setSpeed: 8
					view: 901
					loop: 6
					cel: 0
					setCycle: End self
				)
			)
			(1
				(sfx number: 518 loop: 1 play:)
				(barDoor view: 5101 setCycle: End self)
				(= ticks 10)
			)
			(2
				(gEgo view: 5101 loop: 2 cel: 0)
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
				(gEgo normalize: 900 8 1 cel: 2)
				(barDoor view: 510 loop: 0 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bottleLookScr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 4 1 0 1 self) ; "The bar has a plentiful supply of healthy beverages:"
			)
			(1
				(gMessager say: 4 1 0 2 self) ; "Poorsappo Japanese-flavoured rice near-beer..."
			)
			(2
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
				(if (and (not (SetFlag 46)) (not register))
					(gMessager say: 5 1 global172 0 self)
				else
					(self cue:)
				)
			)
			(1
				(= ticks 30)
			)
			(2
				(gCurRoom newRoom: 520)
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
					setCycle: End self
				)
				(syncSwimmer2
					view: 5111
					loop: 0
					cel: 0
					posn: 185 3
					show:
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
					setCycle: End self
				)
				(syncSwimmer2
					view: 5112
					loop: 0
					cel: 0
					posn: 184 -5
					show:
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
					setCycle: End self
				)
				(syncSwimmer2
					view: 5113
					loop: 1
					cel: 0
					posn: 184 -5
					show:
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
					setCycle: End self
				)
				(syncSwimmer2
					view: 5114
					loop: 1
					cel: 0
					posn: 147 20
					show:
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
		cel 15
		priority 6
		signal 16400
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
		cel 14
		priority 6
		signal 16400
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
		cel 14
		priority 6
		signal 16400
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
								show:
								cel: 0
								cycleSpeed: (Random 6 15)
								setCycle: End fish1
							)
						)
					)
					(1
						1
						(if (not (fish2 cycler:))
							(fish2
								show:
								cel: 0
								cycleSpeed: (Random 6 15)
								setCycle: End fish2
							)
						)
					)
					(2
						2
						(if (not (fish3 cycler:))
							(fish3
								show:
								cel: 0
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

