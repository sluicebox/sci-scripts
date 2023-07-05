;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64978)
(include sci.sh)
(use Main)
(use Rectangle)
(use FlipPoly)
(use Cel)
(use TextField)
(use Save)

(public
	srGetGame 0
)

(instance srGetGame of SRPlane
	(properties
		left 132
		top 83
		right 506
		bottom 310
		picture -2
	)

	(method (init param1 param2)
		(self priority: (+ 1 (GetHighPlanePri)))
		(super init: param1 param2 srCast)
	)
)

(instance srBack of Cel
	(properties
		loop 4
	)
)

(instance srCast of SRCast
	(properties)

	(method (init &tmp temp0)
		(= okButton
			((SROKButton new:)
				x: 324
				y: 58
				view:
					(switch (srGetGame type:)
						(0 4032)
						(1 4033)
						(else 4032)
					)
				loop: 5
				yourself:
			)
		)
		(= delButton
			((SRDeleteButton new:)
				x: 324
				y: 192
				view:
					(switch (srGetGame type:)
						(0 4032)
						(1 4033)
						(else 4032)
					)
				loop: 6
				yourself:
			)
		)
		(= editItem (srEdit new:))
		(= selectBox (srSelector new:))
		(= temp0 (super init: &rest))
		(srBack
			view:
				(switch (srGetGame type:)
					(0 4032)
					(1 4033)
					(else 4032)
				)
			init: plane
			priority: 10
		)
		(FrameOut)
		(return temp0)
	)
)

(instance srSelector of GamesBox
	(properties
		pageSize 12
	)

	(method (init param1 &tmp temp0 temp1 temp2 temp3 temp4)
		((= scrollBar srScroll) client: self)
		(= temp0 (super init: param1 srList srGameItem))
		(if boxRect
			(SetNowSeen boxRect)
			(= temp1 (boxRect left:))
			(= temp2 (boxRect top:))
			(= temp4 (boxRect right:))
			(= temp3 (boxRect bottom:))
			(boxRect dispose:)
			(= boxRect (Rectangle new: temp1 temp2 temp3 temp4))
		)
		(return temp0)
	)
)

(instance srEdit of SREdit
	(properties
		x 41
		y 34
		celWidth 250
	)

	(method (init)
		(super init: &rest)
		(if (== (plane type:) 2)
			(maximumGamesMessage init: plane)
		)
	)
)

(instance maximumGamesMessage of TextView
	(properties
		textLeft 1
		textTop 3
		celWidth 290
	)

	(method (init)
		(self setText: 2 1 0 1 1)
		(self setSize:)
		(super init: &rest)
		(self posn: 8 185)
		(self update:)
	)

	(method (setText)
		(if (not text)
			(= text (TextField new:))
		)
		(text font: 2108 fore: 255 back: 0 skip: 0)
		(super setText: &rest)
	)
)

(instance srList of GamesList
	(properties
		startY 72
		startX 8
		font 1007
		width 290
	)
)

(instance srGameItem of GameItem
	(properties
		textLeft 35
		celWidth 290
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)

	(method (draw)
		(if (not (not (& state $0002)))
			(text skip: 1)
		else
			(text skip: back)
		)
		(super draw: &rest)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (not (& signal $0008))
			(self setRect: x y (+ x celWidth) (+ y celHeight))
			(if (== argc 2)
				(= temp0 param1)
				(= temp1 param2)
			else
				(= temp0 (param1 x:))
				(= temp1 (param1 y:))
			)
			(return (and (<= left temp0 right) (<= top temp1 bottom)))
		)
	)
)

(instance srScroll of Scrollbar
	(properties)

	(method (init)
		(= thumbMax (- (srThumb thumbMax:) (srThumb thumbMin:)))
		(= thumbSize
			(CelHigh
				(switch (srGetGame type:)
					(0 4032)
					(1 4033)
					(else 4032)
				)
				2
				0
			)
		)
		(super init: srGetGame srDn srUp srThumb srPDn srPUp srBar)
	)

	(method (dispose)
		(= clientPosition
			(= reverseRegion
				(= physicalBar
					(= client
						(= forwardArrow
							(= reverseArrow (= thumbButton (= forwardRegion 0)))
						)
					)
				)
			)
		)
		(super dispose:)
	)
)

(instance srUp of ScrollbarArrow
	(properties
		x 303
		y 59
	)

	(method (init)
		(= view
			(switch (srGetGame type:)
				(0 4032)
				(1 4033)
				(else 4032)
			)
		)
		(= cueSelector 441)
		(super init: &rest)
	)

	(method (update)
		(= cel 0)
		(UpdateScreenItem self)
		(self setRect:)
		(FrameOut)
	)

	(method (press param1)
		(if (and argc param1)
			(self hilite: 1)
		)
		(super press: param1 &rest)
	)

	(method (handleEvent event)
		(if responder
			(responder handleEvent: event)
		else
			(cond
				((not (not (& state $0020)))
					(event localize: plane)
					(self track: event)
					(cond
						((& evMOUSERELEASE (event type:))
							(self press: 0)
							((gUser hogs:) pop:)
						)
						((not (not (& state $0002)))
							(self action:)
						)
					)
				)
				((& evMOUSEBUTTON (event type:))
					(self press: 1)
					((gUser hogs:) push: self 1)
					(gUser doit:)
				)
			)
			(event claimed: self)
		)
		(event claimed:)
	)
)

