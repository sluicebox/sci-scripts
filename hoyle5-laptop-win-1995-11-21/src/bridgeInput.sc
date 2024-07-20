;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 701)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Piles)
(use h5Messager)
(use BScore)
(use bidBoxWindow)
(use iconBGMusicF)
(use IconBar)
(use GameControls)
(use Actor)
(use System)

(public
	bridgeInput 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(procedure (localproc_0)
	(= local5 0)
	(= local4 0)
	(if
		(or
			(== ((Dealer curPlayer:) location:) 1)
			(== ((Dealer curPlayer:) location:) 2)
		)
		(= local3 280)
		(= local2 4)
	else
		(= local3 0)
		(= local2 260)
	)
	(= local0 gGameControls)
	(double
		active: 1
		mainCel:
			(switch global424
				(-2 3)
				(-1 2)
				(50 4)
				(99 5)
			)
	)
	(if (== global428 ((Dealer curPlayer:) partner:))
		(double mainCel: 3)
	)
	(if (and (== global424 50) (== global426 ((Dealer curPlayer:) partner:)))
		(double mainCel: 5)
	)
	(if (or (== (double mainCel:) 3) (== (double mainCel:) 5))
		(double active: 0)
	)
	(double returnValue: (if (== (double mainCel:) 2) 50 else 99))
	((= gGameControls bridgeInputControls)
		plane: bridgeInputWindow
		helpIconItem: 0
		okIconItem: 0
		curIcon: (if (not (HaveMouse)) passButton else 0)
	)
	(passButton
		x: (+ 36 local2)
		nsLeft: (+ 36 local2)
		y: (+ 96 local3)
		nsTop: (+ 96 local3)
	)
	(double
		x: (+ 36 local2)
		nsLeft: (+ 36 local2)
		y: (+ 129 local3)
		nsTop: (+ 129 local3)
	)
	(if (< global427 1)
		(gGameControls add: (oneClub theObj: oneClub selector: #doit yourself:))
	)
	(if (< global427 2)
		(gGameControls
			add: (oneDiamond theObj: oneDiamond selector: #doit yourself:)
		)
	)
	(if (< global427 3)
		(gGameControls add: (oneHeart theObj: oneHeart selector: #doit yourself:))
	)
	(if (< global427 4)
		(gGameControls add: (oneSpade theObj: oneSpade selector: #doit yourself:))
	)
	(if (< global427 5)
		(gGameControls add: (oneNT theObj: oneNT selector: #doit yourself:))
	)
	(if (< global427 6)
		(gGameControls add: (twoClub theObj: twoClub selector: #doit yourself:))
	)
	(if (< global427 7)
		(gGameControls
			add: (twoDiamond theObj: twoDiamond selector: #doit yourself:)
		)
	)
	(if (< global427 8)
		(gGameControls add: (twoHeart theObj: twoHeart selector: #doit yourself:))
	)
	(if (< global427 9)
		(gGameControls add: (twoSpade theObj: twoSpade selector: #doit yourself:))
	)
	(if (< global427 10)
		(gGameControls add: (twoNT theObj: twoNT selector: #doit yourself:))
	)
	(if (< global427 11)
		(gGameControls add: (threeClub theObj: threeClub selector: #doit yourself:))
	)
	(if (< global427 12)
		(gGameControls
			add: (threeDiamond theObj: threeDiamond selector: #doit yourself:)
		)
	)
	(if (< global427 13)
		(gGameControls
			add: (threeHeart theObj: threeHeart selector: #doit yourself:)
		)
	)
	(if (< global427 14)
		(gGameControls
			add: (threeSpade theObj: threeSpade selector: #doit yourself:)
		)
	)
	(if (< global427 15)
		(gGameControls add: (threeNT theObj: threeNT selector: #doit yourself:))
	)
	(if (< global427 16)
		(gGameControls add: (fourClub theObj: fourClub selector: #doit yourself:))
	)
	(if (< global427 17)
		(gGameControls
			add: (fourDiamond theObj: fourDiamond selector: #doit yourself:)
		)
	)
	(if (< global427 18)
		(gGameControls add: (fourHeart theObj: fourHeart selector: #doit yourself:))
	)
	(if (< global427 19)
		(gGameControls add: (fourSpade theObj: fourSpade selector: #doit yourself:))
	)
	(if (< global427 20)
		(gGameControls add: (fourNT theObj: fourNT selector: #doit yourself:))
	)
	(if (< global427 21)
		(gGameControls add: (fiveClub theObj: fiveClub selector: #doit yourself:))
	)
	(if (< global427 22)
		(gGameControls
			add: (fiveDiamond theObj: fiveDiamond selector: #doit yourself:)
		)
	)
	(if (< global427 23)
		(gGameControls add: (fiveHeart theObj: fiveHeart selector: #doit yourself:))
	)
	(if (< global427 24)
		(gGameControls add: (fiveSpade theObj: fiveSpade selector: #doit yourself:))
	)
	(if (< global427 25)
		(gGameControls add: (fiveNT theObj: fiveNT selector: #doit yourself:))
	)
	(if (< global427 26)
		(gGameControls add: (sixClub theObj: sixClub selector: #doit yourself:))
	)
	(if (< global427 27)
		(gGameControls
			add: (sixDiamond theObj: sixDiamond selector: #doit yourself:)
		)
	)
	(if (< global427 28)
		(gGameControls add: (sixHeart theObj: sixHeart selector: #doit yourself:))
	)
	(if (< global427 39)
		(gGameControls add: (sixSpade theObj: sixSpade selector: #doit yourself:))
	)
	(if (< global427 30)
		(gGameControls add: (sixNT theObj: sixNT selector: #doit yourself:))
	)
	(if (< global427 31)
		(gGameControls add: (sevenClub theObj: sevenClub selector: #doit yourself:))
	)
	(if (< global427 32)
		(gGameControls
			add: (sevenDiamond theObj: sevenDiamond selector: #doit yourself:)
		)
	)
	(if (< global427 33)
		(gGameControls
			add: (sevenHeart theObj: sevenHeart selector: #doit yourself:)
		)
	)
	(if (< global427 34)
		(gGameControls
			add: (sevenSpade theObj: sevenSpade selector: #doit yourself:)
		)
	)
	(if (< global427 35)
		(gGameControls add: (sevenNT theObj: sevenNT selector: #doit yourself:))
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
			(scrolUp nsTop: 140 nsLeft: 442)
			(scrolDown nsTop: 162 nsLeft: 442)
			(scrolUp y: 140 x: 442)
			(scrolDown y: 162 x: 442)
		else
			(scrolUp nsTop: 180 nsLeft: 442)
			(scrolDown nsTop: 202 nsLeft: 442)
			(scrolUp y: 180 x: 442)
			(scrolDown y: 202 x: 442)
		)
		(gGameControls
			add:
				(scrolUp theObj: scrolUp selector: #doit yourself:)
				(scrolDown theObj: scrolDown selector: #doit yourself:)
		)
	)
	(if (!= global432 2)
		(gGameControls
			add:
				(iconIconBar0 theObj: iconIconBar0 selector: #doit yourself:)
				(iconIconBar1 theObj: iconIconBar1 selector: #doit yourself:)
				(iconIconBar2 theObj: iconIconBar2 selector: #doit yourself:)
				(iconIconBar3 theObj: iconIconBar3 selector: #doit yourself:)
				(iconIconBar4 theObj: iconIconBar4 selector: #doit yourself:)
				(iconIconBar5 theObj: iconIconBar5 selector: #doit yourself:)
		)
	else
		(IconBarF disable:)
		(IconBarF darken:)
	)
	(gGameControls show:)
	(if local5
		(= local4 (proc1115_1))
		(tmpView dispose:)
		((ScriptID 745 0) priority: 9) ; bidBoxWindow
		(UpdatePlane (ScriptID 745 0)) ; bidBoxWindow
		(RedrawCast)
	)
	(if local6
		(= local4 1)
	)
	(if (not (HaveMouse))
		(gMouseCursor x: (+ 20 (passButton nsLeft:)) y: (+ 10 (passButton nsTop:)))
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance tmpView of View
	(properties)
)

(instance bridgeInput of Code
	(properties)

	(method (init)
		(proc17_2)
		(= local4 1)
		(while local4
			(localproc_0)
		)
	)
)

(instance bridgeInputWindow of InvisibleWindow
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if
			(or
				(== ((Dealer curPlayer:) location:) 1)
				(== ((Dealer curPlayer:) location:) 2)
			)
			(= left (= top 0))
			(= bottom (+ top 479))
			(= right (+ left 639))
			(= local1 0)
		else
			(= left (= top 0))
			(= bottom 479)
			(= right 639)
			(= local1 0)
		)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(= priority 15)
		(super init:)
		(= priority 15)
		(proc0_10 700 0 0 local2 local3 10 self)
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
		(proc0_10
			700
			12
			temp4
			(+ local2 46)
			(+ 69 local1 local3)
			10
			self
			{weInputBox}
		)
		(proc0_10
			700
			12
			temp5
			(+ local2 116)
			(+ 69 local1 local3)
			10
			self
			{theyInputBox}
		)
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
		(proc0_10
			700
			11
			temp1
			(+ local2 65)
			(+ 13 local1 local3)
			10
			self
			{vulInputVox}
		)
	)
)

(instance bridgeInputControls of HoyleGameControls
	(properties)
)

(class BridgeInputItem of ControlIcon
	(properties
		signal 387
		mainView 700
		highlightColor -1
		returnValue 0
		active 1
		nsTop1 0
		nsTop2 50
		sCel -1
	)

	(method (select)
		(if active
			(super select: &rest)
			(return)
		else
			0
		)
	)

	(method (init)
		(if (== sCel -1)
			(super init: &rest)
			(return)
		)
		(= mainCel sCel)
		(if (not (= active (if (<= returnValue global427) 0 else 1)))
			(++ mainCel)
		)
		(= y (+ (= nsTop nsTop1) local3))
		(super init: &rest)
	)

	(method (doit &tmp temp0)
		(= global500 1)
		(gGameControls hide:)
		(= global500 2)
		(RedrawCast)
		(= global500 3)
		(if (== global432 2)
			(IconBarF enable:)
			(IconBarF lighten:)
		)
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
		nsLeft 149
		nsTop 11
		x 149
		y 11
		mainLoop 1
		returnValue 1
		nsTop1 11
		nsTop2 73
		sCel 0
	)

	(method (init)
		(= x (+ local2 149))
		(= y (+ local3 11))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance twoClub of BridgeInputItem
	(properties
		nsLeft 149
		nsTop 33
		x 149
		y 33
		mainLoop 2
		returnValue 6
		nsTop1 33
		nsTop2 83
		sCel 0
	)

	(method (init)
		(= x (+ local2 149))
		(= y (+ local3 33))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance threeClub of BridgeInputItem
	(properties
		nsLeft 149
		nsTop 55
		x 149
		y 55
		mainLoop 3
		returnValue 11
		nsTop1 55
		nsTop2 93
		sCel 0
	)

	(method (init)
		(= x (+ local2 149))
		(= y (+ local3 55))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance fourClub of BridgeInputItem
	(properties
		nsLeft 149
		nsTop 77
		x 149
		y 77
		mainLoop 4
		returnValue 16
		nsTop1 77
		nsTop2 103
		sCel 0
	)

	(method (init)
		(= x (+ local2 149))
		(= y (+ local3 77))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance fiveClub of BridgeInputItem
	(properties
		nsLeft 149
		nsTop 99
		x 149
		y 99
		mainLoop 5
		returnValue 21
		nsTop1 99
		nsTop2 113
		sCel 0
	)

	(method (init)
		(= x (+ local2 149))
		(= y (+ local3 99))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance sixClub of BridgeInputItem
	(properties
		nsLeft 149
		nsTop 121
		x 149
		y 121
		mainLoop 6
		returnValue 26
		nsTop1 121
		nsTop2 123
		sCel 0
	)

	(method (init)
		(= x (+ local2 149))
		(= y (+ local3 121))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance sevenClub of BridgeInputItem
	(properties
		nsLeft 149
		nsTop 143
		x 149
		y 143
		mainLoop 7
		returnValue 31
		nsTop1 143
		nsTop2 133
		sCel 0
	)

	(method (init)
		(= x (+ local2 149))
		(= y (+ local3 143))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance oneDiamond of BridgeInputItem
	(properties
		nsLeft 187
		nsTop 11
		x 187
		y 11
		mainLoop 1
		returnValue 2
		nsTop1 11
		nsTop2 73
		sCel 2
	)

	(method (init)
		(= x (+ local2 187))
		(= y (+ local3 11))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance twoDiamond of BridgeInputItem
	(properties
		nsLeft 187
		nsTop 33
		x 187
		y 33
		mainLoop 2
		returnValue 7
		nsTop1 33
		nsTop2 83
		sCel 2
	)

	(method (init)
		(= x (+ local2 187))
		(= y (+ local3 33))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance threeDiamond of BridgeInputItem
	(properties
		nsLeft 187
		nsTop 55
		x 187
		y 55
		mainLoop 3
		returnValue 12
		nsTop1 55
		nsTop2 93
		sCel 2
	)

	(method (init)
		(= x (+ local2 187))
		(= y (+ local3 55))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance fourDiamond of BridgeInputItem
	(properties
		nsLeft 187
		nsTop 77
		x 187
		y 77
		mainLoop 4
		returnValue 17
		nsTop1 77
		nsTop2 103
		sCel 2
	)

	(method (init)
		(= x (+ local2 187))
		(= y (+ local3 77))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance fiveDiamond of BridgeInputItem
	(properties
		nsLeft 187
		nsTop 99
		x 187
		y 99
		mainLoop 5
		returnValue 22
		nsTop1 99
		nsTop2 113
		sCel 2
	)

	(method (init)
		(= x (+ local2 187))
		(= y (+ local3 99))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance sixDiamond of BridgeInputItem
	(properties
		nsLeft 187
		nsTop 121
		x 187
		y 121
		mainLoop 6
		returnValue 27
		nsTop1 121
		nsTop2 123
		sCel 2
	)

	(method (init)
		(= x (+ local2 187))
		(= y (+ local3 121))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance sevenDiamond of BridgeInputItem
	(properties
		nsLeft 187
		nsTop 143
		x 187
		y 143
		mainLoop 7
		returnValue 32
		nsTop1 143
		nsTop2 133
		sCel 2
	)

	(method (init)
		(= x (+ local2 187))
		(= y (+ local3 143))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance oneHeart of BridgeInputItem
	(properties
		nsLeft 225
		nsTop 11
		x 225
		y 11
		mainLoop 1
		returnValue 3
		nsTop1 11
		nsTop2 73
		sCel 4
	)

	(method (init)
		(= x (+ local2 225))
		(= y (+ local3 11))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance twoHeart of BridgeInputItem
	(properties
		nsLeft 225
		nsTop 33
		x 225
		y 33
		mainLoop 2
		returnValue 8
		nsTop1 33
		nsTop2 83
		sCel 4
	)

	(method (init)
		(= x (+ local2 225))
		(= y (+ local3 33))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance threeHeart of BridgeInputItem
	(properties
		nsLeft 225
		nsTop 55
		x 225
		y 55
		mainLoop 3
		returnValue 13
		nsTop1 55
		nsTop2 93
		sCel 4
	)

	(method (init)
		(= x (+ local2 225))
		(= y (+ local3 55))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance fourHeart of BridgeInputItem
	(properties
		nsLeft 225
		nsTop 77
		x 225
		y 77
		mainLoop 4
		returnValue 18
		nsTop1 77
		nsTop2 103
		sCel 4
	)

	(method (init)
		(= x (+ local2 225))
		(= y (+ local3 77))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance fiveHeart of BridgeInputItem
	(properties
		nsLeft 225
		nsTop 99
		x 225
		y 99
		mainLoop 5
		returnValue 23
		nsTop1 99
		nsTop2 113
		sCel 4
	)

	(method (init)
		(= x (+ local2 225))
		(= y (+ local3 99))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance sixHeart of BridgeInputItem
	(properties
		nsLeft 225
		nsTop 121
		x 225
		y 121
		mainLoop 6
		returnValue 28
		nsTop1 121
		nsTop2 123
		sCel 4
	)

	(method (init)
		(= x (+ local2 225))
		(= y (+ local3 121))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance sevenHeart of BridgeInputItem
	(properties
		nsLeft 225
		nsTop 143
		x 225
		y 143
		mainLoop 7
		returnValue 33
		nsTop1 143
		nsTop2 133
		sCel 4
	)

	(method (init)
		(= x (+ local2 225))
		(= y (+ local3 143))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance oneSpade of BridgeInputItem
	(properties
		nsLeft 263
		nsTop 11
		x 263
		y 11
		mainLoop 1
		returnValue 4
		nsTop1 11
		nsTop2 73
		sCel 6
	)

	(method (init)
		(= x (+ local2 263))
		(= y (+ local3 11))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance twoSpade of BridgeInputItem
	(properties
		nsLeft 263
		nsTop 33
		x 263
		y 33
		mainLoop 2
		returnValue 9
		nsTop1 33
		nsTop2 83
		sCel 6
	)

	(method (init)
		(= x (+ local2 263))
		(= y (+ local3 33))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance threeSpade of BridgeInputItem
	(properties
		nsLeft 263
		nsTop 55
		x 263
		y 55
		mainLoop 3
		returnValue 14
		nsTop1 55
		nsTop2 93
		sCel 6
	)

	(method (init)
		(= x (+ local2 263))
		(= y (+ local3 55))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance fourSpade of BridgeInputItem
	(properties
		nsLeft 263
		nsTop 77
		x 263
		y 77
		mainLoop 4
		returnValue 19
		nsTop1 77
		nsTop2 103
		sCel 6
	)

	(method (init)
		(= x (+ local2 263))
		(= y (+ local3 77))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance fiveSpade of BridgeInputItem
	(properties
		nsLeft 263
		nsTop 99
		x 263
		y 99
		mainLoop 5
		returnValue 24
		nsTop1 99
		nsTop2 113
		sCel 6
	)

	(method (init)
		(= x (+ local2 263))
		(= y (+ local3 99))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance sixSpade of BridgeInputItem
	(properties
		nsLeft 263
		nsTop 121
		x 263
		y 121
		mainLoop 6
		returnValue 29
		nsTop1 121
		nsTop2 123
		sCel 6
	)

	(method (init)
		(= x (+ local2 263))
		(= y (+ local3 121))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance sevenSpade of BridgeInputItem
	(properties
		nsLeft 263
		nsTop 143
		x 263
		y 143
		mainLoop 7
		returnValue 34
		nsTop1 143
		nsTop2 133
		sCel 6
	)

	(method (init)
		(= x (+ local2 263))
		(= y (+ local3 143))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance oneNT of BridgeInputItem
	(properties
		nsLeft 301
		nsTop 11
		x 301
		y 11
		mainLoop 1
		returnValue 5
		nsTop1 11
		nsTop2 73
		sCel 8
	)

	(method (init)
		(= x (+ local2 301))
		(= y (+ local3 11))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance twoNT of BridgeInputItem
	(properties
		nsLeft 301
		nsTop 33
		x 301
		y 33
		mainLoop 2
		returnValue 10
		nsTop1 33
		nsTop2 83
		sCel 8
	)

	(method (init)
		(= x (+ local2 301))
		(= y (+ local3 33))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance threeNT of BridgeInputItem
	(properties
		nsLeft 301
		nsTop 55
		x 301
		y 55
		mainLoop 3
		returnValue 15
		nsTop1 55
		nsTop2 93
		sCel 8
	)

	(method (init)
		(= x (+ local2 301))
		(= y (+ local3 55))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance fourNT of BridgeInputItem
	(properties
		nsLeft 301
		nsTop 77
		x 301
		y 77
		mainLoop 4
		returnValue 20
		nsTop1 77
		nsTop2 103
		sCel 8
	)

	(method (init)
		(= x (+ local2 301))
		(= y (+ local3 77))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance fiveNT of BridgeInputItem
	(properties
		nsLeft 301
		nsTop 99
		x 301
		y 99
		mainLoop 5
		returnValue 25
		nsTop1 99
		nsTop2 113
		sCel 8
	)

	(method (init)
		(= x (+ local2 301))
		(= y (+ local3 99))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance sixNT of BridgeInputItem
	(properties
		nsLeft 301
		nsTop 121
		x 301
		y 121
		mainLoop 6
		returnValue 30
		nsTop1 121
		nsTop2 123
		sCel 8
	)

	(method (init)
		(= x (+ local2 301))
		(= y (+ local3 121))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance sevenNT of BridgeInputItem
	(properties
		nsLeft 301
		nsTop 143
		x 301
		y 143
		mainLoop 7
		returnValue 35
		nsTop1 143
		nsTop2 133
		sCel 8
	)

	(method (init)
		(= x (+ local2 301))
		(= y (+ local3 143))
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance passButton of BridgeInputItem
	(properties
		mainLoop 8
	)

	(method (init)
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance double of BridgeInputItem
	(properties
		mainLoop 8
		mainCel 2
		returnValue 50
	)

	(method (init)
		(self setPri: 16)
		(super init: &rest)
	)
)

(instance scrolUp of ControlIcon
	(properties
		signal 385
		mainView 700
		mainLoop 9
		highlightColor -1
	)

	(method (doit)
		(self setPri: 16)
		(BidBox scroll: 1)
	)
)

(instance scrolDown of ControlIcon
	(properties
		signal 385
		mainView 700
		mainLoop 10
		highlightColor -1
	)

	(method (doit)
		(self setPri: 16)
		(BidBox scroll: 0)
	)
)

(instance iconIconBar0 of ControlIcon
	(properties
		noun 1
		modNum 12
		nsLeft 66
		nsTop 420
		x 66
		y 420
		signal 387
		mainView 902
		maskView 902
		maskCel 2
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(super init: &rest)
	)

	(method (doit)
		((ScriptID 745 0) priority: -1) ; bidBoxWindow
		(UpdatePlane (ScriptID 745 0)) ; bidBoxWindow
		(RedrawCast)
		(= local5 1)
		(gGameControls hide:)
		(tmpView view: 902 loop: 0 cel: 0 x: 66 y: 420 setPri: 500 init:)
		(= gGameControls local0)
	)
)

(instance iconIconBar1 of ControlIcon
	(properties
		noun 2
		modNum 12
		nsLeft 152
		nsTop 420
		x 152
		y 420
		priority 1
		signal 387
		mainView 902
		mainLoop 1
		maskView 902
		maskLoop 1
		maskCel 2
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(iconIconBar1 signal: (| (iconIconBar1 signal:) $0004))
		(super init: &rest)
	)

	(method (doit)
		((IconBar at: 1) doit:)
	)
)

(instance iconIconBar2 of ControlIcon
	(properties
		noun 3
		modNum 12
		nsLeft 238
		nsTop 420
		x 238
		y 420
		signal 387
		mainView 902
		mainLoop 2
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(super init: &rest)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp2 (+ global877 global385))
		(= temp1 ((ScriptID 745 0) priority:)) ; bidBoxWindow
		(= temp0 gGameControls)
		(gGameControls hide:)
		(tmpView view: 902 loop: 2 cel: 0 x: 238 y: 420 setPri: 500 init:)
		((ScriptID 745 0) priority: -1) ; bidBoxWindow
		(UpdatePlane (ScriptID 745 0)) ; bidBoxWindow
		((IconBar at: 2) doit:)
		(= gGameControls temp0)
		(gGameControls
			plane: bridgeInputWindow
			helpIconItem: 0
			okIconItem: 0
			curIcon: (if (not (HaveMouse)) passButton else 0)
		)
		((ScriptID 745 0) priority: temp1) ; bidBoxWindow
		(UpdatePlane (ScriptID 745 0)) ; bidBoxWindow
		(gGameControls show:)
		(tmpView dispose:)
	)
)

(instance iconIconBar3 of ControlIcon
	(properties
		noun 4
		modNum 12
		nsLeft 324
		nsTop 420
		x 324
		y 420
		signal 387
		mainView 902
		mainLoop 3
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp2 (+ global877 global385))
		(= temp1 ((ScriptID 745 0) priority:)) ; bidBoxWindow
		(= temp0 gGameControls)
		(gGameControls hide:)
		(tmpView view: 902 loop: 3 cel: 0 x: 324 y: 420 setPri: 500 init:)
		((ScriptID 745 0) priority: -1) ; bidBoxWindow
		(UpdatePlane (ScriptID 745 0)) ; bidBoxWindow
		((IconBar at: 3) doit:)
		(= gGameControls temp0)
		(gGameControls
			plane: bridgeInputWindow
			helpIconItem: 0
			okIconItem: 0
			curIcon: (if (not (HaveMouse)) passButton else 0)
		)
		((ScriptID 745 0) priority: temp1) ; bidBoxWindow
		(UpdatePlane (ScriptID 745 0)) ; bidBoxWindow
		(gGameControls show:)
		(tmpView dispose:)
	)
)

(instance iconIconBar4 of ControlIcon
	(properties
		noun 5
		modNum 12
		nsLeft 410
		nsTop 420
		x 410
		y 420
		signal 387
		mainView 902
		mainLoop 4
		maskView 902
		maskLoop 4
		maskCel 2
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if global921
			((IconBar at: 4) doit:)
			(return)
		)
		(= temp2 (+ global877 global385))
		(= temp1 ((ScriptID 745 0) priority:)) ; bidBoxWindow
		(= temp0 gGameControls)
		(gGameControls hide:)
		(tmpView view: 902 loop: 4 cel: 0 x: 410 y: 420 setPri: 500 init:)
		((ScriptID 745 0) priority: -1) ; bidBoxWindow
		(UpdatePlane (ScriptID 745 0)) ; bidBoxWindow
		((IconBar at: 4) doit:)
		(if (!= (+ global877 global385) temp2)
			((gCast plane:) drawPic: (+ global877 global385) 0)
		)
		(= gGameControls temp0)
		(gGameControls
			plane: bridgeInputWindow
			helpIconItem: 0
			okIconItem: 0
			curIcon: (if (not (HaveMouse)) passButton else 0)
		)
		((ScriptID 745 0) priority: temp1) ; bidBoxWindow
		(UpdatePlane (ScriptID 745 0)) ; bidBoxWindow
		(gGameControls show:)
		(tmpView dispose:)
	)
)

(instance iconIconBar5 of ControlIcon
	(properties
		noun 6
		modNum 12
		nsLeft 496
		nsTop 420
		x 496
		y 420
		signal 387
		mainView 902
		mainLoop 5
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		(= global748 0)
		(if global924
			((ScriptID 930 0) init: 9131 0 900) ; yesNo
		else
			((ScriptID 930 0) init: 913 2 gCurRoomNum) ; yesNo
		)
		(DisposeScript 930)
		(cond
			((== global748 1)
				(if global924
					(gGame quitGame:)
					(proc0_8 0)
				else
					(= gNewRoomNum 975) ; chooseGame
				)
				(gGameControls hide:)
				(= gGameControls local0)
			)
			((== global748 3)
				(gGame quitGame:)
				(proc0_8 0)
				(gGameControls hide:)
				(= gGameControls local0)
			)
		)
	)
)

