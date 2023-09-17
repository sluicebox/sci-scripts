;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6000)
(include sci.sh)
(use Main)
(use ManualSort)
(use acesup)
(use Str)
(use Print)
(use Motion)
(use System)

(local
	local0
	[local1 2]
	local3
	local4
	local5
	local6
	local7
)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 &tmp temp0)
	(if (and (< argc 4) (not param1))
		(return)
	)
	(if (< param1 0)
		(= temp0 1)
		(*= param1 -1)
	else
		(= temp0 0)
	)
	(cond
		((>= param1 1000)
			(proc0_10
				990
				4
				(mod (/ param1 1000) 10)
				(+ param2 30)
				param3
				15
				param6
				param5
			)
			(proc0_10
				990
				4
				(mod (/ param1 100) 10)
				(+ param2 38)
				param3
				15
				param6
				param5
			)
			(proc0_10
				990
				4
				(mod (/ param1 10) 10)
				(+ param2 46)
				param3
				15
				param6
				param5
			)
			(proc0_10
				990
				4
				(mod param1 10)
				(+ param2 54)
				param3
				15
				param6
				param5
			)
		)
		((>= param1 100)
			(proc0_10
				990
				4
				(mod (/ param1 100) 10)
				(+ param2 38)
				param3
				15
				param6
				param5
			)
			(proc0_10
				990
				4
				(mod (/ param1 10) 10)
				(+ param2 46)
				param3
				15
				param6
				param5
			)
			(proc0_10
				990
				4
				(mod param1 10)
				(+ param2 54)
				param3
				15
				param6
				param5
			)
		)
		((>= param1 10)
			(proc0_10
				990
				4
				(mod (/ param1 10) 10)
				(+ param2 46)
				param3
				15
				param6
				param5
			)
			(proc0_10
				990
				4
				(mod param1 10)
				(+ param2 54)
				param3
				15
				param6
				param5
			)
		)
		((>= param1 0)
			(if (or (== param5 {seconds}) (== param5 {bestseconds}))
				(if (== param1 0)
					(proc0_10
						990
						4
						(mod (/ param1 10) 10)
						(+ param2 46)
						param3
						15
						param6
						param5
					)
					(proc0_10
						990
						4
						(mod param1 10)
						(+ param2 54)
						param3
						15
						param6
						param5
					)
				else
					(proc0_10 990 4 0 (+ param2 46) param3 15 param6 param5)
					(proc0_10
						990
						4
						(mod param1 10)
						(+ param2 54)
						param3
						15
						param6
						param5
					)
				)
			else
				(proc0_10
					990
					4
					(mod param1 10)
					(+ param2 54)
					param3
					15
					param6
					param5
				)
			)
		)
	)
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1 (Str format: {%s} param1))
	(= temp2 ((param2 casts:) at: 0))
	(for ((= temp0 (- (temp2 size:) 1))) (>= temp0 0) ((-- temp0))
		(if
			(and
				((temp2 at: temp0) name:)
				(temp1 compare: ((temp2 at: temp0) name:))
			)
			((temp2 at: temp0) dispose:)
		)
	)
	(temp1 dispose:)
)

