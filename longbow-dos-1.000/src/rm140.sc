;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use n013)
(use Interface)
(use verseScript)
(use rhEgo)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm140 0
	fire 1
	ledge 2
	peg 3
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
	local11
	local12
	local13
	local14
	[local15 5] = [1140 0 1 1 0]
)

(procedure (localproc_0)
	(if (and (== gDay 1) (not (gEgo has: 1))) ; horn
		(horn init: stopUpd:)
	)
	(if (or (== gDisguiseNum 0) (== gDisguiseNum 4)) ; outlaw, yeoman
		(bow dispose:)
	else
		(bow init: stopUpd:)
	)
)

(procedure (localproc_1)
	(cond
		(
			(and
				(== gDisguiseNum 0) ; outlaw
				(or (== ((gInventory at: 1) owner:) 140) (gEgo has: 1)) ; horn, horn
			)
			(gEgo get: 1) ; horn
		)
		((gEgo has: 1) ; horn
			(gEgo put: 1 140) ; horn
		)
	)
	(cond
		(
			(and
				(OneOf gDisguiseNum 0 5 6 2 3) ; outlaw, abbey monk, fens monk, jewler (no rouge), jewler (rouge)
				(or (== ((gInventory at: 2) owner:) 140) (gEgo has: 2)) ; halfHeart, halfHeart
			)
			(gEgo get: 2) ; halfHeart
		)
		((gEgo has: 2) ; halfHeart
			(gEgo put: 2 140) ; halfHeart
		)
	)
	(cond
		(
			(and
				(or (== ((gInventory at: 3) owner:) 140) (gEgo has: 3)) ; slipper, slipper
				(or (== gDisguiseNum 0) (== gDisguiseNum 1)) ; outlaw, beggar
			)
			(gEgo get: 3) ; slipper
		)
		((gEgo has: 3) ; slipper
			(gEgo put: 3 140) ; slipper
		)
	)
	(cond
		(
			(and
				(== gDisguiseNum 0) ; outlaw
				(or (== ((gInventory at: 4) owner:) 140) (gEgo has: 4)) ; net, net
			)
			(gEgo get: 4) ; net
		)
		((gEgo has: 4) ; net
			(gEgo put: 4 140) ; net
		)
	)
	(cond
		(
			(and
				(== gDisguiseNum 6) ; fens monk
				(or (== ((gInventory at: 5) owner:) 140) (gEgo has: 5)) ; pipe, pipe
			)
			(gEgo get: 5) ; pipe
		)
		((gEgo has: 5) ; pipe
			(gEgo put: 5 140) ; pipe
		)
	)
	(cond
		(
			(and
				(== gDisguiseNum 6) ; fens monk
				(or (== ((gInventory at: 6) owner:) 140) (gEgo has: 6)) ; gems, gems
			)
			(gEgo get: 6) ; gems
		)
		((gEgo has: 6) ; gems
			(gEgo put: 6 140) ; gems
		)
	)
	(cond
		(
			(and
				(or (== ((gInventory at: 7) owner:) 140) (gEgo has: 7)) ; jewels, jewels
				(or (== gDisguiseNum 2) (== gDisguiseNum 3)) ; jewler (no rouge), jewler (rouge)
			)
			(gEgo get: 7) ; jewels
		)
		((gEgo has: 7) ; jewels
			(gEgo put: 7 140) ; jewels
		)
	)
	(cond
		(
			(and
				(or (== ((gInventory at: 8) owner:) 140) (gEgo has: 8)) ; rouge, rouge
				(or (== gDisguiseNum 2) (== gDisguiseNum 3)) ; jewler (no rouge), jewler (rouge)
			)
			(gEgo get: 8) ; rouge
		)
		((gEgo has: 8) ; rouge
			(gEgo put: 8 140) ; rouge
		)
	)
	(cond
		(
			(and
				(or (== ((gInventory at: 9) owner:) 140) (gEgo has: 9)) ; message, message
				(== gDisguiseNum 0) ; outlaw
			)
			(gEgo get: 9) ; message
		)
		((gEgo has: 9) ; message
			(gEgo put: 9 140) ; message
		)
	)
	(cond
		(
			(and
				(or (== ((gInventory at: 10) owner:) 140) (gEgo has: 10)) ; fireRing, fireRing
				(OneOf gDisguiseNum 0 5 6 2 3) ; outlaw, abbey monk, fens monk, jewler (no rouge), jewler (rouge)
			)
			(gEgo get: 10) ; fireRing
		)
		((gEgo has: 10) ; fireRing
			(gEgo put: 10 140) ; fireRing
		)
	)
	(cond
		(
			(and
				(or (== ((gInventory at: 11) owner:) 140) (gEgo has: 11)) ; cask, cask
				(== gDisguiseNum 5) ; abbey monk
			)
			(gEgo get: 11) ; cask
		)
		((gEgo has: 11) ; cask
			(gEgo put: 11 140) ; cask
		)
	)
	(cond
		(
			(and
				(or (== ((gInventory at: 12) owner:) 140) (gEgo has: 12)) ; puzzleBox, puzzleBox
				(or (== gDisguiseNum 0) (== gDisguiseNum 5)) ; outlaw, abbey monk
			)
			(gEgo get: 12) ; puzzleBox
		)
		((gEgo has: 12) ; puzzleBox
			(gEgo put: 12 140) ; puzzleBox
		)
	)
	(if (IsFlag 101)
		(gEgo put: 12) ; puzzleBox
	)
	(cond
		(
			(and
				(or (== ((gInventory at: 13) owner:) 140) (gEgo has: 13)) ; robes, robes
				(== gDisguiseNum 5) ; abbey monk
			)
			(gEgo get: 13) ; robes
		)
		((gEgo has: 13) ; robes
			(gEgo put: 13 140) ; robes
		)
	)
	(cond
		(
			(and
				(or (== ((gInventory at: 14) owner:) 140) (gEgo has: 14)) ; amethyst, amethyst
				(OneOf gDisguiseNum 0 5 6 2 3) ; outlaw, abbey monk, fens monk, jewler (no rouge), jewler (rouge)
			)
			(gEgo get: 14) ; amethyst
		)
		((gEgo has: 14) ; amethyst
			(gEgo put: 14 140) ; amethyst
		)
	)
	(cond
		(
			(and
				(or (== ((gInventory at: 15) owner:) 140) (gEgo has: 15)) ; comb, comb
				(or (== gDisguiseNum 0) (== gDisguiseNum 1)) ; outlaw, beggar
			)
			(gEgo get: 15) ; comb
		)
		((gEgo has: 15) ; comb
			(gEgo put: 15 140) ; comb
		)
	)
	(cond
		(
			(and
				(or (== ((gInventory at: 16) owner:) 140) (gEgo has: 16)) ; fulkScroll, fulkScroll
				(or (== gDisguiseNum 0) (== gDisguiseNum 6)) ; outlaw, fens monk
			)
			(gEgo get: 16) ; fulkScroll
		)
		((gEgo has: 16) ; fulkScroll
			(gEgo put: 16 140) ; fulkScroll
		)
	)
	(cond
		(
			(and
				(or (== ((gInventory at: 17) owner:) 140) (gEgo has: 17)) ; handScroll, handScroll
				(or (== gDisguiseNum 0) (== gDisguiseNum 6) (== gDisguiseNum 4)) ; outlaw, fens monk, yeoman
			)
			(gEgo get: 17) ; handScroll
		)
		((gEgo has: 17) ; handScroll
			(gEgo put: 17 140) ; handScroll
		)
	)
	(cond
		(
			(and
				(or (== ((gInventory at: 18) owner:) 140) (gEgo has: 18)) ; waterRing, waterRing
				(or
					(== gDisguiseNum 0) ; outlaw
					(== gDisguiseNum 5) ; abbey monk
					(== gDisguiseNum 6) ; fens monk
					(== gDisguiseNum 2) ; jewler (no rouge)
					(== gDisguiseNum 3) ; jewler (rouge)
				)
			)
			(gEgo get: 18) ; waterRing
		)
		((gEgo has: 18) ; waterRing
			(gEgo put: 18 140) ; waterRing
		)
	)
)

