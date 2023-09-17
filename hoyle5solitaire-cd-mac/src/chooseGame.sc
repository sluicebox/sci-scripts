;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 975)
(include sci.sh)
(use Main)
(use KeyMouse)
(use TrackingView)
(use h5Messager)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	chooseGame 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0 param1 param2)
	(if (< global221 28)
		(= local4
			((View new:)
				view: 989
				loop: 31
				cel: 0
				x: param1
				y: param2
				setPri: 100
				yourself:
			)
		)
		(local4 init:)
	)
)

(procedure (localproc_1 &tmp temp0)
	(switch gCardGameScriptNumber
		(6022
			(if local5
				(SetCursor (+ (yukonButton x:) 8) (+ (yukonButton y:) 8))
			else
				(SetCursor (+ (bakersButton x:) 8) (+ (bakersButton y:) 8))
			)
		)
		(6013
			(if local5
				(SetCursor (+ (acesButton x:) 8) (+ (acesButton y:) 8))
			else
				(SetCursor (+ (belcastlButton x:) 8) (+ (belcastlButton y:) 8))
			)
		)
		(6004
			(if local5
				(SetCursor (+ (bakersButton x:) 8) (+ (bakersButton y:) 8))
			else
				(SetCursor (+ (bowlingButton x:) 8) (+ (bowlingButton y:) 8))
			)
		)
		(6020
			(if local5
				(SetCursor (+ (belcastlButton x:) 8) (+ (belcastlButton y:) 8))
			else
				(SetCursor (+ (bristolButton x:) 8) (+ (bristolButton y:) 8))
			)
		)
		(6014
			(if local5
				(SetCursor (+ (bowlingButton x:) 8) (+ (bowlingButton y:) 8))
			else
				(SetCursor
					(+ (calculationButton x:) 8)
					(+ (calculationButton y:) 8)
				)
			)
		)
		(6001
			(if local5
				(SetCursor (+ (bristolButton x:) 8) (+ (bristolButton y:) 8))
			else
				(SetCursor (+ (canfieldButton x:) 8) (+ (canfieldButton y:) 8))
			)
		)
		(6006
			(if local5
				(SetCursor
					(+ (calculationButton x:) 8)
					(+ (calculationButton y:) 8)
				)
			else
				(SetCursor (+ (cribbageButton x:) 8) (+ (cribbageButton y:) 8))
			)
		)
		(6028
			(if local5
				(SetCursor (+ (canfieldButton x:) 8) (+ (canfieldButton y:) 8))
			else
				(SetCursor (+ (eagleButton x:) 8) (+ (eagleButton y:) 8))
			)
		)
		(6003
			(if local5
				(SetCursor (+ (cribbageButton x:) 8) (+ (cribbageButton y:) 8))
			else
				(SetCursor (+ (eightButton x:) 8) (+ (eightButton y:) 8))
			)
		)
		(6015
			(if local5
				(SetCursor (+ (eagleButton x:) 8) (+ (eagleButton y:) 8))
			else
				(SetCursor
					(+ (eliminateButton x:) 8)
					(+ (eliminateButton y:) 8)
				)
			)
		)
		(6018
			(if local5
				(SetCursor (+ (eightButton x:) 8) (+ (eightButton y:) 8))
			else
				(SetCursor (+ (flowerButton x:) 8) (+ (flowerButton y:) 8))
			)
		)
		(6008
			(if local5
				(SetCursor
					(+ (eliminateButton x:) 8)
					(+ (eliminateButton y:) 8)
				)
			else
				(SetCursor (+ (fortressButton x:) 8) (+ (fortressButton y:) 8))
			)
		)
		(6012
			(if local5
				(SetCursor (+ (flowerButton x:) 8) (+ (flowerButton y:) 8))
			else
				(SetCursor (+ (gapsButton x:) 8) (+ (gapsButton y:) 8))
			)
		)
		(6023
			(if local5
				(SetCursor (+ (fortressButton x:) 8) (+ (fortressButton y:) 8))
			else
				(SetCursor (+ (golfButton x:) 8) (+ (golfButton y:) 8))
			)
		)
		(6007
			(if local5
				(SetCursor (+ (gapsButton x:) 8) (+ (gapsButton y:) 8))
			else
				(SetCursor (+ (klondikeButton x:) 8) (+ (klondikeButton y:) 8))
			)
		)
		(6005
			(if local5
				(SetCursor (+ (golfButton x:) 8) (+ (golfButton y:) 8))
			else
				(SetCursor (+ (labelleButton x:) 8) (+ (labelleButton y:) 8))
			)
		)
		(6011
			(if local5
				(SetCursor (+ (klondikeButton x:) 8) (+ (klondikeButton y:) 8))
			else
				(SetCursor (+ (nestorButton x:) 8) (+ (nestorButton y:) 8))
			)
		)
		(6021
			(if local5
				(SetCursor (+ (labelleButton x:) 8) (+ (labelleButton y:) 8))
			else
				(SetCursor (+ (penguinButton x:) 8) (+ (penguinButton y:) 8))
			)
		)
		(6024
			(if local5
				(SetCursor (+ (nestorButton x:) 8) (+ (nestorButton y:) 8))
			else
				(SetCursor (+ (pokerButton x:) 8) (+ (pokerButton y:) 8))
			)
		)
		(6027
			(if local5
				(SetCursor (+ (penguinButton x:) 8) (+ (penguinButton y:) 8))
			else
				(SetCursor (+ (pyramidButton x:) 8) (+ (pyramidButton y:) 8))
			)
		)
		(6025
			(if local5
				(SetCursor (+ (pokerButton x:) 8) (+ (pokerButton y:) 8))
			else
				(SetCursor (+ (scorpionButton x:) 8) (+ (scorpionButton y:) 8))
			)
		)
		(6009
			(if local5
				(SetCursor (+ (pyramidButton x:) 8) (+ (pyramidButton y:) 8))
			else
				(SetCursor (+ (shamrockButton x:) 8) (+ (shamrockButton y:) 8))
			)
		)
		(6016
			(if local5
				(SetCursor (+ (scorpionButton x:) 8) (+ (scorpionButton y:) 8))
			else
				(SetCursor (+ (slideButton x:) 8) (+ (slideButton y:) 8))
			)
		)
		(6019
			(if local5
				(SetCursor (+ (shamrockButton x:) 8) (+ (shamrockButton y:) 8))
			else
				(SetCursor (+ (spiderButton x:) 8) (+ (spiderButton y:) 8))
			)
		)
		(6010
			(if local5
				(SetCursor (+ (slideButton x:) 8) (+ (slideButton y:) 8))
			else
				(SetCursor (+ (strategyButton x:) 8) (+ (strategyButton y:) 8))
			)
		)
		(6002
			(if local5
				(SetCursor (+ (spiderButton x:) 8) (+ (spiderButton y:) 8))
			else
				(SetCursor (+ (tripletsButton x:) 8) (+ (tripletsButton y:) 8))
			)
		)
		(6026
			(if local5
				(SetCursor (+ (strategyButton x:) 8) (+ (strategyButton y:) 8))
			else
				(SetCursor (+ (yukonButton x:) 8) (+ (yukonButton y:) 8))
			)
		)
		(6017
			(if local5
				(SetCursor (+ (tripletsButton x:) 8) (+ (tripletsButton y:) 8))
			else
				(SetCursor (+ (acesButton x:) 8) (+ (acesButton y:) 8))
			)
		)
		(else
			(SetCursor (+ (acesButton x:) 8) (+ (acesButton y:) 8))
		)
	)
)

