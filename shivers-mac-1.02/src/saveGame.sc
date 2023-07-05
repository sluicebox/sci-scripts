;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 993)
(include sci.sh)
(use Main)
(use n951)
(use soundRoom)
(use Str)
(use Array)
(use Print)
(use File)
(use Game)
(use Actor)
(use System)

(public
	saveGame 0
)

(local
	local0
	local1
	local2
	local3
)

(instance saveSound of ShiversSound
	(properties)
)

(instance saveGame of Room
	(properties
		picture 993
	)

	(method (init &tmp temp0)
		(= local0 0)
		(= local2 0)
		(= local1 (IntArray new: 21))
		(= temp0 (Str new:))
		(= local2 (Save 5 {SHIVER} (temp0 data:) (local1 data:))) ; GetSaveFiles
		(temp0 dispose:)
		(gGame handsOn:)
		(gKeyDownHandler addToFront: self)
		(A init:)
		(B init:)
		(C init:)
		(D init:)
		(E init:)
		(F init:)
		(G init:)
		(H init:)
		(I init:)
		(J init:)
		(K init:)
		(L init:)
		(M init:)
		(N init:)
		(O init:)
		(P init:)
		(Q init:)
		(R init:)
		(S init:)
		(T init:)
		(U init:)
		(V init:)
		(W init:)
		(X init:)
		(Y init:)
		(Z init:)
		(backspaceBtn init:)
		(playBtn init:)
		(cancelBtn init:)
		(autosaveBtn init:)
		(playBtn hide:)
		(initName doit:)
		(= local3 0)
		(super init:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(switch (event type:)
			(evKEYBOARD
				(cond
					((OneOf (event message:) KEY_A KEY_a)
						(addLetter doit: 0)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_B KEY_b)
						(addLetter doit: 1)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_C KEY_c)
						(addLetter doit: 2)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_D KEY_d)
						(addLetter doit: 3)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_E KEY_e)
						(addLetter doit: 4)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_F KEY_f)
						(addLetter doit: 5)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_G KEY_g)
						(addLetter doit: 6)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_H KEY_h)
						(addLetter doit: 7)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_I KEY_i)
						(addLetter doit: 8)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_J KEY_j)
						(addLetter doit: 9)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_K KEY_k)
						(addLetter doit: 10)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_L KEY_l)
						(addLetter doit: 11)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_M KEY_m)
						(addLetter doit: 12)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_N KEY_n)
						(addLetter doit: 13)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_O KEY_o)
						(addLetter doit: 14)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_P KEY_p)
						(addLetter doit: 15)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_Q KEY_q)
						(addLetter doit: 16)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_R KEY_r)
						(addLetter doit: 17)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_S KEY_s)
						(addLetter doit: 18)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_T KEY_t)
						(addLetter doit: 19)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_U KEY_u)
						(addLetter doit: 20)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_V KEY_v)
						(addLetter doit: 21)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_W KEY_w)
						(addLetter doit: 22)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_X KEY_x)
						(addLetter doit: 23)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_Y KEY_y)
						(addLetter doit: 24)
						(event claimed: 1)
					)
					((OneOf (event message:) KEY_Z KEY_z)
						(addLetter doit: 25)
						(event claimed: 1)
					)
					((== (event message:) JOY_UPLEFT)
						(removeLetter doit:)
					)
					((and (== (event message:) KEY_RETURN) (> local0 0))
						(composeName doit:)
					)
				)
			)
		)
		(event claimed: 1)
		(super handleEvent: event &rest)
	)

	(method (dispose)
		(local1 dispose:)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)
)

