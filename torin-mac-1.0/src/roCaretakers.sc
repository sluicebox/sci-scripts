;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42000)
(include sci.sh)
(use Main)
(use oInvHandler)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use Array)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roCaretakers 0
)

(local
	oLeftSideLocs
	oRightSideLocs
	bInBasket
	seesawPos = 1
)

(procedure (CheckWeight opCuee &tmp oCuee nRight nLeft newPos bEmpty)
	(= oCuee (if argc opCuee else 0))
	(if bInBasket
		(= nRight (+ 4 (NumCannonballsOwned)))
	else
		(= nRight 0)
	)
	(cond
		((> (= nLeft gnBallsInSeeSawLeft) nRight)
			(= newPos 0)
		)
		((== nLeft nRight)
			(= newPos 1)
		)
		(else
			(= newPos 2)
		)
	)
	(= bEmpty 0)
	(if (and (== nLeft 0) (== nRight 0))
		(= newPos 0)
		(= bEmpty 1)
	)
	(cond
		((!= newPos seesawPos)
			(switch newPos
				(0
					(if bEmpty
						(gCurRoom setScript: soSeeSawEmpty oCuee)
					else
						(gCurRoom setScript: soSeeSawLeftDown oCuee)
					)
				)
				(2
					(gCurRoom setScript: soSeeSawRightDown oCuee)
				)
				(1
					(gCurRoom setScript: soSeeSawBalance oCuee)
				)
			)
			(= seesawPos newPos)
			(foSeeSawLeft setRect:)
			(foSeeSawRight setRect:)
		)
		(oCuee
			(oCuee cue:)
		)
	)
)

(procedure (InitArrays)
	(= oLeftSideLocs
		(IntArray
			newWith: 14 167 156 167 168 167 178 167 188 167 199 167 211 169 221
		)
	)
	(= oRightSideLocs
		(IntArray
			newWith: 14 455 245 455 235 455 223 455 212 455 202 455 192 455 182
		)
	)
)

(procedure (GetLocX oArray nCel)
	(if (or (< argc 2) (not oArray))
		(PrintDebug {error in GetLocX -- 30400.sc DJM})
		(return 0)
	)
	(return (oArray at: (* nCel 2)))
)

(procedure (GetLocY oArray nCel)
	(if (or (< argc 2) (not oArray))
		(PrintDebug {error in GetLocY -- 30400.sc DJM})
		(return 0)
	)
	(return (oArray at: (+ (* nCel 2) 1)))
)

(instance foExitToIsland of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
		(self setRect: 0 0 20 316)
	)

	(method (doVerb)
		(gEgo setScript: soExit)
	)
)

(instance soExit of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath -30 221 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64018 0) setMotion: PolyPath -30 221) ; oBoogle
				(gEgo setMotion: MoveTo -30 221 self)
			)
			(2
				(gCurRoom newRoom: 40200) ; roAstheniaIsland
			)
		)
	)
)

(instance poSeeSaw of Prop
	(properties
		x 320
		y 213
		priority 237
		fixPriority 1
		view 42002
	)

	(method (doit &tmp nX nY)
		(super doit: &rest)
		(= nX (GetLocX oLeftSideLocs cel))
		(= nY (GetLocY oLeftSideLocs cel))
		(if (or (!= nX (voBallsInBasket x:)) (!= nY (voBallsInBasket y:)))
			(voBallsInBasket posn: nX nY)
			(if (voBallsInBasket scratch:)
				(voBallsInBasket doit:)
			)
		)
		(= nX (GetLocX oRightSideLocs cel))
		(= nY (GetLocY oRightSideLocs cel))
		(if (or (!= nX (voTorinInBasket x:)) (!= nY (voTorinInBasket y:)))
			(voTorinInBasket posn: nX nY)
			(if (voTorinInBasket scratch:)
				(voTorinInBasket doit:)
			)
		)
	)
)

(instance poTorin of Prop
	(properties)
)

(instance voTorinInBasket of View
	(properties
		priority 238
		fixPriority 1
		view 42001
		loop 4
	)
)

