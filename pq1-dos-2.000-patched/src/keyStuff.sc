;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 165)
(include sci.sh)
(use Main)
(use Inset)
(use User)
(use Actor)
(use System)

(public
	keyStuff 0
)

(local
	local0
	[local1 11]
	local12
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
	(if (and (< param1 10) (== (d4 loop:) 12))
		(d4 startUpd: setLoop: (d3 loop:))
		(d3 startUpd: setLoop: (d2 loop:))
		(d2 startUpd: setLoop: (d1 loop:))
		(d1 startUpd: setLoop: (d0 loop:))
		(d0 startUpd: setLoop: param1)
	)
)

(procedure (localproc_3 param1)
	(cond
		(
			(InRect
				(+ (pad x:) 13)
				(+ (pad y:) 23)
				(+ (pad x:) 43)
				(+ (pad y:) 53)
				param1
			)
			(return
				(+
					(* (/ (- (param1 y:) (+ (pad y:) 23)) 10) 3)
					1
					(/ (- (param1 x:) (+ (pad x:) 13)) 10)
				)
			)
		)
		(
			(InRect
				(+ (pad x:) 50)
				(+ (pad y:) 23)
				(+ (pad x:) 62)
				(+ (pad y:) 53)
				param1
			)
			(return 10)
		)
		(
			(InRect
				(+ (pad x:) 15)
				(+ (pad y:) 64)
				(+ (pad x:) 59)
				(+ (pad y:) 72)
				param1
			)
			(return 11)
		)
		(
			(InRect
				(+ (pad x:) 23)
				(+ (pad y:) 53)
				(+ (pad x:) 33)
				(+ (pad y:) 63)
				param1
			)
			(return 0)
		)
		(else
			(return -1)
		)
	)
)

(procedure (localproc_4 param1)
	(return
		(switch param1
			(0 10)
			(10 37)
			(11 2)
			(else
				(* (mod (- param1 1) 3) 10)
			)
		)
	)
)

(procedure (localproc_5 param1)
	(return
		(switch param1
			(0 30)
			(10 0)
			(11 41)
			(else
				(* (/ (- param1 1) 3) 10)
			)
		)
	)
)

(instance d0 of Prop
	(properties
		view 1502
		loop 12
		priority 15
		signal 16400
	)

	(method (init)
		(self posn: (+ 12 (pad x:) 40) (+ 6 (pad y:)))
		(super init: &rest)
	)
)

(instance d1 of Prop
	(properties
		view 1502
		loop 12
		priority 15
		signal 16400
	)

	(method (init)
		(self posn: (+ 12 (pad x:) 30) (+ 6 (pad y:)))
		(super init: &rest)
	)
)

(instance d2 of Prop
	(properties
		view 1502
		loop 12
		priority 15
		signal 16400
	)

	(method (init)
		(self posn: (+ 12 (pad x:) 20) (+ 6 (pad y:)))
		(super init: &rest)
	)
)

(instance d3 of Prop
	(properties
		view 1502
		loop 12
		priority 15
		signal 16400
	)

	(method (init)
		(self posn: (+ 12 (pad x:) 10) (+ 6 (pad y:)))
		(super init: &rest)
	)
)

(instance d4 of Prop
	(properties
		view 1502
		loop 12
		priority 15
		signal 16400
	)

	(method (init)
		(self posn: (+ 12 (pad x:) 0) (+ 6 (pad y:)))
		(super init: &rest)
	)
)

(instance tempKey of Prop
	(properties
		view 1502
		cel 1
		priority 15
		signal 16400
	)

	(method (show param1)
		(self
			posn:
				(+ (localproc_4 param1) 13 (pad x:))
				(+ (localproc_5 param1) 23 (pad y:))
			setLoop: param1
			setCel: 1
		)
		(gLongSong2
			number:
				(if param1
					(+ 923 param1)
				else
					933
				)
			loop: 1
			play:
		)
		(super show: &rest)
	)
)

(instance pad of Inset
	(properties
		view 1502
		loop 13
		x 70
		y 57
		disposeNotOnMe 1
	)

	(method (init)
		(super init: &rest)
		(d0 init:)
		(d1 init:)
		(d2 init:)
		(d3 init:)
		(d4 init:)
		(tempKey init: hide:)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (and (not script) local0 (not local12))
			(= temp0 (localproc_1))
			(self setScript: keyFlash 0 temp0)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (User controls:)
			(cond
				((= temp0 (event message:))
					(cond
						(
							(and
								(== temp0 KEY_RETURN)
								(!= (= temp1 (localproc_3 event)) -1)
							)
							(event claimed: 1)
							(localproc_0 temp1)
						)
						((<= KEY_0 temp0 KEY_9)
							(event claimed: 1)
							(localproc_0 (- (event message:) 48))
						)
						((OneOf temp0 KEY_ESCAPE KEY_C KEY_c)
							(event claimed: 1)
							(localproc_0 11)
						)
						((OneOf temp0 KEY_E KEY_e)
							(event claimed: 1)
							(localproc_0 10)
						)
						(else
							(super handleEvent: event &rest)
						)
					)
				)
				(
					(and
						(== (event type:) evMOUSEBUTTON)
						(!= (= temp1 (localproc_3 event)) -1)
						(not (event modifiers:))
					)
					(event claimed: 1)
					(localproc_0 temp1)
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
				(tempKey startUpd: show: register)
				(= ticks 5)
			)
			(1
				(localproc_2 register)
				(= ticks 5)
			)
			(2
				(switch register
					(11
						(self setScript: clearScript self)
					)
					(10
						(keyStuff register: 2)
						(d0 stopUpd:)
						(d1 stopUpd:)
						(d2 stopUpd:)
						(d3 stopUpd:)
						(d4 stopUpd:)
						(tempKey hide:)
						(self dispose:)
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
				(d4 stopUpd:)
				(tempKey hide:)
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
				(d0 startUpd: setLoop: 12)
				(d1 startUpd: setLoop: 12)
				(d2 startUpd: setLoop: 12)
				(d3 startUpd: setLoop: 12)
				(d4 startUpd: setLoop: 12)
				(= cycles 3)
			)
			(1
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

	(method (doit)
		(super doit:)
		(if (== register 2)
			(HandsOff)
			(self cycles: 5 register: 1)
		)
	)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(HandsOn)
				(gTheIconBar disable: 0 3 4 5)
				(gGame setCursor: 609 1 (+ (pad x:) 10) (+ (pad y:) 10))
				(= register -1)
				(gCurRoom setInset: pad self)
			)
			(1
				(HandsOff)
				(gCurRoom setInset: 0)
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
				(if (> (d4 loop:) 9)
					(d4 loop: 0)
				)
				(= ticks 6)
			)
			(2
				(gCurRoom
					notify:
						register
						(d4 loop:)
						(d3 loop:)
						(d2 loop:)
						(d1 loop:)
						(d0 loop:)
				)
				(= seconds 1)
			)
			(3
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 165)
	)
)

