;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43000)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use CueMe)
(use foEExit)
(use Array)
(use Feature)
(use Actor)
(use System)

(public
	roAsthExitPuzzle 0
)

(local
	nSmallestX
	nGreatestX = 632
	nSmallestY
	nGreatestY = 316
	oShardBeingHeld
	oIndexToShard
	bExit
)

(procedure (BendLight n dir)
	(return (+ 1 (mod (+ n (- dir 1)) 8)))
)

(procedure (DrawLine oFromSlot oToSlot)
	(oLines
		add:
			(AddLine
				(gCurRoom plane:)
				(oFromSlot x:)
				(oFromSlot y:)
				(oToSlot x:)
				(oToSlot y:)
				1001
				132
				0
				0
				1
			)
			(AddLine
				(gCurRoom plane:)
				(oFromSlot x:)
				(oFromSlot y:)
				(oToSlot x:)
				(oToSlot y:)
				1000
				13
				0
				0
				3
			)
	)
	(if (and (oToSlot oShard:) (not (oToSlot bLit:)))
		(oFromSlot bLit: 1)
		(oToSlot bLit: 1)
		(return 1)
	else
		(return 0)
	)
)

(procedure (DrawAllLines curSlot &tmp i) ; UNUSED
	(for ((= i 1)) (<= i 8) ((++ i))
		(DrawLine curSlot (curSlot computeTarget: i))
		(FrameOut)
	)
)

(instance oLines of Set
	(properties)

	(method (dispose &tmp theLine)
		(oSlot1 bLit: 0)
		(oSlot2 bLit: 0)
		(oSlot3 bLit: 0)
		(oSlot4 bLit: 0)
		(oSlot5 bLit: 0)
		(oSlot6 bLit: 0)
		(oSlot7 bLit: 0)
		(while size
			(DeleteLine (= theLine (oLines at: 0)) (gCurRoom plane:))
			(self delete: theLine)
		)
		(super dispose: &rest)
	)
)

(instance soDrawLight of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 playSound: 40903)
				(= ticks 30)
			)
			(1
				(oDrawLight cue:)
			)
		)
	)
)

(instance oDrawLight of CueMe
	(properties)

	(method (cue &tmp oLastSlot oCurSlot nDir)
		(= oLastSlot oSlot0)
		(= oCurSlot oSlot1)
		(= nDir 3)
		(while (DrawLine oLastSlot oCurSlot)
			(= oLastSlot oCurSlot)
			(= nDir (BendLight ((oCurSlot oShard:) nBendLight:) nDir))
			(= oCurSlot (oCurSlot computeTarget: nDir))
		)
		(gGame handsOn:)
		(cond
			(
				(and
					(== oCurSlot oSlot8)
					(oSlot7 bLit:)
					(oSlot6 bLit:)
					(oSlot5 bLit:)
					(oSlot4 bLit:)
					(oSlot3 bLit:)
					(oSlot2 bLit:)
					(oSlot1 bLit:)
				)
				(gCurRoom setScript: soPuzzleSolved)
			)
			(bExit
				(gCurRoom newRoom: 40900) ; roAsthExit
			)
		)
	)
)

(instance soPuzzleSolved of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64017 0) set: 156) ; oFlags
				(= ticks 60)
			)
			(1
				(goSound1 playSound: 40906 self)
			)
			(2
				(gCurRoom newRoom: 40900) ; roAsthExit
			)
		)
	)
)

(instance foExit of CUExitFeature
	(properties
		rExitTo 40900
	)

	(method (doVerb &tmp oEmptySlot)
		(if (== global101 75)
			(cond
				((not (oSlot1 oShard:))
					(= oEmptySlot foSlot1)
				)
				((not (oSlot2 oShard:))
					(= oEmptySlot foSlot2)
				)
				((not (oSlot3 oShard:))
					(= oEmptySlot foSlot3)
				)
				((not (oSlot4 oShard:))
					(= oEmptySlot foSlot4)
				)
				((not (oSlot5 oShard:))
					(= oEmptySlot foSlot5)
				)
				((not (oSlot6 oShard:))
					(= oEmptySlot foSlot6)
				)
				((not (oSlot7 oShard:))
					(= oEmptySlot foSlot7)
				)
				(else
					(PrintDebug {Alert: Have shard but no empty slot.})
					(= global101 1)
					(= oEmptySlot 0)
				)
			)
			(if oEmptySlot
				(= bExit 1)
				(oEmptySlot doVerb: 75)
			)
		else
			(super doVerb: &rest)
		)
	)
)

