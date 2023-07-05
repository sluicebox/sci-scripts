;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 511)
(include sci.sh)
(use Main)
(use DialogPlane)
(use oInvHandler)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use TiledBitmap)
(use TextView)
(use NewUser)
(use PushButton)
(use soFlashCyberSniff)
(use Array)
(use Print)
(use Talker)
(use Polygon)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	roLiarsRoom 0
)

(local
	[local0 5] = [40 65 29 54 79]
	[local5 5] = [40 40 64 64 64]
	[local10 5] = [7 31 55 79 103]
	local15 = 137
	[local16 4] = [134 134 134 158]
	[local20 4] = [47 71 95 95]
	[local24 4] = [161 161 161 137]
	[local28 4] = [68 44 20 20]
	local32 = 500
	local33 = 500
	local34
	local35
	local36
	local37 = 2
	local38 = 2
	local39 = 1
	local40 = 1
	local41 = 1
	local42
	local43 = 1
	local44 = 100
	local45 = 100
	local46
	local47
	local48
	local49
	local50 = 2
	local51
	local52
	local53
	local54
	local55
	local56
	local57
	local58 = 1
	local59
	local60
	local61
	local62
	local63
)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22)
	(if (or (< argc 3) (not param1) (not param2) (not param3))
		(if param1
			(proc64896_7 param1)
		)
		(if param2
			(proc64896_7 param2)
		)
		(if param3
			(proc64896_7 param3)
		)
		(PrintDebug {Illegal call of MakeChoice procedure. liars.sc SRC})
		(return 0)
	)
	(if (< argc 6)
		(= temp1 -2)
	else
		(= temp1 param4)
	)
	(if (< argc 7)
		(= temp2 -2)
	else
		(= temp2 param5)
	)
	(if (< argc 8)
		(= temp0 300)
	else
		(= temp0 param6)
	)
	(= temp9 (DialogPlane new:))
	(temp9 init: 0 0 1 1)
	(= temp3 (+ (GetTextWidth param1 global270 0) 20))
	(= temp21
		(+
			(= temp21
				(Max
					(GetTextWidth param2 global270 0)
					(GetTextWidth param3 global270 0)
				)
			)
			10
		)
	)
	(= temp11 (DismissTextButton new:))
	(temp11
		font: global270
		nLeading: global271
		fore: global272
		back: global273
		text: (KArray 8 (KArray 9 param2)) ; ArrayDup, ArrayGetData
		bTileBorder: 1
		vTileOff: global276
		vTileOn: global277
		nMinWidth: temp21
		value: 1
		bDefault: 1
		init: temp9
	)
	(= temp13 (DismissTextButton new:))
	(temp13
		font: global270
		nLeading: global271
		fore: global272
		back: global273
		text: (KArray 8 (KArray 9 param3)) ; ArrayDup, ArrayGetData
		bTileBorder: 1
		vTileOff: global276
		vTileOn: global277
		nMinWidth: temp21
		value: 0
		init: temp9
	)
	(= temp5 (temp11 nWidth:))
	(= temp6 (temp11 nHeight:))
	(= temp7 (+ (Max temp3 temp5) 10))
	(if param1
		(= temp20 (TextItem new:))
		(temp20
			font: global268
			nLeading: global269
			maxWidth: temp0
			nMinWidth: (+ temp7 40)
			fore: global274
			back: 255
			skip: 255
			text: (KArray 8 (KArray 9 param1)) ; ArrayDup, ArrayGetData
			border: 5
			bTileBorder: 0
			vTile: 60020
			init: temp9
		)
		(= temp15 (temp20 nHeight:))
		(= temp4 (temp20 nHeight:))
	else
		(= temp20 0)
	)
	(= temp8 (+ temp4 (* temp6 2)))
	(if param1
		(= temp22 60019)
	else
		(= temp22 global275)
	)
	(= temp10 (TiledView new:))
	(temp10 view: temp22 init: temp7 temp8 0 1 temp9)
	(= temp14 (temp10 nWidth:))
	(+= temp15 (temp10 nHeight:))
	(switch temp1
		(-1
			(= temp1 (/ (- gScreenWidth temp14) 2))
		)
		(-2
			(= temp1 (+ (gThePlane left:) (/ (- (gThePlane getWidth:) temp14) 2)))
		)
	)
	(switch temp2
		(-1
			(= temp2 (/ (- gScreenHeight temp15) 2))
		)
		(-2
			(= temp2 (+ (gThePlane top:) (/ (- (gThePlane getHeight:) temp15) 2)))
		)
	)
	(temp9 setRect: temp1 temp2 (- (+ temp1 temp14) 1) (- (+ temp2 temp15) 1))
	(UpdatePlane temp9)
	(= temp16 (temp10 nOffsetX:))
	(= temp17 (temp10 nOffsetY:))
	(if temp20
		(temp10 posn: (temp10 x:) (+ (temp10 y:) (temp20 nHeight:)))
		(+= temp17 (temp20 nHeight:))
	)
	(= temp18 (/ (- temp14 (+ temp5 5)) 2))
	(= temp19 (+ temp17 10))
	(temp11 posn: temp18 temp19)
	(temp13 posn: temp18 (+ (temp11 y:) temp6 5))
	(if param1
		(proc64896_7 param1)
	)
	(if param2
		(proc64896_7 param2)
	)
	(if param3
		(proc64896_7 param3)
	)
	(return (temp9 sitNSpin:))
)

(instance roLiarsRoom of L7Room
	(properties
		picture 51100
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(Load rsVIEW 60009)
		(Load 140 51218) ; WAVE
		(= global330 toLarry)
		(= global335 toDewmi)
		(poLarry init:)
		(voLarryBust init:)
		(oBabe init:)
		(voLarryMoney init:)
		(voBabeMoney init:)
		(voPotMoney init:)
		(poFountain init:)
		(oBetDie init:)
		(oBetButton init:)
		(oChallengeButton init: disable:)
		(oHowToPlayButton init:)
		(oDie2Button init:)
		(oDie3Button init:)
		(oDie4Button init:)
		(oDie5Button init:)
		(oDie6Button init:)
		(oDiceRadioGroup init:)
		(foRollArea init:)
		(foShowArea init:)
		(= local42
			(IDArray
				newWith:
					15
					(foSlot1 init: yourself:)
					(foSlot1A init: yourself:)
					(foSlot2 init: yourself:)
					(foSlot3 init: yourself:)
					(foSlot2A init: yourself:)
					(foSlot4 init: yourself:)
					(foSlot5 init: yourself:)
					(foSlot3A init: yourself:)
					(foSlot6 init: yourself:)
					(foSlot7 init: yourself:)
					(foSlot4A init: yourself:)
					(foSlot8 init: yourself:)
					(foSlot9 init: yourself:)
					(foSlot5A init: yourself:)
					(foSlot10 init: yourself:)
			)
		)
		(cup init:)
		(oLarryDice init:)
		(oBabeDice init:)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(oLarryDice
				add:
					((Die new:)
						nOwner: 0
						view: 51100
						loop: 4
						x: [local0 temp0]
						y: [local5 temp0]
						init:
						yourself:
					)
			)
			(oBabeDice
				add:
					((Die new:)
						nOwner: 1
						view: 51100
						loop: 4
						x: (+ [local0 temp0] 192)
						y: [local5 temp0]
						init:
						yourself:
					)
			)
		)
		(foDiscoBall init:)
		(foFlowers init:)
		(foGlassTable init:)
		(foHotTub init:)
		(foMermaid init:)
		(foMerman init:)
		(foDewmiLostDice init:)
		(foLarryLostDice init:)
		(foAnchor init:)
		(proc64928_2 412 366 375 999)
		(gOMusic1 setMusic: 51200)
		((ScriptID 64017 0) set: 248) ; oFlags
		(gOEventHandler registerKeyHandler: oCheatKeyHandler)
		(self setScript: soIntro)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 512) ; ro512
			(gOMusic1 fadeOut:)
		)
		(if (not ((ScriptID 64017 0) test: 131)) ; oFlags
			(gEgo put: ((ScriptID 64037 0) get: 52)) ; oInvHandler, ioMoney
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(proc64928_2)
		(= global330 0)
		(= global335 0)
		(if (gTimers contains: oDelayTimer)
			(oDelayTimer dispose: delete:)
		)
		(oLarryDice release:)
		(oBabeDice release:)
		(local42 dispose:)
		(gOEventHandler unregisterKeyHandler: oCheatKeyHandler)
		(super dispose: &rest)
	)
)