(instance srDn of ScrollbarArrow
	(properties
		x 303
		y 207
		loop 1
	)

	(method (init)
		(= view
			(switch (srGetGame type:)
				(0 4032)
				(1 4033)
				(else 4032)
			)
		)
		(= cueSelector 440)
		(super init: &rest)
	)

	(method (update)
		(= cel 0)
		(UpdateScreenItem self)
		(self setRect:)
		(FrameOut)
	)

	(method (press param1)
		(if (and argc param1)
			(self hilite: 1)
		)
		(super press: param1 &rest)
	)

	(method (handleEvent event)
		(if responder
			(responder handleEvent: event)
		else
			(cond
				((not (not (& state $0020)))
					(event localize: plane)
					(self track: event)
					(cond
						((& evMOUSERELEASE (event type:))
							(self press: 0)
							((gUser hogs:) pop:)
						)
						((not (not (& state $0002)))
							(self action:)
						)
					)
				)
				((& evMOUSEBUTTON (event type:))
					(self press: 1)
					((gUser hogs:) push: self 1)
					(gUser doit:)
				)
			)
			(event claimed: self)
		)
		(event claimed:)
	)
)

(instance srThumb of Thumb
	(properties
		x 303
		y 78
		loop 2
		thumbMax 190
		thumbMin 78
	)

	(method (init)
		(= view
			(switch (srGetGame type:)
				(0 4032)
				(1 4033)
				(else 4032)
			)
		)
		(self setPri: 600)
		(super init: &rest)
	)

	(method (update)
		(= cel 0)
		(UpdateScreenItem self)
		(self setRect:)
		(FrameOut)
	)

	(method (press param1)
		(if (and argc param1)
			(self hilite: 1)
		)
		(super press: param1 &rest)
	)

	(method (handleEvent event)
		(if responder
			(responder handleEvent: event)
		else
			(cond
				((not (not (& state $0020)))
					(event localize: plane)
					(self track: event)
					(if (& evMOUSERELEASE (event type:))
						(self press: 0)
						((gUser hogs:) pop:)
					)
					(cond
						(((client physicalBar:) onMe: event)
							(self action: event)
						)
						((not (not (not (& state $0020))))
							(self action:)
						)
					)
				)
				((& evMOUSEBUTTON (event type:))
					(self press: 1)
					(= thumbPosition (if (& state $0080) x else y))
					(-= thumbPosition thumbMin)
					(= dx (- (event x:) x))
					(= dy (- (event y:) y))
					((gUser hogs:) push: self 1)
					(gUser doit:)
				)
			)
			(event claimed: self)
		)
		(event claimed:)
	)
)

(instance srBar of Cel
	(properties
		x 303
		y 78
		loop 3
	)

	(method (init)
		(= view
			(switch (srGetGame type:)
				(0 4032)
				(1 4033)
				(else 4032)
			)
		)
		(self setPri: 40)
		(super init: &rest)
	)
)

(instance srPUp of PageRegion
	(properties
		celHeight 0
	)

	(method (init)
		(= x (srBar x:))
		(= y (srBar y:))
		(= celWidth
			(-
				(CelWide
					(switch (srGetGame type:)
						(0 4032)
						(1 4033)
						(else 4032)
					)
					3
					0
				)
				1
			)
		)
		(self setPri: 400)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if responder
			(responder handleEvent: event)
		else
			(cond
				((not (not (& state $0020)))
					(event localize: plane)
					(if (& evMOUSERELEASE (event type:))
						(self press: 0)
						((gUser hogs:) pop:)
					)
					(if (self onMe: event)
						(self action:)
					)
				)
				((& evMOUSEBUTTON (event type:))
					(self press: 1)
					((gUser hogs:) push: self 1)
					(gUser doit:)
				)
			)
			(event claimed: self)
		)
		(event claimed:)
	)
)

(instance srPDn of PageRegion
	(properties
		type 1
	)

	(method (init)
		(= x (srBar x:))
		(= y
			(+
				(srBar y:)
				(CelHigh
					(switch (srGetGame type:)
						(0 4032)
						(1 4033)
						(else 4032)
					)
					2
					0
				)
			)
		)
		(= celWidth
			(-
				(CelWide
					(switch (srGetGame type:)
						(0 4032)
						(1 4033)
						(else 4032)
					)
					3
					0
				)
				1
			)
		)
		(= celHeight
			(-
				(CelHigh
					(switch (srGetGame type:)
						(0 4032)
						(1 4033)
						(else 4032)
					)
					3
					0
				)
				(CelHigh
					(switch (srGetGame type:)
						(0 4032)
						(1 4033)
						(else 4032)
					)
					2
					0
				)
			)
		)
		(self setPri: 400)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if responder
			(responder handleEvent: event)
		else
			(cond
				((not (not (& state $0020)))
					(event localize: plane)
					(if (& evMOUSERELEASE (event type:))
						(self press: 0)
						((gUser hogs:) pop:)
					)
					(if (self onMe: event)
						(self action:)
					)
				)
				((& evMOUSEBUTTON (event type:))
					(self press: 1)
					((gUser hogs:) push: self 1)
					(gUser doit:)
				)
			)
			(event claimed: self)
		)
		(event claimed:)
	)
)

