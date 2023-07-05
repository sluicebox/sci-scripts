;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56000)
(include sci.sh)
(use Main)
(use TPSound)
(use PushButton)
(use Plane)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	oCrystCorder 0
	poCrystCorderCu 1
	CrystCorderWinner 2
	voUnbrokenShard 3
)

(local
	shardPiece
	planeVisible
	eventX
	eventY
	winnerMsg
)

(procedure (FakeShardInHand)
	(= global101 81)
)

(procedure (FakeShardGoAway)
	(if (== global101 81)
		(= global101 1)
	)
)

(procedure (CrystCorderWinnerEnglish &tmp trayId m1 m2 m3 m4 m5 retval)
	(= trayId (oCrystCorder audPlay:))
	(if (>= (trayId size:) 4)
		(= m1 (trayId at: 0))
		(= m2 (trayId at: 1))
		(= m3 (trayId at: 2))
		(= m4 (trayId at: 3))
	)
	(if (>= (trayId size:) 5)
		(= m5 (trayId at: 4))
	else
		(= m5 0)
	)
	(cond
		(
			(and
				(== 4 (trayId size:))
				(== (m1 sfx:) 56006)
				(== (m2 sfx:) 56008)
				(== (m3 sfx:) 56003)
				(== (m4 sfx:) 56004)
			)
			(= retval 2)
		)
		(
			(and
				(== 4 (trayId size:))
				(== (m1 sfx:) 56003)
				(== (m2 sfx:) 56004)
				(== (m3 sfx:) 56006)
				(== (m4 sfx:) 56008)
			)
			(= retval 3)
		)
		(
			(and
				m5
				(== 5 (trayId size:))
				(== (m1 sfx:) 56005)
				(== (m2 sfx:) 56003)
				(== (m3 sfx:) 56004)
				(== (m4 sfx:) 56006)
				(== (m5 sfx:) 56008)
			)
			(= retval 3)
		)
		(
			(and
				m5
				(== 5 (trayId size:))
				(== (m1 sfx:) 56006)
				(== (m2 sfx:) 56008)
				(== (m3 sfx:) 56005)
				(== (m4 sfx:) 56003)
				(== (m5 sfx:) 56004)
			)
			(= retval 3)
		)
		(else
			(= retval 0)
		)
	)
	(return retval)
)

(procedure (CrystCorderWinnerFrench &tmp trayId m1 m2 m3 m4 m5 retval)
	(= trayId (oCrystCorder audPlay:))
	(if (== (trayId size:) 5)
		(= m1 (trayId at: 0))
		(= m2 (trayId at: 1))
		(= m3 (trayId at: 2))
		(= m4 (trayId at: 3))
		(= m5 (trayId at: 4))
	else
		(return 0)
	)
	(cond
		(
			(and
				(== (m1 sfx:) 56001)
				(== (m2 sfx:) 56003)
				(== (m3 sfx:) 56005)
				(== (m4 sfx:) 56007)
				(== (m5 sfx:) 56008)
			)
			(= retval 3)
		)
		(
			(and
				(== (m1 sfx:) 56005)
				(== (m2 sfx:) 56007)
				(== (m3 sfx:) 56008)
				(== (m4 sfx:) 56001)
				(== (m5 sfx:) 56003)
			)
			(= retval 3)
		)
		(else
			(= retval 0)
		)
	)
	(return retval)
)

(procedure (CrystCorderWinnerGerman &tmp trayId m1 m2 m3 m4 retval)
	(= trayId (oCrystCorder audPlay:))
	(if (== (trayId size:) 4)
		(= m1 (trayId at: 0))
		(= m2 (trayId at: 1))
		(= m3 (trayId at: 2))
		(= m4 (trayId at: 3))
	else
		(return 0)
	)
	(cond
		(
			(and
				(== (m1 sfx:) 56004)
				(== (m2 sfx:) 56008)
				(== (m3 sfx:) 56005)
				(== (m4 sfx:) 56002)
			)
			(= retval 2)
		)
		(
			(and
				(== 4 (trayId size:))
				(== (m1 sfx:) 56005)
				(== (m2 sfx:) 56002)
				(== (m3 sfx:) 56004)
				(== (m4 sfx:) 56008)
			)
			(= retval 3)
		)
		(else
			(= retval 0)
		)
	)
	(return retval)
)