(class sHand of Hand
	(properties
		whatType 0
		cardShow 0
		cardLimit 0
		buildOrder 0
		buildStep 0
		startRank 0
		followRank 0
		wrapping 0
		fill 0
		canTrack 0
		topCard 0
		canPlay 0
		cardsDown 0
		cardsUp 0
		tailMove 0
		growView 0
		orgX 0
		orgY 0
		emptyView 0
		whereTo 0
		cardsDealtDown 0
	)

	(method (nextPri)
		(if size
			(return (+ (- size 1) 2))
		else
			(return 2)
		)
	)

	(method (lastCrd)
		(if (not size)
			(zeroCard nsLeft: (self x:))
			(zeroCard nsRight: (+ (zeroCard nsLeft:) 54))
			(zeroCard nsTop: (self y:))
			(zeroCard nsBottom: (+ (zeroCard nsTop:) 77))
			(return zeroCard)
		else
			(return (self at: (- size 1)))
		)
	)

	(method (legalPlay param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(for ((= temp0 0)) (< temp0 (gTheHands size:)) ((++ temp0))
			(if (== (param1 owner:) (gTheHands at: temp0))
			else
				(= local0 ((gTheHands at: temp0) size:))
				(= local3 (gTheHands at: temp0))
				(if (param1 tailList:)
					(= temp4 (+ 1 ((param1 tailList:) size:)))
				else
					(= temp4 1)
				)
				(= temp1 (local3 lastCrd:))
				(if
					(and
						(== gCardGameScriptNumber 6001)
						(== (local3 whatType:) 1)
						(== local0 1)
					)
					(temp1 nsLeft: 0)
					(temp1 nsRight: 54)
					(temp1 nsTop: 0)
					(temp1 nsBottom: 77)
				)
				(if
					(and
						(== gCardGameScriptNumber 6007)
						(== global927 1)
						((gTheFoundations at: 0) size:)
						(==
							(((gTheFoundations at: 0)
									at: (- ((gTheFoundations at: 0) size:) 1)
								)
								rank:
							)
							13
						)
					)
					(return 0)
				)
				(if
					(and
						(proc15_0 temp1 param1)
						(!= (local3 buildOrder:) 0)
						(not (and (param1 tailList:) (!= (local3 whatType:) 0)))
						(<= (+ temp4 (local3 size:)) (local3 cardLimit:))
						(or
							(== ((param1 owner:) whereTo:) 0)
							(and
								(== ((param1 owner:) whereTo:) 1)
								(== (local3 whatType:) 1)
							)
						)
						(or
							(and
								(== local0 0)
								(!= (local3 startRank:) 0)
								(or
									(and
										(== (param1 rank:) 13)
										(== (local3 startRank:) 1)
									)
									(and
										(== (param1 rank:) 1)
										(== (local3 startRank:) 2)
									)
									(== (local3 startRank:) 3)
									(and
										(== (local3 startRank:) 4)
										(or
											(== (local3 followRank:) 0)
											(==
												(param1 rank:)
												(local3 followRank:)
											)
										)
									)
									(and
										(== (local3 startRank:) 5)
										(or
											(==
												(param1 rank:)
												(-
													(((gTheFoundations at: 0) at: 0)
														rank:
													)
													1
												)
											)
											(and
												(== (param1 rank:) 13)
												(==
													(-
														(((gTheFoundations at: 0)
																at: 0
															)
															rank:
														)
														1
													)
													0
												)
											)
										)
									)
								)
							)
							(local3 buildCheck: temp1 param1)
						)
						(not (and (== (local3 startRank:) 0) (== local0 0)))
					)
					((gTheHands at: temp0) add: param1)
					(if (param1 tailList:)
						(param1 wasTailList: (+ (param1 wasTailList:) 1))
						(= global224 1)
						(for
							((= temp2 0))
							(< temp2 ((param1 tailList:) size:))
							((++ temp2))
							
							(= temp3 ((param1 tailList:) at: temp2))
							((gTheHands at: temp0) add: temp3)
						)
						(= global224 0)
					)
					(if (!= (local3 whatType:) 1)
						(gSound play: 907)
					)
					(return 1)
				)
			)
		)
	)

	(method (handleCard param1 param2 &tmp temp0 temp1 temp2 temp3 [temp4 2] temp6 temp7 temp8)
		(if
			(and
				(not (param1 claimed:))
				(not global395)
				(= temp0 (param2 reverseFirstTrue: 165 param1))
			)
			(= temp1 (param2 indexOf: temp0))
			(cond
				((and (not (temp0 faceUp:)) (!= temp1 (- (param2 size:) 1)))
					(= global920 1)
					(gChar1 sayReg: 600 15 46 0 (Random 1 2))
					(return 1)
				)
				(
					(and
						(== (param2 tailMove:) 0)
						(!= temp1 (- (param2 size:) 1))
						(!= (param2 whatType:) 3)
					)
					(= global920 1)
					(gChar1 sayReg: 600 15 130 0 (Random 1 2))
					(if global222
						((ScriptID 6101 0) init: 1) ; tutorialSolitaire
					)
					(return 1)
				)
				(
					(and
						(or (== (param2 tailMove:) 1) (== (param2 tailMove:) 2))
						(!= temp1 (- (param2 size:) 1))
						(not (param2 pBuild: temp0))
					)
					(= global920 1)
					(gChar1 sayReg: 600 15 130 0 (Random 1 2))
					(if global222
						((ScriptID 6101 0) init: 3) ; tutorialSolitaire
					)
					(return 1)
				)
				((== (param2 whereTo:) 2)
					(= global920 1)
					(gChar1 sayReg: 600 15 130 0 (Random 1 2))
					(if global222
						(if (and (== gCardGameScriptNumber 6002) (== (param2 whatType:) 1))
							((ScriptID 6101 0) init: 5) ; tutorialSolitaire
						else
							((ScriptID 6101 0) init: 4) ; tutorialSolitaire
						)
					)
					(return 1)
				)
			)
			(= global399 0)
			(if (or (== gCardGameScriptNumber 6013) (!= (param2 tailMove:) 0))
				(if (tmpList size:)
					(tmpList release:)
				)
				(for
					((= temp1 (+ (param2 indexOf: temp0) 1)))
					(< temp1 (param2 size:))
					((++ temp1))
					
					(tmpList add: (param2 at: temp1))
				)
				(if (tmpList size:)
					(temp0 tailList: tmpList)
					(temp0 associatedObj: tmpList)
				)
				(if (= temp1 (param2 indexOf: temp0))
					((= global399 (param2 at: (- temp1 1))) setLoop: 0)
				)
			)
			(if (not (temp0 faceUp:))
				(temp0 flip: 1)
			)
			(if
				(and
					(== (= temp7 (temp0 processEvent: param1 global399)) 1)
					(& (param1 modifiers:) $0003)
				)
				(= temp6 2)
			else
				(= temp6 temp7)
			)
			(switch temp6
				(3)
				(1
					(cond
						((self legalPlay: temp0)
							(param2 eliminateCard: temp0)
							(if (temp0 tailList:)
								(for
									((= temp1 0))
									(< temp1 ((temp0 tailList:) size:))
									((++ temp1))
									
									(param2
										eliminateCard:
											((temp0 tailList:) at: temp1)
									)
								)
							)
							(temp0 tailList: 0 associatedObj: 0)
							(if (and global399 (not (global399 faceUp:)))
								(global399 wasFaceDown: global225)
								(global399 flip: addKeyMouse:)
							)
							(return 1)
						)
						((and (temp0 tailList:) ((temp0 tailList:) size:))
							((temp0 tailList:) add: temp0)
							(temp0 cue:)
						)
						(else
							(temp0 moveBack:)
						)
					)
				)
				(2
					(if
						(and
							(!= gCardGameScriptNumber 6008)
							(!= temp1 (- (param2 size:) 1))
						)
						(if
							(or
								(== gCardGameScriptNumber 6009)
								(== gCardGameScriptNumber 6010)
								(== gCardGameScriptNumber 6017)
								(== gCardGameScriptNumber 6006)
								(== gCardGameScriptNumber 6003)
							)
							(return 1)
						)
						(= global920 1)
						(gChar1 sayReg: 600 15 130 0 (Random 1 2))
						(if global222
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText: {Not a legal play to a Foundation.} 6 6
								init:
							)
						)
						(return 1)
					)
					(if (and (!= gCardGameScriptNumber 6018) (== whatType 1))
						(return 1)
					)
					(cond
						((= temp3 (self rFoundation: temp0))
							(= global228 1)
							(temp0 setPreviousHand:)
							(= global458 temp0)
							(if (and (== cardShow 1) (> size 1))
								((self at: (- size 2)) show:)
							)
							(param2 moveCard: temp3 temp3)
						)
						((= temp1 (param2 indexOf: temp0))
							((= global399 (param2 at: (- temp1 1))) setLoop: 2)
						)
					)
				)
			)
		)
	)

	(method (pBuild param1 &tmp temp0 temp1)
		(for
			((= temp0 (+ (= temp1 (self indexOf: param1)) 1)))
			(< temp0 size)
			((++ temp0))
			
			(if (not (self buildCheck: (self at: (- temp0 1)) (self at: temp0)))
				(return 0)
			)
		)
		(if
			(and
				(== tailMove 1)
				temp1
				(self buildCheck: (self at: (- temp1 1)) (self at: temp1))
			)
			(if ((self at: (- temp1 1)) faceUp:)
				(return 0)
			else
				(return 1)
			)
		)
		(return 1)
	)

	(method (buildCheck param1 param2)
		(switch buildOrder
			(0
				(return 0)
			)
			(10
				(return 1)
			)
			(1
				(return (self byAsc: param1 param2))
			)
			(2
				(return (self byDesc: param1 param2))
			)
			(3
				(return
					(or
						(self byAsc: param1 param2)
						(self byDesc: param1 param2)
					)
				)
			)
			(4
				(return
					(and
						(self byAsc: param1 param2)
						(self bySuit: param1 param2)
					)
				)
			)
			(5
				(return
					(and
						(self byDesc: param1 param2)
						(self bySuit: param1 param2)
					)
				)
			)
			(6
				(return
					(and
						(self byAsc: param1 param2)
						(self byAltColors: param1 param2)
					)
				)
			)
			(7
				(return
					(and
						(self byDesc: param1 param2)
						(self byAltColors: param1 param2)
					)
				)
			)
			(8
				(return
					(and
						(self byDesc: param1 param2)
						(self byOtherSuit: param1 param2)
					)
				)
			)
			(9
				(return
					(or
						(and
							(self byAsc: param1 param2)
							(self byAltColors: param1 param2)
						)
						(and
							(self byDesc: param1 param2)
							(self byAltColors: param1 param2)
						)
					)
				)
			)
		)
	)

	(method (byAsc param1 param2 &tmp temp0)
		(= temp0 (self buildStep:))
		(if (and wrapping (== (- (+ (param1 rank:) temp0) 13) (param2 rank:)))
			(return 1)
		)
		(return (== (+ (param1 rank:) temp0) (param2 rank:)))
	)

	(method (byDesc param1 param2 &tmp temp0)
		(= temp0 (self buildStep:))
		(if (and wrapping (== (+ (- (param1 rank:) temp0) 13) (param2 rank:)))
			(return 1)
		)
		(return (== (- (param1 rank:) temp0) (param2 rank:)))
	)

	(method (bySuit param1 param2)
		(return (== (param1 suit:) (param2 suit:)))
	)

	(method (byAltColors param1 param2)
		(if (< (param1 suit:) 2)
			(return (> (param2 suit:) 1))
		else
			(return (< (param2 suit:) 2))
		)
	)

	(method (byOtherSuit param1 param2)
		(return (!= (param1 suit:) (param2 suit:)))
	)

	(method (setFollow param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 (gTheFoundations size:)) ((++ temp0))
			(if ((gTheFoundations at: temp0) followRank:)
				(return)
			)
		)
		(for ((= temp0 0)) (< temp0 (gTheFoundations size:)) ((++ temp0))
			((gTheFoundations at: temp0) followRank: (param1 rank:))
		)
	)

	(method (rFoundation param1 &tmp temp0 temp1 temp2)
		(if (== gCardGameScriptNumber 6020)
			(for ((= temp0 0)) (< temp0 10) ((++ temp0))
				(if
					(and
						((gTheHands at: temp0) size:)
						(==
							(param1 rank:)
							(((gTheHands at: temp0) at: 0) rank:)
						)
					)
					(return (gTheHands at: temp0))
				)
			)
		)
		(if (not gTheFoundations)
			(return 0)
		)
		(cond
			((and (== gCardGameScriptNumber 6022) (proc6022_5 param1))
				(return (gTheFoundations at: 0))
			)
			((== gCardGameScriptNumber 6022)
				(return 0)
			)
		)
		(if
			(and
				(== gCardGameScriptNumber 6007)
				(== global927 1)
				((gTheFoundations at: 0) size:)
				(==
					(((gTheFoundations at: 0) at: (- ((gTheFoundations at: 0) size:) 1))
						rank:
					)
					13
				)
			)
			(return 0)
		)
		(for ((= temp0 0)) (< temp0 (gTheFoundations size:)) ((++ temp0))
			(= temp1 (gTheFoundations at: temp0))
			(= temp2 (temp1 lastCrd:))
			(if
				(and
					(<= (+ 1 (temp1 size:)) (temp1 cardLimit:))
					(or
						(and
							(== (temp1 size:) 0)
							(or
								(and
									(== (param1 rank:) 13)
									(== (temp1 startRank:) 1)
								)
								(and
									(== (param1 rank:) 1)
									(== (temp1 startRank:) 2)
								)
								(== (temp1 startRank:) 3)
								(and
									(== (temp1 startRank:) 4)
									(or
										(== (temp1 followRank:) 0)
										(== (param1 rank:) (temp1 followRank:))
									)
								)
							)
						)
						(temp1 buildCheck: temp2 param1)
					)
				)
				(return temp1)
			)
		)
		(return 0)
	)

	(method (growAdjust)
		(cond
			((< 8 size 13)
				(self
					posn: (- orgX 6) (- orgY 6)
					eachElementDo: #posn (- orgX 6) (- orgY 6)
				)
				(growView setLoop: 1 posn: (- orgX 6) (- orgY 6) show:)
				((self lastCrd:) show:)
				(UpdateScreenItem (self lastCrd:))
				(UpdateScreenItem growView)
			)
			((< 4 size 9)
				(self
					posn: (- orgX 4) (- orgY 4)
					eachElementDo: #posn (- orgX 4) (- orgY 4)
				)
				(growView setLoop: 2 posn: (- orgX 4) (- orgY 4) show:)
				((self lastCrd:) show:)
				(UpdateScreenItem (self lastCrd:))
				(UpdateScreenItem growView)
			)
			((< 1 size 5)
				(self
					posn: (- orgX 2) (- orgY 2)
					eachElementDo: #posn (- orgX 2) (- orgY 2)
				)
				(growView setLoop: 3 posn: (- orgX 2) (- orgY 2) show:)
				((self lastCrd:) show:)
				(UpdateScreenItem (self lastCrd:))
				(UpdateScreenItem growView)
			)
			((== size 1)
				(self posn: orgX orgY eachElementDo: #posn orgX orgY)
				(growView setLoop: 4 posn: orgX orgY show:)
				((self lastCrd:) show:)
				(UpdateScreenItem (self lastCrd:))
				(UpdateScreenItem growView)
			)
			((== size 0)
				(self posn: orgX orgY)
				(growView hide:)
			)
			(else
				(self
					posn: (- orgX 14) (- orgY 13)
					eachElementDo: #posn (- orgX 14) (- orgY 13)
				)
				(growView setLoop: 0 posn: (- orgX 14) (- orgY 13) show:)
				((self lastCrd:) show:)
				(UpdateScreenItem (self lastCrd:))
				(UpdateScreenItem growView)
			)
		)
	)

	(method (release)
		(if size
			(super release:)
		)
	)

	(method (endHand)
		(if size
			(self eachElementDo: #hide eachElementDo: #deleteKeyMouse release:)
		)
		(if (and emptyView (not (& (emptyView signal:) $0008)))
			(emptyView hide:)
		)
		(if growView
			(growView hide:)
		)
	)

	(method (add param1 &tmp temp0)
		(if argc
			(param1 inPlay: 1)
		)
		(if (and (== gCardGameScriptNumber 6019) argc global226)
			(param1 show:)
		)
		(if
			(and
				argc
				(not global226)
				(not global224)
				(not global245)
				(!= gCardGameScriptNumber 6023)
			)
			(if (not global228)
				(if (param1 fromStock:)
					(param1 setPreviousHand: 2)
					(param1 fromStock: 0)
				else
					(param1 setPreviousHand:)
				)
			else
				(= global228 0)
			)
			(cond
				((!= gCardGameScriptNumber 6019)
					(if (not global225)
						(= global225 1)
					else
						(++ global225)
					)
				)
				((or (not global247) (== whatType 1))
					(if (not global225)
						(= global225 1)
					else
						(++ global225)
					)
				)
			)
			(if (and (== gCardGameScriptNumber 6008) (== ((param1 owner:) whatType:) 3))
				(param1 wasInReserve: 1)
			)
			(param1 setWhenPlayed:)
		)
		(if (and (== whatType 1) (!= gCardGameScriptNumber 6020) (not global226))
			(proc0_12 503)
			(++ global928)
		)
		(if (and (== whatType 1) (== startRank 4))
			(self setFollow: param1)
		)
		(if (and (== cardShow 1) size)
			((self at: (- size 1)) hide:)
		)
		(if argc
			(super add: param1 &rest)
			(cond
				((== gCardGameScriptNumber 6013)
					(if
						(and
							global226
							(> size 1)
							(==
								((self at: (- (self indexOf: param1) 1))
									wasFaceDown:
								)
								(+ global225 1)
							)
							(not global224)
						)
						((self at: (- (self indexOf: param1) 1))
							flip: 0
							wasFaceDown: 0
						)
					)
				)
				(
					(and
						global226
						(> size 1)
						(==
							((self at: (- (self indexOf: param1) 1))
								wasFaceDown:
							)
							(+ global225 1)
						)
						(not global224)
					)
					((self at: (- (self indexOf: param1) 1))
						flip: 0
						wasFaceDown: 0
					)
				)
			)
		else
			(super add:)
		)
		(if growView
			(self growAdjust:)
		)
		(if (and emptyView (not (& (emptyView signal:) $0008)))
			(emptyView hide:)
		)
	)

	(method (eliminateCard param1)
		(cond
			((and global226 (!= gCardGameScriptNumber 6023) (!= gCardGameScriptNumber 6019))
				(-- global225)
				(param1 setWhenPlayed: 1)
			)
			((and global226 (== gCardGameScriptNumber 6019) (not global246))
				(-- global225)
				(param1 setWhenPlayed: 1)
			)
		)
		(if (and global226 (== whatType 4) (!= gCardGameScriptNumber 6019))
			(param1 inPlay: 0)
		else
			(param1 inPlay: 1)
		)
		(self delete: param1)
		(if (and global226 size (== cardShow 1))
			(if
				(or
					(!= gCardGameScriptNumber 6001)
					(and (== gCardGameScriptNumber 6001) (!= whatType 1))
				)
				((self at: (- size 1)) show:)
			else
				(if (> size 1)
					((self at: (- size 1)) show:)
				)
				(if (and (< size 2) emptyView)
					(emptyView show:)
				)
			)
		)
		(if (== whatType 1)
			(-- global928)
		)
		(if growView
			(self growAdjust:)
		)
		(if (and emptyView (not size))
			(emptyView show:)
		)
	)

	(method (calcNextY)
		(return
			(cond
				((or (== cardShow 1) (== size 0)) y)
				((== handDirection 2)
					(+ ((self at: (- size 1)) y:) global397)
				)
				(else y)
			)
		)
	)

	(method (calcNextX)
		(return
			(cond
				((or (== cardShow 1) (== size 0)) x)
				((== handDirection 1)
					(if (== gCardGameScriptNumber 6023)
						(= global396 33)
					else
						(= global396 12)
					)
					(+ ((self at: (- size 1)) x:) global396)
				)
				(else x)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 3] temp3 temp4)
		(cond
			(
				(and
					global223
					(not (event claimed:))
					(not (& (event type:) evMOUSERELEASE))
					(<= x (event x:) (- (+ x 54) 1))
					(<= y (event y:) (- (+ y 77) 1))
				)
				(event claimed: 1)
			)
			(
				(and
					(not (event claimed:))
					(not (& (event type:) evMOUSERELEASE))
					(or
						(== gCardGameScriptNumber 6003)
						(== gCardGameScriptNumber 6006)
						(== gCardGameScriptNumber 6024)
						(and (== gCardGameScriptNumber 6012) (== global927 0))
						(and (== gCardGameScriptNumber 6016) (== global927 0))
					)
					(== (self whatType:) 1)
					(> (self size:) 1)
					(<= x (event x:) (- (+ x 54) 1))
					(<= y (event y:) (- (+ y 77) 1))
				)
				(event claimed: 1)
				(= local5 ((self at: (- size 1)) view:))
				(= local6 ((self at: (- size 1)) loop:))
				(= local7 ((self at: (- size 1)) cel:))
				((self at: (- size 1)) view: ((self at: 0) view:))
				((self at: (- size 1)) loop: ((self at: 0) loop:))
				((self at: (- size 1)) cel: ((self at: 0) cel:))
				(UpdateScreenItem (self at: (- size 1)))
				(gAniList add: (self at: (- size 1)))
				(while (!= evMOUSERELEASE ((= temp3 (Event new:)) type:))
					(proc0_9 (gAniList elements:) 0)
					(temp3 dispose:)
				)
				(temp3 dispose:)
				(gAniList release:)
				((self at: (- size 1)) view: local5)
				((self at: (- size 1)) loop: local6)
				((self at: (- size 1)) cel: local7)
				(UpdateScreenItem (self at: (- size 1)))
			)
			(
				(and
					(not canPlay)
					(not (event claimed:))
					(not (& (event type:) evMOUSERELEASE))
					(<= x (event x:) (- (+ x 54) 1))
					(<= y (event y:) (- (+ y 77) 1))
				)
				(event claimed: 1)
				(if global222
					(if (== gCardGameScriptNumber 6001)
						(cond
							(
								(==
									(= temp4
										((self at: (- (self size:) 1)) rank:)
									)
									13
								)
								(= temp4 0)
							)
							((> (+= temp4 ((self at: 0) rank:)) 13)
								(-= temp4 13)
							)
						)
					)
					((ScriptID 6101 0) init: 2 temp4) ; tutorialSolitaire
				)
			)
			(else
				(self handleCard: event self)
			)
		)
	)

	(method (cue)
		(enterAdd doit: self)
		((ScriptID 15 6) dispose:) ; littleCard
		(if (!= whatType 1)
			(gSound play: 907)
		)
	)
)

(class zeroCard of Obj
	(properties
		x 0
		y 0
		nsLeft 0
		nsRight 0
		nsTop 0
		nsBottom 0
		suit -2
		rank -2
	)
)

(class sDealer of List
	(properties
		cardsToDeal 0
		cardsAtATime 1
		dealDirection 0
		script 0
		litlCard 0
		dealerX 0
		dealerY 0
		dealTo 0
		caller 0
	)

	(method (init param1 &tmp temp0)
		(= dealerX (/ gScreenWidth 2))
		(= dealerY (+ gScreenHeight 40))
		(for ((= temp0 (= cardsToDeal 0))) (< temp0 (param1 size:)) ((++ temp0))
			(super add: (param1 at: temp0))
			((param1 at: temp0) cardsDealtDown: 0)
			(+= cardsToDeal ((param1 at: temp0) cardsDown:))
			(+= cardsToDeal ((param1 at: temp0) cardsUp:))
		)
		(= dealTo (param1 at: 0))
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (deal param1)
		(= caller (if argc param1 else 0))
		(self setScript: sDealScript)
	)

	(method (setScript param1)
		(if litlCard
			(litlCard dispose:)
			(= litlCard 0)
		)
		(if (and argc param1)
			((= script param1) init: self)
		else
			(= script 0)
		)
	)

	(method (dispose)
		(self setScript: 0)
		(self release:)
		(super dispose:)
	)

	(method (nextDealTo &tmp temp0)
		(= temp0 (self indexOf: dealTo))
		(if (== dealDirection 0)
			(= dealTo
				(self
					at:
						(if (== temp0 (- size 1))
							0
						else
							(+ temp0 1)
						)
				)
			)
		else
			(= dealTo
				(self
					at:
						(if (== temp0 0)
							(- size 1)
						else
							(- temp0 1)
						)
				)
			)
		)
	)

	(method (doneDealing)
		(if (== (dealTo size:) (+ (dealTo cardsUp:) (dealTo cardsDown:)))
			(return 1)
		else
			(return 0)
		)
	)
)

(instance sDealScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 [temp3 3] temp6)
		(switch (= state newState)
			(0
				(for ((= temp1 (- (gCast size:) 1))) (>= temp1 0) ((-- temp1))
					(if ((gCast at: temp1) isKindOf: sCard)
						(gCast delete: (gCast at: temp1))
					)
				)
				(DisableCursor)
				(= register 0)
				(client litlCard: (ScriptID 15 6)) ; littleCard
				((ScriptID 15 6) ; littleCard
					view: (+ 54 global384)
					posn: (client dealerX:) (client dealerY:)
					init:
				)
				(if (== global898 0)
					(for
						((= temp1 0))
						(< temp1 (client cardsToDeal:))
						((++ temp1))
						
						(= temp6 (client dealTo:))
						((client dealTo:) add: (= temp0 (Deck getCard:)))
						(switch ((client dealTo:) handDirection:)
							(1
								(temp0 setPri: ((temp0 owner:) nextPri:))
							)
							(2
								(temp0 setPri: 2)
							)
						)
						(temp0 init: show:)
						(temp0 inPlay: 1)
						(if
							(and
								((client dealTo:) cardsDown:)
								(<
									((client dealTo:) cardsDealtDown:)
									((client dealTo:) cardsDown:)
								)
							)
							((client dealTo:)
								cardsDealtDown:
									(+ ((client dealTo:) cardsDealtDown:) 1)
							)
						else
							(temp0 flip: 1 1)
						)
						(if (sDealer doneDealing:)
							(client nextDealTo:)
							(sDealer
								delete: (sDealer at: (client indexOf: temp6))
							)
						else
							(client nextDealTo:)
						)
					)
					(= state 2)
				)
				(= ticks 1)
			)
			(1
				(cond
					(((ScriptID 15 6) isNotHidden:) ; littleCard
						(if global898
							((ScriptID 15 6) show:) ; littleCard
						)
					)
					((not global898)
						((ScriptID 15 6) hide:) ; littleCard
					)
				)
				(if global898
					((ScriptID 15 6) ; littleCard
						show:
						cycleSpeed: global898
						moveSpeed: (+ (/ global898 4) 1)
						setLoop: 1
						setMotion:
							MoveTo
							(+ ((client dealTo:) calcNextX:) 0)
							(+ ((client dealTo:) calcNextY:) 1)
							self
					)
				else
					((ScriptID 15 6) hide:) ; littleCard
					(= ticks 1)
				)
			)
			(2
				(= temp2 (+ 8 (* 8 (- 16 global898))))
				((ScriptID 15 6) view: (+ 54 global384) setStep: temp2 temp2) ; littleCard
				(++ register)
				((ScriptID 15 6) posn: (client dealerX:) (client dealerY:)) ; littleCard
				((client dealTo:) add: (= temp0 (Deck getCard:)))
				(switch ((client dealTo:) handDirection:)
					(1
						(temp0 setPri: ((temp0 owner:) nextPri:))
					)
					(2
						(temp0 setPri: 2)
					)
				)
				(temp0 inPlay: 1)
				(if
					(and
						((client dealTo:) cardsDown:)
						(<
							((client dealTo:) cardsDealtDown:)
							((client dealTo:) cardsDown:)
						)
					)
					((client dealTo:)
						cardsDealtDown: (+ ((client dealTo:) cardsDealtDown:) 1)
					)
				else
					(gSound play: 903)
					(temp0 flip: 1 1)
				)
				(= temp6 (client dealTo:))
				(if (sDealer doneDealing:)
					(client nextDealTo:)
					(sDealer delete: (sDealer at: (client indexOf: temp6)))
				else
					(client nextDealTo:)
				)
				(temp0 show: init: 1)
				(if (!= register (client cardsToDeal:))
					(= state 0)
				)
				(= ticks 1)
			)
			(3
				(EnableCursor)
				(gSound play: 903)
				(sDealer setScript: 0)
				(if (sDealer caller:)
					((sDealer caller:) cue:)
					(sDealer caller: 0)
				)
				(for ((= temp1 0)) (< temp1 (gDelayCast size:)) ((++ temp1))
					(gCast add: (gDelayCast at: temp1))
				)
				(gDelayCast release:)
			)
		)
	)
)