(class Die of Prop
	(properties
		priority 480
		fixPriority 1
		bImAHog 0
		nClickTime 0
		nOwner 0
		nValue 0
		bShowing 0
		bDiscarded 0
		bShowed 0
		bRolling 0
		nCurX 0
		nCurY 0
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
	)

	(method (onMe)
		(if
			(or
				bDiscarded
				bShowed
				bRolling
				(== nOwner 1)
				(and
					(not bShowing)
					(== (- (oLarryDice size:) ((oLarryDice oShowing:) size:)) 1)
				)
			)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (doVerb)
		(if bShowing
			(self hideIt:)
		else
			(self showIt:)
		)
		(gOSound1 playSound: 51218)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 (event type:))
		(= temp1 (self onMe: event))
		(cond
			(bImAHog
				(self x: (- gMouseX 11) y: (- gMouseY 11))
				(if (== temp0 evMOUSERELEASE)
					(self stopHogging:)
				)
				(event claimed: 1)
			)
			((and temp1 (== temp0 evMOUSEBUTTON))
				(= local60 (= bImAHog 1))
				(gOEventHandler registerEventHog: self)
				(= nCurX x)
				(= nCurY y)
				(= nClickTime gGameTime)
				(self setPri: 600)
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
		(event claimed:)
	)

	(method (stopHogging)
		(= local60 (= bImAHog 0))
		(gOEventHandler unregisterEventHog: self)
		(if
			(or
				(<= (- gGameTime nClickTime) 30)
				(and
					bShowing
					(foRollArea onMe: (+ (self x:) 11) (+ (self y:) 11))
				)
				(and
					(not bShowing)
					(foShowArea onMe: (+ (self x:) 11) (+ (self y:) 11))
				)
			)
			(self doVerb:)
		else
			(= x nCurX)
			(= y nCurY)
			(gOSound1 playSound: 51218)
		)
		(self setPri: 480)
	)

	(method (rollDie)
		(cond
			((and (== nOwner 0) (not bShowing))
				(self setScript: (soDieRoll new:))
			)
			((and (== nOwner 1) (not bShowing))
				(= nValue (Random 1 6))
				(= loop (+ nValue 3))
			)
		)
	)

	(method (showIt)
		(if bShowing
			(return 0)
		)
		(return
			(if (== nOwner 0)
				(self bShowing: 1 giveShowPosn:)
				((oLarryDice oShowing:) addToFront: self)
				(oLarryDice delete: self add: self)
			else
				(self bShowing: 1 giveShowPosn:)
				((oBabeDice oShowing:) addToFront: self)
			)
		)
	)

	(method (hideIt)
		(if (not bShowing)
			(return 0)
		)
		(self bShowing: 0 giveHidePosn:)
		((oLarryDice oShowing:) delete: self)
		(return (oLarryDice delete: self add: self))
	)

	(method (giveShowPosn &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (== nOwner 0)
			(= temp1 0)
			(= temp2 0)
			(= temp4 (oLarryDice oShowing:))
			(if (temp4 size:)
				(while (and (not temp1) (< temp2 (temp4 size:)))
					(= temp3 0)
					(= temp5 (KList 8 (= temp6 (temp4 first:)))) ; NodeValue
					(for ((= temp0 0)) (< temp0 (temp4 size:)) ((++ temp0))
						(if
							(and
								(== (temp5 x:) [local16 temp2])
								(== (temp5 y:) [local20 temp2])
							)
							(= temp3 1)
							(break)
						)
						(if (!= temp6 (temp4 last:))
							(= temp5 (KList 8 (= temp6 (temp4 next: temp6)))) ; NodeValue
						else
							(= temp5 0)
						)
					)
					(if (not temp3)
						(= temp1 1)
						(self x: [local16 temp2] y: [local20 temp2])
					else
						(++ temp2)
					)
				)
				(if (not temp1)
					(self x: [local16 (temp4 size:)] y: [local20 (temp4 size:)])
				)
			else
				(self x: [local16 0] y: [local20 0])
			)
		else
			(self x: [local24 local46] y: [local28 local46])
			(++ local46)
		)
	)

	(method (giveHidePosn &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 0)
		(= temp2 0)
		(while (and (not temp1) (< temp2 (oLarryDice size:)))
			(= temp3 0)
			(= temp4 (oLarryDice firstDie:))
			(for ((= temp0 0)) (< temp0 (oLarryDice size:)) ((++ temp0))
				(if
					(and
						(== (temp4 x:) [local0 temp2])
						(== (temp4 y:) [local5 temp2])
					)
					(= temp3 1)
					(break)
				)
				(= temp4 (oLarryDice nextDie:))
			)
			(if (not temp3)
				(= temp1 1)
				(self x: [local0 temp2] y: [local5 temp2])
			else
				(++ temp2)
			)
		)
	)
)

(class Dice of Set
	(properties
		oShowing 0
		curNode 0
		oDiscards 0
	)

	(method (init)
		(= oDiscards (Set new:))
		(= oShowing (Set new:))
	)

	(method (roll &tmp temp0 temp1)
		(cond
			((and (self isMemberOf: oLarryDice) (oLarryDice newShows:))
				(= temp0 (- (oLarryDice size:) ((oLarryDice oShowing:) size:)))
				(gOSound1 playSound: (+ 51201 (- 5 temp0)))
			)
			((self isMemberOf: oLarryDice)
				(gOSound1 playSound: 51201)
				(= temp1 (Random 1 100))
				(cond
					((not (gTalkers isEmpty:)) 0)
					((and (not local53) (== (Random 1 10) 3))
						(= local53 1)
						(= local59 1)
						(poFountain setScript: soRollBit)
					)
					((< 5 temp1 21)
						(= local63 1)
						(poFountain setScript: soRollCall 0 1)
					)
					((< 35 temp1 51)
						(poFountain setScript: soRollCall 0 2)
					)
					((< 70 temp1 86)
						(poFountain setScript: soRollCall 0 3)
					)
				)
			)
		)
		(self eachElementDo: #rollDie)
	)

	(method (giveOneUp &tmp temp0 temp1)
		(= temp0 (self lastDie:))
		(if (self isMemberOf: oLarryDice)
			(temp0 x: [local10 (- 5 size)])
		else
			(temp0 x: (+ [local10 (- 5 size)] 189))
		)
		(temp0 y: local15 bDiscarded: 1 bShowing: 0)
		(gOSound1 playSound: 51218)
		(oDiscards addToFront: temp0)
		(self delete: temp0)
	)

	(method (firstDie)
		(KList 8 (= curNode (self first:))) ; NodeValue
	)

	(method (nextDie)
		(if (!= curNode (self last:))
			(return (KList 8 (= curNode (self next: curNode)))) ; NodeValue
		else
			(return 0)
		)
	)

	(method (lastDie)
		(KList 8 (self last:)) ; NodeValue
	)

	(method (stillRolling &tmp temp0 temp1 temp2)
		(= temp2 0)
		(= temp1 0)
		(for
			((= temp0 (self firstDie:)))
			(and (< temp1 size) (not temp2))
			((= temp0 (self nextDie:)))
			
			(if (temp0 bRolling:)
				(= temp2 1)
			)
			(++ temp1)
		)
		(return temp2)
	)

	(method (newShows &tmp temp0 temp1 temp2)
		(= temp0 0)
		(= temp1 (self firstDie:))
		(for ((= temp2 0)) (< temp2 size) ((++ temp2))
			(if (and (temp1 bShowing:) (not (temp1 bShowed:)))
				(++ temp0)
			)
			(= temp1 (self nextDie:))
		)
		(return temp0)
	)

	(method (reposition &tmp temp0 temp1 temp2 temp3)
		(= temp0 (self firstDie:))
		(= temp1 0)
		(= temp2 0)
		(= temp3 0)
		(while (< temp1 size)
			(if (temp0 bShowing:)
				(temp0
					x:
						(if (self isMemberOf: oLarryDice)
							[local16 temp3]
						else
							[local24 temp3]
						)
					y:
						(if (self isMemberOf: oLarryDice)
							[local20 temp3]
						else
							[local28 temp3]
						)
				)
				(++ temp3)
			else
				(temp0
					x:
						(if (self isMemberOf: oLarryDice)
							[local0 temp2]
						else
							(+ [local0 temp2] 192)
						)
					y: [local5 temp2]
				)
				(++ temp2)
			)
			(= temp0 (self nextDie:))
			(++ temp1)
		)
		(if (self isMemberOf: oBabeDice)
			(= local47 temp2)
		)
	)

	(method (reset)
		((self oShowing:) release:)
		(self eachElementDo: #bShowing 0 eachElementDo: #bShowed 0 reposition:)
	)

	(method (dispose)
		(oDiscards dispose:)
		(oShowing dispose:)
		(super dispose: &rest)
	)
)

(class BetDie of View
	(properties
		bImAHog 0
		nValue 2
	)

	(method (update param1)
		(switch param1
			(1
				(self loop: 4 cel: 4 nValue: 1)
				(= local37 1)
				(oDiceRadioGroup eachElementDo: #setButton 0)
				(self updateArrows:)
				(gOSound1 playSound: 51218)
			)
			(2
				(self loop: 5 cel: 2 nValue: 2)
				(= local37 2)
				(oDie2Button internalDoSelect:)
			)
			(3
				(self loop: 6 cel: 2 nValue: 3)
				(= local37 3)
				(oDie3Button internalDoSelect:)
			)
			(4
				(self loop: 7 cel: 2 nValue: 4)
				(= local37 4)
				(oDie4Button internalDoSelect:)
			)
			(5
				(self loop: 8 cel: 2 nValue: 5)
				(= local37 5)
				(oDie5Button internalDoSelect:)
			)
			(6
				(self loop: 9 cel: 2 nValue: 6)
				(= local37 6)
				(oDie6Button internalDoSelect:)
			)
		)
	)

	(method (updateArrows)
		(if (or (> local37 5) (== local37 1))
			(oBetDieUp cel: 3)
		else
			(oBetDieUp cel: 1)
		)
		(foTopHalf
			nsLeft: ((local42 at: local35) nsLeft:)
			nsRight: ((local42 at: local35) nsRight:)
		)
		(if (> local37 2)
			(oBetDieDown cel: 0)
		else
			(oBetDieDown cel: 2)
		)
		(foBottomHalf
			nsLeft: ((local42 at: local35) nsLeft:)
			nsRight: ((local42 at: local35) nsRight:)
		)
	)

	(method (posn param1)
		(super posn: param1 416)
		(oBetDieUp posn: (+ x 5) (- y 7))
		(oBetDieDown posn: (+ x 5) (+ y 23))
		(self updateArrows:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 (event type:))
		(= temp1 (self onMe: event))
		(cond
			(bImAHog
				(self x: (- gMouseX 11) y: (- gMouseY 11))
				(if (== temp0 evMOUSERELEASE)
					(self stopHogging:)
				)
				(event claimed: 1)
			)
			((and temp1 (== temp0 evMOUSEBUTTON))
				(= local60 (= bImAHog 1))
				(gOEventHandler registerEventHog: self)
				(self setPri: 600)
				(oBetDieUp hide:)
				(oBetDieDown hide:)
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
		(event claimed:)
	)

	(method (stopHogging &tmp temp0 temp1)
		(= local60 (= bImAHog 0))
		(gOEventHandler unregisterEventHog: self)
		(= temp0 0)
		(for ((= temp1 0)) (< temp1 (local42 size:)) ((++ temp1))
			(if ((local42 at: temp1) onMe: (+ (self x:) 11) (+ (self y:) 11))
				(= temp0 (local42 at: temp1))
				(break)
			)
		)
		(if temp0
			(temp0 doVerb:)
		else
			((local42 at: local35) doVerb:)
		)
		(self setPri: 500)
		(oBetDieUp show:)
		(oBetDieDown show:)
	)
)

(class BetSlot of Feature
	(properties
		y 400
		nSlotNum 0
		nNumDiceBet 0
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
	)

	(method (onMe)
		(if (foBottomHalf onMe: gMouseX gMouseY)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (doVerb)
		(= local35 nSlotNum)
		(= local39 nNumDiceBet)
		(oBetDie posn: nsLeft)
		(cond
			((OneOf local35 1 4 7 10 13)
				(oBetDie update: 1)
			)
			((== local37 1)
				(oBetDie update: 2)
			)
			(else
				(gOSound1 playSound: 51218)
			)
		)
	)
)

(class AIBabe of Prop
	(properties
		oDieCounts 0
		nLastBetType 0
		nLastValue 0
		nLastQuant 0
	)

	(method (init)
		(= oDieCounts (IntArray new: 6))
		(super init: &rest)
	)

	(method (takeTurn)
		(self countDice:)
		(cond
			(local41
				(self make1stBet:)
			)
			(
				(or
					(and (== nLastBetType 1) (== nLastValue local37))
					(self notPossible:)
					(and (== local37 6) (== local39 10))
				)
				(self challenge:)
			)
			((self betterBet:))
			((self canIncrease:))
			((or (self goodBet:) (> (Random 1 10) 7))
				(self increaseBet:)
			)
			(else
				(self challenge:)
			)
		)
	)

	(method (make1stBet &tmp temp0 temp1 temp2 temp3)
		(if (not (oDieCounts at: 0))
			(= temp1 35)
			(= temp2 33)
			(= temp3 33)
			(if 1
				(++ temp2)
			)
		else
			(= temp1 20)
			(= temp2 40)
			(= temp3 40)
		)
		(cond
			((< (= temp0 (Random 1 100)) temp1)
				(self bluff:)
			)
			((< temp0 (+ temp1 temp2))
				(self playOdds:)
			)
			(else
				(self playSafe:)
			)
		)
	)

	(method (bluff &tmp temp0 temp1 temp2)
		(if (>= (oDieCounts at: 0) 2)
			(self playOdds:)
			(return)
		)
		(for ((= temp0 5)) (oDieCounts at: temp0) ((-- temp0))
		)
		(++ temp0)
		(= temp1
			(+
				(/
					(-
						(= temp2 (+ (oBabeDice size:) (oLarryDice size:)))
						(oDieCounts at: 0)
					)
					3
				)
				(oDieCounts at: 0)
			)
		)
		(if (< (Random 1 10) 6)
			(-- temp1)
		)
		(self updateBoard: temp0 temp1)
		(= local41 0)
		(oChallengeButton enable:)
		(= nLastBetType 1)
		(= nLastValue temp0)
		(= nLastQuant temp1)
		(self firstBetTalk:)
	)

	(method (playOdds &tmp temp0 temp1 temp2 temp3)
		(= temp3 0)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(if (>= (oDieCounts at: temp0) temp3)
				(= temp2 (+ temp0 1))
				(= temp3 (oDieCounts at: temp0))
			)
		)
		(if (== temp2 1)
			(if (>= (+ (- (oLarryDice size:) temp3) (oBabeDice size:)) 6)
				(= temp1 (+ temp3 1))
			else
				(= temp1 temp3)
			)
		else
			(= temp1 (+ temp3 (oDieCounts at: 0) (/ (oLarryDice size:) 3)))
		)
		(if
			(and
				(!= temp2 1)
				(> (oLarryDice size:) 3)
				(>= (+ (- (oLarryDice size:) temp3) (oBabeDice size:)) 3)
				(> (Random 1 10) 8)
			)
			(++ temp1)
		)
		(if
			(and
				(!= temp2 1)
				(>= (oDieCounts at: 0) 2)
				(<= temp1 (* (oDieCounts at: 0) 2))
			)
			(= temp2 1)
			(= temp1 (oDieCounts at: 0))
		)
		(self updateBoard: temp2 temp1)
		(= local41 0)
		(oChallengeButton enable:)
		(= nLastBetType 2)
		(= nLastValue temp2)
		(= nLastQuant temp1)
		(self firstBetTalk:)
	)

	(method (playSafe &tmp temp0 temp1 temp2 temp3)
		(= temp3 0)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(if (>= (oDieCounts at: temp0) temp3)
				(= temp2 (+ temp0 1))
				(= temp3 (oDieCounts at: temp0))
			)
		)
		(if (== temp2 1)
			(= temp1 temp3)
		else
			(= temp1 (+ temp3 (oDieCounts at: 0)))
		)
		(if
			(and
				(!= temp2 1)
				(>= (oDieCounts at: 0) 2)
				(<= temp1 (* (oDieCounts at: 0) 2))
			)
			(= temp2 1)
			(= temp1 (oDieCounts at: 0))
		)
		(self updateBoard: temp2 temp1)
		(= local41 0)
		(oChallengeButton enable:)
		(= nLastBetType 3)
		(= nLastValue temp2)
		(= nLastQuant temp1)
		(self firstBetTalk:)
	)

	(method (firstBetTalk &tmp temp0)
		(= temp0 (Random 1 100))
		(cond
			(local58
				(gMessager say: 0 0 30 7 soPlayGame local50) ; "It's your bet."
				(= local58 0)
			)
			((or (not (gTalkers isEmpty:)) (< temp0 26))
				(soPlayGame cue:)
			)
			((< temp0 51)
				(gMessager say: 0 0 30 7 soPlayGame local50) ; "It's your bet."
			)
			((< temp0 76)
				(gMessager say: 0 0 27 3 soPlayGame local50) ; "And awaaay we go."
			)
			(else
				(gMessager say: 0 0 27 1 soPlayGame local50)
			)
		)
	)

	(method (laterBetTalk &tmp temp0)
		(= temp0 (Random 1 100))
		(cond
			((not (gTalkers isEmpty:))
				(soPlayGame cue:)
			)
			((and (> local57 1) (not local54) (== (Random 1 10) 3))
				(= local54 1)
				(gMessager sayRange: 0 0 28 5 7 soPlayGame local50) ; "Before you challenge me, you may want to feast your eyes on these."
			)
			((and (> local57 1) (< temp0 76))
				(= local54 1)
				(gMessager say: 0 0 28 (Random 3 4) soPlayGame local50)
			)
			((< temp0 51)
				(gMessager say: 0 0 27 2 soPlayGame local50) ; "The dice are calling. They say, "Higher! Higher!""
			)
			((< temp0 76)
				(gMessager say: 0 0 27 4 soPlayGame local50) ; "I just can't help myself. Your move."
			)
			(else
				(gMessager say: 0 0 27 5 soPlayGame local50) ; "And it just keeps going higher. Pressure getting to you, Larry?"
			)
		)
	)

	(method (canIncrease &tmp temp0 temp1 temp2 temp3 temp4)
		(if (not (or (oDieCounts at: 0) (oDieCounts at: (- local37 1))))
			(return 0)
		)
		(= temp0 local39)
		(++ temp0)
		(if (== local37 1)
			(= temp1 (oDieCounts at: 0))
		else
			(= temp1 (+ (oDieCounts at: 0) (oDieCounts at: (- local37 1))))
		)
		(= temp2
			(-
				(= temp4 (+ (oLarryDice size:) (oBabeDice size:)))
				(+
					(oDieCounts at: 0)
					(oDieCounts at: 1)
					(oDieCounts at: 2)
					(oDieCounts at: 3)
					(oDieCounts at: 4)
					(oDieCounts at: 5)
				)
			)
		)
		(= temp3 (+ temp1 temp2))
		(cond
			((> temp2 3)
				(if (> temp0 (Max 0 (- temp3 2)))
					(return 0)
				)
			)
			((> temp2 1)
				(if (> temp0 (Max 0 (- temp3 1)))
					(return 0)
				)
			)
			((> temp0 temp3)
				(return 0)
			)
		)
		(= local39 temp0)
		(= local35 (self getSlot: local37 local39))
		(if (self isValidBet:)
			(self updateBoard: local37 local39)
			(= local41 0)
			(oChallengeButton enable:)
			(= nLastBetType 2)
			(= nLastValue local37)
			(= nLastQuant local39)
			(self laterBetTalk:)
			(return 1)
		else
			(= local35 local36)
			(= local37 local38)
			(= local39 local40)
			(return 0)
		)
	)

	(method (betterBet &tmp temp0 temp1 temp2 temp3)
		(= temp3 0)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(if (>= (oDieCounts at: temp0) temp3)
				(= temp2 (+ temp0 1))
				(= temp3 (oDieCounts at: temp0))
			)
		)
		(if (== temp2 1)
			(= temp1 (+ temp3 (/ (self numHidden:) 3)))
		else
			(= temp1 (+ temp3 (oDieCounts at: 0) (/ (self numHidden:) 3)))
		)
		(if (and (> (self numHidden:) 3) (> (Random 1 10) 8))
			(++ temp1)
		)
		(= local37 temp2)
		(= local39 temp1)
		(= local35 (self getSlot: local37 local39))
		(if (self isValidBet:)
			(self updateBoard: local37 local39)
			(= local41 0)
			(oChallengeButton enable:)
			(= nLastBetType 2)
			(= nLastValue local37)
			(= nLastQuant local39)
			(self laterBetTalk:)
			(return 1)
		else
			(= local35 local36)
			(= local37 local38)
			(= local39 local40)
			(return 0)
		)
	)

	(method (increaseBet &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp4 0)
		(= temp2 0)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(if (>= (oDieCounts at: temp0) temp2)
				(= temp1 (+ temp0 1))
				(= temp2 (oDieCounts at: temp0))
			)
		)
		(cond
			((and (!= local37 1) (> temp1 local37))
				(= local37 temp1)
			)
			((and (== local35 13) (not (self goodBet:)))
				(= temp4 1)
			)
			((< local35 14)
				(++ local35)
				(cond
					((OneOf local35 1 4 7 10 13)
						(if (oDieCounts at: 0)
							(= local37 1)
						else
							(++ local35)
							(= local37 temp1)
						)
					)
					((or (== local38 1) (== temp1 1))
						(= local37 6)
					)
					(else
						(= local37 temp1)
					)
				)
				(= local39 ((local42 at: local35) nNumDiceBet:))
			)
			(else
				(++ local37)
			)
		)
		(= temp3 (+ (oLarryDice size:) (oBabeDice size:)))
		(if (or (> local39 temp3) temp4)
			(= local37 local38)
			(= local39 local40)
			(self challenge:)
		else
			(self updateBoard: local37 local39)
			(= local41 0)
			(oChallengeButton enable:)
			(= nLastBetType 2)
			(= nLastValue temp1)
			(= nLastQuant local39)
			(self laterBetTalk:)
		)
	)

	(method (countDice param1 &tmp temp0 temp1)
		(oDieCounts fill: 0 6 0)
		(= temp1 (oBabeDice firstDie:))
		(for ((= temp0 0)) (< temp0 (oBabeDice size:)) ((++ temp0))
			(oDieCounts
				at:
					(- (temp1 nValue:) 1)
					(+ (oDieCounts at: (- (temp1 nValue:) 1)) 1)
			)
			(= temp1 (oBabeDice nextDie:))
		)
		(= temp1 (oLarryDice firstDie:))
		(for ((= temp0 0)) (< temp0 (oLarryDice size:)) ((++ temp0))
			(if (or (temp1 bShowing:) (and argc param1))
				(oDieCounts
					at:
						(- (temp1 nValue:) 1)
						(+ (oDieCounts at: (- (temp1 nValue:) 1)) 1)
				)
			)
			(= temp1 (oLarryDice nextDie:))
		)
	)

	(method (updateBoard param1 param2)
		(= local38 (= local37 param1))
		(= local40 (= local39 param2))
		(= local36 (= local35 (self getSlot: param1 param2)))
		(oBetDie posn: ((local42 at: local35) nsLeft:) update: local37)
		(= local57 0)
		(if (self shouldShow: local37)
			(self showNRoll: local37)
		)
	)

	(method (challenge param1)
		(self setScript: soChallenge 0 (and argc param1))
	)

	(method (reset)
		(= local35 0)
		(= local36 0)
		(= local37 2)
		(= local38 2)
		(= local39 1)
		(= local40 1)
		(= nLastQuant (= nLastValue (= nLastBetType 0)))
		(= local41 1)
		(oChallengeButton disable:)
		(oBetDie posn: ((local42 at: 0) nsLeft:) update: 2)
		(cup show:)
		(oLarryDice reset: roll:)
		(oBabeDice reset: roll:)
	)

	(method (shouldShow param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if local41
			(return 0)
		)
		(= temp2 0)
		(= temp3 1)
		(= temp5 0)
		(= temp1 (oBabeDice firstDie:))
		(for ((= temp0 0)) (< temp0 (oBabeDice size:)) ((++ temp0))
			(if (not (temp1 bShowing:))
				(++ temp2)
			)
			(if (OneOf (temp1 nValue:) 1 param1)
				(= temp5 1)
			else
				(= temp3 0)
			)
			(= temp1 (oBabeDice nextDie:))
		)
		(if (not temp5)
			(return 0)
		)
		(if (< temp2 2)
			(return 0)
		)
		(if temp3
			(return 0)
		)
		(if (== local37 1)
			(= temp4 (+ (oDieCounts at: (- param1 1)) (/ (self numHidden:) 3)))
		else
			(= temp4
				(+
					(oDieCounts at: (- param1 1))
					(oDieCounts at: 0)
					(/ (self numHidden:) 3)
				)
			)
		)
		(if (and (< temp4 local39) (!= nLastBetType 1))
			(return 1)
		else
			(return 0)
		)
	)

	(method (showNRoll param1 &tmp temp0 temp1 temp2)
		(= temp1 (oBabeDice firstDie:))
		(for ((= temp0 0)) (< temp0 (oBabeDice size:)) ((++ temp0))
			(if
				(and
					(not (temp1 bShowing:))
					(not local41)
					(OneOf (temp1 nValue:) 1 param1)
					(< (+ ((oBabeDice oShowing:) size:) 1) (oBabeDice size:))
				)
				(++ local57)
				(temp1 showIt:)
			)
			(= temp1 (oBabeDice nextDie:))
		)
		(oBabeDice reposition:)
		(= temp2 (- (oBabeDice size:) ((oBabeDice oShowing:) size:)))
		(gOSound1 playSound: (+ 51201 (- 5 temp2)))
		(oBabeDice roll:)
	)

	(method (numHidden &tmp temp0 temp1 temp2)
		(= temp0 (+ (oLarryDice size:) (oBabeDice size:)))
		(= temp1
			(+
				(oDieCounts at: 0)
				(oDieCounts at: 1)
				(oDieCounts at: 2)
				(oDieCounts at: 3)
				(oDieCounts at: 4)
				(oDieCounts at: 5)
			)
		)
		(= temp2 (- temp0 temp1))
	)

	(method (goodBet)
		(if
			(or
				(and (== local37 1) (>= (oDieCounts at: 0) local39))
				(and
					(!= local37 1)
					(>=
						(+ (oDieCounts at: 0) (oDieCounts at: (- local37 1)))
						local39
					)
				)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (notPossible &tmp temp0)
		(if (== local37 1)
			(= temp0 (oDieCounts at: 0))
		else
			(= temp0 (+ (oDieCounts at: (- local37 1)) (oDieCounts at: 0)))
		)
		(if (> local39 (+ (self numHidden:) temp0))
			(return 1)
		else
			(return 0)
		)
	)

	(method (isValidBet)
		(if
			(or
				(> local35 local36)
				(and (== local35 local36) (> local37 local38) (!= local38 1))
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (getSlot param1 param2)
		(switch param2
			(1
				(if (== param1 1)
					(return 1)
				else
					(return 0)
				)
			)
			(2
				(if (== param1 1)
					(return 4)
				else
					(return 2)
				)
			)
			(3
				(if (== param1 1)
					(return 7)
				else
					(return 3)
				)
			)
			(4
				(if (== param1 1)
					(return 10)
				else
					(return 5)
				)
			)
			(5
				(if (== param1 1)
					(return 13)
				else
					(return 6)
				)
			)
			(6
				(return 8)
			)
			(7
				(return 9)
			)
			(8
				(return 11)
			)
			(9
				(return 12)
			)
			(10
				(return 14)
			)
		)
	)

	(method (dispose)
		(oDieCounts dispose:)
		(super dispose:)
	)
)

(instance soIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gMessager say: 0 0 3 0 self 2) ; "Make yourself comfortable, Larry."
			)
			(2
				(gMessager say: 0 0 5 (Random 1 3) self local50)
				(oLarryDice roll:)
				(oBabeDice roll:)
			)
			(3
				((ScriptID 64040 2) init: oBabe global246) ; L7TalkWindow
				(gCurRoom setScript: soPlayGame)
				(self dispose:)
			)
		)
	)
)

(instance soPlayGame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(= ticks (Random 50 110))
			)
			(1
				1
				(cond
					((not (gTalkers isEmpty:))
						(-- state)
						(= ticks 60)
					)
					((oLarryDice stillRolling:)
						(-- state)
						(= ticks 10)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				2
				(oBabe takeTurn:)
			)
			(3
				3
				(cond
					((oLarryDice stillRolling:)
						(-- state)
						(= cycles 3)
					)
					((and local41 local43)
						(self changeState: 0)
					)
					(else
						(oDelayTimer setReal: oDelayTimer 30)
						(if (or (not local59) (not local63))
							(gGame handsOn:)
						)
					)
				)
			)
			(4
				4
				(oDelayTimer dispose: delete:)
				(if (and local41 (not local43))
					(self changeState: 3)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance soDieRoll of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(client bRolling: 1)
				(= register 0)
				(= cycles 3)
			)
			(1
				(if
					(and
						(== (= temp0 (Random 4 9)) (client loop:))
						(== (++ temp0) 10)
					)
					(= temp0 4)
				)
				(client loop: temp0)
				(= ticks (= scratch (Random 15 35)))
			)
			(2
				(+= register scratch)
				(if (< register 90)
					(self changeState: 1)
				else
					(= cycles 1)
				)
			)
			(3
				(client nValue: (Random 1 6))
				(client loop: (+ (client nValue:) 3) bRolling: 0)
				(if (not (oLarryDice stillRolling:))
					(gOSound1 stop:)
				)
				(self dispose:)
			)
		)
	)
)

(instance soChallenge of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp1 (Random 1 100))
				(cond
					(register
						(cond
							((<= temp1 20)
								(= temp2 7)
							)
							((<= temp1 35)
								(= temp2 9)
							)
							((<= temp1 45)
								(= temp2 10)
							)
							((<= temp1 55)
								(= temp2 11)
							)
							((<= temp1 65)
								(= temp2 12)
							)
							((<= temp1 75)
								(= temp2 13)
							)
							((<= temp1 85)
								(= temp2 14)
							)
							(else
								(= temp2 8)
							)
						)
					)
					((<= temp1 30)
						(= temp2 1)
					)
					((<= temp1 40)
						(= temp2 3)
					)
					((<= temp1 50)
						(= temp2 4)
					)
					((<= temp1 60)
						(= temp2 5)
					)
					((<= temp1 70)
						(= temp2 6)
					)
					(else
						(= temp2 2)
					)
				)
				(gMessager say: 0 0 7 temp2 self local50)
			)
			(1
				(cup hide:)
				(oBabe countDice: 1)
				(= ticks 70)
			)
			(2
				(if
					(or
						(and
							(== local37 1)
							(>= ((oBabe oDieCounts:) at: 0) local39)
						)
						(and
							(!= local37 1)
							(>=
								(+
									((oBabe oDieCounts:) at: 0)
									((oBabe oDieCounts:) at: (- local37 1))
								)
								local39
							)
						)
					)
					(= temp0 1)
				else
					(= temp0 0)
				)
				(cond
					((and register temp0)
						(if (< 20 (Random 1 100) 71)
							(gMessager say: 0 0 11 (Random 6 10) self local50)
						else
							(gMessager say: 0 0 10 (Random 1 3) self local50)
						)
						(= local43 1)
					)
					((and register (not temp0))
						(if (< 40 (Random 1 100) 91)
							(gMessager say: 0 0 13 (Random 7 12) self local50)
						else
							(gMessager say: 0 0 11 (Random 1 5) self local50)
						)
						(= local43 0)
					)
					(temp0
						(if (< 10 (Random 1 100) 61)
							(if (< 35 (Random 1 100) 86)
								(gMessager say: 0 0 10 (Random 4 6) self local50)
							else
								(gMessager say: 0 0 8 (Random 4 6) self local50)
							)
						else
							(gMessager say: 0 0 11 (Random 1 5) self local50)
						)
						(= local43 0)
					)
					(else
						(if (< 0 (Random 1 100) 51)
							(gMessager say: 0 0 11 (Random 6 10) self local50)
						else
							(gMessager say: 0 0 13 (Random 1 6) self local50)
						)
						(= local43 1)
					)
				)
			)
			(3
				(if local43
					(oLarryDice giveOneUp:)
				else
					(oBabeDice giveOneUp:)
				)
				(if
					(and
						(== local48 5)
						(< local32 100)
						(not (oLarryDice size:))
					)
					(gCurRoom setScript: soLarryLoses)
				else
					(= cycles 1)
				)
			)
			(4
				(client setScript: soChoiceDialog 0 register)
			)
		)
	)
)

