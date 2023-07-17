;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use TellerIcon)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Flags)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm310 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0)
	(= temp0 -1)
	(while (< temp0 100)
		(++ temp0)
		(if (Message msgSIZE param2 param1 param3 temp0 1)
			(++ local0)
			(if (Message msgSIZE param2 param1 param3 temp0 2)
				(localproc_0
					(Message 4 param2 param1 param3 temp0 2) ; msgREF_NOUN
					param2
					param3
				)
			)
		)
	)
)

(procedure (localproc_1 param1 param2 param3 &tmp temp0)
	(= temp0 -1)
	(while (< temp0 100)
		(++ temp0)
		(if local2
			(break)
		)
		(if (Message msgSIZE 310 param1 5 temp0 1)
			(if (and (== param2 param1) (== temp0 param3))
				(= local2 1)
				(break)
			)
			(++ local1)
			(if (Message msgSIZE 310 param1 5 temp0 2)
				(localproc_1 (Message 4 310 param1 5 temp0 2) param2 param3) ; msgREF_NOUN
			)
		)
	)
)

(instance rm310 of Room
	(properties
		picture 310
	)

	(method (init)
		(proc0_4 0)
		(gGame handsOff:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 163 142 157 130 319 130 319 122 266 122 259 120 244 120 240 123 86 123 78 120 62 120 57 122 0 122 0 130 150 130 157 145 204 146 319 145 319 142 205 143
					yourself:
				)
		)
		(super init: &rest)
		(kittyBldg init:)
		(raginBldg init:)
		(kittySign init:)
		(sidewalk init:)
		(sky init:)
		(switch gPrevRoomNum
			(315
				(gEgo
					x: 250
					y: 122
					heading: 180
					normalize: 0
					setScaler: Scaler 74 48 145 121
					init:
				)
				(if (not (gPqFlags test: 145))
					(gPqFlags set: 145)
					(rod
						view: 311
						setSpeed: 0
						setLoop: 0
						cel: 0
						x: 252
						y: 144
						init:
						setScript: breakAndRun
					)
				else
					(gGame handsOn:)
				)
			)
			(335
				(if (not (gPqFlags test: 145))
					(localproc_0 (rod noun:) 310 5)
					(tatTell init: rod 310 13 5)
					(rod init: setScript: loiter approachVerbs: 2 27) ; Talk, badge
				)
				(gGame handsOn:)
				(gEgo
					x: 65
					y: 121
					heading: 180
					normalize: 0
					setScaler: Scaler 74 48 145 121
					init:
				)
			)
			(else
				(sFx init: number: 917 setLoop: 1 play:)
				(if (not (gPqFlags test: 145))
					(if (not (gPqFlags test: 146))
						(gPqFlags set: 146)
						(rod init: approachVerbs: 2 27) ; Talk, badge
						(localproc_0 (rod noun:) 310 5)
						((= gFlags (Flags new:)) size: local0 init:)
						(gEgo setScript: firstTalk)
					else
						(localproc_0 (rod noun:) 310 5)
						(tatTell init: rod 310 13 5)
						(rod init: setScript: loiter)
						(gGame handsOn:)
					)
				else
					(gGame handsOn:)
				)
				(gEgo
					x: 245
					y: 145
					heading: 270
					normalize: 0
					setScaler: Scaler 74 48 145 121
					init:
				)
			)
		)
		(if
			(and
				(gPqFlags test: 145)
				(not (gEgo has: 8)) ; mirror
				(not (gEgo has: 35)) ; stickMirror
			)
			(mirror init: approachVerbs: 4) ; Do
		)
		(car init: approachVerbs: 4) ; Do
		(trunk init: approachVerbs: 4 46) ; Do, keys
		(ragin init: approachVerbs: 4) ; Do
		(kitty init: approachVerbs: 4) ; Do
		(self setScript: soundScript)
	)

	(method (doit)
		(super doit:)
		(cond
			((< (gEgo x:) 10)
				(gEgo setMotion: 0 x: 10)
				(gMessager say: 4 76 0) ; "You've got a job to do, don't wander off!"
			)
			((> (gEgo x:) 310)
				(gEgo setMotion: 0 x: 310)
				(if (== (rod script:) breakAndRun)
					(gMessager say: 4 76 5) ; "Before you go after him, check to see if there's any damage to the car."
				else
					(gMessager say: 4 76 0) ; "You've got a job to do, don't wander off!"
				)
			)
			(local3
				(if (> (gEgo y:) 136)
					(= local3 0)
					(trunk approachY: 141)
				)
			)
			((< (gEgo y:) 136)
				(= local3 1)
				(trunk approachY: 130)
			)
		)
	)

	(method (dispose)
		(gGlobalSound0 client: 0)
		(gGlobalSound1 client: 0)
		(super dispose:)
	)

	(method (cue)
		(proc0_4 1)
		(gCurRoom newRoom: 315)
	)
)