(procedure (CrystCorderWinner &tmp trayId [unused 5] retval)
	(= retval (trayId size:)) ; UNINIT
)

(class CrystCorderSound of TPSound
	(properties
		curSound -1
		initted 0
		audHolder 0
		audPlay 0
	)

	(method (init &tmp i aObj aTray)
		(if (not initted)
			(super init: &rest)
			(= curSound -1)
			(= audPlay (Set new:))
			(= audHolder (Set new:))
			(= initted 1)
		)
		(if ((ScriptID 64017 0) test: 214) ; oFlags
			(if (and (not (audPlay size:)) (not (audHolder size:)))
				(if ((ScriptID 64017 0) test: 225) ; oFlags
					(self addRandomShards: 1)
				else
					(voUnbrokenShard init:)
					(self insertShard: 1 voUnbrokenShard 126 210)
				)
			else
				(for
					((= i (audPlay first:)))
					i
					((= i (audPlay next: i)))
					
					((KList 8 i) init:) ; NodeValue
				)
				(for
					((= i (audHolder first:)))
					i
					((= i (audHolder next: i)))
					
					((KList 8 i) init:) ; NodeValue
				)
				(= i (+ (audPlay size:) (audHolder size:)))
				(if (and ((ScriptID 64017 0) test: 225) (== i 1)) ; oFlags
					(= aTray (voUnbrokenShard tray:))
					(oCrystCorder deleteShard: aTray voUnbrokenShard)
					(self addBrokenShard: aTray)
					(voUnbrokenShard dispose:)
				)
			)
		)
	)

	(method (startCorder)
		(if (not (audPlay size:))
			(self stopCorder:)
		)
		(= curSound 8)
		(if ((ScriptID 64017 0) test: 214) ; oFlags
			(self cue:)
		)
		((ScriptID 64017 0) set: 216 213) ; oFlags
	)

	(method (stopCorder)
		(= curSound -1)
		((ScriptID 64017 0) clear: 216) ; oFlags
		(oPlayButton setButton: 0)
		(self stop:)
	)

	(method (dispose)
		(FakeShardGoAway)
	)

	(method (reallyDispose)
		(self stopCorder:)
		(audHolder dispose:)
		(audPlay dispose:)
		(super dispose:)
		(DisposeScript 56000)
	)

	(method (cue &tmp startSound snd)
		(if (== curSound -1)
			(return)
		)
		(if (not (audPlay size:))
			(return)
		)
		(= startSound curSound)
		(while 1
			(++ curSound)
			(if (== curSound 8)
				(self playSound: 56012 self)
				(return)
			)
			(if (>= curSound 8)
				(= curSound 0)
			)
			(if (!= 0 (= snd (audPlay at: curSound)))
				(break)
			)
			(if (== curSound startSound)
				(return)
			)
		)
		(if planeVisible
			(self
				playSubtitledSound: (snd sfx:) 1 1 0 (snd seq:) self 56000
			)
		else
			(self playSound: (snd sfx:) self)
		)
	)

	(method (addBrokenShard aTray &tmp trayId)
		(voShard0 init: tray: aTray)
		(voShard1 init: tray: aTray)
		(voShard2 init: tray: aTray)
		(voShard3 init: tray: aTray)
		(voShard4 init: tray: aTray)
		(voShard5 init: tray: aTray)
		(voShard6 init: tray: aTray)
		(voShard7 init: tray: aTray)
		(if (== aTray 2)
			(= trayId audPlay)
		else
			(= trayId audHolder)
		)
		(trayId
			addToEnd:
				voShard0
				voShard1
				voShard2
				voShard3
				voShard4
				voShard5
				voShard6
				voShard7
		)
		(self compressShards: aTray)
	)

	(method (addRandomShards aTray &tmp trayId i n1 n2 n1Id n2Id)
		(self addBrokenShard: aTray)
		(if (== aTray 2)
			(= trayId audPlay)
		else
			(= trayId audHolder)
		)
		(for ((= i 0)) (< i 20) ((++ i))
			(= n1 (Random 0 7))
			(= n2 (Random 0 7))
			(if (!= n1 n2)
				(= n1Id (trayId at: n1))
				(= n2Id (trayId at: n2))
				(trayId delete: n2Id)
				(trayId addAfter: n1Id n2Id)
			)
		)
		(self compressShards: aTray)
	)

	(method (setWinner)
		(= winnerMsg 0)
		(switch gnLanguage
			(33
				(= winnerMsg (CrystCorderWinnerFrench))
			)
			(49
				(= winnerMsg (CrystCorderWinnerGerman))
			)
			(1
				(= winnerMsg (CrystCorderWinnerEnglish))
			)
			(else
				(= winnerMsg (CrystCorderWinner))
			)
		)
		(if winnerMsg
			((ScriptID 64017 0) set: 217) ; oFlags
		else
			((ScriptID 64017 0) clear: 217) ; oFlags
		)
	)

	(method (deleteShard aTray aShard &tmp trayId)
		(if (== aTray 2)
			(= trayId audPlay)
		else
			(= trayId audHolder)
		)
		(if (and (!= curSound -1) (< curSound 8))
			(self stop: ((audPlay at: curSound) sfx:))
		)
		(trayId delete: aShard)
		(aShard tray: 0)
		(if (not (audPlay size:))
			(self stopCorder:)
		)
		(self setWinner:)
	)

	(method (compressShards aTray &tmp trayId node aObj xoff yoff)
		(if (== aTray 2)
			(= trayId audPlay)
			(= xoff 148)
			(= yoff 127)
		else
			(= trayId audHolder)
			(= xoff 126)
			(= yoff 210)
		)
		(+= xoff 5)
		(for ((= node (trayId first:))) node ((= node (trayId next: node)))
			(= aObj (KList 8 node)) ; NodeValue
			(aObj posn: xoff yoff)
			(= xoff
				(+
					(+=
						xoff
						(CelWide (aObj view:) (aObj loop:) (aObj cel:))
					)
					5
				)
			)
		)
	)

	(method (insertShard aTray aShard atX &tmp trayId node aObj)
		(if (== aTray 2)
			(= trayId audPlay)
		else
			(= trayId audHolder)
		)
		(= node (trayId first:))
		(if (or (== 0 (trayId size:)) (< atX ((KList 8 node) x:))) ; NodeValue
			(trayId addToFront: aShard)
		else
			(for
				((= node (trayId next: node)))
				node
				((= node (trayId next: node)))
				
				(if (< atX ((KList 8 node) x:)) ; NodeValue
					(= node (trayId prev: node))
					(trayId addAfter: (KList 8 node) aShard) ; NodeValue
					(break)
				)
			)
			(if (not node)
				(trayId addToEnd: aShard)
			)
		)
		(aShard tray: aTray)
		(self compressShards: aTray)
		(self setWinner:)
	)
)

