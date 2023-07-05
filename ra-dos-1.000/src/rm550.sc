;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 550)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use ExitFeature)
(use Inset)
(use Conversation)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm550 0
	eastDoor 2
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm550 of LBRoom
	(properties
		picture 550
		east 560
		south 510
		vanishingX 0
	)

	(method (init)
		(LoadMany rsVIEW 550 552 553 554 831)
		(Load rsSCRIPT 956 939)
		(LoadMany rsSOUND 550 551 553 555 556 558)
		(gEgo init: normalize: 831 setScale: Scaler 110 0 190 0)
		(self setRegions: 90) ; MuseumRgn
		(switch gPrevRoomNum
			(south
				(gEgo x: 160 y: 250)
				(if (and (== gAct 3) (OneOf global111 4 5))
					(= local4 1)
					(embrace init: setScript: sEmbrace)
					(= local1 embrace)
				)
			)
			(east
				(gEgo edgeHit: EDGE_NONE setHeading: 270)
			)
			(else
				(gGame handsOn:)
				(gEgo posn: 60 180)
			)
		)
		(super init:)
		(eastDoor init:)
		(if (IsFlag 97)
			(eastDoor locked: 1 forceClose: 1)
		)
		(if (IsFlag 5)
			(if (gCurRoom obstacles:)
				((gCurRoom obstacles:) dispose:)
			)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 189 236 189 210 143 252 143 248 139 279 139 279 134 244 134 233 124 226 124 223 128 162 128 156 128 147 124 97 122 33 164 0 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 131 125 157 131 170 139 176 151 128 160 89 160 54 156 99 125
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 46 168 51 159 69 161 74 165 67 175 47 173
						yourself:
					)
			)
			(chair cel: 1 approachVerbs: 4 1 8 init: stopUpd:) ; Do, Look, magnifier
			(typeWriter
				cel: 1
				init:
				approachVerbs: 4 1 8 ; Do, Look, magnifier
				posn: 123 158
				addToPic:
			)
			(deskLamp
				setCel: 2
				posn: 57 172
				approachVerbs: 4 1 8 ; Do, Look, magnifier
				addToPic:
				init:
			)
			(wasteBasket init: cel: 1 stopUpd:)
			(hairs init: approachVerbs: 4 1 8 addToPic:) ; Do, Look, magnifier
			(dressShred init: approachVerbs: 4 1 8 addToPic:) ; Do, Look, magnifier
			(if (not (gEgo has: 30)) ; yvette_sShoe
				(shoe init: approachVerbs: 4 1 8 stopUpd:) ; Do, Look, magnifier
			)
			(paperCutter approachVerbs: 4 1 8 init: stopUpd:) ; Do, Look, magnifier
		else
			(if (or (> gAct 3) (and (== gAct 3) (TimeCheck $b102))) ; has 11:15 pm occurred?
				(paperCutter approachVerbs: 4 1 8 init: stopUpd:) ; Do, Look, magnifier
			else
				(paperCutter setLoop: 10 approachVerbs: 4 1 8 init: stopUpd:) ; Do, Look, magnifier
			)
			(chair cel: 0 approachVerbs: 4 1 8 init: stopUpd:) ; Do, Look, magnifier
			(typeWriter
				cel: 0
				init:
				approachVerbs: 4 1 8 ; Do, Look, magnifier
				posn: 100 126
				addToPic:
			)
			(if (IsFlag 40)
				(deskLamp setCel: 0 approachVerbs: 4 1 8 init: addToPic:) ; Do, Look, magnifier
			else
				(deskLamp approachVerbs: 4 1 8 init: addToPic:) ; Do, Look, magnifier
			)
			(wasteBasket init: addToPic: approachVerbs: 4 1 8 stopUpd:) ; Do, Look, magnifier
		)
		(if (== gAct 4)
			(if (not (TimeCheck $2301)) ; has 2:45 am occurred?
				(yvette init:)
				(paperCutter setScript: sErnieDead)
			)
			(if (OneOf global111 12 13)
				(backRub init: setCycle: Fwd)
				(= local1 backRub)
				(paperCutter setScript: sBackRubViewing)
			)
		)
		(if (!= gPrevRoomNum 560)
			(WrapMusic pause: 1)
		)
		(if local4
			(gGameMusic2 number: 551 setLoop: -1 flags: 1 play:)
		else
			(gGameMusic2 number: 550 setLoop: -1 flags: 1 play:)
		)
		(southExitFeature init:)
		(rug init:)
		(desk init:)
		(intercom init:)
		(table init:)
		(cutterBoard init:)
		(floor init:)
		(ceilingLamp init:)
		(axes init:)
		(needlepoint init:)
		(plant init:)
		(transom init:)
		(diploma init:)
		(pic1 init:)
		(pic2 init:)
		(pic3 init:)
		(genericDrawer init:)
		(if (IsFlag 40)
			(= local0 1)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 560)
			(gGameMusic2 fade:)
			(if
				(and
					(== gAct 3)
					(TimeCheck $c304 1) ; can 12:45 am occur?
					(not (TimeCheck $c304)) ; has 12:45 am occurred?
				)
				(= newRoomNumber 565)
			)
		else
			(cond
				((OneOf global111 4 5)
					(= global111 6)
				)
				((OneOf global111 12 13)
					(= global111 14)
				)
			)
			(gGameMusic2 fade:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance olympia of Actor
	(properties
		x 170
		y 250
		view 820
		loop 2
		priority 13
		signal 16
	)
)

