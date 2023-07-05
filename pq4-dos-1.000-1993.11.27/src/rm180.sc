;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 180)
(include sci.sh)
(use Main)
(use TellerIcon)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm180 0
	lasondraTalker 1
)

(local
	local0
	local1
	local2
)

(instance rm180 of Room
	(properties
		picture 180
		style 0
		horizon 58
		north 100
		west 100
	)

	(method (init)
		(proc0_4 1)
		(if (and (not (gPqFlags test: 38)) (< gDay 3))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 131 152 234 152 251 152 315 152 280 146 213 146 203 124 157 112 124 106 58 89 28 79 17 79
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 128 144 214 152 298 152 124 106 58 89 30 81 10 81
						yourself:
					)
			)
		)
		(super init: &rest)
		(if (and (not (gPqFlags test: 38)) (<= gDay 3))
			(laSondra
				setCycle: Fwd
				init:
				signal: (| (laSondra signal:) $4000)
				approachVerbs: 2 5 27 ; Talk, ???, badge
			)
			(laSondraTeller init: laSondra 180)
		)
		(switch gPrevRoomNum
			(100
				(gEgo
					setScaler: Scaler 92 38 136 85
					setHeading: 180
					posn: 50 90
				)
			)
			(190
				(gEgo
					setHeading: 305
					x: (if (gCast contains: laSondra) 195 else 225)
					y: (if (gCast contains: laSondra) 149 else 137)
				)
			)
			(else
				(gEgo setHeading: 180 posn: 50 90)
				(if (not (gEgo has: 16)) ; badge
					(gEgo get: 10 11 13 16 18 32 33 36) ; wallet
				)
			)
		)
		(musicScript init:)
		(gEgo
			setTalker: careyTalker
			setScaler: Scaler 92 38 136 85
			init:
			normalize: 0
		)
		(if (and (not (gPqFlags test: 38)) (<= gDay 3))
			(laSondra
				setCycle: Fwd
				init:
				signal: (| (laSondra signal:) $4000)
				approachVerbs: 2 5 27 ; Talk, ???, badge
			)
			(laSondraTeller init: laSondra 180)
		)
		(grass init:)
		(miniMart init:)
		(fence init:)
		(sidewalk init:)
		(trees init:)
		(sky init:)
		(street init:)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(!= newRoomNumber 190)
				(gPqPointFlags test: 13)
				(not (gPqFlags test: 38))
			)
			(gPqFlags set: 38)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(cond
			((gEgo inRect: 0 0 44 86)
				(gCurRoom newRoom: 100)
			)
			((> (gEgo x:) 245)
				(gGlobalSound0 fade: 0 3 1 1)
				(gGame handsOff:)
				(gCurRoom newRoom: 190)
			)
		)
	)
)

(instance musicScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gGlobalSound0 client: 0)
		(super dispose: &rest)
		(gTheDoits delete: self)
	)

	(method (cue)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum 100)
					(gGlobalSound0 fade: 0 3 5 1 self)
				else
					(gGlobalSound0 fade: 0 3 5 1)
					(= cycles 2)
				)
			)
			(1
				(if (and (gCast contains: laSondra) (not local1))
					(gGlobalSound0 number: 380 loop: 1 play: self)
					(= local1 1)
				else
					(gGlobalSound0
						number: (if (Random 0 1) 906 else 907)
						loop: 1
						play: self
					)
				)
			)
			(2
				(= state 0)
				(if (== (gGlobalSound0 number:) 380)
					(= cycles 2)
				else
					(= seconds (Random 5 10))
				)
			)
		)
	)
)

(instance rmSFX of Sound ; UNUSED
	(properties
		number 926
	)
)

(instance rmMusic of Sound ; UNUSED
	(properties
		flags 1
		number 180
		loop -1
	)
)

