;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 141)
(include sci.sh)
(use Main)
(use Inset)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	useLock 0
)

(procedure (localproc_0 param1 param2)
	(param1 setCel: (mod (+ (param1 cel:) param2) 10))
	(dial
		posn:
			(+
				(combo x:)
				(switch param1
					(digit1 -22)
					(digit2 -7)
					(digit3 8)
				)
			)
			(- (combo y:) 12)
		setCycle: (if (== param2 -1) End else Beg)
	)
)

(procedure (localproc_1 param1 &tmp temp0)
	(= temp0 0)
	(if argc
		(= temp0 param1)
	)
	(gEgo
		loop: 0
		view:
			(switch global206
				(177 178)
				(0 630)
				(1 111)
				(2 631)
				(124 126)
				(125 127)
			)
		cel: 0
		setCycle: CT 3 1 temp0
	)
)

(procedure (localproc_2 param1 &tmp temp0)
	(= temp0 0)
	(if argc
		(= temp0 param1)
	)
	(gEgo
		loop: 0
		view:
			(switch global206
				(177 178)
				(0 630)
				(1 111)
				(2 631)
				(124 126)
				(125 127)
			)
		cel: (gEgo lastCel:)
		setCycle: Beg temp0
	)
)

(instance useLock of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 141)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (IsFlag 79))
					(SetFlag 79)
					(gMessager say: 34 4 0 0 self 14) ; "Just as you start to enter your combination, you realize with panic that you've completely forgotten your locker combination. Damn! This happens every time!"
				else
					(= cycles 2)
				)
			)
			(1
				(localproc_1 self)
			)
			(2
				(HandsOn)
				(User canControl: 1 canInput: 1)
				(gTheIconBar disable: 5 0 3 4 5)
				(gCurRoom setInset: combo self)
			)
			(3
				(HandsOff)
				(if
					(and
						(== (digit1 cel:) 2)
						(== (digit2 cel:) 6)
						(== (digit3 cel:) 9)
					)
					(= next useLocker)
					(gEgo setCycle: End self)
				else
					(= next 0)
					(gEgo setCycle: Beg self)
				)
			)
			(4
				(if (not next)
					(HandsOn)
					(NormalEgo -1 6)
					(self dispose:)
				else
					(super dispose:)
				)
			)
		)
	)
)

(instance useLocker of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 141)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetScore 96 1)
				(= cycles 3)
			)
			(1
				(gLongSong2 number: 957 loop: 1 play: self)
			)
			(2
				((ScriptID 14 1) setCycle: End self) ; sonnyLocker
			)
			(3
				(gLongSong number: 146 loop: -1 setVol: 64 play:)
				(HandsOn)
				(User canControl: 1 canInput: 1)
				(gTheIconBar disable: 5 0 3 4)
				(gCurRoom setInset: locker self)
			)
			(4
				(HandsOff)
				(localproc_2 self)
				((ScriptID 14 1) setCycle: Beg self) ; sonnyLocker
			)
			(5)
			(6
				(gLongSong2 number: 958 loop: 1 play: self)
			)
			(7
				(gLongSong number: 146 loop: -1 setVol: 64 play:)
				(NormalEgo -1 6)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (>= global211 90)
					(gMessager say: 50 4 26 0 self) ; "You're undercover now. Taking that with you might blow your cover."
				else
					(switch register
						(stick
							(ClearFlag 38)
							(SetScore 98 1)
							(gEgo get: 6) ; Night_Stick
						)
						(keys
							(ClearFlag 10)
							(SetScore 104 1)
							(gEgo get: 10) ; Camaro_Keys
						)
						(noteBook
							(ClearFlag 11)
							(gEgo get: 5) ; Ticket_Book
							(SetScore 102 1)
							(gEgo get: 1) ; Pen
						)
					)
					(register startUpd: hide:)
					(= cycles 3)
				)
			)
			(1
				(if (< global211 90)
					(register dispose:)
				)
				(HandsOn)
				(gTheIconBar disable: 5 0 3 4)
				(self dispose:)
			)
		)
	)
)

