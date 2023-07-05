;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use n045)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm240 0
	bildenTalker 1
	sherryTalker 2
)

(local
	local0
	local1
)

(instance rm240 of Room
	(properties
		noun 2
		picture 240
	)

	(method (doRemap)
		(gGame doRemap: 2 243 85)
		(gGame doRemap: 2 244 75)
	)

	(method (init)
		(proc45_0)
		(cond
			((== gPrevRoomNum 290)
				(= style 0)
			)
			((== gPrevRoomNum 250)
				(= style 0)
				(gGlobalSound0 fade:)
			)
			(else
				(= style 9)
			)
		)
		(if
			(and
				(gPqFlags test: 92)
				(gPqFlags test: 93)
				(== ((gInventory at: 23) owner:) 275) ; boneBaggie
				(== gPrevRoomNum 17) ; MapRoom
				(== gDay 4)
			)
			(gGlobalSound0 number: 505 setLoop: 1 play: hold: 1)
		else
			(gGlobalSound0 number: 506 loop: -1 play:)
		)
		(gGame handsOff:)
		(if (IsHiRes)
			(hiResSign init:)
			(hiResSign2 init:)
			(hiResCar init: setPri: 200 signal: (| (hiResCar signal:) $1000))
		)
		(super init: &rest)
		(car init: approachVerbs: 4) ; Do
		(carTrunk init: approachVerbs: 4 46) ; Do, keys
		(morgue init:)
		(morgueDoor init: approachVerbs: 4) ; Do
		(sky init:)
		(proc0_4 0)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 153 203 153 226 139 319 139 319 134 249 134 161 138 131 136 117 135 42 140 21 138 0 142
					yourself:
				)
		)
		(if (and (== gDay 2) (gPqFlags test: 29))
			(PalVary 8 240) ; PalVaryNewSource
		)
		(cond
			((== gPrevRoomNum 290)
				(= gDay 5)
				(self setScript: establishOnly)
			)
			(
				(and
					(gPqFlags test: 92)
					(gPqFlags test: 93)
					(== ((gInventory at: 23) owner:) 275) ; boneBaggie
					(== gPrevRoomNum 17) ; MapRoom
					(== gDay 4)
				)
				(PalVary 8 240) ; PalVaryNewSource
				(gEgo
					view: 0
					setHeading: 270
					normalize: 0
					posn: 222 148
					setTalker: egoTalker
					setScaler: Scaler 70 42 154 133
					init:
				)
				(gEgo
					scaleSignal: (| (gEgo scaleSignal:) $0004)
					setStep: 1 1
				)
				(sherry init:)
				(kristy init:)
				(barry init:)
				(self setScript: day4Confront)
			)
			((== gPrevRoomNum 250)
				(if (== gDay 3)
					(gPqFlags clear: 11)
				)
				(gEgo
					view: 0
					setHeading: 225
					normalize: 0
					posn: 117 135
					setScaler: Scaler 70 42 154 133
					init:
				)
				(self setScript: fromMorgue)
			)
			(else
				(gEgo
					view: 0
					setHeading: 315
					posn: 197 153
					normalize: 0
					setScaler: Scaler 70 42 154 133
					init:
				)
				(gGame handsOn:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((self script:) 0)
			((and (< (gEgo x:) 190) (< (gEgo y:) 139))
				(self setScript: toMorgue)
			)
			((and (<= (gEgo x:) 318) local1)
				(= local1 0)
			)
			((and (>= (gEgo x:) 1) local0)
				(= local0 0)
			)
			((> (gEgo x:) 318)
				(if (not local1)
					(= local1 1)
					(gMessager say: 0 76 0 1) ; "Where are you going? Your car is parked right in front of you!"
				)
			)
			((and (< (gEgo x:) 1) (not local0))
				(= local0 1)
				(gMessager say: 0 75 0 1) ; "Don't wander off! You have an investigation to conduct!"
			)
		)
	)

	(method (dispose)
		(PalVary 3) ; PalVaryKill
		(if (!= (gGlobalSound0 number:) 505)
			(gGlobalSound0 fade:)
		)
		(super dispose:)
	)
)

