;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40200)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roAstheniaIsland 0
)

(instance foCannonBall of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 118 167 158 163 155 135 134 119 119 122 100 140 100 157
					yourself:
				)
		)
	)

	(method (doVerb)
		(gEgo setScript: soGoToCannonBall)
	)
)

(instance foCaretakers of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 326 170 334 185 408 180 404 168 363 169 358 159 338 160 338 169
					yourself:
				)
		)
	)

	(method (doVerb)
		(gEgo setScript: soGoToCaretakers)
	)
)

(instance foCatapult of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 228 166 243 166 245 172 263 177 262 182 237 186 211 184 211 178 227 176
					yourself:
				)
		)
	)

	(method (doVerb)
		(gEgo setScript: soGoToCatapult)
	)
)

(instance soGoToCatapult of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo x:) 230)
					(= gbCatapultEastSide 0)
					(gEgo setMotion: PolyPath 220 179 self)
				else
					(= gbCatapultEastSide 1)
					(gEgo setMotion: PolyPath 248 178 self)
				)
			)
			(1
				(gCurRoom newRoom: 42100) ; roCatapult
			)
		)
	)
)

(instance soGoToCannonBall of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 154 168 self)
			)
			(1
				(gCurRoom newRoom: 42200) ; roCannonBall
			)
		)
	)
)

(instance soGoToCaretakers of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 307 178 self)
			)
			(1
				(gCurRoom newRoom: 42000) ; roCaretakers
			)
		)
	)
)

(instance soWalkInFromEntrance of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) ; oBoogle
					posn: 273 169
					init:
					normalize:
					setScalePercent: 10
					xStep: 2
					yStep: 1
					setScript: soBoogleWalkIn
				)
				(gEgo posn: 222 167 setPri: 5 setMotion: MoveTo 201 177 self)
			)
			(1
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soBoogleWalkIn of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					posn: 232 167
					setPri: 4
					setMotion: MoveTo 201 170 self
				)
			)
			(1
				((ScriptID 64018 0) setPri: -1 setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance foSpits of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 80 222 180 218 201 221 217 216 234 222 365 224 463 232 532 228 631 232 631 240 536 235 494 241 521 251 464 263 485 271 627 272 631 316 561 318 617 285 559 280 480 274 443 264 392 268 345 281 346 284 401 281 360 301 371 311 363 313 1 315 2 277 67 281 168 251 206 259 269 251 209 268 102 284 79 287 103 298 190 305 306 297 324 283 302 271 266 269 264 263 386 260 498 250 421 237 207 240 192 249 90 247 64 270 -1 274 2 262 51 261 59 253 1 252 1 241 64 235 165 233
					yourself:
				)
		)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gMessager say: 4 1 0 0 0 40200) ; "That spit of land over there MUST be the way out of here. (PAUSE) The trouble is: you can't get there from here!"
	)
)

(instance foCave of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 165 187 152 195 144 204 145 213 158 217 170
					yourself:
				)
		)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gMessager say: 6 1 0 0 0 40200) ; "That phenocryst chamber must have been very important to the people who built this island's defenses."
	)
)

(instance poLavaBubble of Prop
	(properties
		priority 2
		fixPriority 1
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self hide:)
		(self setScalePercent: 50)
		(self setScript: (soRandomBubble new:))
	)
)

(instance soRandomBubble of Script
	(properties)

	(method (changeState newState &tmp nLoop)
		(switch (= state newState)
			(0
				(= ticks (Random 30 250))
			)
			(1
				(= register (Random 0 4))
				(switch register
					(0)
					(1
						(client x: (+ (client x:) 5))
					)
					(2
						(client x: (- (client x:) 5))
					)
					(3
						(client y: (+ (client y:) 3))
					)
					(4
						(client y: (- (client y:) 3))
					)
				)
				(client
					cel: 0
					loop: (Random 2 4)
					cycleSpeed: (Random 6 10)
					show:
					setCycle: End self
				)
			)
			(2
				(switch register
					(0)
					(1
						(client x: (- (client x:) 5))
					)
					(2
						(client x: (+ (client x:) 5))
					)
					(3
						(client y: (- (client y:) 3))
					)
					(4
						(client y: (+ (client y:) 3))
					)
				)
				(client hide:)
				(self changeState: 0)
			)
		)
	)
)

(instance voCatapult of View
	(properties
		x 226
		y 181
		priority 500
		fixPriority 1
		view 40201
	)
)

(instance roAstheniaIsland of TPRoom
	(properties
		picture 40200
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 40200)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 162 165 135 169 191 180 224 184 228 177 245 179 246 185 316 184 306 172 263 175 253 172 219 173 191 171
					yourself:
				)
		)
		(foCannonBall init:)
		(foCaretakers init:)
		(foCatapult init:)
		(if ((ScriptID 64017 0) test: 136) ; oFlags
			(voCatapult init:)
		)
		(foSpits init:)
		(foCave init:)
		((poLavaBubble new:) posn: 440 132 init:)
		((poLavaBubble new:) posn: 460 109 init:)
		((poLavaBubble new:) posn: 514 100 init:)
		((poLavaBubble new:) posn: 313 96 init:)
		((poLavaBubble new:) posn: 322 118 init:)
		((poLavaBubble new:) posn: 533 76 init:)
		((poLavaBubble new:) posn: 614 93 init:)
		((poLavaBubble new:) posn: 604 72 init:)
		((poLavaBubble new:) posn: 22 141 init:)
		((poLavaBubble new:) posn: 45 158 init:)
		((poLavaBubble new:) posn: 72 211 init:)
		((poLavaBubble new:) posn: 21 223 init:)
		((poLavaBubble new:) posn: 159 292 init:)
		((poLavaBubble new:) posn: 243 286 init:)
		((poLavaBubble new:) posn: 412 301 init:)
		((poLavaBubble new:) posn: 442 216 init:)
		((poLavaBubble new:) posn: 369 213 init:)
		((poLavaBubble new:) posn: 282 210 init:)
		((poLavaBubble new:) posn: 537 260 init:)
		((poLavaBubble new:) posn: 575 293 init:)
		(= gbUnflattenBoogle 1)
		(gEgo
			init:
			normalize:
			setScalePercent: 10
			xStep: 2
			yStep: 1
			setSpeed: (Min 2 (gEgo moveSpeed:))
		)
		((ScriptID 64018 0) ; oBoogle
			init:
			normalize:
			setScalePercent: 10
			xStep: 2
			yStep: 1
			setSpeed: (Min 2 (gEgo moveSpeed:))
		)
		(switch gPrevRoomNum
			(40100 ; roAstheniaEntrance
				(gEgo setScript: soWalkInFromEntrance)
			)
			(42000 ; roCaretakers
				(gEgo posn: 307 178)
				((ScriptID 64018 0) posn: 297 178) ; oBoogle
			)
			(42100 ; roCatapult
				(if gbCatapultEastSide
					(gEgo posn: 248 178)
					((ScriptID 64018 0) posn: 258 178) ; oBoogle
				else
					(gEgo posn: 220 179)
					((ScriptID 64018 0) posn: 210 179) ; oBoogle
				)
			)
			(42200 ; roCannonBall
				(gEgo posn: 154 168)
				((ScriptID 64018 0) posn: 164 168) ; oBoogle
			)
			(else
				(gEgo setScript: soWalkInFromEntrance)
			)
		)
		(gEgo doit:)
		((ScriptID 64018 0) doit:) ; oBoogle
		(gGame handsOn:)
	)

	(method (dispose)
		(= gbUnflattenBoogle 0)
		(super dispose: &rest)
	)

	(method (gimme))
)

