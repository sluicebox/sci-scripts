;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 710)
(include sci.sh)
(use Main)
(use PQIconItem)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm710 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 param1 &tmp temp0)
	(if param1
		(gCurRoom style: 5)
		(switch (gCurRoom picture:)
			(0 0)
			(710
				(gCurRoom picture: 713)
				(pipe713 init:)
				(heater713 init:)
				(table713 init:)
				(whiteBoxes713 init:)
				(largeBox713 init:)
				(smallBox713 init:)
				(wall713 init:)
				(floor713 init:)
			)
			(711
				(gCurRoom picture: 710)
				(doorknob710 init:)
				(door710 init:)
				(floor710 init:)
				(map710 init:)
				(wall710 init:)
			)
			(712
				(dogDoor712 dispose:)
				(gCurRoom picture: 711)
				(switch711 init:)
				(door711 init:)
				(wall711 init:)
				(rug711 init:)
				(floor711 init:)
			)
			(713
				(gCurRoom picture: 712)
				(wall712 init:)
				(bucket712 init:)
				(door712 init:)
				(rug712 init:)
				(mirror712 init:)
				(floor712 init:)
				(pipe712 init:)
				(dogDoor712 init:)
			)
		)
		(if local2
			(light x: 1)
		else
			(gEgo x: 1 setMotion: 0)
		)
	else
		(gCurRoom style: 6)
		(switch (gCurRoom picture:)
			(0 0)
			(710
				(gCurRoom picture: 711)
				(switch711 init:)
				(door711 init:)
				(wall711 init:)
				(rug711 init:)
				(floor711 init:)
			)
			(711
				(gCurRoom picture: 712)
				(wall712 init:)
				(bucket712 init:)
				(door712 init:)
				(rug712 init:)
				(mirror712 init:)
				(floor712 init:)
				(pipe712 init:)
				(dogDoor712 init:)
			)
			(712
				(dogDoor712 dispose:)
				(gCurRoom picture: 713)
				(pipe713 init:)
				(heater713 init:)
				(table713 init:)
				(whiteBoxes713 init:)
				(largeBox713 init:)
				(smallBox713 init:)
				(wall713 init:)
				(floor713 init:)
			)
			(713
				(gCurRoom picture: 710)
				(doorknob710 init:)
				(door710 init:)
				(floor710 init:)
				(map710 init:)
				(wall710 init:)
			)
		)
		(if local2
			(light x: 318)
		else
			(gEgo x: 318 setMotion: 0)
		)
	)
	(if local2
		(gGame setCursor: (ScriptID 25 3) 1 (light x:) (light y:)) ; theInvisCursor
	)
	(gCurRoom drawPic: (gCurRoom picture:) (gCurRoom style:))
	(leaveRoom cue:)
)

