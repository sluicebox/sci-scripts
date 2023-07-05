;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1247)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	carol 0
)

(instance carol of Talker
	(properties
		x 229
		y 106
		view 1247
		priority 15
		signal 16400
		talkWidth 150
		textX -180
	)

	(method (init)
		(= font gUserFont)
		(self
			name: {carol}
			view: 1247
			loop: 0
			cel: 0
			textX: -180
			textY: 0
			talkWidth: 150
			disposeWhenDone: 1
			priority: 15
			signal: 16400
		)
		(carolMouth
			view: 1247
			loop: 1
			nsLeft: 39
			nsTop: 39
			priority: 15
			signal: 16400
		)
		(super init: 0 0 carolMouth &rest)
	)
)

(instance carolMouth of Prop
	(properties
		nsTop 39
		nsLeft 35
		view 1247
		loop 1
		priority 15
		signal 16400
	)
)

