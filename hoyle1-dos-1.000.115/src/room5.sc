;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use C)
(use CursorCoords)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	room5 0
	proc5_1 1
	proc5_2 2
	proc5_3 3
	proc5_4 4
	proc5_5 5
	proc5_7 7
	proc5_8 8
	proc5_9 9
)

(local
	[local0 21]
	local21
	[local22 124] = [162 157 152 142 139 136 133 130 125 122 119 116 113 108 105 102 99 96 91 88 85 82 79 74 71 68 65 62 57 54 51 48 45 40 37 34 31 28 277 1297 2317 3595 5131 6923 8459 9741 10769 11797 12060 12063 12066 12069 12072 12077 12080 12083 12086 12089 12094 12097 12100 12103 12106 12111 12114 12117 12120 12123 12128 12131 12134 12137 12140 12145 12148 12151 12154 12157 12162 12165 12168 12171 12174 12179 12183 12187 11168 9890 7586 6047 5275 5271 5267 5262 5259 5256 5253 5250 5245 5242 5239 5236 5233 5228 5225 5222 5219 5216 5211 5208 5205 5202 5199 5194 5191 5188 5185 5182 5177 5174 5171 5168 5165 5919]
	[local146 124] = [1954 1949 1944 1934 1931 1928 1925 1922 1917 1914 1911 1908 1905 1900 1897 1894 1891 1888 1883 1880 1877 1874 1871 1866 1863 1860 1857 1854 1849 1846 1843 1840 1837 1832 1829 1826 1823 1820 2071 2580 3345 4368 5392 6672 7696 8721 9236 10007 10268 10271 10274 10277 10280 10285 10288 10291 10294 10297 10302 10305 10308 10311 10314 10319 10322 10325 10328 10331 10336 10339 10342 10345 10348 10353 10356 10359 10362 10365 10370 10373 10376 10379 10382 10387 10390 10393 10140 9373 8093 7324 7065 7062 7059 7054 7051 7048 7045 7042 7037 7034 7031 7028 7025 7020 7017 7014 7011 7008 7003 7000 6997 6994 6991 6986 6983 6980 6977 6974 6969 6966 6963 6960 6957 5919]
)

(procedure (proc5_4)
	(return countObj)
)

(procedure (proc5_2)
	(return cribbageBoard)
)

(procedure (proc5_8)
	(return crib)
)

(procedure (proc5_3)
	(return cardToss)
)

(procedure (proc5_5)
	(return gTheCardToss)
)

(procedure (proc5_7 param1 param2 param3 param4)
	(return
		(and
			(<= param1 (global321 x:) param2)
			(<= param3 (global321 y:) param4)
		)
	)
)

(procedure (proc5_1 param1 &tmp temp0 temp1)
	((= gWL (WL new:)) add:)
	(for ((= temp1 1)) (< temp1 14) ((++ temp1))
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(if (== ((param1 at: temp0) cardRank:) temp1)
				(gWL add: (param1 at: temp0))
			)
		)
	)
)

(procedure (proc5_9 param1 param2 param3 &tmp [temp0 40])
	(switch param1
		(1000
			(= global199 (Format @global520 5 0)) ; "Fifteen : 2"
		)
		(1001
			(= global199 (Format @global520 5 1)) ; "Thirty One : 2"
		)
		(1002
			(= global199 (Format @global520 5 2)) ; "31 One After Go : 1"
		)
		(1003
			(= global199 (Format @global520 5 3)) ; "GO : 1"
		)
		(1004
			(= global199 (Format @global520 5 4)) ; "Starter is Nobs : 2"
		)
		(1005
			(= global199 (Format @global520 5 5)) ; "Last Card : 1"
		)
		(1006
			(= global199 (Format @global520 5 6)) ; "Pair : 2"
		)
		(1007
			(= global199 (Format @global520 5 7)) ; "Pair Royal : 6"
		)
		(1008
			(= global199 (Format @global520 5 8)) ; "Double Royal : 12"
		)
		(1009
			(= global199 (Format @global520 5 9)) ; "Run : 3"
		)
		(1010
			(= global199 (Format @global520 5 10)) ; "Run : 4"
		)
		(1011
			(= global199 (Format @global520 5 11)) ; "Run : 5"
		)
		(1012
			(= global199 (Format @global520 5 12)) ; "Run : 6"
		)
		(1013
			(= global199 (Format @global520 5 13)) ; "Run : 7"
		)
		(1017
			(= global199 (Format @global520 5 14)) ; "GO."
		)
	)
	(if (and (>= argc 2) param2)
		(switch param2
			(1006
				(StrCat global199 (Format @temp0 {\nPair : 2}))
			)
			(1007
				(StrCat global199 (Format @temp0 {\nPair Royal : 6}))
			)
			(1008
				(StrCat global199 (Format @temp0 {\nDouble Royal : 12}))
			)
			(1009
				(StrCat global199 (Format @temp0 {\nRun : 3}))
			)
			(1010
				(StrCat global199 (Format @temp0 {\nRun : 4}))
			)
			(1011
				(StrCat global199 (Format @temp0 {\nRun : 5}))
			)
			(1012
				(StrCat global199 (Format @temp0 {\nRun : 6}))
			)
			(1013
				(StrCat global199 (Format @temp0 {\nRun : 7}))
			)
		)
	)
	(if (and (== argc 3) param3)
		(StrCat global199 (Format @temp0 {\nLast Card : 1}))
	)
)