(class Alphabet1 of Prop
	(properties
		view 993
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler add: self)
	)

	(method (handleEvent event &tmp [temp0 2])
		(event localize: gThePlane)
		(if
			(and
				(self onMe: event)
				(& (event type:) evMOUSEBUTTON)
				(gUser canControl:)
			)
			(gGame handsOff:)
			(event claimed: 1)
			(self setScript: sButton)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance A of Alphabet1
	(properties
		x 48
		y 56
	)
)

(instance B of Alphabet1
	(properties
		x 139
		y 73
		loop 1
	)
)

(instance C of Alphabet1
	(properties
		x 103
		y 73
		loop 2
	)
)

(instance D of Alphabet1
	(properties
		x 84
		y 56
		loop 3
	)
)

(instance E of Alphabet1
	(properties
		x 75
		y 39
		loop 4
	)
)

(instance F of Alphabet1
	(properties
		x 102
		y 56
		loop 5
	)
)

(instance G of Alphabet1
	(properties
		x 120
		y 56
		loop 6
	)
)

(instance H of Alphabet1
	(properties
		x 138
		y 56
		loop 7
	)
)

(instance I of Alphabet1
	(properties
		x 165
		y 39
		loop 8
	)
)

(instance J of Alphabet1
	(properties
		x 156
		y 56
		loop 9
	)
)

(instance K of Alphabet1
	(properties
		x 174
		y 56
		loop 10
	)
)

(instance L of Alphabet1
	(properties
		x 193
		y 56
		loop 11
	)
)

(instance M of Alphabet1
	(properties
		x 175
		y 73
		loop 12
	)
)

(instance N of Alphabet1
	(properties
		x 157
		y 73
		loop 13
	)
)

(instance O of Alphabet1
	(properties
		x 183
		y 39
		loop 14
	)
)

(instance P of Alphabet1
	(properties
		x 201
		y 39
		loop 15
	)
)

(instance Q of Alphabet1
	(properties
		x 39
		y 39
		loop 16
	)
)

(instance R of Alphabet1
	(properties
		x 93
		y 39
		loop 17
	)
)

(instance S of Alphabet1
	(properties
		x 66
		y 56
		loop 18
	)
)

(instance T of Alphabet1
	(properties
		x 111
		y 39
		loop 19
	)
)

(instance U of Alphabet1
	(properties
		x 147
		y 39
		loop 20
	)
)

(instance V of Alphabet1
	(properties
		x 121
		y 73
		loop 21
	)
)

(instance W of Alphabet1
	(properties
		x 57
		y 39
		loop 22
	)
)

(instance X of Alphabet1
	(properties
		x 85
		y 73
		loop 23
	)
)

(instance Y of Alphabet1
	(properties
		x 129
		y 39
		loop 24
	)
)

(instance Z of Alphabet1
	(properties
		x 67
		y 73
		loop 25
	)
)

(instance backspaceBtn of Alphabet1
	(properties
		x 105
		y 90
		loop 26
	)
)

(instance playBtn of Alphabet1
	(properties
		x 27
		y 116
		loop 27
	)
)

(instance cancelBtn of Alphabet1
	(properties
		x 105
		y 132
		loop 28
	)
)

(instance autosaveBtn of Alphabet1
	(properties
		x 142
		y 116
		loop 29
	)

	(method (init)
		(if (IsFlag 60)
			(self loop: 30)
		else
			(self loop: 29)
		)
		(super init: &rest)
	)
)

(instance letter1 of View
	(properties
		x 70
		y 32
		priority 240
		fixPriority 1
		view 993
		loop -65
		cel 2
	)

	(method (init)
		(super init: &rest)
	)
)

(instance letter2 of View
	(properties
		y 32
		priority 241
		fixPriority 1
		view 993
		loop -65
		cel 2
	)

	(method (init)
		(super init: &rest)
	)
)

(instance letter3 of View
	(properties
		y 32
		priority 242
		fixPriority 1
		view 993
		loop -65
		cel 2
	)

	(method (init)
		(super init: &rest)
	)
)

(instance letter4 of View
	(properties
		y 32
		priority 243
		fixPriority 1
		view 993
		loop -65
		cel 2
	)

	(method (init)
		(super init: &rest)
	)
)

(instance letter5 of View
	(properties
		y 32
		priority 244
		fixPriority 1
		view 993
		loop -65
		cel 2
	)

	(method (init)
		(super init: &rest)
	)
)

(instance letter6 of View
	(properties
		y 32
		priority 245
		fixPriority 1
		view 993
		loop -65
		cel 2
	)

	(method (init)
		(super init: &rest)
	)
)

(instance letter7 of View
	(properties
		y 32
		priority 246
		fixPriority 1
		view 993
		loop -65
		cel 2
	)

	(method (init)
		(super init: &rest)
	)
)

(instance letter8 of View
	(properties
		y 32
		priority 247
		fixPriority 1
		view 993
		loop -65
		cel 2
	)

	(method (init)
		(super init: &rest)
	)
)

(instance sButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 1)
				(UpdateScreenItem client)
				(switch (client loop:)
					(26
						(saveSound number: 15032 play: 90 self)
					)
					(27
						(saveSound number: 15038 play: 90 self)
					)
					(28
						(saveSound number: 15026 play: 90 self)
					)
					(29
						(saveSound number: 15026 play: 90 self)
					)
					(30
						(saveSound number: 15026 play: 90 self)
					)
					(else
						(saveSound number: 15032 play: 90 self)
					)
				)
			)
			(1
				(if (and (< local0 8) (< (client loop:) 26))
					(addLetter doit: (client loop:))
				)
				(if (and (> local0 0) (== (client loop:) 26))
					(removeLetter doit:)
				)
				(if (== (client loop:) 27)
					(composeName doit:)
				)
				(if (== (client loop:) 28)
					(gCurRoom newRoom: 990) ; shiversOptions
				)
				(if (or (== (client loop:) 29) (== (client loop:) 30))
					(if (IsFlag 60)
						(ClearFlag 60)
						(client loop: 29)
					else
						(SetFlag 60)
						(client loop: 30)
					)
				)
				(client cel: 0)
				(UpdateScreenItem client)
				(gGame handsOn:)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance addLetter of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (and (< local0 8) (< param1 27))
			(= local3 1)
			(switch local0
				(0
					(letter1 loop: param1 init:)
				)
				(1
					(letter2
						loop: param1
						x: (+ (CelWide 993 (letter1 loop:) 2) (letter1 x:))
						init:
					)
				)
				(2
					(letter3
						loop: param1
						x: (+ (CelWide 993 (letter2 loop:) 2) (letter2 x:))
						init:
					)
				)
				(3
					(letter4
						loop: param1
						x: (+ (CelWide 993 (letter3 loop:) 2) (letter3 x:))
						init:
					)
				)
				(4
					(letter5
						loop: param1
						x: (+ (CelWide 993 (letter4 loop:) 2) (letter4 x:))
						init:
					)
				)
				(5
					(letter6
						loop: param1
						x: (+ (CelWide 993 (letter5 loop:) 2) (letter5 x:))
						init:
					)
				)
				(6
					(letter7
						loop: param1
						x: (+ (CelWide 993 (letter6 loop:) 2) (letter6 x:))
						init:
					)
				)
				(7
					(letter8
						loop: param1
						x: (+ (CelWide 993 (letter7 loop:) 2) (letter7 x:))
						init:
					)
				)
			)
			(++ local0)
			(playBtn show:)
		)
	)
)