(instance establishOnly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 1 0 6 1 self) ; "Thursday, 9:00 AM LA County Morgue, Los Angeles"
			)
			(2
				(gCurRoom newRoom: 275)
			)
		)
	)
)

(instance day4Confront of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setSpeed: 6)
				(kristy setCycle: End)
				(barry setCycle: End)
				(= cycles 3)
			)
			(1
				(LoadMany rsVIEW 244 241)
				(sherry setCycle: End self)
			)
			(2
				(sherry view: 244 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(kristy view: 241 loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(Load rsVIEW 242)
				(gMessager say: 5 2 1 1 self) ; "Miss Moore, what can you tell us about the latest victims in what is being termed this city's most gruesome murder spree?"
			)
			(5
				(kristy view: 242 loop: 1 cel: 0 setCycle: End self)
			)
			(6
				(gMessager say: 5 2 1 2 self) ; "Me? Well.. I, ah, nothing really. Am I going to be on TV?"
			)
			(7
				(kristy setCycle: Beg self)
			)
			(8
				(gMessager say: 5 2 2 1 self) ; "Miss Moore, is it true that all the victims have been tortured, mutilated?"
			)
			(9
				(kristy setCycle: End self)
			)
			(10
				(gMessager say: 5 2 2 2 self) ; "Well, they're... they're, not all there...ah..."
			)
			(11
				(kristy setCycle: Beg self)
			)
			(12
				(gMessager say: 5 2 4 1 self) ; "Miss Moore, is it true that Officer Rene Garcia and the latest male victim, an unidentified John Doe, were both found not only tortured, but naked?"
			)
			(13
				(kristy setCycle: End self)
			)
			(14
				(gMessager say: 5 2 4 2 self) ; "Ah, well, yes... I mean, well, no... you see... Is that camera on?"
			)
			(15
				(gEgo
					scaleSignal: (& (gEgo scaleSignal:) $fffb)
					setSpeed: 2
					setMotion: DPath 173 138 147 141 self
				)
			)
			(16
				(gEgo setHeading: 270)
				(kristy setCycle: Beg self)
			)
			(17
				(gMessager say: 5 2 5 1 self) ; "So, Miss Moore, are you confirming that John Doe was not entirely nude, that he was found with a pair of nylons on his person? Is it true the nylons were wrapped around his neck?"
			)
			(18
				(kristy setCycle: End self)
			)
			(19
				(gMessager say: 5 2 5 2 self) ; "How'd you know that!?"
			)
			(20
				(kristy setCycle: Beg self)
			)
			(21
				(gMessager say: 5 2 5 3 self) ; "So you are confirming this information?"
			)
			(22
				(Load rsVIEW 9240)
				(kristy setCycle: End self)
			)
			(23
				(gEgo setScaler: 0)
				(gEgo
					setSpeed: 6
					view: 9240
					loop: 0
					cel: 0
					x: 140
					setCycle: End self
				)
			)
			(24
				(gEgo loop: 1 cel: 0)
				(kristy setCycle: Beg self)
			)
			(25
				(gMessager say: 5 2 3 1 self) ; "Detective Carey, can you comment on the nylons wrapped around the neck of..."
			)
			(26
				(kristy setCycle: End self)
			)
			(27
				(Load rsVIEW 248)
				(gMessager sayRange: 5 2 3 2 5 self) ; "I have nothing to say to you, Bilden! Nor does Miss Moore!"
			)
			(28
				(Load rsVIEW 243)
				(kristy setCycle: Beg)
				(sherry view: 248 loop: 0 cel: 0 x: 134)
				(gEgo setCycle: CT 2 1 self)
			)
			(29
				(kristy view: 243 loop: 0 cel: 0 setCycle: End)
				(barry loop: 1 cel: 0 setCycle: End)
				(sherry cel: 5 setCycle: CT 7 1)
				(gEgo setCycle: CT 4 1 self)
			)
			(30
				(sherry cel: 10 setCycle: End)
				(gEgo setCycle: CT 10 1 self)
			)
			(31
				(gMessager say: 5 2 3 6 self) ; "Detective Carey, the public has a right to know... It's their safety at stake! Detective Carey!"
			)
			(32
				(gCast eachElementDo: #hide)
				(Palette 2 0 239 0) ; PalIntensity
				(gCurRoom drawPic: -1 0)
				(gThePlane setRect: 0 0 320 200 1)
				(FrameOut)
				(gCurRoom newRoom: 290)
			)
		)
	)
)