(class CribbageBoard of Obj
	(properties
		view 167
		whoWonGame 0
		whoWonMatch 0
		redGamesWon -2
		blueGamesWon -2
		red1 0
		red2 -1
		red3 -2
		blue1 0
		blue2 -1
		blue3 -2
		redPeg1 0
		redPeg2 0
		redPeg3 0
		bluePeg1 0
		bluePeg2 0
		bluePeg3 0
		shouldMovePegs 0
		track 0
		holesLeftToMove 0
		shouldWait 0
	)

	(method (isNotPegging)
		(return (not holesLeftToMove))
	)

	(method (movePointsPeg)
		(Wait global407)
		(gSndEffect number: (if (== track gPlayer0) 50 else 51) playMaybe:)
		(if (== track gPlayer0)
			(++ red1)
		else
			(++ blue1)
		)
		(self update:)
		(-- holesLeftToMove)
		(cond
			((or (== red1 121) (== blue1 121))
				(= whoWonGame track)
				(= holesLeftToMove 0)
				(cribbageBoard moveGamePeg:)
			)
			((self isNotPegging:)
				(self endPegging:)
			)
		)
	)

	(method (moveGamesPeg)
		(Wait (* global407 2))
		(gSndEffect number: (if (== track gPlayer0) 50 else 51) playMaybe:)
		(switch track
			(player0
				(++ red3)
				(if (< red3 1)
					(= red3 1)
				)
			)
			(else
				(++ blue3)
				(if (< blue3 1)
					(= blue3 1)
				)
			)
		)
		(self update:)
		(-- holesLeftToMove)
		(cond
			((or (== red3 7) (== blue3 7))
				(= whoWonMatch track)
				(self endPegging:)
			)
			((self isNotPegging:)
				(self endPegging:)
			)
		)
	)

	(method (movePeg2ToPeg1)
		(switch track
			(player0
				(= red2 red1)
			)
			(else
				(= blue2 blue1)
			)
		)
		(self update:)
	)

	(method (endPegging)
		(= holesLeftToMove (= shouldMovePegs 0))
		(proc0_5)
		(if
			(and
				shouldWait
				(not (global300 windowUp:))
				(< (cardRoom state:) 10)
			)
			(if (< (= global772 (* global407 25)) 60)
				(= global772 60)
			)
			(proc0_1 global772)
		)
		(if (and gModelessDialog (not (global300 windowUp:)))
			(gModelessDialog dispose:)
			(proc0_5)
		)
		(if (or whoWonGame whoWonMatch)
			(= global439 (gCardRoom state:))
		)
		(if whoWonGame
			(cardRoom state: 17)
		)
		(if whoWonMatch
			(cardRoom state: 19)
		)
		(if (or whoWonGame whoWonMatch)
			(if (< global439 9)
				(global434 init: 0)
				(proc0_5)
				(global434 dispose:)
				(DisposeScript 207)
				((gPlayer2 altrEgo:) clearExps: noExp:)
				(= global437 210)
				(= global438 (ScriptID 210)) ; cardRoomScript1
			)
			(return)
		)
		(cardRoom cue:)
	)

	(method (doit)
		(if (self isNotPegging:)
			(= shouldMovePegs 0)
		)
		(switch shouldMovePegs
			(1
				(self movePointsPeg:)
			)
			(2
				(self moveGamesPeg:)
			)
		)
	)

	(method (reStartMatch)
		(= whoWonMatch 0)
		(= blue3 (= red3 -2))
		(self reStartGame:)
	)

	(method (reStartGame)
		(= red1 (= whoWonGame 0))
		(= red2 -1)
		(= blue1 0)
		(= blue2 -1)
		(self update:)
	)

	(method (update &tmp temp0)
		(= temp0 (if (or (== (Graph grGET_COLOURS) 2) (== (Graph grGET_COLOURS) 4)) 1 else 0))
		(redPeg1
			view: view
			posn: (self calcCoord: red1 1 1) (self calcCoord: red1 1 0)
			cel: (if temp0 1 else 0)
			setPri: 11
			ignoreActors:
			init:
		)
		(redPeg2
			view: view
			posn: (self calcCoord: red2 1 1) (self calcCoord: red2 1 0)
			cel: (if temp0 1 else 0)
			setPri: 11
			ignoreActors:
			init:
		)
		(redPeg3
			view: view
			posn:
				(if (== red3 -2)
					248
				else
					(+ 241 (* red3 7))
				)
				(if (== red3 -2) 162 else 172)
			cel: (if temp0 1 else 0)
			setPri: 11
			ignoreActors:
			init:
		)
		(bluePeg1
			view: view
			posn: (self calcCoord: blue1 0 1) (self calcCoord: blue1 0 0)
			cel: (if temp0 1 else 0)
			setLoop: 1
			setPri: 11
			ignoreActors:
			init:
		)
		(bluePeg2
			view: view
			posn: (self calcCoord: blue2 0 1) (self calcCoord: blue2 0 0)
			cel: (if temp0 1 else 0)
			setLoop: 1
			setPri: 11
			ignoreActors:
			init:
		)
		(bluePeg3
			view: view
			posn:
				(if (== blue3 -2)
					255
				else
					(+ 241 (* blue3 7))
				)
				(if (== blue3 -2) 162 else 177)
			cel: (if temp0 1 else 0)
			setLoop: 1
			setPri: 11
			ignoreActors:
			init:
		)
	)

	(method (init)
		(= redPeg1 redView1)
		(= redPeg2 redView2)
		(= redPeg3 redView3)
		(= bluePeg1 blueView1)
		(= bluePeg2 blueView2)
		(= bluePeg3 blueView3)
		(self update:)
	)

	(method (calcCoord param1 param2 param3 &tmp temp0)
		(= temp0
			(if param2 [local22 (+ param1 2)] else [local146 (+ param1 2)])
		)
		(return
			(if param3
				(+ (/ temp0 256) 248)
			else
				(mod temp0 256)
			)
		)
	)

	(method (movePeg param1 param2 param3)
		(if (not param2)
			(cardRoom cue:)
			(return)
		)
		(= shouldMovePegs 1)
		(= track param1)
		(= holesLeftToMove param2)
		(= shouldWait (if (and (== argc 3) (not param3)) 0 else 1))
		(self movePeg2ToPeg1:)
	)

	(method (moveGamePeg)
		(= holesLeftToMove 1)
		(if (or (> (- red1 blue1) 30) (> (- blue1 red1) 30))
			(++ holesLeftToMove)
		)
		(if (or (> (- red1 blue1) 60) (> (- blue1 red1) 60))
			(+= holesLeftToMove 2)
		)
		(= shouldMovePegs 2)
	)
)

