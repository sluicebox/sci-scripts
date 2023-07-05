;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 242)
(include sci.sh)
(use Main)
(use rm241)
(use Print)
(use Feature)
(use Actor)
(use System)

(public
	keyStuff 0
	proc242_1 1
)

(local
	local0
	[local1 11]
	local12
	local13
)

(procedure (localproc_0 param1)
	(= local12 1)
	(= [local1 local0] param1)
	(= local0 (mod (++ local0) 10))
	(= local12 0)
)

(procedure (localproc_1)
	(= local12 1)
	(if (> local0 0)
		(return [local1 (-- local0)])
	else
		(return -1)
	)
	(return (= local12 0))
)

(procedure (localproc_2 param1)
	(if (< param1 10)
		(if (== (d3 loop:) 15)
			(d3 startUpd: setLoop: (d2 loop:))
			(d2 startUpd: setLoop: (d1 loop:))
			(d1 startUpd: setLoop: (d0 loop:))
			(d0 startUpd: setLoop: param1)
		)
		(if (!= (d2 loop:) 15)
			(colon init:)
		else
			(colon dispose:)
		)
	)
)

(procedure (proc242_1)
	(d3 startUpd:)
	(d2 startUpd:)
	(d1 startUpd:)
	(d0 startUpd:)
	(if (< 0 (d0 loop:) 10)
		(d0 loop: (- (d0 loop:) 1))
	else
		(if (== (d1 loop:) 15)
			(d0 loop: 15)
		else
			(d0 loop: 9)
		)
		(if (< 0 (d1 loop:) 6)
			(d1 loop: (- (d1 loop:) 1))
		else
			(if (== (d2 loop:) 15)
				(d1 loop: 15)
			else
				(d1 loop: 5)
			)
			(if (< 0 (d2 loop:) 10)
				(d2 loop: (- (d2 loop:) 1))
			else
				(if (== (d3 loop:) 15)
					(d2 loop: 15)
				else
					(d2 loop: 9)
				)
				(if (< 0 (d3 loop:) 10)
					(d3 loop: (- (d3 loop:) 1))
				else
					(d3 loop: 15)
				)
			)
		)
	)
)

(procedure (localproc_3 param1)
	(cond
		(
			(and
				(InRect
					(+ (pad x:) 15)
					(+ (pad y:) 27)
					(+ (pad x:) 63)
					(+ (pad y:) 66)
					param1
				)
				(not (proc241_3))
			)
			(return
				(+
					(* (/ (- (param1 y:) (+ (pad y:) 27)) 13) 3)
					1
					(/ (- (param1 x:) (+ (pad x:) 15)) 16)
				)
			)
		)
		(
			(and
				(InRect
					(+ (pad x:) 15)
					(+ (pad y:) 27 52)
					(+ (pad x:) 15 48)
					(+ (pad y:) 27 65)
					param1
				)
				(localproc_7)
				(not (proc241_3))
			)
			(return 14)
		)
		(
			(and
				(InRect
					(+ (pad x:) 15 53)
					(- (+ (pad y:) 27) 13)
					(+ (pad x:) 15 101)
					(+ (pad y:) 27)
					param1
				)
				(not (proc241_3))
			)
			(proc241_2 0)
			(return 10)
		)
		(
			(and
				(InRect
					(+ (pad x:) 15 53)
					(+ (pad y:) 27)
					(+ (pad x:) 15 101)
					(+ (pad y:) 27 13)
					param1
				)
				(not (proc241_3))
			)
			(proc241_2 1)
			(return 11)
		)
		(
			(and
				(InRect
					(+ (pad x:) 15 53)
					(+ (pad y:) 27 13)
					(+ (pad x:) 15 101)
					(+ (pad y:) 27 26)
					param1
				)
				(not (proc241_3))
			)
			(proc241_2 2)
			(return 12)
		)
		(
			(and
				(InRect
					(+ (pad x:) 15 16)
					(+ (pad y:) 27 39)
					(+ (pad x:) 15 32)
					(+ (pad y:) 27 52)
					param1
				)
				(not (proc241_3))
			)
			(return 0)
		)
		(
			(InRect
				(+ (pad x:) 15 32)
				(+ (pad y:) 27 39)
				(+ (pad x:) 15 48)
				(+ (pad y:) 27 52)
				param1
			)
			(return 13)
		)
		(else
			(return -1)
		)
	)
)

