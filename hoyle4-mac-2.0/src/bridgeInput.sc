;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 701)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Piles)
(use BScore)
(use Bid)
(use GameControls)
(use System)

(public
	bridgeInput 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(double
		active: 1
		cel:
			(switch global424
				(-2 3)
				(-1 2)
				(50 4)
				(99 5)
			)
	)
	(if (== global428 ((Dealer curPlayer:) partner:))
		(double cel: 3)
	)
	(if (and (== global424 50) (== global426 ((Dealer curPlayer:) partner:)))
		(double cel: 5)
	)
	(if (or (== (double cel:) 3) (== (double cel:) 5))
		(double active: 0)
	)
	(double returnValue: (if (== (double cel:) 2) 50 else 99))
	((= gGameControls bridgeInputControls)
		window: bridgeInputWindow
		helpIconItem: 0
		okIconItem: 0
		curIcon: (if (not (HaveMouse)) passButton else 0)
	)
	(if
		(or
			(== ((Dealer curPlayer:) location:) 1)
			(== ((Dealer curPlayer:) location:) 2)
		)
		(passButton nsLeft: 13 nsTop: 112)
		(double nsLeft: 13 nsTop: 129)
	else
		(passButton nsLeft: 13 nsTop: 43)
		(double nsLeft: 13 nsTop: 60)
	)
	(if (< global427 1)
		(gGameControls
			add: (oneClub theObj: oneClub selector: #doit init: 0 yourself:)
		)
	)
	(if (< global427 2)
		(gGameControls
			add:
				(oneDiamond
					theObj: oneDiamond
					selector: #doit
					init: 2
					yourself:
				)
		)
	)
	(if (< global427 3)
		(gGameControls
			add: (oneHeart theObj: oneHeart selector: #doit init: 4 yourself:)
		)
	)
	(if (< global427 4)
		(gGameControls
			add: (oneSpade theObj: oneSpade selector: #doit init: 6 yourself:)
		)
	)
	(if (< global427 5)
		(gGameControls add: (oneNT theObj: oneNT selector: #doit init: 8 yourself:))
	)
	(if (< global427 6)
		(gGameControls
			add: (twoClub theObj: twoClub selector: #doit init: 0 yourself:)
		)
	)
	(if (< global427 7)
		(gGameControls
			add:
				(twoDiamond
					theObj: twoDiamond
					selector: #doit
					init: 2
					yourself:
				)
		)
	)
	(if (< global427 8)
		(gGameControls
			add: (twoHeart theObj: twoHeart selector: #doit init: 4 yourself:)
		)
	)
	(if (< global427 9)
		(gGameControls
			add: (twoSpade theObj: twoSpade selector: #doit init: 6 yourself:)
		)
	)
	(if (< global427 10)
		(gGameControls add: (twoNT theObj: twoNT selector: #doit init: 8 yourself:))
	)
	(if (< global427 11)
		(gGameControls
			add: (threeClub theObj: threeClub selector: #doit init: 0 yourself:)
		)
	)
	(if (< global427 12)
		(gGameControls
			add:
				(threeDiamond
					theObj: threeDiamond
					selector: #doit
					init: 2
					yourself:
				)
		)
	)
	(if (< global427 13)
		(gGameControls
			add:
				(threeHeart
					theObj: threeHeart
					selector: #doit
					init: 4
					yourself:
				)
		)
	)
	(if (< global427 14)
		(gGameControls
			add:
				(threeSpade
					theObj: threeSpade
					selector: #doit
					init: 6
					yourself:
				)
		)
	)
	(if (< global427 15)
		(gGameControls
			add: (threeNT theObj: threeNT selector: #doit init: 8 yourself:)
		)
	)
	(if (< global427 16)
		(gGameControls
			add: (fourClub theObj: fourClub selector: #doit init: 0 yourself:)
		)
	)
	(if (< global427 17)
		(gGameControls
			add:
				(fourDiamond
					theObj: fourDiamond
					selector: #doit
					init: 2
					yourself:
				)
		)
	)
	(if (< global427 18)
		(gGameControls
			add: (fourHeart theObj: fourHeart selector: #doit init: 4 yourself:)
		)
	)
	(if (< global427 19)
		(gGameControls
			add: (fourSpade theObj: fourSpade selector: #doit init: 6 yourself:)
		)
	)
	(if (< global427 20)
		(gGameControls
			add: (fourNT theObj: fourNT selector: #doit init: 8 yourself:)
		)
	)
	(if (< global427 21)
		(gGameControls
			add: (fiveClub theObj: fiveClub selector: #doit init: 0 yourself:)
		)
	)
	(if (< global427 22)
		(gGameControls
			add:
				(fiveDiamond
					theObj: fiveDiamond
					selector: #doit
					init: 2
					yourself:
				)
		)
	)
	(if (< global427 23)
		(gGameControls
			add: (fiveHeart theObj: fiveHeart selector: #doit init: 4 yourself:)
		)
	)
	(if (< global427 24)
		(gGameControls
			add: (fiveSpade theObj: fiveSpade selector: #doit init: 6 yourself:)
		)
	)
	(if (< global427 25)
		(gGameControls
			add: (fiveNT theObj: fiveNT selector: #doit init: 8 yourself:)
		)
	)
	(if (< global427 26)
		(gGameControls
			add: (sixClub theObj: sixClub selector: #doit init: 0 yourself:)
		)
	)
	(if (< global427 27)
		(gGameControls
			add:
				(sixDiamond
					theObj: sixDiamond
					selector: #doit
					init: 2
					yourself:
				)
		)
	)
	(if (< global427 28)
		(gGameControls
			add: (sixHeart theObj: sixHeart selector: #doit init: 4 yourself:)
		)
	)
	(if (< global427 39)
		(gGameControls
			add: (sixSpade theObj: sixSpade selector: #doit init: 6 yourself:)
		)
	)
	(if (< global427 30)
		(gGameControls add: (sixNT theObj: sixNT selector: #doit init: 8 yourself:))
	)
	(if (< global427 31)
		(gGameControls
			add: (sevenClub theObj: sevenClub selector: #doit init: 0 yourself:)
		)
	)
	(if (< global427 32)
		(gGameControls
			add:
				(sevenDiamond
					theObj: sevenDiamond
					selector: #doit
					init: 2
					yourself:
				)
		)
	)
	(if (< global427 33)
		(gGameControls
			add:
				(sevenHeart
					theObj: sevenHeart
					selector: #doit
					init: 4
					yourself:
				)
		)
	)
	(if (< global427 34)
		(gGameControls
			add:
				(sevenSpade
					theObj: sevenSpade
					selector: #doit
					init: 6
					yourself:
				)
		)
	)
	(if (< global427 35)
		(gGameControls
			add: (sevenNT theObj: sevenNT selector: #doit init: 8 yourself:)
		)
	)
	(gGameControls add: (passButton theObj: passButton selector: #doit yourself:))
	(if (double active:)
		(gGameControls add: (double theObj: double selector: #doit yourself:))
	)
	(if
		(or
			(and
				(== (BidBox rowsUsed:) 5)
				(!= ((Dealer curPlayer:) location:) 4)
			)
			(>= (BidBox rowsUsed:) 6)
		)
		(if
			(or
				(== ((Dealer curPlayer:) location:) 1)
				(== ((Dealer curPlayer:) location:) 2)
			)
			(scrollUp nsTop: 0 nsLeft: 244)
			(scrollDown nsTop: 7 nsLeft: 244)
		else
			(scrollUp nsTop: 81 nsLeft: 99)
			(scrollDown nsTop: 88 nsLeft: 99)
		)
		(gGameControls
			add:
				(scrollUp theObj: scrollUp selector: #doit yourself:)
				(scrollDown theObj: scrollDown selector: #doit yourself:)
		)
	)
	(gGameControls show:)
	(if (not (HaveMouse))
		(gMouseCursor
			x: (+ 150 (passButton nsLeft:))
			y: (+ 11 (passButton nsTop:))
		)
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance bridgeInput of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance bridgeInputWindow of InvisibleWindow
	(properties)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if
			(or
				(== ((Dealer curPlayer:) location:) 1)
				(== ((Dealer curPlayer:) location:) 2)
			)
			(= top 40)
			(= left 4)
			(= bottom (+ top 147))
			(= right (+ left 263))
			(= local1 69)
		else
			(= top 1)
			(= left 130)
			(= bottom 99)
			(= right 310)
			(= local1 0)
		)
		(super open:)
		(DrawCel 700 0 0 0 local1 15)
		(switch (BScore gameNumber:)
			(1
				(= temp2 (BScore weGame1:))
				(= temp3 (BScore theyGame1:))
			)
			(2
				(= temp2 (BScore weGame2:))
				(= temp3 (BScore theyGame2:))
			)
			(3
				(= temp2 (BScore weGame3:))
				(= temp3 (BScore theyGame3:))
			)
		)
		(= temp4
			(if (== temp2 0)
				0
			else
				(/ temp2 10)
			)
		)
		(= temp5
			(if (== temp3 0)
				0
			else
				(/ temp3 10)
			)
		)
		(DrawCel 700 12 temp4 23 (+ 29 local1) 15)
		(DrawCel 700 12 temp5 64 (+ 29 local1) 15)
		(= temp1 0)
		(cond
			((BScore weGamesWon:)
				(= temp1 1)
				(if (BScore theyGamesWon:)
					(= temp1 3)
				)
			)
			((BScore theyGamesWon:)
				(= temp1 2)
			)
		)
		(DrawCel 700 11 temp1 34 (+ 5 local1) 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance bridgeInputControls of HoyleGameControls
	(properties)
)

(class BridgeInputItem of ControlIcon
	(properties
		view 700
		signal 387
		highlightColor -1
		returnValue 0
		active 1
		nsTop1 0
		nsTop2 0
	)

	(method (select)
		(if active
			(super select: &rest)
			(return)
		else
			0
		)
	)

	(method (init param1)
		(= cel param1)
		(if (not (= active (if (<= returnValue global427) 0 else 1)))
			(++ cel)
		)
		(if
			(or
				(== ((Dealer curPlayer:) location:) 1)
				(== ((Dealer curPlayer:) location:) 2)
			)
			(= nsTop nsTop2)
		else
			(= nsTop nsTop1)
		)
	)

	(method (doit &tmp temp0)
		(= global500 1)
		(gGameControls hide: dispose:)
		(= global500 2)
		(RedrawCast)
		(= global500 3)
		(cond
			((== returnValue 0)
				(++ global116)
			)
			((<= 1 returnValue 35)
				(= global429 (Dealer curPlayer:))
				(= global426 0)
				(= global424 -1)
				(= global427 returnValue)
				(= global116 0)
				(= global428 (Dealer curPlayer:))
			)
			((or (== returnValue 50) (== returnValue 99))
				(= global426 (Dealer curPlayer:))
				(= global428 0)
				(= global424 (if (== returnValue 50) 50 else 99))
				(= global116 0)
			)
		)
		(= global500 4)
		(= gGameControls local0)
		(= global425 returnValue)
	)
)

(instance oneClub of BridgeInputItem
	(properties
		loop 1
		nsLeft 78
		nsTop 4
		returnValue 1
		nsTop1 4
		nsTop2 73
	)
)

(instance twoClub of BridgeInputItem
	(properties
		loop 2
		nsLeft 78
		nsTop 14
		returnValue 6
		nsTop1 14
		nsTop2 83
	)
)

(instance threeClub of BridgeInputItem
	(properties
		loop 3
		nsLeft 78
		nsTop 24
		returnValue 11
		nsTop1 24
		nsTop2 93
	)
)

(instance fourClub of BridgeInputItem
	(properties
		loop 4
		nsLeft 78
		nsTop 34
		returnValue 16
		nsTop1 34
		nsTop2 103
	)
)

(instance fiveClub of BridgeInputItem
	(properties
		loop 5
		nsLeft 78
		nsTop 44
		returnValue 21
		nsTop1 44
		nsTop2 113
	)
)

(instance sixClub of BridgeInputItem
	(properties
		loop 6
		nsLeft 78
		nsTop 54
		returnValue 26
		nsTop1 54
		nsTop2 123
	)
)

(instance sevenClub of BridgeInputItem
	(properties
		loop 7
		nsLeft 78
		nsTop 64
		returnValue 31
		nsTop1 64
		nsTop2 133
	)
)

(instance oneDiamond of BridgeInputItem
	(properties
		loop 1
		nsLeft 97
		nsTop 4
		returnValue 2
		nsTop1 4
		nsTop2 73
	)
)

(instance twoDiamond of BridgeInputItem
	(properties
		loop 2
		nsLeft 97
		nsTop 14
		returnValue 7
		nsTop1 14
		nsTop2 83
	)
)

(instance threeDiamond of BridgeInputItem
	(properties
		loop 3
		nsLeft 97
		nsTop 24
		returnValue 12
		nsTop1 24
		nsTop2 93
	)
)

(instance fourDiamond of BridgeInputItem
	(properties
		loop 4
		nsLeft 97
		nsTop 34
		returnValue 17
		nsTop1 34
		nsTop2 103
	)
)

(instance fiveDiamond of BridgeInputItem
	(properties
		loop 5
		nsLeft 97
		nsTop 44
		returnValue 22
		nsTop1 44
		nsTop2 113
	)
)

(instance sixDiamond of BridgeInputItem
	(properties
		loop 6
		nsLeft 97
		nsTop 54
		returnValue 27
		nsTop1 54
		nsTop2 123
	)
)

(instance sevenDiamond of BridgeInputItem
	(properties
		loop 7
		nsLeft 97
		nsTop 64
		returnValue 32
		nsTop1 64
		nsTop2 133
	)
)

(instance oneHeart of BridgeInputItem
	(properties
		loop 1
		nsLeft 116
		nsTop 4
		returnValue 3
		nsTop1 4
		nsTop2 73
	)
)

(instance twoHeart of BridgeInputItem
	(properties
		loop 2
		nsLeft 116
		nsTop 14
		returnValue 8
		nsTop1 14
		nsTop2 83
	)
)

(instance threeHeart of BridgeInputItem
	(properties
		loop 3
		nsLeft 116
		nsTop 24
		returnValue 13
		nsTop1 24
		nsTop2 93
	)
)

(instance fourHeart of BridgeInputItem
	(properties
		loop 4
		nsLeft 116
		nsTop 34
		returnValue 18
		nsTop1 34
		nsTop2 103
	)
)

(instance fiveHeart of BridgeInputItem
	(properties
		loop 5
		nsLeft 116
		nsTop 44
		returnValue 23
		nsTop1 44
		nsTop2 113
	)
)

(instance sixHeart of BridgeInputItem
	(properties
		loop 6
		nsLeft 116
		nsTop 54
		returnValue 28
		nsTop1 54
		nsTop2 123
	)
)

(instance sevenHeart of BridgeInputItem
	(properties
		loop 7
		nsLeft 116
		nsTop 64
		returnValue 33
		nsTop1 64
		nsTop2 133
	)
)

(instance oneSpade of BridgeInputItem
	(properties
		loop 1
		nsLeft 135
		nsTop 4
		returnValue 4
		nsTop1 4
		nsTop2 73
	)
)

(instance twoSpade of BridgeInputItem
	(properties
		loop 2
		nsLeft 135
		nsTop 14
		returnValue 9
		nsTop1 14
		nsTop2 83
	)
)

(instance threeSpade of BridgeInputItem
	(properties
		loop 3
		nsLeft 135
		nsTop 24
		returnValue 14
		nsTop1 24
		nsTop2 93
	)
)

(instance fourSpade of BridgeInputItem
	(properties
		loop 4
		nsLeft 135
		nsTop 34
		returnValue 19
		nsTop1 34
		nsTop2 103
	)
)

(instance fiveSpade of BridgeInputItem
	(properties
		loop 5
		nsLeft 135
		nsTop 44
		returnValue 24
		nsTop1 44
		nsTop2 113
	)
)

(instance sixSpade of BridgeInputItem
	(properties
		loop 6
		nsLeft 135
		nsTop 54
		returnValue 29
		nsTop1 54
		nsTop2 123
	)
)

(instance sevenSpade of BridgeInputItem
	(properties
		loop 7
		nsLeft 135
		nsTop 64
		returnValue 34
		nsTop1 64
		nsTop2 133
	)
)

(instance oneNT of BridgeInputItem
	(properties
		loop 1
		nsLeft 154
		nsTop 4
		returnValue 5
		nsTop1 4
		nsTop2 73
	)
)

(instance twoNT of BridgeInputItem
	(properties
		loop 2
		nsLeft 154
		nsTop 14
		returnValue 10
		nsTop1 14
		nsTop2 83
	)
)

(instance threeNT of BridgeInputItem
	(properties
		loop 3
		nsLeft 154
		nsTop 24
		returnValue 15
		nsTop1 24
		nsTop2 93
	)
)

(instance fourNT of BridgeInputItem
	(properties
		loop 4
		nsLeft 154
		nsTop 34
		returnValue 20
		nsTop1 34
		nsTop2 103
	)
)

(instance fiveNT of BridgeInputItem
	(properties
		loop 5
		nsLeft 154
		nsTop 44
		returnValue 25
		nsTop1 44
		nsTop2 113
	)
)

(instance sixNT of BridgeInputItem
	(properties
		loop 6
		nsLeft 154
		nsTop 54
		returnValue 30
		nsTop1 54
		nsTop2 123
	)
)

(instance sevenNT of BridgeInputItem
	(properties
		loop 7
		nsLeft 154
		nsTop 64
		returnValue 35
		nsTop1 64
		nsTop2 133
	)
)

(instance passButton of BridgeInputItem
	(properties
		loop 8
		cel 0
	)
)

(instance double of BridgeInputItem
	(properties
		loop 8
		cel 2
		returnValue 50
	)
)

(instance scrollUp of ControlIcon
	(properties
		view 700
		loop 9
		cel 0
		signal 385
		highlightColor -1
	)

	(method (doit)
		(BidBox scroll: 1)
	)
)

(instance scrollDown of ControlIcon
	(properties
		view 700
		loop 10
		cel 0
		signal 385
		highlightColor -1
	)

	(method (doit)
		(BidBox scroll: 0)
	)
)

