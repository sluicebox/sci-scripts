;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 755)
(include sci.sh)
(use Main)
(use SyncedView)
(use n030)
(use n045)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm755 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm755 of Room
	(properties
		noun 10
		picture 755
	)

	(method (doRemap)
		(gGame doRemap: 2 243 85)
		(gGame doRemap: 2 244 75)
	)

	(method (init)
		(proc45_0)
		(if (not (gPqFlags test: 123))
			(gGlobalSound0 number: 755 loop: -1 flags: 5 play:)
		)
		(super init: &rest)
		(if (OneOf gPrevRoomNum 775 776)
			(gGlobalSound1 number: 979 loop: 1 flags: 5 play:)
		)
		(bed init:)
		(underBed init:)
		(floor init:)
		(holeLeft init:)
		(holeRight init:)
		(farRight init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 135 107 135 111 152 114 148 122 88 148 298 148 287 113 287 102 305 102 305 100 266 100 264 107
					yourself:
				)
		)
		(if (OneOf gPrevRoomNum 775 776)
			(gEgo posn: 185 108)
		else
			(gEgo x: (if (gPqFlags test: 123) 310 else 295) y: 100)
		)
		(gEgo
			view: 9120
			origStep: 2052
			stopView: 9125
			setHeading: (if (OneOf gPrevRoomNum 775 776) 0 else 270)
			normalize: 9120
			setScaler: Scaler 119 79 162 106
			init:
		)
		(door init:)
		(cond
			((gPqFlags test: 123)
				(tammy init:)
				(mitchell init:)
				(self setScript: comeInLast)
				(gWalkHandler addToFront: self)
			)
			((OneOf gPrevRoomNum 775 776)
				(closet init: approachVerbs: 4) ; Do
				(gGame handsOn:)
				(gTheIconBar enable: 0)
			)
			(else
				(closet init: approachVerbs: 4) ; Do
				(self setScript: comeIn)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script 0)
			((and (> (gEgo x:) 295) (< (gEgo y:) 103))
				(self newRoom: 750)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(User canControl:)
				(User canInput:)
				(gCast contains: mitchell)
				(not (event modifiers:))
				(& (event type:) evMOVE)
			)
			(self setScript: walkGetKilled)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
			(return)
		)
	)

	(method (dispose)
		(if (gPqFlags test: 123)
			(gWalkHandler delete: self)
		)
		(super dispose:)
	)

	(method (cue)
		(switch (++ local3)
			(1
				(gEgo cycleSpeed: 6 setCycle: CT 10 -1 self)
			)
			(2
				(gEgo setCycle: Beg)
			)
		)
	)
)

(instance comeInLast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mitchell sightAngle: 360)
				(door sightAngle: 360)
				(closet sightAngle: 360)
				(tammy sightAngle: 360)
				(bed sightAngle: 360)
				(underBed sightAngle: 360)
				(holeRight sightAngle: 360)
				(holeLeft sightAngle: 360)
				(farRight sightAngle: 360)
				(floor sightAngle: 360)
				(LoadMany rsVIEW 757 758 759)
				(mitchell setCycle: CT 10 1 self)
				(gGlobalSound0 number: 756 loop: -1 flags: 5 play:)
			)
			(1
				(= ticks 120)
			)
			(2
				(mitchell setCycle: End self)
			)
			(3
				(mitchell view: 757 cel: 0 setCycle: End self)
			)
			(4
				(= ticks 240)
			)
			(5
				(LoadMany rsVIEW 758)
				(mitchell x: 104 view: 758 cel: 0 setCycle: End self)
			)
			(6
				(LoadMany rsVIEW 759)
				(mitchell view: 759 cel: 0 setCycle: End self)
				(gEgo view: 9120 setLoop: 5 1 setMotion: MoveTo 240 111 self)
			)
			(7
				(LoadMany rsVIEW 7550 7551)
				0
			)
			(8
				(gEgo setLoop: -1)
				(= cycles 1)
			)
			(9
				(mitchell
					view: 7550
					cel: 0
					cycleSpeed: 3
					x: 141
					setCycle: End self
				)
			)
			(10
				(gGame handsOn:)
				(= cycles 1)
			)
			(11
				(LoadMany rsVIEW 7551)
				(= ticks 300)
			)
			(12
				(gGame handsOff:)
				(gGlobalSound0 number: 1001 loop: 1 flags: 5 play:)
				(gGlobalSound1 number: 1019 loop: 1 flags: 5 play:)
				(gEgo
					view: 9755
					setLoop: 0
					cel: 0
					x: 219
					y: 118
					setCycle: CT 5 1
				)
				(mitchell
					view: 7551
					cel: 0
					posn: 187 140
					setCycle: CT 13 1 self
				)
			)
			(13
				(EgoDead 4 4 0 1 755) ; "A risky move for your final approach, Detective..."
			)
		)
	)
)