(instance openLockerHandle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lockerHandle setCel: 1)
				(= seconds 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance lockerHandle of Prop
	(properties
		x 181
		y 57
		noun 58
		view 116
		loop 3
		priority 15
		signal 16400
	)

	(method (cue)
		(combo dispose:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if
				(and
					(gCurRoom inset:)
					(== (digit1 cel:) 2)
					(== (digit2 cel:) 6)
					(== (digit3 cel:) 9)
				)
				(combo setScript: openLockerHandle self)
			else
				(gMessager say: 50 4 27 0) ; "That must be the wrong combination. Now what WAS that Grunters-Sows score again? Better check your copy of the Gazette."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance combo of Inset
	(properties
		view 116
		x 212
		y 52
		disposeNotOnMe 1
		noun 57
	)

	(method (init)
		(super init: &rest)
		(lockerHandle init:)
		(digit1 init:)
		(digit2 init:)
		(digit3 init:)
		(dial init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					(
						(InRect
							(- x 27)
							(- y 17)
							(- x 13)
							(- y 7)
							gMouseX
							gMouseY
						)
						(localproc_0 digit1 -1)
					)
					(
						(InRect
							(- x 27)
							(- y 6)
							(- x 13)
							(+ y 3)
							gMouseX
							gMouseY
						)
						(localproc_0 digit1 1)
					)
					(
						(InRect
							(- x 12)
							(- y 17)
							(+ x 2)
							(- y 7)
							gMouseX
							gMouseY
						)
						(localproc_0 digit2 -1)
					)
					(
						(InRect
							(- x 12)
							(- y 6)
							(+ x 2)
							(+ y 3)
							gMouseX
							gMouseY
						)
						(localproc_0 digit2 1)
					)
					(
						(InRect
							(+ x 3)
							(- y 17)
							(+ x 18)
							(- y 7)
							gMouseX
							gMouseY
						)
						(localproc_0 digit3 -1)
					)
					(
						(InRect
							(+ x 3)
							(- y 6)
							(+ x 18)
							(+ y 3)
							gMouseX
							gMouseY
						)
						(localproc_0 digit3 1)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dial of Prop
	(properties
		view 116
		loop 1
		priority 15
		signal 16400
	)

	(method (init)
		(self posn: (- (combo x:) 23) (- (combo y:) 12))
		(super init: &rest)
	)
)

(instance digit1 of Prop
	(properties
		view 116
		loop 2
		priority 15
		signal 16400
	)

	(method (init)
		(self posn: (- (combo x:) 15) (- (combo y:) 13))
		(super init: &rest)
	)
)

(instance digit2 of Prop
	(properties
		view 116
		loop 2
		priority 15
		signal 16400
	)

	(method (init)
		(self posn: (combo x:) (- (combo y:) 13))
		(super init: &rest)
	)
)

(instance digit3 of Prop
	(properties
		view 116
		loop 2
		priority 15
		signal 16400
	)

	(method (init)
		(self posn: (+ (combo x:) 15) (- (combo y:) 13))
		(super init: &rest)
	)
)

(instance locker of Inset
	(properties
		view 118
		loop 1
		x 160
		y 185
		priority 11
		disposeNotOnMe 1
	)

	(method (init)
		(super init: &rest)
		(if (!= global206 0)
			(uniform init:)
		)
		(if (or (== global206 125) (and (== global206 124) (== global211 90)))
			(disguise init:)
		)
		(if (not (OneOf global206 1 177))
			(clothes init:)
		)
		(if (!= global206 0)
			(gunBelt init:)
		)
		(if (not (gEgo has: 10)) ; Camaro_Keys
			(keys init:)
		)
		(if (not (gEgo has: 5)) ; Ticket_Book
			(noteBook init:)
		)
		(if (not (OneOf global206 124 125))
			(towel init:)
		)
		(if (not (gEgo has: 6)) ; Night_Stick
			(stick init:)
		)
	)

	(method (dispose)
		(if (== global206 1)
			(gEgo get: 0) ; Service_Revolver
			(gEgo get: 9) ; Handcuffs
		)
		(uniform dispose:)
		(disguise dispose:)
		(clothes dispose:)
		(gunBelt dispose:)
		(keys dispose:)
		(noteBook dispose:)
		(towel dispose:)
		(stick dispose:)
		(super dispose:)
	)
)

(instance uniform of View
	(properties
		x 168
		y 264
		z 100
		noun 48
		view 118
		cel 2
		priority 12
		signal 16400
	)

	(method (init)
		(super init:)
		(self posn: (+ (locker x:) 23) (+ (locker y:) 75))
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self stopUpd:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (IsFlag 14))
						(gMessager say: noun 4 10 0) ; "Regulations state you must take a shower before changing into your uniform."
					)
					((OneOf global211 0 38)
						(++ global211)
						(locker setScript: swapClothes 0 0)
					)
					((> global211 52)
						(gMessager say: noun 4 23 0) ; "You don't need to wear that uniform anymore. You're a Narc officer now."
					)
					(else
						(gMessager say: noun 4 12 0) ; "You don't need to wear your uniform now."
					)
				)
			)
			(1 ; Look
				(gMessager say: noun 1 0 0 0 14) ; "It's your trusty blue uniform and patrol belt."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance disguise of View
	(properties
		x 148
		y 249
		z 200
		noun 53
		view 118
		priority 14
		signal 16400
	)

	(method (init)
		(super init:)
		(self posn: (+ (locker x:) 3) (+ (locker y:) 160))
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self stopUpd:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((== global211 91)
						(locker setScript: swapClothes 0 2)
					)
					((== global211 90)
						(gMessager say: noun 4 24 0) ; "Bleach your hair first, so you don't end up ruining the - yecch! - leisure suit."
					)
				)
			)
			(1 ; Look
				(gMessager say: noun 1 0 0 0 14) ; "It's your horrid 'Whitey' disguise."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clothes of View
	(properties
		x 134
		y 257
		z 100
		noun 28
		view 118
		cel 1
		priority 15
		signal 16400
	)

	(method (init)
		(super init:)
		(self posn: (- (locker x:) 11) (+ (locker y:) 68))
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self stopUpd:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (OneOf global211 30 52)
					(locker setScript: swapClothes 0 1)
				else
					(gMessager say: noun 4 25 0) ; "All patrol officers MUST wear a regulation uniform when on duty. Wait till you're off duty to put on your street duds."
				)
			)
			(1 ; Look
				(gMessager say: noun 1 0 0 0 14) ; "These are your street clothes."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gunBelt of View
	(properties
		x 158
		y 169
		z 100
		noun 48
		view 118
		cel 3
		priority 12
		signal 16400
	)

	(method (init)
		(super init:)
		(self posn: (+ (locker x:) 13) (- (locker y:) 20))
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self stopUpd:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(uniform doVerb: 4)
			)
			(1 ; Look
				(gMessager say: noun 1 0 0 0 14) ; "It's your trusty blue uniform and patrol belt."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stick of View
	(properties
		x 138
		y 277
		z 200
		noun 56
		view 118
		cel 8
		priority 12
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== global206 0)
					(locker setScript: getIt 0 self)
				else
					(gMessager say: 50 0 26 0) ; "Only uniformed officers are allowed to carry that."
				)
			)
			(1 ; Look
				(gMessager say: noun 1 0 0 0 14) ; "This is your departmental issue PR-24 nightstick."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init:)
		(self posn: (- (locker x:) 1) (+ (locker y:) 158))
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self stopUpd:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance keys of View
	(properties
		x 166
		y 238
		z 200
		noun 27
		view 118
		cel 5
		priority 12
		signal 16400
	)

	(method (init)
		(super init:)
		(self posn: (+ (locker x:) 21) (+ (locker y:) 49))
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(locker setScript: getIt 0 self)
			)
			(1 ; Look
				(gMessager say: noun 1 0 0 0 14) ; "These are the keys to your Camaro."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance noteBook of View
	(properties
		x 150
		y 247
		z 200
		noun 37
		view 118
		cel 6
		priority 12
		signal 16400
	)

	(method (init)
		(super init:)
		(self posn: (+ (locker x:) 5) (+ (locker y:) 58))
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self stopUpd:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== global206 0)
					(locker setScript: getIt 0 self)
				else
					(gMessager say: 50 0 26 0) ; "Only uniformed officers are allowed to carry that."
				)
			)
			(1 ; Look
				(gMessager say: noun 1 0 0 0 14) ; "It's your ticket book and pen."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance towel of View
	(properties
		x 121
		y 233
		z 200
		noun 52
		view 118
		cel 7
		priority 15
		signal 16400
	)

	(method (init)
		(super init:)
		(self posn: (- (locker x:) 24) (+ (locker y:) 44))
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self stopUpd:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (OneOf global211 0 30 38 52 90)
					(locker setScript: swapClothes 0 124)
				else
					(gMessager say: noun 4 20 0) ; "You already took a shower. How clean do you want to get?"
				)
			)
			(1 ; Look
				(gMessager say: noun 1 0 0 0 14) ; "It's your towel. You may want to think about taking it home and washing it someday."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance swapClothes of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 103 2)
				(switch register
					(124
						(towel dispose:)
						(ClearFlag 12)
						(= temp0 52)
					)
					(125
						(towel dispose:)
						(ClearFlag 12)
						(= temp0 52)
					)
					(0
						(= temp0 48)
						(SetScore 97 1)
						(ClearFlag 5)
						(ClearFlag 8)
						(if (OneOf global211 0 38)
							(++ global211)
						)
						(gEgo get: 0) ; Service_Revolver
						(gEgo get: 9) ; Handcuffs
						(uniform dispose:)
						(gunBelt dispose:)
					)
					(2
						(if (OneOf global211 90)
							(++ global211)
						)
						(= temp0 53)
						(for ((= temp1 0)) (<= temp1 19) ((++ temp1))
							(gEgo put: temp1)
						)
						(keys init:)
						(noteBook init:)
						(stick init:)
						(gEgo get: 7) ; Undercover_money
						(gEgo get: 11) ; Undercover_Car_Keys
						(ClearFlag 6)
						(= temp0 53)
						(disguise dispose:)
					)
					(1
						(if (== global211 30)
							(++ global211)
						)
						(if (== global211 52)
							(gEgo get: 0) ; Service_Revolver
							(gEgo get: 9) ; Handcuffs
						)
						(= temp0 28)
						(ClearFlag 7)
						(clothes dispose:)
					)
				)
				(gMessager say: temp0 4 8 0 self)
			)
			(1
				(switch global206
					(0
						(gEgo put: 0) ; Service_Revolver
						(gEgo put: 9) ; Handcuffs
						(gEgo put: 6) ; Night_Stick
						(gEgo put: 5) ; Ticket_Book
						(gEgo put: 10) ; Camaro_Keys
						(gEgo put: 1) ; Pen
						(keys init:)
						(noteBook init:)
						(stick init:)
						(uniform init:)
						(gunBelt init:)
						(SetFlag 5)
						(SetFlag 8)
						(= temp0 48)
						(gEgo view: 630)
					)
					(1
						(clothes init:)
						(SetFlag 7)
						(= temp0 28)
						(gEgo view: 111)
					)
					(2
						(= temp0 53)
						(disguise init:)
						(SetFlag 6)
						(gEgo view: 631)
					)
					(124
						(= temp0 52)
						(towel init:)
						(SetFlag 12)
						(gEgo view: 126)
					)
					(125
						(= temp0 52)
						(towel init:)
						(SetFlag 12)
						(gEgo view: 127)
					)
					(177
						(disguise init:)
						(gEgo view: 111)
						(= temp0 53)
					)
				)
				(gMessager say: temp0 4 9 0 self)
				(= global206 register)
				(gEgo view: register loop: 8 cel: 6)
				(((gTheIconBar at: 0) cursor:) init:)
			)
			(2
				(gGame setCursor: 609 1)
				(HandsOn)
				(gTheIconBar disable: 5 0 3 4)
				(self dispose:)
			)
		)
	)
)

