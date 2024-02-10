;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 781)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use klondike)
(use Conversation)
(use System)

(public
	score2Bridge 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2 param3)
	(if (and (!= argc 4) (not param1))
		(return)
	)
	(if (>= param1 10000)
		(DrawCel 781 4 (/ param1 10000) param2 param3 15)
	)
	(if (>= param1 1000)
		(DrawCel 781 4 (mod (/ param1 1000) 10) (+ param2 6) param3 15)
	)
	(if (>= param1 100)
		(DrawCel 781 4 (mod (/ param1 100) 10) (+ param2 12) param3 15)
	)
	(if (>= param1 10)
		(DrawCel 781 4 (mod (/ param1 10) 10) (+ param2 18) param3 15)
	)
	(if (>= param1 0)
		(DrawCel 781 4 (mod param1 10) (+ param2 24) param3 15)
	)
)

(procedure (localproc_1)
	(= local0 gGameControls)
	(HandsOn)
	((= gGameControls bridgeScore2)
		window: bridgeScore2Window
		notActive: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK noClickHelp: iconOK sRight: 57 yourself:)
	)
	(gGameControls yLast:)
	(if (not (HaveMouse))
		(global114 x: (+ 125 (iconOK nsLeft:)) y: (+ 61 (iconOK nsTop:)))
		(SetCursor (global114 x:) (global114 y:))
	)
)

(instance score2Bridge of Code
	(properties)

	(method (init)
		(localproc_1)
	)
)

(instance bridgeScore2Window of InvisibleWindow
	(properties
		top 48
		left 105
		bottom 180
		right 297
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 781 0 0 0 0 15)
		(DrawCel
			781
			2
			(or (EmptyCol outOfClubs:) (EmptyCol group3List:))
			7
			113
			15
		)
		(DrawCel 781 3 0 7 60 15)
		(DrawCel
			781
			1
			(if (or (EmptyCol setPassTo:) (EmptyCol bestGroup:)) 0 else 1)
			10
			49
			15
		)
		(localproc_0 (EmptyCol outOfClubs:) 100 8)
		(localproc_0 (EmptyCol outOfDiamonds:) 100 19)
		(localproc_0 (EmptyCol outOfHearts:) 100 30)
		(localproc_0 (EmptyCol showPassCards:) 100 41)
		(localproc_0 (EmptyCol passCards:) 100 52)
		(localproc_0 (EmptyCol setPassTo:) 100 52)
		(localproc_0 (EmptyCol makeSuitList:) 100 63 1)
		(localproc_0 (EmptyCol passTo:) 100 80)
		(localproc_0 (EmptyCol passActor:) 100 91)
		(localproc_0 (EmptyCol outOfSpades:) 100 102)
		(localproc_0 (EmptyCol addPassCards:) 100 115 1)
		(localproc_0 (EmptyCol group3List:) 151 8)
		(localproc_0 (EmptyCol deadWoodList:) 151 19)
		(localproc_0 (EmptyCol inARun:) 151 30)
		(localproc_0 (EmptyCol ofAKind:) 151 41)
		(localproc_0 (EmptyCol theGroup:) 151 52)
		(localproc_0 (EmptyCol bestGroup:) 151 52)
		(localproc_0 (EmptyCol offRating:) 151 63 1)
		(localproc_0 (EmptyCol carList:) 151 80)
		(localproc_0 (EmptyCol group1List:) 151 91)
		(localproc_0 (EmptyCol group2List:) 151 102)
		(localproc_0 (EmptyCol playOff:) 151 115 1)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance bridgeScore2 of HoyleGameControls
	(properties)
)

(instance iconOK of MessageObj
	(properties
		modNum 781
		noun 6
		case 9
		sequence 85
		font -1
		x 16384
		y -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