(instance doTrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom setInset: (ScriptID 28) self) ; trunkInset
			)
			(1
				(if (and (== gDay 2) (gPqFlags test: 29))
					(PalVary 8 240) ; PalVaryNewSource
				)
				(self dispose:)
			)
		)
	)
)

(instance toMorgue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 117 135 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gMessager say: 7 4 0 1 self) ; "Entering the morgue always provides a sense of anticipation..."
			)
			(3
				(gCurRoom newRoom: 250)
			)
		)
	)
)

(instance fromMorgue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 167 151 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sherry of Prop
	(properties
		x 114
		y 139
		scaleX 88
		scaleY 88
		view 244
		signal 16385
		scaleSignal 1
	)
)

(instance barry of Prop
	(properties
		x 60
		y 147
		scaleX 106
		scaleY 106
		view 240
		signal 16385
		scaleSignal 1
	)
)

(instance kristy of Prop
	(properties
		x 88
		y 141
		scaleX 96
		scaleY 96
		view 241
		signal 16385
		scaleSignal 1
	)
)

(instance car of Feature
	(properties
		noun 3
		approachX 197
		approachY 153
		x 318
		y 153
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom newRoom: 17) ; MapRoom
		else
			(super doVerb: theVerb)
		)
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PContainedAccess
				init: 212 128 222 125 241 113 249 111 291 111 304 113 312 118 319 126 319 152 273 152 273 128
				yourself:
			)
		)
	)
)

(instance carTrunk of Feature
	(properties
		noun 4
		approachX 197
		approachY 153
		x 265
		y 154
	)

	(method (doVerb theVerb)
		(if (== theVerb 46) ; keys
			(gMessager say: 4 46 0 1) ; "Your key unlocks the trunk."
			(gEgo setScript: doTrunk)
		else
			(super doVerb: theVerb)
		)
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 211 129 272 129 272 152 202 152 202 143 205 132
				yourself:
			)
		)
	)
)

(instance morgue of Feature
	(properties
		noun 1
		x 157
		y 85
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 0 10 44 10 123 29 185 10 319 10 319 137 163 135 100 132 54 136 0 132
				yourself:
			)
		)
	)
)

(instance morgueDoor of Feature
	(properties
		noun 7
		x 157
		y 86
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 115 99 135 100 135 120 119 121 118 118 115 115
					yourself:
				)
		)
	)
)

(instance sky of Feature
	(properties
		noun 6
		y 84
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 216 0 124 29 11 2 0 10
					yourself:
				)
		)
	)
)

(instance bildenTalker of Narrator
	(properties
		x 10
		y 30
	)
)

(instance sherryTalker of Narrator
	(properties
		x 100
		y 30
		talkWidth 100
	)
)

(instance egoTalker of Narrator
	(properties
		x 150
		y 30
		talkWidth 100
	)
)

(instance hiResSign of View
	(properties
		x 226
		y 50
		view 2401
	)
)

(instance hiResSign2 of View
	(properties
		x 10
		y 70
		view 2401
		loop 1
	)
)

(instance hiResCar of View
	(properties
		noun 3
		x 200
		y 153
		view 2401
		loop 2
	)
)

