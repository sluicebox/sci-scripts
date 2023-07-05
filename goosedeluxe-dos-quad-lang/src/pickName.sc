;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 116)
(include sci.sh)
(use Main)
(use Plane)
(use Str)
(use Print)
(use Talker)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	pickName 0
)

(local
	local0
	local1
)

(instance pickName of Room
	(properties
		picture 803
	)

	(method (init)
		(= gEgoName (Str new: 200))
		(gKeyDownHandler addToFront: self)
		(super init: &rest)
		(if (> gLanguage 0)
			(gCurRoom picture: (+ (* 1000 gLanguage) 803))
			(gCurRoom drawPic: (+ (* 1000 gLanguage) 803))
		)
		(= global516 gNarrator)
		(= gNarrator pickNameNarrator)
		(= global511 introButtonBar)
		(global511 init:)
		(global511
			add:
				hilia
				hilib
				hilic
				hilid
				hilie
				hilif
				hilig
				hilih
				hilii
				hilij
				hilik
				hilil
				hilim
				hilin
				hilio
				hilip
				hiliq
				hilir
				hilis
				hilit
				hiliu
				hiliv
				hiliw
				hilix
				hiliy
				hiliz
				startbut
				leftbut
				rightbut
				cancel
		)
		(if (== gLanguage 1)
			(global511 add: hiliFo1 hiliFo2 hiliFo3)
		)
		(if (== gLanguage 3)
			(global511 add: hiliFo4 hiliFo5 hiliFo6)
		)
		(global511 eachElementDo: #init)
		(Sparkle init:)
		(self setScript: sIntro)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		((global511 plane:) dispose:)
		(global511 dispose:)
		(= global511 0)
		(= gNarrator global516)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(switch (event type:)
			(evKEYBOARD
				(cond
					(
						(OneOf
							(event message:)
							KEY_A
							KEY_a
							KEY_B
							KEY_b
							KEY_C
							KEY_c
							KEY_D
							KEY_d
							KEY_E
							KEY_e
							KEY_F
							KEY_f
							KEY_G
							KEY_g
							KEY_H
							KEY_h
							KEY_I
							KEY_i
							KEY_J
							KEY_j
							KEY_K
							KEY_k
							KEY_L
							KEY_l
							KEY_M
							KEY_m
							KEY_N
							KEY_n
							KEY_O
							KEY_o
							KEY_P
							KEY_p
							KEY_Q
							KEY_q
							KEY_R
							KEY_r
							KEY_S
							KEY_s
							KEY_T
							KEY_t
							KEY_U
							KEY_u
							KEY_V
							KEY_v
							KEY_W
							KEY_w
							KEY_X
							KEY_x
							KEY_Y
							KEY_y
							KEY_Z
							KEY_z
						)
						(= temp0 (Str format: {%c} (event message:)))
						(temp0 upper:)
						(= temp1 (temp0 at: 0))
						(showLetter doit: (- temp1 64))
						(temp0 dispose:)
						(event claimed: 1)
					)
					((OneOf (event message:) $ffc4 $ffe4)
						(showLetter doit: 27)
						(event claimed: 1)
					)
					((OneOf (event message:) $ffd6 $fff6)
						(showLetter doit: 28)
						(event claimed: 1)
					)
					((OneOf (event message:) $ffdc $fffc)
						(showLetter doit: 28)
						(event claimed: 1)
					)
					((== (event message:) JOY_UPLEFT)
						(gSfx number: 807 play:)
						(removeLetter doit:)
						(event claimed: 1)
					)
					((== (event message:) KEY_SPACE)
						(if local0
							(gSfx number: 808 play:)
							(showLetter doit: 0)
						)
						(event claimed: 1)
					)
					((== (event message:) KEY_RETURN)
						(if local0
							((gCurRoom script:) cue:)
						)
						(event claimed: 1)
					)
					((== (event message:) KEY_ESCAPE)
						(gSfx stop:)
						(event claimed: 1)
						(gCurRoom newRoom: 90) ; intro
					)
				)
			)
			(else
				(event claimed: 1)
			)
		)
	)
)

(instance sIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: 10 1)
				(gGame handsOn:)
				(gUser canControl: 0)
				(self cue:)
			)
			(1
				(gSfx number: (+ (* gLanguage 1000) 501) play:)
			)
			(2
				(if (checkForCuss doit:)
					(= cycles 1)
				else
					(self init:)
				)
			)
			(3
				(gGame handsOff:)
				(= seconds 1)
			)
			(4
				(gCurRoom newRoom: 104) ; night
			)
		)
	)
)