(procedure (localproc_4 param1)
	(return
		(switch param1
			(0 16)
			(14 0)
			(10 53)
			(11 53)
			(12 53)
			(13 32)
			(else
				(* (mod (- param1 1) 3) 16)
			)
		)
	)
)

(procedure (localproc_5 param1)
	(return
		(switch param1
			(0 39)
			(14 52)
			(10 -13)
			(11 0)
			(12 13)
			(13 39)
			(else
				(* (/ (- param1 1) 3) 13)
			)
		)
	)
)

(procedure (localproc_6 param1 &tmp temp0 temp1)
	(d0 loop: 15)
	(d1 loop: 15)
	(d2 loop: 15)
	(d3 loop: 15)
	(= temp0 (/ param1 60))
	(= temp1 (mod param1 60))
	(if temp0
		(d2 loop: (mod temp0 10))
		(if (/= temp0 10)
			(d3 loop: (mod temp0 10))
		)
	)
	(if temp1
		(d0 loop: (mod temp1 10))
		(if (/= temp1 10)
			(d1 loop: (mod temp1 10))
		)
	)
)

(procedure (localproc_7 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp2 (d0 loop:))
	(= temp3 (d1 loop:))
	(= temp4 (d2 loop:))
	(= temp5 (d3 loop:))
	(if (== (d0 loop:) 15)
		(= temp2 0)
	)
	(if (== (d1 loop:) 15)
		(= temp3 0)
	)
	(if (== (d2 loop:) 15)
		(= temp4 0)
	)
	(if (== (d3 loop:) 15)
		(= temp5 0)
	)
	(= temp1 (+ temp2 (* temp3 10)))
	(return (+ (* (= temp0 (+ temp4 (* temp5 10))) 60) temp1))
)

(instance d0 of Prop
	(properties
		view 264
		loop 15
		priority 15
		signal 16400
	)

	(method (init)
		(self loop: 15 signal: 16400)
		(self posn: (+ 20 (pad x:) 30) (+ 17 (pad y:)))
		(super init: &rest)
	)
)

(instance d1 of Prop
	(properties
		view 264
		loop 15
		priority 15
		signal 16400
	)

	(method (init)
		(self loop: 15 signal: 16400)
		(self posn: (+ 20 (pad x:) 20) (+ 17 (pad y:)))
		(super init: &rest)
	)
)

(instance d2 of Prop
	(properties
		view 264
		loop 15
		priority 15
		signal 16400
	)

	(method (init)
		(self loop: 15 signal: 16400)
		(self posn: (+ 20 (pad x:) 10) (+ 17 (pad y:)))
		(super init: &rest)
	)
)

(instance d3 of Prop
	(properties
		view 264
		loop 15
		priority 15
		signal 16400
	)

	(method (init)
		(self loop: 15 signal: 16400)
		(self posn: (+ 20 (pad x:) 0) (+ 17 (pad y:)))
		(super init: &rest)
	)
)

(instance tempKey of Prop
	(properties
		view 264
		cel 1
		priority 15
		signal 16400
	)

	(method (show param1)
		(self
			posn:
				(+ (localproc_4 param1) (pad x:) 15)
				(+ (localproc_5 param1) (pad y:) 27)
			setLoop: param1
			setCel: 1
		)
		(super show: &rest)
	)
)

(instance tempKey2 of Prop
	(properties
		view 264
		cel 1
		priority 15
		signal 16400
	)

	(method (show &tmp temp0)
		(= temp0 (+ (proc241_2) 10))
		(self
			posn:
				(+ (localproc_4 temp0) (pad x:) 15)
				(+ (localproc_5 temp0) (pad y:) 27)
			setLoop: temp0
			setCel: 1
		)
		(super show: &rest)
	)
)