(procedure (localproc_2)
	(gCurRoom
		addObstacle:
			((Polygon new:)
				type: PBarredAccess
				init: 224 0 224 71 221 75 212 75 221 84 204 87 202 92 208 98 182 106 166 107 156 102 135 102 127 99 77 104 94 115 94 125 70 125 56 122 45 118 21 118 34 123 34 146 30 160 42 175 59 184 121 187 247 187 277 170 292 141 274 124 269 119 251 111 253 107 263 96 256 89 258 83 261 80 247 68 247 0 319 0 319 189 0 189 0 0
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 205 139 205 146 192 146 182 150 156 148 147 142 134 142 134 136 156 130 169 129 184 131
				yourself:
			)
	)
	(if (!= gDisguiseNum 0) ; outlaw
		(gCurRoom
			addObstacle:
				((= local4 (Polygon new:))
					type: PBarredAccess
					init:
						(+ (gRobin x:) 9)
						(+ (gRobin y:) 5)
						(- (gRobin x:) 11)
						(+ (gRobin y:) 5)
						(- (gRobin x:) 19)
						(- (gRobin y:) 1)
						(- (gRobin x:) 11)
						(- (gRobin y:) 10)
						(+ (gRobin x:) 9)
						(- (gRobin y:) 10)
						(+ (gRobin x:) 17)
						(- (gRobin y:) 1)
					yourself:
				)
		)
	)
	(if (and (!= gDisguiseNum 4) (< 7 gDay 10) (IsFlag 57)) ; yeoman
		(gCurRoom
			addObstacle:
				((= local5 (Polygon new:))
					type: PBarredAccess
					init:
						(+ (gPuck x:) 9)
						(+ (gPuck y:) 5)
						(- (gPuck x:) 11)
						(+ (gPuck y:) 5)
						(- (gPuck x:) 19)
						(- (gPuck y:) 1)
						(- (gPuck x:) 11)
						(- (gPuck y:) 10)
						(+ (gPuck x:) 9)
						(- (gPuck y:) 10)
						(+ (gPuck x:) 17)
						(- (gPuck y:) 1)
					yourself:
				)
		)
	)
	(if (and (!= gDisguiseNum 2) (IsFlag 113) (!= gDisguiseNum 3) (== gDay 9)) ; jewler (no rouge), jewler (rouge)
		(gCurRoom
			addObstacle:
				((= local6 (Polygon new:))
					type: PBarredAccess
					init:
						(+ (gJeweler x:) 9)
						(+ (gJeweler y:) 5)
						(- (gJeweler x:) 11)
						(+ (gJeweler y:) 5)
						(- (gJeweler x:) 19)
						(- (gJeweler y:) 1)
						(- (gJeweler x:) 11)
						(- (gJeweler y:) 10)
						(+ (gJeweler x:) 9)
						(- (gJeweler y:) 10)
						(+ (gJeweler x:) 17)
						(- (gJeweler y:) 1)
					yourself:
				)
		)
	)
	(if (and (!= gDisguiseNum 1) (IsFlag 54) (== gDay 3)) ; beggar
		(gCurRoom
			addObstacle:
				((= local7 (Polygon new:))
					type: PBarredAccess
					init:
						(+ (gBeggar x:) 9)
						(+ (gBeggar y:) 5)
						(- (gBeggar x:) 11)
						(+ (gBeggar y:) 5)
						(- (gBeggar x:) 19)
						(- (gBeggar y:) 1)
						(- (gBeggar x:) 11)
						(- (gBeggar y:) 10)
						(+ (gBeggar x:) 9)
						(- (gBeggar y:) 10)
						(+ (gBeggar x:) 17)
						(- (gBeggar y:) 1)
					yourself:
				)
		)
	)
	(if (and (!= gDisguiseNum 5) (IsFlag 55) (< 4 gDay 10)) ; abbey monk
		(gCurRoom
			addObstacle:
				((= local8 (Polygon new:))
					type: PBarredAccess
					init:
						(+ (gAbbey x:) 9)
						(+ (gAbbey y:) 5)
						(- (gAbbey x:) 11)
						(+ (gAbbey y:) 5)
						(- (gAbbey x:) 19)
						(- (gAbbey y:) 1)
						(- (gAbbey x:) 11)
						(- (gAbbey y:) 10)
						(+ (gAbbey x:) 9)
						(- (gAbbey y:) 10)
						(+ (gAbbey x:) 17)
						(- (gAbbey y:) 1)
					yourself:
				)
		)
	)
	(if (and (!= gDisguiseNum 6) (IsFlag 147) (< 4 gDay 10)) ; fens monk
		(gCurRoom
			addObstacle:
				((= local9 (Polygon new:))
					type: PBarredAccess
					init:
						(+ (gFens x:) 9)
						(+ (gFens y:) 5)
						(- (gFens x:) 11)
						(+ (gFens y:) 5)
						(- (gFens x:) 19)
						(- (gFens y:) 15)
						(- (gFens x:) 11)
						(- (gFens y:) 15)
						(+ (gFens x:) 9)
						(- (gFens y:) 10)
						(+ (gFens x:) 17)
						(- (gFens y:) 10)
					yourself:
				)
		)
	)
)

