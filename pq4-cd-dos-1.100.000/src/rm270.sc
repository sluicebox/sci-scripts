;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 270)
(include sci.sh)
(use Main)
(use Array)
(use Talker)
(use Scaler)
(use Osc)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm270 0
	markTalker 1
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
	local9
	local10
)

(instance rm270 of Room
	(properties
		noun 1
		picture 270
	)

	(method (doRemap)
		(gGame doRemap: 2 253 90)
		(gGame doRemap: 2 254 75)
	)

	(method (init &tmp temp0)
		(gGlobalSound0 fade:)
		(gGame handsOff:)
		(super init: &rest)
		(for ((= local10 1)) (Message msgSIZE gCurRoomNum 7 2 2 local10) ((++ local10))
		)
		(-= local10 2)
		(= local9 (IntArray new: (+ local10 1)))
		(local9 name: {jokeMsg})
		(= local8 local10)
		(for ((= temp0 0)) (<= temp0 local8) ((++ temp0))
			(local9 at: temp0 (+ temp0 1))
		)
		(if
			(or
				(and (== gDay 2) (not (gPqFlags test: 9)))
				(and (== gDay 3) (!= gPrevRoomNum 275))
				(and (== gDay 4) (not (gEgo has: 23)) (!= gPrevRoomNum 275)) ; boneBaggie
				(and (== gDay 5) (== gPrevRoomNum 275))
			)
			(assistant init: approachVerbs: 2 setCycle: Osc -1) ; Talk
		)
		(if (gCast contains: assistant)
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 91 169 280 169 253 156 260 140 317 133 318 129 261 130 248 142 195 146 181 135 94 135
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 91 169 280 169 253 156 260 140 317 133 318 129 232 132 230 144 195 146 181 135 94 135
						yourself:
					)
			)
		)
		(if (== gPrevRoomNum 275)
			(gEgo
				view: 0
				setHeading: 270
				normalize: 0
				posn: 291 142
				setScaler: Scaler 141 97 189 129
				init:
			)
		else
			(gEgo
				view: 0
				setHeading: 180
				normalize: 0
				posn: 124 138
				setScaler: Scaler 141 97 189 129
				init:
			)
		)
		(gEgo setTalker: egoTalker)
		(if
			(and
				(not (gEgo has: 4)) ; hickmanStuff
				(!= ((gInventory at: 4) owner:) 790) ; hickmanStuff
				(== gDay 2)
			)
			(hickEnv init: approachVerbs: 4) ; Do
		)
		(if
			(and
				(not (gEgo has: 40)) ; washStuff
				(!= ((gInventory at: 40) owner:) 190) ; washStuff
				(or (gPqFlags test: 8) (gPqPointFlags test: 6))
				(== gDay 2)
			)
			(washEnv init: approachVerbs: 4) ; Do
		)
		(door init: approachVerbs: 4) ; Do
		(garbageCan init:)
		(coldBox init: approachVerbs: 4) ; Do
		(theSign init: approachVerbs: 4 1) ; Do, Look
		(cond
			((== gPrevRoomNum 275)
				(self setScript: egoComeIn)
			)
			((gCast contains: assistant)
				(= local1 1)
				(self setScript: lookUpGreet)
			)
			(else
				(gGame handsOn:)
			)
		)
		(gGlobalSound0 number: 250 loop: -1 play:)
		(proc0_4 1)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (gEgo mover:) local0)
				(gCurRoom setScript: noFinishJoke)
			)
			(script 0)
			((> (gEgo x:) 292)
				(self newRoom: 275)
			)
			((<= (gEgo y:) 168)
				(if local7
					(= local7 0)
				)
			)
			((and (> (gEgo y:) 168) (not local7))
				(= local7 1)
				(if (gCast contains: assistant)
					(gMessager say: 9 3 0 1) ; "Where you going?"
				else
					(gMessager say: 9 3 9 1) ; "You're heading for a wall, Carey. Get back on track."
				)
			)
		)
	)

	(method (dispose)
		(local9 dispose:)
		(super dispose:)
	)
)

(instance lookUpGreet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 270)
				(gEgo setHeading: 90)
				(assistant view: 270 loop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(assistant loop: 2 cel: 0)
				(gMessager say: 7 2 4 1 self) ; "Hello, Detective Carey."
			)
			(2
				(Load rsVIEW 273)
				(assistant view: 273 loop: 0 cel: 5 setCycle: Beg self)
			)
			(3
				(= ticks 60)
			)
			(4
				(client setScript: tellJoke)
			)
		)
	)
)