(class ShardSlot of Obj
	(properties
		bLit 0
		x 0
		y 0
		oShard 0
	)

	(method (posn nX nY)
		(= x nX)
		(= y nY)
	)
)

(instance oSlot0 of ShardSlot
	(properties
		x 51
		y 95
	)
)

(instance oSlot1 of ShardSlot
	(properties
		x 134
		y 95
	)

	(method (computeTarget dir)
		(switch dir
			(1
				(return oSlot13)
			)
			(2
				(return oSlot2)
			)
			(3
				(return oSlot3)
			)
			(4
				(return oSlot4)
			)
			(5
				(return oSlot18)
			)
			(6
				(return oSlot32)
			)
			(7
				(return oSlot0)
			)
			(8
				(return oSlot23)
			)
		)
	)
)

(instance oSlot2 of ShardSlot
	(properties
		x 229
		y 40
	)

	(method (computeTarget dir)
		(switch dir
			(1
				(return oSlot14)
			)
			(2
				(return oSlot29)
			)
			(3
				(return oSlot6)
			)
			(4
				(return oSlot3)
			)
			(5
				(return oSlot4)
			)
			(6
				(return oSlot1)
			)
			(7
				(return oSlot9)
			)
			(8
				(return oSlot24)
			)
		)
	)
)

(instance oSlot3 of ShardSlot
	(properties
		x 312
		y 95
	)

	(method (computeTarget dir)
		(switch dir
			(1
				(return oSlot15)
			)
			(2
				(return oSlot6)
			)
			(3
				(return oSlot7)
			)
			(4
				(return oSlot5)
			)
			(5
				(return oSlot20)
			)
			(6
				(return oSlot4)
			)
			(7
				(return oSlot1)
			)
			(8
				(return oSlot2)
			)
		)
	)
)

(instance oSlot4 of ShardSlot
	(properties
		x 206
		y 185
	)

	(method (computeTarget dir)
		(switch dir
			(1
				(return oSlot2)
			)
			(2
				(return oSlot3)
			)
			(3
				(return oSlot5)
			)
			(4
				(return oSlot26)
			)
			(5
				(return oSlot19)
			)
			(6
				(return oSlot33)
			)
			(7
				(return oSlot11)
			)
			(8
				(return oSlot1)
			)
		)
	)
)

(instance oSlot5 of ShardSlot
	(properties
		x 438
		y 185
	)

	(method (computeTarget dir)
		(switch dir
			(1
				(return oSlot6)
			)
			(2
				(return oSlot7)
			)
			(3
				(return oSlot12)
			)
			(4
				(return oSlot27)
			)
			(5
				(return oSlot21)
			)
			(6
				(return oSlot34)
			)
			(7
				(return oSlot4)
			)
			(8
				(return oSlot3)
			)
		)
	)
)

(instance oSlot6 of ShardSlot
	(properties
		x 416
		y 40
	)

	(method (computeTarget dir)
		(switch dir
			(1
				(return oSlot16)
			)
			(2
				(return oSlot30)
			)
			(3
				(return oSlot10)
			)
			(4
				(return oSlot7)
			)
			(5
				(return oSlot5)
			)
			(6
				(return oSlot3)
			)
			(7
				(return oSlot2)
			)
			(8
				(return oSlot25)
			)
		)
	)
)