(instance eastDoor of Door
	(properties
		x 248
		y 83
		noun 36
		sightAngle 40
		approachX 234
		approachY 135
		view 550
		loop 1
		priority 4
		signal 16
		entranceTo 560
		moveToX 267
		moveToY 135
		enterType 0
		exitType 0
	)

	(method (createPoly)
		(super createPoly: 243 117 266 134 253 142 241 130)
	)

	(method (cue)
		(super cue:)
		(if (and (== state 0) (== local1 embrace))
			(gGame handsOff:)
			(gCurRoom setScript: sBackRubViewing)
		)
	)
)

(instance paperCutter of Prop
	(properties
		x 274
		y 146
		noun 9
		approachX 219
		approachY 187
		view 550
		loop 2
		priority 15
		signal 16
	)

	(method (init)
		(if (IsFlag 88)
			(self cel: (self lastCel:))
		else
			(self cel: 0)
		)
		(super init: &rest)
	)

	(method (cue)
		(super cue: &rest)
		(self stopUpd:)
		(if (== loop 2)
			(gGame points: 1 169)
			(if (not (IsFlag 79))
				(SetFlag 79)
				(self setScript: sOlympiaEnters)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== loop 2)
					(gGame points: 1 169)
					(gMessager say: 9 1 5) ; "A paper cutter with a red blade."
				else
					(gMessager say: 9 1) ; "A paper cutter with a sharp blade."
				)
			)
			(8 ; magnifier
				(if (== loop 2)
					(gGame points: 1 169)
					(gMessager say: 9 8 5) ; "The red stain on the paper cutter blade could be red ink...or blood. Perhaps the last person to use it had an accident?"
				else
					(gMessager say: 9 8) ; "The paper cutter blade looks well-maintained and sharp enough to cut through almost anything."
				)
			)
			(4 ; Do
				(if (== cel 0)
					(SetFlag 88)
					(self setCycle: End self)
				else
					(ClearFlag 88)
					(self setCycle: Beg self)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance embrace of Prop
	(properties
		x 112
		y 147
		view 553
		cel 7
		priority 14
		signal 16
		cycleSpeed 42
	)
)

(instance backRub of Prop
	(properties
		x 135
		y 150
		view 553
		loop 2
		priority 14
		signal 16400
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(0
				(self setScript: sBackRubInterrupted)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance yvette of Prop
	(properties
		x 130
		y 146
		view 554
		loop 1
		cel 12
		priority 14
		signal 16400
		cycleSpeed 12
	)
)

(instance chair of View
	(properties
		x 137
		y 149
		noun 3
		approachX 174
		approachY 157
		view 550
		loop 8
		cel 1
		priority 11
		signal 16
	)
)

(instance typeWriter of View
	(properties
		x 123
		y 158
		noun 4
		approachX 135
		approachY 171
		view 550
		loop 7
		cel 1
		priority 11
		signal 16400
	)
)

(instance deskLamp of View
	(properties
		x 87
		y 130
		noun 5
		approachX 119
		approachY 175
		view 550
		loop 9
		cel 1
		priority 11
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== cel 2)
					(gMessager say: noun theVerb) ; "It's on the floor, but it's actually a desk lamp."
				else
					(gCurRoom setInset: inDeskLamp)
				)
			)
			(8 ; magnifier
				(if (== cel 2)
					(gMessager say: noun theVerb) ; "Since the floor is an odd location for a desk lamp, and since several other desk items have been disturbed, you conclude that the lamp was knocked down during some sort of physical activity that took place on the desk."
				else
					(gCurRoom setInset: inDeskLamp)
				)
			)
			(4 ; Do
				(self doVerb: 1)
			)
			(39 ; carbonPaper
				(if (and (not (IsFlag 40)) (not (IsFlag 64)))
					(gCurRoom setScript: sReadCarbonPaper)
				else
					(gMessager say: noun theVerb 6) ; MISSING MESSAGE
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wasteBasket of View
	(properties
		x 99
		y 155
		noun 7
		approachX 112
		approachY 183
		view 550
		loop 6
		priority 11
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (and (not (gEgo has: 29)) (not (IsFlag 170))) ; carbonPaper
					(gCurRoom setInset: inCarbonPaper)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(4 ; Do
				(if (and (not (gEgo has: 29)) (not (IsFlag 170))) ; carbonPaper
					(gCurRoom setInset: inCarbonPaper)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(8 ; magnifier
				(if (and (not (gEgo has: 29)) (not (IsFlag 170))) ; carbonPaper
					(gCurRoom setInset: inCarbonPaper)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hairs of View
	(properties
		x 98
		y 126
		noun 38
		approachX 104
		approachY 188
		view 550
		loop 3
		cel 1
	)

	(method (init)
		(self setPri: 11)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setInset: inHairs)
			)
			(8 ; magnifier
				(gCurRoom setInset: inHairs)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dressShred of View
	(properties
		x 108
		y 121
		noun 39
		approachX 118
		approachY 184
		view 550
		loop 3
		cel 2
	)

	(method (init)
		(self setPri: 11)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setInset: inDressShred)
			)
			(8 ; magnifier
				(gCurRoom setInset: inDressShred)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shoe of View
	(properties
		x 83
		y 124
		noun 37
		approachX 90
		approachY 186
		view 550
		loop 3
	)

	(method (init)
		(self setPri: 11)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setInset: inShoe)
			)
			(8 ; magnifier
				(gCurRoom setInset: inShoe)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rug of Feature
	(properties
		y 1
		noun 1
		sightAngle 40
		onMeCheck 512
	)
)

(instance desk of Feature
	(properties
		y 1
		noun 2
		sightAngle 40
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(if (IsFlag 5)
			(switch theVerb
				(1 ; Look
					(gMessager say: noun theVerb 8) ; "The desk is in disarray, as if a struggle has occurred here recently."
				)
				(4 ; Do
					(gMessager say: noun theVerb 8) ; "This is a crime scene, so it would be a bad idea to touch the desk surface and leave your fingerprints behind. Imagine trying to explain THAT to the police!"
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance intercom of Feature
	(properties
		y 1
		noun 6
		sightAngle 40
		onMeCheck 4096
	)
)

(instance table of Feature
	(properties
		y 1
		noun 8
		sightAngle 40
		onMeCheck 256
	)
)

(instance cutterBoard of Feature
	(properties
		y 84
		noun 9
		sightAngle 40
		onMeCheck 128
	)
)

(instance floor of Feature
	(properties
		y 1
		noun 10
		sightAngle 40
		onMeCheck 64
	)
)

(instance ceilingLamp of Feature
	(properties
		y 1
		noun 11
		sightAngle 40
		onMeCheck 32
	)
)

(instance axes of Feature
	(properties
		x 123
		y 83
		noun 12
		nsTop 71
		nsLeft 105
		nsBottom 96
		nsRight 142
		sightAngle 40
	)
)

(instance needlepoint of Feature
	(properties
		x 153
		y 93
		noun 13
		nsTop 88
		nsLeft 145
		nsBottom 98
		nsRight 162
		sightAngle 40
	)
)

(instance plant of Feature
	(properties
		x 214
		y 78
		noun 14
		nsTop 72
		nsLeft 208
		nsBottom 84
		nsRight 221
		sightAngle 40
	)
)

(instance transom of Feature
	(properties
		x 252
		y 75
		noun 15
		nsTop 70
		nsLeft 245
		nsBottom 80
		nsRight 259
		sightAngle 40
	)
)

(instance diploma of Feature
	(properties
		x 272
		y 131
		z 34
		noun 16
		nsTop 81
		nsLeft 265
		nsBottom 114
		nsRight 280
		sightAngle 40
	)
)

(instance pic1 of Feature
	(properties
		x 47
		y 76
		noun 17
		nsTop 59
		nsLeft 40
		nsBottom 93
		nsRight 54
		sightAngle 40
	)
)

(instance pic2 of Feature
	(properties
		x 65
		y 92
		noun 18
		nsTop 77
		nsLeft 57
		nsBottom 108
		nsRight 74
		sightAngle 40
	)
)

(instance pic3 of Feature
	(properties
		x 82
		y 84
		noun 19
		nsTop 71
		nsLeft 76
		nsBottom 98
		nsRight 88
		sightAngle 40
	)
)

(instance genericDrawer of Feature
	(properties
		y 1
		sightAngle 40
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 48 theVerb) ; "The wood file drawer is locked. Yvette is the only person who can open it."
			)
			(8 ; magnifier
				(gMessager say: 48 theVerb) ; "The wood file drawer is locked. Yvette is the only person who can open it."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (onMe param1)
		(return
			(and
				(super onMe: param1)
				(cond
					((and (<= 169 gMouseX 180) (<= 96 gMouseY 102))
						(= noun 20)
					)
					((and (<= 181 gMouseX 193) (<= 96 gMouseY 102))
						(= noun 21)
					)
					((and (<= 194 gMouseX 207) (<= 96 gMouseY 102))
						(= noun 22)
					)
					((and (<= 208 gMouseX 221) (<= 96 gMouseY 102))
						(= noun 23)
					)
					((and (<= 169 gMouseX 180) (<= 103 gMouseY 111))
						(= noun 24)
					)
					((and (<= 181 gMouseX 193) (<= 103 gMouseY 111))
						(= noun 25)
					)
					((and (<= 194 gMouseX 207) (<= 103 gMouseY 111))
						(= noun 26)
					)
					((and (<= 208 gMouseX 221) (<= 103 gMouseY 111))
						(= noun 27)
					)
					((and (<= 169 gMouseX 180) (<= 112 gMouseY 122))
						(= noun 28)
					)
					((and (<= 181 gMouseX 193) (<= 112 gMouseY 122))
						(= noun 29)
					)
					((and (<= 194 gMouseX 207) (<= 112 gMouseY 122))
						(= noun 30)
					)
					((and (<= 208 gMouseX 221) (<= 112 gMouseY 122))
						(= noun 31)
					)
					((and (<= 169 gMouseX 180) (<= 123 gMouseY 130))
						(= noun 32)
					)
					((and (<= 181 gMouseX 193) (<= 123 gMouseY 130))
						(= noun 33)
					)
					((and (<= 194 gMouseX 207) (<= 123 gMouseY 130))
						(= noun 34)
					)
					((and (<= 208 gMouseX 221) (<= 123 gMouseY 130))
						(= noun 35)
					)
				)
			)
		)
	)
)

(instance inDeskLamp of Inset
	(properties
		view 550
		loop 5
		x 61
		y 95
		disposeNotOnMe 1
		noun 45
	)

	(method (init)
		(lampCycle init: hide:)
		(if (IsFlag 40)
			(self cel: 1)
		else
			(self cel: 0)
		)
		(if (IsFlag 64)
			(bulbMask init:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (IsFlag 64))
					(self setScript: sDeskLampOnOff)
				else
					(gMessager say: noun theVerb) ; "Since it's missing a lightbulb now, it's pointless to waste time fooling with the desk lamp."
				)
			)
			(1 ; Look
				(if (not (IsFlag 64))
					(gCurRoom setInset: inLightBulb)
				else
					(gMessager say: noun theVerb) ; "It's a standard desk lamp that seems to be missing a lightbulb."
				)
			)
			(8 ; magnifier
				(if (not (IsFlag 64))
					(gCurRoom setInset: inLightBulb)
				else
					(gMessager say: noun theVerb) ; "As indicated by the stamp in the metal base of the standard desk lamp, it was made by the Standard Lamp Company of Standard, Pennsylvania."
				)
			)
			(39 ; carbonPaper
				(if (and (not (IsFlag 40)) (not (IsFlag 64)))
					(gCurRoom setScript: sReadCarbonPaper)
					(self dispose:)
				else
					(gMessager say: noun theVerb 6) ; "You can't read it this way."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(bulbMask dispose:)
		(super dispose:)
	)
)

(instance lampCycle of Prop
	(properties
		x 61
		y 95
		view 550
		loop 4
		priority 15
		signal 16
	)
)

(instance bulbMask of View
	(properties
		x 79
		y 110
		view 550
		loop 5
		cel 2
		priority 14
		signal 16
	)
)

(instance inLightBulb of Inset
	(properties
		view 550
		cel 5
		x 61
		y 95
		disposeNotOnMe 1
		noun 43
	)

	(method (init)
		(if (IsFlag 40)
			(self cel: 3)
		else
			(self cel: 5)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 40)
					(gMessager say: 43 1 4) ; "The light bulb is off."
				else
					(gMessager say: 43 1 3) ; "The light bulb is on. You find it very illuminating."
				)
			)
			(8 ; magnifier
				(self doVerb: 1)
			)
			(4 ; Do
				(cond
					((and local0 (IsFlag 40))
						(gCurRoom setScript: sGetLightBulb)
						(self dispose:)
					)
					((IsFlag 40)
						(gMessager say: 43 4 2) ; "Although the light bulb is starting to cool, it's still too hot to handle."
					)
					(else
						(gMessager say: 43 4 1) ; "OUCH! The lightbulb is too HOT to remove!"
					)
				)
			)
			(39 ; carbonPaper
				(if (not (IsFlag 40))
					(gCurRoom setScript: sReadCarbonPaper)
					(self dispose:)
				else
					(gMessager say: 45 39 6) ; "You can't read it this way."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inCarbonPaper of Inset
	(properties
		view 550
		cel 4
		x 25
		y 145
		disposeNotOnMe 1
		noun 44
	)

	(method (init)
		(if local2
			(self cel: 6)
			(= local2 0)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetCarbonPaper)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inShoe of Inset
	(properties
		view 550
		x 36
		y 111
		disposeNotOnMe 1
		noun 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetShoe)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inHairs of Inset
	(properties
		view 550
		cel 1
		x 48
		y 119
		disposeNotOnMe 1
		noun 41
	)
)

(instance inDressShred of Inset
	(properties
		view 550
		cel 2
		x 58
		y 109
		disposeNotOnMe 1
		noun 42
	)
)

(instance sDeskLampOnOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 40)
					(deskLamp setCel: 1)
					(lampCycle
						init:
						setCel: (lampCycle lastCel:)
						setCycle: CT 5 -1 self
					)
				else
					(deskLamp setCel: 0)
					(lampCycle init: setCel: 0 setCycle: CT 6 1 self)
				)
			)
			(1
				(sFX number: 558 play:)
				(if (IsFlag 40)
					(inDeskLamp cel: 0 drawInset:)
				else
					(inDeskLamp cel: 1 drawInset:)
				)
				(= cycles 1)
			)
			(2
				(if (IsFlag 40)
					(ClearFlag 40)
					(lampCycle setCycle: Beg self)
				else
					(SetFlag 40)
					(lampCycle setCycle: End self)
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(lampCycle dispose: delete:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetLightBulb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (Sound new:))
				(gEgo setMotion: PolyPath 82 156 self)
			)
			(1
				(gEgo
					view: 552
					setLoop: 0
					setCel: 0
					posn: 82 156
					cycleSpeed: 12
					setPri: 13
					setCycle: End self
				)
			)
			(2
				(gEgo setCycle: UnscrewBulb 6 register self)
			)
			(3
				(gEgo get: 23) ; lightBulb
				((ScriptID 21 0) doit: 792) ; addCluesCode, Lightbulb
				(SetFlag 64)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 831 loop: 8 cel: 0)
				(= cycles 1)
			)
			(5
				(gGame handsOn:)
				(register dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sGetCarbonPaper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 85 156 self)
			)
			(1
				(gEgo
					view: 552
					setLoop: 3
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(= ticks 90)
			)
			(3
				(= local2 1)
				(gCurRoom setInset: inCarbonPaper)
				(= ticks 90)
			)
			(4
				(inCarbonPaper dispose:)
				(= ticks 30)
			)
			(5
				(gEgo normalize: 831 loop: 0)
				(gEgo get: 29) ; carbonPaper
				((ScriptID 21 0) doit: 798) ; addCluesCode, Carbon Paper
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetShoe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 71 151 self)
			)
			(2
				(gEgo setHeading: 90)
				(= cycles 15)
			)
			(3
				(gEgo
					view: 552
					setLoop: 1
					setCel: 0
					setPri: 15
					cycleSpeed: 12
					setCycle: CT 3 1 self
				)
			)
			(4
				(shoe dispose:)
				(gEgo setCycle: End self)
				(gEgo setPri: -1)
			)
			(5
				(gEgo get: 30) ; yvette_sShoe
				((ScriptID 21 0) doit: 799) ; addCluesCode, Woman's Shoe
				(gGame points: 1 178)
				(= cycles 3)
			)
			(6
				(gEgo normalize: 831)
				(gEgo setMotion: PolyPath 90 186 self)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkYvette of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 68 148 self)
			)
			(1
				(gEgo
					view: 552
					setLoop: 5
					setCel: 0
					posn: 77 146
					cycleSpeed: 12
					setCycle: ForwardCounter 2 self
				)
			)
			(2
				(yvette setCycle: Fwd)
				(gEgo
					setLoop: 6
					setCel: 0
					posn: 75 146
					setCycle: ForwardCounter 2 self
				)
			)
			(3
				(yvette setCycle: 0)
				(gEgo
					setLoop: 5
					setCel: 0
					posn: 77 146
					setCycle: ForwardCounter 2 self
				)
			)
			(4
				(gEgo normalize: 831 cycleSpeed: 6 posn: 68 148)
				(Face gEgo yvette)
				(= cycles 1)
			)
			(5
				(gEgo setMotion: PolyPath (gEgo x:) 250 self)
			)
			(6
				(gCurRoom newRoom: 510)
			)
		)
	)
)

(instance sEmbraceStop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gGame points: 1 176)
				(embrace cycleSpeed: 6 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 2 0 2 0 self 1550) ; "Oh! Excuse me!"
			)
			(3
				(gEgo setMotion: PolyPath (gEgo x:) 260 self)
			)
			(4
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance sBackRubViewing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if (== local1 backRub)
					(gEgo setMotion: PolyPath 171 183 self)
				else
					(= cycles 1)
				)
			)
			(2
				(Face gEgo backRub)
				(= ticks 300)
			)
			(3
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 556)
				(= ticks 180)
			)
			(4
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 550)
				(= cycles 1)
			)
			(5
				(= ticks 360)
			)
			(6
				(local1 doVerb: 0)
				(self dispose:)
			)
		)
	)
)

(instance sBackRubInterrupted of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 1 177)
				(backRub setLoop: 3 setCel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 3 0 0 0 self 1550) ; "Oh, dear!"
			)
			(2
				(gEgo setMotion: PolyPath (gEgo x:) 250 self)
			)
			(3
				(gCurRoom newRoom: 510)
			)
		)
	)
)

