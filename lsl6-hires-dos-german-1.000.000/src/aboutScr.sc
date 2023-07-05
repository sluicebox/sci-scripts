;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 73)
(include sci.sh)
(use Main)
(use Str)
(use Print)
(use System)

(public
	aboutScr 0
)

(instance aboutScr of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 ((gUser curEvent:) new:))
		(if (and (== (temp0 type:) 4) (== (temp0 message:) 27))
			(= register 20)
		)
		(if (& (temp0 modifiers:) $000b)
			(= register 20)
		)
		(temp0 dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= global211 (gUser controls:))
				(= global212 (gUser input:))
				(= global213 (gTheIconBar getCursor:))
				(gGame handsOff:)
				(SetCursor 98 0 0)
				(= global214 (Str new:))
				(Message msgGET 93 8 0 2 1 (global214 data:)) ; "Shape Up or Slip Out!"
				(= register 0)
				(= cycles 2)
			)
			(1
				(cond
					((or (gTalkers size:) (Print dialog:))
						(-- state)
						(= ticks 90)
					)
					((<= (++ register) 20)
						(= global215 (Str new:))
						(Message msgGET 93 8 0 0 register (global215 data:))
						(cond
							((== register 1)
								(= temp0 0)
							)
							((and (> register 15) (< register 19))
								(= temp0 1925)
							)
							((== register 20)
								(global215 format: (global215 data:) gVersion)
								(= temp0 (+ 1907 register))
							)
							((> register 18)
								(= temp0 (+ 1907 register))
							)
							(else
								(= temp0 (+ 1910 register))
							)
						)
						(if (not temp0)
							(Print
								font: gUserFont
								addTitle: (global214 data:)
								addText: (global215 data:) 2 1
							)
						else
							(Print
								font: gUserFont
								addTitle: (global214 data:)
								addIcon: temp0 0 0 0 0
								mode: 1
								addText: (global215 data:) 60 1
							)
						)
						((Print dialog:) setSize:)
						(Print init: self)
						(global215 dispose:)
						(= global215 0)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(if (< register 20)
					(-= state 2)
				)
				(= cycles 4)
			)
			(3
				(global214 dispose:)
				(= global214 0)
				(gGame handsOn:)
				(if (not global211)
					(gTheIconBar disableIcon: (ScriptID 0 3) show:) ; icon0
				)
				(gGame setCursor: global213)
				(gUser canInput: global212 canControl: global211)
				(self dispose:)
			)
		)
	)
)