(instance soBabeSellsClothes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch local49
					(0
						(gMessager say: 0 0 19 0 self local50)
					)
					(1
						(Load rsVIEW 51111)
						(gMessager say: 0 0 21 0 self local50)
					)
					(2
						(Load rsVIEW 51112)
						(gMessager say: 0 0 22 0 self local50)
					)
					(3
						(Load rsVIEW 51113)
						(gMessager say: 0 0 23 0 self local50)
					)
					(4
						(Load rsVIEW 51114)
						(gMessager say: 0 0 24 0 self local50)
					)
					(5
						(Load rsVIEW 51115)
						(gMessager sayRange: 0 0 12 1 4 self local50)
					)
				)
			)
			(1
				(switch local49
					(0
						(voBabeBottom show:)
						(oBabe setCycle: End self 14 99)
					)
					(1
						(oBabe view: 51111 cel: 0 setCycle: End self 6 99)
					)
					(2
						(oBabe view: 51112 cel: 0 doit: setCycle: End self 7 99)
						(voBabeBottom hide:)
					)
					(3
						(voBabeBottom view: 51117 show:)
						(oBabe view: 51113 cel: 0 setCycle: End self 12 99)
					)
					(4
						(oBabe view: 51114 cel: 0 setCycle: End self 12 99)
					)
					(5
						(oBabe
							view: 51115
							cel: 0
							doit:
							setCycle: End self 37 99
						)
						(voBabeBottom dispose:)
						(voDrink dispose:)
					)
				)
				(poDewmiEyes view: (oBabe view:) hide:)
			)
			(2
				(switch local49
					(0
						(gOSound1 playSound: 51213)
					)
					(1
						(gOSound1 playSound: 51211)
					)
					(2
						(gOSound1 playSound: 51212)
					)
					(3
						(gOSound1 playSound: 51215)
					)
					(4
						(gOSound1 playSound: 51215)
					)
					(5
						(gOSound1 playSound: 51212)
						(voDrink posn: 328 451)
						(= local62 1)
					)
				)
			)
			(3
				(poDewmiEyes show:)
				(if (== local49 5)
					(gMessager sayRange: 0 0 12 5 99 self local50) ; "Doh!"
				else
					(= cycles 1)
				)
			)
			(4
				(++ local49)
				(+= local33 local45)
				(if (< local34 local45)
					(Prints
						{WARNING: There's not enough money in the pot.}
					)
				else
					(-= local34 local45)
				)
				(if (or (< local45 150) (not ((ScriptID 64017 0) test: 285))) ; oFlags
					(+= local45 50)
				)
				(voBabeMoney draw: {$%d} local33)
				(voPotMoney draw: {Pto: $%d} local34)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soLarrySellsClothes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch local48
					(0
						(gMessager say: 0 0 14 0 self local50)
					)
					(1
						(gMessager say: 0 0 15 0 self local50)
					)
					(2
						(gMessager say: 0 0 16 0 self local50)
					)
					(3
						(gMessager say: 0 0 17 0 self local50)
					)
					(4
						(gMessager sayRange: 0 0 18 1 2 self local50)
					)
				)
			)
			(1
				(switch local48
					(0
						(poLarry loop: 0 cel: 0)
					)
					(1
						(poLarry loop: 0 cel: 0)
					)
					(2
						(poLarry loop: 0 cel: 0)
					)
					(3
						(poLarry loop: 0 cel: 0)
					)
					(4
						(poLarry loop: 0 cel: 0)
					)
				)
				(= cycles 1)
			)
			(2
				(voLarryBust hide:)
				(switch local48
					(0
						(poLarry setCycle: End self 5 99)
					)
					(1
						(poLarry setCycle: End self 15 99)
					)
					(2
						(poLarry setCycle: End self 6 99)
					)
					(3
						(poLarry setCycle: End self 5 99)
					)
					(4
						(poLarry setCycle: End self 7 99)
					)
				)
			)
			(3
				(switch local48
					(0
						(gOSound1 playSound: 51211)
					)
					(1
						(gOSound1 playSound: 51211)
					)
					(2
						(gOSound1 playSound: 51212)
					)
					(3
						(gOSound1 playSound: 51214)
					)
					(4
						(gOSound1 playSound: 51212)
					)
				)
			)
			(4
				(switch local48
					(0
						(poLarry view: 51151 loop: 2 cel: 0)
					)
					(1
						(poLarry view: 51152 loop: 2 cel: 0)
					)
					(2
						(poLarry view: 51153 loop: 2 cel: 0)
					)
					(3
						(poLarry view: 51154 loop: 2 cel: 0)
					)
					(4
						(poLarry view: 51155 loop: 2 cel: 0)
					)
				)
				(voLarryBust view: (poLarry view:) show:)
				(if (== local48 4)
					(FrameOut)
					(gMessager sayRange: 0 0 18 3 4 self local50)
				else
					(= cycles 1)
				)
			)
			(5
				(++ local48)
				(+= local32 local44)
				(if (< local34 local44)
					(Prints
						{WARNING: There's not enough money in the pot.}
					)
				else
					(-= local34 local44)
				)
				(if (or (< local44 150) (not ((ScriptID 64017 0) test: 285))) ; oFlags
					(+= local44 50)
				)
				(voLarryMoney draw: {$%d} local32)
				(voPotMoney draw: {Pto: $%d} local34)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soBuyDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					(register
						(cond
							(local55
								(= cycles 1)
							)
							((and (not local52) (== (Random 1 10) 3))
								(= local52 1)
								(gMessager say: 0 0 26 0 self local50)
							)
							((== (oLarryDice size:) 4)
								(gMessager say: 0 0 25 1 self local50)
							)
							(else
								(gMessager say: 0 0 25 2 self local50) ; "I'll buy some dice."
							)
						)
					)
					(local55
						(= cycles 1)
					)
					((== (oBabeDice size:) 4)
						(gMessager say: 0 0 25 3 self local50) ; "I'll buy a die."
					)
					(else
						(gMessager say: 0 0 25 4 self local50) ; "I'll buy some dice."
					)
				)
			)
			(1
				(= local55 1)
				(if register
					(((oLarryDice oDiscards:) at: 0)
						bDiscarded: 0
						x: [local0 (oLarryDice size:)]
						y: [local5 (oLarryDice size:)]
					)
					(oLarryDice add: ((oLarryDice oDiscards:) at: 0))
					((oLarryDice oDiscards:)
						delete: ((oLarryDice oDiscards:) at: 0)
					)
					(+= local34 100)
					(-= local32 100)
					(voLarryMoney draw: {$%d} local32)
					(voPotMoney draw: {Pto: $%d} local34)
					(= cycles 6)
				else
					(((oBabeDice oDiscards:) at: 0)
						bDiscarded: 0
						x: (+ [local0 (oBabeDice size:)] 192)
						y: [local5 (oBabeDice size:)]
					)
					(oBabeDice add: ((oBabeDice oDiscards:) at: 0))
					((oBabeDice oDiscards:)
						delete: ((oBabeDice oDiscards:) at: 0)
					)
					(+= local34 100)
					(-= local33 100)
					(voBabeMoney draw: {$%d} local33)
					(voPotMoney draw: {Pto: $%d} local34)
					(= cycles 6)
				)
				(gOSound1 playSound: 51218)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soChoiceDialog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(= local55 0)
				(= scratch 1)
				(= cycles 3)
			)
			(1
				(if
					(or
						(and
							(or
								(== local48 5)
								(< local34 local44)
								(> local32 99)
								(== (oLarryDice size:) 5)
							)
							(or (== (oLarryDice size:) 5) (< local32 100))
						)
						(and (< (oLarryDice size:) 5) (== (oBabeDice size:) 0))
					)
					(self changeState: 4)
				else
					(switch
						(= scratch
							(localproc_0
								(MakeMessageText 1 0 2 1 2)
								(MakeMessageText 1 0 25 1 2)
								(MakeMessageText 1 0 35 1 2)
							)
						)
						(1
							(if (< local32 100)
								(= local51 1)
								(self
									setScript: (soLarrySellsClothes new:) self
								)
							else
								(self setScript: (soBuyDie new:) self 1)
							)
						)
						(else
							(= scratch 0)
							(= cycles 1)
						)
					)
				)
			)
			(2
				(if local51
					(= local51 0)
					(self setScript: (soBuyDie new:) self 1)
				else
					(= cycles 1)
				)
			)
			(3
				(if scratch
					(self changeState: 1)
				else
					(= cycles 1)
				)
			)
			(4
				(= local55 0)
				(self setScript: soBabeActions self)
			)
			(5
				(if (not (oLarryDice size:))
					(gMessager say: 0 0 30 2 self local50) ; "You can't play with no dice. You have to buy at least one."
				else
					(oBabe reset:)
					(soPlayGame cue:)
					(self dispose:)
				)
			)
			(6
				(self changeState: 1)
			)
		)
	)
)