(instance sFx of Sound
	(properties)
)

(instance tatTell of Teller
	(properties)

	(method (doVerb theVerb &tmp temp0 temp1)
		(if (== theVerb 2) ; Talk
			(for ((= temp0 0)) (< temp0 local0) ((++ temp0))
				(if (gFlags test: temp0)
					(= temp1 1)
				else
					(= temp1 0)
					(break)
				)
			)
			(if (not temp1)
				(super doVerb: theVerb)
			else
				(gMessager sayRange: 7 2 10 1 2) ; "Is there anything else you can think up... ah, of, to tell me?"
			)
		else
			(client doVerb: theVerb)
		)
	)

	(method (showCases &tmp temp0)
		(super showCases:)
		(if (not (or (== iconValue 999) (== iconValue -999)))
			(localproc_1 rootNoun curNoun iconValue)
			(gFlags set: local1)
			(= local1 0)
			(= local2 0)
		)
	)
)

(instance trunk of Feature
	(properties
		noun 14
		nsLeft 290
		nsTop 137
		nsRight 298
		nsBottom 142
		sightAngle 40
		approachX 295
		approachY 130
		approachDist 0
		x 294
		y 140
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 276 114 297 114 302 117 302 132 292 132 284 122 276 121
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 46) ; keys
			(gCurRoom setInset: (ScriptID 28)) ; trunkInset
		else
			(super doVerb: theVerb)
		)
	)
)