(instance oSlot7 of ShardSlot
	(properties
		x 502
		y 95
	)

	(method (computeTarget dir)
		(switch dir
			(1
				(return oSlot17)
			)
			(2
				(return oSlot31)
			)
			(3
				(return oSlot8)
			)
			(4
				(return oSlot28)
			)
			(5
				(return oSlot22)
			)
			(6
				(return oSlot5)
			)
			(7
				(return oSlot3)
			)
			(8
				(return oSlot6)
			)
		)
	)
)

(instance oSlot8 of ShardSlot
	(properties
		x 620
		y 97
	)
)

(instance oSlot9 of ShardSlot
	(properties)
)

(instance oSlot10 of ShardSlot
	(properties)
)

(instance oSlot11 of ShardSlot
	(properties)
)

(instance oSlot12 of ShardSlot
	(properties)
)

(instance oSlot13 of ShardSlot
	(properties)
)

(instance oSlot14 of ShardSlot
	(properties)
)

(instance oSlot15 of ShardSlot
	(properties)
)

(instance oSlot16 of ShardSlot
	(properties)
)

(instance oSlot17 of ShardSlot
	(properties)
)

(instance oSlot18 of ShardSlot
	(properties)
)

(instance oSlot19 of ShardSlot
	(properties)
)

(instance oSlot20 of ShardSlot
	(properties)
)

(instance oSlot21 of ShardSlot
	(properties)
)

(instance oSlot22 of ShardSlot
	(properties)
)

(instance oSlot23 of ShardSlot
	(properties)
)

(instance oSlot24 of ShardSlot
	(properties)
)

(instance oSlot25 of ShardSlot
	(properties)
)

(instance oSlot26 of ShardSlot
	(properties)
)

(instance oSlot27 of ShardSlot
	(properties)
)

(instance oSlot28 of ShardSlot
	(properties)
)

(instance oSlot29 of ShardSlot
	(properties)
)

(instance oSlot30 of ShardSlot
	(properties)
)

(instance oSlot31 of ShardSlot
	(properties)
)

(instance oSlot32 of ShardSlot
	(properties)
)

(instance oSlot33 of ShardSlot
	(properties)
)

(instance oSlot34 of ShardSlot
	(properties)
)

(instance oClick of TPSound
	(properties)
)

(class ShardSlotFeature of Feature
	(properties
		oSlot 0
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 75)
	)

	(method (doVerb &tmp oSelectedShard)
		(= oSelectedShard (oSlot oShard:))
		(oSlot oShard: oShardBeingHeld)
		(oShardBeingHeld posn: x y init:)
		(if oSelectedShard
			(oClick playSound: 40901)
			(= oShardBeingHeld oSelectedShard)
			(oSelectedShard dispose:)
		else
			(= global101 1)
			(gCurRoom setScript: soDrawLight)
		)
	)
)

(instance foSlot1 of ShardSlotFeature
	(properties
		nsLeft 101
		nsTop 142
		nsRight 169
		nsBottom 177
		x 134
		y 170
	)
)

(instance foSlot2 of ShardSlotFeature
	(properties
		nsLeft 202
		nsTop 89
		nsRight 257
		nsBottom 114
		x 229
		y 109
	)
)

(instance foSlot3 of ShardSlotFeature
	(properties
		nsLeft 285
		nsTop 137
		nsRight 350
		nsBottom 175
		x 312
		y 163
	)
)

(instance foSlot4 of ShardSlotFeature
	(properties
		nsLeft 172
		nsTop 231
		nsRight 240
		nsBottom 266
		x 206
		y 259
	)
)

(instance foSlot5 of ShardSlotFeature
	(properties
		nsLeft 400
		nsTop 226
		nsRight 476
		nsBottom 268
		x 438
		y 257
	)
)

(instance foSlot6 of ShardSlotFeature
	(properties
		nsLeft 390
		nsTop 92
		nsRight 435
		nsBottom 108
		x 416
		y 110
	)
)

(instance foSlot7 of ShardSlotFeature
	(properties
		nsLeft 481
		nsTop 151
		nsRight 528
		nsBottom 169
		x 502
		y 168
	)
)