(instance soBabeActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(or
						(< (oBabeDice size:) 5)
						(and
							(< local32 100)
							(== local48 5)
							(< (oBabeDice size:) 5)
						)
					)
					(cond
						((>= local33 100)
							(self setScript: (soBuyDie new:) self)
						)
						((and (== (+ local49 1) 7) (== (oBabeDice size:) 0))
							((ScriptID 64017 0) set: 131) ; oFlags
							(gCurRoom newRoom: 512) ; ro512
						)
						((== (+ local49 1) 7)
							(self dispose:)
						)
						((< local34 local45)
							(Prints
								{There's not enough money in the pot. You're going to have to sell some clothes so I can buy some dice. Either that or forfeit.}
							)
							(oBabe setScript: soChoiceDialog)
						)
						(else
							(self setScript: soBabeSellsClothes self)
						)
					)
				else
					(self dispose:)
				)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance soLarryLoses of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 30)
			)
			(1
				(gMessager say: 0 0 29 0 self local50)
			)
			(2
				((ScriptID 64017 0) clear: 131) ; oFlags
				(gCurRoom newRoom: 370) ; ro370
				(self dispose:)
			)
		)
	)
)

(instance soRollBit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 6 0 self local50)
			)
			(1
				(gGame handsOn:)
				(= local59 0)
				(self dispose:)
			)
		)
	)
)

