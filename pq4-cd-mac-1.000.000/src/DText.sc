;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64915)
(include sci.sh)
(use Main)
(use DItem)
(use Array)
(use System)

(class DText of DItem
	(properties
		type 2
		textLeft 0
		textTop 0
		textRight 0
		textBottom 0
		text 0
		mode 0
		fore 0
		back 254
		skip 254
		font 1
		borderColor -1
		dimmed 0
		rects 0
	)

	(method (init)
		(self draw:)
		(super init: &rest)
	)

	(method (dispose keepText &tmp bm)
		(if (or (not argc) (not keepText))
			(KString 4 text) ; StrFree
		)
		(if rects
			(rects dispose:)
			(= rects 0)
		)
		(= bm 0)
		(if bitmap
			(= bm bitmap)
			(= bitmap 0)
		)
		(super dispose:)
		(if bm
			(Bitmap 1 bm) ; Dispose
		)
	)

	(method (new)
		((super new:) font: gUserFont yourself:)
	)

	(method (setSize w &tmp r margin theX theY theWidth)
		(= margin (if (!= borderColor -1) 3 else 0))
		(= theWidth
			(cond
				((!= view -1)
					(- (CelWide view loop cel) (* margin 2))
				)
				(argc w)
				(else 0)
			)
		)
		(= textTop (= textLeft 0))
		(= r (IntArray with: 0 0 0 0))
		(TextSize (r data:) text font theWidth)
		(= textRight (+ textLeft (r at: 2)))
		(= textBottom (+ textTop (r at: 3)))
		(r dispose:)
		(= nsTop (= nsLeft 0))
		(if (== view -1)
			(+= textLeft margin)
			(+= textTop margin)
			(+= textRight margin)
			(+= textBottom margin)
			(= nsRight (+ textRight margin))
			(= nsBottom (+ textBottom margin))
		else
			(= theX (CelWide view loop cel))
			(= theY (CelHigh view loop cel))
			(= nsRight (+ nsLeft (- theX 1)))
			(= nsBottom (+ nsTop (- theY 1)))
			(= margin (/ (- theX (+ (- textRight textLeft) 1)) 2))
			(+= textLeft margin)
			(+= textRight margin)
			(= margin (/ (- theY (+ (- textBottom textTop) 1)) 2))
			(+= textTop margin)
			(+= textBottom margin)
		)
	)

	(method (handleEvent event &tmp rect t l b r)
		(if
			(and
				gTextCode
				rects
				(or
					(OneOf (event type:) evMOUSEBUTTON $0020) ; joyUp
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
			)
			(= rect -1)
			(event globalize: claimed: 1)
			(while (!= (rects at: (+ rect 1)) 30583)
				(= l (rects at: (++ rect)))
				(= t (rects at: (++ rect)))
				(= r (rects at: (++ rect)))
				(= b (rects at: (++ rect)))
				(if
					(and
						(<= l (event x:) r)
						(<= t (event y:) b)
					)
					(gTextCode doit: (/ rect 4))
					(event type: evNULL claimed: 0)
					(break)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (draw &tmp oldBM)
		(if (= oldBM bitmap)
			(DeleteScreenItem self)
			(Bitmap 1 bitmap) ; Dispose
		)
		(= bitmap
			(if (!= view -1)
				(CreateTextBitmap 1 self)
			else
				(CreateTextBitmap
					0
					(+ (- nsRight nsLeft) 1)
					(+ (- nsBottom nsTop) 1)
					self
				)
			)
		)
		(if oldBM
			(AddScreenItem self)
		)
	)
)