(instance introButtonBar of MgButtonBar
	(properties)

	(method (checkCursor param1 &tmp temp0)
		(if (!= (param1 plane:) plane)
			(param1 localize: plane)
		)
		(cond
			((= temp0 (self firstTrue: #onMe param1))
				(if (!= gTheCursor 10)
					(gGame setCursor: 10)
				)
			)
			((!= gTheCursor 6)
				(gGame setCursor: 6)
				(= saveCursor 0)
			)
		)
	)

	(method (init)
		(if (not plane)
			(= plane (Plane new:))
		)
		(plane back: 0 priority: 1 init: 0 0 640 480 addCast: self)
		(plane setSize:)
	)

	(method (dispose)
		(if saveCursor
			(gGame setCursor: saveCursor 1)
			(= saveCursor 0)
		)
		(super dispose: &rest)
	)
)

(instance startbut of MGIconItem
	(properties
		x 144
		y 2
		mainLoop 6
		maskView 803
		maskLoop 6
		maskCel 3
	)

	(method (init)
		(= view (+ 803 (* 1000 gLanguage)))
		(= mainView (+ 803 (* 1000 gLanguage)))
		(= maskView (+ 803 (* 1000 gLanguage)))
		(if (> gLanguage 0)
			(= maskLoop (= mainLoop (= loop 2)))
			(switch gLanguage
				(2
					(= z 3)
				)
				(1
					(= y (= x 0))
				)
				(3
					(= y (= x 0))
				)
			)
		)
		(self setPri: 10 1)
		(super init: &rest)
	)

	(method (select)
		(if (and (super select: 1) local0)
			((gCurRoom script:) cue:)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (== (event type:) evMOUSEBUTTON) (not (& signal $0004)))
				(gSfx number: 805 play:)
				(self select:)
			)
		)
	)
)

(instance leftbut of MGIconItem
	(properties
		x 60
		y 45
		mainView 803
		mainLoop 7
	)

	(method (init)
		(switch gLanguage
			(2
				(= y 41)
			)
		)
		(super init: &rest)
	)

	(method (select)
		(if (super select: 1)
			(removeLetter doit:)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (self onMe: event)
			(event claimed: 1)
			(if (== (event type:) evMOUSEBUTTON)
				(gSfx number: 807 play:)
				(self select:)
			)
		)
	)
)

(instance removeLetter of Code
	(properties)

	(method (doit param1)
		(if (and argc param1)
			(while local0
				(switch local0
					(1
						(letter1 dispose:)
						(Sparkle dec:)
						(-- local0)
					)
					(2
						(letter2 dispose:)
						(Sparkle dec:)
						(-- local0)
					)
					(3
						(letter3 dispose:)
						(Sparkle dec:)
						(-- local0)
					)
					(4
						(letter4 dispose:)
						(Sparkle dec:)
						(-- local0)
					)
					(5
						(letter5 dispose:)
						(Sparkle dec:)
						(-- local0)
					)
					(6
						(letter6 dispose:)
						(Sparkle dec:)
						(-- local0)
					)
					(7
						(letter7 dispose:)
						(Sparkle dec:)
						(-- local0)
					)
					(8
						(letter8 dispose:)
						(Sparkle dec:)
						(-- local0)
					)
					(else
						(return)
					)
				)
				(gEgoName at: local0 0)
			)
		else
			(switch local0
				(1
					(letter1 dispose:)
					(Sparkle dec:)
					(-- local0)
				)
				(2
					(letter2 dispose:)
					(Sparkle dec:)
					(-- local0)
				)
				(3
					(letter3 dispose:)
					(Sparkle dec:)
					(-- local0)
				)
				(4
					(letter4 dispose:)
					(Sparkle dec:)
					(-- local0)
				)
				(5
					(letter5 dispose:)
					(Sparkle dec:)
					(-- local0)
				)
				(6
					(letter6 dispose:)
					(Sparkle dec:)
					(-- local0)
				)
				(7
					(letter7 dispose:)
					(Sparkle dec:)
					(-- local0)
				)
				(8
					(letter8 dispose:)
					(Sparkle dec:)
					(-- local0)
				)
				(else
					(return)
				)
			)
		)
		(gEgoName at: local0 0)
	)
)