(instance oCrystCorder of CrystCorderSound
	(properties)
)

(instance foFullPlay of Feature
	(properties
		x 156
		y 128
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 144 103 442 103 451 129 140 132
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 65 66 81)
	)

	(method (doVerb theVerb)
		(if (== theVerb 65) ; ioAudcryst
			((ScriptID 64017 0) set: 214) ; oFlags
			(((ScriptID 64001 0) get: 53) moveTo: -1) ; oInvHandler, ioAudcryst
			(oCrystCorder insertShard: 2 voUnbrokenShard 148 127)
			(voUnbrokenShard init:)
			(if (oPlayButton bButtonDown:)
				(oCrystCorder startCorder:)
			)
			(return)
		)
		(if (or (== theVerb 66) (== theVerb 81)) ; ioShatteredShard, ???
			(if (== theVerb 66) ; ioShatteredShard
				(((ScriptID 64001 0) get: 54) moveTo: -1) ; oInvHandler, ioShatteredShard
			else
				(FakeShardGoAway)
			)
			(if (not ((ScriptID 64017 0) test: 214)) ; oFlags
				(oCrystCorder addRandomShards: 2)
				((ScriptID 64017 0) set: 225) ; oFlags
				((ScriptID 64017 0) set: 214) ; oFlags
			else
				(oCrystCorder insertShard: 2 shardPiece eventX eventY)
				(shardPiece init:)
			)
		)
	)

	(method (onMe event &tmp retval)
		(return
			(if (= retval (super onMe: event))
				(= eventX (event x:))
				(= eventY (event y:))
			)
		)
	)
)

