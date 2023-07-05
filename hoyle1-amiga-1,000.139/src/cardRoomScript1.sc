;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use room5)
(use tableau)
(use countCombos)
(use Interface)

(public
	cardRoomScript1 0
)

(instance cardRoomScript1 of GO
	(properties)

	(method (doit)
		(switch (gCardRoom state:)
			(0
				(if (not global186)
					(++ global186)
					((gPlayer2 altrEgo:) init: gPlayer2)
				)
				(if
					(and
						((gPlayer2 altrEgo:) expressions:)
						(not (((gPlayer2 altrEgo:) expressions:) size:))
						(== (gIntroSong state:) 0)
					)
					(self cue:)
				)
			)
			(3
				(if (not global186)
					(++ global186)
					(if global508
						(= global508 0)
						(if (Print 210 0 #button {Yes} 1 #button {No} 0) ; "Reset Scores?"
							((proc5_2)
								red1: 0
								red2: -1
								red3: -2
								blue1: 0
								blue2: -1
								blue3: -2
							)
							((proc5_2) update:)
							(proc0_5)
						)
					)
					((gPlayerList at: (gCardRoom currentPlayer:)) takeCard:)
				)
			)
			(4
				((gPlayerList at: (gCardRoom currentPlayer:)) addCard:)
				(if
					(not
						((gPlayerList at: (gCardRoom currentPlayer:)) playerNum:)
					)
					(gPlayer0 updateCursorCoords:)
				)
				(= global186 0)
				(self cue:)
			)
			(5
				((gPlayer2 altrEgo:) clearExps: noExp:)
				(= global434 (ScriptID 207)) ; playACard
				(= global435 (ScriptID 205)) ; passToCrib
				(proc0_8)
				(if (not global186)
					(++ global186)
					(gDeck showDeck:)
					(global435 init: 1)
					(self cue:)
				)
			)
			(6
				(if (not global186)
					(++ global186)
					((gPlayerList at: (gCardRoom currentPlayer:)) takeTurn:)
				)
			)
			(7
				((ScriptID 206) dispose:) ; cribToss
				(DisposeScript 206)
				(if (== ((gDeck upCardView:) cardRank:) 11)
					(proc5_9 1004 0 0)
					(= global305 (Print global199 #dispose))
					((proc5_2) movePeg: (gPlayerList at: 0) 2)
				else
					(self cue:)
				)
			)
			(8
				(if (not global440)
					(= global440 1)
					(global435 dispose:)
					(DisposeScript 205)
					((ScriptID 208) dispose:) ; countCombos
					(CountCombinations dispose:)
					(DisposeScript 208)
					(= global390 ((ScriptID 204))) ; tableau
					(global390 init:)
					((proc5_4) init: 1)
					(proc0_5)
				)
				(if
					(and
						(== ((global390) count:) 31)
						(!= ((global390) size:) 8)
					)
					((global390) count: 0 go: 0 playerWhoGaveGo: 0 dim:)
				)
				(cond
					(
						(and
							(not ((gPlayer0 cardList:) size:))
							(not ((gPlayer2 cardList:) size:))
						)
						(= global181 1)
						(self cue:)
					)
					((not global186)
						(++ global186)
						((gPlayerList at: (gCardRoom currentPlayer:)) takeTurn:)
					)
				)
			)
			(9
				(proc0_1 (* global407 12))
				((global390) adjustForCount:)
				((proc5_4) init: 0)
				(gCardRoom cue:)
			)
			(10
				((global390) adjustForCountPart2:)
				(gCardRoom cue:)
			)
		)
	)

	(method (cue &tmp temp0)
		(switch (gCardRoom state:)
			(3
				(gCardRoom state: (+ (gCardRoom state:) 1))
				(gPlayer2 opponentLowest: 1)
			)
			(4
				(gCardRoom currentPlayer: (+ (gCardRoom currentPlayer:) 1))
				(if (> (gCardRoom currentPlayer:) 1)
					(gCardRoom currentPlayer: 0)
				)
				(if (== (++ global175) (* global174 (gCardRoom numPlayers:)))
					(gCardRoom state: (+ (gCardRoom state:) 1))
				else
					(gCardRoom state: 3)
				)
			)
			(5
				(gCardRoom state: (+ (gCardRoom state:) 1))
				(= global186 0)
				(= global180 1)
			)
			(6
				(= global186 0)
				(if global179
					(= global179 0)
				else
					(if (== ((proc5_8) size:) 4)
						(gCardRoom state: (+ (gCardRoom state:) 1))
						(gDeck setUpCardView:)
						(= global180 1)
						(global434 init: 3)
						(gPlayer0 pickedUpCard: 10)
					)
					(gCardRoom currentPlayer: (+ (gCardRoom currentPlayer:) 1))
					(if (> (gCardRoom currentPlayer:) 1)
						(gCardRoom currentPlayer: 0)
					)
					(if ((gPlayerList at: (gCardRoom currentPlayer:)) playerNum:)
						(= global180 0)
					else
						(gPlayer0 input: 0)
						(= global180 1)
					)
				)
			)
			(7
				(gCardRoom state: (+ (gCardRoom state:) 1))
				(= global186 0)
				((gPlayer2 altrEgo:) clearExps: noExp:)
			)
			(8
				(= global186 0)
				(cond
					(global181
						(= global181 0)
						((gPlayer2 altrEgo:) clearExps: noExp:)
						(= global440 0)
						(gCardRoom state: (+ (gCardRoom state:) 1))
					)
					(global179
						(= global179 0)
					)
					(else
						(if
							(and
								(== ((global390) size:) 8)
								((proc5_2) isNotPegging:)
							)
							(global434 init: 0)
							(= global440 0)
							(gCardRoom state: (+ (gCardRoom state:) 1))
						)
						(gCardRoom
							currentPlayer: (+ (gCardRoom currentPlayer:) 1)
						)
						(if (> (gCardRoom currentPlayer:) 1)
							(gCardRoom currentPlayer: 0)
						)
						(if
							((gPlayerList at: (gCardRoom currentPlayer:))
								playerNum:
							)
							(= global180 0)
						else
							(gPlayer0 input: 0)
							(= global180 1)
						)
					)
				)
				(if global437
					(global434 dispose:)
				)
			)
			(10
				((gPlayer2 altrEgo:) clearExps: noExp:)
				(gCardRoom state: (+ (gCardRoom state:) 1))
				(= global186 0)
				(global390 endHand:)
				(global390 dispose:)
				(Tableau dispose:)
				(DisposeScript 204)
				(DisposeScript 207)
				((gPlayer2 altrEgo:) clearExps: noExp:)
				(= global437 210)
				(= global438 self)
				(= temp0 (gPlayer0 cardList:))
				(global517
					delete:
						(temp0 at: 0)
						(temp0 at: 1)
						(temp0 at: 2)
						(temp0 at: 3)
				)
			)
			(else
				(gCardRoom state: (+ (gCardRoom state:) 1))
				(= global186 0)
			)
		)
	)
)