(instance cancel of MGIconItem
	(properties
		x 163
		y 180
		mainView 803
		mainLoop 5
	)

	(method (init)
		(if (> gLanguage 0)
			(+= view (* 1000 gLanguage))
			(+= mainView (* 1000 gLanguage))
			(= mainLoop (= loop 1))
			(switch gLanguage
				(2
					(= x 161)
					(= y 176)
				)
				(3
					(= y (= x 0))
				)
				(1
					(= y (= x 0))
				)
			)
			(self setPri: 100 1)
		)
		(super init: &rest)
	)

	(method (select)
		(if (super select: 1)
			(gCurRoom setScript: outScript)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (self onMe: event)
			(event claimed: 1)
			(if (== (event type:) evMOUSEBUTTON)
				(gSfx number: 806 play:)
				(self select:)
			)
		)
	)
)

(instance rightbut of MGIconItem
	(properties
		x 240
		y 45
		mainView 803
		mainLoop 8
	)

	(method (init)
		(switch gLanguage
			(2
				(= y 41)
			)
		)
		(super init: &rest)
	)

	(method (select)
		(if (and (super select: 1) local0)
			(showLetter doit: 0)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (self onMe: event)
			(event claimed: 1)
			(if (== (event type:) evMOUSEBUTTON)
				(gSfx number: 808 play:)
				(self select:)
			)
		)
	)
)

(instance showLetter of Code
	(properties)

	(method (doit param1)
		(switch local0
			(0
				(letter1 cel: param1 init:)
				(Sparkle inc:)
				(++ local0)
			)
			(1
				(letter2 cel: param1 init:)
				(Sparkle inc:)
				(++ local0)
			)
			(2
				(letter3 cel: param1 init:)
				(Sparkle inc:)
				(++ local0)
			)
			(3
				(letter4 cel: param1 init:)
				(Sparkle inc:)
				(++ local0)
			)
			(4
				(letter5 cel: param1 init:)
				(Sparkle inc:)
				(++ local0)
			)
			(5
				(letter6 cel: param1 init:)
				(Sparkle inc:)
				(++ local0)
			)
			(6
				(letter7 cel: param1 init:)
				(Sparkle inc:)
				(++ local0)
			)
			(7
				(letter8 cel: param1 init:)
				(Sparkle inc:)
				(++ local0)
			)
			(else
				(return)
			)
		)
		(if (!= param1 0)
			(gSfx number: (+ (Random 0 2) 608) play:)
		)
		(if (== param1 0)
			(= param1 -32)
		)
		(if (and (== gLanguage 3) (>= param1 27))
			(+= param1 3)
		)
		(gEgoName at: (- local0 1) (+ param1 64))
	)
)