(instance sprayOrLight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(LoadMany rsVIEW register)
				(gEgo
					view: register
					setLoop: 0
					cel: 0
					x: (if (== register 9755) 219 else 214)
					y: 118
					setCycle: End self
				)
			)
			(1
				(= ticks 120)
			)
			(2
				(gGlobalSound0 number: 1001 loop: 1 flags: 5 play:)
				(gGlobalSound1 number: 1019 loop: 1 flags: 5 play:)
				(LoadMany rsVIEW 7551)
				(mitchell
					view: 7551
					cel: 0
					posn: 187 140
					setCycle: CT 13 1 self
				)
				(gGlobalSound1 number: 1019 loop: 1 flags: 5 play:)
			)
			(3
				(EgoDead 4 (if (== register 9755) 41 else 42) 7 1 755)
			)
		)
	)
)

(instance doGetKilled of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(LoadMany rsVIEW 9755 7551)
				(gEgo
					view: 9755
					setLoop: 0
					cel: 0
					x: 219
					y: 118
					setCycle: CT 5 1
				)
				(mitchell
					view: 7551
					cel: 0
					posn: 187 140
					setCycle: CT 13 1 self
				)
				(gGlobalSound0 number: 1001 loop: 1 flags: 5 play:)
				(gGlobalSound1 number: 1019 loop: 1 flags: 5 play:)
			)
			(1
				(EgoDead 4 4 0 1 755) ; "A risky move for your final approach, Detective..."
			)
		)
	)
)

(instance walkGetKilled of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGlobalSound0 number: 1001 loop: 1 flags: 5 play:)
				(LoadMany rsVIEW 7551)
				(gEgo setSpeed: 6 setMotion: MoveTo 228 119)
				(gGlobalSound1 number: 1019 loop: 1 flags: 5 play:)
				(mitchell
					view: 7551
					cel: 0
					posn: 187 140
					setCycle: CT 13 1 self
				)
			)
			(1
				(EgoDead 4 4 0 1 755) ; "A risky move for your final approach, Detective..."
			)
		)
	)
)