(instance removeLetter of Code
	(properties)

	(method (doit)
		(if (> local0 0)
			(= local3 1)
			(switch (- local0 1)
				(0
					(letter1 loop: -65 hide:)
				)
				(1
					(letter2 loop: -65 hide:)
				)
				(2
					(letter3 loop: -65 hide:)
				)
				(3
					(letter4 loop: -65 hide:)
				)
				(4
					(letter5 loop: -65 hide:)
				)
				(5
					(letter6 loop: -65 hide:)
				)
				(6
					(letter7 loop: -65 hide:)
				)
				(7
					(letter8 loop: -65 hide:)
				)
			)
			(if (== (-- local0) 0)
				(playBtn hide:)
			)
		)
	)
)

(instance composeName of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp5 0)
		(= temp0 (Str new: 9))
		(temp0 at: 0 (+ (letter1 loop:) 65))
		(temp0 at: 1 (+ (letter2 loop:) 65))
		(temp0 at: 2 (+ (letter3 loop:) 65))
		(temp0 at: 3 (+ (letter4 loop:) 65))
		(temp0 at: 4 (+ (letter5 loop:) 65))
		(temp0 at: 5 (+ (letter6 loop:) 65))
		(temp0 at: 6 (+ (letter7 loop:) 65))
		(temp0 at: 7 (+ (letter8 loop:) 65))
		(temp0 at: 8 0)
		(if (== local3 1)
			(= temp5 1)
			(for ((= temp4 0)) (< temp4 local2) ((++ temp4))
				(= temp1 (File new:))
				(= temp2 (Str new: 20))
				(= temp3 (Str format: {%s%d.SG} gCurSaveDir (local1 at: temp4)))
				(temp1 name: (temp3 data:))
				(temp1 open: 1 readString: temp2 20 close:)
				(temp2 strip:)
				(if (== (KString 7 (temp2 data:) (temp0 data:)) 0) ; StrCmp
					(gGame setCursor: gNormalCursor)
					(switch
						(Print
							addBitmap: 928 7 0
							addButtonBM: 928 4 0 0 {} 130 40
							addButtonBM: 928 5 0 1 {} 80 40
							init:
						)
						(0
							(temp1 dispose:)
							(temp3 dispose:)
							(temp2 dispose:)
							(temp0 dispose:)
							(gSound1 pause: 1)
							(gSound2 pause: 1)
							(gSound3 pause: 1)
							(gSound4 pause: 1)
							(gSound5 pause: 1)
							(gSound6 pause: 1)
							(return)
						)
						(1
							(= global539 (local1 at: temp4))
							(= temp5 2)
						)
					)
					(gSound1 pause: 1)
					(gSound2 pause: 1)
					(gSound3 pause: 1)
					(gSound4 pause: 1)
					(gSound5 pause: 1)
					(gSound6 pause: 1)
				)
				(temp1 dispose:)
				(temp3 dispose:)
				(temp2 dispose:)
			)
		)
		(if (== temp5 1)
			(if (> (+ local2 1) 20)
				(gGame setCursor: gNormalCursor)
				(switch
					(Print
						addBitmap: 928 0 0
						addButtonBM: 928 2 0 0 {} 105 40
						init:
					)
					(0
						(return)
					)
				)
				(gSound1 pause: 1)
				(gSound2 pause: 1)
				(gSound3 pause: 1)
				(gSound4 pause: 1)
				(gSound5 pause: 1)
				(gSound6 pause: 1)
			)
			(if (not (FileIO 17 2 (KString 9 gCurSaveDir))) ; CheckFreeSpace, StrGetData
				(gGame setCursor: gNormalCursor)
				(switch
					(Print
						addBitmap: 928 6 0
						addButtonBM: 928 2 0 0 {} 105 40
						init:
					)
					(0
						(return)
					)
				)
				(gSound1 pause: 1)
				(gSound2 pause: 1)
				(gSound3 pause: 1)
				(gSound4 pause: 1)
				(gSound5 pause: 1)
				(gSound6 pause: 1)
			)
			(for ((= temp6 0)) 1 ((++ temp6))
				(for ((= temp4 0)) (< temp4 local2) ((++ temp4))
					(breakif (== temp6 (local1 at: temp4)))
				)
				(if (== temp4 local2)
					(break)
				)
			)
			(= global539 temp6)
		)
		(global528 at: 0 (+ (letter1 loop:) 65))
		(global528 at: 1 (+ (letter2 loop:) 65))
		(global528 at: 2 (+ (letter3 loop:) 65))
		(global528 at: 3 (+ (letter4 loop:) 65))
		(global528 at: 4 (+ (letter5 loop:) 65))
		(global528 at: 5 (+ (letter6 loop:) 65))
		(global528 at: 6 (+ (letter7 loop:) 65))
		(global528 at: 7 (+ (letter8 loop:) 65))
		(global528 at: 8 0)
		(temp0 dispose:)
		(gSound1 pause: 0)
		(gSound2 pause: 0)
		(gSound3 pause: 0)
		(gSound4 pause: 0)
		(gSound5 pause: 0)
		(gSound6 pause: 0)
		(gGame handsOn:)
		(= global550 1)
		(gCurRoom newRoom: global343)
	)
)

(instance initName of Code
	(properties)

	(method (doit)
		(if (>= (global528 at: 0) 65)
			(addLetter doit: (- (global528 at: 0) 65))
		)
		(if (>= (global528 at: 1) 65)
			(addLetter doit: (- (global528 at: 1) 65))
		)
		(if (>= (global528 at: 2) 65)
			(addLetter doit: (- (global528 at: 2) 65))
		)
		(if (>= (global528 at: 3) 65)
			(addLetter doit: (- (global528 at: 3) 65))
		)
		(if (>= (global528 at: 4) 65)
			(addLetter doit: (- (global528 at: 4) 65))
		)
		(if (>= (global528 at: 5) 65)
			(addLetter doit: (- (global528 at: 5) 65))
		)
		(if (>= (global528 at: 6) 65)
			(addLetter doit: (- (global528 at: 6) 65))
		)
		(if (>= (global528 at: 7) 65)
			(addLetter doit: (- (global528 at: 7) 65))
		)
	)
)