(class Letter of MGIconItem
	(properties
		val 0
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (self onMe: event)
			(event claimed: 1)
			(if (== (event type:) evMOUSEBUTTON)
				(self select:)
			)
		)
	)

	(method (select)
		(if (super select: 1)
			(if (and (== gLanguage 1) (or (== val 27) (== val 28)))
				(if (== val 27)
					(showLetter doit: 3)
					(showLetter doit: 8)
				)
				(if (== val 28)
					(showLetter doit: 12)
					(showLetter doit: 12)
				)
			else
				(showLetter doit: val)
			)
		)
	)

	(method (init)
		(if (> gLanguage 0)
			(self view: (+ 803 (* 1000 gLanguage)))
			(= mainView (+ 803 (* 1000 gLanguage)))
			(= loop (+ 2 val))
			(= mainLoop (+ 2 val))
			(switch gLanguage
				(2
					(if
						(or
							(<= 89 y 90)
							(<= 113 y 114)
							(<= 137 y 138)
							(<= 163 y 164)
						)
						(-= y 4)
					)
				)
				(1
					(= y (= x 0))
				)
				(3
					(= x 0)
					(= y 200)
				)
			)
		)
		(super init: &rest)
	)
)

(instance hilia of Letter
	(properties
		x 35
		y 89
		mainView 803
		mainLoop 9
		val 1
	)
)

(instance hilib of Letter
	(properties
		x 77
		y 89
		mainView 803
		mainLoop 10
		val 2
	)
)

(instance hilic of Letter
	(properties
		x 118
		y 90
		mainView 803
		mainLoop 11
		val 3
	)
)

(instance hilid of Letter
	(properties
		x 159
		y 89
		mainView 803
		mainLoop 12
		val 4
	)
)

(instance hilie of Letter
	(properties
		x 198
		y 89
		mainView 803
		mainLoop 13
		val 5
	)
)

(instance hilif of Letter
	(properties
		x 239
		y 89
		mainView 803
		mainLoop 14
		val 6
	)
)

(instance hilig of Letter
	(properties
		x 280
		y 89
		mainView 803
		mainLoop 15
		val 7
	)
)

(instance hilih of Letter
	(properties
		x 54
		y 113
		mainView 803
		mainLoop 16
		val 8
	)
)

(instance hilii of Letter
	(properties
		x 96
		y 113
		mainView 803
		mainLoop 17
		val 9
	)
)

(instance hilij of Letter
	(properties
		x 139
		y 113
		mainView 803
		mainLoop 18
		val 10
	)
)

(instance hilik of Letter
	(properties
		x 181
		y 113
		mainView 803
		mainLoop 19
		val 11
	)
)

(instance hilil of Letter
	(properties
		x 224
		y 113
		mainView 803
		mainLoop 20
		val 12
	)
)

(instance hilim of Letter
	(properties
		x 264
		y 114
		mainView 803
		mainLoop 21
		val 13
	)
)

(instance hilin of Letter
	(properties
		x 41
		y 137
		mainView 803
		mainLoop 22
		val 14
	)
)

(instance hilio of Letter
	(properties
		x 82
		y 137
		mainView 803
		mainLoop 23
		val 15
	)
)

(instance hilip of Letter
	(properties
		x 123
		y 137
		mainView 803
		mainLoop 24
		val 16
	)
)

(instance hiliq of Letter
	(properties
		x 163
		y 137
		mainView 803
		mainLoop 25
		val 17
	)
)

(instance hilir of Letter
	(properties
		x 204
		y 137
		mainView 803
		mainLoop 26
		val 18
	)
)

(instance hilis of Letter
	(properties
		x 244
		y 137
		mainView 803
		mainLoop 27
		val 19
	)
)

(instance hilit of Letter
	(properties
		x 285
		y 137
		mainView 803
		mainLoop 28
		val 20
	)
)

(instance hiliu of Letter
	(properties
		x 60
		y 163
		mainView 803
		mainLoop 29
		val 21
	)
)

(instance hiliv of Letter
	(properties
		x 102
		y 163
		mainView 803
		mainLoop 30
		val 22
	)
)

(instance hiliw of Letter
	(properties
		x 144
		y 163
		mainView 803
		mainLoop 31
		val 23
	)
)

