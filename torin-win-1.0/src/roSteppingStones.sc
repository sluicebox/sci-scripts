;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40800)
(include sci.sh)
(use Main)
(use ScrollExit)
(use oHandsOnWhenCued)
(use TPSound)
(use SoTwinkle)
(use CueMe)
(use foEExit)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Ego)
(use Motion)
(use Actor)
(use System)

(public
	roSteppingStones 0
)

(local
	currentStone
	nextStone
	stonesDown
	[rowScale 40]
	[rowLoc 20]
	[stone 37]
	nJumperX
	nJumperY
	stoneSinkDelay
)

(procedure (SetFarShorePoly)
	((gCurRoom obstacles:) delete: oFarShoreWinnerPoly)
	((gCurRoom obstacles:) delete: oFarShorePoly)
	(if (>= stonesDown 34)
		(oFarShoreWinnerPoly init:)
		((gCurRoom obstacles:) add: oFarShoreWinnerPoly)
		(foExit init:)
		((ScriptID 64017 0) set: 151) ; oFlags
	else
		(oFarShorePoly init:)
		((gCurRoom obstacles:) add: oFarShorePoly)
		(foExit dispose:)
	)
)

(procedure (PositionStone aStone aRow aCol &tmp tx ty)
	(= tx (- aCol 12))
	(= tx (MulDiv tx 150 4))
	(= tx (+ (= tx (MulDiv tx [rowScale aRow] 100)) 316))
	(= ty [rowLoc aRow])
	(= ty (- 570 ty))
	(aStone posn: tx ty)
)

(procedure (InitStones &tmp i n)
	(for ((= i 0)) (< i 33) ((++ i))
		((= [stone i] (LavaStone new:)) setPri: 100 id: i)
	)
	(= stonesDown 34)
	(poBridge cel: 34)
	([stone 0] location: 2 6 init: add: 1 4)
	([stone 1] location: 2 10 init: add: 0 2 5 35)
	([stone 2] location: 2 14 init: add: 1 3 6 36)
	([stone 3] location: 2 18 init: add: 2 7)
	([stone 4] location: 4 6 init: add: 0 5 8)
	([stone 5] location: 4 10 init: add: 1 4 6 9)
	([stone 6] location: 4 14 init: add: 2 5 7 10)
	([stone 7] location: 4 18 init: add: 3 6 11)
	([stone 8] location: 6 6 init: add: 4 9 12)
	([stone 9] location: 6 10 init: add: 5 8 10 13)
	([stone 10] location: 6 14 init: add: 6 9 11 14)
	([stone 11] location: 6 18 init: add: 7 10 15)
	([stone 12] location: 8 6 init: add: 8 13 16)
	([stone 13] location: 8 10 init: add: 9 12 14 17)
	([stone 14] location: 8 14 init: add: 10 13 15 17)
	([stone 15] location: 8 18 init: add: 11 14 18)
	([stone 16] location: 10 6 init: add: 12 19 20)
	([stone 17] location: 10 12 init: add: 13 14 20 21 24)
	([stone 18] location: 10 18 init: add: 15 21 22)
	([stone 19] location: 11 3 init: add: 16 23 26)
	([stone 20] location: 11 9 init: add: 16 17 24 27)
	([stone 21] location: 11 15 init: add: 17 18 24 28)
	([stone 22] location: 11 21 init: add: 18 25 29)
	([stone 23] location: 12 0 init: add: 19 26)
	([stone 24] location: 12 12 init: add: 17 20 21 27 28 31)
	([stone 25] location: 12 24 init: add: 22 29)
	([stone 26] location: 13 3 init: add: 19 23 30)
	([stone 27] location: 13 9 init: add: 20 24 30 31)
	([stone 28] location: 13 15 init: add: 21 24 31 32)
	([stone 29] location: 13 21 init: add: 22 25 32)
	([stone 30] location: 14 6 init: add: 26 27)
	([stone 31] location: 14 12 init: add: 24 27 28 33)
	([stone 32] location: 14 18 init: add: 28 29)
	((= [stone 33] (AlmostFarLavaStone new:))
		location: 16 12
		id: 33
		init:
		add: 31 34
	)
	((= [stone 34] (FarLavaStone new:))
		signal: 16417
		loop: 4
		location: 18 12
		id: 34
		init:
		add: 33
		setPolygon:
			((Polygon new:)
				type: PTotalAccess
				init: 249 72 249 106 359 106 359 72
				yourself:
			)
	)
	((= [stone 35] (NearLavaStone new:))
		signal: 16417
		loop: 4
		location: 0 10
		id: 35
		init:
		add: 1 36
	)
	((= [stone 36] (NearLavaStone new:))
		signal: 16417
		loop: 4
		location: 0 14
		id: 36
		init:
		add: 2 35
	)
)