(instance tmpList of List
	(properties)
)

(instance tempList of List
	(properties)
)

(class sCard of Card
	(properties
		offsetX 12
		offsetY 4
		color 0
		tailList 0
		tailOffSetX 0
		tailOffSetY 0
		theBeginX 0
		theBeginY 0
		undoX 0
		undoY 0
		inPlay 0
		whenPlayed 0
		previousHand 0
		fromStock 0
		wasFaceDown 0
		wasReset 0
		wasTailList 0
		numFromStock 0
		wasInReserve 0
	)

	(method (init)
		(super init: &rest)
		(if (< suit 2)
			(= color 0)
		else
			(= color 1)
		)
	)

	(method (setNumFromStock param1 &tmp temp0)
		(if (not numFromStock)
			(= numFromStock (List new:))
		)
		(if (== argc 2)
			(if (> (numFromStock size:) 1)
				(for
					((= temp0 0))
					(< temp0 (- (numFromStock size:) 1))
					((++ temp0))
					
					(tempList add: (numFromStock at: temp0))
				)
				(numFromStock release:)
				(for ((= temp0 0)) (< temp0 (tempList size:)) ((++ temp0))
					(numFromStock add: (tempList at: temp0))
				)
				(tempList release:)
			else
				(numFromStock
					delete: (numFromStock at: (- (numFromStock size:) 1))
				)
			)
		else
			(numFromStock add: param1)
		)
	)

	(method (setWhenPlayed)
		(if (not whenPlayed)
			(= whenPlayed (List new:))
		)
		(if argc
			(whenPlayed delete: (whenPlayed at: (- (whenPlayed size:) 1)))
		else
			(whenPlayed add: global225)
		)
	)

	(method (setPreviousHand param1)
		(if (not previousHand)
			(= previousHand (List new:))
		)
		(if argc
			(previousHand add: param1)
		else
			(previousHand add: (self owner:))
		)
	)

	(method (setNSRect &tmp temp0)
		(if (not (self owner:))
			(return)
		)
		(= temp0 ((self owner:) handDirection:))
		(cond
			((== ((self owner:) lastCrd:) self)
				(self nsLeft: 0 nsRight: 54 nsTop: 0 nsBottom: 77)
			)
			((== temp0 1)
				(self nsLeft: 0 nsRight: global396 nsTop: 0 nsBottom: 77)
			)
			((== temp0 2)
				(self nsLeft: 0 nsRight: 54 nsTop: 0 nsBottom: global397)
			)
		)
	)

	(method (doit)
		(self setNSRect:)
		(if (and (& -info- $0008) (self isNotHidden:))
			(UpdateScreenItem self)
		)
	)

	(method (cue &tmp temp0 temp1)
		(super cue:)
		(self setLoop: 0)
		(= temp1 (self owner:))
		(if (and tailList (tailList size:))
			(for ((= temp0 0)) (< temp0 (tailList size:)) ((++ temp0))
				((tailList at: temp0)
					x: ((tailList at: temp0) theBeginX:)
					y: ((tailList at: temp0) theBeginY:)
				)
			)
			(for ((= temp0 0)) (< temp0 (temp1 size:)) ((++ temp0))
				(switch (temp1 handDirection:)
					(1
						((temp1 at: temp0) setPri: (+ temp0 2) show:)
					)
					(2
						((temp1 at: temp0) setPri: 2 show:)
					)
				)
			)
			(self setLoop: 2)
		)
		(self tailList: 0)
		(if (and (== ((self owner:) cardShow:) 1) (> ((self owner:) size:) 1))
			(((self owner:) at: (- ((self owner:) size:) 2)) hide:)
		)
		(if (and ((self owner:) emptyView:) ((self owner:) size:))
			(((self owner:) emptyView:) hide:)
		)
	)

	(method (track param1 &tmp temp0 temp1 temp2 [temp3 2] temp5 temp6 temp7)
		(if (& (param1 type:) $4000)
			(return)
		)
		(if
			(and
				(== ((self owner:) indexOf: self) 0)
				((self owner:) emptyView:)
			)
			(((self owner:) emptyView:) show:)
		)
		(if (and (== ((self owner:) cardShow:) 1) (> ((self owner:) size:) 1))
			(((self owner:) at: (- ((self owner:) size:) 2)) show:)
		)
		(= global291 priority)
		(self setPri: 500)
		(= temp0 (- x (gMouseCursor x:)))
		(= temp1 (- y (gMouseCursor y:)))
		(self theBeginX: x theBeginY: y)
		(if tailList
			(for ((= temp6 0)) (< temp6 (tailList size:)) ((++ temp6))
				(= temp7 (tailList at: temp6))
				(temp7 setNSRect:)
				(= temp2 (Event new:))
				(temp7
					tailOffSetX: (- (temp7 x:) (temp2 x:))
					tailOffSetY: (- (temp7 y:) (temp2 y:))
					theBeginX: (temp7 x:)
					theBeginY: (temp7 y:)
				)
				(switch ((temp7 owner:) handDirection:)
					(1
						(temp7 setPri: (+ 501 temp6))
					)
					(2
						(temp7 setPri: 500)
					)
				)
				(temp2 dispose:)
			)
		)
		(self saveData:)
		(= global189 self)
		(proc0_9 (gAniList elements:) 0)
		(= temp5 1)
		(while (!= evMOUSERELEASE ((= temp2 (Event new:)) type:))
			(if
				(and
					global250
					(not global253)
					(!= gCardGameScriptNumber 6020)
					(!= gCardGameScriptNumber 6028)
					(!= gCardGameScriptNumber 6027)
					(!= gCardGameScriptNumber 6019)
				)
				(= global251 (GetTime 1)) ; SysTime12
				(if (!= global252 global251)
					(= global252 global251)
					(if (== (++ global248) 60)
						(= global248 0)
					)
					(if (and (== global249 59) (== global248 0))
						(= global253 1)
					else
						(localproc_1 {seconds} (ScriptID gCardGameScriptNumber 8))
						(localproc_0
							global248
							92
							5
							1
							{seconds}
							(ScriptID gCardGameScriptNumber 8)
						)
						(if (== global248 0)
							(++ global249)
							(localproc_1 {minutes} (ScriptID gCardGameScriptNumber 8))
							(localproc_0
								global249
								70
								5
								1
								{minutes}
								(ScriptID gCardGameScriptNumber 8)
							)
						)
					)
				)
			)
			(= gGameTime (+ gTickOffset (GetTime)))
			(= gMouseX (temp2 x:))
			(= gMouseY (temp2 y:))
			(self x: (+ (temp2 x:) temp0) y: (+ (temp2 y:) temp1) setNSRect:)
			(if tailList
				(for ((= temp6 0)) (< temp6 (tailList size:)) ((++ temp6))
					(= temp7 (tailList at: temp6))
					(temp7 x: (self x:))
					(temp7 y: (+ (self y:) (* global397 (+ temp6 1))))
					(temp7 setNSRect:)
				)
			)
			(proc0_9 (gAniList elements:) 0)
			(temp2 dispose:)
		)
		(= gMouseX (temp2 x:))
		(= gMouseY (temp2 y:))
		(temp2 dispose:)
		(proc0_9 (gAniList elements:) 1)
		(gAniList release:)
		(return temp5)
	)
)

(instance enterAdd of Code
	(properties)

	(method (doit param1 &tmp [temp0 2])
		(if (param1 isKindOf: Hand)
			(if (== (param1 startRank:) 4)
				(param1 setFollow: global458)
			)
			(param1 add: global458)
			(global458
				undoX: (global458 theBeginX:)
				undoY: (global458 theBeginY:)
				show:
				setPri: 2
			)
		else
			(param1 setCard: global458)
		)
		(if (and global399 (not (global399 faceUp:)))
			(global399 wasFaceDown: global225)
			(gSound play: 903)
			(global399 flip: addKeyMouse:)
		)
		((ScriptID 15 6) hide:) ; littleCard
		(global458 tailList: 0 associatedObj: 0)
		(= global395 (= global458 0))
	)
)