(instance rm710 of Room
	(properties
		noun 5
		picture 710
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 700)
			((gCaseInv at: 1) owner: 0)
			(gTheIconBar curIcon: (gTheIconBar at: 1))
			(gTheIconBar curInvIcon: 0)
			(gGlobalSound1 number: 1013 loop: 1 play:)
		)
		(if (== gPrevRoomNum 715)
			(= local1 1)
			(gGlobalSound0 number: 725 loop: 1 play:)
		)
		(if (== gPrevRoomNum 670)
			(= picture 0)
			(= modNum 710)
		)
		(gEgo view: 710 setLoop: 1 1 cel: 0 init: setCycle: 0 posn: 222 148)
		(doorknob710 init:)
		(door710 init:)
		(floor710 init:)
		(map710 init:)
		(wall710 init:)
		(gMouseDownHandler addToFront: self)
		(gWalkHandler addToFront: self)
		(gGame handsOn:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
					(== (gTheIconBar curInvIcon:) (gInventory at: 5)) ; vest
				)
				(self setScript: wearVest)
			)
			(
				(or
					(and local2 (> (light x:) 318))
					(and (not local2) (> (gEgo x:) 318))
				)
				(gCurRoom setScript: leaveRoom 0 1)
			)
			(
				(or
					(and local2 (< (light x:) 1))
					(and (not local2) (< (gEgo x:) 1))
				)
				(gCurRoom setScript: leaveRoom 0 0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((& (event type:) evMOVE)
				(if local2
					(event claimed: 0)
					(return)
				else
					(gMessager sayRandom: 5 3 0)
					(event claimed: 0)
					(return)
				)
			)
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
					(== (gTheIconBar curInvIcon:) (gCaseInv at: 4))
					(& (event type:) evMOUSEBUTTON)
					(User canInput:)
					(not (event modifiers:))
				)
				(if (== gPrevRoomNum 670)
					(self setScript: mitchellGetsYou)
				else
					(self setScript: flashlight)
				)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
					(OneOf
						(gTheIconBar curInvIcon:)
						(gInventory at: 31) ; matches
						(gInventory at: 28) ; lighter
					)
					(& (event type:) evMOUSEBUTTON)
					(User canInput:)
					(not (event modifiers:))
				)
				(cond
					((== (gTheIconBar curInvIcon:) (gInventory at: 31)) ; matches
						(if local2
							(self setScript: showMsg 0 0)
						else
							(self setScript: strikeMatch 0 0)
						)
					)
					(local2
						(self setScript: showMsg 0 1)
					)
					(else
						(self setScript: strikeMatch 0 1)
					)
				)
				(event claimed: 1)
				(return)
			)
			(else
				(event claimed: 0)
				(return)
			)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gWalkHandler delete: self)
		(gGame doRemap: 0)
		(gGame doRemap: 2 254 75)
		(super dispose:)
	)
)

(instance wearVest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 3)
			)
			(1
				(gMessager say: 5 15 0 1 self) ; "Putting on your Kevlar vest is a good safety precaution."
			)
			(2
				(gGame handsOn:)
				(gEgo put: 5 0) ; vest
				(self dispose:)
			)
		)
	)
)

(instance mitchellGetsYou of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(gGame setCursor: (ScriptID 25 3) 1) ; theInvisCursor
				(= gMouseX 145)
				(= gMouseY 85)
				((= register (Prop new:))
					view: 711
					loop: 0
					cel: 0
					setPri: 2
					posn: 144 152
					cycleSpeed: 3
					init:
				)
				(SetCursor 139 61 140 62)
				(= local2 1)
				(gGame points: 3 78)
				(light init:)
				(= cycles 1)
			)
			(1
				(gGlobalSound0 number: 670 loop: 1 play:)
				(register setCycle: End self)
			)
			(2
				(ShakeScreen 3)
				(= cycles 1)
			)
			(3
				(register dispose:)
				(light dispose:)
				(= local2 0)
				(gCurRoom drawPic: 0 0)
				(= cycles 1)
			)
			(4
				(for ((= temp0 0)) (< temp0 (gInventory size:)) ((++ temp0))
					(if ((gInventory at: temp0) isKindOf: PQInvItem)
						(gEgo put: temp0)
					)
				)
				(gPqFlags set: 123)
				(= cycles 1)
			)
			(5
				(gGame fadeSpeed: 1)
				(SetCursor -2)
				(gCurRoom newRoom: 745)
			)
		)
	)
)

