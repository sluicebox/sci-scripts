;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64917)
(include sci.sh)
(use Main)
(use Styler)
(use DText)
(use Array)
(use User)
(use Actor)
(use System)

(class Plane of Obj
	(properties
		back 0
		priority -1
		casts 0
		vanishingY 0
		vanishingX 0
		style 0
		picture -1
		resX -1
		resY -1
		coordType 0
		mirrored 0
		bitmap 0
		inBottom 0
		inLeft 0
		inRight 0
		inTop 0
		left 0
		right 0
		bottom 0
		top 0
		theFtrs 0
		extMH 0
	)

	(method (doit)
		(if casts
			(casts doit:)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (and extMH (extMH handleEvent: event))
			(return 1)
		)
		(if (and (gUser input:) (& (event type:) evVERB))
			(cond
				(gUseSortedFeatures
					(OnMeAndLowY init:)
					(if (not (casts isKindOf: Cast))
						(casts
							eachElementDo: #eachElementDo 11 OnMeAndLowY event
						)
					else
						(casts eachElementDo: #perform OnMeAndLowY event)
					)
					(theFtrs eachElementDo: #perform OnMeAndLowY event)
					(if
						(and
							(OnMeAndLowY theObj:)
							((OnMeAndLowY theObj:) handleEvent: event)
						)
						(return 1)
					)
				)
				((casts handleEvent: event)
					(return 1)
				)
				((theFtrs handleEvent: event)
					(return 1)
				)
			)
			(if (and (not (event claimed:)) (gRegions handleEvent: event))
				(return 1)
			)
		)
	)

	(method (addCast castList)
		(casts add: (castList add: plane: self yourself:))
	)

	(method (deleteCast castList)
		(casts delete: (castList plane: 0 yourself:))
	)

	(method (addFeature)
		(if (and argc theFtrs)
			(theFtrs addToFront: &rest)
		)
	)

	(method (deleteFeature)
		(if (not theFtrs)
			(return)
		)
		(theFtrs delete: &rest)
	)

	(method (addExtMH)
		(if argc
			(if (not extMH)
				(= extMH (EventHandler new:))
			)
			(extMH addToFront: &rest)
		)
	)

	(method (deleteExtMH)
		(if (not extMH)
			(return)
		)
		(extMH delete: &rest)
	)

	(method (dispose)
		(casts delete: gCast dispose:)
		(theFtrs eachElementDo: #dispose dispose:)
		(if extMH
			(extMH release: dispose:)
		)
		(= casts (= bitmap (= theFtrs (= extMH 0))))
		(gPlanes delete: self)
		(DeletePlane self)
		(super dispose:)
	)

	(method (drawPic thePic theStyle)
		(= picture thePic)
		(if (> argc 1)
			(= style theStyle)
		)
		(= mirrored (if (& style $0400) 1 else 0))
		(UpdatePlane self)
		(Styler doit: self style)
	)

	(method (findCast theName &tmp node theList)
		(for
			((= node (KList 3 (casts elements:)))) ; FirstNode
			node
			((= node (casts nextNode:)))
			
			(casts nextNode: (KList 6 node)) ; NextNode
			(= theList (KList 8 node)) ; NodeValue
			(if (not (KString 7 (theList name:) theName)) ; StrCmp
				(return theList)
			)
		)
		(return 0)
	)

	(method (init l t r b il it_ ir ib)
		(gPlanes add: self)
		(if (== resX -1)
			(= resX gScreenWidth)
		)
		(if (== resY -1)
			(= resY gScreenHeight)
		)
		(if argc
			(self setRect: l t r b)
			(if (> argc 4)
				(self setInsetRect: il it_ ir ib)
			)
		)
		(AddPlane self)
		(= casts (Set new:))
		(= theFtrs (EventHandler new:))
	)

	(method (onMe theObjOrX theY &tmp oX oY)
		(if (== argc 1)
			(= oX (theObjOrX x:))
			(= oY (theObjOrX y:))
		else
			(= oX theObjOrX)
			(= oY theY)
		)
		(return (and (<= left oX right) (<= top oY bottom)))
	)

	(method (posn x y onPlane &tmp pWidth pHeight l t r b p noCenter)
		(cond
			((> argc 2)
				(= l (onPlane left:))
				(= t (onPlane top:))
				(= r (onPlane right:))
				(= b (onPlane bottom:))
			)
			((and gCurRoom (= p (gCurRoom plane:)))
				(= l (p left:))
				(= t (p top:))
				(= r (p right:))
				(= b (p bottom:))
			)
			(else
				(= l 0)
				(= t 0)
				(= r gLastScreenX)
				(= b gLastScreenY)
			)
		)
		(= pWidth (- right left))
		(= pHeight (- bottom top))
		(if (== x -1)
			(= x (+ l (/ (- (- r l) pWidth) 2)))
		else
			(+= x l)
		)
		(if (== y -1)
			(= y (+ t (/ (- (- b t) pHeight) 2)))
		else
			(+= y t)
		)
		(self setRect: x y (+ x pWidth) (+ y pHeight))
	)

	(method (scaleBitmap sLeft sTop sRight sBottom &tmp w1 w2 h1 h2 xs ys scaling l t r b)
		(if argc
			(= l sLeft)
			(= t sTop)
			(= r sRight)
			(= b sBottom)
		else
			(= l left)
			(= t top)
			(= r right)
			(= b bottom)
		)
		(= w2 (CelWide (bitmap view:) (bitmap loop:) (bitmap cel:)))
		(= h2 (CelHigh (bitmap view:) (bitmap loop:) (bitmap cel:)))
		(= w1 (+ (- r l) 1))
		(= h1 (+ (- b t) 1))
		(if (< w1 250)
			(= xs (/ (* w1 128) w2))
		else
			(= xs (* (/ (* (/ w1 2) 128) w2) 2))
		)
		(= ys (/ (* h1 128) h2))
		(bitmap scaleSignal: 1 scaleX: xs scaleY: ys)
		(UpdateScreenItem bitmap)
	)

	(method (setBitmap v l c scale &tmp newCast w h scaling)
		(= scaling 0)
		(if bitmap
			(bitmap dispose:)
			(= newCast (self findCast: {planeBM}))
		else
			((= newCast (Cast new:)) name: {planeBM})
			(self addCast: newCast)
		)
		(if (< argc 3)
			((= bitmap (v new:)) posn: 0 0 init: newCast)
			(if (> argc 1)
				(= scaling l)
			)
		else
			((= bitmap (View new:))
				view: v
				loop: l
				cel: c
				posn: 0 0
				init: newCast
			)
			(if (> argc 3)
				(= scaling scale)
			)
		)
		(= w (CelWide (bitmap view:) (bitmap loop:) (bitmap cel:)))
		(= h (CelHigh (bitmap view:) (bitmap loop:) (bitmap cel:)))
		(if scaling
			(self scaleBitmap:)
		else
			(self setRect: left top (+ left w) (+ top h))
		)
	)

	(method (setInsetRect il it_ ir ib)
		(= inLeft il)
		(= inTop it_)
		(= inRight ir)
		(= inBottom ib)
	)

	(method (setRect l t r b doUpdate)
		(= left l)
		(= top t)
		(= right r)
		(= bottom b)
		(self setInsetRect: l t r bottom)
		(if (and bitmap (& (bitmap scaleSignal:) $0001))
			(self scaleBitmap:)
		)
		(if (and (> argc 4) doUpdate)
			(UpdatePlane self)
		)
	)

	(method (setSize &tmp r b node1 node2 theList obj)
		(= r (= b 0))
		(for
			((= node1 (KList 3 (casts elements:)))) ; FirstNode
			node1
			((= node1 (casts nextNode:)))
			
			(casts nextNode: (KList 6 node1)) ; NextNode
			(= theList (KList 8 node1)) ; NodeValue
			(for
				((= node2 (KList 3 (theList elements:)))) ; FirstNode
				node2
				((= node2 (theList nextNode:)))
				
				(theList nextNode: (KList 6 node2)) ; NextNode
				(= obj (KList 8 node2)) ; NodeValue
				(if (> (obj nsRight:) r)
					(= r (obj nsRight:))
				)
				(if (> (obj nsBottom:) b)
					(= b (obj nsBottom:))
				)
			)
		)
		(self setRect: left top (+ left r) (+ top b))
	)

	(method (setTitle theText &tmp [temp0 2] temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(self addCast: ((= temp2 (Cast new:)) name: {titleCast} yourself:))
		((= temp10 (DText new:))
			fore: 255
			back: 0
			font: 0
			text: theText
			posn: 0 0
		)
		(= temp3 (IntArray new:))
		(Text 0 (temp3 data:) theText 0 -1) ; TextSize
		(= temp4 (+ (temp3 at: 3) 12))
		(temp10 nsLeft: 0 nsTop: 0 nsRight: (- right left) nsBottom: temp4)
		(= temp11 (- (temp10 nsRight:) (temp10 nsLeft:)))
		(= temp12 (- (temp3 at: 2) (temp3 at: 0)))
		(= temp13 (/ (- temp11 temp12) 2))
		(temp10
			textLeft: temp13
			textTop: 2
			textRight: (+ temp13 temp12 8)
			textBottom: temp4
			init: temp2
		)
		(temp3 dispose:)
		(= temp5 (+ (- bottom top) 1))
		(if (< top temp4)
			(= top 0)
		else
			(-= top temp4)
		)
		(self setRect: left top right (+ top temp5 temp4) 1)
		(for
			((= temp6 (KList 3 (casts elements:)))) ; FirstNode
			temp6
			((= temp6 (casts nextNode:)))
			
			(casts nextNode: (KList 6 temp6)) ; NextNode
			(= temp8 (KList 8 temp6)) ; NodeValue
			(for
				((= temp7 (KList 3 (temp8 elements:)))) ; FirstNode
				temp7
				((= temp7 (temp8 nextNode:)))
				
				(temp8 nextNode: (KList 6 temp7)) ; NextNode
				(if (!= (= temp9 (KList 8 temp7)) temp10) ; NodeValue
					(temp9
						y: (+ (temp9 y:) temp4)
						nsTop: (+ (temp9 nsTop:) temp4)
						nsBottom: (+ (temp9 nsBottom:) temp4)
					)
					(UpdateScreenItem temp9)
				)
			)
		)
	)
)