(instance oBridgeSound of TPSound
	(properties)
)

(instance soRaiseBridge of Script
	(properties)

	(method (changeState newState &tmp [temp0 4])
		(switch (= state newState)
			(0
				(poBridge setCycle: Beg self)
				(oBridgeSound setAmbient: 40805)
			)
			(1
				(oBridgeSound stop:)
				(self dispose:)
			)
		)
	)
)

(instance ResetStones of Script
	(properties)

	(method (changeState newState &tmp i thisCel highCel highCelObj)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= stonesDown 0)
				(SetFarShorePoly)
				(= highCel 1)
				(= highCelObj currentStone)
				(for ((= i 0)) (< i 34) ((++ i))
					(if (> (= thisCel ([stone i] cel:)) highCel)
						(= highCelObj [stone i])
						(= highCel thisCel)
					)
					([stone i] setScript: 0 addHotspotVerb: 1)
					(if (> thisCel 0)
						([stone i] cycleSpeed: 12 setCycle: Beg)
					)
				)
				(self setScript: soRaiseBridge self)
				(highCelObj setCycle: Beg self)
				(goSound1 playSound: 40806)
			)
			(1)
			(2
				(self dispose:)
			)
		)
	)
)

(class LavaStone of Prop
	(properties
		view 40802
		signal 20513
		id -1
		row -1
		canReachList 0
	)

	(method (init)
		(super init: &rest)
		(= canReachList (List new:))
		(self addHotspotVerb: 1)
	)

	(method (dispose)
		(if canReachList
			(canReachList release: dispose:)
			(= canReachList 0)
		)
		(super dispose:)
	)

	(method (location xGrid yGrid)
		(= row xGrid)
		(self setScalePercent: [rowScale row])
		(PositionStone self xGrid yGrid)
	)

	(method (add argv &tmp i)
		(for ((= i 0)) (< i argc) ((++ i))
			(canReachList add: [argv i])
		)
	)

	(method (onMe event)
		(cond
			((self isKindOf: NearLavaStone)
				(return
					(and
						(or (not currentStone) (canReachList contains: (currentStone id:)))
						(super onMe: event)
					)
				)
			)
			((self isKindOf: FarLavaStone)
				(return
					(and
						(== currentStone [stone 33])
						(== (poTorinJumper cel:) 0)
						(super onMe: event)
					)
				)
			)
			((self isKindOf: AlmostFarLavaStone)
				(return
					(and
						(or
							(== currentStone [stone 34])
							(and
								currentStone
								(== (poTorinJumper cel:) 0)
								(canReachList contains: (currentStone id:))
							)
						)
						(super onMe: event)
					)
				)
			)
			(else
				(return
					(and
						currentStone
						(== (poTorinJumper cel:) 0)
						(super onMe: event)
						(canReachList contains: (currentStone id:))
					)
				)
			)
		)
	)

	(method (doVerb &tmp temp0 temp1 temp2)
		(= temp0 (- x (currentStone x:)))
		(= temp1 (- y (currentStone y:)))
		(= temp2 -1)
		(cond
			((< temp0 -30)
				(cond
					((< temp1 0)
						(= temp2 7)
					)
					((> temp1 0)
						(= temp2 5)
					)
					(else
						(= temp2 1)
					)
				)
			)
			((> temp0 30)
				(cond
					((< temp1 0)
						(= temp2 6)
					)
					((> temp1 0)
						(= temp2 4)
					)
					(else
						(= temp2 0)
					)
				)
			)
			((< temp1 0)
				(= temp2 3)
			)
			((> temp1 0)
				(= temp2 2)
			)
			(else
				(return)
			)
		)
		(= nextStone self)
		(cond
			((and (== id 17) (or (== 13 (currentStone id:)) (== 14 (currentStone id:))))
				(= temp2 3)
			)
			((and (== (currentStone id:) 17) (or (== 13 id) (== 14 id)))
				(= temp2 2)
			)
		)
		(cond
			((or (== temp2 2) (== temp2 3))
				(poTorinJumper
					setLoop: temp2
					setCel: 0
					setScript: soJumpNorth self
				)
				(UpdateScreenItem poTorinJumper)
			)
			((or (== temp2 4) (== temp2 5))
				(poTorinJumper
					setLoop: temp2
					setCel: 0
					setScript: soJumpDiagonalSouth self
				)
				(UpdateScreenItem poTorinJumper)
			)
			((or (== temp2 6) (== temp2 7))
				(poTorinJumper
					setLoop: temp2
					setCel: 0
					setScript: soJumpDiagonalNorth self
				)
				(UpdateScreenItem poTorinJumper)
			)
			(else
				(poTorinJumper setLoop: temp2 setCel: 0 setCycle: End self)
				(UpdateScreenItem poTorinJumper)
			)
		)
		(= currentStone self)
	)

	(method (cue)
		(gGame handsOn:)
		(poTorinJumper
			setScalePercent: [rowScale row]
			setLoop: 0
			setCel: 0
			posn: x y
		)
		(UpdateScreenItem poTorinJumper)
		(PerformAutoScroll poTorinJumper)
		(= currentStone self)
		(self setScript: (SoStoneSink new:))
	)
)