(instance rm140 of Rm
	(properties
		picture 140
		style 8
		north 150
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1140 31 1) ; "This is one of the many natural caves carved into the sandstone."
			)
			(3 ; Do
				(Say 1140 32 1) ; "I know what it feels like--cool sandstone."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(HandsOff)
		(gRgnMusic number: 141 loop: -1 vol: 70 play:)
		(DoSound sndGLOBAL_REVERB 20)
		(LoadMany rsVIEW 140 213 142 7)
		(Load rsSCRIPT 969)
		(Load rsPIC 803)
		(super init:)
		(gEgo actions: egoHorn)
		(NormalEgo)
		(fireSound play:)
		(fire init:)
		(ledge init: stopUpd:)
		(peg init: stopUpd:)
		(localproc_1)
		(AddToFeatures skin1 skin2 skin3 bed vines floor drape entry)
		(localproc_2)
		(if (!= gDisguiseNum 0) ; outlaw
			(gRobin init: stopUpd:)
		)
		(if (and (!= gDisguiseNum 4) (< 7 gDay 10) (IsFlag 57)) ; yeoman
			(gPuck init: stopUpd:)
		)
		(if
			(and
				(!= gDisguiseNum 2) ; jewler (no rouge)
				(IsFlag 113)
				(!= gDisguiseNum 3) ; jewler (rouge)
				(== gDay 9)
			)
			(gJeweler init: stopUpd:)
		)
		(if (and (!= gDisguiseNum 1) (IsFlag 54) (== gDay 3)) ; beggar
			(gBeggar init: stopUpd:)
		)
		(if (and (!= gDisguiseNum 5) (IsFlag 55) (< 4 gDay 10)) ; abbey monk
			(gAbbey init: stopUpd:)
		)
		(if (and (!= gDisguiseNum 6) (IsFlag 147) (< 4 gDay 10)) ; fens monk
			(gFens init: stopUpd:)
		)
		(localproc_0)
		(localproc_1)
		(cond
			((== gPrevRoomNum 150)
				(NormalEgo)
				(gEgo posn: 235 82 loop: 5 init: setScript: enterTheCave)
			)
			((and (== gPrevRoomNum 160) (== gDay 2))
				(LoadMany rsPIC 803 210 215)
				(gEgo put: 4 140) ; net
				(gEgo
					view: 142
					loop: 0
					cel: 0
					x: 74
					y: 91
					init:
					setPri: 7
					setScript: (ScriptID 141 0) ; theStupor
				)
				(fireSound stop:)
			)
			(else
				(gEgo loop: 6 posn: 200 108 init:)
				(NormalEgo)
				(HandsOn)
			)
		)
	)

	(method (doit)
		(cond
			((gEgo script:) 0)
			((< (gEgo y:) 78)
				(gCurRoom newRoom: 150)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(DoSound sndGLOBAL_REVERB 0)
		(if (gCurRoom obstacles:)
			((gCurRoom obstacles:) dispose:)
		)
		(gCurRoom obstacles: 0)
		(gCurRoom setScript: 0)
		(super dispose:)
	)
)

(instance floor of Feature
	(properties
		x 219
		y 90
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 219 70 252 70 265 76 262 89 269 95 259 110 261 112 276 115 277 119 278 123 283 125 277 135 277 141 273 143 273 146 249 164 223 166 221 167 218 168 214 171 208 171 202 176 196 178 133 178 122 169 111 167 100 163 83 159 77 151 49 144 32 133 28 128 27 124 48 112 64 118 78 118 89 113 77 104 124 97 124 92 133 94 137 98 157 97 170 103 180 103 193 102 202 98 200 94 197 90 200 89 198 84 214 83 208 75 215 73
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1140 29 1) ; "The floor is beaten earth. We live a simple life here."
			)
			(3 ; Do
				(Say 1140 30 1) ; "I've felt enough beaten earth in my time."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance vines of Feature
	(properties
		x 224
		y 20
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 233 18 229 22 224 17 219 22 216 19 220 12 230 6 233 15
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1140 27 1) ; "I enjoy the graceful vines that hang over entrance to my cave."
			)
			(3 ; Do
				(Say 1140 28 1) ; "I like the vines as they are."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skin1 of Feature
	(properties
		x 278
		y 119
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 278 133 249 139 226 138 212 139 194 131 198 127 215 120 247 122 251 119 267 120 277 129
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb invItem)
		(skinDoVerb doit: theVerb invItem)
	)
)

