;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 233)
(include sci.sh)
(use Main)
(use GloryWindow)
(use IconBar)
(use GameControls)

(public
	proc233_0 0
)

(local
	local0
	local1
	local2
)

(procedure (proc233_0 &tmp temp0 temp1)
	(= temp1 gTheCursor)
	(= temp0 (Message msgSIZE 230 1 6 70 1)) ; "Exchange to Royals"
	(= local1 (Memory memALLOC_NONCRIT temp0))
	(Message msgGET 230 1 6 70 1 local1) ; "Exchange to Royals"
	(= temp0 (Message msgSIZE 230 1 6 71 1)) ; "All Done"
	(= local2 (Memory memALLOC_NONCRIT temp0))
	(Message msgGET 230 1 6 71 1 local2) ; "All Done"
	(quest init: show: dispose:)
	(Memory memFREE local1)
	(Memory memFREE local2)
	(if local0
		(if global424
			(gEgo solvePuzzle: 213 4)
			((gInventory at: 0) amount: (/ (* 9 global424) 10) message: 10) ; theRoyals
			(= global424 0)
		else
			((gInventory at: 0) ; theRoyals
				amount: (+ ((gInventory at: 0) amount:) (/ global410 100)) ; theRoyals
			)
			(= global410 (mod global410 100))
		)
		(gMessager say: 1 6 19)
	)
	(gGame setCursor: temp1)
	(DisposeScript 233)
)

(instance quest of GameControls
	(properties)

	(method (init)
		(gGame setCursor: 999)
		((= window (GloryWindow new:))
			top: 60
			left: 80
			bottom: 145
			right: 240
			priority: 15
			yourself:
		)
		(self add: moneyIcon yesIcon noIcon)
		(super init: &rest)
	)
)

(instance moneyIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 0
		signal 4
		maskView 361
		maskLoop 3
	)

	(method (show &tmp [temp0 30] [temp30 30] [temp60 40] [temp100 30] [temp130 30])
		(Graph grDRAW_LINE 13 1 13 160 58 -1 -1)
		(Graph grUPDATE_BOX 12 1 14 160 1)
		(Message msgGET 230 1 6 69 1 @temp60) ; "Khali's Money Exchange"
		(Display @temp60 dsCOORD 5 3 dsCOLOR 0)
		(Message msgGET 230 1 6 70 3 @temp60) ; "You have:"
		(Display @temp60 dsCOORD 0 20 dsCOLOR 17)
		(if global424
			(Message msgGET 230 1 6 86 1 @temp0) ; "Dinars: %-7d"
			(Format @temp100 @temp0 global424)
			(Display @temp100 dsCOORD 0 36 dsCOLOR 19)
		else
			(Message msgGET 230 1 6 87 1 @temp0) ; "Royals:   %-7d"
			(Format @temp100 @temp0 ((gInventory at: 0) amount:)) ; theRoyals
			(Message msgGET 230 1 6 88 1 @temp30) ; "Commons: %5d"
			(Format @temp130 @temp30 global410)
			(Display @temp100 dsCOORD 0 30 dsCOLOR 19)
			(Display @temp130 dsCOORD 0 40 dsCOLOR 19)
		)
	)
)

(instance yesIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 55
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local0 1)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display local1 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display local1 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance noIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 70
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local0 0)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show &tmp [temp0 15])
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display local2 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display local2 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