(instance flashlight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(if local2
					(= local2 0)
					(light dispose:)
				else
					(light init:)
					(= local2 1)
				)
				(= cycles 1)
			)
			(1
				(User canControl: 1 canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance leaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local2
					(= local0 (gTheCursor view:))
					(gGame setCursor: (ScriptID 25 3) 1) ; theInvisCursor
				)
				(if (gCurRoom picture:)
					(gFeatures eachElementDo: #dispose)
				)
				(= cycles 2)
			)
			(1
				(localproc_0 register)
			)
			(2
				(SetCursor -2)
				(if local2
					(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance light of Prop
	(properties
		sightAngle 360
		priority 15
		fixPriority 1
		view 710
		signal 16385
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Talk
				(gMessager sayRandom: 5 2 0)
			)
			(local2
				(gMessager say: 5 6 0 0) ; "What are you attempting to do exactly, Detective?"
			)
			((OneOf theVerb 4 1) ; Do, Look
				(gMessager say: 5 theVerb 1 0)
			)
			(else
				(gMessager say: 5 6 1 0) ; "What do you think you're doing. You can't see anything!"
			)
		)
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(RemapColors 1 253 38 103 132) ; ByRange
		(RemapColors 1 254 38 103 66) ; ByRange
		(= x gMouseX)
		(= y gMouseY)
		(super init:)
		(= yStep 0)
	)

	(method (doit)
		(if (not (gCurRoom script:))
			(= x gMouseX)
			(= y gMouseY)
		)
		(if cycler
			(cycler doit:)
		)
		(UpdateScreenItem self)
	)
)

(instance matchLight of View
	(properties
		sightAngle 360
		priority 15
		fixPriority 1
		view 710
		loop 2
		signal 16385
	)

	(method (init)
		(RemapColors 1 253 38 103 132) ; ByRange
		(RemapColors 1 254 38 103 66) ; ByRange
		(= x gMouseX)
		(= y gMouseY)
		(super init:)
	)
)

(instance strikeMatch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(matchLight init:)
				(= cycles 1)
			)
			(1
				(= seconds 2)
			)
			(2
				(matchLight dispose:)
				(= ticks 60)
			)
			(3
				(if register
					(gMessager say: 0 41 1 0 self) ; "The room is drafty. The flame is blown out."
				else
					(gMessager say: 0 45 1 0 self) ; "The room is drafty. The match is blown out."
				)
			)
			(4
				(User canControl: 1 canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance showMsg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if register
					(gMessager say: 0 41 0 1 self) ; "A draft blows the flame out..."
				else
					(gMessager say: 0 45 0 1 self) ; "Did somebody fart?"
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance doorknob710 of Feature
	(properties
		noun 3
		nsLeft 281
		nsTop 76
		nsRight 289
		nsBottom 81
		sightAngle 360
		x 285
		y 78
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(if local1
					(gGlobalSound1 number: 979 setLoop: 1 play:)
					(gCurRoom newRoom: 715)
				else
					(gMessager say: noun theVerb (if local2 0 else 1) 0)
				)
			)
			((and local2 (== theVerb 1)) ; Look
				(if local1
					(gMessager say: noun theVerb 2 0)
				else
					(super doVerb: theVerb)
				)
			)
			((and local2 (== theVerb 61)) ; casePuttyKnife
				(if local1
					(gMessager say: noun theVerb 2 0)
				else
					(gGame points: 2)
					(gMessager say: noun theVerb 0 0)
					(= local1 1)
				)
			)
			(else
				(light doVerb: theVerb)
			)
		)
	)
)

(instance door710 of Feature
	(properties
		noun 4
		sightAngle 360
		x 262
		y 75
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 232 11 292 7 290 141 231 134
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 4) local2 local1) ; Do
				(gMessager say: noun theVerb 2 0)
			)
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb (if local2 0 else 1) 0)
			)
			((and local2 (== theVerb 1)) ; Look
				(if local1
					(gMessager say: noun theVerb 2 0)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(light doVerb: theVerb)
			)
		)
	)
)

(instance wall710 of Feature
	(properties
		noun 16
		sightAngle 360
		x 105
		y 69
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 0 0 319 0 319 145 0 106 yourself:)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb (if local2 0 else 1) 0)
			)
			((and local2 (== theVerb 1)) ; Look
				(super doVerb: theVerb)
			)
			(else
				(light doVerb: theVerb)
			)
		)
	)
)

(instance map710 of Feature
	(properties
		noun 2
		sightAngle 360
		x 105
		y 69
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 32 15 145 4 176 8 177 126 32 109
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb (if local2 0 else 1) 0)
			)
			((and local2 (== theVerb 1)) ; Look
				(super doVerb: theVerb)
			)
			(else
				(light doVerb: theVerb)
			)
		)
	)
)