(instance chooseGame of Room
	(properties
		picture 913
		style 14
	)

	(method (init &tmp temp0)
		(super init:)
		(gSong stop:)
		(= gCardGameScriptNumber 0)
		(gSound flags: 1)
		(Characters eachElementDo: #active 0 eachElementDo: #dispose)
		(User canControl: 1)
		(gGame setCursor: 999)
		(Load rsVIEW 978)
		(Load rsVIEW 989)
		(while ((= temp0 (Event new:)) type:)
			(temp0 type: evNULL)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(= global199 0)
		(KeyMouse setList: gTheKeyMouseList)
		(gGame_opt doit: 2)
		(= local1 1)
		(acesButton init: setPri: 40 addKeyMouse:)
		(bakersButton init: setPri: 40 addKeyMouse:)
		(belcastlButton init: setPri: 40 addKeyMouse:)
		(bowlingButton init: setPri: 40 addKeyMouse:)
		(bristolButton init: setPri: 40 addKeyMouse:)
		(calculationButton init: setPri: 40 addKeyMouse:)
		(canfieldButton init: setPri: 40 addKeyMouse:)
		(cribbageButton init: setPri: 40 addKeyMouse:)
		(eagleButton init: setPri: 40 addKeyMouse:)
		(eightButton init: setPri: 40 addKeyMouse:)
		(eliminateButton init: setPri: 40 addKeyMouse:)
		(flowerButton init: setPri: 40 addKeyMouse:)
		(fortressButton init: setPri: 40 addKeyMouse:)
		(gapsButton init: setPri: 40 addKeyMouse:)
		(golfButton init: setPri: 40 addKeyMouse:)
		(klondikeButton init: setPri: 40 addKeyMouse:)
		(labelleButton init: setPri: 40 addKeyMouse:)
		(nestorButton init: setPri: 40 addKeyMouse:)
		(penguinButton init: setPri: 40 addKeyMouse:)
		(pokerButton init: setPri: 40 addKeyMouse:)
		(pyramidButton init: setPri: 40 addKeyMouse:)
		(scorpionButton init: setPri: 40 addKeyMouse:)
		(shamrockButton init: setPri: 40 addKeyMouse:)
		(slideButton init: setPri: 40 addKeyMouse:)
		(spiderButton init: setPri: 40 addKeyMouse:)
		(strategyButton init: setPri: 40 addKeyMouse:)
		(tripletsButton init: setPri: 40 addKeyMouse:)
		(yukonButton init: setPri: 40 addKeyMouse:)
		(quitButton init: setPri: 250 addKeyMouse:)
		(flickButton init: setPri: 250 addKeyMouse:)
		(backButton init: setPri: 250 addKeyMouse:)
		(RedrawCast)
		(if (== global221 28)
			(= global221 0)
			(= global494 0)
			(= global495 0)
			(= global496 0)
			(= global497 0)
			(= global498 0)
			(= global499 0)
			(= global500 0)
			(= global501 0)
			(= global502 0)
			(= global503 0)
			(= global504 0)
			(= global505 0)
			(= global506 0)
			(= global507 0)
			(= global508 0)
			(= global509 0)
			(= global510 0)
			(= global511 0)
			(= global512 0)
			(= global513 0)
			(= global514 0)
			(= global515 0)
			(= global516 0)
			(= global517 0)
			(= global518 0)
			(= global519 0)
			(= global520 0)
			(= global521 0)
			(gGame_opt doit: 3)
			(pAllDiamonds init:)
		)
		(if (not (HaveMouse))
			(KeyMouse setCursor: chooseGameView)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if local1
			(cond
				((and (< 82 gMouseX 152) (< 106 gMouseY 131))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6022)
					(local0 init: 0 show: addKeyMouse:)
				)
				((and (< 82 gMouseX 206) (< 132 gMouseY 157))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6013)
					(local0 init: 1 show: addKeyMouse:)
				)
				((and (< 82 gMouseX 245) (< 158 gMouseY 183))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6004)
					(local0 init: 2 show: addKeyMouse:)
				)
				((and (< 82 gMouseX 153) (< 184 gMouseY 209))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6020)
					(local0 init: 3 show: addKeyMouse:)
				)
				((and (< 82 gMouseX 140) (< 210 gMouseY 235))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6014)
					(local0 init: 4 show: addKeyMouse:)
				)
				((and (< 82 gMouseX 180) (< 236 gMouseY 261))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6001)
					(local0 init: 5 show: addKeyMouse:)
				)
				((and (< 82 gMouseX 153) (< 262 gMouseY 287))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6006)
					(local0 init: 6 show: addKeyMouse:)
				)
				((and (< 82 gMouseX 227) (< 288 gMouseY 313))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6028)
					(local0 init: 7 show: addKeyMouse:)
				)
				((and (< 82 gMouseX 181) (< 314 gMouseY 339))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6003)
					(local0 init: 8 show: addKeyMouse:)
				)
				((and (< 82 gMouseX 165) (< 340 gMouseY 365))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6015)
					(local0 init: 9 show: addKeyMouse:)
				)
				((and (< 279 gMouseX 373) (< 106 gMouseY 131))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6018)
					(local0 init: 10 show: addKeyMouse:)
				)
				((and (< 279 gMouseX 408) (< 132 gMouseY 157))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6008)
					(local0 init: 11 show: addKeyMouse:)
				)
				((and (< 279 gMouseX 349) (< 158 gMouseY 183))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6012)
					(local0 init: 12 show: addKeyMouse:)
				)
				((and (< 279 gMouseX 323) (< 184 gMouseY 209))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6023)
					(local0 init: 13 show: addKeyMouse:)
				)
				((and (< 279 gMouseX 319) (< 210 gMouseY 235))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6007)
					(local0 init: 14 show: addKeyMouse:)
				)
				((and (< 279 gMouseX 358) (< 236 gMouseY 261))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6005)
					(local0 init: 15 show: addKeyMouse:)
				)
				((and (< 279 gMouseX 402) (< 262 gMouseY 287))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6011)
					(local0 init: 16 show: addKeyMouse:)
				)
				((and (< 279 gMouseX 337) (< 288 gMouseY 313))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6021)
					(local0 init: 17 show: addKeyMouse:)
				)
				((and (< 279 gMouseX 348) (< 314 gMouseY 339))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6024)
					(local0 init: 18 show: addKeyMouse:)
				)
				((and (< 279 gMouseX 395) (< 340 gMouseY 365))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6027)
					(local0 init: 19 show: addKeyMouse:)
				)
				((and (< 478 gMouseX 553) (< 106 gMouseY 131))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6025)
					(local0 init: 20 show: addKeyMouse:)
				)
				((and (< 478 gMouseX 554) (< 132 gMouseY 157))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6009)
					(local0 init: 21 show: addKeyMouse:)
				)
				((and (< 478 gMouseX 572) (< 158 gMouseY 183))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6016)
					(local0 init: 22 show: addKeyMouse:)
				)
				((and (< 478 gMouseX 519) (< 184 gMouseY 209))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6019)
					(local0 init: 23 show: addKeyMouse:)
				)
				((and (< 478 gMouseX 564) (< 210 gMouseY 235))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6010)
					(local0 init: 24 show: addKeyMouse:)
				)
				((and (< 478 gMouseX 550) (< 236 gMouseY 261))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6002)
					(local0 init: 25 show: addKeyMouse:)
				)
				((and (< 478 gMouseX 546) (< 262 gMouseY 287))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6026)
					(local0 init: 26 show: addKeyMouse:)
				)
				((and (< 478 gMouseX 533) (< 288 gMouseY 313))
					(if local0
						(local0 hide:)
					)
					(= local0 chooseGameView)
					(= gCardGameScriptNumber 6017)
					(local0 init: 27 show: addKeyMouse:)
				)
			)
		)
	)

	(method (dispose)
		(chooseGameView dispose: deleteKeyMouse:)
		(acesButton dispose: deleteKeyMouse:)
		(bakersButton dispose: deleteKeyMouse:)
		(belcastlButton dispose: deleteKeyMouse:)
		(bowlingButton dispose: deleteKeyMouse:)
		(bristolButton dispose: deleteKeyMouse:)
		(calculationButton dispose: deleteKeyMouse:)
		(canfieldButton dispose: deleteKeyMouse:)
		(cribbageButton dispose: deleteKeyMouse:)
		(eagleButton dispose: deleteKeyMouse:)
		(eightButton dispose: deleteKeyMouse:)
		(eliminateButton dispose: deleteKeyMouse:)
		(flowerButton dispose: deleteKeyMouse:)
		(fortressButton dispose: deleteKeyMouse:)
		(gapsButton dispose: deleteKeyMouse:)
		(golfButton dispose: deleteKeyMouse:)
		(klondikeButton dispose: deleteKeyMouse:)
		(labelleButton dispose: deleteKeyMouse:)
		(nestorButton dispose: deleteKeyMouse:)
		(penguinButton dispose: deleteKeyMouse:)
		(pokerButton dispose: deleteKeyMouse:)
		(pyramidButton dispose: deleteKeyMouse:)
		(scorpionButton dispose: deleteKeyMouse:)
		(shamrockButton dispose: deleteKeyMouse:)
		(slideButton dispose: deleteKeyMouse:)
		(spiderButton dispose: deleteKeyMouse:)
		(strategyButton dispose: deleteKeyMouse:)
		(tripletsButton dispose: deleteKeyMouse:)
		(yukonButton dispose: deleteKeyMouse:)
		(quitButton dispose: deleteKeyMouse:)
		(flickButton dispose: deleteKeyMouse:)
		(backButton dispose: deleteKeyMouse:)
		(UnLoad 128 978)
		(UnLoad 128 989)
		(if local0
			(local0 hide: dispose:)
		)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (and gCardGameScriptNumber local0 (not local2) (proc0_2 event))
			(event claimed: 1)
			(local0 setCel: 1)
			(UpdateScreenItem local0)
			(gCurRoom newRoom: gCardGameScriptNumber)
		)
		(if (and (== evKEYBOARD (event type:)) (== (event message:) KEY_TAB))
			(= local5 0)
			(localproc_1)
			(event claimed: 1)
		)
		(if
			(and
				(== evKEYBOARD (event type:))
				(== (event message:) KEY_TAB)
				(& (event modifiers:) emSHIFT)
			)
			(= local5 1)
			(localproc_1)
			(event claimed: 1)
		)
		(quitButton handleEvent: event)
		(flickButton handleEvent: event)
		(backButton handleEvent: event)
		(if (not gCardGameScriptNumber)
			(event claimed: 1)
		)
		(acesButton handleEvent: event)
		(bakersButton handleEvent: event)
		(belcastlButton handleEvent: event)
		(bowlingButton handleEvent: event)
		(bristolButton handleEvent: event)
		(calculationButton handleEvent: event)
		(canfieldButton handleEvent: event)
		(cribbageButton handleEvent: event)
		(eagleButton handleEvent: event)
		(eightButton handleEvent: event)
		(eliminateButton handleEvent: event)
		(flowerButton handleEvent: event)
		(fortressButton handleEvent: event)
		(gapsButton handleEvent: event)
		(golfButton handleEvent: event)
		(klondikeButton handleEvent: event)
		(labelleButton handleEvent: event)
		(nestorButton handleEvent: event)
		(penguinButton handleEvent: event)
		(pokerButton handleEvent: event)
		(pyramidButton handleEvent: event)
		(scorpionButton handleEvent: event)
		(shamrockButton handleEvent: event)
		(slideButton handleEvent: event)
		(spiderButton handleEvent: event)
		(strategyButton handleEvent: event)
		(tripletsButton handleEvent: event)
		(yukonButton handleEvent: event)
		(chooseGameView handleEvent: event)
		(if local0
			(local0 setCel: 0)
		)
		(if (and (not (event claimed:)) (& (event type:) evMOUSEBUTTON) local0)
			(= gCardGameScriptNumber 0)
			(local0 hide: dispose:)
		)
	)
)