(instance laSondra of Actor
	(properties
		heading 224
		noun 2
		sightAngle 40
		approachX 180
		approachY 150
		x 238
		y 143
		view 184
	)

	(method (doVerb theVerb)
		(switch theVerb
			(19 ; apple
				(if (not (gPqPointFlags test: 14))
					(gCurRoom setScript: girlJamsScript)
				else
					(gCurRoom setScript: giveAppleScript)
				)
			)
			(74 ; candyBar
				(if (not (gPqPointFlags test: 14))
					(gCurRoom setScript: girlJamsScript)
				else
					(gMessager say: 2 74 3 0) ; "Would you like a candy bar?"
				)
			)
			(20 ; wallet
				(if (not (gPqPointFlags test: 14))
					(gCurRoom setScript: girlJamsScript)
				else
					(gMessager say: 2 20 3 0) ; "You have lots of money. I wish my mommy had lots of money."
				)
			)
			(29 ; coins
				(if (not (gPqPointFlags test: 14))
					(gCurRoom setScript: girlJamsScript)
				else
					(gMessager say: 2 29 3 0) ; "I get money sometimes for doing chores."
				)
			)
			(4 ; Do
				(if (not (gPqPointFlags test: 14))
					(gCurRoom setScript: girlJamsScript)
				else
					(gMessager say: noun theVerb 3 0) ; "There's no reason for you to touch this child."
				)
			)
			(1 ; Look
				(if (not (gPqPointFlags test: 11))
					(gMessager say: 2 1 1 0) ; "The child looks to be about five years old."
				else
					(gMessager say: 2 1 2 0) ; "LaSondra Washington, neighborhood child."
				)
			)
			(27 ; badge
				(if (gPqPointFlags test: 14)
					(gMessager say: 2 27 3 0) ; "She has a pretty good memory for a little girl,"
				else
					(gCurRoom setScript: showBadgeScript)
				)
			)
			(2 ; Talk
				(if (not (gPqPointFlags test: 14))
					(gCurRoom setScript: girlJamsScript 0 1)
				else
					(cond
						((== local2 1)
							(gMessager say: noun theVerb 9) ; "Have fun... see you later."
						)
						((not local2)
							(gMessager say: noun theVerb 4) ; "Hello, LaSondra."
						)
						(else
							(gMessager say: noun theVerb 2) ; "Hi, LaSondra."
						)
					)
					(++ local2)
				)
			)
			(22 ; handgun
				(gMessager say: 2 22 0 0) ; "An unnecessary and most aggressive action. Holster your gun."
			)
			(11 ; washStuff
				(gMessager say: 2 11 0) ; "Such an important document should not be given to a five year old."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance laSondraTeller of Teller
	(properties
		sayNoun 3
		verb 5
	)

	(method (doVerb)
		(if (gPqPointFlags test: 14)
			(cond
				((not (gPqPointFlags test: 11))
					(gPqPointFlags set: 11)
					(super doVerb: &rest)
				)
				(
					(and
						(gPqFlags test: 155)
						(gPqFlags test: 156)
						(gPqFlags test: 157)
					)
					(client doVerb: &rest)
				)
				(else
					(super doVerb: &rest)
				)
			)
		else
			(client doVerb: &rest)
		)
	)

	(method (sayMessage)
		(cond
			((== iconValue 5)
				(gPqFlags set: 155)
			)
			((== iconValue 6)
				(gPqFlags set: 156)
			)
			((== iconValue 7)
				(gPqFlags set: 157)
			)
		)
		(super sayMessage: &rest)
	)
)

(instance girlJamsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 2 2 1 0 self) ; "Hello."
			)
			(2
				(laSondra
					view: 187
					loop: 0
					cel: 0
					x: 241
					y: 143
					setCycle: End self
				)
			)
			(3
				(laSondra view: 187 loop: 1 cel: 0 setCycle: End self)
			)
			(4
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(laSondra
					view: 187
					loop: 2
					x: 289
					y: 154
					cel: 0
					setCycle: End self
				)
			)
			(5
				(laSondra dispose:)
				(gEgo setHeading: 135 self)
			)
			(6
				(= cycles 2)
			)
			(7
				(gMessager say: 2 (if (== register 1) 2 else 4) 8 0 self)
			)
			(8
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 128 144 214 152 298 152 124 106 58 89 30 81 10 81
							yourself:
						)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showBadgeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 2 14)
				(gPqPointFlags set: 14)
				(gGame handsOff:)
				(gEgo setHeading: 44 self)
			)
			(1
				(laSondra
					view: 187
					loop: 0
					cel: 0
					x: 241
					y: 143
					setCycle: End self
				)
			)
			(2
				((ScriptID 38 0) init: self) ; BadgeOut
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager say: 2 27 4 0 self) ; "I'm a police officer. My name is Detective Carey."
			)
			(5
				(= cycles 2)
			)
			(6
				((ScriptID 38 1) init: self) ; BadgeIn
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveAppleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 210 150 self)
			)
			(2
				(gEgo setHeading: 44 self)
			)
			(3
				(gEgo view: 9033 loop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(4
				(gMessager say: 2 19 3 1 self) ; "Would you and your doll like an apple?"
			)
			(5
				(laSondra
					view: 186
					loop: 0
					cel: 0
					x: 238
					y: 144
					setCycle: End self
				)
			)
			(6
				(gEgo setCycle: Beg)
				(laSondra loop: 1 cel: 0 setCycle: End self)
			)
			(7
				(gGame points: 2 13)
				(gPqPointFlags set: 13)
				(gEgo put: 9) ; apple
				((gInventory at: 9) owner: gCurRoomNum) ; apple
				(gMessager say: 2 19 3 2 self) ; "Thank you."
			)
			(8
				(= cycles 2)
			)
			(9
				(gEgo normalize: 0)
				(= ticks 120)
			)
			(10
				(laSondra
					view: 184
					x: 238
					y: 143
					setLoop: 0 1
					cel: 0
					approachX: (gEgo x:)
					approachY: (gEgo y:)
					setCycle: Fwd
				)
				(= cycles 2)
			)
			(11
				(gGame handsOn:)
			)
		)
	)
)

