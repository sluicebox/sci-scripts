;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64890)
(include sci.sh)
(use Main)
(use Str)
(use Actor)

(class TextView of View
	(properties
		text 0
		font 0
		just 0
		fore 1
		back 0
		skip 2
		width 300
		height 20
		margin 2
	)

	(method (init)
		(= bitmap (Bitmap 0 width height skip back gScreenWidth gScreenHeight)) ; Create
		(Bitmap 5 bitmap 0 0 (- width 1) (- height 1) back) ; AddRect
		(super init: &rest)
	)

	(method (dispose)
		(if text
			(text dispose:)
		)
		(super dispose: &rest)
	)

	(method (draw)
		(if argc
			(if (not text)
				(= text (Str new:))
			)
			(text format: &rest)
		)
		(Bitmap 5 bitmap 0 0 (- width 1) (- height 1) back) ; AddRect
		(Bitmap
			4 ; AddText
			bitmap
			(text data:)
			margin
			margin
			(- width (+ margin 1))
			(- height (+ margin 1))
			fore
			back
			skip
			font
			just
			back
			0
		)
		(UpdateScreenItem self)
	)
)

