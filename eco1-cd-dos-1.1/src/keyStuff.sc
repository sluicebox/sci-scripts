;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use Main)
(use n819)
(use EcoFeature)
(use Talker)
(use User)
(use System)

(public
	keyStuff 0
)

(local
	local0
	[local1 10]
	local11
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

(procedure (localproc_2 &tmp temp0)
	(d0 startUpd: setCel: 0)
	(d1 startUpd: setCel: 0)
	(d2 startUpd: setCel: 0)
	(d3 startUpd: setCel: 0)
	(cond
		((>= (= temp0 local11) 1000)
			(d0 setCel: 2 setLoop: (/ temp0 1000))
			(-= temp0 (* (/ temp0 1000) 1000))
			(d1 setCel: 2 setLoop: (/ temp0 100))
			(-= temp0 (* (/ temp0 100) 100))
			(d2 setCel: 2 setLoop: (/ temp0 10))
			(-= temp0 (* (/ temp0 10) 10))
			(d3 setCel: 2 setLoop: temp0)
		)
		((>= temp0 100)
			(d0 setCel: 2 setLoop: (/ temp0 100))
			(-= temp0 (* (/ temp0 100) 100))
			(d1 setCel: 2 setLoop: (/ temp0 10))
			(-= temp0 (* (/ temp0 10) 10))
			(d2 setCel: 2 setLoop: temp0)
		)
		((>= temp0 10)
			(d0 setCel: 2 setLoop: (/ temp0 10))
			(-= temp0 (* (/ temp0 10) 10))
			(d1 setCel: 2 setLoop: temp0)
		)
		((>= temp0 1)
			(d0 setCel: 2 setLoop: temp0)
		)
	)
)

(procedure (localproc_3 param1)
	(if (>= local11 1000)
		(= local11 0)
	)
	(= local11 (+ (* local11 10) param1))
)

(procedure (localproc_4 param1)
	(cond
		((InRect 150 68 158 75 param1)
			(return 1)
		)
		((InRect 159 68 167 75 param1)
			(return 2)
		)
		((InRect 168 68 176 75 param1)
			(return 3)
		)
		((InRect 150 76 158 83 param1)
			(return 4)
		)
		((InRect 159 76 167 83 param1)
			(return 5)
		)
		((InRect 168 76 176 83 param1)
			(return 6)
		)
		((InRect 150 84 158 91 param1)
			(return 7)
		)
		((InRect 159 84 167 91 param1)
			(return 8)
		)
		((InRect 168 84 176 91 param1)
			(return 9)
		)
		((InRect 150 92 158 99 param1)
			(return 10)
		)
		((InRect 159 92 167 99 param1)
			(return 11)
		)
		((InRect 168 92 176 99 param1)
			(return 0)
		)
		(else
			(return -1)
		)
	)
)

(instance d0 of EcoProp
	(properties
		x 144
		y 55
		view 409
		priority 15
		signal 16
	)
)

(instance d1 of EcoProp
	(properties
		x 152
		y 55
		view 409
		priority 15
		signal 16
	)
)

(instance d2 of EcoProp
	(properties
		x 160
		y 55
		view 409
		priority 15
		signal 16
	)
)

(instance d3 of EcoProp
	(properties
		x 168
		y 55
		view 409
		priority 15
		signal 16
	)
)

(instance led of EcoProp
	(properties
		x 176
		y 55
		view 409
		loop 13
		priority 15
		signal 16
	)
)

(instance tempKey of EcoProp
	(properties
		view 409
		cel 1
		priority 15
		signal 16400
	)
)

(instance keyPadView of EcoProp
	(properties
		x 163
		y 204
		z 100
		view 409
		loop 14
		priority 13
		signal 16400
		lookStr 79
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (and (not script) local0 (not local12))
			(cond
				((< (= temp0 (localproc_1)) 10)
					(localproc_3 temp0)
					(self setScript: keyFlash 0 temp0)
				)
				((== temp0 10)
					(self setScript: enterScript)
				)
				((== temp0 11)
					(self setScript: clearScript)
				)
			)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(EcoNarrator posn: -1 140 init: 3 0 0 92 0 400)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (User controls:)
			(= temp1 (localproc_4 event))
			(cond
				(
					(and
						(not (event claimed:))
						(!= (event type:) evVERB)
						(not (& (event type:) $000a)) ; evKEYUP | evMOUSERELEASE
						(!= (event message:) KEY_TAB)
						(not (self onMe: event))
						(not (event modifiers:))
					)
					(event claimed: 1)
					(keyStuff cue:)
				)
				((= temp0 (event message:))
					(cond
						((and (== temp0 KEY_RETURN) (!= temp1 -1))
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
						(not (event claimed:))
						(not (event modifiers:))
						(!= (event type:) evVERB)
						(not (& (event type:) $000a)) ; evKEYUP | evMOUSERELEASE
						(== (gTheIconBar curIcon:) (gTheIconBar at: 1))
					)
					(event claimed: 1)
					(EcoNarrator posn: -1 140 init: 3 0 0 lookStr)
				)
				(
					(and
						(not (event claimed:))
						(not (event modifiers:))
						(!= (event type:) evVERB)
						(not (& (event type:) $000a)) ; evKEYUP | evMOUSERELEASE
						(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
						(!= temp1 -1)
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

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (OneOf register 0 10 11)
					(= temp0 93)
				else
					(= temp0 (+ (* (/ (- register 1) 3) 8) 69))
				)
				(cond
					((== register 10)
						(= temp1 151)
					)
					((== register 11)
						(= temp1 160)
					)
					((not register)
						(= temp1 169)
					)
					(else
						(= temp1 (+ (* (mod (- register 1) 3) 9) 151))
					)
				)
				(gSoundEffects number: (+ 903 register) loop: 1 play:)
				(tempKey
					startUpd:
					show:
					setLoop: register
					setCel: 1
					posn: temp1 temp0
				)
				(= ticks 10)
			)
			(1
				(localproc_2)
				(= ticks 10)
			)
			(2
				(d0 stopUpd:)
				(d1 stopUpd:)
				(d2 stopUpd:)
				(d3 stopUpd:)
				(tempKey hide:)
				(self dispose:)
			)
		)
	)
)

(instance keyStuff of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(keyPadView init: stopUpd:)
				(SetFlag 14)
				(HandsOn)
				(gTheIconBar disable: 5 0 3 4 5 6)
				(d0 init: stopUpd:)
				(d1 init: stopUpd:)
				(d2 init: stopUpd:)
				(d3 init: stopUpd:)
				(gEgo stopUpd:)
				((ScriptID 400 3) stopUpd:) ; seaGull
				((ScriptID 400 7) stopUpd:) ; cageProp
				(tempKey init: hide:)
			)
			(1
				(keyPadView startUpd: hide:)
				(d0 startUpd: hide:)
				(d1 startUpd: hide:)
				(d2 startUpd: hide:)
				(d3 startUpd: hide:)
				(tempKey startUpd: hide:)
				(= ticks 6)
			)
			(2
				(d0 dispose: delete:)
				(d1 dispose: delete:)
				(d2 dispose: delete:)
				(d3 dispose: delete:)
				(gEgo startUpd:)
				((ScriptID 400 3) startUpd:) ; seaGull
				(if (not (IsFlag 69))
					((ScriptID 400 7) startUpd:) ; cageProp
				)
				(tempKey dispose: delete:)
				(if (keyPadView script:)
					((keyPadView script:) dispose:)
				)
				(keyPadView dispose: delete:)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(= cycles 3)
			)
			(3
				(self dispose: &rest)
				(DisposeScript 65)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gSoundEffects number: 913 loop: 1 play:)
				(tempKey show: setLoop: 10 setCel: 1 posn: 151 93)
				(= cycles 2)
			)
			(1
				(tempKey hide:)
				(d0 setLoop: 12 cel: 1)
				(d1 setCel: 0)
				(d2 setCel: 0)
				(d3 setCel: 0)
				(led cel: (if (== local11 9731) 2 else 1) init:)
				(= register 5)
				(= cycles 1)
			)
			(2
				(gSoundEffects number: (+ 931 (!= local11 9731)) loop: 1 play:)
				(led show:)
				(= ticks 15)
			)
			(3
				(if (-- register)
					(-= state 2)
				)
				(led hide:)
				(= ticks 15)
			)
			(4
				(if (== local11 9731)
					(ClearFlag 14)
					(keyStuff cue:)
					(d0 setLoop: 0 cel: 0)
					(led dispose:)
					(self dispose:)
				else
					(EcoNarrator posn: -1 140 init: 3 0 0 85 self 400)
				)
			)
			(5
				(SetFlag 14)
				(= local11 0)
				(= local0 0)
				(HandsOn)
				(gTheIconBar disable: 5 0 3 4 5 6)
				(d0 setLoop: 0 cel: 0)
				(led dispose:)
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
				(HandsOff)
				(gSoundEffects number: 914 loop: 1 play:)
				(tempKey show: setLoop: 11 setCel: 1 posn: 160 93)
				(= cycles 2)
			)
			(1
				(tempKey hide:)
				(d0 setLoop: 12 cel: 0)
				(d1 setCel: 0)
				(d2 setCel: 0)
				(d3 setCel: 0)
				(= register 5)
				(= cycles 1)
			)
			(2
				(d0 hide:)
				(= cycles 2)
			)
			(3
				(if (-- register)
					(-= state 2)
				)
				(d0 show:)
				(= cycles 2)
			)
			(4
				(d0 setLoop: 0 cel: 0)
				(= local11 0)
				(= local0 0)
				(HandsOn)
				(gTheIconBar disable: 5 0 3 4 5 6)
				(self dispose:)
			)
		)
	)
)