(instance egoComeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 251 142 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tellJoke of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 273)
				(assistant view: 273 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(= local2 (= temp2 (local9 at: (= temp1 (Random 0 local8)))))
				(for ((= temp0 temp1)) (< temp0 local8) ((++ temp0))
					(local9 at: temp0 (local9 at: (+ temp0 1)))
				)
				(if (< (-- local8) 0)
					(= local8 local10)
					(for ((= temp0 0)) (<= temp0 local8) ((++ temp0))
						(local9 at: temp0 (+ temp0 1))
					)
				)
				(gMessager say: 7 2 2 local2 self)
			)
			(2
				(assistant loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(= local0 1)
				(gGame handsOn:)
				(if local1
					(= ticks 900)
				else
					(= ticks 300)
				)
			)
			(4
				(gGame handsOff:)
				(Load rsVIEW 273)
				(= local0 0)
				(= local2 0)
				(assistant view: 273 loop: 0 cel: 3 setCycle: Beg self)
			)
			(5
				(Load rsVIEW 270)
				(assistant view: 270 loop: 0 cel: 0 setCycle: Osc -1)
				(gMessager sayRandom: 7 2 8 self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance noFinishJoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(= local2 0)
				(Load rsVIEW 273)
				(assistant view: 273 loop: 0 cel: 3 setCycle: Beg self)
			)
			(1
				(Load rsVIEW 270)
				(assistant view: 270 loop: 0 cel: 0 setCycle: Osc -1)
				(gMessager sayRandom: 7 2 8 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance finishJoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(gGame handsOff:)
				(gMessager say: 7 2 6 1 self) ; "I don't know."
			)
			(1
				(assistant view: 273 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 7 2 5 local2 self)
			)
			(3
				(Load rsVIEW 274)
				(assistant view: 274 loop: 0 cel: 7 setCycle: End self)
			)
			(4
				(gMessager say: 7 2 11) ; "Ha, Ha, Ha!!?!?!"
				(assistant cycleSpeed: 2 loop: 1 cel: 0 setCycle: Osc 2 self)
			)
			(5
				(= local2 0)
				(assistant cycleSpeed: 6 setCycle: End self)
			)
			(6
				(assistant setCycle: Beg self)
			)
			(7
				(assistant loop: 0)
				(assistant cel: (assistant lastCel:) setCycle: Beg self)
			)
			(8
				(Load rsVIEW 273)
				(assistant view: 273 loop: 0 cel: 2)
				(if local1
					(gCurRoom setScript: pointToDoor)
				else
					(assistant setCycle: Beg self)
				)
			)
			(9
				(Load rsVIEW 270)
				(assistant view: 270 loop: 0 cel: 0 setCycle: Osc -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pointToDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 272)
				(= local1 0)
				(assistant view: 272 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 7 2 7 0 self) ; "Go right in, Detective."
			)
			(2
				(assistant loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(assistant loop: 2 cel: 0 setCycle: End self)
			)
			(4
				(Load rsVIEW 273)
				(assistant view: 273 loop: 0 cel: 3 setCycle: Beg self)
			)
			(5
				(Load rsVIEW 270)
				(assistant view: 270 loop: 0 cel: 0 setCycle: Osc -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showBadge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 38 0) init: self) ; BadgeOut
			)
			(1
				(= local3 7)
				(= local4 27)
				(self setScript: lookUpReply self)
			)
			(2
				(gGame handsOff:)
				((ScriptID 38 1) init: self) ; BadgeIn
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookUpSorry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 7 2 10 1 self) ; "Hello, Russel."
			)
			(1
				(Load rsVIEW 270)
				(assistant view: 270 loop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 7 2 10 2 self) ; "Hey, saw Sherry on the news last night...she's really a nice girl, I'm sure she didn't mean anything by it."
			)
			(3
				(if local0
					(Load rsVIEW 270)
					(assistant view: 270 loop: 1 setCel: 6)
					(= local0 0)
				)
				(assistant setCycle: Beg self)
			)
			(4
				(Load rsVIEW 270)
				(assistant view: 270 loop: 0 cel: 0 setCycle: Osc -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookUpReply of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(= cycles 1)
				else
					(Load rsVIEW 270)
					(assistant view: 270 loop: 1 setCel: 0 setCycle: End self)
				)
			)
			(1
				(gMessager say: local3 local4 0 1 self)
			)
			(2
				(if local0
					(Load rsVIEW 270)
					(assistant view: 270 loop: 1 setCel: 6)
					(= local0 0)
				)
				(assistant setCycle: Beg self)
			)
			(3
				(Load rsVIEW 270)
				(assistant view: 270 loop: 0 cel: 0 setCycle: Osc -1)
				(= local3 (= local4 0))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance go250 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gCast contains: assistant)
					(gMessager say: 4 4 0 0 self) ; "See ya, Detective."
				else
					(gMessager say: 4 4 9 0 self) ; "You open the door and head to the lobby."
				)
			)
			(1
				(gCurRoom newRoom: 250)
			)
		)
	)
)

