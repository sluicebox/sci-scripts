;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Piles)
(use TrackingView)
(use Print)
(use Actor)
(use System)

(class Tray of Hand
	(properties
		owner -1
		x 90
		y 65
		nsLeft 0
		nsRight 0
		nsTop 0
		nsBottom 0
		maxCards 2
		theOkButton 0
		view 905
		disposalList 0
		hEList 0
		caller 0
	)

	(method (enterKey param1 param2)
		(= global458 param1)
		(self moveCard: (Dealer curPlayer:))
		(RedrawCast)
		(if size
			(KeyMouse
				setCursor:
					(if param2
						param2
					else
						(self at: 0)
					)
			)
		)
	)

	(method (init param1 param2 param3 &tmp temp0)
		(Piles add: self)
		(= gTray self)
		(trayParts add: aTray trayOKButton theTitle)
		(= nsLeft (+ x 30))
		(= nsRight (+ x 70))
		(= nsTop (+ y 31))
		(= nsBottom (+ y 37))
		(= centerX (+ x 50))
		(= centerY (+ y 31))
		(switch gCurRoomNum
			(300 ; heartsGame
				(= maxCards 3)
			)
			(500 ; cribbage
				(= maxCards 2)
			)
			(200 ; oldMaid
				(= maxCards 2)
			)
		)
		(= hEList param1)
		(= caller 0)
		(if (>= argc 2)
			(= caller param2)
		)
		(= disposalList
			(if (>= argc 3)
				(if (IsObject param3) param3 else 0)
			else
				(ScriptID 15 1) ; discardList
			)
		)
		(aTray init:)
		(switch gCurRoomNum
			(300 ; heartsGame
				(= temp0 (- global480 1))
			)
			(500 ; cribbage
				(= temp0 (if (== ((Dealer dealer:) location:) 3) 3 else 5))
			)
			(200 ; oldMaid
				(= temp0 4)
			)
		)
		(theTitle init: temp0)
		((= theOkButton trayOKButton) init:)
		(hEList add: self theOkButton)
	)

	(method (add param1 &tmp temp0)
		(if argc
			(if size
				(= temp0 (self at: (- size 1)))
				(temp0 setLoop: 1 forceUpd:)
			)
			(super
				add:
					(param1
						posn: (self calcNextX:) (self calcNextY:)
						setLoop: 0
						owner: self
						forceUpd:
						yourself:
					)
			)
		else
			(super add:)
		)
	)

	(method (cue)
		(gTheCard1 hide:)
		((Dealer curPlayer:)
			add: global458 (if ((Dealer curPlayer:) autoSorting:) 1 else 0)
		)
		(global458 associatedObj: 0 setPri: 2 show: forceUpd: stopUpd:)
		(= global395 0)
		(super cue:)
	)

	(method (dispose &tmp temp0)
		(self
			eachElementDo: #hide
			eachElementDo: #associatedObj 0
			eachElementDo: #owner 0
			eachElementDo: #deleteKeyMouse
		)
		(if (== gCurRoomNum 500) ; cribbage
			(= global483 (self at: 0))
			(= global484 (self at: 1))
		else
			(for ((= temp0 0)) (< temp0 size) ((++ temp0))
				(disposalList add: (self at: temp0))
			)
		)
		(self release:)
		(theOkButton deleteKeyMouse:)
		(hEList delete: self theOkButton)
		(trayParts dispose:)
		(aTray hide: dispose:)
		(theOkButton hide: dispose:)
		(RedrawCast)
		(= theOkButton 0)
		(Piles delete: self)
		(if (not (Piles size:))
			(Piles dispose:)
		)
		(= gTray 0)
		(super dispose:)
		(DisposeScript 18)
	)

	(method (doCode)
		(return 1)
	)

	(method (checkCard param1)
		(proc15_0 self param1)
	)

	(method (isValid)
		(return 1)
	)

	(method (calcNextX)
		(return (+ x 18 (* size 8)))
	)

	(method (calcNextY)
		(return (+ y 15))
	)

	(method (setCard param1 &tmp temp0)
		(= global291 (+ 2 size))
		(param1
			setPri: 14
			flip: 1
			posn: (self calcNextX:) (self calcNextY:)
			setLoop: 0
			forceUpd:
			stopUpd:
			show:
			associatedObj: trayParts
		)
		(self add: param1)
		(RedrawCast)
		(gSound play: 907)
	)

	(method (posn &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			((self at: temp0)
				setPri: 14
				posn: (+ x 18 (* temp0 8)) (+ y 15)
				setLoop: (if (!= temp0 (- size 1)) 1 else 0)
				forceUpd:
				stopUpd:
			)
		)
	)

	(method (validPlay param1)
		(if (== (param1 owner:) self)
			(return 0)
		)
		(if (== size maxCards)
			(gSound play: 905)
			(Message msgGET 18 1 0 0 1 @global550) ; "You have tried to put too many cards into the tray."
			(Print addText: @global550 init:)
			(return 0)
		)
		(switch gCurRoomNum
			(300 1) ; heartsGame
			(500 1) ; cribbage
			(200 ; oldMaid
				(if (and (== size 1) (!= (param1 rank:) ((self at: 0) rank:)))
					(gSound play: 905)
					(Message msgGET 18 2 0 0 1 @global550) ; "That card does not form a pair. Place cards of the same rank into the tray."
					(Print addText: @global550 init:)
					(return 0)
				)
			)
		)
		(return 1)
	)

	(method (okPressed)
		(if (!= size maxCards)
			(gSound play: 905)
			(Message msgGET 18 3 0 0 1 @global550) ; "You must place more cards into the tray."
			(if (== global193 500)
				(Print posn: 20 90)
			)
			(Print addText: @global550 init:)
			(return)
		)
		(self dispose:)
		(if caller
			(caller cue:)
		)
	)
)

(instance aTray of View
	(properties)

	(method (init)
		(self
			view: 905
			setLoop: 0
			posn: (gTray x:) (gTray y:)
			setPri: 4
			ignoreActors:
			stopUpd:
			show:
		)
		(super init:)
	)
)

(instance theTitle of View
	(properties)

	(method (init param1)
		(self
			view: 905
			setLoop: 2
			cel: param1
			posn: (+ (gTray x:) 17) (+ (gTray y:) 30)
			setPri: 6
			ignoreActors:
			stopUpd:
			show:
		)
		(super init:)
	)
)

(instance trayOKButton of TrackingView
	(properties)

	(method (init)
		(self
			view: 905
			setLoop: 1
			posn: (+ (aTray x:) 101) (+ (aTray y:) 13)
			setPri: 5
			ignoreActors:
			stopUpd:
			show:
		)
		(self addKeyMouse:)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(gTray okPressed:)
		)
		(event claimed:)
	)
)

(instance trayParts of List
	(properties)
)