(class NearLavaStone of LavaStone
	(properties)

	(method (doVerb)
		(if currentStone
			(super doVerb: &rest)
		else
			(= currentStone self)
			(self setScript: soEgoToJumper self)
		)
	)

	(method (cue)
		(gGame handsOn:)
		(poTorinJumper
			setScalePercent: [rowScale row]
			setLoop: 0
			setCel: 0
			posn: x y
		)
		(UpdateScreenItem poTorinJumper)
		(= currentStone self)
	)
)

(instance soJumperToEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not currentStone)
					(self dispose:)
					(return)
				)
				(gGame handsOff:)
				(= ticks 1)
			)
			(1
				(= currentStone 0)
				(gEgo
					normalize:
					loop: 8
					cel: 3
					posn: (poTorinJumper x:) (poTorinJumper y:)
					setPri: 650
					init:
					setMotion:
						MoveTo
						(poTorinJumper x:)
						(+ (poTorinJumper y:) 40)
						self
				)
				(poTorinJumper dispose:)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soEgoToJumper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (currentStone x:) (currentStone y:) self)
			)
			(1
				(= ticks 1)
			)
			(2
				(gEgo setHeading: 0 self)
			)
			(3
				(poTorinJumper
					posn: (currentStone x:) (currentStone y:)
					setScalePercent: [rowScale (currentStone row:)]
					init:
				)
				(gEgo dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soEgoToJumpBackward of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: soEgoToJumper self)
			)
			(1
				(poTorinJumper
					posn: (currentStone x:) (currentStone y:)
					setScalePercent: [rowScale (currentStone row:)]
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
				(UpdateScreenItem poTorinJumper)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(class AlmostFarLavaStone of LavaStone
	(properties)

	(method (doVerb)
		(if (== currentStone [stone 34])
			(self setScript: soEgoToJumpBackward self)
		else
			(super doVerb: &rest)
		)
	)
)

(class FarLavaStone of LavaStone
	(properties)

	(method (cue)
		(gGame handsOn:)
		(= currentStone self)
		(SetFarShorePoly)
		(gEgo
			normalize:
			posn: x y
			setScaler: Scaler [rowScale row] 15 100 46
			setPri: 10
			init:
		)
		(poTorinJumper dispose:)
	)
)

(instance soLavaDrown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(poTorinSinker
					posn: (register x:) (register y:)
					setScale:
					scaleX: (poTorinJumper scaleX:)
					scaleY: (poTorinJumper scaleY:)
					setCel: 0
					init:
					setCycle: CT 7 1 self
				)
				(poTorinJumper dispose:)
			)
			(1
				(goSound1 playSound: 40803)
				(register setCel: (register lastCel:))
				(poTorinSinker setCycle: End self)
			)
			(2
				(goSound1 stop:)
				(poTorinSinker dispose:)
				(if (not gCuees)
					(= gCuees (Set new:))
				)
				(gCuees add: ((Cue new:) cuee: coYourDead yourself:))
				(self dispose:)
			)
		)
	)
)