(class chooseTrackingView of TrackingView
	(properties)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 0)
		(if
			(and
				(not (event claimed:))
				(not (& (event type:) evMOUSERELEASE))
				(not (& (event type:) evVERB))
				(self isNotHidden:)
				(<= nsLeft (event x:) (- nsRight 1))
				(<= nsTop (event y:) (- nsBottom 1))
			)
			(cond
				((proc0_2 event)
					(self enterKey:)
					(= temp0 1)
					(event claimed: 1)
				)
				((& (event type:) evMOUSEBUTTON)
					(if (not local2)
						(local0 setCel: 1)
						(UpdateScreenItem local0)
					)
					(if (= temp0 (self track:))
						(gSound2 play: 901)
					)
					(event claimed: 1)
				)
			)
		)
		(= local2 0)
		(return temp0)
	)
)

(instance acesButton of chooseTrackingView
	(properties
		x 82
		y 107
		priority 35
		view 989
	)

	(method (init)
		(if global494
			(localproc_0 65 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6022)
			(chooseGame newRoom: 6022) ; acesup
		)
	)
)

(instance bakersButton of chooseTrackingView
	(properties
		x 82
		y 133
		view 989
		loop 1
	)

	(method (init)
		(if global495
			(localproc_0 65 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6013)
			(chooseGame newRoom: 6013) ; bakersDozen
		)
	)
)

