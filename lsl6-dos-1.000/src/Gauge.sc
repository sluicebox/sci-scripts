;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 987)
(include sci.sh)
(use Main)
(use Interface)
(use Dialog)
(use Window)

(local
	textI
	upI
	downI
	gaugeI
	okI
	normalI
	noI
	[str 100]
)

(class Gauge of Dialog
	(properties
		description 0
		higher {up}
		lower {down}
		normal 7
		minimum 0
		maximum 15
	)

	(method (init value &tmp dx dy)
		(= window SysWindow)
		(self update: value)
		((= downI (DButton new:)) text: lower moveTo: 4 4 setSize:)
		(self add: downI setSize:)
		((= gaugeI (DText new:))
			text: @str
			moveTo: (+ (downI nsRight:) 4) 4
			font: 0
			setSize:
		)
		(self add: gaugeI setSize:)
		((= upI (DButton new:))
			text: higher
			moveTo: (+ (gaugeI nsRight:) 4) 4
			setSize:
		)
		(self add: upI setSize:)
		(+= nsBottom 8)
		((= okI (DButton new:)) text: {OK} setSize: moveTo: 4 nsBottom)
		((= normalI (DButton new:))
			text: {Normal}
			setSize:
			moveTo: (+ (okI nsRight:) 4) nsBottom
		)
		((= noI (DButton new:))
			text: {Cancel}
			setSize:
			moveTo: (+ (normalI nsRight:) 4) nsBottom
		)
		(self add: okI normalI noI setSize:)
		(= dx (- (- nsRight (noI nsRight:)) 4))
		((= textI (DText new:))
			text: description
			font: gSmallFont
			setSize: (- nsRight 8)
			moveTo: 4 4
		)
		(= dy (+ (textI nsBottom:) 4))
		(self add: textI)
		(upI move: 0 dy)
		(downI move: 0 dy)
		(gaugeI move: 0 dy)
		(okI move: dx dy)
		(normalI move: dx dy)
		(noI move: dx dy)
		(self setSize: center: open: 4 15)
	)

	(method (doit value &tmp i ret)
		(self init: value)
		(= ret value)
		(repeat
			(self update: ret)
			(gaugeI draw:)
			(cond
				((== (= i (super doit: okI)) upI)
					(if (< ret maximum)
						(++ ret)
					)
				)
				((== i downI)
					(if (> ret minimum)
						(-- ret)
					)
				)
				((== i okI)
					(break)
				)
				((== i normalI)
					(= ret normal)
				)
				((or (== i 0) (== i noI))
					(= ret value)
					(break)
				)
			)
		)
		(self dispose:)
		(return ret)
	)

	(method (update value &tmp i range)
		(= range (- maximum minimum))
		(for ((= i 0)) (< i range) ((++ i))
			(StrAt @str i (if (< i value) 6 else 7))
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(switch (event message:)
					(KEY_LEFT
						(event claimed: 1)
						(return downI)
					)
					(KEY_RIGHT
						(event claimed: 1)
						(return upI)
					)
				)
			)
			($0040 ; direction
				(switch (event message:)
					(JOY_LEFT
						(event claimed: 1)
						(return downI)
					)
					(JOY_RIGHT
						(event claimed: 1)
						(return upI)
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