(instance coYourDead of CueMe
	(properties)

	(method (cue)
		(if ((ScriptID 64019 0) show: 0 42 3) ; DeathDialog
			(gCurRoom setScript: soReadyToGo)
		)
	)
)

(class SoStoneSink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client deleteHotspotVerb: 1)
				(++ stonesDown)
				(= ticks stoneSinkDelay)
			)
			(1
				(client setCel: 0 setCycle: CT 5 1 self)
				(UpdateScreenItem client)
			)
			(2
				(client setCel: 0 setCycle: CT 5 1 self)
				(UpdateScreenItem client)
			)
			(3
				(client setCel: 0 setCycle: CT 5 1 self)
				(UpdateScreenItem client)
			)
			(4
				(if (== currentStone client)
					(self setScript: soLavaDrown self client)
				else
					(client setCycle: End self)
					(goSound1 playSound: 40801)
					(poBridge cel: stonesDown)
				)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance foExit of ExitFeature
	(properties
		approachX 580
		approachY 47
		x 580
		y 47
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 535 2 543 110 631 110 630 0
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
	)

	(method (doVerb)
		(gEgo approach: self self)
	)

	(method (cue)
		(gCurRoom newRoom: 40900) ; roAsthExit
	)
)

(instance poTorinSinker of Prop
	(properties
		priority 650
		fixPriority 1
		view 40803
	)
)

