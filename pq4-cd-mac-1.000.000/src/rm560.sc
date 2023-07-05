;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 560)
(include sci.sh)
(use Main)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm560 0
)

(instance rm560 of Room
	(properties
		picture 560
	)

	(method (init)
		(if (!= gPrevRoomNum 540)
			(gGlobalSound0 number: 983 setLoop: -1 setVol: 90 play:)
		)
		(gGame handsOn:)
		(super init: &rest)
		(namePlate init:)
		(phone init:)
		(inBox init:)
		(leftDrawer init:)
		(rightDrawer init:)
		(if (not (gEgo has: 45)) ; qualifyMemo
			(qualifMemo init:)
		)
		(if (and (gPqFlags test: 35) (not (gEgo has: 0))) ; funeralMemo
			(funeralMemo init:)
		)
		(blotter init:)
		(desk init:)
		(farDesk init:)
		(otherFarDesk init:)
		(gWalkHandler addToFront: self)
		(proc0_4 1)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(self newRoom: 540)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
			(return)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance photo of Feature
	(properties
		noun 5
		nsLeft 74
		nsTop 104
		nsRight 97
		nsBottom 111
		sightAngle 40
		x 85
		y 153
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo get: 41) ; photo
				(gGame points: 2 64)
				(self dispose:)
				(leftDrawer loop: 2)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(leftDrawer doVerb: theVerb)
			)
		)
	)
)

(instance forms of Feature
	(properties
		noun 3
		nsLeft 216
		nsTop 102
		nsRight 252
		nsBottom 108
		sightAngle 40
		x 234
		y 153
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (gEgo has: 44)) ; actionReports
						(gEgo get: 44) ; actionReports
						(rightDrawer setLoop: 5 1)
						(super doVerb: theVerb)
					)
					(((gInventory at: 44) state:) ; actionReports
						(gMessager say: noun theVerb 8) ; "Detective, give the form you have to Hal so he can put it in your murder book."
					)
					(else
						(gMessager say: noun theVerb 3) ; "Detective, your report can fit on the form you already have."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftDrawer of Prop
	(properties
		noun 2
		x 104
		y 143
		view 560
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(super doVerb: theVerb)
			)
			((== theVerb 4) ; Do
				(if (not cel)
					(self setScript: openSelf)
				else
					(self setScript: closeSelf)
				)
			)
			((not cel)
				(gMessager say: noun 0 4) ; "Try opening the drawer first, Detective."
			)
			((== theVerb 57) ; photo
				(photo init:)
				(gEgo put: 41) ; photo
				(= loop 0)
				(gMessager say: noun theVerb 1) ; "The drawer provides safekeeping."
			)
			((== theVerb 67) ; actionReports
				(gMessager say: noun theVerb 1) ; "This form doesn't belong in this drawer, Detective."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance funeralMemo of View
	(properties
		noun 9
		x 69
		y 55
		view 560
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame points: 2)
				(gEgo get: 0) ; funeralMemo
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance qualifMemo of View
	(properties
		noun 8
		x 69
		y 55
		view 560
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame points: 2)
				(gEgo get: 45) ; qualifyMemo
				(gPqFlags set: 19)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightDrawer of Prop
	(properties
		noun 2
		x 213
		y 143
		view 560
		loop 1
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(super doVerb: theVerb)
			)
			((== theVerb 4) ; Do
				(if (not cel)
					(self setScript: openSelf)
				else
					(self setScript: closeSelf)
				)
			)
			((not cel)
				(gMessager say: noun 0 4) ; "Try opening the drawer first, Detective."
			)
			((== theVerb 57) ; photo
				(gMessager say: noun theVerb 7) ; "This drawer holds blank follow-up reports, not personal mementos."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance namePlate of Feature
	(properties
		noun 4
		nsLeft 203
		nsTop 41
		nsRight 240
		nsBottom 73
		sightAngle 40
		x 221
		y 57
	)

	(method (init)
		(= onMeCheck
			((Polygon new:) type: PTotalAccess init: 221 5 222 22 177 25 177 6 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance phone of Feature
	(properties
		noun 6
		nsLeft 203
		nsTop 41
		nsRight 240
		nsBottom 73
		sightAngle 40
		x 221
		y 57
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 200 63 202 55 211 45 246 51 247 60 237 70
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (gPqPointFlags test: 9) (gGame script:))
					(gGame setScript: 0)
					(= global124 2)
				)
				(gGame handsOff:)
				(gCurRoom setScript: phoneScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inBox of Feature
	(properties
		noun 1
		nsLeft 46
		nsTop 46
		nsRight 78
		nsBottom 84
		sightAngle 40
		x 62
		y 25
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 40 58 68 45 93 50 92 66 69 84 41 78
				yourself:
			)
		)
		(super init: &rest)
	)
)

(instance blotter of Feature
	(properties
		noun 12
		x 160
		y 67
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 114 67 203 67 217 90 108 90
					yourself:
				)
		)
	)
)

(instance desk of Feature
	(properties
		noun 11
		x 150
		y 20
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 45 92 79 31 226 31 276 89 271 95 265 99 264 143 207 143 206 103 116 104 116 144 53 143
					yourself:
				)
		)
	)
)

(instance farDesk of Feature
	(properties
		noun 13
		x 36
		y 31
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 36 31 77 31 43 93 45 143 36 144
					yourself:
				)
		)
	)
)

(instance otherFarDesk of Feature
	(properties
		noun 14
		x 229
		y 88
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 229 31 283 32 284 145 279 143 277 88
					yourself:
				)
		)
	)
)

(instance closeSelf of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sfx number: 984 setLoop: 1 play:)
				(if (== client leftDrawer)
					(photo dispose:)
				else
					(forms dispose:)
				)
				(client setCycle: Beg self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openSelf of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sfx number: 984 loop: 1 play:)
				(gGame handsOff:)
				(if (== client leftDrawer)
					(if (not (gEgo has: 41)) ; photo
						(photo init:)
					else
						(client loop: 2)
					)
				else
					(forms init:)
				)
				(client setCycle: End self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sfx of Sound
	(properties
		flags 5
	)
)

(instance phoneScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sfx number: 964 loop: 1 play:)
				(= ticks 120)
			)
			(1
				(gSounds eachElementDo: #pause 1)
				(if (gCast contains: leftDrawer)
					(leftDrawer hide:)
				)
				(qualifMemo hide:)
				(gThePlane drawPic: -1 0)
				(gCurRoom setInset: (ScriptID 33) self) ; pad
			)
			(2
				(gCurRoom drawPic: 560 0)
				(if (gCast contains: qualifMemo)
					(qualifMemo show:)
				)
				(gSounds eachElementDo: #pause 0)
				(if (gCast contains: leftDrawer)
					(leftDrawer show:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
			(3
				(-= state 2)
				(self cue:)
			)
		)
	)
)

