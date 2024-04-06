;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10700)
(include sci.sh)
(use Main)
(use Actor)

(public
	proc10700_0 0
)

(procedure (proc10700_0 param1)
	(if (!= param1 -1)
		(gCurRoom drawPic: param1 picture: param1)
	)
	(switch (gCurRoom picture:)
		(10601
			(tableLight
				view: 10601
				x: 156
				y: 23
				setPri: 4
				approachVerbs: 0
				setHotspot: 0
				init:
			)
		)
		(10650
			(tableLight
				view: 10651
				x: 113
				y: 38
				setPri: 4
				approachVerbs: 0
				setHotspot: 0
				init:
			)
		)
		(10655
			(tableLight
				view: 10656
				x: 108
				y: 32
				setPri: 4
				approachVerbs: 0
				setHotspot: 0
				init:
			)
		)
		(10700
			(tableLight
				view: 10701
				x: 175
				y: 28
				setPri: 4
				approachVerbs: 0
				setHotspot: 0
				init:
			)
		)
		(10705
			(tableLight
				view: 10706
				x: 188
				y: 37
				setPri: 4
				approachVerbs: 0
				setHotspot: 0
				init:
			)
		)
		(10715
			(tableLight
				view: 10716
				x: 22
				y: 23
				setPri: 4
				approachVerbs: 0
				setHotspot: 0
				init:
			)
		)
		(10745
			(tableLight
				view: 10746
				x: 56
				y: 21
				setPri: 4
				approachVerbs: 0
				setHotspot: 0
				init:
			)
		)
		(else
			(if (gCast contains: tableLight)
				(tableLight dispose:)
			)
		)
	)
)

(instance tableLight of View
	(properties)
)