(class ViewShard of View
	(properties
		nBendLight 0
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 75)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(goSound1 playSound: 40904)
				(oLines dispose:)
				(= oShardBeingHeld self)
				(= global101 75)
				(switch self
					((oSlot1 oShard:)
						(oSlot1 oShard: 0)
					)
					((oSlot2 oShard:)
						(oSlot2 oShard: 0)
					)
					((oSlot3 oShard:)
						(oSlot3 oShard: 0)
					)
					((oSlot4 oShard:)
						(oSlot4 oShard: 0)
					)
					((oSlot5 oShard:)
						(oSlot5 oShard: 0)
					)
					((oSlot6 oShard:)
						(oSlot6 oShard: 0)
					)
					((oSlot7 oShard:)
						(oSlot7 oShard: 0)
					)
				)
				(self dispose:)
			)
			(75 ; ???
				(switch self
					((oSlot1 oShard:)
						(foSlot1 doVerb: theVerb)
					)
					((oSlot2 oShard:)
						(foSlot2 doVerb: theVerb)
					)
					((oSlot3 oShard:)
						(foSlot3 doVerb: theVerb)
					)
					((oSlot4 oShard:)
						(foSlot4 doVerb: theVerb)
					)
					((oSlot5 oShard:)
						(foSlot5 doVerb: theVerb)
					)
					((oSlot6 oShard:)
						(foSlot6 doVerb: theVerb)
					)
					((oSlot7 oShard:)
						(foSlot7 doVerb: theVerb)
					)
				)
			)
			(else
				(PrintDebug
					{Couldn't figure out which slot holds shard that was clicked upon}
				)
			)
		)
	)
)

(instance voR90One of ViewShard
	(properties
		view 43000
		nBendLight 2
	)
)

(instance voR90Two of ViewShard
	(properties
		view 43000
		loop 2
		nBendLight 2
	)
)

(instance voL90 of ViewShard
	(properties
		view 43000
		loop 1
		nBendLight 6
	)
)

(instance voL45Two of ViewShard
	(properties
		view 43000
		loop 6
		nBendLight 7
	)
)

(instance voL45 of ViewShard
	(properties
		view 43000
		loop 4
		nBendLight 7
	)
)

(instance voR135 of ViewShard
	(properties
		view 43000
		loop 5
		nBendLight 3
	)
)

(instance voL135 of ViewShard
	(properties
		view 43000
		loop 3
		nBendLight 5
	)
)