(instance colon of View
	(properties
		view 264
		loop 4
		cel 3
		priority 15
		signal 16400
	)

	(method (init)
		(self signal: 16400)
		(self x: (+ (pad x:) 15 22) y: (- (+ (pad y:) 27) 9))
		(super init: &rest)
	)
)

(instance pad of Prop
	(properties
		x 10
		y 85
		noun 5
		modNum 241
		view 264
		loop 14
		cel 3
		priority 14
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self show:)
		(d0 init:)
		(d1 init:)
		(d2 init:)
		(d3 init:)
		(tempKey init: hide:)
		(directions init: setOnMeCheck: 26505)
		(tempKey2 init: show:)
		(localproc_6 local13)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (and (not script) local0 (not local12))
			(= temp0 (localproc_1))
			(self setScript: keyFlash 0 temp0)
		)
	)

	(method (hide)
		(d0 hide:)
		(d1 hide:)
		(d2 hide:)
		(d3 hide:)
		(colon hide:)
		(tempKey hide:)
		(tempKey2 hide:)
		(super hide: &rest)
	)

	(method (dispose)
		(d0 dispose:)
		(d1 dispose:)
		(d2 dispose:)
		(d3 dispose:)
		(colon dispose:)
		(tempKey dispose:)
		(directions dispose:)
		(tempKey2 dispose:)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1 [temp2 20])
		(if (and (gUser controls:) (gUser input:))
			(cond
				((== (gTheIconBar curIcon:) (gTheIconBar at: 1))
					(super handleEvent: event &rest)
				)
				(
					(and
						(not (& (event type:) evVERB))
						(!= (event message:) KEY_TAB)
						(not (self onMe: event))
						(not script)
						(not (event modifiers:))
					)
					(keyStuff cue:)
					(event claimed: 1)
					(return)
				)
				((and (= temp0 (event message:)) (& (event type:) evKEYBOARD))
					(cond
						(
							(and
								(== temp0 KEY_RETURN)
								(!= (= temp1 (localproc_3 event)) -1)
							)
							(event claimed: 1)
							(localproc_0 temp1)
							(event claimed:)
							(return)
						)
						((and (== temp0 KEY_TAB) (not (proc241_3)))
							(event claimed: 1)
							(proc241_2 (mod (+ (proc241_2) 1) 3))
							(tempKey2 show:)
							(event claimed:)
							(return)
						)
						((<= KEY_0 temp0 KEY_9)
							(event claimed: 1)
							(localproc_0 (- (event message:) 48))
							(event claimed:)
							(return)
						)
						((OneOf temp0 KEY_ESCAPE KEY_C KEY_c)
							(event claimed: 1)
							(localproc_0 11)
							(event claimed:)
							(return)
						)
						((OneOf temp0 KEY_E KEY_e)
							(event claimed: 1)
							(localproc_0 14)
							(event claimed:)
							(return)
						)
						(else
							(super handleEvent: event &rest)
						)
					)
				)
				(
					(and
						(& (event type:) evMOUSEBUTTON)
						(!= (= temp1 (localproc_3 event)) -1)
						(not (event modifiers:))
					)
					(event claimed: 1)
					(localproc_0 temp1)
					(event claimed:)
					(return)
				)
				(else
					(super handleEvent: event &rest)
				)
			)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance keyFlash of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gSq5Music2 number: 124 loop: 1 play:)
				(if (< 9 register 13)
					(tempKey2 startUpd: show: register)
				else
					(tempKey startUpd: show: register)
				)
				(tempKey startUpd: show: register)
				(= ticks 5)
			)
			(1
				(localproc_2 register)
				(= ticks 5)
			)
			(2
				(switch register
					(13
						(self setScript: clearScript self)
					)
					(14
						(if (or (d0 loop:) (d1 loop:) (d2 loop:) (d3 loop:))
							(proc241_1 (localproc_7))
						)
						(if (== (tempKey2 loop:) 10)
							(proc241_4 471)
						else
							(proc241_4 472)
						)
						(= cycles 1)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(d0 stopUpd:)
				(d1 stopUpd:)
				(d2 stopUpd:)
				(d3 stopUpd:)
				(tempKey hide:)
				(gSq5Music2 stop:)
				(self dispose:)
			)
		)
	)
)