(class Crib of WL
	(properties
		x 20
		y 65
	)

	(method (init)
		(super add:)
	)

	(method (endHand &tmp temp0)
		(self addAllToWorkingDeck:)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			((self at: temp0) erase: 1 faceUp: 0 loop: 0 update:)
		)
		(self empty:)
	)

	(method (flip)
		(self eachElementDo: #faceUp 1 eachElementDo: #update)
	)

	(method (erase)
		(self eachElementDo: #erase 1 eachElementDo: #update)
	)

	(method (nextX)
		(return (+ x (* size 7)))
	)
)

(class Deck of CardDeck
	(properties
		beginFlag 1
		putX 0
		putY 0
		putX1 27
		putY1 6
		putX0 27
		putY0 135
		upCardView 0
	)

	(method (reShuffle)
		(workingDeck eachElementDo: #erase 0)
		(super reShuffle:)
	)

	(method (showDeck)
		(= putX (if (== (gPlayerList at: 0) player0) putX0 else putX1))
		(= putY (if (== (gPlayerList at: 0) player0) putY0 else putY1))
		(proc0_2 172 0 0 putX putY)
		(proc0_2 (+ 290 global507) 0 0 putX putY)
		(proc0_5)
	)

	(method (init &tmp temp0 [temp1 57])
		(super init:)
		(for ((= temp0 4)) (< temp0 56) ((++ temp0))
			(= [temp1 temp0] (Clone C))
			([temp1 temp0] cardRank: (/ temp0 4) cardSuit: (mod temp0 4))
		)
		(for ((= temp0 4)) (< temp0 56) ((++ temp0))
			(theDeck add: [temp1 temp0])
		)
		(self shuffle:)
	)

	(method (resetDealXY)
		(= dealX putX)
		(= dealY putY)
	)

	(method (setUpCardView)
		(= upCardView (theDeck at: (Random 0 (- (theDeck size:) 1))))
		(upCardView faceUp: 1 x: putX y: putY update:)
		(proc0_2
			(+ 152 (upCardView cardSuit:))
			0
			(upCardView cardRank:)
			putX
			putY
		)
		(proc0_5)
		(proc0_1 (* global407 6))
	)

	(method (endHand)
		(upCardView loop: 0)
		(theDeck addAllToWorkingDeck: empty:)
		(proc0_2 172 0 5 (+ putX 6) (+ putY 6))
	)
)

(class CribbageHumanPlayer of HumanPlayer
	(properties
		points 0
	)

	(method (init)
		(super init:)
		((= cardList (CardList new:)) add:)
		((= tempList (WL new:)) add:)
	)

	(method (endHand)
		(cardList
			addAllToWorkingDeck:
			eachElementDo: #erase 1
			eachElementDo: #faceUp 0
			eachElementDo: #loop 0
			eachElementDo: #update
			empty:
		)
	)

	(method (lowestRank &tmp temp0 temp1)
		(= temp0 0)
		(= temp1 14)
		(while (< temp0 (cardList size:))
			(if (< ((cardList at: temp0) cardRank:) temp1)
				(= temp1 ((cardList at: temp0) cardRank:))
			)
			(++ temp0)
		)
		(if (> temp1 10)
			(= temp1 10)
		)
		(return temp1)
	)

	(method (playCard)
		(= global173 (self findADimCard:))
		(global517 delete: global173)
		(= global180 0)
		(global173 erase: 1)
		(self removeCard:)
		(= pickedUpCard 10)
		(gSndEffect number: (proc0_6 playCardSound) playMaybe:)
		(cardToss
			init:
				(global173 x:)
				(global173 y:)
				(global390 nextX:)
				(global390 nextY: self)
				[global417 (- global406 1)]
				global390
				1
		)
	)

	(method (takeTurn)
		(= global180 1)
		(= global184 playerNum)
		(if (== (cardRoom state:) 8)
			(if (!= gTheCursor 999)
				(gGame setCursor: 999)
			)
			(if (cardList size:)
				(if (> (+ (global390 count:) (self lowestRank:)) 31)
					(player2 opponentLowest: (- 32 (global390 count:)))
					(global434 init: 4)
					(if (== (global390 playerWhoGaveGo:) self)
						(cardRoom cue:)
						(return)
					)
				else
					(global434 init: 3)
				)
			else
				(global434 init: 0)
				(if (== (global390 playerWhoGaveGo:) player2)
					(global390 giveAGo: self)
				)
				(cardRoom cue:)
				(return)
			)
		)
		(if (and input global180)
			(proc0_8)
			(= global184 playerNum)
			(self handleInput:)
		else
			(if (gGoneTimer done:)
				(self playerSeemsToBeGone:)
			)
			(= global179 1)
			(self cue:)
		)
	)

	(method (findADimCard param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
			(if ((cardList at: temp0) loop:)
				(return
					(if (and argc (== param1 1))
						temp0
					else
						(cardList at: temp0)
					)
				)
			)
		)
		(return -2)
	)

	(method (howManyCardsDim &tmp temp0 temp1)
		(for ((= temp0 (= temp1 0))) (< temp0 (cardList size:)) ((++ temp0))
			(+= temp1 ((cardList at: temp0) loop:))
		)
		(return temp1)
	)

	(method (takeCard)
		(= global184 playerNum)
		(self setBase:)
		(= global176 dealFaceUp)
		(deck getCard:)
		(global173 faceUp: dealFaceUp)
		(gSndEffect number: (proc0_6 takeCardSound) playMaybe:)
		(gTheCardToss
			init: (deck dealX:) (deck dealY:) bX bY [global408 (- global405 1)]
		)
	)

	(method (findRect)
		(= place -1)
		(super findRect:)
	)

	(method (handleInput &tmp temp0)
		(if (not (cardList size:))
			(cardRoom cue:)
			(return)
		)
		(= global179 1)
		(= place2 place)
		(self findRect:)
		(if (== global854 20992)
			(if
				(or
					(not (self howManyCardsDim:))
					(== (self howManyCardsDim:) 2)
				)
				(= global854 13)
			)
			(if
				(and
					(<= (cardList size:) 4)
					(== (self findADimCard: 1) (- place 1))
				)
				(= global854 13)
				(global434 doit:)
				(= input 0)
				(gCardRoom cue:)
				(return)
			)
		)
		(if (or (== input 2) (== global854 13) (== global854 20992))
			(if (== global854 13)
				(= place2 place)
			)
			(if (and (> place 0) (<= place (cardList size:)) (== place2 place))
				(cond
					(((cardList at: (- place 1)) loop:)
						(-- pickedUpCard)
						(self invertCard: (- place 1))
						(if (== (self howManyCardsDim:) 1)
							(= place (= place2 (self findADimCard: 1)))
							(++ place)
							(++ place2)
						)
					)
					((or (<= pickedUpCard 1) (== pickedUpCard 10))
						(++ pickedUpCard)
						(self invertCard: (- place 1))
					)
					((== pickedUpCard 2)
						(gSndEffect number: 36 play:)
						((player2 altrEgo:) say: 5)
						(if (and (!= input 1) (self dimCardIsAt:))
							(= place (= place2 (self dimCardIsAt:)))
						)
					)
					(else
						(self
							invertCard: (self findADimCard: 1)
							invertCard: (- place 1)
						)
					)
				)
			else
				(if (and (== global854 20992) (== (self howManyCardsDim:) 1))
					(= place2 (+ (self findADimCard: 1) 1))
				)
				(if
					(or
						(and
							(!= global855 4)
							(<= 0 place (cardList size:))
							(>= (cardList size:) place2 1)
						)
						(and
							(== global854 20992)
							(== (self howManyCardsDim:) 1)
							(<= 0 place (cardList size:))
							(>= (cardList size:) place2 1)
						)
					)
					(self adjustLists: place place2 rePosition:)
					(if (self howManyCardsDim:)
						(= place (= place2 (self findADimCard: 1)))
						(++ place)
						(++ place2)
					)
				)
			)
		)
		(= input 0)
		(gCardRoom cue:)
	)

	(method (dimCardIsAt &tmp temp0)
		(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
			(if ((cardList at: temp0) loop:)
				(return (+ temp0 1))
			)
		)
		(return 0)
	)
)

(instance room5 of Rm
	(properties)

	(method (init)
		(cardRoom init:)
	)

	(method (doit)
		(cribbageBoard doit:)
		(if
			(and
				(not (global300 windowUp:))
				(not (cribbageBoard holesLeftToMove:))
			)
			(if (and global440 (== (cardRoom state:) 8))
				(countObj doit:)
			)
			(cardRoom doit:)
			(if (<= 6 (cardRoom state:) 7)
				(global435 doit:)
			)
			(gGoneTimer doit:)
		)
		(if (<= 11 (cardRoom state:) 14)
			((ScriptID 209) doit:) ; tally
		)
		((player2 altrEgo:) doit:)
		(global300 doit:)
	)

	(method (handleEvent event param2 &tmp temp0)
		(if (== argc 2)
			(switch param2
				(1281
					(gGame setCursor: 997)
					((ScriptID 885) doit:) ; cribbageRules
					(DisposeScript 885)
					(event claimed: 1)
					(return)
				)
				(1282
					(gGame setCursor: 997)
					(MenuBar doit: 4 global433)
					(= global433 global429)
					(SetMenu
						1282
						110
						(Format @local0 {Count Speed is %d} global433)
					)
					(return)
				)
			)
		else
			(if
				(and
					(not (global300 windowUp:))
					(not (cribbageBoard holesLeftToMove:))
				)
				(if (== (cardRoom state:) 8)
					(global434 doit: event)
				)
				(if (<= 6 (cardRoom state:) 7)
					(global435 doit: event)
				)
			)
			(if (not (event claimed:))
				(player0 handleEvent: event)
			)
		)
	)

	(method (dispose)
		(if (global300 windowUp:)
			(global300 dispose:)
			(proc0_5)
		)
		(super dispose:)
	)
)

(instance cardRoom of CardRoom
	(properties
		picture 12
		numPlayers 2
	)

	(method (init)
		(AddMenu { Cribbage } {Rules `^r:Count Speed is 5 `^c})
		(SetMenu 1282 110 (Format @local0 {Count Speed is %d} global433))
		(MenuBar draw:)
		(= global517 inList)
		(= gPlayer0 player0)
		(= gPlayer2 player2)
		(= gDeck deck)
		(= gCardRoom cardRoom)
		(= global197 endThrow)
		(if (or (== (Graph grGET_COLOURS) 4) (== (Graph grGET_COLOURS) 2))
			(= picture 13)
		)
		(super init:)
		(= global775 ((player2 altrEgo:) cribbageSkill:))
		((ScriptID 212) init:) ; cardRoomInit
	)

	(method (doit)
		(if global437
			(global438 dispose:)
			(DisposeScript global437)
			(= global438 (= global437 0))
		)
		(if state
			(if (<= state 10)
				((ScriptID 210) doit: state) ; cardRoomScript1
			else
				((ScriptID 211) doit: state) ; cardRoomScript2
			)
		else
			((ScriptID 212) doit:) ; cardRoomInit
		)
	)

	(method (cue)
		(if state
			(if (<= state 10)
				((ScriptID 210) cue: state) ; cardRoomScript1
			else
				((ScriptID 211) cue: state) ; cardRoomScript2
			)
		else
			(= global186 0)
			(= state 3)
			((ScriptID 212) dispose:) ; cardRoomInit
			(DisposeScript 212)
		)
	)

	(method (removeViews)
		(crib endHand:)
		(deck endHand:)
		(player0 endHand:)
		(player2 endHand:)
	)

	(method (newDeal)
		(deck reShuffle:)
		(gPlayerList next:)
		(self newDeal2:)
	)
)

(instance endThrow of EndThrow
	(properties)
)

(instance deck of Deck
	(properties
		origPutX 1
		origPutY 0
		putY 27
		cursorZ 6
	)
)

(instance cribbageBoard of CribbageBoard
	(properties)
)

(instance cribbageEndThrow of EndThrow
	(properties)

	(method (cue)
		(= global182 (- (client x:) 17))
		(= global183 (- (client y:) 21))
		(client dispose:)
		(global173 x: global182 y: global183)
		(local21 cue:)
	)
)

(instance cardToss of Act
	(properties)

	(method (init param1 param2 param3 param4 param5 param6 param7)
		(= global432 param7)
		(= local21 param6)
		(self
			view: (+ 290 global507)
			setLoop: 8
			setCel: 3
			setCycle: Fwd
			setStep: param5 param5
			setPri: 15
			posn: (+ param1 17) (+ param2 21)
			setScript: cribbageEndThrow
			setMotion: MoveTo (+ param3 17) (+ param4 21) self
		)
		(super init:)
	)
)

(instance crib of Crib
	(properties)
)

(instance countObj of GO
	(properties
		x 15
		y 114
		view 168
	)

	(method (init param1)
		(if (!= param1 onOrOff)
			(= onOrOff param1)
			(= status0 0)
			(proc0_2 view 0 onOrOff x y)
		)
	)

	(method (doit)
		(if (and onOrOff (!= status0 (global390 count:)))
			(= status0 (global390 count:))
			(proc0_2
				view
				1
				(if (< status0 10)
					10
				else
					(/ status0 10)
				)
				(+ x 45)
				(+ y 2)
			)
			(proc0_2 view 1 (mod status0 10) (+ x 53) (+ y 2))
		)
	)
)

(instance player0 of CribbageHumanPlayer
	(properties
		dealFromX 130
		baseX 150
	)
)

(instance player2 of CribbageComputerPlayer
	(properties
		playerNum 2
		dealFromX 130
		dealFromY -20
		overlapY 0
		baseX 150
		baseY 5
		speakFrom 1
		altrEgo 11
		altrEgoX 213
		altrEgoY 35
	)
)

(instance redView1 of View
	(properties)
)

(instance redView2 of View
	(properties)
)

(instance redView3 of View
	(properties)
)

(instance blueView1 of View
	(properties)
)

(instance blueView2 of View
	(properties)
)

(instance blueView3 of View
	(properties)
)

(instance inList of InputList
	(properties)
)

