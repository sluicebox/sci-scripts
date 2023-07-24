;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use Str)
(use Array)
(use Sound)
(use Actor)
(use System)

(public
	typeMsg 0
)

(local
	local0
)

(class TypeLineView of View
	(properties
		modNum 2000
		noun 2
		priority 400
		verb 0
		size 0
		initialized 0
		fixPriority 1
		font 1
		textBottom 0
		textLeft 0
		textRight 0
		textTop 0
		indexInto 0
		sequenceNo 0
		messageStr 0
		txtColor 51
		txtBkColor 0
		txtSkip 0
	)

	(method (init param1)
		(self setup: &rest)
		(super init: param1)
	)

	(method (dispose)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
			(= bitmap 0)
		)
		(if messageStr
			(messageStr dispose:)
			(= messageStr 0)
		)
		(super dispose:)
	)

	(method (setup param1 param2 param3 param4 param5 &tmp temp0 temp1)
		(if initialized
			(return)
		)
		(= initialized 1)
		(if argc
			(= sequenceNo param1)
			(if (> argc 1)
				(= noun param2)
				(if (> argc 2)
					(= verb param3)
					(if (> argc 3)
						(= case param4)
						(if (> argc 4)
							(= modNum param5)
						)
					)
				)
			)
		)
		(if messageStr
			(messageStr dispose:)
			(= messageStr 0)
		)
		(if
			(and
				(ResCheck rsMESSAGE modNum)
				(Message msgGET modNum noun verb case sequenceNo)
			)
			(= size (Message msgSIZE modNum noun verb case sequenceNo))
			(= indexInto 0)
			(= messageStr (Str new: (+ size 1) {}))
			(Message msgGET modNum noun verb case sequenceNo (messageStr data:))
			(= temp1 (IntArray with: 0 0 0 0))
			(Text 0 (temp1 data:) (messageStr data:) font -1) ; TextSize
			(= textLeft (= textTop 0))
			(= textRight (temp1 at: 2))
			(= textBottom (temp1 at: 3))
			(temp1 dispose:)
			(= bitmap (Bitmap 0 textRight textBottom txtSkip txtBkColor)) ; Create
		)
	)

	(method (advanceMsg param1 &tmp temp0)
		(+= indexInto 3)
		(if (and argc param1)
			(= indexInto -1)
		)
		(if (>= indexInto size)
			(= indexInto -1)
		)
		(= temp0 (messageStr subStr: 0 indexInto))
		(Bitmap
			4 ; AddText
			bitmap
			(temp0 data:)
			textLeft
			textTop
			textRight
			textBottom
			txtColor
			txtBkColor
			txtSkip
			font
			0
			-1
			0
		)
		(UpdateScreenItem self)
		(if (!= indexInto -1)
			(self playTeleType:)
		)
		(temp0 dispose:)
	)

	(method (playTeleType)
		(teleTypeSound play:)
	)
)

(instance teleTypeSound of Sound
	(properties
		number 2000
		flags 1
	)
)

(instance typeMsg of Script
	(properties)

	(method (dispose param1)
		(if (and (or (not argc) (not param1)) (not (gUser input:)))
			(line1 indexInto: -1)
			(line2 indexInto: -1)
			(line3 indexInto: -1)
			(line4 indexInto: -1)
			(line5 indexInto: -1)
			(= local0 1)
			(= cycles 1)
		else
			(teleTypeSound stop: dispose:)
			(UnLoad 141 2000)
			(gGame handsOn:)
			(line1 dispose:)
			(line2 dispose:)
			(line3 dispose:)
			(line4 dispose:)
			(line5 dispose:)
			(super dispose: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 2000)
				(line1 init: register 1)
				(line2 init: register 2)
				(line3 init: register 3)
				(line4 init: register 4)
				(line5 init: register 5)
				(= cycles 1)
			)
			(1
				(line1 advanceMsg: local0)
				(if (!= (line1 indexInto:) -1)
					(-- state)
					(= ticks 6)
				else
					(= ticks 1)
				)
			)
			(2
				(line2 advanceMsg: local0)
				(if (!= (line2 indexInto:) -1)
					(-- state)
					(= ticks 6)
				else
					(= ticks 1)
				)
			)
			(3
				(line3 advanceMsg: local0)
				(if (!= (line3 indexInto:) -1)
					(-- state)
					(= ticks 6)
				else
					(= ticks 1)
				)
			)
			(4
				(line4 advanceMsg: local0)
				(if (!= (line4 indexInto:) -1)
					(-- state)
					(= ticks 6)
				else
					(= ticks 1)
				)
			)
			(5
				(line5 advanceMsg: local0)
				(if (!= (line5 indexInto:) -1)
					(-- state)
					(= ticks 6)
				else
					(= ticks 1)
				)
			)
			(6
				(gGame handsOn:)
				(= seconds 10)
			)
			(7
				(self dispose: 1)
			)
		)
	)
)

(instance line1 of TypeLineView
	(properties
		x 25
		y 177
		txtColor 11
		txtSkip 255
	)

	(method (setup)
		(super setup: &rest)
		(= textLeft (= textTop 5))
		(+= textRight 10)
		(+= textBottom 10)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
			(= bitmap (Bitmap 0 textRight textBottom txtSkip txtBkColor)) ; Create
		)
	)
)

(instance line2 of TypeLineView
	(properties
		x 20
		y 200
	)
)

(instance line3 of TypeLineView
	(properties
		x 20
		y 218
	)
)

(instance line4 of TypeLineView
	(properties
		x 20
		y 236
	)
)

(instance line5 of TypeLineView
	(properties
		x 20
		y 254
	)
)

