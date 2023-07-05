;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64890)
(include sci.sh)
(use Main)
(use Str)
(use Actor)

(class TextView of View
	(properties
		back 0
		text 0
		margin 2
		height 20
		font 0
		fore 1
		skip 2
		width 300
		just 0
	)

	(method (init)
		(= bitmap (Bitmap 0 width height skip back gScreenWidth gScreenHeight)) ; Create
		(Bitmap 5 bitmap 0 0 (- width 1) (- height 1) back) ; AddRect
		(super init: &rest)
	)

	(method (dispose)
		(if text
			(text dispose:)
			(= text 0)
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