(instance keyStuff of Script
	(properties)

	(method (init param1 param2 param3 param4 param5)
		(if (> argc 3)
			(pad x: param4)
			(if (> argc 4)
				(pad y: param5)
			)
		)
		(super init: param1 param2 param3 &rest)
	)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(= local13 register)
				(pad init:)
				(gGame handsOn:)
				(gTheIconBar disable: 0 3 5 4 6)
				(gGame setCursor: 982 1 (+ (pad x:) 10) (+ (pad y:) 10))
				(gTheIconBar select: (gTheIconBar at: 2))
			)
			(1
				(gGame handsOff:)
				(pad hide:)
				(if (> (d0 loop:) 9)
					(d0 loop: 0)
				)
				(if (> (d1 loop:) 9)
					(d1 loop: 0)
				)
				(if (> (d2 loop:) 9)
					(d2 loop: 0)
				)
				(if (> (d3 loop:) 9)
					(d3 loop: 0)
				)
				(= cycles 6)
			)
			(2
				(pad dispose: delete:)
				(self dispose:)
			)
		)
	)
)

(instance clearScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom setScript: 0)
				(= cycles 1)
			)
			(1
				(d0 startUpd: loop: 0)
				(d1 startUpd: loop: 0)
				(d2 startUpd: loop: 0)
				(d3 startUpd: loop: 0)
				(proc241_3 0)
				(= local13 0)
				(localproc_6 0)
				(colon dispose:)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance directions of Feature
	(properties)

	(method (init)
		(self
			nsLeft: (+ (pad x:) 70)
			nsTop: (+ (pad y:) 53)
			nsRight: (+ (pad x:) 114)
			nsBottom: (+ (pad y:) 92)
			y: 200
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(Print
					addText: 2 1 0 1 0 0 241 ; "CRYO-CHEF Cooking Instructions:"
					addText: 2 1 14 1 0 12 241 ; "Hot Dogs"
					addText: 2 1 15 1 130 12 241 ; "20 seconds COOK"
					addText: 2 1 14 2 0 24 241 ; "Coffee"
					addText: 2 1 15 2 130 24 241 ; "5 seconds DEFROST"
				)
				(Print
					addText: 2 1 14 3 0 36 241 ; "Freeze Ambassador"
					addText: 2 1 15 3 130 36 241 ; "10 seconds FREEZE"
					addText: 2 1 14 4 0 48 241 ; "Cheeseburger"
					addText: 2 1 15 4 130 48 241 ; "25 seconds COOK"
					addText: 2 1 14 5 0 60 241 ; "Fudgecicle"
					addText: 2 1 15 5 130 60 241 ; "1 minute FREEZE"
				)
				(Print
					addText: 2 1 14 6 0 72 241 ; "5 LB Rumproast"
					addText: 2 1 15 6 130 72 241 ; "20 seconds DEFROST"
					addText: 2 1 14 7 0 84 241 ; "Hot Chocolate"
					addText: 2 1 15 7 130 84 241 ; "5 seconds COOK"
					addText: 2 1 14 8 0 96 241 ; "Hampster"
					addText: 2 1 15 8 130 96 241 ; "20 minutes COOK"
				)
				(Print
					addText: 2 1 14 9 0 108 241 ; "Orat Jiblets"
					addText: 2 1 15 9 130 108 241 ; "90 minutes COOK"
					addText: 2 1 14 10 0 120 241 ; "Ambassador Defrost"
					addText: 2 1 15 10 130 120 241 ; "10 seconds DEFROST"
					init:
				)
			)
		)
	)
)