(instance soRollCall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 5 register 0 local50)
			)
			(1
				(gGame handsOn:)
				(= local63 0)
				(self dispose:)
			)
		)
	)
)

(instance soLookAtUser of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 5 1 0 0 self) ; "Play your dice right and you just might get to spend some "quality time" in there."
			)
			(1
				(= register (poLarry loop:))
				(poLarry loop: 3 cel: 0)
				(= cycles 1)
			)
			(2
				(voLarryBust hide:)
				(poLarry setCycle: End self)
			)
			(3
				(= ticks 70)
			)
			(4
				(poLarry setCycle: Beg self)
			)
			(5
				(voLarryBust show:)
				(poLarry loop: register)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oLarryDice of Dice
	(properties)
)

(instance oBabeDice of Dice
	(properties)
)

(instance oBetDie of BetDie
	(properties
		priority 500
		x 210
		y 416
		loop 5
		cel 2
		view 51100
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(oBetDieUp init:)
		(foTopHalf init:)
		(oBetDieDown init:)
		(foBottomHalf init:)
	)
)

(instance oBetDieUp of View
	(properties
		priority 500
		x 215
		y 409
		loop 12
		cel 1
		view 51100
		fixPriority 1
	)
)

(instance oBetDieDown of View
	(properties
		priority 500
		x 215
		y 439
		loop 12
		view 51100
		fixPriority 1
	)
)