(instance sEmbrace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if local3
					(= cycles 1)
				else
					(gEgo setMotion: PolyPath 172 176 self)
				)
			)
			(2
				(if local3
					(= cycles 1)
				else
					(Face gEgo embrace)
					(= ticks 60)
				)
			)
			(3
				(embrace setCel: 0 cycleSpeed: 24 setCycle: CT 3 1)
				(= ticks (* 3 (Random 60 120)))
			)
			(4
				(embrace setCycle: End)
				(= ticks (* 4 (Random 60 120)))
			)
			(5
				(if (== (++ local3) 2)
					(client setScript: sEmbraceStop)
				else
					(self init:)
				)
			)
		)
	)
)

(instance sReadCarbonPaper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 68 159 self)
			)
			(1
				(gEgo setCycle: StopWalk -1)
				(= ticks 60)
			)
			(2
				(gEgo view: 552 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(= ticks 120)
			)
			(4
				(gMessager say: 45 39 7) ; "Backlit, you can read the words typed into the carbon paper: "Ernie, Big Al called to see if you could do some fencing for him next week. He says he'll make it worth your while to do a fast fencing job.""
				(gGame points: 1 170)
				(= cycles 1)
			)
			(5
				(= ticks 60)
			)
			(6
				(gEgo normalize: 831 loop: 6 cel: 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sErnieDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 15)
			)
			(1
				(gEgo setMotion: PolyPath 160 179 self)
			)
			(2
				(Face gEgo yvette)
				(= cycles 5)
			)
			(3
				(gMessager say: 4 0 0 0 self 1550) ; "My Ernie, he was ze wonderful man! I really loved heem!"
			)
			(4
				(gEgo setMotion: PolyPath 160 270 self)
			)
			(5
				(gCurRoom newRoom: 510)
			)
		)
	)
)