(instance roAsthExitPuzzle of TPRoom
	(properties
		picture 43000
	)

	(method (init &tmp tmpShard)
		(super init: &rest)
		((ScriptID 64017 0) set: 158) ; oFlags
		(oSlot9 posn: nSmallestX (oSlot2 y:))
		(oSlot10 posn: nGreatestX (oSlot2 y:))
		(oSlot11 posn: nSmallestX (oSlot4 y:))
		(oSlot12 posn: nGreatestX (oSlot4 y:))
		(oSlot13 posn: (+ (oSlot1 x:) 20) nSmallestY)
		(oSlot14 posn: (+ (oSlot2 x:) 8) nSmallestY)
		(oSlot15 posn: (oSlot3 x:) nSmallestY)
		(oSlot16 posn: (- (oSlot6 x:) 10) nSmallestY)
		(oSlot17 posn: (- (oSlot7 x:) 20) nSmallestY)
		(oSlot18 posn: (- (oSlot1 x:) 40) nGreatestY)
		(oSlot19 posn: (- (oSlot4 x:) 15) nGreatestY)
		(oSlot20 posn: (oSlot3 x:) nGreatestY)
		(oSlot21 posn: (+ (oSlot5 x:) 10) nGreatestY)
		(oSlot22 posn: (+ (oSlot7 x:) 40) nGreatestY)
		(oSlot23 posn: 0 (- (oSlot1 y:) (oSlot1 x:)))
		(oSlot24 posn: 0 (- (oSlot2 y:) (oSlot2 x:)))
		(oSlot25 posn: 0 (- (oSlot6 y:) (oSlot6 x:)))
		(oSlot26 posn: (+ nGreatestY (- (oSlot4 x:) (oSlot4 y:))) nGreatestY)
		(oSlot27 posn: (+ nGreatestY (- (oSlot5 x:) (oSlot5 y:))) nGreatestY)
		(oSlot28 posn: (+ nGreatestY (- (oSlot7 x:) (oSlot7 y:))) nGreatestY)
		(oSlot29 posn: (+ (oSlot2 x:) (oSlot2 y:)) 0)
		(oSlot30 posn: (+ (oSlot6 x:) (oSlot6 y:)) 0)
		(oSlot31 posn: (+ (oSlot7 x:) (oSlot7 y:)) 0)
		(oSlot32 posn: 0 (+ (oSlot1 x:) (oSlot1 y:)))
		(oSlot33 posn: 0 (+ (oSlot4 x:) (oSlot4 y:)))
		(oSlot34 posn: 0 (+ (oSlot5 x:) (oSlot5 y:)))
		(goMusic1 setMusic: 40900)
		(Load rsAUDIO 40903 40904 40906 40901)
		(foSlot1 init: oSlot: oSlot1)
		(foSlot2 init: oSlot: oSlot2)
		(foSlot3 init: oSlot: oSlot3)
		(foSlot4 init: oSlot: oSlot4)
		(foSlot5 init: oSlot: oSlot5)
		(foSlot6 init: oSlot: oSlot6)
		(foSlot7 init: oSlot: oSlot7)
		(= oIndexToShard
			(IDArray with: voR90One voR90Two voL90 voL45Two voL45 voR135 voL135)
		)
		(= tmpShard (oIndexToShard at: gPrismArray1))
		(tmpShard init: posn: (foSlot1 x:) (foSlot1 y:))
		(oSlot1 oShard: tmpShard)
		(= tmpShard (oIndexToShard at: gPrismArray2))
		(tmpShard init: posn: (foSlot2 x:) (foSlot2 y:))
		(oSlot2 oShard: tmpShard)
		(= tmpShard (oIndexToShard at: gPrismArray3))
		(tmpShard init: posn: (foSlot3 x:) (foSlot3 y:))
		(oSlot3 oShard: tmpShard)
		(= tmpShard (oIndexToShard at: gPrismArray4))
		(tmpShard init: posn: (foSlot4 x:) (foSlot4 y:))
		(oSlot4 oShard: tmpShard)
		(= tmpShard (oIndexToShard at: gPrismArray5))
		(tmpShard init: posn: (foSlot5 x:) (foSlot5 y:))
		(oSlot5 oShard: tmpShard)
		(= tmpShard (oIndexToShard at: gPrismArray6))
		(tmpShard init: posn: (foSlot6 x:) (foSlot6 y:))
		(oSlot6 oShard: tmpShard)
		(= tmpShard (oIndexToShard at: gPrismArray7))
		(tmpShard init: posn: (foSlot7 x:) (foSlot7 y:))
		(oSlot7 oShard: tmpShard)
		(foExit init:)
		(gGame handsOn:)
		(oDrawLight cue:)
	)

	(method (dispose)
		(oLines dispose:)
		(= gPrismArray1 (oIndexToShard indexOf: (oSlot1 oShard:)))
		(= gPrismArray2 (oIndexToShard indexOf: (oSlot2 oShard:)))
		(= gPrismArray3 (oIndexToShard indexOf: (oSlot3 oShard:)))
		(= gPrismArray4 (oIndexToShard indexOf: (oSlot4 oShard:)))
		(= gPrismArray5 (oIndexToShard indexOf: (oSlot5 oShard:)))
		(= gPrismArray6 (oIndexToShard indexOf: (oSlot6 oShard:)))
		(= gPrismArray7 (oIndexToShard indexOf: (oSlot7 oShard:)))
		(super dispose: &rest)
	)

	(method (gimme))
)