(instance belcastlButton of chooseTrackingView
	(properties
		x 82
		y 159
		view 989
		loop 2
	)

	(method (init)
		(if global496
			(localproc_0 65 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6004)
			(chooseGame newRoom: 6004) ; beleaguered_castle
		)
	)
)

(instance bowlingButton of chooseTrackingView
	(properties
		x 82
		y 185
		view 989
		loop 3
	)

	(method (init)
		(if global497
			(localproc_0 65 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6020)
			(chooseGame newRoom: 6020) ; bowling
		)
	)
)

(instance bristolButton of chooseTrackingView
	(properties
		x 82
		y 211
		view 989
		loop 4
	)

	(method (init)
		(if global498
			(localproc_0 65 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6014)
			(chooseGame newRoom: 6014) ; bristol
		)
	)
)

(instance calculationButton of chooseTrackingView
	(properties
		x 82
		y 237
		view 989
		loop 5
	)

	(method (init)
		(if global499
			(localproc_0 65 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6001)
			(chooseGame newRoom: 6001) ; calculation
		)
	)
)

(instance canfieldButton of chooseTrackingView
	(properties
		x 82
		y 263
		view 989
		loop 6
	)

	(method (init)
		(if global500
			(localproc_0 65 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6006)
			(chooseGame newRoom: 6006) ; canfield
		)
	)
)

