;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64914)
(include sci.sh)
(use DText)
(use Array)

(class DEdit of DText
	(properties
		state 1
		type 3
		borderColor 0
		width 0
		title 0
		titleFore 0
		titleBack 0
		titleFont 0
		frameOut 1
		lastKey 0
	)

	(method (dispose)
		(super dispose: 1)
	)

	(method (hilite tOrF &tmp origBM)
		(if (and argc tOrF)
			(= origBM bitmap)
			(= bitmap 0)
			(DeleteScreenItem self)
			(if (EditText self)
				(Bitmap 1 origBM) ; Dispose
				(self draw:)
			else
				(= bitmap origBM)
			)
			(AddScreenItem self)
		)
	)

	(method (setSize &tmp r margin w)
		(= margin (if (!= borderColor -1) 2 else 0))
		(= nsTop (= nsLeft 0))
		(= textTop (= textLeft margin))
		(if (== view -1)
			(= r (IntArray with: 0 0 0 0))
			(TextSize (r data:) {M} font 0)
			(= w (* (+ (r at: 2) 1) width))
			(= nsRight (+ nsLeft w (* margin 2)))
			(= nsBottom (+ nsTop (r at: 3) (- (* margin 2) 1)))
			(= textRight (+ textLeft w))
			(= textBottom (+ textTop (r at: 3)))
			(r dispose:)
		else
			(= nsRight (+ nsLeft (CelWide view loop cel)))
			(= nsBottom (+ nsTop (CelHigh view loop cel)))
			(= textRight (- nsRight margin))
			(= textBottom (- nsBottom margin))
		)
	)
)