(instance foHouse of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 183 138 291 140 323 158 305 196 225 197 222 170 180 174
					yourself:
				)
		)
		(= x 225)
		(= y 197)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soLookAtHouse)
	)
)

(instance soLookAtHouse of TPScript
	(properties)

	(method (changeState newState &tmp nLoop)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if bInBasket
					(self cue:)
				else
					(gEgo face: foHouse self)
				)
			)
			(1
				(gMessager say: 3 1 0 0 self 40200) ; "That must be where the people lived who defended this island."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foLava of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 230 54 234 96 271 109 298 109 311 109 314 1 314
					yourself:
				)
		)
		(self addHotspotVerb: 50)
	)

	(method (doVerb)
		(gEgo setScript: soBowlBall)
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
						(client y: (+ (client y:) 5))
					)
					(4
						(client y: (- (client y:) 5))
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
						(client y: (- (client y:) 5))
					)
					(4
						(client y: (+ (client y:) 5))
					)
				)
				(client hide:)
				(self changeState: 0)
			)
		)
	)
)

(instance foGround of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 326 247 356 277 568 275 611 263 601 200 352 214
					yourself:
				)
		)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soJumpOutOfBasket)
	)
)

(instance voBallsInBasket of View
	(properties
		priority 236
		fixPriority 1
		view 42002
		loop 1
	)

	(method (init)
		(= cel (- gnBallsInSeeSawLeft 1))
		(super init: &rest)
		(|= signal $1000)
	)

	(method (testHotspotVerb)
		(foSeeSawLeft testHotspotVerb: &rest)
	)

	(method (doVerb)
		(foSeeSawLeft doVerb: &rest)
	)
)

(instance foSeeSawLeft of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(if (< gnBallsInSeeSawLeft 6)
			(self addHotspotVerb: 50)
		)
		(if gnBallsInSeeSawLeft
			(self addHotspotVerb: 1)
		)
		(self setRect:)
	)

	(method (testHotspotVerb)
		(if bInBasket
			(return 0)
		else
			(return (super testHotspotVerb: &rest))
		)
	)

	(method (setRect)
		(switch seesawPos
			(0
				(super setRect: 148 208 200 234)
			)
			(1
				(super setRect: 141 174 196 203)
			)
			(2
				(super setRect: 143 144 198 172)
			)
			(else
				(PrintDebug {prob in foSeeSawLeft setRect})
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(50 ; ioCannonball1-6
				(gEgo setScript: soPutBallInBasket)
			)
			(1 ; Do
				(if (>= (NumCannonballsOwned) 5)
					(gMessager say: 1 1 2 0 0 40200) ; "I think five of these is just about all I can handle!"
					(return)
				)
				(if (== gnBallsInSeeSawLeft 0)
					(PrintDebug {tried to take ball from empty basket})
					(return)
				)
				(gEgo setScript: soTakeBallFromBasket)
			)
		)
	)
)

(instance foSeeSawRight of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self setRect:)
	)

	(method (setRect)
		(switch seesawPos
			(0
				(super setRect: 432 144 487 171)
			)
			(1
				(super setRect: 433 177 489 203)
			)
			(2
				(super setRect: 427 205 482 234)
			)
			(else
				(PrintDebug {prob in foSeeSawRight setRect})
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(if bInBasket
					(gEgo setScript: soJumpOutOfBasket)
				else
					(gEgo setScript: soJumpIntoBasket)
				)
			)
		)
	)
)