(instance floor710 of Feature
	(properties
		noun 1
		sightAngle 360
		x 160
		y 128
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 0 106 319 145 319 152 0 152 yourself:)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb (if local2 0 else 1) 0)
			)
			((and local2 (== theVerb 1)) ; Look
				(super doVerb: theVerb)
			)
			(else
				(light doVerb: theVerb)
			)
		)
	)
)

(instance switch711 of Feature
	(properties
		noun 7
		nsLeft 185
		nsTop 64
		nsRight 192
		nsBottom 68
		sightAngle 360
		x 188
		y 66
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb (if local2 0 else 1) 0)
			)
			((and local2 (== theVerb 1)) ; Look
				(super doVerb: theVerb)
			)
			(else
				(light doVerb: theVerb)
			)
		)
	)
)

(instance door711 of Feature
	(properties
		noun 6
		nsLeft 191
		nsTop 26
		nsRight 243
		nsBottom 109
		sightAngle 360
		x 217
		y 67
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb (if local2 0 else 1) 0)
			)
			((and local2 (== theVerb 1)) ; Look
				(super doVerb: theVerb)
			)
			(else
				(light doVerb: theVerb)
			)
		)
	)
)

(instance wall711 of Feature
	(properties
		noun 16
		sightAngle 360
		x 98
		y 43
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 0 4 287 12 287 106 0 119 yourself:)
		)
	)

	(method (doVerb theVerb)
		(wall710 doVerb: theVerb)
	)
)

(instance rug711 of Feature
	(properties
		noun 8
		sightAngle 360
		x 107
		y 126
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 0 120 203 111 257 129 0 146 yourself:)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb (if local2 0 else 1) 0)
			)
			((and local2 (== theVerb 1)) ; Look
				(super doVerb: theVerb)
			)
			(else
				(light doVerb: theVerb)
			)
		)
	)
)

(instance floor711 of Feature
	(properties
		noun 1
		sightAngle 360
		x 259
		y 141
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 207 111 287 106 319 111 319 152 0 152 0 145 258 130
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(floor710 doVerb: theVerb)
	)
)

(instance wall712 of Feature
	(properties
		noun 16
		nsRight 319
		nsBottom 133
		sightAngle 360
		x 123
		y 5
	)

	(method (doVerb theVerb)
		(wall710 doVerb: theVerb)
	)
)

(instance bucket712 of Feature
	(properties
		noun 10
		sightAngle 360
		x 111
		y 129
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 98 124 103 121 121 121 124 122 120 138 112 141 104 140
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb (if local2 0 else 1) 0)
			)
			((and local2 (== theVerb 1)) ; Look
				(super doVerb: theVerb)
			)
			(else
				(light doVerb: theVerb)
			)
		)
	)
)

(instance door712 of Feature
	(properties
		noun 6
		nsLeft 143
		nsTop 1
		nsRight 290
		nsBottom 132
		sightAngle 360
		x 214
		y 8
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb (if local2 0 else 1) 0)
			)
			((and local2 (== theVerb 1)) ; Look
				(super doVerb: theVerb)
			)
			(else
				(light doVerb: theVerb)
			)
		)
	)
)

(instance rug712 of Feature
	(properties
		noun 8
		sightAngle 360
		x 286
		y 144
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 146 135 319 134 319 153 148 153
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb (if local2 0 else 1) 0)
			)
			((and local2 (== theVerb 1)) ; Look
				(super doVerb: theVerb)
			)
			(else
				(light doVerb: theVerb)
			)
		)
	)
)

(instance dogDoor712 of Feature
	(properties
		noun 9
		nsLeft 169
		nsTop 102
		nsRight 192
		nsBottom 130
		sightAngle 360
		y 132
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb (if local2 0 else 1) 0)
			)
			((and local2 (== theVerb 1)) ; Look
				(super doVerb: theVerb)
			)
			(else
				(light doVerb: theVerb)
			)
		)
	)
)

(instance mirror712 of Feature
	(properties
		noun 14
		sightAngle 360
		x 63
		y 50
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 37 29 92 30 90 140 88 141 87 110 41 112 39 143 34 143
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb (if local2 0 else 1) 0)
			)
			((and local2 (== theVerb 1)) ; Look
				(super doVerb: theVerb)
			)
			(else
				(light doVerb: theVerb)
			)
		)
	)
)