(instance car of View
	(properties
		noun 6
		approachX 244
		approachY 144
		x 241
		y 139
		view 313
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom newRoom: 17) ; MapRoom
			)
			(1 ; Look
				(if (and (gPqFlags test: 145) (== (rod script:) breakAndRun))
					(rod setScript: 0)
					(gMessager say: noun theVerb 5 1) ; "Your t-bird has been tampered with!"
				else
					(gMessager say: noun theVerb 1 1) ; "It's your T-bird."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mirror of View
	(properties
		noun 10
		approachX 202
		approachY 140
		x 202
		y 140
		z 5
		view 313
		loop 1
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gEgo get: 8) ; mirror
			(gGame points: 4)
			(gMessager say: noun theVerb 0 1) ; "You pick up the broken piece of side mirror."
			(self dispose:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance rod of Actor
	(properties
		noun 7
		approachX 148
		approachY 128
		approachDist 40
		x 120
		y 121
		view 310
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(gMessager say: 7 2 3) ; "I'm Detective Carey, LAPD, and I'm looking to ask some questions about what's been going on in this neighborhood."
			(tatTell init: self 310 13 5)
			(gEgo setScript: 0)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance ragin of Feature
	(properties
		noun 5
		nsLeft 55
		nsTop 74
		nsRight 77
		nsBottom 116
		sightAngle 40
		approachX 68
		approachY 119
		approachDist 0
		x 66
		y 95
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(proc0_4 1)
				(gCurRoom newRoom: 335)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance kitty of Feature
	(properties
		noun 3
		nsLeft 238
		nsTop 74
		nsRight 261
		nsBottom 117
		sightAngle 40
		approachX 253
		approachY 120
		approachDist 0
		x 249
		y 95
	)

	(method (doVerb theVerb)
		(cond
			((not (gPqFlags test: 14))
				(if (Message msgSIZE 310 noun theVerb 9 1)
					(gMessager say: noun theVerb 9)
				else
					(super doVerb: theVerb)
				)
			)
			((== theVerb 4) ; Do
				(if (gPqFlags test: 14)
					(gMessager say: 3 4 0 0 gCurRoom) ; "You push the door open."
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance raginBldg of Feature
	(properties
		noun 2
		nsTop 43
		nsRight 117
		nsBottom 119
		x 66
		y 94
	)
)

(instance kittyBldg of Feature
	(properties
		noun 4
		x 249
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 118 44 234 43 234 67 300 67 299 118 118 118 118 80
					yourself:
				)
		)
		(super init:)
	)
)

(instance kittySign of Feature
	(properties
		noun 1
		x 249
		y 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 258 7 282 0 319 0 319 22 301 17 258 27
					yourself:
				)
		)
		(super init:)
	)
)

(instance sidewalk of Feature
	(properties
		noun 8
		nsTop 120
		nsRight 319
		nsBottom 134
		x 66
		y 95
	)
)

(instance sky of Feature
	(properties
		noun 9
		x 100
		y 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 257 0 256 28 265 28 273 36 319 36 319 65 259 65 259 59 241 59 241 41 0 41
					yourself:
				)
		)
		(super init:)
	)
)

(instance loiter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rod setCycle: End self)
			)
			(1
				(= ticks (Random 120 240))
			)
			(2
				(rod loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(= ticks (Random 120 240))
			)
			(4
				(rod loop: 2 cel: 0 setCycle: End self)
			)
			(5
				(= ticks (Random 120 240))
			)
			(6
				(rod loop: 3 cel: 0 setCycle: End self)
			)
			(7
				(= ticks (Random 120 240))
			)
			(8
				(rod setCycle: Beg self)
			)
			(9
				(= ticks (Random 120 240))
			)
			(10
				(rod loop: 3)
				(rod cel: (rod lastCel:) setCycle: Beg self)
			)
			(11
				(= ticks (Random 120 240))
			)
			(12
				(rod loop: 2)
				(rod cel: (rod lastCel:) setCycle: Beg self)
			)
			(13
				(= ticks (Random 120 240))
			)
			(14
				(rod loop: 1)
				(rod cel: (rod lastCel:) setCycle: Beg self)
			)
			(15
				(= ticks (Random 120 240))
			)
			(16
				(rod loop: 0)
				(rod cel: (rod lastCel:) setCycle: Beg self)
			)
			(17
				(= state -1)
				(= ticks (Random 120 240))
			)
		)
	)
)

(instance firstTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gEgo setMotion: PolyPath 148 128 self)
			)
			(2
				(= cycles 4)
			)
			(3
				(gMessager say: 7 2 2 0 self) ; "Hey, handsome! Lookin' for a girl or a boy? Ewww..."
			)
			(4
				(rod view: 310 loop: 0 cel: 0 setScript: loiter)
				(gGame handsOn:)
			)
		)
	)
)

(instance breakAndRun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rod setCycle: End self)
			)
			(1
				(rod loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(rod loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(rod
					setLoop: 3 1
					cel: 0
					x: 266
					y: 143
					setCycle: Walk
					setMotion: MoveTo 335 143 self
				)
			)
			(4
				(gGame handsOn:)
			)
		)
	)
)

(instance soundScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (not register)
					(gGlobalSound0 client: self fade: 0 4 2 1)
					(if (!= gPrevRoomNum 300)
						(gGlobalSound1
							number: 300
							setPri: 10
							setLoop: -1
							setVol: 0
							play:
							fade: 127 5 1 0
						)
					)
					(= register 1)
					(= seconds (Random 10 40))
				else
					(= seconds (Random 10 40))
				)
			)
			(1
				(if register
					(= temp0
						(switch (Random 1 3)
							(1 905)
							(2 906)
							(3 907)
						)
					)
					(gGlobalSound0 number: temp0 setLoop: 1 play: self)
				else
					(= register 1)
					(self cue:)
				)
			)
			(2
				(= state -1)
				(= cycles 2)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(gGlobalSound0 fade: 0 4 2 1)
	)
)