(instance comeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 243 126 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookUnderBed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 3 86)
				(gEgo setMotion: PolyPath 250 135 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(= register (mySyncedView new:))
				(gEgo view: 9885 loop: 1 cel: 0 x: 241 setCycle: End self)
				(register offset: 56405 init: gEgo)
			)
			(3
				(= ticks 60)
			)
			(4
				(gMessager say: 11 49 0 0 self) ; "Looking underneath the bed and you discover... no one."
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo view: 9125 loop: 1 posn: 250 135 normalize: 9120)
				(register dispose:)
				(= cycles 2)
			)
			(7
				(= register 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mirrorDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 280 104 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo view: 9126 cel: 0 setCycle: End self)
			)
			(3
				(= ticks 120)
			)
			(4
				(gMessager say: 1 49 0 0 self) ; "Detective, the coast is clear."
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(= ticks 60)
			)
			(7
				(gEgo view: 9125 normalize: 9120 setHeading: 180 self)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance door of Feature
	(properties
		noun 1
		nsLeft 257
		nsTop 8
		nsRight 297
		nsBottom 94
		x 277
		y 51
	)

	(method (doVerb theVerb)
		(if (and (gCast contains: mitchell) (== theVerb 4)) ; Do
			(gMessager say: noun theVerb 1 0)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance closet of Feature
	(properties
		noun 2
		nsLeft 156
		nsTop 8
		nsRight 219
		nsBottom 102
		approachX 185
		approachY 108
		x 187
		y 55
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: closetScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance mitchell of Prop
	(properties
		noun 4
		x 98
		y 153
		scaleX 142
		scaleY 142
		view 756
		signal 16385
		scaleSignal 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: doGetKilled)
			)
			(42 ; hairspray
				(gCurRoom setScript: sprayOrLight 0 9756)
			)
			(41 ; lighter
				(gCurRoom setScript: sprayOrLight 0 9755)
			)
			(2 ; Talk
				(switch local1
					(0
						(++ local1)
						(gMessager say: noun theVerb 2 1) ; "Freeze! LAPD!"
					)
					(1
						(++ local1)
						(gMessager say: noun theVerb 3 1) ; "Put your hands above your head! NOW!"
					)
					(2
						(gMessager say: noun theVerb 6 1) ; "Do not move!"
					)
				)
			)
			(48 ; torch
				(gCurRoom setScript: torchHim)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tammy of View
	(properties
		noun 3
		x 55
		y 96
		priority 150
		fixPriority 1
		view 755
		signal 16384
	)
)

(instance bed of Feature
	(properties
		noun 5
		x 88
		y 96
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 0 104 7 103 13 109 14 115 25 108 33 105 43 105 88 92 135 94 137 97 146 111 142 113 142 116 100 133 95 135 90 136 83 141 80 142 76 143 60 143 52 146 54 149 54 152 35 152 34 146 35 144 31 137 13 144 0 151
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(cond
			((and (gCast contains: mitchell) (OneOf theVerb 4 42 41 1)) ; Do, hairspray, lighter, Look
				(gMessager say: noun theVerb 1 0)
			)
			((and local0 (== theVerb 22)) ; handgun
				(gMessager say: noun theVerb 5 0)
			)
			((== theVerb 22) ; handgun
				(gMessager say: noun theVerb 4 0) ; "Holster your weapon, Detective! There is no visible threat."
			)
			((== theVerb 52) ; notebook
				(if (gPqPointFlags test: 34)
					(gMessager say: noun theVerb 3 0) ; "You've already recorded your findings, Detective."
				else
					(gPqPointFlags set: 34)
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance floor of Feature
	(properties
		noun 9
		x 100
		y 90
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 140 100 160 102 218 103 221 102 251 104 255 94 295 95 312 152 76 152 158 116 155 111
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (and (gCast contains: mitchell) (OneOf theVerb 4 41)) ; Do, lighter
			(gMessager say: noun theVerb 1 0)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance underBed of Feature
	(properties
		noun 11
		sightAngle 360
		y 150
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 147 116 80 145 59 147 57 152 0 152 0 141 11 144 35 136 37 139 35 146 36 149 144 108
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(cond
			((and (gCast contains: mitchell) (== theVerb 4)) ; Do
				(gMessager say: noun theVerb 1)
			)
			((and local0 (OneOf theVerb 27 4 22 1 52 49 2)) ; badge, Do, handgun, Look, notebook, stickMirror, Talk
				(gMessager say: noun theVerb 5 0)
			)
			((and (not local0) (== theVerb 49)) ; stickMirror
				(== local0 1)
				(gCurRoom setScript: lookUnderBed)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance holeRight of Feature
	(properties
		noun 7
		x 234
		y 49
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 234 33 239 28 239 41 238 45 234 44 228 49 227 39 229 36 230 34
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (and (gCast contains: mitchell) (== theVerb 4)) ; Do
			(gMessager say: noun theVerb 1 0)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance holeLeft of Feature
	(properties
		noun 6
		x 122
		y 58
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 120 51 125 58 121 67 119 58
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (and (gCast contains: mitchell) (== theVerb 4)) ; Do
			(gMessager say: noun theVerb 1 0)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance farRight of Feature
	(properties
		noun 1
		x 298
		y 113
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 298 8 301 8 301 113 298 94
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 49) ; stickMirror
			(if (gCast contains: mitchell)
				(super doVerb: theVerb)
			else
				(gCurRoom setScript: mirrorDoor)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance mySyncedView of SyncedView
	(properties)

	(method (init param1 &tmp [temp0 2])
		(= client param1)
		(= cel (client cel:))
		(= loop (client loop:))
		(= view (+ (client view:) offset))
		(= signal (client signal:))
		(|= signal $4000)
		(= scaleSignal 1)
		(= scaleX (client scaleX:))
		(= scaleY (client scaleY:))
		(self fixPriority: 1)
		(= priority (+ (client priority:) 1))
		(= x (client x:))
		(= y (+ (client y:) 1))
		(= z (+ (client z:) 1))
		(if (not (gCast contains: self))
			(= lsRight (= lsBottom (= lsLeft (= lsTop 0))))
		)
		(BaseSetter self)
		(gCast addToEnd: self)
		(|= -info- $0010)
		(self initialize:)
		(= plane (gCast plane:))
		(AddScreenItem self)
	)

	(method (doit &tmp temp0)
		(= cel (client cel:))
		(= loop (client loop:))
		(= view (+ (client view:) offset))
		(= signal (client signal:))
		(|= signal $4000)
		(= scaleX (client scaleX:))
		(= scaleY (client scaleY:))
		(self fixPriority: 1)
		(= priority (+ (client priority:) 1))
		(= x (client x:))
		(= y (+ (client y:) 1))
		(= z (+ (client z:) 1))
		(UpdateScreenItem self)
	)
)

(instance closetScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 2 4 0 1 self) ; "Opening the closet doors..."
			)
			(1
				(if (gPqFlags test: 144)
					(gCurRoom newRoom: 775)
				else
					(gCurRoom newRoom: 776)
				)
				(self dispose:)
			)
		)
	)
)

(instance fireFx of Sound
	(properties)
)

(instance fireScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not (-- local2))
						(fireFx play:)
						(self dispose:)
					)
					((== local2 4)
						(fireFx number: 1016 loop: 1 flags: 5 play: self)
					)
					(else
						(fireFx play: self)
					)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance torchHim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 10)
				(LoadMany rsVIEW 9757)
				(= ticks 3)
			)
			(1
				(LoadMany rsVIEW 7553 7554 7555)
				(gEgo
					view: 9757
					setLoop: 0
					cel: 0
					x: 214
					y: 118
					fixPriority: 1
					setPri: 80
					setCycle: CT 7 1 self
				)
			)
			(2
				(gEgo cycleSpeed: 8 setCycle: End self)
				(gGlobalSound1 number: 1014 loop: 1 flags: 5 play:)
				(mitchell
					posn: 202 133
					view: 7553
					cel: 0
					cycleSpeed: 4
					setCycle: End self
				)
			)
			(4
				(gGlobalSound1 number: 0 stop:)
				(= local2 5)
				(gGame setScript: fireScr)
				(gGlobalSound0 number: 1001 loop: -1 flags: 5 play: setVol: 127)
				(mitchell view: 7554 cel: 0 cycleSpeed: 4 setCycle: End self)
				(gCurRoom cue:)
			)
			(5
				(mitchell
					view: 7555
					cel: 0
					cycleSpeed: 5
					setCycle: ForwardCounter 4 self
				)
			)
			(6
				(mitchell cycleSpeed: 6 setCycle: ForwardCounter 4 self)
			)
			(7
				(mitchell cycleSpeed: 8 setCycle: ForwardCounter 4 self)
			)
			(8
				((ScriptID 24 0) modeless: 2) ; ibTalker
				(mitchell setCycle: Fwd)
				(gGlobalSound0 setVol: 60)
				(gMessager say: 4 48 0 0 self) ; "Your action neutralizes your assailant."
			)
			(9
				((ScriptID 24 0) modeless: 1) ; ibTalker
				(gGlobalSound0 setVol: 127)
				(if (gGame script:)
					(fireFx number: 0 stop:)
					((gGame script:) dispose:)
				)
				(= ticks 90)
			)
			(10
				(gGame fadeSpeed: 4)
				(gGlobalSound0 fade:)
				(= seconds 5)
			)
			(11
				(gCurRoom newRoom: 778)
			)
		)
	)
)