(instance skin2 of Feature
	(properties
		x 260
		y 151
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 260 157 250 165 222 166 215 170 195 168 185 169 185 165 175 165 175 160 194 158 199 155 212 155 220 151 244 151
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb invItem)
		(skinDoVerb doit: theVerb invItem)
	)
)

(instance skin3 of Feature
	(properties
		x 169
		y 149
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 169 165 163 168 118 167 104 165 83 159 80 156 88 152 107 149 122 149 138 155 147 155 162 162
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb invItem)
		(skinDoVerb doit: theVerb invItem)
	)
)

(instance bed of Feature
	(properties
		x 121
		y 85
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 121 96 80 100 76 97 71 89 71 71 101 73 124 77
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1140 25 1) ; "I've made a bed of lashed wood and leather, with a fur covering for cold nights."
			)
			(3 ; Do
				(Say 1140 26 1) ; "I've had enough sleep. It's time to be about and doing things."
			)
			(4 ; Inventory
				(Say 1140 33 1) ; "Why?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance entry of Feature
	(properties
		x 259
		y 31
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 259 63 255 66 212 66 206 58 208 38 216 19 219 22 225 17 228 22 234 17 235 20 245 32 252 41 250 49 249 63
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1140 24 1) ; "Just beyond my cave is the main part of our hidden camp."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance drape of Feature
	(properties
		x 253
		y 36
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 253 41 235 19 231 6 239 4 244 6 252 7 263 18 266 33 263 59 259 62 250 62 251 50
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1140 22 1) ; "When I let it down, the leather covering provides me with privacy and keeps out the cold."
			)
			(3 ; Do
				(Say 1140 23 1) ; "It's better left open. A bit of air will do this cave good."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cover of View ; UNUSED
	(properties
		x 237
		y 67
		view 140
		loop 4
		priority 4
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1140 22 1) ; "When I let it down, the leather covering provides me with privacy and keeps out the cold."
			)
			(3 ; Do
				(Say 1140 23 1) ; "It's better left open. A bit of air will do this cave good."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bow of View
	(properties
		x 158
		y 97
		view 140
		loop 6
		priority 3
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1140 20 1) ; "Tis my own bow and quiver."
			)
			(3 ; Do
				(Say 1140 21 1) ; "A bow and quiver wouldn't be right for this disguise."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance horn of View
	(properties
		x 156
		y 73
		view 140
		loop 6
		cel 1
		priority 6
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1140 16 1) ; "'Tis my own horn."
			)
			(3 ; Do
				(gEgo setScript: getHorn)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance peg of View
	(properties
		x 158
		y 60
		view 140
		loop 1
		priority 7
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1140 66 1) ; "It's a peg."
			)
			(3 ; Do
				(Say 1140 67 1) ; "There's nothing on the peg to take."
			)
			(5 ; Talk
				(Say 1140 68 1) ; "Why?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ledge of View
	(properties
		x 38
		y 103
		view 140
		loop 3
		priority 8
		signal 17
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 196)
					(Say 1140 19 1) ; "'Tis my personal money chest."
				else
					(gEgo setScript: lookAtChest)
					(SetFlag 196)
				)
			)
			(3 ; Do
				(if (or (< (gMoney value:) 50) (not (gEgo has: 0))) ; bucks
					(gEgo setScript: stashIt)
				else
					(Say 1140 15 1) ; "I've all my money, and I've no need to carry that small, but heavy chest around."
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(gEgo setScript: putMoneyBack)
					)
					(1 ; horn
						(Say 1140 49 1) ; "It won't fit in there."
					)
					(2 ; halfHeart
						(Say 1140 50 1) ; "I could keep the emerald here for safety...and yet, I think it would be wiser to keep it with me."
					)
					(3 ; slipper
						(Say 1140 51 1) ; "It won't fit in there."
					)
					(15 ; comb
						(Say 1140 52 1) ; "It barely fits, but I'll be wanting it, so why bother?"
					)
					(11 ; cask
						(Say 1140 51 1) ; "It won't fit in there."
					)
					(14 ; amethyst
						(Say 1140 53 1) ; "It doesn't quite fit in this small chest."
					)
					(12 ; puzzleBox
						(Say 1140 51 1) ; "It won't fit in there."
					)
					(10 ; fireRing
						(Say 1140 54 1) ; "The ring would be safe enough in here, but who knows when I might have a need for it? I'll keep it with me."
					)
					(13 ; robes
						(Say 1140 55 1) ; "They certainly won't fit in there."
					)
					(5 ; pipe
						(Say 1140 51 1) ; "It won't fit in there."
					)
					(6 ; gems
						(Say 1140 56 1) ; "The pouch of stones won't fit in there."
					)
					(17 ; handScroll
						(Say 1140 51 1) ; "It won't fit in there."
					)
					(16 ; fulkScroll
						(Say 1140 51 1) ; "It won't fit in there."
					)
					(18 ; waterRing
						(Say 1140 57 1) ; "It's tempting to store it safely here, but it would be wiser to keep it upon my person."
					)
					(4 ; net
						(Say 1140 58 1) ; "I might be able to squeeze the net inside the chest, but then I wouldn't have it if I need it."
					)
					(7 ; jewels
						(Say 1140 59 1) ; "The jewelry won't fit in there."
					)
					(8 ; rouge
						(Say 1140 51 1) ; "It won't fit in there."
					)
					(9 ; message
						(Say 1140 51 1) ; "It won't fit in there."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(class Garb of View
	(properties
		view 140
		loop 5
		signal 16384
		newGuise 0
		garbX 0
		garbY 0
	)

	(method (doVerb theVerb invItem &tmp [temp0 40])
		(switch theVerb
			(2 ; Look
				(Print (Format @temp0 140 0 (self lookStr:)) #at -1 10) ; "%s"
			)
			(3 ; Do
				(= local3 gDisguiseNum)
				(= gDisguiseNum newGuise)
				(localproc_1)
				(= local11 garbX)
				(= local12 garbY)
				(gCurRoom setScript: wardrobeChange)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(Say 1140 61 1) ; "Not much point in leaving money on a pile of clothes I'm not even using."
					)
					(1 ; horn
						(Say 1140 60 1) ; "I'd rather keep it with me."
					)
					(2 ; halfHeart
						(Say 1140 62 1) ; "I'd rather keep the emerald with me."
					)
					(3 ; slipper
						(Say 1140 60 1) ; "I'd rather keep it with me."
					)
					(15 ; comb
						(Say 1140 60 1) ; "I'd rather keep it with me."
					)
					(11 ; cask
						(Say 1140 60 1) ; "I'd rather keep it with me."
					)
					(14 ; amethyst
						(Say 1140 60 1) ; "I'd rather keep it with me."
					)
					(12 ; puzzleBox
						(Say 1140 60 1) ; "I'd rather keep it with me."
					)
					(10 ; fireRing
						(Say 1140 60 1) ; "I'd rather keep it with me."
					)
					(13 ; robes
						(Say 1140 63 1) ; "It might be useful to take them with me."
					)
					(5 ; pipe
						(Say 1140 60 1) ; "I'd rather keep it with me."
					)
					(6 ; gems
						(Say 1140 60 1) ; "I'd rather keep it with me."
					)
					(17 ; handScroll
						(Say 1140 60 1) ; "I'd rather keep it with me."
					)
					(16 ; fulkScroll
						(Say 1140 60 1) ; "I'd rather keep it with me."
					)
					(18 ; waterRing
						(Say 1140 60 1) ; "I'd rather keep it with me."
					)
					(4 ; net
						(Say 1140 60 1) ; "I'd rather keep it with me."
					)
					(7 ; jewels
						(Say 1140 64 1) ; "It makes sense to keep the jewelry in this disguise."
					)
					(8 ; rouge
						(Say 1140 60 1) ; "I'd rather keep it with me."
					)
					(9 ; message
						(Say 1140 60 1) ; "I'd rather keep it with me."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gRobin of Garb
	(properties
		x 95
		y 153
		lookStr {'Tis my outlaw garb.}
		garbX 91
		garbY 138
	)
)

(instance gBeggar of Garb
	(properties
		x 248
		y 160
		lookStr {Yonder mouldering pile is the beggar's rags.}
		cel 3
		newGuise 1
		garbX 244
		garbY 145
	)
)

(instance gJeweler of Garb
	(properties
		x 195
		y 165
		lookStr {The jeweler's fine clothing lies there.}
		cel 2
		newGuise 2
		garbX 189
		garbY 147
	)
)

(instance gPuck of Garb
	(properties
		x 140
		y 163
		lookStr {'Tis the good yeoman's garb.}
		cel 1
		newGuise 4
		garbX 134
		garbY 148
	)
)

(instance gAbbey of Garb
	(properties
		x 255
		y 128
		lookStr {'Tis the Abbey monk's robe.}
		cel 5
		newGuise 5
		garbX 250
		garbY 113
	)
)

(instance gFens of Garb
	(properties
		x 210
		y 129
		lookStr {That is the black robe of the Fens monk.}
		cel 4
		newGuise 6
		garbX 206
		garbY 114
	)
)

(instance fire of Prop
	(properties
		x 167
		y 140
		view 140
		signal 16384
	)

	(method (init)
		(self setCycle: End self)
		(super init:)
	)

	(method (cue &tmp temp0)
		(= temp0 (Random 0 1))
		(self cycleSpeed: (Random 6 18))
		(if temp0
			(self setCycle: End self)
		else
			(self setCycle: Beg self)
		)
		(super cue:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1140 34 1) ; "It is kind of Tuck to see that my fire is kept lit and my cave warm."
			)
			(3 ; Do
				(if (== global115 2)
					(gEgo setScript: burnHand)
				else
					(Say 1140 35 1) ; "I cannot think of a good reason to burn myself."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lookAtChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Say 1140 17 self) ; "This chest contains my own, small store of money."
			)
			(1
				(Say 1140 18 self) ; "Whatever else I gain from lightening the overfilled purse of a rich man is turned over to Friar Tuck, who serves as our trusted Treasurer."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getHorn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 162 110 self)
			)
			(1
				(gEgo setLoop: 3)
				(horn dispose:)
				(gEgo get: 1) ; horn
				(if (not (IsFlag 171))
					(SetFlag 171)
					(SetScore 50)
				)
				(= ticks 20)
			)
			(2
				(gEgo actions: egoHorn)
				(NormalEgo 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance wardrobeChange of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath local11 local12 self)
			)
			(1
				(gEgo setLoop: 2)
				(= ticks 30)
			)
			(2
				(switch gDisguiseNum
					(0 ; outlaw
						(Say 1140 71 self) ; "It'll be good to wear my own clothes again."
					)
					(1 ; beggar
						(Say 1140 76 self) ; "I don't look forward to donning those tattered, flea-bitten rags, but if I must, I must. And I'd best be sure to take only what a beggar might carry, or what I feel I cannot leave behind."
					)
					(2 ; jewler (no rouge)
						(Say 1140 75 self) ; "I'll carry only those things a jeweler might carry, or that I feel I must bring."
					)
					(4 ; yeoman
						(Say 1140 74 self) ; "I'll want to be careful what I carry with me in this guise as 'Puck'."
					)
					(5 ; abbey monk
						(Say 1140 73 self) ; "I'd better take only certain things with me if I'm to pass as an Abbey Monk."
					)
					(6 ; fens monk
						(Say 1140 72 self) ; "I'll need to take care if I'm to pass as one of these militant monks. I'll take with me only what I feel is necessary."
					)
				)
			)
			(3
				(switch gDisguiseNum
					(0 ; outlaw
						(gRobin dispose:)
					)
					(1 ; beggar
						(gBeggar dispose:)
					)
					(2 ; jewler (no rouge)
						(gJeweler dispose:)
					)
					(4 ; yeoman
						(gPuck dispose:)
					)
					(5 ; abbey monk
						(gAbbey dispose:)
					)
					(6 ; fens monk
						(gFens dispose:)
					)
				)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
				)
				(gCurRoom obstacles: 0)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 803 6 1 0)
				(= ticks 50)
			)
			(4
				(switch local3
					(0
						(= local13 (gRobin garbX:))
						(= local14 (gRobin garbY:))
					)
					(1
						(= local13 (gBeggar garbX:))
						(= local14 (gBeggar garbY:))
					)
					(2
						(= local13 (gJeweler garbX:))
						(= local14 (gJeweler garbY:))
					)
					(3
						(= local13 (gJeweler garbX:))
						(= local14 (gJeweler garbY:))
					)
					(4
						(= local13 (gPuck garbX:))
						(= local14 (gPuck garbY:))
					)
					(5
						(= local13 (gAbbey garbX:))
						(= local14 (gAbbey garbY:))
					)
					(6
						(= local13 (gFens garbX:))
						(= local14 (gFens garbY:))
					)
				)
				(localproc_2)
				(= ticks 30)
			)
			(5
				(NormalEgo)
				(gCast eachElementDo: #show)
				(localproc_0)
				(if (and (!= gDisguiseNum 0) (not (gCast contains: gRobin))) ; outlaw
					(gRobin init:)
				)
				(if
					(and
						(!= gDisguiseNum 1) ; beggar
						(IsFlag 54)
						(== gDay 3)
						(not (gCast contains: gBeggar))
					)
					(gBeggar init:)
				)
				(if
					(and
						(!= gDisguiseNum 2) ; jewler (no rouge)
						(IsFlag 113)
						(!= gDisguiseNum 3) ; jewler (rouge)
						(== gDay 9)
						(not (gCast contains: gJeweler))
					)
					(gJeweler init:)
				)
				(if
					(and
						(!= gDisguiseNum 4) ; yeoman
						(< 7 gDay 10)
						(not (gCast contains: gPuck))
						(IsFlag 57)
					)
					(gPuck init:)
				)
				(if
					(and
						(!= gDisguiseNum 5) ; abbey monk
						(IsFlag 55)
						(< 4 gDay 10)
						(not (gCast contains: gAbbey))
					)
					(gAbbey init:)
				)
				(if
					(and
						(!= gDisguiseNum 6) ; fens monk
						(IsFlag 147)
						(< 4 gDay 10)
						(not (gCast contains: gFens))
					)
					(gFens init:)
				)
				(gCurRoom drawPic: 140 6 1 0)
				(= ticks 30)
			)
			(6
				(gCast eachElementDo: #stopUpd)
				(fire cue:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance stashIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 44 118 self)
			)
			(1
				(if (== gDisguiseNum 0) ; outlaw
					(gEgo view: 7 loop: 5 cel: 0 setCycle: CT 4 1 self)
				else
					(self cue:)
				)
			)
			(2
				(chestSound play:)
				(Say 1140 13 self) ; "I'll count my money as I empty the chest."
			)
			(3
				(chingSound play:)
				(= ticks 10)
			)
			(4
				(chingSound play:)
				(= ticks 10)
			)
			(5
				(chingSound play:)
				(= ticks 10)
			)
			(6
				(Say 1140 14 self) ; "There's something about silver in a purse that makes a day seem brighter."
			)
			(7
				(if (== gDisguiseNum 0) ; outlaw
					(gEgo setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(8
				(chestSound play:)
				(if (not (gEgo has: 0)) ; bucks
					(gEgo get: 0) ; bucks
					(if (< (gMoney value:) 50)
						(gPennies put: 5)
						(gHapennies put: 19)
						(gFarthings put: 26)
					)
				else
					(gPennies put: 5)
					(gHapennies put: 19)
					(gFarthings put: 26)
				)
				(= ticks 30)
			)
			(9
				(SetScore 50 193)
				(NormalEgo)
				(gEgo
					setMotion: PolyPath (+ (gEgo x:) 20) (gEgo y:) self
				)
			)
			(10
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance putMoneyBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 44 118 self)
			)
			(1
				(if (== gDisguiseNum 0) ; outlaw
					(gEgo view: 7 loop: 5 cel: 0 setCycle: CT 4 1 self)
				else
					(self cue:)
				)
			)
			(2
				(chestSound play:)
				(= seconds 2)
			)
			(3
				(chingSound play:)
				(= ticks 10)
			)
			(4
				(chingSound play:)
				(= ticks 10)
			)
			(5
				(chingSound play:)
				(= ticks 10)
			)
			(6
				(if (== gDisguiseNum 0) ; outlaw
					(gEgo setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(7
				(chestSound play:)
				(gEgo put: 0 setHeading: 180) ; bucks
				(= ticks 36)
			)
			(8
				(Say 1140 65 self) ; "An empty purse is a sad thing."
			)
			(9
				(NormalEgo)
				(gEgo setHeading: 135 self)
			)
			(10
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cantRap of Script
	(properties)

	(method (doit)
		(if (== (gEgo view:) 10)
			(gRgnMusic setVol: 0)
			(gRgnMusic fade: 127 30 8 1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global111 (gEgo loop:))
				(if
					(or
						(== (gEgo loop:) 2)
						(== (gEgo loop:) 4)
						(== (gEgo loop:) 0)
						(== (gEgo loop:) 6)
					)
					(gEgo setLoop: 0)
				else
					(gEgo setLoop: 1)
				)
				(gEgo view: 10 setCel: 0 setCycle: End self)
			)
			(1
				(hornBadSound play:)
				(= seconds 4)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(NormalEgo global111 0 1)
				(Say 1140 42 self) ; "'Ods blood, my head nearly burst and I sounded like the bleat of a dying swan."
			)
			(4
				(Say 1140 43 self) ; "Zounds! I'll think twice before winding this horn inside a cave again!"
			)
			(5
				(HandsOn)
				(hornBadSound stop:)
				(self dispose:)
			)
		)
	)
)

(instance blowOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global111 (gEgo loop:))
				(if
					(or
						(== (gEgo loop:) 2)
						(== (gEgo loop:) 4)
						(== (gEgo loop:) 0)
						(== (gEgo loop:) 6)
					)
					(gEgo setLoop: 0)
				else
					(gEgo setLoop: 1)
				)
				(gEgo view: 10 setCel: 0 setCycle: End self)
			)
			(1
				(hornBadSound number: 904 play:)
				(= seconds 4)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(NormalEgo global111 0 1)
				(Say 1140 43 self) ; "Zounds! I'll think twice before winding this horn inside a cave again!"
			)
			(4
				(HandsOn)
				(hornBadSound stop:)
				(self dispose:)
			)
		)
	)
)

(instance burnHand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 156 149 self)
			)
			(1
				(Face gEgo fire)
				(= ticks 12)
			)
			(2
				(gEgo
					view: 7
					loop: 1
					cel: 0
					cycleSpeed: 12
					setCycle: CT 4 1 self
				)
			)
			(3
				(Say 1140 44 self) ; "The Ring truly does command Fire! I passed my hand through the flames and am unscathed."
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(NormalEgo 6)
				(gEgo cycleSpeed: 6)
				(= ticks 12)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterTheCave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 235 95 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance skinDoVerb of Code
	(properties)

	(method (doit param1 param2)
		(switch param1
			(2
				(Say 1140 45 1) ; "A skin is more pleasant to stand on than barren floor."
			)
			(3
				(Say 1140 46 1) ; "I'm not going to lug a heavy skin around."
			)
			(4
				(Say 1140 33 1) ; "Why?"
			)
			(else
				(gDoVerbCode doit: param1 &rest)
			)
		)
	)
)

(instance egoHorn of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(switch theVerb
				(3 ; Do
					(if (== gDisguiseNum 0) ; outlaw
						(Say 1140 70) ; "I feel much the same as I did yesterday."
						1
					else
						(Say 1140 69) ; "Aye, here I am, in disguise."
						1
					)
				)
				(4 ; Inventory
					(if (== invItem 1) ; horn
						(cond
							(
								(and
									(== local1 0)
									(== gPrevRoomNum 160)
									(== gDay 2)
									(not (IsFlag 208))
								)
								(SetFlag 208)
								(= local1 1)
								(gRgnMusic number: 160 owner: self init: play:)
								(gEgo setScript: cantRap)
								1
							)
							((and (== local0 0) (not (IsFlag 208)))
								(= local0 1)
								(SetFlag 208)
								(gEgo setScript: blowOut)
								1
							)
							(else
								(Say 1140 47 1) ; "I've no mind to be deafened again."
								1
							)
						)
					)
				)
			)
		)
	)
)

(instance hornBadSound of Sound
	(properties
		flags 1
		number 903
	)
)

(instance fireSound of Sound
	(properties
		flags 1
		number 537
		loop -1
	)
)

(instance chestSound of Sound
	(properties
		flags 1
		number 459
	)
)

(instance chingSound of Sound
	(properties
		flags 1
		number 914
		loop 3
	)
)

(instance magicSound of Sound ; UNUSED
	(properties
		flags 1
		number 216
	)
)

(instance vanishSound of Sound ; UNUSED
	(properties
		flags 1
		number 213
	)
)