(instance soJumpIntoBasket of TPScript
	(properties)

	(method (changeState newState &tmp nLoop)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 381 260 self)
			)
			(1
				(gGame handsOff:)
				(goSound1 preload: 42005)
				((ScriptID 64017 0) set: 133) ; oFlags
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo hide:)
				(poTorin
					view: 42001
					loop: 0
					cel: 0
					posn: 381 258
					init:
					setCycle: End self
				)
			)
			(3
				(= bInBasket 1)
				(poTorin dispose:)
				(voTorinInBasket init:)
				(foExitToIsland dispose:)
				(foLava dispose:)
				(foGround init:)
				(CheckWeight self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soJumpOutOfBasket of TPScript
	(properties)

	(method (changeState newState &tmp nLoop nCels)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 42005)
				(= bInBasket 0)
				(voTorinInBasket dispose:)
				(foExitToIsland init:)
				(foLava init:)
				(foGround dispose:)
				(switch seesawPos
					(2
						(= nLoop 3)
						(= nCels 10)
					)
					(1
						(= nLoop 2)
						(= nCels 19)
					)
					(0
						(= nLoop 1)
						(= nCels 11)
					)
				)
				(poTorin
					view: 42001
					loop: nLoop
					cel: 0
					posn: 381 258
					init:
					setCycle: CT nCels 1 self
				)
			)
			(1
				(CheckWeight)
				(poTorin setCycle: End self)
			)
			(2
				(poTorin dispose:)
				(gEgo posn: 381 260 normalize: 1 60100 6 show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soBowlBall of TPScript
	(properties)

	(method (changeState newState &tmp nLoop)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 194 250 self)
			)
			(1
				(gGame handsOff:)
				(goSound1 preload: 42003)
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo hide:)
				(poTorin
					view: 42000
					loop: 0
					cel: 0
					posn: 194 250
					init:
					setCycle: End self
				)
			)
			(3
				(poTorin loop: 3 cel: 0 setCycle: CT 14 1 self)
			)
			(4
				(goSound1 playSound: 42003 self)
				(poTorin setCycle: CT 21 1)
			)
			(5
				(poTorin setCycle: End self)
			)
			(6
				(if (and gInventItem (IsCannonball gInventItem))
					(gEgo put: gInventItem)
				else
					(gEgo put: (GetHeldCannonball))
				)
				(poTorin dispose:)
				(gEgo posn: 160 258 normalize: 1 60100 0 show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soPutBallInBasket of TPScript
	(properties)

	(method (changeState newState &tmp nLoop)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 171 250 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64017 0) set: 134) ; oFlags
				(goSound1 preload: 42006)
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo hide:)
				(poTorin
					view: 42000
					loop: 0
					cel: 0
					posn: 171 250
					init:
					setCycle: End self
				)
			)
			(3
				(if (== seesawPos 1)
					(= nLoop 1)
				else
					(= nLoop 2)
				)
				(poTorin loop: nLoop cel: 0 setCycle: CT 6 1 self)
			)
			(4
				(goSound1 playSound: 42006)
				(poTorin setCycle: End self)
			)
			(5
				(if (== gnBallsInSeeSawLeft 0)
					(voBallsInBasket init:)
				)
				(++ gnBallsInSeeSawLeft)
				(voBallsInBasket cel: (- gnBallsInSeeSawLeft 1))
				(if (== gnBallsInSeeSawLeft 6)
					(foSeeSawLeft deleteHotspotVerb: 50)
				)
				(foSeeSawLeft addHotspotVerb: 1)
				(if (and gInventItem (IsCannonball gInventItem))
					(gEgo put: gInventItem)
				else
					(gEgo put: (GetHeldCannonball))
				)
				(CheckWeight)
				(poTorin loop: 4 cel: 0 setCycle: End self)
			)
			(6
				(poTorin dispose:)
				(gEgo posn: 146 258 normalize: 1 60100 0 show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTakeBallFromBasket of TPScript
	(properties)

	(method (changeState newState &tmp nLoop)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 171 250 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo hide:)
				(poTorin view: 42000 loop: 2)
				(poTorin
					cel: (poTorin lastCel:)
					posn: 171 250
					init:
					setCycle: Beg self
				)
			)
			(3
				(if (== (-- gnBallsInSeeSawLeft) 0)
					(voBallsInBasket dispose:)
					(foSeeSawLeft deleteHotspotVerb: 1)
				else
					(voBallsInBasket cel: (- gnBallsInSeeSawLeft 1))
				)
				(foSeeSawLeft addHotspotVerb: 50)
				(gEgo get: (GetUnheldCannonball))
				(CheckWeight)
				(poTorin loop: 0 cel: (poTorin lastCel:) setCycle: Beg self)
			)
			(4
				(poTorin dispose:)
				(gEgo normalize: 1 60100 3 show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soWalkIn of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: -30 221 setMotion: MoveTo 30 221 self)
				((ScriptID 64018 0) setScript: soBoogleWalkIn) ; oBoogle
			)
			(1
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
					posn: -40 221
					setMotion: MoveTo 20 221 self
				)
			)
			(1
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance oTeeterSqueak of TPSound
	(properties)
)