(instance hilix of Letter
	(properties
		x 186
		y 163
		mainView 803
		mainLoop 32
		val 24
	)
)

(instance hiliy of Letter
	(properties
		x 228
		y 163
		mainView 803
		mainLoop 33
		val 25
	)
)

(instance hiliz of Letter
	(properties
		x 270
		y 163
		mainView 803
		mainLoop 34
		val 26
	)
)

(instance hiliFo1 of Letter
	(properties
		x 270
		y 163
		mainView 803
		mainLoop 35
		val 27
	)
)

(instance hiliFo2 of Letter
	(properties
		x 270
		y 163
		mainView 803
		mainLoop 36
		val 28
	)
)

(instance hiliFo3 of Letter
	(properties
		x 270
		y 163
		mainView 803
		mainLoop 37
		val 29
	)
)

(instance hiliFo4 of Letter
	(properties
		y 200
		mainView 803
		mainLoop 35
		val 27
	)
)

(instance hiliFo5 of Letter
	(properties
		y 200
		mainView 803
		mainLoop 36
		val 28
	)
)

(instance hiliFo6 of Letter
	(properties
		y 200
		mainView 803
		mainLoop 37
		val 29
	)
)

(instance letter1 of Actor
	(properties
		x 93
		y 63
		priority 63
		view 803
		cel 7
		cycleSpeed 15
	)

	(method (init)
		(switch gLanguage
			(2
				(self x: 99 y: 58)
			)
			(1
				(self x: 93 y: 71)
			)
		)
		(self view: (+ 803 (* 1000 gLanguage)))
		(super init: &rest)
	)
)

(instance letter2 of Actor
	(properties
		x 112
		y 63
		priority 63
		view 803
		cel 20
	)

	(method (init)
		(switch gLanguage
			(2
				(self x: 118 y: 58)
			)
			(1
				(self x: 112 y: 71)
			)
		)
		(self view: (+ 803 (* 1000 gLanguage)))
		(super init: &rest)
	)
)

(instance letter3 of Actor
	(properties
		x 131
		y 63
		priority 63
		view 803
		cycleSpeed 15
	)

	(method (init)
		(switch gLanguage
			(2
				(self x: 137 y: 58)
			)
			(1
				(self x: 131 y: 71)
			)
		)
		(self view: (+ 803 (* 1000 gLanguage)))
		(super init: &rest)
	)
)

(instance letter4 of Actor
	(properties
		x 150
		y 63
		priority 63
		view 803
		cel 12
	)

	(method (init)
		(switch gLanguage
			(2
				(self x: 156 y: 58)
			)
			(1
				(self x: 150 y: 71)
			)
		)
		(self view: (+ 803 (* 1000 gLanguage)))
		(super init: &rest)
	)
)

(instance letter5 of Actor
	(properties
		x 170
		y 63
		priority 63
		view 803
		cel 14
	)

	(method (init)
		(switch gLanguage
			(2
				(self x: 176 y: 58)
			)
			(1
				(self x: 170 y: 71)
			)
		)
		(self view: (+ 803 (* 1000 gLanguage)))
		(super init: &rest)
	)
)

(instance letter6 of Actor
	(properties
		x 190
		y 63
		priority 63
		view 803
	)

	(method (init)
		(switch gLanguage
			(2
				(self x: 196 y: 58)
			)
			(1
				(self x: 190 y: 71)
			)
		)
		(self view: (+ 803 (* 1000 gLanguage)))
		(super init: &rest)
	)
)

(instance letter7 of Actor
	(properties
		x 210
		y 63
		priority 63
		view 803
		cel 1
	)

	(method (init)
		(switch gLanguage
			(2
				(self x: 216 y: 58)
			)
			(1
				(self x: 210 y: 71)
			)
		)
		(self view: (+ 803 (* 1000 gLanguage)))
		(super init: &rest)
	)
)