(instance cribbageButton of chooseTrackingView
	(properties
		x 82
		y 289
		view 989
		loop 7
	)

	(method (init)
		(if global501
			(localproc_0 65 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6028)
			(chooseGame newRoom: 6028) ; cribbagesquare
		)
	)
)

(instance eagleButton of chooseTrackingView
	(properties
		x 82
		y 315
		view 989
		loop 8
	)

	(method (init)
		(if global502
			(localproc_0 65 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6003)
			(chooseGame newRoom: 6003) ; eagleWing
		)
	)
)

(instance eightButton of chooseTrackingView
	(properties
		x 82
		y 341
		view 989
		loop 9
	)

	(method (init)
		(if global503
			(localproc_0 65 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6015)
			(chooseGame newRoom: 6015) ; eightoff
		)
	)
)

(instance eliminateButton of chooseTrackingView
	(properties
		x 279
		y 107
		view 989
		loop 10
	)

	(method (init)
		(if global504
			(localproc_0 262 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6018)
			(chooseGame newRoom: 6018) ; eliminator
		)
	)
)

(instance flowerButton of chooseTrackingView
	(properties
		x 279
		y 133
		view 989
		loop 11
	)

	(method (init)
		(if global505
			(localproc_0 262 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6008)
			(chooseGame newRoom: 6008) ; flowerGarden
		)
	)
)