(instance floor712 of Feature
	(properties
		noun 1
		sightAngle 360
		x 63
		y 49
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 0 136 142 134 146 152 0 152 yourself:)
		)
	)

	(method (doVerb theVerb)
		(floor710 doVerb: theVerb)
	)
)

(instance pipe712 of Feature
	(properties
		noun 12
		sightAngle 360
		x 67
		y 23
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 0 23 125 21 132 13 133 0 138 0 138 12 133 19 137 20 137 25 0 30
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 4) (and local2 (== theVerb 1))) ; Do, Look
			(super doVerb: theVerb)
		else
			(light doVerb: theVerb)
		)
	)
)

(instance pipe713 of Feature
	(properties
		noun 12
		sightAngle 360
		x 175
		y 22
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 13 20 25 21 32 16 34 0 38 0 40 12 37 20 130 20 137 14 138 0 144 0 139 19 143 19 319 17 319 22 14 29
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(pipe712 doVerb: theVerb)
	)
)

(instance heater713 of Feature
	(properties
		noun 11
		sightAngle 360
		x 276
		y 46
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 247 15 257 11 283 11 291 12 291 94 286 99 247 95
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 4) (and local2 (== theVerb 1))) ; Do, Look
			(super doVerb: theVerb)
		else
			(light doVerb: theVerb)
		)
	)
)

(instance table713 of Feature
	(properties
		noun 15
		sightAngle 360
		x 132
		y 55
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 229 67 237 73 237 75 235 77 228 78 228 142 224 141 224 119 218 115 219 133 214 133 214 82 203 83 45 83 45 132 40 132 41 116 35 119 33 144 27 145 25 79 16 77 15 75 40 67
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb (if local2 0 else 1) 0)
			)
			((and local2 (== theVerb 1)) ; Look
				(super doVerb: theVerb)
			)
			(else
				(light doVerb: theVerb)
			)
		)
	)
)

(instance whiteBoxes713 of Feature
	(properties
		noun 17
		sightAngle 360
		x 222
		y 59
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 227 44 227 46 230 47 230 50 233 51 233 54 233 62 233 65 232 67 235 67 234 71 212 71 204 70 204 67 205 59 203 57 204 52 205 51 206 46 210 45
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb (if local2 0 else 1) 0)
			)
			((and local2 (== theVerb 1)) ; Look
				(super doVerb: theVerb)
			)
			(else
				(light doVerb: theVerb)
			)
		)
	)
)

(instance largeBox713 of Feature
	(properties
		noun 19
		sightAngle 360
		x 63
		y 56
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 31 55 43 50 45 37 79 37 83 43 84 48 106 48 107 51 95 51 104 60 102 61 90 53 90 73 43 73 43 62 41 61 42 55
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb (if local2 0 else 1) 0)
			)
			((and local2 (== theVerb 1)) ; Look
				(super doVerb: theVerb)
			)
			(else
				(light doVerb: theVerb)
			)
		)
	)
)

(instance smallBox713 of Feature
	(properties
		noun 18
		sightAngle 360
		x 179
		y 66
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 161 57 186 57 191 59 191 71 165 71 161 70
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb (if local2 0 else 1) 0)
			)
			((and local2 (== theVerb 1)) ; Look
				(super doVerb: theVerb)
			)
			(else
				(light doVerb: theVerb)
			)
		)
	)
)

(instance wall713 of Feature
	(properties
		noun 16
		nsRight 319
		nsBottom 130
		sightAngle 360
		x 166
		y 4
	)

	(method (doVerb theVerb)
		(wall710 doVerb: theVerb)
	)
)

(instance floor713 of Feature
	(properties
		noun 1
		nsTop 131
		nsRight 319
		nsBottom 152
		sightAngle 360
		x 173
		y 14
	)

	(method (doVerb theVerb)
		(floor710 doVerb: theVerb)
	)
)