(instance grass of Feature
	(properties
		noun 6
		sightAngle 40
		x 99
		y 121
	)

	(method (init)
		(self createPoly: 1 80 15 80 247 151 126 152 1 90)
		(super init:)
	)
)

(instance miniMart of Feature
	(properties
		noun 8
		sightAngle 40
		x 16
		y 63
	)

	(method (init)
		(self createPoly: 2 32 29 24 22 41 34 51 34 69 22 75 2 69)
		(super init:)
	)
)

(instance fence of Feature
	(properties
		noun 1
		sightAngle 40
		x 262
		y 90
	)

	(method (init)
		(self createPoly: 37 51 319 45 319 141 36 72)
		(super init:)
	)
)

(instance sidewalk of Feature
	(properties
		noun 4
		sightAngle 40
		x 168
		y 121
	)

	(method (init)
		(self createPoly: 2 77 26 77 319 151 249 151 16 79 2 79)
		(super init:)
	)
)

(instance trees of Feature
	(properties
		noun 9
		sightAngle 40
		x 184
		y 26
	)

	(method (init)
		(self createPoly: 32 23 153 10 319 10 319 43 36 50 25 41)
		(super init: &rest)
	)
)

(instance sky of Feature
	(properties
		noun 5
		sightAngle 40
		x 48
		y 9
	)

	(method (init)
		(self createPoly: 1 10 130 10 28 22 2 30 2 10)
		(super init:)
	)
)

(instance street of Feature
	(properties
		noun 7
		sightAngle 40
		y 152
	)

	(method (init)
		(self createPoly: 0 92 122 152 0 152)
		(super init:)
	)
)

(instance careyTalker of Narrator
	(properties
		x 5
		y 10
	)
)

(instance lasondraTalker of Narrator
	(properties
		x 120
		y 10
	)
)