(instance fortressButton of chooseTrackingView
	(properties
		x 279
		y 159
		view 989
		loop 12
	)

	(method (init)
		(if global506
			(localproc_0 262 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6012)
			(chooseGame newRoom: 6012) ; fortress
		)
	)
)

(instance gapsButton of chooseTrackingView
	(properties
		x 279
		y 185
		view 989
		loop 13
	)

	(method (init)
		(if global507
			(localproc_0 262 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6023)
			(chooseGame newRoom: 6023) ; gaps
		)
	)
)

(instance golfButton of chooseTrackingView
	(properties
		x 279
		y 211
		view 989
		loop 14
	)

	(method (init)
		(if global508
			(localproc_0 262 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6007)
			(chooseGame newRoom: 6007) ; golf
		)
	)
)

(instance klondikeButton of chooseTrackingView
	(properties
		x 279
		y 237
		view 989
		loop 15
	)

	(method (init)
		(if global509
			(localproc_0 262 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6005)
			(chooseGame newRoom: 6005) ; klondike
		)
	)
)

(instance labelleButton of chooseTrackingView
	(properties
		x 279
		y 263
		view 989
		loop 16
	)

	(method (init)
		(if global510
			(localproc_0 262 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6011)
			(chooseGame newRoom: 6011) ; laBelleLucie
		)
	)
)

(instance nestorButton of chooseTrackingView
	(properties
		x 279
		y 289
		view 989
		loop 17
	)

	(method (init)
		(if global511
			(localproc_0 262 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6021)
			(chooseGame newRoom: 6021) ; nestor
		)
	)
)

(instance penguinButton of chooseTrackingView
	(properties
		x 279
		y 315
		view 989
		loop 18
	)

	(method (init)
		(if global512
			(localproc_0 262 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6024)
			(chooseGame newRoom: 6024) ; penguin
		)
	)
)

(instance pokerButton of chooseTrackingView
	(properties
		x 279
		y 341
		view 989
		loop 19
	)

	(method (init)
		(if global513
			(localproc_0 262 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6027)
			(chooseGame newRoom: 6027) ; pokersquare
		)
	)
)