(instance assistant of Prop
	(properties
		noun 7
		approachX 124
		approachY 138
		approachDist 20
		x 221
		y 134
		view 270
		cel 1
		signal 20481
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Talk
				(cond
					((and (== gDay 5) (not local6))
						(++ local6)
						(gCurRoom setScript: lookUpSorry)
					)
					(local0
						(gCurRoom setScript: finishJoke)
					)
					(else
						(gCurRoom setScript: tellJoke)
					)
				)
			)
			((== theVerb 27) ; badge
				(gCurRoom setScript: showBadge)
			)
			(
				(OneOf
					theVerb
					4 ; Do
					19 ; apple
					34 ; boneBaggie
					74 ; candyBar
					30 ; cigarette
					43 ; caseFlashlight
					64 ; caseGloves
					47 ; handcuffs
					14 ; hickmanStuff
					66 ; parkerID
					18 ; mirror
					28 ; newspaper
					57 ; photo
					39 ; pills
					32 ; pretzels
					31 ; shoe
					36 ; tape
					11 ; washStuff
				)
				(= local3 noun)
				(= local4 theVerb)
				(gCurRoom setScript: lookUpReply)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hickEnv of View
	(properties
		noun 3
		approachX 259
		approachY 132
		approachDist 10
		x 251
		y 89
		view 2710
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gEgo get: 4) ; hickmanStuff
			(gGame points: 4)
			(gMessager say: noun theVerb 0 0) ; "You pick up Hickman's personal belongings envelope."
			(self dispose:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance washEnv of View
	(properties
		noun 2
		approachX 277
		approachY 131
		approachDist 10
		x 270
		y 88
		view 2710
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gEgo get: 40) ; washStuff
			(gGame points: 4)
			(gMessager say: noun theVerb 0 0) ; "You pick up Bobby Washington's personal belongings envelope."
			(self dispose:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance door of Feature
	(properties
		noun 4
		nsLeft 80
		nsTop 40
		nsRight 171
		nsBottom 128
		approachX 135
		approachY 135
		x 125
		y 84
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: go250)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance garbageCan of Feature
	(properties
		noun 6
		nsLeft 203
		nsTop 112
		nsRight 222
		nsBottom 137
		sightAngle 40
		approachX 212
		approachY 124
		approachDist 0
		x 212
		y 124
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 74 4 65 41 45 18 39 32 63 71 44) ; candyBar, Do, caseGlassJar, lighter, matches, mirror, pills, pretzels, casePryBar, qualifyMemo, rope
			(if (gCast contains: assistant)
				(= local3 noun)
				(= local4 theVerb)
				(gCurRoom setScript: lookUpReply)
			else
				(gMessager say: noun theVerb 9 0)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance coldBox of Feature
	(properties
		noun 5
		nsLeft 48
		nsTop 2
		nsRight 66
		nsBottom 152
		sightAngle 45
		approachX 78
		approachY 142
		approachDist 30
		x 70
		y 140
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 22 46) ; Do, handgun, keys
			(if (gCast contains: assistant)
				(= local3 noun)
				(= local4 theVerb)
				(gCurRoom setScript: lookUpReply)
			else
				(gMessager say: 5 4 9 0) ; "The cold box is off-limits to non-morgue personnel."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance theSign of Feature
	(properties
		noun 10
		approachX 280
		approachY 167
		x 285
		y 100
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 294 47 305 45 305 74 294 75
					yourself:
				)
		)
	)
)

(instance markTalker of Narrator
	(properties
		x 170
		y 15
		talkWidth 140
		modeless 2
	)
)

(instance egoTalker of Narrator
	(properties
		x 50
		y 15
	)
)