(instance sOlympiaEnters of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 60)
			)
			(1
				(gEgo setHeading: 180)
				(olympia init: setCycle: Walk setMotion: PolyPath 150 186 self)
				(= temp0 (/ (* 110 ((gEgo scaler:) frontSize:)) 100))
				(= temp1 ((gEgo scaler:) frontY:))
				(= temp2 (/ (* 110 (+ 1 ((gEgo scaler:) backSize:))) 100))
				(= temp3 ((gEgo scaler:) backY:))
				(olympia setScale: Scaler temp0 temp2 temp1 temp3)
			)
			(2
				(Face olympia gEgo)
				(Face gEgo olympia)
				(= cycles 1)
			)
			(3
				(olympia setCycle: StopWalk -1)
				(= cycles 1)
			)
			(4
				(olympiaConv
					add: 1550 1 0 1 1 ; "Miss Bow, this is a private office."
					add: 1550 1 0 1 2 ; "Oh! Well, I was just looking around. Have you seen this paper cutter? It looks like it has blood on the blade."
					add: 1550 1 0 1 3 ; "BLOOD?"
					init: self
				)
			)
			(5
				(olympia setCycle: Walk setMotion: PolyPath 194 167 self)
			)
			(6
				(Face gEgo olympia)
				(Face olympia paperCutter)
				(= cycles 1)
			)
			(7
				(olympia setCycle: StopWalk -1)
				(= cycles 1)
			)
			(8
				(= ticks 120)
			)
			(9
				(olympiaConv add: 1550 1 0 1 4 init: self) ; "Oh, that's not blood. You got me all excited. It's probably just red ink. But, if you're worried about Yvette, I just saw her on her way down to Ernie's office in the basement. She goes down there a lot, for some reason."
			)
			(10
				(olympia setCycle: Walk setMotion: PolyPath 150 186 self)
				(= seconds 3)
			)
			(11
				(olympiaConv add: 1550 1 0 1 5 init:) ; "Maybe she's fond of Ernie?"
			)
			(12
				(olympia setCycle: StopWalk -1)
			)
			(13
				(Face gEgo olympia)
				(Face olympia gEgo)
				(= cycles 1)
			)
			(14
				(olympiaConv add: 1550 1 0 1 6 init: self) ; "Yvette is fond of EVERYONE, my dear. Now, if you'll excuse me, I have some business to attend to."
			)
			(15
				(olympia
					setCycle: Walk
					setMotion: PolyPath (olympia x:) 250 self
				)
			)
			(16
				(Face gEgo olympia)
				(= cycles 1)
			)
			(17
				(= ticks 120)
			)
			(18
				(olympia dispose:)
				(Face gEgo paperCutter)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(class UnscrewBulb of Osc
	(properties
		soundOsc 1
	)

	(method (doit &tmp temp0)
		(if (or (> (= temp0 (self nextCel:)) 8) (< temp0 7))
			(= cycleDir (- cycleDir))
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)

	(method (init param1 param2 param3 param4)
		(if (>= argc 2)
			(= howManyCycles param2)
			(if (>= argc 3)
				(= soundOsc param3)
				(if (>= argc 4)
					(= caller param4)
				)
			)
		)
		(super init: param1 param2 param4)
	)

	(method (cycleDone)
		(soundOsc number: 553 play:)
		(super cycleDone:)
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

(instance southExitFeature of ExitFeature
	(properties
		nsTop 184
		nsBottom 189
		nsRight 247
		cursor 11
		exitDir 3
		noun 49
	)
)

(instance olympiaConv of Conversation
	(properties)
)

