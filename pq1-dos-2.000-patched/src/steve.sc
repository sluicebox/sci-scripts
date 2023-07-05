;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1018)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	steve 0
)

(instance steve of Talker
	(properties
		x 7
		y 104
		view 1018
		priority 15
		signal 16400
		talkWidth 150
		textX 100
	)

	(method (init)
		(= font gUserFont)
		(self
			name: {steve}
			view: 1018
			loop: 0
			cel: 0
			textX: 100
			textY: 0
			talkWidth: 150
			disposeWhenDone: 1
			priority: 15
			signal: 16400
		)
		(steveMouth
			view: 1018
			loop: 1
			nsLeft: 35
			nsTop: 42
			priority: 15
			signal: 16400
		)
		(super init: 0 0 steveMouth &rest)
	)
)

(instance steveMouth of Prop
	(properties
		nsTop 42
		nsLeft 35
		view 1018
		loop 1
		priority 15
		signal 16400
	)
)

