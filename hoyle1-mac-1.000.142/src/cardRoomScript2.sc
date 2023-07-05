;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 211)
(include sci.sh)
(use Main)
(use room5)
(use countCombos)
(use Interface)

(public
	cardRoomScript2 0
)

(instance cardRoomScript2 of GO
	(properties)

	(method (doit &tmp temp0)
		(switch (gCardRoom state:)
			(11
				(if (not global186)
					(++ global186)
					((ScriptID 208) setStyle: 0) ; countCombos
					(= temp0 (ScriptID 209)) ; tally
					(proc5_1 ((gPlayerList at: 1) cardList:))
					((ScriptID 208) doit: gWL (gDeck upCardView:)) ; countCombos
					((ScriptID 209) init: 1 (gPlayerList at: 1)) ; tally
				)
			)
			(12
				(if (not global186)
					(++ global186)
					(proc0_1 11200)
					(proc0_5)
					(gWL empty: dispose:)
					(proc5_1 ((gPlayerList at: 0) cardList:))
					((ScriptID 208) doit: gWL (gDeck upCardView:)) ; countCombos
					((ScriptID 209) init: 1 (gPlayerList at: 0)) ; tally
				)
			)
			(13
				(if (not global186)
					(++ global186)
					(proc0_1 11200)
					((proc5_8) flip:)
					(proc0_5)
					(gWL empty: dispose:)
					(proc5_1 (proc5_8))
					((ScriptID 208) doit: gWL (gDeck upCardView:) 1) ; countCombos
					((ScriptID 209) init: 1 (gPlayerList at: 0) 1) ; tally
				)
			)
			(14
				(if (and ((proc5_2) whoWonGame:) (< global439 9))
					(= global305 (Print 211 0 #dispose #at 105 70)) ; "Please input to continue"
				)
				(proc0_1 11200)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if (IsObject gWL)
					(gWL empty: dispose:)
				)
				(if
					(and
						(or ((proc5_2) whoWonMatch:) ((proc5_2) whoWonGame:))
						(< global439 9)
					)
					(= global440 0)
					(global390 endHand:)
					(global390 dispose:)
					(DisposeScript 204)
				)
				(= global439 0)
				(gCardRoom cue:)
			)
			(15
				(cond
					(((proc5_2) whoWonMatch:)
						((proc5_2) reStartMatch:)
					)
					(((proc5_2) whoWonGame:)
						((proc5_2) reStartGame:)
					)
				)
				((ScriptID 209) init: 0) ; tally
				((ScriptID 208) dispose:) ; countCombos
				(CountCombinations dispose:)
				(DisposeScript 208)
				((gPlayer2 altrEgo:) clearExps: noExp:)
				(gCardRoom cue:)
			)
			(16
				((ScriptID 209) dispose:) ; tally
				(DisposeScript 209)
				(gCardRoom removeViews:)
				(proc0_5)
				(gCardRoom newDeal:)
				(= global186 0)
				(gPlayer0 pickedUpCard: 0)
				(gCardRoom cue:)
			)
			(17
				(gCardRoom cue:)
			)
			(18
				(if (== ((proc5_2) whoWonGame:) gPlayer2)
					((gPlayer2 altrEgo:) smile: say: 9)
					(gIntroSong number: ((gPlayer2 altrEgo:) song:) play:)
				else
					((gPlayer2 altrEgo:) upset: say: 10)
					(gIntroSong number: 27 play:)
				)
				(if (!= (gPlayerList at: 0) global436)
					(gPlayerList next:)
				)
				(= global436
					(if (== global436 gPlayer0) gPlayer2 else gPlayer0)
				)
				(gCardRoom cue:)
			)
			(19
				(gCardRoom cue:)
			)
			(20
				(if (== ((proc5_2) whoWonMatch:) gPlayer2)
					((gPlayer2 altrEgo:) smile: say: 11)
					(gIntroSong number: ((gPlayer2 altrEgo:) song:) play:)
				else
					((gPlayer2 altrEgo:) anger: say: 12)
					(gIntroSong number: 27 play:)
				)
				(if (!= (gPlayerList at: 0) global436)
					(gPlayerList next:)
				)
				(= global436
					(if (== global436 gPlayer0) gPlayer2 else gPlayer0)
				)
				(gCardRoom cue:)
			)
			(21
				((gPlayer2 altrEgo:) say: 13)
				(gCardRoom cue:)
			)
		)
	)

	(method (cue)
		(switch (gCardRoom state:)
			(16
				(gCardRoom state: 3)
				(= global186 0)
				(= global437 211)
				(= global438 self)
			)
			(17
				(proc0_5)
				(if (< 0 global439 9)
					((proc5_4) init: 0)
				)
				((gPlayer2 cardList:)
					eachElementDo: #faceUp 1
					eachElementDo: #update
				)
				((proc5_8) eachElementDo: #faceUp 1 eachElementDo: #update)
				(proc0_5)
				(gCardRoom state: (+ (gCardRoom state:) 1))
			)
			(18
				(gCardRoom state: 14)
			)
			(19
				(proc0_5)
				(if (< 0 global439 9)
					((proc5_4) init: 0)
				)
				((gPlayer2 cardList:)
					eachElementDo: #faceUp 1
					eachElementDo: #update
				)
				((proc5_8) eachElementDo: #faceUp 1 eachElementDo: #update)
				(proc0_5)
				(proc0_5)
				(gCardRoom state: (+ (gCardRoom state:) 1))
			)
			(21
				(gCardRoom state: 14)
			)
			(else
				(gCardRoom state: (+ (gCardRoom state:) 1))
				(= global186 0)
			)
		)
	)
)