(instance soJumpNorth of Script
	(properties)

	(method (init)
		(= nJumperX (- (nextStone x:) (currentStone x:)))
		(super init: &rest)
	)

	(method (changeState newState &tmp dx dy)
		(switch (= state newState)
			(0
				(poTorinJumper setCycle: CT 3 1 self)
			)
			(1
				(= dx (+ (= dx (/ nJumperX 4)) 1))
				(-= nJumperX dx)
				(poTorinJumper x: (+ (poTorinJumper x:) dx) setCel: 4)
				(UpdateScreenItem poTorinJumper)
				(= ticks (poTorinJumper cycleSpeed:))
			)
			(2
				(= dx (/ nJumperX 3))
				(-= nJumperX dx)
				(poTorinJumper x: (+ (poTorinJumper x:) dx) setCel: 5)
				(UpdateScreenItem poTorinJumper)
				(= ticks (poTorinJumper cycleSpeed:))
			)
			(3
				(= dx (/ nJumperX 2))
				(-= nJumperX dx)
				(poTorinJumper x: (+ (poTorinJumper x:) dx) setCel: 6)
				(UpdateScreenItem poTorinJumper)
				(= ticks (poTorinJumper cycleSpeed:))
			)
			(4
				(= dx nJumperX)
				(poTorinJumper x: (+ (poTorinJumper x:) dx) setCel: 7)
				(UpdateScreenItem poTorinJumper)
				(= ticks (poTorinJumper cycleSpeed:))
			)
			(5
				(poTorinJumper setCycle: End self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance soJumpDiagonalSouth of Script
	(properties)

	(method (init)
		(= nJumperX (- (nextStone x:) (currentStone x:)))
		(= nJumperY (- (nextStone y:) (currentStone y:)))
		(super init: &rest)
	)

	(method (changeState newState &tmp dx dy)
		(switch (= state newState)
			(0
				(poTorinJumper setCycle: CT 4 1 self)
			)
			(1
				(= dx (+ (= dx (/ nJumperX 2)) 1))
				(-= nJumperX dx)
				(poTorinJumper x: (+ (poTorinJumper x:) dx) setCel: 5)
				(UpdateScreenItem poTorinJumper)
				(= ticks (poTorinJumper cycleSpeed:))
			)
			(2
				(= dx nJumperX)
				(poTorinJumper x: (+ (poTorinJumper x:) dx) setCel: 6)
				(UpdateScreenItem poTorinJumper)
				(= ticks (poTorinJumper cycleSpeed:))
			)
			(3
				(poTorinJumper setCycle: End self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soJumpDiagonalNorth of Script
	(properties)

	(method (init)
		(= nJumperX (- (nextStone x:) (currentStone x:)))
		(super init: &rest)
	)

	(method (changeState newState &tmp dx dy)
		(switch (= state newState)
			(0
				(poTorinJumper setCycle: CT 3 1 self)
			)
			(1
				(= dx (+ (= dx (/ nJumperX 3)) 1))
				(-= nJumperX dx)
				(poTorinJumper x: (+ (poTorinJumper x:) dx) setCel: 4)
				(UpdateScreenItem poTorinJumper)
				(= ticks (poTorinJumper cycleSpeed:))
			)
			(2
				(= dx (/ nJumperX 2))
				(-= nJumperX dx)
				(poTorinJumper x: (+ (poTorinJumper x:) dx) setCel: 5)
				(UpdateScreenItem poTorinJumper)
				(= ticks (poTorinJumper cycleSpeed:))
			)
			(3
				(= dx nJumperX)
				(poTorinJumper x: (+ (poTorinJumper x:) dx) setCel: 6)
				(UpdateScreenItem poTorinJumper)
				(= ticks (poTorinJumper cycleSpeed:))
			)
			(4
				(poTorinJumper setCycle: End self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance poTorinJumper of Prop
	(properties
		priority 650
		fixPriority 1
		view 40801
	)
)

(instance poBridge of Prop
	(properties
		x 581
		y 59
		priority 28
		fixPriority 1
		view 40802
		loop 1
		cycleSpeed 5
	)
)

(instance soTorinEnter of Script
	(properties)

	(method (changeState newState &tmp i)
		(switch (= state newState)
			(0
				(= stonesDown 34)
				(for ((= i 0)) (< i 37) ((++ i))
					([stone i]
						setScript: 0
						cel: ([stone i] lastCel:)
					)
				)
				(= currentStone 0)
				(gEgo
					normalize:
					posn: 418 728
					setPri: 650
					init:
					setMotion: MoveTo 280 617 self
				)
				(poBridge cel: stonesDown)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poNearPusher of Prop
	(properties
		x 238
		y 611
		view 60801
	)
)

(instance soPushLever of Script
	(properties)

	(method (changeState newState &tmp i)
		(switch (= state newState)
			(0
				(gEgo hide:)
				(poNearPusher setCel: 0 init: setCycle: CT 4 1 self)
			)
			(1
				(poNearPusher setCycle: End self)
				(poNearResetHandle setCycle: ForwardCounter 3 self)
			)
			(2)
			(3
				((ScriptID 64017 0) set: 148) ; oFlags
				(gEgo show:)
				(poNearPusher dispose:)
				(self setScript: ResetStones self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soResetNear of Script
	(properties)

	(method (changeState newState &tmp i)
		(switch (= state newState)
			(0
				(if (<= stonesDown 0)
					(self dispose:)
				)
				(self setScript: soJumperToEgo self)
			)
			(1
				(gEgo
					setMotion: PolyPath (poNearPusher x:) (poNearPusher y:) self
				)
			)
			(2
				(= ticks 1)
			)
			(3
				(gGame handsOff:)
				(gEgo setHeading: 270 self)
			)
			(4
				(if (not ((ScriptID 64017 0) test: 149)) ; oFlags
					((ScriptID 64017 0) set: 149) ; oFlags
					(gMessager say: 1 1 1 1 self) ; "Hmm. Wonder what this does?"
				else
					(++ state)
				)
				(self setScript: soPushLever self)
			)
			(5)
			(6
				((ScriptID 64017 0) set: 147) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soReadyToGo of Script
	(properties)

	(method (changeState newState &tmp i)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(= currentStone [stone 35])
				(poTorinJumper
					posn: (currentStone x:) (currentStone y:)
					setScalePercent: [rowScale (currentStone row:)]
					init:
				)
				(PerformAutoScroll poTorinJumper)
				(self setScript: ResetStones self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voFarResetHandle of View
	(properties
		x 342
		y 98
		view 40802
		loop 3
	)
)

(instance foFarReset of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 341 90 338 79 346 69 353 83 350 88
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (onMe event)
		(return
			(and (> stonesDown 0) currentStone (== 34 (currentStone id:)) (super onMe: event))
		)
	)

	(method (doVerb)
		(if (not ((ScriptID 64017 0) test: 150)) ; oFlags
			((ScriptID 64017 0) set: 150) ; oFlags
			(gMessager say: 2 1 2 1) ; "Oh, good. I was wondering how I was going to get back!"
		)
		(gCurRoom setScript: ResetStones (ScriptID 64020 0)) ; oHandsOnWhenCued
	)
)

(instance poNearResetHandle of Prop
	(properties
		x 180
		y 561
		view 40802
		loop 2
	)
)

(instance foNearReset of Feature
	(properties
		x 184
		y 529
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 193 513 176 514 176 541 178 545 186 545
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (onMe event)
		(return
			(and
				(> stonesDown 0)
				(or
					(not currentStone)
					(and currentStone (or (== 35 (currentStone id:)) (== 36 (currentStone id:))))
				)
				(super onMe: event)
			)
		)
	)

	(method (doVerb)
		(gCurRoom setScript: soResetNear)
	)
)

(instance oNearShorePoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super
			init:
				478
				604
				422
				605
				393
				591
				369
				609
				269
				606
				248
				579
				216
				620
				174
				629
				145
				620
				132
				661
				498
				642
		)
	)
)

(instance oFarShorePoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super
			init:
				305
				47
				317
				70
				295
				86
				262
				102
				314
				102
				331
				84
				349
				83
				338
				70
				338
				48
		)
	)
)

(instance oFarShoreWinnerPoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super
			init:
				344
				45
				305
				47
				317
				70
				295
				86
				262
				102
				314
				102
				331
				84
				349
				83
				333
				59
				342
				48
				423
				57
				610
				57
				610
				55
				421
				55
		)
	)
)

(instance oRoomPlane of TorScrollPlane
	(properties
		priority 20
		oNScrollExit 0
		oSScrollExit 0
		oEScrollExit 0
		oWScrollExit 0
	)

	(method (addPics)
		(AddPicAt self 40800 0 316)
		(AddPicAt self 40801 0 0)
	)
)

(instance soLava1 of SoSuperTwinkle
	(properties
		minX 40
		maxX 120
		minY 250
		maxY 370
		maxLoop 8
		minCycle 8
		maxCycle 15
	)
)

(instance poLava1 of Prop
	(properties
		priority 4
		fixPriority 1
		view 40200
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLava1)
	)
)

(instance soLava2 of SoSuperTwinkle
	(properties
		minX 366
		maxX 628
		minY 132
		maxY 152
		maxLoop 8
		minCycle 8
		maxCycle 15
	)
)

(instance poLava2 of Prop
	(properties
		priority 4
		fixPriority 1
		view 40200
	)

	(method (init)
		(super init: &rest)
		(self setScalePercent: 34 setScript: soLava2)
	)
)

(instance soLava3 of SoSuperTwinkle
	(properties
		minX 475
		maxX 623
		minY 245
		maxY 323
		maxLoop 8
		minCycle 8
		maxCycle 15
	)
)

(instance poLava3 of Prop
	(properties
		priority 4
		fixPriority 1
		view 40200
	)

	(method (init)
		(super init: &rest)
		(self setScalePercent: 34 setScript: soLava3)
	)
)

(instance soLava4 of SoSuperTwinkle
	(properties
		minX 535
		maxX 632
		minY 300
		maxY 500
		maxLoop 8
		minCycle 8
		maxCycle 15
	)
)

(instance poLava4 of Prop
	(properties
		priority 4
		fixPriority 1
		view 40200
	)

	(method (init)
		(super init: &rest)
		(self setScalePercent: 50 setScript: soLava4)
	)
)

(instance soLava5 of SoSuperTwinkle
	(properties
		minX 366
		maxX 628
		minY 132
		maxY 152
		maxLoop 8
		minCycle 8
		maxCycle 15
	)
)

(instance poLava5 of Prop
	(properties
		priority 4
		fixPriority 1
		view 40200
	)

	(method (init)
		(super init: &rest)
		(self setScalePercent: 34 setScript: soLava5)
	)
)

(instance soLava6 of SoSuperTwinkle
	(properties
		minX 1
		maxX 100
		minY 21
		maxY 115
		maxLoop 8
		minCycle 8
		maxCycle 15
	)
)

(instance poLava6 of Prop
	(properties
		priority 4
		fixPriority 1
		view 40200
	)

	(method (init)
		(super init: &rest)
		(self setScalePercent: 34 setScript: soLava6)
	)
)

(instance soLava7 of SoSuperTwinkle
	(properties
		minX 1
		maxX 200
		minY 115
		maxY 160
		maxLoop 8
		minCycle 8
		maxCycle 15
	)
)

(instance poLava7 of Prop
	(properties
		priority 4
		fixPriority 1
		view 40200
	)

	(method (init)
		(super init: &rest)
		(self setScalePercent: 34 setScript: soLava7)
	)
)

(instance soLava8 of SoSuperTwinkle
	(properties
		minX 204
		maxX 480
		minY 300
		maxY 360
		maxLoop 8
		minCycle 8
		maxCycle 15
	)
)

(instance poLava8 of Prop
	(properties
		priority 4
		fixPriority 1
		view 40200
	)

	(method (init)
		(super init: &rest)
		(self setScalePercent: 63 setScript: soLava8)
	)
)

(instance roSteppingStones of TPRoom
	(properties)

	(method (init &tmp i)
		((ScriptID 64017 0) set: 146) ; oFlags
		(super init: &rest)
		(= plane (oRoomPlane init: 632 632 yourself:))
		(goMusic1 setMusic: 40100)
		(= [rowScale 0] 100)
		(= [rowScale 1] 93)
		(= [rowScale 2] 86)
		(= [rowScale 3] 80)
		(= [rowScale 4] 74)
		(= [rowScale 5] 68)
		(= [rowScale 6] 63)
		(= [rowScale 7] 58)
		(= [rowScale 8] 54)
		(= [rowScale 9] 50)
		(= [rowScale 10] 46)
		(= [rowScale 11] 43)
		(= [rowScale 12] 40)
		(= [rowScale 13] 37)
		(= [rowScale 14] 34)
		(= [rowScale 15] 31)
		(= [rowScale 16] 29)
		(= [rowScale 17] 27)
		(= [rowScale 18] 25)
		(= [rowScale 19] 23)
		(= [rowLoc 0] 0)
		(for ((= i 1)) (< i 20) ((++ i))
			(= [rowLoc i] (MulDiv 51 [rowScale i] 100))
			(+= [rowLoc i] [rowLoc (- i 1)])
		)
		(oNearShorePoly init:)
		(gCurRoom addObstacle: oNearShorePoly)
		(InitStones)
		(foFarReset init:)
		(voFarResetHandle init:)
		(foNearReset init:)
		(poNearResetHandle init:)
		(poBridge init:)
		(poLava1 init:)
		(poLava2 init:)
		(poLava3 init:)
		(poLava4 init:)
		(poLava5 init:)
		(poLava6 init:)
		(poLava7 init:)
		(poLava8 init:)
		(= stoneSinkDelay 120)
		(gCurRoom setScript: soTorinEnter)
	)

	(method (dispose &tmp i)
		(for ((= i 0)) (< i 37) ((++ i))
			([stone i] dispose:)
		)
		(super dispose:)
	)
)

