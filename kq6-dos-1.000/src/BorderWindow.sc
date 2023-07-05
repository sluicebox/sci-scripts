;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 936)
(include sci.sh)
(use Window)

(procedure (DrawBeveledWindow t l b r theColor topColor leftColor bottomColor rightColor theBevelWid theShadowWid thePri theMaps &tmp savePort i)
	(= savePort (GetPort))
	(SetPort 0)
	(Graph grFILL_BOX t l (+ b 1) (+ r 1) theMaps theColor thePri)
	(-= t theBevelWid)
	(-= l theBevelWid)
	(+= r theBevelWid)
	(+= b theBevelWid)
	(Graph grFILL_BOX t l (+ t theBevelWid) r theMaps topColor thePri)
	(Graph grFILL_BOX (- b theBevelWid) l b r theMaps bottomColor thePri)
	(for ((= i 0)) (< i theBevelWid) ((++ i))
		(Graph
			grDRAW_LINE
			(+ t i)
			(+ l i)
			(- b (+ i 1))
			(+ l i)
			leftColor
			thePri
			-1
		)
		(Graph
			grDRAW_LINE
			(+ t i)
			(- r (+ i 1))
			(- b (+ i 1))
			(- r (+ i 1))
			rightColor
			thePri
			-1
		)
	)
	(if theShadowWid
		(Graph
			grFILL_BOX
			(+ t theShadowWid)
			r
			(+ b theShadowWid)
			(+ r theShadowWid)
			theMaps
			0
			thePri
		)
		(Graph
			grFILL_BOX
			b
			(+ l theShadowWid)
			(+ b theShadowWid)
			r
			theMaps
			0
			thePri
		)
	)
	(SetPort savePort)
)

(procedure (PushOnScreen wind &tmp dX dY) ; UNUSED
	(= dY
		(cond
			((> (wind bottom:) 185)
				(- 185 (wind bottom:))
			)
			((< (wind top:) 10)
				(- 10 (wind top:))
			)
			(else 0)
		)
	)
	(= dX
		(cond
			((> (wind right:) 315)
				(- 315 (wind right:))
			)
			((< (wind left:) 5)
				(- 5 (wind left:))
			)
			(else 0)
		)
	)
	(wind
		top: (+ (wind top:) dY)
		bottom: (+ (wind bottom:) dY)
		left: (+ (wind left:) dX)
		right: (+ (wind right:) dX)
	)
)

(class BorderWindow of SysWindow
	(properties
		back 5
		topBordColor 7
		lftBordColor 6
		rgtBordColor 4
		botBordColor 3
		bevelWid 3
		shadowWid 2
	)

	(method (open &tmp savePort wMap)
		(SetPort 0)
		(= wMap 1)
		(if (!= priority -1)
			(|= wMap $0002)
		)
		(= lsTop (- top bevelWid))
		(= lsLeft (- left bevelWid))
		(= lsRight (+ right bevelWid shadowWid))
		(= lsBottom (+ bottom bevelWid shadowWid))
		(= type 128)
		(super open:)
		(DrawBeveledWindow
			top
			left
			bottom
			right
			back
			topBordColor
			lftBordColor
			botBordColor
			rgtBordColor
			bevelWid
			shadowWid
			priority
			wMap
		)
		(= savePort (GetPort))
		(SetPort 0)
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(SetPort savePort)
	)

	(method (dispose)
		(super dispose:)
		(SetPort 0)
	)
)

(class InsetWindow of BorderWindow
	(properties
		topBordColor 5
		lftBordColor 4
		rgtBordColor 2
		botBordColor 1
		ck 3
		insideColor 2
		topBordColor2 0
		lftBordColor2 1
		botBordColor2 5
		rgtBordColor2 4
		topBordHgt 10
		botBordHgt 24
		sideBordWid 2
		shadWid 0
		bevWid 2
		xOffset 0
		yOffset 0
	)

	(method (open &tmp wMap savePort saveTop saveLeft saveBot saveRight)
		(= wMap 1)
		(if (!= priority -1)
			(|= wMap $0002)
		)
		(= saveTop top)
		(= saveLeft left)
		(= saveBot bottom)
		(= saveRight right)
		(-= top (+ bevelWid topBordHgt))
		(-= left (+ bevelWid sideBordWid))
		(+= bottom (+ bevelWid botBordHgt))
		(+= right (+ bevelWid sideBordWid))
		(= xOffset (+ bevelWid sideBordWid))
		(= yOffset (+ bevelWid topBordHgt))
		(super open:)
		(DrawBeveledWindow
			saveTop
			saveLeft
			saveBot
			saveRight
			insideColor
			topBordColor2
			lftBordColor2
			botBordColor2
			rgtBordColor2
			bevWid
			shadWid
			priority
			wMap
		)
		(= savePort (GetPort))
		(SetPort 0)
		(Graph
			grUPDATE_BOX
			(- saveTop bevWid)
			(- saveLeft bevWid)
			(+ saveBot bevWid)
			(+ saveRight bevWid)
			1
		)
		(SetPort savePort)
	)
)