(instance oThump of TPSound
	(properties)
)

(instance soSeeSawEmpty of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oTeeterSqueak playSound: 42002)
				(poSeeSaw cycleSpeed: 9 setCycle: CT 5 1 self)
			)
			(1
				(oThump playSound: 42005)
				(poSeeSaw setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soSeeSawBalance of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oTeeterSqueak playSound: 42002)
				(poSeeSaw cycleSpeed: 9 setCycle: CT 1 -1 self)
			)
			(1
				(oTeeterSqueak playSound: 42002)
				(poSeeSaw cycleSpeed: 9 setCycle: CT 5 1 self)
			)
			(2
				(oTeeterSqueak playSound: 42002)
				(poSeeSaw cycleSpeed: 9 setCycle: CT 2 -1 self)
			)
			(3
				(oTeeterSqueak playSound: 42002)
				(poSeeSaw cycleSpeed: 9 setCycle: CT 4 1 self)
			)
			(4
				(oTeeterSqueak playSound: 42002)
				(poSeeSaw cycleSpeed: 9 setCycle: CT 3 -1 self)
			)
			(5
				(if (and bInBasket (not ((ScriptID 64017 0) test: 136))) ; oFlags
					((ScriptID 64017 0) set: 136 140) ; oFlags
					(goSound1 playSound: 42004)
				)
				(self dispose:)
			)
		)
	)
)

(instance soSeeSawLeftDown of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oTeeterSqueak playSound: 42002)
				(poSeeSaw cycleSpeed: 4 setCycle: CT 5 1 self)
			)
			(1
				(oThump playSound: 42005)
				(poSeeSaw setCycle: End self)
				(self dispose:)
			)
		)
	)
)

(instance soSeeSawRightDown of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oTeeterSqueak playSound: 42002)
				(poSeeSaw cycleSpeed: 4 setCycle: CT 1 -1 self)
			)
			(1
				(oThump playSound: 42005)
				(poSeeSaw setCycle: Beg self)
				(self dispose:)
			)
		)
	)
)

(instance roCaretakers of TPRoom
	(properties
		picture 42000
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 40300)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 354 250 325 252 145 257 124 235 503 234 503 240 504 246
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 0 224 74 224 102 254 117 254 129 252 142 261 152 267 515 256 510 222 109 225 112 234 92 230 68 208 0 209
					yourself:
				)
		)
		(InitArrays)
		(poSeeSaw init:)
		(foSeeSawLeft init:)
		(foSeeSawRight init:)
		(foLava init:)
		(foHouse init:)
		((poLavaBubble new:) posn: 16 284 init:)
		((poLavaBubble new:) posn: 47 303 init:)
		(if gnBallsInSeeSawLeft
			(= seesawPos 0)
			(poSeeSaw cel: 6)
			(voBallsInBasket init:)
		else
			(= seesawPos 0)
			(poSeeSaw cel: 6)
		)
		(foSeeSawLeft setRect:)
		(foSeeSawRight setRect:)
		(foExitToIsland init:)
		(gEgo init: normalize: setScaler: Scaler 73 35 255 205)
		((ScriptID 64018 0) ; oBoogle
			posn: 30 300
			init:
			normalize:
			setScaler: Scaler 73 35 255 205
		)
		(gGame handsOn:)
		((ScriptID 64017 0) set: 137) ; oFlags
		(gEgo setScript: soWalkIn)
	)

	(method (dispose)
		(if oLeftSideLocs
			(oLeftSideLocs dispose:)
			(= oLeftSideLocs 0)
		)
		(if oRightSideLocs
			(oRightSideLocs dispose:)
			(= oRightSideLocs 0)
		)
		(super dispose: &rest)
	)

	(method (gimme)
		(if (GetUnheldCannonball)
			(gEgo get: (GetUnheldCannonball))
		)
	)
)