(instance pyramidButton of chooseTrackingView
	(properties
		x 478
		y 107
		view 989
		loop 20
	)

	(method (init)
		(if global514
			(localproc_0 461 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6025)
			(chooseGame newRoom: 6025) ; pyramid
		)
	)
)

(instance scorpionButton of chooseTrackingView
	(properties
		x 478
		y 133
		view 989
		loop 21
	)

	(method (init)
		(if global515
			(localproc_0 461 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6009)
			(chooseGame newRoom: 6009) ; scorpion
		)
	)
)

(instance shamrockButton of chooseTrackingView
	(properties
		x 478
		y 159
		view 989
		loop 22
	)

	(method (init)
		(if global516
			(localproc_0 461 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6016)
			(chooseGame newRoom: 6016) ; shamrocks
		)
	)
)

(instance slideButton of chooseTrackingView
	(properties
		x 478
		y 185
		view 989
		loop 23
	)

	(method (init)
		(if global517
			(localproc_0 461 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6019)
			(chooseGame newRoom: 6019) ; slide
		)
	)
)

(instance spiderButton of chooseTrackingView
	(properties
		x 478
		y 211
		view 989
		loop 24
	)

	(method (init)
		(if global518
			(localproc_0 461 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6010)
			(chooseGame newRoom: 6010) ; spiderette
		)
	)
)

(instance strategyButton of chooseTrackingView
	(properties
		x 478
		y 237
		view 989
		loop 25
	)

	(method (init)
		(if global519
			(localproc_0 461 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6002)
			(chooseGame newRoom: 6002) ; strategy
		)
	)
)

(instance tripletsButton of chooseTrackingView
	(properties
		x 478
		y 263
		view 989
		loop 26
	)

	(method (init)
		(if global520
			(localproc_0 461 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6026)
			(chooseGame newRoom: 6026) ; triplets
		)
	)
)

(instance yukonButton of chooseTrackingView
	(properties
		x 478
		y 289
		view 989
		loop 27
	)

	(method (init)
		(if global521
			(localproc_0 461 y)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= gCardGameScriptNumber 6017)
			(chooseGame newRoom: 6017) ; yukon
		)
	)
)

(instance quitButton of chooseTrackingView
	(properties
		x 363
		y 388
		view 989
		loop 28
	)

	(method (handleEvent event)
		(= local2 1)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= global748 0)
			((ScriptID 930 0) init: 9131 0 900) ; yesNo
			(DisposeScript 930)
			(if global748
				(gGame quitGame:)
			)
		)
	)
)

(instance flickButton of chooseTrackingView
	(properties
		x 312
		y 388
		view 989
		loop 29
	)

	(method (handleEvent event)
		(= local2 1)
		(if (super handleEvent: event)
			(event claimed: 1)
			(chooseGame newRoom: 6029) ; cardflick
		)
	)
)

(instance backButton of chooseTrackingView
	(properties
		x 261
		y 388
		view 989
		loop 30
	)

	(method (handleEvent event)
		(= local2 1)
		(if (super handleEvent: event)
			(event claimed: 1)
			((ScriptID 930 0) init: 9131 3 1200) ; yesNo
			(DisposeScript 930)
			(if global748
				(= global119 0)
				(gCurRoom newRoom: 2) ; intro
			)
		)
	)
)

(instance chooseGameView of chooseTrackingView
	(properties
		x 19
		y 205
		priority 35
		view 978
	)

	(method (init param1)
		(self setLoop: param1 posn: 57 18 setPri: priority)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(chooseGame newRoom: gCardGameScriptNumber)
		)
		(event claimed:)
	)
)

(instance pAllDiamonds of Prop
	(properties
		view 670
	)

	(method (init)
		(self setPri: 250)
		(gSound2 play: 3000)
		(gCurRoom setScript: sDiamondScript)
		(super init: &rest)
	)
)

(instance sDiamondScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DisableCursor)
				(= seconds 2)
			)
			(1
				(pAllDiamonds setCycle: End self)
			)
			(2
				(pAllDiamonds hide:)
				(EnableCursor)
				(self dispose:)
			)
		)
	)
)

(instance vTrailer of View
	(properties
		view 800
	)

	(method (init)
		(self setPri: 255)
		(super init: &rest)
	)
)

(instance sTrailerScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DisableCursor)
				(vTrailer init: show:)
				(= seconds 8)
			)
			(1
				(gGame quitGame:)
				(self dispose:)
			)
		)
	)
)