(instance letter8 of Actor
	(properties
		x 229
		y 63
		priority 63
		view 803
		cel 25
	)

	(method (init)
		(switch gLanguage
			(2
				(self x: 235 y: 58)
			)
			(1
				(self x: 229 y: 71)
			)
		)
		(self view: (+ 803 (* 1000 gLanguage)))
		(super init: &rest)
	)
)

(instance checkForCuss of Code
	(properties)

	(method (doit)
		(if
			(or
				(not (KString 7 (gEgoName data:) {FART})) ; StrCmp
				(not (KString 7 (gEgoName data:) {PUD})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FUCK})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FUCKER})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FUCKFACE})) ; StrCmp
				(not (KString 7 (gEgoName data:) {BUTTFUCK})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FUCKO})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FUCKME})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FUCKYOU})) ; StrCmp
				(not (KString 7 (gEgoName data:) {ELFUCKO})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FAGET})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FAGFACE})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FAGBOY})) ; StrCmp
				(not (KString 7 (gEgoName data:) {LESBO})) ; StrCmp
				(not (KString 7 (gEgoName data:) {HORNYBOY})) ; StrCmp
				(not (KString 7 (gEgoName data:) {HORSHIT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {BULLSHIT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {COWSHIT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {DOGSHIT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {EATSHIT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {PRICK})) ; StrCmp
				(not (KString 7 (gEgoName data:) {PECKER})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FAG})) ; StrCmp
				(not (KString 7 (gEgoName data:) {BUTTHOLE})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FUCKHOLE})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SHITHOLE})) ; StrCmp
				(not (KString 7 (gEgoName data:) {BUTTKISS})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SHIT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SHITFACE})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SHITTER})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SHITERIE})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SHITTY})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FUCKBOY})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SHITBOY})) ; StrCmp
				(not (KString 7 (gEgoName data:) {DICKHEAD})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FELCHER})) ; StrCmp
				(not (KString 7 (gEgoName data:) {COCK})) ; StrCmp
				(not (KString 7 (gEgoName data:) {COCKSUCK})) ; StrCmp
				(not (KString 7 (gEgoName data:) {BLOWJOB})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SUCKME})) ; StrCmp
				(not (KString 7 (gEgoName data:) {EATME})) ; StrCmp
				(not (KString 7 (gEgoName data:) {BUTTHEAD})) ; StrCmp
				(not (KString 7 (gEgoName data:) {WHORE})) ; StrCmp
				(not (KString 7 (gEgoName data:) {DYKE})) ; StrCmp
				(not (KString 7 (gEgoName data:) {CUNT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {CUNTLICK})) ; StrCmp
				(not (KString 7 (gEgoName data:) {DICKLICK})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FAGGOT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FAGOT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FAGGET})) ; StrCmp
				(not (KString 7 (gEgoName data:) {BUTTHEAD})) ; StrCmp
				(not (KString 7 (gEgoName data:) {HORNY})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SEXY})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SEXPOT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {PISS})) ; StrCmp
				(not (KString 7 (gEgoName data:) {PISSER})) ; StrCmp
				(not (KString 7 (gEgoName data:) {BASTARD})) ; StrCmp
				(not (KString 7 (gEgoName data:) {DAMN})) ; StrCmp
				(not (KString 7 (gEgoName data:) {DAMMIT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {GODAMMIT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {DAMIT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {GODDAMIT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SATAN})) ; StrCmp
				(not (KString 7 (gEgoName data:) {BITCH})) ; StrCmp
				(not (KString 7 (gEgoName data:) {CUNTHAIR})) ; StrCmp
				(not (KString 7 (gEgoName data:) {DOUCHBAG})) ; StrCmp
				(not (KString 7 (gEgoName data:) {DOOSHBAG})) ; StrCmp
				(not (KString 7 (gEgoName data:) {DOUSHBAG})) ; StrCmp
				(not (KString 7 (gEgoName data:) {JACKOFF})) ; StrCmp
				(not (KString 7 (gEgoName data:) {BEATOFF})) ; StrCmp
				(not (KString 7 (gEgoName data:) {HOMO})) ; StrCmp
				(not (KString 7 (gEgoName data:) {DIPSHIT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {DUMBSHIT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {DUMBFUCK})) ; StrCmp
				(not (KString 7 (gEgoName data:) {BUTTHAIR})) ; StrCmp
				(not (KString 7 (gEgoName data:) {EATDICK})) ; StrCmp
				(not (KString 7 (gEgoName data:) {COCKFACE})) ; StrCmp
				(not (KString 7 (gEgoName data:) {CUMSHOT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {TITBOY})) ; StrCmp
				(not (KString 7 (gEgoName data:) {TITFUCK})) ; StrCmp
				(not (KString 7 (gEgoName data:) {BICH})) ; StrCmp
				(not (KString 7 (gEgoName data:) {HITLER})) ; StrCmp
				(not (KString 7 (gEgoName data:) {MUSOLINI})) ; StrCmp
				(not (KString 7 (gEgoName data:) {NAZIBOY})) ; StrCmp
				(not (KString 7 (gEgoName data:) {NAZI})) ; StrCmp
				(not (KString 7 (gEgoName data:) {NEONAZI})) ; StrCmp
				(not (KString 7 (gEgoName data:) {NIGGER})) ; StrCmp
				(not (KString 7 (gEgoName data:) {NIGER})) ; StrCmp
				(not (KString 7 (gEgoName data:) {KIKE})) ; StrCmp
				(not (KString 7 (gEgoName data:) {BEANER})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SPIC})) ; StrCmp
				(not (KString 7 (gEgoName data:) {WETBACK})) ; StrCmp
				(not (KString 7 (gEgoName data:) {COON})) ; StrCmp
				(not (KString 7 (gEgoName data:) {COONSKIN})) ; StrCmp
				(not (KString 7 (gEgoName data:) {JAP})) ; StrCmp
				(not (KString 7 (gEgoName data:) {CHINK})) ; StrCmp
				(not (KString 7 (gEgoName data:) {GOOK})) ; StrCmp
				(not (KString 7 (gEgoName data:) {HONKY})) ; StrCmp
				(not (KString 7 (gEgoName data:) {HONKEY})) ; StrCmp
				(not (KString 7 (gEgoName data:) {PUSSY})) ; StrCmp
				(not (KString 7 (gEgoName data:) {PUSY})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SNATCH})) ; StrCmp
				(not (KString 7 (gEgoName data:) {CRACK})) ; StrCmp
				(not (KString 7 (gEgoName data:) {CRAK})) ; StrCmp
				(not (KString 7 (gEgoName data:) {BOOBS})) ; StrCmp
				(not (KString 7 (gEgoName data:) {KNOCKERS})) ; StrCmp
				(not (KString 7 (gEgoName data:) {ASS})) ; StrCmp
				(not (KString 7 (gEgoName data:) {ASSWIPE})) ; StrCmp
				(not (KString 7 (gEgoName data:) {ASSHOLE})) ; StrCmp
				(not (KString 7 (gEgoName data:) {ARSE})) ; StrCmp
				(not (KString 7 (gEgoName data:) {BUNGHOLE})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SHAT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {PENIS})) ; StrCmp
				(not (KString 7 (gEgoName data:) {RAMROD})) ; StrCmp
				(not (KString 7 (gEgoName data:) {ANAL})) ; StrCmp
				(not (KString 7 (gEgoName data:) {ANUS})) ; StrCmp
				(not (KString 7 (gEgoName data:) {VAGINA})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FECES})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FECAL})) ; StrCmp
				(not (KString 7 (gEgoName data:) {POOP})) ; StrCmp
				(not (KString 7 (gEgoName data:) {CRAP})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SHITTER})) ; StrCmp
				(not (KString 7 (gEgoName data:) {CRAPPER})) ; StrCmp
				(not (KString 7 (gEgoName data:) {TESTES})) ; StrCmp
				(not (KString 7 (gEgoName data:) {HARDON})) ; StrCmp
				(not (KString 7 (gEgoName data:) {BONER})) ; StrCmp
				(not (KString 7 (gEgoName data:) {STIFFY})) ; StrCmp
				(not (KString 7 (gEgoName data:) {STIFY})) ; StrCmp
				(not (KString 7 (gEgoName data:) {BONNER})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FUCKED})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SCREWED})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SCREWING})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FUCKING})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SHITTING})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SHITING})) ; StrCmp
				(not (KString 7 (gEgoName data:) {JUGS})) ; StrCmp
				(not (KString 7 (gEgoName data:) {DICKFUCK})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FUCKHEAD})) ; StrCmp
				(not (KString 7 (gEgoName data:) {FUCKSHIT})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SHITFUCK})) ; StrCmp
				(not (KString 7 (gEgoName data:) {SHITHEAD})) ; StrCmp
				(not (KString 7 (gEgoName data:) {DICKSHIT})) ; StrCmp
			)
			(Prints {Please don't talk like that.})
			(removeLetter doit: 1)
			(return 0)
		else
			(return 1)
		)
	)
)