(instance foFullHolder of Feature
	(properties
		x 156
		y 212
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 125 183 459 182 465 211 117 212
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 65 66 81)
	)

	(method (doVerb theVerb)
		(if (== theVerb 65) ; ioAudcryst
			((ScriptID 64017 0) set: 214) ; oFlags
			(((ScriptID 64001 0) get: 53) moveTo: -1) ; oInvHandler, ioAudcryst
			(oCrystCorder insertShard: 1 voUnbrokenShard 126 210)
			(voUnbrokenShard init:)
		)
		(if (or (== theVerb 66) (== theVerb 81)) ; ioShatteredShard, ???
			(if (== theVerb 66) ; ioShatteredShard
				(((ScriptID 64001 0) get: 54) moveTo: -1) ; oInvHandler, ioShatteredShard
			else
				(FakeShardGoAway)
			)
			(if (not ((ScriptID 64017 0) test: 214)) ; oFlags
				(oCrystCorder addRandomShards: 1)
				((ScriptID 64017 0) set: 225) ; oFlags
				((ScriptID 64017 0) set: 214) ; oFlags
			else
				(oCrystCorder insertShard: 1 shardPiece eventX eventY)
				(shardPiece init:)
			)
		)
	)

	(method (onMe event &tmp retval)
		(return
			(if (= retval (super onMe: event))
				(= eventX (event x:))
				(= eventY (event y:))
			)
		)
	)
)

(class Shard of View
	(properties
		view 56000
		seq -1
		sfx -1
		tray 1
		invObject 2
	)

	(method (init)
		(if (== invObject 2)
			(= loop 1)
			(= cel (- sfx 56001))
			(= seq (+ cel 2))
		else
			(= cel (= loop 0))
			(= seq 1)
		)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(= shardPiece self)
		(if (== invObject 2)
			(FakeShardInHand)
		else
			(((ScriptID 64001 0) get: 53) moveTo: -2) ; oInvHandler, ioAudcryst
			((ScriptID 64017 0) clear: 214) ; oFlags
		)
		(oCrystCorder deleteShard: tray self)
		(self dispose:)
	)
)

(instance oPlayButton of ToggleButton
	(properties
		x 301
		y 157
		view 56001
	)

	(method (doSelect)
		(if bButtonDown
			(oCrystCorder startCorder:)
		else
			(oCrystCorder stopCorder:)
		)
	)
)

(instance voUnbrokenShard of Shard
	(properties
		sfx 56009
		invObject 1
	)

	(method (doVerb)
		(super doVerb: &rest)
	)
)

(instance voShard0 of Shard
	(properties
		sfx 56001
	)
)

(instance voShard1 of Shard
	(properties
		sfx 56002
	)
)

(instance voShard2 of Shard
	(properties
		sfx 56003
	)
)

(instance voShard3 of Shard
	(properties
		sfx 56004
	)
)

(instance voShard4 of Shard
	(properties
		sfx 56005
	)
)

(instance voShard5 of Shard
	(properties
		sfx 56006
	)
)

(instance voShard6 of Shard
	(properties
		sfx 56007
	)
)

(instance voShard7 of Shard
	(properties
		sfx 56008
	)
)

(instance poCrystCorderCu of Plane
	(properties
		picture 56000
		priority 20
	)

	(method (init &tmp i)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(= planeVisible 1)
		(oCrystCorder init:)
		(foFullPlay init:)
		(foFullHolder init:)
		(oPlayButton init:)
		(= shardPiece 0)
	)

	(method (dispose)
		(= planeVisible 0)
		(super dispose:)
	)
)