(instance cup of View
	(properties
		noun 9
		priority 500
		x 196
		y 125
		loop 10
		view 51100
		fixPriority 1
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
	)
)

(instance oBetButton of PushButton
	(properties
		priority 500
		x 207
		y 379
		loop 1
		view 51100
		fixPriority 1
	)

	(method (doSelect &tmp temp0 temp1)
		(if (or local41 (oBabe isValidBet:))
			(= local36 local35)
			(= local38 local37)
			(= local40 local39)
			(if (= temp1 (oLarryDice newShows:))
				(oLarryDice reposition: roll:)
				((oLarryDice oShowing:) eachElementDo: #bShowed 1)
			)
			(= temp0 (Random 1 100))
			(cond
				((not (gTalkers isEmpty:))
					(= local41 0)
					(soPlayGame cue:)
				)
				(local41
					(= local41 0)
					(oChallengeButton enable:)
					(cond
						((< 34 temp0 67)
							(gMessager say: 0 0 27 6 soPlayGame local50) ; "And over to you."
						)
						((< 66 temp0 101)
							(gMessager say: 0 0 27 7 soPlayGame local50) ; "Okay, there's my bet. Challenge it; I dare ya."
						)
						(else
							(soPlayGame cue:)
						)
					)
				)
				((and (> temp1 1) (< temp0 51))
					(if (< (Random 1 100) 70)
						(gMessager say: 0 0 28 1 soPlayGame local50)
					else
						(gMessager say: 0 0 28 2 soPlayGame local50)
					)
				)
				((and (== temp1 1) (< temp0 51))
					(gMessager say: 0 0 28 2 soPlayGame local50)
				)
				(else
					(gMessager say: 0 0 27 (Random 6 10) soPlayGame local50)
				)
			)
		else
			(gMessager say: 0 0 30 1 0 local50)
			(oBetDie posn: ((local42 at: local36) nsLeft:) update: local38)
			(= local35 local36)
			(= local37 local38)
			(= local39 local40)
		)
	)
)

(instance oChallengeButton of PushButton
	(properties
		priority 500
		x 268
		y 379
		loop 2
		view 51100
		fixPriority 1
	)

	(method (doSelect)
		(= local35 local36)
		(= local37 local38)
		(= local39 local40)
		(oBabe challenge: 1)
	)
)

(instance oHowToPlayButton of PushButton
	(properties
		priority 500
		x 380
		y 379
		loop 11
		view 51100
		fixPriority 1
	)

	(method (doSelect &tmp [temp0 3])
		(DisplayMsgSequence 33 0 0 511)
	)
)

(instance oDie2Button of RadioButton
	(properties
		priority 500
		x 597
		y 386
		loop 5
		view 51100
		fixPriority 1
		bButtonDown 1
	)

	(method (onMe)
		(if (== (oBetDie nValue:) 1)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (doSelect)
		(= local37 2)
		(oBetDie loop: 5 cel: 2 nValue: 2 updateArrows:)
		(gOSound1 playSound: 51218)
	)
)

(instance oDie3Button of RadioButton
	(properties
		priority 500
		x 567
		y 416
		loop 6
		view 51100
		fixPriority 1
	)

	(method (onMe)
		(if (== (oBetDie nValue:) 1)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (doSelect)
		(= local37 3)
		(oBetDie loop: 6 cel: 2 nValue: 3 updateArrows:)
		(gOSound1 playSound: 51218)
	)
)

(instance oDie4Button of RadioButton
	(properties
		priority 500
		x 597
		y 416
		loop 7
		view 51100
		fixPriority 1
	)

	(method (onMe)
		(if (== (oBetDie nValue:) 1)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (doSelect)
		(= local37 4)
		(oBetDie loop: 7 cel: 2 nValue: 4 updateArrows:)
		(gOSound1 playSound: 51218)
	)
)

(instance oDie5Button of RadioButton
	(properties
		priority 500
		x 567
		y 446
		loop 8
		view 51100
		fixPriority 1
	)

	(method (onMe)
		(if (== (oBetDie nValue:) 1)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (doSelect)
		(= local37 5)
		(oBetDie loop: 8 cel: 2 nValue: 5 updateArrows:)
		(gOSound1 playSound: 51218)
	)
)

(instance oDie6Button of RadioButton
	(properties
		priority 500
		x 597
		y 446
		loop 9
		view 51100
		fixPriority 1
	)

	(method (onMe)
		(if (== (oBetDie nValue:) 1)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (doSelect)
		(= local37 6)
		(oBetDie loop: 9 cel: 2 nValue: 6 updateArrows:)
		(gOSound1 playSound: 51218)
	)
)

(instance oDiceRadioGroup of RadioGroup
	(properties)

	(method (init)
		(super init: &rest)
		(self add: oDie2Button oDie3Button oDie4Button oDie5Button oDie6Button)
	)
)

(instance voLarryMoney of TextView
	(properties
		priority 480
		x 46
		y 179
		fixPriority 1
		fore 0
		width 50
	)

	(method (init)
		(= back skip)
		(super init: &rest)
		(self draw: {$%d} local32)
	)
)

(instance voBabeMoney of TextView
	(properties
		priority 480
		x 238
		y 179
		fixPriority 1
		fore 0
		width 50
	)

	(method (init)
		(= back skip)
		(super init: &rest)
		(self draw: {$%d} local33)
	)
)

(instance voPotMoney of TextView
	(properties
		x 518
		y 392
		fore 0
		width 90
	)

	(method (init)
		(= back skip)
		(super init: &rest)
		(self draw: {Pto: $%d} local34)
	)
)

(instance oBabe of AIBabe
	(properties
		noun 11
		priority 190
		x 369
		y 369
		view 51110
		z -100
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(voBabeBottom init: hide:)
		(poDewmiEyes init:)
		(voDrink init:)
		(foDewmiBreasts init:)
		(foHair init:)
		(foFace init:)
		(foLegs init:)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local61
					(= local61 0)
					(gMessager say: noun theVerb 4) ; "Dewmi Moore looks like the kind of girl you'd bring home to Mother... assuming your Mother was Heidi Fleiss!"
				else
					(= local61 1)
					(super doVerb: theVerb)
				)
			)
			(4 ; Talk
				(if (not ((ScriptID 64040 2) oPlane:)) ; L7TalkWindow
					((ScriptID 64040 2) init: self global246) ; L7TalkWindow
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voBabeBottom of View
	(properties
		view 51116
	)

	(method (init)
		(= x (oBabe x:))
		(= y (oBabe y:))
		(= z (oBabe z:))
		(super init: &rest)
		(self setPri: (- (oBabe priority:) 1))
	)
)

(instance voDrink of View
	(properties
		noun 14
		x 403
		y 334
		view 51118
	)

	(method (init)
		(self setPri: (+ (oBabe priority:) 5))
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local62
					(gMessager say: noun theVerb 2) ; "Now I know why Dewmi always has drinks with big umbrellas."
				else
					(gMessager say: noun theVerb 3) ; "Dewmi drinks "Colossal Hump" exclusively."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poLarry of Prop
	(properties
		priority 300
		x 369
		y 469
		loop 2
		view 51150
		fixPriority 1
	)
)

(instance poFountain of Prop
	(properties
		priority 75
		x 507
		y 120
		view 51125
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance foShowArea of Feature
	(properties
		noun 27
		x 159
		y 67
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 132 119 132 15 186 15 186 119
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foRollArea of Feature
	(properties
		x 64
		y 69
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 17 39 36 20 55 14 76 14 94 20 109 35 119 57 118 82 110 99 90 117 70 124 46 123 26 108 10 83 13 42 35 23 36 21
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance foTopHalf of Feature
	(properties
		x 404
		y 505
		nsBottom 415
		nsLeft 210
		nsRight 232
		nsTop 408
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
	)

	(method (handleEvent event)
		(if (or (> local37 5) (== local37 1))
			(event claimed: 0)
			(return 0)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb)
		(if (< local37 6)
			(oBetDie update: (+ (oBetDie nValue:) 1))
		)
	)
)

(instance foBottomHalf of Feature
	(properties
		x 404
		y 505
		nsBottom 445
		nsLeft 700
		nsRight 710
		nsTop 438
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
	)

	(method (handleEvent event)
		(if (< local37 3)
			(event claimed: 0)
			(return 0)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb)
		(if (> local37 2)
			(oBetDie update: (- (oBetDie nValue:) 1))
		)
	)
)

(instance foFace of Feature
	(properties
		noun 15
		x 377
		y 375
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 354 112 362 101 372 97 390 103 400 125 400 139 386 157 378 164 363 154
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(oBabe doVerb: theVerb)
			(return)
		)
		(switch theVerb
			(4 ; Talk
				(oBabe doVerb: 4)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foHair of Feature
	(properties
		noun 19
		x 377
		y 375
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 324 142 331 149 339 146 341 135 328 117 330 87 345 67 373 63 387 76 403 76 417 94 417 133 431 137 415 156 405 155 400 147 407 142 402 118 398 117 387 97 369 94 352 113 361 153 360 164 347 171 334 169 324 158
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(oBabe doVerb: theVerb)
			(return)
		)
		(switch theVerb
			(4 ; Talk
				(oBabe doVerb: 4)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foDewmiBreasts of Feature
	(properties
		noun 5
		x 375
		y 480
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 329 216 344 196 420 196 422 224 398 249 339 238
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(oBabe doVerb: theVerb)
			(return)
		)
		(switch theVerb
			(1 ; Look
				(poFountain setScript: soLookAtUser)
			)
			(4 ; Talk
				(oBabe doVerb: 4)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foLegs of Feature
	(properties
		noun 21
		x 307
		y 375
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 244 368 282 279 289 279 289 306 323 301 337 281 356 280 370 287 368 291 350 294 359 318 352 336 341 334 326 341 333 366 312 369 294 352 266 370 246 370
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(oBabe doVerb: theVerb)
			(return)
		)
		(switch theVerb
			(4 ; Talk
				(oBabe doVerb: 4)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foDiscoBall of Feature
	(properties
		noun 12
		x 520
		y 31
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 510 18 522 12 535 16 542 31 529 49 509 50 499 35 502 23
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foFlowers of Feature
	(properties
		noun 17
		x 588
		y 277
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 573 367 582 332 538 279 547 246 620 188 639 195 637 367
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foGlassTable of Feature
	(properties
		noun 18
		x 225
		y 323
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 286 277 280 242 367 233 367 218 337 173 328 189 305
					yourself:
				)
		)
		(super init: &rest)
		(foTable2 init:)
		(AddDefaultVerbs self)
	)
)

(instance foTable2 of Feature
	(properties
		noun 18
		x 507
		y 332
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 446 293 512 308 572 339 571 356 550 371 443 369 452 324
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foHotTub of Feature
	(properties
		noun 20
		x 520
		y 133
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 452 100 502 99 547 101 587 108 596 129 619 129 615 155 557 166 461 167 421 157 441 128 428 117
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foMermaid of Feature
	(properties
		noun 24
		x 436
		y 62
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 435 10 451 12 484 41 482 54 467 60 452 55 452 65 460 79 458 89 443 87 451 94 436 115 416 108 413 83 389 63 408 45 397 35 419 27
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foMerman of Feature
	(properties
		noun 25
		x 602
		y 98
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 567 40 591 1 637 2 636 37 619 99 633 105 636 140 624 159 637 164 637 176 628 173 632 188 603 195 599 173 615 163 624 126 596 127 585 72
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foDewmiLostDice of Feature
	(properties
		noun 10
		x 253
		y 147
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 189 132 194 130 313 130 317 134 316 163 311 164 194 164 190 160
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foLarryLostDice of Feature
	(properties
		noun 31
		x 65
		y 148
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 8 131 125 131 129 136 127 161 125 164 6 165 2 161 1 135
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foAnchor of Feature
	(properties
		noun 1
		x 350
		y 41
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 331 0 366 0 372 5 368 62 341 70 335 82 329 71
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foSlot1 of BetSlot
	(properties
		nsBottom 468
		nsLeft 210
		nsRight 232
		nsTop 414
		nNumDiceBet 1
	)
)

(instance foSlot1A of BetSlot
	(properties
		nsBottom 468
		nsTop 414
		nSlotNum 1
		nNumDiceBet 1
	)

	(method (init)
		(= nsLeft (+ (foSlot1 nsRight:) 1))
		(= nsRight (+ nsLeft 22))
		(super init: &rest)
	)
)

(instance foSlot2 of BetSlot
	(properties
		nsBottom 468
		nsTop 414
		nSlotNum 2
		nNumDiceBet 2
	)

	(method (init)
		(= nsLeft (+ (foSlot1A nsRight:) 1))
		(= nsRight (+ nsLeft 22))
		(super init: &rest)
	)
)

(instance foSlot3 of BetSlot
	(properties
		nsBottom 468
		nsTop 414
		nSlotNum 3
		nNumDiceBet 3
	)

	(method (init)
		(= nsLeft (+ (foSlot2 nsRight:) 1))
		(= nsRight (+ nsLeft 22))
		(super init: &rest)
	)
)

(instance foSlot2A of BetSlot
	(properties
		nsBottom 468
		nsTop 414
		nSlotNum 4
		nNumDiceBet 2
	)

	(method (init)
		(= nsLeft (+ (foSlot3 nsRight:) 1))
		(= nsRight (+ nsLeft 22))
		(super init: &rest)
	)
)

(instance foSlot4 of BetSlot
	(properties
		nsBottom 468
		nsTop 414
		nSlotNum 5
		nNumDiceBet 4
	)

	(method (init)
		(= nsLeft (+ (foSlot2A nsLeft:) 23))
		(= nsRight (+ (foSlot2A nsRight:) 23))
		(super init: &rest)
	)
)

(instance foSlot5 of BetSlot
	(properties
		nsBottom 468
		nsTop 414
		nSlotNum 6
		nNumDiceBet 5
	)

	(method (init)
		(= nsLeft (+ (foSlot4 nsRight:) 1))
		(= nsRight (+ nsLeft 22))
		(super init: &rest)
	)
)

(instance foSlot3A of BetSlot
	(properties
		nsBottom 468
		nsTop 414
		nSlotNum 7
		nNumDiceBet 3
	)

	(method (init)
		(= nsLeft (+ (foSlot5 nsRight:) 1))
		(= nsRight (+ nsLeft 22))
		(super init: &rest)
	)
)

(instance foSlot6 of BetSlot
	(properties
		nsBottom 468
		nsTop 414
		nSlotNum 8
		nNumDiceBet 6
	)

	(method (init)
		(= nsLeft (+ (foSlot3A nsRight:) 1))
		(= nsRight (+ nsLeft 22))
		(super init: &rest)
	)
)

(instance foSlot7 of BetSlot
	(properties
		nsBottom 468
		nsTop 414
		nSlotNum 9
		nNumDiceBet 7
	)

	(method (init)
		(= nsLeft (+ (foSlot6 nsRight:) 1))
		(= nsRight (+ nsLeft 22))
		(super init: &rest)
	)
)

(instance foSlot4A of BetSlot
	(properties
		nsBottom 468
		nsTop 414
		nSlotNum 10
		nNumDiceBet 4
	)

	(method (init)
		(= nsLeft (+ (foSlot7 nsRight:) 1))
		(= nsRight (+ nsLeft 22))
		(super init: &rest)
	)
)

(instance foSlot8 of BetSlot
	(properties
		nsBottom 468
		nsTop 414
		nSlotNum 11
		nNumDiceBet 8
	)

	(method (init)
		(= nsLeft (+ (foSlot4A nsRight:) 1))
		(= nsRight (+ nsLeft 22))
		(super init: &rest)
	)
)

(instance foSlot9 of BetSlot
	(properties
		nsBottom 468
		nsTop 414
		nSlotNum 12
		nNumDiceBet 9
	)

	(method (init)
		(= nsLeft (+ (foSlot8 nsRight:) 1))
		(= nsRight (+ nsLeft 22))
		(super init: &rest)
	)
)

(instance foSlot5A of BetSlot
	(properties
		nsBottom 468
		nsTop 414
		nSlotNum 13
		nNumDiceBet 5
	)

	(method (init)
		(= nsLeft (+ (foSlot9 nsRight:) 1))
		(= nsRight (+ nsLeft 22))
		(super init: &rest)
	)
)

(instance foSlot10 of BetSlot
	(properties
		nsBottom 468
		nsTop 414
		nSlotNum 14
		nNumDiceBet 10
	)

	(method (init)
		(= nsLeft (+ (foSlot5A nsRight:) 1))
		(= nsRight (+ nsLeft 22))
		(super init: &rest)
	)
)

(instance toLarry of Talker
	(properties
		priority 300
	)

	(method (init)
		(= view (poLarry view:))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(poLarry hide:)
		(super init: poLarryMouth)
	)

	(method (dispose)
		(poLarry show:)
		(super dispose: &rest)
	)
)

(instance poLarryMouth of Prop
	(properties
		loop 2
	)

	(method (init)
		(= view (toLarry view:))
		(= x (toLarry x:))
		(= y (toLarry y:))
		(super init: &rest)
		(self setPri: 301)
	)
)

(instance voLarryBust of View
	(properties
		loop 1
	)

	(method (init)
		(= view (poLarry view:))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(super init: &rest)
		(self setPri: 302)
	)
)

(instance toDewmi of Talker
	(properties)

	(method (init)
		(= priority (+ (oBabe priority:) 1))
		(oBabe hide:)
		(super init: oBabeMouth voDewmiBust)
	)

	(method (dispose)
		(oBabe show:)
		(super dispose: &rest)
	)
)

(instance oBabeMouth of Prop
	(properties
		loop 2
	)

	(method (init)
		(= view (oBabe view:))
		(= x (oBabe x:))
		(= y (oBabe y:))
		(= z (oBabe z:))
		(= priority (+ (voDewmiBust priority:) 1))
		(super init: &rest)
	)
)

(instance voDewmiBust of View
	(properties
		loop 1
	)

	(method (init)
		(= view (oBabe view:))
		(= x (oBabe x:))
		(= y (oBabe y:))
		(= z (oBabe z:))
		(= priority (+ (toDewmi priority:) 1))
		(super init: &rest)
	)
)

(instance poDewmiEyes of Prop
	(properties
		cycleSpeed 4
		loop 3
	)

	(method (init)
		(= view (oBabe view:))
		(= x (oBabe x:))
		(= y (oBabe y:))
		(= z (oBabe z:))
		(super init: &rest)
		(self setPri: (+ (oBabe priority:) 5) setCycle: Blink 100)
	)
)

(instance oCheatKeyHandler of EventCode
	(properties)

	(method (handleEvent event)
		(if (not (& (event type:) evKEYBOARD))
			(return)
		)
		(if (== (event message:) JOY_RIGHT)
			(if (!= (cup x:) 196)
				(cup posn: 196 125)
			else
				(cup posn: 33 304)
			)
			(event claimed: 1)
			(return)
		else
			(event claimed:)
			(return)
		)
	)
)

(instance oDelayTimer of Timer
	(properties)

	(method (cue)
		(cond
			(local56
				(= local56 0)
				(self setReal: self 30)
			)
			((or (oBabe script:) (not (gTalkers isEmpty:)) local60)
				(self setReal: self 10)
			)
			(else
				(= local56 1)
				(if local41
					(if (< (Random 1 100) 51)
						(gMessager say: 0 0 4 (Random 1 2) self local50)
					else
						(gMessager say: 0 0 4 (Random 4 5) self local50)
					)
				else
					(gMessager say: 0 0 4 (Random 1 5) self local50)
				)
			)
		)
	)

	(method (dispose)
		(= local56 0)
		(super dispose: &rest)
	)
)

