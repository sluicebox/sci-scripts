;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64987)
(include sci.sh)
(use Main)
(use DButton)
(use DText)
(use Plane)
(use Str)
(use Dialog)

(local
	textI
	upI
	downI
	gaugeI
	okI
	normalI
	noI
	str
)

(class Gauge of Dialog
	(properties
		readFiles 0
		lastSeconds 0
		script 0
		sortFileNames 0
		eatTheMice 4
		margin 0
		sayNext 0
		sayFormat {up}
		upper {down}
		nextMsg 7
		findTalker 0
		centerObj 15
	)

	(method (init value &tmp dx dy)
		(= str (Str with: 200 {}))
		(= plane Plane)
		(self readWord: value)
		((= downI (DButton new:)) text: upper set: 4 4 enable:)
		(self add: downI enable:)
		((= gaugeI (DText new:))
			text: str
			set: (+ (downI nsRight:) 4) 4
			font: 0
			enable:
		)
		(self add: gaugeI enable:)
		((= upI (DButton new:))
			text: sayFormat
			set: (+ (gaugeI nsRight:) 4) 4
			enable:
		)
		(self add: upI enable:)
		(+= nsBottom 8)
		((= okI (DButton new:)) text: {OK} enable: set: 4 nsBottom)
		((= normalI (DButton new:))
			text: {Normal}
			enable:
			set: (+ (okI nsRight:) 4) nsBottom
		)
		((= noI (DButton new:))
			text: {Cancel}
			enable:
			set: (+ (normalI nsRight:) 4) nsBottom
		)
		(self add: okI normalI noI enable:)
		(= dx (- (- nsRight (noI nsRight:)) 4))
		((= textI (DText new:))
			text: sayNext
			font: gSmallFont
			enable: (- nsRight 8)
			set: 4 4
		)
		(= dy (+ (textI nsBottom:) 4))
		(self add: textI)
		(upI fill: 0 dy)
		(downI fill: 0 dy)
		(gaugeI fill: 0 dy)
		(okI fill: dx dy)
		(normalI fill: dx dy)
		(noI fill: dx dy)
		(self enable: center: modeless: 4 15)
		(str dispose:)
	)

	(method (doit value &tmp i ret)
		(self init: value)
		(= ret value)
		(repeat
			(self readWord: ret)
			(gaugeI draw:)
			(cond
				((== (= i (super doit: okI)) upI)
					(if (< ret centerObj)
						(++ ret)
					)
				)
				((== i downI)
					(if (> ret findTalker)
						(-- ret)
					)
				)
				((== i okI)
					(break)
				)
				((== i normalI)
					(= ret nextMsg)
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

	(method (readWord param1 &tmp temp0 temp1)
		(= temp1 (- centerObj findTalker))
		(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
			(str at: temp0 (if (< temp0 param1) 6 else 7))
		)
	)

	(method (sort param1)
		(switch (param1 type:)
			(4
				(switch (param1 message:)
					(19200
						(param1 claimed: 1)
						(return downI)
					)
					(19712
						(param1 claimed: 1)
						(return upI)
					)
				)
			)
			(16
				(switch (param1 message:)
					(7
						(param1 claimed: 1)
						(return downI)
					)
					(3
						(param1 claimed: 1)
						(return upI)
					)
				)
			)
		)
		(return (super sort: param1))
	)
)