(class Sparkle of Prop
	(properties
		view 803
		loop 4
		itsPlace 1
	)

	(method (init)
		(self setScript: sSparkleLetter changeLoc:)
		(super init: &rest)
	)

	(method (inc)
		(++ itsPlace)
		(self changeLoc:)
	)

	(method (dec)
		(-- itsPlace)
		(self changeLoc:)
	)

	(method (changeLoc)
		(switch itsPlace
			(1
				(startButCode doit: 0)
				(switch gLanguage
					(2
						(self posn: 99 58)
					)
					(1
						(self posn: 93 64)
					)
					(else
						(self posn: 93 62)
					)
				)
			)
			(2
				(startButCode doit: 1)
				(switch gLanguage
					(2
						(self posn: 118 58)
					)
					(1
						(self posn: 112 64)
					)
					(else
						(self posn: 112 62)
					)
				)
			)
			(3
				(switch gLanguage
					(2
						(self posn: 137 58)
					)
					(1
						(self posn: 131 64)
					)
					(else
						(self posn: 131 62)
					)
				)
			)
			(4
				(switch gLanguage
					(2
						(self posn: 156 58)
					)
					(1
						(self posn: 150 64)
					)
					(else
						(self posn: 150 62)
					)
				)
			)
			(5
				(switch gLanguage
					(2
						(self posn: 176 58)
					)
					(1
						(self posn: 170 64)
					)
					(else
						(self posn: 170 62)
					)
				)
			)
			(6
				(switch gLanguage
					(2
						(self posn: 195 58)
					)
					(1
						(self posn: 189 64)
					)
					(else
						(self posn: 189 62)
					)
				)
			)
			(7
				(switch gLanguage
					(2
						(self posn: 216 58)
					)
					(1
						(self posn: 210 64)
					)
					(else
						(self posn: 210 62)
					)
				)
			)
			(8
				(switch gLanguage
					(2
						(self posn: 234 58)
					)
					(1
						(self posn: 228 64)
					)
					(else
						(self posn: 228 62)
					)
				)
				(self show:)
			)
			(else
				(self hide:)
			)
		)
	)
)

(instance sSparkleLetter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(client cel: 0 setCycle: End self)
			)
			(2
				(= seconds 2)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance pickNameNarrator of Narrator
	(properties
		modeless 2
	)
)

(instance startButCode of Code
	(properties)

	(method (doit param1)
		(switch param1
			(1
				(startbut signal: (& (startbut signal:) $fffb) show:)
			)
			(0
				(startbut signal: (| (startbut signal:) $0004) show:)
			)
		)
	)
)

(instance outScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(gCurRoom newRoom: 90) ; intro
			)
		)
	)
)

